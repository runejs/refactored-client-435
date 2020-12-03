package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.FramemapDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.node.Node;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.SceneCluster;

public class Class40_Sub6 extends Node {
    public static Class64 gameConnection;
    public static int[][][] tile_height = new int[4][105][105];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2105;
    public static int[] anIntArray2106 = {16776960, 16711680, 65280, 65535, 16711935, 16777215};
    public static int secondaryCameraVertical = 0;
    public static int anInt2110;
    public static int[] anIntArray2113 = new int[128];
    public static GameInterface aGameInterface_2116;
    public static int anInt2118 = 0;
    public static int placementX;
    public static int onBuildTimePlane = 0;

    public byte[] aByteArray2102;
    public CacheArchive aClass6_Sub1_2104;
    public int anInt2112;
    public CacheIndex aCache_2117;

    public static void method836(int arg0) {
        int i = 256;
        for(int i_0_ = 10; i_0_ < 117; i_0_++) {
            int i_1_ = (int) (Math.random() * 100.0);
            if(i_1_ < 50)
                MovedStatics.anIntArray178[(i - 2 << 7) + i_0_] = 255;
        }
        for(int i_2_ = 0; i_2_ < 100; i_2_++) {
            int i_3_ = (int) (Math.random() * 124.0) + 2;
            int i_4_ = 128 + (int) (Math.random() * 128.0);
            int i_5_ = i_3_ + (i_4_ << 7);
            MovedStatics.anIntArray178[i_5_] = 192;
        }
        for(int i_6_ = 1; i_6_ < i - 1; i_6_++) {
            for(int i_7_ = 1; i_7_ < 127; i_7_++) {
                int i_8_ = i_7_ + (i_6_ << 7);
                Class40_Sub5_Sub17_Sub6.anIntArray3255[i_8_] = (MovedStatics.anIntArray178[i_8_ + 1] + MovedStatics.anIntArray178[i_8_ - 1] - (-MovedStatics.anIntArray178[-128 + i_8_] - MovedStatics.anIntArray178[128 + i_8_])) / 4;
            }
        }
        RSRuntimeException.anInt1641 += 128;
        if(RSRuntimeException.anInt1641 > Landscape.anIntArray1168.length) {
            RSRuntimeException.anInt1641 -= Landscape.anIntArray1168.length;
            int i_9_ = (int) (12.0 * Math.random());
            FramemapDefinition.method879(Class22.aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
        }
        for(int i_10_ = 1; i_10_ < -1 + i; i_10_++) {
            for(int i_11_ = 1; i_11_ < 127; i_11_++) {
                int i_12_ = i_11_ + (i_10_ << 7);
                int i_13_ = -(Landscape.anIntArray1168[i_12_ + RSRuntimeException.anInt1641 & -1 + Landscape.anIntArray1168.length] / 5) + Class40_Sub5_Sub17_Sub6.anIntArray3255[i_12_ + 128];
                if(i_13_ < 0)
                    i_13_ = 0;
                MovedStatics.anIntArray178[i_12_] = i_13_;
            }
        }
        for(int i_14_ = 0; i_14_ < i + -1; i_14_++)
            Class17.anIntArray466[i_14_] = Class17.anIntArray466[i_14_ + 1];
        Class17.anIntArray466[i - arg0] = (int) (16.0 * Math.sin((double) MovedStatics.pulseCycle / 14.0) + 14.0 * Math.sin((double) MovedStatics.pulseCycle / 15.0) + 12.0 * Math.sin((double) MovedStatics.pulseCycle / 16.0));
        if(Class40_Sub5_Sub6.anInt2452 > 0)
            Class40_Sub5_Sub6.anInt2452 -= 4;
        if(IdentityKit.anInt2613 > 0)
            IdentityKit.anInt2613 -= 4;
        if(Class40_Sub5_Sub6.anInt2452 == 0 && IdentityKit.anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if(i_15_ == 0)
                Class40_Sub5_Sub6.anInt2452 = 1024;
            if(i_15_ == 1)
                IdentityKit.anInt2613 = 1024;
        }
    }

    public static void method838(int arg0, long arg1) {
        if(arg1 != 0) {
            for(int i = arg0; i < Class42.anInt1008; i++) {
                if(Player.ignores[i] == arg1) {
                    GameInterface.redrawTabArea = true;
                    Class42.anInt1008--;
                    for(int i_16_ = i; Class42.anInt1008 > i_16_; i_16_++)
                        Player.ignores[i_16_] = Player.ignores[1 + i_16_];
                    SceneCluster.packetBuffer.putPacket(28);
                    SceneCluster.packetBuffer.putLongBE(arg1);
                    break;
                }
            }
        }
    }
}
