package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.scene.GroundItemTile;

public class SubNode extends Node {
    public static int anInt2081;
    public static boolean aBoolean2083;
    public static RSString aClass1_2084;
    public static int[] anIntArray2086;
    public static RSString aClass1_2090 = RSString.CreateString("(U5");
    public static Class68 aClass68_2091;
    public static RSString aClass1_2093;
    public static RSString aClass1_2095;

    static {
        aBoolean2083 = false;
        aClass1_2084 = RSString.CreateString(")1");
        aClass1_2093 = RSString.CreateString("redstone1");
        aClass1_2095 = RSString.CreateString("Fallen lassen");
    }

    public SubNode aClass40_Sub5_2082;
    public SubNode aClass40_Sub5_2087;

    public static IndexedImage method538(int arg0) {
        IndexedImage class40_sub5_sub14_sub2 = new IndexedImage();
        class40_sub5_sub14_sub2.maxWidth = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub2.maxHeight = RSApplet.anInt31;
        class40_sub5_sub14_sub2.xDrawOffset = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub2.yDrawOffset = Actor.anIntArray3111[0];
        class40_sub5_sub14_sub2.imgWidth = Class17.anIntArray456[0];
        class40_sub5_sub14_sub2.imgHeight = Npc.anIntArray3312[0];
        class40_sub5_sub14_sub2.palette = Buffer.anIntArray1972;
        class40_sub5_sub14_sub2.imgPixels = GroundItemTile.aByteArrayArray1370[arg0];
        ActorDefinition.method569();
        return class40_sub5_sub14_sub2;
    }

    public static void method540(int arg0) {
        if(arg0 != 23721)
            aClass1_2095 = null;
        KeyFocusListener.aClass45_1278 = new Class45();
    }

    public static void method541(int arg0) {
        aClass1_2090 = null;
        aClass1_2095 = null;
        aClass1_2084 = null;
        aClass1_2093 = null;
        if(arg0 < 35)
            method541(109);
        aClass68_2091 = null;
        anIntArray2086 = null;
    }

    public void method539(int arg0) {
        if(arg0 != 0)
            method538(16);
        if(aClass40_Sub5_2087 != null) {
            aClass40_Sub5_2087.aClass40_Sub5_2082 = aClass40_Sub5_2082;
            aClass40_Sub5_2082.aClass40_Sub5_2087 = aClass40_Sub5_2087;
            aClass40_Sub5_2087 = null;
            aClass40_Sub5_2082 = null;
        }
    }
}
