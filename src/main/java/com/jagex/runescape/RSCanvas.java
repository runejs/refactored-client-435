package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.cs.ClientScript;
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
    public static CacheIndex aCacheIndex_61;
    public static int[] anIntArray62;
    public static ProducingGraphicsBuffer chatboxProducingGraphicsBuffer;
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
        CacheIndex.method189(false);
        GameInterface.method640();
        GameInterface.method645();
        Class40_Sub5_Sub6.method586(64);
        Class8.method211();
        CacheIndex.method188();
        Class22_Sub2.method316(-11965);
        LinkedList.method907(-99);
        Class5.method167(1023);
        Class51.method941();
        Actor.method783();
        ((Class35) Rasterizer3D.anInterface3_2939).method422(arg0);
        ClientScript.clientScriptCache.clear();
        CacheIndex.skeletonCacheIndex.method191(1120);
        CacheIndex.skinDefinitionCacheIndex.method191(1120);
        CacheIndex.gameInterfaceCacheIndex.method191(arg0 + 1120);
        CacheIndex.soundEffectCacheIndex.method191(1120);
        CacheIndex.gameWorldMapCacheIndex.method191(1120);
        CacheIndex.musicCacheIndex.method191(1120);
        CacheIndex.modelCacheIndex.method191(1120);
        CacheIndex.gameImageCacheIndex.method191(arg0 ^ 0x460);
        CacheIndex.gameTextureCacheIndex.method191(1120);
        CacheIndex.huffmanCacheIndex.method191(arg0 + 1120);
        CacheIndex.jingleCacheIndex.method191(1120);
        CacheIndex.clientScriptCacheIndex.method191(1120);
    }

    public void paint(Graphics arg0) {
        aComponent49.paint(arg0);
    }

    public void update(Graphics arg0) {
        aComponent49.update(arg0);
    }
}
