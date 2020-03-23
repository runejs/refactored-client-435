package com.jagex.runescape.media;

import com.jagex.runescape.Interface3;

public class Rasterizer3D extends Rasterizer {
    public static int[] anIntArray2929 = new int[2048];
    public static int bottomY;
    public static int center_y;
    public static int[] hsl2rgb;
    public static int alpha;
    public static int anInt2934;
    public static int anInt2935;
    public static boolean aBoolean2936 = false;
    public static int center_x;
    public static int[] lineOffsets;
    public static Interface3 anInterface3_2939;
    public static int[] shadowDecay;
    public static int anInt2941;
    public static int anInt2942;
    public static int[] sinetable = new int[2048];
    public static boolean notTextured;
    public static int viewportRx;
    public static int[] cosinetable;
    public static boolean restrict_edges;
    public static boolean aBoolean2948;
    private static boolean useLatestShadeLine = true;

    static {
        alpha = 0;
        hsl2rgb = new int[65536];
        notTextured = true;
        shadowDecay = new int[512];
        cosinetable = new int[2048];
        restrict_edges = false;
        aBoolean2948 = false;
        for(int i = 1; i < 512; i++)
            shadowDecay[i] = 32768 / i;
        for(int i = 1; i < 2048; i++)
            anIntArray2929[i] = 65536 / i;
        for(int i = 0; i < 2048; i++) {
            sinetable[i] = (int) (65536.0 * Math.sin((double) i * 0.0030679615));
            cosinetable[i] = (int) (65536.0 * Math.cos((double) i * 0.0030679615));
        }
    }

    public static void method698(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(restrict_edges) {
            if(arg5 > viewportRx)
                arg5 = viewportRx;
            if(arg4 < 0)
                arg4 = 0;
        }
        if(arg4 < arg5) {
            arg1 += arg4;
            arg3 = arg5 - arg4 >> 2;
            if(alpha == 0) {
                while(--arg3 >= 0) {
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                }
                arg3 = arg5 - arg4 & 0x3;
                while(--arg3 >= 0)
                    arg0[arg1++] = arg2;
            } else {
                int i = alpha;
                int i_0_ = 256 - alpha;
                arg2 = (((arg2 & 0xff00ff) * i_0_ >> 8 & 0xff00ff) + ((arg2 & 0xff00) * i_0_ >> 8 & 0xff00));
                while(--arg3 >= 0) {
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                }
                arg3 = arg5 - arg4 & 0x3;
                while(--arg3 >= 0)
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
            }
        }
    }

