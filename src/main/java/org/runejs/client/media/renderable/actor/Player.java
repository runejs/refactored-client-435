package org.runejs.client.media.renderable.actor;

import org.runejs.client.*;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.util.CollisionMap;

import java.awt.*;

public class Player extends Actor {

    public static int worldLevel;
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
    public static int[] playerExperience = new int[25];
    public static int[] playerLevels = new int[25];
    public static int[] nextLevels = new int[25];
    public static int[] experienceForLevels = new int[99];
    public static long[] privateMessageIds = new long[100];
    public static long[] ignores = new long[100];
    public static int privateMessageIndex = 0;
    public static int[] friendWorlds = new int[200];
    public static int friendListStatus = 0;
    public static int worldId = 1;
    public static int friendsCount = 0;
    public static PlayerAppearance activePlayerAppearance = new PlayerAppearance();
    public static int[] tabWidgetIds = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static int currentTabId = 3;
    public static String[] friendUsernames = new String[200];
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

    static {
        int i = 0;
        for(int idx = 0; idx < 99; idx++) {
            int skillLevel = idx + 1;
            int experienceForLevel = (int) ((double) skillLevel + 300.0 * Math.pow(2.0, (double) skillLevel / 7.0));
            i += experienceForLevel;
            Player.experienceForLevels[idx] = i / 4;
        }
    }

    public Player() {
        skillLevel = 0;
        headIcon = -1;
        isSkulled = -1;
        anInt3274 = 0;
        anInt3283 = 0;
        aBoolean3287 = false;
    }

    public static void drawGameScreenGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            MovedStatics.gameScreenImageProducer.drawGraphics(ScreenController.frameMode == ScreenMode.FIXED ? 4 : 0, ScreenController.frameMode == ScreenMode.FIXED ? 4 : 0, graphics);
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static boolean method793(int arg1) {
        // something to do with checking for valid (typable?) keycodes
        if(arg1 < 32)
            return false;
        if(arg1 == 127)
            return false;
        return arg1 < 129 || arg1 > 159;
    }



