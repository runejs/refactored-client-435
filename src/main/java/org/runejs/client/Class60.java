package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.MusicSystem;
import org.runejs.Configuration;
import org.runejs.whitelabel.Images;

import java.awt.*;

public class Class60 {
    public static boolean DEBUG_DISPLAY_ALL_ACTION_ROWS = false;
    public static int anInt1417;
    public static int loginScreenState = 0;
    public static int loginScreenFocus = 0;

    static {
        Player.localPlayerCount = 0;
    }

    public static int method988(CacheArchive arg0, CacheArchive arg1) {
        int i = 0;
        if(arg0.method194(Native.titleImage, ""))
            i++;
        if(arg1.method194(Native.logo, ""))
            i++;
        if(arg1.method194(Native.titleBox, ""))
            i++;
        if(arg1.method194(Native.titleButton, ""))
            i++;
        if(arg1.method194(Native.runes, ""))
            i++;
        return i;
    }

    public static void determineMenuSize() {
        int width = TypeFace.fontBold.getStringWidth(English.chooseOption);
        for(int i = 0; i < ActorDefinition.menuActionRow; i++) {
            int rowWidth = TypeFace.fontBold.getTextDisplayedWidth(Landscape.menuActionTexts[i]);
            if(width < rowWidth)
                width = rowWidth;
        }
        width += 8;
        int height = ActorDefinition.menuActionRow * 15 + 21;
        if(ScreenController.frameMode == ScreenMode.FIXED){
            if(Class57.clickX > 4 && RSString.clickY > 4 && Class57.clickX < 516 && RSString.clickY < 338) {
                Projectile.menuScreenArea = 0;
                CollisionMap.menuHeight = ActorDefinition.menuActionRow * 15 + 22;
                MovedStatics.menuOpen = true;
                int x = -(width / 2) + -4 + Class57.clickX;
                VertexNormal.menuWidth = width;
                if(width + x > 512)
                    x = 512 - width;
                if(x < 0)
                    x = 0;
                InteractiveObject.menuOffsetX = x;
                int y = RSString.clickY + -4;
                if(y + height > 334)
                    y = 334 - height;
                if(y < 0)
                    y = 0;
                Main.menuOffsetY = y;
            }
            if(Class57.clickX > 553 && RSString.clickY > 205 && Class57.clickX < 743 && RSString.clickY < 466) {
                CollisionMap.menuHeight = 22 + 15 * ActorDefinition.menuActionRow;
                Projectile.menuScreenArea = 1;
                int y = -205 + RSString.clickY;
                int x = -(width / 2) + -553 + Class57.clickX;
                if(x < 0)
                    x = 0;
                else if(width + x > 190)
                    x = 190 - width;
                MovedStatics.menuOpen = true;
                InteractiveObject.menuOffsetX = x;
                if(y >= 0) {
                    if(height + y > 261)
                        y = -height + 261;
                } else
                    y = 0;
                VertexNormal.menuWidth = width;
                Main.menuOffsetY = y;
            }
            if(Class57.clickX > 17 && RSString.clickY > 357 && Class57.clickX < 496 && RSString.clickY < 453) {
                VertexNormal.menuWidth = width;
                Projectile.menuScreenArea = 2;
                CollisionMap.menuHeight = ActorDefinition.menuActionRow * 15 + 22;
                int y = RSString.clickY + -357;
                if(y >= 0) {
                    if(height + y > 96)
                        y = -height + 96;
                } else
                    y = 0;
                int x = -(width / 2) + -17 + Class57.clickX;
                MovedStatics.menuOpen = true;
                Main.menuOffsetY = y;
                if(x < 0)
                    x = 0;
                else if(x + width > 479)
                    x = -width + 479;
                InteractiveObject.menuOffsetX = x;
            }

        } else if(Class57.clickX > 0 && RSString.clickY > 0 && Class57.clickX < GameShell.clientFrame.getWidth() && RSString.clickY < GameShell.clientFrame.getHeight()) {
                        Projectile.menuScreenArea = 0;
            int x = -(width / 2) + -4 + Class57.clickX;
            if(width + x > GameShell.clientFrame.getWidth() - 4)
                x = GameShell.clientFrame.getWidth() - 4;
            if(x < 0)
                x = 0;
            int y = RSString.clickY + -4;
            if(y + height > GameShell.clientFrame.getHeight() - 4)
                y = GameShell.clientFrame.getHeight() - 4;
            if(y + height > ScreenController.frameHeight-22)
                y = ScreenController.frameHeight-22 - height;
            if(y < 0)
                y = 0;
            if(width + x > ScreenController.drawWidth)
                x = ScreenController.drawWidth - width;
            MovedStatics.menuOpen = true;
            InteractiveObject.menuOffsetX = x;
            Main.menuOffsetY = y;
            VertexNormal.menuWidth = width;
            CollisionMap.menuHeight = ActorDefinition.menuActionRow * 15 + 22;
        }
//        if(Class57.clickX > 553 && RSString.clickY > 205 && Class57.clickX < 743 && RSString.clickY < 466) {
//            CollisionMap.menuHeight = 22 + 15 * ActorDefinition.menuActionRow;
//            Class40_Sub5_Sub17_Sub1.menuScreenArea = 1;
//            int y = -205 + RSString.clickY;
//            int x = -(width / 2) + -553 + Class57.clickX;
//            if(x < 0)
//                x = 0;
//            else if(width + x > 190)
//                x = 190 - width;
//            Class4.menuOpen = true;
//            InteractiveObject.menuOffsetX = x;
//            if(y >= 0) {
//                if(height + y > 261)
//                    y = -height + 261;
//            } else
//                y = 0;
//            VertexNormal.menuWidth = width;
//            Main.menuOffsetY = y;
//        }
//        if(Class57.clickX > 17 && RSString.clickY > 357 && Class57.clickX < 496 && RSString.clickY < 453) {
//            VertexNormal.menuWidth = width;
//            Class40_Sub5_Sub17_Sub1.menuScreenArea = 2;
//            CollisionMap.menuHeight = ActorDefinition.menuActionRow * 15 + 22;
//            int y = RSString.clickY + -357;
//            if(y >= 0) {
//                if(height + y > 96)
//                    y = -height + 96;
//            } else
//                y = 0;
//            int x = -(width / 2) + -17 + Class57.clickX;
//            Class4.menuOpen = true;
//            Main.menuOffsetY = y;
//            if(x < 0)
//                x = 0;
//            else if(x + width > 479)
//                x = -width + 479;
//            InteractiveObject.menuOffsetX = x;
//        }
    }

