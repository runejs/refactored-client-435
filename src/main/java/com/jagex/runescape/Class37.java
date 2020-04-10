package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;

public class Class37 {
    public static HashTable aClass23_869 = new HashTable(32);
    public static boolean aBoolean871 = false;
    public static RSString aClass1_873;
    public static int anInt874;
    public static RSString aClass1_875;
    public static int anInt876 = 0;
    public static RSString aClass1_877 = RSString.CreateString("@gr1@");
    public static ImageRGB[] cursorCross;

    static {
        aClass1_875 = (RSString.CreateString("Please close the interface you have open before using (Wreport abuse(W"));
        aClass1_873 = aClass1_875;
        anInt874 = 0;
    }

    public static int getFloorDrawHeight(int plane, int x, int y) {
        int groundX = x >> 7;
        int groundY = y >> 7;
        if(groundX < 0 || groundY < 0 || groundX > 103 || groundY > 103)
            return 0;
        int groundZ = plane;
        if(groundZ < 3 && (OverlayDefinition.tile_flags[1][groundX][groundY] & 0x2) == 2)
            groundZ++;
        int _x = 0x7f & x;
        int _y = y & 0x7f;
        int i2 = (((-_x + 128) * (Class40_Sub6.tile_height[groundZ][groundX][groundY]) + (_x * (Class40_Sub6.tile_height[groundZ][groundX + 1][groundY]))) >> 7);
        int j2 = ((_x * (Class40_Sub6.tile_height[groundZ][1 + groundX][1 + groundY]) + (Class40_Sub6.tile_height[groundZ][groundX][1 + groundY] * (128 + -_x))) >> 7);
        return (128 + -_y) * i2 + (j2 * _y) >> 7;
    }

    public static void method432() {
        System.out.println("Usage: worldid, [live/office/local], [live/rc/wip], [lowmem/highmem], [free/members]");
        System.exit(1);
    }

    public static void method433() {
        aClass23_869 = null;
        aClass1_875 = null;
        cursorCross = null;
        aClass1_873 = null;
        aClass1_877 = null;
    }

    public static void method434(int arg0) {
        Class4.menuOpen = false;
        IncomingPackets.incomingPacket = -1;
        ActorDefinition.menuActionRow = 0;
        IncomingPackets.incomingPacketSize = 0;
        SceneCluster.packetBuffer.currentPosition = 0;
        RSString.anInt1690 = -1;
        Cache.anInt324 = -1;
        Class35.anInt1728 = 0;
        Class49.anInt1151 = -1;
        VarbitDefinition.destinationX = 0;
        Class27.minimapState = 0;
        Class40_Sub5_Sub15.systemUpdateTime = 0;
        IncomingPackets.incomingPacketBuffer.currentPosition = arg0;
        for(int i = 0; ((Player.trackedPlayers).length > i); i++) {
            if((Player.trackedPlayers[i]) != null)
                Player.trackedPlayers[i].facingActorIndex = -1;
        }
        for(int i = 0; ((Player.npcs.length > i)); i++) {
            if(Player.npcs[i] != null)
                Player.npcs[i].facingActorIndex = -1;
        }
        OverlayDefinition.method559(30);
    }

