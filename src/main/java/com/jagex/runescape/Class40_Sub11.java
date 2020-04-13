package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.SignlinkNode;

public class Class40_Sub11 extends Node {
    public static String[] friendUsernames = new String[200];
    public static String[] aClass1Array2153 = new String[1000];
    public static int runEnergy = 0;
    public static String aClass1_2161 = "headicons_pk";
    public static CacheIndex aCacheIndex_2162;
    public static int crossX = 0;
    public static String cmd_fpsoff = "::fpsoff";
    public int[] anIntArray2154;
    public int[] anIntArray2155;
    public SignlinkNode[] aSignlinkNodeArray2156;
    public SignlinkNode[] aSignlinkNodeArray2157;
    public byte[][][] aByteArrayArrayArray2159;
    public int anInt2160;
    public int[] anIntArray2165;
    public int anInt2166;

    public static String method872(int arg0, int arg1) {
        if(arg0 > arg1)
            return Integer.toString(arg1);
        return InteractiveObject.aClass1_478;
    }

    public static void method873(int arg1, int arg2) {
        if(arg2 != 45)
            runEnergy = 53;
        int i = 0;
        for(int i_0_ = 0; i_0_ < 100; i_0_++) {
            if(ChatBox.chatMessages[i_0_] != null) {
                int i_1_ = ChatBox.chatTypes[i_0_];
                int i_2_ = 4 + ChatBox.chatboxScroll + -(i * 14) + 70;
                if(i_2_ < -20)
                    break;
                if(i_1_ == 0)
                    i++;
                String class1 = ChatBox.chatPlayerNames[i_0_];
                if(class1 != null && class1.startsWith(Class51.whiteCrown))
                    class1 = class1.substring(5);
                if(class1 != null && class1.startsWith(Widget.goldCrown))
                    class1 = class1.substring(5);
                if((i_1_ == 1 || i_1_ == 2) && (i_1_ == 1 || ChatBox.publicChatMode == 0 || ChatBox.publicChatMode == 1 && Class40_Sub2.hasFriend(class1))) {
                    if(arg1 > i_2_ - 14 && arg1 <= i_2_ && !class1.equals(Player.localPlayer.playerName)) {
                        if(InteractiveObject.playerRights >= 1) {
                            OverlayDefinition.addActionRow(English.reportAbuse, 0, 0, 0, 28, Class26.aClass1_620+ class1);
                        }
                        OverlayDefinition.addActionRow(Class38.aClass1_885, 0, 0, 0, 51, Class26.aClass1_620+ class1);
                        OverlayDefinition.addActionRow(FloorDecoration.aClass1_591, 0, 0, 0, 45, Class26.aClass1_620+ class1);
                    }
                    i++;
                }
                if((i_1_ == 3 || i_1_ == 7) && CollisionMap.anInt165 == 0 && (i_1_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Class40_Sub2.hasFriend(class1))) {
                    i++;
                    if(arg1 > -14 + i_2_ && arg1 <= i_2_) {
                        if(InteractiveObject.playerRights >= 1) {
                            OverlayDefinition.addActionRow(English.reportAbuse, 0, 0, 0, 28, Class26.aClass1_620+ class1);
                        }
                        OverlayDefinition.addActionRow(Class38.aClass1_885, 0, 0, 0, 51, Class26.aClass1_620+ class1);
                        OverlayDefinition.addActionRow(FloorDecoration.aClass1_591, 0, 0, 0, 45, Class26.aClass1_620+ class1);
                    }
                }
                if(i_1_ == 4 && (ChatBox.tradeMode == 0 || ChatBox.tradeMode == 1 && Class40_Sub2.hasFriend(class1))) {
                    if(arg1 > -14 + i_2_ && arg1 <= i_2_) {
                        OverlayDefinition.addActionRow(Class51.aClass1_1208, 0, 0, 0, 26, Class26.aClass1_620+ class1);
                    }
                    i++;
                }
                if((i_1_ == 5 || i_1_ == 6) && CollisionMap.anInt165 == 0 && ChatBox.privateChatMode < 2)
                    i++;
                if(i_1_ == 8 && (ChatBox.tradeMode == 0 || ChatBox.tradeMode == 1 && Class40_Sub2.hasFriend(class1))) {
                    if(i_2_ + -14 < arg1 && arg1 <= i_2_) {
                        OverlayDefinition.addActionRow(GameObject.aClass1_3039, 0, 0, 0, 46, Class26.aClass1_620 + class1);
                    }
                    i++;
                }
            }
        }
    }

    public static void method874() {
        aClass1Array2153 = null;
        aCacheIndex_2162 = null;
        cmd_fpsoff = null;
        aClass1_2161 = null;
        friendUsernames = null;
    }
}
