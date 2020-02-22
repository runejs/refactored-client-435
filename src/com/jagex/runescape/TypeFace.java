package com.jagex.runescape;

import java.util.Random;

public class TypeFace extends Rasterizer {
    public static RSString aClass1_2893;
    public static RSString aClass1_2894;
    public static RSString aClass1_2895;
    public static RSString aClass1_2896;
    public static RSString[] aClass1Array2897 = new RSString[100];
    public static RSString aClass1_2898;
    public static RSString aClass1_2899 = Class58.method978("dbl");
    public static RSString aClass1_2900;
    public static RSString aClass1_2901;
    public static RSString aClass1_2903;
    public static RSString aClass1_2904;
    public static RSString aClass1_2905;
    public static RSString aClass1_2906;
    public static RSString aClass1_2908;
    public static RSString aClass1_2909;
    public static RSString aClass1_2912;
    public static RSString aClass1_2913;
    public static RSString aClass1_2916;
    public static RSString aClass1_2917;

    static {
        aClass1_2894 = Class58.method978("or1");
        aClass1_2896 = Class58.method978("mag");
        aClass1_2903 = Class58.method978("red");
        aClass1_2893 = Class58.method978("cya");
        aClass1_2905 = Class58.method978("or2");
        aClass1_2900 = Class58.method978("gr1");
        aClass1_2906 = Class58.method978("bla");
        aClass1_2895 = Class58.method978("blu");
        aClass1_2912 = Class58.method978("lre");
        aClass1_2913 = Class58.method978("dre");
        aClass1_2901 = Class58.method978("gr2");
        aClass1_2908 = Class58.method978("str");
        aClass1_2904 = Class58.method978("gre");
        aClass1_2909 = Class58.method978("or3");
        aClass1_2917 = Class58.method978("yel");
        aClass1_2916 = Class58.method978("gr3");
        aClass1_2898 = Class58.method978("whi");
    }

    public Random aRandom2902;
    public int[] anIntArray2907;
    public int anInt2910;
    public int[] anIntArray2911;
    public byte[][] aByteArrayArray2914 = new byte[256][];
    public int[] anIntArray2915;
    public boolean aBoolean2918;
    public int anInt2919;
    public int anInt2920;

    public TypeFace(int[] arg0, int[] arg1, int[] arg2, int[] arg3, byte[][] arg4) {
        anInt2910 = 0;
        aRandom2902 = new Random();
        aBoolean2918 = false;
        anIntArray2911 = arg0;
        anIntArray2907 = arg1;
        anIntArray2915 = arg2;
        byte i = 0;
        for(int i_47_ = 1; i_47_ < arg3.length; i_47_++) {
            if(arg3[i_47_] == 1)
                i = (byte) i_47_;
        }
        aByteArrayArray2914 = arg4;
        int i_48_ = 2147483647;
        int i_49_ = -2147483648;
        for(int i_50_ = 0; i_50_ < 256; i_50_++) {
            if(anIntArray2911[i_50_] < i_48_)
                i_48_ = anIntArray2911[i_50_];
            if(anIntArray2911[i_50_] + anIntArray2915[i_50_] > i_49_)
                i_49_ = anIntArray2911[i_50_] + anIntArray2915[i_50_];
            byte[] is = aByteArrayArray2914[i_50_];
            int i_51_ = is.length;
            for(int i_52_ = 0; i_52_ < i_51_; i_52_++)
                is[i_52_] = is[i_52_] == i ? (byte) 0 : (byte) 1;
        }
        anInt2910 = anIntArray2911[32] + anIntArray2915[32];
        anInt2920 = anInt2910 - i_48_;
        anInt2919 = i_49_ - anInt2910;
    }

    public static void method676() {
        aClass1_2903 = null;
        aClass1_2904 = null;
        aClass1_2895 = null;
        aClass1_2917 = null;
        aClass1_2893 = null;
        aClass1_2896 = null;
        aClass1_2898 = null;
        aClass1_2906 = null;
        aClass1_2912 = null;
        aClass1_2913 = null;
        aClass1_2899 = null;
        aClass1_2894 = null;
        aClass1_2905 = null;
        aClass1_2909 = null;
        aClass1_2900 = null;
        aClass1_2901 = null;
        aClass1_2916 = null;
        aClass1_2908 = null;
        aClass1Array2897 = null;
    }

