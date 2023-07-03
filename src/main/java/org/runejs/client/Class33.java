package org.runejs.client;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.TypeFace;
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
                    if(class40_sub5_sub5.headIcon >= 0 && class40_sub5_sub5.headIcon < ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204.length) {
                        FloorDecoration.method342(actor.anInt3117 + 15, actor);
                        if(ISAAC.anInt522 > -1)
                            ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204[class40_sub5_sub5.headIcon].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -30);
                    }
                    if(Player.headIconDrawType == 1 && HuffmanEncoding.anInt1545 == Player.npcIds[-Player.localPlayerCount + i] && MovedStatics.pulseCycle % 20 < 10) {
                        FloorDecoration.method342(15 + actor.anInt3117, actor);
                        if(ISAAC.anInt522 > -1)
                            MovedStatics.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, Class44.anInt1048 + -28);
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
                                ProducingGraphicsBuffer_Sub1.aClass40_Sub5_Sub14_Sub4Array2204[class40_sub5_sub17_sub4_sub1.headIcon].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
                                i_0_ += 25;
                            }
                        }
                    }
                    if(i >= 0 && Player.headIconDrawType == 10 && ProducingGraphicsBuffer.anInt1623 == Player.trackedPlayerIndices[i]) {
                        FloorDecoration.method342(actor.anInt3117 + 15, actor);
                        if(ISAAC.anInt522 > -1)
                            MovedStatics.aClass40_Sub5_Sub14_Sub4Array2567[1].drawImage(-12 + ISAAC.anInt522, Class44.anInt1048 + -i_0_);
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
                        PlayerAppearance.overheadChatEffect[SceneCluster.anInt770] = actor.chatEffects;
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
            String class1 = PlayerAppearance.overheadChatMessage[i];
            if(MovedStatics.chatEffectsDisabled == 0) {
                int i_8_ = 16776960;
                if(PlayerAppearance.overheadChatColor[i] < 6)
                    i_8_ = MovedStatics.anIntArray2106[PlayerAppearance.overheadChatColor[i]];
                if(PlayerAppearance.overheadChatColor[i] == 6)
                    i_8_ = MovedStatics.anInt2628 % 20 >= 10 ? 16776960 : 16711680;
                if(PlayerAppearance.overheadChatColor[i] == 7)
                    i_8_ = MovedStatics.anInt2628 % 20 < 10 ? 255 : 65535;
                if(PlayerAppearance.overheadChatColor[i] == 8)
                    i_8_ = MovedStatics.anInt2628 % 20 >= 10 ? 8454016 : 45056;
                if(PlayerAppearance.overheadChatColor[i] == 9) {
                    int i_9_ = 150 - PlayerAppearance.anIntArray684[i];
                    if(i_9_ >= 50) {
                        if(i_9_ < 100)
                            i_8_ = -((-50 + i_9_) * 327680) + 16776960;
                        else if(i_9_ < 150)
                            i_8_ = 65280 + 5 * (i_9_ + -100);
                    } else
                        i_8_ = 16711680 + 1280 * i_9_;
                }
                if(PlayerAppearance.overheadChatColor[i] == 10) {
                    int i_10_ = 150 + -PlayerAppearance.anIntArray684[i];
                    if(i_10_ >= 50) {
                        if(i_10_ >= 100) {
                            if(i_10_ < 150)
                                i_8_ = 255 - (-(327680 * (i_10_ - 100)) - 500) + -(5 * i_10_);
                        } else
                            i_8_ = 16711935 - (327680 * i_10_ - 16384000);
                    } else
                        i_8_ = 5 * i_10_ + 16711680;
                }
                if(PlayerAppearance.overheadChatColor[i] == 11) {
                    int i_11_ = -PlayerAppearance.anIntArray684[i] + 150;
                    if(i_11_ >= 50) {
                        if(i_11_ < 100)
                            i_8_ = 327685 * (i_11_ - 50) + 65280;
                        else if(i_11_ < 150)
                            i_8_ = -((-100 + i_11_) * 327680) + 16777215;
                    } else
                        i_8_ = -(327685 * i_11_) + 16777215;
                }
                if(PlayerAppearance.overheadChatEffect[i] == 0) {
                    TypeFace.fontBold.drawStringLeft(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                    TypeFace.fontBold.drawStringLeft(class1, ISAAC.anInt522, Class44.anInt1048, i_8_);
                }
                if(PlayerAppearance.overheadChatEffect[i] == 1) {
                    TypeFace.fontBold.drawCenteredStringWaveY(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0, MovedStatics.anInt2628);
                    TypeFace.fontBold.drawCenteredStringWaveY(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, MovedStatics.anInt2628);
                }
                if(PlayerAppearance.overheadChatEffect[i] == 2) {
                    TypeFace.fontBold.drawCenteredStringWaveXY(class1, ISAAC.anInt522, 1 + Class44.anInt1048, 0, MovedStatics.anInt2628);
                    TypeFace.fontBold.drawCenteredStringWaveXY(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, MovedStatics.anInt2628);
                }
                if(PlayerAppearance.overheadChatEffect[i] == 3) {
                    TypeFace.fontBold.drawCenteredStringWaveXYMove(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0, MovedStatics.anInt2628, -PlayerAppearance.anIntArray684[i] + 150);
                    TypeFace.fontBold.drawCenteredStringWaveXYMove(class1, ISAAC.anInt522, Class44.anInt1048, i_8_, MovedStatics.anInt2628, -PlayerAppearance.anIntArray684[i] + 150);
                }
                if(PlayerAppearance.overheadChatEffect[i] == 4) {
                    int i_12_ = TypeFace.fontBold.getStringWidth(class1);
                    int i_13_ = (i_12_ + 100) * (150 + -PlayerAppearance.anIntArray684[i]) / 150;
                    Rasterizer.setBounds(ISAAC.anInt522 + -50, 0, 50 + ISAAC.anInt522, 334);
                    TypeFace.fontBold.drawString(class1, -i_13_ + ISAAC.anInt522 + 50, Class44.anInt1048 + 1, 0);
                    TypeFace.fontBold.drawString(class1, 50 + ISAAC.anInt522 + -i_13_, Class44.anInt1048, i_8_);
                    Rasterizer.resetBounds();
                }
                if(PlayerAppearance.overheadChatEffect[i] == 5) {
                    int i_14_ = 0;
                    int i_15_ = 150 + -PlayerAppearance.anIntArray684[i];
                    Rasterizer.setBounds(0, -1 + -TypeFace.fontBold.characterDefaultHeight + Class44.anInt1048, 512, 5 + Class44.anInt1048);
                    if(i_15_ >= 25) {
                        if(i_15_ > 125)
                            i_14_ = i_15_ + -125;
                    } else
                        i_14_ = i_15_ + -25;
                    TypeFace.fontBold.drawStringLeft(class1, ISAAC.anInt522, i_14_ + Class44.anInt1048 + 1, 0);
                    TypeFace.fontBold.drawStringLeft(class1, ISAAC.anInt522, i_14_ + Class44.anInt1048, i_8_);
                    Rasterizer.resetBounds();
                }
            } else {
                TypeFace.fontBold.drawStringLeft(class1, ISAAC.anInt522, Class44.anInt1048 + 1, 0);
                TypeFace.fontBold.drawStringLeft(class1, ISAAC.anInt522, Class44.anInt1048, 16776960);
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
