package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.scene.GroundItemTile;

public class SubNode extends Node {
    public static int anInt2081;
    public static boolean aBoolean2083 = false;
    public static RSString aClass1_2084 = RSString.CreateString(")1");
    public static int[] anIntArray2086;
    public static RSString aClass1_2090 = RSString.CreateString("(U5");
    public static Class68 aClass68_2091;
    public static RSString aClass1_2093 = RSString.CreateString("redstone1");

    public SubNode aClass40_Sub5_2082;
    public SubNode aClass40_Sub5_2087;

    public static IndexedImage method538(int arg0) {
        IndexedImage class40_sub5_sub14_sub2 = new IndexedImage();
        class40_sub5_sub14_sub2.maxWidth = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub2.maxHeight = GameShell.anInt31;
        class40_sub5_sub14_sub2.xDrawOffset = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub2.yDrawOffset = Actor.anIntArray3111[0];
        class40_sub5_sub14_sub2.imgWidth = Class17.anIntArray456[0];
        class40_sub5_sub14_sub2.imgHeight = Npc.anIntArray3312[0];
        class40_sub5_sub14_sub2.palette = Buffer.anIntArray1972;
        class40_sub5_sub14_sub2.imgPixels = GroundItemTile.aByteArrayArray1370[arg0];
        ActorDefinition.method569();
        return class40_sub5_sub14_sub2;
    }

    public static void method540() {
        KeyFocusListener.aLinkedList_1278 = new LinkedList();
    }

    public static void method541() {
        aClass1_2090 = null;
        aClass1_2084 = null;
        aClass1_2093 = null;
        aClass68_2091 = null;
        anIntArray2086 = null;
    }

    public void method539() {
        if(aClass40_Sub5_2087 != null) {
            aClass40_Sub5_2087.aClass40_Sub5_2082 = aClass40_Sub5_2082;
            aClass40_Sub5_2082.aClass40_Sub5_2087 = aClass40_Sub5_2087;
            aClass40_Sub5_2087 = null;
            aClass40_Sub5_2082 = null;
        }
    }
}
