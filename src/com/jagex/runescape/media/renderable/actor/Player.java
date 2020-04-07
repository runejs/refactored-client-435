package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.*;

public class Player extends Actor {
    public static RSString aClass1_3256 = RSString.CreateString("green:");
    public static int anInt3264 = 0;
    public static int worldLevel;
    public static byte[] aByteArray3270;
    public static int[] anIntArray3284;
    public static RSString aClass1_3286 = RSString.CreateString("Try again in 60 secs)3)3)3");
    public static int anInt3288 = 0;
    public static Player localPlayer;
    public static int[] actorUpdatingIndices = new int[2048];
    public static Buffer[] trackedPlayerAppearanceCache = new Buffer[2048];
    public static int[] deregisterActorIndices = new int[1000];
    public static Npc[] npcs;
    public static Player[] trackedPlayers = new Player[2048];
    public static int[] npcIds = new int[32768];
    public static int[] trackedPlayerIndices = new int[2048];
    public static int npcCount = 0;
    public static int localPlayerCount;
    public int skillLevel;
    public int anInt3258;
    public int combatLevel = 0;
    public int anInt3262;
    public Model aClass40_Sub5_Sub17_Sub5_3265;
    public int teamId = 0;
    public int isSkulled;
    public int anInt3271;
    public int anInt3272;
    public int headIcon;
    public int anInt3274;
    public int anInt3276;
    public RSString playerName;
    public int anInt3281;
    public Class30 aClass30_3282;
    public int anInt3283;
    public boolean aBoolean3287;
    public int anInt3289;
    public int anInt3291;

    public Player() {
        skillLevel = 0;
        headIcon = -1;
        isSkulled = -1;
        anInt3274 = 0;
        anInt3283 = 0;
        aBoolean3287 = false;
    }

