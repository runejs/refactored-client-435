package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.SignlinkNode;

public class Class40_Sub11 extends Node {
    public static RSString[] friendUsernames = new RSString[200];
    public static RSString[] aClass1Array2153 = new RSString[1000];
    public static int runEnergy = 0;
    public static RSString aClass1_2161 = RSString.CreateString("headicons_pk");
    public static CacheIndex aCacheIndex_2162;
    public static int anInt2163 = 0;
    public static RSString cmd_fpsoff = RSString.CreateString("::fpsoff");
    public int[] anIntArray2154;
    public int[] anIntArray2155;
    public SignlinkNode[] aSignlinkNodeArray2156;
    public SignlinkNode[] aSignlinkNodeArray2157;
    public byte[][][] aByteArrayArrayArray2159;
    public int anInt2160;
    public int[] anIntArray2165;
    public int anInt2166;

    public static RSString method872(int arg0, int arg1) {
        if(arg0 > arg1)
            return HashTable.method334(arg1, -1);
        return InteractiveObject.aClass1_478;
    }

    public static void method873(int arg1, int arg2) {
        if(arg2 != 45)
            runEnergy = 53;
        int i = 0;
        for(int i_0_ = 0; i_0_ < 100; i_0_++) {
            if(Actor.chatMessages[i_0_] != null) {
                int i_1_ = HuffmanEncoding.chatTypes[i_0_];
                int i_2_ = 4 + GameObjectDefinition.chatboxScroll + -(i * 14) + 70;
                if(i_2_ < -20)
                    break;
                if(i_1_ == 0)
                    i++;
                RSString class1 = Renderable.chatPlayerNames[i_0_];
                if(class1 != null && class1.startsWith(Class51.whiteCrown))
                    class1 = class1.substring(5);
                if(class1 != null && class1.startsWith(Widget.goldCrown))
                    class1 = class1.substring(5);
                if((i_1_ == 1 || i_1_ == 2) && (i_1_ == 1 || Class35.publicChatMode == 0 || (Class35.publicChatMode == 1 && Class40_Sub2.hasFriend(class1, -32624)))) {
                    if(arg1 > i_2_ - 14 && arg1 <= i_2_ && !(class1.equals((Player.localPlayer.playerName)))) {
                        if(InteractiveObject.playerRights >= 1) {
                            OverlayDefinition.method558(0, Class22_Sub1.aClass1_1865, 0, -501, 0, 28, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                            CollisionMap.anInt158++;
                        }
                        OverlayDefinition.method558(0, Class38.aClass1_885, 0, -501, 0, 51, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                        OverlayDefinition.method558(0, FloorDecoration.aClass1_591, 0, -501, 0, 45, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                    }
                    i++;
                }
                if((i_1_ == 3 || i_1_ == 7) && CollisionMap.anInt165 == 0 && (i_1_ == 7 || Class4.anInt185 == 0 || (Class4.anInt185 == 1 && Class40_Sub2.hasFriend(class1, -32624)))) {
                    i++;
                    if(arg1 > -14 + i_2_ && (arg1 <= i_2_)) {
                        if(InteractiveObject.playerRights >= 1) {
                            CollisionMap.anInt158++;
                            OverlayDefinition.method558(0, Class22_Sub1.aClass1_1865, 0, -501, 0, 28, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                        }
                        OverlayDefinition.method558(0, Class38.aClass1_885, 0, -501, 0, 51, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                        OverlayDefinition.method558(0, FloorDecoration.aClass1_591, 0, -501, 0, 45, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                    }
                }
                if(i_1_ == 4 && (ItemDefinition.anInt2797 == 0 || ((ItemDefinition.anInt2797 == 1) && Class40_Sub2.hasFriend(class1, -32624)))) {
                    if(arg1 > -14 + i_2_ && (arg1 <= i_2_)) {
                        OverlayDefinition.method558(0, Class51.aClass1_1208, 0, arg2 ^ ~0x1d9, 0, 26, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                    }
                    i++;
                }
                if((i_1_ == 5 || i_1_ == 6) && CollisionMap.anInt165 == 0 && Class4.anInt185 < 2)
                    i++;
                if(i_1_ == 8 && (ItemDefinition.anInt2797 == 0 || ((ItemDefinition.anInt2797 == 1) && Class40_Sub2.hasFriend(class1, -32624)))) {
                    if((i_2_ + -14 < arg1) && (arg1 <= i_2_)) {
                        OverlayDefinition.method558(0, GameObject.aClass1_3039, 0, -501, 0, 46, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class26.aClass1_620, class1})));
                        Actor.anInt3133++;
                    }
                    i++;
                }
            }
        }
    }

    public static void method874(byte arg0) {
        aClass1Array2153 = null;
        aCacheIndex_2162 = null;
        cmd_fpsoff = null;
        if(arg0 != 101)
            method873(-35, -55);
        aClass1_2161 = null;
        friendUsernames = null;
    }
}
