package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
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
            VarbitDefinition.aClass68_2350.method1044(0, 4, graphics, 4);
        } catch(Exception exception) {
            GameFrame.aCanvas1469.repaint();
        }
    }

    public static boolean method793(byte arg0, int arg1) {
        if(arg1 < 32)
            return false;
        if(arg1 == 127)
            return false;
        if(arg0 < 118)
            aByteArray3270 = null;
        return arg1 < 129 || arg1 > 159;
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

    public static void parsePlayerUpdateMasks(Player player, int mask, int arg3) {
        if((0x100 & mask) != 0) {
            int i = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            int i_0_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.method785(i_0_, pulseCycle, i, -122);
            player.anInt3139 = 300 + pulseCycle;
            player.anInt3130 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            player.anInt3101 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
        }
        if((mask & 0x10) != 0) {
            player.facePositionX = Cache.outgoingbuffer.getUnsignedShortBE();
            player.facePositionY = Cache.outgoingbuffer.getUnsignedShortLE();
        }
        if((mask & 0x1) != 0) {
            int i = Cache.outgoingbuffer.getUnsignedShortLE();
            if(i == 65535)
                i = -1;
            int i_1_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
            ActorDefinition.method570(i, i_1_, player, -1);
        }
        if((mask & 0x4) != 0) {
            player.facingActorIndex = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
            if(player.facingActorIndex == 65535)
                player.facingActorIndex = -1;
        }
        if((0x40 & mask) != 0) {
            int i = Cache.outgoingbuffer.getUnsignedByte();
            int i_2_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.method785(i_2_, pulseCycle, i, -123);
            player.anInt3139 = 300 + pulseCycle;
            player.anInt3130 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.anInt3101 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
        }
        if((mask & 0x400) != 0) {
            player.anInt3125 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            player.anInt3081 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            player.anInt3099 = Cache.outgoingbuffer.getUnsignedByte();
            player.anInt3127 = Cache.outgoingbuffer.getUnsignedByte();
            player.anInt3112 = (Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE() + pulseCycle);
            player.anInt3107 = (Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE() + pulseCycle);
            player.anInt3073 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            player.method790(0);
        }
        if((0x8 & mask) != 0) { // chat?...
            int i = Cache.outgoingbuffer.getUnsignedShortBE();
            int i_3_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
            int i_4_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
            int i_5_ = Cache.outgoingbuffer.currentPosition;
            if(player.playerName != null && player.aClass30_3282 != null) {
                long l = player.playerName.method58((byte) 101);
                boolean bool = false;
                if(i_3_ <= 1) {
                    for(int i_6_ = 0; i_6_ < Class42.anInt1008; i_6_++) {
                        if(l == Class53.aLongArray1267[i_6_]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && Class4.anInt182 == 0) {
                    Class59.aClass40_Sub1_1385.currentPosition = 0;
                    Cache.outgoingbuffer.putNegativeOffsetBytes(0, Class59.aClass40_Sub1_1385.buffer, i_4_);
                    Class59.aClass40_Sub1_1385.currentPosition = 0;
                    RSString class1 = KeyFocusListener.method956(124, Class59.aClass40_Sub1_1385).method53(-16315);
                    player.forcedChatMessage = class1.trim();
                    player.anInt3078 = 150;
                    player.anInt3123 = i & 0xff;
                    player.anInt3102 = i >> 8;
                    if(i_3_ == 2 || i_3_ == 3)
                        Class44.method895(68, 1, class1, (Class40_Sub5_Sub17_Sub6.method832(75, (new RSString[]{Widget.goldCrown, player.playerName}))));
                    else if(i_3_ == 1)
                        Class44.method895(123, 1, class1, (Class40_Sub5_Sub17_Sub6.method832(-79, (new RSString[]{Class51.whiteCrown, player.playerName}))));
                    else
                        Class44.method895(127, 2, class1, player.playerName);
                }
            }
            Cache.outgoingbuffer.currentPosition = i_4_ + i_5_;
        }
        if((0x20 & mask) != 0) { // appearance
            int appearanceUpdateLength = Cache.outgoingbuffer.getUnsignedByte();
            byte[] is = new byte[appearanceUpdateLength];
            Buffer buffer = new Buffer(is);
            Cache.outgoingbuffer.getBytes(appearanceUpdateLength, 0, is);
            Class22.aClass40_Sub1Array534[arg3] = buffer;
            player.parsePlayerAppearanceData((byte) -85, buffer);
        }
        if((mask & 0x200) != 0) { // graphics?
            player.anInt3091 = Cache.outgoingbuffer.getUnsignedShortLE();
            int i = Cache.outgoingbuffer.getIntME1();
            player.anInt3129 = 0;
            player.anInt3093 = pulseCycle + (i & 0xffff);
            if(player.anInt3091 == 65535)
                player.anInt3091 = -1;
            player.anInt3140 = 0;
            player.anInt3110 = i >> 16;
            if(player.anInt3093 > pulseCycle)
                player.anInt3140 = -1;
        }
        if((0x80 & mask) != 0) { // forced chat
            player.forcedChatMessage = Cache.outgoingbuffer.getRSString();
            if(player.forcedChatMessage.method55(0, false) != 126) {
                if(player == localPlayer)
                    Class44.method895(99, 2, player.forcedChatMessage, player.playerName);
            } else {
                player.forcedChatMessage = player.forcedChatMessage.substring(1);
                Class44.method895(120, 2, player.forcedChatMessage, player.playerName);
            }
            player.anInt3078 = 150;
            player.anInt3102 = 0;
            player.anInt3123 = 0;
        }
    }

    public static void parseTrackedPlayerUpdateMasks() {
        for(int i = 0; i < anInt3153; i++) {
            int i_2_ = Class24.anIntArray578[i];
            Player player = (aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_2_]);
            int i_3_ = Cache.outgoingbuffer.getUnsignedByte();
            if((i_3_ & 0x2) != 0)
                i_3_ += (Cache.outgoingbuffer.getUnsignedByte() << 8);
            parsePlayerUpdateMasks(player, i_3_, i_2_);
        }
        Class40_Sub5_Sub11.anInt2632++;
    }

    public Model getRotatedModel(int arg0) {
        if(aClass30_3282 == null)
            return null;
        int i = 71 % ((41 - arg0) / 47);
        AnimationSequence animationSequence = (playingAnimation == -1 || playingAnimationDelay != 0 ? null : Class68_Sub1.method1050(playingAnimation, 2));
        AnimationSequence animationSequence_0_ = ((anInt3077 != -1 && !aBoolean3287 && (anInt3126 != anInt3077 || animationSequence == null)) ? Class68_Sub1.method1050(anInt3077, 2) : null);
        Model class40_sub5_sub17_sub5 = aClass30_3282.method377(animationSequence, animationSequence_0_, anInt3116, anInt3104, (byte) -128);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        class40_sub5_sub17_sub5.method799();
        anInt3117 = class40_sub5_sub17_sub5.anInt2861;
        if(!aBoolean3287 && anInt3091 != -1 && anInt3140 != -1) {
            Model class40_sub5_sub17_sub5_1_ = SpotAnimDefinition.forId(anInt3091, 13).method549(anInt3140, 2);
            if(class40_sub5_sub17_sub5_1_ != null) {
                class40_sub5_sub17_sub5_1_.method828(0, -anInt3110, 0);
                Model[] class40_sub5_sub17_sub5s = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_1_};
                class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, 2, true);
            }
        }
        if(!aBoolean3287 && aClass40_Sub5_Sub17_Sub5_3265 != null) {
            if(anInt3274 <= Node.pulseCycle)
                aClass40_Sub5_Sub17_Sub5_3265 = null;
            if(anInt3283 <= Node.pulseCycle && Node.pulseCycle < anInt3274) {
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
            if(i_5_ == 0)
                is[i_4_] = 0;
            else {
                int i_6_ = buffer.getUnsignedByte();
                is[i_4_] = (i_5_ << 8) + i_6_;
                if(i_4_ == 0 && is[0] == 65535) {
                    i_3_ = buffer.getUnsignedShortBE();
                    break;
                }
                if(is[i_4_] >= 512) {
                    int i_7_ = ItemDefinition.forId(-512 + is[i_4_], 10).teamIndex;
                    if(i_7_ != 0)
                        anInt3266 = i_7_;
                }
            }
        }
        int[] is_8_ = new int[5];
        for(int i_9_ = 0; i_9_ < 5; i_9_++) {
            int i_10_ = buffer.getUnsignedByte();
            if(i_10_ < 0 || ((Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_9_]).length <= i_10_))
                i_10_ = 0;
            is_8_[i_9_] = i_10_;
        }
        anInt3126 = buffer.getUnsignedShortBE();
        if(anInt3126 == 65535)
            anInt3126 = -1;
        anInt3145 = buffer.getUnsignedShortBE();
        if(anInt3145 == 65535)
            anInt3145 = -1;
        anInt3083 = anInt3145;
        anInt3131 = buffer.getUnsignedShortBE();
        if(anInt3131 == 65535)
            anInt3131 = -1;
        anInt3079 = buffer.getUnsignedShortBE();
        if(anInt3079 == 65535)
            anInt3079 = -1;
        anInt3075 = buffer.getUnsignedShortBE();
        if(anInt3075 == 65535)
            anInt3075 = -1;
        anInt3132 = buffer.getUnsignedShortBE();
        if(anInt3132 == 65535)
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
