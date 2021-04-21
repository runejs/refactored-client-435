package com.jagex.runescape.net;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.cache.media.gameInterface.InterfaceModelType;
import com.jagex.runescape.cache.media.gameInterface.GameInterfaceType;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.util.TextUtils;

public class IncomingPackets {

    public static int incomingPacketSize = 0;
    public static PacketBuffer incomingPacketBuffer = new PacketBuffer(5000);
    public static int incomingPacket = 0;

    public static boolean parseIncomingPackets() {
        if(MovedStatics.gameSocket == null)
            return false;
        try {
            int availableBytes = MovedStatics.gameSocket.inputStreamAvailable();
            if(availableBytes == 0) {
                // Out of memory
                return false;
            }

            if(incomingPacket == -1) {
                // This will always run first. It fetches the incoming packet ID which should have a size of 1
                MovedStatics.gameSocket.readDataToBuffer(0, 1, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                availableBytes--;
                incomingPacket = incomingPacketBuffer.getPacket();
                incomingPacketSize = PacketType.findPacketSize(incomingPacket);
            }

            if(incomingPacketSize == -1) {
                // Server-defined packet size between 0 and 255
                if(availableBytes > 0) {
                    MovedStatics.gameSocket.readDataToBuffer(0, 1, incomingPacketBuffer.buffer);
                    incomingPacketSize = incomingPacketBuffer.buffer[0] & 0xff;
                    availableBytes--;
                } else
                    return false;
            }

            if(incomingPacketSize == -2) {
                // Server-defined packet size between 0 and 65535
                if(availableBytes <= 1)
                    return false;
                availableBytes -= 2;
                MovedStatics.gameSocket.readDataToBuffer(0, 2, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                incomingPacketSize = incomingPacketBuffer.getUnsignedShortBE();
            }

            if(incomingPacketSize > availableBytes) {
                // Out of memory, would not be able to read this packet
                return false;
            }

            incomingPacketBuffer.currentPosition = 0;
            MovedStatics.gameSocket.readDataToBuffer(0, incomingPacketSize, incomingPacketBuffer.buffer);
            Class49.anInt1151 = MovedStatics.previousIncomingPacket;
            Class35.anInt1728 = 0;
            MovedStatics.previousIncomingPacket = RSString.currentIncomingPacket;
            RSString.currentIncomingPacket = incomingPacket;

            if(incomingPacket == 71) {
                long l = incomingPacketBuffer.getLongBE();
                String class1 = RSString.formatChatString(KeyFocusListener.method956(82, incomingPacketBuffer));

                ChatBox.addChatMessage(Player.longToUsername(l).method85().toString(), class1, 6);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.FRIEND_LOGGED_IN.getId()) {
                long l = incomingPacketBuffer.getLongBE();
                int i_1_ = incomingPacketBuffer.getUnsignedShortBE();
                String string = Player.longToUsername(l).method85().toString();
                for(int i_2_ = 0; i_2_ < Player.friendsCount; i_2_++) {
                    if(l == Class59.friends[i_2_]) {
                        if(i_1_ != Player.friendWorlds[i_2_]) {
                            Player.friendWorlds[i_2_] = i_1_;
                            GameInterface.redrawTabArea = true;
                            if(i_1_ > 0)
                                ChatBox.addChatMessage("", string + English.suffixHasLoggedIn, 5);
                            if(i_1_ == 0)
                                ChatBox.addChatMessage("", string + English.suffixHasLoggedOut, 5);
                        }
                        string = null;
                        break;
                    }
                }
                boolean bool = false;
                if(string != null && Player.friendsCount < 200) {
                    Class59.friends[Player.friendsCount] = l;
                    Player.friendUsernames[Player.friendsCount] = string;
                    Player.friendWorlds[Player.friendsCount] = i_1_;
                    Player.friendsCount++;
                    GameInterface.redrawTabArea = true;
                }
                while(!bool) {
                    bool = true;
                    for(int i_3_ = 0; Player.friendsCount - 1 > i_3_; i_3_++) {
                        if(Player.worldId != Player.friendWorlds[i_3_] && Player.friendWorlds[1 + i_3_] == Player.worldId || Player.friendWorlds[i_3_] == 0 && Player.friendWorlds[i_3_ + 1] != 0) {
                            bool = false;
                            int i_4_ = Player.friendWorlds[i_3_];
                            Player.friendWorlds[i_3_] = Player.friendWorlds[i_3_ + 1];
                            Player.friendWorlds[1 + i_3_] = i_4_;
                            String class1_5_ = Player.friendUsernames[i_3_];
                            Player.friendUsernames[i_3_] = Player.friendUsernames[1 + i_3_];
                            Player.friendUsernames[1 + i_3_] = class1_5_;
                            long l_6_ = Class59.friends[i_3_];
                            Class59.friends[i_3_] = Class59.friends[i_3_ + 1];
                            Class59.friends[1 + i_3_] = l_6_;
                            GameInterface.redrawTabArea = true;
                        }
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 233) { // clear destination X
                incomingPacket = -1;
                MovedStatics.destinationX = 0;
                return true;
            }
            if(incomingPacket == PacketType.CLOSE_CUTSCENE.getId()) { // close cutscene
                Player.cutsceneActive = false;
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
                int varPlayerValue = incomingPacketBuffer.getByte();
                int varPlayerIndex = incomingPacketBuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[varPlayerIndex] = varPlayerValue;
                if(VarPlayerDefinition.varPlayers[varPlayerIndex] != varPlayerValue) {
                    VarPlayerDefinition.varPlayers[varPlayerIndex] = varPlayerValue;
                    Class22.method309(varPlayerIndex);
                    GameInterface.redrawTabArea = true;
                    if(ChatBox.dialogueId != -1)
                        ChatBox.redrawChatbox = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 115) { // set widget hidden state
                boolean bool = incomingPacketBuffer.getUnsignedByte() == 1;
                int i_10_ = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(i_10_);
                gameInterface.isHidden = bool;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_ALL_WIDGET_ITEMS.getId()) {
                GameInterface.redrawTabArea = true;
                final int packed = incomingPacketBuffer.getIntBE();
                final GameInterface gameInterface = GameInterface.getInterface(packed);

                if(gameInterface.isNewInterfaceFormat) {
                    final GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[packed >> 16];
                    for(GameInterface child : gameInterfaces) {
                        if((0xffff & gameInterface.id) == (0xffff & child.parentId) && child.anInt2736 > 0) {
                            child.itemAmount = 0;
                            child.itemId = -1;
                        }
                    }
                } else {
                    for(int index = 0; index < gameInterface.items.length; index++) {
                        gameInterface.items[index] = 0;
                        gameInterface.itemAmounts[index] = 0;
                    }
                }

                final int size = incomingPacketBuffer.getUnsignedShortBE();

                for(int index = 0; index < size; index += 8) {
                    final int bitset = incomingPacketBuffer.getByte();

                    for(int offset = 0; offset < 8; offset++) {
                        final boolean empty = (bitset & 1 << offset) == 0;
                        final int id, amount;

                        if(empty) {
                            id = amount = 0;
                        } else {
                            final int peek = incomingPacketBuffer.getUnsignedByte();
                            amount = peek == 255 ? incomingPacketBuffer.getIntBE() : peek;
                            id = incomingPacketBuffer.getUnsignedShortBE();
                        }

                        final int idx = index + offset;

                        if(gameInterface.isNewInterfaceFormat) {
                            GameInterface gameInterfaces[] = GameInterface.cachedInterfaces[packed >> 16];
                            for(GameInterface child : gameInterfaces) {
                                if((gameInterface.id & 0xffff) == (child.parentId & 0xffff) && 1 + idx == child.anInt2736) {
                                    child.itemAmount = amount;
                                    child.itemId = -1 + id;
                                }
                            }
                        } else if(idx < gameInterface.items.length) {
                            gameInterface.items[idx] = id;
                            gameInterface.itemAmounts[idx] = amount;
                        }
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 250) { // widget model type 1
                int modelId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                gameInterface.modelId = modelId;
                gameInterface.modelType = InterfaceModelType.MODEL;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 255) { // camera shake?
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
            if(incomingPacket == 235) {
                MovedStatics.minimapState = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 48) { // multi combat zone
                MovedStatics.anInt2118 = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 82) {
                String message = incomingPacketBuffer.getString();
                if(message.endsWith(Native.tradeRequest)) {
                    String class1_32_ = message.substring(0, message.indexOf(Native.colon));
                    long l = RSString.nameToLong(class1_32_);
                    boolean bool = false;
                    for(int i_33_ = 0; i_33_ < Class42.anInt1008; i_33_++) {
                        if(l == Player.ignores[i_33_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && !Player.inTutorialIsland)
                        ChatBox.addChatMessage(class1_32_, "wishes to trade with you.", 4);
                } else if(message.endsWith(Native.duelRequest)) {
                    String class1_30_ = message.substring(0, message.indexOf(Native.colon));
                    long l = RSString.nameToLong(class1_30_);
                    boolean bool = false;
                    for(int i_31_ = 0; Class42.anInt1008 > i_31_; i_31_++) {
                        if(l == Player.ignores[i_31_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && !Player.inTutorialIsland)
                        ChatBox.addChatMessage(class1_30_, English.suffixWishesToDuelWithYou, 8);
                } else if(message.endsWith(Native.challengeRequest)) {
                    String class1_27_ = message.substring(0, message.indexOf(Native.colon));
                    long l = RSString.nameToLong(class1_27_);
                    boolean bool = false;
                    for(int i_28_ = 0; i_28_ < Class42.anInt1008; i_28_++) {
                        if(l == Player.ignores[i_28_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && !Player.inTutorialIsland) {
                        String class1_29_ = message.substring(1 + message.indexOf(Native.colon), -9 + message.length());
                        ChatBox.addChatMessage(class1_27_, class1_29_, 8);
                    }
                } else {
                    ChatBox.addChatMessage("", message, 0);
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
            if(incomingPacket == 85) { // console auto-completion
                String command = incomingPacketBuffer.getString();
                String help = incomingPacketBuffer.getString();
                Console.console.addCommand(command, help);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 182) { // set widget scroll position
                int i_34_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(i_35_);
                incomingPacket = -1;
                if(gameInterface != null && gameInterface.type == GameInterfaceType.LAYER) {
                    if(i_34_ < 0)
                        i_34_ = 0;
                    if(-gameInterface.originalHeight + gameInterface.scrollHeight < i_34_)
                        i_34_ = -gameInterface.originalHeight + gameInterface.scrollHeight;
                    gameInterface.scrollPosition = i_34_;
                }
                return true;
            }
            if(incomingPacket == 174) { // clear widget item container?
                int i_36_ = incomingPacketBuffer.getIntME1();
                GameInterface gameInterface = GameInterface.getInterface(i_36_);
                if(gameInterface.isNewInterfaceFormat) {
                    GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[i_36_ >> 16];
                    for(int i_37_ = 0; i_37_ < gameInterfaces.length; i_37_++) {
                        GameInterface gameInterface_38_ = gameInterfaces[i_37_];
                        if((0xffff & gameInterface.id) == (gameInterface_38_.parentId & 0xffff) && gameInterface_38_.anInt2736 > 0) {
                            gameInterface_38_.itemId = -1;
                            gameInterface_38_.itemAmount = 0;
                        }
                    }
                } else {
                    for(int i_39_ = 0; gameInterface.items.length > i_39_; i_39_++) {
                        gameInterface.items[i_39_] = -1;
                        gameInterface.items[i_39_] = 0;
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 130) {
                MovedStatics.anInt854 = incomingPacketBuffer.getUnsignedShortLE();
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
            if(incomingPacket == PacketType.LOGOUT.getId()) {
                Class48.logout(-7225);
                incomingPacket = -1;
                return false;
            }
            if(incomingPacket == PacketType.PLAY_WIDGET_ANIMATION.getId()) {
                int animationId = incomingPacketBuffer.getShortBE();
                int widgetData = incomingPacketBuffer.getIntBE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                if(animationId != gameInterface.animation || animationId == -1) {
                    gameInterface.remainingAnimationTime = 0;
                    gameInterface.animationFrame = 0;
                    gameInterface.animation = animationId;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 56) {
                int i_45_ = incomingPacketBuffer.getShortBE();
                if(i_45_ >= 0)
                    GameInterface.resetInterfaceAnimations(i_45_);
                if(i_45_ != GroundItemTile.walkableWidgetId) {
                    GameInterface.resetInterface(GroundItemTile.walkableWidgetId);
                    GroundItemTile.walkableWidgetId = i_45_;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 117) {
                int i_46_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_47_ = incomingPacketBuffer.getUnsignedShortLE();
                int widgetId = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(widgetId);
                incomingPacket = -1;
                gameInterface.anInt2722 = i_47_ + (i_46_ << 16);
                return true;
            }
            if(incomingPacket == PacketType.SHOW_TAB_AND_SCREEN_WIDGETS.getId()) {
                int i_49_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_50_ = incomingPacketBuffer.getUnsignedShortLE();
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    ChatBox.redrawChatbox = true;
                    GameInterface.chatboxInterfaceId = -1;
                }
                if(GameInterface.fullscreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
                    GameInterface.fullscreenInterfaceId = -1;
                    MovedStatics.updateOverlay(30);
                }
                if(GameInterface.fullscreenSiblingInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = -1;
                }
                if(GameInterface.gameScreenInterfaceId != i_50_) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = i_50_;
                }
                if(GameInterface.tabAreaInterfaceId != i_49_) {
                    GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
                    GameInterface.tabAreaInterfaceId = i_49_;
                }
                MovedStatics.lastContinueTextWidgetId = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.CLEAR_MAP_CHUNK.getId()) {
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.placementX = incomingPacketBuffer.getUnsignedByte();
                for(int i_51_ = MovedStatics.placementX; i_51_ < 8 + MovedStatics.placementX; i_51_++) {
                    for(int i_52_ = OverlayDefinition.placementY; 8 + OverlayDefinition.placementY > i_52_; i_52_++) {
                        if(Wall.groundItems[Player.worldLevel][i_51_][i_52_] != null) {
                            Wall.groundItems[Player.worldLevel][i_51_][i_52_] = null;
                            FramemapDefinition.spawnGroundItem(i_52_, i_51_);
                        }
                    }
                }
                for(Class40_Sub3 class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.method902((byte) -90); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.method909(-4)) {
                    if(class40_sub3.anInt2039 >= MovedStatics.placementX && MovedStatics.placementX + 8 > class40_sub3.anInt2039 && class40_sub3.anInt2038 >= OverlayDefinition.placementY && OverlayDefinition.placementY + 8 > class40_sub3.anInt2038 && Player.worldLevel == class40_sub3.anInt2018)
                        class40_sub3.anInt2031 = 0;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 223) { // set player options
                String class1 = incomingPacketBuffer.getString();
                int i_53_ = incomingPacketBuffer.getUnsignedByte();
                int i_54_ = incomingPacketBuffer.getUnsignedByte();
                if(i_54_ >= 1 && i_54_ <= 5) {
                    if(class1.equalsIgnoreCase("null"))
                        class1 = null;
                    Main.playerActions[i_54_ - 1] = class1;
                    Class13.playerArray[i_54_ - 1] = i_53_ == 0;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SHOW_SCREEN_WIDGET.getId()) {
                int i_55_ = incomingPacketBuffer.getUnsignedShortBE();
                GameInterface.resetInterfaceAnimations(i_55_);
                if(GameInterface.tabAreaInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
                    GameInterface.drawTabIcons = true;
                    GameInterface.tabAreaInterfaceId = -1;
                    GameInterface.redrawTabArea = true;
                }
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    ChatBox.redrawChatbox = true;
                    GameInterface.chatboxInterfaceId = -1;
                }
                if(GameInterface.fullscreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
                    GameInterface.fullscreenInterfaceId = -1;
                    MovedStatics.updateOverlay(30);
                }
                if(GameInterface.fullscreenSiblingInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = -1;
                }
                if(i_55_ != GameInterface.gameScreenInterfaceId) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = i_55_;
                }
                MovedStatics.lastContinueTextWidgetId = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                GameInterface.callOnLoadListeners(GameInterface.gameScreenInterfaceId);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_RUN_ENERGY.getId()) {
                if(Player.currentTabId == 12)
                    GameInterface.redrawTabArea = true;
                ClientScriptRunner.runEnergy = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 253) {
                Player.cutsceneActive = true;
                Class22.anInt545 = incomingPacketBuffer.getUnsignedByte();
                SceneCluster.anInt767 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt194 = incomingPacketBuffer.getUnsignedShortBE();
                MovedStatics.anInt188 = incomingPacketBuffer.getUnsignedByte();
                Class59.anInt1386 = incomingPacketBuffer.getUnsignedByte();
                if(Class59.anInt1386 >= 100) {
                    Class40_Sub5_Sub6.cameraY = 64 + SceneCluster.anInt767 * 128;
                    Class12.cameraX = Class22.anInt545 * 128 + 64;
                    SceneCluster.cameraZ = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, Class40_Sub5_Sub6.cameraY) - MovedStatics.anInt194;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SHOW_PERMANENT_CHATBOX_WIDGET.getId()) {
                int chatboxInterfaceId = incomingPacketBuffer.getShortBE();
                if(ChatBox.dialogueId != chatboxInterfaceId) {
                    GameInterface.resetInterface(ChatBox.dialogueId);
                    ChatBox.dialogueId = chatboxInterfaceId;
                }
                incomingPacket = -1;
                ChatBox.redrawChatbox = true;
                MovedStatics.lastContinueTextWidgetId = -1;
                return true;
            }
            if(incomingPacket == PacketType.SHOW_FULLSCREEN_INTERFACE.getId()) {
                int siblingInterfaceId = incomingPacketBuffer.getUnsignedShortBE();
                int interfaceId = incomingPacketBuffer.getUnsignedShortBE();
                GameInterface.resetInterfaceAnimations(interfaceId);

                if(siblingInterfaceId != -1) {
                    GameInterface.resetInterfaceAnimations(siblingInterfaceId);
                }
                if(GameInterface.gameScreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = -1;
                }
                if(GameInterface.tabAreaInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
                    GameInterface.tabAreaInterfaceId = -1;
                }
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = -1;
                }
                if(interfaceId != GameInterface.fullscreenInterfaceId) {
                    GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
                    GameInterface.fullscreenInterfaceId = interfaceId;
                    MovedStatics.updateOverlay(35);
                }
                if(interfaceId != GameInterface.fullscreenSiblingInterfaceId) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = siblingInterfaceId;
                }
                MovedStatics.lastContinueTextWidgetId = -1;
                ChatBox.inputType = 0;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.CLOSE_ALL_WIDGETS.getId()) {
                if(GameInterface.tabAreaInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
                    GameInterface.redrawTabArea = true;
                    GameInterface.drawTabIcons = true;
                    GameInterface.tabAreaInterfaceId = -1;
                }
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    ChatBox.redrawChatbox = true;
                    GameInterface.chatboxInterfaceId = -1;
                }
                if(GameInterface.fullscreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
                    GameInterface.fullscreenInterfaceId = -1;
                    MovedStatics.updateOverlay(30);
                }
                if(GameInterface.fullscreenSiblingInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = -1;
                }
                if(GameInterface.gameScreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = -1;
                }
                incomingPacket = -1;
                MovedStatics.lastContinueTextWidgetId = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                return true;
            }
            if(incomingPacket == PacketType.SHOW_CHATBOX_WIDGET.getId()) {
                int widgetId = incomingPacketBuffer.getUnsignedShortBE();
                GameInterface.resetInterfaceAnimations(widgetId);
                if(GameInterface.tabAreaInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
                    GameInterface.drawTabIcons = true;
                    GameInterface.tabAreaInterfaceId = -1;
                    GameInterface.redrawTabArea = true;
                }
                if(GameInterface.fullscreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
                    GameInterface.fullscreenInterfaceId = -1;
                    MovedStatics.updateOverlay(30);
                }
                if(GameInterface.fullscreenSiblingInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = -1;
                }
                if(GameInterface.gameScreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = -1;
                }
                if(GameInterface.chatboxInterfaceId != widgetId) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = widgetId;
                }

                ChatBox.redrawChatbox = true;
                incomingPacket = -1;
                MovedStatics.lastContinueTextWidgetId = -1;
                return true;
            }
            if(incomingPacket == PacketType.PLAY_SONG.getId()) {
                int songId = incomingPacketBuffer.getUnsignedShortLE();
                if(songId == 65535)
                    songId = -1;
                Class51.playSong(songId);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.PLAY_QUICK_SONG.getId()) {
                int songTimeout = incomingPacketBuffer.getMediumBE();
                int songId = incomingPacketBuffer.getUnsignedShortBE();
                if(songId == 65535)
                    songId = -1;
                Class57.method975(songTimeout, songId);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_REFERENCE_POSITION.getId()) {
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.placementX = incomingPacketBuffer.getUnsignedByte();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 88) {
                Class51.anInt1205 = incomingPacketBuffer.getUnsignedByte();
                if(Player.currentTabId == Class51.anInt1205) {
                    if(Class51.anInt1205 != 3)
                        Player.currentTabId = 3;
                    else
                        Player.currentTabId = 1;
                    GameInterface.redrawTabArea = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 63) { // mass object/ground item update packet
                MovedStatics.placementX = incomingPacketBuffer.getUnsignedByte();
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                while(incomingPacketBuffer.currentPosition < incomingPacketSize) {
                    incomingPacket = incomingPacketBuffer.getUnsignedByte();
                    WallDecoration.method949();
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 196) { // set chat mode configs
                ChatBox.publicChatMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.privateChatMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.tradeMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.redrawChatbox = true;
                MovedStatics.redrawChatbox = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_SYSTEM_UPDATE_TIME.getId()) {
                Class40_Sub5_Sub15.systemUpdateTime = incomingPacketBuffer.getUnsignedShortLE() * 30;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_PLAYERS.getId()) {
                parsePlayerUpdatePacket();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 2) {
                int varPlayerValue = incomingPacketBuffer.getIntBE();
                int varPlayerIndex = incomingPacketBuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[varPlayerIndex] = varPlayerValue;
                if(varPlayerValue != VarPlayerDefinition.varPlayers[varPlayerIndex]) {
                    VarPlayerDefinition.varPlayers[varPlayerIndex] = varPlayerValue;
                    Class22.method309(varPlayerIndex); // TODO find out what this does
                    if(ChatBox.dialogueId != -1)
                        ChatBox.redrawChatbox = true;
                    GameInterface.redrawTabArea = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_NPCS.getId()) {
                parseNpcUpdatePacket();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.PLAY_SOUND.getId()) {
                int soundId = incomingPacketBuffer.getUnsignedShortBE();
                int volume = incomingPacketBuffer.getUnsignedByte();
                int delay = incomingPacketBuffer.getUnsignedShortBE();
                WallDecoration.method950(soundId, volume, delay);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 237) { // show tab overlay widget
                int i_68_ = incomingPacketBuffer.getUnsignedShortBE();
                GameInterface.resetInterfaceAnimations(i_68_);
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = -1;
                    ChatBox.redrawChatbox = true;
                }
                if(GameInterface.fullscreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
                    GameInterface.fullscreenInterfaceId = -1;
                    MovedStatics.updateOverlay(30);
                }
                if(GameInterface.fullscreenSiblingInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = -1;
                }
                if(GameInterface.gameScreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = -1;
                }
                if(GameInterface.tabAreaInterfaceId != i_68_) {
                    GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
                    GameInterface.tabAreaInterfaceId = i_68_;
                }
                GameInterface.drawTabIcons = true;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                MovedStatics.lastContinueTextWidgetId = -1;
                incomingPacket = -1;
                GameInterface.redrawTabArea = true;
                return true;
            }
            if(incomingPacket == 234) {
                Player.cutsceneActive = true;
                MovedStatics.anInt564 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt2576 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt892 = incomingPacketBuffer.getUnsignedShortBE();
                Class60.anInt1413 = incomingPacketBuffer.getUnsignedByte();
                Class22_Sub1.anInt1856 = incomingPacketBuffer.getUnsignedByte();
                if(Class22_Sub1.anInt1856 >= 100) {
                    int i_69_ = 128 * MovedStatics.anInt564 + 64;
                    int i_70_ = 128 * MovedStatics.anInt2576 + 64;
                    int i_71_ = Class37.getFloorDrawHeight(Player.worldLevel, i_69_, i_70_) - MovedStatics.anInt892;
                    int i_72_ = i_69_ + -Class12.cameraX;
                    int i_73_ = i_70_ + -Class40_Sub5_Sub6.cameraY;
                    int i_74_ = -SceneCluster.cameraZ + i_71_;
                    int i_75_ = (int) Math.sqrt((double) (i_73_ * i_73_ + i_72_ * i_72_));
                    Class26.anInt627 = (int) (325.949 * Math.atan2((double) i_74_, (double) i_75_)) & 0x7ff;
                    ProducingGraphicsBuffer_Sub1.anInt2210 = (int) (Math.atan2((double) i_72_, (double) i_73_) * -325.949) & 0x7ff;
                    if(Class26.anInt627 < 128)
                        Class26.anInt627 = 128;
                    if(Class26.anInt627 > 383)
                        Class26.anInt627 = 383;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 142) {
                int rotationZ = incomingPacketBuffer.getUnsignedShortBE();
                int modelZoom = incomingPacketBuffer.getUnsignedShortLE();
                int rotationX = incomingPacketBuffer.getUnsignedShortBE();
                int interfaceData = incomingPacketBuffer.getIntLE();
                GameInterface childInterface = GameInterface.getInterface(interfaceData);
                incomingPacket = -1;
                childInterface.rotationZ = rotationZ;
                childInterface.modelZoom = modelZoom;
                childInterface.rotationX = rotationX;
                return true;
            }
            if(incomingPacket == PacketType.SET_CURRENT_TAB.getId()) {
                Player.currentTabId = incomingPacketBuffer.getUnsignedByte();
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_CARRY_WEIGHT.getId()) {
                if(Player.currentTabId == 12)
                    GameInterface.redrawTabArea = true;
                GenericTile.carryWeight = incomingPacketBuffer.getShortBE();
                incomingPacket = -1;
                return true;
            }
            // object/ground item update packets?
            if(incomingPacket == 9 || incomingPacket == 99 || incomingPacket == 229 || incomingPacket == 19 || incomingPacket == 202 || incomingPacket == 1 || incomingPacket == 74 || incomingPacket == 175 || incomingPacket == 49 || incomingPacket == 143 || incomingPacket == 241) {
                WallDecoration.method949();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 14) { // reset client configs?
                for(int varPlayerIndex = 0; VarPlayerDefinition.varPlayerDefinitionsSize > varPlayerIndex; varPlayerIndex++) {
                    VarPlayerDefinition varPlayerDefinition = VarPlayerDefinition.getDefinition(varPlayerIndex);
                    if(varPlayerDefinition.type == 0) {
                        Buffer.anIntArray1984[varPlayerIndex] = 0;
                        VarPlayerDefinition.varPlayers[varPlayerIndex] = 0;
                    }
                }
                if(ChatBox.dialogueId != -1)
                    ChatBox.redrawChatbox = true;
                GameInterface.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_WIDGET_NPC_HEAD.getId()) {
                int npcId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                gameInterface.modelType = InterfaceModelType.NPC_CHATHEAD;
                incomingPacket = -1;
                gameInterface.modelId = npcId;
                return true;
            }
            if(incomingPacket == 132) { // open chatbox input widget
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = -1;
                }
                incomingPacket = -1;
                ChatBox.inputMessage = "";
                ChatBox.inputType = 1;
                ChatBox.redrawChatbox = true;
                ChatBox.messagePromptRaised = false;
                return true;
            }
            if(incomingPacket == 186) {
                Player.headIconDrawType = incomingPacketBuffer.getUnsignedByte();
                if(Player.headIconDrawType == 1)
                    HuffmanEncoding.anInt1545 = incomingPacketBuffer.getUnsignedShortBE();
                if(Player.headIconDrawType >= 2 && Player.headIconDrawType <= 6) {
                    if(Player.headIconDrawType == 2) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 64;
                    }
                    if(Player.headIconDrawType == 3) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 0;
                    }
                    if(Player.headIconDrawType == 4) {
                        Class35.anInt1730 = 64;
                        Landscape.anInt1170 = 128;
                    }
                    if(Player.headIconDrawType == 5) {
                        Landscape.anInt1170 = 64;
                        Class35.anInt1730 = 0;
                    }
                    if(Player.headIconDrawType == 6) {
                        Landscape.anInt1170 = 64;
                        Class35.anInt1730 = 128;
                    }
                    Player.headIconDrawType = 2;
                    ProducingGraphicsBuffer.anInt1637 = incomingPacketBuffer.getUnsignedShortBE();
                    MovedStatics.anInt175 = incomingPacketBuffer.getUnsignedShortBE();
                    ActorDefinition.anInt2404 = incomingPacketBuffer.getUnsignedByte();
                }
                if(Player.headIconDrawType == 10)
                    ProducingGraphicsBuffer.anInt1623 = incomingPacketBuffer.getUnsignedShortBE();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_WIDGET_PLAYER_HEAD.getId()) {
                int interfaceData = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                gameInterface.modelType = InterfaceModelType.LOCAL_PLAYER_CHATHEAD;
                gameInterface.modelId = Player.localPlayer.playerAppearance.getHeadModelId();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_WIDGET_TEXT.getId()) {
                int interfaceData = incomingPacketBuffer.getIntLE();
                String interfaceText = incomingPacketBuffer.getString();
                GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                gameInterface.disabledText = interfaceText;
                if(Player.tabWidgetIds[Player.currentTabId] == interfaceData >> 16) {
                    GameInterface.redrawTabArea = true;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_FRIEND_LIST_STATUS.getId()) {
                Player.friendListStatus = incomingPacketBuffer.getUnsignedByte();
                GameInterface.redrawTabArea = true;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_WIDGET_ITEM_MODEL.getId()) {
                int zoom = incomingPacketBuffer.getUnsignedShortBE();
                int itemId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                if(itemId == 65535) {
                    itemId = -1;
                }

                GameInterface gameInterface = GameInterface.getInterface(widgetData);

                if(gameInterface.isNewInterfaceFormat) {
                    gameInterface.itemAmount = 1;
                    gameInterface.itemId = itemId;
                } else {
                    if(itemId == -1) {
                        incomingPacket = -1;
                        gameInterface.modelType = InterfaceModelType.NULL;
                        return true;
                    }
                    ItemDefinition itemDefinition = ItemDefinition.forId(itemId, 10);
                    gameInterface.rotationX = itemDefinition.xan2d;
                    gameInterface.modelId = itemId;
                    gameInterface.modelType = InterfaceModelType.ITEM;
                    gameInterface.modelZoom = 100 * itemDefinition.zoom2d / zoom;
                    gameInterface.rotationZ = itemDefinition.yan2d;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_FRIEND_LOGIN_MESSAGE.getId()) {
                long fromPlayerIndex = incomingPacketBuffer.getLongBE();
                long chatIdModifier = incomingPacketBuffer.getUnsignedShortBE();
                long privateMessageCounter = incomingPacketBuffer.getMediumBE();
                int fromPlayerRights = incomingPacketBuffer.getUnsignedByte();
                boolean hideMessage = false;
                long chatId = (chatIdModifier << 32) + privateMessageCounter;
                for(int msgIndex = 0; msgIndex < 100; msgIndex++) {
                    if(chatId == Player.privateMessageIds[msgIndex]) {
                        hideMessage = true;
                        break;
                    }
                }
                if(fromPlayerRights <= 1) {
                    for(int ignoreIndex = 0; ignoreIndex < Class42.anInt1008; ignoreIndex++) {
                        if(fromPlayerIndex == Player.ignores[ignoreIndex]) {
                            hideMessage = true;
                            break;
                        }
                    }
                }
                if(!hideMessage && !Player.inTutorialIsland) {
                    Player.privateMessageIds[Player.privateMessageIndex] = chatId;
                    Player.privateMessageIndex = (1 + Player.privateMessageIndex) % 100;
                    String loginNotification = RSString.formatChatString(KeyFocusListener.method956(67, incomingPacketBuffer));
                    if(fromPlayerRights == 2 || fromPlayerRights == 3)
                        ChatBox.addChatMessage(Native.goldCrown + TextUtils.formatName(TextUtils.longToName(fromPlayerIndex)), loginNotification, 7);
                    else if(fromPlayerRights == 1)
                        ChatBox.addChatMessage(Native.whiteCrown + TextUtils.formatName(TextUtils.longToName(fromPlayerIndex)), loginNotification, 7);
                    else
                        ChatBox.addChatMessage(TextUtils.formatName(TextUtils.longToName(fromPlayerIndex)), loginNotification, 3);
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.RESET_ACTOR_ANIMATIONS.getId()) {
                for(int playerIdx = 0; playerIdx < Player.trackedPlayers.length; playerIdx++) {
                    if(Player.trackedPlayers[playerIdx] != null)
                        Player.trackedPlayers[playerIdx].playingAnimation = -1;
                }
                for(int npcIdx = 0; Player.npcs.length > npcIdx; npcIdx++) {
                    if(Player.npcs[npcIdx] != null)
                        Player.npcs[npcIdx].playingAnimation = -1;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_TAB_WIDGET.getId()) {
                int interfaceId = incomingPacketBuffer.getUnsignedShortBE();
                int tabIndex = incomingPacketBuffer.getUnsignedByte();
                if(interfaceId == 65535)
                    interfaceId = -1;
                if(interfaceId != Player.tabWidgetIds[tabIndex]) {
                    GameInterface.resetInterface(Player.tabWidgetIds[tabIndex]);
                    Player.tabWidgetIds[tabIndex] = interfaceId;
                }
                GameInterface.drawTabIcons = true;
                incomingPacket = -1;
                GameInterface.redrawTabArea = true;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_SKILL.getId()) {
                GameInterface.redrawTabArea = true;
                int skillLevel = incomingPacketBuffer.getUnsignedByte();
                int skillId = incomingPacketBuffer.getUnsignedByte();
                int skillExperience = incomingPacketBuffer.getIntLE();
                Player.playerExperience[skillId] = skillExperience;
                Player.playerLevels[skillId] = skillLevel;
                Player.nextLevels[skillId] = 1;
                for(int levelIndex = 0; levelIndex < 98; levelIndex++) {
                    if(Player.experienceForLevels[levelIndex] <= skillExperience)
                        Player.nextLevels[skillId] = levelIndex + 2;
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.MOVE_WIDGET_CHILD.getId()) {
                int interfaceData = incomingPacketBuffer.getIntBE();
                int x = incomingPacketBuffer.getShortLE();
                int y = incomingPacketBuffer.getShortLE();
                GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                gameInterface.currentX = gameInterface.originalX + y;
                gameInterface.currentY = gameInterface.originalY + x;
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 72) { // reset varbits?
                for(int varPlayerIndex = 0; varPlayerIndex < VarPlayerDefinition.varPlayers.length; varPlayerIndex++) {
                    if(Buffer.anIntArray1984[varPlayerIndex] != VarPlayerDefinition.varPlayers[varPlayerIndex]) {
                        VarPlayerDefinition.varPlayers[varPlayerIndex] = Buffer.anIntArray1984[varPlayerIndex];
                        Class22.method309(varPlayerIndex);
                        GameInterface.redrawTabArea = true;
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 240) {
                ClientScriptRunner.parseClientScriptPacket(Main.signlink, incomingPacketBuffer);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 58) {
                int i_106_ = incomingPacketBuffer.getIntME2();
                Class12.aSignlinkNode_394 = Main.signlink.method393(i_106_); // this just ends up throwing an exception? wot
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_SPECIFIC_WIDGET_ITEMS.getId()) {
                GameInterface.redrawTabArea = true;
                int widgetData = incomingPacketBuffer.getIntBE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                while(incomingPacketSize > incomingPacketBuffer.currentPosition) {
                    int itemSlot = incomingPacketBuffer.getSmart();
                    int i_109_ = incomingPacketBuffer.getUnsignedShortBE();
                    int i_110_ = 0;
                    if(i_109_ != 0) {
                        i_110_ = incomingPacketBuffer.getUnsignedByte();
                        if(i_110_ == 255)
                            i_110_ = incomingPacketBuffer.getIntBE();
                    }
                    if(gameInterface.isNewInterfaceFormat) {
                        GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[widgetData >> 16];
                        for(int i_111_ = 0; i_111_ < gameInterfaces.length; i_111_++) {
                            GameInterface gameInterface_112_ = gameInterfaces[i_111_];
                            if((gameInterface.id & 0xffff) == (gameInterface_112_.parentId & 0xffff) && 1 + itemSlot == gameInterface_112_.anInt2736) {
                                gameInterface_112_.itemAmount = i_110_;
                                gameInterface_112_.itemId = i_109_ + -1;
                            }
                        }
                    } else if(itemSlot >= 0 && gameInterface.items.length > itemSlot) {
                        gameInterface.items[itemSlot] = i_109_;
                        gameInterface.itemAmounts[itemSlot] = i_110_;
                    }
                }
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.SET_MAP_CHUNK.getId()) {
                FloorDecoration.method343(false, 5688);
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == PacketType.UPDATE_WIDGET_TEXT_COLOR.getId()) {
                int i_113_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_114_ = incomingPacketBuffer.getIntLE();
                int i_115_ = i_113_ >> 10 & 0x1f;
                int i_116_ = 0x1f & i_113_ >> 5;
                GameInterface gameInterface = GameInterface.getInterface(i_114_);
                incomingPacket = -1;
                int i_117_ = i_113_ & 0x1f;
                gameInterface.textColor = (i_116_ << 11) + (i_115_ << 19) + (i_117_ << 3);
                return true;
            }
            if(incomingPacket == 211) { // update ignore list
                Class42.anInt1008 = incomingPacketSize / 8;
                for(int i_118_ = 0; Class42.anInt1008 > i_118_; i_118_++)
                    Player.ignores[i_118_] = incomingPacketBuffer.getLongBE();
                incomingPacket = -1;
                return true;
            }
            if(incomingPacket == 124) { // close chatbox widget
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = -1;
                }
                ChatBox.redrawChatbox = true;
                ChatBox.inputMessage = "";
                ChatBox.inputType = 2;
                incomingPacket = -1;
                ChatBox.messagePromptRaised = false;
                return true;
            }
            MovedStatics.printException("T1 - " + incomingPacket + "," + MovedStatics.previousIncomingPacket + "," + Class49.anInt1151 + " - " + incomingPacketSize, null);
            Class48.logout(-7225);
        } catch(java.io.IOException ioexception) {
            Class59.dropClient();
        } catch(Exception exception) {
            String string = "T2 - " + incomingPacket + "," + MovedStatics.previousIncomingPacket + "," + Class49.anInt1151 + " - " + incomingPacketSize + "," + (SpotAnimDefinition.baseX + Player.localPlayer.pathY[0]) + "," + (Player.localPlayer.pathX[0] + Class26.baseY) + " - ";
            for(int i = 0; incomingPacketSize > i && i < 50; i++)
                string += incomingPacketBuffer.buffer[i] + ",";
            MovedStatics.printException(string, exception);
            Class48.logout(-7225);
            exception.printStackTrace();
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
            if(MovedStatics.pulseCycle != Player.npcs[trackedNpcIndex].anInt3134) {
                Player.npcs[trackedNpcIndex].actorDefinition = null;
                Player.npcs[trackedNpcIndex] = null;
            }
        }
        if(incomingPacketBuffer.currentPosition != incomingPacketSize)
            throw new RuntimeException("gnp1 pos:" + incomingPacketBuffer.currentPosition + " psize:" + incomingPacketSize);
        for(int i = 0; Player.npcCount > i; i++) {
            if(Player.npcs[Player.npcIds[i]] == null)
                throw new RuntimeException("gnp2 pos:" + i + " size:" + Player.npcCount);
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
            if(MovedStatics.pulseCycle != Player.trackedPlayers[trackedPlayerIndex].anInt3134)
                Player.trackedPlayers[trackedPlayerIndex] = null;
        }
        if(incomingPacketSize != incomingPacketBuffer.currentPosition)
            throw new RuntimeException("gpp1 pos:" + incomingPacketBuffer.currentPosition + " psize:" + incomingPacketSize);
        int i = 0;
        for(/**/; Player.localPlayerCount > i; i++) {
            if(Player.trackedPlayers[Player.trackedPlayerIndices[i]] == null)
                throw new RuntimeException("gpp2 pos:" + i + " size:" + Player.localPlayerCount);
        }
    }
}
