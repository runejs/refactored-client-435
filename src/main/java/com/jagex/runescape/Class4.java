package com.jagex.runescape;

import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class4 {
    public static boolean menuOpen = false;
    public static volatile long aLong174 = 0L;
    public static int anInt175 = 0;
    public static RSString cmd_hiddenbuttontest = RSString.CreateString("::hiddenbuttontest");
    public static int[] anIntArray178;
    public static GameShell anApplet_Sub1_179 = null;
    public static RSString aClass1_180 = RSString.CreateString("wishes to trade with you)3");
    public static int anInt182 = 0;
    public static RSString aClass1_183 = RSString.CreateString("mapdots");
    public static int anInt188;

    public static void method159() {
        cmd_hiddenbuttontest = null;
        aClass1_180 = null;
        aClass1_183 = null;
        anIntArray178 = null;
    }

    public static int method160(int arg0, int arg1, int arg2, int arg3) {
        int i = arg0 & -1 + arg2;
        int i_0_ = arg3 / arg2;
        int i_1_ = arg2 - 1 & arg3;
        int i_2_ = arg0 / arg2;
        int i_3_ = CollisionMap.method157(arg1 + -15177, i_2_, i_0_);
        int i_4_ = CollisionMap.method157(arg1 ^ arg1, 1 + i_2_, i_0_);
        int i_5_ = CollisionMap.method157(0, i_2_, 1 + i_0_);
        int i_6_ = CollisionMap.method157(0, 1 + i_2_, 1 + i_0_);
        int i_7_ = GameShell.method32(i_3_, arg2, i_4_, true, i);
        int i_8_ = GameShell.method32(i_5_, arg2, i_6_, true, i);
        return GameShell.method32(i_7_, arg2, i_8_, true, i_1_);
    }

    public static void processAudio() {
        for(int index = 0; index < PacketBuffer.currentSound; index++) {
            Class40_Sub3.soundDelay[index]--;
            if(Class40_Sub3.soundDelay[index] < -10) {
                PacketBuffer.currentSound--;
                for(int j = index; ((PacketBuffer.currentSound > j)); j++) {
                    IdentityKit.sound[j] = IdentityKit.sound[j + 1];
                    PacketBuffer.effects[j] = PacketBuffer.effects[1 + j];
                    ItemDefinition.soundVolume[j] = ItemDefinition.soundVolume[1 + j];
                    Class40_Sub3.soundDelay[j] = Class40_Sub3.soundDelay[1 + j];
                    Class38_Sub1.anIntArray1916[j] = Class38_Sub1.anIntArray1916[1 + j];
                }
                index--;
            } else {
                Effect effect = PacketBuffer.effects[index];
                if(effect == null) {
                    effect = Effect.method429((Actor.aClass6_Sub1_3157), (IdentityKit.sound[index]), 0);
                    if(effect == null)
                        continue;
                    Class40_Sub3.soundDelay[index] += effect.delay();
                    PacketBuffer.effects[index] = effect;
                }
                if(Class40_Sub3.soundDelay[index] < 0) {
                    int i_10_;
                    if(Class38_Sub1.anIntArray1916[index] != 0) {
                        int i_11_ = 128 * (Class38_Sub1.anIntArray1916[index] & 0xff);
                        int i_12_ = (0xff & Class38_Sub1.anIntArray1916[index] >> 16);
                        int i_13_ = ((Class38_Sub1.anIntArray1916[index] & 0xffb8) >> 8);
                        int i_14_ = (i_13_ * 128 + 64 + -(Player.localPlayer.worldY));
                        int i_15_ = (i_12_ * 128 + (64 - (Player.localPlayer.worldX)));
                        if(i_15_ < 0)
                            i_15_ = -i_15_;
                        if(i_14_ < 0)
                            i_14_ = -i_14_;
                        int i_16_ = -128 + (i_15_ + i_14_);
                        if(i_16_ > i_11_) {
                            Class40_Sub3.soundDelay[index] = -100;
                            continue;
                        }
                        if(i_16_ < 0)
                            i_16_ = 0;
                        i_10_ = (i_11_ + -i_16_) * RSCanvas.anInt65 / i_11_;
                    } else
                        i_10_ = Class5.anInt200;
                    Class40_Sub12_Sub1 class40_sub12_sub1 = effect.method428().method875(Class55.aClass48_1289);
                    Class40_Sub9_Sub2 class40_sub9_sub2 = Class40_Sub9_Sub2.method864(class40_sub12_sub1, 100, i_10_);
                    class40_sub9_sub2.method860(-1 + ItemDefinition.soundVolume[index]);
                    Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                    Class40_Sub3.soundDelay[index] = -100;
                }
            }
        }
        if(Class35.songTimeout > 0) {
            Class35.songTimeout -= 20;
            if(Class35.songTimeout < 0)
                Class35.songTimeout = 0;
            if(Class35.songTimeout == 0 && RSCanvas.anInt60 != 0 && MouseHandler.anInt1457 != -1)
                Class33.method414(false, 0, MouseHandler.anInt1457, RSCanvas.anInt60, 0, Class55.aClass6_Sub1_1286);
        }
    }
}
