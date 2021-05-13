package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.cs.ClientScript;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.actor.Actor;

import java.awt.*;

public class RSCanvas extends Canvas {
    public static byte[][] aByteArrayArray47 = new byte[50][];
    public static LinkedList aLinkedList_53 = new LinkedList();
    public static int anInt54 = 0;
    public static int anInt57;
    public static ProducingGraphicsBuffer tabBottom;
    public static int musicVolume = 255;
    public static int[] anIntArray62;
    public static ProducingGraphicsBuffer chatBoxImageProducer;
    public static int anInt65 = 127;
    public static int[] anIntArray66;

    public Component aComponent49;

    public RSCanvas(Component arg0) {
        aComponent49 = arg0;
    }

    @Override
    public void repaint() {
//        super.repaint();
    }

    public static void createMinimapRaster() {
        RSString.mapbackProducingGraphicsBuffer.prepareRasterizer();
    }

    public static void clearCaches() {
        MovedStatics.method233(true);
        UnderlayDefinition.clearUnderlayDefinitionCache();
        GameInterface.method640();
        GameObjectDefinition.clearGameObjectModelCache();
        Class40_Sub5_Sub6.method586(64);
        Class8.method211();
        MovedStatics.method188();
        SpotAnimDefinition.clearSpotAnimDefinitionCache();
        VarbitDefinition.clearVarbitDefinitionCache();
        VarPlayerDefinition.clearVarPlayerDefinitionCache();
        Class51.clearModelCache();
        Actor.clearCaches();
        ((Class35) Rasterizer3D.anInterface3_2939).method422();
        ClientScript.clientScriptCache.clear();
        CacheArchive.skeletonCacheArchive.clearCache();
        CacheArchive.skinDefinitionCacheArchive.clearCache();
        CacheArchive.gameInterfaceCacheArchive.clearCache();
        CacheArchive.soundEffectCacheArchive.clearCache();
        CacheArchive.gameWorldMapCacheArchive.clearCache();
        CacheArchive.musicCacheArchive.clearCache();
        CacheArchive.modelCacheArchive.clearCache();
        CacheArchive.gameImageCacheArchive.clearCache();
        CacheArchive.gameTextureCacheArchive.clearCache();
        CacheArchive.huffmanCacheArchive.clearCache();
        CacheArchive.jingleCacheArchive.clearCache();
        CacheArchive.clientScriptCacheArchive.clearCache();
    }

    public void paint(Graphics arg0) {
        aComponent49.paint(arg0);
    }

    public void update(Graphics arg0) {
        aComponent49.update(arg0);
    }
}
