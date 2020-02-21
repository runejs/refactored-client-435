/* Class40_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class Class40_Sub2 extends Node {
    public static RSString aClass1_1991;
    public static int anInt1992;
    public static RSString aClass1_1995
            = Class58.method978(-11538, "Lade Spiel)2Fenster )2 ");
    public static int anInt1996 = 0;
    public static int anInt1998;
    public static int anInt1999;
    public static int anInt2004;
    public static int anInt2006;
    public static RSString aClass1_2008;
    public static int anInt2009;

    static {
        aClass1_1991
                = Class58.method978(-11538, "Ung-Ultiges Anmelde)2Paket)3");
        aClass1_2008
                = (Class58.method978
                (-11538,
                        "Ihre Ignorieren)2Liste ist voll)1 Sie k-Onnen nur 100 Spieler darauf eintragen)3"));
    }

    public int anInt1993;
    public int anInt1994;
    public int anInt1997;
    public int anInt2000;
    public Class40_Sub9_Sub2 aClass40_Sub9_Sub2_2001;
    public int anInt2002;
    public int anInt2003;
    public int[] anIntArray2005;
    public int anInt2007;
    public Class40_Sub9_Sub2 aClass40_Sub9_Sub2_2010;
    public Class40_Sub5_Sub8 aClass40_Sub5_Sub8_2011;
    public int anInt2012;
    public int anInt2013;
    public int anInt2014;

    public static void method522(int arg0, int arg1, byte arg2) {
        try {
            anInt2006++;
            Class40_Sub5_Sub4 class40_sub5_sub4 = Class34.method417(0, arg1);
            int i = class40_sub5_sub4.anInt2368;
            int i_0_ = class40_sub5_sub4.anInt2358;
            int i_1_ = class40_sub5_sub4.anInt2370;
            int i_2_ = -115 % ((arg2 - 46) / 57);
            int i_3_ = Class68_Sub1.anIntArray2199[i_1_ + -i];
            if ((arg0 ^ 0xffffffff) > -1
                    || (i_3_ ^ 0xffffffff) > (arg0 ^ 0xffffffff))
                arg0 = 0;
            i_3_ <<= i;
            Class58.varbitmasks[i_0_]
                    = (Class40_Sub5_Sub9.method619
                    (Class66.method1021(Class58.varbitmasks[i_0_],
                            i_3_ ^ 0xffffffff),
                            Class66.method1021(i_3_, arg0 << i)));
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("be.B(" + arg0 + ',' + arg1 + ',' + arg2
                            + ')'));
        }
    }

    public static boolean method523(RSString arg0, int arg1) {
        try {
            anInt1992++;
            if (arg0 == null)
                return false;
            for (int i = 0; i < Class40_Sub5_Sub17_Sub3.anInt3060; i++) {
                if (arg0.method63(Class40_Sub11.aClass1Array2147[i], true))
                    return true;
            }
            if (arg1 != -32624)
                aClass1_1991 = null;
            return arg0.method63((Class40_Sub5_Sub13
                            .aClass40_Sub5_Sub17_Sub4_Sub1_2760
                            .aClass1_3278),
                    true);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("be.F(" + (arg0 != null ? "{...}" : "null")
                            + ',' + arg1 + ')'));
        }
    }

    public static void method524(int arg0) {
        try {
            aClass1_1995 = null;
            aClass1_2008 = null;
            if (arg0 != -9019)
                method523(null, -100);
            aClass1_1991 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "be.A(" + arg0 + ')');
        }
    }

    public static int method525(byte[] arg0, int arg1, byte arg2) {
        try {
            anInt2009++;
            if (arg2 != -68)
                return -56;
            return Class67.method1034(true, 0, arg1, arg0);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("be.D(" + (arg0 != null ? "{...}" : "null")
                            + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public static DirectColorSprite[] method526
            (Class6 arg0, int arg1, RSString arg2, RSString arg3) {
        try {
            anInt1998++;
            if (arg1 != 0)
                aClass1_2008 = null;
            int i = arg0.method183(0, arg2);
            int i_4_ = arg0.method179(arg1 ^ ~0x68, i, arg3);
            return Class52.method944((byte) -3, i, arg0, i_4_);
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("be.G(" + (arg0 != null ? "{...}" : "null")
                            + ',' + arg1 + ','
                            + (arg2 != null ? "{...}" : "null") + ','
                            + (arg3 != null ? "{...}" : "null")
                            + ')'));
        }
    }

    public static void method527(int arg0, int arg1, int[] arg2, boolean arg3,
                                 int arg4) {
        try {
            Class19.aClass68_482.method1046((byte) 90);
            anInt1999++;
            Buffer.aClass40_Sub5_Sub14_Sub2_1959.method692(0, 0);
            if (arg3) {
                if (arg2[arg0] != -1) {
                    if (arg0 == 0)
                        Class56.aClass40_Sub5_Sub14_Sub2_1315.method692(22,
                                10);
                    if (arg0 == 1)
                        RSApplet.aClass40_Sub5_Sub14_Sub2_1.method692(54,
                                8);
                    if (arg0 == 2)
                        RSApplet.aClass40_Sub5_Sub14_Sub2_1.method692(82,
                                8);
                    if (arg0 == 3)
                        Class35.aClass40_Sub5_Sub14_Sub2_1744.method692(110,
                                8);
                    if (arg0 == 4)
                        Class53.aClass40_Sub5_Sub14_Sub2_1270.method692(153,
                                8);
                    if ((arg0 ^ 0xffffffff) == -6)
                        Class53.aClass40_Sub5_Sub14_Sub2_1270.method692(181,
                                8);
                    if ((arg0 ^ 0xffffffff) == -7)
                        Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105
                                .method692(209, 9);
                }
                if (arg2[0] != -1 && arg4 != 0)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[0]
                            .method692(29, 13);
                if (arg2[1] != -1 && (arg4 ^ 0xffffffff) != -2)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[1]
                            .method692(53, 11);
                if ((arg2[2] ^ 0xffffffff) != 0 && arg4 != 2)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[2]
                            .method692(82, 11);
                if ((arg2[3] ^ 0xffffffff) != 0 && (arg4 ^ 0xffffffff) != -4)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[3]
                            .method692(115, 12);
                if ((arg2[4] ^ 0xffffffff) != 0 && arg4 != 4)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[4]
                            .method692(153, 13);
                if (arg2[5] != -1 && (arg4 ^ 0xffffffff) != -6)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[5]
                            .method692(180, 11);
                if (arg2[6] != -1 && arg4 != 6)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[6]
                            .method692(208, 13);
            }
            RSCanvas.aClass68_59.method1046((byte) 90);
            Class56.aClass40_Sub5_Sub14_Sub2_1329.method692(0, 0);
            if (arg1 != 4)
                method523(null, -128);
            if (arg3) {
                if ((arg2[arg0] ^ 0xffffffff) != 0) {
                    if (arg0 == 7)
                        Class40_Sub5_Sub17.aClass40_Sub5_Sub14_Sub2_2860
                                .method692(42, 0);
                    if (arg0 == 8)
                        HashTable.aClass40_Sub5_Sub14_Sub2_549.method692(74, 0);
                    if ((arg0 ^ 0xffffffff) == -10)
                        HashTable.aClass40_Sub5_Sub14_Sub2_549.method692(102, 0);
                    if ((arg0 ^ 0xffffffff) == -11)
                        Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919
                                .method692(130, 1);
                    if (arg0 == 11)
                        Class13.aClass40_Sub5_Sub14_Sub2_418.method692(173, 0);
                    if (arg0 == 12)
                        Class13.aClass40_Sub5_Sub14_Sub2_418.method692(201, 0);
                    if (arg0 == 13)
                        ISAAC.aClass40_Sub5_Sub14_Sub2_524.method692(229, 0);
                }
                if ((arg2[8] ^ 0xffffffff) != 0 && arg4 != 8)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[7]
                            .method692(74, 2);
                if (arg2[9] != -1 && arg4 != 9)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[8]
                            .method692(102, 3);
                if ((arg2[10] ^ 0xffffffff) != 0 && (arg4 ^ 0xffffffff) != -11)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[9]
                            .method692(137, 4);
                if ((arg2[11] ^ 0xffffffff) != 0 && (arg4 ^ 0xffffffff) != -12)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776
                            [10].method692(174, 2);
                if ((arg2[12] ^ 0xffffffff) != 0 && (arg4 ^ 0xffffffff) != -13)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776
                            [11].method692(201, 2);
                if (arg2[13] != -1 && (arg4 ^ 0xffffffff) != -14)
                    Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776
                            [12].method692(226, 2);
            }
            try {
                Graphics graphics = Class62.aCanvas1469.getGraphics();
                Class19.aClass68_482.method1044(0, 516, graphics, 160);
                RSCanvas.aClass68_59.method1044(0, 496, graphics, 466);
            } catch (Exception exception) {
                Class62.aCanvas1469.repaint();
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("be.E(" + arg0 + ',' + arg1 + ','
                            + (arg2 != null ? "{...}" : "null") + ','
                            + arg3 + ',' + arg4 + ')'));
        }
    }

    public void method528(int arg0) {
        int i = anInt1997;
        int i_5_ = 37 % ((arg0 - -55) / 54);
        Class40_Sub5_Sub8 class40_sub5_sub8
                = aClass40_Sub5_Sub8_2011.method611(-20);
        if (class40_sub5_sub8 == null) {
            anInt2000 = 0;
            anInt2012 = 0;
            anInt2002 = 0;
            anIntArray2005 = null;
            anInt1997 = -1;
        } else {
            anInt2000 = 128 * class40_sub5_sub8.anInt2502;
            anInt2012 = class40_sub5_sub8.anInt2499;
            anInt2002 = class40_sub5_sub8.anInt2542;
            anInt1997 = class40_sub5_sub8.anInt2513;
            anIntArray2005 = class40_sub5_sub8.anIntArray2523;
        }
        anInt2004++;
        if (i != anInt1997 && aClass40_Sub9_Sub2_2001 != null) {
            Class49.aClass40_Sub9_Sub1_1152.method853(aClass40_Sub9_Sub2_2001);
            aClass40_Sub9_Sub2_2001 = null;
        }
    }
}
