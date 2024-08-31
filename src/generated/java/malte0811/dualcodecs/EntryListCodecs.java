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
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class EntryListCodecs {
    private EntryListCodecs() {
    }

    public static <ARG1, RES> MapCodec<RES> composite(MapCodec<ARG1> codec1,
            Function<RES, ARG1> getter1, Function<ARG1, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(1);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                return builder.apply(arg1);
            }
        };
    }

    public static <ARG1, ARG2, RES> MapCodec<RES> composite(MapCodec<ARG1> codec1,
            Function<RES, ARG1> getter1, MapCodec<ARG2> codec2, Function<RES, ARG2> getter2,
            BiFunction<ARG1, ARG2, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(2);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                return builder.apply(arg1, arg2);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, RES> MapCodec<RES> composite(MapCodec<ARG1> codec1,
            Function<RES, ARG1> getter1, MapCodec<ARG2> codec2, Function<RES, ARG2> getter2,
            MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            Function3<ARG1, ARG2, ARG3, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(3);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                return builder.apply(arg1, arg2, arg3);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, RES> MapCodec<RES> composite(MapCodec<ARG1> codec1,
            Function<RES, ARG1> getter1, MapCodec<ARG2> codec2, Function<RES, ARG2> getter2,
            MapCodec<ARG3> codec3, Function<RES, ARG3> getter3, MapCodec<ARG4> codec4,
            Function<RES, ARG4> getter4, Function4<ARG1, ARG2, ARG3, ARG4, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(4);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                return builder.apply(arg1, arg2, arg3, arg4);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, RES> MapCodec<RES> composite(MapCodec<ARG1> codec1,
            Function<RES, ARG1> getter1, MapCodec<ARG2> codec2, Function<RES, ARG2> getter2,
            MapCodec<ARG3> codec3, Function<RES, ARG3> getter3, MapCodec<ARG4> codec4,
            Function<RES, ARG4> getter4, MapCodec<ARG5> codec5, Function<RES, ARG5> getter5,
            Function5<ARG1, ARG2, ARG3, ARG4, ARG5, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(5);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                return builder.apply(arg1, arg2, arg3, arg4, arg5);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            Function6<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(6);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7,
            Function7<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(7);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8,
            Function8<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(8);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            Function9<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(9);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10,
            Function10<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(10);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10, MapCodec<ARG11> codec11,
            Function<RES, ARG11> getter11,
            Function11<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(11);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        list.add(new EntryListCodec.CodecEntry<RES, ARG11>(codec11, getter11));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                ARG11 arg11 = (ARG11) parts.get(10);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10, MapCodec<ARG11> codec11,
            Function<RES, ARG11> getter11, MapCodec<ARG12> codec12, Function<RES, ARG12> getter12,
            Function12<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(12);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        list.add(new EntryListCodec.CodecEntry<RES, ARG11>(codec11, getter11));
        list.add(new EntryListCodec.CodecEntry<RES, ARG12>(codec12, getter12));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                ARG11 arg11 = (ARG11) parts.get(10);
                ARG12 arg12 = (ARG12) parts.get(11);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10, MapCodec<ARG11> codec11,
            Function<RES, ARG11> getter11, MapCodec<ARG12> codec12, Function<RES, ARG12> getter12,
            MapCodec<ARG13> codec13, Function<RES, ARG13> getter13,
            Function13<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(13);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        list.add(new EntryListCodec.CodecEntry<RES, ARG11>(codec11, getter11));
        list.add(new EntryListCodec.CodecEntry<RES, ARG12>(codec12, getter12));
        list.add(new EntryListCodec.CodecEntry<RES, ARG13>(codec13, getter13));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                ARG11 arg11 = (ARG11) parts.get(10);
                ARG12 arg12 = (ARG12) parts.get(11);
                ARG13 arg13 = (ARG13) parts.get(12);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10, MapCodec<ARG11> codec11,
            Function<RES, ARG11> getter11, MapCodec<ARG12> codec12, Function<RES, ARG12> getter12,
            MapCodec<ARG13> codec13, Function<RES, ARG13> getter13, MapCodec<ARG14> codec14,
            Function<RES, ARG14> getter14,
            Function14<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(14);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        list.add(new EntryListCodec.CodecEntry<RES, ARG11>(codec11, getter11));
        list.add(new EntryListCodec.CodecEntry<RES, ARG12>(codec12, getter12));
        list.add(new EntryListCodec.CodecEntry<RES, ARG13>(codec13, getter13));
        list.add(new EntryListCodec.CodecEntry<RES, ARG14>(codec14, getter14));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                ARG11 arg11 = (ARG11) parts.get(10);
                ARG12 arg12 = (ARG12) parts.get(11);
                ARG13 arg13 = (ARG13) parts.get(12);
                ARG14 arg14 = (ARG14) parts.get(13);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10, MapCodec<ARG11> codec11,
            Function<RES, ARG11> getter11, MapCodec<ARG12> codec12, Function<RES, ARG12> getter12,
            MapCodec<ARG13> codec13, Function<RES, ARG13> getter13, MapCodec<ARG14> codec14,
            Function<RES, ARG14> getter14, MapCodec<ARG15> codec15, Function<RES, ARG15> getter15,
            Function15<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(15);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        list.add(new EntryListCodec.CodecEntry<RES, ARG11>(codec11, getter11));
        list.add(new EntryListCodec.CodecEntry<RES, ARG12>(codec12, getter12));
        list.add(new EntryListCodec.CodecEntry<RES, ARG13>(codec13, getter13));
        list.add(new EntryListCodec.CodecEntry<RES, ARG14>(codec14, getter14));
        list.add(new EntryListCodec.CodecEntry<RES, ARG15>(codec15, getter15));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                ARG11 arg11 = (ARG11) parts.get(10);
                ARG12 arg12 = (ARG12) parts.get(11);
                ARG13 arg13 = (ARG13) parts.get(12);
                ARG14 arg14 = (ARG14) parts.get(13);
                ARG15 arg15 = (ARG15) parts.get(14);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
            }
        };
    }

    public static <ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> MapCodec<RES> composite(
            MapCodec<ARG1> codec1, Function<RES, ARG1> getter1, MapCodec<ARG2> codec2,
            Function<RES, ARG2> getter2, MapCodec<ARG3> codec3, Function<RES, ARG3> getter3,
            MapCodec<ARG4> codec4, Function<RES, ARG4> getter4, MapCodec<ARG5> codec5,
            Function<RES, ARG5> getter5, MapCodec<ARG6> codec6, Function<RES, ARG6> getter6,
            MapCodec<ARG7> codec7, Function<RES, ARG7> getter7, MapCodec<ARG8> codec8,
            Function<RES, ARG8> getter8, MapCodec<ARG9> codec9, Function<RES, ARG9> getter9,
            MapCodec<ARG10> codec10, Function<RES, ARG10> getter10, MapCodec<ARG11> codec11,
            Function<RES, ARG11> getter11, MapCodec<ARG12> codec12, Function<RES, ARG12> getter12,
            MapCodec<ARG13> codec13, Function<RES, ARG13> getter13, MapCodec<ARG14> codec14,
            Function<RES, ARG14> getter14, MapCodec<ARG15> codec15, Function<RES, ARG15> getter15,
            MapCodec<ARG16> codec16, Function<RES, ARG16> getter16,
            Function16<ARG1, ARG2, ARG3, ARG4, ARG5, ARG6, ARG7, ARG8, ARG9, ARG10, ARG11, ARG12, ARG13, ARG14, ARG15, ARG16, RES> builder) {
        List<EntryListCodec.CodecEntry<RES, ?>> list = new ArrayList<EntryListCodec.CodecEntry<RES, ?>>(16);
        list.add(new EntryListCodec.CodecEntry<RES, ARG1>(codec1, getter1));
        list.add(new EntryListCodec.CodecEntry<RES, ARG2>(codec2, getter2));
        list.add(new EntryListCodec.CodecEntry<RES, ARG3>(codec3, getter3));
        list.add(new EntryListCodec.CodecEntry<RES, ARG4>(codec4, getter4));
        list.add(new EntryListCodec.CodecEntry<RES, ARG5>(codec5, getter5));
        list.add(new EntryListCodec.CodecEntry<RES, ARG6>(codec6, getter6));
        list.add(new EntryListCodec.CodecEntry<RES, ARG7>(codec7, getter7));
        list.add(new EntryListCodec.CodecEntry<RES, ARG8>(codec8, getter8));
        list.add(new EntryListCodec.CodecEntry<RES, ARG9>(codec9, getter9));
        list.add(new EntryListCodec.CodecEntry<RES, ARG10>(codec10, getter10));
        list.add(new EntryListCodec.CodecEntry<RES, ARG11>(codec11, getter11));
        list.add(new EntryListCodec.CodecEntry<RES, ARG12>(codec12, getter12));
        list.add(new EntryListCodec.CodecEntry<RES, ARG13>(codec13, getter13));
        list.add(new EntryListCodec.CodecEntry<RES, ARG14>(codec14, getter14));
        list.add(new EntryListCodec.CodecEntry<RES, ARG15>(codec15, getter15));
        list.add(new EntryListCodec.CodecEntry<RES, ARG16>(codec16, getter16));
        return new EntryListCodec<RES>(list) {
            @SuppressWarnings("unchecked")
            protected RES make(List<Object> parts) {
                ARG1 arg1 = (ARG1) parts.get(0);
                ARG2 arg2 = (ARG2) parts.get(1);
                ARG3 arg3 = (ARG3) parts.get(2);
                ARG4 arg4 = (ARG4) parts.get(3);
                ARG5 arg5 = (ARG5) parts.get(4);
                ARG6 arg6 = (ARG6) parts.get(5);
                ARG7 arg7 = (ARG7) parts.get(6);
                ARG8 arg8 = (ARG8) parts.get(7);
                ARG9 arg9 = (ARG9) parts.get(8);
                ARG10 arg10 = (ARG10) parts.get(9);
                ARG11 arg11 = (ARG11) parts.get(10);
                ARG12 arg12 = (ARG12) parts.get(11);
                ARG13 arg13 = (ARG13) parts.get(12);
                ARG14 arg14 = (ARG14) parts.get(13);
                ARG15 arg15 = (ARG15) parts.get(14);
                ARG16 arg16 = (ARG16) parts.get(15);
                return builder.apply(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
            }
        };
    }
}
