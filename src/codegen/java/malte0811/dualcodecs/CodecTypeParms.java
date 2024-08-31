package malte0811.dualcodecs;

import com.mojang.serialization.MapCodec;
import com.squareup.javapoet.*;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;
import java.util.function.Consumer;

import static malte0811.dualcodecs.Helpers.generateTypeArgs;

public record CodecTypeParms(
        TypeVariableName bufferType, List<TypeVariableName> argumentTypes, TypeVariableName resultType
) {
    public static CodecTypeParms create(int numArgs) {
        return new CodecTypeParms(
                Helpers.bufferType("BUF"),
                generateTypeArgs(numArgs, "ARG"),
                TypeVariableName.get("RES")
        );
    }

    public void forEach(boolean includeBuffer, Consumer<TypeVariableName> action) {
        if (includeBuffer) {
            action.accept(bufferType);
        }
        argumentTypes.forEach(action);
        action.accept(resultType);
    }

    public TypeName streamCodec() {
        return ParameterizedTypeName.get(ClassName.get(StreamCodec.class), bufferType, resultType);
    }

    public TypeName dualMapCodec() {
        return ParameterizedTypeName.get(ClassName.get(DualMapCodec.class), bufferType, resultType);
    }

    public TypeName dualCodec() {
        return ParameterizedTypeName.get(ClassName.get(DualCodec.class), bufferType, resultType);
    }

    public TypeName superStreamCodec(TypeName ofType) {
        return ParameterizedTypeName.get(
                ClassName.get(StreamCodec.class), WildcardTypeName.supertypeOf(bufferType), ofType
        );
    }

    public TypeName superDualMapCodec(TypeName ofType) {
        return ParameterizedTypeName.get(
                ClassName.get(DualMapCodec.class), WildcardTypeName.supertypeOf(bufferType), ofType
        );
    }

    public TypeName mapCodec() {
        return ParameterizedTypeName.get(ClassName.get(MapCodec.class), resultType);
    }

    // TODO move elsewhere
    public static TypeName mapCodec(TypeName ofType) {
        return ParameterizedTypeName.get(ClassName.get(MapCodec.class), ofType);
    }
}