    public static void parsePlayerUpdateMasks(PacketBuffer appearanceBuffer, Player player, int mask, int playerIndex) {
        if((0x100 & mask) != 0) { // damage/hitsplat 1
            int damageType1 = appearanceBuffer.getUnsignedByte();
            int damageType2 = appearanceBuffer.getUnsignedByte();
            player.method785(damageType2, MovedStatics.pulseCycle, damageType1);
            player.anInt3139 = 300 + MovedStatics.pulseCycle;
            player.remainingHitpoints = appearanceBuffer.getUnsignedByte();
            player.maximumHitpoints = appearanceBuffer.getUnsignedByte();
        }
        if((mask & 0x10) != 0) { // face position
            player.facePositionX = appearanceBuffer.getUnsignedShortBE();
            player.facePositionY = appearanceBuffer.getUnsignedShortLE();
        }
        if((mask & 0x1) != 0) { // animation
            int animationId = appearanceBuffer.getUnsignedShortLE();
            if(animationId == 65535)
                animationId = -1;
            int animationDelay = appearanceBuffer.getUnsignedByte();
            ActorDefinition.playAnimation(animationId, animationDelay, player);
        }
        if((mask & 0x4) != 0) { // face actor
            player.facingActorIndex = appearanceBuffer.getUnsignedShortBE();
            if(player.facingActorIndex == 65535)
                player.facingActorIndex = -1;
        }
        if((0x40 & mask) != 0) { // damage/hitsplat 2
            int damageType1 = appearanceBuffer.getUnsignedByte();
            int damageType2 = appearanceBuffer.getUnsignedByte();
            player.method785(damageType2, MovedStatics.pulseCycle, damageType1);
            player.anInt3139 = 300 + MovedStatics.pulseCycle;
            player.remainingHitpoints = appearanceBuffer.getUnsignedByte();
            player.maximumHitpoints = appearanceBuffer.getUnsignedByte();
        }
        if((mask & 0x400) != 0) { // Forced movement?
            player.forceMoveStartX = appearanceBuffer.getUnsignedByte();
            player.forceMoveStartY = appearanceBuffer.getUnsignedByte();
            player.forceMoveEndX = appearanceBuffer.getUnsignedByte();
            player.forceMoveEndY = appearanceBuffer.getUnsignedByte();
            player.forceMoveEndCycle = appearanceBuffer.getUnsignedShortBE() + MovedStatics.pulseCycle;
            player.forceMoveStartCycle = appearanceBuffer.getUnsignedShortLE() + MovedStatics.pulseCycle;
            player.forceMoveFaceDirection = appearanceBuffer.getUnsignedByte();
            player.method790(0);
        }
        if((0x8 & mask) != 0) { // chat
            int chatEffectsAndColors = appearanceBuffer.getUnsignedShortBE();
            int playerRights = appearanceBuffer.getUnsignedByte();
            int messageLength = appearanceBuffer.getUnsignedByte();
            int bufferPosition = appearanceBuffer.currentPosition;
            if(player.playerName != null && player.playerAppearance != null) {
                long l = RSString.nameToLong(player.playerName);
                boolean bool = false;
                if(playerRights <= 1) {
                    for(int i = 0; i < MovedStatics.anInt1008; i++) {
                        if(l == ignores[i]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && !inTutorialIsland) {
                    chatBuffer.currentPosition = 0;
                    appearanceBuffer.getBytes(0, messageLength, chatBuffer.buffer);
                    chatBuffer.currentPosition = 0;
                    String incomming = KeyFocusListener.method956(appearanceBuffer);
                    String class1 = RSString.formatChatString(incomming);
                    player.forcedChatMessage = class1.trim();
                    player.anInt3078 = 150;
                    player.chatEffects = chatEffectsAndColors & 0xff;
                    player.chatcolor = chatEffectsAndColors >> 8;
                    if(playerRights == 2 || playerRights == 3)
                        ChatBox.addChatMessage(Native.goldCrown + player.playerName, class1, 1);
                    else if(playerRights == 1)
                        ChatBox.addChatMessage(Native.whiteCrown + player.playerName, class1, 1);
                    else
                        ChatBox.addChatMessage(player.playerName, class1, 2);
                }
            }
            appearanceBuffer.currentPosition = messageLength + bufferPosition;
        }
        if((0x20 & mask) != 0) { // appearance
            int appearanceUpdateLength = appearanceBuffer.getUnsignedByte();
            byte[] is = new byte[appearanceUpdateLength];
            Buffer buffer = new Buffer(is);
            appearanceBuffer.getBytes(appearanceUpdateLength, 0, is);
            trackedPlayerAppearanceCache[playerIndex] = buffer;
            player.parsePlayerAppearanceData(buffer);
        }
        if((mask & 0x200) != 0) { // graphics
            player.graphicId = appearanceBuffer.getUnsignedShortLE();
            int graphicData = appearanceBuffer.getIntBE();
            player.anInt3129 = 0;
            player.graphicDelay = MovedStatics.pulseCycle + (graphicData & 0xffff);
            if(player.graphicId == 65535)
                player.graphicId = -1;
            player.anInt3140 = 0;
            player.graphicHeight = graphicData >> 16;
            if(player.graphicDelay > MovedStatics.pulseCycle)
                player.anInt3140 = -1;
        }
        if((0x80 & mask) != 0) { // forced chat
            player.forcedChatMessage = appearanceBuffer.getString();
            if(player.forcedChatMessage.charAt(0) == 126) {
                player.forcedChatMessage = player.forcedChatMessage.substring(1);
                ChatBox.addChatMessage(player.playerName, player.forcedChatMessage, 2);
            } else if(player == localPlayer)
                ChatBox.addChatMessage(player.playerName, player.forcedChatMessage, 2);
            player.anInt3078 = 150;
            player.chatcolor = 0;
            player.chatEffects = 0;
        }
    }

    public static void parseTrackedPlayerUpdateMasks(PacketBuffer appearanceBuffer) {
        for(int i = 0; i < actorUpdatingIndex; i++) {
            int trackedPlayerIndex = actorUpdatingIndices[i];
            Player player = trackedPlayers[trackedPlayerIndex];
            int mask = appearanceBuffer.getUnsignedByte();
            if((mask & 0x2) != 0)
                mask += appearanceBuffer.getUnsignedByte() << 8;
            parsePlayerUpdateMasks(appearanceBuffer, player, mask, trackedPlayerIndex);
        }
    }

    public static void setTutorialIslandFlag() {
        inTutorialIsland = false;
        int xPos = (localPlayer.worldX >> 7) + MovedStatics.baseX;
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
        if (localPlayer != player && MovedStatics.menuActionRow < 400) {
            String playerDisplayName;
            if (player.skillLevel == 0)
                playerDisplayName = player.playerName + SceneTile.getCombatLevelColour(localPlayer.combatLevel, player.combatLevel) + Native.leftParenthesisWithSpacePrefix + English.prefixLevel + player.combatLevel + Native.rightParenthesis;
            else
                playerDisplayName = player.playerName + Native.leftParenthesisWithSpacePrefix + English.prefixSkill + player.skillLevel + Native.rightParenthesis;
            if (MovedStatics.itemSelected == 1) {
                MovedStatics.addActionRow(English.use, index, x, y, ActionRowType.USE_ITEM_ON_PLAYER.getId(), Native.selectedItemName + Native.arrowActionOnOther + playerDisplayName);
            } else if (Main.widgetSelected == 1) {
                if ((MovedStatics.selectedMask & 0x8) == 8) {
                    MovedStatics.addActionRow(Native.selectedSpellVerb, index, x, y, ActionRowType.CAST_MAGIC_ON_PLAYER.getId(), Native.selectedSpellName + Native.arrowActionOnOther + playerDisplayName);
                }
            } else {
                for (int i = 4; i >= 0; i--) {
                    if (Main.playerActions[i] != null) {
                        int actionType = 0;
                        int actionRowOffset = 0;

                        if (Main.playerActions[i].equalsIgnoreCase(English.attack)) {
                            // offset attack actions so that they are lower priority for players of higher combat lvl or the same team
                            if (localPlayer.combatLevel < player.combatLevel)
                                actionRowOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
                            if (localPlayer.teamId != 0 && player.teamId != 0) {
                                if (localPlayer.teamId != player.teamId)
                                    actionRowOffset = 0;
                                else
                                    actionRowOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
                            }
                        } else if (Class13.playerArray[i]) {
                            // what is this for?
                            actionRowOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
                        }

                        if (i == 0)
                            actionType = ActionRowType.INTERACT_WITH_PLAYER_OPTION_1.getId() + actionRowOffset;
                        if (i == 1)
                            actionType = ActionRowType.INTERACT_WITH_PLAYER_OPTION_2.getId() + actionRowOffset;
                        if (i == 2)
                            actionType = ActionRowType.INTERACT_WITH_PLAYER_OPTION_3.getId() + actionRowOffset;
                        if (i == 3)
                            actionType = ActionRowType.INTERACT_WITH_PLAYER_OPTION_4.getId() + actionRowOffset;
                        if (i == 4)
                            actionType = ActionRowType.INTERACT_WITH_PLAYER_OPTION_5.getId() + actionRowOffset;
                        MovedStatics.addActionRow(Main.playerActions[i], index, x, y, actionType, Native.white + playerDisplayName);
                    }
                }
            }
            for (int i = 0; i < MovedStatics.menuActionRow; i++) {
                if (MovedStatics.menuActionTypes[i] == 7) {
                    Landscape.menuActionTexts[i] = English.walkHere + Native.whitespace + Native.white + playerDisplayName;
                    break;
                }
            }
        }

    }

    public static boolean hasFriend(String arg0) {
        if(arg0 == null)
            return false;
        for(int i = 0; i < friendsCount; i++) {
            if(arg0.equalsIgnoreCase(friendUsernames[i]))
                return true;
        }
        return arg0.equalsIgnoreCase(localPlayer.playerName);
    }

    public Model getRotatedModel() {
        if(playerAppearance == null)
            return null;
        AnimationSequence animationSequence = playingAnimation == -1 || playingAnimationDelay != 0 ? null : ProducingGraphicsBuffer_Sub1.getAnimationSequence(playingAnimation);
        AnimationSequence animationSequence_0_ = anInt3077 != -1 && !aBoolean3287 && (idleAnimation != anInt3077 || animationSequence == null) ? ProducingGraphicsBuffer_Sub1.getAnimationSequence(anInt3077) : null;
        Model animatedModel = playerAppearance.getAnimatedModel(animationSequence, animationSequence_0_, anInt3116, anInt3104);
        if(animatedModel == null)
            return null;
        animatedModel.method799();
        anInt3117 = animatedModel.modelHeight;
        if(!aBoolean3287 && graphicId != -1 && anInt3140 != -1) {
            Model model = SpotAnimDefinition.forId(graphicId).getModel(anInt3140);
            if(model != null) {
                model.translate(0, -graphicHeight, 0);
                Model[] models = {animatedModel, model};
                animatedModel = new Model(models, 2, true);
            }
        }
        if(!aBoolean3287 && playerModel != null) {
            if(anInt3274 <= MovedStatics.pulseCycle)
                playerModel = null;
            if(anInt3283 <= MovedStatics.pulseCycle && MovedStatics.pulseCycle < anInt3274) {
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

    public boolean isInitialized() {
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
