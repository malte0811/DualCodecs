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
import java.lang.Override;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.network.codec.StreamCodec;

/**
 * Provides composite stream codecs with up to 16 members, instead of the limit of 6 members imposed by the vanilla implementation
 */
public abstract class ExtendedStreamCodecs {
    private ExtendedStreamCodecs() {
    }

    public static <BUF extends ByteBuf, ARG1, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            Function<ARG1, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                return builder.apply(arg1);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            BiFunction<ARG1, ARG2, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                return builder.apply(arg1, arg2);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            Function3<ARG1, ARG2, ARG3, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                return builder.apply(arg1, arg2, arg3);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            Function4<ARG1, ARG2, ARG3, ARG4, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            Function5<ARG1, ARG2, ARG3, ARG4, ARG5, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            Function6<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            Function7<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            Function8<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            Function9<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            Function10<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            StreamCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            Function11<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                ARG11 arg11 = codec11.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
                codec11.encode(buf, getter11.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            StreamCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            StreamCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            Function12<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                ARG11 arg11 = codec11.decode(buf);
                ARG12 arg12 = codec12.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
                codec11.encode(buf, getter11.apply(object));
                codec12.encode(buf, getter12.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            StreamCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            StreamCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            StreamCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            Function13<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                ARG11 arg11 = codec11.decode(buf);
                ARG12 arg12 = codec12.decode(buf);
                ARG13 arg13 = codec13.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
                codec11.encode(buf, getter11.apply(object));
                codec12.encode(buf, getter12.apply(object));
                codec13.encode(buf, getter13.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            StreamCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            StreamCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            StreamCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            StreamCodec<? super BUF, ARG14> codec14, Function<RES, ARG14> getter14,
            Function14<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                ARG11 arg11 = codec11.decode(buf);
                ARG12 arg12 = codec12.decode(buf);
                ARG13 arg13 = codec13.decode(buf);
                ARG14 arg14 = codec14.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
                codec11.encode(buf, getter11.apply(object));
                codec12.encode(buf, getter12.apply(object));
                codec13.encode(buf, getter13.apply(object));
                codec14.encode(buf, getter14.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            StreamCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            StreamCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            StreamCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            StreamCodec<? super BUF, ARG14> codec14, Function<RES, ARG14> getter14,
            StreamCodec<? super BUF, ARG15> codec15, Function<RES, ARG15> getter15,
            Function15<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                ARG11 arg11 = codec11.decode(buf);
                ARG12 arg12 = codec12.decode(buf);
                ARG13 arg13 = codec13.decode(buf);
                ARG14 arg14 = codec14.decode(buf);
                ARG15 arg15 = codec15.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
                codec11.encode(buf, getter11.apply(object));
                codec12.encode(buf, getter12.apply(object));
                codec13.encode(buf, getter13.apply(object));
                codec14.encode(buf, getter14.apply(object));
                codec15.encode(buf, getter15.apply(object));
            }
        };
    }

    public static <BUF extends ByteBuf, ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> StreamCodec<BUF, RES> composite(
            StreamCodec<? super BUF, ARG1> codec1, Function<RES, ARG1> getter1,
            StreamCodec<? super BUF, ARG2> codec2, Function<RES, ARG2> getter2,
            StreamCodec<? super BUF, ARG3> codec3, Function<RES, ARG3> getter3,
            StreamCodec<? super BUF, ARG4> codec4, Function<RES, ARG4> getter4,
            StreamCodec<? super BUF, ARG5> codec5, Function<RES, ARG5> getter5,
            StreamCodec<? super BUF, ARG6> codec6, Function<RES, ARG6> getter6,
            StreamCodec<? super BUF, ARG7> codec7, Function<RES, ARG7> getter7,
            StreamCodec<? super BUF, ARG8> codec8, Function<RES, ARG8> getter8,
            StreamCodec<? super BUF, ARG9> codec9, Function<RES, ARG9> getter9,
            StreamCodec<? super BUF, ARG10> codec10, Function<RES, ARG10> getter10,
            StreamCodec<? super BUF, ARG11> codec11, Function<RES, ARG11> getter11,
            StreamCodec<? super BUF, ARG12> codec12, Function<RES, ARG12> getter12,
            StreamCodec<? super BUF, ARG13> codec13, Function<RES, ARG13> getter13,
            StreamCodec<? super BUF, ARG14> codec14, Function<RES, ARG14> getter14,
            StreamCodec<? super BUF, ARG15> codec15, Function<RES, ARG15> getter15,
            StreamCodec<? super BUF, ARG16> codec16, Function<RES, ARG16> getter16,
            Function16<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> builder) {
        return new StreamCodec<BUF, RES>() {
            @Override
            public RES decode(BUF buf) {
                ARG1 arg1 = codec1.decode(buf);
                ARG2 arg2 = codec2.decode(buf);
                ARG3 arg3 = codec3.decode(buf);
                ARG4 arg4 = codec4.decode(buf);
                ARG5 arg5 = codec5.decode(buf);
                ARG6 arg6 = codec6.decode(buf);
                ARG7 arg7 = codec7.decode(buf);
                ARG8 arg8 = codec8.decode(buf);
                ARG9 arg9 = codec9.decode(buf);
                ARG10 arg10 = codec10.decode(buf);
                ARG11 arg11 = codec11.decode(buf);
                ARG12 arg12 = codec12.decode(buf);
                ARG13 arg13 = codec13.decode(buf);
                ARG14 arg14 = codec14.decode(buf);
                ARG15 arg15 = codec15.decode(buf);
                ARG16 arg16 = codec16.decode(buf);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
            }

            @Override
            public void encode(BUF buf, RES object) {
                codec1.encode(buf, getter1.apply(object));
                codec2.encode(buf, getter2.apply(object));
                codec3.encode(buf, getter3.apply(object));
                codec4.encode(buf, getter4.apply(object));
                codec5.encode(buf, getter5.apply(object));
                codec6.encode(buf, getter6.apply(object));
                codec7.encode(buf, getter7.apply(object));
                codec8.encode(buf, getter8.apply(object));
                codec9.encode(buf, getter9.apply(object));
                codec10.encode(buf, getter10.apply(object));
                codec11.encode(buf, getter11.apply(object));
                codec12.encode(buf, getter12.apply(object));
                codec13.encode(buf, getter13.apply(object));
                codec14.encode(buf, getter14.apply(object));
                codec15.encode(buf, getter15.apply(object));
                codec16.encode(buf, getter16.apply(object));
            }
        };
    }
}
