package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class Class40_Sub5_Sub17_Sub1 extends Renderable {
    public static RSString aClass1_2963 = RSString.CreateString("Feb");
    public static RSString[] aClass1Array2964;
    public static RSString aClass1_2965;
    public static RSString aClass1_2966;
    public static RSString aClass1_2967;
    public static RSString aClass1_2969 = RSString.CreateString("Aug");
    public static boolean[] aBooleanArray2975;
    public static int menuScreenArea;
    public static RSString aClass1_2985;
    public static int[] directions;
    public static RSString aClass1_2988;
    public static RSString aClass1_2990;
    public static RSString aClass1_2991;
    public static RSString aClass1_2998;
    public static int atInventoryInterfaceType;
    public static CacheIndex_Sub1 aClass6_Sub1_3000;
    public static RSString aClass1_3002;
    public static int anInt3004;
    public static RSString aClass1_3009;
    public static RSString aClass1_3010;
    public static RSString aClass1_3012;
    public static RSString aClass1_3014;
    public static RSString aClass1_3015;

    static {
        aClass1_2967 = RSString.CreateString("Dec");
        aBooleanArray2975 = new boolean[5];
        aClass1_2990 = RSString.CreateString("Mar");
        atInventoryInterfaceType = 0;
        aClass1_2998 = RSString.CreateString("May");
        aClass1_3002 = RSString.CreateString("Loading wordpack )2 ");
        aClass1_2985 = RSString.CreateString("Jun");
        aClass1_2965 = RSString.CreateString("Oct");
        aClass1_2991 = RSString.CreateString("Jul");
        aClass1_3010 = RSString.CreateString("Connecting to server)3)3)3");
        aClass1_3009 = aClass1_3010;
        directions = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        aClass1_3012 = RSString.CreateString("Jan");
        aClass1_2966 = RSString.CreateString("Sep");
        aClass1_2988 = RSString.CreateString("Nov");
        aClass1_3014 = aClass1_3002;
        aClass1_3015 = RSString.CreateString("Apr");
        aClass1Array2964 = new RSString[]{aClass1_3012, aClass1_2963, aClass1_2990, aClass1_3015, aClass1_2998, aClass1_2985, aClass1_2991, aClass1_2969, aClass1_2966, aClass1_2965, aClass1_2988, aClass1_2967};
    }

    public int anInt2957;
    public int anInt2958;
    public int anInt2960;
    public int anInt2961;
    public int anInt2962;
    public boolean aBoolean2968;
    public int anInt2971;
    public double aDouble2972;
    public int anInt2973 = 0;
    public int anInt2974;
    public int anInt2976;
    public double aDouble2980;
    public int anInt2981;
    public int anInt2982;
    public int anInt2984;
    public int anInt2989;
    public double aDouble2992;
    public double aDouble2993;
    public double aDouble2995;
    public double aDouble2996;
    public int anInt2997;
    public double aDouble3001;
    public AnimationSequence aAnimationSequence_3006;
    public double aDouble3011;
    public int anInt3013;

    public Class40_Sub5_Sub17_Sub1(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        aBoolean2968 = false;
        anInt2982 = 0;
        anInt2958 = arg2;
        anInt2957 = arg4;
        aBoolean2968 = false;
        anInt2960 = arg10;
        anInt2989 = arg8;
        anInt2962 = arg0;
        anInt2981 = arg1;
        anInt2971 = arg6;
        anInt2974 = arg5;
        anInt2961 = arg9;
        anInt2984 = arg3;
        anInt2997 = arg7;
        int i = SpotAnimDefinition.forId(anInt2962, 13).animationId;
        if(i != -1)
            aAnimationSequence_3006 = Class68_Sub1.method1050(i, 2);
        else
            aAnimationSequence_3006 = null;

    }

    public static void method758(CacheIndex arg0, CacheIndex arg1, CacheIndex arg2, byte arg3) {
        do {
            Cache.aCacheIndex_329 = arg2;
            VarbitDefinition.aCacheIndex_2349 = arg0;
            Class40_Sub5_Sub15.aCacheIndex_2779 = arg1;
            Widget.interfaces = (new Widget
                    [VarbitDefinition.aCacheIndex_2349.method175(-82)][]);
            Class68.aBooleanArray1629 = (new boolean
                    [VarbitDefinition.aCacheIndex_2349.method175(-116)]);
            if(arg3 == 90)
                break;
            aClass6_Sub1_3000 = null;

            break;
        } while(false);
    }

    public static void method761() {
        aClass1Array2964 = null;
        aClass1_2966 = null;
        aClass1_2963 = null;
        aClass6_Sub1_3000 = null;
        aBooleanArray2975 = null;
        aClass1_2990 = null;
        aClass1_2991 = null;
        aClass1_3002 = null;
        aClass1_3012 = null;
        aClass1_2985 = null;
        aClass1_2969 = null;
        aClass1_2965 = null;
        aClass1_3014 = null;
        directions = null;
        aClass1_3015 = null;
        aClass1_2967 = null;
        aClass1_2998 = null;
        aClass1_2988 = null;
        aClass1_3010 = null;
        aClass1_3009 = null;
    }

    public static void method762(int arg0, Actor actor) {
        if(arg0 != (actor.anInt3113 ^ 0xffffffff)) {
            if(actor.facingActorIndex != -1 && actor.facingActorIndex < 32768) {
                Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[actor.facingActorIndex]);
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    int i = (-class40_sub5_sub17_sub4_sub2.worldY + actor.worldY);
                    int i_10_ = (-class40_sub5_sub17_sub4_sub2.worldX + actor.worldX);
                    if(i_10_ != 0 || i != 0)
                        actor.anInt3080 = 0x7ff & (int) (325.949 * Math.atan2((double) i_10_, (double) i));
                }
            }
            if(actor.facingActorIndex >= 32768) {
                int i = -32768 + actor.facingActorIndex;
                if(i == Class30.anInt708)
                    i = 2047;
                Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    int i_11_ = (actor.worldX - class40_sub5_sub17_sub4_sub1.worldX);
                    int i_12_ = (-class40_sub5_sub17_sub4_sub1.worldY + actor.worldY);
                    if(i_11_ != 0 || i_12_ != 0)
                        actor.anInt3080 = (int) (Math.atan2((double) i_11_, (double) i_12_) * 325.949) & 0x7ff;
                }
            }
            if((actor.facePositionX != 0 || actor.facePositionY != 0) && (actor.anInt3109 == 0 || actor.anInt3074 > 0)) {
                int i = (actor.worldY - 64 * (actor.facePositionY - Class26.baseY - Class26.baseY));
                int i_13_ = (-((-SpotAnimDefinition.baseX + actor.facePositionX + -SpotAnimDefinition.baseX) * 64) + actor.worldX);
                if(i_13_ != 0 || i != 0)
                    actor.anInt3080 = 0x7ff & (int) (325.949 * Math.atan2((double) i_13_, (double) i));
                actor.facePositionY = 0;
                actor.facePositionX = 0;
            }
            int i = 0x7ff & actor.anInt3080 + -actor.anInt3118;
            if(i != 0) {
                actor.anInt3097++;
                if(i > 1024) {
                    actor.anInt3118 -= actor.anInt3113;
                    boolean bool = true;
                    if(actor.anInt3113 > i || ((2048 + -actor.anInt3113 < i))) {
                        bool = false;
                        actor.anInt3118 = actor.anInt3080;
                    }
                    if(actor.idleAnimation == actor.anInt3077 && (actor.anInt3097 > 25 || bool)) {
                        if(actor.standTurnAnimationId != -1)
                            actor.anInt3077 = actor.standTurnAnimationId;
                        else
                            actor.anInt3077 = actor.walkAnimationId;
                    }
                } else {
                    actor.anInt3118 += actor.anInt3113;
                    boolean bool = true;
                    if(i < actor.anInt3113 || (i > -actor.anInt3113 + 2048)) {
                        actor.anInt3118 = actor.anInt3080;
                        bool = false;
                    }
                    if(actor.anInt3077 == actor.idleAnimation && (actor.anInt3097 > 25 || bool)) {
                        if(actor.anInt3083 != -1)
                            actor.anInt3077 = actor.anInt3083;
                        else
                            actor.anInt3077 = actor.walkAnimationId;
                    }
                }
                actor.anInt3118 &= 0x7ff;
            } else
                actor.anInt3097 = 0;
        }
    }

    public static void method763(Component arg0, byte arg1, CacheIndex arg2) {
        if(!SubNode.aBoolean2083) {
            FloorDecoration.aClass40_Sub5_Sub14_Sub2_593 = Class27.method359(Class27.aClass1_638, Class8.aClass1_305, arg2);
            Class44.aClass40_Sub5_Sub14_Sub2_1047 = Class27.method359(Native.chatback, Class8.aClass1_305, arg2);
            Class34.mapBack = Class27.method359(VertexNormal.aClass1_1113, Class8.aClass1_305, arg2);
            Class57.aClass40_Sub5_Sub14_Sub2_1346 = Class27.method359(Class59.aClass1_1395, Class8.aClass1_305, arg2);
            Class56.aClass40_Sub5_Sub14_Sub2_1329 = Class27.method359(CacheIndex.aClass1_256, Class8.aClass1_305, arg2);
            Buffer.aClass40_Sub5_Sub14_Sub2_1959 = Class27.method359(Wall.aClass1_338, Class8.aClass1_305, arg2);
            RSCanvas.aClass68_64 = Class40_Sub5_Sub13.method649(96, 479, arg0, -4875);
            Class44.aClass40_Sub5_Sub14_Sub2_1047.drawImage(0, 0);
            RSString.aClass68_1665 = Class40_Sub5_Sub13.method649(156, 172, arg0, -4875);
            Rasterizer.clear();
            Class34.mapBack.drawImage(0, 0);
            SubNode.aClass68_2091 = Class40_Sub5_Sub13.method649(261, 190, arg0, -4875);
            FloorDecoration.aClass40_Sub5_Sub14_Sub2_593.drawImage(0, 0);
            VarbitDefinition.aClass68_2350 = Class40_Sub5_Sub13.method649(334, 512, arg0, -4875);
            Rasterizer.clear();
            HuffmanEncoding.aClass68_1541 = Class40_Sub5_Sub13.method649(50, 496, arg0, -4875);
            RSCanvas.aClass68_59 = Class40_Sub5_Sub13.method649(37, 269, arg0, -4875);
            InteractiveObject.aClass68_482 = Class40_Sub5_Sub13.method649(45, 249, arg0, -4875);
            ImageRGB class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, Class61.aClass1_1440, (byte) 21, Class8.aClass1_305);
            Landscape.aClass68_1185 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, Class43.aClass1_1024, (byte) 21, Class8.aClass1_305);
            Class40_Sub5_Sub1.aClass68_2275 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, Class8.aClass1_281, (byte) 21, Class8.aClass1_305);
            Class39.aClass68_908 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, WallDecoration.aClass1_1266, (byte) 21, Class8.aClass1_305);
            GameObject.aClass68_3045 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, Main.aClass1_1788, (byte) 21, Class8.aClass1_305);
            Class40_Sub5_Sub17_Sub6.aClass68_3243 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, GroundItemTile.aClass1_1374, (byte) 21, Class8.aClass1_305);
            Class40_Sub7.aClass68_2123 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, IdentityKit.aClass1_2588, (byte) 21, Class8.aClass1_305);
            Class61.aClass68_1441 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, Class5.aClass1_196, (byte) 21, Class8.aClass1_305);
            Class30.aClass68_714 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            class40_sub5_sub14_sub4.method727(0, 0);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg2, Class8.aClass1_304, (byte) 21, Class8.aClass1_305);
            Class17.aClass68_462 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_height), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
            int i = -80 % ((arg1 - 9) / 40);
            class40_sub5_sub14_sub4.method727(0, 0);
            Class56.aClass40_Sub5_Sub14_Sub2_1315 = Class27.method359(SubNode.aClass1_2093, Class8.aClass1_305, arg2);
            GameShell.aClass40_Sub5_Sub14_Sub2_1 = Class27.method359(Class40_Sub5_Sub17_Sub6.aClass1_3254, Class8.aClass1_305, arg2);
            Class35.aClass40_Sub5_Sub14_Sub2_1744 = Class27.method359(Class64.aClass1_1517, Class8.aClass1_305, arg2);
            Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105 = Class56.aClass40_Sub5_Sub14_Sub2_1315.method691();
            Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105.flipHorizontal();
            WallDecoration.aClass40_Sub5_Sub14_Sub2_1270 = GameShell.aClass40_Sub5_Sub14_Sub2_1.method691();
            WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.flipHorizontal();
            Renderable.aClass40_Sub5_Sub14_Sub2_2860 = Class56.aClass40_Sub5_Sub14_Sub2_1315.method691();
            Renderable.aClass40_Sub5_Sub14_Sub2_2860.flipVertical();
            HashTable.aClass40_Sub5_Sub14_Sub2_549 = GameShell.aClass40_Sub5_Sub14_Sub2_1.method691();
            HashTable.aClass40_Sub5_Sub14_Sub2_549.flipVertical();
            Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919 = Class35.aClass40_Sub5_Sub14_Sub2_1744.method691();
            Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919.flipVertical();
            ISAAC.aClass40_Sub5_Sub14_Sub2_524 = Class56.aClass40_Sub5_Sub14_Sub2_1315.method691();
            ISAAC.aClass40_Sub5_Sub14_Sub2_524.flipHorizontal();
            ISAAC.aClass40_Sub5_Sub14_Sub2_524.flipVertical();
            Class13.aClass40_Sub5_Sub14_Sub2_418 = GameShell.aClass40_Sub5_Sub14_Sub2_1.method691();
            Class13.aClass40_Sub5_Sub14_Sub2_418.flipHorizontal();
            Class13.aClass40_Sub5_Sub14_Sub2_418.flipVertical();
            Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776 = IndexedImage.getMultipleIndexedImages(arg2, (Class40_Sub5_Sub15.aClass1_2787), Class8.aClass1_305);
            Landscape.anIntArray1186 = new int[151];
            RSCanvas.anIntArray66 = new int[33];
            RSCanvas.anIntArray62 = new int[33];
            Class34.anIntArray852 = new int[151];
            for(int i_14_ = 0; i_14_ < 33; i_14_++) {
                int i_15_ = 0;
                int i_16_ = 999;
                for(int i_17_ = 0; i_17_ < 34; i_17_++) {
                    if((Class34.mapBack.imgPixels[(Class34.mapBack.imgWidth * i_14_) + i_17_]) == 0) {
                        if(i_16_ == 999)
                            i_16_ = i_17_;
                    } else if(i_16_ != 999) {
                        i_15_ = i_17_;
                        break;
                    }
                }
                RSCanvas.anIntArray62[i_14_] = i_16_;
                RSCanvas.anIntArray66[i_14_] = -i_16_ + i_15_;
            }
            for(int i_18_ = 5; i_18_ < 156; i_18_++) {
                int i_19_ = 0;
                int i_20_ = 999;
                for(int i_21_ = 25; i_21_ < 172; i_21_++) {
                    if((Class34.mapBack.imgPixels[i_21_ + (Class34.mapBack.imgWidth) * i_18_]) != 0 || i_21_ <= 34 && i_18_ <= 34) {
                        if(i_20_ != 999) {
                            i_19_ = i_21_;
                            break;
                        }
                    } else if(i_20_ == 999)
                        i_20_ = i_21_;
                }
                Landscape.anIntArray1186[-5 + i_18_] = i_20_ - 25;
                Class34.anIntArray852[-5 + i_18_] = i_19_ + -i_20_;
            }
            SubNode.aBoolean2083 = true;
        }
    }

    public static int method764(byte arg0) {
        int i = 3;
        if(Class26.anInt627 < 310) {
            int i_22_ = Class40_Sub5_Sub6.cameraY >> 7;
            int i_23_ = Class12.cameraX >> 7;
            if(i_22_ > 103) {
                i_22_ = 103;
            }
            if(i_23_ > 103) {
                i_23_ = 103;
            }
            if(((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_]) & 0x4) != 0)
                i = Player.worldLevel;
            int i_24_ = ((Player.localPlayer.worldX) >> 7);
            int i_25_ = ((Player.localPlayer.worldY) >> 7);
            int i_26_;
            if(i_24_ <= i_23_)
                i_26_ = -i_24_ + i_23_;
            else
                i_26_ = -i_23_ + i_24_;
            int i_27_;
            if((i_22_ < i_25_))
                i_27_ = i_25_ + -i_22_;
            else
                i_27_ = -i_25_ + i_22_;
            if(i_26_ <= i_27_) {
                int i_28_ = i_26_ * 65536 / i_27_;
                int i_29_ = 32768;
                while(i_22_ != i_25_) {
                    if(i_25_ <= i_22_) {
                        if(i_22_ > i_25_)
                            i_22_--;
                    } else
                        i_22_++;
                    if(i_22_ > 103) {
                        i_22_ = 103;
                    }
                    if(i_23_ > 103) {
                        i_23_ = 103;
                    }
                    i_29_ += i_28_;
                    if(((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_]) & 0x4) != 0)
                        i = Player.worldLevel;
                    if(i_29_ >= 65536) {
                        if(i_23_ < i_24_)
                            i_23_++;
                        else if((i_24_ < i_23_))
                            i_23_--;
                        i_29_ -= 65536;
                        if(i_22_ > 103) {
                            i_22_ = 103;
                        }
                        if(i_23_ > 103) {
                            i_23_ = 103;
                        }
                        if((0x4 & (OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_])) != 0)
                            i = Player.worldLevel;
                    }
                }
            } else {
                int i_30_ = i_27_ * 65536 / i_26_;
                int i_31_ = 32768;
                while(i_23_ != i_24_) {
                    if(i_23_ >= i_24_) {
                        if((i_24_ < i_23_))
                            i_23_--;
                    } else
                        i_23_++;
                    if(((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_]) & 0x4) != 0)
                        i = Player.worldLevel;
                    i_31_ += i_30_;
                    if(i_31_ >= 65536) {
                        i_31_ -= 65536;
                        if(i_25_ > i_22_)
                            i_22_++;
                        else if(i_22_ > i_25_)
                            i_22_--;
                        if(((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_]) & 0x4) != 0)
                            i = Player.worldLevel;
                    }
                }
            }
        }
        if(arg0 > -101)
            aClass6_Sub1_3000 = null;
        if(((OverlayDefinition.tile_flags[Player.worldLevel][(Player.localPlayer.worldX) >> 7][(Player.localPlayer.worldY) >> 7]) & 0x4) != 0)
            i = Player.worldLevel;
        return i;

    }

    public static void addObject(int objectId, int localX, int localY, int plane, int face, int type, Scene scene, CollisionMap collisionMap) {
        if(!VertexNormal.lowMemory || (0x2 & (OverlayDefinition.tile_flags[0][localX][localY])) != 0 || ((0x10 & (OverlayDefinition.tile_flags[plane][localX][localY])) == 0 && (Class40_Sub6.onBuildTimePlane == Class59.getVisibilityPlaneFor(plane, localY, 0, localX)))) {
            if(Class64.lowestPlane > plane)
                Class64.lowestPlane = plane;
            int vertexHeight = Class40_Sub6.tile_height[plane][localX][localY];
            int vertexHeightRight = Class40_Sub6.tile_height[plane][localX + 1][localY];
            int vertexHeightTopRight = Class40_Sub6.tile_height[plane][localX + 1][localY + 1];
            int vertexHeightTop = Class40_Sub6.tile_height[plane][localX][localY + 1];
            int vertexMix = vertexHeight + vertexHeightRight + vertexHeightTopRight + vertexHeightTop >> 2;
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(objectId);
            int hash = localX + (localY << 7) + (objectId << 14) + 1073741824;
            int objectConfig = (byte) ((face << 6) + type);
            if(gameObjectDefinition.supportsItems == 1)
                objectConfig += 256;
            if(gameObjectDefinition.hasActions == 0)
                hash += -2147483648;
            if(gameObjectDefinition.method601())
                Class37.method437(localY, true, plane, face, localX, gameObjectDefinition);
            if(type == 22) {
                if(!VertexNormal.lowMemory || gameObjectDefinition.hasActions != 0 || gameObjectDefinition.obstructsGround) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 22, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 22, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addGroundDecoration(localX, localY, plane, vertexMix, hash, renderable, objectConfig);
                    if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1 && collisionMap != null)
                        collisionMap.markBlocked(localY, localX);
                }
            } else if(type == 10 || type == 11) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 10, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                if(renderable != null) {
                    int i_40_;
                    int i_41_;
                    if(face == 1 || face == 3) {
                        i_40_ = gameObjectDefinition.sizeX;
                        i_41_ = gameObjectDefinition.sizeY;
                    } else {
                        i_41_ = gameObjectDefinition.sizeX;
                        i_40_ = gameObjectDefinition.sizeY;
                    }
                    int i_42_ = 0;
                    if(type == 11)
                        i_42_ += 256;
                    if(scene.addEntityB(localX, localY, plane, vertexMix, i_42_, i_40_, i_41_, hash, renderable, objectConfig) && gameObjectDefinition.castsShadow) {
                        Model class40_sub5_sub17_sub5;
                        if(renderable instanceof Model)
                            class40_sub5_sub17_sub5 = ((Model) renderable);
                        else
                            class40_sub5_sub17_sub5 = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, vertexHeightRight);
                        if(class40_sub5_sub17_sub5 != null) {
                            for(int i_43_ = 0; ((i_43_ <= i_41_)); i_43_++) {
                                for(int i_44_ = 0; i_40_ >= i_44_; i_44_++) {
                                    int i_45_ = (class40_sub5_sub17_sub5.method805() / 4);
                                    if(i_45_ > 30)
                                        i_45_ = 30;
                                    if(i_45_ > (InteractiveObject.aByteArrayArrayArray492[plane][localX + i_43_][localY + i_44_]))
                                        InteractiveObject.aByteArrayArrayArray492[plane][i_43_ + localX][localY + i_44_] = (byte) i_45_;
                                }
                            }
                        }
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else if(type >= 12) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                else
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, vertexHeightRight);
                scene.addEntityB(localX, localY, plane, vertexMix, 0, 1, 1, hash, renderable, objectConfig);
                if(type >= 12 && type <= 17 && type != 13 && plane > 0)
                    CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 2340));
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else if(type == 0) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 0, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 0, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                scene.addWall(localX, localY, plane, vertexMix, SceneCluster.anIntArray761[face], 0, hash, renderable, null, objectConfig);
                if(face == 0) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][(localY + 1)] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 585));
                } else if(face == 1) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY + 1] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY + 1] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY + 1]), 1170));
                } else if(face == 2) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][1 + localX][localY] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        CacheIndex.anIntArrayArrayArray262[plane][localX + 1][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX + 1][localY]), 585));
                } else if(face == 3) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 1170));
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
                if(gameObjectDefinition.setDecorDisplacement != 16)
                    scene.method115(plane, localX, localY, gameObjectDefinition.setDecorDisplacement);
            } else if(type == 1) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 1, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 1, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                scene.addWall(localX, localY, plane, vertexMix, Class40_Sub5_Sub15.anIntArray2788[face], 0, hash, renderable, null, objectConfig);
                if(gameObjectDefinition.castsShadow) {
                    if(face == 0)
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][(localY + 1)] = (byte) 50;
                    else if(face == 1)
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                    else if(face == 2)
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                    else if(face == 3)
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
            } else if(type == 2) {
                int i_46_ = 0x3 & face + 1;
                Renderable renderable;
                Renderable renderable_47_;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null) {
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face + 4, vertexHeight, 2, vertexHeightRight);
                    renderable_47_ = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, i_46_, vertexHeight, 2, vertexHeightRight);
                } else {
                    renderable = new GameObject(objectId, 2, 4 + face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                    renderable_47_ = new GameObject(objectId, 2, i_46_, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                }
                scene.addWall(localX, localY, plane, vertexMix, SceneCluster.anIntArray761[face], SceneCluster.anIntArray761[i_46_], hash, renderable, renderable_47_, objectConfig);
                if(gameObjectDefinition.wall) {
                    if(face == 0) {
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 585));
                        CacheIndex.anIntArrayArrayArray262[plane][localX][(localY + 1)] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY + 1]), 1170));
                    } else if(face == 1) {
                        CacheIndex.anIntArrayArrayArray262[plane][localX][1 + localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][1 + localY]), 1170));
                        CacheIndex.anIntArrayArrayArray262[plane][1 + localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][1 + localX][localY]), 585));
                    } else if(face == 2) {
                        CacheIndex.anIntArrayArrayArray262[plane][localX + 1][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX + 1][localY]), 585));
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 1170));
                    } else if(face == 3) {
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 1170));
                        CacheIndex.anIntArrayArrayArray262[plane][localX][localY] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[plane][localX][localY]), 585));
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
                if(gameObjectDefinition.setDecorDisplacement != 16)
                    scene.method115(plane, localX, localY, gameObjectDefinition.setDecorDisplacement);
            } else if(type == 3) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                    renderable = new GameObject(objectId, 3, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                else
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 3, vertexHeightRight);
                scene.addWall(localX, localY, plane, vertexMix, Class40_Sub5_Sub15.anIntArray2788[face], 0, hash, renderable, null, objectConfig);
                if(gameObjectDefinition.castsShadow) {
                    if(face != 0) {
                        if(face == 1)
                            InteractiveObject.aByteArrayArrayArray492[plane][1 + localX][localY + 1] = (byte) 50;
                        else if(face == 2)
                            InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                        else if(face == 3)
                            InteractiveObject.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                    } else
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][(localY + 1)] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
            } else if(type == 9) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                scene.addEntityB(localX, localY, plane, vertexMix, 0, 1, 1, hash, renderable, objectConfig);
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else {
                if(gameObjectDefinition.adjustToTerrain) {
                    if(face == 1) {
                        int i_48_ = vertexHeightTop;
                        vertexHeightTop = vertexHeightTopRight;
                        vertexHeightTopRight = vertexHeightRight;
                        vertexHeightRight = vertexHeight;
                        vertexHeight = i_48_;
                    } else if(face == 2) {
                        int i_49_ = vertexHeightTop;
                        vertexHeightTop = vertexHeightRight;
                        vertexHeightRight = i_49_;
                        i_49_ = vertexHeightTopRight;
                        vertexHeightTopRight = vertexHeight;
                        vertexHeight = i_49_;
                    } else if(face == 3) {
                        int i_50_ = vertexHeightTop;
                        vertexHeightTop = vertexHeight;
                        vertexHeight = vertexHeightRight;
                        vertexHeightRight = vertexHeightTopRight;
                        vertexHeightTopRight = i_50_;
                    }
                }
                if(type == 4) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, 512 * face, hash, renderable, objectConfig, SceneCluster.anIntArray761[face]);
                } else if(type == 5) {
                    int i_51_ = scene.method122(plane, localX, localY);
                    int i_52_ = 16;
                    if(i_51_ > 0)
                        i_52_ = (GameObjectDefinition.getDefinition((0x1fffedf2 & i_51_) >> 14).setDecorDisplacement);
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.addWallDecoration(localX, localY, plane, vertexMix, i_52_ * Class27.anIntArray666[face], (Class68_Sub1.anIntArray2207[face] * i_52_), face * 512, hash, renderable, objectConfig, SceneCluster.anIntArray761[face]);
                } else if(type == 6) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 256);
                } else if(type == 7) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 512);
                } else if(type == 8) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 768);
                }
            }
        }

    }

    public Model getRotatedModel(int arg0) {
        SpotAnimDefinition spotAnimDefinition = SpotAnimDefinition.forId(anInt2962, 13);
        Model class40_sub5_sub17_sub5 = spotAnimDefinition.method549(anInt2982, 2);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        class40_sub5_sub17_sub5.method804(anInt2976);
        return class40_sub5_sub17_sub5;
    }

    public void method765(int arg0, int arg1) {
        aBoolean2968 = true;
        aDouble2993 += (double) arg1 * aDouble3001;
        aDouble2980 += aDouble3011 * (double) arg1;
        if(arg0 >= 35) {
            aDouble2992 += (aDouble2996 * 0.5 * (double) arg1 * (double) arg1 + (double) arg1 * aDouble2972);
            aDouble2972 += (double) arg1 * aDouble2996;
            anInt3013 = 0x7ff & (int) (Math.atan2(aDouble3011, aDouble3001) * 325.949) + 1024;
            anInt2976 = 0x7ff & (int) (325.949 * Math.atan2(aDouble2972, aDouble2995));
            if(aAnimationSequence_3006 != null) {
                anInt2973 += arg1;
                while((aAnimationSequence_3006.animationLengths[anInt2982] < anInt2973)) {
                    anInt2973 -= aAnimationSequence_3006.animationLengths[anInt2982];
                    anInt2982++;
                    if((aAnimationSequence_3006.anIntArray2485.length <= anInt2982))
                        anInt2982 = 0;
                }
            }
        }
    }

    public void method766(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(!aBoolean2968) {
            double d = (double) (-anInt2958 + arg4);
            double d_32_ = (double) (-anInt2984 + arg2);
            double d_33_ = Math.sqrt(d * d + d_32_ * d_32_);
            aDouble2980 = (double) anInt2958 + d * (double) anInt2989 / d_33_;
            aDouble2993 = (double) anInt2984 + (double) anInt2989 * d_32_ / d_33_;
            aDouble2992 = (double) anInt2957;
        }
        double d = (double) (-arg0 + (1 + anInt2971));
        aDouble3001 = ((double) arg2 - aDouble2993) / d;
        aDouble3011 = ((double) arg4 - aDouble2980) / d;
        aDouble2995 = Math.sqrt(aDouble3001 * aDouble3001 + aDouble3011 * aDouble3011);
        if(!aBoolean2968)
            aDouble2972 = -aDouble2995 * Math.tan((double) anInt2997 * 0.02454369);
        aDouble2996 = (-aDouble2992 + (double) arg3 - aDouble2972 * d) * 2.0 / (d * d);
        if(arg1 != 0)
            Npc.parseTrackedNpcs();
    }
}
