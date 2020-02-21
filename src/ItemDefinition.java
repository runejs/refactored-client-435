/* Class40_Sub5_Sub16 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class ItemDefinition extends SubNode {
    public static int anInt2797;
    public static int anInt2798 = 0;
    public static int anInt2801;
    public static int anInt2802;
    public static int anInt2808;
    public static int anInt2809;
    public static int anInt2811;
    public static int[] anIntArray2814;
    public static int anInt2815;
    public static int anInt2821;
    public static int anInt2826;
    public static int anInt2832;
    public static int anInt2835;
    public static int anInt2837;
    public static int anInt2838;
    public static int anInt2839;
    public static int anInt2842;
    public static int anInt2843;
    public static int anInt2846;
    public static int anInt2847;
    public static int anInt2850;
    public static int anInt2854;

    static {
        anInt2797 = 0;
        anIntArray2814 = new int[50];
        anInt2850 = -1;
    }

    public int anInt2795;
    public RSString aClass1_2796;
    public RSString[] options;
    public int anInt2800 = -1;
    public int[] anIntArray2803;
    public RSString[] groundOptions;
    public int anInt2805;
    public int anInt2806;
    public int anInt2807;
    public int anInt2810;
    public int anInt2812;
    public int anInt2813;
    public int[] anIntArray2816;
    public int anInt2817;
    public int anInt2818;
    public int anInt2819;
    public int anInt2820;
    public int anInt2822;
    public int anInt2823;
    public int anInt2824;
    public int anInt2825;
    public int anInt2827;
    public int anInt2828;
    public int anInt2829;
    public int anInt2830;
    public int[] anIntArray2831;
    public int anInt2833;
    public int[] anIntArray2834;
    public int anInt2836;
    public int anInt2840;
    public int anInt2841;
    public int anInt2844;
    public int anInt2845;
    public int anInt2848;
    public boolean aBoolean2849;
    public int anInt2851;
    public int anInt2852;
    public int anInt2853;

    public ItemDefinition() {
        options = new RSString[]{null, null, null, null, Cache.dropStringInstance};
        anInt2795 = 0;
        anInt2818 = 0;
        aClass1_2796 = Class61.aClass1_1437;
        anInt2810 = 0;
        anInt2828 = 1;
        anInt2806 = 0;
        anInt2829 = 0;
        anInt2825 = 0;
        anInt2820 = -1;
        anInt2830 = 0;
        groundOptions = new RSString[]{null, null, Class27.takeStringInstance, null, null};
        anInt2813 = 128;
        anInt2807 = -1;
        anInt2822 = -1;
        anInt2817 = 2000;
        anInt2824 = -1;
        anInt2823 = 0;
        anInt2827 = 0;
        anInt2840 = 0;
        anInt2819 = -1;
        anInt2845 = -1;
        anInt2844 = 0;
        anInt2833 = 128;
        anInt2841 = -1;
        anInt2848 = -1;
        aBoolean2849 = false;
        anInt2851 = -1;
        anInt2853 = 128;
        anInt2812 = -1;
        anInt2836 = -1;
    }

    public static void method742(int arg0) {
        try {
            try {
                Graphics graphics = Class62.aCanvas1469.getGraphics();
                Landscape.aClass68_1185.method1044(arg0 ^ arg0, 0, graphics, 4);
                Class40_Sub5_Sub1.aClass68_2275.method1044(arg0 + -205, 0,
                        graphics, 357);
                Class39.aClass68_908.method1044(0, 722, graphics, 4);
                Class40_Sub5_Sub17_Sub2.aClass68_3045
                        .method1044(arg0 + -205, 743, graphics, 205);
                Class40_Sub5_Sub17_Sub6.aClass68_3243.method1044(0, 0,
                        graphics, 0);
                Class40_Sub7.aClass68_2123.method1044(0, 516, graphics, 4);
                Class61.aClass68_1441.method1044(0, 516, graphics, 205);
                Class30.aClass68_714.method1044(0, 496, graphics, 357);
                Class17.aClass68_462.method1044(0, 0, graphics, 338);
            } catch (Exception exception) {
                Class62.aCanvas1469.repaint();
            }
            anInt2808++;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ta.L(" + arg0 + ')');
        }
    }

    public static void method744(byte arg0) {
        anInt2839++;
        if (Class59.aClass54_1392 != null) {
            synchronized (Class59.aClass54_1392) {
                Class59.aClass54_1392 = null;
            }
        }
        if (arg0 != -80)
            method748(true, 72);
    }

    public static void method745(int arg0) {
        try {
            if (arg0 != 64)
                anInt2846 = -72;
            anIntArray2814 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ta.E(" + arg0 + ')');
        }
    }

    public static boolean method746(boolean arg0, Class40_Sub5_Sub12 arg1) {
        try {
            if (arg0 != false)
                anIntArray2814 = null;
            anInt2838++;
            if (arg1.anIntArray2742 == null)
                return false;
            for (int i = 0; arg1.anIntArray2742.length > i; i++) {
                int i_10_ = Class66.method1029(i, false, arg1);
                int i_11_ = arg1.anIntArray2693[i];
                if ((arg1.anIntArray2742[i] ^ 0xffffffff) == -3) {
                    if ((i_11_ ^ 0xffffffff) >= (i_10_ ^ 0xffffffff))
                        return false;
                } else if ((arg1.anIntArray2742[i] ^ 0xffffffff) == -4) {
                    if ((i_11_ ^ 0xffffffff) <= (i_10_ ^ 0xffffffff))
                        return false;
                } else if ((arg1.anIntArray2742[i] ^ 0xffffffff) == -5) {
                    if (i_11_ == i_10_)
                        return false;
                } else if ((i_11_ ^ 0xffffffff) != (i_10_ ^ 0xffffffff))
                    return false;
            }
            return true;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("ta.K(" + arg0 + ','
                            + (arg1 != null ? "{...}" : "null")
                            + ')'));
        }
    }

    public static void method748(boolean arg0, int arg1) {
        if (arg0 != true)
            method749(true, -38);
        anInt2843++;
        for (Class40_Sub5_Sub17.anInt2866 += arg1;
             ((Class3.anInt141 ^ 0xffffffff)
                     >= (Class40_Sub5_Sub17.anInt2866 ^ 0xffffffff));
             Class40_Sub5_Sub17.anInt2866 -= Class3.anInt141)
            SubNode.anInt2081 -= SubNode.anInt2081 >> -1244591038;
        SubNode.anInt2081 -= 1000 * arg1;
        if ((SubNode.anInt2081 ^ 0xffffffff) > -1)
            SubNode.anInt2081 = 0;
    }

    public static void method749(boolean arg0, int arg1) {
        try {
            for (int i = 0; Class40_Sub5_Sub8.anInt2558 > i; i++) {
                NPC class40_sub5_sub17_sub4_sub2
                        = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813
                        [Class40_Sub3.anIntArray2016[i]]);
                int i_15_ = (536870912
                        + (Class40_Sub3.anIntArray2016[i] << 1399377262));
                if (class40_sub5_sub17_sub4_sub2 != null
                        && class40_sub5_sub17_sub4_sub2.method784(1)
                        && !arg0 != (class40_sub5_sub17_sub4_sub2
                        .aClass40_Sub5_Sub5_3300.aBoolean2397)
                        && class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300
                        .method571(-1)) {
                    int i_16_ = (class40_sub5_sub17_sub4_sub2.anInt3098
                            >> -1699335129);
                    int i_17_
                            = class40_sub5_sub17_sub4_sub2.anInt3089 >> 698755175;
                    if ((i_16_ ^ 0xffffffff) <= -1
                            && (i_16_ ^ 0xffffffff) > -105
                            && (i_17_ ^ 0xffffffff) <= -1 && i_17_ < 104) {
                        if ((class40_sub5_sub17_sub4_sub2.anInt3096
                                ^ 0xffffffff) == -2
                                && (class40_sub5_sub17_sub4_sub2.anInt3098 & 0x7f
                                ^ 0xffffffff) == -65
                                && ((class40_sub5_sub17_sub4_sub2.anInt3089 & 0x7f)
                                == 64)) {
                            if ((Class40_Sub5_Sub11.anInt2628 ^ 0xffffffff)
                                    == (Class61.anIntArrayArray1435[i_16_][i_17_]
                                    ^ 0xffffffff))
                                continue;
                            Class61.anIntArrayArray1435[i_16_][i_17_]
                                    = Class40_Sub5_Sub11.anInt2628;
                        }
                        if (!class40_sub5_sub17_sub4_sub2
                                .aClass40_Sub5_Sub5_3300.aBoolean2372)
                            i_15_ += -2147483648;
                        NPC.aClass2_3301.method134
                                (Player.anInt3267,
                                        class40_sub5_sub17_sub4_sub2.anInt3098,
                                        class40_sub5_sub17_sub4_sub2.anInt3089,
                                        (Class37.method430
                                                ((byte) -126,
                                                        Player.anInt3267,
                                                        (class40_sub5_sub17_sub4_sub2.anInt3098
                                                                + ((-1
                                                                + class40_sub5_sub17_sub4_sub2.anInt3096)
                                                                * 64)),
                                                        (class40_sub5_sub17_sub4_sub2.anInt3096 * 64
                                                                + (-64 + (class40_sub5_sub17_sub4_sub2
                                                                .anInt3089))))),
                                        -64 + (class40_sub5_sub17_sub4_sub2.anInt3096 * 64
                                                + 60),
                                        class40_sub5_sub17_sub4_sub2,
                                        class40_sub5_sub17_sub4_sub2.anInt3118, i_15_,
                                        class40_sub5_sub17_sub4_sub2.aBoolean3105);
                    }
                }
            }
            if (arg1 != -15537)
                method744((byte) -33);
            anInt2811++;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "ta.F(" + arg0 + ',' + arg1 + ')');
        }
    }

    public boolean method738(byte arg0, boolean arg1) {
        try {
            anInt2832++;
            if (arg0 != 44)
                options = null;
            int i = anInt2800;
            int i_0_ = anInt2841;
            if (arg1) {
                i_0_ = anInt2822;
                i = anInt2851;
            }
            if (i == -1)
                return true;
            boolean bool = true;
            if (!Class8.aClass6_284.method173(i, (byte) -10, 0))
                bool = false;
            if (i_0_ != -1
                    && !Class8.aClass6_284.method173(i_0_, (byte) -10, 0))
                bool = false;
            return bool;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "ta.B(" + arg0 + ',' + arg1 + ')');
        }
    }

    public boolean method739(boolean arg0, byte arg1) {
        try {
            anInt2826++;
            int i = anInt2836;
            int i_1_ = anInt2820;
            int i_2_ = anInt2824;
            if (arg0) {
                i_2_ = anInt2845;
                i_1_ = anInt2819;
                i = anInt2848;
            }
            if ((i ^ 0xffffffff) == 0)
                return true;
            boolean bool = true;
            if (arg1 <= 126)
                return false;
            if (!Class8.aClass6_284.method173(i, (byte) -10, 0))
                bool = false;
            if (i_1_ != -1
                    && !Class8.aClass6_284.method173(i_1_, (byte) -10, 0))
                bool = false;
            if (i_2_ != -1
                    && !Class8.aClass6_284.method173(i_2_, (byte) -10, 0))
                bool = false;
            return bool;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "ta.D(" + arg0 + ',' + arg1 + ')');
        }
    }

    public Model method740(boolean arg0, int arg1) {
        try {
            anInt2837++;
            int i = anInt2836;
            int i_3_ = anInt2820;
            int i_4_ = 11 / ((arg1 - 35) / 56);
            int i_5_ = anInt2824;
            if (arg0) {
                i = anInt2848;
                i_3_ = anInt2819;
                i_5_ = anInt2845;
            }
            if (i == -1)
                return null;
            Model class40_sub5_sub17_sub5
                    = Model.method830(Class8.aClass6_284, i, 0);
            if (i_3_ != -1) {
                Model class40_sub5_sub17_sub5_6_
                        = Model.method830(Class8.aClass6_284,
                        i_3_, 0);
                if (i_5_ == -1) {
                    Model[] class40_sub5_sub17_sub5s
                            = {class40_sub5_sub17_sub5,
                            class40_sub5_sub17_sub5_6_};
                    class40_sub5_sub17_sub5
                            = new Model(class40_sub5_sub17_sub5s,
                            2);
                } else {
                    Model class40_sub5_sub17_sub5_7_
                            = Model.method830(Class8.aClass6_284,
                            i_5_, 0);
                    Model[] class40_sub5_sub17_sub5s
                            = {class40_sub5_sub17_sub5,
                            class40_sub5_sub17_sub5_6_,
                            class40_sub5_sub17_sub5_7_};
                    class40_sub5_sub17_sub5
                            = new Model(class40_sub5_sub17_sub5s,
                            3);
                }
            }
            if (!arg0 && (anInt2818 ^ 0xffffffff) != -1)
                class40_sub5_sub17_sub5.method828(0, anInt2818, 0);
            if (arg0 && anInt2829 != 0)
                class40_sub5_sub17_sub5.method828(0, anInt2829, 0);
            if (anIntArray2803 != null) {
                for (int i_8_ = 0; ((anIntArray2803.length ^ 0xffffffff)
                        < (i_8_ ^ 0xffffffff)); i_8_++)
                    class40_sub5_sub17_sub5.method803(anIntArray2803[i_8_],
                            anIntArray2816[i_8_]);
            }
            return class40_sub5_sub17_sub5;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "ta.O(" + arg0 + ',' + arg1 + ')');
        }
    }

    public void method741(int arg0) {
        try {
            if (arg0 == 29216)
                anInt2801++;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ta.N(" + arg0 + ')');
        }
    }

    public ItemDefinition method743(byte arg0, int arg1) {
        try {
            anInt2809++;
            if (anIntArray2831 != null && (arg1 ^ 0xffffffff) < -2) {
                int i = -1;
                for (int i_9_ = 0; (i_9_ ^ 0xffffffff) > -11; i_9_++) {
                    if ((arg1 ^ 0xffffffff) <= (anIntArray2834[i_9_]
                            ^ 0xffffffff)
                            && (anIntArray2834[i_9_] ^ 0xffffffff) != -1)
                        i = anIntArray2831[i_9_];
                }
                if ((i ^ 0xffffffff) != 0)
                    return Class44.method897(i, 10);
            }
            if (arg0 != -37)
                return null;
            return this;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "ta.H(" + arg0 + ',' + arg1 + ')');
        }
    }

    public Model method747(boolean arg0, byte arg1) {
        try {
            int i = anInt2800;
            int i_12_ = anInt2841;
            if (arg1 != 25)
                return null;
            anInt2847++;
            if (arg0) {
                i = anInt2851;
                i_12_ = anInt2822;
            }
            if (i == -1)
                return null;
            Model class40_sub5_sub17_sub5
                    = Model.method830(Class8.aClass6_284, i, 0);
            if (i_12_ != -1) {
                Model class40_sub5_sub17_sub5_13_
                        = Model.method830(Class8.aClass6_284,
                        i_12_, 0);
                Model[] class40_sub5_sub17_sub5s
                        = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_13_};
                class40_sub5_sub17_sub5
                        = new Model(class40_sub5_sub17_sub5s, 2);
            }
            if (anIntArray2803 != null) {
                for (int i_14_ = 0; ((anIntArray2803.length ^ 0xffffffff)
                        < (i_14_ ^ 0xffffffff)); i_14_++)
                    class40_sub5_sub17_sub5.method803(anIntArray2803[i_14_],
                            anIntArray2816[i_14_]);
            }
            return class40_sub5_sub17_sub5;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "ta.C(" + arg0 + ',' + arg1 + ')');
        }
    }

    public void readValue(int arg0, int arg1, Buffer arg2) {
        if (arg0 == 1)
            anInt2805 = arg2.method469(arg1 + 65373);
        else if ((arg0 ^ 0xffffffff) == -3)
            aClass1_2796 = arg2.getRSString(-10721);
        else if ((arg0 ^ 0xffffffff) != -5) {
            if ((arg0 ^ 0xffffffff) == -6)
                anInt2844 = arg2.method469(65280);
            else if ((arg0 ^ 0xffffffff) != -7) {
                if (arg0 != 7) {
                    if (arg0 != 8) {
                        if ((arg0 ^ 0xffffffff) != -12) {
                            if (arg0 != 12) {
                                if ((arg0 ^ 0xffffffff) == -17)
                                    aBoolean2849 = true;
                                else if ((arg0 ^ 0xffffffff) != -24) {
                                    if (arg0 != 24) {
                                        if ((arg0 ^ 0xffffffff) == -26) {
                                            anInt2848 = arg2.method469(65280);
                                            anInt2829 = arg2.method468(false);
                                        } else if ((arg0 ^ 0xffffffff) == -27)
                                            anInt2819 = arg2.method469(65280);
                                        else if ((arg0 ^ 0xffffffff) <= -31
                                                && ((arg0 ^ 0xffffffff)
                                                > -36)) {
                                            groundOptions[-30 + arg0]
                                                    = arg2.getRSString(-10721);
                                            if (groundOptions
                                                    [arg0 + -30].method63
                                                    (Class59.aClass1_1396, true))
                                                groundOptions[arg0 + -30]
                                                        = null;
                                        } else if (arg0 >= 35
                                                && ((arg0 ^ 0xffffffff)
                                                > -41))
                                            options[arg0 + -35]
                                                    = arg2.getRSString(-10721);
                                        else if (arg0 != 40) {
                                            if ((arg0 ^ 0xffffffff) == -79)
                                                anInt2824
                                                        = arg2.method469(65280);
                                            else if ((arg0 ^ 0xffffffff)
                                                    == -80)
                                                anInt2845
                                                        = arg2.method469(65280);
                                            else if ((arg0 ^ 0xffffffff)
                                                    == -91)
                                                anInt2800
                                                        = arg2.method469(65280);
                                            else if ((arg0 ^ 0xffffffff)
                                                    == -92)
                                                anInt2851
                                                        = arg2.method469(65280);
                                            else if ((arg0 ^ 0xffffffff)
                                                    == -93)
                                                anInt2841
                                                        = arg2.method469(65280);
                                            else if ((arg0 ^ 0xffffffff)
                                                    != -94) {
                                                if (arg0 == 95)
                                                    anInt2827 = (arg2.method469
                                                            (65280));
                                                else if ((arg0 ^ 0xffffffff)
                                                        == -98)
                                                    anInt2812 = (arg2.method469
                                                            (65280));
                                                else if ((arg0 ^ 0xffffffff)
                                                        != -99) {
                                                    if (arg0 >= 100
                                                            && ((arg0 ^ 0xffffffff)
                                                            > -111)) {
                                                        if (anIntArray2831
                                                                == null) {
                                                            anIntArray2834
                                                                    = new int[10];
                                                            anIntArray2831
                                                                    = new int[10];
                                                        }
                                                        anIntArray2831
                                                                [-100 + arg0]
                                                                = (arg2.method469
                                                                (RSApplet
                                                                        .method27
                                                                                (arg1,
                                                                                        -65373)));
                                                        anIntArray2834
                                                                [-100 + arg0]
                                                                = (arg2.method469
                                                                (65280));
                                                    } else if ((arg0
                                                            ^ 0xffffffff)
                                                            != -111) {
                                                        if (arg0 != 111) {
                                                            if (arg0 != 112) {
                                                                if (arg0
                                                                        == 113)
                                                                    anInt2825
                                                                            = (arg2.get
                                                                            (123));
                                                                else if ((arg0
                                                                        ^ 0xffffffff)
                                                                        != -115) {
                                                                    if (arg0
                                                                            == 115)
                                                                        anInt2823
                                                                                = arg2.method468(false);
                                                                } else
                                                                    anInt2840
                                                                            = ((arg2.get
                                                                            (96))
                                                                            * 5);
                                                            } else
                                                                anInt2833
                                                                        = (arg2.method469
                                                                        (65280));
                                                        } else
                                                            anInt2853
                                                                    = (arg2.method469
                                                                    (65280));
                                                    } else
                                                        anInt2813
                                                                = (arg2.method469
                                                                (arg1 + 65373));
                                                } else
                                                    anInt2807
                                                            = (arg2.method469
                                                            (arg1 ^ ~0xff5c));
                                            } else
                                                anInt2822
                                                        = arg2.method469(65280);
                                        } else {
                                            int i = arg2.method468(false);
                                            anIntArray2816 = new int[i];
                                            anIntArray2803 = new int[i];
                                            for (int i_18_ = 0;
                                                 ((i_18_ ^ 0xffffffff)
                                                         > (i ^ 0xffffffff));
                                                 i_18_++) {
                                                anIntArray2803[i_18_]
                                                        = arg2.method469(65280);
                                                anIntArray2816[i_18_]
                                                        = arg2.method469(65280);
                                            }
                                        }
                                    } else
                                        anInt2820 = arg2.method469(65280);
                                } else {
                                    anInt2836 = arg2.method469(arg1 + 65373);
                                    anInt2818 = arg2.method468(false);
                                }
                            } else
                                anInt2828 = arg2.method491(-4750);
                        } else
                            anInt2795 = 1;
                    } else {
                        anInt2810 = arg2.method469(65280);
                        if (anInt2810 > 32767)
                            anInt2810 -= 65536;
                    }
                } else {
                    anInt2806 = arg2.method469(arg1 ^ ~0xff5c);
                    if ((anInt2806 ^ 0xffffffff) < -32768)
                        anInt2806 -= 65536;
                }
            } else
                anInt2830 = arg2.method469(65280);
        } else
            anInt2817 = arg2.method469(65280);
        anInt2802++;
        if (arg1 != -93)
            anInt2841 = -84;
    }

    public void readValues(Buffer arg0, int arg1) {
        try {
            anInt2821++;
            if (arg1 != -1)
                anInt2817 = 23;
            for (; ; ) {
                int i = arg0.method468(false);
                if ((i ^ 0xffffffff) == -1)
                    break;
                readValue(i, arg1 ^ 0x5c, arg0);
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("ta.P(" + (arg0 != null ? "{...}" : "null")
                            + ',' + arg1 + ')'));
        }
    }

    public void itemToNote(ItemDefinition noteTemplate, ItemDefinition note) {
        try {
            anInt2844 = noteTemplate.anInt2844;
            anInt2806 = noteTemplate.anInt2806;
            anInt2827 = noteTemplate.anInt2827;
            aClass1_2796 = note.aClass1_2796;
            anInt2835++;
            anInt2828 = note.anInt2828;
            anInt2795 = 1;
            anInt2817 = noteTemplate.anInt2817;
            aBoolean2849 = note.aBoolean2849;
            anIntArray2816 = noteTemplate.anIntArray2816;
            anIntArray2803 = noteTemplate.anIntArray2803;
            anInt2830 = noteTemplate.anInt2830;
            anInt2810 = noteTemplate.anInt2810;
            anInt2805 = noteTemplate.anInt2805;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ItemDefinition.itemToNote(" + (noteTemplate != null ? "{...}" : "null") + (note != null ? "{...}" : "null") + ')'));
        }
    }

    public Model method753(boolean arg0, int arg1, int arg2) {
        try {
            if (arg2 != 26910)
                anIntArray2814 = null;
            anInt2842++;
            if (anIntArray2831 != null && arg1 > 1) {
                int i = -1;
                for (int i_19_ = 0; (i_19_ ^ 0xffffffff) > -11; i_19_++) {
                    if (arg1 >= anIntArray2834[i_19_]
                            && (anIntArray2834[i_19_] ^ 0xffffffff) != -1)
                        i = anIntArray2831[i_19_];
                }
                if (i != -1)
                    return Class44.method897(i, 10).method753(arg0, 1, 26910);
            }
            if (arg0) {
                Model class40_sub5_sub17_sub5
                        = ((Model)
                        Class62.aClass9_1455.method231((long) anInt2852,
                                (byte) 87));
                if (class40_sub5_sub17_sub5 != null)
                    return class40_sub5_sub17_sub5;
            }
            Model class40_sub5_sub17_sub5
                    = Model.method830(Class8.aClass6_284,
                    anInt2805, 0);
            if (class40_sub5_sub17_sub5 == null)
                return null;
            if ((anInt2813 ^ 0xffffffff) != -129 || anInt2853 != 128
                    || anInt2833 != 128)
                class40_sub5_sub17_sub5.method821(anInt2813, anInt2853,
                        anInt2833);
            if (anIntArray2803 != null) {
                for (int i = 0; i < anIntArray2803.length; i++)
                    class40_sub5_sub17_sub5.method803(anIntArray2803[i],
                            anIntArray2816[i]);
            }
            if (arg0) {
                class40_sub5_sub17_sub5.method802(anInt2825 + 64,
                        768 + anInt2840, -50, -10,
                        -50, true);
                class40_sub5_sub17_sub5.aBoolean3164 = true;
                Class62.aClass9_1455.method230(-7208, (long) anInt2852,
                        class40_sub5_sub17_sub5);
            }
            return class40_sub5_sub17_sub5;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("ta.J(" + arg0 + ',' + arg1 + ',' + arg2
                            + ')'));
        }
    }
}
