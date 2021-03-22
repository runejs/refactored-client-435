package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
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
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;

public class Class40_Sub5_Sub17_Sub1 extends Renderable {

    public static String[] aClass1Array2964 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static boolean[] aBooleanArray2975 = new boolean[5];
    public static int menuScreenArea;
    public static int[] directions = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};

    public static int atInventoryInterfaceType = 0;
    public static int anInt3004;


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
            aAnimationSequence_3006 = ProducingGraphicsBuffer_Sub1.method1050(i, 2);
        else
            aAnimationSequence_3006 = null;

    }


    public static void method762(Actor actor) {
        if(actor.anInt3113 != 0) {
            if(actor.facingActorIndex != -1 && actor.facingActorIndex < 32768) {
                Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[actor.facingActorIndex];
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    int i = -class40_sub5_sub17_sub4_sub2.worldY + actor.worldY;
                    int i_10_ = -class40_sub5_sub17_sub4_sub2.worldX + actor.worldX;
                    if(i_10_ != 0 || i != 0)
                        actor.initialFaceDirection = 0x7ff & (int) (325.949 * Math.atan2((double) i_10_, (double) i));
                }
            }
            if(actor.facingActorIndex >= 32768) {
                int i = -32768 + actor.facingActorIndex;
                if(i == PlayerAppearance.anInt708)
                    i = 2047;
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    int i_11_ = actor.worldX - class40_sub5_sub17_sub4_sub1.worldX;
                    int i_12_ = -class40_sub5_sub17_sub4_sub1.worldY + actor.worldY;
                    if(i_11_ != 0 || i_12_ != 0)
                        actor.initialFaceDirection = (int) (Math.atan2((double) i_11_, (double) i_12_) * 325.949) & 0x7ff;
                }
            }
            if((actor.facePositionX != 0 || actor.facePositionY != 0) && (actor.anInt3109 == 0 || actor.anInt3074 > 0)) {
                int i = actor.worldY - 64 * (actor.facePositionY - Class26.baseY - Class26.baseY);
                int i_13_ = -((-SpotAnimDefinition.baseX + actor.facePositionX + -SpotAnimDefinition.baseX) * 64) + actor.worldX;
                if(i_13_ != 0 || i != 0)
                    actor.initialFaceDirection = 0x7ff & (int) (325.949 * Math.atan2((double) i_13_, (double) i));
                actor.facePositionY = 0;
                actor.facePositionX = 0;
            }
            int i = 0x7ff & actor.initialFaceDirection + -actor.anInt3118;
            if(i != 0) {
                actor.anInt3097++;
                if(i > 1024) {
                    actor.anInt3118 -= actor.anInt3113;
                    boolean bool = true;
                    if(actor.anInt3113 > i || 2048 + -actor.anInt3113 < i) {
                        bool = false;
                        actor.anInt3118 = actor.initialFaceDirection;
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
                    if(i < actor.anInt3113 || i > -actor.anInt3113 + 2048) {
                        actor.anInt3118 = actor.initialFaceDirection;
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

    public static void method763(Component arg0, CacheArchive arg2) {
        if(!MovedStatics.aBoolean2083) {
            FloorDecoration.inventoryBackgroundImage = Main.method359(Native.aClass1_638, Native.aClass1_305, arg2);
            Class44.chatboxBackgroundImage = Main.method359(Native.chatback, Native.aClass1_305, arg2);
            MovedStatics.minimapBackgroundImage = Main.method359(Native.mapBack, Native.aClass1_305, arg2);
            Class57.bottomChatBack = Main.method359(Native.aClass1_1395, Native.aClass1_305, arg2);
            MovedStatics.tabBottomBack = Main.method359(Native.aClass1_256, Native.aClass1_305, arg2);
            Buffer.tabTopBack = Main.method359(Native.aClass1_338, Native.aClass1_305, arg2);
            RSCanvas.chatBoxImageProducer = Class40_Sub5_Sub13.createGraphicsBuffer(479, 96, arg0);
            Class44.chatboxBackgroundImage.drawImage(0, 0);
            RSString.mapbackProducingGraphicsBuffer = Class40_Sub5_Sub13.createGraphicsBuffer(172, 156, arg0);
            Rasterizer.resetPixels();
            MovedStatics.minimapBackgroundImage.drawImage(0, 0);
            MovedStatics.tabImageProducer = Class40_Sub5_Sub13.createGraphicsBuffer(190, 261, arg0);
            FloorDecoration.inventoryBackgroundImage.drawImage(0, 0);
            VarbitDefinition.gameScreenImageProducer = Class40_Sub5_Sub13.createGraphicsBuffer(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight, arg0);
            Rasterizer.resetPixels();
            HuffmanEncoding.aProducingGraphicsBuffer_1541 = Class40_Sub5_Sub13.createGraphicsBuffer(496, 50, arg0);
            RSCanvas.tabBottom = Class40_Sub5_Sub13.createGraphicsBuffer(269, 37, arg0);
            InteractiveObject.tabTop = Class40_Sub5_Sub13.createGraphicsBuffer(249, 45, arg0);
            ImageRGB image = HuffmanEncoding.method1028(arg2, Native.imgBackleft1, (byte) 21, Native.aClass1_305);
            Landscape.framePieceRight = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_1024, (byte) 21, Native.aClass1_305);
            MovedStatics.chatboxRight = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_281, (byte) 21, Native.aClass1_305);
            Class39.mapbackLeft = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.backright2, (byte) 21, Native.aClass1_305);
            GameObject.tabPieceLeft = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_1788, (byte) 21, Native.aClass1_305);
            Class40_Sub5_Sub17_Sub6.framePieceTop = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_1374, (byte) 21, Native.aClass1_305);
            Class40_Sub7.mapBackRight = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_2588, (byte) 21, Native.aClass1_305);
            MovedStatics.tabPieceUpperRight = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_196, (byte) 21, Native.aClass1_305);
            PlayerAppearance.tabPieveLowerRight = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            image = HuffmanEncoding.method1028(arg2, Native.aClass1_304, (byte) 21, Native.aClass1_305);
            Class17.chatboxTop = Class40_Sub5_Sub13.createGraphicsBuffer(image.imageWidth, image.imageHeight, arg0);
            image.drawInverse(0, 0);
            MovedStatics.aClass40_Sub5_Sub14_Sub2_1315 = Main.method359(Native.aClass1_2093, Native.aClass1_305, arg2);
            GameShell.aClass40_Sub5_Sub14_Sub2_1 = Main.method359(Native.aClass1_3254, Native.aClass1_305, arg2);
            Class35.aClass40_Sub5_Sub14_Sub2_1744 = Main.method359(Native.aClass1_1517, Native.aClass1_305, arg2);
            MovedStatics.aClass40_Sub5_Sub14_Sub2_2105 = MovedStatics.aClass40_Sub5_Sub14_Sub2_1315.method691();
            MovedStatics.aClass40_Sub5_Sub14_Sub2_2105.flipHorizontal();
            WallDecoration.aClass40_Sub5_Sub14_Sub2_1270 = GameShell.aClass40_Sub5_Sub14_Sub2_1.method691();
            WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.flipHorizontal();
            Renderable.aClass40_Sub5_Sub14_Sub2_2860 = MovedStatics.aClass40_Sub5_Sub14_Sub2_1315.method691();
            Renderable.aClass40_Sub5_Sub14_Sub2_2860.flipVertical();
            MovedStatics.aClass40_Sub5_Sub14_Sub2_549 = GameShell.aClass40_Sub5_Sub14_Sub2_1.method691();
            MovedStatics.aClass40_Sub5_Sub14_Sub2_549.flipVertical();
            MovedStatics.aClass40_Sub5_Sub14_Sub2_1919 = Class35.aClass40_Sub5_Sub14_Sub2_1744.method691();
            MovedStatics.aClass40_Sub5_Sub14_Sub2_1919.flipVertical();
            ISAAC.aClass40_Sub5_Sub14_Sub2_524 = MovedStatics.aClass40_Sub5_Sub14_Sub2_1315.method691();
            ISAAC.aClass40_Sub5_Sub14_Sub2_524.flipHorizontal();
            ISAAC.aClass40_Sub5_Sub14_Sub2_524.flipVertical();
            Class13.aClass40_Sub5_Sub14_Sub2_418 = GameShell.aClass40_Sub5_Sub14_Sub2_1.method691();
            Class13.aClass40_Sub5_Sub14_Sub2_418.flipHorizontal();
            Class13.aClass40_Sub5_Sub14_Sub2_418.flipVertical();
            Class40_Sub5_Sub15.tabIcons = IndexedImage.getMultipleIndexedImages(arg2, Native.aClass1_2787, Native.aClass1_305);
            Landscape.anIntArray1186 = new int[151];
            MovedStatics.anIntArray852 = new int[151];
            RSCanvas.anIntArray66 = new int[33];
            RSCanvas.anIntArray62 = new int[33];
            for(int y = 0; y < 33; y++) {
                int i_15_ = 0;
                int i_16_ = 999;
                for(int x = 0; x < 34; x++) {
                    if(MovedStatics.minimapBackgroundImage.imgPixels[MovedStatics.minimapBackgroundImage.imgWidth * y + x] == 0) {
                        if(i_16_ == 999)
                            i_16_ = x;
                    } else if(i_16_ != 999) {
                        i_15_ = x;
                        break;
                    }
                }
                RSCanvas.anIntArray62[y] = i_16_;
                RSCanvas.anIntArray66[y] = -i_16_ + i_15_;
            }
            for(int y = 5; y < 156; y++) {
                int maxWidth = 0;
                int minWidth = 999;
                for(int x = 25; x < 172; x++) {
                    if(MovedStatics.minimapBackgroundImage.imgPixels[x + MovedStatics.minimapBackgroundImage.imgWidth * y] != 0 || x <= 34 && y <= 34) {
                        if(minWidth != 999) {
                            maxWidth = x;
                            break;
                        }
                    } else if(minWidth == 999)
                        minWidth = x;
                }
                Landscape.anIntArray1186[-5 + y] = minWidth - 25;
                MovedStatics.anIntArray852[-5 + y] = maxWidth + -minWidth;
            }
            MovedStatics.aBoolean2083 = true;
        }
    }

    public static int method764(byte arg0) {
        if(!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
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
            if((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                i = Player.worldLevel;
            int i_24_ = Player.localPlayer.worldX >> 7;
            int i_25_ = Player.localPlayer.worldY >> 7;
            int i_26_;
            if(i_24_ <= i_23_)
                i_26_ = -i_24_ + i_23_;
            else
                i_26_ = -i_23_ + i_24_;
            int i_27_;
            if(i_22_ < i_25_)
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
                    if((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                        i = Player.worldLevel;
                    if(i_29_ >= 65536) {
                        if(i_23_ < i_24_)
                            i_23_++;
                        else if(i_24_ < i_23_)
                            i_23_--;
                        i_29_ -= 65536;
                        if(i_22_ > 103) {
                            i_22_ = 103;
                        }
                        if(i_23_ > 103) {
                            i_23_ = 103;
                        }
                        if((0x4 & OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_]) != 0)
                            i = Player.worldLevel;
                    }
                }
            } else {
                int i_30_ = i_27_ * 65536 / i_26_;
                int i_31_ = 32768;
                while(i_23_ != i_24_) {
                    if(i_23_ >= i_24_) {
                        if(i_24_ < i_23_)
                            i_23_--;
                    } else
                        i_23_++;
                    if((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                        i = Player.worldLevel;
                    i_31_ += i_30_;
                    if(i_31_ >= 65536) {
                        i_31_ -= 65536;
                        if(i_25_ > i_22_)
                            i_22_++;
                        else if(i_22_ > i_25_)
                            i_22_--;
                        if((OverlayDefinition.tile_flags[Player.worldLevel][i_23_][i_22_] & 0x4) != 0)
                            i = Player.worldLevel;
                    }
                }
            }
        }
        if(arg0 > -101)
            CacheArchive.skinDefinitionCacheArchive = null;
        if((OverlayDefinition.tile_flags[Player.worldLevel][Player.localPlayer.worldX >> 7][Player.localPlayer.worldY >> 7] & 0x4) != 0)
            i = Player.worldLevel;
        return i;

    }

    public static void addObject(int objectId, int localX, int localY, int plane, int face, int type, Scene scene, CollisionMap collisionMap) {
        if(!VertexNormal.lowMemory || (0x2 & OverlayDefinition.tile_flags[0][localX][localY]) != 0 || (0x10 & OverlayDefinition.tile_flags[plane][localX][localY]) == 0 && MovedStatics.onBuildTimePlane == Class59.getVisibilityPlaneFor(plane, localY, 0, localX)) {
            if(Class64.lowestPlane > plane)
                Class64.lowestPlane = plane;
            int vertexHeight = MovedStatics.tile_height[plane][localX][localY];
            int vertexHeightRight = MovedStatics.tile_height[plane][localX + 1][localY];
            int vertexHeightTopRight = MovedStatics.tile_height[plane][localX + 1][localY + 1];
            int vertexHeightTop = MovedStatics.tile_height[plane][localX][localY + 1];
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
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 22, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 22, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addGroundDecoration(localX, localY, plane, vertexMix, hash, renderable, objectConfig);
                    if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1 && collisionMap != null)
                        collisionMap.markBlocked(localY, localX);
                }
            } else if(type == 10 || type == 11) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 10, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
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
                            class40_sub5_sub17_sub5 = (Model) renderable;
                        else
                            class40_sub5_sub17_sub5 = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, vertexHeightRight);
                        if(class40_sub5_sub17_sub5 != null) {
                            for(int i_43_ = 0; i_43_ <= i_41_; i_43_++) {
                                for(int i_44_ = 0; i_40_ >= i_44_; i_44_++) {
                                    int i_45_ = class40_sub5_sub17_sub5.method805() / 4;
                                    if(i_45_ > 30)
                                        i_45_ = 30;
                                    if(i_45_ > InteractiveObject.aByteArrayArrayArray492[plane][localX + i_43_][localY + i_44_])
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
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                else
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, vertexHeightRight);
                scene.addEntityB(localX, localY, plane, vertexMix, 0, 1, 1, hash, renderable, objectConfig);
                if(type >= 12 && type <= 17 && type != 13 && plane > 0)
                    MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 2340);
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkSolidOccupant(localX, localY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, face, gameObjectDefinition.walkable);
            } else if(type == 0) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 0, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 0, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                scene.addWall(localX, localY, plane, vertexMix, SceneCluster.anIntArray761[face], 0, hash, renderable, null, objectConfig);
                if(face == 0) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY + 1] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 585);
                } else if(face == 1) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY + 1] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY + 1] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY + 1], 1170);
                } else if(face == 2) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][1 + localX][localY] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        MovedStatics.anIntArrayArrayArray262[plane][localX + 1][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX + 1][localY], 585);
                } else if(face == 3) {
                    if(gameObjectDefinition.castsShadow) {
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                        InteractiveObject.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                    }
                    if(gameObjectDefinition.wall)
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 1170);
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
                if(gameObjectDefinition.setDecorDisplacement != 16)
                    scene.method115(plane, localX, localY, gameObjectDefinition.setDecorDisplacement);
            } else if(type == 1) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 1, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 1, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                scene.addWall(localX, localY, plane, vertexMix, Class40_Sub5_Sub15.anIntArray2788[face], 0, hash, renderable, null, objectConfig);
                if(gameObjectDefinition.castsShadow) {
                    if(face == 0)
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY + 1] = (byte) 50;
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
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face + 4, vertexHeight, 2, vertexHeightRight);
                    renderable_47_ = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, i_46_, vertexHeight, 2, vertexHeightRight);
                } else {
                    renderable = new GameObject(objectId, 2, 4 + face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    renderable_47_ = new GameObject(objectId, 2, i_46_, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                }
                scene.addWall(localX, localY, plane, vertexMix, SceneCluster.anIntArray761[face], SceneCluster.anIntArray761[i_46_], hash, renderable, renderable_47_, objectConfig);
                if(gameObjectDefinition.wall) {
                    if(face == 0) {
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 585);
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY + 1] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY + 1], 1170);
                    } else if(face == 1) {
                        MovedStatics.anIntArrayArrayArray262[plane][localX][1 + localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][1 + localY], 1170);
                        MovedStatics.anIntArrayArrayArray262[plane][1 + localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][1 + localX][localY], 585);
                    } else if(face == 2) {
                        MovedStatics.anIntArrayArrayArray262[plane][localX + 1][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX + 1][localY], 585);
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 1170);
                    } else if(face == 3) {
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 1170);
                        MovedStatics.anIntArrayArrayArray262[plane][localX][localY] = UnderlayDefinition.bitWiseOR(MovedStatics.anIntArrayArrayArray262[plane][localX][localY], 585);
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
                if(gameObjectDefinition.setDecorDisplacement != 16)
                    scene.method115(plane, localX, localY, gameObjectDefinition.setDecorDisplacement);
            } else if(type == 3) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                    renderable = new GameObject(objectId, 3, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                else
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 3, vertexHeightRight);
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
                        InteractiveObject.aByteArrayArrayArray492[plane][localX][localY + 1] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.unmarkWall(localX, localY, type, face, gameObjectDefinition.walkable);
            } else if(type == 9) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
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
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, 512 * face, hash, renderable, objectConfig, SceneCluster.anIntArray761[face]);
                } else if(type == 5) {
                    int i_51_ = scene.method122(plane, localX, localY);
                    int i_52_ = 16;
                    if(i_51_ > 0)
                        i_52_ = GameObjectDefinition.getDefinition((0x1fffedf2 & i_51_) >> 14).setDecorDisplacement;
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, i_52_ * MovedStatics.anIntArray666[face], ProducingGraphicsBuffer_Sub1.anIntArray2207[face] * i_52_, face * 512, hash, renderable, objectConfig, SceneCluster.anIntArray761[face]);
                } else if(type == 6) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 256);
                } else if(type == 7) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 512);
                } else if(type == 8) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.createTerrainObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addWallDecoration(localX, localY, plane, vertexMix, 0, 0, face, hash, renderable, objectConfig, 768);
                }
            }
        }

    }

    public Model getRotatedModel() {
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
            aDouble2992 += aDouble2996 * 0.5 * (double) arg1 * (double) arg1 + (double) arg1 * aDouble2972;
            aDouble2972 += (double) arg1 * aDouble2996;
            anInt3013 = 0x7ff & (int) (Math.atan2(aDouble3011, aDouble3001) * 325.949) + 1024;
            anInt2976 = 0x7ff & (int) (325.949 * Math.atan2(aDouble2972, aDouble2995));
            if(aAnimationSequence_3006 != null) {
                anInt2973 += arg1;
                while(aAnimationSequence_3006.frameLengths[anInt2982] < anInt2973) {
                    anInt2973 -= aAnimationSequence_3006.frameLengths[anInt2982];
                    anInt2982++;
                    if(aAnimationSequence_3006.frameIds.length <= anInt2982)
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
        double d = (double) (-arg0 + 1 + anInt2971);
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
