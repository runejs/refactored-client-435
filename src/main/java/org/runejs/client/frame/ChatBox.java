package org.runejs.client.frame;

import org.runejs.client.*;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.tile.WallDecoration;
import org.runejs.client.scene.util.CollisionMap;

public class ChatBox {
    public static boolean redrawChatbox = false;
    public static boolean messagePromptRaised = false;
    private static String lastItemSearchInput = "";
    public static String inputMessage = "";
    public static int itemSearchResultCount = 0;
    public static int itemSearchScroll = 0;
    private static String[] itemSearchResultNames = new String[100];
    public static int inputType = 0;
    public static int dialogueId = -1;
    public static String[] chatMessages = new String[100];
    public static int[] chatTypes = new int[100];
    public static String[] chatPlayerNames  = new String[100];
    public static int publicChatMode = 0;
    public static int privateChatMode = 0;
    public static int tradeMode = 0;
    public static int chatboxScrollMax = 78;
    public static int chatboxScroll = 0;
    private static int[] itemSearchResultIds = new int[100];
    public static String chatboxInput = "";
    public static String chatMessage = "";

    private static char[] VALID_CHARACTERS = {' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w',
            'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243',
            '$', '%', '"', '[', ']', '_', '{', '}', '/', '|'};
    public static void renderChatbox() {
        MovedStatics.showChatPanelRedrawnText = true;
        MovedStatics.method305();
        if(messagePromptRaised) {
            TypeFace.fontBold.drawStringLeft(Native.enterPlayerNameHeader, 239, 40, 0);
            TypeFace.fontBold.drawStringLeft(chatMessage + "*", 239, 60, 128);
        } else if(inputType == 1) {
            TypeFace.fontBold.drawStringLeft(English.enterAmount, 239, 40, 0);
            TypeFace.fontBold.drawStringLeft(inputMessage + "*", 239, 60, 128);
        } else if(inputType == 2) {
            TypeFace.fontBold.drawStringLeft(English.enterName, 239, 40, 0);
            TypeFace.fontBold.drawStringLeft(inputMessage + "*", 239, 60, 128);
        } else if(inputType == 3) {
            if(!inputMessage.equals(lastItemSearchInput)) {
                itemSearch(inputMessage);
                lastItemSearchInput = inputMessage;
            }
            TypeFace font = WallDecoration.fontNormal;
            Rasterizer.setBounds(0, 0, 463, 77);
            for(int index = 0; index < itemSearchResultCount; index++) {
                int y = index * 14 + 18 - itemSearchScroll;
                if(y > 0 && y < 110)
                    font.drawStringLeft(itemSearchResultNames[index], 239, y, 0);
            }
            Rasterizer.resetBounds();
            if(itemSearchResultCount > 5)
                GameInterface.drawScrollBar(463, 0, 77, itemSearchScroll, 7 + 14 * itemSearchResultCount, 0);
            if(inputMessage.length() != 0) {
                if(itemSearchResultCount == 0)
                    TypeFace.fontBold.drawStringLeft(English.noMatchingObjectsFound, 239, 40, 0);
            } else
                TypeFace.fontBold.drawStringLeft(English.enterObjectName, 239, 40, 255);
            font.drawStringLeft(inputMessage + "*", 239, 90, 0);
            Rasterizer.drawHorizontalLine(0, 77, 479, 0);
        } else if(Native.clickToContinueString != null) {
            TypeFace.fontBold.drawStringLeft(Native.clickToContinueString, 239, 40, 0);
            TypeFace.fontBold.drawStringLeft(English.clickToContinue, 239, 60, 128);
        } else if(GameInterface.chatboxInterfaceId != -1) {
            redrawChatbox = !Main.drawParentInterface(2, 0, 0, 479, 96, GameInterface.chatboxInterfaceId);
        } else if(dialogueId == -1) {
            int line = 0;
            TypeFace typeFace = WallDecoration.fontNormal;
            Rasterizer.setBounds(0, 0, 463, 77);
            for(int i = 0; i < 100; i++) {
                if(chatMessages[i] != null) {
                    int type = chatTypes[i];
                    String name = chatPlayerNames[i];
                    int y = chatboxScroll + 70 + -(line * 14);
                    int privelege = 0;
                    if(name != null && name.startsWith(Native.whiteCrown)) {
                        name = name.substring(5);
                        privelege = 1;
                    }
                    if(name != null && name.startsWith(Native.goldCrown)) {
                        name = name.substring(5);
                        privelege = 2;
                    }
                    if(type == 0) {
                        line++;
                        if(y > 0 && y < 110)
                            typeFace.drawString(chatMessages[i], 4, y, 0);
                    }
                    if((type == 1 || type == 2) && (type == 1 || publicChatMode == 0 || publicChatMode == 1 && Player.hasFriend(name))) {
                        if(y > 0 && y < 110) {
                            int x = 4;
                            if(privelege == 1) {
                                MovedStatics.moderatorIcon[0].drawImage(x, y + -12);
                                x += 14;
                            }
                            if(privelege == 2) {
                                MovedStatics.moderatorIcon[1].drawImage(x, y - 12);
                                x += 14;
                            }
                            typeFace.drawString(name+ Native.colon, x, y, 0);
                            x += 8 + typeFace.getStringWidth(name);
                            typeFace.drawString(chatMessages[i], x, y, 255);
                        }
                        line++;
                    }
                    if((type == 3 || type == 7) && CollisionMap.anInt165 == 0 && (type == 7 || privateChatMode == 0 || privateChatMode == 1 && Player.hasFriend(name))) {
                        line++;
                        if(y > 0 && y < 110) {
                            int i_13_ = 4;
                            typeFace.drawString(English.from, i_13_, y, 0);
                            i_13_ += typeFace.getStringWidth(English.from);
                            i_13_ += typeFace.method689(32);
                            if(privelege == 1) {
                                MovedStatics.moderatorIcon[0].drawImage(i_13_, y + -12);
                                i_13_ += 14;
                            }
                            if(privelege == 2) {
                                MovedStatics.moderatorIcon[1].drawImage(i_13_, y - 12);
                                i_13_ += 14;
                            }
                            typeFace.drawString(name + Native.colon, i_13_, y, 0);
                            i_13_ += 8 + typeFace.getStringWidth(name);
                            typeFace.drawString(chatMessages[i], i_13_, y, 8388608);
                        }
                    }
                    if(type == 4 && (tradeMode == 0 || tradeMode == 1 && Player.hasFriend(name))) {
                        line++;
                        if(y > 0 && y < 110)
                            typeFace.drawString(name + " " + chatMessages[i], 4, y, 8388736);
                    }
                    if(type == 5 && CollisionMap.anInt165 == 0 && privateChatMode < 2) {
                        if(y > 0 && y < 110)
                            typeFace.drawString(chatMessages[i], 4, y, 8388608);
                        line++;
                    }
                    if(type == 6 && CollisionMap.anInt165 == 0 && privateChatMode < 2) {
                        if(y > 0 && y < 110) {
                            typeFace.drawString(English.to + Native.whitespace_b + name + Native.colon, 4, y, 0);
                            typeFace.drawString(chatMessages[i], typeFace.getStringWidth(English.to + Native.whitespace_b + name) + 12, y, 8388608);
                        }
                        line++;
                    }
                    if(type == 8 && (tradeMode == 0 || tradeMode == 1 && Player.hasFriend(name))) {
                        line++;
                        if(y > 0 && y < 110)
                            typeFace.drawString(name + Native.whitespace_b + chatMessages[i], 4, y, 8270336);
                    }
                }
            }
            Rasterizer.resetBounds();
            chatboxScrollMax = line * 14 + 7;
            if(chatboxScrollMax < 78)
                chatboxScrollMax = 78;
            GameInterface.drawScrollBar(463, 0, 77, chatboxScrollMax - chatboxScroll - 77, chatboxScrollMax, 0);
            String name;
            if(Player.localPlayer != null && Player.localPlayer.playerName != null)
                name = Player.localPlayer.playerName;
            else
                name = Native.username.toString();
            typeFace.drawString(name + Native.colon, 4, 90, 0);
            typeFace.drawBasicStringLegacy("@blu@" + chatboxInput + Native.asterisk, typeFace.getStringWidth(name + Native.COLON_CHARACTER) + 6, 90);
            Rasterizer.drawHorizontalLine(0, 77, 479, 0);
        } else {
            boolean bool = Main.drawParentInterface(3, 0, 0, 479, 96, dialogueId);
            if(!bool)
                redrawChatbox = true;
        }
        if(MovedStatics.menuOpen && ScreenController.frameMode == ScreenMode.FIXED && Projectile.menuScreenArea == 2)
            MovedStatics.drawMenu(0, 0);
        if(ScreenController.frameMode == ScreenMode.FIXED) {
            LinkedList.drawChatBoxGraphics();
        }

    }

