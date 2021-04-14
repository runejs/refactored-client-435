package com.jagex.runescape.frame;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.tab.TabProducer;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Pathfinding;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.SceneCluster;

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
                frameHeight = 540;
                Class35.aFrame1732.setResizable(false);
                Class35.aFrame1732.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                Class35.aFrame1732.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
            } else if (screenMode == ScreenMode.RESIZABLE) {
                frameWidth = 900;
                frameHeight = 637;
                Class35.aFrame1732.setResizable(true);
                Class35.aFrame1732.setPreferredSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));
                Class35.aFrame1732.setMinimumSize(new Dimension(ScreenController.frameWidth, ScreenController.frameHeight));


            } else if (screenMode == ScreenMode.FULLSCREEN) {
                frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            }
            Class35.aFrame1732.setSize(ScreenController.frameWidth, ScreenController.frameHeight);
            Dimension innerSize = getInnerSize(Class35.aFrame1732);
            drawHeight = innerSize.height;
            drawWidth = innerSize.width;
            setBounds();

        }

    }

    public static void refreshFrameSize() {
        Class12.width = drawWidth;
        IdentityKit.height = drawHeight;
        if (frameMode != ScreenMode.FIXED) {
            if (frameWidth != Class35.aFrame1732.getWidth()) {
                frameWidth = Class35.aFrame1732.getWidth();
                setBounds();
            }
            if (frameHeight != Class35.aFrame1732.getHeight()) {
                frameHeight = Class35.aFrame1732.getHeight();
                setBounds();
            }
        }
    }

    public static void setBounds() {
        if (MouseHandler.gameCanvas == null) {
            return;
        }
        Dimension innerSize = getInnerSize(Class35.aFrame1732);
        drawHeight = innerSize.height;
        drawWidth = innerSize.width;
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 512 : drawWidth, frameMode == ScreenMode.FIXED ? 334 : drawHeight);
        Class24.fullScreenTextureArray = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 479 : drawWidth, frameMode == ScreenMode.FIXED ? 96 : drawHeight);
        MovedStatics.chatboxLineOffsets = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 190 : drawWidth, frameMode == ScreenMode.FIXED ? 261 : drawHeight);
        ActorDefinition.sidebarOffsets = Rasterizer3D.setLineOffsets(null);
        Rasterizer3D.prepare(null, frameMode == ScreenMode.FIXED ? 765 : drawWidth, frameMode == ScreenMode.FIXED ? 503 : drawHeight);
        Player.viewportOffsets = Rasterizer3D.setLineOffsets(null);

        int[] is = new int[9];
        for (int i = 0; i < 9; i++) {
            int i_0_ = 15 + 32 * i + 128;
            int i_1_ = 3 * i_0_ + 600;
            int i_2_ = Rasterizer3D.sinetable[i_0_];
            is[i] = i_2_ * i_1_ >> 16;
        }


        Scene.method95(500, 800, frameMode == ScreenMode.FIXED ? 512 : drawWidth, frameMode == ScreenMode.FIXED ? 334 : drawHeight, is);
        MouseHandler.gameCanvas.setSize(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight);

        if (Class51.currentAction <= 35 && Class51.currentAction >= 30) {
            VarbitDefinition.gameScreenImageProducer = Class40_Sub5_Sub13.createGraphicsBuffer(ScreenController.frameMode == ScreenMode.FIXED ? 512 : ScreenController.drawWidth, ScreenController.frameMode == ScreenMode.FIXED ? 334 : ScreenController.drawHeight, Class35.aFrame1732);
        } else {
            MouseHandler.gameCanvas.setSize(Class12.width, IdentityKit.height);
            MouseHandler.gameCanvas.setVisible(true);
            if (Class35.aFrame1732 == null)
                MouseHandler.gameCanvas.setLocation(0, 0);
            else {
                Insets insets = Class35.aFrame1732.getInsets();
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
            int mX = Class13.mouseX;
            int mY = Landscape.mouseY;

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


            Rasterizer.drawFilledRectangle(Class13.mouseX - 4, Landscape.mouseY - 4, 4, 4, 0xFF0000);
        }

        if (MovedStatics.menuOpen) {
            Class40_Sub5_Sub6.drawMenu(0, 0);
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
        drawFramePiece(HuffmanEncoding.aProducingGraphicsBuffer_1541, x, y + 112);
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
                Class13.handleInterfaceActions(1, mouseX, mouseY, 553, 205, 743, 466, GameInterface.tabAreaInterfaceId);
            else if (Player.tabWidgetIds[Player.currentTabId] != -1) {
                Class13.handleInterfaceActions(1, mouseX, mouseY, 553, 205, 743, 466, Player.tabWidgetIds[Player.currentTabId]);
            }
        } else {
            int[] tabInterFaceCoords= tabProducer.getTabInterfaceCoordSize(drawWidth - 241, drawHeight - (334));

            if (GameInterface.tabAreaInterfaceId != -1)
                Class13.handleInterfaceActions(1, mouseX, mouseY, tabInterFaceCoords[0], tabInterFaceCoords[1], tabInterFaceCoords[0]+tabInterFaceCoords[2],tabInterFaceCoords[1]+tabInterFaceCoords[3], GameInterface.tabAreaInterfaceId);
            else if (Player.tabWidgetIds[Player.currentTabId] != -1) {
                Class13.handleInterfaceActions(1, mouseX, mouseY, tabInterFaceCoords[0], tabInterFaceCoords[1], tabInterFaceCoords[0]+tabInterFaceCoords[2],tabInterFaceCoords[1]+tabInterFaceCoords[3], Player.tabWidgetIds[Player.currentTabId]);
            }
        }
    }

    public static void handleChatClick(int x, int y) {
        if (frameMode == ScreenMode.FIXED) {
            if (GameInterface.chatboxInterfaceId == -1) {
                if (ChatBox.dialogueId == -1) {
                    if (y < 434 && x < 426)
                        ClientScriptRunner.method873(y - 357, 45);
                } else
                    Class13.handleInterfaceActions(3, x, y, 17, 357, 496, 453, ChatBox.dialogueId);
            } else
                Class13.handleInterfaceActions(2, x, y, 17, 357, 496, 453, GameInterface.chatboxInterfaceId);
        } else {
            if (GameInterface.chatboxInterfaceId == -1) {
                if (ChatBox.dialogueId == -1) {
                    if (y < frameHeight - (112) && x < 426)
                        ClientScriptRunner.method873(y - (frameHeight - 162), 45);
                } else
                    Class13.handleInterfaceActions(3, x, y, 17, (frameHeight - 162), frameWidth - 496, frameHeight - 54, ChatBox.dialogueId);
            } else
                Class13.handleInterfaceActions(2, x, y, 17, (frameHeight - 162), frameWidth - 496, frameHeight - 54, GameInterface.chatboxInterfaceId);
        }

    }


    public static void handleMinimapMouse() {
        if (MovedStatics.minimapState != 0) {
            return;
        }
        if (MouseHandler.clickType == 1) {
            int x;
            int y;
            if (frameMode == ScreenMode.FIXED) {
                x = -575 + Class57.clickX;
                y = -5 + RSString.clickY - 4;
                if (x >= 0 && y >= 0 && x < 146 && y < 151) {
                    x -= 73;
                    y -= 75;
                } else {
                    return;
                }

            } else {
                x = -(frameWidth - 210) + Class57.clickX;
                y = -5 + RSString.clickY - 4;
                if (x >= 0 && y >= 0 && x < 204 && y < 200) {
                    x -= 107;
                    y -= 100;
                } else {
                    return;
                }
            }
            int angle = 0x7ff & Class43.cameraYawOffset + GroundItemTile.cameraHorizontal;
            int sin = Rasterizer3D.sinetable[angle];
            int cos = Rasterizer3D.cosinetable[angle];
            cos = (Class51.mapZoomOffset + 256) * cos >> 8;
            sin = (Class51.mapZoomOffset + 256) * sin >> 8;
            int i_14_ = y * sin + x * cos >> 11;
            int i_15_ = cos * y - x * sin >> 11;
            int destX = Player.localPlayer.worldX + i_14_ >> 7;
            int destY = -i_15_ + Player.localPlayer.worldY >> 7;

            if (Item.obfuscatedKeyStatus[81] && InteractiveObject.playerRights > 1) {
                SceneCluster.packetBuffer.putPacket(246);
                SceneCluster.packetBuffer.putString(MessageFormat.format(" move {0} {1}", Integer.toString(destX + SpotAnimDefinition.baseX), Integer.toString(destY + Class26.baseY)));
            } else {
                boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], destX, 0, true, 0, 0, Player.localPlayer.pathX[0], destY, 1);
                if (bool) {
                    SceneCluster.packetBuffer.putByte(x);
                    SceneCluster.packetBuffer.putByte(y);
                    SceneCluster.packetBuffer.putShortBE(GroundItemTile.cameraHorizontal);
                    SceneCluster.packetBuffer.putByte(57);
                    SceneCluster.packetBuffer.putByte(Class43.cameraYawOffset);
                    SceneCluster.packetBuffer.putByte(Class51.mapZoomOffset);
                    SceneCluster.packetBuffer.putByte(89);
                    SceneCluster.packetBuffer.putShortBE(Player.localPlayer.worldX);
                    SceneCluster.packetBuffer.putShortBE(Player.localPlayer.worldY);
                    SceneCluster.packetBuffer.putByte(Class40_Sub5_Sub15.arbitraryDestination);
                    SceneCluster.packetBuffer.putByte(63);
                }
            }
        }
    }

    public static void handleChatButtonsClick() {
        int x = Class57.clickX;
        int y = RSString.clickY;
        if (frameMode == ScreenMode.FIXED) {
            x -= 6;
            y -= 467;
        } else {
            x -= 6;
            y -= frameHeight - 54;
        }
        if (MouseHandler.clickType == 1) {
            if (x >= 0 && x <= 100 && y >= 0 && y <= 32) {
                MovedStatics.redrawChatbox = true;
                ChatBox.publicChatMode = (1 + ChatBox.publicChatMode) % 4;
                ChatBox.redrawChatbox = true;
                SceneCluster.packetBuffer.putPacket(32);
                SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
                SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
                SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
            }
            if (x >= 129 && x <= 229 && y >= 0 && y <= 32) {
                ChatBox.redrawChatbox = true;
                ChatBox.privateChatMode = (ChatBox.privateChatMode + 1) % 3;
                MovedStatics.redrawChatbox = true;
                SceneCluster.packetBuffer.putPacket(32);
                SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
                SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
                SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
            }
            if (x >= 267 && x <= 367 && y >= 0 && y <= 32) {
                ChatBox.tradeMode = (ChatBox.tradeMode + 1) % 3;
                MovedStatics.redrawChatbox = true;
                ChatBox.redrawChatbox = true;
                SceneCluster.packetBuffer.putPacket(32);
                SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
                SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
                SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
            }
            if (x >= 406 && x <= 506 && y >= 0 && y <= 32) {
                if (GameInterface.gameScreenInterfaceId == -1) {
                    PacketBuffer.closeAllWidgets();
                    if (MovedStatics.anInt854 != -1) {
                        MovedStatics.reportMutePlayer = false;
                        HuffmanEncoding.reportAbuseInterfaceID = GameInterface.gameScreenInterfaceId = MovedStatics.anInt854;
                        Native.reportedName = "";
                    }
                } else
                    ChatBox.addChatMessage("", English.pleaseCloseInterfaceBeforeReportAbuse, 0);
            }
        }
    }

    public static void handleTabClick() {
        int x = Class57.clickX;
        int y = RSString.clickY;


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
