package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class40_Sub5_Sub9 extends SubNode {
    public static int anInt2562;
    public static RSString aClass1_2564 = Class58.method978("Welt");
    public static RSString aClass1_2566;
    public static DirectColorSprite[] aClass40_Sub5_Sub14_Sub4Array2567;
    public static int anInt2569;
    public static RSString aClass1_2570;
    public static Class6_Sub1 aClass6_Sub1_2571;
    public static int anInt2572;
    public static int anInt2573;
    public static int anInt2575;
    public static int anInt2576;
    public static RSString aClass1_2577;
    public static int anInt2578;
    public static int anInt2580;
    public static int anInt2581;
    public static Class6 aClass6_2582;
    public static RSString aClass1_2583;
    public static int anInt2584;

    static {
        anInt2562 = -1;
        aClass1_2570 = Class58.method978("flash2:");
        aClass1_2566 = aClass1_2570;
        aClass1_2583 = Class58.method978(" million");
        aClass1_2577 = aClass1_2583;
    }

    public int anInt2563;
    public int anInt2565;
    public int anInt2568;
    public int anInt2574;
    public int anInt2579 = 0;

    public static int method614(byte arg0, int arg1, int arg2, int arg3) {

        int i = 114 % ((arg0 + 28) / 59);
            anInt2572++;
            int i_7_ = 256 + -arg3;
            return (((arg3 * (0xff00 & arg2) + i_7_ * (0xff00 & arg1) & 0xff0000) + (~0xff00ff & (0xff00ff & arg1) * i_7_ + (arg3 * (0xff00ff & arg2)))) >> -794214296);

    }

    public static void method616(Class6 arg0, byte arg1) {

        anInt2580++;
            if(arg1 == 85)
                Actor.aClass6_3150 = arg0;

    }

    public static void method617(long arg0, byte arg1) {

        anInt2569++;
            if(arg0 != 0L) {
                if((Class40_Sub5_Sub17_Sub3.anInt3060 >= 100 && (Class44.anInt1049 ^ 0xffffffff) != -2) || ((Class40_Sub5_Sub17_Sub3.anInt3060 ^ 0xffffffff) <= -201))
                    Class44.method895(94, 0, Class59.aClass1_1399, Class66.aClass1_1567);
                else {
                    if(arg1 >= -2)
                        aClass6_Sub1_2571 = null;
                    RSString class1 = Class60.method991(-23, arg0).method85(-4305);
                    for(int i = 0; Class40_Sub5_Sub17_Sub3.anInt3060 > i; i++) {
                        if((arg0 ^ 0xffffffffffffffffL) == (Class59.aLongArray1397[i] ^ 0xffffffffffffffffL)) {
                            Class44.method895(62, 0, (Class40_Sub5_Sub17_Sub6.method832(-124, (new RSString[]{class1, Class62.aClass1_1465}))), Class66.aClass1_1567);
                            return;
                        }
                    }
                    for(int i = 0; Class42.anInt1008 > i; i++) {
                        if((arg0 ^ 0xffffffffffffffffL) == (Class53.aLongArray1267[i] ^ 0xffffffffffffffffL)) {
                            Class44.method895(126, 0, (Class40_Sub5_Sub17_Sub6.method832(75, (new RSString[]{Class44.aClass1_1038, class1, Class39.aClass1_917}))), Class66.aClass1_1567);
                            return;
                        }
                    }
                    if(!class1.method54((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.aClass1_3278), 122)) {
                        Class40_Sub11.aClass1Array2147[(Class40_Sub5_Sub17_Sub3.anInt3060)] = class1;
                        Class59.aLongArray1397[(Class40_Sub5_Sub17_Sub3.anInt3060)] = arg0;
                        Class40_Sub7.anIntArray2131[(Class40_Sub5_Sub17_Sub3.anInt3060)] = 0;
                        Class40_Sub5_Sub17_Sub3.anInt3060++;
                        CollisionMap.anInt139++;
                        ISAAC.aBoolean505 = true;
                        Class32.packetBuffer.putPacket(11453, 114);
                        Class32.packetBuffer.putLong(arg0, false);
                    }
                }
            }

    }

    public static int method619(int arg0, int arg1) {

        return arg0 | arg1;

    }

    public static void method621(int arg0) {

        aClass1_2583 = null;
            if(arg0 == 0) {
                aClass1_2566 = null;
                aClass40_Sub5_Sub14_Sub4Array2567 = null;
                aClass1_2564 = null;
                aClass6_2582 = null;
                aClass1_2577 = null;
                aClass1_2570 = null;
                aClass6_Sub1_2571 = null;
            }

    }

    public void updateTextureBrightness(int arg0, byte arg1) {

        anInt2584++;
            double d = (double) (arg0 >> 1980839856 & 0xff) / 256.0;
            double d_0_ = (double) (arg0 & 0xff) / 256.0;
            double d_1_ = (double) ((arg0 & 0xff68) >> -99983128) / 256.0;
            double d_2_ = d;
            if(d_2_ > d_1_)
                d_2_ = d_1_;
            if(d_0_ < d_2_)
                d_2_ = d_0_;
            double d_3_ = d;
            if(d_3_ < d_1_)
                d_3_ = d_1_;
            double d_4_ = 0.0;
            if(d_3_ < d_0_)
                d_3_ = d_0_;
            double d_5_ = (d_3_ + d_2_) / 2.0;
            anInt2563 = (int) (d_5_ * 256.0);
            double d_6_ = 0.0;
            if(d_3_ != d_2_) {
                if(d_5_ < 0.5)
                    d_6_ = (d_3_ - d_2_) / (d_3_ + d_2_);
                if(d_5_ >= 0.5)
                    d_6_ = (-d_2_ + d_3_) / (-d_2_ + (-d_3_ + 2.0));
                if(d == d_3_)
                    d_4_ = (-d_0_ + d_1_) / (-d_2_ + d_3_);
                else if(d_3_ != d_1_) {
                    if(d_3_ == d_0_)
                        d_4_ = (d - d_1_) / (-d_2_ + d_3_) + 4.0;
                } else
                    d_4_ = 2.0 + (d_0_ - d) / (d_3_ - d_2_);
            }
            d_4_ /= 6.0;
            if(arg1 != -18)
                aClass40_Sub5_Sub14_Sub4Array2567 = null;
            if(anInt2563 >= 0) {
                if(anInt2563 > 255)
                    anInt2563 = 255;
            } else
                anInt2563 = 0;
            if(d_5_ > 0.5)
                anInt2568 = (int) ((-d_5_ + 1.0) * d_6_ * 512.0);
            else
                anInt2568 = (int) (d_5_ * d_6_ * 512.0);
            anInt2574 = (int) (256.0 * d_6_);
            if(anInt2568 < 1)
                anInt2568 = 1;
            anInt2565 = (int) (d_4_ * (double) anInt2568);
            if((anInt2574 ^ 0xffffffff) <= -1) {
                if(anInt2574 > 255)
                    anInt2574 = 255;
            } else
                anInt2574 = 0;

    }

    public void method615(boolean arg0) {
        anInt2575++;
        updateTextureBrightness(anInt2579, (byte) -18);
        if(arg0 != true)
            aClass1_2583 = null;
    }

    public void method618(byte arg0, int arg1, Buffer arg2) {
        for(; ; ) {
            int i = arg2.getUnsignedByte();
            if(i == 0)
                break;
            method620((byte) -121, i, arg2, arg1);
        }
        anInt2573++;
        if(arg0 < 125)
            aClass6_Sub1_2571 = null;
    }

    public void method620(byte arg0, int arg1, Buffer arg2, int arg3) {
        if(arg0 != -121)
            method621(73);
        anInt2578++;
        if((arg1 ^ 0xffffffff) == -2)
            anInt2579 = arg2.getTri(true);
    }
}