    public static void renderMinimap(boolean arg0) {
        RSCanvas.method45((byte) -106);
        if(Class27.minimapState == 2) {
            byte[] mmBackgroundPixels = Class34.mapBack.imgPixels;
            int[] rasterPixels = Rasterizer.destinationPixels;
            int pixelCount = mmBackgroundPixels.length;
            for(int i = 0; i < pixelCount; i++) {
                if(mmBackgroundPixels[i] == 0)
                    rasterPixels[i] = 0;
            }
            AnimationSequence.minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, GroundItemTile.cameraHorizontal, 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
            ActorDefinition.method574();
        } else {
            int i = 48 + ((Player.localPlayer.worldX) / 32);
            int i_8_ = 464 + -((Player.localPlayer.worldY) / 32);
            int i_9_ = GroundItemTile.cameraHorizontal + Class43.cameraYawOffset & 0x7ff;
            Class40_Sub5_Sub13.aClass40_Sub5_Sub14_Sub4_2765.shapeImageToPixels(25, 5, 146, 151, i, i_8_, i_9_, Class51.mapZoomOffset + 256, Landscape.anIntArray1186, Class34.anIntArray852);
            for(int i_10_ = 0; GameObject.anInt3040 > i_10_; i_10_++) {
                i = 2 + (4 * Actor.anIntArray3149[i_10_] + -((Player.localPlayer.worldX) / 32));
                i_8_ = (2 + 4 * LinkedList.anIntArray1083[i_10_] - ((Player.localPlayer.worldY) / 32));
                SceneTile.drawOnMinimap(i_8_, i, (MouseHandler.aClass40_Sub5_Sub14_Sub4Array1466[i_10_]));
            }
            for(int i_11_ = 0; i_11_ < 104; i_11_++) {
                for(int i_12_ = 0; i_12_ < 104; i_12_++) {
                    LinkedList linkedList = (Wall.groundItems[Player.worldLevel][i_11_][i_12_]);
                    if(linkedList != null) {
                        i_8_ = -((Player.localPlayer.worldY) / 32) + 2 + i_12_ * 4;
                        i = -((Player.localPlayer.worldX) / 32) + 2 + i_11_ * 4;
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[0]);
                    }
                }
            }
            for(int i_13_ = 0; Player.npcCount > i_13_; i_13_++) {
                Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[Player.npcIds[i_13_]]);
                if(class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.isVisible(1)) {
                    ActorDefinition class40_sub5_sub5 = (class40_sub5_sub17_sub4_sub2.actorDefinition);
                    if(class40_sub5_sub5.childrenIds != null)
                        class40_sub5_sub5 = class40_sub5_sub5.getChildDefinition(-1);
                    if(class40_sub5_sub5 != null && class40_sub5_sub5.renderOnMinimap && class40_sub5_sub5.isClickable) {
                        i = (-((Player.localPlayer.worldX) / 32) + (class40_sub5_sub17_sub4_sub2.worldX / 32));
                        i_8_ = (class40_sub5_sub17_sub4_sub2.worldY / 32 + -((Player.localPlayer.worldY) / 32));
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[1]);
                    }
                }
            }
            for(int i_14_ = 0; (Player.localPlayerCount > i_14_); i_14_++) {
                Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[Player.trackedPlayerIndices[i_14_]]);
                if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.isVisible(1)) {
                    i = (class40_sub5_sub17_sub4_sub1.worldX / 32 + -((Player.localPlayer.worldX) / 32));
                    i_8_ = (-((Player.localPlayer.worldY) / 32) + class40_sub5_sub17_sub4_sub1.worldY / 32);
                    boolean bool = false;
                    long l = class40_sub5_sub17_sub4_sub1.playerName.method58((byte) 122);
                    for(int i_15_ = 0; Item.friendsCount > i_15_; i_15_++) {
                        if(l == Class59.aLongArray1397[i_15_] && Class40_Sub7.friendWorlds[i_15_] != 0) {
                            bool = true;
                            break;
                        }
                    }
                    boolean bool_16_ = false;
                    if(((Player.localPlayer.teamId) != 0) && class40_sub5_sub17_sub4_sub1.teamId != 0 && (class40_sub5_sub17_sub4_sub1.teamId == (Player.localPlayer.teamId)))
                        bool_16_ = true;
                    if(bool)
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[3]);
                    else if(bool_16_)
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[4]);
                    else
                        SceneTile.drawOnMinimap(i_8_, i, Class27.aClass40_Sub5_Sub14_Sub4Array649[2]);
                }
            }
            if(Player.anInt3288 != 0 && Node.pulseCycle % 20 < 10) {
                if(Player.anInt3288 == 1 && HuffmanEncoding.anInt1545 >= 0 && ((Player.npcs).length > HuffmanEncoding.anInt1545)) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[HuffmanEncoding.anInt1545]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        i = (-((Player.localPlayer.worldX) / 32) + (class40_sub5_sub17_sub4_sub2.worldX / 32));
                        i_8_ = (class40_sub5_sub17_sub4_sub2.worldY / 32 - (Player.localPlayer.worldY) / 32);
                        OverlayDefinition.drawMinimapMark((Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1]), i, i_8_);
                    }
                }
                if(Player.anInt3288 == 2) {
                    i_8_ = (-((Player.localPlayer.worldY) / 32) + 2 + 4 * (-Class26.baseY + Class4.anInt175));
                    i = (4 * (Class68.anInt1637 - SpotAnimDefinition.baseX) - (-2 + ((Player.localPlayer.worldX) / 32)));
                    OverlayDefinition.drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], i, i_8_);
                }
                if(Player.anInt3288 == 10 && Class68.anInt1623 >= 0 && ((Player.trackedPlayers).length > Class68.anInt1623)) {
                    Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[Class68.anInt1623]);
                    if(class40_sub5_sub17_sub4_sub1 != null) {
                        i_8_ = (-((Player.localPlayer.worldY) / 32) + (class40_sub5_sub17_sub4_sub1.worldY / 32));
                        i = (class40_sub5_sub17_sub4_sub1.worldX / 32 - (Player.localPlayer.worldX) / 32);
                        OverlayDefinition.drawMinimapMark((Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1]), i, i_8_);
                    }
                }
            }
            if(VarbitDefinition.destinationX != 0) {
                i = (2 + VarbitDefinition.destinationX * 4 + -((Player.localPlayer.worldX) / 32));
                i_8_ = 2 + (4 * Class55.destinationY + -((Player.localPlayer.worldY) / 32));
                SceneTile.drawOnMinimap(i_8_, i, (Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[0]));
            }
            Rasterizer.drawFilledRectangle(97, 78, 3, 3, 16777215);
            AnimationSequence.minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, GroundItemTile.cameraHorizontal, 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
            if(arg0)
                ActorDefinition.method574();
        }

    }

    public static void method436(int arg0) {
        if(arg0 < 95)
            method436(25);
        for(Class40_Sub2 class40_sub2 = ((Class40_Sub2) Class40_Sub5_Sub1.aLinkedList_2268.method902((byte) -90)); class40_sub2 != null; class40_sub2 = (Class40_Sub2) Class40_Sub5_Sub1.aLinkedList_2268.method909(-4)) {
            if(class40_sub2.aClass40_Sub9_Sub2_2001 != null) {
                Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2001);
                class40_sub2.aClass40_Sub9_Sub2_2001 = null;
            }
            if(class40_sub2.aClass40_Sub9_Sub2_2010 != null) {
                Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2010);
                class40_sub2.aClass40_Sub9_Sub2_2010 = null;
            }
        }
        Class40_Sub5_Sub1.aLinkedList_2268.method906(0);
    }

    public static void method437(int arg0, boolean arg1, int arg2, int arg3, int arg4, GameObjectDefinition arg5) {
        Class40_Sub2 class40_sub2 = new Class40_Sub2();
        class40_sub2.anInt2000 = 128 * arg5.anInt2502;
        if(!arg1)
            method438(119, -54);
        class40_sub2.anInt2002 = arg5.anInt2542;
        class40_sub2.anIntArray2005 = arg5.anIntArray2523;
        class40_sub2.anInt2012 = arg5.anInt2499;
        int i = arg5.sizeX;
        int i_17_ = arg5.sizeY;
        class40_sub2.anInt1993 = arg2;
        class40_sub2.anInt1994 = arg4 * 128;
        if(arg3 == 1 || arg3 == 3) {
            i = arg5.sizeY;
            i_17_ = arg5.sizeX;
        }
        class40_sub2.anInt2003 = 128 * arg0;
        class40_sub2.anInt2007 = (i_17_ + arg0) * 128;
        class40_sub2.anInt2013 = (arg4 + i) * 128;
        class40_sub2.anInt1997 = arg5.ambientSoundId;
        if(arg5.configChangeDest != null) {
            class40_sub2.aGameObjectDefinition_2011 = arg5;
            class40_sub2.method528();
        }
        Class40_Sub5_Sub1.aLinkedList_2268.pushBack(class40_sub2, -126);
        if(class40_sub2.anIntArray2005 != null)
            class40_sub2.anInt2014 = (int) ((double) (class40_sub2.anInt2002 - class40_sub2.anInt2012) * Math.random()) + class40_sub2.anInt2012;
    }

    public static boolean method438(int arg0, int arg1) {
        if(arg0 == 0 && arg1 == HashTable.anInt573)
            return true;
        if(arg0 == 1 && FloorDecoration.anInt614 == arg1)
            return true;
        if((arg0 == 2 || arg0 == 3) && Class67.anInt1586 == arg1)
            return true;
        return false;
    }
}
