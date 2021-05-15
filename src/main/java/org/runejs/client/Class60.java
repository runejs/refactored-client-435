package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.Configuration;

public class Class60 {
    public static boolean aBoolean1402 = false;
    public static int anInt1413;
    public static int cameraVelocityVertical = 0;
    public static int anInt1417;

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

    public static void method989() {
        if(CollisionMap.aClass8_166 != null) {
            CollisionMap.aClass8_166.method213();
            CollisionMap.aClass8_166 = null;
        }
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
                Class40_Sub5_Sub17_Sub1.menuScreenArea = 0;
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
                Class40_Sub5_Sub17_Sub1.menuScreenArea = 1;
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
                Class40_Sub5_Sub17_Sub1.menuScreenArea = 2;
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
                        Class40_Sub5_Sub17_Sub1.menuScreenArea = 0;
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
        MovedStatics.method836(1);
        if(MouseHandler.clickType == 1 && RSString.clickY >= ScreenController.drawHeight-42 && Class57.clickX>=ScreenController.drawWidth-42 ){
            int newVolume = 0;
            if(RSCanvas.musicVolume == 0) {
                newVolume = 255;
            }
            if(RSCanvas.musicVolume != 0 || MouseHandler.currentSongId == -1) {
                if(newVolume == 0) {
                    Class33.method402(false);
                    Class35.songTimeout = 0;
                } else
                    MovedStatics.method456(newVolume);
            } else {
                Class33.method414(false, 0, MouseHandler.currentSongId, newVolume, 0, CacheArchive.musicCacheArchive);
                Class35.songTimeout = 0;
            }

            RSCanvas.musicVolume = newVolume;
        }

        if(Class51.gameStatusCode == 10) {
            int i = Class57.clickX + -202;
            int clickType = MouseHandler.clickType;
            int clickY = -171 + RSString.clickY;
            if(Class26.loginScreenState == 0) {
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
                    Class26.loginScreenState = 2;
                    MovedStatics.loginScreenFocus = 0;
                    Native.loginScreenMessageLineOne = "";
                    Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
                    Native.loginScreenMessageLineThree = "";
                }
            } else if(Class26.loginScreenState == 2) {
                int y = 60;
                int clickX = 100;
                y += 30;
                if(clickType == 1 && -15 + y <= clickY && clickY < y)
                    MovedStatics.loginScreenFocus = 0;
                int i_18_ = 150;
                y += 15;
                if(clickType == 1 && -15 + y <= clickY && y > clickY)
                    MovedStatics.loginScreenFocus = 1;
                y += 15;
                if(clickType == 1 && clickX + -75 <= i && i <= clickX + 75 && clickY >= i_18_ + -20 && clickY <= i_18_ + 20) {
                    Native.username = Native.username.method62().method85();
                    Class33.setLoginScreenMessage("", English.connectingToServer, "");
                    MovedStatics.processGameStatus(20);
                } else {
                    clickX = 260;
                    if(clickType == 1 && i >= -75 + clickX && clickX + 75 >= i && clickY >= -20 + i_18_ && clickY <= i_18_ + 20) {
                        Native.username = Configuration.getUsername();
                        Native.password = Configuration.getPassword();
                        Class26.loginScreenState = 0;
                    }
                    while(MovedStatics.method416((byte) -104)) {
                        boolean bool = false;
                        for(int i_19_ = 0; Native.supportedCharacters.length() > i_19_; i_19_++) {
                            if(Native.supportedCharacters.charAt(i_19_) == Class59.anInt1388) {
                                bool = true;
                                break;
                            }
                        }
                        if(MovedStatics.loginScreenFocus == 0) {
                            if(ItemDefinition.anInt2854 == 85 && Native.username.length() > 0)
                                Native.username = Native.username.substring(0, -1 + Native.username.length());
                            if(ItemDefinition.anInt2854 == 84 || ItemDefinition.anInt2854 == 80)
                                MovedStatics.loginScreenFocus = 1;
                            if(bool && Native.username.length() < 18)
                                Native.username = Native.username.addChar(Class59.anInt1388);
                        } else if(MovedStatics.loginScreenFocus == 1) {
                            if(ItemDefinition.anInt2854 == 85 && Native.password.length() > 0)
                                Native.password = Native.password.substring(0, Native.password.length() + -1);
                            if(ItemDefinition.anInt2854 == 80)
                                MovedStatics.loginScreenFocus = 0;
                            if(ItemDefinition.anInt2854 == 84) {
                                Native.username = Native.username.method62().method85();
                                Class33.setLoginScreenMessage("", English.connectingToServer, "");
                                MovedStatics.processGameStatus(20);
                            }
                            if(bool && Native.password.length() < 20)
                                Native.password = Native.password.addChar(Class59.anInt1388);
                        }
                    }
                }
            } else if(Class26.loginScreenState == 3) {
                int i_20_ = 150;
                int i_21_ = 180;
                if(clickType == 1 && i >= -75 + i_21_ && 75 + i_21_ >= i && -20 + i_20_ <= clickY && 20 + i_20_ >= clickY)
                    Class26.loginScreenState = 0;
            }
        }
    }

}
