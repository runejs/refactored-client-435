package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.util.CollisionMap;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Class40_Sub5_Sub6 extends SubNode {
    public static Class67[] aClass67Array2436 = new Class67[13];
    public static int currentCameraPositionH;
    public static Cache aClass9_2439 = new Cache(64);
    public static int cameraY;
    public static int anInt2451 = 0;
    public static int anInt2452 = 0;
    public byte[] aByteArray2441;
    private static char VALID_CHARACTERS[] = {' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w',
            'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243',
            '$', '%', '"', '[', ']'};

    public Class40_Sub5_Sub6(byte[] arg0) {
        aByteArray2441 = arg0;
    }

    public static boolean drawInterface(int arg0, int arg1, int arg2, byte arg3, int arg4, int arg5, int arg6) {
        if (!Class68.method1043(arg1))
            return false;
        if (arg3 != -5)
            return true;
        return Main.method36(arg5, arg0, arg4, 0, -1, arg2, arg6, 0, Widget.interfaces[arg1], true);
    }

    public static void putHackCheckPacket(int arg0, int arg1, PacketBuffer arg2) {
        if (arg0 == -12) {
            for (; ; ) {
                Class40_Sub11 class40_sub11 = (Class40_Sub11) KeyFocusListener.aLinkedList_1278.method902((byte) -90);
                if (class40_sub11 == null)
                    break;
                boolean bool = false;
                for (int i = 0; class40_sub11.anInt2160 > i; i++) {
                    if (class40_sub11.aSignlinkNodeArray2157[i] != null) {
                        if (class40_sub11.aSignlinkNodeArray2157[i].anInt434 == 2)
                            class40_sub11.anIntArray2155[i] = -5;
                        if (class40_sub11.aSignlinkNodeArray2157[i].anInt434 == 0)
                            bool = true;
                    }
                    if (class40_sub11.aSignlinkNodeArray2156[i] != null) {
                        if (class40_sub11.aSignlinkNodeArray2156[i].anInt434 == 2)
                            class40_sub11.anIntArray2155[i] = -6;
                        if (class40_sub11.aSignlinkNodeArray2156[i].anInt434 == 0)
                            bool = true;
                    }
                }
                if (bool)
                    break;
                arg2.putPacket(arg1);
                arg2.putByte(0);
                int i = arg2.currentPosition;
                arg2.putIntBE(class40_sub11.anInt2166);
                for (int i_0_ = 0; class40_sub11.anInt2160 > i_0_; i_0_++) {
                    if (class40_sub11.anIntArray2155[i_0_] == 0) {
                        try {
                            int i_1_ = class40_sub11.anIntArray2154[i_0_];
                            if (i_1_ == 0) {
                                Field field = (Field) class40_sub11.aSignlinkNodeArray2157[i_0_].value;
                                int i_2_ = field.getInt(null);
                                arg2.putByte(0);
                                arg2.putIntBE(i_2_);
                            } else if (i_1_ == 1) {
                                Field field = (Field) class40_sub11.aSignlinkNodeArray2157[i_0_].value;
                                field.setInt(null, class40_sub11.anIntArray2165[i_0_]);
                                arg2.putByte(0);
                            } else if (i_1_ == 2) {
                                Field field = (Field) class40_sub11.aSignlinkNodeArray2157[i_0_].value;
                                int i_3_ = field.getModifiers();
                                arg2.putByte(0);
                                arg2.putIntBE(i_3_);
                            }
                            if (i_1_ == 3) {
                                Method method = (Method) class40_sub11.aSignlinkNodeArray2156[i_0_].value;
                                byte[][] is = class40_sub11.aByteArrayArrayArray2159[i_0_];
                                Object[] objects = new Object[is.length];
                                for (int i_5_ = 0; is.length > i_5_; i_5_++) {
                                    ObjectInputStream objectinputstream = new ObjectInputStream(new ByteArrayInputStream(is[i_5_]));
                                    objects[i_5_] = objectinputstream.readObject();
                                }
                                Object object = method.invoke(null, objects);
                                if (object == null)
                                    arg2.putByte(0);
                                else if (object instanceof Number) {
                                    arg2.putByte(1);
                                    arg2.putLongBE(((Number) object).longValue());
                                } else if (object instanceof RSString) {
                                    arg2.putByte(2);
                                    arg2.method505((RSString) object);
                                } else
                                    arg2.putByte(4);
                            } else if (i_1_ == 4) {
                                Method method = (Method) class40_sub11.aSignlinkNodeArray2156[i_0_].value;
                                int i_4_ = method.getModifiers();
                                arg2.putByte(0);
                                arg2.putIntBE(i_4_);
                            }
                        } catch (ClassNotFoundException classnotfoundexception) {
                            arg2.putByte(-10);
                        } catch (java.io.InvalidClassException invalidclassexception) {
                            arg2.putByte(-11);
                        } catch (java.io.StreamCorruptedException streamcorruptedexception) {
                            arg2.putByte(-12);
                        } catch (java.io.OptionalDataException optionaldataexception) {
                            arg2.putByte(-13);
                        } catch (IllegalAccessException illegalaccessexception) {
                            arg2.putByte(-14);
                        } catch (IllegalArgumentException illegalargumentexception) {
                            arg2.putByte(-15);
                        } catch (java.lang.reflect.InvocationTargetException invocationtargetexception) {
                            arg2.putByte(-16);
                        } catch (SecurityException securityexception) {
                            arg2.putByte(-17);
                        } catch (java.io.IOException ioexception) {
                            arg2.putByte(-18);
                        } catch (NullPointerException nullpointerexception) {
                            arg2.putByte(-19);
                        } catch (Exception exception) {
                            arg2.putByte(-20);
                        } catch (Throwable throwable) {
                            arg2.putByte(-21);
                        }
                    } else
                        arg2.putByte(class40_sub11.anIntArray2155[i_0_]);
                }
                arg2.method473(i);
                arg2.finishVarByte(-i + arg2.currentPosition);
                class40_sub11.method457(-1);
            }
        }

    }

    public static int method585(int arg0, int arg1) {
        VarbitDefinition varbitDefinition = Class34.method417(0, arg0);
        if (arg1 != 1369)
            return 27;
        int i = varbitDefinition.mostSignificantBit;
        int i_6_ = varbitDefinition.index;
        int i_7_ = varbitDefinition.leastSignificantBit;
        int i_8_ = Class68_Sub1.anIntArray2199[i - i_7_];
        return GroundItemTile.varbitmasks[i_6_] >> i_7_ & i_8_;
    }

    public static void method586(int arg0) {
        ISAAC.aClass9_510.method235();
        Class67.aClass9_1611.method235();
        if (arg0 <= 63)
            English.errorConnectingToServer = null;
    }

    public static void manageTextInputs() {
        while (Class34.method416((byte) -125)) {
            if (ItemDefinition.anInt2854 == 28) {
                break;
            }
            if (Console.console.consoleOpen) {
                Console.console.handleInput();
                break;
            }
            if (HuffmanEncoding.openScreenWidgetId != -1 && HuffmanEncoding.reportAbuseInterfaceID == HuffmanEncoding.openScreenWidgetId) {
                if (ItemDefinition.anInt2854 == 85 && HuffmanEncoding.reportedName.length() > 0)
                    HuffmanEncoding.reportedName = HuffmanEncoding.reportedName.substring(0, -1 + HuffmanEncoding.reportedName.length());
                if ((Class40_Sub5_Sub15.method735(Class59.anInt1388) || Class59.anInt1388 == 32) && HuffmanEncoding.reportedName.length() < 12)
                    HuffmanEncoding.reportedName = HuffmanEncoding.reportedName + (char) Class59.anInt1388;
            } else if (ChatBox.messagePromptRaised) {
                if (ItemDefinition.anInt2854 == 85 && ChatBox.chatMessage.length() > 0) {
                    ChatBox.chatMessage = ChatBox.chatMessage.substring(0, -1 + ChatBox.chatMessage.length());
                    ChatBox.redrawChatbox = true;
                }
                if (Player.method793((byte) 120, Class59.anInt1388) && ChatBox.chatMessage.length() < 80) {
                    ChatBox.chatMessage = ChatBox.chatMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if (ItemDefinition.anInt2854 == 84) {
                    ChatBox.messagePromptRaised = false;
                    ChatBox.redrawChatbox = true;
                    if (Class37.anInt876 == 1) {
                        long l = RSString.method58(ChatBox.chatMessage);
                        UnderlayDefinition.addFriend(l);
                    }
                    if (Class37.anInt876 == 2 && Item.friendsCount > 0) {
                        long l = RSString.method58(ChatBox.chatMessage);
                        GameShell.method28(l);
                    }
                    if (Class37.anInt876 == 3 && ChatBox.chatMessage.length() > 0) {
                        SceneCluster.packetBuffer.putPacket(207);
                        SceneCluster.packetBuffer.putByte(0);
                        int i = SceneCluster.packetBuffer.currentPosition;
                        SceneCluster.packetBuffer.putLongBE(PacketBuffer.aLong2241);
                        ChatBox.filterInput();
                        Class68_Sub1.method1052(ChatBox.chatMessage, SceneCluster.packetBuffer);
                        SceneCluster.packetBuffer.finishVarByte(-i + SceneCluster.packetBuffer.currentPosition);
                        if (ChatBox.privateChatMode == 2) {
                            ChatBox.privateChatMode = 1;
                            Cache.redrawChatbox = true;
                            SceneCluster.packetBuffer.putPacket(32);
                            SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
                            SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
                            SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
                        }
                    }
                    if (Class37.anInt876 == 4 && Class42.anInt1008 < 100) {
                        long l = RSString.method58(ChatBox.chatMessage);
                        Class17.method275(l);
                    }
                    if (Class37.anInt876 == 5 && Class42.anInt1008 > 0) {
                        long l = RSString.method58(ChatBox.chatMessage);
                        Class40_Sub6.method838(0, l);
                    }
                }
            } else if (ChatBox.inputType == 1) {
                if (ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 1);
                    ChatBox.redrawChatbox = true;
                }
                if (HuffmanEncoding.method1027(Class59.anInt1388) && ChatBox.inputMessage.length() < 10) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if (ItemDefinition.anInt2854 == 84) {
                    if (ChatBox.inputMessage.length() > 0) {
                        int inputValue = 0;
                        try {
                            inputValue = Integer.parseInt(ChatBox.inputMessage);
                        } catch (Exception _ex) {
                            /* empty */
                        }
                        SceneCluster.packetBuffer.putPacket(238);
                        SceneCluster.packetBuffer.putIntBE(inputValue);
                    }
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
            } else if (ChatBox.inputType == 2) {
                if (ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, -1 + ChatBox.inputMessage.length());
                    ChatBox.redrawChatbox = true;
                }
                if ((Class40_Sub5_Sub15.method735(Class59.anInt1388) || Class59.anInt1388 == 32) && ChatBox.inputMessage.length() < 12) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if (ItemDefinition.anInt2854 == 84) {
                    if (ChatBox.inputMessage.length() > 0) {
                        SceneCluster.packetBuffer.putPacket(86);
                        SceneCluster.packetBuffer.putLongBE(RSString.method58(ChatBox.inputMessage));
                    }
                    ChatBox.inputType = 0;
                    ChatBox.redrawChatbox = true;
                }
            } else if (ChatBox.inputType == 3) {
                if (ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 10);
                    ChatBox.redrawChatbox = true;
                }
                if (Player.method793((byte) 122, Class59.anInt1388) && ChatBox.inputMessage.length() < 40) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
            } else if (ChatBox.openChatboxWidgetId == -1 && ActorDefinition.openFullScreenWidgetId == -1) {
                if (ItemDefinition.anInt2854 == 85 && ChatBox.chatboxInput.length() > 0) {
                    ChatBox.chatboxInput = ChatBox.chatboxInput.substring(0, ChatBox.chatboxInput.length() - 1);
                    ChatBox.redrawChatbox = true;
                }
                if (Player.method793((byte) 124, Class59.anInt1388) && ChatBox.chatboxInput.length() < 80) {
                    ChatBox.chatboxInput = ChatBox.chatboxInput + (char) Class59.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if (ItemDefinition.anInt2854 == 84 && ChatBox.chatboxInput.length() > 0) {
                    if (InteractiveObject.playerRights > 1) {
                        if (ChatBox.chatboxInput.equals(GroundItemTile.cmd_clientdrop))
                            Class59.dropClient();
                        if (ChatBox.chatboxInput.equals(Class40_Sub3.cmd_fpson)) {
                            InteractiveObject.showFps = true;
                            ChatBox.inputType = 3;
                        }
                        if (ChatBox.chatboxInput.startsWith("::region")) {
                            for (int qq = 0; qq < 469; qq++) {
                                if (Class68.method1043(qq)) {
                                    Widget[] widgets = Widget.interfaces[qq];
                                    for (int y = 0; widgets.length > y; y++) {
                                        Widget widget = widgets[y];
                                        if (widget.disabledText != null) {
                                            String text = widget.disabledText.toString().toLowerCase();
                                            if (widget.disabledText.toString().toLowerCase().contains("bank")) {
                                                System.out.println(qq + " contains " + text);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (ChatBox.chatboxInput.equals(Native.cmd_fpsoff))
                            InteractiveObject.showFps = false;
                        if (ChatBox.chatboxInput.equals(SpotAnimDefinition.cmd_noclip)) {
                            for (int i = 0; i < 4; i++) {
                                for (int i_9_ = 1; i_9_ < 103; i_9_++) {
                                    for (int i_10_ = 1; i_10_ < 103; i_10_++)
                                        Landscape.currentCollisionMap[i].clippingData[i_9_][i_10_] = 0;
                                }
                            }
                        }
                        if (ChatBox.chatboxInput.equals(Widget.cmd_errortest) && Class44.modewhere == 2)
                            throw new RuntimeException();
                        if (ChatBox.chatboxInput.equals(Native.cmd_hiddenbuttontest))
                            PacketBuffer.hiddenButtonTest = true;
                    }
                    if (ChatBox.chatboxInput.startsWith(Native.cmd_prefix)) {
                        SceneCluster.packetBuffer.putPacket(248);
                        SceneCluster.packetBuffer.putByte(-1 + ChatBox.chatboxInput.length());
                        SceneCluster.packetBuffer.putString(ChatBox.chatboxInput.substring(2));
                    } else {
                        int i = 0;
                        String class1 = ChatBox.chatboxInput.toLowerCase();
                        int i_11_ = 0;
                        if (class1.startsWith(English.effectYellow)) {
                            i_11_ = 0;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectYellow.length());
                        } else if (class1.startsWith(English.effectRed)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectRed.length());
                            i_11_ = 1;
                        } else if (class1.startsWith(English.effectGreen)) {
                            i_11_ = 2;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGreen.length());
                        } else if (class1.startsWith(LinkedList.aClass1_1076)) {
                            i_11_ = 3;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(LinkedList.aClass1_1076.length());
                        } else if (class1.startsWith(English.effectPurple)) {
                            i_11_ = 4;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectPurple.length());
                        } else if (class1.startsWith(Node.aClass1_940)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Node.aClass1_940.length());
                            i_11_ = 5;
                        } else if (class1.startsWith(Native.aClass1_1019)) {
                            i_11_ = 6;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Native.aClass1_1019.length());
                        } else if (class1.startsWith(UnderlayDefinition.aClass1_2566)) {
                            i_11_ = 7;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(UnderlayDefinition.aClass1_2566.length());
                        } else if (class1.startsWith(English.effectFlash3)) {
                            i_11_ = 8;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectFlash3.length());
                        } else if (class1.startsWith(English.effectGlow1)) {
                            i_11_ = 9;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow1.length());
                        } else if (class1.startsWith(Widget.aClass1_2671)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Widget.aClass1_2671.length());
                            i_11_ = 10;
                        } else if (class1.startsWith(English.effectGlow3)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow3.length());
                            i_11_ = 11;
                        }
                        class1 = ChatBox.chatboxInput.toLowerCase();
                        if (class1.startsWith(VertexNormal.aClass1_1097)) {
                            i = 1;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(VertexNormal.aClass1_1097.length());
                        } else if (class1.startsWith(MouseHandler.aClass1_1474)) {
                            i = 2;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(MouseHandler.aClass1_1474.length());
                        } else if (class1.startsWith(RSCanvas.aClass1_51)) {
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(RSCanvas.aClass1_51.length());
                            i = 3;
                        } else if (class1.startsWith(Native.aClass1_2438)) {
                            i = 4;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Native.aClass1_2438.length());
                        } else if (class1.startsWith(English.effectSlide)) {
                            i = 5;
                            ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectSlide.length());
                        }
                        SceneCluster.packetBuffer.putPacket(75);
                        SceneCluster.packetBuffer.putByte(0);
                        int i_12_ = SceneCluster.packetBuffer.currentPosition;
                        SceneCluster.packetBuffer.putByte(i_11_);
                        SceneCluster.packetBuffer.putByte(i);
                        ChatBox.filterInput();
                        Class68_Sub1.method1052(ChatBox.chatboxInput, SceneCluster.packetBuffer);
                        SceneCluster.packetBuffer.finishVarByte(SceneCluster.packetBuffer.currentPosition + -i_12_);
                        if (ChatBox.publicChatMode == 2) {
                            Cache.redrawChatbox = true;
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

    public static void drawMenu() {
        int i = InteractiveObject.menuOffsetX;
        int i_13_ = CollisionMap.menuHeight;
        int i_14_ = Main.menuOffsetY;
        int i_15_ = VertexNormal.menuWidth;
        int i_16_ = 6116423;
        Rasterizer.drawFilledRectangle(i, i_14_, i_15_, i_13_, i_16_);
        Rasterizer.drawFilledRectangle(1 + i, 1 + i_14_, -2 + i_15_, 16, 0);
        Rasterizer.drawUnfilledRectangle(i + 1, 18 + i_14_, -2 + i_15_, -19 + i_13_, 0);
        Class40_Sub5_Sub17_Sub6.fontBold.drawString(Widget.str_Choose_Option, i + 3, 14 + i_14_, i_16_);
        int i_17_ = Class13.mouseX;
        int i_18_ = Landscape.mouseY;
        if (Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
            i_17_ -= 4;
            i_18_ -= 4;
        }
        if (Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
            i_18_ -= 205;
            i_17_ -= 553;
        }
        if (Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
            i_18_ -= 357;
            i_17_ -= 17;
        }
        for (int i_19_ = 0; i_19_ < ActorDefinition.menuActionRow; i_19_++) {
            int i_20_ = 15 * (-i_19_ + ActorDefinition.menuActionRow + -1) + i_14_ + 31;
            int i_21_ = 16777215;
            if (i_17_ > i && i + i_15_ > i_17_ && i_18_ > -13 + i_20_ && i_20_ + 3 > i_18_)
                i_21_ = 16776960;
            Class40_Sub5_Sub17_Sub6.fontBold.drawShadowedString(Landscape.menuActionTexts[i_19_], i + 3, i_20_, true, i_21_);
        }
    }
}
