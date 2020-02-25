package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class58 {
    public static boolean aBoolean1349;
    public static int anInt1350;
    public static int anInt1351;
    public static int selectedInventorySlot = 0;
    public static RSString aClass1_1354;
    public static int anInt1356;
    public static int anInt1357;
    public static int[] anIntArray1358;
    public static RSString cmd_clientdrop;
    public static int anInt1360;
    public static Cache aClass9_1364;
    public static int anInt1367;
    public static RSString aClass1_1365 = RSString.CreateString("Message");
    public static int anInt1368;
    public static int anInt1369;
    public static byte[][] aByteArrayArray1370;
    public static int cameraHorizontal;
    public static RSString aClass1_1374;
    public static CacheIndex aCacheIndex_1375;
    public static int anInt1376;
    public static byte[][] aByteArrayArray1377;
    public static RSString aClass1_1378;
    public static int[] varbitmasks;

    static {
        aBoolean1349 = false;
        aClass1_1354 = aClass1_1365;
        anIntArray1358 = new int[5];
        cmd_clientdrop = RSString.CreateString("::clientdrop");
        aClass9_1364 = new Cache(64);
        aClass1_1374 = RSString.CreateString("backvmid1");
        cameraHorizontal = 0;
        anInt1376 = -1;
        aClass1_1378 = RSString.CreateString("Chat panel redrawn");
        aByteArrayArray1377 = new byte[1000][];
        varbitmasks = new int[2000];
    }

    public Renderable aRenderable_1353;
    public int anInt1355;
    public int anInt1361;
    public Renderable aRenderable_1362;
    public Renderable aRenderable_1363;
    public int anInt1366;
    public int anInt1371;
    public int anInt1372;

    public static void method976(byte arg0, Widget arg1) {
        anInt1350++;
        int i = arg1.contentType;
        if(i >= 1 && i <= 100 || (i ^ 0xffffffff) <= -702 && (i ^ 0xffffffff) >= -801) {
            if((i ^ 0xffffffff) == -2 && (Class12.anInt380 ^ 0xffffffff) == -1) {
                arg1.text = Class13.aClass1_405;
                arg1.menuType = 0;
            } else if(i == 1 && (Class12.anInt380 ^ 0xffffffff) == -2) {
                arg1.text = HuffmanEncoding.aClass1_1552;
                arg1.menuType = 0;
            } else if(i == 2 && (Class12.anInt380 ^ 0xffffffff) != -3) {
                arg1.menuType = 0;
                arg1.text = PacketBuffer.aClass1_2240;
            } else {
                int i_0_ = Class40_Sub5_Sub17_Sub3.anInt3060;
                if((i ^ 0xffffffff) < -701)
                    i -= 601;
                else
                    i--;
                if((Class12.anInt380 ^ 0xffffffff) != -3)
                    i_0_ = 0;
                if((i_0_ <= i)) {
                    arg1.text = HuffmanEncoding.blank_string;
                    arg1.menuType = 0;
                } else {
                    arg1.text = Class40_Sub11.aClass1Array2147[i];
                    arg1.menuType = 1;
                }
            }
        } else if(i >= 101 && (i ^ 0xffffffff) >= -201 || (i ^ 0xffffffff) <= -802 && (i ^ 0xffffffff) >= -901) {
            if(i <= 800)
                i -= 101;
            else
                i -= 701;
            int i_1_ = Class40_Sub5_Sub17_Sub3.anInt3060;
            if(Class12.anInt380 != 2)
                i_1_ = 0;
            if(i >= i_1_) {
                arg1.text = HuffmanEncoding.blank_string;
                arg1.menuType = 0;
            } else {
                if((Class40_Sub7.anIntArray2131[i] ^ 0xffffffff) != -1) {
                    if((Class40_Sub7.anIntArray2131[i] ^ 0xffffffff) > -5001) {
                        if((Class13.worldid ^ 0xffffffff) != (Class40_Sub7.anIntArray2131[i] ^ 0xffffffff))
                            arg1.text = (Class40_Sub5_Sub17_Sub6.method832(86, (new RSString[]{KeyFocusListener.aClass1_1283, Class26.aClass1_634, HashTable.method334((Class40_Sub7.anIntArray2131[i]), -1)})));
                        else
                            arg1.text = (Class40_Sub5_Sub17_Sub6.method832(86, (new RSString[]{Landscape.aClass1_1162, Class26.aClass1_634, HashTable.method334((Class40_Sub7.anIntArray2131[i]), -1)})));
                    } else if((Class40_Sub7.anIntArray2131[i] ^ 0xffffffff) != (Class13.worldid ^ 0xffffffff))
                        arg1.text = (Class40_Sub5_Sub17_Sub6.method832(53, (new RSString[]{KeyFocusListener.aClass1_1283, Cache.aClass1_333, HashTable.method334(((Class40_Sub7.anIntArray2131[i]) + -5000), -1)})));
                    else
                        arg1.text = (Class40_Sub5_Sub17_Sub6.method832(-111, (new RSString[]{Landscape.aClass1_1162, Cache.aClass1_333, HashTable.method334(-5000 + (Class40_Sub7.anIntArray2131[i]), -1)})));
                } else
                    arg1.text = (Class40_Sub5_Sub17_Sub6.method832(104, new RSString[]{FloorDecoration.aClass1_610, Class27.aClass1_664}));
                arg1.menuType = 1;
            }
        } else {
            int i_2_ = 88 / ((arg0 - 13) / 53);
            if((i ^ 0xffffffff) == -204) {
                int i_3_ = Class40_Sub5_Sub17_Sub3.anInt3060;
                if(Class12.anInt380 != 2)
                    i_3_ = 0;
                arg1.scrollHeight = 20 + 15 * i_3_;
                if(arg1.originalHeight >= arg1.scrollHeight)
                    arg1.scrollHeight = 1 + arg1.originalHeight;
            } else if((i ^ 0xffffffff) <= -402 && i <= 500) {
                i -= 401;
                if((i ^ 0xffffffff) == -1 && (Class12.anInt380 ^ 0xffffffff) == -1) {
                    arg1.text = Class49.aClass1_1148;
                    arg1.menuType = 0;
                } else if((i ^ 0xffffffff) == -2 && (Class12.anInt380 ^ 0xffffffff) == -1) {
                    arg1.text = PacketBuffer.aClass1_2240;
                    arg1.menuType = 0;
                } else {
                    int i_4_ = Class42.anInt1008;
                    if((Class12.anInt380 ^ 0xffffffff) == -1)
                        i_4_ = 0;
                    if((i_4_ <= i)) {
                        arg1.menuType = 0;
                        arg1.text = HuffmanEncoding.blank_string;
                    } else {
                        arg1.text = Class60.method991(-111, Class53.aLongArray1267[i]).method85(-4305);
                        arg1.menuType = 1;
                    }
                }
            } else if((i ^ 0xffffffff) == -504) {
                arg1.scrollHeight = 15 * Class42.anInt1008 + 20;
                if(arg1.scrollHeight <= arg1.originalHeight)
                    arg1.scrollHeight = arg1.originalHeight + 1;
            } else if(i == 324) {
                if((Class64.anInt1511 ^ 0xffffffff) == 0) {
                    Class64.anInt1511 = arg1.spriteId;
                    Main.anInt1769 = arg1.alternateSpriteId;
                }
                if(!Class45.aClass30_1082.aBoolean683)
                    arg1.spriteId = Main.anInt1769;
                else
                    arg1.spriteId = Class64.anInt1511;
            } else if((i ^ 0xffffffff) == -326) {
                if((Class64.anInt1511 ^ 0xffffffff) == 0) {
                    Main.anInt1769 = arg1.alternateSpriteId;
                    Class64.anInt1511 = arg1.spriteId;
                }
                if(Class45.aClass30_1082.aBoolean683)
                    arg1.spriteId = Main.anInt1769;
                else
                    arg1.spriteId = Class64.anInt1511;
            } else if((i ^ 0xffffffff) == -328) {
                arg1.rotationX = 150;
                arg1.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) Node.pulseCycle / 40.0));
                arg1.modelId = 0;
                arg1.modelType = 5;
            } else if(i == 328) {
                arg1.rotationX = 150;
                arg1.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) Node.pulseCycle / 40.0));
                arg1.modelId = 1;
                arg1.modelType = 5;
            } else if((i ^ 0xffffffff) == -601)
                arg1.text = (Class40_Sub5_Sub17_Sub6.method832(-128, new RSString[]{HuffmanEncoding.aClass1_1550, Class22_Sub2.aClass1_1878}));
            else if(i == 620) {
                if((Class19.anInt493 ^ 0xffffffff) <= -2) {
                    if(!Class67.aBoolean1601) {
                        arg1.textColor = 16777215;
                        arg1.text = VertexNormal.aClass1_1088;
                    } else {
                        arg1.textColor = 16711680;
                        arg1.text = ActorDefinition.aClass1_2384;
                    }
                } else
                    arg1.text = HuffmanEncoding.blank_string;
            }
        }
    }

    public static void method977(int arg0, CacheIndex arg1, CacheIndex arg2) {

        Class27.aCacheIndex_654 = arg2;
        if(arg0 == 3) {
            anInt1360++;
            Class49.aCacheIndex_1150 = arg1;
            PacketBuffer.anInt2257 = Class49.aCacheIndex_1150.method190(3, (byte) 8);
        }

    }

    public static void method979(boolean arg0) {

        CacheIndex.aBoolean260 = arg0;
        Class22.method305((byte) 124);
        if(!Class19.aBoolean490) {
            if((Class40_Sub5_Sub15.inputType ^ 0xffffffff) != -2) {
                if((Class40_Sub5_Sub15.inputType ^ 0xffffffff) == -3) {
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub5_Sub6.aClass1_2446, 239, 40, 0);
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686((Class40_Sub5_Sub17_Sub6.method832(-50, new RSString[]{HuffmanEncoding.inputInputMessage, Class19.aClass1_478})), 239, 60, 128);
                } else if(Class40_Sub5_Sub15.inputType != 3) {
                    if(RSApplet.aClass1_8 == null) {
                        if(Class43.openChatboxWidgetId == -1) {
                            if((Class48.anInt1138 ^ 0xffffffff) != 0) {
                                boolean bool = (Class40_Sub5_Sub6.drawInterface(0, Class48.anInt1138, 96, (byte) -5, 0, 3, 479));
                                if(!bool)
                                    Class52.redrawChatbox = true;
                            } else {
                                int line = 0;
                                TypeFace typeFace = (Class53.fontNormal);
                                Rasterizer.setCoordinates(0, 0, 77, 463);
                                for(int i_8_ = 0; i_8_ < 100; i_8_++) {
                                    if((Actor.chatMessages[i_8_]) != null) {
                                        int type = HuffmanEncoding.chatTypes[i_8_];
                                        RSString name = (Renderable.chatPlayerNames[i_8_]);
                                        int y = (GameObjectDefinition.chatboxScroll + 70 + -(line * 14));
                                        int privelege = 0;
                                        if(name != null && (name.startsWith(Class51.whiteCrown))) {
                                            name = (name.substring(5));
                                            privelege = 1;
                                        }
                                        if(name != null && (name.startsWith((Widget.goldCrown)))) {
                                            name = (name.substring(5));
                                            privelege = 2;
                                        }
                                        if(type == 0) {
                                            line++;
                                            if(y > 0 && ((y ^ 0xffffffff) > -111))
                                                typeFace.drawString((Actor.chatMessages[i_8_]), 4, y, 0);
                                        }
                                        if((type == 1 || type == 2) && (type == 1 || Class35.publicChatMode == 0 || Class35.publicChatMode == 1 && (Class40_Sub2.hasFriend(name, -32624)))) {
                                            if(y > 0 && y < 110) {
                                                int x = 4;
                                                if(privelege == 1) {
                                                    Class40_Sub5_Sub13.moderatorIcon[0].drawImage(x, y + -12);
                                                    x += 14;
                                                }
                                                if(privelege == 2) {
                                                    Class40_Sub5_Sub13.moderatorIcon[1].drawImage(x, y - 12);
                                                    x += 14;
                                                }
                                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(53, (new RSString[]{name, (Class43.aClass1_1027)}))), x, y, 0);
                                                x += (8 + (typeFace.getStringWidth(name)));
                                                typeFace.drawString((Actor.chatMessages[i_8_]), x, y, 255);
                                            }
                                            line++;
                                        }
                                        if(((type ^ 0xffffffff) == -4 || type == 7) && CollisionMap.anInt165 == 0 && ((type ^ 0xffffffff) == -8 || Class4.anInt185 == 0 || ((Class4.anInt185 ^ 0xffffffff) == -2 && (Class40_Sub2.hasFriend(name, -32624))))) {
                                            line++;
                                            if((y ^ 0xffffffff) < -1 && y < 110) {
                                                int i_13_ = 4;
                                                typeFace.drawString((Class40_Sub5_Sub6.aClass1_2458), i_13_, y, 0);
                                                i_13_ += (typeFace.getStringWidth(Class40_Sub5_Sub6.aClass1_2458));
                                                i_13_ += typeFace.method689(32);
                                                if(privelege == 1) {
                                                    Class40_Sub5_Sub13.moderatorIcon[0].drawImage(i_13_, y + -12);
                                                    i_13_ += 14;
                                                }
                                                if((privelege ^ 0xffffffff) == -3) {
                                                    Class40_Sub5_Sub13.moderatorIcon[1].drawImage(i_13_, y - 12);
                                                    i_13_ += 14;
                                                }
                                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(103, (new RSString[]{name, (Class43.aClass1_1027)}))), i_13_, y, 0);
                                                i_13_ += (8 + (typeFace.getStringWidth(name)));
                                                typeFace.drawString((Actor.chatMessages[i_8_]), i_13_, y, 8388608);
                                            }
                                        }
                                        if(type == 4 && ((ItemDefinition.anInt2797) == 0 || (((ItemDefinition.anInt2797) ^ 0xffffffff) == -2 && (Class40_Sub2.hasFriend(name, -32624))))) {
                                            line++;
                                            if(y > 0 && y < 110)
                                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(-65, (new RSString[]{name, (Class48.aClass1_1123), (Actor.chatMessages[i_8_])}))), 4, y, 8388736);
                                        }
                                        if(type == 5 && (CollisionMap.anInt165 ^ 0xffffffff) == -1 && Class4.anInt185 < 2) {
                                            if(y > 0 && y < 110)
                                                typeFace.drawString((Actor.chatMessages[i_8_]), 4, y, 8388608);
                                            line++;
                                        }
                                        if(type == 6 && (CollisionMap.anInt165 ^ 0xffffffff) == -1 && Class4.anInt185 < 2) {
                                            if(y > 0 && ((y ^ 0xffffffff) > -111)) {
                                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(-108, (new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), name, (Class43.aClass1_1027)}))), 4, y, 0);
                                                typeFace.drawString((Actor.chatMessages[i_8_]), (typeFace.getStringWidth(Class40_Sub5_Sub17_Sub6.method832(-98, (new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), name})))) + 12, y, 8388608);
                                            }
                                            line++;
                                        }
                                        if(type == 8 && ((ItemDefinition.anInt2797) == 0 || (((ItemDefinition.anInt2797) ^ 0xffffffff) == -2 && (Class40_Sub2.hasFriend(name, -32624))))) {
                                            line++;
                                            if(y > 0 && ((y ^ 0xffffffff) > -111))
                                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(-105, (new RSString[]{name, (Class48.aClass1_1123), (Actor.chatMessages[i_8_])}))), 4, y, 8270336);
                                        }
                                    }
                                }
                                Rasterizer.resetCoordinates();
                                GameFrame.chatboxScrollMax = line * 14 + 7;
                                if(GameFrame.chatboxScrollMax < 78)
                                    GameFrame.chatboxScrollMax = 78;
                                Class27.drawScrollBar(0, (-(GameObjectDefinition.chatboxScroll) + GameFrame.chatboxScrollMax - 77), GameFrame.chatboxScrollMax, 463, 77, 0);
                                RSString name;
                                if(((Player.localPlayer) != null) && (Player.localPlayer.playerName) != null)
                                    name = (Player.localPlayer.playerName);
                                else
                                    name = Class22_Sub2.username;
                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(-62, (new RSString[]{name, Class43.aClass1_1027}))), 4, 90, 0);
                                typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832(71, (new RSString[]{HuffmanEncoding.chatboxInput, Class19.aClass1_478}))), ((typeFace.getStringWidth(Class40_Sub5_Sub17_Sub6.method832(-99, (new RSString[]{name, ISAAC.aClass1_515})))) + 6), 90, 255);
                                Rasterizer.drawHorizontalLine(0, 77, 479, 0);
                            }
                        } else {
                            boolean bool = Class40_Sub5_Sub6.drawInterface(0, (Class43.openChatboxWidgetId), 96, (byte) -5, 0, 2, 479);
                            if(!bool)
                                Class52.redrawChatbox = true;
                        }
                    } else {
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(RSApplet.aClass1_8, 239, 40, 0);
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class34.aClass1_829, 239, 60, 128);
                    }
                } else {
                    if(HuffmanEncoding.inputInputMessage != HuffmanEncoding.lastItemSearchInput) {
                        GameObject.itemSearch(HuffmanEncoding.inputInputMessage);
                        HuffmanEncoding.lastItemSearchInput = HuffmanEncoding.inputInputMessage;
                    }
                    TypeFace class40_sub5_sub14_sub1 = Class53.fontNormal;
                    Rasterizer.setCoordinates(0, 0, 77, 463);
                    for(int i = 0; (i < VertexNormal.itemSearchResultCount); i++) {
                        int i_14_ = i * 14 + (18 - Class26.itemSearchScroll);
                        if((i_14_ ^ 0xffffffff) < -1 && (i_14_ ^ 0xffffffff) > -111)
                            class40_sub5_sub14_sub1.method686(Class22_Sub1.itemSearchResultNames[i], 239, i_14_, 0);
                    }
                    Rasterizer.resetCoordinates();
                    if((VertexNormal.itemSearchResultCount ^ 0xffffffff) < -6)
                        Class27.drawScrollBar(0, Class26.itemSearchScroll, 7 + 14 * VertexNormal.itemSearchResultCount, 463, 77, 0);
                    if(HuffmanEncoding.inputInputMessage.length() != 0) {
                        if((VertexNormal.itemSearchResultCount ^ 0xffffffff) == -1)
                            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub6.aClass1_2097, 239, 40, 0);
                    } else
                        Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class35.aClass1_1747, 239, 40, 255);
                    class40_sub5_sub14_sub1.method686((Class40_Sub5_Sub17_Sub6.method832(-122, new RSString[]{HuffmanEncoding.inputInputMessage, Class19.aClass1_478})), 239, 90, 0);
                    Rasterizer.drawHorizontalLine(0, 77, 479, 0);
                }
            } else {
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Landscape.aClass1_1174, 239, 40, 0);
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686((Class40_Sub5_Sub17_Sub6.method832(73, new RSString[]{HuffmanEncoding.inputInputMessage, Class19.aClass1_478})), 239, 60, 128);
            }
        } else {
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(HuffmanEncoding.aClass1_1563, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub5_Sub17_Sub6.method832(-117, (new RSString[]{HuffmanEncoding.aClass1_1565, (Class19.aClass1_478)})), 239, 60, 128);
        }
        anInt1357++;
        if(Class4.menuOpen && (Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -3)
            Class40_Sub5_Sub6.method588(-1);
        Class45.method908((byte) 122);

    }

    public static void method980(int arg0, CacheIndex arg1, boolean arg2, CacheIndex arg3) {

        Class40_Sub3.aCacheIndex_2037 = arg3;
        Class35.aBoolean1734 = arg2;
        anInt1351++;
        if(arg0 == 28987)
            RSString.aCacheIndex_1705 = arg1;

    }

    public static void method981(byte arg0) {

        aClass1_1354 = null;
        varbitmasks = null;
        aByteArrayArray1377 = null;
        aClass1_1365 = null;
        aClass1_1374 = null;
        aClass9_1364 = null;
        anIntArray1358 = null;
        if(arg0 == -120) {
            aByteArrayArray1370 = null;
            aClass1_1378 = null;
            cmd_clientdrop = null;
            aCacheIndex_1375 = null;
        }

    }
}
