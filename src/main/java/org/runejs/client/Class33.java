package org.runejs.client;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.chat.ChatColorEffect;
import org.runejs.client.chat.ChatShapeEffect;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.FloorDecoration;

public class Class33 {
    public static int anInt784 = 0;
    public static int[] selectedMenuActions = new int[500];


    public static void method404() {
        SceneCluster.anInt770 = 0;
        for(int i = -1; Player.localPlayerCount + Player.npcCount > i; i++) {
            Actor actor;
            if(i == -1)
                actor = Player.localPlayer;
            else if(i < Player.localPlayerCount)
                actor = Player.trackedPlayers[Player.trackedPlayerIndices[i]];
            else
                actor = Player.npcs[Player.npcIds[i + -Player.localPlayerCount]];
            if(actor != null && actor.isInitialized()) {
                if(actor instanceof Npc) {
                    ActorDefinition actorDefinition = ((Npc) actor).actorDefinition;
                    if(actorDefinition.childIds != null)
                        actorDefinition = actorDefinition.getChildDefinition();
                    if(actorDefinition == null)
                        continue;
                }
                if(Player.localPlayerCount <= i) {
                    ActorDefinition class40_sub5_sub5 = ((Npc) actor).actorDefinition;
                    if(class40_sub5_sub5.headIcon >= 0 && class40_sub5_sub5.headIcon < ProducingGraphicsBuffer_Sub1.headIconSprites.length) {
                        FloorDecoration.method342(actor.anInt3117 + 15, actor);
                        if(ISAAC.anInt522 > -1)
                            ProducingGraphicsBuffer_Sub1.headIconSprites[class40_sub5_sub5.headIcon].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -30);
                    }
                    if(Player.headIconDrawType == 1 && HuffmanEncoding.anInt1545 == Player.npcIds[-Player.localPlayerCount + i] && MovedStatics.pulseCycle % 20 < 10) {
                        FloorDecoration.method342(15 + actor.anInt3117, actor);
                        if(ISAAC.anInt522 > -1)
                            MovedStatics.hintIconSprites[0].drawImage(ISAAC.anInt522 + -12, Class44.anInt1048 + -28);
                    }
                } else {
                    Player class40_sub5_sub17_sub4_sub1 = (Player) actor;
                    int i_0_ = 30;
                    if(class40_sub5_sub17_sub4_sub1.isSkulled != -1 || class40_sub5_sub17_sub4_sub1.headIcon != -1) {
                        FloorDecoration.method342(15 + actor.anInt3117, actor);
                        if(ISAAC.anInt522 > -1) {
                            if(class40_sub5_sub17_sub4_sub1.isSkulled != -1) {
                                FloorDecoration.aClass40_Sub5_Sub14_Sub4Array603[class40_sub5_sub17_sub4_sub1.isSkulled].drawImage(ISAAC.anInt522 - 12, Class44.anInt1048 - i_0_);
                                i_0_ += 25;
                            }
                            if(class40_sub5_sub17_sub4_sub1.headIcon != -1) {
                                ProducingGraphicsBuffer_Sub1.headIconSprites[class40_sub5_sub17_sub4_sub1.headIcon].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                                i_0_ += 25;
                            }
                        }
                    }
                    if(i >= 0 && Player.headIconDrawType == 10 && ProducingGraphicsBuffer.anInt1623 == Player.trackedPlayerIndices[i]) {
                        FloorDecoration.method342(actor.anInt3117 + 15, actor);
                        if(ISAAC.anInt522 > -1)
                            MovedStatics.hintIconSprites[1].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                    }
                }
                if(actor.forcedChatMessage != null && (i >= Player.localPlayerCount || ChatBox.publicChatMode == 0 || ChatBox.publicChatMode == 3 || ChatBox.publicChatMode == 1 && Player.hasFriend(((Player) actor).playerName))) {
                    FloorDecoration.method342(actor.anInt3117, actor);
                    if(ISAAC.anInt522 > -1 && 50 > SceneCluster.anInt770) {
                        PlayerAppearance.anIntArray680[SceneCluster.anInt770] = TypeFace.fontBold.getStringWidth(actor.forcedChatMessage) / 2;
                        PlayerAppearance.anIntArray688[SceneCluster.anInt770] = TypeFace.fontBold.characterDefaultHeight;
                        PlayerAppearance.anIntArray715[SceneCluster.anInt770] = ISAAC.anInt522;
                        PlayerAppearance.anIntArray685[SceneCluster.anInt770] = Class44.anInt1048;
                        PlayerAppearance.overheadChatColor[SceneCluster.anInt770] = actor.chatcolor;
                        PlayerAppearance.overheadChatShape[SceneCluster.anInt770] = actor.chatEffects;
                        PlayerAppearance.anIntArray684[SceneCluster.anInt770] = actor.anInt3078;
                        PlayerAppearance.overheadChatMessage[SceneCluster.anInt770] = actor.forcedChatMessage;
                        SceneCluster.anInt770++;
                    }
                }
                if(MovedStatics.pulseCycle < actor.anInt3139) {
                    FloorDecoration.method342(actor.anInt3117 + 15, actor);
                    if(ISAAC.anInt522 > -1) {
                        int i_1_ = 30 * actor.remainingHitpoints / actor.maximumHitpoints;
                        if(i_1_ > 30)
                            i_1_ = 30;
                        Rasterizer.drawFilledRectangle(-15 + ISAAC.anInt522, Class44.anInt1048 + -3, i_1_, 5, 65280);
                        Rasterizer.drawFilledRectangle(-15 + ISAAC.anInt522 + i_1_, Class44.anInt1048 + -3, 30 + -i_1_, 5, 16711680);
                    }
                }
                for(int i_2_ = 0; i_2_ < 4; i_2_++) {
                    if(MovedStatics.pulseCycle < actor.anIntArray3136[i_2_]) {
                        FloorDecoration.method342(actor.anInt3117 / 2, actor);
                        if(ISAAC.anInt522 > -1) {
                            if(i_2_ == 1)
                                Class44.anInt1048 -= 20;
                            if(i_2_ == 2) {
                                ISAAC.anInt522 -= 15;
                                Class44.anInt1048 -= 10;
                            }
                            if(i_2_ == 3) {
                                ISAAC.anInt522 += 15;
                                Class44.anInt1048 -= 10;
                            }
                            AnimationSequence.aClass40_Sub5_Sub14_Sub4Array2474[actor.anIntArray3086[i_2_]].drawImage(ISAAC.anInt522 + -12, -12 + Class44.anInt1048);
                            TypeFace.fontSmall.drawStringLeft(Integer.toString(actor.anIntArray3087[i_2_]), ISAAC.anInt522, 4 + Class44.anInt1048, 0);
                            TypeFace.fontSmall.drawStringLeft(Integer.toString(actor.anIntArray3087[i_2_]), ISAAC.anInt522 - 1, Class44.anInt1048 + 3, 16777215);
                        }
                    }
                }
            }
        }
        for(int i = 0; SceneCluster.anInt770 > i; i++) {
            int i_3_ = PlayerAppearance.anIntArray715[i];
            int i_4_ = PlayerAppearance.anIntArray685[i];
            int i_5_ = PlayerAppearance.anIntArray680[i];
            int i_6_ = PlayerAppearance.anIntArray688[i];
            boolean bool = true;
            while(bool) {
                bool = false;
                for(int i_7_ = 0; i > i_7_; i_7_++) {
                    if(-PlayerAppearance.anIntArray688[i_7_] + PlayerAppearance.anIntArray685[i_7_] < i_4_ + 2 && -i_6_ + i_4_ < 2 + PlayerAppearance.anIntArray685[i_7_] && PlayerAppearance.anIntArray715[i_7_] + PlayerAppearance.anIntArray680[i_7_] > -i_5_ + i_3_ && i_5_ + i_3_ > -PlayerAppearance.anIntArray680[i_7_] + PlayerAppearance.anIntArray715[i_7_] && -PlayerAppearance.anIntArray688[i_7_] + PlayerAppearance.anIntArray685[i_7_] < i_4_) {
                        bool = true;
                        i_4_ = -PlayerAppearance.anIntArray688[i_7_] + PlayerAppearance.anIntArray685[i_7_];
                    }
                }
            }
            ISAAC.anInt522 = PlayerAppearance.anIntArray715[i];
            Class44.anInt1048 = PlayerAppearance.anIntArray685[i] = i_4_;
            String message = PlayerAppearance.overheadChatMessage[i];
            if(MovedStatics.chatEffectsDisabled == 0) {
                int textColor = MovedStatics.OVERHEAD_CHAT_COLORS[0];
                // standard 6 colors (yellow, red, green, cyan, purple, white)
                // TODO (James) tie this into the ChatColorEffect enum
                if(PlayerAppearance.overheadChatColor[i] < 6)
                    textColor = MovedStatics.OVERHEAD_CHAT_COLORS[PlayerAppearance.overheadChatColor[i]];
                if(PlayerAppearance.overheadChatColor[i] == ChatColorEffect.FLASH1.getNetworkCode())
                    textColor = MovedStatics.anInt2628 % 20 >= 10 ? MovedStatics.OVERHEAD_CHAT_COLORS[0] : MovedStatics.OVERHEAD_CHAT_COLORS[1];
                if(PlayerAppearance.overheadChatColor[i] == ChatColorEffect.FLASH2.getNetworkCode())
                    textColor = MovedStatics.anInt2628 % 20 < 10 ? 255 : MovedStatics.OVERHEAD_CHAT_COLORS[3];
                if(PlayerAppearance.overheadChatColor[i] == ChatColorEffect.FLASH3.getNetworkCode())
                    textColor = MovedStatics.anInt2628 % 20 >= 10 ? 8454016 : 45056;
                if(PlayerAppearance.overheadChatColor[i] == ChatColorEffect.GLOW1.getNetworkCode()) {
                    int i_9_ = 150 - PlayerAppearance.anIntArray684[i];
                    if(i_9_ >= 50) {
                        if(i_9_ < 100)
                            textColor = -((-50 + i_9_) * 327680) + MovedStatics.OVERHEAD_CHAT_COLORS[0];
                        else if(i_9_ < 150)
                            textColor = MovedStatics.OVERHEAD_CHAT_COLORS[2] + 5 * (i_9_ + -100);
                    } else
                        textColor = MovedStatics.OVERHEAD_CHAT_COLORS[1] + 1280 * i_9_;
                }
                if(PlayerAppearance.overheadChatColor[i] == ChatColorEffect.GLOW2.getNetworkCode()) {
                    int i_10_ = 150 + -PlayerAppearance.anIntArray684[i];
                    if(i_10_ >= 50) {
                        if(i_10_ >= 100) {
                            if(i_10_ < 150)
                                textColor = 255 - (-(327680 * (i_10_ - 100)) - 500) + -(5 * i_10_);
                        } else
                            textColor = MovedStatics.OVERHEAD_CHAT_COLORS[4] - (327680 * i_10_ - 16384000);
                    } else
                        textColor = 5 * i_10_ + MovedStatics.OVERHEAD_CHAT_COLORS[1];
                }
                if(PlayerAppearance.overheadChatColor[i] == ChatColorEffect.GLOW3.getNetworkCode()) {
                    int i_11_ = -PlayerAppearance.anIntArray684[i] + 150;
                    if(i_11_ >= 50) {
                        if(i_11_ < 100)
                            textColor = 327685 * (i_11_ - 50) + MovedStatics.OVERHEAD_CHAT_COLORS[2];
                        else if(i_11_ < 150)
                            textColor = -((-100 + i_11_) * 327680) + MovedStatics.OVERHEAD_CHAT_COLORS[5];
                    } else
                        textColor = -(327685 * i_11_) + MovedStatics.OVERHEAD_CHAT_COLORS[5];
                }
                if(PlayerAppearance.overheadChatShape[i] == ChatShapeEffect.NONE.getNetworkCode()) {
                    TypeFace.fontBold.drawStringLeft(message, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                    TypeFace.fontBold.drawStringLeft(message, ISAAC.anInt522, Class44.anInt1048, textColor);
                }
                if(PlayerAppearance.overheadChatShape[i] == ChatShapeEffect.WAVE.getNetworkCode()) {
                    TypeFace.fontBold.drawCenteredStringWaveY(message, ISAAC.anInt522, Class44.anInt1048 + 1, MovedStatics.anInt2628, 0);
                    TypeFace.fontBold.drawCenteredStringWaveY(message, ISAAC.anInt522, Class44.anInt1048, MovedStatics.anInt2628, textColor);
                }
                if(PlayerAppearance.overheadChatShape[i] == ChatShapeEffect.WAVE2.getNetworkCode()) {
                    TypeFace.fontBold.drawCenteredStringWaveXY(message, ISAAC.anInt522, 1 + Class44.anInt1048, MovedStatics.anInt2628, 0);
                    TypeFace.fontBold.drawCenteredStringWaveXY(message, ISAAC.anInt522, Class44.anInt1048, MovedStatics.anInt2628, textColor);
                }
                if(PlayerAppearance.overheadChatShape[i] == ChatShapeEffect.SHAKE.getNetworkCode()) {
                    TypeFace.fontBold.drawCenteredStringWaveXYMove(message, ISAAC.anInt522, Class44.anInt1048 + 1, MovedStatics.anInt2628, -PlayerAppearance.anIntArray684[i] + 150, 0);
                    TypeFace.fontBold.drawCenteredStringWaveXYMove(message, ISAAC.anInt522, Class44.anInt1048, MovedStatics.anInt2628, -PlayerAppearance.anIntArray684[i] + 150, textColor);
                }
                if(PlayerAppearance.overheadChatShape[i] == ChatShapeEffect.SCROLL.getNetworkCode()) {
                    int i_12_ = TypeFace.fontBold.getStringWidth(message);
                    int i_13_ = (i_12_ + 100) * (150 + -PlayerAppearance.anIntArray684[i]) / 150;
                    Rasterizer.setBounds(ISAAC.anInt522 + -50, 0, 50 + ISAAC.anInt522, 334);
                    TypeFace.fontBold.drawString(message, -i_13_ + ISAAC.anInt522 + 50, Class44.anInt1048 + 1, 0);
                    TypeFace.fontBold.drawString(message, 50 + ISAAC.anInt522 + -i_13_, Class44.anInt1048, textColor);
                    Rasterizer.resetBounds();
                }
                if(PlayerAppearance.overheadChatShape[i] == ChatShapeEffect.SLIDE.getNetworkCode()) {
                    int i_14_ = 0;
                    int i_15_ = 150 + -PlayerAppearance.anIntArray684[i];
                    Rasterizer.setBounds(0, -1 + -TypeFace.fontBold.characterDefaultHeight + Class44.anInt1048, 512, 5 + Class44.anInt1048);
                    if(i_15_ >= 25) {
                        if(i_15_ > 125)
                            i_14_ = i_15_ + -125;
                    } else
                        i_14_ = i_15_ + -25;
                    TypeFace.fontBold.drawStringLeft(message, ISAAC.anInt522, i_14_ + Class44.anInt1048 + 1, 0);
                    TypeFace.fontBold.drawStringLeft(message, ISAAC.anInt522, i_14_ + Class44.anInt1048, textColor);
                    Rasterizer.resetBounds();
                }
            } else {
                TypeFace.fontBold.drawStringLeft(message, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                TypeFace.fontBold.drawStringLeft(message, ISAAC.anInt522, Class44.anInt1048, MovedStatics.OVERHEAD_CHAT_COLORS[0]);
            }
        }
    }

    public static void method406(int arg0, int arg1, int arg2) {
        if(arg1 == 1) {
            SceneCluster.packetBuffer.putPacket(111);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 2) {
            SceneCluster.packetBuffer.putPacket(9);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 3) {
            SceneCluster.packetBuffer.putPacket(193);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 4) {
            SceneCluster.packetBuffer.putPacket(53);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 5) {
            SceneCluster.packetBuffer.putPacket(94);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 6) {
            SceneCluster.packetBuffer.putPacket(213);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 7) {
            SceneCluster.packetBuffer.putPacket(46);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 8) {
            SceneCluster.packetBuffer.putPacket(130);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 9) {
            SceneCluster.packetBuffer.putPacket(157);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
        if(arg1 == 10) {
            SceneCluster.packetBuffer.putPacket(84);
            SceneCluster.packetBuffer.putIntBE(arg2);
            SceneCluster.packetBuffer.putShortBE(arg0);
        }
    }

    public static boolean menuHasAddFriend(int arg1) {
        int i = MovedStatics.menuActionTypes[arg1];
        if(i >= ActionRowType.LOW_PRIORITY_MODIFIER)
            i -= ActionRowType.LOW_PRIORITY_MODIFIER;
        return i == ActionRowType.ADD_FRIEND.getId();
    }

    public static int getRotatedTileY(int x, int y, int rotation) {
        rotation &= 0x3;
        if(rotation == 0)
            return y;
        if(rotation == 1)
            return 7 + -x;
        if(rotation == 2)
            return -y + 7;
        return x;

    }

    public static void setLoginScreenMessage(String line1, String line2, String line3) {
        Native.loginScreenMessageLineOne = line1;
        Native.loginScreenMessageLineTwo = line2;
        Native.loginScreenMessageLineThree = line3;
    }
}