    public static void itemSearch(String input) {
        if(input == null || input.length() == 0)
            itemSearchResultCount = 0;
        else {
            String searchTerm = input;
            String[] splitString = new String[100];
            int i = 0;
            while(true) {
                int spaceIndex = searchTerm.indexOf(' ');
                if(spaceIndex == -1) {
                    searchTerm = searchTerm.trim();
                    if(searchTerm.length() > 0)
                        splitString[i++] = searchTerm.toLowerCase();
                    break;
                }
                String first = searchTerm.substring(0, spaceIndex).trim();
                if(first.length() > 0)
                    splitString[i++] = first.toLowerCase();
                searchTerm = searchTerm.substring(1 + spaceIndex);
            }
            itemSearchResultCount = 0;
            while_12_:
            for(int itemId = 0; ItemDefinition.count > itemId; itemId++) {
                ItemDefinition definition = ItemDefinition.forId(itemId, 10);
                if(definition.noteTemplateId == -1 && definition.name != null) {
                    String itemName = definition.name.toLowerCase();
                    for(int indx = 0; indx < i; indx++) {
                        if(!itemName.contains(splitString[indx]))
                            continue while_12_;
                    }
                    itemSearchResultNames[itemSearchResultCount] = itemName;
                    itemSearchResultIds[itemSearchResultCount] = itemId;
                    itemSearchResultCount++;
                    if(itemSearchResultCount >= itemSearchResultNames.length)
                        break;
                }
            }
        }
    }

