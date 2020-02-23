package com.jagex.runescape;

import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class40_Sub5_Sub15 extends SubNode {
    public static RSString aClass1_2773 = (RSString.CreateString("Um ein neues Spielkonto zu erstellen)1 m-Ussen Sie"));
    public static RSString aClass1_2774;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2775;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array2776;
    public static int[] anIntArray2777 = {8, 11, 4, 6, 9, 7, 10};
    public static int anInt2778;
    public static CacheIndex aCacheIndex_2779;
    public static int inputType;
    public static RSString aClass1_2781 = RSString.CreateString(" Sekunde(Xn(Y -Ubertragen)3");
    public static int anInt2782;
    public static int anInt2783;
    public static boolean aBoolean2784;
    public static int anInt2785;
    public static RSString aClass1_2786;
    public static RSString aClass1_2787;
    public static int[] anIntArray2788;
    public static int anInt2789;
    public static RSString aClass1_2790;
    public static int anInt2791;
    public static RSString aClass1_2792;
    public static RSString aClass1_2793;

    static {
        inputType = 0;
        anInt2782 = 0;
        anInt2778 = 0;
        anIntArray2788 = new int[]{16, 32, 64, 128};
        aClass1_2787 = RSString.CreateString("sideicons");
        aBoolean2784 = false;
        aClass1_2790 = RSString.CreateString("Friends");
        aClass1_2792 = RSString.CreateString("Examine");
        aClass1_2786 = aClass1_2790;
        aClass1_2793 = RSString.CreateString("Ihr Charakter)2Profil wird in:");
        anInt2791 = -8 + (int) (17.0 * Math.random());
        aClass1_2774 = aClass1_2792;
    }

    public Class41[] aClass41Array2794;

    public Class40_Sub5_Sub15(CacheIndex arg0, CacheIndex arg1, int arg2, boolean arg3) {

        Class45 class45 = new Class45();
        int i = arg0.method190(arg2, (byte) 16);
        aClass41Array2794 = new Class41[i];
        int[] is = arg0.method192(arg2, true);
        for(int i_0_ = 0; is.length > i_0_; i_0_++) {
            byte[] is_1_ = arg0.getFile(is[i_0_], arg2);
            Class40_Sub13 class40_sub13 = null;
            int i_2_ = is_1_[1] & 0xff | is_1_[0] << 490068232 & 0xff00;
            for(Class40_Sub13 class40_sub13_3_ = (Class40_Sub13) class45.method902((byte) -90); class40_sub13_3_ != null; class40_sub13_3_ = (Class40_Sub13) class45.method909(-4)) {
                if(i_2_ == class40_sub13_3_.anInt2175) {
                    class40_sub13 = class40_sub13_3_;
                    break;
                }
            }
            if(class40_sub13 == null) {
                byte[] is_4_;
                if(!arg3)
                    is_4_ = arg1.method182(0, -16, i_2_);
                else
                    is_4_ = arg1.method182(i_2_, -122, 0);
                class40_sub13 = new Class40_Sub13(i_2_, is_4_);
                class45.method904(class40_sub13, 60);
            }
            aClass41Array2794[is[i_0_]] = new Class41(is_1_, class40_sub13);
        }

    }

    public static void method734(int arg0) {

        aClass1_2792 = null;
        aClass40_Sub5_Sub14_Sub2_2775 = null;
        aClass1_2790 = null;
        aClass40_Sub5_Sub14_Sub2Array2776 = null;
        anIntArray2777 = null;
        int i = -41 % ((32 - arg0) / 40);
        aClass1_2787 = null;
        aClass1_2773 = null;
        aCacheIndex_2779 = null;
        anIntArray2788 = null;
        aClass1_2793 = null;
        aClass1_2786 = null;
        aClass1_2781 = null;
        aClass1_2774 = null;

    }

    public static boolean method735(byte arg0, int arg1) {

        anInt2783++;
        if(arg1 >= 97 && arg1 <= 122)
            return true;
        if((arg1 ^ 0xffffffff) <= -66 && arg1 <= 90)
            return true;
        if((arg1 ^ 0xffffffff) <= -49 && arg1 <= 57)
            return true;
        if(arg0 != -37)
            method734(31);
        return false;

    }

    public static void method736(boolean arg0, Actor arg1) {
        anInt2789++;
        arg1.aBoolean3105 = false;
        if((arg1.anInt3077 ^ 0xffffffff) != 0) {
            Class40_Sub5_Sub7 class40_sub5_sub7 = Class68_Sub1.method1050(arg1.anInt3077, 2);
            if(class40_sub5_sub7 == null || class40_sub5_sub7.anIntArray2485 == null)
                arg1.anInt3077 = -1;
            else {
                arg1.anInt3120++;
                if(((arg1.anInt3116 < class40_sub5_sub7.anIntArray2485.length)) && (class40_sub5_sub7.anIntArray2466[arg1.anInt3116] < arg1.anInt3120)) {
                    arg1.anInt3116++;
                    arg1.anInt3120 = 1;
                }
                if(class40_sub5_sub7.anIntArray2485.length <= arg1.anInt3116) {
                    arg1.anInt3116 = 0;
                    arg1.anInt3120 = 0;
                }
            }
        }
        if(arg1.anInt3091 != -1 && Node.anInt926 >= arg1.anInt3093) {
            if((arg1.anInt3140 ^ 0xffffffff) > -1)
                arg1.anInt3140 = 0;
            int i = Class37.method431(arg1.anInt3091, 13).anInt2287;
            if(i == -1)
                arg1.anInt3091 = -1;
            else {
                Class40_Sub5_Sub7 class40_sub5_sub7 = Class68_Sub1.method1050(i, 2);
                if(class40_sub5_sub7 == null || class40_sub5_sub7.anIntArray2485 == null)
                    arg1.anInt3091 = -1;
                else {
                    arg1.anInt3129++;
                    if(((class40_sub5_sub7.anIntArray2485.length > arg1.anInt3140)) && ((arg1.anInt3129 > class40_sub5_sub7.anIntArray2466[arg1.anInt3140]))) {
                        arg1.anInt3129 = 1;
                        arg1.anInt3140++;
                    }
                    if(((class40_sub5_sub7.anIntArray2485.length <= arg1.anInt3140)) && ((arg1.anInt3140 ^ 0xffffffff) > -1 || ((class40_sub5_sub7.anIntArray2485.length <= arg1.anInt3140))))
                        arg1.anInt3091 = -1;
                }
            }
        }
        if(arg0 == true) {
            if(arg1.anInt3141 != -1 && arg1.anInt3122 <= 1) {
                Class40_Sub5_Sub7 class40_sub5_sub7 = Class68_Sub1.method1050(arg1.anInt3141, 2);
                if(class40_sub5_sub7.anInt2470 == 1 && (arg1.anInt3094 ^ 0xffffffff) < -1 && arg1.anInt3112 <= Node.anInt926 && Node.anInt926 > arg1.anInt3107) {
                    arg1.anInt3122 = 1;
                    return;
                }
            }
            if((arg1.anInt3141 ^ 0xffffffff) != 0 && arg1.anInt3122 == 0) {
                Class40_Sub5_Sub7 class40_sub5_sub7 = Class68_Sub1.method1050(arg1.anInt3141, 2);
                if(class40_sub5_sub7 != null && class40_sub5_sub7.anIntArray2485 != null) {
                    arg1.anInt3115++;
                    if((class40_sub5_sub7.anIntArray2485.length > arg1.anInt3104) && (class40_sub5_sub7.anIntArray2466[arg1.anInt3104] < arg1.anInt3115)) {
                        arg1.anInt3104++;
                        arg1.anInt3115 = 1;
                    }
                    if((class40_sub5_sub7.anIntArray2485.length <= arg1.anInt3104)) {
                        arg1.anInt3104 -= class40_sub5_sub7.anInt2497;
                        arg1.anInt3095++;
                        if((class40_sub5_sub7.anInt2495 <= arg1.anInt3095))
                            arg1.anInt3141 = -1;
                        if((arg1.anInt3104 ^ 0xffffffff) > -1 || (arg1.anInt3104 >= class40_sub5_sub7.anIntArray2485.length))
                            arg1.anInt3141 = -1;
                    }
                    arg1.aBoolean3105 = class40_sub5_sub7.aBoolean2496;
                } else
                    arg1.anInt3141 = -1;
            }
            if(arg1.anInt3122 > 0)
                arg1.anInt3122--;
        }
    }

    public boolean method737(int arg0, int arg1) {

        int i = 104 % ((58 - arg1) / 61);
        anInt2785++;
        return aClass41Array2794[arg0].aBoolean985;

    }
}
