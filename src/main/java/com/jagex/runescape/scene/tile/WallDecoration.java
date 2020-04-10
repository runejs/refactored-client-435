package com.jagex.runescape.scene.tile;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.collection.Node;
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
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.InteractiveObject;

import java.awt.*;

public class WallDecoration {
    public static RSString aClass1_1243 = RSString.CreateString("@whi@ )4 ");
    public static Cache aClass9_1247 = new Cache(64);
    public static RSString aClass1_1251;
    public static RSString aClass1_1255 = RSString.CreateString("and choose the (Wcreate account(W");
    public static int anInt1257 = 0;
    public static RSString aClass1_1259;
    public static RSString aClass1_1260 = RSString.CreateString("go back to the main RuneScape webpage");
    public static Cache aClass9_1264 = new Cache(50);
    public static RSString aClass1_1266 = RSString.CreateString("backright2");
    public static long[] ignores = new long[100];
    public static TypeFace fontNormal;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1270;

    static {
        aClass1_1259 = aClass1_1260;
        aClass1_1251 = aClass1_1255;
    }

    public int configBits;
    public int z;
    public Renderable renderable;
    public int face;
    public int config = 0;
    public int y;
    public int x;
    public int hash = 0;

    public static void method949(byte arg0) {
        if(IncomingPackets.incomingPacket == 49) {
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_0_ = OverlayDefinition.placementY + (i & 0x7);
            int i_1_ = ((0x7b & i) >> 4) + Class40_Sub6.placementX;
            int i_2_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_3_ = i_2_ >> 2;
            int i_4_ = 0x3 & i_2_;
            int i_5_ = Npc.anIntArray3304[i_3_];
            int i_6_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
            if(i_1_ >= 0 && i_0_ >= 0 && i_1_ < 103 && i_0_ < 103) {
                int i_7_ = (Class40_Sub6.tile_height[Player.worldLevel][i_1_][i_0_]);
                int i_8_ = (Class40_Sub6.tile_height[Player.worldLevel][i_1_ + 1][i_0_]);
                int i_9_ = (Class40_Sub6.tile_height[Player.worldLevel][1 + i_1_][1 + i_0_]);
                int i_10_ = (Class40_Sub6.tile_height[Player.worldLevel][i_1_][i_0_ + 1]);
                if(i_5_ == 0) {
                    Wall wall = (Npc.currentScene.method126(Player.worldLevel, i_1_, i_0_));
                    if(wall != null) {
                        int i_11_ = 0x7fff & wall.hash >> 14;
                        if(i_3_ == 2) {
                            wall.primary = new GameObject(i_11_, 2, 4 + i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                            wall.secondary = new GameObject(i_11_, 2, 0x3 & i_4_ + 1, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                        } else
                            wall.primary = new GameObject(i_11_, i_3_, i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                    }
                }
                if(i_5_ == 1) {
                    WallDecoration wallDecoration = (Npc.currentScene.getWallDecoration(Player.worldLevel, i_1_, i_0_));
                    if(wallDecoration != null)
                        wallDecoration.renderable = (new GameObject((0x1fffe268 & wallDecoration.hash) >> 14, 4, 0, i_7_, i_8_, i_9_, i_10_, i_6_, false));
                }
                if(i_5_ == 2) {
                    InteractiveObject interactiveObject = (Npc.currentScene.method107(Player.worldLevel, i_1_, i_0_));
                    if(i_3_ == 11)
                        i_3_ = 10;
                    if(interactiveObject != null)
                        interactiveObject.renderable = new GameObject(((interactiveObject.hash >> 14) & 0x7fff), i_3_, i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                }
                if(i_5_ == 3) {
                    FloorDecoration floorDecoration = (Npc.currentScene.getFloorDecoration(Player.worldLevel, i_1_, i_0_));
                    if(floorDecoration != null)
                        floorDecoration.renderable = new GameObject((0x7fff & (floorDecoration.hash >> 14)), 22, i_4_, i_7_, i_8_, i_9_, i_10_, i_6_, false);
                }
            }
        } else if(IncomingPackets.incomingPacket == 241) { // set landscape object
            int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_12_ = i & 0x3;
            int i_13_ = i >> 2;
            int i_14_ = Npc.anIntArray3304[i_13_];
            int i_15_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
            int i_16_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
            int i_17_ = (0x7 & i_16_) + OverlayDefinition.placementY;
            int i_18_ = Class40_Sub6.placementX + ((i_16_ & 0x75) >> 4);
            if(i_18_ >= 0 && i_17_ >= 0 && i_18_ < 104 && i_17_ < 104)
                GameObjectDefinition.method609(i_15_, i_18_, i_12_, -1, (Player.worldLevel), i_17_, i_14_, i_13_, 0);
        } else {
            if(IncomingPackets.incomingPacket == 9) {
                int offset = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int localX = (offset & 0x7) + OverlayDefinition.placementY;
                int localY = (0x7 & offset >> 4) + Class40_Sub6.placementX;
                int soundId = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();

                int soundData = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int radius = soundData >> 4 & 0xf;
                int volume = 0x7 & soundData;
                int delay = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                if(localY >= 0 && localX >= 0 && localY < 104 && localX < 104) {
                    int i_26_ = 1 + radius;
                    if(((Player.localPlayer.pathY[0]) >= localY - i_26_) && ((Player.localPlayer.pathY[0]) <= localY + i_26_) && (localX - i_26_ <= (Player.localPlayer.pathX[0])) && (localX + i_26_ >= (Player.localPlayer.pathX[0])) && RSCanvas.anInt65 != 0 && volume > 0 && PacketBuffer.currentSound < 50) {
                        IdentityKit.sound[(PacketBuffer.currentSound)] = soundId;
                        ItemDefinition.soundVolume[(PacketBuffer.currentSound)] = volume;
                        Class40_Sub3.soundDelay[(PacketBuffer.currentSound)] = delay;
                        PacketBuffer.effects[(PacketBuffer.currentSound)] = null;
                        Class38_Sub1.anIntArray1916[(PacketBuffer.currentSound)] = radius + ((localX << 8) + (localY << 16));
                        PacketBuffer.currentSound++;
                    }
                }
            }
            if(IncomingPackets.incomingPacket == 202) {
                int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_27_ = ((0x78 & i) >> 4) + Class40_Sub6.placementX;
                int i_28_ = OverlayDefinition.placementY + (0x7 & i);
                int i_29_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                int i_30_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_31_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                if(i_27_ >= 0 && i_28_ >= 0 && i_27_ < 104 && i_28_ < 104) {
                    i_28_ = 128 * i_28_ + 64;
                    i_27_ = i_27_ * 128 + 64;
                    Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = (new Class40_Sub5_Sub17_Sub6(i_29_, Player.worldLevel, i_27_, i_28_, (-i_30_ + Class37.getFloorDrawHeight((Player.worldLevel), i_27_, i_28_)), i_31_, Node.pulseCycle));
                    Class57.aLinkedList_1332.pushBack(class40_sub5_sub17_sub6, -111);
                }
            } else if(IncomingPackets.incomingPacket == 99) {
                int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int i_32_ = Class40_Sub6.placementX + ((0x75 & i) >> 4);
                int i_33_ = (i & 0x7) + OverlayDefinition.placementY;
                int i_34_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                int i_36_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                if(i_32_ >= 0 && i_33_ >= 0 && i_32_ < 104 && i_33_ < 104) {
                    LinkedList linkedList = (Wall.groundItems[Player.worldLevel][i_32_][i_33_]);
                    if(linkedList != null) {
                        for(Item item = ((Item) linkedList.method902((byte) -90)); item != null; item = ((Item) linkedList.method909(-4))) {
                            if(item.itemId == (i_34_ & 0x7fff) && (i_35_ == item.itemCount)) {
                                item.itemCount = i_36_;
                                break;
                            }
                        }
                        FramemapDefinition.spawnGroundItem(i_33_, i_32_);
                    }
                }
            } else if(IncomingPackets.incomingPacket == 143) { // remove landscape object
                int offset = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int positionY = OverlayDefinition.placementY + (0x7 & offset);
                int positionX = Class40_Sub6.placementX + (offset >> 4 & 0x7);
                int objectInfo = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                int orientation = objectInfo & 0x3;
                int typeIndex = objectInfo >> 2;
                int objectType = Npc.anIntArray3304[typeIndex];
                if(positionX >= 0 && positionY >= 0 && positionX < 104 && positionY < 104)
                    GameObjectDefinition.method609(-1, positionX, orientation, -1, (Player.worldLevel), positionY, objectType, typeIndex, 0);
            } else {
                if(IncomingPackets.incomingPacket == 229) {
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
                    int i_52_ = Class40_Sub6.placementX + (i_50_ >> 4 & 0x7);
                    int i_53_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_54_ = IncomingPackets.incomingPacketBuffer.getByte();
                    int i_55_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                    int i_56_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                    Player class40_sub5_sub17_sub4_sub1;
                    if(i_43_ != Class30.anInt708)
                        class40_sub5_sub17_sub4_sub1 = (Player.trackedPlayers[i_43_]);
                    else
                        class40_sub5_sub17_sub4_sub1 = (Player.localPlayer);
                    if(class40_sub5_sub17_sub4_sub1 != null) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_55_);
                        int i_57_ = (Class40_Sub6.tile_height[Player.worldLevel][i_52_][i_51_]);
                        int i_58_ = (Class40_Sub6.tile_height[Player.worldLevel][i_52_][1 + i_51_]);
                        int i_59_ = (Class40_Sub6.tile_height[Player.worldLevel][1 + i_52_][1 + i_51_]);
                        int i_60_ = (Class40_Sub6.tile_height[Player.worldLevel][i_52_ + 1][i_51_]);
                        Model class40_sub5_sub17_sub5 = gameObjectDefinition.getGameObjectModel(i_59_, i_58_, i_47_, i_57_, i_48_, i_60_);
                        if(class40_sub5_sub17_sub5 != null) {
                            if((i < i_54_)) {
                                int i_61_ = i_54_;
                                i_54_ = i;
                                i = i_61_;
                            }
                            if(i_44_ < i_45_) {
                                int i_62_ = i_45_;
                                i_45_ = i_44_;
                                i_44_ = i_62_;
                            }
                            GameObjectDefinition.method609(-1, i_52_, 0, 1 + i_56_, Player.worldLevel, i_51_, i_49_, 0, 1 + i_53_);
                            class40_sub5_sub17_sub4_sub1.anInt3274 = i_56_ + Node.pulseCycle;
                            int i_63_ = gameObjectDefinition.sizeX;
                            class40_sub5_sub17_sub4_sub1.aClass40_Sub5_Sub17_Sub5_3265 = class40_sub5_sub17_sub5;
                            class40_sub5_sub17_sub4_sub1.anInt3283 = i_53_ + Node.pulseCycle;
                            int i_64_ = gameObjectDefinition.sizeY;
                            if(i_47_ == 1 || i_47_ == 3) {
                                i_64_ = gameObjectDefinition.sizeX;
                                i_63_ = gameObjectDefinition.sizeY;
                            }
                            class40_sub5_sub17_sub4_sub1.anInt3271 = i_52_ * 128 + 64 * i_63_;
                            class40_sub5_sub17_sub4_sub1.anInt3291 = i_51_ * 128 + (64 * i_64_);
                            class40_sub5_sub17_sub4_sub1.anInt3272 = (Class37.getFloorDrawHeight(Player.worldLevel, class40_sub5_sub17_sub4_sub1.anInt3271, class40_sub5_sub17_sub4_sub1.anInt3291));
                            class40_sub5_sub17_sub4_sub1.anInt3281 = i_45_ + i_51_;
                            class40_sub5_sub17_sub4_sub1.anInt3258 = i_52_ + i_54_;
                            class40_sub5_sub17_sub4_sub1.anInt3262 = i_52_ + i;
                            class40_sub5_sub17_sub4_sub1.anInt3289 = i_44_ + i_51_;
                        }
                    }
                }
                if(IncomingPackets.incomingPacket == 74) { // remove world item
                    int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_65_ = Class40_Sub6.placementX + (i >> 4 & 0x7);
                    int i_66_ = (i & 0x7) + OverlayDefinition.placementY;
                    int i_67_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    if(i_65_ >= 0 && i_66_ >= 0 && i_65_ < 104 && i_66_ < 104) {
                        LinkedList linkedList = (Wall.groundItems[Player.worldLevel][i_65_][i_66_]);
                        if(linkedList != null) {
                            for(Item item = ((Item) linkedList.method902((byte) -90)); item != null; item = ((Item) linkedList.method909(-4))) {
                                if((0x7fff & i_67_) == item.itemId) {
                                    item.method457(-1);
                                    break;
                                }
                            }
                            if(linkedList.method902((byte) -90) == null)
                                Wall.groundItems[Player.worldLevel][i_65_][i_66_] = null;
                            FramemapDefinition.spawnGroundItem(i_66_, i_65_);
                        }
                    }
                } else if(IncomingPackets.incomingPacket == 1) {
                    int i = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_68_ = (i & 0x7) + OverlayDefinition.placementY;
                    int i_69_ = Class40_Sub6.placementX + (0x7 & i >> 4);
                    int i_70_ = (i_69_ + IncomingPackets.incomingPacketBuffer.getByte());
                    int i_71_ = (i_68_ + IncomingPackets.incomingPacketBuffer.getByte());
                    int i_72_ = IncomingPackets.incomingPacketBuffer.getShortBE();
                    int i_73_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_74_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte() * 4;
                    int i_75_ = 4 * IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_76_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_77_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    int i_78_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    int i_79_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                    if(i_69_ >= 0 && i_68_ >= 0 && i_69_ < 104 && i_68_ < 104 && i_70_ >= 0 && i_71_ >= 0 && i_70_ < 104 && i_71_ < 104 && i_73_ != 65535) {
                        i_70_ = 64 + 128 * i_70_;
                        i_69_ = 64 + 128 * i_69_;
                        i_68_ = i_68_ * 128 + 64;
                        Class40_Sub5_Sub17_Sub1 class40_sub5_sub17_sub1 = (new Class40_Sub5_Sub17_Sub1(i_73_, Player.worldLevel, i_69_, i_68_, Class37.getFloorDrawHeight((Player.worldLevel), i_69_, i_68_) + -i_74_, i_76_ + Node.pulseCycle, i_77_ + Node.pulseCycle, i_78_, i_79_, i_72_, i_75_));
                        i_71_ = 128 * i_71_ + 64;
                        class40_sub5_sub17_sub1.method766(i_76_ + Node.pulseCycle, 0, i_71_, (-i_75_ + Class37.getFloorDrawHeight((Player.worldLevel), i_70_, i_71_)), i_70_);
                        Class43.aLinkedList_1022.pushBack(class40_sub5_sub17_sub1, -73);
                    }
                } else {
                    if(arg0 >= -110)
                        method952();
                    if(IncomingPackets.incomingPacket == 19) { // update world item amount
                        int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                        int i_80_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                        int i_81_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                        int i_82_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                        int i_83_ = (((0x71 & i_82_) >> 4) + Class40_Sub6.placementX);
                        int i_84_ = (0x7 & i_82_) + OverlayDefinition.placementY;
                        if(i_83_ >= 0 && i_84_ >= 0 && i_83_ < 104 && i_84_ < 104 && Class30.anInt708 != i_80_) {
                            Item item = new Item();
                            item.itemId = i_81_;
                            item.itemCount = i;
                            if((Wall.groundItems[Player.worldLevel][i_83_][i_84_]) == null)
                                Wall.groundItems[Player.worldLevel][i_83_][i_84_] = new LinkedList();
                            Wall.groundItems[Player.worldLevel][i_83_][i_84_].pushBack(item, 64);
                            FramemapDefinition.spawnGroundItem(i_84_, i_83_);
                        }
                    } else if(IncomingPackets.incomingPacket == 175) { // add world item
                        int i = IncomingPackets.incomingPacketBuffer.getUnsignedShortLE();
                        int i_85_ = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                        int i_86_ = IncomingPackets.incomingPacketBuffer.getUnsignedByte();
                        int i_87_ = OverlayDefinition.placementY + (i_86_ & 0x7);
                        int i_88_ = (Class40_Sub6.placementX + ((0x7a & i_86_) >> 4));
                        if(i_88_ >= 0 && i_87_ >= 0 && i_88_ < 104 && i_87_ < 104) {
                            Item item = new Item();
                            item.itemCount = i_85_;
                            item.itemId = i;
                            if((Wall.groundItems[Player.worldLevel][i_88_][i_87_]) == null)
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
        if(Class5.anInt200 != 0 && volume != 0 && PacketBuffer.currentSound < 50) {
            IdentityKit.sound[PacketBuffer.currentSound] = soundId;
            ItemDefinition.soundVolume[PacketBuffer.currentSound] = volume;
            Class40_Sub3.soundDelay[PacketBuffer.currentSound] = delay;
            PacketBuffer.effects[PacketBuffer.currentSound] = null;
            Class38_Sub1.anIntArray1916[PacketBuffer.currentSound] = 0;
            PacketBuffer.currentSound++;
        }
    }

    public static void method951(int arg0, TypeFace arg1, TypeFace arg2) {
        do {
            Class38.aClass68_887.method1046((byte) 90);
            if(Class51.anInt1197 == 0 || Class51.anInt1197 == 5) {
                int i = 20;
                arg1.drawStringLeft(Class48.aClass1_1122, 180, 74 + -i, 16777215);
                int i_89_ = -i + 82;
                Rasterizer.drawUnfilledRectangle(28, i_89_, 304, 34, 9179409);
                Rasterizer.drawUnfilledRectangle(29, 1 + i_89_, 302, 32, 0);
                Rasterizer.drawFilledRectangle(30, 2 + i_89_, Class67.anInt1607 * 3, 30, 9179409);
                Rasterizer.drawFilledRectangle(3 * Class67.anInt1607 + 30, i_89_ + 2, (-(Class67.anInt1607 * 3) + 300), 30, 0);
                arg1.drawStringLeft(Native.currentLoadingText, 180, -i + 105, 16777215);
            }
            if(Class51.anInt1197 == 20) {
                int i = 40;
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2_2775.drawImage(0, 0);
                arg1.method688(Class22_Sub2.aClass1_1879, 180, i, 16776960, true);
                i += 15;
                arg1.method688(Class22_Sub2.aClass1_1896, 180, i, 16776960, true);
                i += 15;
                arg1.method688(Class22_Sub2.aClass1_1881, 180, i, 16776960, true);
                i += 15;
                i += 10;
                arg1.drawShadowedString((RSString.linkRSStrings((new RSString[]{Class61.aClass1_1422, Native.username}))), 90, i, 16777215, true);
                i += 15;
                arg1.drawShadowedString((RSString.linkRSStrings(new RSString[]{English.password, Native.password.method61()})), 92, i, 16777215, true);
                i += 15;
            }
            if(Class51.anInt1197 == 10) {
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2_2775.drawImage(0, 0);
                if(Class26.anInt622 == 0) {
                    int i = 80;
                    int i_94_ = 100;
                    arg1.method688(Main.aClass1_1761, 180, i, 16776960, true);
                    i += 30;
                    int i_95_ = 120;
                    Class59.aClass40_Sub5_Sub14_Sub2_1387.drawImage(i_94_ - 73, i_95_ - 20);
                    arg1.drawText(GenericTile.aClass1_1223, i_94_ + -73, -20 + i_95_, 144, 40, 16777215, true, 1, 1, 0);
                    i_94_ = 260;
                    Class59.aClass40_Sub5_Sub14_Sub2_1387.drawImage(i_94_ - 73, i_95_ + -20);
                    arg1.drawText(Class42.aClass1_1011, -73 + i_94_, -20 + i_95_, 144, 40, 16777215, true, 1, 1, 0);
                } else if(Class26.anInt622 == 2) {
                    int i = 40;
                    int i_90_ = 100;
                    arg1.method688(Class22_Sub2.aClass1_1879, 180, i, 16776960, true);
                    i += 15;
                    int i_91_ = 150;
                    arg1.method688(Class22_Sub2.aClass1_1896, 180, i, 16776960, true);
                    i += 15;
                    arg1.method688(Class22_Sub2.aClass1_1881, 180, i, 16776960, true);
                    i += 15;
                    i += 10;
                    arg1.drawShadowedString((RSString.linkRSStrings((new RSString[]{Class61.aClass1_1422, Native.username, ((Node.pulseCycle % 40 < 20 & Node.anInt947 == 0) ? (Class40_Sub5_Sub6.aClass1_2447) : (Native.string_blank))}))), 90, i, 16777215, true);
                    i += 15;
                    arg1.drawShadowedString((RSString.linkRSStrings((new RSString[]{English.password, Native.password.method61(), ((Node.pulseCycle % 40 < 20 & Node.anInt947 == 1) ? (Class40_Sub5_Sub6.aClass1_2447) : (Native.string_blank))}))), 92, i, 16777215, true);
                    Class59.aClass40_Sub5_Sub14_Sub2_1387.drawImage(-73 + i_90_, i_91_ + -20);
                    i += 15;
                    arg1.method688(VarbitDefinition.aClass1_2351, i_90_, i_91_ + 5, 16777215, true);
                    i_90_ = 260;
                    Class59.aClass40_Sub5_Sub14_Sub2_1387.drawImage(-73 + i_90_, i_91_ + -20);
                    arg1.method688(Class68.str_Cancel, i_90_, 5 + i_91_, 16777215, true);
                } else if(Class26.anInt622 == 3) {
                    arg1.method688(Class67.aClass1_1598, 180, 40, 16776960, true);
                    int i = 180;
                    int i_92_ = 150;
                    int i_93_ = 65;
                    arg1.method688(English.toCreateANewAccountYouNeedTo, 180, i_93_, 16777215, true);
                    i_93_ += 15;
                    arg1.method688(aClass1_1259, 180, i_93_, 16777215, true);
                    i_93_ += 15;
                    arg1.method688(aClass1_1251, 180, i_93_, 16777215, true);
                    i_93_ += 15;
                    arg1.method688(Class40_Sub5_Sub11.aClass1_2629, 180, i_93_, 16777215, true);
                    Class59.aClass40_Sub5_Sub14_Sub2_1387.drawImage(-73 + i, i_92_ - 20);
                    arg1.method688(Class68.str_Cancel, i, 5 + i_92_, 16777215, true);
                    i_93_ += 15;
                }
            }
            Main.renderFlames(0);
            try {
                Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
                Class38.aClass68_887.drawGraphics(202, 171, graphics);
                if(arg0 != -19010)
                    method949((byte) 41);
                Class8.aClass68_298.drawGraphics(0, 0, graphics);
                GameObject.aClass68_3042.drawGraphics(637, 0, graphics);
                if(!Class40_Sub5_Sub11.clearScreen)
                    break;
                Class40_Sub5_Sub11.clearScreen = false;
                Class39.aClass68_907.drawGraphics(128, 0, graphics);
                Class51.aClass68_1206.drawGraphics(202, 371, graphics);
                Class17.aClass68_463.drawGraphics(0, 265, graphics);
                KeyFocusListener.aClass68_1285.drawGraphics(562, 265, graphics);
                GameObjectDefinition.aClass68_2524.drawGraphics(128, 171, graphics);
                Class68.aClass68_1631.drawGraphics(562, 171, graphics);
            } catch(Exception exception) {
                MouseHandler.aCanvas1469.repaint();
            }
            break;

        } while(false);
    }

    public static void method952() {
        aClass40_Sub5_Sub14_Sub2_1270 = null;
        fontNormal = null;
        aClass9_1247 = null;
        aClass1_1243 = null;
        aClass1_1251 = null;
        aClass1_1266 = null;
        aClass1_1255 = null;
        aClass9_1264 = null;
        aClass1_1259 = null;
        ignores = null;
        aClass1_1260 = null;
    }
}
