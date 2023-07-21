package org.runejs.client.frame;

import org.runejs.Configuration;
import org.runejs.client.Game;
import org.runejs.client.GameShell;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.RasterizerInstanced;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Player;

public class Game3DRenderer {
    private final RasterizerInstanced rasterizer;

    public Game3DRenderer(RasterizerInstanced rasterizer) {
        this.rasterizer = rasterizer;
    }

    private void renderSplitPrivateMessages(TypeFace font) {
        if(ChatBox.splitPrivateChat != 0) {
            int i = 0;
            if(MovedStatics.systemUpdateTime != 0)
                i = 1;
            for(int i_0_ = 0; i_0_ < 100; i_0_++) {
                if(ChatBox.chatMessages[i_0_] != null) {
                    String name = ChatBox.chatPlayerNames[i_0_];
                    int crown = 0;
                    int type = ChatBox.chatTypes[i_0_];
                    if(name != null && name.startsWith(Native.whiteCrown)) {
                        name = name.substring(5);
                        crown = 1;
                    }
                    if(name != null && name.startsWith(Native.goldCrown)) {
                        name = name.substring(5);
                        crown = 2;
                    }
                    if((type == 3 || type == 7) && (type == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(name))) {
                        int y = 329 - 13 * i;
                        int x = 4;
                        i++;
                        font.drawString(English.from, x, y, 0);
                        font.drawString(English.from, x, -1 + y, 65535);
                        x += font.getStringWidth(English.from);
                        x += font.method689(32);
                        if(crown == 1) {
                            MovedStatics.moderatorIcon[0].drawImage(rasterizer, x, y - 12);
                            x += 14;
                        }
                        if(crown == 2) {
                            MovedStatics.moderatorIcon[1].drawImage(rasterizer,x, -12 + y);
                            x += 14;
                        }
                        font.drawString(name + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], x, y, 0);
                        font.drawString(name + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], x, -1 + y, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(type == 5 && ChatBox.privateChatMode < 2) {
                        int y = -(i * 13) + 329;
                        i++;
                        font.drawString(ChatBox.chatMessages[i_0_], 4, y, 0);
                        font.drawString(ChatBox.chatMessages[i_0_], 4, y - 1, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(type == 6 && ChatBox.privateChatMode < 2) {
                        int y = -(13 * i) + 329;
                        i++;
                        font.drawString(English.to + Native.whitespace_b + name + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, y, 0);
                        font.drawString(English.to + Native.whitespace_b + name + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, y + -1, 65535);
                        if(i >= 5)
                            return;
                    }
                }
            }
        }
    }

    public void draw3dScreenOverlays() {
        TypeFace font = MovedStatics.fontNormal;
        font.setRasterizer(this.rasterizer);

        renderSplitPrivateMessages(font);
        if (MovedStatics.crossType == 1) {
            MovedStatics.cursorCross[MovedStatics.crossIndex / 100].drawImage(GameInterface.crossX - 8 - 4, GameInterface.crossY - 8 - 4);
        }
        if (MovedStatics.crossType == 2) {
            MovedStatics.cursorCross[4 + MovedStatics.crossIndex / 100].drawImage(GameInterface.crossX - 8 - 4, GameInterface.crossY - 8 - 4);
        }
        if (GameInterface.gameScreenInterfaceId != -1 || GameInterface.walkableWidgetId != -1) {
            int areaId = GameInterface.gameScreenInterfaceId != -1 ? 0 : 4;
            int id = GameInterface.gameScreenInterfaceId != -1 ? GameInterface.gameScreenInterfaceId : GameInterface.walkableWidgetId;
            GameInterface.handleSequences(id);
            int yOffset = (ScreenController.drawHeight /2) - (334/2) - (184/2);
            int xOffset = (ScreenController.drawWidth /2) - (512/2) - (234/3);
            if(ScreenController.frameMode == ScreenMode.FIXED) {
                yOffset = 0;
                xOffset = 0;
            }
            Game.drawParentInterface(areaId, xOffset, yOffset, 512+ xOffset, 334 + yOffset, id);
        }
        MovedStatics.method1018();
        Player.setTutorialIslandFlag();
        if (!MovedStatics.menuOpen) {
            MovedStatics.processRightClick();
            MovedStatics.drawMenuTooltip(4);
        } else  {
            if(ScreenController.frameMode == ScreenMode.FIXED && MovedStatics.menuScreenArea == 0){
                MovedStatics.drawMenu(4,4);
            }
        }
        if (MovedStatics.multiCombatState == 1) {
            MovedStatics.multiCombatIcon.drawImage(472, 296);
        }
        if (MovedStatics.showFps) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }

            int colour = 0xffff00;
            if (GameShell.fps < 30 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (GameShell.fps < 20 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            font.drawStringRight("Fps: " + GameShell.fps, x, y, colour);
            colour = 0xffff00;
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int memoryUsed = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            if (memoryUsed > 32768 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (memoryUsed < 65536 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            font.drawStringRight("Mem: " + memoryUsed + "k", x, y, colour);
            y += 15;

            font.drawStringRight("MouseX: " + MouseHandler.mouseX, x, y ,0xffff00);
            y += 15;

            font.drawStringRight("MouseY: " + MouseHandler.mouseY, x, y ,0xffff00);
            y += 15;
            font.drawStringRight("ClickX: " + MouseHandler.clickX, x, y ,0xffff00);
            y += 15;

            font.drawStringRight("ClickY: " + MouseHandler.clickY, x, y ,0xffff00);
            y += 15;
            if (MovedStatics.showSidePanelRedrawnText) {
                font.drawStringRight(English.sidePanelRedrawn, x, y, 16711680);
                y += 15;
                MovedStatics.showSidePanelRedrawnText = false;
            }
            if (MovedStatics.showChatPanelRedrawnText) {
                font.drawStringRight(English.chatPanelRedrawn, x, y, 16711680);
                y += 15;
                MovedStatics.showChatPanelRedrawnText = false;
            }
            if (MovedStatics.showIconsRedrawnText) {
                font.drawStringRight(English.iconsRedrawn, x, y, 16711680);
                MovedStatics.showIconsRedrawnText = false;
                y += 15;
            }
        }
        if (Configuration.DEBUG_WIDGETS) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }
            int widgetParentId = MovedStatics.hoveredWidgetId >> 16;
            int widgetChildId = MovedStatics.hoveredWidgetId & 0x7fff;
            String typeAsString = "";

            // Gather widget metadata from the cached interfaces
            GameInterface[] parentInterface;
            GameInterface childInterface = null;
            if (widgetParentId >= 0 && widgetChildId < 469) {
                parentInterface = GameInterface.cachedInterfaces[widgetParentId];

                if (parentInterface != null) {
                    childInterface = parentInterface[widgetChildId];
                }

                if (childInterface != null) {
                    switch (childInterface.type) {
                        case TEXT:
                            typeAsString = "TEXT";
                            break;
                        case GRAPHIC:
                            typeAsString = "GRAPHIC";
                            break;
                        case MODEL:
                            typeAsString = "MODEL";
                            break;
                        case RECTANGLE:
                            typeAsString = "RECTANGLE";
                            break;
                        case INVENTORY:
                            typeAsString = "INVENTORY";
                            break;
                        case LINE:
                            typeAsString = "LINE";
                            break;
                        case TEXT_INVENTORY:
                            typeAsString = "TEXT_INVENTORY";
                            break;
                        case LAYER:
                            typeAsString = "LAYER";
                            break;
                        case IF1_TOOLTIP:
                            typeAsString = "IF1_TOOLTIP";
                            break;
                        default:
                            typeAsString = "UNKNOWN";
                    }
                }
            }

            font.drawStringRight("Widget " + widgetParentId + ":" + widgetChildId, x, y, 0xffff00);
            y+= 15;
            if (childInterface != null) {
                font.drawStringRight("Parent ID: " + childInterface.parentId, x, y, 0xffff00);
                y+= 15;
                font.drawStringRight("Type: " + typeAsString, x, y, 0xffff00);
                y+= 15;
            }

        }
        if (MovedStatics.systemUpdateTime != 0) {
            int seconds = MovedStatics.systemUpdateTime / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if (seconds < 10) {
                font.drawString(English.systemUpdateIn + minutes + Native.prefixColonZero + seconds, 4, 329, 16776960);
            } else {
                font.drawString(English.systemUpdateIn + minutes + Native.colon + seconds, 4, 329, 16776960);
            }
        }
    }
}
