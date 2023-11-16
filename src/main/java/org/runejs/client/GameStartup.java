package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.Minimap;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.console.Console;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneRenderer;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;

public class GameStartup {
    public int startupStage = 0;
    public int loadingBarPercentage = 10;
    public String currentLoadingText = "";


    public void process() {
        if (startupStage == 0) {
            Game.currentScene = new Scene();
            Game.sceneRenderer = new SceneRenderer(Game.currentScene);
            for (int i = 0; i < 4; i++)
                Landscape.currentCollisionMap[i] = new CollisionMap(104, 104);
            Minimap.minimapImage = new ImageRGB(512, 512);
            loadingBarPercentage = 5;
            startupStage = 20;
            currentLoadingText = English.startingGameEngine;
        } else if (startupStage == 20) {
//            int[] is = new int[9];
//            for (int i = 0; i < 9; i++) {
//                int i_0_ = 15 + 32 * i + 128;
//                int i_1_ = 3 * i_0_ + 600;
//                int i_2_ = Rasterizer3D.sinetable[i_0_];
//                is[i] = i_2_ * i_1_ >> 16;
//            }
//            Scene.method95(500, 800, 512, 334, is);
            ScreenController.setBounds();
            loadingBarPercentage = 10;
            currentLoadingText = English.preparedVisibilityMap;
            startupStage = 30;
        } else if (startupStage == 30) {
            CacheArchive.skeletonCacheArchive = CacheArchive.loadArchive(0, false, true, true);
            CacheArchive.skinDefinitionCacheArchive = CacheArchive.loadArchive(1, false, true, true);
            CacheArchive.gameDefinitionsCacheArchive = CacheArchive.loadArchive(2, true, false, true);
            CacheArchive.gameInterfaceCacheArchive = CacheArchive.loadArchive(3, false, true, true);
            CacheArchive.soundEffectCacheArchive = CacheArchive.loadArchive(4, false, true, true);
            CacheArchive.gameWorldMapCacheArchive = CacheArchive.loadArchive(5, true, true, true);
            CacheArchive.musicCacheArchive = CacheArchive.loadArchive(6, true, true, false);
            CacheArchive.modelCacheArchive = CacheArchive.loadArchive(7, false, true, true);
            CacheArchive.gameImageCacheArchive = CacheArchive.loadArchive(8, false, true, true);
            CacheArchive.gameTextureCacheArchive = CacheArchive.loadArchive(9, false, true, true);
            CacheArchive.huffmanCacheArchive = CacheArchive.loadArchive(10, false, true, true);
            CacheArchive.jingleCacheArchive = CacheArchive.loadArchive(11, false, true, true);
            CacheArchive.clientScriptCacheArchive = CacheArchive.loadArchive(12, false, true, true);
            startupStage = 40;
            currentLoadingText = English.connectingToUpdateServer;
            loadingBarPercentage = 20;
        } else if (startupStage == 40) {
            int i = 0;
            i += CacheArchive.skeletonCacheArchive.getIndexLoadedPercentage() * 5 / 100;
            i += 5 * CacheArchive.skinDefinitionCacheArchive.getIndexLoadedPercentage() / 100;
            i += 5 * CacheArchive.gameDefinitionsCacheArchive.getIndexLoadedPercentage() / 100;
            i += 5 * CacheArchive.gameInterfaceCacheArchive.getIndexLoadedPercentage() / 100;
            i += 5 * CacheArchive.soundEffectCacheArchive.getIndexLoadedPercentage() / 100;
            i += 5 * CacheArchive.gameWorldMapCacheArchive.getIndexLoadedPercentage() / 100;
            i += CacheArchive.musicCacheArchive.getIndexLoadedPercentage() * 5 / 100;
            i += 40 * CacheArchive.modelCacheArchive.getIndexLoadedPercentage() / 100;
            i += CacheArchive.gameImageCacheArchive.getIndexLoadedPercentage() * 5 / 100;
            i += CacheArchive.gameTextureCacheArchive.getIndexLoadedPercentage() * 5 / 100;
            i += 5 * CacheArchive.huffmanCacheArchive.getIndexLoadedPercentage() / 100;
            i += 5 * CacheArchive.jingleCacheArchive.getIndexLoadedPercentage() / 100;
            i += 5 * CacheArchive.clientScriptCacheArchive.getIndexLoadedPercentage() / 100;
            if (i == 100) {
                startupStage = 45;
                currentLoadingText = English.loadedUpdateList;
                loadingBarPercentage = 30;
            } else {
                if (i != 0)
                    currentLoadingText = English.checkingForUpdates + i + Native.percent;
                loadingBarPercentage = 30;
            }
        } else if (startupStage == 45) {
            MusicSystem.initialiseMusic(0);
            SoundSystem.initialiseSound(Game.signlink);
            startupStage = 50;
            currentLoadingText = English.preparedSoundEngine;
            loadingBarPercentage = 35;
        } else if (startupStage == 50) {
            int i = 0;
            if (TypeFace.fontSmall != null)
                i++;
            else
                TypeFace.fontSmall = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, Native.fontP11Full, "");
            if (MovedStatics.fontNormal != null)
                i++;
            else
                MovedStatics.fontNormal = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, Native.fontP12Full, "");
            if (TypeFace.fontBold != null)
                i++;
            else
                TypeFace.fontBold = TypeFace.loadTypeFace(CacheArchive.gameImageCacheArchive, Native.fontB12Full, "");
            if (i < 3) {
                currentLoadingText = English.loadingFonts + (i * 100 / 3) + Native.percent;
                loadingBarPercentage = 40;
            } else {
                startupStage = 60;
                loadingBarPercentage = 40;
                currentLoadingText = English.loadedFonts;
            }
        } else if (startupStage == 60) {
            int i = MovedStatics.method988(CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
            int i_3_ = 5;
            if (i < 5) {
                currentLoadingText = English.loadingTitleScreen + (100 * i / 5) + Native.percent;
                loadingBarPercentage = 50;
            } else {
                org.runejs.client.frame.console.Console.console = new Console();
                currentLoadingText = English.loadedTitleScreen;
                loadingBarPercentage = 50;
                MovedStatics.processGameStatus(5);
                startupStage = 70;
            }
        } else if (startupStage == 70) {
            if (CacheArchive.gameDefinitionsCacheArchive.areAllGroupsLoaded()) {
                OverlayDefinition.initializeOverlayDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                UnderlayDefinition.initializeUnderlayDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                IdentityKit.initializeIdentityKitDefinitionCache(CacheArchive.gameDefinitionsCacheArchive, CacheArchive.modelCacheArchive);
                GameObjectDefinition.initializeGameObjectDefinitionCache(CacheArchive.modelCacheArchive, VertexNormal.lowMemory, CacheArchive.gameDefinitionsCacheArchive);
                ActorDefinition.initializeActorCache(CacheArchive.modelCacheArchive, CacheArchive.gameDefinitionsCacheArchive);
                ItemDefinition.initializeItemDefinitionCache(CacheArchive.gameDefinitionsCacheArchive, MovedStatics.membersWorld, CacheArchive.modelCacheArchive);
                AnimationSequence.initializeAnimationCaches(CacheArchive.skinDefinitionCacheArchive, CacheArchive.gameDefinitionsCacheArchive, CacheArchive.skeletonCacheArchive);
                SpotAnimDefinition.initializeSpotAnimCache(CacheArchive.modelCacheArchive, CacheArchive.gameDefinitionsCacheArchive);
                VarbitDefinition.initializeVarbitDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                VarPlayerDefinition.initializeVarPlayerDefinitionCache(CacheArchive.gameDefinitionsCacheArchive);
                GameInterface.createInterfaceMemoryBuffers();
                startupStage = 80;
                loadingBarPercentage = 60;
                currentLoadingText = English.loadedConfig;
            } else {
                currentLoadingText = English.loadingConfig + CacheArchive.gameDefinitionsCacheArchive.getGroupsLoadedPercentage() + Native.percent;
                loadingBarPercentage = 60;
            }
        } else if (startupStage == 80) {
            int i = 0;
            if (Minimap.minimapCompass != null)
                i++;
            else
                Minimap.minimapCompass = MovedStatics.method1028(CacheArchive.gameImageCacheArchive, Native.compass, "");
            if (Minimap.minimapEdge == null)
                Minimap.minimapEdge = MovedStatics.method1028(CacheArchive.gameImageCacheArchive, Native.mapEdge, "");
            else
                i++;
            if (Minimap.mapSceneIcons != null)
                i++;
            else
                Minimap.mapSceneIcons = IndexedImage.getMultipleIndexedImages(CacheArchive.gameImageCacheArchive, Native.mapScene, "");
            if (Minimap.mapFunctionIcons == null)
                Minimap.mapFunctionIcons = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.mapFunction, "");
            else
                i++;
            if (MovedStatics.aClass40_Sub5_Sub14_Sub4Array2474 != null)
                i++;
            else
                MovedStatics.aClass40_Sub5_Sub14_Sub4Array2474 = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.hitmarks, "");
            if (MovedStatics.aClass40_Sub5_Sub14_Sub4Array603 == null)
                MovedStatics.aClass40_Sub5_Sub14_Sub4Array603 = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.headiconsPK, "");
            else
                i++;
            if (MovedStatics.headIconSprites != null)
                i++;
            else
                MovedStatics.headIconSprites = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.headiconsPrayer, "");
            if (MovedStatics.hintIconSprites == null)
                MovedStatics.hintIconSprites = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.headiconsHint, "");
            else
                i++;
            if (MovedStatics.multiCombatIcon == null)
                MovedStatics.multiCombatIcon = MovedStatics.method1028(CacheArchive.gameImageCacheArchive, Native.overlayMultiway, "");
            else
                i++;
            if (Minimap.minimapMarkers == null)
                Minimap.minimapMarkers = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.mapMarker, "");
            else
                i++;
            if (MovedStatics.cursorCross != null)
                i++;
            else
                MovedStatics.cursorCross = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.cursorCross, "");
            if (Minimap.mapDots == null)
                Minimap.mapDots = ImageRGB.method526(CacheArchive.gameImageCacheArchive, Native.mapDots, "");
            else
                i++;
            if (MovedStatics.scrollbarArrowImages == null)
                MovedStatics.scrollbarArrowImages = IndexedImage.getMultipleIndexedImages(CacheArchive.gameImageCacheArchive, Native.scrollbar, "");
            else
                i++;
            if (MovedStatics.moderatorIcon != null)
                i++;
            else
                MovedStatics.moderatorIcon = IndexedImage.getMultipleIndexedImages(CacheArchive.gameImageCacheArchive, Native.modIcons, "");
            if (i < 14) {
                currentLoadingText = English.loadingSprites + (100 * i / 14) + Native.percent;
                loadingBarPercentage = 70;
            } else {
                Minimap.minimapEdge.trim();
                int i_4_ = (int) (Math.random() * 21.0) - 10;
                int i_5_ = (int) (21.0 * Math.random()) - 10;
                int i_6_ = (int) (41.0 * Math.random()) - 20;
                int i_7_ = -10 + (int) (21.0 * Math.random());
                for (int i_8_ = 0; Minimap.mapFunctionIcons.length > i_8_; i_8_++)
                    Minimap.mapFunctionIcons[i_8_].method717(i_6_ + i_4_, i_5_ + i_6_, i_7_ + i_6_);
                Minimap.mapSceneIcons[0].mixPalette(i_4_ + i_6_, i_5_ + i_6_, i_6_ + i_7_);
                currentLoadingText = English.loadedSprites;
                loadingBarPercentage = 70;
                startupStage = 85;
            }
        } else if (startupStage == 85) {
            int i = MovedStatics.getLoadedFrameImageCount(CacheArchive.gameImageCacheArchive);
            if (i < 19) {
                currentLoadingText = English.loadingGameScreen + (i * 100 / 19) + Native.percent;
                loadingBarPercentage = 80;
            } else {
                currentLoadingText = English.loadedGamescreen;
                startupStage = 90;
                loadingBarPercentage = 80;
            }
        } else if (startupStage == 90) {
            if (CacheArchive.gameTextureCacheArchive.areAllGroupsLoaded()) {
                Class35 class35 = new Class35(CacheArchive.gameTextureCacheArchive, CacheArchive.gameImageCacheArchive, 20, 0.8, !VertexNormal.lowMemory ? 128 : 64);
                Rasterizer3D.method703(class35);
                Rasterizer3D.createPalette(0.8);
                startupStage = 110;
                loadingBarPercentage = 90;
                currentLoadingText = English.loadedTextures;
            } else {
                currentLoadingText = English.loadingTextures + CacheArchive.gameTextureCacheArchive.getGroupsLoadedPercentage() + Native.percent;
                loadingBarPercentage = 90;
            }
        } else if (startupStage == 110) {
            Game.mouseCapturer = new MouseCapturer();
            Game.signlink.putThreadNode(10, Game.mouseCapturer);
            currentLoadingText = English.loadedInputHandler;
            startupStage = 120;
            loadingBarPercentage = 94;
        } else if (startupStage == 120) {
            if (CacheArchive.huffmanCacheArchive.loaded(Native.huffman, "")) {
                HuffmanEncoding huffmanEncoding = new HuffmanEncoding(CacheArchive.huffmanCacheArchive.getFileByName(Native.huffman, ""));
                MovedStatics.method778(huffmanEncoding);
                startupStage = 130;
                currentLoadingText = English.loadedWordpack;
                loadingBarPercentage = 96;
            } else {
                currentLoadingText = English.loadingWordPack + Native.zeroPercent;
                loadingBarPercentage = 96;
            }
        } else if (startupStage == 130) {
            if (!CacheArchive.gameInterfaceCacheArchive.areAllGroupsLoaded()) {
                currentLoadingText = English.loadingInterfaces + (4 * CacheArchive.gameInterfaceCacheArchive.getGroupsLoadedPercentage() / 5) + Native.percent;
                loadingBarPercentage = 100;
            } else if (CacheArchive.clientScriptCacheArchive.areAllGroupsLoaded()) {
                currentLoadingText = English.loadedInterfaces;
                startupStage = 140;
                loadingBarPercentage = 100;
            } else {
                currentLoadingText = English.loadingInterfaces + (80 + CacheArchive.clientScriptCacheArchive.getGroupsLoadedPercentage() / 5) + Native.percent;
                loadingBarPercentage = 100;
            }
        } else {
            if (startupStage == 140)
                MovedStatics.processGameStatus(10);
        }
    }
}
