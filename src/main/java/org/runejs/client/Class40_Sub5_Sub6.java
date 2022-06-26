package org.runejs.client;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.AnimationFrameGroup;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.console.Console;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.node.CachedNode;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.util.CollisionMap;

public class Class40_Sub5_Sub6 extends CachedNode {
    public static int currentCameraPositionH;
    public static NodeCache aClass9_2439 = new NodeCache(64);
    public static int cameraY;
    public static int loadingPercent = 0;
    public static int anInt2452 = 0;
    public byte[] aByteArray2441;
    private static char VALID_CHARACTERS[] = {' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w',
            'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243',
            '$', '%', '"', '[', ']'};

    public Class40_Sub5_Sub6(byte[] arg0) {
        aByteArray2441 = arg0;
    }

    public static void method586(int arg0) {
        ISAAC.cachedActorDefinitions.clear();
        MovedStatics.aClass9_1611.clear();
        if(arg0 <= 63)
            English.errorConnectingToServer = null;
    }

    public static void manageTextInputs() {
        while(MovedStatics.method416((byte) -125)) {
            if(ItemDefinition.anInt2854 == 28) {
                break;
            }
            if(Console.console.consoleOpen) {
                Console.console.handleInput();
                break;
            }
            if(GameInterface.gameScreenInterfaceId != -1 && HuffmanEncoding.reportAbuseInterfaceID == GameInterface.gameScreenInterfaceId) {
                if(ItemDefinition.anInt2854 == 85 && Native.reportedName.length() > 0)
                    Native.reportedName = Native.reportedName.substring(0, -1 + Native.reportedName.length());
                if((AnimationFrameGroup.method735(Class59.anInt1388) || Class59.anInt1388 == 32) && Native.reportedName.length() < 12)
                    Native.reportedName = Native.reportedName + (char) Class59.anInt1388;
            } else if(ChatBox.messagePromptRaised) {
                if(ItemDefinition.anInt2854 == 85 && ChatBox.chatMessage.length() > 0) {
                    ChatBox.chatMessage = ChatBox.chatMessage.substring(0, -1 + ChatBox.chatMessage.length());
                    ChatBox.redrawChatbox = true;
                }
                if(Player.method793((byte) 120, Class59.anInt1388) && ChatBox.chatMessage.length() < 80) {
                    ChatBox.chatMessage = ChatBox.chatMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(ItemDefinition.anInt2854 == 84) {
                    ChatBox.messagePromptRaised = false;
                    ChatBox.redrawChatbox = true;
                    if(Class37.anInt876 == 1) {
                        long l = RSString.nameToLong(ChatBox.chatMessage);
                        MovedStatics.addFriend(l);
                    }
                    if(Class37.anInt876 == 2 && Player.friendsCount > 0) {
                        long l = RSString.nameToLong(ChatBox.chatMessage);
                        GameShell.method28(l);
                    }
                    if(Class37.anInt876 == 3 && ChatBox.chatMessage.length() > 0) {
                        SceneCluster.packetBuffer.putPacket(207);
                        SceneCluster.packetBuffer.putByte(0);
                        int i = SceneCluster.packetBuffer.currentPosition;
                        SceneCluster.packetBuffer.putLongBE(PacketBuffer.aLong2241);
                        ChatBox.filterInput();
                        ProducingGraphicsBuffer_Sub1.method1052(ChatBox.chatMessage, SceneCluster.packetBuffer);
                        SceneCluster.packetBuffer.finishVarByte(-i + SceneCluster.packetBuffer.currentPosition);
                        if(ChatBox.privateChatMode == 2) {
                            ChatBox.privateChatMode = 1;
                            MovedStatics.redrawChatbox = true;
                            SceneCluster.packetBuffer.putPacket(32);
                            SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
                            SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
                            SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
                        }
                    }
                    if(Class37.anInt876 == 4 && MovedStatics.anInt1008 < 100) {
                        long l = RSString.nameToLong(ChatBox.chatMessage);
                        Class17.method275(l);
                    }
                    if(Class37.anInt876 == 5 && MovedStatics.anInt1008 > 0) {
                        long l = RSString.nameToLong(ChatBox.chatMessage);
                        MovedStatics.method838(0, l);
                    }
                }
            } else if(ChatBox.inputType == 1) {
                if(ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 1);
                    ChatBox.redrawChatbox = true;
                }
                if(HuffmanEncoding.method1027(Class59.anInt1388) && ChatBox.inputMessage.length() < 10) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(ItemDefinition.anInt2854 == 84) {
                    if(ChatBox.inputMessage.length() > 0) {
                        int inputValue = 0;
                        try {
                            inputValue = Integer.parseInt(ChatBox.inputMessage);
                        } catch(Exception _ex) {
                            /* empty */
                        }
                        SceneCluster.packetBuffer.putPacket(238);
                        SceneCluster.packetBuffer.putIntBE(inputValue);
                    }
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
            } else if(ChatBox.inputType == 2) {
                if(ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, -1 + ChatBox.inputMessage.length());
                    ChatBox.redrawChatbox = true;
                }
                if((AnimationFrameGroup.method735(Class59.anInt1388) || Class59.anInt1388 == 32) && ChatBox.inputMessage.length() < 12) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(ItemDefinition.anInt2854 == 84) {
                    if(ChatBox.inputMessage.length() > 0) {
                        SceneCluster.packetBuffer.putPacket(86);
                        SceneCluster.packetBuffer.putLongBE(RSString.nameToLong(ChatBox.inputMessage));
                    }
                    ChatBox.inputType = 0;
                    ChatBox.redrawChatbox = true;
                }
            } else if(ChatBox.inputType == 3) {
                if(ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 10);
                    ChatBox.redrawChatbox = true;
                }
                if(Player.method793((byte) 122, Class59.anInt1388) && ChatBox.inputMessage.length() < 40) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
            } else if(GameInterface.chatboxInterfaceId == -1 && GameInterface.fullscreenInterfaceId == -1) {
                if(ItemDefinition.anInt2854 == 85 && ChatBox.chatboxInput.length() > 0) {
                    ChatBox.chatboxInput = ChatBox.chatboxInput.substring(0, ChatBox.chatboxInput.length() - 1);
                    ChatBox.redrawChatbox = true;
                }
                if(Player.method793((byte) 124, Class59.anInt1388) && ChatBox.chatboxInput.length() < 80) {
                    ChatBox.chatboxInput = ChatBox.chatboxInput + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(ItemDefinition.anInt2854 == 84 && ChatBox.chatboxInput.length() > 0) {
                    if(InteractiveObject.playerRights > 1) {
                        if(ChatBox.chatboxInput.equals(English.commandClientDrop))
                            Class59.dropClient();
                        if(ChatBox.chatboxInput.equals(English.commandFpson)) {
                            InteractiveObject.showFps = true;
                            ChatBox.inputType = 3;
                        }
                        if(ChatBox.chatboxInput.startsWith("::region")) {
                            for(int qq = 0; qq < 469; qq++) {
                                if(GameInterface.decodeGameInterface(qq)) {
                                    GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[qq];
                                    for(int y = 0; gameInterfaces.length > y; y++) {
                                        GameInterface gameInterface = gameInterfaces[y];
                                        if(gameInterface.disabledText != null) {
                                            String text = gameInterface.disabledText.toString().toLowerCase();
                                            if(gameInterface.disabledText.toString().toLowerCase().contains("bank")) {
                                                System.out.println(qq + " contains " + text);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if(ChatBox.chatboxInput.equals(Native.cmd_fpsoff))
                            InteractiveObject.showFps = false;
                        if(ChatBox.chatboxInput.equals(English.commandNoclip)) {
                            for(int i = 0; i < 4; i++) {
                                for(int i_9_ = 1; i_9_ < 103; i_9_++) {
                                    for(int i_10_ = 1; i_10_ < 103; i_10_++)
                                        Landscape.currentCollisionMap[i].clippingData[i_9_][i_10_] = 0;
                                }
                            }
                        }
                        if(ChatBox.chatboxInput.equals(English.commandErrorTest) && Class44.modewhere == 2)
                            throw new RuntimeException();
                        if(ChatBox.chatboxInput.equals(Native.cmd_hiddenbuttontest))
                            PacketBuffer.hiddenButtonTest = true;
                    }
                    if(ChatBox.chatboxInput.startsWith(Native.cmd_prefix)) {
                        SceneCluster.packetBuffer.putPacket(248);
                        SceneCluster.packetBuffer.putByte(-1 + ChatBox.chatboxInput.length());
                        SceneCluster.packetBuffer.putString(ChatBox.chatboxInput.substring(2));
                    } else {
                        int i = 0;
                        String class1 = ChatBox.chatboxInput.toLowerCase();
                        int i_11_ = 0;
                        if(class1.startsWith(English.effectYellow)) {
                            i_11_ = 0;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectYellow.length());
                        } else if(class1.startsWith(English.effectRed)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectRed.length());
                            i_11_ = 1;
                        } else if(class1.startsWith(English.effectGreen)) {
                            i_11_ = 2;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGreen.length());
                        } else if(class1.startsWith(English.effectCyan)) {
                            i_11_ = 3;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectCyan.length());
                        } else if(class1.startsWith(English.effectPurple)) {
                            i_11_ = 4;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectPurple.length());
                        } else if(class1.startsWith(English.effectWhite)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectWhite.length());
                            i_11_ = 5;
                        } else if(class1.startsWith(Native.aClass1_1019)) {
                            i_11_ = 6;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Native.aClass1_1019.length());
                        } else if(class1.startsWith(English.effectFlash2)) {
                            i_11_ = 7;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectFlash2.length());
                        } else if(class1.startsWith(English.effectFlash3)) {
                            i_11_ = 8;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectFlash3.length());
                        } else if(class1.startsWith(English.effectGlow1)) {
                            i_11_ = 9;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow1.length());
                        } else if(class1.startsWith(English.effectGlow2)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow2.length());
                            i_11_ = 10;
                        } else if(class1.startsWith(English.effectGlow3)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow3.length());
                            i_11_ = 11;
                        }
                        class1 = ChatBox.chatboxInput.toLowerCase();
                        if(class1.startsWith(English.effectWave)) {
                            i = 1;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectWave.length());
                        } else if(class1.startsWith(English.effectWave2)) {
                            i = 2;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectWave2.length());
                        } else if(class1.startsWith(English.effectShake)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectShake.length());
                            i = 3;
                        } else if(class1.startsWith(Native.aClass1_2438)) {
                            i = 4;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Native.aClass1_2438.length());
                        } else if(class1.startsWith(English.effectSlide)) {
                            i = 5;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectSlide.length());
                        }
                        SceneCluster.packetBuffer.putPacket(75);
                        SceneCluster.packetBuffer.putByte(0);
                        int i_12_ = SceneCluster.packetBuffer.currentPosition;
                        SceneCluster.packetBuffer.putByte(i_11_);
                        SceneCluster.packetBuffer.putByte(i);
                        ChatBox.filterInput();
                        ProducingGraphicsBuffer_Sub1.method1052(ChatBox.chatboxInput, SceneCluster.packetBuffer);
                        SceneCluster.packetBuffer.finishVarByte(SceneCluster.packetBuffer.currentPosition + -i_12_);
                        if(ChatBox.publicChatMode == 2) {
                            MovedStatics.redrawChatbox = true;
                            ChatBox.publicChatMode = 3;
                            SceneCluster.packetBuffer.putPacket(32);
                            SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
                            SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
                            SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
                        }
                    }
                    ChatBox.redrawChatbox = true;
                    ChatBox.chatboxInput = "";
                }
            }
        }

    }

    public static void drawMenu(int xOffSet, int yOffSet) {
        int height = CollisionMap.menuHeight;
        int width = VertexNormal.menuWidth;
        int offsetX = InteractiveObject.menuOffsetX - (xOffSet);
        int offsetY = (-yOffSet) + Main.menuOffsetY;
        int colour = 0x5d5447;
        ChatBox.redrawChatbox = true;
        GameInterface.redrawTabArea = true;
        Rasterizer.drawFilledRectangleAlpha(offsetX, offsetY, width, height, colour, 120);
        Rasterizer.drawFilledRectangle(1 + offsetX, 1 + offsetY, -2 + width, 16, 0);
        Rasterizer.drawUnfilledRectangle(offsetX + 1, 18 + offsetY, -2 + width, -19 + height, 0);
        TypeFace.fontBold.drawString(English.chooseOption, offsetX + 3, 14 + offsetY, colour);
        int x = Class13.mouseX - (xOffSet);
        int y = (-yOffSet) + Landscape.mouseY;
        if(Projectile.menuScreenArea == 0) {
            x -= 4;
            y -= 4;
        }
        if(Projectile.menuScreenArea == 1) {
            y -= 205;
            x -= 553;
        }
        if(Projectile.menuScreenArea == 2) {
            y -= 357;
            x -= 17;
        }
        for(int action = 0; action < ActorDefinition.menuActionRow; action++) {
            int actionY = 15 * (-action + ActorDefinition.menuActionRow + -1) + offsetY + 31;
            int actionColour = 16777215;
            if(x > offsetX && offsetX + width > x && y > -13 + actionY && actionY + 3 > y)
                actionColour = 16776960;
            TypeFace.fontBold.drawShadowedString(Landscape.menuActionTexts[action], offsetX + 3, actionY, true, actionColour);
        }
    }
}
