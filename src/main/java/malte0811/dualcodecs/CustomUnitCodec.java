package malte0811.dualcodecs;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;

import java.util.function.Supplier;

// The main DFU unit codec breaks when presented with a non-map input. This can be a problem when parsing legacy data
// where this "unit" is presented by e.g. "true".
public record CustomUnitCodec<T>(T value) implements Codec<T> {
    @Override
    public <T1> DataResult<Pair<T, T1>> decode(DynamicOps<T1> ops, T1 input)
    {
        return DataResult.success(Pair.of(value, input));
    }

    @Override
    public <T1> DataResult<T1> encode(T input, DynamicOps<T1> ops, T1 prefix)
    {
        return ops.mapBuilder().build(prefix);
    }
}
