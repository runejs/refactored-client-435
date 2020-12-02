package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.node.Node;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class40_Sub3 extends Node {
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2019;
    public static int anInt2020;
    public static int[] soundDelay = new int[50];
    public static int anInt2024 = 1;
    public static boolean aBoolean2026 = false;
    public static int anInt2032 = 0;
    public int anInt2017;
    public int anInt2018;
    public int anInt2025;
    public int anInt2027;
    public int anInt2028;
    public int anInt2030;
    public int anInt2031 = -1;
    public int anInt2033 = 0;
    public int anInt2035;
    public int anInt2036;
    public int anInt2038;
    public int anInt2039;


    public static void startup(int arg0) {
        if (Class40_Sub5_Sub6.anInt2451 == 0) {
            Npc.currentScene = new Scene(Class40_Sub6.tile_height);
            for (int i = 0; i < 4; i++)
                Landscape.currentCollisionMap[i] = new CollisionMap(104, 104);
            Class40_Sub5_Sub13.minimapImage = new ImageRGB(512, 512);
            Class67.anInt1607 = 5;
            Class40_Sub5_Sub6.anInt2451 = 20;
            Native.currentLoadingText = English.startingGameEngine;
        } else if (Class40_Sub5_Sub6.anInt2451 == 20) {
//            int[] is = new int[9];
//            for (int i = 0; i < 9; i++) {
//                int i_0_ = 15 + 32 * i + 128;
//                int i_1_ = 3 * i_0_ + 600;
//                int i_2_ = Rasterizer3D.sinetable[i_0_];
//                is[i] = i_2_ * i_1_ >> 16;
//            }
//            Scene.method95(500, 800, 512, 334, is);
            ScreenController.setBounds();
            Class67.anInt1607 = 10;
            Native.currentLoadingText = English.preparedVisibilityMap;
            Class40_Sub5_Sub6.anInt2451 = 30;
        } else if (Class40_Sub5_Sub6.anInt2451 == 30) {
            CacheIndex.skeletonCacheIndex = CacheIndex.loadCacheIndex(0, true, false, true);
            CacheIndex.skinDefinitionCacheIndex = CacheIndex.loadCacheIndex(1, true, false, true);
            CacheIndex.gameDefinitionsCacheIndex = CacheIndex.loadCacheIndex(2, true, true, false);
            CacheIndex.gameInterfaceCacheIndex = CacheIndex.loadCacheIndex(3, true, false, true);
            CacheIndex.soundEffectCacheIndex = CacheIndex.loadCacheIndex(4, true, false, true);
            CacheIndex.gameWorldMapCacheIndex = CacheIndex.loadCacheIndex(5, true, true, true);
            CacheIndex.musicCacheIndex = CacheIndex.loadCacheIndex(6, false, true, true);
            CacheIndex.modelCacheIndex = CacheIndex.loadCacheIndex(7, true, false, true);
            CacheIndex.gameImageCacheIndex = CacheIndex.loadCacheIndex(8, true, false, true);
            CacheIndex.gameTextureCacheIndex = CacheIndex.loadCacheIndex(9, true, false, true);
            CacheIndex.huffmanCacheIndex = CacheIndex.loadCacheIndex(10, true, false, true);
            CacheIndex.jingleCacheIndex = CacheIndex.loadCacheIndex(11, true, false, true);
            CacheIndex.clientScriptCacheIndex = CacheIndex.loadCacheIndex(12, true, false, true);
            Class40_Sub5_Sub6.anInt2451 = 40;
            Native.currentLoadingText = English.connectingToUpdateServer;
            Class67.anInt1607 = 20;
        } else if (Class40_Sub5_Sub6.anInt2451 == 40) {
            int i = 0;
            i += CacheIndex.skeletonCacheIndex.getPercentLoaded() * 5 / 100;
            i += 5 * CacheIndex.skinDefinitionCacheIndex.getPercentLoaded() / 100;
            i += 5 * CacheIndex.gameDefinitionsCacheIndex.getPercentLoaded() / 100;
            i += 5 * CacheIndex.gameInterfaceCacheIndex.getPercentLoaded() / 100;
            i += 5 * CacheIndex.soundEffectCacheIndex.getPercentLoaded() / 100;
            i += 5 * CacheIndex.gameWorldMapCacheIndex.getPercentLoaded() / 100;
            i += CacheIndex.musicCacheIndex.getPercentLoaded() * 5 / 100;
            i += 40 * CacheIndex.modelCacheIndex.getPercentLoaded() / 100;
            i += CacheIndex.gameImageCacheIndex.getPercentLoaded() * 5 / 100;
            i += CacheIndex.gameTextureCacheIndex.getPercentLoaded() * 5 / 100;
            i += 5 * CacheIndex.huffmanCacheIndex.getPercentLoaded() / 100;
            i += 5 * CacheIndex.jingleCacheIndex.getPercentLoaded() / 100;
            i += 5 * CacheIndex.clientScriptCacheIndex.getPercentLoaded() / 100;
            if (i == 100) {
                Class40_Sub5_Sub6.anInt2451 = 45;
                Native.currentLoadingText = English.loadedUpdateList;
                Class67.anInt1607 = 30;
            } else {
                if (i != 0)
                    Native.currentLoadingText = English.checkingForUpdates + i + Native.percent;
                Class67.anInt1607 = 30;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 45) {
            MovedStatics.method446(ISAAC.aClass31_521, 0, !VertexNormal.lowMemory, (byte) 30);
            Class49.aClass40_Sub9_Sub1_1152 = MouseHandler.method1003(ISAAC.aClass31_521, MouseHandler.aCanvas1469, arg0 ^ 0x74be);
            Class55.aClass48_1289 = new Class48(22050, CollisionMap.anInt141);
            Class40_Sub5_Sub6.anInt2451 = 50;
            Native.currentLoadingText = English.preparedSoundEngine;
            Class67.anInt1607 = 35;
        } else if (Class40_Sub5_Sub6.anInt2451 == 50) {
            int i = 0;
            if (TypeFace.fontSmall != null)
                i++;
            else
                TypeFace.fontSmall = TypeFace.loadTypeFace(CacheIndex.gameImageCacheIndex, "", Native.aClass1_2101);
            if (WallDecoration.fontNormal != null)
                i++;
            else
                WallDecoration.fontNormal = TypeFace.loadTypeFace(CacheIndex.gameImageCacheIndex, "", Native.aClass1_1580);
            if (TypeFace.fontBold != null)
                i++;
            else
                TypeFace.fontBold = TypeFace.loadTypeFace(CacheIndex.gameImageCacheIndex, "", Native.aClass1_1921);
            if (i < 3) {
                Native.currentLoadingText = English.loadingFonts + (i * 100 / 3) + Native.percent;
                Class67.anInt1607 = 40;
            } else {
                Class40_Sub5_Sub6.anInt2451 = 60;
                Class67.anInt1607 = 40;
                Native.currentLoadingText = English.loadedFonts;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 60) {
            int i = Class60.method988(CacheIndex.huffmanCacheIndex, CacheIndex.gameImageCacheIndex);
            int i_3_ = ISAAC.method288((byte) 119);
            if (i < i_3_) {
                Native.currentLoadingText = English.loadingTitleScreen + (100 * i / i_3_) + Native.percent;
                Class67.anInt1607 = 50;
            } else {
                Console.console = new Console();
                Native.currentLoadingText = English.loadedTitleScreen;
                Class67.anInt1607 = 50;
                OverlayDefinition.method559(5);
                Class40_Sub5_Sub6.anInt2451 = 70;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 70) {
            if (CacheIndex.gameDefinitionsCacheIndex.method185((byte) 98)) {
                MovedStatics.method441(CacheIndex.gameDefinitionsCacheIndex);
                UnderlayDefinition.method616(CacheIndex.gameDefinitionsCacheIndex);
                method977(3, CacheIndex.gameDefinitionsCacheIndex, CacheIndex.modelCacheIndex);
                method980(28987, CacheIndex.modelCacheIndex, VertexNormal.lowMemory, CacheIndex.gameDefinitionsCacheIndex);
                Main.method357(CacheIndex.modelCacheIndex, arg0 ^ ~0x2a85, CacheIndex.gameDefinitionsCacheIndex);
                Class42.method885(CacheIndex.gameDefinitionsCacheIndex, Class22.membersWorld, CacheIndex.modelCacheIndex);
                MovedStatics.method236(CacheIndex.skinDefinitionCacheIndex, CacheIndex.gameDefinitionsCacheIndex, CacheIndex.skeletonCacheIndex);
                Class55.method966(arg0 ^ 0x38, CacheIndex.modelCacheIndex, CacheIndex.gameDefinitionsCacheIndex);
                Landscape.method936(CacheIndex.gameDefinitionsCacheIndex);
                Main.method43(CacheIndex.gameDefinitionsCacheIndex);
                GameInterface.createInterfaceMemoryBuffers();
                Class40_Sub5_Sub6.anInt2451 = 80;
                Class67.anInt1607 = 60;
                Native.currentLoadingText = English.loadedConfig;
            } else {
                Native.currentLoadingText = English.loadingConfig + CacheIndex.gameDefinitionsCacheIndex.method202() + Native.percent;
                Class67.anInt1607 = 60;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 80) {
            int i = 0;
            if (AnimationSequence.minimapCompass != null)
                i++;
            else
                AnimationSequence.minimapCompass = HuffmanEncoding.method1028(CacheIndex.gameImageCacheIndex, Native.compass, (byte) 21, "");
            if (SpotAnimDefinition.minimapEdge == null)
                SpotAnimDefinition.minimapEdge = HuffmanEncoding.method1028(CacheIndex.gameImageCacheIndex, Native.aClass1_1427, (byte) 21, "");
            else
                i++;
            if (SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301 != null)
                i++;
            else
                SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301 = IndexedImage.getMultipleIndexedImages(CacheIndex.gameImageCacheIndex, Native.aClass1_671, "");
            if (Class8.aClass40_Sub5_Sub14_Sub4Array296 == null)
                Class8.aClass40_Sub5_Sub14_Sub4Array296 = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.mapFunction, "");
            else
                i++;
            if (AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474 != null)
                i++;
            else
                AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474 = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.aClass1_2114, "");
            if (FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603 == null)
                FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603 = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.aClass1_2161, "");
            else
                i++;
            if (ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204 != null)
                i++;
            else
                ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204 = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.headiconsPrayer, "");
            if (UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567 == null)
                UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567 = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.aClass1_1230, "");
            else
                i++;
            if (LinkedList.aClass40_Sub5_Sub14_Sub4_1057 == null)
                LinkedList.aClass40_Sub5_Sub14_Sub4_1057 = HuffmanEncoding.method1028(CacheIndex.gameImageCacheIndex, Native.aClass1_2109, (byte) 21, "");
            else
                i++;
            if (aClass40_Sub5_Sub14_Sub4Array2019 == null)
                aClass40_Sub5_Sub14_Sub4Array2019 = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.aClass1_203, "");
            else
                i++;
            if (Class37.cursorCross != null)
                i++;
            else
                Class37.cursorCross = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.aClass1_2179, "");
            if (MovedStatics.mapDots == null)
                MovedStatics.mapDots = Class40_Sub2.method526(CacheIndex.gameImageCacheIndex, Native.aClass1_183, "");
            else
                i++;
            if (CacheIndex.aClass40_Sub5_Sub14_Sub2Array215 == null)
                CacheIndex.aClass40_Sub5_Sub14_Sub2Array215 = IndexedImage.getMultipleIndexedImages(CacheIndex.gameImageCacheIndex, Native.scrollbar, "");
            else
                i++;
            if (Class40_Sub5_Sub13.moderatorIcon != null)
                i++;
            else
                Class40_Sub5_Sub13.moderatorIcon = IndexedImage.getMultipleIndexedImages(CacheIndex.gameImageCacheIndex, Native.aClass1_881, "");
            if (i < 14) {
                Native.currentLoadingText = English.loadingSprites + (100 * i / 14) + Native.percent;
                Class67.anInt1607 = 70;
            } else {
                SpotAnimDefinition.minimapEdge.trim();
                int i_4_ = (int) (Math.random() * 21.0) - 10;
                int i_5_ = (int) (21.0 * Math.random()) - 10;
                int i_6_ = (int) (41.0 * Math.random()) - 20;
                int i_7_ = -10 + (int) (21.0 * Math.random());
                for (int i_8_ = 0; Class8.aClass40_Sub5_Sub14_Sub4Array296.length > i_8_; i_8_++)
                    Class8.aClass40_Sub5_Sub14_Sub4Array296[i_8_].method717(i_6_ + i_4_, i_5_ + i_6_, i_7_ + i_6_);
                SpotAnimDefinition.aClass40_Sub5_Sub14_Sub2Array2301[0].mixPalette(i_4_ + i_6_, i_5_ + i_6_, i_6_ + i_7_);
                Native.currentLoadingText = English.loadedSprites;
                Class67.anInt1607 = 70;
                Class40_Sub5_Sub6.anInt2451 = 85;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 85) {
            int i = KeyFocusListener.method955(CacheIndex.gameImageCacheIndex);
            int i_9_ = ActorDefinition.method576();
            if (i < i_9_) {
                Native.currentLoadingText = English.loadingGameScreen + (i * 100 / i_9_) + Native.percent;
                Class67.anInt1607 = 80;
            } else {
                Native.currentLoadingText = English.loadedGamescreen;
                Class40_Sub5_Sub6.anInt2451 = 90;
                Class67.anInt1607 = 80;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 90) {
            if (CacheIndex.gameTextureCacheIndex.method185((byte) 62)) {
                Class35 class35 = new Class35(CacheIndex.gameTextureCacheIndex, CacheIndex.gameImageCacheIndex, 20, 0.8, !VertexNormal.lowMemory ? 128 : 64);
                Rasterizer3D.method703(class35);
                Rasterizer3D.method711(0.8);
                Class40_Sub5_Sub6.anInt2451 = 110;
                Class67.anInt1607 = 90;
                Native.currentLoadingText = English.loadedTextures;
            } else {
                Native.currentLoadingText = English.loadingTextures + CacheIndex.gameTextureCacheIndex.method202() + Native.percent;
                Class67.anInt1607 = 90;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 110) {
            Class12.mouseCapturer = new Class39();
            ISAAC.aClass31_521.method394(10, 0, Class12.mouseCapturer);
            Native.currentLoadingText = English.loadedInputHandler;
            Class40_Sub5_Sub6.anInt2451 = 120;
            Class67.anInt1607 = 94;
        } else if (Class40_Sub5_Sub6.anInt2451 == 120) {
            if (CacheIndex.huffmanCacheIndex.method194(Native.huffman, "")) {
                HuffmanEncoding huffmanEncoding = new HuffmanEncoding(CacheIndex.huffmanCacheIndex.method170("", Native.huffman));
                Item.method778(huffmanEncoding);
                Class40_Sub5_Sub6.anInt2451 = 130;
                Native.currentLoadingText = English.loadedWordpack;
                Class67.anInt1607 = 96;
            } else {
                Native.currentLoadingText = English.loadingWordPack + Native.aClass1_1348;
                Class67.anInt1607 = 96;
            }
        } else if (Class40_Sub5_Sub6.anInt2451 == 130) {
            if (!CacheIndex.gameInterfaceCacheIndex.method185((byte) 66)) {
                Native.currentLoadingText = English.loadingInterfaces + (4 * CacheIndex.gameInterfaceCacheIndex.method202() / 5) + Native.percent;
                Class67.anInt1607 = 100;
            } else if (CacheIndex.clientScriptCacheIndex.method185((byte) 69)) {
                Native.currentLoadingText = English.loadedInterfaces;
                Class40_Sub5_Sub6.anInt2451 = 140;
                Class67.anInt1607 = 100;
            } else {
                Native.currentLoadingText = English.loadingInterfaces + (80 + CacheIndex.clientScriptCacheIndex.method202() / 5) + Native.percent;
                Class67.anInt1607 = 100;
            }
        } else {
            if (arg0 != 100)
                aClass40_Sub5_Sub14_Sub4Array2019 = null;
            if (Class40_Sub5_Sub6.anInt2451 == 140)
                OverlayDefinition.method559(10);
        }
    }

    public static UnderlayDefinition method531(byte arg0, int arg1) {
        UnderlayDefinition underlayDefinition = (UnderlayDefinition) WallDecoration.aClass9_1247.get((long) arg1);
        if (underlayDefinition != null)
            return underlayDefinition;
        byte[] is = Actor.aCacheIndex_3150.getFile(arg1, 1);
        underlayDefinition = new UnderlayDefinition();
        if (is != null)
            underlayDefinition.readValues(new Buffer(is));
        underlayDefinition.calculateHsl();
        if (arg0 >= -39)
            English.commandFpson = null;
        WallDecoration.aClass9_1247.put((long) arg1, underlayDefinition);
        return underlayDefinition;
    }

    public static void method977(int arg0, CacheIndex arg1, CacheIndex arg2) {
        MovedStatics.aCacheIndex_654 = arg2;
        if (arg0 == 3) {
            Class49.aCacheIndex_1150 = arg1;
            PlayerAppearance.identityKitLength = Class49.aCacheIndex_1150.fileLength(3);
        }
    }

    public static void method980(int arg0, CacheIndex arg1, boolean arg2, CacheIndex arg3) {
        CacheIndex.definitionCache = arg3;
        GameObjectDefinition.count = CacheIndex.definitionCache.fileLength(6);

        Class35.aBoolean1734 = arg2;
        if (arg0 == 28987)
            RSString.aCacheIndex_1705 = arg1;
    }
}
