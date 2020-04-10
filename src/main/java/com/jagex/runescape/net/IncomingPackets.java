package com.jagex.runescape.net;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.cache.media.Widget.WidgetModelType;
import com.jagex.runescape.cache.media.Widget.WidgetType;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

public class IncomingPackets {

    private static final int

            SET_WIDGET_ITEM_MODEL = 120, MOVE_WIDGET_CHILD = 3, UPDATE_SPECIFIC_WIDGET_ITEMS = 214, UPDATE_ALL_WIDGET_ITEMS = 12, UPDATE_WIDGET_TEXT = 110, UPDATE_WIDGET_TEXT_COLOR = 231, SET_WIDGET_PLAYER_HEAD = 210, SET_WIDGET_NPC_HEAD = 160, PLAY_WIDGET_ANIMATION = 24, SET_TAB_WIDGET = 140,

    SHOW_CHATBOX_WIDGET = 208, SHOW_SCREEN_WIDGET = 118, SHOW_FULLSCREEN_WIDGET = 195, SHOW_TAB_AND_SCREEN_WIDGETS = 84, CLOSE_ALL_WIDGETS = 180,

    UPDATE_CARRY_WEIGHT = 171, UPDATE_RUN_ENERGY = 18, UPDATE_SKILL = 34,

    UPDATE_REFERENCE_POSITION = 254, SET_MAP_CHUNK = 166, CLEAR_MAP_CHUNK = 64,

    UPDATE_PLAYERS = 92, UPDATE_NPCS = 128, LOGOUT = 181,

    PLAY_SOUND = 131, PLAY_SONG = 217, PLAY_QUICK_SONG = 40;

    public static int incomingPacketSize = 0;
    public static PacketBuffer incomingPacketBuffer = new PacketBuffer(5000);
    public static int incomingPacket = 0;
    public static int[] INCOMING_PACKET_SIZES = (new int[]{
            0, 15, 6, 8, 0, 0, 1, 0, 0, 5,  // 0
            0, 0, -2, 0, 0, 0, 0, 0, 1, 7,  // 10
            0, 0, 0, -2, 6, 0, 0, 0, 0, 0,  // 20
            0, 0, 0, 0, 6, 0, 0, 0, 0, 0,  // 30
            5, 0, 0, 0, 0, 0, 0, 0, 1, 4,  // 40
            0, -1, 0, 0, 0, 0, 2, 0, 4, 0,  // 50
            0, 0, 0, -2, 2, 0, 0, 0, 0, 0,  // 60
            1, -1, 0, 0, 3, 0, 0, 0, 0, 0,  // 70
            0, 0, -1, -1, 4, 0, 0, 0, 1, 0,  // 80
            0, 0, -2, 0, 0, 0, 0, 0, 0, 7,  // 90
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  // 100
            -2, 0, 0, 0, 0, 5, 2, 8, 2, 0,  // 110
            8, 0, 0, 0, 0, 0, 0, 0, -2, 3,  // 120
            2, 5, 0, 0, 0, 0, 0, 0, 0, 0,  // 130
            3, 0, 10, 2, 0, 0, 0, 0, 0, 0,  // 140
            0, 0, 0, 0, 0, 0, 10, 0, 0, 0,  // 150
            6, 0, 0, 0, 0, 0, -2, 0, 0, 0,  // 160
            0, 2, 0, 0, 4, 5, 0, 0, 0, 0,  // 170
            0, 0, 6, 0, 0, 2, 6, 0, 0, 0,  // 180
            0, 0, 0, 0, 6, 4, 3, 0, 0, 0,  // 190
            0, 0, 6, 0, 0, 0, 0, 0, 2, 0,  // 200
            4, -2, 0, 0, -2, 0, 0, 2, 0, 0,  // 210
            0, 0, 3, -1, 0, 0, 0, 0, 0, 14,  // 220
            0, 6, 0, 0, 6, 1, 0, 2, 0, 0,  // 230
            -2, 4, 0, 0, 0, 0, 0, 0, 0, 0,  // 240
            6, 0, 0, 6, 2, 4});

