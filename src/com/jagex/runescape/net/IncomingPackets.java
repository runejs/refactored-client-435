package com.jagex.runescape.net;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

public class IncomingPackets {

    private static final int

            SET_WIDGET_ITEM_MODEL = 120,
            MOVE_WIDGET_CHILD = 3,
            UPDATE_SPECIFIC_WIDGET_ITEMS = 214,
            UPDATE_ALL_WIDGET_ITEMS = 12,
            UPDATE_WIDGET_TEXT = 110,
            SET_WIDGET_PLAYER_HEAD = 210,
            SET_WIDGET_NPC_HEAD = 160,
            PLAY_WIDGET_ANIMATION = 24,
            SET_TAB_WIDGET = 140,

            SHOW_CHATBOX_WIDGET = 208,
            SHOW_SCREEN_WIDGET = 118,
            SHOW_FULLSCREEN_WIDGET = 195,
            SHOW_TAB_AND_SCREEN_WIDGETS = 84,
            CLOSE_ALL_WIDGETS = 180,

            UPDATE_CARRY_WEIGHT = 171,
            UPDATE_RUN_ENERGY = 18,
            UPDATE_SKILL = 34,

            UPDATE_REFERENCE_POSITION = 254,
            SET_MAP_CHUNK = 166,
            CLEAR_MAP_CHUNK = 64,

            UPDATE_PLAYERS = 92,
            UPDATE_NPCS = 128,
            LOGOUT = 181,

            PLAY_SOUND = 131;

