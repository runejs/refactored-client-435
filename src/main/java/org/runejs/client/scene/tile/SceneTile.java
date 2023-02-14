package org.runejs.client.scene.tile;

import org.runejs.client.*;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.cs.ClientScript;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.node.Node;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;

import java.nio.charset.StandardCharsets;

public class SceneTile extends Node {
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2043;
    public static int[] blendedLightness;
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

    public static String method532(GameInterface gameInterface, String arg2) {
        if (arg2.contains(Native.percent)) {
            for (; ; ) {
                int i = arg2.indexOf(Native.percentOne);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + ClientScriptRunner.method872(999999999, ClientScript.parseClientScripts(0, false, gameInterface)) + arg2.substring(2 + i);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentTwo);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + ClientScriptRunner.method872(999999999, ClientScript.parseClientScripts(1, false, gameInterface)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentThree);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + ClientScriptRunner.method872(999999999, ClientScript.parseClientScripts(2, false, gameInterface)) + arg2.substring(2 + i);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentFour);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + ClientScriptRunner.method872(999999999, ClientScript.parseClientScripts(3, false, gameInterface)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentFive);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + ClientScriptRunner.method872(999999999, ClientScript.parseClientScripts(4, false, gameInterface)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                // check client script results for value
                int i = arg2.indexOf(Native.percentDns);
                if (i == -1)
                    break;
                String str = "";
                if (Class12.aSignlinkNode_394 != null) {
                    str = MovedStatics.method204(Class12.aSignlinkNode_394.integerData);
                    if (Class12.aSignlinkNode_394.value != null) {
                        byte[] is = ((String) Class12.aSignlinkNode_394.value).getBytes(StandardCharsets.ISO_8859_1);
                        str = InteractiveObject.method279(is, 0, is.length).toString();
                    }
                }
                arg2 = arg2.substring(0, i) + str + arg2.substring(i + 4);
            }
        }
        return arg2;
    }

    public static void drawOnMinimap(int x, int y, ImageRGB sprite) {
        if (sprite == null) {
            return;
        }
        int angle = 0x7ff & Class43.cameraYawOffset + GroundItemTile.cameraHorizontal;
        int l = x * x + y * y;
        if (l > 6400) {
            return;
        }
        int sine = Model.SINE[angle];
        int cosine = Model.COSINE[angle];
        sine = sine * 256 / (Class51.mapZoomOffset + 256);
        cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
        int i_3_ = cosine * y + x * sine >> 16;
        int i_4_ = -(y * sine) + cosine * x >> 16;
        if (l > 2500)
            sprite.drawTo(MovedStatics.minimapBackgroundImage, 98 + i_3_ + -(sprite.maxWidth / 2), -(sprite.maxHeight / 2) + -i_4_ + 79);
        else
            sprite.drawImage(4 + -(sprite.maxWidth / 2) + i_3_ + 94, -4 + -i_4_ + 83 + -(sprite.maxHeight / 2));
    }

    public static String getCombatLevelColour(int arg0, int arg1) {
        int diff = -arg1 + arg0;
        if (diff < -9)
            return Native.red;
        if (diff < -6)
            return Native.orange3;
        if (diff < -3)
            return Native.orange2;
        if (diff < 0)
            return Native.orange1;
        if (diff > 9)
            return Native.green;
        if (diff > 6)
            return Native.green3;
        if (diff > 3)
            return Native.green2;
        if (diff > 0)
            return Native.green1;
        return Native.yellow;
    }

    public static void drawMenuTooltip(int arg0) {
        if (ActorDefinition.menuActionRow >= 2 || MovedStatics.itemSelected != 0 || Main.widgetSelected != 0) {
            String class1;
            if (MovedStatics.itemSelected == 1 && ActorDefinition.menuActionRow < 2)
                class1 = English.use + Native.whitespace + Native.selectedItemName + Native.targetThingArrow;
            else if (Main.widgetSelected != 1 || ActorDefinition.menuActionRow >= 2)
                class1 = Landscape.menuActionTexts[-1 + ActorDefinition.menuActionRow];
            else
                class1 = Native.selectedSpellVerb + Native.whitespace + Native.selectedSpellName + Native.targetThingArrow;
            if (ActorDefinition.menuActionRow > 2)
                class1 = class1 + Native.whiteSlash + (ActorDefinition.menuActionRow + -2) + English.suffixMoreOptions;
            if (arg0 == 4)
                TypeFace.fontBold.drawShadowedSeededAlphaString(class1, 4, 15, 16777215, true, MovedStatics.pulseCycle / 1000);
        }
    }
}