    public static boolean parseIncomingPackets(boolean arg0) {
        if(Class40_Sub6.aClass64_2098 == null)
            return false;
        try {
            int i = Class40_Sub6.aClass64_2098.method1014(-122);
            if(i == 0)
                return false;
            if(incomingPacket == -1) {
                Class40_Sub6.aClass64_2098.method1008(0, 1, -127, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                i--;
                incomingPacket = incomingPacketBuffer.getPacket();
                incomingPacketSize = INCOMING_PACKET_SIZES[incomingPacket];
            }
            //System.out.println("packet received: " + Class57.incomingPacket);
            if(incomingPacketSize == -1) {
                if(i > 0) {
                    Class40_Sub6.aClass64_2098.method1008(0, 1, -127, incomingPacketBuffer.buffer);
                    incomingPacketSize = (incomingPacketBuffer.buffer[0] & 0xff);
                    i--;
                } else
                    return false;
            }
            if(incomingPacketSize == -2) {
                if(i <= 1)
                    return false;
                i -= 2;
                Class40_Sub6.aClass64_2098.method1008(0, 2, -127, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                incomingPacketSize = incomingPacketBuffer.getUnsignedShortBE();
            }
            if((incomingPacketSize > i))
                return false;
            incomingPacketBuffer.currentPosition = 0;
            Class40_Sub6.aClass64_2098.method1008(0, incomingPacketSize, -128, incomingPacketBuffer.buffer);
            Class49.anInt1151 = Cache.anInt324;
            Class35.anInt1728 = 0;
            Cache.anInt324 = RSString.anInt1690;
            RSString.anInt1690 = incomingPacket;
            if(incomingPacket == 71) {
                long l = incomingPacketBuffer.getLongBE();
                RSString class1 = KeyFocusListener.method956(82, incomingPacketBuffer).method53();
                Class44.addChatMessage(Class60.method991(-42, l).method85(), class1, 6);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 156) { // friend logged in
                long l = incomingPacketBuffer.getLongBE();
                int i_1_ = incomingPacketBuffer.getUnsignedShortBE();
                RSString string = Class60.method991(-64, l).method85();
                for(int i_2_ = 0; i_2_ < Item.friendsCount; i_2_++) {
                    if(l == Class59.aLongArray1397[i_2_]) {
                        if(i_1_ != Class40_Sub7.friendWorlds[i_2_]) {
                            Class40_Sub7.friendWorlds[i_2_] = i_1_;
                            ISAAC.redrawTabArea = true;
                            if(i_1_ > 0)
                                Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings((new RSString[]{string, (Class42.aClass1_988)}))), 5);
                            if(i_1_ == 0)
                                Class44.addChatMessage(HuffmanEncoding.blank_string, (RSString.linkRSStrings((new RSString[]{string, Class38_Sub1.aClass1_1905}))), 5);
                        }
                        string = null;
                        break;
                    }
                }
                boolean bool = false;
                if(string != null && Item.friendsCount < 200) {
                    Class59.aLongArray1397[(Item.friendsCount)] = l;
                    Class40_Sub11.friendUsernames[(Item.friendsCount)] = string;
                    Class40_Sub7.friendWorlds[(Item.friendsCount)] = i_1_;
                    Item.friendsCount++;
                    ISAAC.redrawTabArea = true;
                }
                while(!bool) {
                    bool = true;
                    for(int i_3_ = 0; Item.friendsCount - 1 > i_3_; i_3_++) {
                        if(((Class13.worldid != Class40_Sub7.friendWorlds[i_3_]) && (Class40_Sub7.friendWorlds[1 + i_3_] == Class13.worldid)) || (Class40_Sub7.friendWorlds[i_3_] == 0 && Class40_Sub7.friendWorlds[i_3_ + 1] != 0)) {
                            bool = false;
                            int i_4_ = Class40_Sub7.friendWorlds[i_3_];
                            Class40_Sub7.friendWorlds[i_3_] = Class40_Sub7.friendWorlds[i_3_ + 1];
                            Class40_Sub7.friendWorlds[1 + i_3_] = i_4_;
                            RSString class1_5_ = Class40_Sub11.friendUsernames[i_3_];
                            Class40_Sub11.friendUsernames[i_3_] = Class40_Sub11.friendUsernames[1 + i_3_];
                            Class40_Sub11.friendUsernames[1 + i_3_] = class1_5_;
                            long l_6_ = Class59.aLongArray1397[i_3_];
                            Class59.aLongArray1397[i_3_] = Class59.aLongArray1397[i_3_ + 1];
                            Class59.aLongArray1397[1 + i_3_] = l_6_;
                            ISAAC.redrawTabArea = true;
                        }
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 233) {
                incomingPacket = -1;
                VarbitDefinition.destinationX = 0;
                return true;
            }
            if(incomingPacket == 7) {
                Class39.aBoolean906 = false;
                for(int i_7_ = 0; i_7_ < 5; i_7_++)
                    Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_7_] = false;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 23) {
                FloorDecoration.method343(true, 5688);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 222) {
                int i_8_ = incomingPacketBuffer.getByte();
                int i_9_ = incomingPacketBuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[i_9_] = i_8_;
                if(GroundItemTile.varbitmasks[i_9_] != i_8_) {
                    GroundItemTile.varbitmasks[i_9_] = i_8_;
                    Class22.method309(-1, i_9_);
                    ISAAC.redrawTabArea = true;
                    if(ChatBox.dialogueId != -1)
                        ChatBox.redrawChatbox = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 115) { // set widget hidden state
                boolean bool = (incomingPacketBuffer.getUnsignedByte() == 1);
                int i_10_ = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(i_10_);
                widget.isHidden = bool;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_ALL_WIDGET_ITEMS) {
                ISAAC.redrawTabArea = true;
                final int packed = incomingPacketBuffer.getIntBE();
                final Widget widget = Widget.forId(packed);

                if (widget.isIf3) {
                    final Widget[] widgets = (Widget.interfaces[packed >> 16]);
                    for (Widget child : widgets) {
                        if (((0xffff & widget.id) == (0xffff & child.parentId)) && child.anInt2736 > 0) {
                            child.itemAmount = 0;
                            child.itemId = -1;
                        }
                    }
                } else {
                    for (int index = 0; index < widget.items.length; index++) {
                        widget.items[index] = 0;
                        widget.itemAmounts[index] = 0;
                    }
                }

                final int size = incomingPacketBuffer.getUnsignedShortBE();

                for (int index = 0; index < size; index += 8) {
                    final int bitset = incomingPacketBuffer.getByte();

                    for (int offset = 0; offset < 8; offset++) {
                        final boolean empty = (bitset & (1 << offset)) == 0;
                        final int id, amount;

                        if (empty) {
                            id = amount = 0;
                        } else {
                            final int peek = incomingPacketBuffer.getUnsignedByte();
                            amount = peek == 255 ? incomingPacketBuffer.getIntBE() : peek;
                            id = incomingPacketBuffer.getUnsignedShortBE();
                        }

                        final int idx = index + offset;

                        if (widget.isIf3) {
                            Widget widgets[] = Widget.interfaces[packed >> 16];
                            for (Widget child : widgets) {
                                if (((widget.id & 0xffff) == (child.parentId & 0xffff)) && (1 + idx == child.anInt2736)) {
                                    child.itemAmount = amount;
                                    child.itemId = -1 + id;
                                }
                            }
                        } else if (idx < widget.items.length) {
                            widget.items[idx] = id;
                            widget.itemAmounts[idx] = amount;
                        }
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 250) { // widget model type 1
                int modelId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelId = modelId;
                widget.modelType = WidgetModelType.MODEL;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 255) {
                int i_23_ = incomingPacketBuffer.getUnsignedByte();
                int i_24_ = incomingPacketBuffer.getUnsignedByte();
                int i_25_ = incomingPacketBuffer.getUnsignedByte();
                int i_26_ = incomingPacketBuffer.getUnsignedByte();
                Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_23_] = true;
                Class8.anIntArray297[i_23_] = i_24_;
                GameShell.anIntArray2[i_23_] = i_25_;
                GroundItemTile.anIntArray1358[i_23_] = i_26_;
                Class22_Sub1.anIntArray1846[i_23_] = 0;
                incomingPacket = -1;
                return true;
            }
            if(arg0)
                CollisionMap.anInt172 = -96;
            if(incomingPacket == 235) {
                Class27.minimapState = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 48) {
                Class40_Sub6.anInt2118 = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 82) {
                RSString message = incomingPacketBuffer.getRSString();
                if(message.method87(AnimationSequence.requestcmd_tradereq)) {
                    RSString class1_32_ = message.substring(0, message.contains((Class43.char_colon)));
                    long l = class1_32_.method58((byte) 98);
                    boolean bool = false;
                    for(int i_33_ = 0; i_33_ < Class42.anInt1008; i_33_++) {
                        if(l == WallDecoration.ignores[i_33_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && Class4.anInt182 == 0)
                        Class44.addChatMessage(class1_32_, Class4.aClass1_180, 4);
                } else if(message.method87(Class40_Sub5_Sub6.requestcmd_duelreq)) {
                    RSString class1_30_ = (message.substring(0, message.contains(Class43.char_colon)));
                    long l = class1_30_.method58((byte) 120);
                    boolean bool = false;
                    for(int i_31_ = 0; ((Class42.anInt1008 > i_31_)); i_31_++) {
                        if(l == WallDecoration.ignores[i_31_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && Class4.anInt182 == 0)
                        Class44.addChatMessage(class1_30_, Class61.aClass1_1428, 8);
                } else if(message.method87(Node.requestcmd_chalreq)) {
                    RSString class1_27_ = (message.substring(0, message.contains(Class43.char_colon)));
                    long l = class1_27_.method58((byte) 121);
                    boolean bool = false;
                    for(int i_28_ = 0; i_28_ < Class42.anInt1008; i_28_++) {
                        if(l == WallDecoration.ignores[i_28_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && Class4.anInt182 == 0) {
                        RSString class1_29_ = (message.substring((1 + message.contains((Class43.char_colon))), -9 + message.length()));
                        Class44.addChatMessage(class1_27_, class1_29_, 8);
                    }
                } else {
                    Class44.addChatMessage(HuffmanEncoding.blank_string, message, 0);
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 83) { // console command
                RSString message = incomingPacketBuffer.getRSString();
                Console.console.log("<col=FFFF00>" + message.toString() + "</col>");
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 182) { // set widget scroll position
                int i_34_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(i_35_);
                incomingPacket = -1;
                if(widget != null && widget.type == WidgetType.LAYER) {
                    if(i_34_ < 0)
                        i_34_ = 0;
                    if((-widget.originalHeight + widget.scrollHeight) < i_34_)
                        i_34_ = (-widget.originalHeight + widget.scrollHeight);
                    widget.scrollPosition = i_34_;
                }
                return true;
            }
            if(incomingPacket == 174) { // clear widget item container?
                int i_36_ = incomingPacketBuffer.getIntME1();
                Widget widget = Widget.forId(i_36_);
                if(widget.isIf3) {
                    Widget[] widgets = (Widget.interfaces[i_36_ >> 16]);
                    for(int i_37_ = 0; i_37_ < widgets.length; i_37_++) {
                        Widget widget_38_ = widgets[i_37_];
                        if(((0xffff & widget.id) == (widget_38_.parentId & 0xffff)) && widget_38_.anInt2736 > 0) {
                            widget_38_.itemId = -1;
                            widget_38_.itemAmount = 0;
                        }
                    }
                } else {
                    for(int i_39_ = 0; widget.items.length > i_39_; i_39_++) {
                        widget.items[i_39_] = -1;
                        widget.items[i_39_] = 0;
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 130) {
                Class34.anInt854 = incomingPacketBuffer.getUnsignedShortLE();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 129) {
                int i_40_ = incomingPacketBuffer.getUnsignedByte();
                int i_41_ = incomingPacketBuffer.getUnsignedByte();
                int i_42_ = incomingPacketBuffer.getUnsignedByte();
                Player.worldLevel = i_40_ >> 1;
                Player.localPlayer.method787(i_42_, -7717, (i_40_ & 0x1) == 1, i_41_);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == LOGOUT) {
                Class48.method928(-7225);
                incomingPacket = -1;
                return false;
            }
            if(incomingPacket == PLAY_WIDGET_ANIMATION) {
                int animationId = incomingPacketBuffer.getShortBE();
                int widgetData = incomingPacketBuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                if((animationId != widget.animation) || animationId == -1) {
                    widget.anInt2660 = 0;
                    widget.anInt2654 = 0;
                    widget.animation = animationId;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 56) {
                int i_45_ = incomingPacketBuffer.getShortBE();
                if(i_45_ >= 0)
                    Class42.method883((byte) -121, i_45_);
                if(i_45_ != GroundItemTile.walkableWidgetId) {
                    Class55.method958(GroundItemTile.walkableWidgetId);
                    GroundItemTile.walkableWidgetId = i_45_;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 117) {
                int i_46_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_47_ = incomingPacketBuffer.getUnsignedShortLE();
                int i_48_ = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(i_48_);
                incomingPacket = -1;
                widget.anInt2722 = i_47_ + (i_46_ << 16);
                return true;
            }
            if(incomingPacket == SHOW_TAB_AND_SCREEN_WIDGETS) { // show tab and screen widget
                int i_49_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_50_ = incomingPacketBuffer.getUnsignedShortLE();
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.redrawChatbox = true;
                    ChatBox.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != i_50_) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId);
                    HuffmanEncoding.openScreenWidgetId = i_50_;
                }
                if(Class29.tabAreaOverlayWidgetId != i_49_) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId);
                    Class29.tabAreaOverlayWidgetId = i_49_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == CLEAR_MAP_CHUNK) {
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                Class40_Sub6.placementX = incomingPacketBuffer.getUnsignedByte();
                for(int i_51_ = Class40_Sub6.placementX; ((i_51_ < 8 + Class40_Sub6.placementX)); i_51_++) {
                    for(int i_52_ = OverlayDefinition.placementY; ((8 + OverlayDefinition.placementY > i_52_)); i_52_++) {
                        if((Wall.groundItems[Player.worldLevel][i_51_][i_52_]) != null) {
                            Wall.groundItems[Player.worldLevel][i_51_][i_52_] = null;
                            FramemapDefinition.spawnGroundItem(i_52_, i_51_);
                        }
                    }
                }
                for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) LinkedList.aLinkedList_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.method909(-4)) {
                    if(class40_sub3.anInt2039 >= Class40_Sub6.placementX && (Class40_Sub6.placementX + 8 > class40_sub3.anInt2039) && (class40_sub3.anInt2038 >= OverlayDefinition.placementY) && (OverlayDefinition.placementY + 8 > class40_sub3.anInt2038) && (Player.worldLevel == class40_sub3.anInt2018))
                        class40_sub3.anInt2031 = 0;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 223) { // set player options
                RSString class1 = incomingPacketBuffer.getRSString();
                int i_53_ = incomingPacketBuffer.getUnsignedByte();
                int i_54_ = incomingPacketBuffer.getUnsignedByte();
                if(i_54_ >= 1 && i_54_ <= 5) {
                    if(class1.equalsIgnoreCase(GameShell.aClass1_34))
                        class1 = null;
                    Main.playerActions[i_54_ + -1] = class1;
                    Class13.playerArray[i_54_ + -1] = i_53_ == 0;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == SHOW_SCREEN_WIDGET) {
                int i_55_ = incomingPacketBuffer.getUnsignedShortBE();
                Class42.method883((byte) -127, i_55_);
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId);
                    IdentityKit.drawTabIcons = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                    ISAAC.redrawTabArea = true;
                }
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.redrawChatbox = true;
                    ChatBox.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(i_55_ != HuffmanEncoding.openScreenWidgetId) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId);
                    HuffmanEncoding.openScreenWidgetId = i_55_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                Class64.method1012(HuffmanEncoding.openScreenWidgetId, 2);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_RUN_ENERGY) {
                if(Class5.currentTabId == 12)
                    ISAAC.redrawTabArea = true;
                Class40_Sub11.runEnergy = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 253) {
                Class39.aBoolean906 = true;
                Class22.anInt545 = incomingPacketBuffer.getUnsignedByte();
                SceneCluster.anInt767 = incomingPacketBuffer.getUnsignedByte();
                Class5.anInt194 = incomingPacketBuffer.getUnsignedShortBE();
                Class4.anInt188 = incomingPacketBuffer.getUnsignedByte();
                Class59.anInt1386 = incomingPacketBuffer.getUnsignedByte();
                if(Class59.anInt1386 >= 100) {
                    Class40_Sub5_Sub6.cameraY = 64 + SceneCluster.anInt767 * 128;
                    Class12.cameraX = Class22.anInt545 * 128 + 64;
                    SceneCluster.cameraZ = (Class37.getFloorDrawHeight((Player.worldLevel), Class12.cameraX, Class40_Sub5_Sub6.cameraY) - Class5.anInt194);
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 185) {
                int i_56_ = incomingPacketBuffer.getShortBE();
                if(ChatBox.dialogueId != i_56_) {
                    Class55.method958(ChatBox.dialogueId);
                    ChatBox.dialogueId = i_56_;
                }
                incomingPacket = -1;
                ChatBox.redrawChatbox = true;
                return true;
            }
            if(incomingPacket == SHOW_FULLSCREEN_WIDGET) { // fullscreen widget?
                int secondaryWidgetId = incomingPacketBuffer.getUnsignedShortBE();
                int fullscreenWidgetId = incomingPacketBuffer.getUnsignedShortBE();
                Class42.method883((byte) -120, fullscreenWidgetId);
                if(secondaryWidgetId != -1)
                    Class42.method883((byte) -124, secondaryWidgetId);
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId);
                    Class29.tabAreaOverlayWidgetId = -1;
                }
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.openChatboxWidgetId = -1;
                }
                if(fullscreenWidgetId != ActorDefinition.openFullScreenWidgetId) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId);
                    ActorDefinition.openFullScreenWidgetId = fullscreenWidgetId;
                    OverlayDefinition.method559(35);
                }
                if(fullscreenWidgetId != UnderlayDefinition.openSecondaryWidgetId) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
                    UnderlayDefinition.openSecondaryWidgetId = secondaryWidgetId;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                ChatBox.inputType = 0;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == CLOSE_ALL_WIDGETS) {
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId);
                    ISAAC.redrawTabArea = true;
                    IdentityKit.drawTabIcons = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                }
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.redrawChatbox = true;
                    ChatBox.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                incomingPacket = -1;
                CacheIndex_Sub1.anInt1819 = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                return true;
            }
            if(incomingPacket == SHOW_CHATBOX_WIDGET) {
                int widgetId = incomingPacketBuffer.getUnsignedShortBE();
                Class42.method883((byte) -119, widgetId);
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId);
                    IdentityKit.drawTabIcons = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                    ISAAC.redrawTabArea = true;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                if(ChatBox.openChatboxWidgetId != widgetId) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.openChatboxWidgetId = widgetId;
                }

                ChatBox.redrawChatbox = true;
                incomingPacket = -1;
                CacheIndex_Sub1.anInt1819 = -1;
                return true;
            }
            if(incomingPacket == PLAY_SONG) {
                int songId = incomingPacketBuffer.getUnsignedShortLE();
                if(songId == 65535)
                    songId = -1;
                Class51.method942(songId);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PLAY_QUICK_SONG) {
                int songTimeout = incomingPacketBuffer.getMediumBE();
                int songId = incomingPacketBuffer.getUnsignedShortBE();
                if(songId == 65535)
                    songId = -1;
                Class57.method975(songTimeout, songId);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_REFERENCE_POSITION) {
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                Class40_Sub6.placementX = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 88) {
                Class51.anInt1205 = incomingPacketBuffer.getUnsignedByte();
                if(Class5.currentTabId == Class51.anInt1205) {
                    if(Class51.anInt1205 != 3)
                        Class5.currentTabId = 3;
                    else
                        Class5.currentTabId = 1;
                    ISAAC.redrawTabArea = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 63) { // mass object/ground item update packet
                Class40_Sub6.placementX = incomingPacketBuffer.getUnsignedByte();
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                while(incomingPacketBuffer.currentPosition < incomingPacketSize) {
                    incomingPacket = incomingPacketBuffer.getUnsignedByte();
                    WallDecoration.method949((byte) -125);
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 196) { // set chat mode configs
                ChatBox.publicChatMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.privateChatMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.tradeMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.redrawChatbox = true;
                Cache.redrawChatbox = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 116) {
                Class40_Sub5_Sub15.systemUpdateTime = (incomingPacketBuffer.getUnsignedShortLE() * 30);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_PLAYERS) {
                parsePlayerUpdatePacket();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 2) {
                int configValue = incomingPacketBuffer.getIntBE();
                int configId = incomingPacketBuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[configId] = configValue;
                if(configValue != GroundItemTile.varbitmasks[configId]) {
                    GroundItemTile.varbitmasks[configId] = configValue;
                    Class22.method309(-1, configId);
                    if(ChatBox.dialogueId != -1)
                        ChatBox.redrawChatbox = true;
                    ISAAC.redrawTabArea = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_NPCS) {
                parseNpcUpdatePacket();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PLAY_SOUND) {
                int soundId = incomingPacketBuffer.getUnsignedShortBE();
                int volume = incomingPacketBuffer.getUnsignedByte();
                int delay = incomingPacketBuffer.getUnsignedShortBE();
                WallDecoration.method950(soundId, volume, delay);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 237) { // show tab overlay widget
                int i_68_ = incomingPacketBuffer.getUnsignedShortBE();
                Class42.method883((byte) 107, i_68_);
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.openChatboxWidgetId = -1;
                    ChatBox.redrawChatbox = true;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                if(Class29.tabAreaOverlayWidgetId != i_68_) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId);
                    Class29.tabAreaOverlayWidgetId = i_68_;
                }
                IdentityKit.drawTabIcons = true;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                incomingPacket = -1;
                ISAAC.redrawTabArea = true;
                return true;
            }
            if(incomingPacket == 234) {
                Class39.aBoolean906 = true;
                HashTable.anInt564 = incomingPacketBuffer.getUnsignedByte();
                UnderlayDefinition.anInt2576 = incomingPacketBuffer.getUnsignedByte();
                Class38.anInt892 = incomingPacketBuffer.getUnsignedShortBE();
                Class60.anInt1413 = incomingPacketBuffer.getUnsignedByte();
                Class22_Sub1.anInt1856 = incomingPacketBuffer.getUnsignedByte();
                if(Class22_Sub1.anInt1856 >= 100) {
                    int i_69_ = 128 * HashTable.anInt564 + 64;
                    int i_70_ = 128 * UnderlayDefinition.anInt2576 + 64;
                    int i_71_ = (Class37.getFloorDrawHeight((Player.worldLevel), i_69_, i_70_) - Class38.anInt892);
                    int i_72_ = i_69_ + -Class12.cameraX;
                    int i_73_ = i_70_ + -Class40_Sub5_Sub6.cameraY;
                    int i_74_ = -SceneCluster.cameraZ + i_71_;
                    int i_75_ = (int) Math.sqrt((double) (i_73_ * i_73_ + i_72_ * i_72_));
                    Class26.anInt627 = ((int) (325.949 * Math.atan2((double) i_74_, (double) i_75_)) & 0x7ff);
                    Class68_Sub1.anInt2210 = (int) (Math.atan2((double) i_72_, (double) i_73_) * -325.949) & 0x7ff;
                    if(Class26.anInt627 < 128)
                        Class26.anInt627 = 128;
                    if(Class26.anInt627 > 383)
                        Class26.anInt627 = 383;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 142) {
                int i_76_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_77_ = incomingPacketBuffer.getUnsignedShortLE();
                int i_78_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_79_ = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(i_79_);
                incomingPacket = -1;
                widget.rotationZ = i_76_;
                widget.modelZoom = i_77_;
                widget.rotationX = i_78_;
                return true;
            }
            if(incomingPacket == 6) {
                Class5.currentTabId = incomingPacketBuffer.getUnsignedByte();
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_CARRY_WEIGHT) { // update carry weight
                if(Class5.currentTabId == 12)
                    ISAAC.redrawTabArea = true;
                GenericTile.anInt1222 = incomingPacketBuffer.getShortBE();
                incomingPacket = -1;
                return true;
            }
            // object/ground item update packets?
            if(incomingPacket == 9 || incomingPacket == 99 || incomingPacket == 229 || incomingPacket == 19 || incomingPacket == 202 || incomingPacket == 1 || incomingPacket == 74 || incomingPacket == 175 || incomingPacket == 49 || incomingPacket == 143 || incomingPacket == 241) {
                WallDecoration.method949((byte) -112);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 14) { // reset client configs?
                for(int i_80_ = 0; Class59.anInt1383 > i_80_; i_80_++) {
                    Class40_Sub5_Sub11 class40_sub5_sub11 = Npc.method795((byte) -114, i_80_);
                    if(class40_sub5_sub11 != null && class40_sub5_sub11.anInt2633 == 0) {
                        Buffer.anIntArray1984[i_80_] = 0;
                        GroundItemTile.varbitmasks[i_80_] = 0;
                    }
                }
                if(ChatBox.dialogueId != -1)
                    ChatBox.redrawChatbox = true;
                ISAAC.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == SET_WIDGET_NPC_HEAD) {
                int npcId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelType = WidgetModelType.NPC_CHATHEAD;
                incomingPacket = -1;
                widget.modelId = npcId;
                return true;
            }
            if(incomingPacket == 132) { // open chatbox input widget
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.openChatboxWidgetId = -1;
                }
                incomingPacket = -1;
                ChatBox.inputMessage = HuffmanEncoding.blank_string;
                ChatBox.inputType = 1;
                ChatBox.redrawChatbox = true;
                ChatBox.messagePromptRaised = false;
                return true;
            }
            if(incomingPacket == 186) {
                Player.anInt3288 = incomingPacketBuffer.getUnsignedByte();
                if(Player.anInt3288 == 1)
                    HuffmanEncoding.anInt1545 = incomingPacketBuffer.getUnsignedShortBE();
                if((Player.anInt3288 >= 2) && Player.anInt3288 <= 6) {
                    if(Player.anInt3288 == 2) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 64;
                    }
                    if(Player.anInt3288 == 3) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 0;
                    }
                    if(Player.anInt3288 == 4) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 128;
                    }
                    if(Player.anInt3288 == 5) {
                        Landscape.anInt1170 = 64;
                        Class35.anInt1730 = 0;
                    }
                    if(Player.anInt3288 == 6) {
                        Landscape.anInt1170 = 64;
                        Class35.anInt1730 = 128;
                    }
                    Player.anInt3288 = 2;
                    Class68.anInt1637 = incomingPacketBuffer.getUnsignedShortBE();
                    Class4.anInt175 = incomingPacketBuffer.getUnsignedShortBE();
                    ActorDefinition.anInt2404 = incomingPacketBuffer.getUnsignedByte();
                }
                if(Player.anInt3288 == 10)
                    Class68.anInt1623 = incomingPacketBuffer.getUnsignedShortBE();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == SET_WIDGET_PLAYER_HEAD) {
                int widgetData = incomingPacketBuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelType = WidgetModelType.LOCAL_PLAYER_CHATHEAD;
                widget.modelId = Player.localPlayer.aClass30_3282.method374(-20874);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_WIDGET_TEXT) {
                int widgetData = incomingPacketBuffer.getIntLE();
                RSString class1 = incomingPacketBuffer.getRSString();
                Widget widget = Widget.forId(widgetData);
                widget.disabledText = class1;
                if(Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId] == widgetData >> 16)
                    ISAAC.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 70) {
                Class12.friendListStatus = incomingPacketBuffer.getUnsignedByte();
                ISAAC.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == SET_WIDGET_ITEM_MODEL) { // item model on interface
                int zoom = incomingPacketBuffer.getUnsignedShortBE();
                int itemId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                if(itemId == 65535)
                    itemId = -1;
                Widget widget = Widget.forId(widgetData);
                if(widget.isIf3) {
                    widget.itemAmount = 1;
                    widget.itemId = itemId;
                } else {
                    if(itemId == -1) {
                        incomingPacket = -1;
                        widget.modelType = WidgetModelType.NULL;
                        return true;
                    }
                    ItemDefinition itemDefinition = ItemDefinition.forId(itemId, 10);
                    widget.rotationX = itemDefinition.xan2d;
                    widget.modelId = itemId;
                    widget.modelType =  WidgetModelType.ITEM;
                    widget.modelZoom = 100 * itemDefinition.zoom2d / zoom;
                    widget.rotationZ = itemDefinition.yan2d;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 51) { // friend login???
                long l = incomingPacketBuffer.getLongBE();
                long l_88_ = (long) incomingPacketBuffer.getUnsignedShortBE();
                long l_89_ = (long) incomingPacketBuffer.getMediumBE();
                int i_90_ = incomingPacketBuffer.getUnsignedByte();
                boolean bool = false;
                long l_91_ = (l_88_ << 32) + l_89_;
                for(int i_92_ = 0; i_92_ < 100; i_92_++) {
                    if(l_91_ == Class40_Sub5_Sub13.aLongArray2757[i_92_]) {
                        bool = true;
                        break;
                    }
                }
                if(i_90_ <= 1) {
                    for(int i_93_ = 0; ((i_93_ < Class42.anInt1008)); i_93_++) {
                        if(l == WallDecoration.ignores[i_93_]) {
                            bool = true;
                            break;
                        }
                    }
                }
                if(!bool && Class4.anInt182 == 0) {
                    Class40_Sub5_Sub13.aLongArray2757[(Class40_Sub3.anInt2021)] = l_91_;
                    Class40_Sub3.anInt2021 = (1 + Class40_Sub3.anInt2021) % 100;
                    RSString class1 = KeyFocusListener.method956(67, incomingPacketBuffer).method53();
                    if(i_90_ == 2 || i_90_ == 3)
                        Class44.addChatMessage((RSString.linkRSStrings((new RSString[]{(Widget.goldCrown), Class60.method991(-73, l).method85()}))), class1, 7);
                    else if(i_90_ == 1)
                        Class44.addChatMessage((RSString.linkRSStrings((new RSString[]{Class51.whiteCrown, Class60.method991(-46, l).method85()}))), class1, 7);
                    else
                        Class44.addChatMessage(Class60.method991(-55, l).method85(), class1, 3);
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 27) { // reset actor animations
                for(int i_94_ = 0; (i_94_ < (Player.trackedPlayers).length); i_94_++) {
                    if((Player.trackedPlayers[i_94_]) != null)
                        Player.trackedPlayers[i_94_].playingAnimation = -1;
                }
                for(int i_95_ = 0; (((Player.npcs).length > i_95_)); i_95_++) {
                    if((Player.npcs[i_95_]) != null)
                        Player.npcs[i_95_].playingAnimation = -1;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == SET_TAB_WIDGET) {
                int i_96_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_97_ = incomingPacketBuffer.getUnsignedByte();
                if(i_96_ == 65535)
                    i_96_ = -1;
                if(i_96_ != Class40_Sub5_Sub11.tabWidgetIds[i_97_]) {
                    Class55.method958((Class40_Sub5_Sub11.tabWidgetIds[i_97_]));
                    Class40_Sub5_Sub11.tabWidgetIds[i_97_] = i_96_;
                }
                IdentityKit.drawTabIcons = true;
                incomingPacket = -1;
                ISAAC.redrawTabArea = true;
                return true;
            }
            if(incomingPacket == UPDATE_SKILL) {
                ISAAC.redrawTabArea = true;
                int i_98_ = incomingPacketBuffer.getUnsignedByte();
                int i_99_ = incomingPacketBuffer.getUnsignedByte();
                int i_100_ = incomingPacketBuffer.getIntLE();
                Item.anIntArray3051[i_99_] = i_100_;
                Class13.anIntArray403[i_99_] = i_98_;
                Wall.anIntArray354[i_99_] = 1;
                for(int i_101_ = 0; i_101_ < 98; i_101_++) {
                    if((Class38_Sub1.anIntArray1909[i_101_] <= i_100_))
                        Wall.anIntArray354[i_99_] = i_101_ + 2;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == MOVE_WIDGET_CHILD) { // move widget position
                int i_102_ = incomingPacketBuffer.getIntBE();
                int i_103_ = incomingPacketBuffer.getUnsignedShortLE();
                int i_104_ = incomingPacketBuffer.getUnsignedShortLE();
                Widget widget = Widget.forId(i_102_);
                widget.currentX = widget.originalX + i_104_;
                incomingPacket = -1;
                widget.currentY = widget.originalY + i_103_;
                return true;
            }
            if(incomingPacket == 72) {
                for(int i_105_ = 0; ((i_105_ < GroundItemTile.varbitmasks.length)); i_105_++) {
                    if(Buffer.anIntArray1984[i_105_] != GroundItemTile.varbitmasks[i_105_]) {
                        GroundItemTile.varbitmasks[i_105_] = Buffer.anIntArray1984[i_105_];
                        Class22.method309(-1, i_105_);
                        ISAAC.redrawTabArea = true;
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 240) {
                ActorDefinition.method580(ISAAC.aClass31_521, incomingPacketBuffer);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 58) {
                int i_106_ = incomingPacketBuffer.getIntME2();
                Class12.aSignlinkNode_394 = ISAAC.aClass31_521.method393(11545, i_106_);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_SPECIFIC_WIDGET_ITEMS) {
                ISAAC.redrawTabArea = true;
                int widgetData = incomingPacketBuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                while(incomingPacketSize > incomingPacketBuffer.currentPosition) {
                    int itemSlot = incomingPacketBuffer.getSmart();
                    int i_109_ = incomingPacketBuffer.getUnsignedShortBE();
                    int i_110_ = 0;
                    if(i_109_ != 0) {
                        i_110_ = incomingPacketBuffer.getUnsignedByte();
                        if(i_110_ == 255)
                            i_110_ = incomingPacketBuffer.getIntBE();
                    }
                    if(widget.isIf3) {
                        Widget[] widgets = (Widget.interfaces[widgetData >> 16]);
                        for(int i_111_ = 0; ((i_111_ < widgets.length)); i_111_++) {
                            Widget widget_112_ = widgets[i_111_];
                            if(((widget.id & 0xffff) == (widget_112_.parentId & 0xffff)) && 1 + itemSlot == (widget_112_.anInt2736)) {
                                widget_112_.itemAmount = i_110_;
                                widget_112_.itemId = i_109_ + -1;
                            }
                        }
                    } else if(itemSlot >= 0 && (widget.items.length > itemSlot)) {
                        widget.items[itemSlot] = i_109_;
                        widget.itemAmounts[itemSlot] = i_110_;
                    }
                }
                if(Class68.method1043(307)) {
                    Widget[] widgets = Widget.interfaces[307];
                    for(int y = 0; widgets.length > y; y++) {
                        Widget widget2 = widgets[y];
                        if(widget2 != null && widget2.items != null) {
                            System.out.println("Container ID: " + y);
                        }
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == SET_MAP_CHUNK) {
                FloorDecoration.method343(false, 5688);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == UPDATE_WIDGET_TEXT_COLOR) { // update widget text color
                int i_113_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_114_ = incomingPacketBuffer.getIntLE();
                int i_115_ = i_113_ >> 10 & 0x1f;
                int i_116_ = 0x1f & i_113_ >> 5;
                Widget widget = Widget.forId(i_114_);
                incomingPacket = -1;
                int i_117_ = i_113_ & 0x1f;
                widget.textColor = ((i_116_ << 11) + (i_115_ << 19) + (i_117_ << 3));
                return true;
            }
            if(incomingPacket == 211) {
                Class42.anInt1008 = incomingPacketSize / 8;
                for(int i_118_ = 0; ((Class42.anInt1008 > i_118_)); i_118_++)
                    WallDecoration.ignores[i_118_] = incomingPacketBuffer.getLongBE();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 124) {
                if(ChatBox.openChatboxWidgetId != -1) {
                    Class55.method958(ChatBox.openChatboxWidgetId);
                    ChatBox.openChatboxWidgetId = -1;
                }
                ChatBox.redrawChatbox = true;
                ChatBox.inputMessage = HuffmanEncoding.blank_string;
                ChatBox.inputType = 2;
                incomingPacket = -1;
                ChatBox.messagePromptRaised = false;
                return true;
            }
            CacheIndex.method169(("T1 - " + incomingPacket + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + incomingPacketSize), (byte) -121, null);
            Class48.method928(-7225);
        } catch(java.io.IOException ioexception) {
            Class59.dropClient(2578);
        } catch(Exception exception) {
            String string = ("T2 - " + incomingPacket + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + incomingPacketSize + "," + (SpotAnimDefinition.baseX + (Player.localPlayer.pathY[0])) + "," + ((Player.localPlayer.pathX[0]) + Class26.baseY) + " - ");
            for(int i = 0; (((incomingPacketSize > i)) && i < 50); i++)
                string += (incomingPacketBuffer.buffer[i] + ",");
            CacheIndex.method169(string, (byte) -120, exception);
            Class48.method928(-7225);
        }
        return true;

    }

    public static void parseNpcUpdatePacket() {
        Class17.deregisterActorCount = 0;
        Actor.actorUpdatingIndex = 0;
        Npc.parseTrackedNpcs();
        Npc.registerNewNpcs();
        Npc.parseNpcUpdateMasks();
        for(int i = 0; i < Class17.deregisterActorCount; i++) {
            int trackedNpcIndex = Player.deregisterActorIndices[i];
            if(Node.pulseCycle != (Player.npcs[trackedNpcIndex].anInt3134)) {
                Player.npcs[trackedNpcIndex].actorDefinition = null;
                Player.npcs[trackedNpcIndex] = null;
            }
        }
        if(incomingPacketBuffer.currentPosition != incomingPacketSize)
            throw new RuntimeException("gnp1 pos:" + (incomingPacketBuffer.currentPosition) + " psize:" + incomingPacketSize);
        for(int i = 0; Player.npcCount > i; i++) {
            if((Player.npcs[Player.npcIds[i]]) == null)
                throw new RuntimeException("gnp2 pos:" + i + " size:" + (Player.npcCount));
        }
    }

    public static void parsePlayerUpdatePacket() {
        Actor.actorUpdatingIndex = 0;
        Class17.deregisterActorCount = 0;
        Player.parsePlayerMovement();
        Player.parseTrackedPlayerMovement();
        Player.registerNewPlayers();
        Player.parseTrackedPlayerUpdateMasks();
        for(int i = 0; Class17.deregisterActorCount > i; i++) {
            int trackedPlayerIndex = Player.deregisterActorIndices[i];
            if(Node.pulseCycle != (Player.trackedPlayers[trackedPlayerIndex].anInt3134))
                Player.trackedPlayers[trackedPlayerIndex] = null;
        }
        if(incomingPacketSize != incomingPacketBuffer.currentPosition)
            throw new RuntimeException("gpp1 pos:" + (incomingPacketBuffer.currentPosition) + " psize:" + incomingPacketSize);
        int i = 0;
        for(/**/; Player.localPlayerCount > i; i++) {
            if((Player.trackedPlayers[Player.trackedPlayerIndices[i]]) == null)
                throw new RuntimeException("gpp2 pos:" + i + " size:" + Player.localPlayerCount);
        }
    }
}
