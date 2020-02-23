package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;

import java.awt.*;

public class Player extends Actor {
    public static RSString aClass1_3256 = RSString.CreateString("green:");
    public static int anInt3264 = 0;
    public static int anInt3267;
    public static RSString aClass1_3269 = RSString.CreateString("Mitteilung");
    public static byte[] aByteArray3270;
    public static RSString aClass1_3275 = RSString.CreateString("Bitte starten Sie eine Mitgliedschaft");
    public static int[] anIntArray3284;
    public static RSString aClass1_3285 = RSString.CreateString("Keine Antwort vom Anmelde)2Server)3");
    public static RSString aClass1_3286 = RSString.CreateString("Try again in 60 secs)3)3)3");
    public static int anInt3288 = 0;
    public static RSString aClass1_3290 = RSString.CreateString("Spieler kann nicht gefunden werden: ");
    public static Player localPlayer;
    public int anInt3257;
    public int anInt3258;
    public int anInt3260 = 0;
    public int anInt3262;
    public Model aClass40_Sub5_Sub17_Sub5_3265;
    public int anInt3266 = 0;
    public int anInt3268;
    public int anInt3271;
    public int anInt3272;
    public int anInt3273;
    public int anInt3274;
    public int anInt3276;
    public RSString playerName;
    public int anInt3281;
    public Class30 aClass30_3282;
    public int anInt3283;
    public boolean aBoolean3287;
    public int anInt3289;
    public int anInt3291;

    public Player() {
        anInt3257 = 0;
        anInt3273 = -1;
        anInt3268 = -1;
        anInt3274 = 0;
        anInt3283 = 0;
        aBoolean3287 = false;
    }

    public static void method792(int arg0) {
        try {
            if(arg0 < 106)
                return;
            Graphics graphics = GameFrame.aCanvas1469.getGraphics();
            Class40_Sub5_Sub4.aClass68_2350.method1044(0, 4, graphics, 4);
        } catch(Exception exception) {
            GameFrame.aCanvas1469.repaint();
        }
    }

    public static boolean method793(byte arg0, int arg1) {
        if((arg1 ^ 0xffffffff) > -33)
            return false;
        if(arg1 == 127)
            return false;
        if(arg0 < 118)
            aByteArray3270 = null;
        return (arg1 ^ 0xffffffff) > -130 || arg1 > 159;
    }

    public static void method794(boolean arg0) {
        aClass1_3275 = null;
        aClass1_3269 = null;
        aByteArray3270 = null;
        aClass1_3285 = null;
        anIntArray3284 = null;
        if(arg0 == false) {
            aClass1_3286 = null;
            aClass1_3290 = null;
            aClass1_3256 = null;
        }
    }

