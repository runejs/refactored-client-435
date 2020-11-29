package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class Player extends Actor {

    public static int anInt3264 = 0;
    public static int worldLevel;
    public static byte[] aByteArray3270;
    public static int[] viewportOffsets;
    public static int headIconDrawType = 0;
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
    public static boolean inTutorialIsland = false;
    public static Buffer chatBuffer = new Buffer(new byte[5000]);
    public static boolean cutsceneActive = false;
    public int skillLevel;
    public int anInt3258;
    public int combatLevel = 0;
    public int anInt3262;
    public Model playerModel;
    public int teamId = 0;
    public int isSkulled;
    public int anInt3271;
    public int anInt3272;
    public int headIcon;
    public int anInt3274;
    public int anInt3276;
    public String playerName;
    public int anInt3281;
    public PlayerAppearance playerAppearance;
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

    public static void drawGameScreenGraphics(int arg0) {
        try {
            if(arg0 < 106)
                return;
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            VarbitDefinition.gameScreenImageProducer.drawGraphics(ScreenController.frameMode == ScreenMode.FIXED ? 4 : 0, ScreenController.frameMode == ScreenMode.FIXED ? 4 : 0, graphics);
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



    public static void parsePlayerUpdateMasks(Player player, int mask, int playerIndex) {
        if((0x100 & mask) != 0) { // damage/hitsplat 1
            int damageType1 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int damageType2 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.method785(damageType2, pulseCycle, damageType1);
            player.anInt3139 = 300 + pulseCycle;
            player.remainingHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.maximumHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
        }
        if((mask & 0x10) != 0) { // face position
            player.facePositionX = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            player.facePositionY = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
        }
        if((mask & 0x1) != 0) { // animation
            int animationId = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            if(animationId == 65535)
                animationId = -1;
            int animationDelay = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            ActorDefinition.playAnimation(animationId, animationDelay, player);
        }
        if((mask & 0x4) != 0) { // face actor
            player.facingActorIndex = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            if(player.facingActorIndex == 65535)
                player.facingActorIndex = -1;
        }
        if((0x40 & mask) != 0) { // damage/hitsplat 2
            int damageType1 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int damageType2 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.method785(damageType2, pulseCycle, damageType1);
            player.anInt3139 = 300 + pulseCycle;
            player.remainingHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.maximumHitpoints = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
        }
        if((mask & 0x400) != 0) { // Forced movement?
            player.anInt3125 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3081 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3099 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3127 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.anInt3112 = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE() + pulseCycle;
            player.anInt3107 = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE() + pulseCycle;
            player.anInt3073 = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            player.method790(0);
        }
        if((0x8 & mask) != 0) { // chat
            int chatEffectsAndColors = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int playerRights = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int messageLength = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int bufferPosition = IncomingPackets.incomingPacketBuffer.currentPosition;
            if(player.playerName != null && player.playerAppearance != null) {
                long l = RSString.nameToLong(player.playerName);
                boolean bool = false;
                if(playerRights <= 1) {
                    for(int i = 0; i < Class42.anInt1008; i++) {
                        if(l == WallDecoration.ignores[i]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && !inTutorialIsland) {
                    chatBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacketBuffer.getBytes(0, messageLength, chatBuffer.buffer);
                    chatBuffer.currentPosition = 0;
                    String incomming = KeyFocusListener.method956(124, IncomingPackets.incomingPacketBuffer);
                    String class1 = RSString.formatChatString(incomming);
                    player.forcedChatMessage = class1.trim();
                    player.anInt3078 = 150;
                    player.chatEffects = chatEffectsAndColors & 0xff;
                    player.chatcolor = chatEffectsAndColors >> 8;
                    if(playerRights == 2 || playerRights == 3)
                        Class44.addChatMessage(Native.goldCrown + player.playerName, class1, 1);
                    else if(playerRights == 1)
                        Class44.addChatMessage(Native.whiteCrown + player.playerName, class1, 1);
                    else
                        Class44.addChatMessage(player.playerName, class1, 2);
                }
            }
            IncomingPackets.incomingPacketBuffer.currentPosition = messageLength + bufferPosition;
        }
        if((0x20 & mask) != 0) { // appearance
            int appearanceUpdateLength = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            byte[] is = new byte[appearanceUpdateLength];
            Buffer buffer = new Buffer(is);
            IncomingPackets.incomingPacketBuffer.getBytes(appearanceUpdateLength, 0, is);
            trackedPlayerAppearanceCache[playerIndex] = buffer;
            player.parsePlayerAppearanceData(buffer);
        }
        if((mask & 0x200) != 0) { // graphics
            player.graphicId = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            int graphicData = IncomingPackets.incomingPacketBuffer.getIntBE();
            player.anInt3129 = 0;
            player.graphicDelay = pulseCycle + (graphicData & 0xffff);
            if(player.graphicId == 65535)
                player.graphicId = -1;
            player.anInt3140 = 0;
            player.graphicHeight = graphicData >> 16;
            if(player.graphicDelay > pulseCycle)
                player.anInt3140 = -1;
        }
        if((0x80 & mask) != 0) { // forced chat
            player.forcedChatMessage = IncomingPackets.incomingPacketBuffer.getString();
            if(player.forcedChatMessage.charAt(0) == 126) {
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
            Player player = trackedPlayers[trackedPlayerIndex];
            int mask = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            if((mask & 0x2) != 0)
                mask += IncomingPackets.incomingPacketBuffer.getUnsignedByte() << 8;
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
        for(int i = 0; trackedPlayerCount > i; i++) {
            int trackedPlayerIndex = trackedPlayerIndices[i];
            Player player = trackedPlayers[trackedPlayerIndex];
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
        while(IncomingPackets.incomingPacketBuffer.getRemainingBits(IncomingPackets.incomingPacketSize) >= 11) {
            int newPlayerIndex = IncomingPackets.incomingPacketBuffer.getBits(11);
            if(newPlayerIndex == 2047)
                break;
            boolean bool = false;
            if(trackedPlayers[newPlayerIndex] == null) {
                trackedPlayers[newPlayerIndex] = new Player();
                if(trackedPlayerAppearanceCache[newPlayerIndex] != null)
                    trackedPlayers[newPlayerIndex].parsePlayerAppearanceData(trackedPlayerAppearanceCache[newPlayerIndex]);
                bool = true;
            }
            trackedPlayerIndices[localPlayerCount++] = newPlayerIndex;
            Player player = trackedPlayers[newPlayerIndex];
            player.anInt3134 = pulseCycle;
            int offsetX = IncomingPackets.incomingPacketBuffer.getBits(5);
            int offsetY = IncomingPackets.incomingPacketBuffer.getBits(5);
            if(offsetX > 15)
                offsetX -= 32;
            if(offsetY > 15)
                offsetY -= 32;
            int initialFaceDirection = IncomingPackets.incomingPacketBuffer.getBits(3);
            int faceDirection = Class40_Sub5_Sub17_Sub1.directions[initialFaceDirection];
            if(bool)
                player.initialFaceDirection = faceDirection;
            int updateRequired = IncomingPackets.incomingPacketBuffer.getBits(1);
            int discardWalkingQueue = IncomingPackets.incomingPacketBuffer.getBits(1);
            if(discardWalkingQueue == 1)
                actorUpdatingIndices[actorUpdatingIndex++] = newPlayerIndex;
            player.method787(offsetY + localPlayer.pathX[0], -7717, updateRequired == 1, localPlayer.pathY[0] + offsetX);
        }
        IncomingPackets.incomingPacketBuffer.finishBitAccess();

    }

    public static void setTutorialIslandFlag() {
        inTutorialIsland = false;
        int xPos = (localPlayer.worldX >> 7) + SpotAnimDefinition.baseX;
        int yPos = Class26.baseY + (localPlayer.worldY >> 7);
        if(xPos >= 3053 && xPos <= 3156 && yPos >= 3056 && yPos <= 3136)
            inTutorialIsland = true;
        if(xPos >= 3072 && xPos <= 3118 && yPos >= 9492 && yPos <= 9535)
            inTutorialIsland = true;
        if(inTutorialIsland  && xPos >= 3139 && xPos <= 3199 && yPos >= 3008 && yPos <= 3062)
            inTutorialIsland = false;
    }

    public static RSString longToUsername(long arg1) {
        if(arg1 <= 0L || arg1 >= 6582952005840035281L)
            return null;
        if(arg1 % 37L == 0)
            return null;
        long l = arg1;
        int i = 0;
        while(l != 0) {
            l /= 37L;
            i++;
        }
        byte[] is = new byte[i];
        while(arg1 != 0) {
            long l_10_ = arg1;
            arg1 /= 37L;
            is[--i] = CollisionMap.aByteArray169[(int) (-(arg1 * 37L) + l_10_)];
        }
        RSString class1 = new RSString();
        class1.chars = is;
        class1.length = is.length;
        return class1;
    }

    public static void processPlayerMenuOptions(Player player, int x, int y, int index) {
        if (localPlayer != player && ActorDefinition.menuActionRow < 400) {
            String rsString;
            if (player.skillLevel == 0)
                rsString = player.playerName + SceneTile.getCombatLevelColour(localPlayer.combatLevel, player.combatLevel) + Native.aClass1_569 + English.prefixLevel + player.combatLevel + Native.aClass1_1199;
            else
                rsString = player.playerName + Native.aClass1_569 + English.prefixSkill + player.skillLevel + Native.aClass1_1199;
            if (Class8.itemSelected == 1) {
                OverlayDefinition.addActionRow(English.use, index, x, y, 22, Native.aClass1_3295 + Native.aClass1_3068 + rsString);
            } else if (Main.widgetSelected == 1) {
                if ((ItemDefinition.selectedMask & 0x8) == 8) {
                    OverlayDefinition.addActionRow(Native.aClass1_1918, index, x, y, 1, Native.aClass1_611 + Native.aClass1_3068 + rsString);
                }
            } else {
                for (int i = 4; i >= 0; i--) {
                    if (Main.playerActions[i] != null) {
                        int i_16_ = 0;
                        int i_17_ = 0;
                        if (Main.playerActions[i].equalsIgnoreCase(English.attack)) {
                            if (localPlayer.combatLevel < player.combatLevel)
                                i_17_ = 2000;
                            if (localPlayer.teamId != 0 && player.teamId != 0) {
                                if (localPlayer.teamId != player.teamId)
                                    i_17_ = 0;
                                else
                                    i_17_ = 2000;
                            }
                        } else if (Class13.playerArray[i])
                            i_17_ = 2000;
                        if (i == 0)
                            i_16_ = 10 + i_17_;
                        if (i == 1)
                            i_16_ = 39 + i_17_;
                        if (i == 2)
                            i_16_ = i_17_ + 44;
                        if (i == 3)
                            i_16_ = i_17_ + 14;
                        if (i == 4)
                            i_16_ = 41 + i_17_;
                        OverlayDefinition.addActionRow(Main.playerActions[i], index, x, y, i_16_, Native.aClass1_620 + rsString);
                    }
                }
            }
            for (int i = 0; i < ActorDefinition.menuActionRow; i++) {
                if (MovedStatics.menuActionTypes[i] == 7) {
                    Landscape.menuActionTexts[i] = English.walkHere + Native.aClass1_1117 + Native.aClass1_620 + rsString;
                    break;
                }
            }
        }

    }

    public Model getRotatedModel() {
        if(playerAppearance == null)
            return null;
        AnimationSequence animationSequence = playingAnimation == -1 || playingAnimationDelay != 0 ? null : ProducingGraphicsBuffer_Sub1.method1050(playingAnimation, 2);
        AnimationSequence animationSequence_0_ = anInt3077 != -1 && !aBoolean3287 && (idleAnimation != anInt3077 || animationSequence == null) ? ProducingGraphicsBuffer_Sub1.method1050(anInt3077, 2) : null;
        Model animatedModel = playerAppearance.getAnimatedModel(animationSequence, animationSequence_0_, anInt3116, anInt3104);
        if(animatedModel == null)
            return null;
        animatedModel.method799();
        anInt3117 = animatedModel.modelHeight;
        if(!aBoolean3287 && graphicId != -1 && anInt3140 != -1) {
            Model model = SpotAnimDefinition.forId(graphicId, 13).method549(anInt3140, 2);
            if(model != null) {
                model.translate(0, -graphicHeight, 0);
                Model[] models = {animatedModel, model};
                animatedModel = new Model(models, 2, true);
            }
        }
        if(!aBoolean3287 && playerModel != null) {
            if(anInt3274 <= Node.pulseCycle)
                playerModel = null;
            if(anInt3283 <= Node.pulseCycle && Node.pulseCycle < anInt3274) {
                Model model = playerModel;
                model.translate(-worldX + anInt3271, -anInt3276 + anInt3272, anInt3291 + -worldY);
                if(initialFaceDirection == 512) {
                    model.method813();
                    model.method813();
                    model.method813();
                } else if(initialFaceDirection == 1024) {
                    model.method813();
                    model.method813();
                } else if(initialFaceDirection == 1536)
                    model.method813();
                Model[] models = {animatedModel, model};
                animatedModel = new Model(models, 2, true);
                if(initialFaceDirection != 512) {
                    if(initialFaceDirection == 1024) {
                        model.method813();
                        model.method813();
                    } else if(initialFaceDirection == 1536) {
                        model.method813();
                        model.method813();
                        model.method813();
                    }
                } else
                    model.method813();
                model.translate(-anInt3271 + worldX, -anInt3272 + anInt3276, worldY - anInt3291);
            }
        }
        animatedModel.singleTile = true;
        return animatedModel;
    }

    public boolean isVisible(int arg0) {
        return playerAppearance != null;
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
            if(j1 < 0 || PlayerAppearance.playerColours[l].length <= j1)
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
        playerName = longToUsername(buffer.getLongBE()).method85().toString();
        combatLevel = buffer.getUnsignedByte();
        skillLevel = buffer.getUnsignedShortBE();

        if(playerAppearance == null)
            playerAppearance = new PlayerAppearance();

        playerAppearance.setPlayerAppearance(appearance, i == 1, appearanceColors, npcDefId);
    }
}
