package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.FloorDecoration;

public class Npc extends Actor {
    public static int anInt3294 = 0;
    public static RSString aClass1_3295 = null;
    public static boolean aBoolean3298;
    public static Scene aScene_3301;
    public static RSString aClass1_3302 = RSString.CreateString("Sichtbare Karte vorbereitet)3");
    public static int[] anIntArray3304 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    public static RSString aClass1_3305 = RSString.CreateString("Connection lost");
    public static RSString aClass1_3307 = RSString.CreateString("Keine Antwort vom Server)3");
    public static RSString aClass1_3308 = RSString.CreateString("gr-Un:");
    public static RSString aClass1_3309 = RSString.CreateString("Hierhin gehen");
    public static RSString aClass1_3311 = RSString.CreateString("On");
    public static int[] anIntArray3312;
    public ActorDefinition actorDefinition;

    public static Class40_Sub5_Sub11 method795(byte arg0, int arg1) {
        Class40_Sub5_Sub11 class40_sub5_sub11 = ((Class40_Sub5_Sub11) Class13.aClass9_406.get((long) arg1, (byte) 98));
        if(arg0 >= -66)
            aClass1_3295 = null;
        if(class40_sub5_sub11 != null)
            return class40_sub5_sub11;
        byte[] is = Class64.aCacheIndex_1521.getFile(arg1, 16);
        class40_sub5_sub11 = new Class40_Sub5_Sub11();
        if(is != null)
            class40_sub5_sub11.method634(new Buffer(is), 0);
        Class13.aClass9_406.put(-7208, (long) arg1, class40_sub5_sub11);
        return class40_sub5_sub11;
    }

