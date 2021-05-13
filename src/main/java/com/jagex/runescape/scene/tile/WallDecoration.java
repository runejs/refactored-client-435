package com.jagex.runescape.scene.tile;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.tab.parts.TabParts;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.InteractiveObject;

import java.awt.*;

public class WallDecoration {
    public static int durationHoveredOverWidget = 0;
    public static NodeCache modelCache = new NodeCache(50);
    public static TypeFace fontNormal;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1270;

    public int configBits;
    public int z;
    public Renderable renderable;
    public int face;
    public int config = 0;
    public int y;
    public int x;
    public int hash = 0;

    public static void method949() {
        if (IncomingPackets.incomingPacket == 49) {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_0_ = OverlayDefinition.placementY + (i & 0x7);
            int i_1_ = ((0x7b & i) >> 4) + MovedStatics.placementX;
            int i_2_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_3_ = i_2_ >> 2;
            int i_4_ = 0x3 & i_2_;
            int i_5_ = Npc.anIntArray3304[i_3_];
            int i_6_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            if (i_1_ >= 0 && i_0_ >= 0 && i_1_ < 103 && i_0_ < 103) {
                int i_7_ = MovedStatics.tile_height[Player.worldLevel][i_1_][i_0_];
                int i_8_ = MovedStatics.tile_height[Player.worldLevel][i_1_ + 1][i_0_];
                int i_9_ = MovedStatics.tile_height[Player.worldLevel][1 + i_1_][1 + i_0_];
                int i_10_ = MovedStatics.tile_height[Player.worldLevel][i_1_][i_0_ + 1];
                if (i_5_ == 0) {
                    Wall wall = Npc.currentScene.method126(Player.worldLevel, i_1_, i_0_);
                    if (wall != null) {
                        int i_11_ = 0x7fff & wall.hash >> 14;
                        if (i_3_ == 2) {
                            wall.primary = new GameObject(i_11_, 2, 4 + i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                            wall.secondary = new GameObject(i_11_, 2, 0x3 & i_4_ + 1, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                        } else
                            wall.primary = new GameObject(i_11_, i_3_, i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                    }
                }
                if (i_5_ == 1) {
                    WallDecoration wallDecoration = Npc.currentScene.getWallDecoration(Player.worldLevel, i_1_, i_0_);
                    if (wallDecoration != null)
                        wallDecoration.renderable = new GameObject((0x1fffe268 & wallDecoration.hash) >> 14, 4, 0, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                }
                if (i_5_ == 2) {
                    InteractiveObject interactiveObject = Npc.currentScene.method107(Player.worldLevel, i_1_, i_0_);
                    if (i_3_ == 11)
                        i_3_ = 10;
                    if (interactiveObject != null)
                        interactiveObject.renderable = new GameObject(interactiveObject.hash >> 14 & 0x7fff, i_3_, i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                }
                if (i_5_ == 3) {
                    FloorDecoration floorDecoration = Npc.currentScene.getFloorDecoration(Player.worldLevel, i_1_, i_0_);
                    if (floorDecoration != null)
                        floorDecoration.renderable = new GameObject(0x7fff & floorDecoration.hash >> 14, 22, i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                }
            }
        } else if (IncomingPackets.incomingPacket == 241) { // set landscape object
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_12_ = i & 0x3;
            int i_13_ = i >> 2;
            int i_14_ = Npc.anIntArray3304[i_13_];
            int objectId = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_16_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_17_ = (0x7 & i_16_) + OverlayDefinition.placementY;
            int i_18_ = MovedStatics.placementX + ((i_16_ & 0x75) >> 4);
            if (i_18_ >= 0 && i_17_ >= 0 && i_18_ < 104 && i_17_ < 104)
                GameObjectDefinition.method609(objectId, i_18_, i_12_, -1, Player.worldLevel, i_17_, i_14_, i_13_, 0);
        } else {
            if (IncomingPackets.incomingPacket == 9) {
                int offset = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int localX = (offset & 0x7) + OverlayDefinition.placementY;
                int localY = (0x7 & offset >> 4) + MovedStatics.placementX;
                int soundId = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();

                int soundData = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int radius = soundData >> 4 & 0xf;
                int volume = 0x7 & soundData;
                int delay = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                if (localY >= 0 && localX >= 0 && localY < 104 && localX < 104) {
                    int i_26_ = 1 + radius;
                    if (Player.localPlayer.pathY[0] >= localY - i_26_ && Player.localPlayer.pathY[0] <= localY + i_26_ && localX - i_26_ <= Player.localPlayer.pathX[0] && localX + i_26_ >= Player.localPlayer.pathX[0] && RSCanvas.anInt65 != 0 && volume > 0 && PacketBuffer.currentSound < 50) {
                        IdentityKit.sound[PacketBuffer.currentSound] = soundId;
                        ItemDefinition.soundVolume[PacketBuffer.currentSound] = volume;
                        Class40_Sub3.soundDelay[PacketBuffer.currentSound] = delay;
                        PacketBuffer.effects[PacketBuffer.currentSound] = null;
                        MovedStatics.anIntArray1916[PacketBuffer.currentSound] = radius + (localX << 8) + (localY << 16);
                        PacketBuffer.currentSound++;
                    }
                }
            }
            if (IncomingPackets.incomingPacket == 202) {
                int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_27_ = ((0x78 & i) >> 4) + MovedStatics.placementX;
                int i_28_ = OverlayDefinition.placementY + (0x7 & i);
                int i_29_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                int i_30_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_31_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                if (i_27_ >= 0 && i_28_ >= 0 && i_27_ < 104 && i_28_ < 104) {
                    i_28_ = 128 * i_28_ + 64;
                    i_27_ = i_27_ * 128 + 64;
                    Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = new Class40_Sub5_Sub17_Sub6(i_29_, Player.worldLevel, i_27_, i_28_, -i_30_ + Class37.getFloorDrawHeight(Player.worldLevel, i_27_, i_28_), i_31_, MovedStatics.pulseCycle);
                    Class57.aLinkedList_1332.pushBack(class40_sub5_sub17_sub6, -111);
                }
            } else if (IncomingPackets.incomingPacket == 99) {
                int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_32_ = MovedStatics.placementX + ((0x75 & i) >> 4);
                int i_33_ = (i & 0x7) + OverlayDefinition.placementY;
                int i_34_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                int i_36_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                if (i_32_ >= 0 && i_33_ >= 0 && i_32_ < 104 && i_33_ < 104) {
                    LinkedList linkedList = Wall.groundItems[Player.worldLevel][i_32_][i_33_];
                    if (linkedList != null) {
                        for (Item item = (Item) linkedList.method902((byte) -90); item != null; item = (Item) linkedList.method909(-4)) {
                            if (item.itemId == (i_34_ & 0x7fff) && i_35_ == item.itemCount) {
                                item.itemCount = i_36_;
                                break;
                            }
                        }
                        FramemapDefinition.spawnGroundItem(i_33_, i_32_);
                    }
                }
            } else if (IncomingPackets.incomingPacket == 143) { // remove landscape object
                int offset = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int positionY = OverlayDefinition.placementY + (0x7 & offset);
                int positionX = MovedStatics.placementX + (offset >> 4 & 0x7);
                int objectInfo = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int orientation = objectInfo & 0x3;
                int typeIndex = objectInfo >> 2;
                int objectType = Npc.anIntArray3304[typeIndex];
                if (positionX >= 0 && positionY >= 0 && positionX < 104 && positionY < 104)
                    GameObjectDefinition.method609(-1, positionX, orientation, -1, Player.worldLevel, positionY, objectType, typeIndex, 0);
            } else {
                if (IncomingPackets.incomingPacket == 229) {
                    int i = IncomingPackets.incomingPacketBuffer.getByte();
                    int i_43_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_44_ = IncomingPackets.incomingPacketBuffer.getByte();
                    int i_45_ = IncomingPackets.incomingPacketBuffer.getByte();
                    int i_46_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_47_ = i_46_ & 0x3;
                    int i_48_ = i_46_ >> 2;
                    int i_49_ = Npc.anIntArray3304[i_48_];
                    int i_50_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_51_ = (i_50_ & 0x7) + OverlayDefinition.placementY;
                    int i_52_ = MovedStatics.placementX + (i_50_ >> 4 & 0x7);
                    int i_53_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_54_ = IncomingPackets.incomingPacketBuffer.getByte();
                    int i_55_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                    int i_56_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                    Player class40_sub5_sub17_sub4_sub1;
                    if (i_43_ != PlayerAppearance.anInt708)
                        class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_43_];
                    else
                        class40_sub5_sub17_sub4_sub1 = Player.localPlayer;
                    if (class40_sub5_sub17_sub4_sub1 != null) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_55_);
                        int i_57_ = MovedStatics.tile_height[Player.worldLevel][i_52_][i_51_];
                        int i_58_ = MovedStatics.tile_height[Player.worldLevel][i_52_][1 + i_51_];
                        int i_59_ = MovedStatics.tile_height[Player.worldLevel][1 + i_52_][1 + i_51_];
                        int i_60_ = MovedStatics.tile_height[Player.worldLevel][i_52_ + 1][i_51_];
                        Model class40_sub5_sub17_sub5 = gameObjectDefinition.createTerrainObjectModel(i_59_, i_58_, i_47_, i_57_, i_48_, i_60_);
                        if (class40_sub5_sub17_sub5 != null) {
                            if (i < i_54_) {
                                int i_61_ = i_54_;
                                i_54_ = i;
                                i = i_61_;
                            }
                            if (i_44_ < i_45_) {
                                int i_62_ = i_45_;
                                i_45_ = i_44_;
                                i_44_ = i_62_;
                            }
                            GameObjectDefinition.method609(-1, i_52_, 0, 1 + i_56_, Player.worldLevel, i_51_, i_49_, 0, 1 + i_53_);
                            class40_sub5_sub17_sub4_sub1.anInt3274 = i_56_ + MovedStatics.pulseCycle;
                            int i_63_ = gameObjectDefinition.sizeX;
                            class40_sub5_sub17_sub4_sub1.playerModel = class40_sub5_sub17_sub5;
                            class40_sub5_sub17_sub4_sub1.anInt3283 = i_53_ + MovedStatics.pulseCycle;
                            int i_64_ = gameObjectDefinition.sizeY;
                            if (i_47_ == 1 || i_47_ == 3) {
                                i_64_ = gameObjectDefinition.sizeX;
                                i_63_ = gameObjectDefinition.sizeY;
                            }
                            class40_sub5_sub17_sub4_sub1.anInt3271 = i_52_ * 128 + 64 * i_63_;
                            class40_sub5_sub17_sub4_sub1.anInt3291 = i_51_ * 128 + 64 * i_64_;
                            class40_sub5_sub17_sub4_sub1.anInt3272 = Class37.getFloorDrawHeight(Player.worldLevel, class40_sub5_sub17_sub4_sub1.anInt3271, class40_sub5_sub17_sub4_sub1.anInt3291);
                            class40_sub5_sub17_sub4_sub1.anInt3281 = i_45_ + i_51_;
                            class40_sub5_sub17_sub4_sub1.anInt3258 = i_52_ + i_54_;
                            class40_sub5_sub17_sub4_sub1.anInt3262 = i_52_ + i;
                            class40_sub5_sub17_sub4_sub1.anInt3289 = i_44_ + i_51_;
                        }
                    }
                }
                if (IncomingPackets.incomingPacket == 74) { // remove world item
                    int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_65_ = MovedStatics.placementX + (i >> 4 & 0x7);
                    int i_66_ = (i & 0x7) + OverlayDefinition.placementY;
                    int i_67_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    if (i_65_ >= 0 && i_66_ >= 0 && i_65_ < 104 && i_66_ < 104) {
                        LinkedList linkedList = Wall.groundItems[Player.worldLevel][i_65_][i_66_];
                        if (linkedList != null) {
                            for (Item item = (Item) linkedList.method902((byte) -90); item != null; item = (Item) linkedList.method909(-4)) {
                                if ((0x7fff & i_67_) == item.itemId) {
                                    item.remove();
                                    break;
                                }
                            }
                            if (linkedList.method902((byte) -90) == null)
                                Wall.groundItems[Player.worldLevel][i_65_][i_66_] = null;
                            FramemapDefinition.spawnGroundItem(i_66_, i_65_);
                        }
                    }
                } else if (IncomingPackets.incomingPacket == 1) {
                    int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_68_ = (i & 0x7) + OverlayDefinition.placementY;
                    int i_69_ = MovedStatics.placementX + (0x7 & i >> 4);
                    int i_70_ = i_69_ + IncomingPackets.incomingPacketBuffer.getByte();
                    int i_71_ = i_68_ + IncomingPackets.incomingPacketBuffer.getByte();
                    int i_72_ = IncomingPackets.incomingPacketBuffer.getShortBE();
                    int i_73_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_74_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte() * 4;
                    int i_75_ = 4 * IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_76_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_77_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_78_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_79_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    if (i_69_ >= 0 && i_68_ >= 0 && i_69_ < 104 && i_68_ < 104 && i_70_ >= 0 && i_71_ >= 0 && i_70_ < 104 && i_71_ < 104 && i_73_ != 65535) {
                        i_70_ = 64 + 128 * i_70_;
                        i_69_ = 64 + 128 * i_69_;
                        i_68_ = i_68_ * 128 + 64;
                        Class40_Sub5_Sub17_Sub1 class40_sub5_sub17_sub1 = new Class40_Sub5_Sub17_Sub1(i_73_, Player.worldLevel, i_69_, i_68_, Class37.getFloorDrawHeight(Player.worldLevel, i_69_, i_68_) + -i_74_, i_76_ + MovedStatics.pulseCycle, i_77_ + MovedStatics.pulseCycle, i_78_, i_79_, i_72_, i_75_);
                        i_71_ = 128 * i_71_ + 64;
                        class40_sub5_sub17_sub1.method766(i_76_ + MovedStatics.pulseCycle, 0, i_71_, -i_75_ + Class37.getFloorDrawHeight(Player.worldLevel, i_70_, i_71_), i_70_);
                        Class43.aLinkedList_1022.pushBack(class40_sub5_sub17_sub1, -73);
                    }
                } else {
                    if (IncomingPackets.incomingPacket == 19) { // update world item amount
                        int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                        int i_80_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                        int i_81_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                        int i_82_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                        int i_83_ = ((0x71 & i_82_) >> 4) + MovedStatics.placementX;
                        int i_84_ = (0x7 & i_82_) + OverlayDefinition.placementY;
                        if (i_83_ >= 0 && i_84_ >= 0 && i_83_ < 104 && i_84_ < 104 && PlayerAppearance.anInt708 != i_80_) {
                            Item item = new Item();
                            item.itemId = i_81_;
                            item.itemCount = i;
                            if (Wall.groundItems[Player.worldLevel][i_83_][i_84_] == null)
                                Wall.groundItems[Player.worldLevel][i_83_][i_84_] = new LinkedList();
                            Wall.groundItems[Player.worldLevel][i_83_][i_84_].pushBack(item, 64);
                            FramemapDefinition.spawnGroundItem(i_84_, i_83_);
                        }
                    } else if (IncomingPackets.incomingPacket == 175) { // add world item
                        int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                        int i_85_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                        int i_86_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                        int i_87_ = OverlayDefinition.placementY + (i_86_ & 0x7);
                        int i_88_ = MovedStatics.placementX + ((0x7a & i_86_) >> 4);
                        if (i_88_ >= 0 && i_87_ >= 0 && i_88_ < 104 && i_87_ < 104) {
                            Item item = new Item();
                            item.itemCount = i_85_;
                            item.itemId = i;
                            if (Wall.groundItems[Player.worldLevel][i_88_][i_87_] == null)
                                Wall.groundItems[Player.worldLevel][i_88_][i_87_] = new LinkedList();
                            Wall.groundItems[Player.worldLevel][i_88_][i_87_].pushBack(item, -118);
                            FramemapDefinition.spawnGroundItem(i_87_, i_88_);
                        }
                    }
                }
            }
        }
    }

    public static void method950(int soundId, int volume, int delay) {
        if (MovedStatics.anInt200 != 0 && volume != 0 && PacketBuffer.currentSound < 50) {
            IdentityKit.sound[PacketBuffer.currentSound] = soundId;
            ItemDefinition.soundVolume[PacketBuffer.currentSound] = volume;
            Class40_Sub3.soundDelay[PacketBuffer.currentSound] = delay;
            PacketBuffer.effects[PacketBuffer.currentSound] = null;
            MovedStatics.anIntArray1916[PacketBuffer.currentSound] = 0;
            PacketBuffer.currentSound++;
        }
    }

    public static void drawLoadingScreen(int arg0, TypeFace fontBold, TypeFace fontSmall) {
        do {
            MovedStatics.loginBoxGraphics.prepareRasterizer();
//            Rasterizer.drawFilledRectangle(0,0, ScreenController.frameWidth, ScreenController.frameHeight, 0);
            if (Class51.currentAction == 0 || Class51.currentAction == 5) {
                int i = 20;
                fontBold.drawStringLeft(English.runeScapeIsLoadingPleaseWait, 180, 74 + -i, 16777215);
                int i_89_ = -i + 82;
                Rasterizer.drawUnfilledRectangle(28, i_89_, 304, 34, 9179409);
                Rasterizer.drawUnfilledRectangle(29, 1 + i_89_, 302, 32, 0);
                Rasterizer.drawFilledRectangle(30, 2 + i_89_, MovedStatics.anInt1607 * 3, 30, 9179409);
                Rasterizer.drawFilledRectangle(3 * MovedStatics.anInt1607 + 30, i_89_ + 2, -(MovedStatics.anInt1607 * 3) + 300, 30, 0);
                fontBold.drawStringLeft(Native.currentLoadingText, 180, -i + 105, 16777215);
            }
            if (Class51.currentAction == 20) {
                int drawY = 40;
                Class40_Sub5_Sub15.loginScreenBox.drawImage(0, 0);
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, drawY, 16776960, true);
                drawY += 15;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, drawY, 16776960, true);
                drawY += 15;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, drawY, 16776960, true);
                drawY += 15;
                drawY += 10;
                fontBold.drawShadowedString(English.username + Native.username, 90, drawY, true, 16777215);
                drawY += 15;
                fontBold.drawShadowedString(English.password + Native.password.method61(), 92, drawY, true, 16777215);
                drawY += 15;
            }
            if (Class51.currentAction == 10) {
                Class40_Sub5_Sub15.loginScreenBox.drawImage(0, 0);
                if (Class26.loginScreenState == 0) {
                    fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 80, 16776960, true);
                    int drawX = 100;
                    int drawY = 120;
                    Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY - 20);
                    fontBold.drawText(English.newUser, drawX + -73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);
                    drawX = 260;
                    Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY + -20);
                    fontBold.drawText(English.existingUser, drawX - 73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);
                } else if (Class26.loginScreenState == 2) {
                    int y1 = 40;
                    int drawX = 100;
                    fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, y1, 16776960, true);
                    y1 += 15;
                    int y2 = 150;
                    fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, y1, 16776960, true);
                    y1 += 15;
                    fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, y1, 16776960, true);
                    y1 += 15;
                    y1 += 10;
                    int width = fontBold.getStringWidth(English.username + Native.username + Native.justAnotherYellowBar);
                    int offset = 0;
                    while (width > 250) {
                        offset++;
                        width = fontBold.getStringWidth(English.username + Native.username.substring(offset) + Native.justAnotherYellowBar);
                    }
                    fontBold.drawShadowedString(English.username + Native.username.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & MovedStatics.loginScreenFocus == 0 ? Native.justAnotherYellowBar : ""), 90, y1, true, 16777215);
                    y1 += 15;
                    String starredPassword = Native.password.method61().toString();
                    width = fontBold.getStringWidth(English.password + starredPassword + Native.justAnotherYellowBar);
                    offset = 0;
                    while (width > 250) {
                        offset++;
                        width = fontBold.getStringWidth(English.password + starredPassword.substring(offset) + Native.justAnotherYellowBar);
                    }
                    fontBold.drawShadowedString(English.password + starredPassword.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & MovedStatics.loginScreenFocus == 1 ? Native.justAnotherYellowBar : ""), 92, y1, true, 16777215);
                    Class59.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                    y1 += 15;
                    fontBold.drawShadowedStringCenter(English.login, drawX, y2 + 5, 16777215, true);
                    drawX = 260;
                    Class59.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                    fontBold.drawShadowedStringCenter(English.cancel, drawX, 5 + y2, 16777215, true);
                } else if (Class26.loginScreenState == 3) {
                    fontBold.drawShadowedStringCenter(English.createAFreeAccount, 180, 40, 16776960, true);
                    int i = 180;
                    int i_92_ = 150;
                    int i_93_ = 65;

                    for(int textIndex = 0; textIndex < English.createAccountText.length; textIndex++) {
                        fontBold.drawShadowedStringCenter(English.createAccountText[textIndex], 180, i_93_, 16777215, true);
                        i_93_ += 15;
                    }

                    Class59.imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                    fontBold.drawShadowedStringCenter(English.cancel, i, 5 + i_92_, 16777215, true);
                }
            }
            ProducingGraphicsBuffer.muteButton.prepareRasterizer();
            ImageRGB musicIcon = TabParts.GetPart("music");
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            if(RSCanvas.musicVolume == 0) {
                Rasterizer.drawDiagonalLine(0,0, 42,42, 0xFF0000);
            }
            Main.renderFlames();
            try {



                Graphics graphics = MouseHandler.gameCanvas.getGraphics();
                ProducingGraphicsBuffer.muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);

                MovedStatics.loginBoxGraphics.drawGraphics(202, 171, graphics);
                if (arg0 != -19010)
                    method949();
                Class8.flameLeftBackground.drawGraphics(0, 0, graphics);
                GameObject.flameRightBackground.drawGraphics(637, 0, graphics);

                if (!MovedStatics.clearScreen)
                    break;
                MovedStatics.clearScreen = false;

                Class39.aProducingGraphicsBuffer_907.drawGraphics(128, 0, graphics);
                Class51.aProducingGraphicsBuffer_1206.drawGraphics(202, 371, graphics);
                Class17.aProducingGraphicsBuffer_463.drawGraphics(0, 265, graphics);
                KeyFocusListener.aProducingGraphicsBuffer_1285.drawGraphics(562, 265, graphics);
                GameObjectDefinition.aProducingGraphicsBuffer_2524.drawGraphics(128, 171, graphics);
                ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.drawGraphics(562, 171, graphics);
                ProducingGraphicsBuffer.muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);


            } catch (Exception exception) {
                MouseHandler.gameCanvas.repaint();
            }
            break;

        } while (false);
    }

}
