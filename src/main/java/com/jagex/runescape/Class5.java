package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class Class5 {
    public static Class22 aClass22_189;
    public static RSString aClass1_193 = RSString.CreateString("Please contact customer support)3");
    public static int anInt194;
    public static int anInt195 = 1;
    public static RSString aClass1_196 = RSString.CreateString("backvmid3");
    public static int[] anIntArray198;
    public static int anInt199 = 0;
    public static int anInt200 = 127;
    public static RSString aClass1_203 = RSString.CreateString("mapmarker");
    public static RSString aClass1_204 = RSString.CreateString("red:");
    public static RSString aClass1_206 = RSString.CreateString(" )2> @lre@");
    public static int currentTabId = 3;

    public static void loadTerrainSubblock(int arg0, int arg2, int arg3, int arg4, int x, int arg6, int arg7, byte[] arg8, CollisionMap[] arg9) {
        for(int i = 0; i < 8; i++) {
            for(int y = 0; y < 8; y++) {
                if(x + i > 0 && i + x < 103 && arg0 + y > 0 && y + arg0 < 103)
                    arg9[arg4].clippingData[x + i][y + arg0] = HuffmanEncoding.method1021((arg9[arg4].clippingData[x + i][y + arg0]), -16777217);
            }
        }
        Buffer class40_sub1 = new Buffer(arg8);
        for(int i = 0; i < 4; i++) {
            for(int i_1_ = 0; i_1_ < 64; i_1_++) {
                for(int i_2_ = 0; i_2_ < 64; i_2_++) {
                    if(i == arg3 && i_1_ >= arg2 && 8 + arg2 > i_1_ && i_2_ >= arg6 && 8 + arg6 > i_2_)
                        Class48.method922(x + Class24.method338(arg7, false, i_1_ & 0x7, i_2_ & 0x7), arg7, class40_sub1, arg0 + Class33.method410(i_1_ & 0x7, 0x7 & i_2_, arg7, false), 0, 0, arg4);
                    else
                        Class48.method922(-1, 0, class40_sub1, -1, 0, 0, 0);
                }
            }
        }
    }

    public static void method163() {
        aClass1_196 = null;
        aClass1_204 = null;
        aClass1_206 = null;
        ChatBox.itemSearchResultIds = null;
        aClass22_189 = null;
        aClass1_203 = null;
        aClass1_193 = null;
        anIntArray198 = null;
    }

    public static void method164() {
        Renderable.handleSequences(ActorDefinition.openFullScreenWidgetId);
        if(UnderlayDefinition.openSecondaryWidgetId != -1)
            Renderable.handleSequences(UnderlayDefinition.openSecondaryWidgetId);
        anInt199 = 0;
        Class68_Sub1.aClass68_2213.method1046((byte) 90);
        Player.anIntArray3284 = Rasterizer3D.method708(Player.anIntArray3284);
        Rasterizer.clear();
        Class40_Sub5_Sub6.drawInterface(0, ActorDefinition.openFullScreenWidgetId, 503, (byte) -5, 0, 0, 765);
        if(UnderlayDefinition.openSecondaryWidgetId != -1)
            Class40_Sub5_Sub6.drawInterface(0, UnderlayDefinition.openSecondaryWidgetId, 503, (byte) -5, 0, 0, 765);
        if(!Class4.menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else
            Class40_Sub5_Sub6.drawMenu();
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            Class68_Sub1.aClass68_2213.drawGraphics(0, 0, graphics);
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static void method165(int arg0) {
        int i = 64 + SceneCluster.anInt767 * 128;
        int i_3_ = 64 + 128 * Class22.anInt545;
        int i_4_ = (Class37.getFloorDrawHeight(Player.worldLevel, i_3_, i) + -anInt194);
        if((i_3_ > Class12.cameraX)) {
            Class12.cameraX += (Class59.anInt1386 * (i_3_ + -Class12.cameraX) / 1000 + Class4.anInt188);
            if(Class12.cameraX > i_3_) {
                Class12.cameraX = i_3_;
            }
        }
        if((i_4_ > SceneCluster.cameraZ)) {
            SceneCluster.cameraZ += (Class59.anInt1386 * (i_4_ - SceneCluster.cameraZ) / 1000 + Class4.anInt188);
            if((i_4_ < SceneCluster.cameraZ))
                SceneCluster.cameraZ = i_4_;
        }
        if((Class12.cameraX > i_3_)) {
            Class12.cameraX -= Class4.anInt188 + (Class59.anInt1386 * (Class12.cameraX + -i_3_) / 1000);
            if(i_3_ > Class12.cameraX) {
                Class12.cameraX = i_3_;
            }
        }
        if((Class40_Sub5_Sub6.cameraY < i)) {
            Class40_Sub5_Sub6.cameraY += Class4.anInt188 + (Class59.anInt1386 * (-Class40_Sub5_Sub6.cameraY + i) / 1000);
            if((Class40_Sub5_Sub6.cameraY > i))
                Class40_Sub5_Sub6.cameraY = i;
        }
        if(SceneCluster.cameraZ > i_4_) {
            SceneCluster.cameraZ -= ((SceneCluster.cameraZ + -i_4_) * Class59.anInt1386 / 1000 + Class4.anInt188);
            if((i_4_ > SceneCluster.cameraZ))
                SceneCluster.cameraZ = i_4_;
        }
        i_3_ = 64 + HashTable.anInt564 * 128;
        if(Class40_Sub5_Sub6.cameraY > i) {
            Class40_Sub5_Sub6.cameraY -= Class4.anInt188 + (Class59.anInt1386 * (Class40_Sub5_Sub6.cameraY - i) / 1000);
            if(Class40_Sub5_Sub6.cameraY < i)
                Class40_Sub5_Sub6.cameraY = i;
        }
        i = UnderlayDefinition.anInt2576 * 128 + 64;
        i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, i_3_, i) - Class38.anInt892;
        int i_5_ = -SceneCluster.cameraZ + i_4_;
        int i_6_ = i - Class40_Sub5_Sub6.cameraY;
        int i_7_ = i_3_ - Class12.cameraX;
        int i_8_ = (int) Math.sqrt((double) (i_7_ * i_7_ + (i_6_ * i_6_)));
        int i_9_ = 0x7ff & (int) (Math.atan2((double) i_5_, (double) i_8_) * 325.949);
        if(i_9_ < 128)
            i_9_ = 128;
        int i_10_ = 0x7ff & (int) (-325.949 * Math.atan2((double) i_7_, (double) i_6_));
        if(i_9_ > 383)
            i_9_ = 383;
        int i_11_ = -Class68_Sub1.anInt2210 + i_10_;
        if(i_11_ > 1024)
            i_11_ -= 2048;
        if(i_11_ < -1024)
            i_11_ += 2048;
        if(i_11_ > 0) {
            Class68_Sub1.anInt2210 += Class22_Sub1.anInt1856 * i_11_ / 1000 + Class60.anInt1413;
            Class68_Sub1.anInt2210 &= 0x7ff;
        }
        if(arg0 > 0) {
            if(i_11_ < 0) {
                Class68_Sub1.anInt2210 -= Class60.anInt1413 + (Class22_Sub1.anInt1856 * -i_11_ / 1000);
                Class68_Sub1.anInt2210 &= 0x7ff;
            }
            if(i_9_ > Class26.anInt627) {
                Class26.anInt627 += Class60.anInt1413 + (Class22_Sub1.anInt1856 * (i_9_ - Class26.anInt627) / 1000);
                if(Class26.anInt627 > i_9_)
                    Class26.anInt627 = i_9_;
            }
            if(Class26.anInt627 > i_9_) {
                Class26.anInt627 -= (Class22_Sub1.anInt1856 * (Class26.anInt627 + -i_9_) / 1000) + Class60.anInt1413;
                if(Class26.anInt627 < i_9_)
                    Class26.anInt627 = i_9_;
            }
            int i_12_ = i_10_ + -Class68_Sub1.anInt2210;
            if(i_12_ > 1024)
                i_12_ -= 2048;
            if(i_12_ < -1024)
                i_12_ += 2048;
            if(i_12_ < 0 && i_11_ > 0 || i_12_ > 0 && i_11_ < 0)
                Class68_Sub1.anInt2210 = i_10_;
        }
    }

    public static boolean method166(byte arg0, Widget arg1) {
        int i = arg1.contentType;
        if(Class12.friendListStatus == 2) {
            if(i == 201) {
                Class37.anInt876 = 1;
                HuffmanEncoding.aClass1_1563 = Widget.aClass1_2740;
                ChatBox.messagePromptRaised = true;
                ChatBox.inputType = 0;
                HuffmanEncoding.chatMessage = HuffmanEncoding.blank_string;
                ChatBox.redrawChatbox = true;
            }
            if(i == 202) {
                Class37.anInt876 = 2;
                HuffmanEncoding.aClass1_1563 = English.enterNameOfFriendToDeleteFromList;
                ChatBox.redrawChatbox = true;
                ChatBox.inputType = 0;
                ChatBox.messagePromptRaised = true;
                HuffmanEncoding.chatMessage = HuffmanEncoding.blank_string;
            }
        }
        if(i == 205) {
            SceneCluster.anInt771 = 250;
            return true;
        }
        if(i == 501) {
            ChatBox.inputType = 0;
            Class37.anInt876 = 4;
            ChatBox.redrawChatbox = true;
            HuffmanEncoding.aClass1_1563 = Class51.aClass1_1200;
            HuffmanEncoding.chatMessage = HuffmanEncoding.blank_string;
            ChatBox.messagePromptRaised = true;
        }
        if(i == 502) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
            Class37.anInt876 = 5;
            ChatBox.messagePromptRaised = true;
            HuffmanEncoding.chatMessage = HuffmanEncoding.blank_string;
            HuffmanEncoding.aClass1_1563 = English.enterNameOfPlayerToDeleteFromList;
        }
        if(i >= 300 && i <= 313) {
            int i_13_ = (-300 + i) / 2;
            int i_14_ = 0x1 & i;
            LinkedList.aClass30_1082.method382(i_13_, i_14_ == 1, 14);
        }
        if(i >= 314 && i <= 323) {
            int i_15_ = (i + -314) / 2;
            int i_16_ = i & 0x1;
            LinkedList.aClass30_1082.method384(i_16_ == 1, i_15_);
        }
        if(arg0 != 88)
            method163();
        if(i == 324)
            LinkedList.aClass30_1082.method383(false, (byte) -110);
        if(i == 325)
            LinkedList.aClass30_1082.method383(true, (byte) -110);
        if(i == 326) {
            SceneCluster.packetBuffer.putPacket(231);
            LinkedList.aClass30_1082.method375(arg0 ^ 0x58, SceneCluster.packetBuffer);
            return true;
        }
        if(i == 620)
            Class67.reportMutePlayer = !Class67.reportMutePlayer;
        if(i >= 601 && i <= 613) {
            PacketBuffer.method516();
            if(HuffmanEncoding.reportedName.length() > 0) {
                SceneCluster.packetBuffer.putPacket(202);
                SceneCluster.packetBuffer.putLongBE(HuffmanEncoding.reportedName.method58((byte) 102));
                SceneCluster.packetBuffer.putByte(-601 + i);
                SceneCluster.packetBuffer.putByte(Class67.reportMutePlayer ? 1 : 0);
            }
        }
        return false;
    }

    public static void method167(int arg0) {
        if(arg0 != 1023)
            method164();
        Class13.aClass9_406.method235((byte) -56);
    }

    public static void scrollInterface(int arg0, int arg1, int arg2, int arg3, Widget arg5, int arg6, int arg7, int arg8) {
        if(Class61.aBoolean1444)
            Landscape.anInt1171 = 32;
        else
            Landscape.anInt1171 = 0;
        Class61.aBoolean1444 = false;
        if(arg2 >= arg6 && arg2 < arg6 + 16 && arg1 >= arg8 && 16 + arg8 > arg1) {
            arg5.scrollPosition -= Npc.anInt3294 * 4;
            if(arg7 == 1)
                ISAAC.redrawTabArea = true;
            if(arg7 == 2 || arg7 == 3)
                ChatBox.redrawChatbox = true;
        } else if(arg6 > arg2 || (arg6 + 16 <= arg2) || arg1 < arg8 + arg0 + -16 || arg1 >= arg8 + arg0) {
            if(-Landscape.anInt1171 + arg6 <= arg2 && 16 + (arg6 + Landscape.anInt1171) > arg2 && arg8 + 16 <= arg1 && arg1 < -16 + arg8 + arg0 && Npc.anInt3294 > 0) {
                Class61.aBoolean1444 = true;
                int i = (-32 + arg0) * arg0 / arg3;
                if(arg7 == 2 || arg7 == 3)
                    ChatBox.redrawChatbox = true;
                if(arg7 == 1)
                    ISAAC.redrawTabArea = true;
                if(i < 8)
                    i = 8;
                int i_17_ = -i + (arg0 + -32);
                int i_18_ = -(i / 2) + (-arg8 + arg1) + -16;
                arg5.scrollPosition = (arg3 + -arg0) * i_18_ / i_17_;
            }
        } else {
            arg5.scrollPosition += 4 * Npc.anInt3294;
            if(arg7 == 2 || arg7 == 3)
                ChatBox.redrawChatbox = true;
            if(arg7 == 1)
                ISAAC.redrawTabArea = true;
        }
    }
}
