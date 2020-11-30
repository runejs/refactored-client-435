package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.*;

public class Class40_Sub2 extends Node {
    public static int anInt1996 = 0;

    public int anInt1993;
    public int anInt1994;
    public int anInt1997;
    public int anInt2000;
    public Class40_Sub9_Sub2 aClass40_Sub9_Sub2_2001;
    public int anInt2002;
    public int anInt2003;
    public int[] anIntArray2005;
    public int anInt2007;
    public Class40_Sub9_Sub2 aClass40_Sub9_Sub2_2010;
    public GameObjectDefinition aGameObjectDefinition_2011;
    public int anInt2012;
    public int anInt2013;
    public int anInt2014;

    public static void method522(int arg0, int arg1) {
        VarbitDefinition varbitDefinition = Class34.method417(0, arg1);
        int i = varbitDefinition.leastSignificantBit;
        int i_0_ = varbitDefinition.index;
        int i_1_ = varbitDefinition.mostSignificantBit;
        int i_3_ = ProducingGraphicsBuffer_Sub1.anIntArray2199[i_1_ + -i];
        if(arg0 < 0 || i_3_ < arg0)
            arg0 = 0;
        i_3_ <<= i;
        GroundItemTile.varbitmasks[i_0_] = UnderlayDefinition.bitWiseOR(HuffmanEncoding.method1021(GroundItemTile.varbitmasks[i_0_], i_3_ ^ 0xffffffff), HuffmanEncoding.method1021(i_3_, arg0 << i));
    }

    public static boolean hasFriend(String arg0) {
        if(arg0 == null)
            return false;
        for(int i = 0; i < Item.friendsCount; i++) {
            if(arg0.equalsIgnoreCase(ClientScriptRunner.friendUsernames[i]))
                return true;
        }
        return arg0.equalsIgnoreCase(Player.localPlayer.playerName);
    }


    public static int method525(byte[] arg0, int arg1, byte arg2) {
        if(arg2 != -68)
            return -56;
        return Class67.method1034(true, 0, arg1, arg0);
    }

    public static ImageRGB[] method526(CacheIndex arg0, String arg2, String arg3) {
        int i = arg0.getHash(arg2);
        int i_4_ = arg0.method179(i, arg3);
        return GenericTile.method944((byte) -3, i, arg0, i_4_);
    }

