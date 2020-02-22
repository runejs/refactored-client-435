package com.jagex.runescape;

import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class4 {
    public static boolean aBoolean173;
    public static volatile long aLong174 = 0L;
    public static int anInt175;
    public static RSString aClass1_176;
    public static RSString aClass1_177 = Class58.method978("::hiddenbuttontest");
    public static int[] anIntArray178;
    public static RSApplet anApplet_Sub1_179;
    public static RSString aClass1_180;
    public static RSString aClass1_181;
    public static int anInt182;
    public static RSString aClass1_183;
    public static int anInt184;
    public static int anInt185;
    public static int anInt186;
    public static int anInt187;
    public static int anInt188;

    static {
        aBoolean173 = false;
        anInt175 = 0;
        aClass1_181 = Class58.method978("Einloggen");
        aClass1_183 = Class58.method978("mapdots");
        aClass1_176 = Class58.method978("wishes to trade with you)3");
        anInt182 = 0;
        aClass1_180 = aClass1_176;
        anApplet_Sub1_179 = null;
        anInt185 = 0;
    }

    public static void method159(byte arg0) {

        aClass1_177 = null;
            aClass1_180 = null;
            int i = 18 % ((arg0 - 8) / 59);
            aClass1_183 = null;
            anIntArray178 = null;
            aClass1_176 = null;
            aClass1_181 = null;

    }

    public static int method160(int arg0, int arg1, int arg2, int arg3) {

        anInt186++;
            int i = arg0 & -1 + arg2;
            int i_0_ = arg3 / arg2;
            int i_1_ = arg2 - 1 & arg3;
            int i_2_ = arg0 / arg2;
            int i_3_ = CollisionMap.method157(arg1 + -15177, i_2_, i_0_);
            int i_4_ = CollisionMap.method157(arg1 ^ arg1, 1 + i_2_, i_0_);
            int i_5_ = CollisionMap.method157(0, i_2_, 1 + i_0_);
            int i_6_ = CollisionMap.method157(0, 1 + i_2_, 1 + i_0_);
            int i_7_ = RSApplet.method32(i_3_, arg2, i_4_, true, i);
            int i_8_ = RSApplet.method32(i_5_, arg2, i_6_, true, i);
            return RSApplet.method32(i_7_, arg2, i_8_, true, i_1_);

    }

    public static void method161(int arg0) {
        anInt187++;
        if(arg0 != 128)
            aBoolean173 = false;
        for(int i = 0; i < PacketBuffer.anInt2248; i++) {
            Class40_Sub3.anIntArray2023[i]--;
            if(Class40_Sub3.anIntArray2023[i] < -10) {
                PacketBuffer.anInt2248--;
                for(int i_9_ = i; ((PacketBuffer.anInt2248 ^ 0xffffffff) < (i_9_ ^ 0xffffffff)); i_9_++) {
                    IdentityKit.anIntArray2602[i_9_] = IdentityKit.anIntArray2602[i_9_ + 1];
                    PacketBuffer.effects[i_9_] = PacketBuffer.effects[1 + i_9_];
                    ItemDefinition.anIntArray2814[i_9_] = ItemDefinition.anIntArray2814[1 + i_9_];
                    Class40_Sub3.anIntArray2023[i_9_] = Class40_Sub3.anIntArray2023[1 + i_9_];
                    Class38_Sub1.anIntArray1916[i_9_] = Class38_Sub1.anIntArray1916[1 + i_9_];
                }
                i--;
            } else {
                Effect effect = PacketBuffer.effects[i];
                if(effect == null) {
                    effect = Effect.method429((Actor.aClass6_Sub1_3157), (IdentityKit.anIntArray2602[i]), 0);
                    if(effect == null)
                        continue;
                    Class40_Sub3.anIntArray2023[i] += effect.method427();
                    PacketBuffer.effects[i] = effect;
                }
                if((Class40_Sub3.anIntArray2023[i] ^ 0xffffffff) > -1) {
                    int i_10_;
                    if((Class38_Sub1.anIntArray1916[i] ^ 0xffffffff) != -1) {
                        int i_11_ = 128 * (Class38_Sub1.anIntArray1916[i] & 0xff);
                        int i_12_ = (0xff & Class38_Sub1.anIntArray1916[i] >> 854878096);
                        int i_13_ = ((Class38_Sub1.anIntArray1916[i] & 0xffb8) >> 1161269672);
                        int i_14_ = (i_13_ * 128 + 64 + -(Class40_Sub5_Sub13.localPlayer.anInt3089));
                        int i_15_ = (i_12_ * 128 + (64 - (Class40_Sub5_Sub13.localPlayer.anInt3098)));
                        if(i_15_ < 0)
                            i_15_ = -i_15_;
                        if((i_14_ ^ 0xffffffff) > -1)
                            i_14_ = -i_14_;
                        int i_16_ = -128 + (i_15_ + i_14_);
                        if(i_16_ > i_11_) {
                            Class40_Sub3.anIntArray2023[i] = -100;
                            continue;
                        }
                        if(i_16_ < 0)
                            i_16_ = 0;
                        i_10_ = (i_11_ + -i_16_) * RSCanvas.anInt65 / i_11_;
                    } else
                        i_10_ = Class5.anInt200;
                    Class40_Sub12_Sub1 class40_sub12_sub1 = effect.method428().method875(Class55.aClass48_1289);
                    Class40_Sub9_Sub2 class40_sub9_sub2 = Class40_Sub9_Sub2.method864(class40_sub12_sub1, 100, i_10_);
                    class40_sub9_sub2.method860(-1 + ItemDefinition.anIntArray2814[i]);
                    Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                    Class40_Sub3.anIntArray2023[i] = -100;
                }
            }
        }
        if((Class35.anInt1733 ^ 0xffffffff) < -1) {
            Class35.anInt1733 -= 20;
            if(Class35.anInt1733 < 0)
                Class35.anInt1733 = 0;
            if((Class35.anInt1733 ^ 0xffffffff) == -1 && (RSCanvas.anInt60 ^ 0xffffffff) != -1 && (Class62.anInt1457 ^ 0xffffffff) != 0)
                Class33.method414(false, 0, Class62.anInt1457, RSCanvas.anInt60, 0, Class55.aClass6_Sub1_1286, -1);
        }
    }
}
