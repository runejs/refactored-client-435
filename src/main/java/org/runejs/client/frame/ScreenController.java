package org.runejs.client.frame;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceArea;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.RasterizerInstanced;
import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.outbound.chat.SetChatOptionsOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.*;

import java.awt.*;
import java.text.MessageFormat;

public class ScreenController {
    public static ScreenMode frameMode = null;
    public static int frameWidth = 765;
    public static int frameHeight = 540;
    public static int drawWidth = 765;
    public static int drawHeight = 540;
    public static ProducingGraphicsBuffer drawComponent;
    public static RasterizerInstanced rasterizer;

    private static FrameRenderer renderer;
    public static boolean DebugView = false;

    public static void setDrawComponent(Component component) {
        drawComponent = MovedStatics.createGraphicsBuffer(
            ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth,
            ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight,
            component
        );

        rasterizer = new RasterizerInstanced(drawComponent);

        if (renderer != null) {
            renderer.setRasterizer(rasterizer);
        }
    }

    public static void frameMode(ScreenMode screenMode) {
        if (frameMode != screenMode) {
            frameMode = screenMode;

            if (renderer != null) {
                renderer.stop();
            }

            if (screenMode == ScreenMode.FIXED) {
                frameWidth = 765;
                frameHeight = 503;
                GameShell.clientFrame.setResizable(false);
                GameShell.clientFrame.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                GameShell.clientFrame.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));

                renderer = new FixedFrameRenderer();
            } else if (screenMode == ScreenMode.RESIZABLE) {
                frameWidth = 900;
                frameHeight = 637;
                GameShell.clientFrame.setResizable(true);
                GameShell.clientFrame.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                GameShell.clientFrame.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));

                renderer = new ResizableFrameRenderer(rasterizer);
            } else if (screenMode == ScreenMode.FULLSCREEN) {
                frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

                renderer = new ResizableFrameRenderer(rasterizer);
            }
            GameShell.clientFrame.setSize(ScreenController.frameWidth, ScreenController.frameHeight);
            Dimension innerSize = getInnerSize(GameShell.clientFrame);
            drawHeight = innerSize.height;
            drawWidth = innerSize.width;
            setBounds();

        }

    }

    public static void refreshFrameSize() {
        if(Game.gameStatusCode == 5 || Game.gameStatusCode == 10 || Game.gameStatusCode == 20) {
            MovedStatics.clearScreen = true;
        }
        MovedStatics.width = drawWidth;
        MovedStatics.height = drawHeight;
        if (frameMode != ScreenMode.FIXED) {
            if (frameWidth != GameShell.clientFrame.getWidth()) {
                frameWidth = GameShell.clientFrame.getWidth();
                setBounds();
            }
            if (frameHeight != GameShell.clientFrame.getHeight()) {
                frameHeight = GameShell.clientFrame.getHeight();
                setBounds();
            }
        }
    }

    public static void setBounds() {
        if (Game.gameCanvas == null) {
            return;
        }
        Dimension innerSize = getInnerSize(GameShell.clientFrame);
        drawHeight = innerSize.height;
        drawWidth = innerSize.width;

        renderer.setDrawSize(drawWidth, drawHeight);

        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 512 : drawWidth, frameMode == ScreenMode.FIXED ? 334 : drawHeight);
        MovedStatics.fullScreenTextureArray = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 479 : drawWidth, frameMode == ScreenMode.FIXED ? 96 : drawHeight);
        // TODO rethink this, maybe its way easier than this
