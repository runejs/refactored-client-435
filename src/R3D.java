/* Class40_Sub5_Sub14_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class R3D extends Rasterizer {
    public static int[] anIntArray2929 = new int[2048];
    public static int anInt2930;
    public static int anInt2931;
    public static int[] anIntArray2932;
    public static int anInt2933;
    public static int anInt2934;
    public static int anInt2935;
    public static boolean aBoolean2936 = false;
    public static int anInt2937;
    public static int[] anIntArray2938;
    public static Interface3 anInterface3_2939;
    public static int[] anIntArray2940;
    public static int anInt2941;
    public static int anInt2942;
    public static int[] sinetable = new int[2048];
    public static boolean aBoolean2944;
    public static int anInt2945;
    public static int[] cosinetable;
    public static boolean aBoolean2947;
    public static boolean aBoolean2948;

    static {
        anInt2933 = 0;
        anIntArray2932 = new int[65536];
        aBoolean2944 = true;
        anIntArray2940 = new int[512];
        cosinetable = new int[2048];
        aBoolean2947 = false;
        aBoolean2948 = false;
        for (int i = 1; i < 512; i++)
            anIntArray2940[i] = 32768 / i;
        for (int i = 1; i < 2048; i++)
            anIntArray2929[i] = 65536 / i;
        for (int i = 0; i < 2048; i++) {
            sinetable[i]
                    = (int) (65536.0 * Math.sin((double) i * 0.0030679615));
            cosinetable[i]
                    = (int) (65536.0 * Math.cos((double) i * 0.0030679615));
        }
    }

    public static void method698(int[] arg0, int arg1, int arg2, int arg3,
                                 int arg4, int arg5) {
        if (aBoolean2947) {
            if (arg5 > anInt2945)
                arg5 = anInt2945;
            if (arg4 < 0)
                arg4 = 0;
        }
        if (arg4 < arg5) {
            arg1 += arg4;
            arg3 = arg5 - arg4 >> 2;
            if (anInt2933 == 0) {
                while (--arg3 >= 0) {
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                }
                arg3 = arg5 - arg4 & 0x3;
                while (--arg3 >= 0)
                    arg0[arg1++] = arg2;
            } else {
                int i = anInt2933;
                int i_0_ = 256 - anInt2933;
                arg2 = (((arg2 & 0xff00ff) * i_0_ >> 8 & 0xff00ff)
                        + ((arg2 & 0xff00) * i_0_ >> 8 & 0xff00));
                while (--arg3 >= 0) {
                    arg0[arg1++]
                            = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                }
                arg3 = arg5 - arg4 & 0x3;
                while (--arg3 >= 0)
                    arg0[arg1++]
                            = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
            }
        }
    }

    public static void method699
            (int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
             int arg7, int arg8, int arg9, int arg10, int arg11, int arg12,
             int arg13, int arg14, int arg15, int arg16, int arg17, int arg18) {
        int[] is = anInterface3_2939.method12(56, arg18);
        if (is == null) {
            int i = anInterface3_2939.method14(true, arg18);
            method706(arg0, arg1, arg2, arg3, arg4, arg5, method709(i, arg6),
                    method709(i, arg7), method709(i, arg8));
        } else {
            aBoolean2948 = anInterface3_2939.method15(arg18, (byte) -90);
            aBoolean2936 = anInterface3_2939.method13((byte) -109, arg18);
            arg10 = arg9 - arg10;
            arg13 = arg12 - arg13;
            arg16 = arg15 - arg16;
            arg11 -= arg9;
            arg14 -= arg12;
            arg17 -= arg15;
            int i = arg11 * arg12 - arg14 * arg9 << 14;
            int i_1_ = arg14 * arg15 - arg17 * arg12 << 8;
            int i_2_ = arg17 * arg9 - arg11 * arg15 << 5;
            int i_3_ = arg10 * arg12 - arg13 * arg9 << 14;
            int i_4_ = arg13 * arg15 - arg16 * arg12 << 8;
            int i_5_ = arg16 * arg9 - arg10 * arg15 << 5;
            int i_6_ = arg13 * arg11 - arg10 * arg14 << 14;
            int i_7_ = arg16 * arg14 - arg13 * arg17 << 8;
            int i_8_ = arg10 * arg17 - arg16 * arg11 << 5;
            int i_9_ = 0;
            int i_10_ = 0;
            if (arg1 != arg0) {
                i_9_ = (arg4 - arg3 << 16) / (arg1 - arg0);
                i_10_ = (arg7 - arg6 << 16) / (arg1 - arg0);
            }
            int i_11_ = 0;
            int i_12_ = 0;
            if (arg2 != arg1) {
                i_11_ = (arg5 - arg4 << 16) / (arg2 - arg1);
                i_12_ = (arg8 - arg7 << 16) / (arg2 - arg1);
            }
            int i_13_ = 0;
            int i_14_ = 0;
            if (arg2 != arg0) {
                i_13_ = (arg3 - arg5 << 16) / (arg0 - arg2);
                i_14_ = (arg6 - arg8 << 16) / (arg0 - arg2);
            }
            if (arg0 <= arg1 && arg0 <= arg2) {
                if (arg0 < anInt2930) {
                    if (arg1 > anInt2930)
                        arg1 = anInt2930;
                    if (arg2 > anInt2930)
                        arg2 = anInt2930;
                    if (arg1 < arg2) {
                        arg5 = arg3 <<= 16;
                        arg8 = arg6 <<= 16;
                        if (arg0 < 0) {
                            arg5 -= i_13_ * arg0;
                            arg3 -= i_9_ * arg0;
                            arg8 -= i_14_ * arg0;
                            arg6 -= i_10_ * arg0;
                            arg0 = 0;
                        }
                        arg4 <<= 16;
                        arg7 <<= 16;
                        if (arg1 < 0) {
                            arg4 -= i_11_ * arg1;
                            arg7 -= i_12_ * arg1;
                            arg1 = 0;
                        }
                        int i_15_ = arg0 - anInt2931;
                        i += i_2_ * i_15_;
                        i_3_ += i_5_ * i_15_;
                        i_6_ += i_8_ * i_15_;
                        if (arg0 != arg1 && i_13_ < i_9_
                                || arg0 == arg1 && i_13_ > i_11_) {
                            arg2 -= arg1;
                            arg1 -= arg0;
                            arg0 = anIntArray2938[arg0];
                            while (--arg1 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg5 >> 16,
                                        arg3 >> 16, arg8 >> 8, arg6 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg3 += i_9_;
                                arg8 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg5 >> 16,
                                        arg4 >> 16, arg8 >> 8, arg7 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg4 += i_11_;
                                arg8 += i_14_;
                                arg7 += i_12_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg2 -= arg1;
                            arg1 -= arg0;
                            arg0 = anIntArray2938[arg0];
                            while (--arg1 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg3 >> 16,
                                        arg5 >> 16, arg6 >> 8, arg8 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg3 += i_9_;
                                arg8 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg4 >> 16,
                                        arg5 >> 16, arg7 >> 8, arg8 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg4 += i_11_;
                                arg8 += i_14_;
                                arg7 += i_12_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    } else {
                        arg4 = arg3 <<= 16;
                        arg7 = arg6 <<= 16;
                        if (arg0 < 0) {
                            arg4 -= i_13_ * arg0;
                            arg3 -= i_9_ * arg0;
                            arg7 -= i_14_ * arg0;
                            arg6 -= i_10_ * arg0;
                            arg0 = 0;
                        }
                        arg5 <<= 16;
                        arg8 <<= 16;
                        if (arg2 < 0) {
                            arg5 -= i_11_ * arg2;
                            arg8 -= i_12_ * arg2;
                            arg2 = 0;
                        }
                        int i_16_ = arg0 - anInt2931;
                        i += i_2_ * i_16_;
                        i_3_ += i_5_ * i_16_;
                        i_6_ += i_8_ * i_16_;
                        if (arg0 != arg2 && i_13_ < i_9_
                                || arg0 == arg2 && i_11_ > i_9_) {
                            arg1 -= arg2;
                            arg2 -= arg0;
                            arg0 = anIntArray2938[arg0];
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg4 >> 16,
                                        arg3 >> 16, arg7 >> 8, arg6 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg4 += i_13_;
                                arg3 += i_9_;
                                arg7 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg1 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg5 >> 16,
                                        arg3 >> 16, arg8 >> 8, arg6 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_11_;
                                arg3 += i_9_;
                                arg8 += i_12_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg1 -= arg2;
                            arg2 -= arg0;
                            arg0 = anIntArray2938[arg0];
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg3 >> 16,
                                        arg4 >> 16, arg6 >> 8, arg7 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg4 += i_13_;
                                arg3 += i_9_;
                                arg7 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg1 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg0, arg3 >> 16,
                                        arg5 >> 16, arg6 >> 8, arg8 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_11_;
                                arg3 += i_9_;
                                arg8 += i_12_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    }
                }
            } else if (arg1 <= arg2) {
                if (arg1 < anInt2930) {
                    if (arg2 > anInt2930)
                        arg2 = anInt2930;
                    if (arg0 > anInt2930)
                        arg0 = anInt2930;
                    if (arg2 < arg0) {
                        arg3 = arg4 <<= 16;
                        arg6 = arg7 <<= 16;
                        if (arg1 < 0) {
                            arg3 -= i_9_ * arg1;
                            arg4 -= i_11_ * arg1;
                            arg6 -= i_10_ * arg1;
                            arg7 -= i_12_ * arg1;
                            arg1 = 0;
                        }
                        arg5 <<= 16;
                        arg8 <<= 16;
                        if (arg2 < 0) {
                            arg5 -= i_13_ * arg2;
                            arg8 -= i_14_ * arg2;
                            arg2 = 0;
                        }
                        int i_17_ = arg1 - anInt2931;
                        i += i_2_ * i_17_;
                        i_3_ += i_5_ * i_17_;
                        i_6_ += i_8_ * i_17_;
                        if (arg1 != arg2 && i_9_ < i_11_
                                || arg1 == arg2 && i_9_ > i_13_) {
                            arg0 -= arg2;
                            arg2 -= arg1;
                            arg1 = anIntArray2938[arg1];
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg3 >> 16,
                                        arg4 >> 16, arg6 >> 8, arg7 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg4 += i_11_;
                                arg6 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg0 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg3 >> 16,
                                        arg5 >> 16, arg6 >> 8, arg8 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg5 += i_13_;
                                arg6 += i_10_;
                                arg8 += i_14_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg0 -= arg2;
                            arg2 -= arg1;
                            arg1 = anIntArray2938[arg1];
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg4 >> 16,
                                        arg3 >> 16, arg7 >> 8, arg6 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg4 += i_11_;
                                arg6 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg0 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg5 >> 16,
                                        arg3 >> 16, arg8 >> 8, arg6 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg5 += i_13_;
                                arg6 += i_10_;
                                arg8 += i_14_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    } else {
                        arg5 = arg4 <<= 16;
                        arg8 = arg7 <<= 16;
                        if (arg1 < 0) {
                            arg5 -= i_9_ * arg1;
                            arg4 -= i_11_ * arg1;
                            arg8 -= i_10_ * arg1;
                            arg7 -= i_12_ * arg1;
                            arg1 = 0;
                        }
                        arg3 <<= 16;
                        arg6 <<= 16;
                        if (arg0 < 0) {
                            arg3 -= i_13_ * arg0;
                            arg6 -= i_14_ * arg0;
                            arg0 = 0;
                        }
                        int i_18_ = arg1 - anInt2931;
                        i += i_2_ * i_18_;
                        i_3_ += i_5_ * i_18_;
                        i_6_ += i_8_ * i_18_;
                        if (i_9_ < i_11_) {
                            arg2 -= arg0;
                            arg0 -= arg1;
                            arg1 = anIntArray2938[arg1];
                            while (--arg0 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg5 >> 16,
                                        arg4 >> 16, arg8 >> 8, arg7 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_9_;
                                arg4 += i_11_;
                                arg8 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg3 >> 16,
                                        arg4 >> 16, arg6 >> 8, arg7 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_13_;
                                arg4 += i_11_;
                                arg6 += i_14_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg2 -= arg0;
                            arg0 -= arg1;
                            arg1 = anIntArray2938[arg1];
                            while (--arg0 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg4 >> 16,
                                        arg5 >> 16, arg7 >> 8, arg8 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_9_;
                                arg4 += i_11_;
                                arg8 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while (--arg2 >= 0) {
                                method701(Rasterizer.anIntArray2766,
                                        is, 0, 0, arg1, arg4 >> 16,
                                        arg3 >> 16, arg7 >> 8, arg6 >> 8, i,
                                        i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_13_;
                                arg4 += i_11_;
                                arg6 += i_14_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.anInt2768;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    }
                }
            } else if (arg2 < anInt2930) {
                if (arg0 > anInt2930)
                    arg0 = anInt2930;
                if (arg1 > anInt2930)
                    arg1 = anInt2930;
                if (arg0 < arg1) {
                    arg4 = arg5 <<= 16;
                    arg7 = arg8 <<= 16;
                    if (arg2 < 0) {
                        arg4 -= i_11_ * arg2;
                        arg5 -= i_13_ * arg2;
                        arg7 -= i_12_ * arg2;
                        arg8 -= i_14_ * arg2;
                        arg2 = 0;
                    }
                    arg3 <<= 16;
                    arg6 <<= 16;
                    if (arg0 < 0) {
                        arg3 -= i_9_ * arg0;
                        arg6 -= i_10_ * arg0;
                        arg0 = 0;
                    }
                    int i_19_ = arg2 - anInt2931;
                    i += i_2_ * i_19_;
                    i_3_ += i_5_ * i_19_;
                    i_6_ += i_8_ * i_19_;
                    if (i_11_ < i_13_) {
                        arg1 -= arg0;
                        arg0 -= arg2;
                        arg2 = anIntArray2938[arg2];
                        while (--arg0 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg4 >> 16, arg5 >> 16,
                                    arg7 >> 8, arg8 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg5 += i_13_;
                            arg7 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while (--arg1 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg4 >> 16, arg3 >> 16,
                                    arg7 >> 8, arg6 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg3 += i_9_;
                            arg7 += i_12_;
                            arg6 += i_10_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    } else {
                        arg1 -= arg0;
                        arg0 -= arg2;
                        arg2 = anIntArray2938[arg2];
                        while (--arg0 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg5 >> 16, arg4 >> 16,
                                    arg8 >> 8, arg7 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg5 += i_13_;
                            arg7 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while (--arg1 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg3 >> 16, arg4 >> 16,
                                    arg6 >> 8, arg7 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg3 += i_9_;
                            arg7 += i_12_;
                            arg6 += i_10_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    }
                } else {
                    arg3 = arg5 <<= 16;
                    arg6 = arg8 <<= 16;
                    if (arg2 < 0) {
                        arg3 -= i_11_ * arg2;
                        arg5 -= i_13_ * arg2;
                        arg6 -= i_12_ * arg2;
                        arg8 -= i_14_ * arg2;
                        arg2 = 0;
                    }
                    arg4 <<= 16;
                    arg7 <<= 16;
                    if (arg1 < 0) {
                        arg4 -= i_9_ * arg1;
                        arg7 -= i_10_ * arg1;
                        arg1 = 0;
                    }
                    int i_20_ = arg2 - anInt2931;
                    i += i_2_ * i_20_;
                    i_3_ += i_5_ * i_20_;
                    i_6_ += i_8_ * i_20_;
                    if (i_11_ < i_13_) {
                        arg0 -= arg1;
                        arg1 -= arg2;
                        arg2 = anIntArray2938[arg2];
                        while (--arg1 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg3 >> 16, arg5 >> 16,
                                    arg6 >> 8, arg8 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg3 += i_11_;
                            arg5 += i_13_;
                            arg6 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while (--arg0 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg4 >> 16, arg5 >> 16,
                                    arg7 >> 8, arg8 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg4 += i_9_;
                            arg5 += i_13_;
                            arg7 += i_10_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    } else {
                        arg0 -= arg1;
                        arg1 -= arg2;
                        arg2 = anIntArray2938[arg2];
                        while (--arg1 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg5 >> 16, arg3 >> 16,
                                    arg8 >> 8, arg6 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg3 += i_11_;
                            arg5 += i_13_;
                            arg6 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while (--arg0 >= 0) {
                            method701(Rasterizer.anIntArray2766, is, 0,
                                    0, arg2, arg5 >> 16, arg4 >> 16,
                                    arg8 >> 8, arg7 >> 8, i, i_3_, i_6_,
                                    i_1_, i_4_, i_7_);
                            arg4 += i_9_;
                            arg5 += i_13_;
                            arg7 += i_10_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.anInt2768;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    }
                }
            }
        }
    }

    public static int[] method700(int arg0, int arg1, int arg2, int arg3,
                                  int[] arg4) {
        anInt2945 = arg2 - arg0;
        anInt2930 = arg3 - arg1;
        if (arg4 == null) {
            int i = anInt2930;
            if (i == 0)
                i++;
            anIntArray2938 = new int[i];
            for (int i_21_ = 0; i_21_ < i; i_21_++)
                anIntArray2938[i_21_]
                        = (arg1 + i_21_) * Rasterizer.anInt2768 + arg0;
        } else
            anIntArray2938 = arg4;
        method702();
        return anIntArray2938;
    }

    public static void method701(int[] arg0, int[] arg1, int arg2, int arg3,
                                 int arg4, int arg5, int arg6, int arg7,
                                 int arg8, int arg9, int arg10, int arg11,
                                 int arg12, int arg13, int arg14) {
        if (arg5 < arg6) {
            int i;
            int i_22_;
            if (aBoolean2947) {
                i_22_ = (arg8 - arg7) / (arg6 - arg5);
                if (arg6 > anInt2945)
                    arg6 = anInt2945;
                if (arg5 < 0) {
                    arg7 -= arg5 * i_22_;
                    arg5 = 0;
                }
                if (arg5 >= arg6)
                    return;
                i = arg6 - arg5 >> 3;
                i_22_ <<= 12;
                arg7 <<= 9;
            } else {
                if (arg6 - arg5 > 7) {
                    i = arg6 - arg5 >> 3;
                    i_22_ = (arg8 - arg7) * anIntArray2940[i] >> 6;
                } else {
                    i = 0;
                    i_22_ = 0;
                }
                arg7 <<= 9;
            }
            arg4 += arg5;
            if (aBoolean2948) {
                int i_23_ = 0;
                int i_24_ = 0;
                int i_25_ = arg5 - anInt2937;
                arg9 += (arg12 >> 3) * i_25_;
                arg10 += (arg13 >> 3) * i_25_;
                arg11 += (arg14 >> 3) * i_25_;
                int i_26_ = arg11 >> 12;
                if (i_26_ != 0) {
                    arg2 = arg9 / i_26_;
                    arg3 = arg10 / i_26_;
                    if (arg2 < 0)
                        arg2 = 0;
                    else if (arg2 > 4032)
                        arg2 = 4032;
                }
                arg9 += arg12;
                arg10 += arg13;
                arg11 += arg14;
                i_26_ = arg11 >> 12;
                if (i_26_ != 0) {
                    i_23_ = arg9 / i_26_;
                    i_24_ = arg10 / i_26_;
                    if (i_23_ < 7)
                        i_23_ = 7;
                    else if (i_23_ > 4032)
                        i_23_ = 4032;
                }
                int i_27_ = i_23_ - arg2 >> 3;
                int i_28_ = i_24_ - arg3 >> 3;
                arg2 += (arg7 & 0x600000) >> 3;
                int i_29_ = arg7 >> 23;
                if (aBoolean2936) {
                    while (i-- > 0) {
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 = i_23_;
                        arg3 = i_24_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_26_ = arg11 >> 12;
                        if (i_26_ != 0) {
                            i_23_ = arg9 / i_26_;
                            i_24_ = arg10 / i_26_;
                            if (i_23_ < 7)
                                i_23_ = 7;
                            else if (i_23_ > 4032)
                                i_23_ = 4032;
                        }
                        i_27_ = i_23_ - arg2 >> 3;
                        i_28_ = i_24_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += (arg7 & 0x600000) >> 3;
                        i_29_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while (i-- > 0) {
                        arg0[arg4++]
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                    }
                } else {
                    while (i-- > 0) {
                        int i_30_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if ((i_30_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 = i_23_;
                        arg3 = i_24_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_26_ = arg11 >> 12;
                        if (i_26_ != 0) {
                            i_23_ = arg9 / i_26_;
                            i_24_ = arg10 / i_26_;
                            if (i_23_ < 7)
                                i_23_ = 7;
                            else if (i_23_ > 4032)
                                i_23_ = 4032;
                        }
                        i_27_ = i_23_ - arg2 >> 3;
                        i_28_ = i_24_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += (arg7 & 0x600000) >> 3;
                        i_29_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while (i-- > 0) {
                        int i_31_;
                        if ((i_31_
                                = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_)
                                != 0)
                            arg0[arg4] = i_31_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                    }
                }
            } else {
                int i_32_ = 0;
                int i_33_ = 0;
                int i_34_ = arg5 - anInt2937;
                arg9 += (arg12 >> 3) * i_34_;
                arg10 += (arg13 >> 3) * i_34_;
                arg11 += (arg14 >> 3) * i_34_;
                int i_35_ = arg11 >> 14;
                if (i_35_ != 0) {
                    arg2 = arg9 / i_35_;
                    arg3 = arg10 / i_35_;
                    if (arg2 < 0)
                        arg2 = 0;
                    else if (arg2 > 16256)
                        arg2 = 16256;
                }
                arg9 += arg12;
                arg10 += arg13;
                arg11 += arg14;
                i_35_ = arg11 >> 14;
                if (i_35_ != 0) {
                    i_32_ = arg9 / i_35_;
                    i_33_ = arg10 / i_35_;
                    if (i_32_ < 7)
                        i_32_ = 7;
                    else if (i_32_ > 16256)
                        i_32_ = 16256;
                }
                int i_36_ = i_32_ - arg2 >> 3;
                int i_37_ = i_33_ - arg3 >> 3;
                arg2 += arg7 & 0x600000;
                int i_38_ = arg7 >> 23;
                if (aBoolean2936) {
                    while (i-- > 0) {
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 = i_32_;
                        arg3 = i_33_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_35_ = arg11 >> 14;
                        if (i_35_ != 0) {
                            i_32_ = arg9 / i_35_;
                            i_33_ = arg10 / i_35_;
                            if (i_32_ < 7)
                                i_32_ = 7;
                            else if (i_32_ > 16256)
                                i_32_ = 16256;
                        }
                        i_36_ = i_32_ - arg2 >> 3;
                        i_37_ = i_33_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += arg7 & 0x600000;
                        i_38_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while (i-- > 0) {
                        arg0[arg4++]
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                    }
                } else {
                    while (i-- > 0) {
                        int i_39_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if ((i_39_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 = i_32_;
                        arg3 = i_33_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_35_ = arg11 >> 14;
                        if (i_35_ != 0) {
                            i_32_ = arg9 / i_35_;
                            i_33_ = arg10 / i_35_;
                            if (i_32_ < 7)
                                i_32_ = 7;
                            else if (i_32_ > 16256)
                                i_32_ = 16256;
                        }
                        i_36_ = i_32_ - arg2 >> 3;
                        i_37_ = i_33_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += arg7 & 0x600000;
                        i_38_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while (i-- > 0) {
                        int i_40_;
                        if ((i_40_
                                = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_)
                                != 0)
                            arg0[arg4] = i_40_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                    }
                }
            }
        }
    }

    public static void method702() {
        anInt2937 = anInt2945 / 2;
        anInt2931 = anInt2930 / 2;
        anInt2942 = -anInt2937;
        anInt2934 = anInt2945 - anInt2937;
        anInt2935 = -anInt2931;
        anInt2941 = anInt2930 - anInt2931;
    }

    public static void method703(Interface3 arg0) {
        anInterface3_2939 = arg0;
    }

    public static void method704() {
        anIntArray2938 = null;
        anIntArray2932 = null;
        anInterface3_2939 = null;
        anIntArray2940 = null;
        anIntArray2929 = null;
        sinetable = null;
        cosinetable = null;
    }

    public static void method705(int[] arg0, int arg1, int arg2, int arg3,
                                 int arg4, int arg5, int arg6, int arg7) {
        if (aBoolean2944) {
            int i;
            if (aBoolean2947) {
                if (arg5 - arg4 > 3)
                    i = (arg7 - arg6) / (arg5 - arg4);
                else
                    i = 0;
                if (arg5 > anInt2945)
                    arg5 = anInt2945;
                if (arg4 < 0) {
                    arg6 -= arg4 * i;
                    arg4 = 0;
                }
                if (arg4 >= arg5)
                    return;
                arg1 += arg4;
                arg3 = arg5 - arg4 >> 2;
                i <<= 2;
            } else {
                if (arg4 >= arg5)
                    return;
                arg1 += arg4;
                arg3 = arg5 - arg4 >> 2;
                if (arg3 > 0)
                    i = (arg7 - arg6) * anIntArray2940[arg3] >> 15;
                else
                    i = 0;
            }
            if (anInt2933 == 0) {
                while (--arg3 >= 0) {
                    arg2 = anIntArray2932[arg6 >> 8];
                    arg6 += i;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                }
                arg3 = arg5 - arg4 & 0x3;
                if (arg3 > 0) {
                    arg2 = anIntArray2932[arg6 >> 8];
                    do
                        arg0[arg1++] = arg2;
                    while (--arg3 > 0);
                }
            } else {
                int i_41_ = anInt2933;
                int i_42_ = 256 - anInt2933;
                while (--arg3 >= 0) {
                    arg2 = anIntArray2932[arg6 >> 8];
                    arg6 += i;
                    arg2 = (((arg2 & 0xff00ff) * i_42_ >> 8 & 0xff00ff)
                            + ((arg2 & 0xff00) * i_42_ >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2
                            + ((arg0[arg1] & 0xff00ff) * i_41_ >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i_41_ >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2
                            + ((arg0[arg1] & 0xff00ff) * i_41_ >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i_41_ >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2
                            + ((arg0[arg1] & 0xff00ff) * i_41_ >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i_41_ >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2
                            + ((arg0[arg1] & 0xff00ff) * i_41_ >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i_41_ >> 8 & 0xff00));
                }
                arg3 = arg5 - arg4 & 0x3;
                if (arg3 > 0) {
                    arg2 = anIntArray2932[arg6 >> 8];
                    arg2 = (((arg2 & 0xff00ff) * i_42_ >> 8 & 0xff00ff)
                            + ((arg2 & 0xff00) * i_42_ >> 8 & 0xff00));
                    do
                        arg0[arg1++] = (arg2
                                + ((arg0[arg1] & 0xff00ff) * i_41_ >> 8
                                & 0xff00ff)
                                + ((arg0[arg1] & 0xff00) * i_41_ >> 8
                                & 0xff00));
                    while (--arg3 > 0);
                }
            }
        } else if (arg4 < arg5) {
            int i = (arg7 - arg6) / (arg5 - arg4);
            if (aBoolean2947) {
                if (arg5 > anInt2945)
                    arg5 = anInt2945;
                if (arg4 < 0) {
                    arg6 -= arg4 * i;
                    arg4 = 0;
                }
                if (arg4 >= arg5)
                    return;
            }
            arg1 += arg4;
            arg3 = arg5 - arg4;
            if (anInt2933 == 0) {
                do {
                    arg0[arg1++] = anIntArray2932[arg6 >> 8];
                    arg6 += i;
                } while (--arg3 > 0);
            } else {
                int i_43_ = anInt2933;
                int i_44_ = 256 - anInt2933;
                do {
                    arg2 = anIntArray2932[arg6 >> 8];
                    arg6 += i;
                    arg2 = (((arg2 & 0xff00ff) * i_44_ >> 8 & 0xff00ff)
                            + ((arg2 & 0xff00) * i_44_ >> 8 & 0xff00));
                    arg0[arg1++]
                            = (arg2
                            + ((arg0[arg1] & 0xff00ff) * i_43_ >> 8 & 0xff00ff)
                            + ((arg0[arg1] & 0xff00) * i_43_ >> 8 & 0xff00));
                } while (--arg3 > 0);
            }
        }
    }

    public static void method706(int arg0, int arg1, int arg2, int arg3,
                                 int arg4, int arg5, int arg6, int arg7,
                                 int arg8) {
        int i = 0;
        int i_45_ = 0;
        if (arg1 != arg0) {
            i = (arg4 - arg3 << 16) / (arg1 - arg0);
            i_45_ = (arg7 - arg6 << 15) / (arg1 - arg0);
        }
        int i_46_ = 0;
        int i_47_ = 0;
        if (arg2 != arg1) {
            i_46_ = (arg5 - arg4 << 16) / (arg2 - arg1);
            i_47_ = (arg8 - arg7 << 15) / (arg2 - arg1);
        }
        int i_48_ = 0;
        int i_49_ = 0;
        if (arg2 != arg0) {
            i_48_ = (arg3 - arg5 << 16) / (arg0 - arg2);
            i_49_ = (arg6 - arg8 << 15) / (arg0 - arg2);
        }
        if (arg0 <= arg1 && arg0 <= arg2) {
            if (arg0 < anInt2930) {
                if (arg1 > anInt2930)
                    arg1 = anInt2930;
                if (arg2 > anInt2930)
                    arg2 = anInt2930;
                if (arg1 < arg2) {
                    arg5 = arg3 <<= 16;
                    arg8 = arg6 <<= 15;
                    if (arg0 < 0) {
                        arg5 -= i_48_ * arg0;
                        arg3 -= i * arg0;
                        arg8 -= i_49_ * arg0;
                        arg6 -= i_45_ * arg0;
                        arg0 = 0;
                    }
                    arg4 <<= 16;
                    arg7 <<= 15;
                    if (arg1 < 0) {
                        arg4 -= i_46_ * arg1;
                        arg7 -= i_47_ * arg1;
                        arg1 = 0;
                    }
                    if (arg0 != arg1 && i_48_ < i
                            || arg0 == arg1 && i_48_ > i_46_) {
                        arg2 -= arg1;
                        arg1 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg1 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
                                    arg6 >> 7);
                            arg5 += i_48_;
                            arg3 += i;
                            arg8 += i_49_;
                            arg6 += i_45_;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg5 >> 16, arg4 >> 16, arg8 >> 7,
                                    arg7 >> 7);
                            arg5 += i_48_;
                            arg4 += i_46_;
                            arg8 += i_49_;
                            arg7 += i_47_;
                            arg0 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg2 -= arg1;
                        arg1 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg1 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
                                    arg8 >> 7);
                            arg5 += i_48_;
                            arg3 += i;
                            arg8 += i_49_;
                            arg6 += i_45_;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg4 >> 16, arg5 >> 16, arg7 >> 7,
                                    arg8 >> 7);
                            arg5 += i_48_;
                            arg4 += i_46_;
                            arg8 += i_49_;
                            arg7 += i_47_;
                            arg0 += Rasterizer.anInt2768;
                        }
                    }
                } else {
                    arg4 = arg3 <<= 16;
                    arg7 = arg6 <<= 15;
                    if (arg0 < 0) {
                        arg4 -= i_48_ * arg0;
                        arg3 -= i * arg0;
                        arg7 -= i_49_ * arg0;
                        arg6 -= i_45_ * arg0;
                        arg0 = 0;
                    }
                    arg5 <<= 16;
                    arg8 <<= 15;
                    if (arg2 < 0) {
                        arg5 -= i_46_ * arg2;
                        arg8 -= i_47_ * arg2;
                        arg2 = 0;
                    }
                    if (arg0 != arg2 && i_48_ < i
                            || arg0 == arg2 && i_46_ > i) {
                        arg1 -= arg2;
                        arg2 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
                                    arg6 >> 7);
                            arg4 += i_48_;
                            arg3 += i;
                            arg7 += i_49_;
                            arg6 += i_45_;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg1 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
                                    arg6 >> 7);
                            arg5 += i_46_;
                            arg3 += i;
                            arg8 += i_47_;
                            arg6 += i_45_;
                            arg0 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg1 -= arg2;
                        arg2 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
                                    arg7 >> 7);
                            arg4 += i_48_;
                            arg3 += i;
                            arg7 += i_49_;
                            arg6 += i_45_;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg1 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg0,
                                    0, 0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
                                    arg8 >> 7);
                            arg5 += i_46_;
                            arg3 += i;
                            arg8 += i_47_;
                            arg6 += i_45_;
                            arg0 += Rasterizer.anInt2768;
                        }
                    }
                }
            }
        } else if (arg1 <= arg2) {
            if (arg1 < anInt2930) {
                if (arg2 > anInt2930)
                    arg2 = anInt2930;
                if (arg0 > anInt2930)
                    arg0 = anInt2930;
                if (arg2 < arg0) {
                    arg3 = arg4 <<= 16;
                    arg6 = arg7 <<= 15;
                    if (arg1 < 0) {
                        arg3 -= i * arg1;
                        arg4 -= i_46_ * arg1;
                        arg6 -= i_45_ * arg1;
                        arg7 -= i_47_ * arg1;
                        arg1 = 0;
                    }
                    arg5 <<= 16;
                    arg8 <<= 15;
                    if (arg2 < 0) {
                        arg5 -= i_48_ * arg2;
                        arg8 -= i_49_ * arg2;
                        arg2 = 0;
                    }
                    if (arg1 != arg2 && i < i_46_
                            || arg1 == arg2 && i > i_48_) {
                        arg0 -= arg2;
                        arg2 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
                                    arg7 >> 7);
                            arg3 += i;
                            arg4 += i_46_;
                            arg6 += i_45_;
                            arg7 += i_47_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg0 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
                                    arg8 >> 7);
                            arg3 += i;
                            arg5 += i_48_;
                            arg6 += i_45_;
                            arg8 += i_49_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg0 -= arg2;
                        arg2 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
                                    arg6 >> 7);
                            arg3 += i;
                            arg4 += i_46_;
                            arg6 += i_45_;
                            arg7 += i_47_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg0 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
                                    arg6 >> 7);
                            arg3 += i;
                            arg5 += i_48_;
                            arg6 += i_45_;
                            arg8 += i_49_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    }
                } else {
                    arg5 = arg4 <<= 16;
                    arg8 = arg7 <<= 15;
                    if (arg1 < 0) {
                        arg5 -= i * arg1;
                        arg4 -= i_46_ * arg1;
                        arg8 -= i_45_ * arg1;
                        arg7 -= i_47_ * arg1;
                        arg1 = 0;
                    }
                    arg3 <<= 16;
                    arg6 <<= 15;
                    if (arg0 < 0) {
                        arg3 -= i_48_ * arg0;
                        arg6 -= i_49_ * arg0;
                        arg0 = 0;
                    }
                    if (i < i_46_) {
                        arg2 -= arg0;
                        arg0 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg0 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg5 >> 16, arg4 >> 16, arg8 >> 7,
                                    arg7 >> 7);
                            arg5 += i;
                            arg4 += i_46_;
                            arg8 += i_45_;
                            arg7 += i_47_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
                                    arg7 >> 7);
                            arg3 += i_48_;
                            arg4 += i_46_;
                            arg6 += i_49_;
                            arg7 += i_47_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg2 -= arg0;
                        arg0 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg0 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg4 >> 16, arg5 >> 16, arg7 >> 7,
                                    arg8 >> 7);
                            arg5 += i;
                            arg4 += i_46_;
                            arg8 += i_45_;
                            arg7 += i_47_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method705(Rasterizer.anIntArray2766, arg1,
                                    0, 0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
                                    arg6 >> 7);
                            arg3 += i_48_;
                            arg4 += i_46_;
                            arg6 += i_49_;
                            arg7 += i_47_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    }
                }
            }
        } else if (arg2 < anInt2930) {
            if (arg0 > anInt2930)
                arg0 = anInt2930;
            if (arg1 > anInt2930)
                arg1 = anInt2930;
            if (arg0 < arg1) {
                arg4 = arg5 <<= 16;
                arg7 = arg8 <<= 15;
                if (arg2 < 0) {
                    arg4 -= i_46_ * arg2;
                    arg5 -= i_48_ * arg2;
                    arg7 -= i_47_ * arg2;
                    arg8 -= i_49_ * arg2;
                    arg2 = 0;
                }
                arg3 <<= 16;
                arg6 <<= 15;
                if (arg0 < 0) {
                    arg3 -= i * arg0;
                    arg6 -= i_45_ * arg0;
                    arg0 = 0;
                }
                if (i_46_ < i_48_) {
                    arg1 -= arg0;
                    arg0 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg0 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg4 >> 16, arg5 >> 16, arg7 >> 7,
                                arg8 >> 7);
                        arg4 += i_46_;
                        arg5 += i_48_;
                        arg7 += i_47_;
                        arg8 += i_49_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg1 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg4 >> 16, arg3 >> 16, arg7 >> 7,
                                arg6 >> 7);
                        arg4 += i_46_;
                        arg3 += i;
                        arg7 += i_47_;
                        arg6 += i_45_;
                        arg2 += Rasterizer.anInt2768;
                    }
                } else {
                    arg1 -= arg0;
                    arg0 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg0 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg5 >> 16, arg4 >> 16, arg8 >> 7,
                                arg7 >> 7);
                        arg4 += i_46_;
                        arg5 += i_48_;
                        arg7 += i_47_;
                        arg8 += i_49_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg1 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg3 >> 16, arg4 >> 16, arg6 >> 7,
                                arg7 >> 7);
                        arg4 += i_46_;
                        arg3 += i;
                        arg7 += i_47_;
                        arg6 += i_45_;
                        arg2 += Rasterizer.anInt2768;
                    }
                }
            } else {
                arg3 = arg5 <<= 16;
                arg6 = arg8 <<= 15;
                if (arg2 < 0) {
                    arg3 -= i_46_ * arg2;
                    arg5 -= i_48_ * arg2;
                    arg6 -= i_47_ * arg2;
                    arg8 -= i_49_ * arg2;
                    arg2 = 0;
                }
                arg4 <<= 16;
                arg7 <<= 15;
                if (arg1 < 0) {
                    arg4 -= i * arg1;
                    arg7 -= i_45_ * arg1;
                    arg1 = 0;
                }
                if (i_46_ < i_48_) {
                    arg0 -= arg1;
                    arg1 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg1 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg3 >> 16, arg5 >> 16, arg6 >> 7,
                                arg8 >> 7);
                        arg3 += i_46_;
                        arg5 += i_48_;
                        arg6 += i_47_;
                        arg8 += i_49_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg0 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg4 >> 16, arg5 >> 16, arg7 >> 7,
                                arg8 >> 7);
                        arg4 += i;
                        arg5 += i_48_;
                        arg7 += i_45_;
                        arg8 += i_49_;
                        arg2 += Rasterizer.anInt2768;
                    }
                } else {
                    arg0 -= arg1;
                    arg1 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg1 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg5 >> 16, arg3 >> 16, arg8 >> 7,
                                arg6 >> 7);
                        arg3 += i_46_;
                        arg5 += i_48_;
                        arg6 += i_47_;
                        arg8 += i_49_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg0 >= 0) {
                        method705(Rasterizer.anIntArray2766, arg2, 0,
                                0, arg5 >> 16, arg4 >> 16, arg8 >> 7,
                                arg7 >> 7);
                        arg4 += i;
                        arg5 += i_48_;
                        arg7 += i_45_;
                        arg8 += i_49_;
                        arg2 += Rasterizer.anInt2768;
                    }
                }
            }
        }
    }

    public static int method707(int arg0, double arg1) {
        double d = (double) (arg0 >> 16) / 256.0;
        double d_50_ = (double) (arg0 >> 8 & 0xff) / 256.0;
        double d_51_ = (double) (arg0 & 0xff) / 256.0;
        d = Math.pow(d, arg1);
        d_50_ = Math.pow(d_50_, arg1);
        d_51_ = Math.pow(d_51_, arg1);
        int i = (int) (d * 256.0);
        int i_52_ = (int) (d_50_ * 256.0);
        int i_53_ = (int) (d_51_ * 256.0);
        return (i << 16) + (i_52_ << 8) + i_53_;
    }

    public static int[] method708(int[] arg0) {
        return method700(Rasterizer.anInt2771,
                Rasterizer.anInt2767,
                Rasterizer.anInt2772,
                Rasterizer.anInt2770, arg0);
    }

    public static int method709(int arg0, int arg1) {
        arg1 = (127 - arg1) * (arg0 & 0x7f) >> 7;
        if (arg1 < 2)
            arg1 = 2;
        else if (arg1 > 126)
            arg1 = 126;
        return (arg0 & 0xff80) + arg1;
    }

    public static void method710(int arg0, int arg1) {
        int i = anIntArray2938[0];
        int i_54_ = i / Rasterizer.anInt2768;
        int i_55_ = i - i_54_ * Rasterizer.anInt2768;
        anInt2937 = arg0 - i_55_;
        anInt2931 = arg1 - i_54_;
        anInt2942 = -anInt2937;
        anInt2934 = anInt2945 - anInt2937;
        anInt2935 = -anInt2931;
        anInt2941 = anInt2930 - anInt2931;
    }

    public static void method711(double arg0) {
        method714(arg0, 0, 512);
    }

    public static void method712(int arg0, int arg1, int arg2, int arg3,
                                 int arg4, int arg5, int arg6) {
        int i = 0;
        if (arg1 != arg0)
            i = (arg4 - arg3 << 16) / (arg1 - arg0);
        int i_56_ = 0;
        if (arg2 != arg1)
            i_56_ = (arg5 - arg4 << 16) / (arg2 - arg1);
        int i_57_ = 0;
        if (arg2 != arg0)
            i_57_ = (arg3 - arg5 << 16) / (arg0 - arg2);
        if (arg0 <= arg1 && arg0 <= arg2) {
            if (arg0 < anInt2930) {
                if (arg1 > anInt2930)
                    arg1 = anInt2930;
                if (arg2 > anInt2930)
                    arg2 = anInt2930;
                if (arg1 < arg2) {
                    arg5 = arg3 <<= 16;
                    if (arg0 < 0) {
                        arg5 -= i_57_ * arg0;
                        arg3 -= i * arg0;
                        arg0 = 0;
                    }
                    arg4 <<= 16;
                    if (arg1 < 0) {
                        arg4 -= i_56_ * arg1;
                        arg1 = 0;
                    }
                    if (arg0 != arg1 && i_57_ < i
                            || arg0 == arg1 && i_57_ > i_56_) {
                        arg2 -= arg1;
                        arg1 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg1 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg5 >> 16, arg3 >> 16);
                            arg5 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg5 >> 16, arg4 >> 16);
                            arg5 += i_57_;
                            arg4 += i_56_;
                            arg0 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg2 -= arg1;
                        arg1 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg1 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg3 >> 16, arg5 >> 16);
                            arg5 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg4 >> 16, arg5 >> 16);
                            arg5 += i_57_;
                            arg4 += i_56_;
                            arg0 += Rasterizer.anInt2768;
                        }
                    }
                } else {
                    arg4 = arg3 <<= 16;
                    if (arg0 < 0) {
                        arg4 -= i_57_ * arg0;
                        arg3 -= i * arg0;
                        arg0 = 0;
                    }
                    arg5 <<= 16;
                    if (arg2 < 0) {
                        arg5 -= i_56_ * arg2;
                        arg2 = 0;
                    }
                    if (arg0 != arg2 && i_57_ < i
                            || arg0 == arg2 && i_56_ > i) {
                        arg1 -= arg2;
                        arg2 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg4 >> 16, arg3 >> 16);
                            arg4 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg1 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg5 >> 16, arg3 >> 16);
                            arg5 += i_56_;
                            arg3 += i;
                            arg0 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg1 -= arg2;
                        arg2 -= arg0;
                        arg0 = anIntArray2938[arg0];
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg3 >> 16, arg4 >> 16);
                            arg4 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.anInt2768;
                        }
                        while (--arg1 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg0,
                                    arg6, 0, arg3 >> 16, arg5 >> 16);
                            arg5 += i_56_;
                            arg3 += i;
                            arg0 += Rasterizer.anInt2768;
                        }
                    }
                }
            }
        } else if (arg1 <= arg2) {
            if (arg1 < anInt2930) {
                if (arg2 > anInt2930)
                    arg2 = anInt2930;
                if (arg0 > anInt2930)
                    arg0 = anInt2930;
                if (arg2 < arg0) {
                    arg3 = arg4 <<= 16;
                    if (arg1 < 0) {
                        arg3 -= i * arg1;
                        arg4 -= i_56_ * arg1;
                        arg1 = 0;
                    }
                    arg5 <<= 16;
                    if (arg2 < 0) {
                        arg5 -= i_57_ * arg2;
                        arg2 = 0;
                    }
                    if (arg1 != arg2 && i < i_56_
                            || arg1 == arg2 && i > i_57_) {
                        arg0 -= arg2;
                        arg2 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg3 >> 16, arg4 >> 16);
                            arg3 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg0 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg3 >> 16, arg5 >> 16);
                            arg3 += i;
                            arg5 += i_57_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg0 -= arg2;
                        arg2 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg4 >> 16, arg3 >> 16);
                            arg3 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg0 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg5 >> 16, arg3 >> 16);
                            arg3 += i;
                            arg5 += i_57_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    }
                } else {
                    arg5 = arg4 <<= 16;
                    if (arg1 < 0) {
                        arg5 -= i * arg1;
                        arg4 -= i_56_ * arg1;
                        arg1 = 0;
                    }
                    arg3 <<= 16;
                    if (arg0 < 0) {
                        arg3 -= i_57_ * arg0;
                        arg0 = 0;
                    }
                    if (i < i_56_) {
                        arg2 -= arg0;
                        arg0 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg0 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg5 >> 16, arg4 >> 16);
                            arg5 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg3 >> 16, arg4 >> 16);
                            arg3 += i_57_;
                            arg4 += i_56_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    } else {
                        arg2 -= arg0;
                        arg0 -= arg1;
                        arg1 = anIntArray2938[arg1];
                        while (--arg0 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg4 >> 16, arg5 >> 16);
                            arg5 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.anInt2768;
                        }
                        while (--arg2 >= 0) {
                            method698(Rasterizer.anIntArray2766, arg1,
                                    arg6, 0, arg4 >> 16, arg3 >> 16);
                            arg3 += i_57_;
                            arg4 += i_56_;
                            arg1 += Rasterizer.anInt2768;
                        }
                    }
                }
            }
        } else if (arg2 < anInt2930) {
            if (arg0 > anInt2930)
                arg0 = anInt2930;
            if (arg1 > anInt2930)
                arg1 = anInt2930;
            if (arg0 < arg1) {
                arg4 = arg5 <<= 16;
                if (arg2 < 0) {
                    arg4 -= i_56_ * arg2;
                    arg5 -= i_57_ * arg2;
                    arg2 = 0;
                }
                arg3 <<= 16;
                if (arg0 < 0) {
                    arg3 -= i * arg0;
                    arg0 = 0;
                }
                if (i_56_ < i_57_) {
                    arg1 -= arg0;
                    arg0 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg0 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg4 >> 16, arg5 >> 16);
                        arg4 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg1 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg4 >> 16, arg3 >> 16);
                        arg4 += i_56_;
                        arg3 += i;
                        arg2 += Rasterizer.anInt2768;
                    }
                } else {
                    arg1 -= arg0;
                    arg0 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg0 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg5 >> 16, arg4 >> 16);
                        arg4 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg1 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg3 >> 16, arg4 >> 16);
                        arg4 += i_56_;
                        arg3 += i;
                        arg2 += Rasterizer.anInt2768;
                    }
                }
            } else {
                arg3 = arg5 <<= 16;
                if (arg2 < 0) {
                    arg3 -= i_56_ * arg2;
                    arg5 -= i_57_ * arg2;
                    arg2 = 0;
                }
                arg4 <<= 16;
                if (arg1 < 0) {
                    arg4 -= i * arg1;
                    arg1 = 0;
                }
                if (i_56_ < i_57_) {
                    arg0 -= arg1;
                    arg1 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg1 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg3 >> 16, arg5 >> 16);
                        arg3 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg0 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg4 >> 16, arg5 >> 16);
                        arg4 += i;
                        arg5 += i_57_;
                        arg2 += Rasterizer.anInt2768;
                    }
                } else {
                    arg0 -= arg1;
                    arg1 -= arg2;
                    arg2 = anIntArray2938[arg2];
                    while (--arg1 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg5 >> 16, arg3 >> 16);
                        arg3 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.anInt2768;
                    }
                    while (--arg0 >= 0) {
                        method698(Rasterizer.anIntArray2766, arg2,
                                arg6, 0, arg5 >> 16, arg4 >> 16);
                        arg4 += i;
                        arg5 += i_57_;
                        arg2 += Rasterizer.anInt2768;
                    }
                }
            }
        }
    }

    public static int[] method713() {
        return anIntArray2938;
    }

    public static void method714(double arg0, int arg1, int arg2) {
        arg0 += Math.random() * 0.03 - 0.015;
        int i = arg1 * 128;
        for (int i_58_ = arg1; i_58_ < arg2; i_58_++) {
            double d = (double) (i_58_ >> 3) / 64.0 + 0.0078125;
            double d_59_ = (double) (i_58_ & 0x7) / 8.0 + 0.0625;
            for (int i_60_ = 0; i_60_ < 128; i_60_++) {
                double d_61_ = (double) i_60_ / 128.0;
                double d_62_ = d_61_;
                double d_63_ = d_61_;
                double d_64_ = d_61_;
                if (d_59_ != 0.0) {
                    double d_65_;
                    if (d_61_ < 0.5)
                        d_65_ = d_61_ * (1.0 + d_59_);
                    else
                        d_65_ = d_61_ + d_59_ - d_61_ * d_59_;
                    double d_66_ = 2.0 * d_61_ - d_65_;
                    double d_67_ = d + 0.3333333333333333;
                    if (d_67_ > 1.0)
                        d_67_--;
                    double d_68_ = d;
                    double d_69_ = d - 0.3333333333333333;
                    if (d_69_ < 0.0)
                        d_69_++;
                    if (6.0 * d_67_ < 1.0)
                        d_62_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_67_;
                    else if (2.0 * d_67_ < 1.0)
                        d_62_ = d_65_;
                    else if (3.0 * d_67_ < 2.0)
                        d_62_ = d_66_ + ((d_65_ - d_66_)
                                * (0.6666666666666666 - d_67_) * 6.0);
                    else
                        d_62_ = d_66_;
                    if (6.0 * d_68_ < 1.0)
                        d_63_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_68_;
                    else if (2.0 * d_68_ < 1.0)
                        d_63_ = d_65_;
                    else if (3.0 * d_68_ < 2.0)
                        d_63_ = d_66_ + ((d_65_ - d_66_)
                                * (0.6666666666666666 - d_68_) * 6.0);
                    else
                        d_63_ = d_66_;
                    if (6.0 * d_69_ < 1.0)
                        d_64_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_69_;
                    else if (2.0 * d_69_ < 1.0)
                        d_64_ = d_65_;
                    else if (3.0 * d_69_ < 2.0)
                        d_64_ = d_66_ + ((d_65_ - d_66_)
                                * (0.6666666666666666 - d_69_) * 6.0);
                    else
                        d_64_ = d_66_;
                }
                int i_70_ = (int) (d_62_ * 256.0);
                int i_71_ = (int) (d_63_ * 256.0);
                int i_72_ = (int) (d_64_ * 256.0);
                int i_73_ = (i_70_ << 16) + (i_71_ << 8) + i_72_;
                i_73_ = method707(i_73_, arg0);
                if (i_73_ == 0)
                    i_73_ = 1;
                anIntArray2932[i++] = i_73_;
            }
        }
    }
}
