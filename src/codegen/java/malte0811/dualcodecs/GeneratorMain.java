package malte0811.dualcodecs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static malte0811.dualcodecs.Helpers.*;

public class GeneratorMain {
    /*
	public static <S extends ByteBuf, T, E1, E2> DualMapCodec<S, T> composite(
			DualMapCodec<? super S, E1> field1, Function<T, E1> get1,
			DualMapCodec<? super S, E2> field2, Function<T, E2> get2,
			BiFunction<E1, E2, T> make
	)
	{
		return new DualMapCodec<>(
				EntryListCodecs.makeMapCodec(field1.mapCodec, get1, field2.mapCodec, get2, make),
				EntryListCodecs.makeStreamCodec(field1.streamCodec, get1, field2.streamCodec, get2, make)
		);
	}
     */

    private static MethodSpec generateCompositeMap(int numArgs) {
        var resultType = TypeVariableName.get("RES");
        var argumentTypes = generateTypeArgs(numArgs, "ARG");
        var bufferType = bufferType("BUF");
        var builder = MethodSpec.methodBuilder("composite")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addTypeVariable(resultType)
                .addTypeVariable(bufferType)
                .addTypeVariables(argumentTypes);
        builder.returns(dmapCodec(bufferType, resultType));
        List<ParameterSpec> codecParams = new ArrayList<>();
        List<ParameterSpec> getterParams = new ArrayList<>();
        for (int i = 0; i < argumentTypes.size(); ++i)
        {
            var codecParam = ParameterSpec.builder(
                    dmapCodec(WildcardTypeName.supertypeOf(bufferType), argumentTypes.get(i)), "codec"+(i+1)
            ).build();
            var getterParam = ParameterSpec.builder(
                    getFunction(resultType, argumentTypes.get(i)), "getter"+(i+1)
            ).build();
            codecParams.add(codecParam);
            getterParams.add(getterParam);
            builder.addParameter(codecParam).addParameter(getterParam);
        }
        var builderParam = ParameterSpec.builder(
                getFunction(argumentTypes, resultType), "create"
        ).build();
        builder.addParameter(builderParam);
        return builder.build();
    }

    private static void writeClass(TypeSpec spec) throws IOException {
        var file = JavaFile.builder("malte0811.dualcodecs", spec)
                .indent("    ")
                .build();
        file.writeTo(Path.of("src/generated/java"));
    }

    public static void main(String[] args) throws IOException {
        int maxArgs = 16;
        var extendedStreamCodec = StreamCodecGenerator.generateExtendedStreamCodec(maxArgs);
        writeClass(extendedStreamCodec);
        var entryListCodecs = EntryListCodecGenerator.generateEntryListCodec(maxArgs);
        writeClass(entryListCodecs);
        var dualMapCodecs = DualCompositeMapGenerator.generateDualCompositeCodecs(maxArgs, extendedStreamCodec, entryListCodecs);
        writeClass(dualMapCodecs);
        writeClass(DualCompositeGenerator.generateDualCompositeCodecs(maxArgs, dualMapCodecs));
    }
}
