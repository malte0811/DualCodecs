package malte0811.dualcodecs;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import net.minecraft.network.codec.StreamCodec;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class DualCompositeMapGenerator {
    public static TypeSpec generateDualCompositeCodecs(
            int maxArgs, TypeSpec extendedStreamCodecs, TypeSpec entryListCodecs
    ) {
        var builder = TypeSpec.classBuilder("DualCompositeMapCodecs")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build())
                .addSuperinterface(ParameterizedTypeName.get(StreamCodec.class, Integer.class, Integer.class))
                .addJavadoc(
                        "Methods to build \"composite\" map codecs with up to $L members. The method parameters are " +
                        "k pairs of a {@link DualMapCodec} (e.g. obtained by {@code codec.fieldOf(\"foo\")}) and a " +
                        "getter for corresponding member of the final object. The last parameter is a function to " +
                        "construct the object from the k members",
                        maxArgs
                );
        for (int i = 1; i <= maxArgs; ++i) {
            builder.addMethod(generateCompositeMap(i, extendedStreamCodecs, entryListCodecs));
        }
        return builder.build();
    }

    private static MethodSpec generateCompositeMap(int argCount, TypeSpec extendedStreamCodecs, TypeSpec entryListCodecs) {
        var typeArgs = CodecTypeParms.create(argCount);
        var parms = CompositeParms.create(typeArgs::superDualMapCodec, typeArgs);

        var builder = MethodSpec.methodBuilder("composite")
                .addModifiers(Modifier.STATIC, Modifier.PUBLIC);
        typeArgs.forEach(true, builder::addTypeVariable);
        parms.forEach(builder::addParameter);
        builder.returns(typeArgs.dualMapCodec());

        List<String> streamCodecArgs = new ArrayList<>();
        List<String> mapCodecArgs = new ArrayList<>();
        for (var entry : parms.codecs()) {
            streamCodecArgs.add(entry.codec().name + ".streamCodec()");
            streamCodecArgs.add(entry.getter().name);
            mapCodecArgs.add(
                    entry.codec().name + ".mapCodec()"
            );
            mapCodecArgs.add(entry.getter().name);
        }
        streamCodecArgs.add(parms.builder().name);
        mapCodecArgs.add(parms.builder().name);
        builder.addStatement(
                "$T streamCodec = $L.composite($L)",
                typeArgs.streamCodec(),
                extendedStreamCodecs.name,
                String.join(", ", streamCodecArgs)
        );
        builder.addStatement(
                "$T mapCodec = $L.composite($L)",
                typeArgs.mapCodec(),
                entryListCodecs.name,
                String.join(", ", mapCodecArgs)
        );
        builder.addStatement("return new $T(mapCodec, streamCodec)", typeArgs.dualMapCodec());

        return builder.build();
    }
}
