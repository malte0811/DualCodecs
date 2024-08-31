package malte0811.dualcodecs;

import com.mojang.datafixers.util.Function10;
import com.mojang.datafixers.util.Function11;
import com.mojang.datafixers.util.Function12;
import com.mojang.datafixers.util.Function13;
import com.mojang.datafixers.util.Function14;
import com.mojang.datafixers.util.Function15;
import com.mojang.datafixers.util.Function16;
import com.mojang.datafixers.util.Function3;
import com.mojang.datafixers.util.Function4;
import com.mojang.datafixers.util.Function5;
import com.mojang.datafixers.util.Function6;
import com.mojang.datafixers.util.Function7;
import com.mojang.datafixers.util.Function8;
import com.mojang.datafixers.util.Function9;
import io.netty.buffer.ByteBuf;
import java.lang.Integer;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.network.codec.StreamCodec;

/**
 * Methods to build "composite" codecs with up to 16 members. The method parameters are k pairs of a {@link DualMapCodec} (e.g. obtained by {@code codec.fieldOf("foo")}) and a getter for corresponding member of the final object. The last parameter is a function to construct the object from the k members
 */
public abstract class DualCompositeCodecs implements StreamCodec<Integer, Integer> {
    private DualCompositeCodecs() {
    }

    public static <BUF extends ByteBuf, ARG1, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            Function<ARG1, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, RES>composite(codec1, getter1, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            BiFunction<ARG1, ARG2, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, RES>composite(codec1, getter1, codec2, getter2, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            Function3<ARG1, ARG2, ARG3, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            Function4<ARG1, ARG2, ARG3, ARG4, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            Function5<ARG1, ARG2, ARG3, ARG4, ARG5, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            Function6<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            Function7<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            Function8<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            Function9<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            Function10<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            DualMapCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            Function11<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            DualMapCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            DualMapCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            Function12<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, codec12, getter12, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            DualMapCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            DualMapCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            DualMapCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            Function13<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, codec12, getter12, codec13, getter13, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            DualMapCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            DualMapCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            DualMapCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            DualMapCodec<? super BUF, ARG14> codec14, Function<RES, ARG14> getter14,
            Function14<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, codec12, getter12, codec13, getter13, codec14, getter14, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            DualMapCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            DualMapCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            DualMapCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            DualMapCodec<? super BUF, ARG14> codec14, Function<RES, ARG14> getter14,
            DualMapCodec<? super BUF, ARG15> codec15, Function<RES, ARG15> getter15,
            Function15<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, codec12, getter12, codec13, getter13, codec14, getter14, codec15, getter15, builder).codec();
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> DualCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            DualMapCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            DualMapCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            DualMapCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            DualMapCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            DualMapCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            DualMapCodec<? super BUF, ARG14> codec14, Function<RES, ARG14> getter14,
            DualMapCodec<? super BUF, ARG15> codec15, Function<RES, ARG15> getter15,
            DualMapCodec<? super BUF, ARG16> codec16, Function<RES, ARG16> getter16,
            Function16<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> builder) {
        return DualCompositeMapCodecs.<BUF, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES>composite(codec1, getter1, codec2, getter2, codec3, getter3, codec4, getter4, codec5, getter5, codec6, getter6, codec7, getter7, codec8, getter8, codec9, getter9, codec10, getter10, codec11, getter11, codec12, getter12, codec13, getter13, codec14, getter14, codec15, getter15, codec16, getter16, builder).codec();
    }
}
