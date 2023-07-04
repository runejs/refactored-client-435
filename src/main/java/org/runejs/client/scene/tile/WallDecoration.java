package org.runejs.client.scene.tile;

import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.node.NodeCache;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.*;

import java.awt.*;

public class WallDecoration {
    public static int durationHoveredOverWidget = 0;
    public static NodeCache modelCache = new NodeCache(50);
    public static TypeFace fontNormal;
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the right-hand side of the top,
     * but not the furthest-right (see `tabHighlightImageTopRightEdge` for that).
     */
    public static IndexedImage tabHighlightImageTopRight;

    public int configBits;
    public int z;
    public Renderable renderable;
    public int face;
    public int config = 0;
    public int y;
    public int x;
    public int hash = 0;

    public static void drawLoadingScreen(TypeFace fontBold, TypeFace fontSmall) {
        MovedStatics.loginBoxGraphics.prepareRasterizer();
//            Rasterizer.drawFilledRectangle(0,0, ScreenController.frameWidth, ScreenController.frameHeight, 0);
        if (Class51.gameStatusCode == 0 || Class51.gameStatusCode == 5) {
            int i = 20;
            fontBold.drawStringLeft(English.gameIsLoadingPleaseWait, 180, 74 + -i, 16777215);
            int i_89_ = -i + 82;
            Rasterizer.drawUnfilledRectangle(28, i_89_, 304, 34, 9179409);
            Rasterizer.drawUnfilledRectangle(29, 1 + i_89_, 302, 32, 0);
            Rasterizer.drawFilledRectangle(30, 2 + i_89_, MovedStatics.anInt1607 * 3, 30, 9179409);
            Rasterizer.drawFilledRectangle(3 * MovedStatics.anInt1607 + 30, i_89_ + 2, -(MovedStatics.anInt1607 * 3) + 300, 30, 0);
            fontBold.drawStringLeft(Native.currentLoadingText, 180, -i + 105, 16777215);
        }
        if (Class51.gameStatusCode == 20) {
            int drawY = 40;
            Class40_Sub5_Sub15.loginScreenBox.drawImage(0, 0);
            fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, drawY, 16776960, true);
            drawY += 15;
            fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, drawY, 16776960, true);
            drawY += 15;
            fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, drawY, 16776960, true);
            drawY += 15;
            drawY += 10;
            fontBold.drawShadowedString(English.username + Native.username, 90, drawY, true, 16777215);
            drawY += 15;
            fontBold.drawShadowedString(English.password + Native.password.method61(), 92, drawY, true, 16777215);
            drawY += 15;
        }
        if (Class51.gameStatusCode == 10) {
            Class40_Sub5_Sub15.loginScreenBox.drawImage(0, 0);
            if (Class26.loginScreenState == 0) {
                /*fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 80, 16776960, true);
                int drawX = 100;
                int drawY = 120;
                Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY - 20);
                fontBold.drawText(English.newUser, drawX + -73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);
                drawX = 260;
                Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY + -20);
                fontBold.drawText(English.existingUser, drawX - 73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);*/

                fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 40, 16776960, true);
                int i = 180;
                int i_92_ = 150;
                int i_93_ = 65;

                for(int textIndex = 0; textIndex < English.customLoginText.length; textIndex++) {
                    fontBold.drawShadowedStringCenter(English.customLoginText[textIndex], 180, i_93_, 16777215, true);
                    i_93_ += 15;
                }

                Class59.imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                fontBold.drawShadowedStringCenter(English.login, i, 5 + i_92_, 16777215, true);

            } else if (Class26.loginScreenState == 2) {
                int y1 = 40;
                int drawX = 100;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, y1, 16776960, true);
                y1 += 15;
                int y2 = 150;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, y1, 16776960, true);
                y1 += 15;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, y1, 16776960, true);
                y1 += 15;
                y1 += 10;
                int width = fontBold.getStringWidth(English.username + Native.username + Native.justAnotherYellowBar);
                int offset = 0;
                while (width > 250) {
                    offset++;
                    width = fontBold.getStringWidth(English.username + Native.username.substring(offset) + Native.justAnotherYellowBar);
                }
                fontBold.drawShadowedString(English.username + Native.username.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & MovedStatics.loginScreenFocus == 0 ? Native.justAnotherYellowBar : ""), 90, y1, true, 16777215);
                y1 += 15;
                String starredPassword = Native.password.method61().toString();
                width = fontBold.getStringWidth(English.password + starredPassword + Native.justAnotherYellowBar);
                offset = 0;
                while (width > 250) {
                    offset++;
                    width = fontBold.getStringWidth(English.password + starredPassword.substring(offset) + Native.justAnotherYellowBar);
                }
                fontBold.drawShadowedString(English.password + starredPassword.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & MovedStatics.loginScreenFocus == 1 ? Native.justAnotherYellowBar : ""), 92, y1, true, 16777215);
                Class59.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                y1 += 15;
                fontBold.drawShadowedStringCenter(English.login, drawX, y2 + 5, 16777215, true);
                drawX = 260;
                Class59.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                fontBold.drawShadowedStringCenter(English.cancel, drawX, 5 + y2, 16777215, true);
            } else if (Class26.loginScreenState == 3) {
                fontBold.drawShadowedStringCenter(English.createAFreeAccount, 180, 40, 16776960, true);
                int i = 180;
                int i_92_ = 150;
                int i_93_ = 65;

                for(int textIndex = 0; textIndex < English.createAccountText.length; textIndex++) {
                    fontBold.drawShadowedStringCenter(English.createAccountText[textIndex], 180, i_93_, 16777215, true);
                    i_93_ += 15;
                }

                Class59.imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                fontBold.drawShadowedStringCenter(English.cancel, i, 5 + i_92_, 16777215, true);
            }
        }

        ProducingGraphicsBuffer.muteButton.prepareRasterizer();
        ImageRGB musicIcon = TabParts.GetPart("music");

        if(ScreenController.frameMode == ScreenMode.RESIZABLE) {
            Rasterizer.drawFilledRectangle(0, 0, ScreenController.drawWidth, ScreenController.drawHeight, 0);
        }

        Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
        Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
        musicIcon.drawImage(4, 3);

        if(MusicSystem.musicVolume == 0) {
            Rasterizer.drawDiagonalLine(0,0, 42,42, 0xFF0000);
        }

        Main.renderFlames();

        try {
            int offsetX = 0;
            int offsetY = 0;
            if(ScreenController.frameMode == ScreenMode.RESIZABLE) {
                int drawWidth = ScreenController.drawWidth;
                int drawHeight = ScreenController.drawHeight;
                int middleX = drawWidth / 2;
                int middleY = drawHeight / 2;
                int loginScreenOffsetX = 765 / 2;
                int loginScreenOffsetY = 503 / 2;
                offsetX = middleX - loginScreenOffsetX;
                offsetY = middleY - loginScreenOffsetY;
            }
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            ProducingGraphicsBuffer.muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);

            MovedStatics.loginBoxGraphics.drawGraphics(offsetX + 202, offsetY + 171, graphics);
            MovedStatics.flameLeftBackground.drawGraphics(offsetX, offsetY, graphics);
            GameObject.flameRightBackground.drawGraphics(offsetX + 637, offsetY, graphics);

            if (!MovedStatics.clearScreen)
                return;
            MovedStatics.clearScreen = false;

            Class39.aProducingGraphicsBuffer_907.drawGraphics(offsetX + 128, offsetY, graphics);
            Class51.aProducingGraphicsBuffer_1206.drawGraphics(offsetX + 202, offsetY + 371, graphics);
            Class17.aProducingGraphicsBuffer_463.drawGraphics(offsetX, offsetY + 265, graphics);
            KeyFocusListener.aProducingGraphicsBuffer_1285.drawGraphics(offsetX + 562, offsetY + 265, graphics);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.drawGraphics(offsetX + 128, offsetY + 171, graphics);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.drawGraphics(offsetX + 562, offsetY + 171, graphics);
            ProducingGraphicsBuffer.muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);
        } catch (Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

}