    public static void method527(int currentTabId, int arg1, int[] tabWidgetIds, boolean arg3, int arg4) {
        InteractiveObject.tabTop.prepareRasterizer();
        Buffer.tabTopBack.drawImage(0, 0);
        if(arg3) {
            if(tabWidgetIds[currentTabId] != -1) {
                if(currentTabId == 0)
                    Class56.aClass40_Sub5_Sub14_Sub2_1315.drawImage(22, 10);
                if(currentTabId == 1)
                    GameShell.aClass40_Sub5_Sub14_Sub2_1.drawImage(54, 8);
                if(currentTabId == 2)
                    GameShell.aClass40_Sub5_Sub14_Sub2_1.drawImage(82, 8);
                if(currentTabId == 3)
                    Class35.aClass40_Sub5_Sub14_Sub2_1744.drawImage(110, 8);
                if(currentTabId == 4)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(153, 8);
                if(currentTabId == 5)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(181, 8);
                if(currentTabId == 6)
                    Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105.drawImage(209, 9);
            }
            if(tabWidgetIds[0] != -1 && arg4 != 0)
                Class40_Sub5_Sub15.tabIcons[0].drawImage(29, 13);
            if(tabWidgetIds[1] != -1 && arg4 != 1)
                Class40_Sub5_Sub15.tabIcons[1].drawImage(53, 11);
            if(tabWidgetIds[2] != -1 && arg4 != 2)
                Class40_Sub5_Sub15.tabIcons[2].drawImage(82, 11);
            if(tabWidgetIds[3] != -1 && arg4 != 3)
                Class40_Sub5_Sub15.tabIcons[3].drawImage(115, 12);
            if(tabWidgetIds[4] != -1 && arg4 != 4)
                Class40_Sub5_Sub15.tabIcons[4].drawImage(153, 13);
            if(tabWidgetIds[5] != -1 && arg4 != 5)
                Class40_Sub5_Sub15.tabIcons[5].drawImage(180, 11);
            if(tabWidgetIds[6] != -1 && arg4 != 6)
                Class40_Sub5_Sub15.tabIcons[6].drawImage(208, 13);
        }
        RSCanvas.tabBottom.prepareRasterizer();
        Class56.tabBottomBack.drawImage(0, 0);
        if(arg1 != 4)
            hasFriend(null);
        if(arg3) {
            if(tabWidgetIds[currentTabId] != -1) {
                if(currentTabId == 7)
                    Renderable.aClass40_Sub5_Sub14_Sub2_2860.drawImage(42, 0);
                if(currentTabId == 8)
                    HashTable.aClass40_Sub5_Sub14_Sub2_549.drawImage(74, 0);
                if(currentTabId == 9)
                    HashTable.aClass40_Sub5_Sub14_Sub2_549.drawImage(102, 0);
                if(currentTabId == 10)
                    MovedStatics.aClass40_Sub5_Sub14_Sub2_1919.drawImage(130, 1);
                if(currentTabId == 11)
                    Class13.aClass40_Sub5_Sub14_Sub2_418.drawImage(173, 0);
                if(currentTabId == 12)
                    Class13.aClass40_Sub5_Sub14_Sub2_418.drawImage(201, 0);
                if(currentTabId == 13)
                    ISAAC.aClass40_Sub5_Sub14_Sub2_524.drawImage(229, 0);
            }
            if(tabWidgetIds[8] != -1 && arg4 != 8)
                Class40_Sub5_Sub15.tabIcons[7].drawImage(74, 2);
            if(tabWidgetIds[9] != -1 && arg4 != 9)
                Class40_Sub5_Sub15.tabIcons[8].drawImage(102, 3);
            if(tabWidgetIds[10] != -1 && arg4 != 10)
                Class40_Sub5_Sub15.tabIcons[9].drawImage(137, 4);
            if(tabWidgetIds[11] != -1 && arg4 != 11)
                Class40_Sub5_Sub15.tabIcons[10].drawImage(174, 2);
            if(tabWidgetIds[12] != -1 && arg4 != 12)
                Class40_Sub5_Sub15.tabIcons[11].drawImage(201, 2);
            if(tabWidgetIds[13] != -1 && arg4 != 13)
                Class40_Sub5_Sub15.tabIcons[12].drawImage(226, 2);
        }
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            if(ScreenController.frameMode == ScreenMode.FIXED) {
                InteractiveObject.tabTop.drawGraphics(516, 160, graphics);
                RSCanvas.tabBottom.drawGraphics(496, 466, graphics);
            }
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public void method528() {
        int i = anInt1997;
        GameObjectDefinition gameObjectDefinition = aGameObjectDefinition_2011.getChildDefinition(-20);
        if(gameObjectDefinition == null) {
            anInt2000 = 0;
            anInt2012 = 0;
            anInt2002 = 0;
            anIntArray2005 = null;
            anInt1997 = -1;
        } else {
            anInt2000 = 128 * gameObjectDefinition.anInt2502;
            anInt2012 = gameObjectDefinition.anInt2499;
            anInt2002 = gameObjectDefinition.anInt2542;
            anInt1997 = gameObjectDefinition.ambientSoundId;
            anIntArray2005 = gameObjectDefinition.anIntArray2523;
        }
        if(i != anInt1997 && aClass40_Sub9_Sub2_2001 != null) {
            Class49.aClass40_Sub9_Sub1_1152.method853(aClass40_Sub9_Sub2_2001);
            aClass40_Sub9_Sub2_2001 = null;
        }
    }
}
