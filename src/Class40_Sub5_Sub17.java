/* Class40_Sub5_Sub17 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public abstract class Class40_Sub5_Sub17 extends SubNode {
    public static int anInt2855;
    public static RSString[] aClass1Array2856;
    public static Class6_Sub1 aClass6_Sub1_2857;
    public static long aLong2858 = 0L;
    public static int anInt2859;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_2860;
    public static RSString aClass1_2862 = Class58.method978(-11538, "@cya@");
    public static int anInt2863;
    public static RSString aClass1_2864;
    public static int[] anIntArray2865;
    public static int anInt2866;
    public static int anInt2867;
    public static int anInt2868;
    public static int anInt2869;
    public static RSString aClass1_2870;
    public static RSString aClass1_2871;

    static {
        aClass1Array2856 = new RSString[100];
        anInt2869 = 0;
        aClass1_2870
                = Class58.method978(-11538, " from your friend list first");
        aClass1_2864 = aClass1_2870;
        aClass1_2871 = Class58.method978(-11538, "Bitte versuchen Sie)1");
    }

    public int anInt2861 = 1000;

    public static boolean method754(int arg0, int arg1) {
        try {
            anInt2859++;
            if (!Class68.method1043(arg1, 127))
                return false;
            Class40_Sub5_Sub12[] class40_sub5_sub12s
                    = Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1];
            if (arg0 != 29378)
                anInt2866 = 125;
            boolean bool = false;
            for (int i = 0; class40_sub5_sub12s.length > i; i++) {
                Class40_Sub5_Sub12 class40_sub5_sub12 = class40_sub5_sub12s[i];
                if (class40_sub5_sub12 != null
                        && class40_sub5_sub12.anInt2683 == 6) {
                    if ((class40_sub5_sub12.anInt2659 ^ 0xffffffff) != 0
                            || class40_sub5_sub12.anInt2653 != -1) {
                        boolean bool_0_
                                = ItemDefinition.method746(false,
                                class40_sub5_sub12);
                        int i_1_;
                        if (bool_0_)
                            i_1_ = class40_sub5_sub12.anInt2653;
                        else
                            i_1_ = class40_sub5_sub12.anInt2659;
                        if ((i_1_ ^ 0xffffffff) != 0) {
                            Class40_Sub5_Sub7 class40_sub5_sub7
                                    = Class68_Sub1.method1050(i_1_, 2);
                            class40_sub5_sub12.anInt2660 += Class5.anInt199;
                            while ((class40_sub5_sub7.anIntArray2466
                                    [class40_sub5_sub12.anInt2654])
                                    < class40_sub5_sub12.anInt2660) {
                                bool = true;
                                class40_sub5_sub12.anInt2660
                                        -= (class40_sub5_sub7.anIntArray2466
                                        [class40_sub5_sub12.anInt2654]);
                                class40_sub5_sub12.anInt2654++;
                                if ((class40_sub5_sub12.anInt2654 ^ 0xffffffff)
                                        <= (class40_sub5_sub7.anIntArray2485.length
                                        ^ 0xffffffff)) {
                                    class40_sub5_sub12.anInt2654
                                            -= class40_sub5_sub7.anInt2497;
                                    if ((class40_sub5_sub12.anInt2654
                                            ^ 0xffffffff) > -1
                                            || ((class40_sub5_sub12.anInt2654
                                            ^ 0xffffffff)
                                            <= ((class40_sub5_sub7
                                            .anIntArray2485).length
                                            ^ 0xffffffff)))
                                        class40_sub5_sub12.anInt2654 = 0;
                                }
                            }
                        }
                    }
                    if (class40_sub5_sub12.anInt2722 != 0) {
                        bool = true;
                        int i_2_ = class40_sub5_sub12.anInt2722 >> -1999002640;
                        int i_3_ = (class40_sub5_sub12.anInt2722 << 1943281072
                                >> -1142238960);
                        i_2_ *= Class5.anInt199;
                        class40_sub5_sub12.anInt2690
                                = 0x7ff & i_2_ + class40_sub5_sub12.anInt2690;
                        i_3_ *= Class5.anInt199;
                        class40_sub5_sub12.anInt2657
                                = 0x7ff & class40_sub5_sub12.anInt2657 - -i_3_;
                    }
                }
            }
            return bool;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "vb.EB(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method757(byte arg0) {
        try {
            aClass1_2871 = null;
            aClass1Array2856 = null;
            if (arg0 > -112)
                method757((byte) 59);
            aClass40_Sub5_Sub14_Sub2_2860 = null;
            aClass6_Sub1_2857 = null;
            aClass1_2870 = null;
            anIntArray2865 = null;
            aClass1_2862 = null;
            aClass1_2864 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vb.DB(" + arg0 + ')');
        }
    }

    public void method755(int arg0, int arg1, int arg2, int arg3, int arg4,
                          int arg5, int arg6, int arg7, int arg8) {
        anInt2868++;
        Model class40_sub5_sub17_sub5 = method756(-38);
        if (class40_sub5_sub17_sub5 != null) {
            anInt2861 = class40_sub5_sub17_sub5.anInt2861;
            class40_sub5_sub17_sub5.method755(arg0, arg1, arg2, arg3, arg4,
                    arg5, arg6, arg7, arg8);
        }
    }

    public Model method756(int arg0) {
        try {
            int i = 87 / ((arg0 - 41) / 47);
            anInt2855++;
            return null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "vb.UA(" + arg0 + ')');
        }
    }
}
