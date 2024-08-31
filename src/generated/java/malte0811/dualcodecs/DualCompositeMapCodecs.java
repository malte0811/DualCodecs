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
import com.mojang.serialization.MapCodec;
import io.netty.buffer.ByteBuf;
import java.lang.Integer;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.network.codec.StreamCodec;

/**
 * Methods to build "composite" map codecs with up to 16 members. The method parameters are k pairs of a {@link DualMapCodec} (e.g. obtained by {@code codec.fieldOf("foo")}) and a getter for corresponding member of the final object. The last parameter is a function to construct the object from the k members
 */
public abstract class DualCompositeMapCodecs implements StreamCodec<Integer, Integer> {
    private DualCompositeMapCodecs() {
    }

    public static <BUF extends ByteBuf, ARG1, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            Function<ARG1, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            BiFunction<ARG1, ARG2, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            Function3<ARG1, ARG2, ARG3, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            Function4<ARG1, ARG2, ARG3, ARG4, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            Function5<ARG1, ARG2, ARG3, ARG4, ARG5, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            Function6<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            Function7<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> DualMapCodec<BUF, RES> composite(
            DualMapCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            DualMapCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            DualMapCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            DualMapCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            DualMapCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            DualMapCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            DualMapCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            DualMapCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            Function8<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> builder) {
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, codec11.streamCodec(), getter11, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, codec11.mapCodec(), getter11, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, codec11.streamCodec(), getter11, codec12.streamCodec(), getter12, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, codec11.mapCodec(), getter11, codec12.mapCodec(), getter12, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, codec11.streamCodec(), getter11, codec12.streamCodec(), getter12, codec13.streamCodec(), getter13, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, codec11.mapCodec(), getter11, codec12.mapCodec(), getter12, codec13.mapCodec(), getter13, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, codec11.streamCodec(), getter11, codec12.streamCodec(), getter12, codec13.streamCodec(), getter13, codec14.streamCodec(), getter14, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, codec11.mapCodec(), getter11, codec12.mapCodec(), getter12, codec13.mapCodec(), getter13, codec14.mapCodec(), getter14, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, codec11.streamCodec(), getter11, codec12.streamCodec(), getter12, codec13.streamCodec(), getter13, codec14.streamCodec(), getter14, codec15.streamCodec(), getter15, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, codec11.mapCodec(), getter11, codec12.mapCodec(), getter12, codec13.mapCodec(), getter13, codec14.mapCodec(), getter14, codec15.mapCodec(), getter15, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> DualMapCodec<BUF, RES> composite(
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
        StreamCodec<BUF, RES> streamCodec = ExtendedStreamCodecs.composite(codec1.streamCodec(), getter1, codec2.streamCodec(), getter2, codec3.streamCodec(), getter3, codec4.streamCodec(), getter4, codec5.streamCodec(), getter5, codec6.streamCodec(), getter6, codec7.streamCodec(), getter7, codec8.streamCodec(), getter8, codec9.streamCodec(), getter9, codec10.streamCodec(), getter10, codec11.streamCodec(), getter11, codec12.streamCodec(), getter12, codec13.streamCodec(), getter13, codec14.streamCodec(), getter14, codec15.streamCodec(), getter15, codec16.streamCodec(), getter16, builder);
        MapCodec<RES> mapCodec = EntryListCodecs.composite(codec1.mapCodec(), getter1, codec2.mapCodec(), getter2, codec3.mapCodec(), getter3, codec4.mapCodec(), getter4, codec5.mapCodec(), getter5, codec6.mapCodec(), getter6, codec7.mapCodec(), getter7, codec8.mapCodec(), getter8, codec9.mapCodec(), getter9, codec10.mapCodec(), getter10, codec11.mapCodec(), getter11, codec12.mapCodec(), getter12, codec13.mapCodec(), getter13, codec14.mapCodec(), getter14, codec15.mapCodec(), getter15, codec16.mapCodec(), getter16, builder);
        return new DualMapCodec<BUF, RES>(mapCodec, streamCodec);
    }
}
