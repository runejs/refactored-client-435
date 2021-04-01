package com.jagex.runescape;

import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.node.HashTable;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;

public class Class37 {
    public static HashTable aClass23_869 = new HashTable(32);
    public static boolean aBoolean871 = false;
    public static int anInt874;
    public static int anInt876 = 0;
    public static ImageRGB[] cursorCross;

    static {
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
        int i2 = (-_x + 128) * MovedStatics.tile_height[groundZ][groundX][groundY] + _x * MovedStatics.tile_height[groundZ][groundX + 1][groundY] >> 7;
        int j2 = _x * MovedStatics.tile_height[groundZ][1 + groundX][1 + groundY] + MovedStatics.tile_height[groundZ][groundX][1 + groundY] * (128 + -_x) >> 7;
        return (128 + -_y) * i2 + j2 * _y >> 7;
    }

    public static void method432() {
        System.out.println("Usage: worldid, [live/office/local], [live/rc/wip], [lowmem/highmem], [free/members]");
        System.exit(1);
    }


    public static void method434(int arg0) {
        MovedStatics.menuOpen = false;
        IncomingPackets.incomingPacket = -1;
        ActorDefinition.menuActionRow = 0;
        IncomingPackets.incomingPacketSize = 0;
        SceneCluster.packetBuffer.currentPosition = 0;
        RSString.anInt1690 = -1;
        MovedStatics.anInt324 = -1;
        Class35.anInt1728 = 0;
        Class49.anInt1151 = -1;
        VarbitDefinition.destinationX = 0;
        MovedStatics.minimapState = 0;
        Class40_Sub5_Sub15.systemUpdateTime = 0;
        IncomingPackets.incomingPacketBuffer.currentPosition = arg0;
        for(int i = 0; Player.trackedPlayers.length > i; i++) {
            if(Player.trackedPlayers[i] != null)
                Player.trackedPlayers[i].facingActorIndex = -1;
        }
        for(int i = 0; Player.npcs.length > i; i++) {
            if(Player.npcs[i] != null)
                Player.npcs[i].facingActorIndex = -1;
        }
        OverlayDefinition.updateOverlay(30);
    }

