package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.sound.MusicSystem;
import org.runejs.Configuration;
import org.runejs.client.util.BitUtils;
import org.runejs.whitelabel.Images;

import java.awt.*;

/**
 * The class that handles the login screen.
 */
public class LoginScreen {
    public static int loginScreenState = 0;
    public static int loginScreenFocus = 0;
    public static ProducingGraphicsBuffer muteButton;
    /**
     * Part of login screen
     */
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1631;
    /**
     * Part of login screen
     */
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1206;
    public static ProducingGraphicsBuffer flameRightBackground;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1285;
    /**
     * Something to do with flames, maybe
     */
	public static int anInt2452 = 0;
    /**
     * Something to do with flames, maybe
     */
    public static int anInt2613 = 0;
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray1013;
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray1198;
    public static int[] anIntArray2865;
    public static int[] anIntArray3248;
    public static ProducingGraphicsBuffer flameLeftBackground;
    /**
     * Something to do with flames, maybe
     */
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_918;
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray466 = new int[256];
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray178;
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2043;
    public static ProducingGraphicsBuffer loginBoxGraphics;
    public static IndexedImage loginScreenBox;
    public static IndexedImage imgLoginScreenButton;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_907;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_463;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2524;
    public static int[] anIntArray3255;
    public static int[] anIntArray1168;
    public static int anInt1641 = 0;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array535;
    public static int[] anIntArray1445;

    public static void updateLogin() {
        method836(1);

        if(MouseHandler.clickType == 1 && MouseHandler.clickY >= ScreenController.drawHeight-42 && MouseHandler.clickX>=ScreenController.drawWidth-42 ){
            int newVolume = 0;
            if(MusicSystem.musicVolume == 0) {
                newVolume = 255;
            }

            if(MusicSystem.musicVolume != 0 || MusicSystem.currentSongId == -1) {
                if(newVolume == 0) {
                    MusicSystem.method402(false);
                    MusicSystem.songTimeout = 0;
                } else {
                    MusicSystem.playLoginScreenMusic(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
                    MusicSystem.method456(newVolume);
                }
            } else {
                MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, newVolume, 0, CacheArchive.musicCacheArchive);
                MusicSystem.songTimeout = 0;
            }

            MusicSystem.musicVolume = newVolume;
            Configuration.setSoundMuted(newVolume == 0);

        }

        if(Game.gameStatusCode == 10) {
            int i = MouseHandler.clickX + -202;
            int clickType = MouseHandler.clickType;
            int clickY = -171 + MouseHandler.clickY;
            if(loginScreenState == 0) {
                /*int i_14_ = 100;
                int i_15_ = 120;
                if(clickType == 1 && i >= i_14_ - 75 && i_14_ + 75 >= i && clickY >= -20 + i_15_ && i_15_ + 20 >= clickY) {
                    MovedStatics.loginScreenFocus = 0;
                    Class26.loginScreenState = 3;
                }
                i_14_ = 260;
                if(clickType == 1 && i >= -75 + i_14_ && i <= 75 + i_14_ && clickY >= -20 + i_15_ && 20 + i_15_ >= clickY) {
                    Class26.loginScreenState = 2;
                    MovedStatics.loginScreenFocus = 0;
                    Native.loginScreenMessageLineOne = "";
                    Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
                    Native.loginScreenMessageLineThree = "";
                }*/
                int i_20_ = 150;
                int i_21_ = 180;
                if(clickType == 1 && i >= -75 + i_21_ && 75 + i_21_ >= i && -20 + i_20_ <= clickY && 20 + i_20_ >= clickY) {
                    loginScreenState = 2;
                    loginScreenFocus = 0;
                    Native.loginScreenMessageLineOne = "";
                    Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
                    Native.loginScreenMessageLineThree = "";
                }
            } else if(loginScreenState == 2) {
                int y = 60;
                int clickX = 100;
                y += 30;
                if(clickType == 1 && -15 + y <= clickY && clickY < y)
                    loginScreenFocus = 0;
                int i_18_ = 150;
                y += 15;
                if(clickType == 1 && -15 + y <= clickY && y > clickY)
                    loginScreenFocus = 1;
                y += 15;
                if(clickType == 1 && clickX + -75 <= i && i <= clickX + 75 && clickY >= i_18_ + -20 && clickY <= i_18_ + 20) {
                    Native.username = Native.username.method62().method85();
                    setLoginScreenMessage("", English.connectingToServer, "");
                    MovedStatics.processGameStatus(20);
                } else {
                    clickX = 260;
                    if(clickType == 1 && i >= -75 + clickX && clickX + 75 >= i && clickY >= -20 + i_18_ && clickY <= i_18_ + 20) {
                        Native.username = Configuration.getUsername();
                        Native.password = Configuration.getPassword();
                        loginScreenState = 0;
                    }
                    while(MovedStatics.method416()) {
                        boolean bool = false;
                        for(int i_19_ = 0; Native.supportedCharacters.length() > i_19_; i_19_++) {
                            if(Native.supportedCharacters.charAt(i_19_) == MovedStatics.anInt1388) {
                                bool = true;
                                break;
                            }
                        }
                        if(loginScreenFocus == 0) {
                            if(MovedStatics.anInt2854 == 85 && Native.username.length() > 0)
                                Native.username = Native.username.substring(0, -1 + Native.username.length());
                            if(MovedStatics.anInt2854 == 84 || MovedStatics.anInt2854 == 80)
                                loginScreenFocus = 1;
                            if(bool && Native.username.length() < 18)
                                Native.username = Native.username.addChar(MovedStatics.anInt1388);
                        } else if(loginScreenFocus == 1) {
                            if(MovedStatics.anInt2854 == 85 && Native.password.length() > 0)
                                Native.password = Native.password.substring(0, Native.password.length() + -1);
                            if(MovedStatics.anInt2854 == 80)
                                loginScreenFocus = 0;
                            if(MovedStatics.anInt2854 == 84) {
                                Native.username = Native.username.method62().method85();
                                setLoginScreenMessage("", English.connectingToServer, "");
                                MovedStatics.processGameStatus(20);
                            }
                            if(bool && Native.password.length() < 20)
                                Native.password = Native.password.addChar(MovedStatics.anInt1388);
                        }
                    }
                }
            } else if(loginScreenState == 3) {
                int i_20_ = 150;
                int i_21_ = 180;
                if(clickType == 1 && i >= -75 + i_21_ && 75 + i_21_ >= i && -20 + i_20_ <= clickY && 20 + i_20_ >= clickY)
                    loginScreenState = 0;
            }
        }
    }

