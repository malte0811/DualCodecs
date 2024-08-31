package malte0811.dualcodecs;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class EntryListCodecGenerator {
    public static TypeSpec generateEntryListCodec(int maxArguments) {
        var builder = TypeSpec.classBuilder("EntryListCodecs")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build());
        for (int i = 1; i <= maxArguments; ++i) {
            builder.addMethod(generateCodec(i));
        }
        return builder.build();
    }

    private static MethodSpec generateCodec(int argumentCount) {
        var typeArgs = CodecTypeParms.create(argumentCount);
        var parms = CompositeParms.create(CodecTypeParms::mapCodec, typeArgs);

        var builder = MethodSpec.methodBuilder("composite")
                .addModifiers(Modifier.STATIC, Modifier.PUBLIC);
        typeArgs.forEach(false, builder::addTypeVariable);
        parms.forEach(builder::addParameter);
        builder.returns(typeArgs.mapCodec());

        TypeName wildcardEntry = ParameterizedTypeName.get(
                ClassName.get(EntryListCodec.CodecEntry.class),
                typeArgs.resultType(),
                WildcardTypeName.subtypeOf(Object.class)
        );
        String listName = "list";
        builder.addStatement(
                "$T $L = new $T($L)",
                ParameterizedTypeName.get(ClassName.get(List.class), wildcardEntry),
                listName,
                ParameterizedTypeName.get(ClassName.get(ArrayList.class), wildcardEntry),
                argumentCount
        );
        for (var entry : parms.codecs()) {
            var entryType = ParameterizedTypeName.get(
                    ClassName.get(EntryListCodec.CodecEntry.class),
                    typeArgs.resultType(),
                    entry.type()
            );
            builder.addStatement("$L.add(new $T($N, $N))", listName, entryType, entry.codec(), entry.getter());
        }
        builder.addStatement("return $L", generateAnonymousCodec(typeArgs, parms.builder(), listName));

        return builder.build();
    }

    private static TypeSpec generateAnonymousCodec(CodecTypeParms parmTypes, ParameterSpec make, String entryListName) {
        var list = ParameterSpec.builder(ParameterizedTypeName.get(List.class, Object.class), "parts").build();
        var makeBuilder = MethodSpec.methodBuilder("make")
                .addModifiers(Modifier.PROTECTED)
                .addParameter(list)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings.class).addMember("value", "\"unchecked\"").build())
                .returns(parmTypes.resultType());
        List<String> makeArgs = new ArrayList<>();
        for (int i = 0; i < parmTypes.argumentTypes().size(); ++i) {
            var name = "arg"+(i+1);
            var type = parmTypes.argumentTypes().get(i);
            makeArgs.add(name);
            makeBuilder.addStatement("$T $L = ($T) $N.get($L)", type, name, type, list, i);
        }
        makeBuilder.addStatement("return $N.apply($L)", make, String.join(", ", makeArgs));

        return TypeSpec.anonymousClassBuilder(entryListName)
                .superclass(ParameterizedTypeName.get(ClassName.get(EntryListCodec.class), parmTypes.resultType()))
                .addMethod(makeBuilder.build())
                .build();
    }
}
