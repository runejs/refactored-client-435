/* Class40_Sub5_Sub14 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Rasterizer extends SubNode {
    public static int[] anIntArray2766;
    public static int anInt2767 = 0;
    public static int anInt2768;
    public static int anInt2769;
    public static int anInt2770;
    public static int anInt2771;
    public static int anInt2772 = 0;

    static {
        anInt2771 = 0;
        anInt2770 = 0;
    }

    public static void method654(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        method658(arg0, arg1, arg2, arg4, arg5);
        method658(arg0, arg1 + arg3 - 1, arg2, arg4, arg5);
        if(arg3 >= 3) {
            method660(arg0, arg1 + 1, arg3 - 2, arg4, arg5);
            method660(arg0 + arg2 - 1, arg1 + 1, arg3 - 2, arg4, arg5);
        }
    }

    public static void method655(int arg0, int arg1, int arg2, int arg3) {
        if(arg0 < 0)
            arg0 = 0;
        if(arg1 < 0)
            arg1 = 0;
        if(arg2 > anInt2768)
            arg2 = anInt2768;
        if(arg3 > anInt2769)
            arg3 = anInt2769;
        anInt2771 = arg0;
        anInt2767 = arg1;
        anInt2772 = arg2;
        anInt2770 = arg3;
    }

    public static void method656(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg0 < anInt2771) {
            arg2 -= anInt2771 - arg0;
            arg0 = anInt2771;
        }
        if(arg1 < anInt2767) {
            arg3 -= anInt2767 - arg1;
            arg1 = anInt2767;
        }
        if(arg0 + arg2 > anInt2772)
            arg2 = anInt2772 - arg0;
        if(arg1 + arg3 > anInt2770)
            arg3 = anInt2770 - arg1;
        int i = anInt2768 - arg2;
        int i_0_ = arg0 + arg1 * anInt2768;
        for(int i_1_ = -arg3; i_1_ < 0; i_1_++) {
            for(int i_2_ = -arg2; i_2_ < 0; i_2_++)
                anIntArray2766[i_0_++] = arg4;
            i_0_ += i;
        }
    }

    public static void method657(int[] arg0) {
        anInt2771 = arg0[0];
        anInt2767 = arg0[1];
        anInt2772 = arg0[2];
        anInt2770 = arg0[3];
    }

    public static void method658(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg1 >= anInt2767 && arg1 < anInt2770) {
            if(arg0 < anInt2771) {
                arg2 -= anInt2771 - arg0;
                arg0 = anInt2771;
            }
            if(arg0 + arg2 > anInt2772)
                arg2 = anInt2772 - arg0;
            int i = 256 - arg4;
            int i_3_ = (arg3 >> 16 & 0xff) * arg4;
            int i_4_ = (arg3 >> 8 & 0xff) * arg4;
            int i_5_ = (arg3 & 0xff) * arg4;
            int i_6_ = arg0 + arg1 * anInt2768;
            for(int i_7_ = 0; i_7_ < arg2; i_7_++) {
                int i_8_ = (anIntArray2766[i_6_] >> 16 & 0xff) * i;
                int i_9_ = (anIntArray2766[i_6_] >> 8 & 0xff) * i;
                int i_10_ = (anIntArray2766[i_6_] & 0xff) * i;
                int i_11_ = ((i_3_ + i_8_ >> 8 << 16) + (i_4_ + i_9_ >> 8 << 8) + (i_5_ + i_10_ >> 8));
                anIntArray2766[i_6_++] = i_11_;
            }
        }
    }

    public static void method659(int arg0, int arg1, int arg2, int arg3) {
        if(arg1 >= anInt2767 && arg1 < anInt2770) {
            if(arg0 < anInt2771) {
                arg2 -= anInt2771 - arg0;
                arg0 = anInt2771;
            }
            if(arg0 + arg2 > anInt2772)
                arg2 = anInt2772 - arg0;
            int i = arg0 + arg1 * anInt2768;
            for(int i_12_ = 0; i_12_ < arg2; i_12_++)
                anIntArray2766[i + i_12_] = arg3;
        }
    }

    public static void method660(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg0 >= anInt2771 && arg0 < anInt2772) {
            if(arg1 < anInt2767) {
                arg2 -= anInt2767 - arg1;
                arg1 = anInt2767;
            }
            if(arg1 + arg2 > anInt2770)
                arg2 = anInt2770 - arg1;
            int i = 256 - arg4;
            int i_13_ = (arg3 >> 16 & 0xff) * arg4;
            int i_14_ = (arg3 >> 8 & 0xff) * arg4;
            int i_15_ = (arg3 & 0xff) * arg4;
            int i_16_ = arg0 + arg1 * anInt2768;
            for(int i_17_ = 0; i_17_ < arg2; i_17_++) {
                int i_18_ = (anIntArray2766[i_16_] >> 16 & 0xff) * i;
                int i_19_ = (anIntArray2766[i_16_] >> 8 & 0xff) * i;
                int i_20_ = (anIntArray2766[i_16_] & 0xff) * i;
                int i_21_ = ((i_13_ + i_18_ >> 8 << 16) + (i_14_ + i_19_ >> 8 << 8) + (i_15_ + i_20_ >> 8));
                anIntArray2766[i_16_] = i_21_;
                i_16_ += anInt2768;
            }
        }
    }

    public static void method661(int[] arg0) {
        arg0[0] = anInt2771;
        arg0[1] = anInt2767;
        arg0[2] = anInt2772;
        arg0[3] = anInt2770;
    }

    public static void method662() {
        anInt2771 = 0;
        anInt2767 = 0;
        anInt2772 = anInt2768;
        anInt2770 = anInt2769;
    }

    public static void method663() {
        int i = 0;
        int i_22_ = anInt2768 * anInt2769 - 7;
        while(i < i_22_) {
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
            anIntArray2766[i++] = 0;
        }
        i_22_ += 7;
        while(i < i_22_)
            anIntArray2766[i++] = 0;
    }

    public static void method664(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg0 < anInt2771) {
            arg2 -= anInt2771 - arg0;
            arg0 = anInt2771;
        }
        if(arg1 < anInt2767) {
            arg3 -= anInt2767 - arg1;
            arg1 = anInt2767;
        }
        if(arg0 + arg2 > anInt2772)
            arg2 = anInt2772 - arg0;
        if(arg1 + arg3 > anInt2770)
            arg3 = anInt2770 - arg1;
        int i = 256 - arg5;
        int i_23_ = (arg4 >> 16 & 0xff) * arg5;
        int i_24_ = (arg4 >> 8 & 0xff) * arg5;
        int i_25_ = (arg4 & 0xff) * arg5;
        int i_26_ = anInt2768 - arg2;
        int i_27_ = arg0 + arg1 * anInt2768;
        for(int i_28_ = 0; i_28_ < arg3; i_28_++) {
            for(int i_29_ = -arg2; i_29_ < 0; i_29_++) {
                int i_30_ = (anIntArray2766[i_27_] >> 16 & 0xff) * i;
                int i_31_ = (anIntArray2766[i_27_] >> 8 & 0xff) * i;
                int i_32_ = (anIntArray2766[i_27_] & 0xff) * i;
                int i_33_ = ((i_23_ + i_30_ >> 8 << 16) + (i_24_ + i_31_ >> 8 << 8) + (i_25_ + i_32_ >> 8));
                anIntArray2766[i_27_++] = i_33_;
            }
            i_27_ += i_26_;
        }
    }

    public static void method665(int arg0, int arg1, int arg2, int arg3, int arg4) {
        method659(arg0, arg1, arg2, arg4);
        method659(arg0, arg1 + arg3 - 1, arg2, arg4);
        method668(arg0, arg1, arg3, arg4);
        method668(arg0 + arg2 - 1, arg1, arg3, arg4);
    }

    public static void method666(int arg0, int arg1, int arg2, int arg3, int arg4) {
        arg2 -= arg0;
        arg3 -= arg1;
        if(arg3 == 0) {
            if(arg2 >= 0)
                method659(arg0, arg1, arg2 + 1, arg4);
            else
                method659(arg0 + arg2, arg1, -arg2 + 1, arg4);
        } else if(arg2 == 0) {
            if(arg3 >= 0)
                method668(arg0, arg1, arg3 + 1, arg4);
            else
                method668(arg0, arg1 + arg3, -arg3 + 1, arg4);
        } else {
            if(arg2 + arg3 < 0) {
                arg0 += arg2;
                arg2 = -arg2;
                arg1 += arg3;
                arg3 = -arg3;
            }
            if(arg2 > arg3) {
                arg1 <<= 16;
                arg1 += 32768;
                arg3 <<= 16;
                int i = (int) Math.floor((double) arg3 / (double) arg2 + 0.5);
                arg2 += arg0;
                if(arg0 < anInt2771) {
                    arg1 += i * (anInt2771 - arg0);
                    arg0 = anInt2771;
                }
                if(arg2 >= anInt2772)
                    arg2 = anInt2772 - 1;
                for(/**/; arg0 <= arg2; arg0++) {
                    int i_34_ = arg1 >> 16;
                    if(i_34_ >= anInt2767 && i_34_ < anInt2770)
                        anIntArray2766[arg0 + i_34_ * anInt2768] = arg4;
                    arg1 += i;
                }
            } else {
                arg0 <<= 16;
                arg0 += 32768;
                arg2 <<= 16;
                int i = (int) Math.floor((double) arg2 / (double) arg3 + 0.5);
                arg3 += arg1;
                if(arg1 < anInt2767) {
                    arg0 += i * (anInt2767 - arg1);
                    arg1 = anInt2767;
                }
                if(arg3 >= anInt2770)
                    arg3 = anInt2770 - 1;
                for(/**/; arg1 <= arg3; arg1++) {
                    int i_35_ = arg0 >> 16;
                    if(i_35_ >= anInt2771 && i_35_ < anInt2772)
                        anIntArray2766[i_35_ + arg1 * anInt2768] = arg4;
                    arg0 += i;
                }
            }
        }
    }

    public static void method667() {
        anIntArray2766 = null;
    }

    public static void method668(int arg0, int arg1, int arg2, int arg3) {
        if(arg0 >= anInt2771 && arg0 < anInt2772) {
            if(arg1 < anInt2767) {
                arg2 -= anInt2767 - arg1;
                arg1 = anInt2767;
            }
            if(arg1 + arg2 > anInt2770)
                arg2 = anInt2770 - arg1;
            int i = arg0 + arg1 * anInt2768;
            for(int i_36_ = 0; i_36_ < arg2; i_36_++)
                anIntArray2766[i + i_36_ * anInt2768] = arg3;
        }
    }

    public static void method669(int[] arg0, int arg1, int arg2) {
        anIntArray2766 = arg0;
        anInt2768 = arg1;
        anInt2769 = arg2;
        method655(0, 0, arg1, arg2);
    }
}
