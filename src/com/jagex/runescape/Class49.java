package com.jagex.runescape;

import com.jagex.runescape.media.renderable.Model;

public class Class49 {
    public static int anInt1142;
    public static RSString aClass1_1143;
    public static int anInt1144;
    public static Cache aClass9_1145;
    public static RSString aClass1_1146 = Class58.method978("An");
    public static volatile int anInt1147 = 0;
    public static RSString aClass1_1148;
    public static RSString aClass1_1149;
    public static Class6 aClass6_1150;
    public static int anInt1151;
    public static Class40_Sub9_Sub1 aClass40_Sub9_Sub1_1152;
    public static RSString aClass1_1153;
    public static int anInt1154;
    public static RSString aClass1_1155;
    public static RSString aClass1_1156;

    static {
        aClass1_1143 = (Class58.method978("sind fehlgeschlagen)3 Bitte warten Sie 5 Minuten)1"));
        aClass9_1145 = new Cache(30);
        aClass1_1149 = Class58.method978("Empf-=nger:");
        anInt1151 = 0;
        aClass1_1153 = Class58.method978("Bitte warten Sie)3)3)3");
        aClass1_1155 = (Class58.method978("Wir vermuten)1 dass jemand Ihr Passwort kennt)3"));
        aClass1_1156 = Class58.method978("Loading ignore list");
        aClass1_1148 = aClass1_1156;
    }

    public static void method929(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {

        int i = 0;
        int i_0_ = 0x7ff & -arg3 + 2048;
        int i_1_ = 0;
        int i_2_ = 2048 - arg0 & 0x7ff;
        anInt1144++;
        int i_3_ = arg6;
        if(arg5 != (i_2_ ^ 0xffffffff)) {
            int i_4_ = Model.COSINE[i_2_];
            int i_5_ = Model.SINE[i_2_];
            int i_6_ = i_1_ * i_4_ + -(i_5_ * i_3_) >> 530951344;
            i_3_ = i_4_ * i_3_ + i_5_ * i_1_ >> -1614421968;
            i_1_ = i_6_;
        }
        if(i_0_ != 0) {
            int i_7_ = Model.COSINE[i_0_];
            int i_8_ = Model.SINE[i_0_];
            int i_9_ = i_7_ * i + i_3_ * i_8_ >> -435436048;
            i_3_ = -(i * i_8_) + i_3_ * i_7_ >> -2076141520;
            i = i_9_;
        }
        Class68_Sub1.anInt2210 = arg3;
        Class32.anInt769 = -i_1_ + arg2;
        Class12.anInt388 = -i + arg1;
        Class26.anInt627 = arg0;
        Class40_Sub5_Sub6.anInt2443 = arg4 + -i_3_;

    }

    public static void method930(int arg0) {

        aClass1_1153 = null;
        aClass9_1145 = null;
        aClass40_Sub9_Sub1_1152 = null;
        aClass1_1155 = null;
        aClass1_1149 = null;
        if(arg0 > 11) {
            aClass1_1148 = null;
            aClass1_1146 = null;
            aClass1_1143 = null;
            aClass1_1156 = null;
            aClass6_1150 = null;
        }

    }
}
