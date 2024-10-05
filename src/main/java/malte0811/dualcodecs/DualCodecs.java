package malte0811.dualcodecs;

import com.mojang.datafixers.util.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Provides "canonical" codecs for various objects
 */
public class DualCodecs
{
	public static final DualCodec<ByteBuf, Integer> INT = new DualCodec<>(Codec.INT, ByteBufCodecs.VAR_INT);
	public static final DualCodec<ByteBuf, Float> FLOAT = new DualCodec<>(Codec.FLOAT, ByteBufCodecs.FLOAT);
	public static final DualCodec<ByteBuf, String> STRING = new DualCodec<>(Codec.STRING, ByteBufCodecs.STRING_UTF8);
	public static final DualCodec<ByteBuf, Double> DOUBLE = new DualCodec<>(Codec.DOUBLE, ByteBufCodecs.DOUBLE);
	public static final DualCodec<ByteBuf, Boolean> BOOL = new DualCodec<>(Codec.BOOL, ByteBufCodecs.BOOL);
	public static final DualCodec<ByteBuf, Long> LONG = new DualCodec<>(Codec.LONG, ByteBufCodecs.VAR_LONG);
    public static final DualCodec<ByteBuf, Direction> DIRECTION = new DualCodec<>(Direction.CODEC, Direction.STREAM_CODEC);
	public static final DualCodec<ByteBuf, BlockPos> BLOCK_POS = new DualCodec<>(BlockPos.CODEC, BlockPos.STREAM_CODEC);
	public static final DualCodec<ByteBuf, ResourceLocation> RESOURCE_LOCATION = new DualCodec<>(
			ResourceLocation.CODEC, ResourceLocation.STREAM_CODEC
	);
	public static final DualCodec<RegistryFriendlyByteBuf, Component> CHAT_COMPONENT = new DualCodec<>(
			ComponentSerialization.CODEC, ComponentSerialization.STREAM_CODEC
	);
	public static final DualCodec<RegistryFriendlyByteBuf, PotionContents> POTION_CONTENTS = new DualCodec<>(
			PotionContents.CODEC, PotionContents.STREAM_CODEC
	);
	public static final DualCodec<RegistryFriendlyByteBuf, Ingredient> INGREDIENT = new DualCodec<>(
			Ingredient.CODEC, Ingredient.CONTENTS_STREAM_CODEC
	);
	public static final DualCodec<RegistryFriendlyByteBuf, ItemStack> ITEM_STACK = new DualCodec<>(
			ItemStack.OPTIONAL_CODEC, ItemStack.OPTIONAL_STREAM_CODEC
	);
	public static final DualCodec<RegistryFriendlyByteBuf, Recipe<?>> RECIPE = new DualCodec<>(
			Recipe.CODEC, Recipe.STREAM_CODEC
	);
	public static final DualCodec<ByteBuf, BlockState> BLOCK_STATE = new DualCodec<>(
			BlockState.CODEC,
			ByteBufCodecs.VAR_INT.map(Block.BLOCK_STATE_REGISTRY::byId, Block::getId)
	);

    /**
     * Creates a codec that will always return the same value. See also {@link Unit}
     */
	public static <T, S extends ByteBuf> DualCodec<S, T> unit(T value)
	{
		return new DualCodec<>(new CustomUnitCodec<>(value), StreamCodec.unit(value));
	}

	public static <T>
	DualCodec<ByteBuf, ResourceKey<T>> resourceKey(ResourceKey<? extends Registry<T>> registry)
	{
		return new DualCodec<>(ResourceKey.codec(registry), ResourceKey.streamCodec(registry));
	}

	public static <T>
	DualCodec<RegistryFriendlyByteBuf, T> registryEntry(Registry<T> registry)
	{

		return new DualCodec<>(
                registry.byNameCodec(),
                ByteBufCodecs.registry(registry.key())
        );
	}
}
