package malte0811.dualcodecs;

import com.google.gson.JsonArray;
import com.mojang.datafixers.util.Unit;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.minecraft.nbt.NbtOps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomUnitCodecTest {
    @Test
    public void testUnit() {
        // All other codecs are built directly on the DFU equivalent codec. Ensure that this custom-implemented one
        // works correctly as well.
        var dfuCodec = Codec.unit(Unit.INSTANCE);
        var dfuNbt = dfuCodec.encodeStart(NbtOps.INSTANCE, Unit.INSTANCE);
        var myCodec = new CustomUnitCodec<>(Unit.INSTANCE);
        var myNbt = myCodec.encodeStart(NbtOps.INSTANCE, Unit.INSTANCE);
        Assertions.assertEquals(myNbt, dfuNbt);
        // Assert that the advantage of our implementation is actually working and is still relevant
        Assertions.assertTrue(myCodec.decode(JsonOps.INSTANCE, new JsonArray()).isSuccess());
        Assertions.assertFalse(dfuCodec.decode(JsonOps.INSTANCE, new JsonArray()).isSuccess());
    }
}