    public static void drawTexturedTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18) {
        int[] texture = anInterface3_2939.getTexturePixels(56, arg18);
        if(texture == null) {
            int i = anInterface3_2939.method14(true, arg18);
            drawShadedTriangle(arg0, arg1, arg2, arg3, arg4, arg5, method709(i, arg6), method709(i, arg7), method709(i, arg8));
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
            if(arg1 != arg0) {
                i_9_ = (arg4 - arg3 << 16) / (arg1 - arg0);
                i_10_ = (arg7 - arg6 << 16) / (arg1 - arg0);
            }
            int i_11_ = 0;
            int i_12_ = 0;
            if(arg2 != arg1) {
                i_11_ = (arg5 - arg4 << 16) / (arg2 - arg1);
                i_12_ = (arg8 - arg7 << 16) / (arg2 - arg1);
            }
            int i_13_ = 0;
            int i_14_ = 0;
            if(arg2 != arg0) {
                i_13_ = (arg3 - arg5 << 16) / (arg0 - arg2);
                i_14_ = (arg6 - arg8 << 16) / (arg0 - arg2);
            }
            if(arg0 <= arg1 && arg0 <= arg2) {
                if(arg0 < bottomY) {
                    if(arg1 > bottomY)
                        arg1 = bottomY;
                    if(arg2 > bottomY)
                        arg2 = bottomY;
                    if(arg1 < arg2) {
                        arg5 = arg3 <<= 16;
                        arg8 = arg6 <<= 16;
                        if(arg0 < 0) {
                            arg5 -= i_13_ * arg0;
                            arg3 -= i_9_ * arg0;
                            arg8 -= i_14_ * arg0;
                            arg6 -= i_10_ * arg0;
                            arg0 = 0;
                        }
                        arg4 <<= 16;
                        arg7 <<= 16;
                        if(arg1 < 0) {
                            arg4 -= i_11_ * arg1;
                            arg7 -= i_12_ * arg1;
                            arg1 = 0;
                        }
                        int i_15_ = arg0 - center_y;
                        i += i_2_ * i_15_;
                        i_3_ += i_5_ * i_15_;
                        i_6_ += i_8_ * i_15_;
                        if(arg0 != arg1 && i_13_ < i_9_ || arg0 == arg1 && i_13_ > i_11_) {
                            arg2 -= arg1;
                            arg1 -= arg0;
                            arg0 = lineOffsets[arg0];
                            while(--arg1 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg5 >> 16, arg3 >> 16, arg8 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg3 += i_9_;
                                arg8 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg5 >> 16, arg4 >> 16, arg8 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg4 += i_11_;
                                arg8 += i_14_;
                                arg7 += i_12_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg2 -= arg1;
                            arg1 -= arg0;
                            arg0 = lineOffsets[arg0];
                            while(--arg1 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg3 >> 16, arg5 >> 16, arg6 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg3 += i_9_;
                                arg8 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg4 >> 16, arg5 >> 16, arg7 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_13_;
                                arg4 += i_11_;
                                arg8 += i_14_;
                                arg7 += i_12_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    } else {
                        arg4 = arg3 <<= 16;
                        arg7 = arg6 <<= 16;
                        if(arg0 < 0) {
                            arg4 -= i_13_ * arg0;
                            arg3 -= i_9_ * arg0;
                            arg7 -= i_14_ * arg0;
                            arg6 -= i_10_ * arg0;
                            arg0 = 0;
                        }
                        arg5 <<= 16;
                        arg8 <<= 16;
                        if(arg2 < 0) {
                            arg5 -= i_11_ * arg2;
                            arg8 -= i_12_ * arg2;
                            arg2 = 0;
                        }
                        int i_16_ = arg0 - center_y;
                        i += i_2_ * i_16_;
                        i_3_ += i_5_ * i_16_;
                        i_6_ += i_8_ * i_16_;
                        if(arg0 != arg2 && i_13_ < i_9_ || arg0 == arg2 && i_11_ > i_9_) {
                            arg1 -= arg2;
                            arg2 -= arg0;
                            arg0 = lineOffsets[arg0];
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg4 >> 16, arg3 >> 16, arg7 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg4 += i_13_;
                                arg3 += i_9_;
                                arg7 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg1 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg5 >> 16, arg3 >> 16, arg8 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_11_;
                                arg3 += i_9_;
                                arg8 += i_12_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg1 -= arg2;
                            arg2 -= arg0;
                            arg0 = lineOffsets[arg0];
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg3 >> 16, arg4 >> 16, arg6 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg4 += i_13_;
                                arg3 += i_9_;
                                arg7 += i_14_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg1 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg0, arg3 >> 16, arg5 >> 16, arg6 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_11_;
                                arg3 += i_9_;
                                arg8 += i_12_;
                                arg6 += i_10_;
                                arg0 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    }
                }
            } else if(arg1 <= arg2) {
                if(arg1 < bottomY) {
                    if(arg2 > bottomY)
                        arg2 = bottomY;
                    if(arg0 > bottomY)
                        arg0 = bottomY;
                    if(arg2 < arg0) {
                        arg3 = arg4 <<= 16;
                        arg6 = arg7 <<= 16;
                        if(arg1 < 0) {
                            arg3 -= i_9_ * arg1;
                            arg4 -= i_11_ * arg1;
                            arg6 -= i_10_ * arg1;
                            arg7 -= i_12_ * arg1;
                            arg1 = 0;
                        }
                        arg5 <<= 16;
                        arg8 <<= 16;
                        if(arg2 < 0) {
                            arg5 -= i_13_ * arg2;
                            arg8 -= i_14_ * arg2;
                            arg2 = 0;
                        }
                        int i_17_ = arg1 - center_y;
                        i += i_2_ * i_17_;
                        i_3_ += i_5_ * i_17_;
                        i_6_ += i_8_ * i_17_;
                        if(arg1 != arg2 && i_9_ < i_11_ || arg1 == arg2 && i_9_ > i_13_) {
                            arg0 -= arg2;
                            arg2 -= arg1;
                            arg1 = lineOffsets[arg1];
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg3 >> 16, arg4 >> 16, arg6 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg4 += i_11_;
                                arg6 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg0 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg3 >> 16, arg5 >> 16, arg6 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg5 += i_13_;
                                arg6 += i_10_;
                                arg8 += i_14_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg0 -= arg2;
                            arg2 -= arg1;
                            arg1 = lineOffsets[arg1];
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg4 >> 16, arg3 >> 16, arg7 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg4 += i_11_;
                                arg6 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg0 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg5 >> 16, arg3 >> 16, arg8 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_9_;
                                arg5 += i_13_;
                                arg6 += i_10_;
                                arg8 += i_14_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    } else {
                        arg5 = arg4 <<= 16;
                        arg8 = arg7 <<= 16;
                        if(arg1 < 0) {
                            arg5 -= i_9_ * arg1;
                            arg4 -= i_11_ * arg1;
                            arg8 -= i_10_ * arg1;
                            arg7 -= i_12_ * arg1;
                            arg1 = 0;
                        }
                        arg3 <<= 16;
                        arg6 <<= 16;
                        if(arg0 < 0) {
                            arg3 -= i_13_ * arg0;
                            arg6 -= i_14_ * arg0;
                            arg0 = 0;
                        }
                        int i_18_ = arg1 - center_y;
                        i += i_2_ * i_18_;
                        i_3_ += i_5_ * i_18_;
                        i_6_ += i_8_ * i_18_;
                        if(i_9_ < i_11_) {
                            arg2 -= arg0;
                            arg0 -= arg1;
                            arg1 = lineOffsets[arg1];
                            while(--arg0 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg5 >> 16, arg4 >> 16, arg8 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_9_;
                                arg4 += i_11_;
                                arg8 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg3 >> 16, arg4 >> 16, arg6 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_13_;
                                arg4 += i_11_;
                                arg6 += i_14_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        } else {
                            arg2 -= arg0;
                            arg0 -= arg1;
                            arg1 = lineOffsets[arg1];
                            while(--arg0 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg4 >> 16, arg5 >> 16, arg7 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg5 += i_9_;
                                arg4 += i_11_;
                                arg8 += i_10_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                            while(--arg2 >= 0) {
                                method701(Rasterizer.pixels, texture, 0, 0, arg1, arg4 >> 16, arg3 >> 16, arg7 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                                arg3 += i_13_;
                                arg4 += i_11_;
                                arg6 += i_14_;
                                arg7 += i_12_;
                                arg1 += Rasterizer.width;
                                i += i_2_;
                                i_3_ += i_5_;
                                i_6_ += i_8_;
                            }
                        }
                    }
                }
            } else if(arg2 < bottomY) {
                if(arg0 > bottomY)
                    arg0 = bottomY;
                if(arg1 > bottomY)
                    arg1 = bottomY;
                if(arg0 < arg1) {
                    arg4 = arg5 <<= 16;
                    arg7 = arg8 <<= 16;
                    if(arg2 < 0) {
                        arg4 -= i_11_ * arg2;
                        arg5 -= i_13_ * arg2;
                        arg7 -= i_12_ * arg2;
                        arg8 -= i_14_ * arg2;
                        arg2 = 0;
                    }
                    arg3 <<= 16;
                    arg6 <<= 16;
                    if(arg0 < 0) {
                        arg3 -= i_9_ * arg0;
                        arg6 -= i_10_ * arg0;
                        arg0 = 0;
                    }
                    int i_19_ = arg2 - center_y;
                    i += i_2_ * i_19_;
                    i_3_ += i_5_ * i_19_;
                    i_6_ += i_8_ * i_19_;
                    if(i_11_ < i_13_) {
                        arg1 -= arg0;
                        arg0 -= arg2;
                        arg2 = lineOffsets[arg2];
                        while(--arg0 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg4 >> 16, arg5 >> 16, arg7 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg5 += i_13_;
                            arg7 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while(--arg1 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg4 >> 16, arg3 >> 16, arg7 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg3 += i_9_;
                            arg7 += i_12_;
                            arg6 += i_10_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    } else {
                        arg1 -= arg0;
                        arg0 -= arg2;
                        arg2 = lineOffsets[arg2];
                        while(--arg0 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg5 >> 16, arg4 >> 16, arg8 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg5 += i_13_;
                            arg7 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while(--arg1 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg3 >> 16, arg4 >> 16, arg6 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg4 += i_11_;
                            arg3 += i_9_;
                            arg7 += i_12_;
                            arg6 += i_10_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    }
                } else {
                    arg3 = arg5 <<= 16;
                    arg6 = arg8 <<= 16;
                    if(arg2 < 0) {
                        arg3 -= i_11_ * arg2;
                        arg5 -= i_13_ * arg2;
                        arg6 -= i_12_ * arg2;
                        arg8 -= i_14_ * arg2;
                        arg2 = 0;
                    }
                    arg4 <<= 16;
                    arg7 <<= 16;
                    if(arg1 < 0) {
                        arg4 -= i_9_ * arg1;
                        arg7 -= i_10_ * arg1;
                        arg1 = 0;
                    }
                    int i_20_ = arg2 - center_y;
                    i += i_2_ * i_20_;
                    i_3_ += i_5_ * i_20_;
                    i_6_ += i_8_ * i_20_;
                    if(i_11_ < i_13_) {
                        arg0 -= arg1;
                        arg1 -= arg2;
                        arg2 = lineOffsets[arg2];
                        while(--arg1 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg3 >> 16, arg5 >> 16, arg6 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg3 += i_11_;
                            arg5 += i_13_;
                            arg6 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while(--arg0 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg4 >> 16, arg5 >> 16, arg7 >> 8, arg8 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg4 += i_9_;
                            arg5 += i_13_;
                            arg7 += i_10_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    } else {
                        arg0 -= arg1;
                        arg1 -= arg2;
                        arg2 = lineOffsets[arg2];
                        while(--arg1 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg5 >> 16, arg3 >> 16, arg8 >> 8, arg6 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg3 += i_11_;
                            arg5 += i_13_;
                            arg6 += i_12_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                        while(--arg0 >= 0) {
                            method701(Rasterizer.pixels, texture, 0, 0, arg2, arg5 >> 16, arg4 >> 16, arg8 >> 8, arg7 >> 8, i, i_3_, i_6_, i_1_, i_4_, i_7_);
                            arg4 += i_9_;
                            arg5 += i_13_;
                            arg7 += i_10_;
                            arg8 += i_14_;
                            arg2 += Rasterizer.width;
                            i += i_2_;
                            i_3_ += i_5_;
                            i_6_ += i_8_;
                        }
                    }
                }
            }
        }
    }

    public static int[] method700(int arg0, int arg1, int arg2, int arg3, int[] arg4) {
        viewportRx = arg2 - arg0;
        bottomY = arg3 - arg1;
        if(arg4 == null) {
            int i = bottomY;
            if(i == 0)
                i++;
            lineOffsets = new int[i];
            for(int i_21_ = 0; i_21_ < i; i_21_++)
                lineOffsets[i_21_] = (arg1 + i_21_) * Rasterizer.width + arg0;
        } else
            lineOffsets = arg4;
        method702();
        return lineOffsets;
    }

    public static void method701(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
        if(arg5 < arg6) {
            int i;
            int i_22_;
            if(restrict_edges) {
                i_22_ = (arg8 - arg7) / (arg6 - arg5);
                if(arg6 > viewportRx)
                    arg6 = viewportRx;
                if(arg5 < 0) {
                    arg7 -= arg5 * i_22_;
                    arg5 = 0;
                }
                if(arg5 >= arg6)
                    return;
                i = arg6 - arg5 >> 3;
                i_22_ <<= 12;
                arg7 <<= 9;
            } else {
                if(arg6 - arg5 > 7) {
                    i = arg6 - arg5 >> 3;
                    i_22_ = (arg8 - arg7) * shadowDecay[i] >> 6;
                } else {
                    i = 0;
                    i_22_ = 0;
                }
                arg7 <<= 9;
            }
            arg4 += arg5;
            if(aBoolean2948) {
                int i_23_ = 0;
                int i_24_ = 0;
                int i_25_ = arg5 - center_x;
                arg9 += (arg12 >> 3) * i_25_;
                arg10 += (arg13 >> 3) * i_25_;
                arg11 += (arg14 >> 3) * i_25_;
                int i_26_ = arg11 >> 12;
                if(i_26_ != 0) {
                    arg2 = arg9 / i_26_;
                    arg3 = arg10 / i_26_;
                    if(arg2 < 0)
                        arg2 = 0;
                    else if(arg2 > 4032)
                        arg2 = 4032;
                }
                arg9 += arg12;
                arg10 += arg13;
                arg11 += arg14;
                i_26_ = arg11 >> 12;
                if(i_26_ != 0) {
                    i_23_ = arg9 / i_26_;
                    i_24_ = arg10 / i_26_;
                    if(i_23_ < 7)
                        i_23_ = 7;
                    else if(i_23_ > 4032)
                        i_23_ = 4032;
                }
                int i_27_ = i_23_ - arg2 >> 3;
                int i_28_ = i_24_ - arg3 >> 3;
                arg2 += (arg7 & 0x600000) >> 3;
                int i_29_ = arg7 >> 23;
                if(aBoolean2936) {
                    while(i-- > 0) {
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 = i_23_;
                        arg3 = i_24_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_26_ = arg11 >> 12;
                        if(i_26_ != 0) {
                            i_23_ = arg9 / i_26_;
                            i_24_ = arg10 / i_26_;
                            if(i_23_ < 7)
                                i_23_ = 7;
                            else if(i_23_ > 4032)
                                i_23_ = 4032;
                        }
                        i_27_ = i_23_ - arg2 >> 3;
                        i_28_ = i_24_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += (arg7 & 0x600000) >> 3;
                        i_29_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while(i-- > 0) {
                        arg0[arg4++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_;
                        arg2 += i_27_;
                        arg3 += i_28_;
                    }
                } else {
                    while(i-- > 0) {
                        int i_30_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                        if((i_30_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_30_;
                        arg4++;
                        arg2 = i_23_;
                        arg3 = i_24_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_26_ = arg11 >> 12;
                        if(i_26_ != 0) {
                            i_23_ = arg9 / i_26_;
                            i_24_ = arg10 / i_26_;
                            if(i_23_ < 7)
                                i_23_ = 7;
                            else if(i_23_ > 4032)
                                i_23_ = 4032;
                        }
                        i_27_ = i_23_ - arg2 >> 3;
                        i_28_ = i_24_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += (arg7 & 0x600000) >> 3;
                        i_29_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while(i-- > 0) {
                        int i_31_;
                        if((i_31_ = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i_29_) != 0)
                            arg0[arg4] = i_31_;
                        arg4++;
                        arg2 += i_27_;
                        arg3 += i_28_;
                    }
                }
            } else {
                int i_32_ = 0;
                int i_33_ = 0;
                int i_34_ = arg5 - center_x;
                arg9 += (arg12 >> 3) * i_34_;
                arg10 += (arg13 >> 3) * i_34_;
                arg11 += (arg14 >> 3) * i_34_;
                int i_35_ = arg11 >> 14;
                if(i_35_ != 0) {
                    arg2 = arg9 / i_35_;
                    arg3 = arg10 / i_35_;
                    if(arg2 < 0)
                        arg2 = 0;
                    else if(arg2 > 16256)
                        arg2 = 16256;
                }
                arg9 += arg12;
                arg10 += arg13;
                arg11 += arg14;
                i_35_ = arg11 >> 14;
                if(i_35_ != 0) {
                    i_32_ = arg9 / i_35_;
                    i_33_ = arg10 / i_35_;
                    if(i_32_ < 7)
                        i_32_ = 7;
                    else if(i_32_ > 16256)
                        i_32_ = 16256;
                }
                int i_36_ = i_32_ - arg2 >> 3;
                int i_37_ = i_33_ - arg3 >> 3;
                arg2 += arg7 & 0x600000;
                int i_38_ = arg7 >> 23;
                if(aBoolean2936) {
                    while(i-- > 0) {
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 = i_32_;
                        arg3 = i_33_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_35_ = arg11 >> 14;
                        if(i_35_ != 0) {
                            i_32_ = arg9 / i_35_;
                            i_33_ = arg10 / i_35_;
                            if(i_32_ < 7)
                                i_32_ = 7;
                            else if(i_32_ > 16256)
                                i_32_ = 16256;
                        }
                        i_36_ = i_32_ - arg2 >> 3;
                        i_37_ = i_33_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += arg7 & 0x600000;
                        i_38_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while(i-- > 0) {
                        arg0[arg4++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_;
                        arg2 += i_36_;
                        arg3 += i_37_;
                    }
                } else {
                    while(i-- > 0) {
                        int i_39_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 += i_36_;
                        arg3 += i_37_;
                        if((i_39_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
                            arg0[arg4] = i_39_;
                        arg4++;
                        arg2 = i_32_;
                        arg3 = i_33_;
                        arg9 += arg12;
                        arg10 += arg13;
                        arg11 += arg14;
                        i_35_ = arg11 >> 14;
                        if(i_35_ != 0) {
                            i_32_ = arg9 / i_35_;
                            i_33_ = arg10 / i_35_;
                            if(i_32_ < 7)
                                i_32_ = 7;
                            else if(i_32_ > 16256)
                                i_32_ = 16256;
                        }
                        i_36_ = i_32_ - arg2 >> 3;
                        i_37_ = i_33_ - arg3 >> 3;
                        arg7 += i_22_;
                        arg2 += arg7 & 0x600000;
                        i_38_ = arg7 >> 23;
                    }
                    i = arg6 - arg5 & 0x7;
                    while(i-- > 0) {
                        int i_40_;
                        if((i_40_ = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i_38_) != 0)
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
        center_x = viewportRx / 2;
        center_y = bottomY / 2;
        anInt2942 = -center_x;
        anInt2934 = viewportRx - center_x;
        anInt2935 = -center_y;
        anInt2941 = bottomY - center_y;
    }

    public static void method703(Interface3 arg0) {
        anInterface3_2939 = arg0;
    }

    public static void method704() {
        lineOffsets = null;
        hsl2rgb = null;
        anInterface3_2939 = null;
        shadowDecay = null;
        anIntArray2929 = null;
        sinetable = null;
        cosinetable = null;
    }

    //562 drawshadedline
    //has vertex blending :O
    public static void drawShadedLine562(int dest[], int dest_off, int startX, int endX, int colorIndex, int grad) {
        int off = 0;
        int color;
        int loops;
        if (restrict_edges) {
            if (endX > viewportRx)
                endX = viewportRx;
            if (startX < 0) {
                //colorIndex -= startX * off;//not sure if needed
                startX = 0;
            }
        }
        if (startX < endX) {
            dest_off += startX - 1;
            colorIndex += off * startX;
            if (notTextured) {
                loops = endX - startX >> 2;
                if (loops > 0)
                    off = (grad - colorIndex) * shadowDecay[loops] >> 15;
                else
                    off = 0;
                if (alpha == 0) {
                    if (loops > 0) {
                        do {
                            color = hsl2rgb[colorIndex >> 8];
                            colorIndex += off;
                            dest[++dest_off] = color;
                            dest[++dest_off] = color;
                            dest[++dest_off] = color;
                            dest[++dest_off] = color;
                        } while (--loops > 0);
                    }
                    loops = endX - startX & 0x3;
                    if (loops > 0) {
                        color = hsl2rgb[colorIndex >> 8];
                        do
                            dest[++dest_off] = color;
                        while (--loops > 0);
                    }
                } else {
                    int src_alpha = alpha;
                    int dest_alpha = 256 - alpha;
                    if (loops > 0) {
                        do {
                            color = hsl2rgb[colorIndex >> 8];
                            colorIndex += off;
                            color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                            int i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                            i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                            i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                            i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                        } while (--loops > 0);
                    }
                    loops = endX - startX & 0x3;
                    if (loops > 0) {
                        color = hsl2rgb[colorIndex >> 8];
                        color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                        do {
                            int i_170_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_170_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_170_ & 0xff00) * src_alpha >> 8 & 0xff00));
                        } while (--loops > 0);
                    }
                }
            } else {
                loops = endX - startX;
                if (alpha == 0) {
                    do {
                        dest[++dest_off] = hsl2rgb[colorIndex >> 8];
                        colorIndex += off;
                    } while (--loops > 0);
                } else {
                    int i = alpha;
                    int i_171_ = 256 - alpha;
                    do {
                        color = hsl2rgb[colorIndex >> 8];
                        colorIndex += off;
                        color = (((color & 0xff00ff) * i_171_ >> 8 & 0xff00ff) + ((color & 0xff00) * i_171_ >> 8 & 0xff00));
                        int i_ = dest[++dest_off];
                        dest[dest_off] = (color + ((i_ & 0xff00ff) * i >> 8 & 0xff00ff) + ((i_ & 0xff00) * i >> 8 & 0xff00));
                    } while (--loops > 0);
                }
            }
        }
    }

    public static void drawShadedLine(int[] dest, int dest_off, int start_x, int end_x, int color_index, int grad) {
        if (!useLatestShadeLine) {//divert all calls to the new method as its better
            drawShadedLine562(dest, dest_off, start_x, end_x, color_index, grad);
            return;
        }
        int color;
        int loops;
        if(notTextured) {
            int off;
            if(restrict_edges) {
                if(end_x - start_x > 3)
                    off = (grad - color_index) / (end_x - start_x);
                else
                    off = 0;
                if(end_x > viewportRx)
                    end_x = viewportRx;
                if(start_x < 0) {
                    color_index -= start_x * off;
                    start_x = 0;
                }
                if(start_x >= end_x)
                    return;
                dest_off += start_x;
                loops = end_x - start_x >> 2;
                off <<= 2;
            } else {
                if(start_x >= end_x)
                    return;
                dest_off += start_x;
                loops = end_x - start_x >> 2;
                if(loops > 0)
                    off = (grad - color_index) * shadowDecay[loops] >> 15;
                else
                    off = 0;
            }
            if(alpha == 0) {
                while(--loops >= 0) {
                    color = hsl2rgb[color_index >> 8];
                    color_index += off;
                    dest[dest_off++] = color;
                    dest[dest_off++] = color;
                    dest[dest_off++] = color;
                    dest[dest_off++] = color;
                }
                loops = end_x - start_x & 0x3;
                if(loops > 0) {
                    color = hsl2rgb[color_index >> 8];
                    do
                        dest[dest_off++] = color; while(--loops > 0);
                }
            } else {
                int src_alpha = alpha;
                int dest_alpha = 256 - alpha;
                while(--loops >= 0) {
                    color = hsl2rgb[color_index >> 8];
                    color_index += off;
                    color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                }
                loops = end_x - start_x & 0x3;
                if(loops > 0) {
                    color = hsl2rgb[color_index >> 8];
                    color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                    do
                        dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    while(--loops > 0);
                }
            }
        } else {
            if(start_x < end_x) {
                int i = (grad - color_index) / (end_x - start_x);
                if(restrict_edges) {
                    if(end_x > viewportRx)
                        end_x = viewportRx;
                    if(start_x < 0) {
                        color_index -= start_x * i;
                        start_x = 0;
                    }
                    if(start_x >= end_x)
                        return;
                }
                dest_off += start_x;
                loops = end_x - start_x;
                if(alpha == 0) {
                    do {
                        dest[dest_off++] = hsl2rgb[color_index >> 8];
                        color_index += i;
                    } while(--loops > 0);
                } else {
                    int i_43_ = alpha;
                    int i_44_ = 256 - alpha;
                    do {
                        color = hsl2rgb[color_index >> 8];
                        color_index += i;
                        color = (((color & 0xff00ff) * i_44_ >> 8 & 0xff00ff) + ((color & 0xff00) * i_44_ >> 8 & 0xff00));
                        dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * i_43_ >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * i_43_ >> 8 & 0xff00));
                    } while(--loops > 0);
                }
            }
        }
    }

    public static void drawShadedTriangle(int y_a, int y_b, int y_c, int x_a, int x_b, int x_c, int z_a, int z_b, int z_c) {
        int x_a_off = 0;
        int z_a_off = 0;
        if(y_b != y_a) {
            x_a_off = (x_b - x_a << 16) / (y_b - y_a);
            z_a_off = (z_b - z_a << 15) / (y_b - y_a);
        }
        int x_b_off = 0;
        int z_b_off = 0;
        if(y_c != y_b) {
            x_b_off = (x_c - x_b << 16) / (y_c - y_b);
            z_b_off = (z_c - z_b << 15) / (y_c - y_b);
        }
        int x_c_off = 0;
        int z_c_off = 0;
        if(y_c != y_a) {
            x_c_off = (x_a - x_c << 16) / (y_a - y_c);
            z_c_off = (z_a - z_c << 15) / (y_a - y_c);
        }
        if(y_a <= y_b && y_a <= y_c) {
            if(y_a >= bottomY) {
                return;
            }
            if(y_b > bottomY)
                y_b = bottomY;
            if(y_c > bottomY)
                y_c = bottomY;
            if(y_b < y_c) {
                x_c = x_a <<= 16;
                z_c = z_a <<= 15;
                if(y_a < 0) {
                    x_c -= x_c_off * y_a;
                    x_a -= x_a_off * y_a;
                    z_c -= z_c_off * y_a;
                    z_a -= z_a_off * y_a;
                    y_a = 0;
                }
                x_b <<= 16;
                z_b <<= 15;
                if(y_b < 0) {
                    x_b -= x_b_off * y_b;
                    z_b -= z_b_off * y_b;
                    y_b = 0;
                }
                if(y_a != y_b && x_c_off < x_a_off || y_a == y_b && x_c_off > x_b_off) {
                    y_c -= y_b;
                    y_b -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                        x_c += x_c_off;
                        x_a += x_a_off;
                        z_c += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.width;
                    }
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                        x_c += x_c_off;
                        x_b += x_b_off;
                        z_c += z_c_off;
                        z_b += z_b_off;
                        y_a += Rasterizer.width;
                    }
                } else {
                    y_c -= y_b;
                    y_b -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                        x_c += x_c_off;
                        x_a += x_a_off;
                        z_c += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.width;
                    }
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                        x_c += x_c_off;
                        x_b += x_b_off;
                        z_c += z_c_off;
                        z_b += z_b_off;
                        y_a += Rasterizer.width;
                    }
                }
            } else {
                x_b = x_a <<= 16;
                z_b = z_a <<= 15;
                if(y_a < 0) {
                    x_b -= x_c_off * y_a;
                    x_a -= x_a_off * y_a;
                    z_b -= z_c_off * y_a;
                    z_a -= z_a_off * y_a;
                    y_a = 0;
                }
                x_c <<= 16;
                z_c <<= 15;
                if(y_c < 0) {
                    x_c -= x_b_off * y_c;
                    z_c -= z_b_off * y_c;
                    y_c = 0;
                }
                if(y_a != y_c && x_c_off < x_a_off || y_a == y_c && x_b_off > x_a_off) {
                    y_b -= y_c;
                    y_c -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                        x_b += x_c_off;
                        x_a += x_a_off;
                        z_b += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.width;
                    }
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                        x_c += x_b_off;
                        x_a += x_a_off;
                        z_c += z_b_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.width;
                    }
                } else {
                    y_b -= y_c;
                    y_c -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                        x_b += x_c_off;
                        x_a += x_a_off;
                        z_b += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.width;
                    }
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.pixels, y_a, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                        x_c += x_b_off;
                        x_a += x_a_off;
                        z_c += z_b_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.width;
                    }
                }
            }
        } else {
            if(y_b <= y_c) {
                if(y_b < bottomY) {
                    if(y_c > bottomY)
                        y_c = bottomY;
                    if(y_a > bottomY)
                        y_a = bottomY;
                    if(y_c < y_a) {
                        x_a = x_b <<= 16;
                        z_a = z_b <<= 15;
                        if(y_b < 0) {
                            x_a -= x_a_off * y_b;
                            x_b -= x_b_off * y_b;
                            z_a -= z_a_off * y_b;
                            z_b -= z_b_off * y_b;
                            y_b = 0;
                        }
                        x_c <<= 16;
                        z_c <<= 15;
                        if(y_c < 0) {
                            x_c -= x_c_off * y_c;
                            z_c -= z_c_off * y_c;
                            y_c = 0;
                        }
                        if(y_b != y_c && x_a_off < x_b_off || y_b == y_c && x_a_off > x_c_off) {
                            y_a -= y_c;
                            y_c -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                                x_a += x_a_off;
                                x_b += x_b_off;
                                z_a += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.width;
                            }
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                                x_a += x_a_off;
                                x_c += x_c_off;
                                z_a += z_a_off;
                                z_c += z_c_off;
                                y_b += Rasterizer.width;
                            }
                        } else {
                            y_a -= y_c;
                            y_c -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                                x_a += x_a_off;
                                x_b += x_b_off;
                                z_a += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.width;
                            }
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                                x_a += x_a_off;
                                x_c += x_c_off;
                                z_a += z_a_off;
                                z_c += z_c_off;
                                y_b += Rasterizer.width;
                            }
                        }
                    } else {
                        x_c = x_b <<= 16;
                        z_c = z_b <<= 15;
                        if(y_b < 0) {
                            x_c -= x_a_off * y_b;
                            x_b -= x_b_off * y_b;
                            z_c -= z_a_off * y_b;
                            z_b -= z_b_off * y_b;
                            y_b = 0;
                        }
                        x_a <<= 16;
                        z_a <<= 15;
                        if(y_a < 0) {
                            x_a -= x_c_off * y_a;
                            z_a -= z_c_off * y_a;
                            y_a = 0;
                        }
                        if(x_a_off < x_b_off) {
                            y_c -= y_a;
                            y_a -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                                x_c += x_a_off;
                                x_b += x_b_off;
                                z_c += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.width;
                            }
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                                x_a += x_c_off;
                                x_b += x_b_off;
                                z_a += z_c_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.width;
                            }
                        } else {
                            y_c -= y_a;
                            y_a -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                                x_c += x_a_off;
                                x_b += x_b_off;
                                z_c += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.width;
                            }
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.pixels, y_b, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                                x_a += x_c_off;
                                x_b += x_b_off;
                                z_a += z_c_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.width;
                            }
                        }
                    }
                }
            } else if(y_c < bottomY) {
                if(y_a > bottomY)
                    y_a = bottomY;
                if(y_b > bottomY)
                    y_b = bottomY;
                if(y_a < y_b) {
                    x_b = x_c <<= 16;
                    z_b = z_c <<= 15;
                    if(y_c < 0) {
                        x_b -= x_b_off * y_c;
                        x_c -= x_c_off * y_c;
                        z_b -= z_b_off * y_c;
                        z_c -= z_c_off * y_c;
                        y_c = 0;
                    }
                    x_a <<= 16;
                    z_a <<= 15;
                    if(y_a < 0) {
                        x_a -= x_a_off * y_a;
                        z_a -= z_a_off * y_a;
                        y_a = 0;
                    }
                    if(x_b_off < x_c_off) {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                            x_b += x_b_off;
                            x_c += x_c_off;
                            z_b += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.width;
                        }
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                            x_b += x_b_off;
                            x_a += x_a_off;
                            z_b += z_b_off;
                            z_a += z_a_off;
                            y_c += Rasterizer.width;
                        }
                    } else {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                            x_b += x_b_off;
                            x_c += x_c_off;
                            z_b += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.width;
                        }
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                            x_b += x_b_off;
                            x_a += x_a_off;
                            z_b += z_b_off;
                            z_a += z_a_off;
                            y_c += Rasterizer.width;
                        }
                    }
                } else {
                    x_a = x_c <<= 16;
                    z_a = z_c <<= 15;
                    if(y_c < 0) {
                        x_a -= x_b_off * y_c;
                        x_c -= x_c_off * y_c;
                        z_a -= z_b_off * y_c;
                        z_c -= z_c_off * y_c;
                        y_c = 0;
                    }
                    x_b <<= 16;
                    z_b <<= 15;
                    if(y_b < 0) {
                        x_b -= x_a_off * y_b;
                        z_b -= z_a_off * y_b;
                        y_b = 0;
                    }
                    if(x_b_off < x_c_off) {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                            x_a += x_b_off;
                            x_c += x_c_off;
                            z_a += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.width;
                        }
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                            x_b += x_a_off;
                            x_c += x_c_off;
                            z_b += z_a_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.width;
                        }
                    } else {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                            x_a += x_b_off;
                            x_c += x_c_off;
                            z_a += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.width;
                        }
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.pixels, y_c, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                            x_b += x_a_off;
                            x_c += x_c_off;
                            z_b += z_a_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.width;
                        }
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
        return method700(Rasterizer.viewport_left, Rasterizer.viewport_top, Rasterizer.viewport_right, Rasterizer.viewport_bottom, arg0);
    }

    public static int method709(int arg0, int arg1) {
        arg1 = (127 - arg1) * (arg0 & 0x7f) >> 7;
        if(arg1 < 2)
            arg1 = 2;
        else if(arg1 > 126)
            arg1 = 126;
        return (arg0 & 0xff80) + arg1;
    }

    public static void method710(int arg0, int arg1) {
        int i = lineOffsets[0];
        int i_54_ = i / Rasterizer.width;
        int i_55_ = i - i_54_ * Rasterizer.width;
        center_x = arg0 - i_55_;
        center_y = arg1 - i_54_;
        anInt2942 = -center_x;
        anInt2934 = viewportRx - center_x;
        anInt2935 = -center_y;
        anInt2941 = bottomY - center_y;
    }

    public static void method711(double arg0) {
        method714(arg0, 0, 512);
    }

    public static void method712(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        int i = 0;
        if(arg1 != arg0)
            i = (arg4 - arg3 << 16) / (arg1 - arg0);
        int i_56_ = 0;
        if(arg2 != arg1)
            i_56_ = (arg5 - arg4 << 16) / (arg2 - arg1);
        int i_57_ = 0;
        if(arg2 != arg0)
            i_57_ = (arg3 - arg5 << 16) / (arg0 - arg2);
        if(arg0 <= arg1 && arg0 <= arg2) {
            if(arg0 < bottomY) {
                if(arg1 > bottomY)
                    arg1 = bottomY;
                if(arg2 > bottomY)
                    arg2 = bottomY;
                if(arg1 < arg2) {
                    arg5 = arg3 <<= 16;
                    if(arg0 < 0) {
                        arg5 -= i_57_ * arg0;
                        arg3 -= i * arg0;
                        arg0 = 0;
                    }
                    arg4 <<= 16;
                    if(arg1 < 0) {
                        arg4 -= i_56_ * arg1;
                        arg1 = 0;
                    }
                    if(arg0 != arg1 && i_57_ < i || arg0 == arg1 && i_57_ > i_56_) {
                        arg2 -= arg1;
                        arg1 -= arg0;
                        arg0 = lineOffsets[arg0];
                        while(--arg1 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg5 >> 16, arg3 >> 16);
                            arg5 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.width;
                        }
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg5 >> 16, arg4 >> 16);
                            arg5 += i_57_;
                            arg4 += i_56_;
                            arg0 += Rasterizer.width;
                        }
                    } else {
                        arg2 -= arg1;
                        arg1 -= arg0;
                        arg0 = lineOffsets[arg0];
                        while(--arg1 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg3 >> 16, arg5 >> 16);
                            arg5 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.width;
                        }
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg4 >> 16, arg5 >> 16);
                            arg5 += i_57_;
                            arg4 += i_56_;
                            arg0 += Rasterizer.width;
                        }
                    }
                } else {
                    arg4 = arg3 <<= 16;
                    if(arg0 < 0) {
                        arg4 -= i_57_ * arg0;
                        arg3 -= i * arg0;
                        arg0 = 0;
                    }
                    arg5 <<= 16;
                    if(arg2 < 0) {
                        arg5 -= i_56_ * arg2;
                        arg2 = 0;
                    }
                    if(arg0 != arg2 && i_57_ < i || arg0 == arg2 && i_56_ > i) {
                        arg1 -= arg2;
                        arg2 -= arg0;
                        arg0 = lineOffsets[arg0];
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg4 >> 16, arg3 >> 16);
                            arg4 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.width;
                        }
                        while(--arg1 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg5 >> 16, arg3 >> 16);
                            arg5 += i_56_;
                            arg3 += i;
                            arg0 += Rasterizer.width;
                        }
                    } else {
                        arg1 -= arg2;
                        arg2 -= arg0;
                        arg0 = lineOffsets[arg0];
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg3 >> 16, arg4 >> 16);
                            arg4 += i_57_;
                            arg3 += i;
                            arg0 += Rasterizer.width;
                        }
                        while(--arg1 >= 0) {
                            method698(Rasterizer.pixels, arg0, arg6, 0, arg3 >> 16, arg5 >> 16);
                            arg5 += i_56_;
                            arg3 += i;
                            arg0 += Rasterizer.width;
                        }
                    }
                }
            }
        } else if(arg1 <= arg2) {
            if(arg1 < bottomY) {
                if(arg2 > bottomY)
                    arg2 = bottomY;
                if(arg0 > bottomY)
                    arg0 = bottomY;
                if(arg2 < arg0) {
                    arg3 = arg4 <<= 16;
                    if(arg1 < 0) {
                        arg3 -= i * arg1;
                        arg4 -= i_56_ * arg1;
                        arg1 = 0;
                    }
                    arg5 <<= 16;
                    if(arg2 < 0) {
                        arg5 -= i_57_ * arg2;
                        arg2 = 0;
                    }
                    if(arg1 != arg2 && i < i_56_ || arg1 == arg2 && i > i_57_) {
                        arg0 -= arg2;
                        arg2 -= arg1;
                        arg1 = lineOffsets[arg1];
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg3 >> 16, arg4 >> 16);
                            arg3 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.width;
                        }
                        while(--arg0 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg3 >> 16, arg5 >> 16);
                            arg3 += i;
                            arg5 += i_57_;
                            arg1 += Rasterizer.width;
                        }
                    } else {
                        arg0 -= arg2;
                        arg2 -= arg1;
                        arg1 = lineOffsets[arg1];
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg4 >> 16, arg3 >> 16);
                            arg3 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.width;
                        }
                        while(--arg0 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg5 >> 16, arg3 >> 16);
                            arg3 += i;
                            arg5 += i_57_;
                            arg1 += Rasterizer.width;
                        }
                    }
                } else {
                    arg5 = arg4 <<= 16;
                    if(arg1 < 0) {
                        arg5 -= i * arg1;
                        arg4 -= i_56_ * arg1;
                        arg1 = 0;
                    }
                    arg3 <<= 16;
                    if(arg0 < 0) {
                        arg3 -= i_57_ * arg0;
                        arg0 = 0;
                    }
                    if(i < i_56_) {
                        arg2 -= arg0;
                        arg0 -= arg1;
                        arg1 = lineOffsets[arg1];
                        while(--arg0 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg5 >> 16, arg4 >> 16);
                            arg5 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.width;
                        }
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg3 >> 16, arg4 >> 16);
                            arg3 += i_57_;
                            arg4 += i_56_;
                            arg1 += Rasterizer.width;
                        }
                    } else {
                        arg2 -= arg0;
                        arg0 -= arg1;
                        arg1 = lineOffsets[arg1];
                        while(--arg0 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg4 >> 16, arg5 >> 16);
                            arg5 += i;
                            arg4 += i_56_;
                            arg1 += Rasterizer.width;
                        }
                        while(--arg2 >= 0) {
                            method698(Rasterizer.pixels, arg1, arg6, 0, arg4 >> 16, arg3 >> 16);
                            arg3 += i_57_;
                            arg4 += i_56_;
                            arg1 += Rasterizer.width;
                        }
                    }
                }
            }
        } else if(arg2 < bottomY) {
            if(arg0 > bottomY)
                arg0 = bottomY;
            if(arg1 > bottomY)
                arg1 = bottomY;
            if(arg0 < arg1) {
                arg4 = arg5 <<= 16;
                if(arg2 < 0) {
                    arg4 -= i_56_ * arg2;
                    arg5 -= i_57_ * arg2;
                    arg2 = 0;
                }
                arg3 <<= 16;
                if(arg0 < 0) {
                    arg3 -= i * arg0;
                    arg0 = 0;
                }
                if(i_56_ < i_57_) {
                    arg1 -= arg0;
                    arg0 -= arg2;
                    arg2 = lineOffsets[arg2];
                    while(--arg0 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg4 >> 16, arg5 >> 16);
                        arg4 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.width;
                    }
                    while(--arg1 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg4 >> 16, arg3 >> 16);
                        arg4 += i_56_;
                        arg3 += i;
                        arg2 += Rasterizer.width;
                    }
                } else {
                    arg1 -= arg0;
                    arg0 -= arg2;
                    arg2 = lineOffsets[arg2];
                    while(--arg0 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg5 >> 16, arg4 >> 16);
                        arg4 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.width;
                    }
                    while(--arg1 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg3 >> 16, arg4 >> 16);
                        arg4 += i_56_;
                        arg3 += i;
                        arg2 += Rasterizer.width;
                    }
                }
            } else {
                arg3 = arg5 <<= 16;
                if(arg2 < 0) {
                    arg3 -= i_56_ * arg2;
                    arg5 -= i_57_ * arg2;
                    arg2 = 0;
                }
                arg4 <<= 16;
                if(arg1 < 0) {
                    arg4 -= i * arg1;
                    arg1 = 0;
                }
                if(i_56_ < i_57_) {
                    arg0 -= arg1;
                    arg1 -= arg2;
                    arg2 = lineOffsets[arg2];
                    while(--arg1 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg3 >> 16, arg5 >> 16);
                        arg3 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.width;
                    }
                    while(--arg0 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg4 >> 16, arg5 >> 16);
                        arg4 += i;
                        arg5 += i_57_;
                        arg2 += Rasterizer.width;
                    }
                } else {
                    arg0 -= arg1;
                    arg1 -= arg2;
                    arg2 = lineOffsets[arg2];
                    while(--arg1 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg5 >> 16, arg3 >> 16);
                        arg3 += i_56_;
                        arg5 += i_57_;
                        arg2 += Rasterizer.width;
                    }
                    while(--arg0 >= 0) {
                        method698(Rasterizer.pixels, arg2, arg6, 0, arg5 >> 16, arg4 >> 16);
                        arg4 += i;
                        arg5 += i_57_;
                        arg2 += Rasterizer.width;
                    }
                }
            }
        }
    }

    public static int[] method713() {
        return lineOffsets;
    }

    public static void method714(double arg0, int arg1, int arg2) {
        arg0 += Math.random() * 0.03 - 0.015;
        int i = arg1 * 128;
        for(int i_58_ = arg1; i_58_ < arg2; i_58_++) {
            double d = (double) (i_58_ >> 3) / 64.0 + 0.0078125;
            double d_59_ = (double) (i_58_ & 0x7) / 8.0 + 0.0625;
            for(int i_60_ = 0; i_60_ < 128; i_60_++) {
                double d_61_ = (double) i_60_ / 128.0;
                double d_62_ = d_61_;
                double d_63_ = d_61_;
                double d_64_ = d_61_;
                if(d_59_ != 0.0) {
                    double d_65_;
                    if(d_61_ < 0.5)
                        d_65_ = d_61_ * (1.0 + d_59_);
                    else
                        d_65_ = d_61_ + d_59_ - d_61_ * d_59_;
                    double d_66_ = 2.0 * d_61_ - d_65_;
                    double d_67_ = d + 0.3333333333333333;
                    if(d_67_ > 1.0)
                        d_67_--;
                    double d_68_ = d;
                    double d_69_ = d - 0.3333333333333333;
                    if(d_69_ < 0.0)
                        d_69_++;
                    if(6.0 * d_67_ < 1.0)
                        d_62_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_67_;
                    else if(2.0 * d_67_ < 1.0)
                        d_62_ = d_65_;
                    else if(3.0 * d_67_ < 2.0)
                        d_62_ = d_66_ + ((d_65_ - d_66_) * (0.6666666666666666 - d_67_) * 6.0);
                    else
                        d_62_ = d_66_;
                    if(6.0 * d_68_ < 1.0)
                        d_63_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_68_;
                    else if(2.0 * d_68_ < 1.0)
                        d_63_ = d_65_;
                    else if(3.0 * d_68_ < 2.0)
                        d_63_ = d_66_ + ((d_65_ - d_66_) * (0.6666666666666666 - d_68_) * 6.0);
                    else
                        d_63_ = d_66_;
                    if(6.0 * d_69_ < 1.0)
                        d_64_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_69_;
                    else if(2.0 * d_69_ < 1.0)
                        d_64_ = d_65_;
                    else if(3.0 * d_69_ < 2.0)
                        d_64_ = d_66_ + ((d_65_ - d_66_) * (0.6666666666666666 - d_69_) * 6.0);
                    else
                        d_64_ = d_66_;
                }
                int i_70_ = (int) (d_62_ * 256.0);
                int i_71_ = (int) (d_63_ * 256.0);
                int i_72_ = (int) (d_64_ * 256.0);
                int i_73_ = (i_70_ << 16) + (i_71_ << 8) + i_72_;
                i_73_ = method707(i_73_, arg0);
                if(i_73_ == 0)
                    i_73_ = 1;
                hsl2rgb[i++] = i_73_;
            }
        }
    }
}