    public static void renderMinimap() {
        RSCanvas.createMinimapRaster();

        if(MovedStatics.minimapState == 2) {
            byte[] mmBackgroundPixels = MovedStatics.minimapBackgroundImage.imgPixels;
            int[] rasterPixels = Rasterizer.destinationPixels;
            int pixelCount = mmBackgroundPixels.length;
            for(int i = 0; i < pixelCount; i++) {
                if(mmBackgroundPixels[i] == 0)
                    rasterPixels[i] = 0;
            }
            AnimationSequence.minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, GroundItemTile.cameraHorizontal, 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
            ActorDefinition.drawMapBack();
            return;
        }

        int centerX = 48 + Player.localPlayer.worldX / 32;
        int centerY = 464 + -(Player.localPlayer.worldY / 32);
        int angle = GroundItemTile.cameraHorizontal + Class43.cameraYawOffset & 0x7ff;
        Class40_Sub5_Sub13.minimapImage.shapeImageToPixels(25, 5, 146, 151, centerX, centerY, angle, Class51.mapZoomOffset + 256, Landscape.anIntArray1186, MovedStatics.anIntArray852);
        for(int i = 0; GameObject.minimapHintCount > i; i++) {
            int hintX = 2 + 4 * Actor.minimapHintX[i] + -(Player.localPlayer.worldX / 32);
            int hintY = 2 + 4 * LinkedList.minimapHintY[i] - Player.localPlayer.worldY / 32;
            SceneTile.drawOnMinimap(hintY, hintX, MouseHandler.minimapHint[i]);
        }
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                LinkedList linkedList = Wall.groundItems[Player.worldLevel][x][y];
                if(linkedList != null) {
                    int itemX = -(Player.localPlayer.worldY / 32) + 2 + y * 4;
                    int itemY = -(Player.localPlayer.worldX / 32) + 2 + x * 4;
                    SceneTile.drawOnMinimap(itemX, itemY, MovedStatics.mapDots[0]);
                }
            }
        }
        for(int i = 0; Player.npcCount > i; i++) {
            Npc npc = Player.npcs[Player.npcIds[i]];
            if(npc != null && npc.isVisible(1)) {
                ActorDefinition definition = npc.actorDefinition;
                if(definition.childrenIds != null)
                    definition = definition.getChildDefinition(-1);
                if(definition != null && definition.renderOnMinimap && definition.isClickable) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 + -(Player.localPlayer.worldY / 32);
                    SceneTile.drawOnMinimap(npcY, npcX, MovedStatics.mapDots[1]);
                }
            }
        }
        for(int i = 0; Player.localPlayerCount > i; i++) {
            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            if(player != null && player.isVisible(1)) {
                int playerX = player.worldX / 32 + -(Player.localPlayer.worldX / 32);
                int playerY = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                boolean isFriend = false;
                long name = RSString.nameToLong(player.playerName);
                for(int friend = 0; Player.friendsCount > friend; friend++) {
                    if(name == Class59.friends[friend] && Player.friendWorlds[friend] != 0) {
                        isFriend = true;
                        break;
                    }
                }
                boolean isTeammate = false;
                if(Player.localPlayer.teamId != 0 && player.teamId != 0 && player.teamId == Player.localPlayer.teamId)
                    isTeammate = true;
                if(isFriend)
                    SceneTile.drawOnMinimap(playerY, playerX, MovedStatics.mapDots[3]);
                else if(isTeammate)
                    SceneTile.drawOnMinimap(playerY, playerX, MovedStatics.mapDots[4]);
                else
                    SceneTile.drawOnMinimap(playerY, playerX, MovedStatics.mapDots[2]);
            }
        }
        if(Player.headIconDrawType != 0 && MovedStatics.pulseCycle % 20 < 10) {
            if(Player.headIconDrawType == 1 && HuffmanEncoding.anInt1545 >= 0 && Player.npcs.length > HuffmanEncoding.anInt1545) {
                Npc npc = Player.npcs[HuffmanEncoding.anInt1545];
                if(npc != null) {
                    int npcX = -(Player.localPlayer.worldX / 32) + npc.worldX / 32;
                    int npcY = npc.worldY / 32 - Player.localPlayer.worldY / 32;
                    OverlayDefinition.drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], npcX, npcY);
                }
            }
            if(Player.headIconDrawType == 2) {
                int hintX = -(Player.localPlayer.worldY / 32) + 2 + 4 * (-Class26.baseY + MovedStatics.anInt175);
                int hintY = 4 * (ProducingGraphicsBuffer.anInt1637 - SpotAnimDefinition.baseX) - (-2 + Player.localPlayer.worldX / 32);
                OverlayDefinition.drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], hintY, hintX);
            }
            if(Player.headIconDrawType == 10 && ProducingGraphicsBuffer.anInt1623 >= 0 && Player.trackedPlayers.length > ProducingGraphicsBuffer.anInt1623) {
                Player player = Player.trackedPlayers[ProducingGraphicsBuffer.anInt1623];
                if(player != null) {
                    int playerX = -(Player.localPlayer.worldY / 32) + player.worldY / 32;
                    int playerY = player.worldX / 32 - Player.localPlayer.worldX / 32;
                    OverlayDefinition.drawMinimapMark(Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[1], playerY, playerX);
                }
            }
        }
        if(VarbitDefinition.destinationX != 0) {
            int flagX = 2 + VarbitDefinition.destinationX * 4 + -(Player.localPlayer.worldX / 32);
            int flagY = 2 + 4 * Class55.destinationY + -(Player.localPlayer.worldY / 32);
            SceneTile.drawOnMinimap(flagY, flagX, Class40_Sub3.aClass40_Sub5_Sub14_Sub4Array2019[0]);
        }
        Rasterizer.drawFilledRectangle(97, 78, 3, 3, 16777215);
        AnimationSequence.minimapCompass.shapeImageToPixels(0, 0, 33, 33, 25, 25, GroundItemTile.cameraHorizontal, 256, RSCanvas.anIntArray62, RSCanvas.anIntArray66);
        MovedStatics.minimapBackgroundImage.drawImage(0, 0);

        if(MovedStatics.menuOpen && ScreenController.frameMode == ScreenMode.FIXED && Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
            Class40_Sub5_Sub6.drawMenu(550, 4);
        }
        ActorDefinition.drawMapBack();

    }

    public static void method436(int arg0) {
        if(arg0 < 95)
            method436(25);
        for(Class40_Sub2 class40_sub2 = (Class40_Sub2) MovedStatics.aLinkedList_2268.method902((byte) -90); class40_sub2 != null; class40_sub2 = (Class40_Sub2) MovedStatics.aLinkedList_2268.method909(-4)) {
            if(class40_sub2.aClass40_Sub9_Sub2_2001 != null) {
                Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2001);
                class40_sub2.aClass40_Sub9_Sub2_2001 = null;
            }
            if(class40_sub2.aClass40_Sub9_Sub2_2010 != null) {
                Class49.aClass40_Sub9_Sub1_1152.method853(class40_sub2.aClass40_Sub9_Sub2_2010);
                class40_sub2.aClass40_Sub9_Sub2_2010 = null;
            }
        }
        MovedStatics.aLinkedList_2268.method906(0);
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
            class40_sub2.gameObjectDefinition = arg5;
            class40_sub2.method528();
        }
        MovedStatics.aLinkedList_2268.pushBack(class40_sub2, -126);
        if(class40_sub2.anIntArray2005 != null)
            class40_sub2.anInt2014 = (int) ((double) (class40_sub2.anInt2002 - class40_sub2.anInt2012) * Math.random()) + class40_sub2.anInt2012;
    }

    public static boolean method438(int arg0, int arg1) {
        if(arg0 == 0 && arg1 == MovedStatics.anInt573)
            return true;
        if(arg0 == 1 && FloorDecoration.anInt614 == arg1)
            return true;
        if((arg0 == 2 || arg0 == 3) && MovedStatics.anInt1586 == arg1)
            return true;
        return false;
    }
}
