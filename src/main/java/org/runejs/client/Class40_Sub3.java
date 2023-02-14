package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.node.Node;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.console.Console;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.WallDecoration;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;

public class Class40_Sub3 extends Node {
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2019;
    public static int ticksPerLoop;
    public static int anInt2024 = 1;
    public static boolean showIconsRedrawnText = false;
    public static int loginStatus = 0;
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


    public static void startup() {
        if (MovedStatics.loadingPercent == 0) {
            Npc.currentScene = new Scene(MovedStatics.tile_height);
            for (int i = 0; i < 4; i++)
                Landscape.currentCollisionMap[i] = new CollisionMap(104, 104);
            MovedStatics.minimapImage = new ImageRGB(512, 512);
            MovedStatics.anInt1607 = 5;
            MovedStatics.loadingPercent = 20;
            Native.currentLoadingText = English.startingGameEngine;
        } else if (MovedStatics.loadingPercent == 20) {
//            int[] is = new int[9];
//            for (int i = 0; i < 9; i++) {
//                int i_0_ = 15 + 32 * i + 128;
//                int i_1_ = 3 * i_0_ + 600;
//                int i_2_ = Rasterizer3D.sinetable[i_0_];
//                is[i] = i_2_ * i_1_ >> 16;
//            }
//            Scene.method95(500, 800, 512, 334, is);
            ScreenController.setBounds();
            MovedStatics.anInt1607 = 10;
            Native.currentLoadingText = English.preparedVisibilityMap;
            MovedStatics.loadingPercent = 30;
        } else if (MovedStatics.loadingPercent == 30) {
            CacheArchive.skeletonCacheArchive = CacheArchive.loadArchive(0, true, false, true);
            CacheArchive.skinDefinitionCacheArchive = CacheArchive.loadArchive(1, true, false, true);
            CacheArchive.gameDefinitionsCacheArchive = CacheArchive.loadArchive(2, true, true, false);
            CacheArchive.gameInterfaceCacheArchive = CacheArchive.loadArchive(3, true, false, true);
            CacheArchive.soundEffectCacheArchive = CacheArchive.loadArchive(4, true, false, true);
            CacheArchive.gameWorldMapCacheArchive = CacheArchive.loadArchive(5, true, true, true);
            CacheArchive.musicCacheArchive = CacheArchive.loadArchive(6, false, true, true);
            CacheArchive.modelCacheArchive = CacheArchive.loadArchive(7, true, false, true);
            CacheArchive.gameImageCacheArchive = CacheArchive.loadArchive(8, true, false, true);
            CacheArchive.gameTextureCacheArchive = CacheArchive.loadArchive(9, true, false, true);
            CacheArchive.huffmanCacheArchive = CacheArchive.loadArchive(10, true, false, true);
            CacheArchive.jingleCacheArchive = CacheArchive.loadArchive(11, true, false, true);
            CacheArchive.clientScriptCacheArchive = CacheArchive.loadArchive(12, true, false, true);
            MovedStatics.loadingPercent = 40;
            Native.currentLoadingText = English.connectingToUpdateServer;
            MovedStatics.anInt1607 = 20;
        } else if (MovedStatics.loadingPercent == 40) {
            int i = 0;
            i += CacheArchive.skeletonCacheArchive.getPercentLoaded() * 5 / 100;
            i += 5 * CacheArchive.skinDefinitionCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.gameDefinitionsCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.gameInterfaceCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.soundEffectCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.gameWorldMapCacheArchive.getPercentLoaded() / 100;
            i += CacheArchive.musicCacheArchive.getPercentLoaded() * 5 / 100;
            i += 40 * CacheArchive.modelCacheArchive.getPercentLoaded() / 100;
            i += CacheArchive.gameImageCacheArchive.getPercentLoaded() * 5 / 100;
            i += CacheArchive.gameTextureCacheArchive.getPercentLoaded() * 5 / 100;
            i += 5 * CacheArchive.huffmanCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.jingleCacheArchive.getPercentLoaded() / 100;
            i += 5 * CacheArchive.clientScriptCacheArchive.getPercentLoaded() / 100;
            if (i == 100) {
                MovedStatics.loadingPercent = 45;
                Native.currentLoadingText = English.loadedUpdateList;
                MovedStatics.anInt1607 = 30;
            } else {
                if (i != 0)
                    Native.currentLoadingText = English.checkingForUpdates + i + Native.percent;
                MovedStatics.anInt1607 = 30;
            }
        } else if (MovedStatics.loadingPercent == 45) {
            MusicSystem.initialiseMusic(0);
            SoundSystem.initialiseSound(Main.signlink);
            MovedStatics.loadingPercent = 50;
            Native.currentLoadingText = English.preparedSoundEngine;
            MovedStatics.anInt1607 = 35;
        } else if (MovedStatics.loadingPercent == 50) {
            int i = 0;
            if (TypeFace.fontSmall != null)
                i++;
            else
                TypeFace.fontSmall = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, "", Native.fontP11Full);
            if (WallDecoration.fontNormal != null)
                i++;
            else
                WallDecoration.fontNormal = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, "", Native.fontP12Full);
            if (TypeFace.fontBold != null)
                i++;
            else
                TypeFace.fontBold = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, "", Native.fontB12Full);
            if (i < 3) {
                Native.currentLoadingText = English.loadingFonts + (i * 100 / 3) + Native.percent;
                MovedStatics.anInt1607 = 40;
            } else {
                MovedStatics.loadingPercent = 60;
                MovedStatics.anInt1607 = 40;
                Native.currentLoadingText = English.loadedFonts;
            }
        } else if (MovedStatics.loadingPercent == 60) {
            int i = Class60.method988(CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
            int i_3_ = ISAAC.method288();
            if (i < i_3_) {
                Native.currentLoadingText = English.loadingTitleScreen + (100 * i / i_3_) + Native.percent;
                MovedStatics.anInt1607 = 50;
            } else {
                Console.console = new Console();
                Native.currentLoadingText = English.loadedTitleScreen;
                MovedStatics.anInt1607 = 50;
                MovedStatics.processGameStatus(5);
                MovedStatics.loadingPercent = 70;
            }
        } else if (MovedStatics.loadingPercent == 70) {
            if (CacheArchive.gameDefinitionsCacheArchive.method185()) {
                OverlayDefinition.initializeOverlayDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                UnderlayDefinition.initializeUnderlayDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                initializeIdentityKitDefinitionCache(CacheArchive.gameDefinitionsCacheArchive, CacheArchive.modelCacheArchive);
                initializeGameObjectDefinitionCache(CacheArchive.modelCacheArchive, VertexNormal.lowMemory, CacheArchive.gameDefinitionsCacheArchive);
                Main.method357(CacheArchive.modelCacheArchive, CacheArchive.gameDefinitionsCacheArchive);
                MovedStatics.initializeItemDefinitionCache(CacheArchive.gameDefinitionsCacheArchive, MovedStatics.membersWorld, CacheArchive.modelCacheArchive);
                MovedStatics.initializeAnimationCaches(CacheArchive.skinDefinitionCacheArchive, CacheArchive.gameDefinitionsCacheArchive, CacheArchive.skeletonCacheArchive);
                Class55.method966(CacheArchive.modelCacheArchive, CacheArchive.gameDefinitionsCacheArchive);
                VarbitDefinition.initializeVarbitDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                VarPlayerDefinition.initializeVarPlayerDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                GameInterface.createInterfaceMemoryBuffers();
                MovedStatics.loadingPercent = 80;
                MovedStatics.anInt1607 = 60;
                Native.currentLoadingText = English.loadedConfig;
            } else {
                Native.currentLoadingText = English.loadingConfig + CacheArchive.gameDefinitionsCacheArchive.method202() + Native.percent;
                MovedStatics.anInt1607 = 60;
            }
        } else if (MovedStatics.loadingPercent == 80) {
            int i = 0;
            if (AnimationSequence.minimapCompass != null)
                i++;
            else
                AnimationSequence.minimapCompass = HuffmanEncoding.method1028(CacheArchive.gameImageCacheArchive, Native.compass, "");
            if (MovedStatics.minimapEdge == null)
                MovedStatics.minimapEdge = HuffmanEncoding.method1028(CacheArchive.gameImageCacheArchive, Native.mapEdge, "");
            else
                i++;
            if (MovedStatics.aClass40_Sub5_Sub14_Sub2Array2301 != null)
                i++;
            else
                MovedStatics.aClass40_Sub5_Sub14_Sub2Array2301 = IndexedImage.getMultipleIndexedImages(CacheArchive.gameImageCacheArchive, Native.mapScene, "");
            if (MovedStatics.aClass40_Sub5_Sub14_Sub4Array296 == null)
                MovedStatics.aClass40_Sub5_Sub14_Sub4Array296 = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.mapFunction, "");
            else
                i++;
            if (AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474 != null)
                i++;
            else
                AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474 = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.hitmarks, "");
            if (FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603 == null)
                FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603 = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.headiconsPK, "");
            else
                i++;
            if (ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204 != null)
                i++;
            else
                ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204 = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.headiconsPrayer, "");
            if (MovedStatics.aClass40_Sub5_Sub14_Sub4Array2567 == null)
                MovedStatics.aClass40_Sub5_Sub14_Sub4Array2567 = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.headiconsHint, "");
            else
                i++;
            if (LinkedList.aClass40_Sub5_Sub14_Sub4_1057 == null)
                LinkedList.aClass40_Sub5_Sub14_Sub4_1057 = HuffmanEncoding.method1028(CacheArchive.gameImageCacheArchive, Native.overlayMultiway, "");
            else
                i++;
            if (aClass40_Sub5_Sub14_Sub4Array2019 == null)
                aClass40_Sub5_Sub14_Sub4Array2019 = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.mapMarker, "");
            else
                i++;
            if (Class37.cursorCross != null)
                i++;
            else
                Class37.cursorCross = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.cursorCross, "");
            if (MovedStatics.mapDots == null)
                MovedStatics.mapDots = MovedStatics.method526(CacheArchive.gameImageCacheArchive, Native.mapDots, "");
            else
                i++;
            if (MovedStatics.aClass40_Sub5_Sub14_Sub2Array215 == null)
                MovedStatics.aClass40_Sub5_Sub14_Sub2Array215 = IndexedImage.getMultipleIndexedImages(CacheArchive.gameImageCacheArchive, Native.scrollbar, "");
            else
                i++;
            if (MovedStatics.moderatorIcon != null)
                i++;
            else
                MovedStatics.moderatorIcon = IndexedImage.getMultipleIndexedImages(CacheArchive.gameImageCacheArchive, Native.modIcons, "");
            if (i < 14) {
                Native.currentLoadingText = English.loadingSprites + (100 * i / 14) + Native.percent;
                MovedStatics.anInt1607 = 70;
            } else {
                MovedStatics.minimapEdge.trim();
                int i_4_ = (int) (Math.random() * 21.0) - 10;
                int i_5_ = (int) (21.0 * Math.random()) - 10;
                int i_6_ = (int) (41.0 * Math.random()) - 20;
                int i_7_ = -10 + (int) (21.0 * Math.random());
                for (int i_8_ = 0; MovedStatics.aClass40_Sub5_Sub14_Sub4Array296.length > i_8_; i_8_++)
                    MovedStatics.aClass40_Sub5_Sub14_Sub4Array296[i_8_].method717(i_6_ + i_4_, i_5_ + i_6_, i_7_ + i_6_);
                MovedStatics.aClass40_Sub5_Sub14_Sub2Array2301[0].mixPalette(i_4_ + i_6_, i_5_ + i_6_, i_6_ + i_7_);
                Native.currentLoadingText = English.loadedSprites;
                MovedStatics.anInt1607 = 70;
                MovedStatics.loadingPercent = 85;
            }
        } else if (MovedStatics.loadingPercent == 85) {
            int i = KeyFocusListener.method955(CacheArchive.gameImageCacheArchive);
            int i_9_ = ActorDefinition.method576();
            if (i < i_9_) {
                Native.currentLoadingText = English.loadingGameScreen + (i * 100 / i_9_) + Native.percent;
                MovedStatics.anInt1607 = 80;
            } else {
                Native.currentLoadingText = English.loadedGamescreen;
                MovedStatics.loadingPercent = 90;
                MovedStatics.anInt1607 = 80;
            }
        } else if (MovedStatics.loadingPercent == 90) {
            if (CacheArchive.gameTextureCacheArchive.method185()) {
                Class35 class35 = new Class35(CacheArchive.gameTextureCacheArchive, CacheArchive.gameImageCacheArchive, 20, 0.8, !VertexNormal.lowMemory ? 128 : 64);
                Rasterizer3D.method703(class35);
                Rasterizer3D.createPalette(0.8);
                MovedStatics.loadingPercent = 110;
                MovedStatics.anInt1607 = 90;
                Native.currentLoadingText = English.loadedTextures;
            } else {
                Native.currentLoadingText = English.loadingTextures + CacheArchive.gameTextureCacheArchive.method202() + Native.percent;
                MovedStatics.anInt1607 = 90;
            }
        } else if (MovedStatics.loadingPercent == 110) {
            Class12.mouseCapturer = new Class39();
            Main.signlink.createThreadNode(10, Class12.mouseCapturer);
            Native.currentLoadingText = English.loadedInputHandler;
            MovedStatics.loadingPercent = 120;
            MovedStatics.anInt1607 = 94;
        } else if (MovedStatics.loadingPercent == 120) {
            if (CacheArchive.huffmanCacheArchive.method194(Native.huffman, "")) {
                HuffmanEncoding huffmanEncoding = new HuffmanEncoding(CacheArchive.huffmanCacheArchive.method170("", Native.huffman));
                Item.method778(huffmanEncoding);
                MovedStatics.loadingPercent = 130;
                Native.currentLoadingText = English.loadedWordpack;
                MovedStatics.anInt1607 = 96;
            } else {
                Native.currentLoadingText = English.loadingWordPack + Native.zeroPercent;
                MovedStatics.anInt1607 = 96;
            }
        } else if (MovedStatics.loadingPercent == 130) {
            if (!CacheArchive.gameInterfaceCacheArchive.method185()) {
                Native.currentLoadingText = English.loadingInterfaces + (4 * CacheArchive.gameInterfaceCacheArchive.method202() / 5) + Native.percent;
                MovedStatics.anInt1607 = 100;
            } else if (CacheArchive.clientScriptCacheArchive.method185()) {
                Native.currentLoadingText = English.loadedInterfaces;
                MovedStatics.loadingPercent = 140;
                MovedStatics.anInt1607 = 100;
            } else {
                Native.currentLoadingText = English.loadingInterfaces + (80 + CacheArchive.clientScriptCacheArchive.method202() / 5) + Native.percent;
                MovedStatics.anInt1607 = 100;
            }
        } else {
            if (MovedStatics.loadingPercent == 140)
                MovedStatics.processGameStatus(10);
        }
    }

    public static void initializeIdentityKitDefinitionCache(CacheArchive definitionCache, CacheArchive arg2) {
        MovedStatics.aCacheArchive_654 = arg2;
        Class49.definitionCache = definitionCache;
        PlayerAppearance.identityKitLength = Class49.definitionCache.fileLength(3);
    }

    public static void initializeGameObjectDefinitionCache(CacheArchive arg1, boolean arg2, CacheArchive definitionCache) {
        CacheArchive.definitionCache = definitionCache;
        GameObjectDefinition.count = CacheArchive.definitionCache.fileLength(6);

        Class35.aBoolean1734 = arg2;
        RSString.aCacheArchive_1705 = arg1;
    }
}
