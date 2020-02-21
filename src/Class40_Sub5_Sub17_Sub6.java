/* Class40_Sub5_Sub17_Sub6 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class40_Sub5_Sub17_Sub6 extends Renderable {
    public static int anInt3232;
    public static int anInt3234;
    public static RSFont aClass40_Sub5_Sub14_Sub1_3236;
    public static int[][] anIntArrayArray3238 = {{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193}, {8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239}, {25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
    public static int anInt3241;
    public static Class68 aClass68_3243;
    public static RSString aClass1_3245 = Class58.method978("Sie haben gerade eine andere Welt verlassen)3");
    public static RSFont aClass40_Sub5_Sub14_Sub1_3246;
    public static RSString aClass1_3247;
    public static int[] anIntArray3248;
    public static int[] anIntArray3250;
    public static int anInt3251;
    public static int anInt3252;
    public static int[] anIntArray3253;
    public static RSString aClass1_3254 = Class58.method978("redstone2");
    public static int[] anIntArray3255;

    static {
        aClass1_3247 = Class58.method978("Die Verbindung konnte");
    }

    public int anInt3230;
    public int anInt3231;
    public int anInt3233;
    public int anInt3235;
    public boolean aBoolean3237;
    public int anInt3239;
    public int anInt3240 = 0;
    public Class40_Sub5_Sub7 aClass40_Sub5_Sub7_3242;
    public int anInt3244;
    public int anInt3249;

    public Class40_Sub5_Sub17_Sub6(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        aBoolean3237 = false;
        anInt3233 = 0;
        try {
            anInt3235 = arg3;
            anInt3244 = arg2;
            anInt3230 = arg5 + arg6;
            anInt3231 = arg4;
            anInt3249 = arg0;
            anInt3239 = arg1;
            int i = Class37.method431(anInt3249, 13).anInt2287;
            if((i ^ 0xffffffff) != 0) {
                aBoolean3237 = false;
                aClass40_Sub5_Sub7_3242 = Class68_Sub1.method1050(i, 2);
            } else
                aBoolean3237 = true;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("tb.<init>(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ')'));
        }
    }

    public static int method831(int arg0, int arg1, byte arg2) {
        try {
            anInt3252++;
            if(arg0 == -1)
                return 12345678;
            if(arg2 != 73)
                anIntArrayArray3238 = null;
            arg1 = (0x7f & arg0) * arg1 / 128;
            if((arg1 ^ 0xffffffff) > -3)
                arg1 = 2;
            else if(arg1 > 126)
                arg1 = 126;
            return arg1 + (arg0 & 0xff80);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("tb.C(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public static RSString method832(int arg0, RSString[] arg1) {
        try {
            int i = 58 % ((7 - arg0) / 44);
            anInt3251++;
            if((arg1.length ^ 0xffffffff) > -3)
                throw new IllegalArgumentException();
            return Class40_Sub5_Sub10.method627(120, arg1.length, 0, arg1);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("tb.A(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method833(int arg0, boolean arg1) {
        try {
            anInt3241++;
            if(((Class40_Sub5_Sub4.anInt2366 ^ 0xffffffff) == ((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3098) >> 1533110887 ^ 0xffffffff)) && ((Class55.anInt1304 ^ 0xffffffff) == ((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3089) >> -425626553 ^ 0xffffffff)))
                Class40_Sub5_Sub4.anInt2366 = 0;
            int i = Class60.anInt1407;
            if(arg1)
                i = 1;
            int i_0_ = arg0;
            for(/**/; i > i_0_; i_0_++) {
                int i_1_;
                Player class40_sub5_sub17_sub4_sub1;
                if(arg1) {
                    i_1_ = 33538048;
                    class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760);
                } else {
                    i_1_ = Class57.anIntArray1334[i_0_] << -377206898;
                    class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_0_]]);
                }
                if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.method784(1)) {
                    class40_sub5_sub17_sub4_sub1.aBoolean3287 = false;
                    int i_2_ = class40_sub5_sub17_sub4_sub1.anInt3098 >> 1455652391;
                    int i_3_ = class40_sub5_sub17_sub4_sub1.anInt3089 >> -130081305;
                    if(((Class46.lowMemory && (Class60.anInt1407 ^ 0xffffffff) < -51) || (Class60.anInt1407 ^ 0xffffffff) < -201) && !arg1 && ((class40_sub5_sub17_sub4_sub1.anInt3126 ^ 0xffffffff) == (class40_sub5_sub17_sub4_sub1.anInt3077 ^ 0xffffffff)))
                        class40_sub5_sub17_sub4_sub1.aBoolean3287 = true;
                    if(i_2_ >= 0 && (i_2_ ^ 0xffffffff) > -105 && i_3_ >= 0 && i_3_ < 104) {
                        if((class40_sub5_sub17_sub4_sub1.aClass40_Sub5_Sub17_Sub5_3265) != null && ((class40_sub5_sub17_sub4_sub1.anInt3283 ^ 0xffffffff) >= (Node.anInt926 ^ 0xffffffff)) && (Node.anInt926 < class40_sub5_sub17_sub4_sub1.anInt3274)) {
                            class40_sub5_sub17_sub4_sub1.aBoolean3287 = false;
                            class40_sub5_sub17_sub4_sub1.anInt3276 = (Class37.method430((byte) -117, Player.anInt3267, class40_sub5_sub17_sub4_sub1.anInt3098, class40_sub5_sub17_sub4_sub1.anInt3089));
                            NPC.aScene_3301.method112(Player.anInt3267, class40_sub5_sub17_sub4_sub1.anInt3098, class40_sub5_sub17_sub4_sub1.anInt3089, class40_sub5_sub17_sub4_sub1.anInt3276, 60, class40_sub5_sub17_sub4_sub1, class40_sub5_sub17_sub4_sub1.anInt3118, i_1_, class40_sub5_sub17_sub4_sub1.anInt3258, class40_sub5_sub17_sub4_sub1.anInt3281, class40_sub5_sub17_sub4_sub1.anInt3262, class40_sub5_sub17_sub4_sub1.anInt3289);
                        } else {
                            if((0x7f & class40_sub5_sub17_sub4_sub1.anInt3098 ^ 0xffffffff) == -65 && ((class40_sub5_sub17_sub4_sub1.anInt3089 & 0x7f) ^ 0xffffffff) == -65) {
                                if(Class40_Sub5_Sub11.anInt2628 == Class61.anIntArrayArray1435[i_2_][i_3_])
                                    continue;
                                Class61.anIntArrayArray1435[i_2_][i_3_] = Class40_Sub5_Sub11.anInt2628;
                            }
                            class40_sub5_sub17_sub4_sub1.anInt3276 = (Class37.method430((byte) -120, Player.anInt3267, class40_sub5_sub17_sub4_sub1.anInt3098, class40_sub5_sub17_sub4_sub1.anInt3089));
                            NPC.aScene_3301.method134(Player.anInt3267, class40_sub5_sub17_sub4_sub1.anInt3098, class40_sub5_sub17_sub4_sub1.anInt3089, class40_sub5_sub17_sub4_sub1.anInt3276, 60, class40_sub5_sub17_sub4_sub1, class40_sub5_sub17_sub4_sub1.anInt3118, i_1_, class40_sub5_sub17_sub4_sub1.aBoolean3105);
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "tb.E(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method835(byte arg0) {
        try {
            aClass1_3247 = null;
            aClass68_3243 = null;
            anIntArray3250 = null;
            anIntArrayArray3238 = null;
            aClass40_Sub5_Sub14_Sub1_3246 = null;
            anIntArray3253 = null;
            aClass1_3245 = null;
            if(arg0 < 87)
                aClass40_Sub5_Sub14_Sub1_3236 = null;
            aClass1_3254 = null;
            anIntArray3248 = null;
            anIntArray3255 = null;
            aClass40_Sub5_Sub14_Sub1_3236 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "tb.B(" + arg0 + ')');
        }
    }

    public Model method756(int arg0) {
        try {
            anInt3234++;
            Class40_Sub5_Sub2 class40_sub5_sub2 = Class37.method431(anInt3249, 13);
            int i = -110 / ((arg0 - 41) / 47);
            Model class40_sub5_sub17_sub5;
            if(aBoolean3237)
                class40_sub5_sub17_sub5 = class40_sub5_sub2.method549(-1, 2);
            else
                class40_sub5_sub17_sub5 = class40_sub5_sub2.method549(anInt3240, 2);
            if(class40_sub5_sub17_sub5 == null)
                return null;
            return class40_sub5_sub17_sub5;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "tb.UA(" + arg0 + ')');
        }
    }

    public void method834(int arg0, int arg1) {
        try {
            anInt3232++;
            if(arg0 != 8076)
                method834(106, 6);
            if(!aBoolean3237) {
                anInt3233 += arg1;
                while((anInt3233 ^ 0xffffffff) < (aClass40_Sub5_Sub7_3242.anIntArray2466[anInt3240] ^ 0xffffffff)) {
                    anInt3233 -= aClass40_Sub5_Sub7_3242.anIntArray2466[anInt3240];
                    anInt3240++;
                    if(aClass40_Sub5_Sub7_3242.anIntArray2485.length <= anInt3240) {
                        aBoolean3237 = true;
                        break;
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "tb.D(" + arg0 + ',' + arg1 + ')');
        }
    }
}
