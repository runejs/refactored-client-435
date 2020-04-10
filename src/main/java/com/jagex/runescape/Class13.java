package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.Wall;

public class Class13 {
    public static int worldid = 1;
    public static int[] anIntArray403 = new int[25];
    public static Cache aClass9_406 = new Cache(64);
    public static boolean[] playerArray = new boolean[5];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_418;
    public static int anInt419 = 2;
    public static int mouseX = 0;
    public static int[] anIntArray421;

    public static void method241(Actor arg0, int arg1, byte arg2) {
        if(arg0.worldX < 128 || arg0.worldY < 128 || arg0.worldX >= 13184 || arg0.worldY >= 13184) {
            arg0.playingAnimation = -1;
            arg0.anInt3112 = 0;
            arg0.anInt3107 = 0;
            arg0.anInt3091 = -1;
            arg0.worldX = arg0.anInt3096 * 64 + 128 * arg0.pathY[0];
            arg0.worldY = arg0.pathX[0] * 128 + 64 * arg0.anInt3096;
            arg0.method790(0);
        }
        if(arg0 == Player.localPlayer && (arg0.worldX < 1536 || arg0.worldY < 1536 || arg0.worldX >= 11776 || arg0.worldY >= 11776)) {
            arg0.anInt3091 = -1;
            arg0.anInt3107 = 0;
            arg0.anInt3112 = 0;
            arg0.playingAnimation = -1;
            arg0.worldX = arg0.pathY[0] * 128 + (arg0.anInt3096 * 64);
            arg0.worldY = 64 * arg0.anInt3096 + arg0.pathX[0] * 128;
            arg0.method790(0);
        }
        if(arg0.anInt3112 > Node.pulseCycle)
            Class40_Sub5_Sub11.method631(arg0, false);
        else if(arg0.anInt3107 < Node.pulseCycle)
            Class44.method898(255, arg0);
        else
            Class30.method381(22378, arg0);
        Class40_Sub5_Sub17_Sub1.method762(-1, arg0);
        Class40_Sub5_Sub15.method736(true, arg0);
        if(arg2 != 107)
            method249(false);
    }

    public static void method242(byte arg0) {
        if(arg0 > -88)
            method247(null, (byte) 34);
        for(; ; ) {
            Class40_Sub6 class40_sub6;
            synchronized(RSCanvas.aLinkedList_53) {
                class40_sub6 = ((Class40_Sub6) IdentityKit.aLinkedList_2604.method913(25447));
            }
            if(class40_sub6 == null)
                break;
            class40_sub6.aClass6_Sub1_2104.method198((byte) -115, false, class40_sub6.aByteArray2102, (int) class40_sub6.key, class40_sub6.aClass56_2117);
        }
    }

    public static void method243(byte arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        if(Class68.method1043(arg4)) {
            Class48.method925(arg3, Widget.interfaces[arg4], arg5, 0, arg7, 0, -1, arg8, arg6, arg1, 0, arg2);
            if(arg0 != 89)
                English.loadingFriendList = null;
        }
    }

    public static int method244(int arg0, int arg1, int arg3) {
        if(arg1 > 179)
            arg0 /= 2;
        if(arg1 > 192)
            arg0 /= 2;
        if(arg1 > 217)
            arg0 /= 2;
        if(arg1 > 243)
            arg0 /= 2;
        return arg1 / 2 + ((arg0 / 32 << 7) + (arg3 / 4 << 10));
    }

    public static synchronized byte[] method246(int arg1) {
        if(arg1 == 100 && Wall.anInt356 > 0) {
            byte[] is = GroundItemTile.aByteArrayArray1377[--Wall.anInt356];
            GroundItemTile.aByteArrayArray1377[Wall.anInt356] = null;
            return is;
        }
        if(arg1 == 5000 && Main.anInt1764 > 0) {
            byte[] is = Class44.aByteArrayArray1039[--Main.anInt1764];
            Class44.aByteArrayArray1039[Main.anInt1764] = null;
            return is;
        }
        if(arg1 == 30000 && VarbitDefinition.anInt2359 > 0) {
            byte[] is = (RSCanvas.aByteArrayArray47[--VarbitDefinition.anInt2359]);
            RSCanvas.aByteArrayArray47[VarbitDefinition.anInt2359] = null;
            return is;
        }
        return new byte[arg1];
    }

    public static int[] method247(Widget arg0, byte arg1) {
        if(arg1 <= 74)
            anInt419 = -37;
        int i;
        if(arg0.id < 0)
            i = arg0.parentId >> 16;
        else
            i = arg0.id >> 16;
        if(!Class68.method1043(i))
            return null;
        int i_11_ = arg0.currentX;
        int i_12_ = arg0.currentY;
        int i_13_ = arg0.parentId;
        while(i_13_ != -1) {
            Widget widget = (Widget.interfaces[i][i_13_ & 0xffff]);
            i_11_ += widget.currentX;
            if(!arg0.aBoolean2694)
                i_11_ -= widget.anInt2746;
            i_12_ += widget.currentY;
            i_13_ = widget.parentId;
            if(!arg0.aBoolean2694)
                i_12_ -= widget.scrollPosition;
        }
        int[] is = new int[2];
        is[0] = i_11_;
        is[1] = i_12_;
        return is;
    }

    public static void method248() {
        anIntArray421 = null;
        aClass40_Sub5_Sub14_Sub2_418 = null;
        English.loadingFriendList = null;
        English.enterNameOfFriendToDeleteFromList = null;
        anIntArray403 = null;
        playerArray = null;
        aClass9_406 = null;
    }

    public static void method249(boolean arg0) {
        if(!arg0)
            method244(-58, 116, 98);
        if(GameObject.frame != null) {
            synchronized(GameObject.frame) {
                GameObject.frame = null;
            }
        }
    }
}