    public static void method792(int arg0) {
        try {
            if(arg0 < 106)
                return;
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            VarbitDefinition.aClass68_2350.drawGraphics(4, 4, graphics);
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static boolean method793(byte arg0, int arg1) {
        if(arg1 < 32)
            return false;
        if(arg1 == 127)
            return false;
        if(arg0 < 118)
            aByteArray3270 = null;
        return arg1 < 129 || arg1 > 159;
    }

    public static void method794() {
        aByteArray3270 = null;
        anIntArray3284 = null;
        aClass1_3286 = null;
        aClass1_3256 = null;
    }

    public static void parsePlayerUpdateMasks(Player player, int mask, int playerIndex) {
        if((0x100 & mask) != 0) {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_0_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.method785(i_0_, pulseCycle, i, -122);
            player.anInt3139 = 300 + pulseCycle;
            player.anInt3130 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3101 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
        }
        if((mask & 0x10) != 0) { // face position
            player.facePositionX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            player.facePositionY = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
        }
        if((mask & 0x1) != 0) { // animation
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            if(i == 65535)
                i = -1;
            int i_1_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            ActorDefinition.method570(i, i_1_, player);
        }
        if((mask & 0x4) != 0) { // face actor
            player.facingActorIndex = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            if(player.facingActorIndex == 65535)
                player.facingActorIndex = -1;
        }
        if((0x40 & mask) != 0) {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_2_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.method785(i_2_, pulseCycle, i, -123);
            player.anInt3139 = 300 + pulseCycle;
            player.anInt3130 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3101 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
        }
        if((mask & 0x400) != 0) {
            player.anInt3125 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3081 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3099 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3127 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3112 = (IncomingPackets.incomingPacketBuffer.getUnsignedShortBE() + pulseCycle);
            player.anInt3107 = (IncomingPackets.incomingPacketBuffer.getUnsignedShortLE() + pulseCycle);
            player.anInt3073 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.method790(0);
        }
        if((0x8 & mask) != 0) { // chat
            int chatEffectsAndColors = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int playerRights = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int messageLength = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_5_ = IncomingPackets.incomingPacketBuffer.currentPosition;
            if(player.playerName != null && player.aClass30_3282 != null) {
                long l = player.playerName.method58((byte) 101);
                boolean bool = false;
                if(playerRights <= 1) {
                    for(int i_6_ = 0; i_6_ < Class42.anInt1008; i_6_++) {
                        if(l == WallDecoration.ignores[i_6_]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && Class4.anInt182 == 0) {
                    Class59.aClass40_Sub1_1385.currentPosition = 0;
                    IncomingPackets.incomingPacketBuffer.putBytes(0, messageLength, Class59.aClass40_Sub1_1385.buffer);
                    Class59.aClass40_Sub1_1385.currentPosition = 0;
                    RSString class1 = KeyFocusListener.method956(124, Class59.aClass40_Sub1_1385).method53();
                    player.forcedChatMessage = class1.trim();
                    player.anInt3078 = 150;
                    player.chatEffects = chatEffectsAndColors & 0xff;
                    player.chatcolor = chatEffectsAndColors >> 8;
                    if(playerRights == 2 || playerRights == 3)
                        Class44.addChatMessage((RSString.linkRSStrings((new RSString[]{Widget.goldCrown, player.playerName}))), class1, 1);
                    else if(playerRights == 1)
                        Class44.addChatMessage((RSString.linkRSStrings((new RSString[]{Class51.whiteCrown, player.playerName}))), class1, 1);
                    else
                        Class44.addChatMessage(player.playerName, class1, 2);
                }
            }
            IncomingPackets.incomingPacketBuffer.currentPosition = messageLength + i_5_;
        }
        if((0x20 & mask) != 0) { // appearance
            int appearanceUpdateLength = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            byte[] is = new byte[appearanceUpdateLength];
            Buffer buffer = new Buffer(is);
            IncomingPackets.incomingPacketBuffer.getBytes(appearanceUpdateLength, 0, is);
            trackedPlayerAppearanceCache[playerIndex] = buffer;
            player.parsePlayerAppearanceData(buffer);
        }
        if((mask & 0x200) != 0) { // graphics?
            player.anInt3091 = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int i = IncomingPackets.incomingPacketBuffer.getIntBE();
            player.anInt3129 = 0;
            player.anInt3093 = pulseCycle + (i & 0xffff);
            if(player.anInt3091 == 65535)
                player.anInt3091 = -1;
            player.anInt3140 = 0;
            player.anInt3110 = i >> 16;
            if(player.anInt3093 > pulseCycle)
                player.anInt3140 = -1;
        }
        if((0x80 & mask) != 0) { // forced chat
            player.forcedChatMessage = IncomingPackets.incomingPacketBuffer.getRSString();
            if(player.forcedChatMessage.getChar(0) == 126) {
                player.forcedChatMessage = player.forcedChatMessage.substring(1);
                Class44.addChatMessage(player.playerName, player.forcedChatMessage, 2);
            } else if(player == localPlayer)
                Class44.addChatMessage(player.playerName, player.forcedChatMessage, 2);
            player.anInt3078 = 150;
            player.chatcolor = 0;
            player.chatEffects = 0;
        }
    }

    public static void parseTrackedPlayerUpdateMasks() {
        for(int i = 0; i < actorUpdatingIndex; i++) {
            int trackedPlayerIndex = actorUpdatingIndices[i];
            Player player = (trackedPlayers[trackedPlayerIndex]);
            int mask = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            if((mask & 0x2) != 0)
                mask += (IncomingPackets.incomingPacketBuffer.getUnsignedByte() << 8);
            parsePlayerUpdateMasks(player, mask, trackedPlayerIndex);
        }
    }

    public static void parsePlayerMovement() {
        IncomingPackets.incomingPacketBuffer.initBitAccess();
        int updateRequired = IncomingPackets.incomingPacketBuffer.getBits(1);
        if(updateRequired != 0) {
            int movementType = IncomingPackets.incomingPacketBuffer.getBits(2);
            if(movementType == 0) // No movement
                actorUpdatingIndices[actorUpdatingIndex++] = 2047;
            else if(movementType == 1) { // Walking
                int walkDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                localPlayer.method782(walkDirection, (byte) -96, false);
                int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                if(runUpdateBlock == 1)
                    actorUpdatingIndices[actorUpdatingIndex++] = 2047;
            } else if(movementType == 2) { // Running
                int walkDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                localPlayer.method782(walkDirection, (byte) -96, true);
                int runDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                localPlayer.method782(runDirection, (byte) -96, true);
                int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                if(runUpdateBlock == 1)
                    actorUpdatingIndices[actorUpdatingIndex++] = 2047;
            } else if(movementType == 3) { // Map region changed
                int teleporting = IncomingPackets.incomingPacketBuffer.getBits(1);
                worldLevel = IncomingPackets.incomingPacketBuffer.getBits(2);
                int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                if(runUpdateBlock == 1)
                    actorUpdatingIndices[actorUpdatingIndex++] = 2047;
                int localChunkX = IncomingPackets.incomingPacketBuffer.getBits(7);
                int localChunkY = IncomingPackets.incomingPacketBuffer.getBits(7);
                localPlayer.method787(localChunkY, -7717, teleporting == 1, localChunkX);
            }
        }
    }

    public static void parseTrackedPlayerMovement() {
        int trackedPlayerCount = IncomingPackets.incomingPacketBuffer.getBits(8);
        if(trackedPlayerCount < localPlayerCount) {
            for(int i = trackedPlayerCount; localPlayerCount > i; i++)
                deregisterActorIndices[Class17.deregisterActorCount++] = trackedPlayerIndices[i];
        }
        if(localPlayerCount < trackedPlayerCount)
            throw new RuntimeException("gppov1");
        localPlayerCount = 0;
        for(int i = 0; (trackedPlayerCount > i); i++) {
            int trackedPlayerIndex = trackedPlayerIndices[i];
            Player player = (trackedPlayers[trackedPlayerIndex]);
            int updateRequired = IncomingPackets.incomingPacketBuffer.getBits(1);
            if(updateRequired == 0) {
                trackedPlayerIndices[localPlayerCount++] = trackedPlayerIndex;
                player.anInt3134 = pulseCycle;
            } else {
                int movementType = IncomingPackets.incomingPacketBuffer.getBits(2);
                if(movementType == 0) { // No movement
                    trackedPlayerIndices[localPlayerCount++] = trackedPlayerIndex;
                    player.anInt3134 = pulseCycle;
                    actorUpdatingIndices[actorUpdatingIndex++] = trackedPlayerIndex;
                } else if(movementType == 1) { // Walking
                    trackedPlayerIndices[localPlayerCount++] = trackedPlayerIndex;
                    player.anInt3134 = pulseCycle;
                    int walkDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                    player.method782(walkDirection, (byte) -96, false);
                    int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                    if(runUpdateBlock == 1)
                        actorUpdatingIndices[actorUpdatingIndex++] = trackedPlayerIndex;
                } else if(movementType == 2) { // Running
                    trackedPlayerIndices[localPlayerCount++] = trackedPlayerIndex;
                    player.anInt3134 = pulseCycle;
                    int walkDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                    player.method782(walkDirection, (byte) -96, true);
                    int runDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
                    player.method782(runDirection, (byte) -96, true);
                    int runUpdateBlock = IncomingPackets.incomingPacketBuffer.getBits(1);
                    if(runUpdateBlock == 1)
                        actorUpdatingIndices[actorUpdatingIndex++] = trackedPlayerIndex;
                } else if(movementType == 3)
                    deregisterActorIndices[Class17.deregisterActorCount++] = trackedPlayerIndex;
            }
        }
    }

    public static void registerNewPlayers() {
        while(IncomingPackets.incomingPacketBuffer.method510(IncomingPackets.incomingPacketSize) >= 11) {
            int newPlayerIndex = IncomingPackets.incomingPacketBuffer.getBits(11);
            if(newPlayerIndex == 2047)
                break;
            boolean bool = false;
            if((trackedPlayers[newPlayerIndex]) == null) {
                trackedPlayers[newPlayerIndex] = new Player();
                if(trackedPlayerAppearanceCache[newPlayerIndex] != null)
                    trackedPlayers[newPlayerIndex].parsePlayerAppearanceData(trackedPlayerAppearanceCache[newPlayerIndex]);
                bool = true;
            }
            trackedPlayerIndices[localPlayerCount++] = newPlayerIndex;
            Player player = (trackedPlayers[newPlayerIndex]);
            player.anInt3134 = pulseCycle;
            int offsetX = IncomingPackets.incomingPacketBuffer.getBits(5);
            int offsetY = IncomingPackets.incomingPacketBuffer.getBits(5);
            if(offsetX > 15)
                offsetX -= 32;
            if(offsetY > 15)
                offsetY -= 32;
            int initialFaceDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
            int faceDirection = (Class40_Sub5_Sub17_Sub1.directions[initialFaceDirection]);
            if(bool)
                player.anInt3080 = faceDirection;
            int updateRequired = IncomingPackets.incomingPacketBuffer.getBits(1);
            int discardWalkingQueue = IncomingPackets.incomingPacketBuffer.getBits(1);
            if(discardWalkingQueue == 1)
                actorUpdatingIndices[actorUpdatingIndex++] = newPlayerIndex;
            player.method787(offsetY + (localPlayer.pathX[0]), -7717, updateRequired == 1, (localPlayer.pathY[0]) + offsetX);
        }
        IncomingPackets.incomingPacketBuffer.finishBitAccess();

    }

    public Model getRotatedModel(int arg0) {
        if(aClass30_3282 == null)
            return null;
        AnimationSequence animationSequence = (playingAnimation == -1 || playingAnimationDelay != 0 ? null : Class68_Sub1.method1050(playingAnimation, 2));
        AnimationSequence animationSequence_0_ = ((anInt3077 != -1 && !aBoolean3287 && (idleAnimation != anInt3077 || animationSequence == null)) ? Class68_Sub1.method1050(anInt3077, 2) : null);
        Model class40_sub5_sub17_sub5 = aClass30_3282.getAnimatedModel(animationSequence, animationSequence_0_, anInt3116, anInt3104, (byte) -128);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        class40_sub5_sub17_sub5.method799();
        anInt3117 = class40_sub5_sub17_sub5.modelHeight;
        if(!aBoolean3287 && anInt3091 != -1 && anInt3140 != -1) {
            Model class40_sub5_sub17_sub5_1_ = SpotAnimDefinition.forId(anInt3091, 13).method549(anInt3140, 2);
            if(class40_sub5_sub17_sub5_1_ != null) {
                class40_sub5_sub17_sub5_1_.translate(0, -anInt3110, 0);
                Model[] class40_sub5_sub17_sub5s = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_1_};
                class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, 2, true);
            }
        }
        if(!aBoolean3287 && aClass40_Sub5_Sub17_Sub5_3265 != null) {
            if(anInt3274 <= Node.pulseCycle)
                aClass40_Sub5_Sub17_Sub5_3265 = null;
            if(anInt3283 <= Node.pulseCycle && Node.pulseCycle < anInt3274) {
                Model class40_sub5_sub17_sub5_2_ = aClass40_Sub5_Sub17_Sub5_3265;
                class40_sub5_sub17_sub5_2_.translate(-worldX + anInt3271, -anInt3276 + anInt3272, anInt3291 + -worldY);
                if(anInt3080 == 512) {
                    class40_sub5_sub17_sub5_2_.method813();
                    class40_sub5_sub17_sub5_2_.method813();
                    class40_sub5_sub17_sub5_2_.method813();
                } else if(anInt3080 == 1024) {
                    class40_sub5_sub17_sub5_2_.method813();
                    class40_sub5_sub17_sub5_2_.method813();
                } else if(anInt3080 == 1536)
                    class40_sub5_sub17_sub5_2_.method813();
                Model[] class40_sub5_sub17_sub5s = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_2_};
                class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, 2, true);
                if(anInt3080 != 512) {
                    if(anInt3080 == 1024) {
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                    } else if(anInt3080 == 1536) {
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                        class40_sub5_sub17_sub5_2_.method813();
                    }
                } else
                    class40_sub5_sub17_sub5_2_.method813();
                class40_sub5_sub17_sub5_2_.translate(-anInt3271 + worldX, -anInt3272 + anInt3276, worldY - anInt3291);
            }
        }
        class40_sub5_sub17_sub5.singleTile = true;
        return class40_sub5_sub17_sub5;
    }

