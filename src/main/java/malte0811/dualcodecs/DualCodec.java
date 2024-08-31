package malte0811.dualcodecs;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public record DualCodec<S extends ByteBuf, T>(Codec<T> codec, StreamCodec<S, T> streamCodec)
{
    /**
     * Creates a codec that is equal to this codec in its serialization format, but applies the given functions before
     * serialization/after deserialization to obtain a codec for type {@link T1}.
     */
	public <T1> DualCodec<S, T1> map(Function<T, T1> to, Function<T1, T> from)
	{
		return new DualCodec<>(codec.xmap(to, from), streamCodec.map(to, from));
	}

    /**
     * Creates a single-entry map codec with the given name.
     */
	public DualMapCodec<S, T> fieldOf(String name)
	{
		return new DualMapCodec<>(codec.fieldOf(name), streamCodec);
	}

    /**
     * "Escape hatch": If the generics for the stream type do not match, this can be used to move to a "stricter" stream
     * type.
     */
	public <S1 extends S>
	DualCodec<S1, T> castStream()
	{
		return new DualCodec<>(codec, streamCodec.cast());
	}

    /**
     * Creates "dispatch" codecs:<br>
     * During decoding, we first decode an object of type {@link T}. Based on that object, we choose the codec used to
     * decode the "main" object of type {@link V} using {@code getCodec}.<br>
     * During encoding, we determine the "type" of the object using {@code getKey}. We then encode this type/key using
     * this codec, and the object of type {@link V} using the codec provided by {@code getCodec}.
     */
	public <V> DualCodec<S, V> dispatch(
            Function<V, T> getKey, Function<T, DualMapCodec<? super S, ? extends V>> getCodec
    )
	{
		return new DualCodec<>(
				codec.dispatch(getKey, k -> getCodec.apply(k).mapCodec()),
				streamCodec.dispatch(getKey, k -> getCodec.apply(k).streamCodec())
		);
	}

    /**
     * @return Codecs for a set of {@link T}s, using this codec for the individual elements
     */
	public DualCodec<S, Set<T>> setOf()
	{
		return listOf().map(ImmutableSet::copyOf, ImmutableList::copyOf);
	}

    /**
     * @return Codecs for a list of {@link T}s, using this codec for the individual elements
     */
	public DualCodec<S, List<T>> listOf()
	{
		return new DualCodec<>(
				codec.listOf(),
				streamCodec.apply(ByteBufCodecs.list())
		);
	}

    /**
     * Creates a codec for a field that can be omitted from JSON/NBT data, with a fallback to use in that case
     */
	public DualMapCodec<S, T> optionalFieldOf(String name, T fallback)
	{
		return new DualMapCodec<>(codec.optionalFieldOf(name, fallback), streamCodec);
	}

    /**
     * Creates a codec for a field that can be completely absent, i.e. a field of type {@code Optional<T>}
     */
	public DualMapCodec<S, Optional<T>> optionalFieldOf(String name)
	{
		return new DualMapCodec<>(codec.optionalFieldOf(name), ByteBufCodecs.optional(streamCodec));
	}

    /**
     * Encodes the given object as NBT using {@link DualCodec#codec()}, throwing an exception if this fails
     */
	public Tag toNBT(T object)
	{
		return codec().encodeStart(NbtOps.INSTANCE, object).getOrThrow();
	}

    /**
     * Decodes an object from the given tag using {@link DualCodec#codec()}, throwing an exception if this fails
     */
    public T fromNBT(Tag nbt)
    {
        return codec().decode(NbtOps.INSTANCE, nbt).getOrThrow().getFirst();
    }

    /**
     * Encodes the given object as JSON using {@link DualCodec#codec()}, throwing an exception if this fails
     */
    public JsonElement toJSON(T object)
    {
        return codec().encodeStart(JsonOps.INSTANCE, object).getOrThrow();
    }

    /**
     * Decodes an object from the given JSON data using {@link DualCodec#codec()}, throwing an exception if this fails
     */
    public T fromJSON(JsonElement json)
    {
        return codec().decode(JsonOps.INSTANCE, json).getOrThrow().getFirst();
    }
}
