package malte0811.dualcodecs;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import net.minecraft.network.codec.StreamCodec;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class DualCompositeGenerator {
    public static TypeSpec generateDualCompositeCodecs(
            int maxArgs, TypeSpec dualMapCodecs
    ) {
        var builder = TypeSpec.classBuilder("DualCompositeCodecs")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build())
                .addSuperinterface(ParameterizedTypeName.get(StreamCodec.class, Integer.class, Integer.class))
                .addJavadoc(
                        "Methods to build \"composite\" codecs with up to $L members. The method parameters are k " +
                        "pairs of a {@link DualMapCodec} (e.g. obtained by {@code codec.fieldOf(\"foo\")}) and a " +
                        "getter for corresponding member of the final object. The last parameter is a function to " +
                        "construct the object from the k members",
                        maxArgs
                );
        for (int i = 1; i <= maxArgs; ++i) {
            builder.addMethod(generateComposite(i, dualMapCodecs));
        }
        return builder.build();
    }

    private static MethodSpec generateComposite(int argCount, TypeSpec dualMapCodecs) {
        var typeArgs = CodecTypeParms.create(argCount);
        var parms = CompositeParms.create(typeArgs::superDualMapCodec, typeArgs);

        var builder = MethodSpec.methodBuilder("composite")
                .addModifiers(Modifier.STATIC, Modifier.PUBLIC);
        typeArgs.forEach(true, builder::addTypeVariable);
        parms.forEach(builder::addParameter);
        builder.returns(typeArgs.dualCodec());

        List<String> argNames = new ArrayList<>();
        parms.forEach(ps -> argNames.add(ps.name));
        List<String> typeNames = new ArrayList<>();
        typeArgs.forEach(true, type -> typeNames.add(type.name));

        builder.addStatement(
                "return $L.<$L>composite($L).codec()",
                dualMapCodecs.name,
                String.join(", ", typeNames),
                String.join(", ", argNames)
        );
        return builder.build();
    }
}
