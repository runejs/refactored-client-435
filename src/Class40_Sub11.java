/* Class40_Sub11 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class40_Sub11 extends Node {
    public static RSString[] aClass1Array2147 = new RSString[200];
    public static int anInt2148;
    public static int anInt2149;
    public static int anInt2150;
    public static int anInt2151;
    public static int anInt2152;
    public static RSString[] aClass1Array2153 = new RSString[1000];
    public static int anInt2158 = 0;
    public static RSString aClass1_2161
            = Class58.method978(-11538, "headicons_pk");
    public static Class6 aClass6_2162;
    public static int anInt2163 = 0;
    public static RSString aClass1_2164 = Class58.method978(-11538, "::fpsoff");
    public int[] anIntArray2154;
    public int[] anIntArray2155;
    public Class15[] aClass15Array2156;
    public Class15[] aClass15Array2157;
    public byte[][][] aByteArrayArrayArray2159;
    public int anInt2160;
    public int[] anIntArray2165;
    public int anInt2166;

    public static RSString method872(int arg0, int arg1) {
        try {
            anInt2149++;
            if (arg0 > arg1)
                return HashTable.method334(arg1, -1);
            return Class19.aClass1_478;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "te.B(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method873(int arg0, int arg1, int arg2) {
        try {
            anInt2151++;
            if (arg2 != 45)
                anInt2158 = 53;
            int i = 0;
            for (int i_0_ = 0; i_0_ < 100; i_0_++) {
                if (Class40_Sub5_Sub17_Sub4.aClass1Array3160[i_0_] != null) {
                    int i_1_ = Class66.anIntArray1569[i_0_];
                    int i_2_
                            = 4 + Class40_Sub5_Sub8.anInt2557 + -(i * 14) + 70;
                    if (i_2_ < -20)
                        break;
                    if (i_1_ == 0)
                        i++;
                    RSString class1 = Class40_Sub5_Sub17.aClass1Array2856[i_0_];
                    if (class1 != null
                            && class1.method75((byte) 116, Class51.aClass1_1210))
                        class1 = class1.method50((byte) 95, 5);
                    if (class1 != null
                            && class1.method75((byte) 116,
                            Class40_Sub5_Sub12.aClass1_2729))
                        class1 = class1.method50((byte) 95, 5);
                    if ((i_1_ == 1 || i_1_ == 2)
                            && ((i_1_ ^ 0xffffffff) == -2 || Class35.anInt1737 == 0
                            || (Class35.anInt1737 == 1
                            && Class40_Sub2.method523(class1, -32624)))) {
                        if (arg1 > i_2_ - 14 && arg1 <= i_2_
                                && !(class1.method54
                                ((Class40_Sub5_Sub13
                                                .aClass40_Sub5_Sub17_Sub4_Sub1_2760
                                                .aClass1_3278),
                                        122))) {
                            Class40_Sub5_Sub6.anInt2453++;
                            if ((Class19.anInt493 ^ 0xffffffff) <= -2) {
                                Floor.method558
                                        (0, Class22_Sub1.aClass1_1865, 0, -501, 0,
                                                28,
                                                (Class40_Sub5_Sub17_Sub6.method832
                                                        (arg2 ^ ~0x18,
                                                                new RSString[]{Class26.aClass1_620,
                                                                        class1})));
                                Class3.anInt158++;
                            }
                            Floor.method558
                                    (0, Class38.aClass1_885, 0, -501, 0, 51,
                                            (Class40_Sub5_Sub17_Sub6.method832
                                                    (-82, new RSString[]{Class26.aClass1_620,
                                                            class1})));
                            Floor.method558
                                    (0, Class25.aClass1_591, 0, -501, 0, 45,
                                            (Class40_Sub5_Sub17_Sub6.method832
                                                    (-40, new RSString[]{Class26.aClass1_620,
                                                            class1})));
                            Class60.anInt1400++;
                        }
                        i++;
                    }
                    if (((i_1_ ^ 0xffffffff) == -4
                            || (i_1_ ^ 0xffffffff) == -8)
                            && (Class3.anInt165 ^ 0xffffffff) == -1
                            && ((i_1_ ^ 0xffffffff) == -8
                            || (Class4.anInt185 ^ 0xffffffff) == -1
                            || (Class4.anInt185 == 1
                            && Class40_Sub2.method523(class1, -32624)))) {
                        i++;
                        if (arg1 > -14 + i_2_
                                && (arg1 ^ 0xffffffff) >= (i_2_ ^ 0xffffffff)) {
                            Class40_Sub5_Sub6.anInt2453++;
                            if ((Class19.anInt493 ^ 0xffffffff) <= -2) {
                                Class3.anInt158++;
                                Floor.method558
                                        (0, Class22_Sub1.aClass1_1865, 0, -501, 0,
                                                28,
                                                (Class40_Sub5_Sub17_Sub6.method832
                                                        (arg2 + 60,
                                                                new RSString[]{Class26.aClass1_620,
                                                                        class1})));
                            }
                            Floor.method558
                                    (0, Class38.aClass1_885, 0, -501, 0, 51,
                                            (Class40_Sub5_Sub17_Sub6.method832
                                                    (arg2 ^ ~0x4c,
                                                            new RSString[]{Class26.aClass1_620,
                                                                    class1})));
                            Floor.method558
                                    (0, Class25.aClass1_591, 0, -501, 0, 45,
                                            (Class40_Sub5_Sub17_Sub6.method832
                                                    (arg2 ^ ~0x48,
                                                            new RSString[]{Class26.aClass1_620,
                                                                    class1})));
                            Class60.anInt1400++;
                        }
                    }
                    if ((i_1_ ^ 0xffffffff) == -5
                            && ((ItemDefinition.anInt2797 ^ 0xffffffff) == -1
                            || (((ItemDefinition.anInt2797 ^ 0xffffffff)
                            == -2)
                            && Class40_Sub2.method523(class1, -32624)))) {
                        if (arg1 > -14 + i_2_
                                && (arg1 ^ 0xffffffff) >= (i_2_ ^ 0xffffffff)) {
                            Class40_Sub5_Sub17.anInt2867++;
                            Floor.method558
                                    (0, Class51.aClass1_1208, 0, arg2 ^ ~0x1d9, 0,
                                            26,
                                            (Class40_Sub5_Sub17_Sub6.method832
                                                    (-41, new RSString[]{Class26.aClass1_620,
                                                            class1})));
                        }
                        i++;
                    }
                    if (((i_1_ ^ 0xffffffff) == -6 || i_1_ == 6)
                            && Class3.anInt165 == 0
                            && (Class4.anInt185 ^ 0xffffffff) > -3)
                        i++;
                    if (i_1_ == 8
                            && (ItemDefinition.anInt2797 == 0
                            || (((ItemDefinition.anInt2797 ^ 0xffffffff)
                            == -2)
                            && Class40_Sub2.method523(class1, -32624)))) {
                        if ((i_2_ + -14 ^ 0xffffffff) > (arg1 ^ 0xffffffff)
                                && (arg1 ^ 0xffffffff) >= (i_2_ ^ 0xffffffff)) {
                            Floor.method558
                                    (0, Class40_Sub5_Sub17_Sub2.aClass1_3039, 0,
                                            -501, 0, 46,
                                            (Class40_Sub5_Sub17_Sub6.method832
                                                    (arg2 + -108,
                                                            new RSString[]{Class26.aClass1_620,
                                                                    class1})));
                            Class40_Sub5_Sub17_Sub4.anInt3133++;
                        }
                        i++;
                    }
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("te.C(" + arg0 + ',' + arg1 + ',' + arg2
                            + ')'));
        }
    }

    public static void method874(byte arg0) {
        try {
            aClass1Array2153 = null;
            aClass6_2162 = null;
            aClass1_2164 = null;
            if (arg0 != 101)
                method873(-62, -35, -55);
            aClass1_2161 = null;
            aClass1Array2147 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "te.A(" + arg0 + ')');
        }
    }
}