    public static void method796(byte arg0) {
        if(Class40_Sub5_Sub15.anInt2782 > 1)
            Class40_Sub5_Sub15.anInt2782--;
        if(Class32.anInt771 > 0)
            Class32.anInt771--;
        if(Class37.aBoolean871) {
            Class37.aBoolean871 = false;
            Class59.dropClient(2578);
        } else {
            for(int i = 0; i < 100; i++) {
                if(!IncomingPackets.parseIncomingPackets(false))
                    break;
            }
            if(Class51.anInt1197 == 30 || Class51.anInt1197 == 35) {
                if(ISAAC.aBoolean519 && Class51.anInt1197 == 30) {
                    SpotAnimDefinition.anInt2302 = 0;
                    GameFrame.clickType = 0;
                    while(Class34.method416((byte) -104)) {
                        /* empty */
                    }
                    for(int i = 0; i < Class40_Sub5_Sub17_Sub3.aBooleanArray3056.length; i++)
                        Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i] = false;
                }
                Class40_Sub5_Sub6.putHackCheckPacket(-12, 205, Class32.packetBuffer);
                synchronized(Class12.mouseCapturer.objectLock) {
                    if(Class22.accountFlagged) {
                        if(GameFrame.clickType != 0 || Class12.mouseCapturer.coord >= 40) {
                            int coordinateCount = 0;
                            Class32.packetBuffer.putPacket(210);
                            Class32.packetBuffer.putByte(0);
                            int originalOffset = Class32.packetBuffer.currentPosition;
                            for(int c = 0; c < Class12.mouseCapturer.coord; c++) {
                                if((-originalOffset + Class32.packetBuffer.currentPosition) >= 240)
                                    break;
                                coordinateCount++;
                                int pixelOffset = Class12.mouseCapturer.coordsY[c];
                                if(pixelOffset >= 0) {
                                    if(pixelOffset > 502)
                                        pixelOffset = 502;
                                } else
                                    pixelOffset = 0;
                                int x = Class12.mouseCapturer.coordsX[c];
                                if(x < 0)
                                    x = 0;
                                else if(x > 764)
                                    x = 764;
                                int y = pixelOffset * 765 + x;
                                if(Class12.mouseCapturer.coordsY[c] == -1 && Class12.mouseCapturer.coordsX[c] == -1) {
                                    x = -1;
                                    y = -1;
                                    pixelOffset = 0x7ffff;
                                }
                                if(x == PacketBuffer.lastClickX && y == GameObjectDefinition.lastClickY) {
                                    if(Class22_Sub2.duplicateClickCount < 2047)
                                        Class22_Sub2.duplicateClickCount++;
                                } else {
                                    int differenceX = x - PacketBuffer.lastClickX;
                                    PacketBuffer.lastClickX = x;
                                    int differenceY = pixelOffset - GameObjectDefinition.lastClickY;
                                    GameObjectDefinition.lastClickY = pixelOffset;
                                    if(Class22_Sub2.duplicateClickCount < 8 && differenceX >= -32 && differenceX <= 31 && differenceY >= -32 && differenceY <= 31) {
                                        differenceX += 32;
                                        differenceY += 32;
                                        Class32.packetBuffer.putShortBE((differenceY + (differenceX << 6) + (Class22_Sub2.duplicateClickCount << 12)));
                                        Class22_Sub2.duplicateClickCount = 0;
                                    } else if(Class22_Sub2.duplicateClickCount < 8) {
                                        Class32.packetBuffer.putMediumBE((y + 8388608 + (Class22_Sub2.duplicateClickCount << 19)));
                                        Class22_Sub2.duplicateClickCount = 0;
                                    } else {
                                        Class32.packetBuffer.putIntBE(((Class22_Sub2.duplicateClickCount << 19) + -1073741824 + y));
                                        Class22_Sub2.duplicateClickCount = 0;
                                    }
                                }
                            }
                            Class32.packetBuffer.finishVarByte(Class32.packetBuffer.currentPosition + -originalOffset);
                            if(coordinateCount < Class12.mouseCapturer.coord) {
                                Class12.mouseCapturer.coord -= coordinateCount;
                                for(int i_9_ = 0; ((Class12.mouseCapturer.coord > i_9_)); i_9_++) {
                                    Class12.mouseCapturer.coordsX[i_9_] = (Class12.mouseCapturer.coordsX[coordinateCount + i_9_]);
                                    Class12.mouseCapturer.coordsY[i_9_] = (Class12.mouseCapturer.coordsY[i_9_ + coordinateCount]);
                                }
                            } else
                                Class12.mouseCapturer.coord = 0;
                        }
                    } else {
                        Class12.mouseCapturer.coord = 0;
                    }
                }
                if(GameFrame.clickType != 0) {
                    VarbitDefinition.anInt2363++;
                    long l = ((GameObjectDefinition.aLong2561 - Class51.aLong1203) / 50L);
                    int i = Class57.anInt1338;
                    int i_10_ = RSString.anInt1668;
                    Class51.aLong1203 = GameObjectDefinition.aLong2561;
                    if(i >= 0) {
                        if(i > 764)
                            i = 764;
                    } else
                        i = 0;
                    if(i_10_ >= 0) {
                        if(i_10_ > 502)
                            i_10_ = 502;
                    } else
                        i_10_ = 0;
                    int i_11_ = 0;
                    if(GameFrame.clickType == 2)
                        i_11_ = 1;
                    if(l > 4095)
                        l = 4095L;
                    int i_12_ = (int) l;
                    Class32.packetBuffer.putPacket(234);
                    int i_13_ = i_10_ * 765 + i;
                    Class32.packetBuffer.putIntLE(((i_11_ << 19) + ((i_12_ << 20) + i_13_)));
                }
                if(InteractiveObject.anInt487 > 0)
                    InteractiveObject.anInt487--;
                if(Class40_Sub5_Sub17_Sub3.aBooleanArray3056[96] || Class40_Sub5_Sub17_Sub3.aBooleanArray3056[97] || Class40_Sub5_Sub17_Sub3.aBooleanArray3056[98] || Class40_Sub5_Sub17_Sub3.aBooleanArray3056[99])
                    HashTable.aBoolean565 = true;
                if(HashTable.aBoolean565 && InteractiveObject.anInt487 <= 0) {
                    Class13.anInt415++;
                    InteractiveObject.anInt487 = 20;
                    HashTable.aBoolean565 = false;
                    Class32.packetBuffer.putPacket(58);
                    Class32.packetBuffer.putShortBE(GroundItemTile.cameraHorizontal);
                    Class32.packetBuffer.putShortBE(Class65.anInt1537);
                }
                if(HashTable.aBoolean571 && !Class35.aBoolean1735) {
                    Class60.anInt1406++;
                    Class35.aBoolean1735 = true;
                    Class32.packetBuffer.putPacket(160);
                    Class32.packetBuffer.putByte(1);
                }
                if(!HashTable.aBoolean571 && Class35.aBoolean1735) {
                    Class35.aBoolean1735 = false;
                    Class60.anInt1406++;
                    Class32.packetBuffer.putPacket(160);
                    Class32.packetBuffer.putByte(0);
                }
                Class45.method910(-32322);
                if(Class51.anInt1197 == 30 || Class51.anInt1197 == 35) {
                    Class40_Sub5_Sub13.method652((byte) 0);
                    Class4.method161(128);
                    Class35.anInt1728++;
                    if(Class35.anInt1728 > 750)
                        Class59.dropClient(2578);
                    else {
                        Class17.method276(-1);
                        Class8.method209();
                        Class22_Sub1.method313(54);
                        if(Class45.anInt1075 != 0) {
                            OverlayDefinition.anInt2319 += 20;
                            if(OverlayDefinition.anInt2319 >= 400)
                                Class45.anInt1075 = 0;
                        }
                        if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType != 0) {
                            RSRuntimeException.anInt1651++;
                            if(RSRuntimeException.anInt1651 >= 15) {
                                if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == 2)
                                    ISAAC.redrawTabArea = true;
                                if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == 3)
                                    Class52.redrawChatbox = true;
                                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 0;
                            }
                        }
                        Class5.anInt199++;
                        if(SceneTile.activeInterfaceType != 0) {
                            Buffer.anInt1978++;
                            if(((Class13.mouseX > Renderable.anInt2869 + 5)) || ((Renderable.anInt2869 + -5 > Class13.mouseX)) || ((ItemDefinition.anInt2798 + 5 < Landscape.mouseY)) || (ItemDefinition.anInt2798 - 5 > Landscape.mouseY))
                                Class40_Sub5_Sub15.aBoolean2784 = true;
                            if(SpotAnimDefinition.anInt2302 == 0) {
                                if(SceneTile.activeInterfaceType == 3)
                                    Class52.redrawChatbox = true;
                                if(SceneTile.activeInterfaceType == 2)
                                    ISAAC.redrawTabArea = true;
                                SceneTile.activeInterfaceType = 0;
                                if(!Class40_Sub5_Sub15.aBoolean2784 || Buffer.anInt1978 < 5) {
                                    if((Class68.anInt1630 == 1 || (Class33.method409((byte) 63, (ActorDefinition.anInt2394 - 1)))) && ActorDefinition.anInt2394 > 2)
                                        Class60.method990(11451);
                                    else if(ActorDefinition.anInt2394 > 0)
                                        Class27.method358(123, (-1 + (ActorDefinition.anInt2394)));
                                } else {
                                    RSRuntimeException.lastActiveInvInterface = -1;
                                    Class43.method894(false);
                                    if((RSRuntimeException.lastActiveInvInterface == Class48.modifiedWidgetId) && (Class55.mouseInvInterfaceIndex != GroundItemTile.selectedInventorySlot)) {
                                        Widget childInterface = Widget.forId((Class48.modifiedWidgetId));
                                        int moveItemInsertionMode = 0;
                                        if((Class43.bankInsertMode == 1) && (childInterface.contentType == 206))
                                            moveItemInsertionMode = 1;
                                        if((childInterface.items[Class55.mouseInvInterfaceIndex]) <= 0)
                                            moveItemInsertionMode = 0;
                                        if(childInterface.itemDeletesDraged) {
                                            int i_16_ = Class55.mouseInvInterfaceIndex;
                                            int i_17_ = GroundItemTile.selectedInventorySlot;
                                            childInterface.items[i_16_] = (childInterface.items[i_17_]);
                                            childInterface.itemAmounts[i_16_] = (childInterface.itemAmounts[i_17_]);
                                            childInterface.items[i_17_] = -1;
                                            childInterface.itemAmounts[i_17_] = 0;
                                        } else if(moveItemInsertionMode == 1) {
                                            int slotStart = GroundItemTile.selectedInventorySlot;
                                            int slotEnd = Class55.mouseInvInterfaceIndex;
                                            while(slotEnd != slotStart) {
                                                if(slotStart <= slotEnd) {
                                                    if((slotStart < slotEnd)) {
                                                        childInterface.swapItems(1 + slotStart, false, slotStart);
                                                        slotStart++;
                                                    }
                                                } else {
                                                    childInterface.swapItems(-1 + slotStart, false, slotStart);
                                                    slotStart--;
                                                }
                                            }
                                        } else
                                            childInterface.swapItems(Class55.mouseInvInterfaceIndex, false, GroundItemTile.selectedInventorySlot);
                                        Class32.packetBuffer.putPacket(83);
                                        Class32.packetBuffer.putDualByte(moveItemInsertionMode, 128);
                                        Class32.packetBuffer.putCustomNegativeOffsetShortBE(GroundItemTile.selectedInventorySlot, -128);
                                        Class32.packetBuffer.putOffsetShortLE(Class55.mouseInvInterfaceIndex);
                                        Class32.packetBuffer.putIntME2(Class48.modifiedWidgetId);
                                    }
                                }
                                RSRuntimeException.anInt1651 = 10;
                                GameFrame.clickType = 0;
                            }
                        }
                        if(Scene.anInt78 != -1) {
                            int i = Scene.anInt78;
                            int i_18_ = Scene.anInt81;
                            boolean bool = (Class38_Sub1.method448(0, 0, (Player.localPlayer.pathY[0]), i, (byte) 119, 0, true, 0, 0, (Player.localPlayer.pathX[0]), i_18_, 0));
                            if(bool) {
                                Class40_Sub5_Sub1.anInt2276 = RSString.anInt1668;
                                OverlayDefinition.anInt2319 = 0;
                                Class40_Sub11.anInt2163 = Class57.anInt1338;
                                Class45.anInt1075 = 1;
                            }
                            Scene.anInt78 = -1;
                        }
                        if(GameFrame.clickType == 1 && RSApplet.aClass1_8 != null) {
                            GameFrame.clickType = 0;
                            Class52.redrawChatbox = true;
                            RSApplet.aClass1_8 = null;
                        }
                        GameFrame.method1002(-77);
                        if(ActorDefinition.openFullScreenWidgetId == -1) {
                            Class40_Sub5_Sub17_Sub3.method776((byte) -125);
                            Class38_Sub1.method447((byte) 29);
                            Class40_Sub5_Sub1.method544();
                        }
                        if(SpotAnimDefinition.anInt2302 == 1 || GameFrame.clickType == 1)
                            anInt3294++;
                        int i = 34;
                        if(HuffmanEncoding.openScreenWidgetId != -1)
                            Class27.method360((byte) 125, 516, i, 338, HuffmanEncoding.openScreenWidgetId, 4, 4);
                        if(Class29.tabAreaOverlayWidgetId == -1) {
                            if((Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]) != -1)
                                Class27.method360((byte) 125, 743, i, 466, (Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]), 205, 553);
                        } else
                            Class27.method360((byte) 125, 743, i, 466, Class29.tabAreaOverlayWidgetId, 205, 553);
                        if(Class43.openChatboxWidgetId != -1)
                            Class27.method360((byte) 125, 496, i, 453, Class43.openChatboxWidgetId, 357, 17);
                        else if(Class48.anInt1138 != -1)
                            Class27.method360((byte) 125, 496, i, 453, Class48.anInt1138, 357, 17);
                        if(HuffmanEncoding.openScreenWidgetId != -1)
                            Class27.method360((byte) 125, 516, i ^ 0xffffffff, 338, HuffmanEncoding.openScreenWidgetId, 4, 4);
                        if(Class29.tabAreaOverlayWidgetId != -1)
                            Class27.method360((byte) 125, 743, i ^ 0xffffffff, 466, Class29.tabAreaOverlayWidgetId, 205, 553);
                        else if((Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]) != -1)
                            Class27.method360((byte) 125, 743, i ^ 0xffffffff, 466, (Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId]), 205, 553);
                        if(Class43.openChatboxWidgetId != -1)
                            Class27.method360((byte) 125, 496, i ^ 0xffffffff, 453, Class43.openChatboxWidgetId, 357, 17);
                        else if(Class48.anInt1138 != -1)
                            Class27.method360((byte) 125, 496, i ^ 0xffffffff, 453, Class48.anInt1138, 357, 17);
                        if(Class67.anInt1586 != -1 || FloorDecoration.anInt614 != -1 || HashTable.anInt573 != -1) {
                            if(RSString.anInt1711 > WallDecoration.anInt1257) {
                                WallDecoration.anInt1257++;
                                if(RSString.anInt1711 == WallDecoration.anInt1257) {
                                    if(Class67.anInt1586 != -1)
                                        Class52.redrawChatbox = true;
                                    if(FloorDecoration.anInt614 != -1)
                                        ISAAC.redrawTabArea = true;
                                }
                            }
                        } else if(WallDecoration.anInt1257 > 0)
                            WallDecoration.anInt1257--;
                        Class40_Sub5_Sub17_Sub3.method775(false);
                        if(Class39.aBoolean906)
                            Class5.method165(35);
                        for(int i_19_ = 0; i_19_ < 5; i_19_++)
                            Class22_Sub1.anIntArray1846[i_19_]++;
                        Class40_Sub5_Sub6.manageTextInputs();
                        int i_20_ = Class32.method400(-1);
                        int i_21_ = Class17.method274(true);
                        if(i_20_ > 4500 && i_21_ > 4500) {
                            Class32.anInt771 = 250;
                            Class40_Sub5_Sub13.method650(true, 4000);
                            Class32.packetBuffer.putPacket(216);
                        }
                        Player.anInt3264++;
                        Class38_Sub1.anInt1923++;
                        if(arg0 <= 6)
                            loadFloor(-34, 97);
                        if(Class38_Sub1.anInt1923 > 500) {
                            int i_22_ = (int) (8.0 * Math.random());
                            if((0x2 & i_22_) == 2)
                                Class48.anInt1126 += Class68_Sub1.anInt2211;
                            if((i_22_ & 0x1) == 1)
                                Buffer.anInt1976 += Class42.anInt1010;
                            Class38_Sub1.anInt1923 = 0;
                            if((0x4 & i_22_) == 4)
                                Class57.anInt1342 += Class5.anInt195;
                        }
                        if(Class48.anInt1126 < -55)
                            Class68_Sub1.anInt2211 = 2;
                        if(Player.anInt3264 > 500) {
                            int i_23_ = (int) (Math.random() * 8.0);
                            if((0x1 & i_23_) == 1)
                                Class43.cameraYawOffset += Class13.anInt419;
                            if((0x2 & i_23_) == 2)
                                Class51.mapZoomOffset += Main.anInt1766;
                            Player.anInt3264 = 0;
                        }
                        if(Class48.anInt1126 > 55)
                            Class68_Sub1.anInt2211 = -2;
                        if(Buffer.anInt1976 < -50)
                            Class42.anInt1010 = 2;
                        if(Class43.cameraYawOffset < -60)
                            Class13.anInt419 = 2;
                        Class22.anInt537++;
                        if(Buffer.anInt1976 > 50)
                            Class42.anInt1010 = -2;
                        if(Class43.cameraYawOffset > 60)
                            Class13.anInt419 = -2;
                        if(Class57.anInt1342 < -40)
                            Class5.anInt195 = 1;
                        if(Class57.anInt1342 > 40)
                            Class5.anInt195 = -1;
                        if(Class51.mapZoomOffset < -20)
                            Main.anInt1766 = 1;
                        if(Class51.mapZoomOffset > 10)
                            Main.anInt1766 = -1;
                        if(Class22.anInt537 > 50) {
                            Class32.packetBuffer.putPacket(13);
                            Class49.anInt1142++;
                        }
                        do {
                            try {
                                if(Class40_Sub6.aClass64_2098 == null || (Class32.packetBuffer.currentPosition) <= 0)
                                    break;
                                Class40_Sub6.aClass64_2098.method1010(Class32.packetBuffer.currentPosition, (byte) -19, 0, (Class32.packetBuffer.buffer));
                                Class22.anInt537 = 0;
                                Class32.packetBuffer.currentPosition = 0;
                            } catch(java.io.IOException ioexception) {
                                Class59.dropClient(2578);
                                break;
                            }
                            break;
                        } while(false);
                    }
                }
            }
        }
    }

    public static void method797(int arg0) {
        aClass1_3307 = null;
        anIntArray3304 = null;
        aClass1_3305 = null;
        aClass1_3295 = null;
        aClass1_3311 = null;
        aClass1_3308 = null;
        anIntArray3312 = null;
        aClass1_3302 = null;
        aScene_3301 = null;
        aClass1_3309 = null;
        if(arg0 != 210)
            aClass1_3307 = null;
    }

    public static OverlayDefinition loadFloor(int arg0, int arg1) {
        OverlayDefinition overlayDefinition = ((OverlayDefinition) Class33.aClass9_778.get((long) arg0, (byte) 63));
        if(overlayDefinition != null)
            return overlayDefinition;
        byte[] is = Actor.aCacheIndex_3144.getFile(arg0, arg1);
        overlayDefinition = new OverlayDefinition();
        if(is != null)
            overlayDefinition.method553((byte) 65, arg0, new Buffer(is));
        overlayDefinition.method555((byte) 64);
        Class33.aClass9_778.put(-7208, (long) arg0, overlayDefinition);
        return overlayDefinition;
    }

    public static void parseNpcUpdateMasks() {
        for(int i = 0; i < anInt3153; i++) {
            int npcIndex = Class24.anIntArray578[i];
            Npc npc = CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[npcIndex];
            int mask = Cache.outgoingbuffer.getUnsignedByte();
            if((0x1 & mask) != 0) {
                int i_3_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_4_ = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                npc.method785(i_4_, pulseCycle, i_3_, -121);
                npc.anInt3139 = pulseCycle + 300;
                npc.anInt3130 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                npc.anInt3101 = Cache.outgoingbuffer.getUnsignedByte();
            }
            if((0x20 & mask) != 0) {
                npc.anInt3091 = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE();
                int i_5_ = Cache.outgoingbuffer.getIntBE();
                npc.anInt3129 = 0;
                npc.anInt3093 = pulseCycle + (0xffff & i_5_);
                npc.anInt3110 = i_5_ >> 16;
                npc.anInt3140 = 0;
                if(npc.anInt3093 > pulseCycle)
                    npc.anInt3140 = -1;
                if(npc.anInt3091 == 65535)
                    npc.anInt3091 = -1;
            }
            if((mask & 0x4) != 0) {
                npc.facingActorIndex = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                if(npc.facingActorIndex == 65535)
                    npc.facingActorIndex = -1;
            }
            if((0x2 & mask) != 0) {
                int i_6_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_7_ = Cache.outgoingbuffer.getUnsignedByte();
                npc.method785(i_7_, pulseCycle, i_6_, -119);
                npc.anInt3139 = pulseCycle + 300;
                npc.anInt3130 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                npc.anInt3101 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            }
            if((0x40 & mask) != 0) {
                npc.forcedChatMessage = Cache.outgoingbuffer.getRSString();
                npc.anInt3078 = 100;
            }
            if((mask & 0x80) != 0) {
                npc.actorDefinition = ActorDefinition.getDefinition((byte) -122, Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE());
                npc.anInt3083 = (npc.actorDefinition.rotateRightAnimation);
                npc.anInt3113 = (npc.actorDefinition.degreesToTurn);
                npc.turnRightAnimationId = (npc.actorDefinition.rotate90RightAnimation);
                npc.idleAnimation = (npc.actorDefinition.stanceAnimation);
                npc.walkAnimationId = (npc.actorDefinition.walkAnimation);
                npc.standTurnAnimationId = (npc.actorDefinition.rotateLeftAnimation);
                npc.anInt3096 = (npc.actorDefinition.tileSpacesOccupied);
                npc.turnLeftAnimationId = (npc.actorDefinition.rotate90LeftAnimation);
                npc.turnAroundAnimationId = (npc.actorDefinition.rotate180Animation);
            }
            if((mask & 0x8) != 0) {
                npc.facePositionX = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                npc.facePositionY = Cache.outgoingbuffer.getUnsignedShortLE();
            }
            if((0x10 & mask) != 0) {
                int animationId = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                if(animationId == 65535)
                    animationId = -1;
                int animationDelay = Cache.outgoingbuffer.getUnsignedInvertedByte();
                if(animationId == npc.playingAnimation && animationId != -1) {
                    int i_10_ = Class68_Sub1.method1050(animationId, 2).anInt2483;
                    if(i_10_ == 1) {
                        npc.anInt3115 = 0;
                        npc.anInt3095 = 0;
                        npc.anInt3104 = 0;
                        npc.playingAnimationDelay = animationDelay;
                    }
                    if(i_10_ == 2)
                        npc.anInt3095 = 0;
                } else if(animationId == -1 || npc.playingAnimation == -1 || (Class68_Sub1.method1050(animationId, 2).anInt2494 >= (Class68_Sub1.method1050(npc.playingAnimation, 2).anInt2494))) {
                    npc.playingAnimation = animationId;
                    npc.anInt3115 = 0;
                    npc.playingAnimationDelay = animationDelay;
                    npc.anInt3104 = 0;
                    npc.anInt3095 = 0;
                    npc.anInt3094 = npc.anInt3109;
                }
            }
        }
        Class13.anInt409++;
    }

    public Model getRotatedModel(int arg0) {
        if(actorDefinition == null)
            return null;
        int i = 25 % ((41 - arg0) / 47);
        AnimationSequence animationSequence = (playingAnimation == -1 || playingAnimationDelay != 0 ? null : Class68_Sub1.method1050(playingAnimation, 2));
        AnimationSequence animationSequence_0_ = (anInt3077 != -1 && (anInt3077 != idleAnimation || animationSequence == null) ? Class68_Sub1.method1050(anInt3077, 2) : null);
        Model class40_sub5_sub17_sub5 = actorDefinition.getChildModel((byte) -50, animationSequence, animationSequence_0_, anInt3116, anInt3104);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        class40_sub5_sub17_sub5.method799();
        anInt3117 = class40_sub5_sub17_sub5.anInt2861;
        if(anInt3091 != -1 && anInt3140 != -1) {
            Model class40_sub5_sub17_sub5_1_ = SpotAnimDefinition.forId(anInt3091, 13).method549(anInt3140, 2);
            if(class40_sub5_sub17_sub5_1_ != null) {
                class40_sub5_sub17_sub5_1_.translate(0, -anInt3110, 0);
                Model[] class40_sub5_sub17_sub5s = {class40_sub5_sub17_sub5, class40_sub5_sub17_sub5_1_};
                class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, 2, true);
            }
        }
        if(actorDefinition.tileSpacesOccupied == 1)
            class40_sub5_sub17_sub5.singleTile = true;
        return class40_sub5_sub17_sub5;
    }

    public boolean isVisible(int arg0) {
        if(actorDefinition == null)
            return false;
        return arg0 == 1;

    }
}