    public static void filterInput() {
//        StringBuilder result = new StringBuilder();
//        chatboxInput = chatboxInput.toLowerCase();
//        for (int i = 0; i < chatboxInput.length(); i++) {
//            for (char validCharacter : VALID_CHARACTERS) {
//                if (chatboxInput.charAt(i) != validCharacter)
//                    continue;
//
//                result.append(chatboxInput.charAt(i));
//            }
//        }
//        chatboxInput = result.toString();
    }

    /**
     * Adds a client-sided chat message.
     * @param name The name of the person sending this message, or blank.
     * @param message The message
     * @param type The message type. Can be:
     *             0 = System message (all black)
     *             1 = Moderator message (with crown)
     *             2 = Regular message
     *             3 = Regular private message
     *             4 = Trade message
     *             5 = Log in / log out notification
     *             6 = Unknown, might be forced private message
     *             7 = Moderator private message
     *             8 = Duel/Challenge message
     */
    public static void addChatMessage(String name, String message, int type) {
        if(GameInterface.chatboxInterfaceId == -1)
            redrawChatbox = true;
        if(type == 0 && dialogueId != -1) {
            MouseHandler.clickType = 0;
            Native.clickToContinueString = message;
        }
        for(int i = 99; i > 0; i--) {
            chatTypes[i] = chatTypes[i + -1];
            chatPlayerNames[i] = chatPlayerNames[-1 + i];
            chatMessages[i] = chatMessages[-1 + i];
        }
        chatTypes[0] = type;
        chatPlayerNames[0] = name;
        chatMessages[0] = message;
    }
}
