package malte0811.dualcodecs;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DualCodecTest {
    private static final String BAD_TYPE = "invalid-type";
    // TODO can we get MDG to load MC in tests in a non-Neo project?
    private static final DualCodec<ByteBuf, String> STRING_CODEC = new DualCodec<>(Codec.STRING, ByteBufCodecs.STRING_UTF8);

    @Test
    public void testDispatch() {

        record TestObject(String type, String data) {
            static DualMapCodec<ByteBuf, TestObject> codecForType(String type) {
                if (BAD_TYPE.equals(type)) {
                    return null;
                } else {
                    return STRING_CODEC.map(s -> new TestObject(type, s), TestObject::data).fieldOf("data");
                }
            }
        }
        DualCodec<ByteBuf, TestObject> codec = STRING_CODEC.dispatch(TestObject::type, TestObject::codecForType);
        // Standard encode/decode works
        var object1 = new TestObject("test-type", "some-data");
        var expectedJson1 = new JsonObject();
        expectedJson1.add("type", new JsonPrimitive("test-type"));
        expectedJson1.add("data", new JsonPrimitive("some-data"));
        var json1 = codec.toJSON(object1);
        assertEquals(json1, expectedJson1);
        var decoded1 = codec.fromJSON(json1);
        assertEquals(object1, decoded1);
        // Encoding broken data gives reasonable error
        var object2 = new TestObject(BAD_TYPE, "other-data");
        var result2 = codec.codec().encodeStart(JsonOps.INSTANCE, object2);
        assertTrue(result2.isError());
        // Decoding broken data gives reasonable error
        var badJson = new JsonObject();
        badJson.add("type", new JsonPrimitive(BAD_TYPE));
        badJson.add("data", new JsonPrimitive("some-data"));
        var badResult = codec.codec().decode(JsonOps.INSTANCE, badJson);
        assertTrue(badResult.isError());
        assertTrue(badResult.error().orElseThrow().message().contains(BAD_TYPE));
    }
}