package com.jagex.runescape.frame;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.util.CollisionMap;

public class ChatBox {
    public static void renderChatbox(boolean arg0) {

        CacheIndex.aBoolean260 = arg0;
        Class22.method305((byte) 124);
        if(InteractiveObject.messagePromptRaised) {
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(HuffmanEncoding.aClass1_1563, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub5_Sub17_Sub6.method832((new RSString[]{HuffmanEncoding.aClass1_1565, (InteractiveObject.aClass1_478)})), 239, 60, 128);
        } else if(Class40_Sub5_Sub15.inputType == 1) {
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Landscape.aClass1_1174, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{HuffmanEncoding.inputInputMessage, InteractiveObject.aClass1_478})), 239, 60, 128);
        } else if(Class40_Sub5_Sub15.inputType == 2) {
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub5_Sub6.aClass1_2446, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{HuffmanEncoding.inputInputMessage, InteractiveObject.aClass1_478})), 239, 60, 128);
        } else if(Class40_Sub5_Sub15.inputType == 3) {
            if(HuffmanEncoding.inputInputMessage != HuffmanEncoding.lastItemSearchInput) {
                GameObject.itemSearch(HuffmanEncoding.inputInputMessage);
                HuffmanEncoding.lastItemSearchInput = HuffmanEncoding.inputInputMessage;
            }
            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
            Rasterizer.setCoordinates(0, 0, 77, 463);
            for(int index = 0; (index < VertexNormal.itemSearchResultCount); index++) {
                int y = index * 14 + (18 - Class26.itemSearchScroll);
                if(y > 0 && y < 110)
                    class40_sub5_sub14_sub1.method686(Class22_Sub1.itemSearchResultNames[index], 239, y, 0);
            }
            Rasterizer.resetCoordinates();
            if(VertexNormal.itemSearchResultCount > 5)
                Class27.drawScrollBar(0, Class26.itemSearchScroll, 7 + 14 * VertexNormal.itemSearchResultCount, 463, 77, 0);
            if(HuffmanEncoding.inputInputMessage.length() != 0) {
                if(VertexNormal.itemSearchResultCount == 0)
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class40_Sub6.aClass1_2097, 239, 40, 0);
            } else
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class35.aClass1_1747, 239, 40, 255);
            class40_sub5_sub14_sub1.method686((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{HuffmanEncoding.inputInputMessage, InteractiveObject.aClass1_478})), 239, 90, 0);
            Rasterizer.drawHorizontalLine(0, 77, 479, 0);
        } else if(RSApplet.aClass1_8 == null) {
            if(Class43.openChatboxWidgetId == -1) {
                if(Class48.anInt1138 == -1) {
                    int line = 0;
                    TypeFace typeFace = (WallDecoration.fontNormal);
                    Rasterizer.setCoordinates(0, 0, 77, 463);
                    for(int i_8_ = 0; i_8_ < 100; i_8_++) {
                        if((Actor.chatMessages[i_8_]) != null) {
                            int type = HuffmanEncoding.chatTypes[i_8_];
                            RSString name = (Renderable.chatPlayerNames[i_8_]);
                            int y = (GameObjectDefinition.chatboxScroll + 70 + -(line * 14));
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
                                    typeFace.drawString((Actor.chatMessages[i_8_]), 4, y, 0);
                            }
                            if((type == 1 || type == 2) && (type == 1 || Class35.publicChatMode == 0 || Class35.publicChatMode == 1 && (Class40_Sub2.hasFriend(name, -32624)))) {
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
                                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{name, (Class43.char_colon)}))), x, y, 0);
                                    x += (8 + (typeFace.getStringWidth(name)));
                                    typeFace.drawString((Actor.chatMessages[i_8_]), x, y, 255);
                                }
                                line++;
                            }
                            if((type == 3 || type == 7) && CollisionMap.anInt165 == 0 && (type == 7 || Class4.anInt185 == 0 || (Class4.anInt185 == 1 && (Class40_Sub2.hasFriend(name, -32624))))) {
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
                                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{name, (Class43.char_colon)}))), i_13_, y, 0);
                                    i_13_ += (8 + (typeFace.getStringWidth(name)));
                                    typeFace.drawString((Actor.chatMessages[i_8_]), i_13_, y, 8388608);
                                }
                            }
                            if(type == 4 && ((ItemDefinition.anInt2797) == 0 || ((ItemDefinition.anInt2797) == 1 && (Class40_Sub2.hasFriend(name, -32624))))) {
                                line++;
                                if(y > 0 && y < 110)
                                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{name, (Class48.aClass1_1123), (Actor.chatMessages[i_8_])}))), 4, y, 8388736);
                            }
                            if(type == 5 && CollisionMap.anInt165 == 0 && Class4.anInt185 < 2) {
                                if(y > 0 && y < 110)
                                    typeFace.drawString((Actor.chatMessages[i_8_]), 4, y, 8388608);
                                line++;
                            }
                            if(type == 6 && CollisionMap.anInt165 == 0 && Class4.anInt185 < 2) {
                                if(y > 0 && (y < 110)) {
                                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), name, (Class43.char_colon)}))), 4, y, 0);
                                    typeFace.drawString((Actor.chatMessages[i_8_]), (typeFace.getStringWidth(Class40_Sub5_Sub17_Sub6.method832((new RSString[]{(Class40_Sub5_Sub1.aClass1_2274), (Class48.aClass1_1123), name})))) + 12, y, 8388608);
                                }
                                line++;
                            }
                            if(type == 8 && ((ItemDefinition.anInt2797) == 0 || ((ItemDefinition.anInt2797) == 1 && (Class40_Sub2.hasFriend(name, -32624))))) {
                                line++;
                                if(y > 0 && (y < 110))
                                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{name, (Class48.aClass1_1123), (Actor.chatMessages[i_8_])}))), 4, y, 8270336);
                            }
                        }
                    }
                    Rasterizer.resetCoordinates();
                    GameFrame.chatboxScrollMax = line * 14 + 7;
                    if(GameFrame.chatboxScrollMax < 78)
                        GameFrame.chatboxScrollMax = 78;
                    Class27.drawScrollBar(0, (-(GameObjectDefinition.chatboxScroll) + GameFrame.chatboxScrollMax - 77), GameFrame.chatboxScrollMax, 463, 77, 0);
                    RSString name;
                    if(((Player.localPlayer) != null) && (Player.localPlayer.playerName) != null)
                        name = (Player.localPlayer.playerName);
                    else
                        name = Class22_Sub2.username;
                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{name, Class43.char_colon}))), 4, 90, 0);
                    typeFace.drawString((Class40_Sub5_Sub17_Sub6.method832((new RSString[]{HuffmanEncoding.chatboxInput, InteractiveObject.aClass1_478}))), ((typeFace.getStringWidth(Class40_Sub5_Sub17_Sub6.method832((new RSString[]{name, ISAAC.aClass1_515})))) + 6), 90, 255);
                    Rasterizer.drawHorizontalLine(0, 77, 479, 0);
                } else {
                    boolean bool = (Class40_Sub5_Sub6.drawInterface(0, Class48.anInt1138, 96, (byte) -5, 0, 3, 479));
                    if(!bool)
                        Class52.redrawChatbox = true;
                }
            } else {
                boolean bool = Class40_Sub5_Sub6.drawInterface(0, (Class43.openChatboxWidgetId), 96, (byte) -5, 0, 2, 479);
                if(!bool)
                    Class52.redrawChatbox = true;
            }
        } else {
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(RSApplet.aClass1_8, 239, 40, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method686(Class34.aClass1_829, 239, 60, 128);
        }
        if(Class4.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 2)
            Class40_Sub5_Sub6.method588(-1);
        Class45.method908((byte) 122);

    }
}