    public static void method992() {
        SceneCluster.gameTimer.start();
        for(int i = 0; i < 32; i++)
            GameShell.tickSamples[i] = 0L;
        for(int i = 0; i < 32; i++)
            MovedStatics.tickSamples[i] = 0L;
        Class40_Sub3.ticksPerLoop = 0;
    }

    public static void updateLogin() {
        method836(1);

        if(MouseHandler.clickType == 1 && RSString.clickY >= ScreenController.drawHeight-42 && Class57.clickX>=ScreenController.drawWidth-42 ){
            int newVolume = 0;
            if(MusicSystem.musicVolume == 0) {
                newVolume = 255;
            }

            if(MusicSystem.musicVolume != 0 || MusicSystem.currentSongId == -1) {
                if(newVolume == 0) {
                    MusicSystem.method402(false);
                    MusicSystem.songTimeout = 0;
                } else {
                    MusicSystem.method412(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
                    MusicSystem.method456(newVolume);
                }
            } else {
                MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, newVolume, 0, CacheArchive.musicCacheArchive);
                MusicSystem.songTimeout = 0;
            }

            MusicSystem.musicVolume = newVolume;
            Configuration.setSoundMuted(newVolume == 0);

        }

        if(Class51.gameStatusCode == 10) {
            int i = Class57.clickX + -202;
            int clickType = MouseHandler.clickType;
            int clickY = -171 + RSString.clickY;
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
                            if(Native.supportedCharacters.charAt(i_19_) == Class59.anInt1388) {
                                bool = true;
                                break;
                            }
                        }
                        if(loginScreenFocus == 0) {
                            if(ItemDefinition.anInt2854 == 85 && Native.username.length() > 0)
                                Native.username = Native.username.substring(0, -1 + Native.username.length());
                            if(ItemDefinition.anInt2854 == 84 || ItemDefinition.anInt2854 == 80)
                                loginScreenFocus = 1;
                            if(bool && Native.username.length() < 18)
                                Native.username = Native.username.addChar(Class59.anInt1388);
                        } else if(loginScreenFocus == 1) {
                            if(ItemDefinition.anInt2854 == 85 && Native.password.length() > 0)
                                Native.password = Native.password.substring(0, Native.password.length() + -1);
                            if(ItemDefinition.anInt2854 == 80)
                                loginScreenFocus = 0;
                            if(ItemDefinition.anInt2854 == 84) {
                                Native.username = Native.username.method62().method85();
                                setLoginScreenMessage("", English.connectingToServer, "");
                                MovedStatics.processGameStatus(20);
                            }
                            if(bool && Native.password.length() < 20)
                                Native.password = Native.password.addChar(Class59.anInt1388);
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

                Class59.imgLoginScreenButton.drawImage(-73 + i, i_92_ - 20);
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
                Class59.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
                y1 += 15;
                fontBold.drawShadowedStringCenter(English.login, drawX, y2 + 5, 16777215, true);
                drawX = 260;
                Class59.imgLoginScreenButton.drawImage(-73 + drawX, y2 + -20);
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
                MovedStatics.anIntArray178[(i - 2 << 7) + i_0_] = 255;
        }
        for (int i_2_ = 0; i_2_ < 100; i_2_++) {
            int i_3_ = (int) (Math.random() * 124.0) + 2;
            int i_4_ = 128 + (int) (Math.random() * 128.0);
            int i_5_ = i_3_ + (i_4_ << 7);
            MovedStatics.anIntArray178[i_5_] = 192;
        }
        for (int i_6_ = 1; i_6_ < i - 1; i_6_++) {
            for (int i_7_ = 1; i_7_ < 127; i_7_++) {
                int i_8_ = i_7_ + (i_6_ << 7);
                SpotAnim.anIntArray3255[i_8_] = (MovedStatics.anIntArray178[i_8_ + 1] + MovedStatics.anIntArray178[i_8_ - 1] - (-MovedStatics.anIntArray178[-128 + i_8_] - MovedStatics.anIntArray178[128 + i_8_])) / 4;
            }
        }
        RSRuntimeException.anInt1641 += 128;
        if (RSRuntimeException.anInt1641 > Landscape.anIntArray1168.length) {
            RSRuntimeException.anInt1641 -= Landscape.anIntArray1168.length;
            int i_9_ = (int) (12.0 * Math.random());
            FramemapDefinition.method879(MovedStatics.aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
        }
        for (int i_10_ = 1; i_10_ < -1 + i; i_10_++) {
            for (int i_11_ = 1; i_11_ < 127; i_11_++) {
                int i_12_ = i_11_ + (i_10_ << 7);
                int i_13_ = -(Landscape.anIntArray1168[i_12_ + RSRuntimeException.anInt1641 & -1 + Landscape.anIntArray1168.length] / 5) + SpotAnim.anIntArray3255[i_12_ + 128];
                if (i_13_ < 0)
                    i_13_ = 0;
                MovedStatics.anIntArray178[i_12_] = i_13_;
            }
        }
        for (int i_14_ = 0; i_14_ < i + -1; i_14_++)
            Class17.anIntArray466[i_14_] = Class17.anIntArray466[i_14_ + 1];
        Class17.anIntArray466[i - arg0] = (int) (16.0 * Math.sin((double) MovedStatics.pulseCycle / 14.0) + 14.0 * Math.sin((double) MovedStatics.pulseCycle / 15.0) + 12.0 * Math.sin((double) MovedStatics.pulseCycle / 16.0));
        if (MovedStatics.anInt2452 > 0)
            MovedStatics.anInt2452 -= 4;
        if (IdentityKit.anInt2613 > 0)
            IdentityKit.anInt2613 -= 4;
        if (MovedStatics.anInt2452 == 0 && IdentityKit.anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if (i_15_ == 0)
                MovedStatics.anInt2452 = 1024;
            if (i_15_ == 1)
                IdentityKit.anInt2613 = 1024;
        }
    }

    public static void renderLoginScreen(Component arg0, CacheArchive huffmanCacheArchive, CacheArchive gameImageCacheArchive) {
        if (!ISAAC.aBoolean512) {
            MovedStatics.flameLeftBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            GameObject.flameRightBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            Class39.aProducingGraphicsBuffer_907 = MovedStatics.createGraphicsBuffer(509, 171, arg0);
            Rasterizer.resetPixels();
            Class51.aProducingGraphicsBuffer_1206 = MovedStatics.createGraphicsBuffer(360, 132, arg0);
            Rasterizer.resetPixels();
            MovedStatics.loginBoxGraphics = MovedStatics.createGraphicsBuffer(360, 200, arg0);
            Rasterizer.resetPixels();
            Class17.aProducingGraphicsBuffer_463 = MovedStatics.createGraphicsBuffer(202, 238, arg0);
            Rasterizer.resetPixels();
            KeyFocusListener.aProducingGraphicsBuffer_1285 = MovedStatics.createGraphicsBuffer(203, 238, arg0);
            Rasterizer.resetPixels();
            GameObjectDefinition.aProducingGraphicsBuffer_2524 = MovedStatics.createGraphicsBuffer(74, 94, arg0);
            Rasterizer.resetPixels();
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631 = MovedStatics.createGraphicsBuffer(75, 94, arg0);
            Rasterizer.resetPixels();
            ProducingGraphicsBuffer.muteButton = MovedStatics.createGraphicsBuffer(42, 42, arg0);
            Rasterizer.resetPixels();
            byte[] is = huffmanCacheArchive.method170("", Native.titleImage);
            ImageRGB titleImg = new ImageRGB(is, arg0);
            MovedStatics.flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(0, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-637, 0);
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(-128, 0);
            Class51.aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(-202, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(-202, -171);
            Class17.aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(0, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-562, -265);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(-128, -171);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-562, -171);
            int[] is_18_ = new int[titleImg.imageWidth];
            for (int i = 0; i < titleImg.imageHeight; i++) {
                for (int i_19_ = 0; i_19_ < titleImg.imageWidth; i_19_++)
                    is_18_[i_19_] = titleImg.pixels[i * titleImg.imageWidth + titleImg.imageWidth + -i_19_ - 1];
                for (int i_20_ = 0; i_20_ < titleImg.imageWidth; i_20_++)
                    titleImg.pixels[i_20_ + titleImg.imageWidth * i] = is_18_[i_20_];
            }
            MovedStatics.flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(382, 0);
            GameObject.flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-255, 0);
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(254, 0);
            Class51.aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(180, -371);
            MovedStatics.loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(180, -171);
            Class17.aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(382, -265);
            KeyFocusListener.aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-180, -265);
            GameObjectDefinition.aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(254, -171);
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-180, -171);
            ProducingGraphicsBuffer.muteButton.prepareRasterizer();
            ImageRGB musicIcon = TabParts.GetPart("music");
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            titleImg = HuffmanEncoding.method1028(gameImageCacheArchive, Native.logo, "");
            Class39.aProducingGraphicsBuffer_907.prepareRasterizer();
            // UNCOMMENT LINE UNDER FOR LOGO
            // class40_sub5_sub14_sub4.drawImage(-128 + 382 + -(class40_sub5_sub14_sub4.imageWidth / 2), 18);
            // Comment line under to remove custom logo:
            ImageRGB logo = Images.GetPart("logo");

