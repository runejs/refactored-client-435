package org.runejs.client.media.renderable;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.frame.console.Console;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.SceneCamera;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.*;
import org.runejs.Configuration;
import org.runejs.whitelabel.Images;

import java.awt.*;

public class Item extends Renderable {
    public static boolean[] obfuscatedKeyStatus = new boolean[112];
    public static int anInt3065 = -1;

    public int itemCount;
    public int itemId;

    public static void calculateCameraPosition() {
        int sceneX = Player.localPlayer.worldX;
        int sceneY = Player.localPlayer.worldY;
        if (MovedStatics.currentCameraPositionH - sceneX < -500 || -sceneX + MovedStatics.currentCameraPositionH > 500 || MovedStatics.currentCameraPositionV + -sceneY < -500 || -sceneY + MovedStatics.currentCameraPositionV > 500) {
            MovedStatics.currentCameraPositionV = sceneY;
            MovedStatics.currentCameraPositionH = sceneX;
        }
        if (MovedStatics.currentCameraPositionH != sceneX)
            MovedStatics.currentCameraPositionH += (-MovedStatics.currentCameraPositionH + sceneX) / 16;
        if (MovedStatics.currentCameraPositionV != sceneY)
            MovedStatics.currentCameraPositionV += (-MovedStatics.currentCameraPositionV + sceneY) / 16;

        if (obfuscatedKeyStatus[96] && !Console.console.consoleOpen)
            Wall.cameraVelocityHorizontal += (-24 - Wall.cameraVelocityHorizontal) / 2;
        else if (obfuscatedKeyStatus[97] && !Console.console.consoleOpen)
            Wall.cameraVelocityHorizontal += (24 - Wall.cameraVelocityHorizontal) / 2;
        else
            Wall.cameraVelocityHorizontal /= 2;
        if (obfuscatedKeyStatus[98] && !Console.console.consoleOpen)
            Class60.cameraVelocityVertical += (12 + -Class60.cameraVelocityVertical) / 2;
        else if (obfuscatedKeyStatus[99] && !Console.console.consoleOpen)
            Class60.cameraVelocityVertical += (-12 - Class60.cameraVelocityVertical) / 2;
        else
            Class60.cameraVelocityVertical /= 2;
        int i_1_ = MovedStatics.currentCameraPositionV >> 7;
        GroundItemTile.cameraHorizontal = Wall.cameraVelocityHorizontal / 2 + GroundItemTile.cameraHorizontal & 0x7ff;
        int i_2_ = MovedStatics.currentCameraPositionH >> 7;
        Class65.cameraVertical += Class60.cameraVelocityVertical / 2;
        int i_3_ = 0;
        if (Class65.cameraVertical < 128)
            Class65.cameraVertical = 128;
        if (Class65.cameraVertical > 383)
            Class65.cameraVertical = 383;

        // figure out minimum allowed pitch based on surrounding heights
        int i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, MovedStatics.currentCameraPositionH, MovedStatics.currentCameraPositionV);
        if (i_2_ > 3 && i_1_ > 3 && i_2_ < 100 && i_1_ < 100) {
            for (int i_5_ = -4 + i_2_; i_5_ <= 4 + i_2_; i_5_++) {
                for (int i_6_ = -4 + i_1_; 4 + i_1_ >= i_6_; i_6_++) {
                    int i_7_ = Player.worldLevel;
                    if (i_7_ < 3 && (0x2 & OverlayDefinition.tile_flags[1][i_5_][i_6_]) == 2)
                        i_7_++;
                    int i_8_ = i_4_ + -MovedStatics.tile_height[i_7_][i_5_][i_6_];
                    if (i_8_ > i_3_)
                        i_3_ = i_8_;
                }
            }
        }
        int i_9_ = i_3_ * 192;
        if (i_9_ > 98048)
            i_9_ = 98048;
        if (i_9_ < 32768)
            i_9_ = 32768;
        if (SceneCamera.cameraTerrainMinScaledPitch < i_9_) {
            SceneCamera.cameraTerrainMinScaledPitch += (-SceneCamera.cameraTerrainMinScaledPitch + i_9_) / 24;
        } else if (SceneCamera.cameraTerrainMinScaledPitch > i_9_)
            SceneCamera.cameraTerrainMinScaledPitch += (-SceneCamera.cameraTerrainMinScaledPitch + i_9_) / 80;
    }

    public static void method778(HuffmanEncoding arg1) {
        IdentityKit.aHuffmanEncoding_2590 = arg1;
    }

    public static void renderLoginScreen(Component arg0, CacheArchive huffmanCacheArchive, CacheArchive gameImageCacheArchive) {
        if (!ISAAC.aBoolean512) {
            MovedStatics.flameLeftBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            GameObject.flameRightBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            Class39.aProducingGraphicsBuffer_907 = MovedStatics.createGraphicsBuffer(509, 171, arg0);
            Rasterizer.resetPixels();
            Class51.aProducingGraphicsBuffer_1206 = MovedStatics.createGraphicsBuffer(360, 132, arg0);
            Rasterizer.resetPixels();
            MovedStatics.loginBoxGraphics = MovedStatics.createGraphicsBuffer(360, 200, arg0);
            Rasterizer.resetPixels();
            Class17.aProducingGraphicsBuffer_463 = MovedStatics.createGraphicsBuffer(202, 238, arg0);
            Rasterizer.resetPixels();
            KeyFocusListener.aProducingGraphicsBuffer_1285 = MovedStatics.createGraphicsBuffer(203, 238, arg0);
            Rasterizer.resetPixels();
            GameObjectDefinition.aProducingGraphicsBuffer_2524 = MovedStatics.createGraphicsBuffer(74, 94, arg0);
            Rasterizer.resetPixels();
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631 = MovedStatics.createGraphicsBuffer(75, 94, arg0);
            Rasterizer.resetPixels();
            ProducingGraphicsBuffer.muteButton = MovedStatics.createGraphicsBuffer(42, 42, arg0);
            Rasterizer.resetPixels();
            byte[] is = huffmanCacheArchive.method170("", Native.titleImage);
            ImageRGB titleImg = new ImageRGB(is, arg0);
            MovedStatics.flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(0, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-637, 0);
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(-128, 0);
            Class51.aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(-202, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(-202, -171);
            Class17.aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(0, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-562, -265);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(-128, -171);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-562, -171);
            int[] is_18_ = new int[titleImg.imageWidth];
            for (int i = 0; i < titleImg.imageHeight; i++) {
                for (int i_19_ = 0; i_19_ < titleImg.imageWidth; i_19_++)
                    is_18_[i_19_] = titleImg.pixels[i * titleImg.imageWidth + titleImg.imageWidth + -i_19_ - 1];
                for (int i_20_ = 0; i_20_ < titleImg.imageWidth; i_20_++)
                    titleImg.pixels[i_20_ + titleImg.imageWidth * i] = is_18_[i_20_];
            }
            MovedStatics.flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(382, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-255, 0);
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(254, 0);
            Class51.aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(180, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(180, -171);
            Class17.aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(382, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-180, -265);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(254, -171);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-180, -171);
            ProducingGraphicsBuffer.muteButton.prepareRasterizer();
            ImageRGB musicIcon = TabParts.GetPart("music");
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            titleImg = HuffmanEncoding.method1028(gameImageCacheArchive, Native.logo, "");
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            // UNCOMMENT LINE UNDER FOR LOGO
            // class40_sub5_sub14_sub4.drawImage(-128 + 382 + -(class40_sub5_sub14_sub4.imageWidth / 2), 18);
            // Comment line under to remove custom logo:
            ImageRGB logo = Images.GetPart("logo");

            logo.drawImage(-128 + 382 + -(logo.imageWidth / 2), 18);

            Class40_Sub5_Sub15.loginScreenBox = Main.method359(Native.titleBox, "", gameImageCacheArchive);
            Class59.imgLoginScreenButton = Main.method359(Native.titleButton, "", gameImageCacheArchive);
            MovedStatics.aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(gameImageCacheArchive, Native.runes, "");

            Class39.aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for (int i = 0; i < 33920; i++)
                Class39.aClass40_Sub5_Sub14_Sub4_918.pixels[i] = MovedStatics.flameLeftBackground.pixels[i];
            for (int i = 0; i < 33920; i++)
                SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = GameObject.flameRightBackground.pixels[i];
            Class51.anIntArray1198 = new int[256];
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[i] = i * 262144;
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[64 + i] = 1024 * i + 16711680;
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[128 + i] = 16776960 + i * 4;
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[i + 192] = 16777215;
            Renderable.anIntArray2865 = new int[256];
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i] = i * 1024;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 64] = 4 * i + 65280;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[128 + i] = i * 262144 + 65535;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 192] = 16777215;
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = new int[256];
            for (int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[i] = i * 4;
            for (int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[64 + i] = 255 + i * 262144;
            for (int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[128 + i] = i * 1024 + 16711935;
            for (int i = 0; i < 64; i++)
                Class40_Sub5_Sub17_Sub6.anIntArray3248[192 + i] = 16777215;
            MovedStatics.anIntArray1013 = new int[256];
            MovedStatics.anIntArray1445 = new int[32768];
            Landscape.anIntArray1168 = new int[32768];
            FramemapDefinition.method879(null);
            Class40_Sub5_Sub17_Sub6.anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            MovedStatics.anIntArray178 = new int[32768];
            Class26.loginScreenState = 0;
            if (MusicSystem.musicVolume != 0 && !VertexNormal.lowMemory)
                MusicSystem.method412(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
            else
                MusicSystem.method405(10);
            UpdateServer.resetUpdateServerRequests(false);
            MovedStatics.clearScreen = true;
            ISAAC.aBoolean512 = true;
        }
    }


    public Model getRotatedModel() {
        return ItemDefinition.forId(itemId, 10).asGroundStack(true, itemCount);
    }
}