//        MovedStatics.chatboxLineOffsets = Rasterizer3D.setLineOffsets(null);
//        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 190 : drawWidth, frameMode == ScreenMode.FIXED ? 261 : drawHeight);
        MovedStatics.sidebarOffsets = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 765 : drawWidth, frameMode == ScreenMode.FIXED ? 503 : drawHeight);
        Player.viewportOffsets = Rasterizer3D.setLineOffsets(null);

        int[] is = new int[9];
        for (int i = 0; i < 9; i++) {
            int i_0_ = 15 + 32 * i + 128;
            int i_1_ = 3 * i_0_ + 600;
            int i_2_ = Rasterizer3D.sinetable[i_0_];
            is[i] = i_2_ * i_1_ >> 16;
        }


        Game.sceneRenderer.precalculateTileVisibility(frameMode == ScreenMode.FIXED ? 512 : drawWidth, frameMode == ScreenMode.FIXED ? 334 : drawHeight, 500, 800, is);
        Game.gameCanvas.setSize(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight);

        if (Game.gameStatusCode <= 35 && Game.gameStatusCode >= 30) {
            // set to resizable mode
            setDrawComponent(GameShell.clientFrame);
        } else {
            Game.gameCanvas.setSize(MovedStatics.width, MovedStatics.height);
            Game.gameCanvas.setVisible(true);
            if (GameShell.clientFrame == null)
                Game.gameCanvas.setLocation(0, 0);
            else {
                Insets insets = GameShell.clientFrame.getInsets();
                Game.gameCanvas.setLocation(insets.left, insets.top);
            }//            Class38.loginBoxGraphics = Class40_Sub5_Sub13.createGraphicsBuffer(frameWidth, frameHeight, Class35.aFrame1732);
        }
    }

    public static void drawFrame() {
        // create the render thread if required, and draw the output to screen
        int mX = MouseHandler.mouseX;
        int mY = MouseHandler.mouseY;

        renderer.draw(mX, mY, DebugView);
    }


    public static Dimension getInnerSize(Frame frame) {
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        if (insets != null) {
            size.height -= insets.top + insets.bottom;
            size.width -= insets.left + insets.right;
        }
        return size;
    }

    public static boolean isCoordinatesIn3dScreen(int x, int y) {
        return renderer.isCoordinatesIn3dScreen(x, y);
    }

    public static boolean isCoordinatesInTabArea(int x, int y) {
        return renderer.isCoordinatesInTabArea(x, y);
    }


    public static boolean isCoordinatesInExtendedTabArea(int x, int y) {
        return renderer.isCoordinatesInExtendedTabArea(x, y);
    }

    public static boolean isCoordinatesInExtendedChatArea(int x, int y) {
        return renderer.isCoordinatesInExtendedChatArea(x, y);
    }

    public static boolean isCoordinatesInChatArea(int x, int y) {
        return renderer.isCoordinatesInChatArea(x, y);
    }

    public static boolean isCoordinatesInMinimapArea(int x, int y) {
        return renderer.isCoordinatesInMinimapArea(x, y);
    }

    public static void handleTabClick(int mouseX, int mouseY) {
        if (frameMode == ScreenMode.FIXED) {
            if (GameInterface.tabAreaInterfaceId != -1)
                MovedStatics.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, 553, 205, 743, 466, GameInterface.tabAreaInterfaceId);
            else if (Game.tabWidgetIds[Game.currentTabId] != -1) {
                MovedStatics.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, 553, 205, 743, 466, Game.tabWidgetIds[Game.currentTabId]);
            }
        } else {
            int[] tabInterFaceCoords= renderer.getTabProducer().getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));

            if (GameInterface.tabAreaInterfaceId != -1)
                MovedStatics.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, tabInterFaceCoords[0], tabInterFaceCoords[1], tabInterFaceCoords[0]+tabInterFaceCoords[2],tabInterFaceCoords[1]+tabInterFaceCoords[3], GameInterface.tabAreaInterfaceId);
            else if (Game.tabWidgetIds[Game.currentTabId] != -1) {
                MovedStatics.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, tabInterFaceCoords[0], tabInterFaceCoords[1], tabInterFaceCoords[0]+tabInterFaceCoords[2],tabInterFaceCoords[1]+tabInterFaceCoords[3], Game.tabWidgetIds[Game.currentTabId]);
            }
        }
    }

    public static void handleChatBoxMouse(int x, int y) {
        int chatBoxWidth = 479;
        int chatBoxHeight = 96;
        int offsetBottom = 50; // Offset for the chat modes below the chat, and the chat bottom frame itself
        int offsetLeft = 17; // Offset from the left of the screen to account for chat left frame

        // Define chat box bounds as absolute screen coordinates (accounts for resizable)
        int minX = offsetLeft;
        int minY = drawHeight - offsetBottom - chatBoxHeight;
        int maxX = minX + chatBoxWidth;
        int maxY = minY + chatBoxHeight;

        // Chat being shown, and mouse is in usernames area
        if (GameInterface.chatboxInterfaceId == -1 && ChatBox.dialogueId == -1 && y < maxY - 21 && x < maxX - 70) {
            ClientScriptRunner.handleChatNamesRightClick(y - minY);
            return;
        }

        // Handle interface actions for permanent chat box widget. Takes precedence over regular chat box widgets
        if (ChatBox.dialogueId != -1) {
            MovedStatics.handleInterfaceActions(GameInterfaceArea.PERMANENT_CHAT_BOX_WIDGET, x, y, minX, minY, maxX, maxY, ChatBox.dialogueId);
            return;
        }

        // Handle interface actions for regular chat box widget
        if (GameInterface.chatboxInterfaceId != -1) {
            MovedStatics.handleInterfaceActions(GameInterfaceArea.CHAT_AREA, x, y, minX, minY, maxX, maxY, GameInterface.chatboxInterfaceId);
            return;
        }
    }


    public static void handleMinimapMouse() {
        if (Minimap.minimapState != 0) {
            return;
        }
        if (MouseHandler.clickType == 1) {
            int minimapClickX;
            int minimapClickY;
            if (frameMode == ScreenMode.FIXED) {
                minimapClickX = -575 + MouseHandler.clickX;
                minimapClickY = -5 + MouseHandler.clickY - 4;
                if (minimapClickX >= 0 && minimapClickY >= 0 && minimapClickX < 146 && minimapClickY < 151) {
                    minimapClickX -= 73;
                    minimapClickY -= 75;
                } else {
                    return;
                }

            } else {
                minimapClickX = -(frameWidth - 210) + MouseHandler.clickX;
                minimapClickY = -5 + MouseHandler.clickY - 4;
                if (minimapClickX >= 0 && minimapClickY >= 0 && minimapClickX < 204 && minimapClickY < 200) {
                    minimapClickX -= 107;
                    minimapClickY -= 100;
                } else {
                    return;
                }
            }
            int angle = 0x7ff & Game.getMinimapRotation();
            int sin = Rasterizer3D.sinetable[angle];
            int cos = Rasterizer3D.cosinetable[angle];

            int zoom = 0;

            cos = (zoom + 256) * cos >> 8;
            sin = (zoom + 256) * sin >> 8;
            int i_14_ = minimapClickY * sin + minimapClickX * cos >> 11;
            int i_15_ = cos * minimapClickY - minimapClickX * sin >> 11;
            int destX = Player.localPlayer.worldX + i_14_ >> 7;
            int destY = -i_15_ + Player.localPlayer.worldY >> 7;

            if (MovedStatics.obfuscatedKeyStatus[81] && Game.playerRights > 1) {
                OutgoingPackets.buffer.putPacket(246);
                OutgoingPackets.buffer.putString(MessageFormat.format(" move {0} {1}", Integer.toString(destX + MovedStatics.baseX), Integer.toString(destY + MovedStatics.baseY)));
            } else {
                Pathfinding.MinimapWalkAnalytics analytics = new Pathfinding.MinimapWalkAnalytics(
                    minimapClickX,
                    minimapClickY,
                    0, // current minimap zoom randomisation
                    0, // current minimap rotation randomisation
                    Game.playerCamera.getYaw(),
                    Player.localPlayer.worldX,
                    Player.localPlayer.worldY,
                    Pathfinding.arbitraryDestination == 1,
                    57,
                    89,
                    63
                );

                Pathfinding.doMinimapWalkTo(
                    Player.localPlayer.pathY[0], 
                    Player.localPlayer.pathX[0], 
                    destX, 
                    destY,
                    analytics
                );
            }
        }
    }

    public static void handleChatButtonsClick() {
        int x = MouseHandler.clickX;
        int y = MouseHandler.clickY;
        if (frameMode == ScreenMode.FIXED) {
            x -= 6;
            y -= 467;
        } else {
            x -= 6;
            y -= drawHeight - 36;
        }
        if (MouseHandler.clickType == 1) {
            if (x >= 0 && x <= 100 && y >= 0 && y <= 32) {
                MovedStatics.redrawChatbox = true;
                ChatBox.publicChatMode = (1 + ChatBox.publicChatMode) % 4;
                ChatBox.redrawChatbox = true;

                OutgoingPackets.sendMessage(new SetChatOptionsOutboundMessage(
                    ChatBox.publicChatMode,
                    ChatBox.privateChatMode,
                    ChatBox.tradeMode
                ));
            }
            if (x >= 129 && x <= 229 && y >= 0 && y <= 32) {
                ChatBox.redrawChatbox = true;
                ChatBox.privateChatMode = (ChatBox.privateChatMode + 1) % 3;
                MovedStatics.redrawChatbox = true;

                OutgoingPackets.sendMessage(new SetChatOptionsOutboundMessage(
                    ChatBox.publicChatMode,
                    ChatBox.privateChatMode,
                    ChatBox.tradeMode
                ));
            }
            if (x >= 267 && x <= 367 && y >= 0 && y <= 32) {
                ChatBox.tradeMode = (ChatBox.tradeMode + 1) % 3;
                MovedStatics.redrawChatbox = true;
                ChatBox.redrawChatbox = true;

                OutgoingPackets.sendMessage(new SetChatOptionsOutboundMessage(
                    ChatBox.publicChatMode,
                    ChatBox.privateChatMode,
                    ChatBox.tradeMode
                ));
            }
            if (x >= 406 && x <= 506 && y >= 0 && y <= 32) {
                if (GameInterface.gameScreenInterfaceId == -1) {
                    GameInterface.closeAllWidgets();
                    if (GameInterface.reportAbuseWidgetId != -1) {
                        MovedStatics.reportMutePlayer = false;
                        GameInterface.reportAbuseInterfaceID = GameInterface.gameScreenInterfaceId = GameInterface.reportAbuseWidgetId;
                        Native.reportedName = "";
                    }
                } else
                    ChatBox.addChatMessage("", English.pleaseCloseInterfaceBeforeReportAbuse, 0);
            }
        }
    }

    public static void handleTabClick() {
        int x = MouseHandler.clickX;
        int y = MouseHandler.clickY;


        if (MouseHandler.clickType == 1) {
            if(frameMode == ScreenMode.FIXED) {
                x -= 539;
                y -= 168;
            if (x >= 0 && x <= 34 && y >= 1 && y < 37 && Game.tabWidgetIds[0] != -1) {
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                Game.currentTabId = 0;
            }
            if (x >= 30 && x <= 60 && y >= 0 && y < 37 && Game.tabWidgetIds[1] != -1) {
                Game.currentTabId = 1;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 58 && x <= 88 && y >= 0 && y < 37 && Game.tabWidgetIds[2] != -1) {
                GameInterface.drawTabIcons = true;
                Game.currentTabId = 2;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 86 && x <= 130 && y >= 0 && y < 35 && Game.tabWidgetIds[3] != -1) {
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                Game.currentTabId = 3;
            }
            if (x >= 127 && x <= 157 && y >= 0 && y < 37 && Game.tabWidgetIds[4] != -1) {
                Game.currentTabId = 4;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 155 && x <= 185 && y >= 0 && y < 37 && Game.tabWidgetIds[5] != -1) {
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                Game.currentTabId = 5;
            }
            if (x >= 183 && x <= 217 && y >= 1 && y < 37 && Game.tabWidgetIds[6] != -1) {
                GameInterface.redrawTabArea = true;
                Game.currentTabId = 6;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 1 && x <= 35 && y >= 298 && y < 334 && Game.tabWidgetIds[7] != -1) {
                Game.currentTabId = 7;
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 33 && x <= 63 && y >= 298 && y < 335 && Game.tabWidgetIds[8] != -1) {
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                Game.currentTabId = 8;
            }
            if (x >= 60 && x <= 90 && y >= 298 && y < 335 && Game.tabWidgetIds[9] != -1) {
                GameInterface.drawTabIcons = true;
                Game.currentTabId = 9;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 88 && x <= 132 && y >= 299 && y < 334 && Game.tabWidgetIds[10] != -1) {
                Game.currentTabId = 10;
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 130 && x <= 160 && y >= 298 && y < 335 && Game.tabWidgetIds[11] != -1) {
                Game.currentTabId = 11;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 157 && x <= 187 && y >= 298 && y < 335 && Game.tabWidgetIds[12] != -1) {
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                Game.currentTabId = 12;
            }
            if (x >= 185 && x <= 219 && y >= 298 && y < 334 && Game.tabWidgetIds[13] != -1) {
                Game.currentTabId = 13;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            } else {
                if(isCoordinatesInExtendedTabArea(x, y)) {
                    renderer.getTabProducer().clickTabButton(x,y, drawWidth - 241, drawHeight - (334));
                }
            }

        }
    }
}
