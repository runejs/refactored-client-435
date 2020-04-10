package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.cache.media.Widget.WidgetType;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.*;

public class Class27 {
    public static RSString aClass1_638 = RSString.CreateString("invback");
    public static RSString aClass1_643 = RSString.CreateString(")2");
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array649;
    public static CacheIndex aCacheIndex_654;
    public static int minimapState = 0;
    public static RSString takeString = RSString.CreateString("Take");
    public static RSString aClass1_664 = RSString.CreateString("Offline");
    public static RSString takeStringInstance = takeString;
    public static int[] anIntArray666 = new int[]{1, 0, -1, 0};
    public static RSString aClass1_668 = RSString.CreateString("Loading game screen )2 ");
    public SubNode aClass40_Sub5_660 = new SubNode();

    public Class27() {
        aClass40_Sub5_660.aClass40_Sub5_2087 = aClass40_Sub5_660;
        aClass40_Sub5_660.aClass40_Sub5_2082 = aClass40_Sub5_660;
    }

    public static void method353(byte arg0) {
        Class40_Sub5_Sub11.anInt2628++;
        Class40_Sub5_Sub17_Sub6.method833(0, true);
        ItemDefinition.method749(true);
        Class40_Sub5_Sub17_Sub6.method833(0, false);
        ItemDefinition.method749(false);
        HashTable.method335((byte) 61);
        Class61.method1000(true);
        if(!Class39.aBoolean906) {
            int i = Class65.cameraVertical;
            if(Class40_Sub6.secondaryCameraVertical / 256 > i)
                i = Class40_Sub6.secondaryCameraVertical / 256;
            int i_0_ = 0x7ff & GroundItemTile.cameraHorizontal + Class57.anInt1342;
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[4] && 128 + GameShell.anIntArray2[4] > i)
                i = 128 + GameShell.anIntArray2[4];
            Class49.setCameraPosition(i, Class40_Sub5_Sub6.currentCameraPositionH, -50 + (Class37.getFloorDrawHeight(Player.worldLevel, (Player.localPlayer.worldX), (Player.localPlayer.worldY))), i_0_, Class34.currentCameraPositionV, -1, 3 * i + 600);
        }
        int i;
        if(!Class39.aBoolean906)
            i = Class40_Sub5_Sub17_Sub1.method764((byte) -107);
        else
            i = Class40_Sub5_Sub1.method546(256);
        int i_1_ = Class12.cameraX;
        int i_2_ = Class68_Sub1.anInt2210;
        int i_3_ = SceneCluster.cameraZ;
        int i_4_ = Class26.anInt627;
        int i_5_ = Class40_Sub5_Sub6.cameraY;
        for(int i_6_ = 0; i_6_ < 5; i_6_++) {
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_6_]) {
                int i_7_ = (int) (((double) (Class8.anIntArray297[i_6_] * 2 + 1) * Math.random()) - (double) Class8.anIntArray297[i_6_] + (Math.sin((double) (Class22_Sub1.anIntArray1846[i_6_]) * ((double) (GroundItemTile.anIntArray1358[i_6_]) / 100.0)) * (double) GameShell.anIntArray2[i_6_]));
                if(i_6_ == 1)
                    SceneCluster.cameraZ += i_7_;
                if(i_6_ == 0) {
                    Class12.cameraX += i_7_;
                }
                if(i_6_ == 2)
                    Class40_Sub5_Sub6.cameraY += i_7_;
                if(i_6_ == 4) {
                    Class26.anInt627 += i_7_;
                    if(Class26.anInt627 < 128)
                        Class26.anInt627 = 128;
                    if(Class26.anInt627 > 383)
                        Class26.anInt627 = 383;
                }
                if(i_6_ == 3)
                    Class68_Sub1.anInt2210 = 0x7ff & i_7_ + Class68_Sub1.anInt2210;
            }
        }
        Class65.method1018();
        Model.cursorY = Landscape.mouseY - 4;
        Model.gameScreenClickable = true;
        Model.cursorX = Class13.mouseX - 4;
        Model.resourceCount = 0;
        Rasterizer.clear();
        Npc.currentScene.render(Class12.cameraX, SceneCluster.cameraZ, Class40_Sub5_Sub6.cameraY, Class26.anInt627, Class68_Sub1.anInt2210, i);
        Npc.currentScene.clearInteractiveObjectCache();
        Class33.method404((byte) -28);
        Class38_Sub1.method450((byte) -67);
        ((Class35) Rasterizer3D.anInterface3_2939).method425((byte) 6, Class5.anInt199);
        KeyFocusListener.draw3dScreen();
        Console.console.drawConsole();
        Console.console.drawConsoleArea();
        if(ISAAC.aBoolean519 && method368((byte) -41, false, true) == 0)
            ISAAC.aBoolean519 = false;
        if(ISAAC.aBoolean519) {
            Class65.method1018();
            Rasterizer.clear();
            Class51.method940(0, Class67.aClass1_1585, false, null);
        }

        Player.method792(110);
        Class12.cameraX = i_1_;
        Class40_Sub5_Sub6.cameraY = i_5_;
        Class68_Sub1.anInt2210 = i_2_;
        Class26.anInt627 = i_4_;
        SceneCluster.cameraZ = i_3_;
        if(arg0 >= -98)
            Widget.drawScrollBar(0, -27, 3, 10, 23, -36);
    }

    public static void method356() {
        aClass40_Sub5_Sub14_Sub4Array649 = null;
        takeString = null;
        aCacheIndex_654 = null;
        aClass1_638 = null;
        aClass1_668 = null;
        takeStringInstance = null;
        anIntArray666 = null;
        aClass1_664 = null;
        aClass1_643 = null;
    }

    public static void method357(CacheIndex arg0, int arg1, CacheIndex arg2) {
        GroundItemTile.aCacheIndex_1375 = arg2;
        ActorDefinition.count = GroundItemTile.aCacheIndex_1375.method190(9);

        Class67.aCacheIndex_1577 = arg0;
        if(arg1 == -10978)
            return;
        drawGameScreen();

    }

    public static void processMenuActions(int arg0, int arg1) {
        if(arg1 >= 0) {
            int i = InteractiveObject.firstMenuOperand[arg1];
            int i_10_ = Class59.secondMenuOperand[arg1];
            int action = Class38.menuActionTypes[arg1];
            if(action >= 2000)
                action -= 2000;
            int i_12_ = Class33.selectedMenuActions[arg1];
            if(ChatBox.inputType != 0 && action != 1005) {
                ChatBox.inputType = 0;
                ChatBox.redrawChatbox = true;
            }
            if(action == 37) {
                SceneCluster.packetBuffer.putPacket(21);
                SceneCluster.packetBuffer.putIntLE(Class60.anInt1417);
                SceneCluster.packetBuffer.putIntME2(i_10_);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                SceneCluster.packetBuffer.putShortBE(i);
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                GenericTile.anInt1233 = i;
                RSRuntimeException.anInt1651 = 0;
                if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                Class30.anInt704 = i_10_;
                if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 38) {
                boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                if(!bool)
                    bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                OverlayDefinition.crossIndex = 0;
                Class40_Sub5_Sub1.crossY = RSString.clickY;
                Class40_Sub11.crossX = Class57.clickX;
                LinkedList.crossType = 2;
                SceneCluster.packetBuffer.putPacket(190);
                SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
            }
            if(action == 1004) {
                Class40_Sub5_Sub1.crossY = RSString.clickY;
                Class40_Sub11.crossX = Class57.clickX;
                LinkedList.crossType = 2;
                OverlayDefinition.crossIndex = 0;
                SceneCluster.packetBuffer.putPacket(148);
                SceneCluster.packetBuffer.putShortLE(i_12_ >> 14 & 0x7fff);
            }
            if(action == 27) {
                AnimationSequence.method596(i, i_12_, (byte) -79, i_10_);
                SceneCluster.packetBuffer.putPacket(229);
                SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + i);
                SceneCluster.packetBuffer.putShortLE((0x1ffffd20 & i_12_) >> 14);
                SceneCluster.packetBuffer.putShortLE(Class26.baseY + i_10_);
            }
            if(action == 1) {
                Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    Class40_Sub11.crossX = Class57.clickX;
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    Class40_Sub5_Sub1.crossY = RSString.clickY;
                    SceneCluster.packetBuffer.putPacket(221);
                    SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                }
            }
            if(action == 26 || action == 46) {
                RSString class1 = Landscape.menuActionTexts[arg1];
                int i_13_ = class1.contains(Class26.aClass1_620);
                if(i_13_ != -1) {
                    class1 = class1.substring(i_13_ + 5).trim();
                    RSString class1_14_ = class1.method62().method85();
                    boolean bool = false;
                    for(int i_15_ = 0; i_15_ < Player.localPlayerCount; i_15_++) {
                        Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[Player.trackedPlayerIndices[i_15_]]);
                        if(class40_sub5_sub17_sub4_sub1 != null && (class40_sub5_sub17_sub4_sub1.playerName != null) && class40_sub5_sub17_sub4_sub1.playerName.equalsIgnoreCase(class1_14_)) {
                            bool = true;
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub1.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub1.pathX[0]), 2);
                            if(action == 26) {
                                SceneCluster.packetBuffer.putPacket(96);
                                SceneCluster.packetBuffer.putShortBE(Player.trackedPlayerIndices[i_15_]);
                            }
                            if(action == 46) {
                                SceneCluster.packetBuffer.putPacket(68);
                                SceneCluster.packetBuffer.putShortLE(Player.trackedPlayerIndices[i_15_]);
                            }
                            break;
                        }
                    }
                    if(!bool)
                        Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings(new RSString[]{English.unableToFind, class1_14_})), 0);
                }
            }
            if(action == 55) {
                SceneCluster.packetBuffer.putPacket(26);
                SceneCluster.packetBuffer.putShortBE(i);
                SceneCluster.packetBuffer.putIntLE(i_10_);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                Class30.anInt704 = i_10_;
                RSRuntimeException.anInt1651 = 0;
                GenericTile.anInt1233 = i;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == HuffmanEncoding.openScreenWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 53) {
                SceneCluster.packetBuffer.putPacket(38);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                SceneCluster.packetBuffer.putShortLE(i);
                SceneCluster.packetBuffer.putIntME1(i_10_);
                GenericTile.anInt1233 = i;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                RSRuntimeException.anInt1651 = 0;
                Class30.anInt704 = i_10_;
                if(i_10_ >> 16 == HuffmanEncoding.openScreenWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 57) {
                SceneCluster.packetBuffer.putPacket(64);
                SceneCluster.packetBuffer.putIntBE(i_10_);
                Widget widget = Widget.forId(i_10_);
                if(widget.clientScripts != null && widget.clientScripts[0][0] == 5) {
                    int i_16_ = widget.clientScripts[0][1];
                    if(widget.alternateRhs[0] != GroundItemTile.varbitmasks[i_16_]) {
                        GroundItemTile.varbitmasks[i_16_] = widget.alternateRhs[0];
                        Class22.method309(-1, i_16_);
                        ISAAC.redrawTabArea = true;
                    }
                }
            }
            if(action == 52) {
                SceneCluster.packetBuffer.putPacket(240);
                SceneCluster.packetBuffer.putShortLE(i);
                SceneCluster.packetBuffer.putShortLE(i_12_);
                SceneCluster.packetBuffer.putIntME2(i_10_);
                GenericTile.anInt1233 = i;
                Class30.anInt704 = i_10_;
                RSRuntimeException.anInt1651 = 0;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == HuffmanEncoding.openScreenWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
            }
            if(action == 10) {
                Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    Class40_Sub11.crossX = Class57.clickX;
                    LinkedList.crossType = 2;
                    Class40_Sub5_Sub1.crossY = RSString.clickY;
                    OverlayDefinition.crossIndex = 0;
                    SceneCluster.packetBuffer.putPacket(68);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                }
            }
            if(action == 14) {
                Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    Class40_Sub5_Sub1.crossY = RSString.clickY;
                    Class40_Sub11.crossX = Class57.clickX;
                    SceneCluster.packetBuffer.putPacket(96);
                    SceneCluster.packetBuffer.putShortBE(i_12_);
                }
            }
            if(action == 1001) {
                Class40_Sub11.crossX = Class57.clickX;
                LinkedList.crossType = 2;
                Class40_Sub5_Sub1.crossY = RSString.clickY;
                OverlayDefinition.crossIndex = 0;
                Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    ActorDefinition class40_sub5_sub5 = class40_sub5_sub17_sub4_sub2.actorDefinition;
                    if(class40_sub5_sub5.childrenIds != null)
                        class40_sub5_sub5 = class40_sub5_sub5.getChildDefinition(-1);
                    if(class40_sub5_sub5 != null) {
                        SceneCluster.packetBuffer.putPacket(247);
                        SceneCluster.packetBuffer.putShortLE(class40_sub5_sub5.id);
                    }
                }
            }
            if(action == 22) {
                Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    Class40_Sub11.crossX = Class57.clickX;
                    LinkedList.crossType = 2;
                    Class40_Sub5_Sub1.crossY = RSString.clickY;
                    OverlayDefinition.crossIndex = 0;
                    SceneCluster.packetBuffer.putPacket(110);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                    SceneCluster.packetBuffer.putIntME1(ISAAC.anInt525);
                    SceneCluster.packetBuffer.putShortBE(Class49.anInt1154);
                    SceneCluster.packetBuffer.putShortBE(LinkedList.anInt1061);
                }
            }
            if(action == 19) {
                Class49.anInt1154 = i_12_;
                LinkedList.anInt1061 = i;
                ISAAC.anInt525 = i_10_;
                Class8.itemSelected = 1;
                Npc.aClass1_3295 = (RSString.linkRSStrings((new RSString[]{VertexNormal.aClass1_1114, ItemDefinition.forId(i_12_, 10).name, Class26.aClass1_620})));
                Main.widgetSelected = 0;
                if(Npc.aClass1_3295 == null)
                    Npc.aClass1_3295 = GameShell.aClass1_34;
                ISAAC.redrawTabArea = true;
            } else {
                if(action == 15) {
                    boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                    if(!bool)
                        bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    Class40_Sub5_Sub1.crossY = RSString.clickY;
                    Class40_Sub11.crossX = Class57.clickX;
                    SceneCluster.packetBuffer.putPacket(168);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                    SceneCluster.packetBuffer.putShortBE(SpotAnimDefinition.baseX + i);
                    SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                    SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                }
                if(action == 23) {
                    SceneCluster.packetBuffer.putPacket(64);
                    SceneCluster.packetBuffer.putIntBE(i_10_);
                    Widget widget = Widget.forId(i_10_);
                    if(widget.clientScripts != null && widget.clientScripts[0][0] == 5) {
                        int i_17_ = widget.clientScripts[0][1];
                        GroundItemTile.varbitmasks[i_17_] = -GroundItemTile.varbitmasks[i_17_] + 1;
                        Class22.method309(-1, i_17_);
                        ISAAC.redrawTabArea = true;
                    }
                }
                if(action == 48) {
                    SceneCluster.packetBuffer.putPacket(147);
                    SceneCluster.packetBuffer.putShortBE(i_12_);
                    SceneCluster.packetBuffer.putShortLE(i);
                    SceneCluster.packetBuffer.putIntLE(i_10_);
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                    GenericTile.anInt1233 = i;
                    Class30.anInt704 = i_10_;
                    if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                    if(ChatBox.openChatboxWidgetId == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    RSRuntimeException.anInt1651 = 0;
                }
                if(action == 18) {
                    RSString class1 = Landscape.menuActionTexts[arg1];
                    int i_18_ = class1.contains(Class26.aClass1_620);
                    if(i_18_ != -1) {
                        long l = class1.substring(5 + i_18_).trim().method58((byte) 107);
                        int i_19_ = -1;
                        for(int i_20_ = 0; i_20_ < Item.friendsCount; i_20_++) {
                            if(Class59.aLongArray1397[i_20_] == l) {
                                i_19_ = i_20_;
                                break;
                            }
                        }
                        if(i_19_ != -1 && Class40_Sub7.friendWorlds[i_19_] > 0) {
                            Class37.anInt876 = 3;
                            ChatBox.redrawChatbox = true;
                            ChatBox.inputType = 0;
                            HuffmanEncoding.chatMessage = HuffmanEncoding.blank_string;
                            ChatBox.messagePromptRaised = true;
                            PacketBuffer.aLong2241 = Class59.aLongArray1397[i_19_];
                            HuffmanEncoding.aClass1_1563 = (RSString.linkRSStrings(new RSString[]{Class35.aClass1_1746, (Class40_Sub11.friendUsernames[i_19_])}));
                        }
                    }
                }
                if(action == 1003) {
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    Class40_Sub5_Sub1.crossY = RSString.clickY;
                    Class40_Sub11.crossX = Class57.clickX;
                    SceneCluster.packetBuffer.putPacket(151);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                }
                if(action == 1002) {
                    AnimationSequence.method596(i, i_12_, (byte) -11, i_10_);
                    SceneCluster.packetBuffer.putPacket(62);
                    SceneCluster.packetBuffer.putShortBE((0x1fffd05d & i_12_) >> 14);
                    SceneCluster.packetBuffer.putShortLE(i_10_ + Class26.baseY);
                    SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                }
                if(action == 30) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                        OverlayDefinition.crossIndex = 0;
                        Class40_Sub11.crossX = Class57.clickX;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        LinkedList.crossType = 2;
                        SceneCluster.packetBuffer.putPacket(57);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                    }
                }
                if(action == 49) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                        Class40_Sub11.crossX = Class57.clickX;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        SceneCluster.packetBuffer.putPacket(208);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortBE(Class49.anInt1154);
                        SceneCluster.packetBuffer.putShortLE(LinkedList.anInt1061);
                        SceneCluster.packetBuffer.putIntBE(ISAAC.anInt525);
                    }
                }
                if(action == 29) {
                    AnimationSequence.method596(i, i_12_, (byte) -77, i_10_);
                    SceneCluster.packetBuffer.putPacket(164);
                    SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + i);
                    SceneCluster.packetBuffer.putShortLE(Class26.baseY + i_10_);
                    SceneCluster.packetBuffer.putShortLE(i_12_ >> 14 & 0x7fff);
                }
                if(action == 5 && AnimationSequence.method596(i, i_12_, (byte) -104, i_10_)) {
                    SceneCluster.packetBuffer.putPacket(24);
                    SceneCluster.packetBuffer.putShortLE(i_10_ + Class26.baseY);
                    SceneCluster.packetBuffer.putShortBE(Class49.anInt1154);
                    SceneCluster.packetBuffer.putShortLE((i_12_ & 0x1fffccf7) >> 14);
                    SceneCluster.packetBuffer.putShortLE(LinkedList.anInt1061);
                    SceneCluster.packetBuffer.putIntME1(ISAAC.anInt525);
                    SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                }
                if(action == 34) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, (Player.localPlayer.pathX[0]), class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        Class40_Sub11.crossX = Class57.clickX;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(0);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                    }
                }
                if(action == 56) {
                    SceneCluster.packetBuffer.putPacket(40);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                    SceneCluster.packetBuffer.putShortLE(i);
                    SceneCluster.packetBuffer.putIntLE(i_10_);
                    SceneCluster.packetBuffer.putIntLE(ISAAC.anInt525);
                    SceneCluster.packetBuffer.putShortLE(Class49.anInt1154);
                    SceneCluster.packetBuffer.putShortBE(LinkedList.anInt1061);
                    Class30.anInt704 = i_10_;
                    RSRuntimeException.anInt1651 = 0;
                    GenericTile.anInt1233 = i;
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                    if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                    if(ChatBox.openChatboxWidgetId == i_10_ >> 16)
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                }
                if(action == 33) {
                    Widget widget = Widget.forId(i_10_);
                    ISAAC.redrawTabArea = true;
                    Main.widgetSelected = 1;
                    Class38_Sub1.aClass1_1918 = widget.targetVerb;
                    ItemDefinition.selectedMask = widget.clickMask;
                    Class8.itemSelected = 0;
                    Class60.anInt1417 = i_10_;
                    FloorDecoration.aClass1_611 = (RSString.linkRSStrings(new RSString[]{Landscape.aClass1_1162, widget.spellName, Class26.aClass1_620}));
                    if(ItemDefinition.selectedMask == 16) {
                        IdentityKit.drawTabIcons = true;
                        Class5.currentTabId = 3;
                        ISAAC.redrawTabArea = true;
                    }
                } else {
                    if(action == 1007) {
                        Widget widget = Widget.forId(i_10_);
                        if(widget != null && (widget.aWidgetArray2713 != null) && i != -1)
                            widget = (widget.aWidgetArray2713[i]);
                        if(widget == null || widget.itemAmount < 100000) {
                            SceneCluster.packetBuffer.putPacket(151);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        } else
                            Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings((new RSString[]{HashTable.method334((widget.itemAmount)), Class65.aClass1_1536, (ItemDefinition.forId(i_12_, 10).name)}))), 0);
                    }
                    if(action == 42) {
                        Widget widget = Widget.forId(i_10_);
                        boolean bool = true;
                        if(widget.contentType > 0)
                            bool = Class5.method166((byte) 88, widget);
                        if(bool) {
                            SceneCluster.packetBuffer.putPacket(64);
                            SceneCluster.packetBuffer.putIntBE(i_10_);
                        }
                    }
                    if(action == 31) {
                        SceneCluster.packetBuffer.putPacket(163);
                        SceneCluster.packetBuffer.putShortLE(i);
                        SceneCluster.packetBuffer.putShortLE(i_12_);
                        SceneCluster.packetBuffer.putIntBE(i_10_);
                        GenericTile.anInt1233 = i;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        Class30.anInt704 = i_10_;
                        RSRuntimeException.anInt1651 = 0;
                        if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 12) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub2.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub2.pathX[0]), 2);
                            Class40_Sub11.crossX = Class57.clickX;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            OverlayDefinition.crossIndex = 0;
                            LinkedList.crossType = 2;
                            SceneCluster.packetBuffer.putPacket(63);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 2) {
                        boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                        LinkedList.crossType = 2;
                        OverlayDefinition.crossIndex = 0;
                        Class40_Sub11.crossX = Class57.clickX;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(244);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                        SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                    }
                    if(action == 3) {
                        boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                        OverlayDefinition.crossIndex = 0;
                        Class40_Sub11.crossX = Class57.clickX;
                        LinkedList.crossType = 2;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(85);
                        SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 21) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub2.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub2.pathX[0]), 2);
                            Class40_Sub11.crossX = Class57.clickX;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            OverlayDefinition.crossIndex = 0;
                            LinkedList.crossType = 2;
                            SceneCluster.packetBuffer.putPacket(253);
                            SceneCluster.packetBuffer.putShortBE(i_12_);
                            SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                        }
                    }
                    if(action == 45 || action == 51 || action == 13 || action == 35) {
                        RSString class1 = Landscape.menuActionTexts[arg1];
                        int i_21_ = class1.contains(Class26.aClass1_620);
                        if(i_21_ != -1) {
                            long l = class1.substring(i_21_ + 5).trim().method58((byte) 96);
                            if(action == 45)
                                UnderlayDefinition.method617(l);
                            if(action == 51)
                                Class17.method275(l);
                            if(action == 13)
                                GameShell.method28(l);
                            if(action == 35)
                                Class40_Sub6.method838(0, l);
                        }
                    }
                    if(action == 44) {
                        Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub1.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub1.pathX[0]), 2);
                            LinkedList.crossType = 2;
                            OverlayDefinition.crossIndex = 0;
                            Class40_Sub11.crossX = Class57.clickX;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            SceneCluster.packetBuffer.putPacket(220);
                            SceneCluster.packetBuffer.putShortBE(i_12_);
                        }
                    }
                    if(arg0 < 51)
                        aClass40_Sub5_Sub14_Sub4Array649 = null;
                    if(action == 7) {
                        if(Class4.menuOpen)
                            Npc.currentScene.method120(-4 + i, -4 + i_10_);
                        else
                            Npc.currentScene.method120(Class57.clickX - 4, -4 + RSString.clickY);
                    }
                    if(action == 1006) {
                        Widget widget = Widget.forId(i_10_);
                        if(widget == null || widget.itemAmounts[i] < 100000) {
                            SceneCluster.packetBuffer.putPacket(151);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        } else
                            Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings((new RSString[]{HashTable.method334((widget.itemAmounts[i])), Class65.aClass1_1536, (ItemDefinition.forId(i_12_, 10).name)}))), 0);
                        GenericTile.anInt1233 = i;
                        RSRuntimeException.anInt1651 = 0;
                        Class30.anInt704 = i_10_;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(i_10_ >> 16 == HuffmanEncoding.openScreenWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 17) {
                        AnimationSequence.method596(i, i_12_, (byte) -104, i_10_);
                        SceneCluster.packetBuffer.putPacket(183);
                        SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
                        SceneCluster.packetBuffer.putShortBE(i_12_ >> 14 & 0x7fff);
                        SceneCluster.packetBuffer.putShortBE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 50)
                        Class33.method406(i, i_12_, i_10_, -121);
                    if(action == 40) {
                        Class55.method958(ChatBox.dialogueId);
                        ChatBox.dialogueId = -1;
                        ChatBox.redrawChatbox = true;
                    }
                    if(action == 32 && AnimationSequence.method596(i, i_12_, (byte) -27, i_10_)) {
                        SceneCluster.packetBuffer.putPacket(225);
                        SceneCluster.packetBuffer.putShortBE(i_12_ >> 14 & 0x7fff);
                        SceneCluster.packetBuffer.putShortLE(i_10_ + Class26.baseY);
                        SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 25) {
                        SceneCluster.packetBuffer.putPacket(228);
                        SceneCluster.packetBuffer.putShortLE(i_12_);
                        SceneCluster.packetBuffer.putIntLE(i_10_);
                        SceneCluster.packetBuffer.putShortLE(i);
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        Class30.anInt704 = i_10_;
                        GenericTile.anInt1233 = i;
                    }
                    if(action == 11) {
                        SceneCluster.packetBuffer.putPacket(29);
                        SceneCluster.packetBuffer.putIntME1(i_10_);
                        SceneCluster.packetBuffer.putShortBE(i);
                        SceneCluster.packetBuffer.putShortLE(i_12_);
                        GenericTile.anInt1233 = i;
                        Class30.anInt704 = i_10_;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        RSRuntimeException.anInt1651 = 0;
                    }
                    if(action == 41) {
                        Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub1.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub1.pathX[0]), 2);
                            LinkedList.crossType = 2;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            Class40_Sub11.crossX = Class57.clickX;
                            OverlayDefinition.crossIndex = 0;
                            SceneCluster.packetBuffer.putPacket(187);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 28) {
                        RSString class1 = Landscape.menuActionTexts[arg1];
                        int i_22_ = class1.contains(Class26.aClass1_620);
                        if(i_22_ != -1) {
                            if(HuffmanEncoding.openScreenWidgetId == -1) {
                                PacketBuffer.method516();
                                if(Class34.anInt854 != -1) {
                                    HuffmanEncoding.reportedName = class1.substring(i_22_ + 5).trim();
                                    HuffmanEncoding.reportAbuseInterfaceID = HuffmanEncoding.openScreenWidgetId = Class34.anInt854;
                                    Class67.reportMutePlayer = false;
                                }
                            } else {
                                Class44.addChatMessage(HuffmanEncoding.blank_string, Class37.aClass1_873, 0);
                            }
                        }
                    }
                    if(action == 8) {
                        boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                        Class40_Sub11.crossX = Class57.clickX;
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(65);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
                        SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + i);
                    }
                    if(action == 9)
                        PacketBuffer.method516();
                    if(action == 54 && CacheIndex_Sub1.anInt1819 == -1) {
                        PacketBuffer.method517(0, i_10_);
                        CacheIndex_Sub1.anInt1819 = i_10_;
                    }
                    if(action == 43) {
                        SceneCluster.packetBuffer.putPacket(98);
                        SceneCluster.packetBuffer.putShortBE(i);
                        SceneCluster.packetBuffer.putIntME1(i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        GenericTile.anInt1233 = i;
                        Class30.anInt704 = i_10_;
                        if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 36) {
                        boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        LinkedList.crossType = 2;
                        OverlayDefinition.crossIndex = 0;
                        Class40_Sub11.crossX = Class57.clickX;
                        SceneCluster.packetBuffer.putPacket(27);
                        SceneCluster.packetBuffer.putShortBE(SpotAnimDefinition.baseX + i);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
                    }
                    if(action == 39) {
                        Player class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_12_]);
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub1.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub1.pathX[0]), 2);
                            OverlayDefinition.crossIndex = 0;
                            Class40_Sub11.crossX = Class57.clickX;
                            LinkedList.crossType = 2;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            SceneCluster.packetBuffer.putPacket(211);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 24) {
                        SceneCluster.packetBuffer.putPacket(124);
                        SceneCluster.packetBuffer.putShortBE(i);
                        SceneCluster.packetBuffer.putIntLE(i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        Class30.anInt704 = i_10_;
                        RSRuntimeException.anInt1651 = 0;
                        GenericTile.anInt1233 = i;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(HuffmanEncoding.openScreenWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(ChatBox.openChatboxWidgetId == i_10_ >> 16)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 16) {
                        AnimationSequence.method596(i, i_12_, (byte) -47, i_10_);
                        SceneCluster.packetBuffer.putPacket(30);
                        SceneCluster.packetBuffer.putShortBE(0x7fff & i_12_ >> 14);
                        SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 20) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub2.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub2.pathX[0]), 2);
                            LinkedList.crossType = 2;
                            Class40_Sub11.crossX = Class57.clickX;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            OverlayDefinition.crossIndex = 0;
                            SceneCluster.packetBuffer.putPacket(153);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 47) {
                        boolean bool = (Class38_Sub1.doWalkTo(0, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 0, (Player.localPlayer.pathX[0]), i_10_, 2));
                        if(!bool)
                            bool = (Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), i, 0, false, 0, 1, (Player.localPlayer.pathX[0]), i_10_, 2));
                        Class40_Sub11.crossX = Class57.clickX;
                        Class40_Sub5_Sub1.crossY = RSString.clickY;
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        SceneCluster.packetBuffer.putPacket(172);
                        SceneCluster.packetBuffer.putShortBE(i + SpotAnimDefinition.baseX);
                        SceneCluster.packetBuffer.putShortBE(LinkedList.anInt1061);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putIntME2(ISAAC.anInt525);
                        SceneCluster.packetBuffer.putShortLE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortLE(Class49.anInt1154);
                    }
                    if(action == 6) {
                        SceneCluster.packetBuffer.putPacket(102);
                        SceneCluster.packetBuffer.putIntLE(i_10_);
                        SceneCluster.packetBuffer.putShortLE(i);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        GenericTile.anInt1233 = i;
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        Class30.anInt704 = i_10_;
                        if(i_10_ >> 16 == HuffmanEncoding.openScreenWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        if(i_10_ >> 16 == ChatBox.openChatboxWidgetId)
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    if(action == 4) {
                        Npc class40_sub5_sub17_sub4_sub2 = (Player.npcs[i_12_]);
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Class38_Sub1.doWalkTo(1, 0, (Player.localPlayer.pathY[0]), (class40_sub5_sub17_sub4_sub2.pathY[0]), 0, false, 0, 1, (Player.localPlayer.pathX[0]), (class40_sub5_sub17_sub4_sub2.pathX[0]), 2);
                            LinkedList.crossType = 2;
                            Class40_Sub11.crossX = Class57.clickX;
                            OverlayDefinition.crossIndex = 0;
                            Class40_Sub5_Sub1.crossY = RSString.clickY;
                            SceneCluster.packetBuffer.putPacket(116);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(Class8.itemSelected != 0) {
                        Class8.itemSelected = 0;
                        ISAAC.redrawTabArea = true;
                    }
                    if(Main.widgetSelected != 0) {
                        ISAAC.redrawTabArea = true;
                        Main.widgetSelected = 0;
                    }
                }
            }
        }
    }

    public static IndexedImage method359(RSString arg0, RSString arg1, CacheIndex arg2) {
        int i = arg2.getHash(arg0);
        int i_23_ = arg2.method179(i, arg1);
        return method363(arg2, (byte) -42, i_23_, i);
    }

    public static void method360(byte arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        if(Class68.method1043(arg4)) {
            if(arg0 != 125)
                Widget.drawScrollBar(-118, 12, 65, -60, 59, -24);
            GameShell.method20(arg5, arg3, 0, arg2, arg6, -1, 1, (Widget.interfaces[arg4]), arg1, 0);
            if(Wall.aWidget_353 != null) {
                Widget widget = Wall.aWidget_353;
                Widget widget_24_ = FramemapDefinition.method878(widget);
                if(widget_24_ != null) {
                    int[] is = Class13.method247(widget_24_, (byte) 97);
                    int[] is_25_ = Class13.method247(widget, (byte) 110);
                    int i = (is_25_[1] - is[1] + -Class40_Sub5_Sub11.anInt2621 + Landscape.mouseY);
                    int i_26_ = (-is[0] + is_25_[0] + (Class13.mouseX + -Class40_Sub2.anInt1996));
                    if(i < 0)
                        i = 0;
                    if(widget_24_.originalHeight < i + widget.originalHeight)
                        i = (-widget.originalHeight + widget_24_.originalHeight);
                    if(i_26_ < 0)
                        i_26_ = 0;
                    if((widget_24_.originalWidth < widget.originalWidth + i_26_))
                        i_26_ = (widget_24_.originalWidth - widget.originalWidth);
                    if((Wall.aWidget_353.anObjectArray2669 != null) && (arg2 & 0x200) != 0)
                        Widget.method891(widget.anObjectArray2669, 0, i, widget, i_26_, false);
                    if(SpotAnimDefinition.mouseButtonPressed == 0 && (arg2 & 0x400) != 0) {
                        if(Wall.aWidget_353.anObjectArray2695 != null)
                            Widget.method891((widget.anObjectArray2695), 0, i, widget, i_26_, false);
                        Wall.aWidget_353 = null;
                    }
                }
            }
        }
    }

    public static Widget method361(Widget[] arg0, int arg1, boolean arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg0 == null)
            return null;
        Widget widget = null;
        for(int i = 0; arg0.length > i; i++) {
            Widget widget_27_ = arg0[i];
            if(widget_27_ != null && widget_27_.parentId == arg4) {
                int i_28_ = arg3 + widget_27_.currentY;
                int i_29_ = arg5 + widget_27_.currentX;
                if(i_29_ <= arg6 && i_28_ <= arg1 && (i_29_ + widget_27_.originalWidth > arg6) && ((arg1 < i_28_ + widget_27_.originalHeight)) && !widget_27_.isHidden) {
                    if(widget_27_.id < 0 && arg2 || widget_27_.id >= 0 && !arg2)
                        widget = widget_27_;
                    if(widget_27_.type == WidgetType.LAYER) {
                        Widget widget_30_ = method361(arg0, arg1, arg2, (-widget_27_.scrollPosition + (widget_27_.currentY)), i, (widget_27_.currentX - (widget_27_.anInt2746)), arg6, 398);
                        if(widget_30_ != null)
                            widget = widget_30_;
                        if(arg2 && (widget_27_.aWidgetArray2713) != null) {
                            Widget widget_31_ = (method361((widget_27_.aWidgetArray2713), arg1, arg2, (widget_27_.currentY + -widget_27_.scrollPosition), widget_27_.id, (widget_27_.currentX - widget_27_.anInt2746), arg6, 398));
                            if(widget_31_ != null)
                                widget = widget_31_;
                        }
                    }
                }
            }
        }
        if(arg7 != 398)
            takeStringInstance = null;
        return widget;
    }

    public static IndexedImage method363(CacheIndex arg0, byte arg1, int arg2, int arg3) {
        int i = 106 % ((arg1 - 66) / 53);
        if(!ImageRGB.spriteExists(arg2, arg3, arg0))
            return null;
        return SubNode.method538(0);

    }

    public static void method364(byte arg0, boolean arg1) {
        if(arg0 != -34)
            method368((byte) 123, true, false);
        Class22.anInt537++;
        if(Class22.anInt537 >= 50 || arg1) {
            Class22.anInt537 = 0;
            if(!Class37.aBoolean871 && Class40_Sub6.aClass64_2098 != null) {
                SceneCluster.packetBuffer.putPacket(13);
                try {
                    Class40_Sub6.aClass64_2098.method1010(SceneCluster.packetBuffer.currentPosition, (byte) -19, 0, SceneCluster.packetBuffer.buffer);
                    SceneCluster.packetBuffer.currentPosition = 0;
                } catch(java.io.IOException ioexception) {
                    Class37.aBoolean871 = true;
                }
            }
        }
    }

    public static void drawGameScreen() {
        if(Class40_Sub5_Sub11.clearScreen) {
            Class40_Sub5_Sub11.clearScreen = false;
            ItemDefinition.method742();
            IdentityKit.drawTabIcons = true;
            ChatBox.redrawChatbox = true;
            ISAAC.redrawTabArea = true;
            Cache.redrawChatbox = true;
        }
        method353((byte) -114);

        if(Class4.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 1)
            ISAAC.redrawTabArea = true;
        if(Class29.tabAreaOverlayWidgetId != -1) {
            boolean bool = Renderable.handleSequences(Class29.tabAreaOverlayWidgetId);
            if(bool)
                ISAAC.redrawTabArea = true;
        }
        if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == -3)
            ISAAC.redrawTabArea = true;
        if(SceneTile.activeInterfaceType == 2)
            ISAAC.redrawTabArea = true;
        if(ISAAC.redrawTabArea) {
            ISAAC.redrawTabArea = false;
            Class43.drawTabArea(-29);
        }
        if(ChatBox.openChatboxWidgetId == -1) {
            Class12.chatboxInterface.scrollPosition = -77 + (-ChatBox.chatboxScroll + ChatBox.chatboxScrollMax);
            if(Class13.mouseX > 448 && Class13.mouseX < 560 && Landscape.mouseY > 332)
                Class5.scrollInterface(77, Landscape.mouseY + -357, -17 + Class13.mouseX, ChatBox.chatboxScrollMax, Class12.chatboxInterface, 463, -1, 0);
            int currentScroll = (ChatBox.chatboxScrollMax - 77 - Class12.chatboxInterface.scrollPosition);
            if(currentScroll < 0)
                currentScroll = 0;
            if(currentScroll > ChatBox.chatboxScrollMax + -77)
                currentScroll = -77 + ChatBox.chatboxScrollMax;
            if(currentScroll != ChatBox.chatboxScroll) {
                ChatBox.chatboxScroll = currentScroll;
                ChatBox.redrawChatbox = true;
            }
        }
        if(ChatBox.openChatboxWidgetId == -1 && ChatBox.inputType == 3) {
            Class12.chatboxInterface.scrollPosition = ChatBox.itemSearchScroll;
            int scrollMax = 14 * ChatBox.itemSearchResultCount + 7;
            if(Class13.mouseX > 448 && Class13.mouseX < 560 && Landscape.mouseY > 332)
                Class5.scrollInterface(77, Landscape.mouseY - 357, -17 + Class13.mouseX, scrollMax, Class12.chatboxInterface, 463, -1, 0);
            int currentScroll = Class12.chatboxInterface.scrollPosition;
            if(currentScroll < 0)
                currentScroll = 0;
            if(currentScroll > scrollMax - 77)
                currentScroll = scrollMax - 77;
            if(currentScroll != ChatBox.itemSearchScroll) {
                ChatBox.itemSearchScroll = currentScroll;
                ChatBox.redrawChatbox = true;
            }
        }
        if(ChatBox.openChatboxWidgetId != -1) {
            boolean bool = Renderable.handleSequences(ChatBox.openChatboxWidgetId);
            if(bool)
                ChatBox.redrawChatbox = true;
        }
        if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == 3)
            ChatBox.redrawChatbox = true;
        if(SceneTile.activeInterfaceType == 3)
            ChatBox.redrawChatbox = true;
        if(GameShell.clickToContinueString != null)
            ChatBox.redrawChatbox = true;
        if(Class4.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
            ChatBox.redrawChatbox = true;
        if(ChatBox.redrawChatbox) {
            ChatBox.redrawChatbox = false;
            ChatBox.renderChatbox(true);
            Console.console.drawConsoleArea();
        }
        Class37.renderMinimap(true);


        if(Class51.anInt1205 != -1)
            IdentityKit.drawTabIcons = true;
        if(IdentityKit.drawTabIcons) {
            if(Class51.anInt1205 != -1 && Class51.anInt1205 == Class5.currentTabId) {
                Class51.anInt1205 = -1;
                SceneCluster.packetBuffer.putPacket(44);
                SceneCluster.packetBuffer.putByte(Class5.currentTabId);
            }
            IdentityKit.drawTabIcons = false;
            Class40_Sub3.aBoolean2026 = true;
            Class40_Sub2.method527(Class5.currentTabId, 4, Class40_Sub5_Sub11.tabWidgetIds, (Class29.tabAreaOverlayWidgetId == -1), (Node.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1));
        }
        if(Cache.redrawChatbox) {
            Class40_Sub3.aBoolean2026 = true;
            Cache.redrawChatbox = false;
            GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
        }

        Landscape.method934((Player.localPlayer.worldX), Player.worldLevel, Class5.anInt199, (Player.localPlayer.worldY));
        Class5.anInt199 = 0;

    }

    public static void method366(int arg1) {
        if(arg1 == -3)
            Class33.method411(Node.aClass1_956, GenericTile.aClass1_1218, SceneTile.aClass1_2057, (byte) -121);
        else if(arg1 == -2)
            Class33.method411(Node.aClass1_934, Node.aClass1_969, Class40_Sub5_Sub6.aClass1_2462, (byte) 93);
        else if(arg1 == -1)
            Class33.method411(Node.aClass1_949, Class33.aClass1_799, SceneTile.aClass1_2053, (byte) 115);
        else if(arg1 == 3)
            Class33.method411(Node.aClass1_941, Node.aClass1_974, ISAAC.aClass1_526, (byte) -65);
        else if(arg1 == 4)
            Class33.method411(Node.aClass1_976, Class64.aClass1_1526, Cache.aClass1_323, (byte) -33);
        else if(arg1 != 5) {
            if(arg1 == 6)
                Class33.method411(Node.aClass1_930, Class40_Sub5_Sub6.aClass1_2460, Class65.aClass1_1538, (byte) 112);
            else if(arg1 == 7)
                Class33.method411(Node.aClass1_953, Class57.aClass1_1339, English.pleaseUseADifferentWorld, (byte) 105);
            else if(arg1 != 8) {
                if(arg1 == 9)
                    Class33.method411(Node.aClass1_942, Actor.aClass1_3138, Item.aClass1_3050, (byte) 104);
                else if(arg1 == 10)
                    Class33.method411(Node.aClass1_952, Class42.aClass1_1002, IdentityKit.aClass1_2615, (byte) 87);
                else if(arg1 == 11)
                    Class33.method411(Node.aClass1_943, Class42.aClass1_1001, Class40_Sub6.aClass1_2111, (byte) 110);
                else if(arg1 == 12)
                    Class33.method411(Node.aClass1_931, FramemapDefinition.aClass1_2188, VarbitDefinition.aClass1_2357, (byte) 115);
                else if(arg1 == 13)
                    Class33.method411(Node.aClass1_972, Item.aClass1_3066, SceneTile.aClass1_2042, (byte) -53);
                else if(arg1 != 14) {
                    if(arg1 != 16) {
                        if(arg1 != 17) {
                            if(arg1 != 18) {
                                if(arg1 == 20)
                                    Class33.method411(Node.aClass1_944, Class55.aClass1_1298, (SceneTile.aClass1_2047), (byte) 126);
                                else if(arg1 == 22)
                                    Class33.method411(Node.aClass1_955, (OverlayDefinition.aClass1_2325), CacheIndex.aClass1_258, (byte) -123);
                                else if(arg1 == 23)
                                    Class33.method411(Node.aClass1_957, Class38.aClass1_882, (ActorDefinition.aClass1_2410), (byte) -128);
                                else if(arg1 != 24) {
                                    if(arg1 == 25)
                                        Class33.method411(Node.aClass1_973, Class8.aClass1_278, SceneTile.aClass1_2050, (byte) -84);
                                    else if(arg1 == 26)
                                        Class33.method411(Node.aClass1_960, English.thisComputersAddressHasBeenBlocked, English.asItWasUsedToBreakOurRules, (byte) 103);
                                    else if(arg1 != 27)
                                        Class33.method411(Node.aClass1_946, (English.unexpectedServerResponse), SceneTile.aClass1_2054, (byte) 123);
                                    else
                                        Class33.method411(Node.aClass1_945, Node.aClass1_925, FramemapDefinition.aClass1_2189, (byte) 103);
                                } else
                                    Class33.method411(Node.aClass1_954, Class60.aClass1_1416, Class5.aClass1_193, (byte) 117);
                            } else
                                Class33.method411(Node.aClass1_963, Main.aClass1_1781, Class34.aClass1_817, (byte) 96);
                        } else
                            Class33.method411(Node.aClass1_959, Landscape.aClass1_1178, Class61.aClass1_1421, (byte) -85);
                    } else
                        Class33.method411(Node.aClass1_924, Buffer.aClass1_1983, English.pleaseWait5MinutesBeforeTryingAgain, (byte) -29);
                } else
                    Class33.method411(Node.aClass1_929, Wall.aClass1_344, ActorDefinition.aClass1_2401, (byte) -68);
            } else
                Class33.method411(Node.aClass1_937, Class42.aClass1_997, Class68_Sub1.aClass1_2209, (byte) -76);
        } else
            Class33.method411(Node.aClass1_966, English.yourAccountIsAlreadyLoggedIn, Player.aClass1_3286, (byte) -101);
        OverlayDefinition.method559(10);
    }

    public static int method368(byte arg0, boolean arg1, boolean arg2) {
        int i = 0;
        if(arg2)
            i += Class17.anInt464 + Class68.anInt1618;
        if(arg0 != -41)
            aClass40_Sub5_Sub14_Sub4Array649 = null;
        if(arg1)
            i += Class42.anInt1006 + HashTable.anInt554;
        return i;
    }

    public SubNode method351() {
        SubNode class40_sub5 = aClass40_Sub5_660.aClass40_Sub5_2082;
        if(class40_sub5 == aClass40_Sub5_660)
            return null;
        class40_sub5.method539();
        return class40_sub5;
    }

    public void method352(int arg0, SubNode arg1) {
        if(arg1.aClass40_Sub5_2087 != null)
            arg1.method539();
        arg1.aClass40_Sub5_2082 = aClass40_Sub5_660;
        arg1.aClass40_Sub5_2087 = aClass40_Sub5_660.aClass40_Sub5_2087;
        arg1.aClass40_Sub5_2087.aClass40_Sub5_2082 = arg1;
        arg1.aClass40_Sub5_2082.aClass40_Sub5_2087 = arg1;
        if(arg0 <= 97)
            method361(null, 14, false, 78, 114, 98, -51, -54);
    }

    public SubNode method362(int arg0) {
        if(arg0 >= -73)
            aClass1_638 = null;
        SubNode class40_sub5 = aClass40_Sub5_660.aClass40_Sub5_2082;
        if(class40_sub5 == aClass40_Sub5_660)
            return null;
        return class40_sub5;
    }

    public void method367(boolean arg0, SubNode arg1) {
        if(arg1.aClass40_Sub5_2087 != null)
            arg1.method539();
        arg1.aClass40_Sub5_2082 = aClass40_Sub5_660.aClass40_Sub5_2082;
        arg1.aClass40_Sub5_2087 = aClass40_Sub5_660;
        arg1.aClass40_Sub5_2087.aClass40_Sub5_2082 = arg1;
        if(!arg0)
            method360((byte) -126, -26, -36, -4, -38, 92, -45);
        arg1.aClass40_Sub5_2082.aClass40_Sub5_2087 = arg1;
    }
}
