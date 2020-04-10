package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;

public class Item extends Renderable {
    public static RSString aClass1_3049 = RSString.CreateString("Could not complete login)3");
    public static RSString aClass1_3050;
    public static int[] anIntArray3051 = new int[25];
    public static RSString aClass1_3054 = RSString.CreateString("Members object");
    public static boolean[] obfuscatedKeyStatus = new boolean[112];
    public static RSString aClass1_3059 = RSString.CreateString("Too many connections from your address)3");
    public static int friendsCount = 0;
    public static int anInt3065 = -1;
    public static RSString aClass1_3066 = aClass1_3049;
    public static RSString aClass1_3068 = RSString.CreateString(" )2> @whi@");
    public static RSString aClass1_3069;

    static {
        aClass1_3050 = aClass1_3059;
        aClass1_3069 = aClass1_3054;
    }

    public int itemCount;
    public int itemId;

    public static void calculateCameraPosition() {
        int sceneX = (Buffer.cameraOffsetX + (Player.localPlayer.worldX));
        int sceneY = ((Player.localPlayer.worldY) + Class48.cameraOffsetY);
        if(Class40_Sub5_Sub6.currentCameraPositionH - sceneX < -500 || -sceneX + Class40_Sub5_Sub6.currentCameraPositionH > 500 || Class34.currentCameraPositionV + -sceneY < -500 || -sceneY + Class34.currentCameraPositionV > 500) {
            Class34.currentCameraPositionV = sceneY;
            Class40_Sub5_Sub6.currentCameraPositionH = sceneX;
        }
        if(Class40_Sub5_Sub6.currentCameraPositionH != sceneX)
            Class40_Sub5_Sub6.currentCameraPositionH += (-Class40_Sub5_Sub6.currentCameraPositionH + sceneX) / 16;
        if(Class34.currentCameraPositionV != sceneY)
            Class34.currentCameraPositionV += (-Class34.currentCameraPositionV + sceneY) / 16;

        if(obfuscatedKeyStatus[96] && !Console.console.consoleOpen)
            Wall.cameraVelocityHorizontal += (-24 - Wall.cameraVelocityHorizontal) / 2;
        else if(obfuscatedKeyStatus[97] && !Console.console.consoleOpen)
            Wall.cameraVelocityHorizontal += (24 - Wall.cameraVelocityHorizontal) / 2;
        else
            Wall.cameraVelocityHorizontal /= 2;
        if(obfuscatedKeyStatus[98] && !Console.console.consoleOpen)
            Class60.cameraVelocityVertical += (12 + -Class60.cameraVelocityVertical) / 2;
        else if(obfuscatedKeyStatus[99] && !Console.console.consoleOpen)
            Class60.cameraVelocityVertical += (-12 - Class60.cameraVelocityVertical) / 2;
        else
            Class60.cameraVelocityVertical /= 2;
        int i_1_ = Class34.currentCameraPositionV >> 7;
        GroundItemTile.cameraHorizontal = Wall.cameraVelocityHorizontal / 2 + GroundItemTile.cameraHorizontal & 0x7ff;
        int i_2_ = Class40_Sub5_Sub6.currentCameraPositionH >> 7;
        Class65.cameraVertical += Class60.cameraVelocityVertical / 2;
        int i_3_ = 0;
        if(Class65.cameraVertical < 128)
            Class65.cameraVertical = 128;
        if(Class65.cameraVertical > 383)
            Class65.cameraVertical = 383;
        int i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, Class40_Sub5_Sub6.currentCameraPositionH, Class34.currentCameraPositionV);
        if(i_2_ > 3 && i_1_ > 3 && i_2_ < 100 && i_1_ < 100) {
            for(int i_5_ = -4 + i_2_; (i_5_ <= 4 + i_2_); i_5_++) {
                for(int i_6_ = -4 + i_1_; 4 + i_1_ >= i_6_; i_6_++) {
                    int i_7_ = Player.worldLevel;
                    if(i_7_ < 3 && (0x2 & (OverlayDefinition.tile_flags[1][i_5_][i_6_])) == 2)
                        i_7_++;
                    int i_8_ = i_4_ + -(Class40_Sub6.tile_height[i_7_][i_5_][i_6_]);
                    if((i_8_ > i_3_))
                        i_3_ = i_8_;
                }
            }
        }
        int i_9_ = i_3_ * 192;
        if(i_9_ > 98048)
            i_9_ = 98048;
        if(i_9_ < 32768)
            i_9_ = 32768;
        if((Class40_Sub6.secondaryCameraVertical < i_9_)) {
            Class40_Sub6.secondaryCameraVertical += (-Class40_Sub6.secondaryCameraVertical + i_9_) / 24;
        } else if(Class40_Sub6.secondaryCameraVertical > i_9_)
            Class40_Sub6.secondaryCameraVertical += (-Class40_Sub6.secondaryCameraVertical + i_9_) / 80;
    }

    public static void handleMinimapMouse() {
        if(Class27.minimapState != 0) {
            return;
        }
        if(MouseHandler.clickType == 1) {
            int x = -575 + Class57.clickX;
            int y = -5 + (RSString.clickY - 4);
            if(x >= 0 && y >= 0 && x < 146 && y < 151) {
                x -= 73;
                y -= 75;
                int angle = 0x7ff & Class43.cameraYawOffset + GroundItemTile.cameraHorizontal;
                int sin = Rasterizer3D.sinetable[angle];
                int cos = Rasterizer3D.cosinetable[angle];
                cos = (Class51.mapZoomOffset + 256) * cos >> 8;
                sin = (Class51.mapZoomOffset + 256) * sin >> 8;
                int i_14_ = y * sin + (x * cos) >> 11;
                int i_15_ = cos * y - x * sin >> 11;
                int destX = ((Player.localPlayer.worldX) + i_14_ >> 7);
                int destY = (-i_15_ + (Player.localPlayer.worldY) >> 7);
                boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), destX, 0, true, 0, 0, (Player.localPlayer.pathX[0]), destY, 1));
                if(bool) {
                    SceneCluster.packetBuffer.putByte(x);
                    SceneCluster.packetBuffer.putByte(y);
                    SceneCluster.packetBuffer.putShortBE(GroundItemTile.cameraHorizontal);
                    SceneCluster.packetBuffer.putByte(57);
                    SceneCluster.packetBuffer.putByte(Class43.cameraYawOffset);
                    SceneCluster.packetBuffer.putByte(Class51.mapZoomOffset);
                    SceneCluster.packetBuffer.putByte(89);
                    SceneCluster.packetBuffer.putShortBE((Player.localPlayer.worldX));
                    SceneCluster.packetBuffer.putShortBE((Player.localPlayer.worldY));
                    SceneCluster.packetBuffer.putByte(Class40_Sub5_Sub15.arbitraryDestination);
                    SceneCluster.packetBuffer.putByte(63);
                }
            }
        }
    }

    public static void method778(HuffmanEncoding arg1) {
        IdentityKit.aHuffmanEncoding_2590 = arg1;
    }

    public static void method779(Component arg0, boolean arg1, CacheIndex arg2, CacheIndex arg3) {
        if(!ISAAC.aBoolean512) {
            Class8.aClass68_298 = Class40_Sub5_Sub13.method649(265, 128, arg0, -4875);
            Rasterizer.clear();
            GameObject.aClass68_3042 = Class40_Sub5_Sub13.method649(265, 128, arg0, -4875);
            Rasterizer.clear();
            Class39.aClass68_907 = Class40_Sub5_Sub13.method649(171, 509, arg0, -4875);
            Rasterizer.clear();
            Class51.aClass68_1206 = Class40_Sub5_Sub13.method649(132, 360, arg0, -4875);
            Rasterizer.clear();
            Class38.aClass68_887 = Class40_Sub5_Sub13.method649(200, 360, arg0, -4875);
            Rasterizer.clear();
            Class17.aClass68_463 = Class40_Sub5_Sub13.method649(238, 202, arg0, -4875);
            Rasterizer.clear();
            KeyFocusListener.aClass68_1285 = Class40_Sub5_Sub13.method649(238, 203, arg0, -4875);
            Rasterizer.clear();
            GameObjectDefinition.aClass68_2524 = Class40_Sub5_Sub13.method649(94, 74, arg0, -4875);
            Rasterizer.clear();
            Class68.aClass68_1631 = Class40_Sub5_Sub13.method649(94, 75, arg0, -4875);
            Rasterizer.clear();
            byte[] is = arg2.method170(Native.string_blank, SceneCluster.aClass1_772, 1);
            ImageRGB class40_sub5_sub14_sub4 = new ImageRGB(is, arg0);
            Class8.aClass68_298.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(0, 0);
            GameObject.aClass68_3042.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-637, 0);
            Class39.aClass68_907.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-128, 0);
            Class51.aClass68_1206.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-202, -371);
            Class38.aClass68_887.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-202, -171);
            Class17.aClass68_463.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(0, -265);
            KeyFocusListener.aClass68_1285.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-562, -265);
            GameObjectDefinition.aClass68_2524.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-128, -171);
            Class68.aClass68_1631.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-562, -171);
            int[] is_18_ = new int[class40_sub5_sub14_sub4.image_width];
            for(int i = 0; i < class40_sub5_sub14_sub4.image_height; i++) {
                for(int i_19_ = 0; ((i_19_ < class40_sub5_sub14_sub4.image_width)); i_19_++)
                    is_18_[i_19_] = (class40_sub5_sub14_sub4.pixels[(i * class40_sub5_sub14_sub4.image_width + class40_sub5_sub14_sub4.image_width + -i_19_ - 1)]);
                for(int i_20_ = 0; ((i_20_ < class40_sub5_sub14_sub4.image_width)); i_20_++)
                    class40_sub5_sub14_sub4.pixels[i_20_ + class40_sub5_sub14_sub4.image_width * i] = is_18_[i_20_];
            }
            Class8.aClass68_298.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(382, 0);
            GameObject.aClass68_3042.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-255, 0);
            Class39.aClass68_907.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(254, 0);
            Class51.aClass68_1206.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(180, -371);
            Class38.aClass68_887.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(180, -171);
            Class17.aClass68_463.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(382, -265);
            KeyFocusListener.aClass68_1285.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-180, -265);
            GameObjectDefinition.aClass68_2524.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(254, -171);
            Class68.aClass68_1631.method1046((byte) 90);
            class40_sub5_sub14_sub4.method727(-180, -171);
            class40_sub5_sub14_sub4 = HuffmanEncoding.method1028(arg3, Main.aClass1_1762, (byte) 21, Native.string_blank);
            Class39.aClass68_907.method1046((byte) 90);
            class40_sub5_sub14_sub4.drawImage(-128 + (382 + -(class40_sub5_sub14_sub4.image_width / 2)), 18);
            Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2_2775 = Class27.method359(AnimationSequence.aClass1_2488, Native.string_blank, arg3);
            Class59.aClass40_Sub5_Sub14_Sub2_1387 = Class27.method359(ISAAC.aClass1_506, Native.string_blank, arg3);
            Class22.aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(arg3, Class8.aClass1_299, Native.string_blank);
            Class39.aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for(int i = 0; i < 33920; i++)
                Class39.aClass40_Sub5_Sub14_Sub4_918.pixels[i] = Class8.aClass68_298.pixels[i];
            for(int i = 0; i < 33920; i++)
                SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = (GameObject.aClass68_3042.pixels[i]);
            Class51.anIntArray1198 = new int[256];
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[i] = i * 262144;
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[64 + i] = 1024 * i + 16711680;
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[128 + i] = 16776960 + (i * 4);
            for(int i = 0; i < 64; i++)
                Class51.anIntArray1198[i + 192] = 16777215;
            Renderable.anIntArray2865 = new int[256];
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i] = i * 1024;
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 64] = 4 * i + 65280;
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[128 + i] = i * 262144 + 65535;
            if(!arg1)
                method779(null, false, null, null);
            for(int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 192] = 16777215;
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = new int[256];
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[i] = i * 4;
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[64 + i] = 255 + (i * 262144);
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[128 + i] = i * 1024 + 16711935;
            for(int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[192 + i] = 16777215;
            Class42.anIntArray1013 = new int[256];
            Class61.anIntArray1445 = new int[32768];
            Landscape.anIntArray1168 = new int[32768];
            FramemapDefinition.method879(null);
            Class40_Sub5_Sub17_Sub6.anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            Class4.anIntArray178 = new int[32768];
            Class26.anInt622 = 0;
            if(RSCanvas.anInt60 != 0 && !VertexNormal.lowMemory)
                Class33.method412(false, Class55.aClass6_Sub1_1286, 0, (byte) 66, Class30.aClass1_716, 10, Native.string_blank, RSCanvas.anInt60);
            else
                Class33.method405(16969, 10);
            GameShell.method19(false, 24041);
            Class40_Sub5_Sub11.clearScreen = true;
            ISAAC.aBoolean512 = true;
        }
    }

    public static void method780() {
        obfuscatedKeyStatus = null;
        aClass1_3054 = null;
        aClass1_3050 = null;
        aClass1_3059 = null;
        aClass1_3069 = null;
        aClass1_3066 = null;
        aClass1_3068 = null;
        anIntArray3051 = null;
        aClass1_3049 = null;
    }

    public Model getRotatedModel(int arg0) {
        return ItemDefinition.forId(itemId, 10).asGroundStack(true, itemCount);
    }
}
