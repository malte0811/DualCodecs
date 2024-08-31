package malte0811.dualcodecs;

import com.mojang.serialization.MapCodec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;

import java.util.function.Function;

/**
 * "Dual" equivalent of a {@link MapCodec}
 */
public record DualMapCodec<S extends ByteBuf, T>(MapCodec<T> mapCodec, StreamCodec<S, T> streamCodec)
{
	public static <S extends ByteBuf, T> DualMapCodec<S, T> unit(T value)
	{
		return new DualMapCodec<>(MapCodec.unit(value), StreamCodec.unit(value));
	}

	public DualCodec<S, T> codec()
	{
		return new DualCodec<>(mapCodec.codec(), streamCodec);
	}

	public <T1> DualMapCodec<S, T1> map(Function<T, T1> to, Function<T1, T> from)
	{
		return new DualMapCodec<>(mapCodec.xmap(to, from), streamCodec.map(to, from));
	}
}