    public boolean isVisible(int arg0) {
        if(arg0 != 1)
            method792(-71);
        return aClass30_3282 != null;
    }

    public void parsePlayerAppearanceData(Buffer buffer) {
        buffer.currentPosition = 0;
        int i = buffer.getUnsignedByte();
        isSkulled = buffer.getByte();
        headIcon = buffer.getByte();
        int npcDefId = -1;
        teamId = 0;
        int[] appearance = new int[12];
        for(int index = 0; index < 12; index++) {
            int upperByte = buffer.getUnsignedByte();
            if(upperByte == 0)
                appearance[index] = 0;
            else {
                int lowerByte = buffer.getUnsignedByte();
                appearance[index] = (upperByte << 8) + lowerByte;
                if(index == 0 && appearance[0] == 65535) {
                    npcDefId = buffer.getUnsignedShortBE();
                    break;
                }
                if(appearance[index] >= 512) {
                    int itemTeam = ItemDefinition.forId(-512 + appearance[index], 10).teamIndex;
                    if(itemTeam != 0)
                        teamId = itemTeam;
                }
            }
        }
        int[] appearanceColors = new int[5];
        for(int l = 0; l < 5; l++) {
            int j1 = buffer.getUnsignedByte();
            if(j1 < 0 || ((Class40_Sub5_Sub17_Sub6.playerColours[l]).length <= j1))
                j1 = 0;
            appearanceColors[l] = j1;
        }
        idleAnimation = buffer.getUnsignedShortBE();
        if(idleAnimation == 65535)
            idleAnimation = -1;
        standTurnAnimationId = buffer.getUnsignedShortBE();
        if(standTurnAnimationId == 65535)
            standTurnAnimationId = -1;
        anInt3083 = standTurnAnimationId;
        walkAnimationId = buffer.getUnsignedShortBE();
        if(walkAnimationId == 65535)
            walkAnimationId = -1;
        turnAroundAnimationId = buffer.getUnsignedShortBE();
        if(turnAroundAnimationId == 65535)
            turnAroundAnimationId = -1;
        turnRightAnimationId = buffer.getUnsignedShortBE();
        if(turnRightAnimationId == 65535)
            turnRightAnimationId = -1;
        turnLeftAnimationId = buffer.getUnsignedShortBE();
        if(turnLeftAnimationId == 65535)
            turnLeftAnimationId = -1;
        runAnimationId = buffer.getUnsignedShortBE();
        if(runAnimationId == 65535)
            runAnimationId = -1;
        playerName = Class60.method991(-127, buffer.getLongBE()).method85();
        combatLevel = buffer.getUnsignedByte();
        skillLevel = buffer.getUnsignedShortBE();
        if(aClass30_3282 == null)
            aClass30_3282 = new Class30();
        aClass30_3282.method380(appearance, i == 1, 7, appearanceColors, npcDefId);
    }
}
