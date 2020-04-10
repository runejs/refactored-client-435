package com.jagex.runescape.cache.media;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.util.CollisionMap;

public class AnimationSequence extends SubNode {
    public static RSString requestcmd_tradereq = RSString.CreateString(":tradereq:");
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2474;
    public static int anInt2480 = 0;
    public static ImageRGB minimapCompass;
    public static CacheIndex aCacheIndex_2484;
    public static RSString aClass1_2488 = RSString.CreateString("titlebox");
    public static int[][] anIntArrayArray2490;

    public int[] animationLengths;
    public int anInt2470 = -1;
    public int[] anIntArray2473;
    public int anInt2476 = -1;
    public int shieldModel;
    public int[] anIntArray2479;
    public int anInt2483 = 2;
    public int[] anIntArray2485;
    public int weaponModel;
    public int anInt2494;
    public int anInt2495;
    public boolean aBoolean2496;
    public int frameStep;

    public AnimationSequence() {
        shieldModel = -1;
        weaponModel = -1;
        anInt2494 = 5;
        anInt2495 = 99;
        frameStep = -1;
        aBoolean2496 = false;
    }

    public static void method589() {
        aClass1_2488 = null;
        aCacheIndex_2484 = null;
        minimapCompass = null;
        requestcmd_tradereq = null;
        aClass40_Sub5_Sub14_Sub4Array2474 = null;
        anIntArrayArray2490 = null;
    }

