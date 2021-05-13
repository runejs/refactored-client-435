package com.jagex.runescape.scene.tile;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.tab.parts.TabParts;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.net.PacketBuffer;

import java.awt.*;

public class WallDecoration {
    public static int durationHoveredOverWidget = 0;
    public static NodeCache modelCache = new NodeCache(50);
    public static TypeFace fontNormal;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1270;

    public int configBits;
    public int z;
    public Renderable renderable;
    public int face;
    public int config = 0;
    public int y;
    public int x;
    public int hash = 0;

    public static void method950(int soundId, int volume, int delay) {
        if (MovedStatics.anInt200 != 0 && volume != 0 && PacketBuffer.currentSound < 50) {
            IdentityKit.sound[PacketBuffer.currentSound] = soundId;
            ItemDefinition.soundVolume[PacketBuffer.currentSound] = volume;
            Class40_Sub3.soundDelay[PacketBuffer.currentSound] = delay;
            PacketBuffer.effects[PacketBuffer.currentSound] = null;
            MovedStatics.anIntArray1916[PacketBuffer.currentSound] = 0;
            PacketBuffer.currentSound++;
        }
    }

    public static void drawLoadingScreen(TypeFace fontBold, TypeFace fontSmall) {
        do {
            MovedStatics.loginBoxGraphics.prepareRasterizer();
//            Rasterizer.drawFilledRectangle(0,0, ScreenController.frameWidth, ScreenController.frameHeight, 0);
            if (Class51.gameStatusCode == 0 || Class51.gameStatusCode == 5) {
                int i = 20;
                fontBold.drawStringLeft(English.runeScapeIsLoadingPleaseWait, 180, 74 + -i, 16777215);
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
                    fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 80, 16776960, true);
                    int drawX = 100;
                    int drawY = 120;
                    Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY - 20);
                    fontBold.drawText(English.newUser, drawX + -73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);
                    drawX = 260;
                    Class59.imgLoginScreenButton.drawImage(drawX - 73, drawY + -20);
                    fontBold.drawText(English.existingUser, drawX - 73, -20 + drawY, 144, 40, 16777215, true, 1, 1, 0);
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
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            if(RSCanvas.musicVolume == 0) {
                Rasterizer.drawDiagonalLine(0,0, 42,42, 0xFF0000);
            }
            Main.renderFlames();
            try {



                Graphics graphics = MouseHandler.gameCanvas.getGraphics();
                ProducingGraphicsBuffer.muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);

                MovedStatics.loginBoxGraphics.drawGraphics(202, 171, graphics);
                Class8.flameLeftBackground.drawGraphics(0, 0, graphics);
                GameObject.flameRightBackground.drawGraphics(637, 0, graphics);

                if (!MovedStatics.clearScreen)
                    break;
                MovedStatics.clearScreen = false;

                Class39.aProducingGraphicsBuffer_907.drawGraphics(128, 0, graphics);
                Class51.aProducingGraphicsBuffer_1206.drawGraphics(202, 371, graphics);
                Class17.aProducingGraphicsBuffer_463.drawGraphics(0, 265, graphics);
                KeyFocusListener.aProducingGraphicsBuffer_1285.drawGraphics(562, 265, graphics);
                GameObjectDefinition.aProducingGraphicsBuffer_2524.drawGraphics(128, 171, graphics);
                ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.drawGraphics(562, 171, graphics);
                ProducingGraphicsBuffer.muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);


            } catch (Exception exception) {
                MouseHandler.gameCanvas.repaint();
            }
            break;

        } while (false);
    }

}
