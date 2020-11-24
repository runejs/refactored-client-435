package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

public class Class60 {
    public static boolean aBoolean1402 = false;
    public static int anInt1413;
    public static int cameraVelocityVertical = 0;
    public static int anInt1417;

    static {
        Player.localPlayerCount = 0;
    }

    public static int method988(CacheIndex arg0, CacheIndex arg1) {
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
        int width = Class40_Sub5_Sub17_Sub6.fontBold.getStringWidth(English.chooseOption);
        for(int i = 0; i < ActorDefinition.menuActionRow; i++) {
            int rowWidth = Class40_Sub5_Sub17_Sub6.fontBold.getTextDisplayedWidth(Landscape.menuActionTexts[i]);
            if(width < rowWidth)
                width = rowWidth;
        }
        width += 8;
        int height = ActorDefinition.menuActionRow * 15 + 21;
        if(ScreenController.frameMode == ScreenMode.FIXED){
            if(Class57.clickX > 4 && RSString.clickY > 4 && Class57.clickX < 516 && RSString.clickY < 338) {
                Class40_Sub5_Sub17_Sub1.menuScreenArea = 0;
                CollisionMap.menuHeight = ActorDefinition.menuActionRow * 15 + 22;
                Class4.menuOpen = true;
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
                Class4.menuOpen = true;
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
                Class4.menuOpen = true;
                Main.menuOffsetY = y;
                if(x < 0)
                    x = 0;
                else if(x + width > 479)
                    x = -width + 479;
                InteractiveObject.menuOffsetX = x;
            }

        } else if(Class57.clickX > 0 && RSString.clickY > 0 && Class57.clickX < Class35.aFrame1732.getWidth() && RSString.clickY < Class35.aFrame1732.getHeight()) {
            //            Class40_Sub5_Sub17_Sub1.menuScreenArea = 0;
            int x = -(width / 2) + -4 + Class57.clickX;
            if(width + x > Class35.aFrame1732.getWidth() - 4)
                x = Class35.aFrame1732.getWidth() - 4;
            if(x < 0)
                x = 0;
            int y = RSString.clickY + -4;
            if(y + height > Class35.aFrame1732.getHeight() - 4)
                y = Class35.aFrame1732.getHeight() - 4;
            if(y + height > ScreenController.frameHeight-22)
                y = ScreenController.frameHeight-22 - height;
            if(y < 0)
                y = 0;
            if(width + x > ScreenController.frameWidth)
                x = ScreenController.frameWidth - width;
            Class4.menuOpen = true;
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
        SceneCluster.aTimer_768.start();
        for(int i = 0; i < 32; i++)
            GameShell.aLongArray4[i] = 0L;
        for(int i = 0; i < 32; i++)
            Class67.aLongArray1614[i] = 0L;
        Class40_Sub3.anInt2020 = 0;
    }

    public static void updateLogin() {
        Class40_Sub6.method836(1);
        if(Class51.anInt1197 == 10) {
            int i = Class57.clickX + -202;
            int clickType = MouseHandler.clickType;
            int clickY = -171 + RSString.clickY;
            if(Class26.loginScreenState == 0) {
                int i_14_ = 100;
                int i_15_ = 120;
                if(clickType == 1 && i >= i_14_ - 75 && i_14_ + 75 >= i && clickY >= -20 + i_15_ && i_15_ + 20 >= clickY) {
                    Node.loginScreenFocus = 0;
                    Class26.loginScreenState = 3;
                }
                i_14_ = 260;
                if(clickType == 1 && i >= -75 + i_14_ && i <= 75 + i_14_ && clickY >= -20 + i_15_ && 20 + i_15_ >= clickY) {
                    Class26.loginScreenState = 2;
                    Node.loginScreenFocus = 0;
                    Native.loginScreenMessageLineOne = "";
                    Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
                    Native.loginScreenMessageLineThree = "";
                }
            } else if(Class26.loginScreenState == 2) {
                int y = 60;
                int clickX = 100;
                y += 30;
                if(clickType == 1 && -15 + y <= clickY && clickY < y)
                    Node.loginScreenFocus = 0;
                int i_18_ = 150;
                y += 15;
                if(clickType == 1 && -15 + y <= clickY && y > clickY)
                    Node.loginScreenFocus = 1;
                y += 15;
                if(clickType == 1 && clickX + -75 <= i && i <= clickX + 75 && clickY >= i_18_ + -20 && clickY <= i_18_ + 20) {
                    Native.username = Native.username.method62().method85();
                    Class33.setLoginScreenMessage("", English.connectingToServer, "");
                    OverlayDefinition.method559(20);
                } else {
                    clickX = 260;
                    if(clickType == 1 && i >= -75 + clickX && clickX + 75 >= i && clickY >= -20 + i_18_ && clickY <= i_18_ + 20) {
                        Native.username = Configuration.getUsername();
                        Native.password = Configuration.getPassword();
                        Class26.loginScreenState = 0;
                    }
                    while(Class34.method416((byte) -104)) {
                        boolean bool = false;
                        for(int i_19_ = 0; Native.supportedCharacters.length() > i_19_; i_19_++) {
                            if(Native.supportedCharacters.charAt(i_19_) == Class59.anInt1388) {
                                bool = true;
                                break;
                            }
                        }
                        if(Node.loginScreenFocus == 0) {
                            if(ItemDefinition.anInt2854 == 85 && Native.username.length() > 0)
                                Native.username = Native.username.substring(0, -1 + Native.username.length());
                            if(ItemDefinition.anInt2854 == 84 || ItemDefinition.anInt2854 == 80)
                                Node.loginScreenFocus = 1;
                            if(bool && Native.username.length() < 12)
                                Native.username = Native.username.addChar(Class59.anInt1388);
                        } else if(Node.loginScreenFocus == 1) {
                            if(ItemDefinition.anInt2854 == 85 && Native.password.length() > 0)
                                Native.password = Native.password.substring(0, Native.password.length() + -1);
                            if(ItemDefinition.anInt2854 == 80)
                                Node.loginScreenFocus = 0;
                            if(ItemDefinition.anInt2854 == 84) {
                                Native.username = Native.username.method62().method85();
                                Class33.setLoginScreenMessage("", English.connectingToServer, "");
                                OverlayDefinition.method559(20);
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
