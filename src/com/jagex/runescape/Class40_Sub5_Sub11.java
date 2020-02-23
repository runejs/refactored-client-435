package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class40_Sub5_Sub11 extends SubNode {
    public static int anInt2618;
    public static int anInt2619;
    public static RSString aClass1_2620 = RSString.CreateString("yellow:");
    public static int anInt2621 = 0;
    public static RSString aClass1_2622 = RSString.CreateString("Hide");
    public static int anInt2624;
    public static volatile int mouseY = 0;
    public static int[] tabWidgetIds = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static int anInt2628 = 0;
    public static RSString aClass1_2629 = RSString.CreateString("button near the top of that page)3");
    public static volatile boolean aBoolean2631 = true;
    public static int anInt2632;

    public int anInt2633 = 0;

    public static void method631(Actor arg0, boolean arg1) {

        if(arg1 != false)
            method633(-48);
        int i = arg0.anInt3125 * 128 + (64 * arg0.anInt3096);
        int i_0_ = arg0.anInt3112 + -Node.anInt926;
        if(arg0.anInt3073 == 0)
            arg0.anInt3080 = 1024;
        anInt2619++;
        if(arg0.anInt3073 == 1)
            arg0.anInt3080 = 1536;
        if(arg0.anInt3073 == 2)
            arg0.anInt3080 = 0;
        int i_1_ = arg0.anInt3096 * 64 + 128 * arg0.anInt3081;
        arg0.anInt3098 += (i - arg0.anInt3098) / i_0_;
        if((arg0.anInt3073 ^ 0xffffffff) == -4)
            arg0.anInt3080 = 512;
        arg0.anInt3074 = 0;
        arg0.anInt3089 += (-arg0.anInt3089 + i_1_) / i_0_;

    }

    public static void method632(int arg0) {

        if(arg0 == -1) {
            aClass1_2629 = null;
            aClass1_2620 = null;
            tabWidgetIds = null;
            aClass1_2622 = null;
        }

    }

    public static void method633(int arg0) {

        if(arg0 == -1) {
            for(int i = 0; i < Actor.anInt3153; i++) {
                int i_2_ = Class24.anIntArray578[i];
                Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_2_]);
                int i_3_ = Cache.outgoingbuffer.getUnsignedByte();
                if((i_3_ & 0x2) != 0)
                    i_3_ += (Cache.outgoingbuffer.getUnsignedByte() << 1874166152);
                Class68_Sub1.parsePlayerUpdateMasks(class40_sub5_sub17_sub4_sub1, (byte) 51, i_3_, i_2_);
            }
            anInt2632++;
        }

    }

    public void method634(Buffer arg0, int arg1) {
        anInt2624++;
        for(; ; ) {
            int i = arg0.getUnsignedByte();
            if((i ^ 0xffffffff) == -1)
                break;
            method635(i, 512, arg0);
        }
        if(arg1 != 0)
            method632(6);
    }

    public void method635(int arg0, int arg1, Buffer arg2) {

        if(arg1 != 512)
            method631(null, true);
        if((arg0 ^ 0xffffffff) == -6)
            anInt2633 = arg2.getUnsignedShortBE();
        anInt2618++;

    }
}