    public static boolean parseIncomingPackets(boolean arg0) {
        if(Class40_Sub6.aClass64_2098 == null)
            return false;
        try {
            int i = Class40_Sub6.aClass64_2098.method1014(-122);
            if(i == 0)
                return false;
            if(Class57.incomingPacket == -1) {
                Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                Cache.outgoingbuffer.currentPosition = 0;
                i--;
                Class57.incomingPacket = Cache.outgoingbuffer.getPacket((byte) 49);
                Widget.packetsize = Class24.INCOMINGPACKETSIZES[Class57.incomingPacket];
            }
            //System.out.println("packet received: " + Class57.incomingPacket);
            if(Widget.packetsize == -1) {
                if(i > 0) {
                    Class40_Sub6.aClass64_2098.method1008(0, 1, -127, Cache.outgoingbuffer.buffer);
                    Widget.packetsize = (Cache.outgoingbuffer.buffer[0] & 0xff);
                    i--;
                } else
                    return false;
            }
            if(Widget.packetsize == -2) {
                if(i <= 1)
                    return false;
                i -= 2;
                Class40_Sub6.aClass64_2098.method1008(0, 2, -127, Cache.outgoingbuffer.buffer);
                Cache.outgoingbuffer.currentPosition = 0;
                Widget.packetsize = Cache.outgoingbuffer.getUnsignedShortBE();
            }
            if((Widget.packetsize > i))
                return false;
            Cache.outgoingbuffer.currentPosition = 0;
            Class40_Sub6.aClass64_2098.method1008(0, Widget.packetsize, -128, Cache.outgoingbuffer.buffer);
            Class49.anInt1151 = Cache.anInt324;
            Class35.anInt1728 = 0;
            Cache.anInt324 = RSString.anInt1690;
            RSString.anInt1690 = Class57.incomingPacket;
            if(Class57.incomingPacket == 71) {
                long l = Cache.outgoingbuffer.getLongBE();
                RSString class1 = KeyFocusListener.method956(82, Cache.outgoingbuffer).method53(-16315);
                Class44.addChatMessage(Class60.method991(-42, l).method85(-4305), class1, 6);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 156) { // friend logged in
                long l = Cache.outgoingbuffer.getLongBE();
                int i_1_ = Cache.outgoingbuffer.getUnsignedShortBE();
                RSString string = Class60.method991(-64, l).method85(-4305);
                for(int i_2_ = 0; i_2_ < Class40_Sub5_Sub17_Sub3.friendsCount; i_2_++) {
                    if(l == Class59.aLongArray1397[i_2_]) {
                        if(i_1_ != Class40_Sub7.friendWorlds[i_2_]) {
                            Class40_Sub7.friendWorlds[i_2_] = i_1_;
                            ISAAC.redrawTabArea = true;
                            if(i_1_ > 0)
                                Class44.addChatMessage(HuffmanEncoding.blank_string, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{string, (Class42.aClass1_988)}))), 5);
                            if(i_1_ == 0)
                                Class44.addChatMessage(HuffmanEncoding.blank_string, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{string, Class38_Sub1.aClass1_1905}))), 5);
                        }
                        string = null;
                        break;
                    }
                }
                boolean bool = false;
                if(string != null && Class40_Sub5_Sub17_Sub3.friendsCount < 200) {
                    Class59.aLongArray1397[(Class40_Sub5_Sub17_Sub3.friendsCount)] = l;
                    Class40_Sub11.friendUsernames[(Class40_Sub5_Sub17_Sub3.friendsCount)] = string;
                    Class40_Sub7.friendWorlds[(Class40_Sub5_Sub17_Sub3.friendsCount)] = i_1_;
                    Class40_Sub5_Sub17_Sub3.friendsCount++;
                    ISAAC.redrawTabArea = true;
                }
                while(!bool) {
                    bool = true;
                    for(int i_3_ = 0; Class40_Sub5_Sub17_Sub3.friendsCount - 1 > i_3_; i_3_++) {
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
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 233) {
                Class57.incomingPacket = -1;
                VarbitDefinition.anInt2366 = 0;
                return true;
            }
            if(Class57.incomingPacket == 7) {
                Class39.aBoolean906 = false;
                for(int i_7_ = 0; i_7_ < 5; i_7_++)
                    Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_7_] = false;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 23) {
                FloorDecoration.method343(true, 5688);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 222) {
                int i_8_ = Cache.outgoingbuffer.getOffsetInvertedByte();
                int i_9_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                Buffer.anIntArray1984[i_9_] = i_8_;
                if(GroundItemTile.varbitmasks[i_9_] != i_8_) {
                    GroundItemTile.varbitmasks[i_9_] = i_8_;
                    Class22.method309(-1, i_9_);
                    ISAAC.redrawTabArea = true;
                    if(Class48.anInt1138 != -1)
                        Class52.redrawChatbox = true;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 115) { // set widget hidden state
                boolean bool = (Cache.outgoingbuffer.getUnsignedByte() == 1);
                int i_10_ = Cache.outgoingbuffer.getIntME1();
                Widget widget = Widget.forId(i_10_);
                widget.isHidden = bool;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_ALL_WIDGET_ITEMS) {
                /*for(int qq = 0; qq < Class58.varbitmasks.length; qq++) {
                    int value = (Npc.method795((byte) -70, qq).anInt2633);

                    if(value != 0) {
                        System.out.println(qq + " = " + value);
                    }
                }*/
                /*for(int qq = 0; qq < 469; qq++) {
                    if(Class68.method1043(qq)) {
                        Widget[] widgets = Widget.interfaces[qq];
                        for(int y = 0; widgets.length > y; y++) {
                            Widget widget = widgets[y];
                            if(widget.items != null && widget.alternateRhs != null) {
                                System.out.println(qq + " contains alternateOperators");
                            }*/
                            /*if(widget.configActions != null) {
                                for(int jj = 0; jj < widget.configActions.length; jj++) {
                                    if(widget.configActions[jj] != null) {
                                        System.out.println(qq + " contains " + widget.configActions[jj]);
                                    }
                                }
                            }*/
                            //if(widget.items != null && widget.items.length == 28) {
                            //    System.out.println(qq + " contains inventory");
                            //}
                        /*}
                    }
                }*/
                /*if(Class68.method1043(149)) {
                    Widget[] widgets = Widget.interfaces[149];
                    for(int y = 0; widgets.length > y; y++) {
                        Widget widget = widgets[y];
                        if(widget != null && widget.clientScripts != null) {
                            String widgetText = widget.text.toString();
                            if(widgetText.contains("Members")) {
                                System.out.println(y);
                            }
                        }
                    }
                }*/
                ISAAC.redrawTabArea = true;
                int widgetData = Cache.outgoingbuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                if(widget.isIf3) {
                    Widget[] widgets = (Widget.interfaces[widgetData >> 16]);
                    for(int childIndex = 0; childIndex < widgets.length; childIndex++) {
                        Widget child = widgets[childIndex];
                        if(((0xffff & widget.id) == (0xffff & child.parentId)) && child.anInt2736 > 0) {
                            child.anInt2734 = 0;
                            child.anInt2718 = -1;
                        }
                    }
                } else {
                    for(int containerIndex = 0; widget.items.length > containerIndex; containerIndex++) {
                        widget.items[containerIndex] = 0;
                        widget.itemAmounts[containerIndex] = 0;
                    }
                }
                int containerSize = Cache.outgoingbuffer.getUnsignedShortBE();
                for(int containerIndex = 0; (containerSize > containerIndex); containerIndex++) {
                    int itemAmount = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                    if(itemAmount == 255)
                        itemAmount = Cache.outgoingbuffer.getIntBE();
                    int itemId = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                    if(widget.isIf3) {
                        Widget[] widgets = (Widget.interfaces[widgetData >> 16]);
                        for(int childIndex = 0; ((childIndex < widgets.length)); childIndex++) {
                            Widget child = widgets[childIndex];
                            if(((widget.id & 0xffff) == (child.parentId & 0xffff)) && (1 + containerIndex == child.anInt2736)) {
                                child.anInt2734 = itemAmount;
                                child.anInt2718 = -1 + itemId;
                            }
                        }
                    } else if(widget.items.length > containerIndex) {
                        widget.items[containerIndex] = itemId;
                        widget.itemAmounts[containerIndex] = itemAmount;
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 250) { // widget model type 1
                int modelId = Cache.outgoingbuffer.getUnsignedShortLE();
                int widgetData = Cache.outgoingbuffer.getIntME1();
                Widget widget = Widget.forId(widgetData);
                widget.modelId = modelId;
                widget.modelType = 1;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 255) {
                int i_23_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_24_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_25_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_26_ = Cache.outgoingbuffer.getUnsignedByte();
                Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_23_] = true;
                Class8.anIntArray297[i_23_] = i_24_;
                RSApplet.anIntArray2[i_23_] = i_25_;
                GroundItemTile.anIntArray1358[i_23_] = i_26_;
                Class22_Sub1.anIntArray1846[i_23_] = 0;
                Class57.incomingPacket = -1;
                return true;
            }
            if(arg0)
                CollisionMap.anInt172 = -96;
            if(Class57.incomingPacket == 235) {
                Class27.anInt658 = Cache.outgoingbuffer.getUnsignedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 48) {
                Class40_Sub6.anInt2118 = Cache.outgoingbuffer.getUnsignedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 82) {
                RSString message = Cache.outgoingbuffer.getRSString();
                if(message.method87(103, AnimationSequence.requestcmd_tradereq)) {
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
                } else if(message.method87(104, Class40_Sub5_Sub6.requestcmd_duelreq)) {
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
                } else if(message.method87(81, Node.requestcmd_chalreq)) {
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
                } else
                    Class44.addChatMessage(HuffmanEncoding.blank_string, message, 0);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 182) { // set widget scroll position
                int i_34_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_35_ = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(i_35_);
                Class57.incomingPacket = -1;
                if(widget != null && widget.type == 0) {
                    if(i_34_ < 0)
                        i_34_ = 0;
                    if((-widget.originalHeight + widget.scrollHeight) < i_34_)
                        i_34_ = (-widget.originalHeight + widget.scrollHeight);
                    widget.scrollPosition = i_34_;
                }
                return true;
            }
            if(Class57.incomingPacket == 174) { // clear widget item container?
                int i_36_ = Cache.outgoingbuffer.getIntME1();
                Widget widget = Widget.forId(i_36_);
                if(widget.isIf3) {
                    Widget[] widgets = (Widget.interfaces[i_36_ >> 16]);
                    for(int i_37_ = 0; i_37_ < widgets.length; i_37_++) {
                        Widget widget_38_ = widgets[i_37_];
                        if(((0xffff & widget.id) == (widget_38_.parentId & 0xffff)) && widget_38_.anInt2736 > 0) {
                            widget_38_.anInt2718 = -1;
                            widget_38_.anInt2734 = 0;
                        }
                    }
                } else {
                    for(int i_39_ = 0; widget.items.length > i_39_; i_39_++) {
                        widget.items[i_39_] = -1;
                        widget.items[i_39_] = 0;
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 130) {
                Class34.anInt854 = Cache.outgoingbuffer.getUnsignedShortLE();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 129) {
                int i_40_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
                int i_41_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_42_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
                Player.anInt3267 = i_40_ >> 1;
                Player.localPlayer.method787(i_42_, -7717, (i_40_ & 0x1) == 1, i_41_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == LOGOUT) {
                Class48.method928(-7225);
                Class57.incomingPacket = -1;
                return false;
            }
            if(Class57.incomingPacket == PLAY_WIDGET_ANIMATION) {
                int animationId = Cache.outgoingbuffer.getShortBE();
                int widgetData = Cache.outgoingbuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                if((animationId != widget.animation) || animationId == -1) {
                    widget.anInt2660 = 0;
                    widget.anInt2654 = 0;
                    widget.animation = animationId;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 56) {
                int i_45_ = Cache.outgoingbuffer.getNegativeOffsetShortBE();
                if(i_45_ >= 0)
                    Class42.method883((byte) -121, i_45_);
                if(i_45_ != GroundItemTile.anInt1376) {
                    Class55.method958(GroundItemTile.anInt1376, -14222);
                    GroundItemTile.anInt1376 = i_45_;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 117) {
                int i_46_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_47_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE();
                int i_48_ = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(i_48_);
                Class57.incomingPacket = -1;
                widget.anInt2722 = i_47_ + (i_46_ << 16);
                return true;
            }
            if(Class57.incomingPacket == SHOW_TAB_AND_SCREEN_WIDGETS) { // show tab and screen widget
                int i_49_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_50_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE();
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class52.redrawChatbox = true;
                    Class43.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId, -14222);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30, 91);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != i_50_) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
                    HuffmanEncoding.openScreenWidgetId = i_50_;
                }
                if(Class29.tabAreaOverlayWidgetId != i_49_) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    Class29.tabAreaOverlayWidgetId = i_49_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                ISAAC.redrawTabArea = true;
                IdentityKit.aBoolean2597 = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == CLEAR_MAP_CHUNK) {
                OverlayDefinition.placementY = Cache.outgoingbuffer.getUnsignedByte();
                Class40_Sub6.placementX = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                for(int i_51_ = Class40_Sub6.placementX; ((i_51_ < 8 + Class40_Sub6.placementX)); i_51_++) {
                    for(int i_52_ = OverlayDefinition.placementY; ((8 + OverlayDefinition.placementY > i_52_)); i_52_++) {
                        if((Wall.aClass45ArrayArrayArray357[Player.anInt3267][i_51_][i_52_]) != null) {
                            Wall.aClass45ArrayArrayArray357[Player.anInt3267][i_51_][i_52_] = null;
                            Class40_Sub13.method880((byte) -80, i_52_, i_51_);
                        }
                    }
                }
                for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) Class45.aClass45_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = (Class40_Sub3) Class45.aClass45_1064.method909(-4)) {
                    if(class40_sub3.anInt2039 >= Class40_Sub6.placementX && (Class40_Sub6.placementX + 8 > class40_sub3.anInt2039) && (class40_sub3.anInt2038 >= OverlayDefinition.placementY) && (OverlayDefinition.placementY + 8 > class40_sub3.anInt2038) && (Player.anInt3267 == class40_sub3.anInt2018))
                        class40_sub3.anInt2031 = 0;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 223) { // set player options
                RSString class1 = Cache.outgoingbuffer.getRSString();
                int i_53_ = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                int i_54_ = Cache.outgoingbuffer.getUnsignedByte();
                if(i_54_ >= 1 && i_54_ <= 5) {
                    if(class1.equalsIgnoreCase(RSApplet.aClass1_34, !arg0))
                        class1 = null;
                    Main.aClass1Array1778[i_54_ + -1] = class1;
                    Class13.aBooleanArray414[i_54_ + -1] = i_53_ == 0;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SHOW_SCREEN_WIDGET) {
                int i_55_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Class42.method883((byte) -127, i_55_);
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    IdentityKit.aBoolean2597 = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                    ISAAC.redrawTabArea = true;
                }
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class52.redrawChatbox = true;
                    Class43.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId, -14222);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30, -117);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(i_55_ != HuffmanEncoding.openScreenWidgetId) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
                    HuffmanEncoding.openScreenWidgetId = i_55_;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                Class64.method1012(HuffmanEncoding.openScreenWidgetId, 2);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_RUN_ENERGY) {
                if(Class5.currentTabId == 12)
                    ISAAC.redrawTabArea = true;
                Class40_Sub11.runEnergy = Cache.outgoingbuffer.getUnsignedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 253) {
                Class39.aBoolean906 = true;
                Class22.anInt545 = Cache.outgoingbuffer.getUnsignedByte();
                Class32.anInt767 = Cache.outgoingbuffer.getUnsignedByte();
                Class5.anInt194 = Cache.outgoingbuffer.getUnsignedShortBE();
                Class4.anInt188 = Cache.outgoingbuffer.getUnsignedByte();
                Class59.anInt1386 = Cache.outgoingbuffer.getUnsignedByte();
                if(Class59.anInt1386 >= 100) {
                    Class40_Sub5_Sub6.cameraY = 64 + Class32.anInt767 * 128;
                    Class12.cameraX = Class22.anInt545 * 128 + 64;
                    Class32.cameraZ = (Class37.method430((byte) -125, (Player.anInt3267), Class12.cameraX, Class40_Sub5_Sub6.cameraY) - Class5.anInt194);
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 185) {
                int i_56_ = Cache.outgoingbuffer.getNegativeOffsetShortBE();
                if(Class48.anInt1138 != i_56_) {
                    Class55.method958(Class48.anInt1138, -14222);
                    Class48.anInt1138 = i_56_;
                }
                Class57.incomingPacket = -1;
                Class52.redrawChatbox = true;
                return true;
            }
            if(Class57.incomingPacket == SHOW_FULLSCREEN_WIDGET) { // fullscreen widget?
                int secondaryWidgetId = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                int fullscreenWidgetId = Cache.outgoingbuffer.getUnsignedShortBE();
                Class42.method883((byte) -120, fullscreenWidgetId);
                if(secondaryWidgetId != -1)
                    Class42.method883((byte) -124, secondaryWidgetId);
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    Class29.tabAreaOverlayWidgetId = -1;
                }
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                }
                if(fullscreenWidgetId != ActorDefinition.openFullScreenWidgetId) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId, -14222);
                    ActorDefinition.openFullScreenWidgetId = fullscreenWidgetId;
                    OverlayDefinition.method559(35, -57);
                }
                if(fullscreenWidgetId != UnderlayDefinition.openSecondaryWidgetId) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
                    UnderlayDefinition.openSecondaryWidgetId = secondaryWidgetId;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                Class40_Sub5_Sub15.inputType = 0;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == CLOSE_ALL_WIDGETS) {
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    ISAAC.redrawTabArea = true;
                    IdentityKit.aBoolean2597 = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                }
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class52.redrawChatbox = true;
                    Class43.openChatboxWidgetId = -1;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId, -14222);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30, -84);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                Class57.incomingPacket = -1;
                CacheIndex_Sub1.anInt1819 = -1;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                return true;
            }
            if(Class57.incomingPacket == SHOW_CHATBOX_WIDGET) {
                int widgetId = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                Class42.method883((byte) -119, widgetId);
                if(Class29.tabAreaOverlayWidgetId != -1) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    IdentityKit.aBoolean2597 = true;
                    Class29.tabAreaOverlayWidgetId = -1;
                    ISAAC.redrawTabArea = true;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId, -14222);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30, -53);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                if(Class43.openChatboxWidgetId != widgetId) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = widgetId;
                }

                Class52.redrawChatbox = true;
                Class57.incomingPacket = -1;
                CacheIndex_Sub1.anInt1819 = -1;
                return true;
            }
            if(Class57.incomingPacket == 217) {
                int i_60_ = Cache.outgoingbuffer.getUnsignedShortLE();
                if(i_60_ == 65535)
                    i_60_ = -1;
                Class51.method942(257, i_60_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 40) {
                int i_61_ = Cache.outgoingbuffer.getMediumBE();
                int i_62_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                if(i_62_ == 65535)
                    i_62_ = -1;
                Class57.method975(i_61_, (byte) 110, i_62_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_REFERENCE_POSITION) {
                OverlayDefinition.placementY = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                Class40_Sub6.placementX = Cache.outgoingbuffer.getUnsignedInvertedByte();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 88) {
                Class51.anInt1205 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                if(Class5.currentTabId == Class51.anInt1205) {
                    if(Class51.anInt1205 != 3)
                        Class5.currentTabId = 3;
                    else
                        Class5.currentTabId = 1;
                    ISAAC.redrawTabArea = true;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 63) { // mass object/ground item update packet
                Class40_Sub6.placementX = Cache.outgoingbuffer.getUnsignedInvertedByte();
                OverlayDefinition.placementY = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                while(Cache.outgoingbuffer.currentPosition < Widget.packetsize) {
                    Class57.incomingPacket = Cache.outgoingbuffer.getUnsignedByte();
                    WallDecoration.method949((byte) -125);
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 196) { // set chat mode configs
                Class35.publicChatMode = Cache.outgoingbuffer.getUnsignedByte();
                Class4.anInt185 = Cache.outgoingbuffer.getUnsignedByte();
                ItemDefinition.anInt2797 = Cache.outgoingbuffer.getUnsignedByte();
                Class52.redrawChatbox = true;
                Cache.aBoolean330 = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 116) {
                Class40_Sub5_Sub15.anInt2782 = (Cache.outgoingbuffer.getUnsignedShortLE() * 30);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_PLAYERS) {
                parsePlayerUpdatePacket((byte) 57);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 2) {
                int i_63_ = Cache.outgoingbuffer.getIntME1();
                int i_64_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[i_64_] = i_63_;
                if(i_63_ != GroundItemTile.varbitmasks[i_64_]) {
                    GroundItemTile.varbitmasks[i_64_] = i_63_;
                    Class22.method309(-1, i_64_);
                    if(Class48.anInt1138 != -1)
                        Class52.redrawChatbox = true;
                    ISAAC.redrawTabArea = true;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_NPCS) {
                parseNpcUpdatePacket(89);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == PLAY_SOUND) {
                int soundId = Cache.outgoingbuffer.getUnsignedShortBE();
                int volume = Cache.outgoingbuffer.getUnsignedByte();
                int delay = Cache.outgoingbuffer.getUnsignedShortBE();
                WallDecoration.method950(soundId, volume, delay);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 237) { // show tab overlay widget
                int i_68_ = Cache.outgoingbuffer.getUnsignedShortBE();
                Class42.method883((byte) 107, i_68_);
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                    Class52.redrawChatbox = true;
                }
                if(ActorDefinition.openFullScreenWidgetId != -1) {
                    Class55.method958(ActorDefinition.openFullScreenWidgetId, -14222);
                    ActorDefinition.openFullScreenWidgetId = -1;
                    OverlayDefinition.method559(30, 81);
                }
                if(UnderlayDefinition.openSecondaryWidgetId != -1) {
                    Class55.method958(UnderlayDefinition.openSecondaryWidgetId, -14222);
                    UnderlayDefinition.openSecondaryWidgetId = -1;
                }
                if(HuffmanEncoding.openScreenWidgetId != -1) {
                    Class55.method958(HuffmanEncoding.openScreenWidgetId, -14222);
                    HuffmanEncoding.openScreenWidgetId = -1;
                }
                if(Class29.tabAreaOverlayWidgetId != i_68_) {
                    Class55.method958(Class29.tabAreaOverlayWidgetId, -14222);
                    Class29.tabAreaOverlayWidgetId = i_68_;
                }
                IdentityKit.aBoolean2597 = true;
                if(Class40_Sub5_Sub15.inputType != 0) {
                    Class52.redrawChatbox = true;
                    Class40_Sub5_Sub15.inputType = 0;
                }
                CacheIndex_Sub1.anInt1819 = -1;
                Class57.incomingPacket = -1;
                ISAAC.redrawTabArea = true;
                return true;
            }
            if(Class57.incomingPacket == 234) {
                Class39.aBoolean906 = true;
                HashTable.anInt564 = Cache.outgoingbuffer.getUnsignedByte();
                UnderlayDefinition.anInt2576 = Cache.outgoingbuffer.getUnsignedByte();
                Class38.anInt892 = Cache.outgoingbuffer.getUnsignedShortBE();
                Class60.anInt1413 = Cache.outgoingbuffer.getUnsignedByte();
                Class22_Sub1.anInt1856 = Cache.outgoingbuffer.getUnsignedByte();
                if(Class22_Sub1.anInt1856 >= 100) {
                    int i_69_ = 128 * HashTable.anInt564 + 64;
                    int i_70_ = 128 * UnderlayDefinition.anInt2576 + 64;
                    int i_71_ = (Class37.method430((byte) -120, (Player.anInt3267), i_69_, i_70_) - Class38.anInt892);
                    int i_72_ = i_69_ + -Class12.cameraX;
                    int i_73_ = i_70_ + -Class40_Sub5_Sub6.cameraY;
                    int i_74_ = -Class32.cameraZ + i_71_;
                    int i_75_ = (int) Math.sqrt((double) (i_73_ * i_73_ + i_72_ * i_72_));
                    Class26.anInt627 = ((int) (325.949 * Math.atan2((double) i_74_, (double) i_75_)) & 0x7ff);
                    Class68_Sub1.anInt2210 = (int) (Math.atan2((double) i_72_, (double) i_73_) * -325.949) & 0x7ff;
                    if(Class26.anInt627 < 128)
                        Class26.anInt627 = 128;
                    if(Class26.anInt627 > 383)
                        Class26.anInt627 = 383;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 142) {
                int i_76_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_77_ = Cache.outgoingbuffer.getUnsignedShortLE();
                int i_78_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_79_ = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(i_79_);
                Class57.incomingPacket = -1;
                widget.rotationZ = i_76_;
                widget.modelZoom = i_77_;
                widget.rotationX = i_78_;
                return true;
            }
            if(Class57.incomingPacket == 6) {
                Class5.currentTabId = Cache.outgoingbuffer.getUnsignedByte();
                IdentityKit.aBoolean2597 = true;
                ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_CARRY_WEIGHT) { // update carry weight
                if(Class5.currentTabId == 12)
                    ISAAC.redrawTabArea = true;
                Class52.anInt1222 = Cache.outgoingbuffer.getShortBE();
                Class57.incomingPacket = -1;
                return true;
            }
            // object/ground item update packets?
            if(Class57.incomingPacket == 9 || Class57.incomingPacket == 99 || Class57.incomingPacket == 229 ||
                    Class57.incomingPacket == 19 || Class57.incomingPacket == 202 || Class57.incomingPacket == 1 ||
                    Class57.incomingPacket == 74 || Class57.incomingPacket == 175 || Class57.incomingPacket == 49 ||
                    Class57.incomingPacket == 143 || Class57.incomingPacket == 241) {
                WallDecoration.method949((byte) -112);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 14) { // reset client configs?
                for(int i_80_ = 0; Class59.anInt1383 > i_80_; i_80_++) {
                    Class40_Sub5_Sub11 class40_sub5_sub11 = Npc.method795((byte) -114, i_80_);
                    if(class40_sub5_sub11 != null && class40_sub5_sub11.anInt2633 == 0) {
                        Buffer.anIntArray1984[i_80_] = 0;
                        GroundItemTile.varbitmasks[i_80_] = 0;
                    }
                }
                if(Class48.anInt1138 != -1)
                    Class52.redrawChatbox = true;
                ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_WIDGET_NPC_HEAD) {
                int npcId = Cache.outgoingbuffer.getUnsignedShortLE();
                int widgetData = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelType = 2;
                Class57.incomingPacket = -1;
                widget.modelId = npcId;
                return true;
            }
            if(Class57.incomingPacket == 132) { // open chatbox input widget
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                }
                Class57.incomingPacket = -1;
                HuffmanEncoding.inputInputMessage = HuffmanEncoding.blank_string;
                Class40_Sub5_Sub15.inputType = 1;
                Class52.redrawChatbox = true;
                InteractiveObject.messagePromptRaised = false;
                return true;
            }
            if(Class57.incomingPacket == 186) {
                Player.anInt3288 = Cache.outgoingbuffer.getUnsignedByte();
                if(Player.anInt3288 == 1)
                    HuffmanEncoding.anInt1545 = Cache.outgoingbuffer.getUnsignedShortBE();
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
                    Class68.anInt1637 = Cache.outgoingbuffer.getUnsignedShortBE();
                    Class4.anInt175 = Cache.outgoingbuffer.getUnsignedShortBE();
                    ActorDefinition.anInt2404 = Cache.outgoingbuffer.getUnsignedByte();
                }
                if(Player.anInt3288 == 10)
                    Class68.anInt1623 = Cache.outgoingbuffer.getUnsignedShortBE();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_WIDGET_PLAYER_HEAD) {
                int widgetData = Cache.outgoingbuffer.getIntLE();
                Widget widget = Widget.forId(widgetData);
                widget.modelType = 3;
                widget.modelId = Player.localPlayer.aClass30_3282.method374(-20874);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_WIDGET_TEXT) {
                int widgetData = Cache.outgoingbuffer.getIntLE();
                RSString class1 = Cache.outgoingbuffer.getRSString();
                Widget widget = Widget.forId(widgetData);
                widget.disabledText = class1;
                if(Class40_Sub5_Sub11.tabWidgetIds[Class5.currentTabId] == widgetData >> 16)
                    ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 70) {
                Class12.friendListStatus = Cache.outgoingbuffer.getUnsignedByte();
                ISAAC.redrawTabArea = true;
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_WIDGET_ITEM_MODEL) { // item model on interface
                int zoom = Cache.outgoingbuffer.getUnsignedShortBE();
                int itemId = Cache.outgoingbuffer.getUnsignedShortLE();
                int widgetData = Cache.outgoingbuffer.getIntLE();
                if(itemId == 65535)
                    itemId = -1;
                Widget widget = Widget.forId(widgetData);
                if(widget.isIf3) {
                    widget.anInt2734 = 1;
                    widget.anInt2718 = itemId;
                } else {
                    if(itemId == -1) {
                        Class57.incomingPacket = -1;
                        widget.modelType = 0;
                        return true;
                    }
                    ItemDefinition itemDefinition = ItemDefinition.forId(itemId, 10);
                    widget.rotationX = itemDefinition.xan2d;
                    widget.modelId = itemId;
                    widget.modelType = 4;
                    widget.modelZoom = 100 * itemDefinition.zoom2d / zoom;
                    widget.rotationZ = itemDefinition.yan2d;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 51) { // friend login???
                long l = Cache.outgoingbuffer.getLongBE();
                long l_88_ = (long) Cache.outgoingbuffer.getUnsignedShortBE();
                long l_89_ = (long) Cache.outgoingbuffer.getMediumBE();
                int i_90_ = Cache.outgoingbuffer.getUnsignedByte();
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
                    RSString class1 = KeyFocusListener.method956(67, Cache.outgoingbuffer).method53(-16315);
                    if(i_90_ == 2 || i_90_ == 3)
                        Class44.addChatMessage((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{(Widget.goldCrown), Class60.method991(-73, l).method85(-4305)}))), class1, 7);
                    else if(i_90_ == 1)
                        Class44.addChatMessage((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{Class51.whiteCrown, Class60.method991(-46, l).method85(-4305)}))), class1, 7);
                    else
                        Class44.addChatMessage(Class60.method991(-55, l).method85(-4305), class1, 3);
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 27) { // reset actor animations
                for(int i_94_ = 0; (i_94_ < (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156).length); i_94_++) {
                    if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_94_]) != null)
                        Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_94_].playingAnimation = -1;
                }
                for(int i_95_ = 0; (((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813).length > i_95_)); i_95_++) {
                    if((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_95_]) != null)
                        CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_95_].playingAnimation = -1;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_TAB_WIDGET) {
                int i_96_ = Cache.outgoingbuffer.getUnsignedShortBE();
                int i_97_ = Cache.outgoingbuffer.getUnsignedByte();
                if(i_96_ == 65535)
                    i_96_ = -1;
                if(i_96_ != Class40_Sub5_Sub11.tabWidgetIds[i_97_]) {
                    Class55.method958((Class40_Sub5_Sub11.tabWidgetIds[i_97_]), -14222);
                    Class40_Sub5_Sub11.tabWidgetIds[i_97_] = i_96_;
                }
                IdentityKit.aBoolean2597 = true;
                Class57.incomingPacket = -1;
                ISAAC.redrawTabArea = true;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_SKILL) {
                ISAAC.redrawTabArea = true;
                int i_98_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_99_ = Cache.outgoingbuffer.getUnsignedByte();
                int i_100_ = Cache.outgoingbuffer.getIntME1();
                Class40_Sub5_Sub17_Sub3.anIntArray3051[i_99_] = i_100_;
                Class13.anIntArray403[i_99_] = i_98_;
                Wall.anIntArray354[i_99_] = 1;
                for(int i_101_ = 0; i_101_ < 98; i_101_++) {
                    if((Class38_Sub1.anIntArray1909[i_101_] <= i_100_))
                        Wall.anIntArray354[i_99_] = i_101_ + 2;
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == MOVE_WIDGET_CHILD) { // move widget position
                int i_102_ = Cache.outgoingbuffer.getIntBE();
                int i_103_ = Cache.outgoingbuffer.getNegativeOffsetShortLE();
                int i_104_ = Cache.outgoingbuffer.getNegativeOffsetShortLE();
                Widget widget = Widget.forId(i_102_);
                widget.currentX = widget.originalX + i_104_;
                Class57.incomingPacket = -1;
                widget.currentY = widget.originalY + i_103_;
                return true;
            }
            if(Class57.incomingPacket == 72) {
                for(int i_105_ = 0; ((i_105_ < GroundItemTile.varbitmasks.length)); i_105_++) {
                    if(Buffer.anIntArray1984[i_105_] != GroundItemTile.varbitmasks[i_105_]) {
                        GroundItemTile.varbitmasks[i_105_] = Buffer.anIntArray1984[i_105_];
                        Class22.method309(-1, i_105_);
                        ISAAC.redrawTabArea = true;
                    }
                }
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 240) {
                ActorDefinition.method580(ISAAC.aClass31_521, Cache.outgoingbuffer);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 58) {
                int i_106_ = Cache.outgoingbuffer.getIntME2();
                Class12.aSignlinkNode_394 = ISAAC.aClass31_521.method393(11545, i_106_);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == UPDATE_SPECIFIC_WIDGET_ITEMS) {
                ISAAC.redrawTabArea = true;
                int widgetData = Cache.outgoingbuffer.getIntBE();
                Widget widget = Widget.forId(widgetData);
                while(Widget.packetsize > Cache.outgoingbuffer.currentPosition) {
                    int itemSlot = Cache.outgoingbuffer.getSmart();
                    int i_109_ = Cache.outgoingbuffer.getUnsignedShortBE();
                    int i_110_ = 0;
                    if(i_109_ != 0) {
                        i_110_ = Cache.outgoingbuffer.getUnsignedByte();
                        if(i_110_ == 255)
                            i_110_ = Cache.outgoingbuffer.getIntBE();
                    }
                    if(widget.isIf3) {
                        Widget[] widgets = (Widget.interfaces[widgetData >> 16]);
                        for(int i_111_ = 0; ((i_111_ < widgets.length)); i_111_++) {
                            Widget widget_112_ = widgets[i_111_];
                            if(((widget.id & 0xffff) == (widget_112_.parentId & 0xffff)) && 1 + itemSlot == (widget_112_.anInt2736)) {
                                widget_112_.anInt2734 = i_110_;
                                widget_112_.anInt2718 = i_109_ + -1;
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
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == SET_MAP_CHUNK) {
                FloorDecoration.method343(false, 5688);
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 231) { // update widget text color
                int i_113_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                int i_114_ = Cache.outgoingbuffer.getIntLE();
                int i_115_ = i_113_ >> 10 & 0x1f;
                int i_116_ = 0x1f & i_113_ >> 5;
                Widget widget = Widget.forId(i_114_);
                Class57.incomingPacket = -1;
                int i_117_ = i_113_ & 0x1f;
                widget.textColor = ((i_116_ << 11) + (i_115_ << 19) + (i_117_ << 3));
                return true;
            }
            if(Class57.incomingPacket == 211) {
                Class42.anInt1008 = Widget.packetsize / 8;
                for(int i_118_ = 0; ((Class42.anInt1008 > i_118_)); i_118_++)
                    WallDecoration.ignores[i_118_] = Cache.outgoingbuffer.getLongBE();
                Class57.incomingPacket = -1;
                return true;
            }
            if(Class57.incomingPacket == 124) {
                if(Class43.openChatboxWidgetId != -1) {
                    Class55.method958(Class43.openChatboxWidgetId, -14222);
                    Class43.openChatboxWidgetId = -1;
                }
                Class52.redrawChatbox = true;
                HuffmanEncoding.inputInputMessage = HuffmanEncoding.blank_string;
                Class40_Sub5_Sub15.inputType = 2;
                Class57.incomingPacket = -1;
                InteractiveObject.messagePromptRaised = false;
                return true;
            }
            CacheIndex.method169(("T1 - " + Class57.incomingPacket + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + Widget.packetsize), (byte) -121, null);
            Class48.method928(-7225);
        } catch(java.io.IOException ioexception) {
            Class59.dropClient(2578);
        } catch(Exception exception) {
            String string = ("T2 - " + Class57.incomingPacket + "," + Cache.anInt324 + "," + Class49.anInt1151 + " - " + Widget.packetsize + "," + (SpotAnimDefinition.anInt2307 + (Player.localPlayer.pathY[0])) + "," + ((Player.localPlayer.pathX[0]) + Class26.anInt635) + " - ");
            for(int i = 0; (((Widget.packetsize > i)) && i < 50); i++)
                string += (Cache.outgoingbuffer.buffer[i] + ",");
            CacheIndex.method169(string, (byte) -120, exception);
            Class48.method928(-7225);
        }
        return true;

    }

    public static void parseNpcUpdatePacket(int arg0) {
        Class17.anInt460 = 0;
        Actor.anInt3153 = 0;
        Class40_Sub5_Sub17_Sub1.method759(false);
        Class42.method889(48);
        Npc.parseNpcUpdateMasks();
        if(arg0 > 75) {
            for(int i = 0; i < Class17.anInt460; i++) {
                int i_0_ = CacheIndex.anIntArray225[i];
                if(Node.pulseCycle != (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_].anInt3134)) {
                    CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_].actorDefinition = null;
                    CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_] = null;
                }
            }
            if(Cache.outgoingbuffer.currentPosition != Widget.packetsize)
                throw new RuntimeException("gnp1 pos:" + (Cache.outgoingbuffer.currentPosition) + " psize:" + Widget.packetsize);
            for(int i = 0; GameObjectDefinition.anInt2558 > i; i++) {
                if((CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i]]) == null)
                    throw new RuntimeException("gnp2 pos:" + i + " size:" + (GameObjectDefinition.anInt2558));
            }
        }
    }

    public static void parsePlayerUpdatePacket(byte arg0) {
        Actor.anInt3153 = 0;
        Class17.anInt460 = 0;
        Actor.method786(true);
        Class29.method373((byte) -5);
        Class34.registerNewPlayers((byte) 108);
        Player.parseTrackedPlayerUpdateMasks();
        for(int i = 0; Class17.anInt460 > i; i++) {
            int i_8_ = CacheIndex.anIntArray225[i];
            if(Node.pulseCycle != (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_8_].anInt3134))
                Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_8_] = null;
        }
        if(Widget.packetsize != Cache.outgoingbuffer.currentPosition)
            throw new RuntimeException("gpp1 pos:" + (Cache.outgoingbuffer.currentPosition) + " psize:" + Widget.packetsize);
        int i = 0;
        if(arg0 < 50)
            Class27.aCacheIndex_654 = null;
        for(/**/; Class60.anInt1407 > i; i++) {
            if((Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i]]) == null)
                throw new RuntimeException("gpp2 pos:" + i + " size:" + Class60.anInt1407);
        }
    }
}
