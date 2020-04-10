package com.jagex.runescape.frame;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

public class ChatBox {
    public static boolean redrawChatbox = false;
    public static boolean messagePromptRaised = false;
    public static RSString lastItemSearchInput = HuffmanEncoding.blank_string;
    public static RSString inputMessage = HuffmanEncoding.blank_string;
    public static int itemSearchResultCount = 0;
    public static int itemSearchScroll = 0;
    public static RSString[] itemSearchResultNames = new RSString[100];
    public static int inputType = 0;
    public static int openChatboxWidgetId = -1;
    public static int dialogueId = -1;
    public static RSString[] chatMessages = new RSString[100];
    public static int[] chatTypes = new int[100];
    public static RSString[] chatPlayerNames;
    public static int publicChatMode = 0;
    public static int privateChatMode = 0;
    public static int tradeMode = 0;
    public static int chatboxScrollMax = 78;
    public static int chatboxScroll = 0;
    public static int[] itemSearchResultIds = new int[100];

    public static void renderChatbox(boolean arg0) {
        CacheIndex.aBoolean260 = arg0;
        Class22.method305((byte) 124);
        if(messagePromptRaised) {
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(HuffmanEncoding.aClass1_1563, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(RSString.linkRSStrings((new RSString[]{HuffmanEncoding.chatMessage, (InteractiveObject.aClass1_478)})), 239, 60, 128);
        } else if(inputType == 1) {
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(Landscape.aClass1_1174, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft((RSString.linkRSStrings(new RSString[]{inputMessage, InteractiveObject.aClass1_478})), 239, 60, 128);
        } else if(inputType == 2) {
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(Class40_Sub5_Sub6.aClass1_2446, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft((RSString.linkRSStrings(new RSString[]{inputMessage, InteractiveObject.aClass1_478})), 239, 60, 128);
        } else if(inputType == 3) {
            if(inputMessage != lastItemSearchInput) {
                itemSearch(inputMessage);
                lastItemSearchInput = inputMessage;
            }
            TypeFace font = WallDecoration.fontNormal;
            Rasterizer.setBounds(0, 0, 77, 463);
            for(int index = 0; (index < itemSearchResultCount); index++) {
                int y = index * 14 + (18 - itemSearchScroll);
                if(y > 0 && y < 110)
                    font.drawStringLeft(itemSearchResultNames[index], 239, y, 0);
            }
            Rasterizer.resetBounds();
            if(itemSearchResultCount > 5)
                Widget.drawScrollBar(463, 0, 77, itemSearchScroll, 7 + 14 * itemSearchResultCount, 0);
            if(inputMessage.length() != 0) {
                if(itemSearchResultCount == 0)
                    Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(Class40_Sub6.aClass1_2097, 239, 40, 0);
            } else
                Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(Class35.aClass1_1747, 239, 40, 255);
            font.drawStringLeft((RSString.linkRSStrings(new RSString[]{inputMessage, InteractiveObject.aClass1_478})), 239, 90, 0);
            Rasterizer.drawHorizontalLine(0, 77, 479, 0);
        } else if(GameShell.clickToContinueString != null) {
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(GameShell.clickToContinueString, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.fontBold.drawStringLeft(Class34.aClass1_829, 239, 60, 128);
        } else if(openChatboxWidgetId != -1) {
            redrawChatbox = !Class40_Sub5_Sub6.drawInterface(0, (openChatboxWidgetId), 96, (byte) -5, 0, 2, 479);
        } else if(dialogueId == -1) {
            int line = 0;
            TypeFace typeFace = WallDecoration.fontNormal;
            Rasterizer.setBounds(0, 0, 77, 463);
            for(int i = 0; i < 100; i++) {
                if((chatMessages[i]) != null) {
                    int type = chatTypes[i];
                    RSString name = (chatPlayerNames[i]);
                    int y = (chatboxScroll + 70 + -(line * 14));
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
                        if(y > 0 && (y < 110))
                            typeFace.drawString((chatMessages[i]), 4, y, 0);
                    }
                    if((type == 1 || type == 2) && (type == 1 || publicChatMode == 0 || publicChatMode == 1 && (Class40_Sub2.hasFriend(name)))) {
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
                            typeFace.drawString((RSString.linkRSStrings((new RSString[]{name, (Class43.char_colon)}))), x, y, 0);
                            x += (8 + (typeFace.getStringWidth(name)));
                            typeFace.drawString((chatMessages[i]), x, y, 255);
                        }
                        line++;
                    }
                    if((type == 3 || type == 7) && CollisionMap.anInt165 == 0 && (type == 7 || privateChatMode == 0 || (privateChatMode == 1 && (Class40_Sub2.hasFriend(name))))) {
                        line++;
                        if(y > 0 && y < 110) {
                            int i_13_ = 4;
                            typeFace.drawString((Class40_Sub5_Sub6.aClass1_2458), i_13_, y, 0);
                            i_13_ += (typeFace.getStringWidth(Class40_Sub5_Sub6.aClass1_2458));
                            i_13_ += typeFace.method689(32);
                            if(privelege == 1) {
                                Class40_Sub5_Sub13.moderatorIcon[0].drawImage(i_13_, y + -12);
                                i_13_ += 14;
                            }
                            if(privelege == 2) {
                                Class40_Sub5_Sub13.moderatorIcon[1].drawImage(i_13_, y - 12);
                                i_13_ += 14;
                            }
                            typeFace.drawString((RSString.linkRSStrings((new RSString[]{name, (Class43.char_colon)}))), i_13_, y, 0);
                            i_13_ += (8 + (typeFace.getStringWidth(name)));
                            typeFace.drawString((chatMessages[i]), i_13_, y, 8388608);
                        }
                    }
                    if(type == 4 && ((tradeMode) == 0 || ((tradeMode) == 1 && (Class40_Sub2.hasFriend(name))))) {
                        line++;
                        if(y > 0 && y < 110)
                            typeFace.drawString((RSString.linkRSStrings((new RSString[]{name, (Class48.aClass1_1123), (chatMessages[i])}))), 4, y, 8388736);
                    }
                    if(type == 5 && CollisionMap.anInt165 == 0 && privateChatMode < 2) {
                        if(y > 0 && y < 110)
                            typeFace.drawString((chatMessages[i]), 4, y, 8388608);
                        line++;
                    }
                    if(type == 6 && CollisionMap.anInt165 == 0 && privateChatMode < 2) {
                        if(y > 0 && (y < 110)) {
                            typeFace.drawString((RSString.linkRSStrings((new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), name, (Class43.char_colon)}))), 4, y, 0);
                            typeFace.drawString((chatMessages[i]), (typeFace.getStringWidth(RSString.linkRSStrings((new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), name})))) + 12, y, 8388608);
                        }
                        line++;
                    }
                    if(type == 8 && ((tradeMode) == 0 || ((tradeMode) == 1 && (Class40_Sub2.hasFriend(name))))) {
                        line++;
                        if(y > 0 && (y < 110))
                            typeFace.drawString((RSString.linkRSStrings((new RSString[]{name, (Class48.aClass1_1123), (chatMessages[i])}))), 4, y, 8270336);
                    }
                }
            }
            Rasterizer.resetBounds();
            chatboxScrollMax = line * 14 + 7;
            if(chatboxScrollMax < 78)
                chatboxScrollMax = 78;
            Widget.drawScrollBar(463, 0, 77, chatboxScrollMax - chatboxScroll - 77, chatboxScrollMax, 0);
            RSString name;
            if(((Player.localPlayer) != null) && (Player.localPlayer.playerName) != null)
                name = (Player.localPlayer.playerName);
            else
                name = Native.username;
            typeFace.drawString((RSString.linkRSStrings((new RSString[]{name, Class43.char_colon}))), 4, 90, 0);
            typeFace.drawString((RSString.linkRSStrings((new RSString[]{HuffmanEncoding.chatboxInput, InteractiveObject.aClass1_478}))), ((typeFace.getStringWidth(RSString.linkRSStrings((new RSString[]{name, ISAAC.aClass1_515})))) + 6), 90, 255);
            Rasterizer.drawHorizontalLine(0, 77, 479, 0);
        } else {
            boolean bool = (Class40_Sub5_Sub6.drawInterface(0, dialogueId, 96, (byte) -5, 0, 3, 479));
            if(!bool)
                redrawChatbox = true;
        }
        if(Class4.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
            Class40_Sub5_Sub6.drawMenu();
        LinkedList.method908((byte) 122);

    }

    public static void itemSearch(RSString input) {
        if(input == null || input.length() == 0)
            itemSearchResultCount = 0;
        else {
            RSString searchTerm = input;
            RSString[] splitString = new RSString[100];
            int i = 0;
            while(true) {
                int spaceIndex = searchTerm.indexOf(' ');
                if(spaceIndex == -1) {
                    searchTerm = searchTerm.trim();
                    if(searchTerm.length() > 0)
                        splitString[i++] = searchTerm.toLowerCase();
                    break;
                }
                RSString first = searchTerm.substring(0, spaceIndex).trim();
                if(first.length() > 0)
                    splitString[i++] = first.toLowerCase();
                searchTerm = searchTerm.substring(1 + spaceIndex);
            }
            itemSearchResultCount = 0;
            while_12_:
            for(int itemId = 0; ItemDefinition.count > itemId; itemId++) {
                ItemDefinition definition = ItemDefinition.forId(itemId, 10);
                if(definition.noteTemplateId == -1 && definition.name != null) {
                    RSString itemName = definition.name.toLowerCase();
                    for(int indx = 0; indx < i; indx++) {
                        if(itemName.contains(splitString[indx]) == -1)
                            continue while_12_;
                    }
                    itemSearchResultNames[itemSearchResultCount] = itemName;
                    itemSearchResultIds[itemSearchResultCount] = itemId;
                    itemSearchResultCount++;
                    if((itemSearchResultCount >= itemSearchResultNames.length))
                        break;
                }
            }
        }
    }
}
