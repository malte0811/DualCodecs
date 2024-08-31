package malte0811.dualcodecs;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.squareup.javapoet.*;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

import static javax.lang.model.util.ElementFilter.methodsIn;
import static malte0811.dualcodecs.Helpers.nonnullParm;

public class StreamCodecGenerator {
    public static TypeSpec generateExtendedStreamCodec(int maxArguments) {
        var builder = TypeSpec.classBuilder("ExtendedStreamCodecs")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build())
                .addJavadoc(
                        "Provides composite stream codecs with up to $L members, instead of the limit of 6 members imposed by the vanilla implementation",
                        maxArguments
                );
        for (int i = 1; i <= maxArguments; ++i) {
            builder.addMethod(generateStreamCodec(i));
        }
        return builder.build();
    }

    private static MethodSpec generateStreamCodec(int argumentCount) {
        var typeArgs = CodecTypeParms.create(argumentCount);
        var parms = CompositeParms.create(typeArgs::superStreamCodec, typeArgs);

        var builder = MethodSpec.methodBuilder("composite")
                .addModifiers(Modifier.STATIC, Modifier.PUBLIC);
        typeArgs.forEach(true, builder::addTypeVariable);
        parms.forEach(builder::addParameter);
        builder.returns(typeArgs.streamCodec());
        builder.addStatement("return $L", generateAnonymousCodec(typeArgs, parms));
        return builder.build();
    }

    private static TypeSpec generateAnonymousCodec(CodecTypeParms typeArgs, CompositeParms parms) {
        return TypeSpec.anonymousClassBuilder("")
                .addSuperinterface(typeArgs.streamCodec())
                .addMethod(generateDecode(typeArgs, parms))
                .addMethod(generateEncode(typeArgs, parms))
                .build();
    }

    private static MethodSpec generateDecode(CodecTypeParms typeArgs, CompositeParms parms) {
        var buffer = nonnullParm(typeArgs.bufferType(), "buf");
        var builder = MethodSpec.methodBuilder("decode")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(buffer)
                .addAnnotation(Override.class)
                //.addAnnotation(NONNULL)
                .returns(typeArgs.resultType());
        List<String> decodedLocals = new ArrayList<>();
        for (var codec : parms.codecs()) {
            String varName = "arg" + codec.suffix();
            builder.addStatement("$T $L = $N.decode($N)", codec.type(), varName, codec.codec(), buffer);
            decodedLocals.add(varName);
        }
        builder.addStatement(
                "return $N.apply($L)",
                parms.builder(),
                String.join(", ", decodedLocals)
        );
        return builder.build();
    }

    private static MethodSpec generateEncode(CodecTypeParms typeArgs, CompositeParms parms) {
        var buffer = nonnullParm(typeArgs.bufferType(), "buf");
        var object = nonnullParm(typeArgs.resultType(), "object");
        var builder = MethodSpec.methodBuilder("encode")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(buffer)
                .addParameter(object)
                .addAnnotation(Override.class)
                .returns(void.class);
        for (var codec : parms.codecs()) {
            builder.addStatement("$N.encode($N, $N.apply($N))", codec.codec(), buffer, codec.getter(), object);
        }
        return builder.build();
    }
}
