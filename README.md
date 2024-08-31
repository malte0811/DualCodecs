# Dual Codecs

In Minecraft 1.20.5, Mojang introduced `StreamCodec`s to handle network serialization in a structured manner. The API
closely follows that of DFU `Codec`s, and for many objects both types of codec have to be provided. In most cases both
codecs follow the same basic structure, essentially duplicating the codec-building code. This library provides a way to
handle both types of codec within a single `DualCodec` object, and the necessary helpers to directly construct most
codecs directly as `DualCodec`s:

```java
public class AlloyRecipeSerializer implements RecipeSerializer<AlloyRecipe>
{
    private static final DualMapCodec<RegistryFriendlyByteBuf, AlloyRecipe> CODECS = DualCompositeMapCodecs.composite(
        TagOutput.CODECS.listOf().fieldOf("results"), r -> r.output,
        IngredientWithSize.CODECS.fieldOf("input0"), r -> r.input0,
        IngredientWithSize.CODECS.fieldOf("input1"), r -> r.input1,
        DualCodecs.INT.optionalFieldOf("time", 200), r -> r.time,
        AlloyRecipe::new
    );

    @Override
    public MapCodec<AlloyRecipe> codec() { return CODECS.mapCodec(); }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, AlloyRecipe> streamCodec() { return CODECS.streamCodec(); }
}
```

In cases where the codecs differ significantly, and for objects where the codecs are provided by an external API, a
`DualCodec` can be constructed from the "standalone" codecs.