    public int method670(RSString arg0) {
        if(arg0.method54(aClass1_2903, 122))
            return 16711680;
        if(arg0.method54(aClass1_2904, 122))
            return 65280;
        if(arg0.method54(aClass1_2895, 122))
            return 255;
        if(arg0.method54(aClass1_2917, 122))
            return 16776960;
        if(arg0.method54(aClass1_2893, 122))
            return 65535;
        if(arg0.method54(aClass1_2896, 122))
            return 16711935;
        if(arg0.method54(aClass1_2898, 122))
            return 16777215;
        if(arg0.method54(aClass1_2906, 122))
            return 0;
        if(arg0.method54(aClass1_2912, 122))
            return 16748608;
        if(arg0.method54(aClass1_2913, 122))
            return 8388608;
        if(arg0.method54(aClass1_2899, 122))
            return 128;
        if(arg0.method54(aClass1_2894, 122))
            return 16756736;
        if(arg0.method54(aClass1_2905, 122))
            return 16740352;
        if(arg0.method54(aClass1_2909, 122))
            return 16723968;
        if(arg0.method54(aClass1_2900, 122))
            return 12648192;
        if(arg0.method54(aClass1_2901, 122))
            return 8453888;
        if(arg0.method54(aClass1_2916, 122))
            return 4259584;
        if(arg0.method54(aClass1_2908, 122))
            aBoolean2918 = true;
        return -1;
    }