    public static void drawLoadingScreen(TypeFace fontBold, TypeFace fontSmall) {
        loginBoxGraphics.prepareRasterizer();
//            Rasterizer.drawFilledRectangle(0,0, ScreenController.frameWidth, ScreenController.frameHeight, 0);
        if (Game.gameStatusCode == 0 || Game.gameStatusCode == 5) {
            int i = 20;
            fontBold.drawStringLeft(English.gameIsLoadingPleaseWait, 180, 74 + -i, 16777215);
            int i_89_ = -i + 82;
            Rasterizer.drawUnfilledRectangle(28, i_89_, 304, 34, 9179409);
            Rasterizer.drawUnfilledRectangle(29, 1 + i_89_, 302, 32, 0);
            Rasterizer.drawFilledRectangle(30, 2 + i_89_, Game.gameStartup.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer.drawFilledRectangle(3 * Game.gameStartup.loadingBarPercentage + 30, i_89_ + 2, -(Game.gameStartup.loadingBarPercentage * 3) + 300, 30, 0);
            fontBold.drawStringLeft(Game.gameStartup.currentLoadingText, 180, -i + 105, 16777215);
        }
        if (Game.gameStatusCode == 20) {
            int drawY = 40;
            loginScreenBox.drawImage(0, 0);
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
        if (Game.gameStatusCode == 10) {
            loginScreenBox.drawImage(0, 0);
            if (loginScreenState == 0) {
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

                imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                fontBold.drawShadowedStringCenter(English.login, i, 5 + i_92_, 16777215, true);

            } else if (loginScreenState == 2) {
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
                fontBold.drawShadowedString(English.username + Native.username.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & loginScreenFocus == 0 ? Native.justAnotherYellowBar : ""), 90, y1, true, 16777215);
                y1 += 15;
                String starredPassword = Native.password.method61().toString();
                width = fontBold.getStringWidth(English.password + starredPassword + Native.justAnotherYellowBar);
                offset = 0;
                while (width > 250) {
                    offset++;
                    width = fontBold.getStringWidth(English.password + starredPassword.substring(offset) + Native.justAnotherYellowBar);
                }
                fontBold.drawShadowedString(English.password + starredPassword.substring(offset) + (MovedStatics.pulseCycle % 40 < 20 & loginScreenFocus == 1 ? Native.justAnotherYellowBar : ""), 92, y1, true, 16777215);
                imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                y1 += 15;
                fontBold.drawShadowedStringCenter(English.login, drawX, y2 + 5, 16777215, true);
                drawX = 260;
                imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                fontBold.drawShadowedStringCenter(English.cancel, drawX, 5 + y2, 16777215, true);
            } else if (loginScreenState == 3) {
                fontBold.drawShadowedStringCenter(English.createAFreeAccount, 180, 40, 16776960, true);
                int i = 180;
                int i_92_ = 150;
                int i_93_ = 65;

                for(int textIndex = 0; textIndex < English.createAccountText.length; textIndex++) {
                    fontBold.drawShadowedStringCenter(English.createAccountText[textIndex], 180, i_93_, 16777215, true);
                    i_93_ += 15;
                }

                imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
                fontBold.drawShadowedStringCenter(English.cancel, i, 5 + i_92_, 16777215, true);
            }
        }

        muteButton.prepareRasterizer();
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

        renderFlames();

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
            Graphics graphics = Game.gameCanvas.getGraphics();
            muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);

            loginBoxGraphics.drawGraphics(offsetX + 202, offsetY + 171, graphics);
            flameLeftBackground.drawGraphics(offsetX, offsetY, graphics);
            flameRightBackground.drawGraphics(offsetX + 637, offsetY, graphics);

            if (!MovedStatics.clearScreen)
                return;
            MovedStatics.clearScreen = false;

            aProducingGraphicsBuffer_907.drawGraphics(offsetX + 128, offsetY, graphics);
            aProducingGraphicsBuffer_1206.drawGraphics(offsetX + 202, offsetY + 371, graphics);
            aProducingGraphicsBuffer_463.drawGraphics(offsetX, offsetY + 265, graphics);
            aProducingGraphicsBuffer_1285.drawGraphics(offsetX + 562, offsetY + 265, graphics);
            aProducingGraphicsBuffer_2524.drawGraphics(offsetX + 128, offsetY + 171, graphics);
            aProducingGraphicsBuffer_1631.drawGraphics(offsetX + 562, offsetY + 171, graphics);
            muteButton.drawGraphics(ScreenController.drawWidth-42, ScreenController.drawHeight-42, graphics);
        } catch (Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    public static void setLoginScreenMessage(String line1, String line2, String line3) {
        Native.loginScreenMessageLineOne = line1;
        Native.loginScreenMessageLineTwo = line2;
        Native.loginScreenMessageLineThree = line3;
    }

    /**
     * Login screen flames?
     */
    private static void method836(int arg0) {
        int i = 256;
        for (int i_0_ = 10; i_0_ < 117; i_0_++) {
            int i_1_ = (int) (Math.random() * 100.0);
            if (i_1_ < 50)
                anIntArray178[(i - 2 << 7) + i_0_] = 255;
        }
        for (int i_2_ = 0; i_2_ < 100; i_2_++) {
            int i_3_ = (int) (Math.random() * 124.0) + 2;
            int i_4_ = 128 + (int) (Math.random() * 128.0);
            int i_5_ = i_3_ + (i_4_ << 7);
            anIntArray178[i_5_] = 192;
        }
        for (int i_6_ = 1; i_6_ < i - 1; i_6_++) {
            for (int i_7_ = 1; i_7_ < 127; i_7_++) {
                int i_8_ = i_7_ + (i_6_ << 7);
                anIntArray3255[i_8_] = (anIntArray178[i_8_ + 1] + anIntArray178[i_8_ - 1] - (-anIntArray178[-128 + i_8_] - anIntArray178[128 + i_8_])) / 4;
            }
        }
        anInt1641 += 128;
        if (anInt1641 > anIntArray1168.length) {
            anInt1641 -= anIntArray1168.length;
            int i_9_ = (int) (12.0 * Math.random());
            method879(aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
        }
        for (int i_10_ = 1; i_10_ < -1 + i; i_10_++) {
            for (int i_11_ = 1; i_11_ < 127; i_11_++) {
                int i_12_ = i_11_ + (i_10_ << 7);
                int i_13_ = -(anIntArray1168[i_12_ + anInt1641 & -1 + anIntArray1168.length] / 5) + anIntArray3255[i_12_ + 128];
                if (i_13_ < 0)
                    i_13_ = 0;
                anIntArray178[i_12_] = i_13_;
            }
        }
        for (int i_14_ = 0; i_14_ < i + -1; i_14_++)
            anIntArray466[i_14_] = anIntArray466[i_14_ + 1];
        anIntArray466[i - arg0] = (int) (16.0 * Math.sin((double) MovedStatics.pulseCycle / 14.0) + 14.0 * Math.sin((double) MovedStatics.pulseCycle / 15.0) + 12.0 * Math.sin((double) MovedStatics.pulseCycle / 16.0));
        if (anInt2452 > 0)
            anInt2452 -= 4;
        if (anInt2613 > 0)
            anInt2613 -= 4;
        if (anInt2452 == 0 && anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if (i_15_ == 0)
                anInt2452 = 1024;
            if (i_15_ == 1)
                anInt2613 = 1024;
        }
    }

    public static void renderLoginScreen(Component arg0, CacheArchive huffmanCacheArchive, CacheArchive gameImageCacheArchive) {
        if (!MovedStatics.aBoolean512) {
            flameLeftBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            flameRightBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_907 = MovedStatics.createGraphicsBuffer(509, 171, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1206 = MovedStatics.createGraphicsBuffer(360, 132, arg0);
            Rasterizer.resetPixels();
            loginBoxGraphics = MovedStatics.createGraphicsBuffer(360, 200, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_463 = MovedStatics.createGraphicsBuffer(202, 238, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1285 = MovedStatics.createGraphicsBuffer(203, 238, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_2524 = MovedStatics.createGraphicsBuffer(74, 94, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1631 = MovedStatics.createGraphicsBuffer(75, 94, arg0);
            Rasterizer.resetPixels();
            muteButton = MovedStatics.createGraphicsBuffer(42, 42, arg0);
            Rasterizer.resetPixels();
            byte[] is = huffmanCacheArchive.getFileByName(Native.titleImage, "");
            ImageRGB titleImg = new ImageRGB(is, arg0);
            flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(0, 0);
            flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-637, 0);
            aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(-128, 0);
            aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(-202, -371);
            loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(-202, -171);
            aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(0, -265);
            aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-562, -265);
            aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(-128, -171);
            aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-562, -171);
            int[] is_18_ = new int[titleImg.imageWidth];
            for (int i = 0; i < titleImg.imageHeight; i++) {
                for (int i_19_ = 0; i_19_ < titleImg.imageWidth; i_19_++)
                    is_18_[i_19_] = titleImg.pixels[i * titleImg.imageWidth + titleImg.imageWidth + -i_19_ - 1];
                for (int i_20_ = 0; i_20_ < titleImg.imageWidth; i_20_++)
                    titleImg.pixels[i_20_ + titleImg.imageWidth * i] = is_18_[i_20_];
            }
            flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(382, 0);
            flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-255, 0);
            aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(254, 0);
            aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(180, -371);
            loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(180, -171);
            aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(382, -265);
            aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-180, -265);
            aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(254, -171);
            aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-180, -171);
            muteButton.prepareRasterizer();
            ImageRGB musicIcon = TabParts.GetPart("music");
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            titleImg = MovedStatics.method1028(gameImageCacheArchive, Native.logo, "");
            aProducingGraphicsBuffer_907.prepareRasterizer();
            // UNCOMMENT LINE UNDER FOR LOGO
            // class40_sub5_sub14_sub4.drawImage(-128 + 382 + -(class40_sub5_sub14_sub4.imageWidth / 2), 18);
            // Comment line under to remove custom logo:
            ImageRGB logo = Images.GetPart("logo");

            logo.drawImage(-128 + 382 + -(logo.imageWidth / 2), 18);

            loginScreenBox = Game.method359(Native.titleBox, "", gameImageCacheArchive);
            imgLoginScreenButton = Game.method359(Native.titleButton, "", gameImageCacheArchive);
            aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(gameImageCacheArchive, Native.runes, "");

            aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for (int i = 0; i < 33920; i++)
                aClass40_Sub5_Sub14_Sub4_918.pixels[i] = flameLeftBackground.pixels[i];
            for (int i = 0; i < 33920; i++)
                aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = flameRightBackground.pixels[i];
            anIntArray1198 = new int[256];
            for (int i = 0; i < 64; i++)
                anIntArray1198[i] = i * 262144;
            for (int i = 0; i < 64; i++)
                anIntArray1198[64 + i] = 1024 * i + 16711680;
            for (int i = 0; i < 64; i++)
                anIntArray1198[128 + i] = 16776960 + i * 4;
            for (int i = 0; i < 64; i++)
                anIntArray1198[i + 192] = 16777215;
            anIntArray2865 = new int[256];
            for (int i = 0; i < 64; i++)
                anIntArray2865[i] = i * 1024;
            for (int i = 0; i < 64; i++)
                anIntArray2865[i + 64] = 4 * i + 65280;
            for (int i = 0; i < 64; i++)
                anIntArray2865[128 + i] = i * 262144 + 65535;
            for (int i = 0; i < 64; i++)
                anIntArray2865[i + 192] = 16777215;
            anIntArray3248 = new int[256];
            for (int i = 0; i < 64; i++)
                anIntArray3248[i] = i * 4;
            for (int i = 0; i < 64; i++)
                anIntArray3248[64 + i] = 255 + i * 262144;
            for (int i = 0; i < 64; i++)
                anIntArray3248[128 + i] = i * 1024 + 16711935;
            for (int i = 0; i < 64; i++)
                anIntArray3248[192 + i] = 16777215;
            anIntArray1013 = new int[256];
            anIntArray1445 = new int[32768];
            anIntArray1168 = new int[32768];
            method879(null);
            anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            anIntArray178 = new int[32768];
            loginScreenState = 0;
            if (MusicSystem.musicVolume != 0 && !VertexNormal.lowMemory)
                MusicSystem.playLoginScreenMusic(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
            else
                MusicSystem.method405(10);
            Game.updateServerConnectionManager.updateServer.resetRequests(false);
            MovedStatics.clearScreen = true;
            MovedStatics.aBoolean512 = true;
        }
    }

    public static void method879(IndexedImage arg1) {
        int i = 0;
        for(/**/; i < anIntArray1168.length; i++)
            anIntArray1168[i] = 0;
        int i_19_ = 256;
        for(int i_20_ = 0; i_20_ < 5000; i_20_++) {
            int i_21_ = (int) ((double) i_19_ * (128.0 * Math.random()));
            anIntArray1168[i_21_] = (int) (256.0 * Math.random());
        }
        for(int i_22_ = 0; i_22_ < 20; i_22_++) {
            for(int i_23_ = 1; -1 + i_19_ > i_23_; i_23_++) {
                for(int i_24_ = 1; i_24_ < 127; i_24_++) {
                    int i_25_ = (i_23_ << 7) + i_24_;
                    anIntArray1445[i_25_] = (anIntArray1168[i_25_ - 128] + anIntArray1168[i_25_ + -1] + anIntArray1168[i_25_ + 1] + anIntArray1168[128 + i_25_]) / 4;
                }
            }
            int[] is = anIntArray1168;
            anIntArray1168 = anIntArray1445;
            anIntArray1445 = is;
        }
        if(arg1 != null) {
            int i_26_ = 0;
            for(int i_27_ = 0; arg1.imgHeight > i_27_; i_27_++) {
                for(int i_28_ = 0; i_28_ < arg1.imgWidth; i_28_++) {
                    if(arg1.imgPixels[i_26_++] != 0) {
                        int i_29_ = arg1.yDrawOffset + i_27_ + 16;
                        int i_30_ = arg1.xDrawOffset + i_28_ + 16;
                        int i_31_ = i_30_ + (i_29_ << 7);
                        anIntArray1168[i_31_] = 0;
                    }
                }
            }
        }
    }

    public static void renderFlames() {
        if (anInt2452 <= 0) {
            if (anInt2613 > 0) {
                for (int i = 0; i < 256; i++) {
                    if (anInt2613 > 768)
                        anIntArray1013[i] = method614(anIntArray1198[i], anIntArray3248[i], -anInt2613 + 1024);
                    else if (anInt2613 > 256)
                        anIntArray1013[i] = anIntArray3248[i];
                    else
                        anIntArray1013[i] = method614(anIntArray3248[i], anIntArray1198[i], -anInt2613 + 256);
                }
            } else {
                System.arraycopy(anIntArray1198, 0, anIntArray1013, 0, 256);
            }
        } else {
            for (int i = 0; i < 256; i++) {
                if (anInt2452 <= 768) {
                    if (anInt2452 > 256)
                        anIntArray1013[i] = anIntArray2865[i];
                    else
                        anIntArray1013[i] = method614(anIntArray2865[i], anIntArray1198[i], -anInt2452 + 256);
                } else
                    anIntArray1013[i] = method614(anIntArray1198[i], anIntArray2865[i], -anInt2452 + 1024);
            }
        }
        int i = 256;
        System.arraycopy(aClass40_Sub5_Sub14_Sub4_918.pixels, 0, flameLeftBackground.pixels, 0, 33920);
        int i_61_ = 0;
        int i_62_ = 1152;
        for (int i_63_ = 1; i - 1 > i_63_; i_63_++) {
            int i_64_ = (-i_63_ + i) * anIntArray466[i_63_] / i;
            int i_65_ = i_64_ + 22;
            if (i_65_ < 0)
                i_65_ = 0;
            i_61_ += i_65_;
            for (int i_66_ = i_65_; i_66_ < 128; i_66_++) {
                int i_67_ = anIntArray178[i_61_++];
                if (i_67_ != 0) {
                    int i_68_ = -i_67_ + 256;
                    int i_69_ = i_67_;
                    i_67_ = anIntArray1013[i_67_];
                    int i_70_ = flameLeftBackground.pixels[i_62_];
                    flameLeftBackground.pixels[i_62_++] = BitUtils.bitWiseAND(-16711936, BitUtils.bitWiseAND(i_67_, 16711935) * i_69_ + i_68_ * BitUtils.bitWiseAND(i_70_, 16711935)) + BitUtils.bitWiseAND(BitUtils.bitWiseAND(65280, i_70_) * i_68_ + i_69_ * BitUtils.bitWiseAND(65280, i_67_), 16711680) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += i_65_;
        }
        i_62_ = 1176;
        i_61_ = 0;

        for (int i_71_ = 0; i_71_ < 33920; i_71_++)
            flameRightBackground.pixels[i_71_] = aClass40_Sub5_Sub14_Sub4_2043.pixels[i_71_];
        for (int i_72_ = 1; i_72_ < -1 + i; i_72_++) {
            int i_73_ = (-i_72_ + i) * anIntArray466[i_72_] / i;
            int i_74_ = 103 + -i_73_;
            i_62_ += i_73_;
            for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
                int i_76_ = anIntArray178[i_61_++];
                if (i_76_ != 0) {
                    int i_77_ = i_76_;
                    int i_78_ = flameRightBackground.pixels[i_62_];
                    int i_79_ = 256 + -i_76_;
                    i_76_ = anIntArray1013[i_76_];
                    flameRightBackground.pixels[i_62_++] = BitUtils.bitWiseAND(i_77_ * BitUtils.bitWiseAND(65280, i_76_) + i_79_ * BitUtils.bitWiseAND(65280, i_78_), 16711680) + BitUtils.bitWiseAND(i_79_ * BitUtils.bitWiseAND(16711935, i_78_) + BitUtils.bitWiseAND(16711935, i_76_) * i_77_, -16711936) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += 128 - (i_74_ + i_73_);
            i_61_ += -i_74_ + 128;
        }
    }

    public static int method614(int arg1, int arg2, int arg3) {
        int i_7_ = 256 + -arg3;
        return (arg3 * (0xff00 & arg2) + i_7_ * (0xff00 & arg1) & 0xff0000) + (~0xff00ff & (0xff00ff & arg1) * i_7_ + arg3 * (0xff00ff & arg2)) >> 8;
    }

    public static void displayMessageForResponseCode(int responseCode) {
        if(responseCode == -3) {
            setLoginScreenMessage(English.connectionTimedOut, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == -2) {
            setLoginScreenMessage("", English.errorConnectingToServer, "");
        } else if(responseCode == -1) {
            setLoginScreenMessage(English.noResponseFromServer, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 3) {
            setLoginScreenMessage("", English.invalidUsernameOrPassword, "");
        } else if(responseCode == 4) {
            setLoginScreenMessage(English.yourAccountHasBeenDisabled, English.pleaseCheckYourMessageCenterForDetails, "");
        } else if(responseCode == 5) {
            setLoginScreenMessage(English.yourAccountIsAlreadyLoggedIn, English.tryAgainIn60Secs, "");
        } else if(responseCode == 6) {
            setLoginScreenMessage(English.gameHasBeenUpdated, English.pleaseReloadThisPage, "");
        } else if(responseCode == 7) {
            setLoginScreenMessage(English.theWorldIsFull, English.pleaseUseADifferentWorld, "");
        } else if(responseCode == 8) {
            setLoginScreenMessage(English.unableToConnect, English.loginServerOffline, "");
        } else if(responseCode == 9) {
            setLoginScreenMessage(English.loginLimitExceeded, English.tooManyConnectionsFromYourAddress, "");
        } else if(responseCode == 10) {
            setLoginScreenMessage(English.unableToConnect, English.badSessionId, "");
        } else if(responseCode == 11) {
            setLoginScreenMessage(English.weSuspectSomeoneKnowsYourPassword, English.pressChangeYourPasswordOnFrontPage, "");
        } else if(responseCode == 12) {
            setLoginScreenMessage(English.youNeedMembersAccountToLoginToThisWorld, English.pleaseSubscribeOrUseDifferentWorld, "");
        } else if(responseCode == 13) {
            setLoginScreenMessage(English.couldNotCompleteLogin, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 14) {
            setLoginScreenMessage(English.theServerIsBeingUpdated, English.pleaseWait1MinuteAndTryAgain, "");
        } else if(responseCode == 16) {
            setLoginScreenMessage(English.tooManyIncorrectLoginsFromYourAddress, English.pleaseWait5MinutesBeforeTryingAgain, "");
        } else if(responseCode == 17) {
            setLoginScreenMessage(English.youAreStandingInMembersOnlyArea, English.toPlayOnThisWorldMoveToFreeArea, "");
        } else if(responseCode == 18) {
            setLoginScreenMessage(English.accountLockedAsWeSuspectItHasBeenStolen, English.pressRecoverLockedAccountOnFrontPage, "");
        } else if(responseCode == 20) {
            setLoginScreenMessage(English.invalidLoginserverRequested, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 22) {
            setLoginScreenMessage(English.malformedLoginPacket, English.pleaseTryAgain, "");
        } else if(responseCode == 23) {
            setLoginScreenMessage(English.noReplyFromLoginserver, English.pleaseWait1MinuteAndTryAgain, "");
        } else if(responseCode == 24) {
            setLoginScreenMessage(English.errorLoadingYourProfile, English.pleaseContactCustomerSupport, "");
        } else if(responseCode == 25) {
            setLoginScreenMessage(English.unexpectedLoginserverResponse, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 26) {
            setLoginScreenMessage(English.thisComputersAddressHasBeenBlocked, English.asItWasUsedToBreakOurRules, "");
        } else if(responseCode == 27) {
            setLoginScreenMessage("", English.serviceUnavailable, "");
        } else {
            setLoginScreenMessage(English.unexpectedServerResponse, English.pleaseTryUsingDifferentWorld, "");
        }
        MovedStatics.processGameStatus(10);
    }
}
