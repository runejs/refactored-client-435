package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

public class Class60 {
    public static boolean aBoolean1402 = false;
    public static RSString aClass1_1411;
    public static int anInt1413;
    public static int cameraVelocityVertical;
    public static RSString aClass1_1416;
    public static int anInt1417;

    static {
        aClass1_1411 = RSString.CreateString("Error loading your profile)3");
        Player.localPlayerCount = 0;
        aClass1_1416 = aClass1_1411;
        cameraVelocityVertical = 0;
    }

    public static int method988(CacheIndex arg0, CacheIndex arg1) {
        int i = 0;
        if(arg0.method194(SceneCluster.aClass1_772, Native.string_blank, -1234))
            i++;
        if(arg1.method194(Main.aClass1_1762, Native.string_blank, -1234))
            i++;
        if(arg1.method194(AnimationSequence.aClass1_2488, Native.string_blank, -1234))
            i++;
        if(arg1.method194(ISAAC.aClass1_506, Native.string_blank, -1234))
            i++;
        if(arg1.method194(Class8.aClass1_299, Native.string_blank, -1234))
            i++;
        return i;
    }

    public static void method989(boolean arg0) {
        if(CollisionMap.aClass8_166 != null) {
            CollisionMap.aClass8_166.method213();
            CollisionMap.aClass8_166 = null;
        }
    }

    public static void determineMenuSize() {
        int width = Class40_Sub5_Sub17_Sub6.fontBold.getStringWidth(Widget.str_Choose_Option);
        for(int i = 0; i < ActorDefinition.menuActionRow; i++) {
            int rowWidth = Class40_Sub5_Sub17_Sub6.fontBold.getTextDisplayedWidth(Landscape.menuActionTexts[i]);
            if((width < rowWidth))
                width = rowWidth;
        }
        width += 8;
        int height = ActorDefinition.menuActionRow * 15 + 21;
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
            int x = -(width / 2) + (-553 + Class57.clickX);
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
    }

    public static RSString method991(int arg0, long arg1) {
        if(arg1 <= 0L || arg1 >= 6582952005840035281L)
            return null;
        if(arg1 % 37L == 0)
            return null;
        long l = arg1;
        int i = 0;
        while(l != 0) {
            l /= 37L;
            i++;
        }
        byte[] is = new byte[i];
        while(arg1 != 0) {
            long l_10_ = arg1;
            arg1 /= 37L;
            is[--i] = CollisionMap.aByteArray169[(int) (-(arg1 * 37L) + l_10_)];
        }
        RSString class1 = new RSString();
        class1.chars = is;
        class1.length = is.length;
        return class1;
    }

    public static void method992(int arg0) {
        SceneCluster.aClass38_768.method443(-10115);
        for(int i = 0; i < 32; i++)
            GameShell.aLongArray4[i] = 0L;
        for(int i = 0; i < 32; i++)
            Class67.aLongArray1614[i] = 0L;
        Class40_Sub3.anInt2020 = 0;
        if(arg0 != 75)
            method994();
    }

    public static void method993(int arg0) {
        Class40_Sub6.method836(1);
        if(Class51.anInt1197 == 10) {
            int i = Class57.clickX + -202;
            int i_11_ = MouseHandler.clickType;
            int i_12_ = -171 + RSString.clickY;
            int i_13_ = -58 % ((-38 - arg0) / 59);
            if(Class26.anInt622 == 0) {
                int i_14_ = 100;
                int i_15_ = 120;
                if(i_11_ == 1 && i >= i_14_ - 75 && i_14_ + 75 >= i && i_12_ >= -20 + i_15_ && i_15_ + 20 >= i_12_) {
                    Node.anInt947 = 0;
                    Class26.anInt622 = 3;
                }
                i_14_ = 260;
                if(i_11_ == 1 && (i >= -75 + i_14_) && i <= 75 + i_14_ && (i_12_ >= -20 + i_15_) && (20 + i_15_ >= i_12_)) {
                    Class26.anInt622 = 2;
                    Node.anInt947 = 0;
                    Class22_Sub2.aClass1_1879 = Node.aClass1_967;
                    Class22_Sub2.aClass1_1896 = English.enterYourUsernameAndPassword;
                    Class22_Sub2.aClass1_1881 = Node.aClass1_951;
                }
            } else if(Class26.anInt622 == 2) {
                int i_16_ = 60;
                int i_17_ = 100;
                i_16_ += 30;
                if(i_11_ == 1 && (-15 + i_16_ <= i_12_) && (i_12_ < i_16_))
                    Node.anInt947 = 0;
                int i_18_ = 150;
                i_16_ += 15;
                if(i_11_ == 1 && (-15 + i_16_ <= i_12_) && i_16_ > i_12_)
                    Node.anInt947 = 1;
                i_16_ += 15;
                if(i_11_ == 1 && i_17_ + -75 <= i && i <= i_17_ + 75 && (i_12_ >= i_18_ + -20) && (i_12_ <= i_18_ + 20)) {
                    Native.username = Native.username.method62().method85();
                    Class33.method411(Node.aClass1_964, Node.aClass1_958, Class40_Sub5_Sub17_Sub1.aClass1_3009, (byte) 106);
                    OverlayDefinition.method559(20);
                } else {
                    i_17_ = 260;
                    if(i_11_ == 1 && i >= -75 + i_17_ && (i_17_ + 75 >= i) && (i_12_ >= -20 + i_18_) && (i_12_ <= i_18_ + 20)) {
                        Native.username = Configuration.getUsername();
                        Native.password = Configuration.getPassword();
                        Class26.anInt622 = 0;
                    }
                    while(Class34.method416((byte) -104)) {
                        boolean bool = false;
                        for(int i_19_ = 0; (Native.supportedCharacters.length() > i_19_); i_19_++) {
                            if(Native.supportedCharacters.getChar(i_19_) == Class59.anInt1388) {
                                bool = true;
                                break;
                            }
                        }
                        if(Node.anInt947 == 0) {
                            if((ItemDefinition.anInt2854 == 85) && (Native.username.length() > 0))
                                Native.username = (Native.username.substring(0, -1 + Native.username.length()));
                            if(ItemDefinition.anInt2854 == 84 || (ItemDefinition.anInt2854 == 80))
                                Node.anInt947 = 1;
                            if(bool && Native.username.length() < 12)
                                Native.username = Native.username.method70(Class59.anInt1388);
                        } else if(Node.anInt947 == 1) {
                            if(ItemDefinition.anInt2854 == 85 && Native.password.length() > 0)
                                Native.password = (Native.password.substring(0, Native.password.length() + -1));
                            if(ItemDefinition.anInt2854 == 84 || ItemDefinition.anInt2854 == 80)
                                Node.anInt947 = 0;
                            if(bool && Native.password.length() < 20)
                                Native.password = Native.password.method70(Class59.anInt1388);
                        }
                    }
                }
            } else if(Class26.anInt622 == 3) {
                int i_20_ = 150;
                int i_21_ = 180;
                if(i_11_ == 1 && (i >= -75 + i_21_) && 75 + i_21_ >= i && -20 + i_20_ <= i_12_ && (20 + i_20_ >= i_12_))
                    Class26.anInt622 = 0;
            }
        }
    }

    public static void method994() {
        aClass1_1411 = null;
        aClass1_1416 = null;
    }
}