    public Model method756(int arg0) {
        if(aClass30_3282 == null)
            return null;
        int i = 71 % ((41 - arg0) / 47);
        Class40_Sub5_Sub7 class40_sub5_sub7 = (anInt3141 == -1 || (anInt3122 ^ 0xffffffff) != -1 ? null : Class68_Sub1.method1050(anInt3141, 2));
        Class40_Sub5_Sub7 class40_sub5_sub7_0_ = (((anInt3077 ^ 0xffffffff) != 0 && !aBoolean3287 && (anInt3126 != anInt3077 || class40_sub5_sub7 == null)) ? Class68_Sub1.method1050(anInt3077, 2) : null);
        Model class40_sub5_sub17_sub5 = aClass30_3282.method377(class40_sub5_sub7, class40_sub5_sub7_0_, anInt3116, anInt3104, (byte) -128);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        class40_sub5_sub17_sub5.method799();
        anInt3117 = class40_sub5_sub17_sub5.anInt2861;
        if(!aBoolean3287 && (anInt3091 ^ 0xffffffff) != 0 && anInt3140 != -1) {
            Model class40_sub5_sub17_sub5_1_ = Class37.method431(anInt3091, 13).method549(anInt3140, 2);
            if(class40_sub5_sub17_sub5_1_ != null) {
                class40_sub5_sub17_sub5_1_.method828(0, -anInt3110, 0);
                Model[] class40_sub5_sub17_sub5s = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_1_};
                class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, 2, true);
            }
        }
        if(!aBoolean3287 && aClass40_Sub5_Sub17_Sub5_3265 != null) {
            if(anInt3274 <= Node.anInt926)
                aClass40_Sub5_Sub17_Sub5_3265 = null;
            if(anInt3283 <= Node.anInt926 && Node.anInt926 < anInt3274) {
                Model class40_sub5_sub17_sub5_2_ = aClass40_Sub5_Sub17_Sub5_3265;
                class40_sub5_sub17_sub5_2_.method828(-anInt3098 + anInt3271, -anInt3276 + anInt3272, anInt3291 + -anInt3089);
                if(anInt3080 != 512) {
                    if(anInt3080 == 1024) {
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                    } else if(anInt3080 == 1536)
                        class40_sub5_sub17_sub5_2_.method813();
                } else {
                    class40_sub5_sub17_sub5_2_.method813();
                    class40_sub5_sub17_sub5_2_.method813();
                    class40_sub5_sub17_sub5_2_.method813();
                }
                Model[] class40_sub5_sub17_sub5s = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_2_};
                class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, 2, true);
                if(anInt3080 != 512) {
                    if(anInt3080 == 1024) {
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                    } else if(anInt3080 == 1536) {
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                    }
                } else
                    class40_sub5_sub17_sub5_2_.method813();
                class40_sub5_sub17_sub5_2_.method828(-anInt3271 + anInt3098, -anInt3272 + anInt3276, anInt3089 - anInt3291);
            }
        }
        class40_sub5_sub17_sub5.aBoolean3164 = true;
        return class40_sub5_sub17_sub5;
    }

    public boolean isVisible(int arg0) {
        if(arg0 != 1)
            method792(-71);
        return aClass30_3282 != null;
    }

    public void parsePlayerAppearanceData(byte arg0, Buffer buffer) {
        buffer.currentPosition = 0;
        int i = buffer.getUnsignedByte();
        anInt3268 = buffer.getByte();
        anInt3273 = buffer.getByte();
        int i_3_ = -1;
        anInt3266 = 0;
        int[] is = new int[12];
        if(arg0 >= -51)
            aClass1_3275 = null;
        for(int i_4_ = 0; i_4_ < 12; i_4_++) {
            int i_5_ = buffer.getUnsignedByte();
            if((i_5_ ^ 0xffffffff) == -1)
                is[i_4_] = 0;
            else {
                int i_6_ = buffer.getUnsignedByte();
                is[i_4_] = (i_5_ << 292869864) + i_6_;
                if((i_4_ ^ 0xffffffff) == -1 && is[0] == 65535) {
                    i_3_ = buffer.getUnsignedShortBE();
                    break;
                }
                if((is[i_4_] ^ 0xffffffff) <= -513) {
                    int i_7_ = ItemDefinition.forId(-512 + is[i_4_], 10).teamIndex;
                    if((i_7_ ^ 0xffffffff) != -1)
                        anInt3266 = i_7_;
                }
            }
        }
        int[] is_8_ = new int[5];
        for(int i_9_ = 0; (i_9_ ^ 0xffffffff) > -6; i_9_++) {
            int i_10_ = buffer.getUnsignedByte();
            if((i_10_ ^ 0xffffffff) > -1 || ((Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_9_]).length <= i_10_))
                i_10_ = 0;
            is_8_[i_9_] = i_10_;
        }
        anInt3126 = buffer.getUnsignedShortBE();
        if((anInt3126 ^ 0xffffffff) == -65536)
            anInt3126 = -1;
        anInt3145 = buffer.getUnsignedShortBE();
        if(anInt3145 == 65535)
            anInt3145 = -1;
        anInt3083 = anInt3145;
        anInt3131 = buffer.getUnsignedShortBE();
        if((anInt3131 ^ 0xffffffff) == -65536)
            anInt3131 = -1;
        anInt3079 = buffer.getUnsignedShortBE();
        if(anInt3079 == 65535)
            anInt3079 = -1;
        anInt3075 = buffer.getUnsignedShortBE();
        if(anInt3075 == 65535)
            anInt3075 = -1;
        anInt3132 = buffer.getUnsignedShortBE();
        if((anInt3132 ^ 0xffffffff) == -65536)
            anInt3132 = -1;
        anInt3082 = buffer.getUnsignedShortBE();
        if(anInt3082 == 65535)
            anInt3082 = -1;
        playerName = Class60.method991(-127, buffer.getLongBE()).method85(-4305);
        anInt3260 = buffer.getUnsignedByte();
        anInt3257 = buffer.getUnsignedShortBE();
        if(aClass30_3282 == null)
            aClass30_3282 = new Class30();
        aClass30_3282.method380(is, i == 1, 7, is_8_, i_3_);
    }
}
