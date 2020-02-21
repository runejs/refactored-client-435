/* Class40_Sub4 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.nio.charset.StandardCharsets;

public class Class40_Sub4 extends Node {
    public static int anInt2040;
    public static int anInt2041;
    public static RSString aClass1_2042;
    public static DirectColorSprite aClass40_Sub5_Sub14_Sub4_2043;
    public static RSString aClass1_2044;
    public static int anInt2045;
    public static RSString aClass1_2046 = Class58.method978("Verbindung mit Freunde)2Server)3)3)3");
    public static RSString aClass1_2047;
    public static int[] anIntArray2048;
    public static int anInt2049;
    public static RSString aClass1_2050;
    public static RSString aClass1_2051;
    public static int anInt2052;
    public static RSString aClass1_2053;
    public static RSString aClass1_2054;
    public static RSString aClass1_2055;
    public static int anInt2056;
    public static RSString aClass1_2057;

    static {
        aClass1_2044 = Class58.method978("Schrifts-=tze geladen)3");
        aClass1_2051 = Class58.method978("m-Ochte sich mit Ihnen duellieren)3");
        aClass1_2055 = Class58.method978("Please try using a different world)3");
        aClass1_2050 = aClass1_2055;
        aClass1_2047 = aClass1_2055;
        aClass1_2053 = aClass1_2055;
        aClass1_2057 = aClass1_2055;
        aClass1_2042 = aClass1_2055;
        anInt2049 = 0;
        aClass1_2054 = aClass1_2055;
    }

    public Class40_Sub4 aClass40_Sub4_2058;
    public int anInt2059;
    public Class58 aClass58_2060;
    public int anInt2061;
    public boolean aBoolean2062;
    public int anInt2063;
    public int anInt2064;
    public Class19[] aClass19Array2065 = new Class19[5];
    public int anInt2066;
    public int anInt2067;
    public Class11 aClass11_2068;
    public int anInt2069;
    public Class52 aClass52_2070;
    public boolean aBoolean2071;
    public Class10 aClass10_2072;
    public int anInt2073;
    public int[] anIntArray2074 = new int[5];
    public Class25 aClass25_2075;
    public int anInt2076;
    public boolean aBoolean2077;
    public int anInt2078;
    public Class53 aClass53_2079;
    public int anInt2080;

    public Class40_Sub4(int arg0, int arg1, int arg2) {
        anInt2073 = 0;
        try {
            anInt2061 = arg1;
            anInt2069 = anInt2066 = arg0;
            anInt2078 = arg2;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("fa.<init>(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public static RSString method532(byte arg0, Class40_Sub5_Sub12 arg1, RSString arg2) {
        try {
            anInt2045++;
            if(arg0 != 20)
                aClass1_2047 = null;
            if(arg2.method60(Class44.aClass1_1041, arg0 + 12) != -1) {
                for(; ; ) {
                    int i = arg2.method60(Class38.aClass1_890, 32);
                    if(i == -1)
                        break;
                    arg2 = (Class40_Sub5_Sub17_Sub6.method832(-37, (new RSString[]{arg2.method68(0, 0, i), (Class40_Sub11.method872(999999999, Class66.method1029(0, false, arg1))), arg2.method50((byte) 95, 2 + i)})));
                }
                for(; ; ) {
                    int i = arg2.method60(Class45.aClass1_1077, 32);
                    if((i ^ 0xffffffff) == 0)
                        break;
                    arg2 = (Class40_Sub5_Sub17_Sub6.method832(72, (new RSString[]{arg2.method68(0, 0, i), (Class40_Sub11.method872(999999999, Class66.method1029(1, false, arg1))), arg2.method50((byte) 95, i + 2)})));
                }
                for(; ; ) {
                    int i = arg2.method60(Class67.aClass1_1610, 32);
                    if((i ^ 0xffffffff) == 0)
                        break;
                    arg2 = (Class40_Sub5_Sub17_Sub6.method832(-121, (new RSString[]{arg2.method68(arg0 ^ 0x14, 0, i), (Class40_Sub11.method872(999999999, Class66.method1029(2, false, arg1))), arg2.method50((byte) 95, 2 + i)})));
                }
                for(; ; ) {
                    int i = arg2.method60(Class55.aClass1_1300, 32);
                    if(i == -1)
                        break;
                    arg2 = (Class40_Sub5_Sub17_Sub6.method832(125, (new RSString[]{arg2.method68(0, 0, i), (Class40_Sub11.method872(arg0 ^ 0x3b9ac9eb, Class66.method1029(3, false, arg1))), arg2.method50((byte) 95, i + 2)})));
                }
                for(; ; ) {
                    int i = arg2.method60(SubNode.aClass1_2090, 32);
                    if(i == -1)
                        break;
                    arg2 = (Class40_Sub5_Sub17_Sub6.method832(-43, (new RSString[]{arg2.method68(0, 0, i), (Class40_Sub11.method872(999999999, Class66.method1029(4, false, arg1))), arg2.method50((byte) 95, i - -2)})));
                }
                for(; ; ) {
                    int i = arg2.method60(Class40_Sub5_Sub8.aClass1_2526, arg0 ^ 0x34);
                    if((i ^ 0xffffffff) == 0)
                        break;
                    RSString class1 = Class66.aClass1_1567;
                    if(Class12.aClass15_394 != null) {
                        class1 = Class6_Sub1.method204((Class12.aClass15_394.anInt432), 255);
                        if(Class12.aClass15_394.anObject437 != null) {
                            byte[] is = ((String) Class12.aClass15_394.anObject437).getBytes(StandardCharsets.ISO_8859_1);
                            class1 = Class19.method279(is, true, 0, is.length);
                        }
                    }
                    arg2 = (Class40_Sub5_Sub17_Sub6.method832(124, new RSString[]{arg2.method68(0, 0, i), class1, arg2.method50((byte) 95, i + 4)}));
                }
            }
            return arg2;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("fa.B(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + (arg2 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method533(int arg0, int arg1, DirectColorSprite arg2, byte arg3) {
        try {
            anInt2052++;
            if(arg2 != null) {
                int i = 0x7ff & Class43.anInt1020 + Class58.anInt1373;
                int i_0_ = arg0 * arg0 + arg1 * arg1;
                if(i_0_ <= 6400) {
                    int i_1_ = Model.anIntArray3215[i];
                    i_1_ = i_1_ * 256 / (Class51.anInt1187 + 256);
                    int i_2_ = Model.anIntArray3217[i];
                    i_2_ = i_2_ * 256 / (Class51.anInt1187 + 256);
                    int i_3_ = i_2_ * arg1 + arg0 * i_1_ >> -78503568;
                    int i_4_ = -(arg1 * i_1_) + i_2_ * arg0 >> -1568937360;
                    if(arg3 < 22)
                        method535(18, (byte) 75);
                    if((i_0_ ^ 0xffffffff) < -2501)
                        arg2.method725(Class34.aClass40_Sub5_Sub14_Sub2_855, 98 + i_3_ + -(arg2.anInt2954 / 2), -(arg2.anInt2952 / 2) + (-i_4_ + 79));
                    else
                        arg2.method721(4 + -(arg2.anInt2954 / 2) + (i_3_ + 94), -4 + (-i_4_ + (83 + -(arg2.anInt2952 / 2))));
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("fa.A(" + arg0 + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ',' + arg3 + ')'));
        }
    }

    public static void method534(int arg0) {
        try {
            aClass1_2042 = null;
            aClass1_2055 = null;
            aClass1_2050 = null;
            aClass1_2047 = null;
            aClass1_2044 = null;
            aClass1_2051 = null;
            aClass1_2057 = null;
            int i = -102 % ((arg0 - 14) / 51);
            aClass1_2053 = null;
            anIntArray2048 = null;
            aClass1_2054 = null;
            aClass1_2046 = null;
            aClass40_Sub5_Sub14_Sub4_2043 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "fa.E(" + arg0 + ')');
        }
    }

    public static Class40_Sub5_Sub8 method535(int arg0, byte arg1) {
        try {
            Class40_Sub5_Sub8 class40_sub5_sub8 = ((Class40_Sub5_Sub8) Class58.aClass9_1364.method231((long) arg0, (byte) 61));
            anInt2040++;
            if(class40_sub5_sub8 != null)
                return class40_sub5_sub8;
            byte[] is = Class40_Sub3.aClass6_2037.method172(arg0, 113, 6);
            class40_sub5_sub8 = new Class40_Sub5_Sub8();
            class40_sub5_sub8.anInt2538 = arg0;
            if(is != null)
                class40_sub5_sub8.method603(new Buffer(is), -122);
            class40_sub5_sub8.method605(true);
            if(class40_sub5_sub8.aBoolean2518) {
                class40_sub5_sub8.aBoolean2501 = false;
                class40_sub5_sub8.aBoolean2528 = false;
            }
            Class58.aClass9_1364.method230(-7208, (long) arg0, class40_sub5_sub8);
            if(arg1 <= 121)
                method533(51, -29, null, (byte) -100);
            return class40_sub5_sub8;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "fa.C(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static RSString method536(int arg0, int arg1, int arg2) {
        try {
            anInt2056++;
            if(arg2 >= -16)
                return null;
            int i = -arg1 + arg0;
            if((i ^ 0xffffffff) > 8)
                return Class25.aClass1_610;
            if((i ^ 0xffffffff) > 5)
                return Class29.aClass1_670;
            if(i < -3)
                return Class68.aClass1_1639;
            if((i ^ 0xffffffff) > -1)
                return Cache.aClass1_327;
            if((i ^ 0xffffffff) < -10)
                return Landscape.aClass1_1162;
            if(i > 6)
                return Class19.aClass1_494;
            if((i ^ 0xffffffff) < -4)
                return Node.aClass1_932;
            if((i ^ 0xffffffff) < -1)
                return Class37.aClass1_877;
            return Class54.aClass1_1283;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("fa.F(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public static void method537(int arg0) {
        try {
            anInt2041++;
            if(NpcDefinition.anInt2394 >= 2 || (Class8.anInt301 ^ 0xffffffff) != -1 || (Main.anInt1773 ^ 0xffffffff) != -1) {
                RSString class1;
                if(Class8.anInt301 == 1 && (NpcDefinition.anInt2394 ^ 0xffffffff) > -3)
                    class1 = (Class40_Sub5_Sub17_Sub6.method832(-74, (new RSString[]{Main.aClass1_1763, Class46.aClass1_1117, NPC.aClass1_3295, Class38.aClass1_894})));
                else if(Main.anInt1773 != 1 || NpcDefinition.anInt2394 >= 2)
                    class1 = (Landscape.aClass1Array1184[-1 + NpcDefinition.anInt2394]);
                else
                    class1 = (Class40_Sub5_Sub17_Sub6.method832(-57, new RSString[]{Class38_Sub1.aClass1_1918, Class46.aClass1_1117, Class25.aClass1_611, Class38.aClass1_894}));
                if((NpcDefinition.anInt2394 ^ 0xffffffff) < -3)
                    class1 = (Class40_Sub5_Sub17_Sub6.method832(56, new RSString[]{class1, Class53.aClass1_1243, HashTable.method334((NpcDefinition.anInt2394) + -2, -1), Class39.aClass1_904}));
                if(arg0 == 4)
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method684(class1, 4, 15, 16777215, true, Node.anInt926 / 1000);
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "fa.D(" + arg0 + ')');
        }
    }
}
