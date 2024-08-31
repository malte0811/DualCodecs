package malte0811.dualcodecs;

import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static malte0811.dualcodecs.Helpers.getFunction;

public record CompositeParms(List<CodecAndGetter> codecs, ParameterSpec builder) {
    public static CompositeParms create(Function<TypeName, TypeName> makeCodec, CodecTypeParms parms) {
        List<CodecAndGetter> codecs = new ArrayList<>();
        for (int i = 0; i < parms.argumentTypes().size(); ++i) {
            var suffix = Integer.toString(i+1);
            var type = parms.argumentTypes().get(i);
            codecs.add(new CodecAndGetter(
                    suffix,
                    type,
                    ParameterSpec.builder(makeCodec.apply(type), "codec"+suffix).build(),
                    ParameterSpec.builder(getFunction(parms.resultType(), type), "getter"+suffix).build()
            ));
        }
        return new CompositeParms(
                codecs,
                ParameterSpec.builder(getFunction(parms.argumentTypes(), parms.resultType()), "builder").build()
        );
    }

    public void forEach(Consumer<ParameterSpec> action) {
        for (var getter : codecs) {
            action.accept(getter.codec);
            action.accept(getter.getter);
        }
        action.accept(builder);
    }

    public record CodecAndGetter(String suffix, TypeName type, ParameterSpec codec, ParameterSpec getter) {}
}
