package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.cs.ClientScript;
import com.jagex.runescape.cache.def.GameObjectDefinition;
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
    public static int anInt60 = 255;
    public static CacheArchive aCacheArchive_61;
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

    public static void method46(int arg0) {
        MovedStatics.method233(true);
        MovedStatics.method189(false);
        GameInterface.method640();
        GameObjectDefinition.clearGameObjectModelCache();
        Class40_Sub5_Sub6.method586(64);
        Class8.method211();
        MovedStatics.method188();
        Class22_Sub2.method316(-11965);
        LinkedList.method907(-99);
        MovedStatics.method167(1023);
        Class51.method941();
        Actor.method783();
        ((Class35) Rasterizer3D.anInterface3_2939).method422(arg0);
        ClientScript.clientScriptCache.clear();
        CacheArchive.skeletonCacheArchive.method191(1120);
        CacheArchive.skinDefinitionCacheArchive.method191(1120);
        CacheArchive.gameInterfaceCacheArchive.method191(arg0 + 1120);
        CacheArchive.soundEffectCacheArchive.method191(1120);
        CacheArchive.gameWorldMapCacheArchive.method191(1120);
        CacheArchive.musicCacheArchive.method191(1120);
        CacheArchive.modelCacheArchive.method191(1120);
        CacheArchive.gameImageCacheArchive.method191(arg0 ^ 0x460);
        CacheArchive.gameTextureCacheArchive.method191(1120);
        CacheArchive.huffmanCacheArchive.method191(arg0 + 1120);
        CacheArchive.jingleCacheArchive.method191(1120);
        CacheArchive.clientScriptCacheArchive.method191(1120);
    }

    public void paint(Graphics arg0) {
        aComponent49.paint(arg0);
    }

    public void update(Graphics arg0) {
        aComponent49.update(arg0);
    }
}