    public static void loadTerrainBlock(CollisionMap[] arg0, int arg1, byte[] arg2, int arg3, int arg4, int arg5, int arg6) {
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; i_1_ < 64; i_1_++) {
                for(int i_2_ = 0; i_2_ < 64; i_2_++) {
                    if(arg4 + i_1_ > 0 && i_1_ + arg4 < 103 && arg5 + i_2_ > 0 && i_2_ + arg5 < 103)
                        arg0[i].clippingData[i_1_ + arg4][(i_2_ + arg5)] = HuffmanEncoding.method1021((arg0[i].clippingData[i_1_ + arg4][i_2_ + arg5]), -16777217);
                }
            }
        }
        Buffer class40_sub1 = new Buffer(arg2);
        if(arg3 == -6) {
            for(int i = 0; i < 4; i++) {
                for(int i_3_ = 0; i_3_ < 64; i_3_++) {
                    for(int i_4_ = 0; i_4_ < 64; i_4_++)
                        Class48.method922(i_3_ + arg4, 0, class40_sub1, i_4_ + arg5, arg6, arg1, i);
                }
            }
        }
    }

    public static boolean method596(int arg0, int arg1, byte arg2, int arg3) {
        int i = 0x7fff & arg1 >> 14;
        if(arg2 > -9)
            method596(-4, -74, (byte) -44, -62);
        int i_14_ = (Npc.currentScene.getArrangement(Player.worldLevel, arg0, arg3, arg1));
        if(i_14_ == -1)
            return false;
        int i_15_ = 0x3 & i_14_ >> 6;
        int i_16_ = 0x1f & i_14_;
        if(i_16_ != 10 && i_16_ != 11 && i_16_ != 22)
            Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), arg0, 1 + i_16_, true, i_15_, 0, (Player.localPlayer.pathX[0]), arg3, 2);
        else {
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
            int i_17_ = gameObjectDefinition.blockingMask;
            if(i_15_ != 0)
                i_17_ = (i_17_ >> 4 + -i_15_) + (0xf & i_17_ << i_15_);
            int i_18_;
            int i_19_;
            if(i_15_ == 0 || i_15_ == 2) {
                i_19_ = gameObjectDefinition.sizeY;
                i_18_ = gameObjectDefinition.sizeX;
            } else {
                i_18_ = gameObjectDefinition.sizeY;
                i_19_ = gameObjectDefinition.sizeX;
            }
            Class38_Sub1.doWalkTo(i_18_, i_17_, (Player.localPlayer.pathY[0]), arg0, 0, true, 0, i_19_, (Player.localPlayer.pathX[0]), arg3, 2);
        }
        Class40_Sub11.crossX = Class57.clickX;
        LinkedList.crossType = 2;
        Class40_Sub5_Sub1.crossY = RSString.clickY;
        OverlayDefinition.crossIndex = 0;
        return true;
    }

    public Model method590(Model arg0, AnimationSequence arg1, int arg2, int arg3, byte arg4) {
        arg2 = anIntArray2485[arg2];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg2 >> 16);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method599(arg3, arg0, false);
        arg3 = arg1.anIntArray2485[arg3];
        Class40_Sub5_Sub15 class40_sub5_sub15_0_ = Class55.method960((byte) -99, arg3 >> 16);
        arg3 &= 0xffff;
        if(class40_sub5_sub15_0_ == null) {
            Model class40_sub5_sub17_sub5 = arg0.method817(!class40_sub5_sub15.method737(arg2));
            class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg2);
            return class40_sub5_sub17_sub5;
        }
        if(arg4 != 63)
            return null;
        Model model = arg0.method817(!class40_sub5_sub15.method737(arg2) & !class40_sub5_sub15_0_.method737(arg3));
        model.method809(class40_sub5_sub15, arg2, class40_sub5_sub15_0_, arg3, anIntArray2473);
        return model;
    }

    public void method591(byte arg0) {
        if(anInt2476 == -1) {
            if(anIntArray2473 == null)
                anInt2476 = 0;
            else
                anInt2476 = 2;
        }
        int i = -117 / ((-76 - arg0) / 39);
        if(anInt2470 == -1) {
            if(anIntArray2473 == null)
                anInt2470 = 0;
            else
                anInt2470 = 2;
        }
    }

    public Model method593(int arg0, boolean arg1, Model arg2, int arg3) {
        arg0 = anIntArray2485[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg0 >> 16);
        if(arg1)
            anIntArray2479 = null;
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg2.method817(true);
        arg3 &= 0x3;
        Model class40_sub5_sub17_sub5 = arg2.method817(!class40_sub5_sub15.method737(arg0));
        if(arg3 == 1)
            class40_sub5_sub17_sub5.method824();
        else if(arg3 == 2)
            class40_sub5_sub17_sub5.method819();
        else if(arg3 == 3)
            class40_sub5_sub17_sub5.method813();
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg0);
        if(arg3 != 1) {
            if(arg3 != 2) {
                if(arg3 == 3)
                    class40_sub5_sub17_sub5.method824();
            } else
                class40_sub5_sub17_sub5.method819();
        } else
            class40_sub5_sub17_sub5.method813();
        return class40_sub5_sub17_sub5;
    }

    public void method594(int arg0, Buffer arg1) {
        for(; ; ) {
            int i = arg1.getUnsignedByte();
            if(i == 0)
                break;
            method595(-102, i, arg1);
        }
        if(arg0 != -1)
            anInt2470 = -80;
    }

    public void method595(int arg0, int arg1, Buffer arg2) {
        int i = 3 / ((arg0 + 12) / 51);
        if(arg1 == 1) {
            int i_5_ = arg2.getUnsignedByte();
            animationLengths = new int[i_5_];
            for(int i_6_ = 0; (i_5_ > i_6_); i_6_++)
                animationLengths[i_6_] = arg2.getUnsignedShortBE();
            anIntArray2485 = new int[i_5_];
            for(int i_7_ = 0; (i_5_ > i_7_); i_7_++)
                anIntArray2485[i_7_] = arg2.getUnsignedShortBE();
            for(int i_8_ = 0; (i_8_ < i_5_); i_8_++)
                anIntArray2485[i_8_] = ((arg2.getUnsignedShortBE() << 16) + anIntArray2485[i_8_]);
        } else if(arg1 == 2)
            frameStep = arg2.getUnsignedShortBE();
        else if(arg1 == 3) {
            int i_12_ = arg2.getUnsignedByte();
            anIntArray2473 = new int[1 + i_12_];
            for(int i_13_ = 0; i_12_ > i_13_; i_13_++)
                anIntArray2473[i_13_] = arg2.getUnsignedByte();
            anIntArray2473[i_12_] = 9999999;
        } else if(arg1 != 4) {
            if(arg1 == 5)
                anInt2494 = arg2.getUnsignedByte();
            else if(arg1 != 6) {
                if(arg1 != 7) {
                    if(arg1 == 8)
                        anInt2495 = arg2.getUnsignedByte();
                    else if(arg1 == 9)
                        anInt2470 = arg2.getUnsignedByte();
                    else if(arg1 != 10) {
                        if(arg1 == 11)
                            anInt2483 = arg2.getUnsignedByte();
                        else if(arg1 == 12) {
                            int i_9_ = arg2.getUnsignedByte();
                            anIntArray2479 = new int[i_9_];
                            for(int i_10_ = 0; ((i_10_ < i_9_)); i_10_++)
                                anIntArray2479[i_10_] = arg2.getUnsignedShortBE();
                            for(int i_11_ = 0; ((i_9_ > i_11_)); i_11_++)
                                anIntArray2479[i_11_] = ((arg2.getUnsignedShortBE() << 16) + anIntArray2479[i_11_]);
                        }
                    } else
                        anInt2476 = arg2.getUnsignedByte();
                } else
                    weaponModel = arg2.getUnsignedShortBE();
            } else
                shieldModel = arg2.getUnsignedShortBE();
        } else
            aBoolean2496 = true;
    }

    public Model method597(byte arg0, Model arg1, int arg2) {
        arg2 = anIntArray2485[arg2];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg2 >> 16);
        arg2 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method806(true);
        if(arg0 != -87)
            return null;
        Model class40_sub5_sub17_sub5 = arg1.method806(!class40_sub5_sub15.method737(arg2));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg2);
        return class40_sub5_sub17_sub5;
    }

    public Model method598(int arg0, Model arg1, boolean arg2) {
        int i = anIntArray2485[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, i >> 16);
        i &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        if(!arg2)
            method594(98, null);
        Class40_Sub5_Sub15 class40_sub5_sub15_20_ = null;
        int i_21_ = 0;
        if(anIntArray2479 != null && arg0 < anIntArray2479.length) {
            i_21_ = anIntArray2479[arg0];
            class40_sub5_sub15_20_ = Class55.method960((byte) -99, i_21_ >> 16);
            i_21_ &= 0xffff;
        }
        if(class40_sub5_sub15_20_ == null || i_21_ == 65535) {
            Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(i));
            class40_sub5_sub17_sub5.method825(class40_sub5_sub15, i);
            return class40_sub5_sub17_sub5;
        }
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(i) & !class40_sub5_sub15_20_.method737(i_21_));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, i);
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15_20_, i_21_);
        return class40_sub5_sub17_sub5;
    }

    public Model method599(int arg0, Model arg1, boolean arg2) {
        if(arg2)
            method591((byte) -78);
        arg0 = anIntArray2485[arg0];
        Class40_Sub5_Sub15 class40_sub5_sub15 = Class55.method960((byte) -99, arg0 >> 16);
        arg0 &= 0xffff;
        if(class40_sub5_sub15 == null)
            return arg1.method817(true);
        Model class40_sub5_sub17_sub5 = arg1.method817(!class40_sub5_sub15.method737(arg0));
        class40_sub5_sub17_sub5.method825(class40_sub5_sub15, arg0);
        return class40_sub5_sub17_sub5;
    }
}
