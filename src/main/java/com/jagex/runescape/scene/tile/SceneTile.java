package com.jagex.runescape.scene.tile;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;

import java.nio.charset.StandardCharsets;

public class SceneTile extends Node {
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2043;
    public static int[] anIntArray2048;
    public static int activeInterfaceType = 0;

    public SceneTile aSceneTile_2058;
    public int wallCullOppositeDirection;
    public GroundItemTile groundItemTile;
    public int anInt2061;
    public boolean drawEntities;
    public int anInt2063;
    public int anInt2064;
    public InteractiveObject[] interactiveObjects = new InteractiveObject[5];
    public int anInt2066;
    public int wallCullDirection;
    public ComplexTile shapedTile;
    public int anInt2069;
    public GenericTile plainTile;
    public boolean draw;
    public Wall wall;
    public int interactiveObjectsSizeOR;
    public int[] sceneSpawnRequestsSize = new int[5];
    public FloorDecoration floorDecoration;
    public int wallUncullDirection;
    public boolean visible;
    public int anInt2078;
    public WallDecoration wallDecoration;
    public int entityCount;

    public SceneTile(int arg0, int arg1, int arg2) {
        interactiveObjectsSizeOR = 0;
        anInt2061 = arg1;
        anInt2069 = anInt2066 = arg0;
        anInt2078 = arg2;

    }

    public static String method532(byte arg0, Widget arg1, String arg2) {
        if (arg2.contains(Native.aClass1_1041)) {
            for (; ; ) {
                int i = arg2.indexOf(Native.aClass1_890);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(0, false, arg1)) + arg2.substring(2 + i);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.aClass1_1077);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(1, false, arg1)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.aClass1_1610);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(2, false, arg1)) + arg2.substring(2 + i);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.aClass1_1300);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + Class40_Sub11.method872(arg0 ^ 0x3b9ac9eb, HuffmanEncoding.method1029(3, false, arg1)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.aClass1_2090);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + Class40_Sub11.method872(999999999, HuffmanEncoding.method1029(4, false, arg1)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.aClass1_2526);
                if (i == -1)
                    break;
                String class1 = "";
                if (Class12.aSignlinkNode_394 != null) {
                    class1 = CacheIndex_Sub1.method204(Class12.aSignlinkNode_394.integerData);
                    if (Class12.aSignlinkNode_394.value != null) {
                        byte[] is = ((String) Class12.aSignlinkNode_394.value).getBytes(StandardCharsets.ISO_8859_1);
                        class1 = InteractiveObject.method279(is, true, 0, is.length).toString();
                    }
                }
                arg2 = arg2.substring(0, i) + class1 + arg2.substring(i + 4);
            }
        }
        return arg2;
    }

    public static void drawOnMinimap(int arg0, int arg1, ImageRGB sprite) {
        if (sprite == null) {
            return;
        }
        int k = 0x7ff & Class43.cameraYawOffset + GroundItemTile.cameraHorizontal;
        int l = arg0 * arg0 + arg1 * arg1;
        if (l > 6400) {
            return;
        }
        int sine = Model.SINE[k];
        int cosine = Model.COSINE[k];
        sine = sine * 256 / (Class51.mapZoomOffset + 256);
        cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
        int i_3_ = cosine * arg1 + arg0 * sine >> 16;
        int i_4_ = -(arg1 * sine) + cosine * arg0 >> 16;
        if (l > 2500)
            sprite.drawTo(Class34.mapBack, 98 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + -i_4_ + 79);
        else
            sprite.drawImage(4 + -(sprite.maxWidth / 2) + i_3_ + 94, -4 + -i_4_ + 83 + -(sprite.maxHeight / 2));
    }

    public static String getCombatLevelColour(int arg0, int arg1) {
        int diff = -arg1 + arg0;
        if (diff < -9)
            return Native.aClass1_610;
        if (diff < -6)
            return Native.aClass1_670;
        if (diff < -3)
            return Native.aClass1_1639;
        if (diff < 0)
            return Native.aClass1_327;
        if (diff > 9)
            return Native.aClass1_1162;
        if (diff > 6)
            return Native.aClass1_494;
        if (diff > 3)
            return Native.aClass1_932;
        if (diff > 0)
            return Native.aClass1_877;
        return Native.aClass1_1283;
    }

    public static void drawMenuTooltip(int arg0) {
        if (ActorDefinition.menuActionRow >= 2 || Class8.itemSelected != 0 || Main.widgetSelected != 0) {
            String class1;
            if (Class8.itemSelected == 1 && ActorDefinition.menuActionRow < 2)
                class1 = English.use + Native.aClass1_1117 + Native.aClass1_3295 + Native.aClass1_894;
            else if (Main.widgetSelected != 1 || ActorDefinition.menuActionRow >= 2)
                class1 = Landscape.menuActionTexts[-1 + ActorDefinition.menuActionRow];
            else
                class1 = Native.aClass1_1918 + Native.aClass1_1117 + Native.aClass1_611 + Native.aClass1_894;
            if (ActorDefinition.menuActionRow > 2)
                class1 = class1 + Native.aClass1_1243 + (ActorDefinition.menuActionRow + -2) + English.suffixMoreOptions;
            if (arg0 == 4)
                Class40_Sub5_Sub17_Sub6.fontBold.drawShadowedSeededAlphaString(class1, 4, 15, 16777215, true, Node.pulseCycle / 1000);
        }
    }
}
