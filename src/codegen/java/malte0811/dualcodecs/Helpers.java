package malte0811.dualcodecs;

import com.mojang.datafixers.util.*;
import com.squareup.javapoet.*;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Helpers {
    //TODO
    // public static final Class<? extends Annotation> NONNULL = NotNull.class;

    public static Class<?> getFunctionType(int numArgs) {
        return switch (numArgs) {
            case 1 -> Function.class;
            case 2 -> BiFunction.class;
            case 3 -> Function3.class;
            case 4 -> Function4.class;
            case 5 -> Function5.class;
            case 6 -> Function6.class;
            case 7 -> Function7.class;
            case 8 -> Function8.class;
            case 9 -> Function9.class;
            case 10 -> Function10.class;
            case 11 -> Function11.class;
            case 12 -> Function12.class;
            case 13 -> Function13.class;
            case 14 -> Function14.class;
            case 15 -> Function15.class;
            case 16 -> Function16.class;
            default -> throw new IllegalStateException("Unexpected value: " + numArgs);
        };
    }

    public static TypeVariableName bufferType(String name) {
        return TypeVariableName.get(name, ByteBuf.class);
    }

    public static TypeName getFunction(List<? extends TypeName> arguments, TypeName result) {
        List<TypeName> allTypes = new ArrayList<>(arguments);
        allTypes.add(result);
        return ParameterizedTypeName.get(
                ClassName.get(getFunctionType(arguments.size())), allTypes.toArray(new TypeName[0])
        );
    }

    public static TypeName getFunction(TypeName argument, TypeName result) {
        return getFunction(List.of(argument), result);
    }

    public static List<TypeVariableName> generateTypeArgs(int count, String prefix) {
        List<TypeVariableName> result = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            result.add(TypeVariableName.get(prefix+(i+1)));
        }
        return result;
    }

    public static TypeName dmapCodec(TypeName buffer, TypeName type) {
        return ParameterizedTypeName.get(ClassName.get(DualMapCodec.class), buffer, type);
    }

    public static ParameterSpec nonnullParm(TypeName type, String name) {
        return ParameterSpec.builder(type, name)/*.addAnnotation(NONNULL)*/.build();
    }
}
