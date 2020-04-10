package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.collection.Node;
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

    public static void method522(int arg0, int arg1, byte arg2) {
        VarbitDefinition varbitDefinition = Class34.method417(0, arg1);
        int i = varbitDefinition.leastSignificantBit;
        int i_0_ = varbitDefinition.index;
        int i_1_ = varbitDefinition.mostSignificantBit;
        int i_2_ = -115 % ((arg2 - 46) / 57);
        int i_3_ = Class68_Sub1.anIntArray2199[i_1_ + -i];
        if(arg0 < 0 || (i_3_ < arg0))
            arg0 = 0;
        i_3_ <<= i;
        GroundItemTile.varbitmasks[i_0_] = (UnderlayDefinition.bitWiseOR(HuffmanEncoding.method1021(GroundItemTile.varbitmasks[i_0_], i_3_ ^ 0xffffffff), HuffmanEncoding.method1021(i_3_, arg0 << i)));
    }

    public static boolean hasFriend(RSString arg0) {
        if(arg0 == null)
            return false;
        for(int i = 0; i < Item.friendsCount; i++) {
            if(arg0.equalsIgnoreCase(Class40_Sub11.friendUsernames[i]))
                return true;
        }
        return arg0.equalsIgnoreCase((Player.localPlayer.playerName));
    }


    public static int method525(byte[] arg0, int arg1, byte arg2) {
        if(arg2 != -68)
            return -56;
        return Class67.method1034(true, 0, arg1, arg0);
    }

    public static ImageRGB[] method526(CacheIndex arg0, RSString arg2, RSString arg3) {
        int i = arg0.getHash(arg2);
        int i_4_ = arg0.method179(i, arg3);
        return GenericTile.method944((byte) -3, i, arg0, i_4_);
    }

    public static void method527(int arg0, int arg1, int[] arg2, boolean arg3, int arg4) {
        InteractiveObject.aClass68_482.method1046((byte) 90);
        Buffer.aClass40_Sub5_Sub14_Sub2_1959.drawImage(0, 0);
        if(arg3) {
            if(arg2[arg0] != -1) {
                if(arg0 == 0)
                    Class56.aClass40_Sub5_Sub14_Sub2_1315.drawImage(22, 10);
                if(arg0 == 1)
                    GameShell.aClass40_Sub5_Sub14_Sub2_1.drawImage(54, 8);
                if(arg0 == 2)
                    GameShell.aClass40_Sub5_Sub14_Sub2_1.drawImage(82, 8);
                if(arg0 == 3)
                    Class35.aClass40_Sub5_Sub14_Sub2_1744.drawImage(110, 8);
                if(arg0 == 4)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(153, 8);
                if(arg0 == 5)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(181, 8);
                if(arg0 == 6)
                    Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105.drawImage(209, 9);
            }
            if(arg2[0] != -1 && arg4 != 0)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[0].drawImage(29, 13);
            if(arg2[1] != -1 && arg4 != 1)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[1].drawImage(53, 11);
            if(arg2[2] != -1 && arg4 != 2)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[2].drawImage(82, 11);
            if(arg2[3] != -1 && arg4 != 3)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[3].drawImage(115, 12);
            if(arg2[4] != -1 && arg4 != 4)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[4].drawImage(153, 13);
            if(arg2[5] != -1 && arg4 != 5)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[5].drawImage(180, 11);
            if(arg2[6] != -1 && arg4 != 6)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[6].drawImage(208, 13);
        }
        RSCanvas.aClass68_59.method1046((byte) 90);
        Class56.aClass40_Sub5_Sub14_Sub2_1329.drawImage(0, 0);
        if(arg1 != 4)
            hasFriend(null);
        if(arg3) {
            if(arg2[arg0] != -1) {
                if(arg0 == 7)
                    Renderable.aClass40_Sub5_Sub14_Sub2_2860.drawImage(42, 0);
                if(arg0 == 8)
                    HashTable.aClass40_Sub5_Sub14_Sub2_549.drawImage(74, 0);
                if(arg0 == 9)
                    HashTable.aClass40_Sub5_Sub14_Sub2_549.drawImage(102, 0);
                if(arg0 == 10)
                    Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919.drawImage(130, 1);
                if(arg0 == 11)
                    Class13.aClass40_Sub5_Sub14_Sub2_418.drawImage(173, 0);
                if(arg0 == 12)
                    Class13.aClass40_Sub5_Sub14_Sub2_418.drawImage(201, 0);
                if(arg0 == 13)
                    ISAAC.aClass40_Sub5_Sub14_Sub2_524.drawImage(229, 0);
            }
            if(arg2[8] != -1 && arg4 != 8)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[7].drawImage(74, 2);
            if(arg2[9] != -1 && arg4 != 9)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[8].drawImage(102, 3);
            if(arg2[10] != -1 && arg4 != 10)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[9].drawImage(137, 4);
            if(arg2[11] != -1 && arg4 != 11)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[10].drawImage(174, 2);
            if(arg2[12] != -1 && arg4 != 12)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[11].drawImage(201, 2);
            if(arg2[13] != -1 && arg4 != 13)
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776[12].drawImage(226, 2);
        }
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            InteractiveObject.aClass68_482.drawGraphics(516, 160, graphics);
            RSCanvas.aClass68_59.drawGraphics(496, 466, graphics);
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
