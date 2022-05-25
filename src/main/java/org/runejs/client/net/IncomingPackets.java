package org.runejs.client.net;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.console.Console;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.scene.tile.WallDecoration;
import org.runejs.client.sound.StaticAudio;
import org.runejs.client.util.TextUtils;
import org.runejs.client.*;
import org.runejs.client.cache.def.*;

public class IncomingPackets {
    public static int incomingPacketSize = 0;
    public static PacketBuffer incomingPacketBuffer = new PacketBuffer(5000);
    public static int opcode = 0;
    public static int lastOpcode = 0;
    public static int secondLastOpcode = 0;
    public static int thirdLastOpcode = 0;
    public static int cyclesSinceLastPacket = 0;

    public static boolean parseIncomingPackets() {
        if(MovedStatics.gameServerSocket == null)
            return false;
        try {
            int availableBytes = MovedStatics.gameServerSocket.inputStreamAvailable();
            if(availableBytes == 0) {
                // Out of memory
                return false;
            }

            if(opcode == -1) {
                // This will always run first. It fetches the incoming packet ID which should have a size of 1
                MovedStatics.gameServerSocket.readDataToBuffer(0, 1, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                availableBytes--;
                opcode = incomingPacketBuffer.getPacket();
                incomingPacketSize = PacketType.findPacketSize(opcode);
            }

            if(incomingPacketSize == -1) {
                // Server-defined packet size between 0 and 255
                if(availableBytes > 0) {
                    MovedStatics.gameServerSocket.readDataToBuffer(0, 1, incomingPacketBuffer.buffer);
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
                MovedStatics.gameServerSocket.readDataToBuffer(0, 2, incomingPacketBuffer.buffer);
                incomingPacketBuffer.currentPosition = 0;
                incomingPacketSize = incomingPacketBuffer.getUnsignedShortBE();
            }

            if(incomingPacketSize > availableBytes) {
                // Out of memory, would not be able to read this packet
                return false;
            }

            incomingPacketBuffer.currentPosition = 0;
            MovedStatics.gameServerSocket.readDataToBuffer(0, incomingPacketSize, incomingPacketBuffer.buffer);
            cyclesSinceLastPacket = 0;
            thirdLastOpcode = secondLastOpcode;
            secondLastOpcode = lastOpcode;
            lastOpcode = opcode;

            if(opcode == 71) {
                long username = incomingPacketBuffer.getLongBE();
                String message = RSString.formatChatString(KeyFocusListener.method956(82, incomingPacketBuffer));

                ChatBox.addChatMessage(Player.longToUsername(username).method85().toString(), message, 6);
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.FRIEND_LOGGED_IN.getOpcode()) {
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
                opcode = -1;
                return true;
            }
            if(opcode == 233) { // clear destination X
                opcode = -1;
                MovedStatics.destinationX = 0;
                return true;
            }
            if(opcode == PacketType.CLOSE_CUTSCENE.getOpcode()) { // close cutscene
                Player.cutsceneActive = false;
                for(int i_7_ = 0; i_7_ < 5; i_7_++)
                    Projectile.aBooleanArray2975[i_7_] = false;
                opcode = -1;
                return true;
            }
            if(opcode == 23) {
                FloorDecoration.constructMapRegion(true, 5688);
                opcode = -1;
                return true;
            }
            if(opcode == 222) {
                int varPlayerValue = incomingPacketBuffer.getByte();
                int varPlayerIndex = incomingPacketBuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[varPlayerIndex] = varPlayerValue;
                if(VarPlayerDefinition.varPlayers[varPlayerIndex] != varPlayerValue) {
                    VarPlayerDefinition.varPlayers[varPlayerIndex] = varPlayerValue;
                    MovedStatics.method309(varPlayerIndex);
                    GameInterface.redrawTabArea = true;
                    if(ChatBox.dialogueId != -1)
                        ChatBox.redrawChatbox = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 115) { // set widget hidden state
                boolean bool = incomingPacketBuffer.getUnsignedByte() == 1;
                int i_10_ = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(i_10_);
                gameInterface.isHidden = bool;
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_ALL_WIDGET_ITEMS.getOpcode()) {
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
                opcode = -1;
                return true;
            }
            if(opcode == 250) { // widget model type 1
                int modelId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                gameInterface.modelId = modelId;
                gameInterface.modelType = InterfaceModelType.MODEL;
                opcode = -1;
                return true;
            }
            if(opcode == 255) { // camera shake?
                int i_23_ = incomingPacketBuffer.getUnsignedByte();
                int i_24_ = incomingPacketBuffer.getUnsignedByte();
                int i_25_ = incomingPacketBuffer.getUnsignedByte();
                int i_26_ = incomingPacketBuffer.getUnsignedByte();
                Projectile.aBooleanArray2975[i_23_] = true;
                MovedStatics.anIntArray297[i_23_] = i_24_;
                GameShell.anIntArray2[i_23_] = i_25_;
                GroundItemTile.anIntArray1358[i_23_] = i_26_;
                MovedStatics.anIntArray1846[i_23_] = 0;
                opcode = -1;
                return true;
            }
            if(opcode == 235) {
                MovedStatics.minimapState = incomingPacketBuffer.getUnsignedByte();
                opcode = -1;
                return true;
            }
            if(opcode == 48) { // multi combat zone
                MovedStatics.anInt2118 = incomingPacketBuffer.getUnsignedByte();
                opcode = -1;
                return true;
            }
            if(opcode == 82) { // duel/trade/challenge request, or regular chat message
                String message = incomingPacketBuffer.getString();
                if(message.endsWith(Native.tradeRequest)) {
                    String username = message.substring(0, message.indexOf(Native.colon));
                    long l = RSString.nameToLong(username);
                    boolean bool = false;
                    for(int i_33_ = 0; i_33_ < MovedStatics.anInt1008; i_33_++) {
                        if(l == Player.ignores[i_33_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && !Player.inTutorialIsland)
                        ChatBox.addChatMessage(username, "wishes to trade with you.", 4);
                } else if(message.endsWith(Native.duelRequest)) {
                    String username = message.substring(0, message.indexOf(Native.colon));
                    long l = RSString.nameToLong(username);
                    boolean bool = false;
                    for(int i_31_ = 0; MovedStatics.anInt1008 > i_31_; i_31_++) {
                        if(l == Player.ignores[i_31_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && !Player.inTutorialIsland)
                        ChatBox.addChatMessage(username, English.suffixWishesToDuelWithYou, 8);
                } else if(message.endsWith(Native.challengeRequest)) {
                    String username = message.substring(0, message.indexOf(Native.colon));
                    long l = RSString.nameToLong(username);
                    boolean bool = false;
                    for(int i_28_ = 0; i_28_ < MovedStatics.anInt1008; i_28_++) {
                        if(l == Player.ignores[i_28_]) {
                            bool = true;
                            break;
                        }
                    }
                    if(!bool && !Player.inTutorialIsland) {
                        String challengeMessage = message.substring(1 + message.indexOf(Native.colon), -9 + message.length());
                        ChatBox.addChatMessage(username, challengeMessage, 8);
                    }
                } else {
                    ChatBox.addChatMessage("", message, 0);
                }
                opcode = -1;
                return true;
            }
            if(opcode == 83) { // console command
                RSString message = incomingPacketBuffer.getRSString();
                Console.console.log("<col=FFFF00>" + message.toString() + "</col>");
                opcode = -1;
                return true;
            }
            if(opcode == 85) { // console auto-completion
                String command = incomingPacketBuffer.getString();
                String help = incomingPacketBuffer.getString();
                Console.console.addCommand(command, help);
                opcode = -1;
                return true;
            }
            if(opcode == 182) { // set widget scroll position
                int i_34_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(i_35_);
                opcode = -1;
                if(gameInterface != null && gameInterface.type == GameInterfaceType.LAYER) {
                    if(i_34_ < 0)
                        i_34_ = 0;
                    if(-gameInterface.originalHeight + gameInterface.scrollHeight < i_34_)
                        i_34_ = -gameInterface.originalHeight + gameInterface.scrollHeight;
                    gameInterface.scrollPosition = i_34_;
                }
                return true;
            }
            if(opcode == 174) { // clear widget item container?
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
                opcode = -1;
                return true;
            }
            if(opcode == 130) {
                MovedStatics.anInt854 = incomingPacketBuffer.getUnsignedShortLE();
                opcode = -1;
                return true;
            }
            if(opcode == 129) {
                int i_40_ = incomingPacketBuffer.getUnsignedByte();
                int i_41_ = incomingPacketBuffer.getUnsignedByte();
                int i_42_ = incomingPacketBuffer.getUnsignedByte();
                Player.worldLevel = i_40_ >> 1;
                Player.localPlayer.method787(i_42_, -7717, (i_40_ & 0x1) == 1, i_41_);
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.LOGOUT.getOpcode()) {
                MovedStatics.logout();
                opcode = -1;
                return false;
            }
            if(opcode == PacketType.PLAY_WIDGET_ANIMATION.getOpcode()) {
                int animationId = incomingPacketBuffer.getShortBE();
                int widgetData = incomingPacketBuffer.getIntBE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                if(animationId != gameInterface.animation || animationId == -1) {
                    gameInterface.remainingAnimationTime = 0;
                    gameInterface.animationFrame = 0;
                    gameInterface.animation = animationId;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 56) {
                int i_45_ = incomingPacketBuffer.getShortBE();
                if(i_45_ >= 0)
                    GameInterface.resetInterfaceAnimations(i_45_);
                if(i_45_ != GroundItemTile.walkableWidgetId) {
                    GameInterface.resetInterface(GroundItemTile.walkableWidgetId);
                    GroundItemTile.walkableWidgetId = i_45_;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 117) {
                int i_46_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_47_ = incomingPacketBuffer.getUnsignedShortLE();
                int widgetId = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(widgetId);
                opcode = -1;
                gameInterface.anInt2722 = i_47_ + (i_46_ << 16);
                return true;
            }
            if(opcode == PacketType.SHOW_TAB_AND_SCREEN_WIDGETS.getOpcode()) {
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
                    MovedStatics.processGameStatus(30);
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.CLEAR_MAP_CHUNK.getOpcode()) {
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
                opcode = -1;
                return true;
            }
            if(opcode == 223) { // set player options
                String class1 = incomingPacketBuffer.getString();
                int i_53_ = incomingPacketBuffer.getUnsignedByte();
                int i_54_ = incomingPacketBuffer.getUnsignedByte();
                if(i_54_ >= 1 && i_54_ <= 5) {
                    if(class1.equalsIgnoreCase("null"))
                        class1 = null;
                    Main.playerActions[i_54_ - 1] = class1;
                    Class13.playerArray[i_54_ - 1] = i_53_ == 0;
                }
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SHOW_SCREEN_WIDGET.getOpcode()) {
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
                    MovedStatics.processGameStatus(30);
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_RUN_ENERGY.getOpcode()) {
                if(Player.currentTabId == 12)
                    GameInterface.redrawTabArea = true;
                ClientScriptRunner.runEnergy = incomingPacketBuffer.getUnsignedByte();
                opcode = -1;
                return true;
            }
            if(opcode == 253) {
                Player.cutsceneActive = true;
                MovedStatics.anInt545 = incomingPacketBuffer.getUnsignedByte();
                SceneCluster.anInt767 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt194 = incomingPacketBuffer.getUnsignedShortBE();
                MovedStatics.anInt188 = incomingPacketBuffer.getUnsignedByte();
                Class59.anInt1386 = incomingPacketBuffer.getUnsignedByte();
                if(Class59.anInt1386 >= 100) {
                    MovedStatics.cameraY = 64 + SceneCluster.anInt767 * 128;
                    Class12.cameraX = MovedStatics.anInt545 * 128 + 64;
                    SceneCluster.cameraZ = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, MovedStatics.cameraY) - MovedStatics.anInt194;
                }
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SHOW_PERMANENT_CHATBOX_WIDGET.getOpcode()) {
                int chatboxInterfaceId = incomingPacketBuffer.getShortBE();
                if(ChatBox.dialogueId != chatboxInterfaceId) {
                    GameInterface.resetInterface(ChatBox.dialogueId);
                    ChatBox.dialogueId = chatboxInterfaceId;
                }
                opcode = -1;
                ChatBox.redrawChatbox = true;
                MovedStatics.lastContinueTextWidgetId = -1;
                return true;
            }
            if(opcode == PacketType.SHOW_FULLSCREEN_INTERFACE.getOpcode()) {
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
                    MovedStatics.processGameStatus(35);
                }
                if(interfaceId != GameInterface.fullscreenSiblingInterfaceId) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = siblingInterfaceId;
                }
                MovedStatics.lastContinueTextWidgetId = -1;
                ChatBox.inputType = 0;
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.CLOSE_ALL_WIDGETS.getOpcode()) {
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
                    MovedStatics.processGameStatus(30);
                }
                if(GameInterface.fullscreenSiblingInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
                    GameInterface.fullscreenSiblingInterfaceId = -1;
                }
                if(GameInterface.gameScreenInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
                    GameInterface.gameScreenInterfaceId = -1;
                }
                opcode = -1;
                MovedStatics.lastContinueTextWidgetId = -1;
                if(ChatBox.inputType != 0) {
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
                return true;
            }
            if(opcode == PacketType.SHOW_CHATBOX_WIDGET.getOpcode()) {
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
                    MovedStatics.processGameStatus(30);
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
                opcode = -1;
                MovedStatics.lastContinueTextWidgetId = -1;
                return true;
            }
            if(opcode == PacketType.PLAY_SONG.getOpcode()) {
                int songId = incomingPacketBuffer.getUnsignedShortLE();
                if(songId == 65535)
                    songId = -1;
                StaticAudio.playSong(songId);
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.PLAY_QUICK_SONG.getOpcode()) {
                int songTimeout = incomingPacketBuffer.getMediumBE();
                int songId = incomingPacketBuffer.getUnsignedShortBE();
                if(songId == 65535)
                    songId = -1;
                StaticAudio.playSoundJingle(songTimeout, songId);
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_REFERENCE_POSITION.getOpcode()) {
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.placementX = incomingPacketBuffer.getUnsignedByte();
                opcode = -1;
                return true;
            }
            if(opcode == 88) {
                Class51.anInt1205 = incomingPacketBuffer.getUnsignedByte();
                if(Player.currentTabId == Class51.anInt1205) {
                    if(Class51.anInt1205 != 3)
                        Player.currentTabId = 3;
                    else
                        Player.currentTabId = 1;
                    GameInterface.redrawTabArea = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 63) { // mass object/ground item update packet
                MovedStatics.placementX = incomingPacketBuffer.getUnsignedByte();
                OverlayDefinition.placementY = incomingPacketBuffer.getUnsignedByte();
                while(incomingPacketBuffer.currentPosition < incomingPacketSize) {
                    opcode = incomingPacketBuffer.getUnsignedByte();
                    parseMapIncomingPacket();
                }
                opcode = -1;
                return true;
            }
            if(opcode == 196) { // set chat mode configs
                ChatBox.publicChatMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.privateChatMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.tradeMode = incomingPacketBuffer.getUnsignedByte();
                ChatBox.redrawChatbox = true;
                MovedStatics.redrawChatbox = true;
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_SYSTEM_UPDATE_TIME.getOpcode()) {
                Class40_Sub5_Sub15.systemUpdateTime = incomingPacketBuffer.getUnsignedShortLE() * 30;
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_PLAYERS.getOpcode()) {
                parsePlayerUpdatePacket();
                opcode = -1;
                return true;
            }
            if(opcode == 2) {
                int varPlayerValue = incomingPacketBuffer.getIntBE();
                int varPlayerIndex = incomingPacketBuffer.getUnsignedShortBE();
                Buffer.anIntArray1984[varPlayerIndex] = varPlayerValue;
                if(varPlayerValue != VarPlayerDefinition.varPlayers[varPlayerIndex]) {
                    VarPlayerDefinition.varPlayers[varPlayerIndex] = varPlayerValue;
                    MovedStatics.method309(varPlayerIndex); // TODO find out what this does
                    if(ChatBox.dialogueId != -1)
                        ChatBox.redrawChatbox = true;
                    GameInterface.redrawTabArea = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_NPCS.getOpcode()) {
                parseNpcUpdatePacket();
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.PLAY_SOUND.getOpcode()) {
                int soundId = incomingPacketBuffer.getUnsignedShortBE();
                int volume = incomingPacketBuffer.getUnsignedByte();
                int delay = incomingPacketBuffer.getUnsignedShortBE();
                StaticAudio.method950(soundId, volume, delay);
                opcode = -1;
                return true;
            }
            if(opcode == 237) { // show tab overlay widget
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
                    MovedStatics.processGameStatus(30);
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
                opcode = -1;
                GameInterface.redrawTabArea = true;
                return true;
            }
            if(opcode == 234) {
                Player.cutsceneActive = true;
                MovedStatics.anInt564 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt2576 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt892 = incomingPacketBuffer.getUnsignedShortBE();
                Class60.anInt1413 = incomingPacketBuffer.getUnsignedByte();
                MovedStatics.anInt1856 = incomingPacketBuffer.getUnsignedByte();
                if(MovedStatics.anInt1856 >= 100) {
                    int i_69_ = 128 * MovedStatics.anInt564 + 64;
                    int i_70_ = 128 * MovedStatics.anInt2576 + 64;
                    int i_71_ = Class37.getFloorDrawHeight(Player.worldLevel, i_69_, i_70_) - MovedStatics.anInt892;
                    int i_72_ = i_69_ + -Class12.cameraX;
                    int i_73_ = i_70_ + -MovedStatics.cameraY;
                    int i_74_ = -SceneCluster.cameraZ + i_71_;
                    int i_75_ = (int) Math.sqrt((double) (i_73_ * i_73_ + i_72_ * i_72_));
                    Class26.anInt627 = (int) (325.949 * Math.atan2((double) i_74_, (double) i_75_)) & 0x7ff;
                    ProducingGraphicsBuffer_Sub1.anInt2210 = (int) (Math.atan2((double) i_72_, (double) i_73_) * -325.949) & 0x7ff;
                    if(Class26.anInt627 < 128)
                        Class26.anInt627 = 128;
                    if(Class26.anInt627 > 383)
                        Class26.anInt627 = 383;
                }
                opcode = -1;
                return true;
            }
            if(opcode == 142) {
                int rotationZ = incomingPacketBuffer.getUnsignedShortBE();
                int modelZoom = incomingPacketBuffer.getUnsignedShortLE();
                int rotationX = incomingPacketBuffer.getUnsignedShortBE();
                int interfaceData = incomingPacketBuffer.getIntLE();
                GameInterface childInterface = GameInterface.getInterface(interfaceData);
                opcode = -1;
                childInterface.rotationZ = rotationZ;
                childInterface.modelZoom = modelZoom;
                childInterface.rotationX = rotationX;
                return true;
            }
            if(opcode == PacketType.SET_CURRENT_TAB.getOpcode()) {
                Player.currentTabId = incomingPacketBuffer.getUnsignedByte();
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_CARRY_WEIGHT.getOpcode()) {
                if(Player.currentTabId == 12)
                    GameInterface.redrawTabArea = true;
                GenericTile.carryWeight = incomingPacketBuffer.getShortBE();
                opcode = -1;
                return true;
            }
            // object/ground item update packets?
            if(opcode == 9 || opcode == 99 || opcode == 229 || opcode == 19 || opcode == 202 || opcode == 1 || opcode == 74 || opcode == 175 || opcode == 49 || opcode == 143 || opcode == 241) {
                parseMapIncomingPacket();
                opcode = -1;
                return true;
            }
            if(opcode == 14) { // reset client configs?
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_WIDGET_NPC_HEAD.getOpcode()) {
                int npcId = incomingPacketBuffer.getUnsignedShortLE();
                int widgetData = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(widgetData);
                gameInterface.modelType = InterfaceModelType.NPC_CHATHEAD;
                opcode = -1;
                gameInterface.modelId = npcId;
                return true;
            }
            if(opcode == 132) { // open chatbox input widget
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = -1;
                }
                opcode = -1;
                ChatBox.inputMessage = "";
                ChatBox.inputType = 1;
                ChatBox.redrawChatbox = true;
                ChatBox.messagePromptRaised = false;
                return true;
            }
            if(opcode == 186) {
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_WIDGET_PLAYER_HEAD.getOpcode()) {
                int interfaceData = incomingPacketBuffer.getIntLE();
                GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                gameInterface.modelType = InterfaceModelType.LOCAL_PLAYER_CHATHEAD;
                gameInterface.modelId = Player.localPlayer.playerAppearance.getHeadModelId();
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_WIDGET_TEXT.getOpcode()) {
                int interfaceData = incomingPacketBuffer.getIntLE();
                String interfaceText = incomingPacketBuffer.getString();
                GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                gameInterface.disabledText = interfaceText;
                if(Player.tabWidgetIds[Player.currentTabId] == interfaceData >> 16) {
                    GameInterface.redrawTabArea = true;
                }
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_FRIEND_LIST_STATUS.getOpcode()) {
                Player.friendListStatus = incomingPacketBuffer.getUnsignedByte();
                GameInterface.redrawTabArea = true;
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_WIDGET_ITEM_MODEL.getOpcode()) {
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
                        opcode = -1;
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.PRIVATE_MESSAGE_RECEIVED.getOpcode()) {
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
                    for(int ignoreIndex = 0; ignoreIndex < MovedStatics.anInt1008; ignoreIndex++) {
                        if(fromPlayerIndex == Player.ignores[ignoreIndex]) {
                            hideMessage = true;
                            break;
                        }
                    }
                }
                if(!hideMessage && !Player.inTutorialIsland) {
                    Player.privateMessageIds[Player.privateMessageIndex] = chatId;
                    Player.privateMessageIndex = (1 + Player.privateMessageIndex) % 100;
                    String privateMessage = RSString.formatChatString(KeyFocusListener.method956(67, incomingPacketBuffer));
                    if(fromPlayerRights == 2 || fromPlayerRights == 3)
                        ChatBox.addChatMessage(Native.goldCrown + TextUtils.formatName(TextUtils.longToName(fromPlayerIndex)), privateMessage, 7);
                    else if(fromPlayerRights == 1)
                        ChatBox.addChatMessage(Native.whiteCrown + TextUtils.formatName(TextUtils.longToName(fromPlayerIndex)), privateMessage, 7);
                    else
                        ChatBox.addChatMessage(TextUtils.formatName(TextUtils.longToName(fromPlayerIndex)), privateMessage, 3);
                }
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.RESET_ACTOR_ANIMATIONS.getOpcode()) {
                for(int playerIdx = 0; playerIdx < Player.trackedPlayers.length; playerIdx++) {
                    if(Player.trackedPlayers[playerIdx] != null)
                        Player.trackedPlayers[playerIdx].playingAnimation = -1;
                }
                for(int npcIdx = 0; Player.npcs.length > npcIdx; npcIdx++) {
                    if(Player.npcs[npcIdx] != null)
                        Player.npcs[npcIdx].playingAnimation = -1;
                }
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_TAB_WIDGET.getOpcode()) {
                int interfaceId = incomingPacketBuffer.getUnsignedShortBE();
                int tabIndex = incomingPacketBuffer.getUnsignedByte();
                if(interfaceId == 65535)
                    interfaceId = -1;
                if(interfaceId != Player.tabWidgetIds[tabIndex]) {
                    GameInterface.resetInterface(Player.tabWidgetIds[tabIndex]);
                    Player.tabWidgetIds[tabIndex] = interfaceId;
                }
                GameInterface.drawTabIcons = true;
                opcode = -1;
                GameInterface.redrawTabArea = true;
                return true;
            }
            if(opcode == PacketType.UPDATE_SKILL.getOpcode()) {
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.MOVE_WIDGET_CHILD.getOpcode()) {
                int interfaceData = incomingPacketBuffer.getIntBE();
                int x = incomingPacketBuffer.getShortLE();
                int y = incomingPacketBuffer.getShortLE();
                GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                gameInterface.currentX = gameInterface.originalX + y;
                gameInterface.currentY = gameInterface.originalY + x;
                opcode = -1;
                return true;
            }
            if(opcode == 72) { // reset varbits?
                for(int varPlayerIndex = 0; varPlayerIndex < VarPlayerDefinition.varPlayers.length; varPlayerIndex++) {
                    if(Buffer.anIntArray1984[varPlayerIndex] != VarPlayerDefinition.varPlayers[varPlayerIndex]) {
                        VarPlayerDefinition.varPlayers[varPlayerIndex] = Buffer.anIntArray1984[varPlayerIndex];
                        MovedStatics.method309(varPlayerIndex);
                        GameInterface.redrawTabArea = true;
                    }
                }
                opcode = -1;
                return true;
            }
            if(opcode == 240) {
                ClientScriptRunner.parseClientScriptPacket(Main.signlink, incomingPacketBuffer);
                opcode = -1;
                return true;
            }
            if(opcode == 58) {
                int i_106_ = incomingPacketBuffer.getIntME2();
                Class12.aSignlinkNode_394 = Main.signlink.createExceptionNode(i_106_); // TODO this just ends up throwing an exception? wot
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_SPECIFIC_WIDGET_ITEMS.getOpcode()) {
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
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.SET_MAP_CHUNK.getOpcode()) {
                FloorDecoration.constructMapRegion(false, 5688);
                opcode = -1;
                return true;
            }
            if(opcode == PacketType.UPDATE_WIDGET_TEXT_COLOR.getOpcode()) {
                int i_113_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_114_ = incomingPacketBuffer.getIntLE();
                int i_115_ = i_113_ >> 10 & 0x1f;
                int i_116_ = 0x1f & i_113_ >> 5;
                GameInterface gameInterface = GameInterface.getInterface(i_114_);
                opcode = -1;
                int i_117_ = i_113_ & 0x1f;
                gameInterface.textColor = (i_116_ << 11) + (i_115_ << 19) + (i_117_ << 3);
                return true;
            }
            if(opcode == 211) { // update ignore list
                MovedStatics.anInt1008 = incomingPacketSize / 8;
                for(int i_118_ = 0; MovedStatics.anInt1008 > i_118_; i_118_++)
                    Player.ignores[i_118_] = incomingPacketBuffer.getLongBE();
                opcode = -1;
                return true;
            }
            if(opcode == 124) { // close chatbox widget
                if(GameInterface.chatboxInterfaceId != -1) {
                    GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
                    GameInterface.chatboxInterfaceId = -1;
                }
                ChatBox.redrawChatbox = true;
                ChatBox.inputMessage = "";
                ChatBox.inputType = 2;
                opcode = -1;
                ChatBox.messagePromptRaised = false;
                return true;
            }
            MovedStatics.printException("T1 - " + opcode + "," + secondLastOpcode + "," + thirdLastOpcode + " - " + incomingPacketSize, null);
            MovedStatics.logout();
        } catch(java.io.IOException ioexception) {
            Class59.dropClient();
        } catch(Exception exception) {
            String string = "T2 - " + opcode + "," + secondLastOpcode + "," + thirdLastOpcode + " - " + incomingPacketSize + "," + (MovedStatics.baseX + Player.localPlayer.pathY[0]) + "," + (Player.localPlayer.pathX[0] + Class26.baseY) + " - ";
            for(int i = 0; incomingPacketSize > i && i < 50; i++)
                string += incomingPacketBuffer.buffer[i] + ",";
            MovedStatics.printException(string, exception);
            MovedStatics.logout();
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

    public static void parseMapIncomingPacket() {
        if (opcode == 49) {
            int i = incomingPacketBuffer.getUnsignedByte();
            int i_0_ = OverlayDefinition.placementY + (i & 0x7);
            int i_1_ = ((0x7b & i) >> 4) + MovedStatics.placementX;
            int i_2_ = incomingPacketBuffer.getUnsignedByte();
            int i_3_ = i_2_ >> 2;
            int i_4_ = 0x3 & i_2_;
            int i_5_ = Npc.anIntArray3304[i_3_];
            int i_6_ = incomingPacketBuffer.getUnsignedShortLE();
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
        } else if (opcode == 241) { // set landscape object
            int i = incomingPacketBuffer.getUnsignedByte();
            int i_12_ = i & 0x3;
            int i_13_ = i >> 2;
            int i_14_ = Npc.anIntArray3304[i_13_];
            int objectId = incomingPacketBuffer.getUnsignedShortBE();
            int i_16_ = incomingPacketBuffer.getUnsignedByte();
            int i_17_ = (0x7 & i_16_) + OverlayDefinition.placementY;
            int i_18_ = MovedStatics.placementX + ((i_16_ & 0x75) >> 4);
            if (i_18_ >= 0 && i_17_ >= 0 && i_18_ < 104 && i_17_ < 104)
                GameObjectDefinition.method609(objectId, i_18_, i_12_, -1, Player.worldLevel, i_17_, i_14_, i_13_, 0);
        } else {
            if (opcode == 9) {
                int offset = incomingPacketBuffer.getUnsignedByte();
                int localX = (offset & 0x7) + OverlayDefinition.placementY;
                int localY = (0x7 & offset >> 4) + MovedStatics.placementX;
                int soundId = incomingPacketBuffer.getUnsignedShortBE();

                int soundData = incomingPacketBuffer.getUnsignedByte();
                int radius = soundData >> 4 & 0xf;
                int volume = 0x7 & soundData;
                int delay = incomingPacketBuffer.getUnsignedByte();
                if (localY >= 0 && localX >= 0 && localY < 104 && localX < 104) {
                    int i_26_ = 1 + radius;
                    if (Player.localPlayer.pathY[0] >= localY - i_26_ && Player.localPlayer.pathY[0] <= localY + i_26_ && localX - i_26_ <= Player.localPlayer.pathX[0] && localX + i_26_ >= Player.localPlayer.pathX[0] && StaticAudio.areaSoundEffectVolume != 0 && volume > 0 && StaticAudio.currentSound < 50) {
                        StaticAudio.sound[StaticAudio.currentSound] = soundId;
                        StaticAudio.soundVolume[StaticAudio.currentSound] = volume;
                        StaticAudio.soundDelay[StaticAudio.currentSound] = delay;
                        StaticAudio.effects[StaticAudio.currentSound] = null;
                        StaticAudio.soundLocations[StaticAudio.currentSound] = radius + (localX << 8) + (localY << 16);
                        StaticAudio.currentSound++;
                    }
                }
            }
            if (opcode == 202) {
                int i = incomingPacketBuffer.getUnsignedByte();
                int i_27_ = ((0x78 & i) >> 4) + MovedStatics.placementX;
                int i_28_ = OverlayDefinition.placementY + (0x7 & i);
                int i_29_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_30_ = incomingPacketBuffer.getUnsignedByte();
                int i_31_ = incomingPacketBuffer.getUnsignedShortBE();
                if (i_27_ >= 0 && i_28_ >= 0 && i_27_ < 104 && i_28_ < 104) {
                    i_28_ = 128 * i_28_ + 64;
                    i_27_ = i_27_ * 128 + 64;
                    Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = new Class40_Sub5_Sub17_Sub6(i_29_, Player.worldLevel, i_27_, i_28_, -i_30_ + Class37.getFloorDrawHeight(Player.worldLevel, i_27_, i_28_), i_31_, MovedStatics.pulseCycle);
                    Class57.aLinkedList_1332.pushBack(class40_sub5_sub17_sub6, -111);
                }
            } else if (opcode == 99) {
                int i = incomingPacketBuffer.getUnsignedByte();
                int i_32_ = MovedStatics.placementX + ((0x75 & i) >> 4);
                int i_33_ = (i & 0x7) + OverlayDefinition.placementY;
                int i_34_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_35_ = incomingPacketBuffer.getUnsignedShortBE();
                int i_36_ = incomingPacketBuffer.getUnsignedShortBE();
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
            } else if (opcode == 143) { // remove landscape object
                int offset = incomingPacketBuffer.getUnsignedByte();
                int positionY = OverlayDefinition.placementY + (0x7 & offset);
                int positionX = MovedStatics.placementX + (offset >> 4 & 0x7);
                int objectInfo = incomingPacketBuffer.getUnsignedByte();
                int orientation = objectInfo & 0x3;
                int typeIndex = objectInfo >> 2;
                int objectType = Npc.anIntArray3304[typeIndex];
                if (positionX >= 0 && positionY >= 0 && positionX < 104 && positionY < 104)
                    GameObjectDefinition.method609(-1, positionX, orientation, -1, Player.worldLevel, positionY, objectType, typeIndex, 0);
            } else {
                if (opcode == 229) {
                    int i = incomingPacketBuffer.getByte();
                    int i_43_ = incomingPacketBuffer.getUnsignedShortBE();
                    int i_44_ = incomingPacketBuffer.getByte();
                    int i_45_ = incomingPacketBuffer.getByte();
                    int i_46_ = incomingPacketBuffer.getUnsignedByte();
                    int i_47_ = i_46_ & 0x3;
                    int i_48_ = i_46_ >> 2;
                    int i_49_ = Npc.anIntArray3304[i_48_];
                    int i_50_ = incomingPacketBuffer.getUnsignedByte();
                    int i_51_ = (i_50_ & 0x7) + OverlayDefinition.placementY;
                    int i_52_ = MovedStatics.placementX + (i_50_ >> 4 & 0x7);
                    int i_53_ = incomingPacketBuffer.getUnsignedShortBE();
                    int i_54_ = incomingPacketBuffer.getByte();
                    int i_55_ = incomingPacketBuffer.getUnsignedShortLE();
                    int i_56_ = incomingPacketBuffer.getUnsignedShortLE();
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
                if (opcode == 74) { // remove world item
                    int i = incomingPacketBuffer.getUnsignedByte();
                    int i_65_ = MovedStatics.placementX + (i >> 4 & 0x7);
                    int i_66_ = (i & 0x7) + OverlayDefinition.placementY;
                    int i_67_ = incomingPacketBuffer.getUnsignedShortBE();
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
                } else if (opcode == 1) {
                    int offset = incomingPacketBuffer.getUnsignedByte();
                    int startY = (offset & 0x7) + OverlayDefinition.placementY;
                    int startX = MovedStatics.placementX + (0x7 & offset >> 4);
                    int endX = startX + incomingPacketBuffer.getByte();
                    int endY = startY + incomingPacketBuffer.getByte();
                    int entityIndex = incomingPacketBuffer.getShortBE();
                    int graphicsId = incomingPacketBuffer.getUnsignedShortBE();
                    int startHeight = incomingPacketBuffer.getUnsignedByte() * 4;
                    int endHeight = 4 * incomingPacketBuffer.getUnsignedByte();
                    int delay = incomingPacketBuffer.getUnsignedShortBE();
                    int speed = incomingPacketBuffer.getUnsignedShortBE();
                    int startSlope = incomingPacketBuffer.getUnsignedByte();
                    int startDistance = incomingPacketBuffer.getUnsignedByte();
                    if (startX >= 0 && startY >= 0 && startX < 104 && startY < 104 && endX >= 0 && endY >= 0 && endX < 104 && endY < 104 && graphicsId != 65535) {
                        endX = 64 + 128 * endX;
                        startX = 64 + 128 * startX;
                        startY = startY * 128 + 64;
                        Projectile projectile = new Projectile(graphicsId, Player.worldLevel, startX, startY, Class37.getFloorDrawHeight(Player.worldLevel, startX, startY) + -startHeight, delay + MovedStatics.pulseCycle, speed + MovedStatics.pulseCycle, startSlope, startDistance, entityIndex, endHeight);
                        endY = 128 * endY + 64;
                        projectile.trackTarget(delay + MovedStatics.pulseCycle, 0, endY, -endHeight + Class37.getFloorDrawHeight(Player.worldLevel, endX, endY), endX);
                        Class43.projectileQueue.pushBack(projectile, -73);
                    }
                } else {
                    if (opcode == 19) { // update world item amount
                        int i = incomingPacketBuffer.getUnsignedShortLE();
                        int i_80_ = incomingPacketBuffer.getUnsignedShortLE();
                        int i_81_ = incomingPacketBuffer.getUnsignedShortBE();
                        int i_82_ = incomingPacketBuffer.getUnsignedByte();
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
                    } else if (opcode == 175) { // add world item
                        int i = incomingPacketBuffer.getUnsignedShortLE();
                        int i_85_ = incomingPacketBuffer.getUnsignedShortBE();
                        int i_86_ = incomingPacketBuffer.getUnsignedByte();
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
}