            logo.drawImage(-128 + 382 + -(logo.imageWidth / 2), 18);

            Class40_Sub5_Sub15.loginScreenBox = Main.method359(Native.titleBox, "", gameImageCacheArchive);
            Class59.imgLoginScreenButton = Main.method359(Native.titleButton, "", gameImageCacheArchive);
            MovedStatics.aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(gameImageCacheArchive, Native.runes, "");

            Class39.aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for (int i = 0; i < 33920; i++)
                Class39.aClass40_Sub5_Sub14_Sub4_918.pixels[i] = MovedStatics.flameLeftBackground.pixels[i];
            for (int i = 0; i < 33920; i++)
                SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = GameObject.flameRightBackground.pixels[i];
            Class51.anIntArray1198 = new int[256];
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[i] = i * 262144;
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[64 + i] = 1024 * i + 16711680;
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[128 + i] = 16776960 + i * 4;
            for (int i = 0; i < 64; i++)
                Class51.anIntArray1198[i + 192] = 16777215;
            Renderable.anIntArray2865 = new int[256];
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i] = i * 1024;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 64] = 4 * i + 65280;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[128 + i] = i * 262144 + 65535;
            for (int i = 0; i < 64; i++)
                Renderable.anIntArray2865[i + 192] = 16777215;
            SpotAnim.anIntArray3248 = new int[256];
            for (int i = 0; i < 64; i++)
                SpotAnim.anIntArray3248[i] = i * 4;
            for (int i = 0; i < 64; i++)
                SpotAnim.anIntArray3248[64 + i] = 255 + i * 262144;
            for (int i = 0; i < 64; i++)
                SpotAnim.anIntArray3248[128 + i] = i * 1024 + 16711935;
            for (int i = 0; i < 64; i++)
                SpotAnim.anIntArray3248[192 + i] = 16777215;
            MovedStatics.anIntArray1013 = new int[256];
            MovedStatics.anIntArray1445 = new int[32768];
            Landscape.anIntArray1168 = new int[32768];
            FramemapDefinition.method879(null);
            SpotAnim.anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            MovedStatics.anIntArray178 = new int[32768];
            loginScreenState = 0;
            if (MusicSystem.musicVolume != 0 && !VertexNormal.lowMemory)
                MusicSystem.method412(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
            else
                MusicSystem.method405(10);
            UpdateServer.resetUpdateServerRequests(false);
            MovedStatics.clearScreen = true;
            ISAAC.aBoolean512 = true;
        }
    }
}
