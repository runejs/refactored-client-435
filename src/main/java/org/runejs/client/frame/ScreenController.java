package org.runejs.client.frame;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceArea;
import org.runejs.client.frame.tab.TabProducer;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.outbound.chat.SetChatOptionsOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.*;
import org.runejs.client.*;

import java.awt.*;
import java.text.MessageFormat;

public class ScreenController {


    public static ScreenMode frameMode = null;
    public static int frameWidth = 765;
    public static int frameHeight = 540;
    public static int drawWidth = 765;
    public static int drawHeight = 540;
    public static Minimap minimap = new Minimap();
    public static TabProducer tabProducer = new TabProducer();
    private static Thread drawingThread;
    private static FrameRenderer renderer;
    public static boolean DebugView = false;


    public static void frameMode(ScreenMode screenMode) {
        if (frameMode != screenMode) {
            frameMode = screenMode;
            if (screenMode == ScreenMode.FIXED) {
                frameWidth = 765;
                frameHeight = 503;
                GameShell.clientFrame.setResizable(false);
                GameShell.clientFrame.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                GameShell.clientFrame.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
            } else if (screenMode == ScreenMode.RESIZABLE) {
                frameWidth = 900;
                frameHeight = 637;
                GameShell.clientFrame.setResizable(true);
                GameShell.clientFrame.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                GameShell.clientFrame.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));


            } else if (screenMode == ScreenMode.FULLSCREEN) {
                frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            }
            GameShell.clientFrame.setSize(ScreenController.frameWidth, ScreenController.frameHeight);
            Dimension innerSize = getInnerSize(GameShell.clientFrame);
            drawHeight = innerSize.height;
            drawWidth = innerSize.width;
            setBounds();

        }

    }

    public static void refreshFrameSize() {
        if(Class51.gameStatusCode == 5 || Class51.gameStatusCode == 10 || Class51.gameStatusCode == 20) {
            MovedStatics.clearScreen = true;
        }
        Class12.width = drawWidth;
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
        if (MouseHandler.gameCanvas == null) {
            return;
        }
        Dimension innerSize = getInnerSize(GameShell.clientFrame);
        drawHeight = innerSize.height;
        drawWidth = innerSize.width;
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 512 : drawWidth, frameMode == ScreenMode.FIXED ? 334 : drawHeight);
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(null);
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


        Scene.computeTileVisibilityMaps(500, 800, frameMode == ScreenMode.FIXED ? 512 : drawWidth, frameMode == ScreenMode.FIXED ? 334 : drawHeight, is);
        MouseHandler.gameCanvas.setSize(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight);

        if (Class51.gameStatusCode <= 35 && Class51.gameStatusCode >= 30) {
            MovedStatics.gameScreenImageProducer = MovedStatics.createGraphicsBuffer(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight, GameShell.clientFrame);
        } else {
            MouseHandler.gameCanvas.setSize(Class12.width, MovedStatics.height);
            MouseHandler.gameCanvas.setVisible(true);
            if (GameShell.clientFrame == null)
                MouseHandler.gameCanvas.setLocation(0, 0);
            else {
                Insets insets = GameShell.clientFrame.getInsets();
                MouseHandler.gameCanvas.setLocation(insets.left, insets.top);
            }//            Class38.loginBoxGraphics = Class40_Sub5_Sub13.createGraphicsBuffer(frameWidth, frameHeight, Class35.aFrame1732);
        }
    }

    public static void RenderResizableUI() {
        if (drawingThread == null) {
            renderer = new FrameRenderer(minimap, tabProducer);
            drawingThread = new Thread(renderer);
            drawingThread.start();
        }
        minimap.drawResizableMiniMapArea(drawWidth - 210, 0);
//        RenderTabArea(drawWidth - 234, drawHeight - (337));
        RenderChatArea(0, drawHeight - (162));

        tabProducer.drawResizableSideBarArea(drawWidth - 241, drawHeight - (334));

        if (DebugView) {
            int mX = MouseHandler.mouseX;
            int mY = MouseHandler.mouseY;

            int[] tabInterFaceCoords= tabProducer.getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));
            int[] tabInterFaceTop = tabProducer.getTopBarCoordSize(drawWidth - 241, drawHeight - (334));
            int[] tabInterFaceBottom = tabProducer.getBottomBarCoordSize(drawWidth - 241, drawHeight - (334));
            if (isCoordinatesIn3dScreen(mX, mY)) {
                Rasterizer.drawFilledRectangleAlpha(0, 0, drawWidth, drawHeight, 0x00FF00, 90);
            } else {
                Rasterizer.drawFilledRectangleAlpha(0, 0, drawWidth, drawHeight, 0xFF00FF, 90);
            }
            if (isCoordinatesInExtendedTabArea(mX, mY) && !isCoordinatesInTabArea(mX, mY)) {
                Rasterizer.drawFilledRectangleAlpha(tabInterFaceTop[0], tabInterFaceTop[1], tabInterFaceTop[2], tabInterFaceTop[3], 0x00FF00, 90);
                Rasterizer.drawFilledRectangleAlpha(tabInterFaceBottom[0], tabInterFaceBottom[1], tabInterFaceBottom[2], tabInterFaceBottom[3], 0x00FF00, 90);
            } else {
                Rasterizer.drawFilledRectangleAlpha(tabInterFaceTop[0], tabInterFaceTop[1], tabInterFaceTop[2], tabInterFaceTop[3], 0x0000FF, 90);
                Rasterizer.drawFilledRectangleAlpha(tabInterFaceBottom[0], tabInterFaceBottom[1], tabInterFaceBottom[2], tabInterFaceBottom[3], 0x0000FF, 90);
            }
            if (isCoordinatesInTabArea(mX, mY)) {
                Rasterizer.drawFilledRectangleAlpha(tabInterFaceCoords[0], tabInterFaceCoords[1], MovedStatics.tabImageProducer.width, MovedStatics.tabImageProducer.height, 0x00FF00, 90);
            } else {
                Rasterizer.drawFilledRectangleAlpha(tabInterFaceCoords[0], tabInterFaceCoords[1], MovedStatics.tabImageProducer.width, MovedStatics.tabImageProducer.height, 0x0000FF, 90);
            }
            if (isCoordinatesInExtendedChatArea(mX, mY) && !isCoordinatesInChatArea(mX, mY)) {
                Rasterizer.drawFilledRectangleAlpha(0, drawHeight - (162), 516, drawHeight, 0x00FF00, 90);
            } else {
                Rasterizer.drawFilledRectangleAlpha(0, drawHeight - (162), 516, drawHeight, 0x0000FF, 90);
            }
            if (isCoordinatesInChatArea(mX, mY)) {
                Rasterizer.drawFilledRectangleAlpha(17, drawHeight - (162) + 16, RSCanvas.chatBoxImageProducer.width, RSCanvas.chatBoxImageProducer.height, 0x00FF00, 90);
            } else {
                Rasterizer.drawFilledRectangleAlpha(17, drawHeight - (162) + 16, RSCanvas.chatBoxImageProducer.width, RSCanvas.chatBoxImageProducer.height, 0x0000FF, 90);
            }
            if (isCoordinatesInMinimapArea(mX, mY)) {
                Rasterizer.drawFilledRectangleAlpha(drawWidth - 210, 0, 210, 210, 0x00FF00, 90);
            } else {
                Rasterizer.drawFilledRectangleAlpha(drawWidth - 210, 0, 210, 210, 0x0000FF, 90);
            }


            Rasterizer.drawFilledRectangle(MouseHandler.mouseX - 4, MouseHandler.mouseY - 4, 4, 4, 0xFF0000);
        }

        if (MovedStatics.menuOpen) {
            MovedStatics.drawMenu(0, 0);
        }

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

    public static void RenderTabArea(int x, int y) {
        // height 337
        // width 234
        drawFramePiece(GameObject.tabPieceLeft, x + 212, y + 39);
        drawFramePieceCutout(MovedStatics.tabPieceUpperRight, x, y + 39, MovedStatics.tabPieceUpperRight.width - 15, MovedStatics.tabPieceUpperRight.height, 15, 0);
        drawFramePieceCutout(PlayerAppearance.tabPieveLowerRight, x, y + 191, PlayerAppearance.tabPieveLowerRight.width - 35, PlayerAppearance.tabPieveLowerRight.height, 35, 0);
        drawFramePieceCutout(Class17.chatboxTop, x, y + 172, Class17.chatboxTop.width - 531, Class17.chatboxTop.height, 531, 0);
        drawFramePieceCutout(RSCanvas.tabBottom, x, y + 300, RSCanvas.tabBottom.width - 35, RSCanvas.tabBottom.height, 35, 0);
        drawFramePieceCutout(InteractiveObject.tabTop, x, y, InteractiveObject.tabTop.width - 15, InteractiveObject.tabTop.height - 6, 15, 6);
        drawFramePiece(MovedStatics.tabImageProducer, x + 22, y + 39);


    }

    public static void RenderChatArea(int x, int y) {
        //width 516
        //height 184
        drawFramePiece(RSCanvas.chatBoxImageProducer, x + 17, y + 16);
        drawFramePiece(MovedStatics.chatModes, x, y + 112);
        drawFramePieceCutout(RSCanvas.tabBottom, x + 496, y + 125, 20, RSCanvas.tabBottom.height, 0, 0);
        drawFramePiece(MovedStatics.chatboxRight, x, y + 16);
        drawFramePieceCutout(Class17.chatboxTop, x, y, Class17.chatboxTop.width - 37, Class17.chatboxTop.height - 3, 0, 3);
        //        System.out.println(Class40_Sub5_Sub1.chatboxRight.height + (Class17.chatboxTop.height-3) + HuffmanEncoding.aProducingGraphicsBuffer_1541.height);

        drawFramePieceCutout(PlayerAppearance.tabPieveLowerRight, x + 496, y + 16, 20, PlayerAppearance.tabPieveLowerRight.height, 0, 0);


    }

    public static void drawFramePiece(ProducingGraphicsBuffer framePiece, int x, int y) {
        Rasterizer.copyPixels(framePiece.pixels, framePiece.width, framePiece.height, x, y);
    }

    public static void drawFramePieceCutout(ProducingGraphicsBuffer framePiece, int x, int y, int width, int height, int offsetX, int offsetY) {
        Rasterizer.copyPixelsCutOff(framePiece.pixels, framePiece.width, framePiece.height, x, y, width, height, offsetX, offsetY);
    }


    public static boolean isCoordinatesIn3dScreen(int x, int y) {
        if (frameMode == ScreenMode.FIXED) {
            return x > 4 && y > 4 && x < 516 && y < 338;
        } else {
            return x > 0 && y > 0 && x < drawWidth && y < drawHeight && !isCoordinatesInExtendedTabArea(x, y) && !isCoordinatesInTabArea(x, y) && !isCoordinatesInMinimapArea(x, y) && !isCoordinatesInExtendedChatArea(x, y);

        }
    }

    public static boolean isCoordinatesInTabArea(int x, int y) {
        if (frameMode == ScreenMode.FIXED) {
            return x > 553 && y > 205 && x < 743 && y < 466;
        } else {
            int[] tabInterFaceCoords= tabProducer.getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));

            int minX = tabInterFaceCoords[0];
            int minY = tabInterFaceCoords[1];
            int maxX = minX + tabInterFaceCoords[2];
            int maxY = minY + tabInterFaceCoords[3];
            return x > minX && y > minY && x < maxX && y < maxY;
        }
    }


    public static boolean isCoordinatesInExtendedTabArea(int x, int y) {
        int[] top = tabProducer.getTopBarCoordSize(drawWidth - 241, drawHeight - (334));
        int[] bottom = tabProducer.getBottomBarCoordSize(drawWidth - 241, drawHeight - (334));
        if(x > top[0] && x < top[0]+top[2] && y > top[1] && y < top[1]+top[3]) {
            return true;
        } else return x > bottom[0] && x < bottom[0] + bottom[2] && y > bottom[1] && y < bottom[1] + bottom[3];
    }

    public static boolean isCoordinatesInExtendedChatArea(int x, int y) {
        return x > 0 && y > drawHeight - 184 && x < 516;
    }

    public static boolean isCoordinatesInChatArea(int x, int y) {
        if (frameMode == ScreenMode.FIXED) {
            return x > 17 && y > 357 && x < 496 && y < 453;
        } else {
            int minX = 17;
            int minY = drawHeight - (162) + 16;
            int maxX = minX + RSCanvas.chatBoxImageProducer.width;
            int maxY = minY + RSCanvas.chatBoxImageProducer.height;
            return x > minX && y > minY && x < maxX && y < maxY;
        }

    }

    public static boolean isCoordinatesInMinimapArea(int x, int y) {
        if (frameMode == ScreenMode.FIXED) {
            return x > 575 && y < 156;
        } else {
            return x > drawWidth - 210 && y < 210;
        }
    }

    public static void handleTabClick(int mouseX, int mouseY) {
        if (frameMode == ScreenMode.FIXED) {
            if (GameInterface.tabAreaInterfaceId != -1)
                Class13.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, 553, 205, 743, 466, GameInterface.tabAreaInterfaceId);
            else if (Player.tabWidgetIds[Player.currentTabId] != -1) {
                Class13.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, 553, 205, 743, 466, Player.tabWidgetIds[Player.currentTabId]);
            }
        } else {
            int[] tabInterFaceCoords= tabProducer.getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));

            if (GameInterface.tabAreaInterfaceId != -1)
                Class13.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, tabInterFaceCoords[0], tabInterFaceCoords[1], tabInterFaceCoords[0]+tabInterFaceCoords[2],tabInterFaceCoords[1]+tabInterFaceCoords[3], GameInterface.tabAreaInterfaceId);
            else if (Player.tabWidgetIds[Player.currentTabId] != -1) {
                Class13.handleInterfaceActions(GameInterfaceArea.TAB_AREA, mouseX, mouseY, tabInterFaceCoords[0], tabInterFaceCoords[1], tabInterFaceCoords[0]+tabInterFaceCoords[2],tabInterFaceCoords[1]+tabInterFaceCoords[3], Player.tabWidgetIds[Player.currentTabId]);
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
            Class13.handleInterfaceActions(GameInterfaceArea.PERMANENT_CHAT_BOX_WIDGET, x, y, minX, minY, maxX, maxY, ChatBox.dialogueId);
            return;
        }

        // Handle interface actions for regular chat box widget
        if (GameInterface.chatboxInterfaceId != -1) {
            Class13.handleInterfaceActions(GameInterfaceArea.CHAT_AREA, x, y, minX, minY, maxX, maxY, GameInterface.chatboxInterfaceId);
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

            if (Item.obfuscatedKeyStatus[81] && InteractiveObject.playerRights > 1) {
                OutgoingPackets.buffer.putPacket(246);
                OutgoingPackets.buffer.putString(MessageFormat.format(" move {0} {1}", Integer.toString(destX + MovedStatics.baseX), Integer.toString(destY + Class26.baseY)));
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
                    PacketBuffer.closeAllWidgets();
                    if (MovedStatics.anInt854 != -1) {
                        MovedStatics.reportMutePlayer = false;
                        GameInterface.reportAbuseInterfaceID = GameInterface.gameScreenInterfaceId = MovedStatics.anInt854;
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
            if (x >= 0 && x <= 34 && y >= 1 && y < 37 && Player.tabWidgetIds[0] != -1) {
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                Player.currentTabId = 0;
            }
            if (x >= 30 && x <= 60 && y >= 0 && y < 37 && Player.tabWidgetIds[1] != -1) {
                Player.currentTabId = 1;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 58 && x <= 88 && y >= 0 && y < 37 && Player.tabWidgetIds[2] != -1) {
                GameInterface.drawTabIcons = true;
                Player.currentTabId = 2;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 86 && x <= 130 && y >= 0 && y < 35 && Player.tabWidgetIds[3] != -1) {
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                Player.currentTabId = 3;
            }
            if (x >= 127 && x <= 157 && y >= 0 && y < 37 && Player.tabWidgetIds[4] != -1) {
                Player.currentTabId = 4;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 155 && x <= 185 && y >= 0 && y < 37 && Player.tabWidgetIds[5] != -1) {
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
                Player.currentTabId = 5;
            }
            if (x >= 183 && x <= 217 && y >= 1 && y < 37 && Player.tabWidgetIds[6] != -1) {
                GameInterface.redrawTabArea = true;
                Player.currentTabId = 6;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 1 && x <= 35 && y >= 298 && y < 334 && Player.tabWidgetIds[7] != -1) {
                Player.currentTabId = 7;
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 33 && x <= 63 && y >= 298 && y < 335 && Player.tabWidgetIds[8] != -1) {
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                Player.currentTabId = 8;
            }
            if (x >= 60 && x <= 90 && y >= 298 && y < 335 && Player.tabWidgetIds[9] != -1) {
                GameInterface.drawTabIcons = true;
                Player.currentTabId = 9;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 88 && x <= 132 && y >= 299 && y < 334 && Player.tabWidgetIds[10] != -1) {
                Player.currentTabId = 10;
                GameInterface.drawTabIcons = true;
                GameInterface.redrawTabArea = true;
            }
            if (x >= 130 && x <= 160 && y >= 298 && y < 335 && Player.tabWidgetIds[11] != -1) {
                Player.currentTabId = 11;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            if (x >= 157 && x <= 187 && y >= 298 && y < 335 && Player.tabWidgetIds[12] != -1) {
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
                Player.currentTabId = 12;
            }
            if (x >= 185 && x <= 219 && y >= 298 && y < 334 && Player.tabWidgetIds[13] != -1) {
                Player.currentTabId = 13;
                GameInterface.redrawTabArea = true;
                GameInterface.drawTabIcons = true;
            }
            } else {
                if(isCoordinatesInExtendedTabArea(x, y)) {
                    tabProducer.clickTabButton(x,y, drawWidth - 241, drawHeight - (334));
                }
            }

        }
    }
}
