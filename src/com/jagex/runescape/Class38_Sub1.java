package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

public class Class38_Sub1 extends Class38 {
    public static RSString aClass1_1905 = RSString.CreateString(" has logged out)3");
    public static int[] anIntArray1909 = new int[99];
    public static int[] anIntArray1916 = new int[50];
    public static RSString aClass1_1917 = RSString.CreateString("Attack");
    public static RSString aClass1_1918 = null;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1919;
    public static RSString aClass1_1921 = RSString.CreateString("b12_full");
    public static RSString aClass1_1922 = RSString.CreateString("Loaded sprites");
    public static int anInt1923 = 0;

    static {
        int i = 0;
        for(int i_27_ = 0; i_27_ < 99; i_27_++) {
            int i_28_ = i_27_ + 1;
            int i_29_ = (int) ((double) i_28_ + 300.0 * Math.pow(2.0, (double) i_28_ / 7.0));
            i += i_29_;
            anIntArray1909[i_27_] = i / 4;
        }
    }

    public int anInt1900;
    public int anInt1903;
    public long[] aLongArray1910 = new long[10];
    public int anInt1912;
    public long aLong1914;
    public int anInt1915;

    public Class38_Sub1() {
        method443(-10115);
    }

    public static void method445(int arg0) {
        if(CollisionMap.anInt165 != 0) {
            int i = 0;
            if(Class40_Sub5_Sub15.anInt2782 != 0)
                i = 1;
            for(int i_1_ = 0; i_1_ < 100; i_1_++) {
                if(Actor.chatMessages[i_1_] != null) {
                    int i_2_ = HuffmanEncoding.chatTypes[i_1_];
                    RSString class1 = Renderable.chatPlayerNames[i_1_];
                    if(class1 != null && class1.startsWith(Class51.whiteCrown))
                        class1 = class1.substring(5);
                    if(class1 != null && class1.startsWith(Widget.goldCrown))
                        class1 = class1.substring(5);
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || Class4.privateChatMode == 0 || (Class4.privateChatMode == 1 && Class40_Sub2.hasFriend(class1, arg0 + -42391)))) {
                        int i_3_ = 329 + -(13 * i);
                        i++;
                        if(Class13.mouseX > 4 && ((i_3_ + -10 < Landscape.mouseY + -4)) && ((-4 + Landscape.mouseY <= i_3_ + 3))) {
                            int i_4_ = 25 + (WallDecoration.fontNormal.getStringWidth(RSString.linkRSStrings((new RSString[]{Class40_Sub5_Sub6.aClass1_2458, Class12.aClass1_392, class1, (Actor.chatMessages[i_1_])}))));
                            if(i_4_ > 450)
                                i_4_ = 450;
                            if(Class13.mouseX < 4 + i_4_) {
                                if(InteractiveObject.playerRights >= 1) {
                                    OverlayDefinition.addActionRow(Class22_Sub1.aClass1_1865, 0, 0, 0, 2028, (RSString.linkRSStrings(new RSString[]{Class26.aClass1_620, class1})));
                                }
                                OverlayDefinition.addActionRow(Class38.aClass1_885, 0, 0, 0, 2051, (RSString.linkRSStrings(new RSString[]{Class26.aClass1_620, class1})));
                                OverlayDefinition.addActionRow(FloorDecoration.aClass1_591, 0, 0, 0, 2045, (RSString.linkRSStrings(new RSString[]{Class26.aClass1_620, class1})));
                            }
                        }
                        if(i >= 5)
                            return;
                    }
                    if((i_2_ == 5 || i_2_ == 6) && Class4.privateChatMode < 2 && ++i >= 5)
                        return;
                }
            }
            if(arg0 != 9767)
                anInt1923 = 48;
        }
    }

    public static boolean method446(Signlink arg0, int arg1, boolean arg2, byte arg3) {
        if(arg3 != 30)
            method448(47, -7, 96, -97, (byte) -6, -111, true, -110, 57, -36, -84, -42);
        if(!Class39.method452(arg0, (byte) 121, arg2))
            return false;
        if(arg1 > 0)
            RSString.aClass9_1684 = new Cache(arg1);
        return true;
    }

    public static void method447() {
        if(MouseHandler.clickType == 1) {
            if(Class57.clickX >= 539 && Class57.clickX <= 573 && RSString.clickY >= 169 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[0] != -1) {
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 0;
            }
            if(Class57.clickX >= 569 && Class57.clickX <= 599 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[1] != -1) {
                Class5.currentTabId = 1;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 597 && Class57.clickX <= 627 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[2] != -1) {
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 2;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 625 && Class57.clickX <= 669 && RSString.clickY >= 168 && RSString.clickY < 203 && Class40_Sub5_Sub11.tabWidgetIds[3] != -1) {
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 3;
            }
            if(Class57.clickX >= 666 && Class57.clickX <= 696 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[4] != -1) {
                Class5.currentTabId = 4;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 694 && Class57.clickX <= 724 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[5] != -1) {
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 5;
            }
            if(Class57.clickX >= 722 && Class57.clickX <= 756 && RSString.clickY >= 169 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[6] != -1) {
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 6;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 540 && Class57.clickX <= 574 && RSString.clickY >= 466 && RSString.clickY < 502 && Class40_Sub5_Sub11.tabWidgetIds[7] != -1) {
                Class5.currentTabId = 7;
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 572 && Class57.clickX <= 602 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[8] != -1) {
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 8;
            }
            if(Class57.clickX >= 599 && Class57.clickX <= 629 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[9] != -1) {
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 9;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 627 && Class57.clickX <= 671 && RSString.clickY >= 467 && RSString.clickY < 502 && Class40_Sub5_Sub11.tabWidgetIds[10] != -1) {
                Class5.currentTabId = 10;
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 669 && Class57.clickX <= 699 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[11] != -1) {
                Class5.currentTabId = 11;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 696 && Class57.clickX <= 726 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[12] != -1) {
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 12;
            }
            if(Class57.clickX >= 724 && Class57.clickX <= 758 && RSString.clickY >= 466 && RSString.clickY < 502 && Class40_Sub5_Sub11.tabWidgetIds[13] != -1) {
                Class5.currentTabId = 13;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
        }
    }

    public static boolean method448(int arg0, int arg1, int arg2, int arg3, byte arg4, int arg5, boolean arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        for(int i = 0; i < 104; i++) {
            for(int i_8_ = 0; i_8_ < 104; i_8_++) {
                Class57.anIntArrayArray1335[i][i_8_] = 0;
                Landscape.anIntArrayArray1175[i][i_8_] = 99999999;
            }
        }
        Class57.anIntArrayArray1335[arg2][arg9] = 99;
        int i = 0;
        int i_9_ = arg9;
        boolean bool = false;
        int i_10_ = 0;
        Landscape.anIntArrayArray1175[arg2][arg9] = 0;
        int i_11_ = arg2;
        Class24.anIntArray581[i] = arg2;
        if(arg4 < 91)
            return false;
        Wall.anIntArray351[i++] = arg9;
        int i_12_ = Class24.anIntArray581.length;
        int[][] is = (Landscape.aCollisionMapArray1167[Player.worldLevel].anIntArrayArray150);
        while(i_10_ != i) {
            i_9_ = Wall.anIntArray351[i_10_];
            i_11_ = Class24.anIntArray581[i_10_];
            i_10_ = (i_10_ + 1) % i_12_;
            if(i_11_ == arg3 && i_9_ == arg10) {
                bool = true;
                break;
            }
            if(arg5 != 0) {
                if(arg5 >= 5 && arg5 != 10 || !(Landscape.aCollisionMapArray1167[Player.worldLevel].method155(i_11_, false, arg5 + -1, arg10, i_9_, arg7, arg3))) {
                    if(arg5 < 10 && (Landscape.aCollisionMapArray1167[Player.worldLevel].method158(arg10, arg7, i_9_, arg3, i_11_, (byte) 122, -1 + arg5))) {
                        bool = true;
                        break;
                    }
                } else {
                    bool = true;
                    break;
                }
            }
            if(arg0 != 0 && arg8 != 0 && (Landscape.aCollisionMapArray1167[Player.worldLevel].method153(-24, arg8, arg3, arg0, arg10, arg1, i_9_, i_11_))) {
                bool = true;
                break;
            }
            int i_13_ = Landscape.anIntArrayArray1175[i_11_][i_9_] + 1;
            if(i_11_ > 0 && Class57.anIntArrayArray1335[-1 + i_11_][i_9_] == 0 && (0x1280108 & is[i_11_ - 1][i_9_]) == 0) {
                Class24.anIntArray581[i] = i_11_ - 1;
                Wall.anIntArray351[i] = i_9_;
                i = (1 + i) % i_12_;
                Class57.anIntArrayArray1335[-1 + i_11_][i_9_] = 2;
                Landscape.anIntArrayArray1175[i_11_ - 1][i_9_] = i_13_;
            }
            if(i_11_ < 103 && Class57.anIntArrayArray1335[i_11_ + 1][i_9_] == 0 && (is[1 + i_11_][i_9_] & 0x1280180) == 0) {
                Class24.anIntArray581[i] = i_11_ + 1;
                Wall.anIntArray351[i] = i_9_;
                i = (i + 1) % i_12_;
                Class57.anIntArrayArray1335[i_11_ + 1][i_9_] = 8;
                Landscape.anIntArrayArray1175[i_11_ + 1][i_9_] = i_13_;
            }
            if(i_9_ > 0 && Class57.anIntArrayArray1335[i_11_][i_9_ - 1] == 0 && (is[i_11_][-1 + i_9_] & 0x1280102) == 0) {
                Class24.anIntArray581[i] = i_11_;
                Wall.anIntArray351[i] = -1 + i_9_;
                Class57.anIntArrayArray1335[i_11_][-1 + i_9_] = 1;
                i = (i + 1) % i_12_;
                Landscape.anIntArrayArray1175[i_11_][i_9_ - 1] = i_13_;
            }
            if(i_9_ < 103 && Class57.anIntArrayArray1335[i_11_][i_9_ + 1] == 0 && (is[i_11_][i_9_ + 1] & 0x1280120) == 0) {
                Class24.anIntArray581[i] = i_11_;
                Wall.anIntArray351[i] = 1 + i_9_;
                Class57.anIntArrayArray1335[i_11_][i_9_ + 1] = 4;
                Landscape.anIntArrayArray1175[i_11_][1 + i_9_] = i_13_;
                i = (i + 1) % i_12_;
            }
            if(i_11_ > 0 && i_9_ > 0 && Class57.anIntArrayArray1335[-1 + i_11_][i_9_ - 1] == 0 && (is[i_11_ - 1][-1 + i_9_] & 0x128010e) == 0 && (0x1280108 & is[i_11_ + -1][i_9_]) == 0 && (is[i_11_][-1 + i_9_] & 0x1280102) == 0) {
                Class24.anIntArray581[i] = -1 + i_11_;
                Wall.anIntArray351[i] = i_9_ - 1;
                i = (i + 1) % i_12_;
                Class57.anIntArrayArray1335[i_11_ + -1][-1 + i_9_] = 3;
                Landscape.anIntArrayArray1175[-1 + i_11_][i_9_ + -1] = i_13_;
            }
            if(i_11_ < 103 && i_9_ > 0 && Class57.anIntArrayArray1335[i_11_ + 1][-1 + i_9_] == 0 && ((is[1 + i_11_][-1 + i_9_] & 0x1280183) == 0) && (is[i_11_ + 1][i_9_] & 0x1280180) == 0 && (0x1280102 & is[i_11_][-1 + i_9_]) == 0) {
                Class24.anIntArray581[i] = 1 + i_11_;
                Wall.anIntArray351[i] = i_9_ - 1;
                i = (i + 1) % i_12_;
                Class57.anIntArrayArray1335[1 + i_11_][-1 + i_9_] = 9;
                Landscape.anIntArrayArray1175[i_11_ + 1][-1 + i_9_] = i_13_;
            }
            if(i_11_ > 0 && i_9_ < 103 && Class57.anIntArrayArray1335[i_11_ + -1][i_9_ + 1] == 0 && ((0x1280138 & is[-1 + i_11_][1 + i_9_]) == 0) && (0x1280108 & is[i_11_ - 1][i_9_]) == 0 && (is[i_11_][i_9_ + 1] & 0x1280120) == 0) {
                Class24.anIntArray581[i] = -1 + i_11_;
                Wall.anIntArray351[i] = 1 + i_9_;
                Class57.anIntArrayArray1335[i_11_ - 1][1 + i_9_] = 6;
                Landscape.anIntArrayArray1175[-1 + i_11_][i_9_ + 1] = i_13_;
                i = (1 + i) % i_12_;
            }
            if(i_11_ < 103 && i_9_ < 103 && Class57.anIntArrayArray1335[1 + i_11_][1 + i_9_] == 0 && (0x12801e0 & is[i_11_ + 1][i_9_ + 1]) == 0 && (0x1280180 & is[1 + i_11_][i_9_]) == 0 && (is[i_11_][1 + i_9_] & 0x1280120) == 0) {
                Class24.anIntArray581[i] = 1 + i_11_;
                Wall.anIntArray351[i] = i_9_ + 1;
                i = (i + 1) % i_12_;
                Class57.anIntArrayArray1335[1 + i_11_][1 + i_9_] = 12;
                Landscape.anIntArrayArray1175[1 + i_11_][1 + i_9_] = i_13_;
            }
        }
        Class40_Sub5_Sub15.anInt2778 = 0;
        if(!bool) {
            if(!arg6)
                return false;
            int i_14_ = 1000;
            int i_15_ = 10;
            int i_16_ = 100;
            for(int i_17_ = arg3 + -i_15_; arg3 + i_15_ >= i_17_; i_17_++) {
                for(int i_18_ = -i_15_ + arg10; (arg10 + i_15_ >= i_18_); i_18_++) {
                    if(i_17_ >= 0 && i_18_ >= 0 && i_17_ < 104 && i_18_ < 104 && (Landscape.anIntArrayArray1175[i_17_][i_18_] < 100)) {
                        int i_19_ = 0;
                        int i_20_ = 0;
                        if(i_18_ < arg10)
                            i_19_ = arg10 - i_18_;
                        else if(i_18_ > arg10 - (-arg8 + 1))
                            i_19_ = i_18_ + -arg8 + -arg10 + 1;
                        if(i_17_ < arg3)
                            i_20_ = -i_17_ + arg3;
                        else if(-1 + arg0 + arg3 < i_17_)
                            i_20_ = i_17_ + (-arg0 + -arg3 + 1);
                        int i_21_ = i_19_ * i_19_ + i_20_ * i_20_;
                        if(i_14_ > i_21_ || (i_21_ == i_14_ && (((Landscape.anIntArrayArray1175[i_17_][i_18_]) < i_16_)))) {
                            i_9_ = i_18_;
                            i_14_ = i_21_;
                            i_11_ = i_17_;
                            i_16_ = (Landscape.anIntArrayArray1175[i_17_][i_18_]);
                        }
                    }
                }
            }
            if(i_14_ == 1000)
                return false;
            if(arg2 == i_11_ && arg9 == i_9_)
                return false;
            Class40_Sub5_Sub15.anInt2778 = 1;
        }
        i_10_ = 0;
        Class24.anIntArray581[i_10_] = i_11_;
        Wall.anIntArray351[i_10_++] = i_9_;
        int i_23_;
        int i_22_ = i_23_ = Class57.anIntArrayArray1335[i_11_][i_9_];
        while(i_11_ != arg2 || arg9 != i_9_) {
            if(i_22_ != i_23_) {
                i_23_ = i_22_;
                Class24.anIntArray581[i_10_] = i_11_;
                Wall.anIntArray351[i_10_++] = i_9_;
            }
            if((i_22_ & 0x1) != 0)
                i_9_++;
            else if((i_22_ & 0x4) != 0)
                i_9_--;
            if((i_22_ & 0x2) != 0)
                i_11_++;
            else if((i_22_ & 0x8) != 0)
                i_11_--;
            i_22_ = Class57.anIntArrayArray1335[i_11_][i_9_];
        }
        if(i_10_ > 0) {
            i_12_ = i_10_;
            if(i_12_ > 25)
                i_12_ = 25;
            i_10_--;
            int i_24_ = Wall.anIntArray351[i_10_];
            int i_25_ = Class24.anIntArray581[i_10_];
            if(arg11 == 0) {
                SceneCluster.packetBuffer.putPacket(73);
                SceneCluster.packetBuffer.putByte(3 + (i_12_ + i_12_));
            }
            if(arg11 == 1) {
                SceneCluster.packetBuffer.putPacket(236);
                SceneCluster.packetBuffer.putByte(14 + i_12_ + i_12_ + 3);
            }
            if(arg11 == 2) {
                SceneCluster.packetBuffer.putPacket(89);
                SceneCluster.packetBuffer.putByte(3 + (i_12_ + i_12_));
            }
            SceneCluster.packetBuffer.putShortLE(i_24_ + Class26.anInt635);
            SceneCluster.packetBuffer.putByte(Item.obfuscatedKeyStatus[82] ? 1 : 0);
            SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.anInt2307 + i_25_);
            VarbitDefinition.anInt2366 = Class24.anIntArray581[0];
            Class55.anInt1304 = Wall.anIntArray351[0];
            for(int i_26_ = 1; i_12_ > i_26_; i_26_++) {
                i_10_--;
                SceneCluster.packetBuffer.putByte(Class24.anIntArray581[i_10_] - i_25_);
                SceneCluster.packetBuffer.putByte(-i_24_ + Wall.anIntArray351[i_10_]);
            }
            return true;
        }
        return arg11 != 1;
    }

    public static void method449() {
        anIntArray1916 = null;
        aClass1_1918 = null;
        aClass1_1917 = null;
        anIntArray1909 = null;
        aClass40_Sub5_Sub14_Sub2_1919 = null;
        aClass1_1905 = null;
        aClass1_1922 = null;
        aClass1_1921 = null;
    }

    public static void method450(byte arg0) {
        if(Player.anInt3288 == 2) {
            if(arg0 >= -28)
                method445(-128);
            Class22_Sub1.method312(2 * ActorDefinition.anInt2404, (Class35.anInt1730 + (-Class26.anInt635 + Class4.anInt175 << 7)), ((Class68.anInt1637 + -SpotAnimDefinition.anInt2307) << 7) + Landscape.anInt1170, 4976905);
            if(ISAAC.anInt522 > -1 && Node.pulseCycle % 20 < 10)
                UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
        }
    }

    public void method444(int arg0) {
        int i = 36 / ((arg0 + 76) / 48);
        for(int i_0_ = 0; i_0_ < 10; i_0_++)
            aLongArray1910[i_0_] = 0L;
    }

    public void method443(int arg0) {
        anInt1915 = 256;
        anInt1903 = 0;
        anInt1912 = 1;
        aLong1914 = System.currentTimeMillis();
        for(int i = 0; i < 10; i++)
            aLongArray1910[i] = aLong1914;
        if(arg0 != -10115)
            aClass1_1921 = null;
    }

    public int method442(int arg0, int arg1, int arg2) {
        int i = anInt1912;
        anInt1912 = 1;
        int i_5_ = anInt1915;
        anInt1915 = 300;
        aLong1914 = System.currentTimeMillis();
        if(aLongArray1910[anInt1900] == 0L) {
            anInt1915 = i_5_;
            anInt1912 = i;
        } else if(aLong1914 > aLongArray1910[anInt1900])
            anInt1915 = (int) ((long) (arg0 * 2560) / (-aLongArray1910[anInt1900] + aLong1914));
        if(anInt1915 < 25)
            anInt1915 = 25;
        if(anInt1915 > 256) {
            anInt1915 = 256;
            anInt1912 = (int) ((long) arg0 - (aLong1914 - aLongArray1910[anInt1900]) / 10L);
        }
        if(arg0 < anInt1912)
            anInt1912 = arg0;
        aLongArray1910[anInt1900] = aLong1914;
        anInt1900 = (anInt1900 + 1) % 10;
        if(anInt1912 > 1) {
            for(int i_6_ = 0; i_6_ < 10; i_6_++) {
                if(aLongArray1910[i_6_] != 0L)
                    aLongArray1910[i_6_] = (long) anInt1912 + aLongArray1910[i_6_];
            }
        }
        if(anInt1912 < arg1)
            anInt1912 = arg1;
        Class43.method890((long) anInt1912, arg2 ^ ~0x2613);
        int i_7_ = 0;
        for(/**/; anInt1903 < 256; anInt1903 += anInt1915)
            i_7_++;
        anInt1903 &= 0xff;
        return i_7_;

    }
}