    public void method671(int[] arg0, byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 0x3);
        for(int i_0_ = -arg6; i_0_ < 0; i_0_++) {
            for(int i_1_ = i; i_1_ < 0; i_1_++) {
                if(arg1[arg3++] != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                if(arg1[arg3++] != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                if(arg1[arg3++] != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                if(arg1[arg3++] != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            for(int i_2_ = arg5; i_2_ < 0; i_2_++) {
                if(arg1[arg3++] != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public void method672(RSString arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, int arg7, int arg8, int arg9) {
        if(arg0 != null) {
            int i = 0;
            int i_3_ = 0;
            RSString class1 = Class40_Sub5_Sub17_Sub3.method777(-18596, 100);
            int i_4_ = -1;
            int i_5_ = 0;
            RSString class1_6_ = null;
            if(arg9 == 0)
                arg9 = anInt2920;
            boolean bool = true;
            if(arg4 < anInt2920 + anInt2919 + arg9 && arg4 < arg9 + arg9)
                bool = false;
            int i_7_ = 0;
            int i_8_ = arg0.method59(-3136);
            for(int i_9_ = 0; i_9_ < i_8_; i_9_++) {
                int i_10_ = arg0.method55(i_9_, false);
                if(i_10_ == 64 && i_9_ + 4 < i_8_ && arg0.method55(i_9_ + 4, false) == 64) {
                    class1_6_ = arg0.method68(i_9_, i_9_ + 5);
                    class1.method72(class1_6_, (byte) -87);
                    i_9_ += 4;
                } else if(i_10_ == 92 && i_9_ + 1 < i_8_ && arg0.method55(i_9_ + 1, false) == 110) {
                    class1_6_ = null;
                    aClass1Array2897[i_7_++] = class1.method68(i_3_, class1.method59(-3136)).method89(false);
                    i_3_ = class1.method59(-3136);
                    i = 0;
                    i_4_ = -1;
                    i_9_++;
                } else {
                    class1.method78(-62, i_10_);
                    i += method689(i_10_);
                    if(i_10_ == 32 || i_10_ == 45) {
                        i_4_ = class1.method59(-3136);
                        i_5_ = i;
                    }
                    if(bool && i > arg3 && i_4_ >= 0) {
                        aClass1Array2897[i_7_++] = class1.method68(i_3_, i_4_).method89(false);
                        i_3_ = i_4_;
                        i_4_ = -1;
                        i -= i_5_;
                        if(class1_6_ != null && i_3_ > 4) {
                            i_3_ -= 5;
                            class1.method69(class1_6_, 16039, i_3_);
                        }
                    }
                }
            }
            if(class1.method59(-3136) > i_3_)
                aClass1Array2897[i_7_++] = class1.method68(i_3_, class1.method59(-3136)).method89(false);
            if(arg8 == 3 && i_7_ == 1)
                arg8 = 1;
            int i_11_;
            if(arg8 == 0)
                i_11_ = arg2 + anInt2920;
            else if(arg8 == 1)
                i_11_ = arg2 + anInt2920 + (arg4 - anInt2920 - anInt2919 - (i_7_ - 1) * arg9) / 2;
            else if(arg8 == 2)
                i_11_ = arg2 + arg4 - anInt2919 - (i_7_ - 1) * arg9;
            else {
                int i_12_ = ((arg4 - anInt2920 - anInt2919 - (i_7_ - 1) * arg9) / (i_7_ + 1));
                if(i_12_ < 0)
                    i_12_ = 0;
                i_11_ = arg2 + anInt2920 + i_12_;
                arg9 += i_12_;
            }
            for(int i_13_ = 0; i_13_ < i_7_; i_13_++) {
                if(arg7 == 0)
                    method683(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6);
                else if(arg7 == 1)
                    method688(aClass1Array2897[i_13_], arg1 + arg3 / 2, i_11_, arg5, arg6);
                else if(arg7 == 2)
                    method677(aClass1Array2897[i_13_], arg1 + arg3, i_11_, arg5, arg6);
                else if(i_13_ == i_7_ - 1)
                    method683(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6);
                else
                    method680(aClass1Array2897[i_13_], arg1, i_11_, arg5, arg6, arg3);
                i_11_ += arg9;
            }
        }
    }

    public void method673(RSString arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg0 != null) {
            arg1 -= method685(arg0) / 2;
            arg2 -= anInt2910;
            for(int i = 0; i < arg0.anInt1680; i++) {
                int i_14_ = arg0.aByteArray1692[i] & 0xff;
                if(i_14_ != 32)
                    method682(aByteArrayArray2914[i_14_], arg1, (arg2 + anIntArray2911[i_14_] + (int) (Math.sin((double) i / 2.0 + (double) arg4 / 5.0) * 5.0)), anIntArray2907[i_14_], anIntArray2915[i_14_], arg3);
                arg1 += anIntArray2907[i_14_];
            }
        }
    }

    public void method674(int[] arg0, byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        arg2 = ((arg2 & 0xff00ff) * arg9 & ~0xff00ff) + ((arg2 & 0xff00) * arg9 & 0xff0000) >> 8;
        arg9 = 256 - arg9;
        for(int i = -arg6; i < 0; i++) {
            for(int i_15_ = -arg5; i_15_ < 0; i_15_++) {
                if(arg1[arg3++] != 0) {
                    int i_16_ = arg0[arg4];
                    arg0[arg4++] = ((((i_16_ & 0xff00ff) * arg9 & ~0xff00ff) + ((i_16_ & 0xff00) * arg9 & 0xff0000)) >> 8) + arg2;
                } else
                    arg4++;
            }
            arg4 += arg7;
            arg3 += arg8;
        }
    }

    public void method675(RSString arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg0 != null) {
            arg1 -= method685(arg0) / 2;
            arg2 -= anInt2910;
            for(int i = 0; i < arg0.method59(-3136); i++) {
                int i_17_ = arg0.aByteArray1692[i] & 0xff;
                if(i_17_ != 32)
                    method682(aByteArrayArray2914[i_17_], arg1 + (int) (Math.sin((double) i / 5.0 + (double) arg4 / 5.0) * 5.0), (arg2 + anIntArray2911[i_17_] + (int) (Math.sin((double) i / 3.0 + (double) arg4 / 5.0) * 5.0)), anIntArray2907[i_17_], anIntArray2915[i_17_], arg3);
                arg1 += anIntArray2907[i_17_];
            }
        }
    }

    public void method677(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        method683(arg0, arg1 - method681(arg0), arg2, arg3, arg4);
    }

    public void method678(RSString arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 != null) {
            double d = 7.0 - (double) arg5 / 8.0;
            if(d < 0.0)
                d = 0.0;
            arg1 -= method685(arg0) / 2;
            arg2 -= anInt2910;
            for(int i = 0; i < arg0.method59(-3136); i++) {
                int i_18_ = arg0.aByteArray1692[i] & 0xff;
                if(i_18_ != 32)
                    method682(aByteArrayArray2914[i_18_], arg1, (arg2 + anIntArray2911[i_18_] + (int) (Math.sin((double) i / 1.5 + (double) arg4) * d)), anIntArray2907[i_18_], anIntArray2915[i_18_], arg3);
                arg1 += anIntArray2907[i_18_];
            }
        }
    }

    public void method679(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        int i = arg1 + arg2 * Rasterizer.width;
        int i_19_ = Rasterizer.width - arg3;
        int i_20_ = 0;
        int i_21_ = 0;
        if(arg2 < Rasterizer.viewport_top) {
            int i_22_ = Rasterizer.viewport_top - arg2;
            arg4 -= i_22_;
            arg2 = Rasterizer.viewport_top;
            i_21_ += i_22_ * arg3;
            i += i_22_ * Rasterizer.width;
        }
        if(arg2 + arg4 > Rasterizer.viewport_bottom)
            arg4 -= arg2 + arg4 - Rasterizer.viewport_bottom;
        if(arg1 < Rasterizer.viewport_left) {
            int i_23_ = Rasterizer.viewport_left - arg1;
            arg3 -= i_23_;
            arg1 = Rasterizer.viewport_left;
            i_21_ += i_23_;
            i += i_23_;
            i_20_ += i_23_;
            i_19_ += i_23_;
        }
        if(arg1 + arg3 > Rasterizer.viewport_right) {
            int i_24_ = arg1 + arg3 - Rasterizer.viewport_right;
            arg3 -= i_24_;
            i_20_ += i_24_;
            i_19_ += i_24_;
        }
        if(arg3 > 0 && arg4 > 0)
            method674(Rasterizer.pixels, arg0, arg5, i_21_, i, arg3, arg4, i_19_, i_20_, arg6);
    }

    public void method680(RSString arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        arg0 = arg0.method89(false);
        int i = 0;
        for(int i_25_ = 0; i_25_ < arg0.method59(-3136); i_25_++) {
            if(arg0.method55(i_25_, false) == 32)
                i++;
        }
        int i_26_ = 0;
        int i_27_ = 0;
        if(i > 0)
            i_26_ = (arg5 - method681(arg0)) * 256 / i;
        aBoolean2918 = false;
        int i_28_ = arg1;
        if(arg0 != null) {
            arg2 -= anInt2910;
            for(int i_29_ = 0; i_29_ < arg0.anInt1680; i_29_++) {
                if(arg0.aByteArray1692[i_29_] == 64 && i_29_ + 4 < arg0.anInt1680 && arg0.aByteArray1692[i_29_ + 4] == 64) {
                    int i_30_ = method670(arg0.method68(i_29_ + 1, i_29_ + 4));
                    if(i_30_ != -1)
                        arg3 = i_30_;
                    i_29_ += 4;
                } else {
                    int i_31_ = arg0.aByteArray1692[i_29_] & 0xff;
                    if(i_31_ != 32) {
                        if(arg4)
                            method682(aByteArrayArray2914[i_31_], arg1 + 1, arg2 + anIntArray2911[i_31_] + 1, anIntArray2907[i_31_], anIntArray2915[i_31_], 0);
                        method682(aByteArrayArray2914[i_31_], arg1, arg2 + anIntArray2911[i_31_], anIntArray2907[i_31_], anIntArray2915[i_31_], arg3);
                    }
                    arg1 += anIntArray2907[i_31_];
                    if(i_31_ == 32) {
                        i_27_ += i_26_;
                        arg1 += i_27_ / 256;
                        i_27_ &= 0xff;
                    }
                }
            }
            if(aBoolean2918)
                Rasterizer.method659(i_28_, arg2 + (int) ((double) anInt2910 * 0.7), arg1 - i_28_, 8388608);
        }
    }

    public int method681(RSString arg0) {
        if(arg0 == null)
            return 0;
        int i = 0;
        for(int i_32_ = 0; i_32_ < arg0.anInt1680; i_32_++) {
            if(arg0.aByteArray1692[i_32_] == 64 && i_32_ + 4 < arg0.anInt1680 && arg0.aByteArray1692[i_32_ + 4] == 64)
                i_32_ += 4;
            else
                i += anIntArray2907[arg0.aByteArray1692[i_32_] & 0xff];
        }
        return i;
    }

    public void method682(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        int i = arg1 + arg2 * Rasterizer.width;
        int i_33_ = Rasterizer.width - arg3;
        int i_34_ = 0;
        int i_35_ = 0;
        if(arg2 < Rasterizer.viewport_top) {
            int i_36_ = Rasterizer.viewport_top - arg2;
            arg4 -= i_36_;
            arg2 = Rasterizer.viewport_top;
            i_35_ += i_36_ * arg3;
            i += i_36_ * Rasterizer.width;
        }
        if(arg2 + arg4 > Rasterizer.viewport_bottom)
            arg4 -= arg2 + arg4 - Rasterizer.viewport_bottom;
        if(arg1 < Rasterizer.viewport_left) {
            int i_37_ = Rasterizer.viewport_left - arg1;
            arg3 -= i_37_;
            arg1 = Rasterizer.viewport_left;
            i_35_ += i_37_;
            i += i_37_;
            i_34_ += i_37_;
            i_33_ += i_37_;
        }
        if(arg1 + arg3 > Rasterizer.viewport_right) {
            int i_38_ = arg1 + arg3 - Rasterizer.viewport_right;
            arg3 -= i_38_;
            i_34_ += i_38_;
            i_33_ += i_38_;
        }
        if(arg3 > 0 && arg4 > 0)
            method671(Rasterizer.pixels, arg0, arg5, i_35_, i, arg3, arg4, i_33_, i_34_);
    }

    public void method683(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        aBoolean2918 = false;
        int i = arg1;
        if(arg0 != null) {
            arg2 -= anInt2910;
            for(int i_39_ = 0; i_39_ < arg0.anInt1680; i_39_++) {
                if(arg0.aByteArray1692[i_39_] == 64 && i_39_ + 4 < arg0.anInt1680 && arg0.aByteArray1692[i_39_ + 4] == 64) {
                    int i_40_ = method670(arg0.method68(i_39_ + 1, i_39_ + 4));
                    if(i_40_ != -1)
                        arg3 = i_40_;
                    i_39_ += 4;
                } else {
                    int i_41_ = arg0.aByteArray1692[i_39_] & 0xff;
                    if(i_41_ != 32) {
                        if(arg4)
                            method682(aByteArrayArray2914[i_41_], arg1 + 1, arg2 + anIntArray2911[i_41_] + 1, anIntArray2907[i_41_], anIntArray2915[i_41_], 0);
                        method682(aByteArrayArray2914[i_41_], arg1, arg2 + anIntArray2911[i_41_], anIntArray2907[i_41_], anIntArray2915[i_41_], arg3);
                    }
                    arg1 += anIntArray2907[i_41_];
                }
            }
            if(aBoolean2918)
                Rasterizer.method659(i, arg2 + (int) ((double) anInt2910 * 0.7), arg1 - i, 8388608);
        }
    }

    public void method684(RSString arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        if(arg0 != null) {
            aRandom2902.setSeed((long) arg5);
            int i = 192 + (aRandom2902.nextInt() & 0x1f);
            arg2 -= anInt2910;
            for(int i_42_ = 0; i_42_ < arg0.anInt1680; i_42_++) {
                if(arg0.aByteArray1692[i_42_] == 64 && i_42_ + 4 < arg0.anInt1680 && arg0.aByteArray1692[i_42_ + 4] == 64) {
                    int i_43_ = method670(arg0.method68(i_42_ + 1, i_42_ + 4));
                    if(i_43_ != -1)
                        arg3 = i_43_;
                    i_42_ += 4;
                } else {
                    int i_44_ = arg0.aByteArray1692[i_42_] & 0xff;
                    if(i_44_ != 32) {
                        if(arg4)
                            method679(aByteArrayArray2914[i_44_], arg1 + 1, arg2 + anIntArray2911[i_44_] + 1, anIntArray2907[i_44_], anIntArray2915[i_44_], 0, 192);
                        method679(aByteArrayArray2914[i_44_], arg1, arg2 + anIntArray2911[i_44_], anIntArray2907[i_44_], anIntArray2915[i_44_], arg3, i);
                    }
                    arg1 += anIntArray2907[i_44_];
                    if((aRandom2902.nextInt() & 0x3) == 0)
                        arg1++;
                }
            }
        }
    }

    public int method685(RSString arg0) {
        if(arg0 == null)
            return 0;
        int i = 0;
        for(int i_45_ = 0; i_45_ < arg0.anInt1680; i_45_++)
            i += anIntArray2907[arg0.aByteArray1692[i_45_] & 0xff];
        return i;
    }

    public void method686(RSString arg0, int arg1, int arg2, int arg3) {
        drawString(arg0, arg1 - method685(arg0) / 2, arg2, arg3);
    }

    public void method687(RSString arg0, int arg1, int arg2, int arg3) {
        drawString(arg0, arg1 - method685(arg0), arg2, arg3);
    }

    public void method688(RSString arg0, int arg1, int arg2, int arg3, boolean arg4) {
        method683(arg0, arg1 - method681(arg0) / 2, arg2, arg3, arg4);
    }

    public int method689(int arg0) {
        return anIntArray2907[arg0 & 0xff];
    }

    public void drawString(RSString str, int x, int y, int colour) {
        if(str != null) {
            y -= anInt2910;
            for(int i = 0; i < str.anInt1680; i++) {
                int i_46_ = str.aByteArray1692[i] & 0xff;
                if(i_46_ != 32)
                    method682(aByteArrayArray2914[i_46_], x, y + anIntArray2911[i_46_], anIntArray2907[i_46_], anIntArray2915[i_46_], colour);
                x += anIntArray2907[i_46_];
            }
        }
    }
}
