package org.runejs.client;

import org.runejs.client.node.Class40_Sub6;
import org.runejs.client.cache.def.IdentityKit;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceArea;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.tile.Wall;

public class Class13 {
    public static boolean[] playerArray = new boolean[5];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_418;
    public static int anInt419 = 2;
    public static int mouseX = 0;
    public static int[] objectDataIds;

    public static void handleActorAnimation(Actor actor) {
        if(actor.worldX < 128 || actor.worldY < 128 || actor.worldX >= 13184 || actor.worldY >= 13184) {
            actor.playingAnimation = -1;
            actor.anInt3112 = 0;
            actor.anInt3107 = 0;
            actor.graphicId = -1;
            actor.worldX = actor.anInt3096 * 64 + 128 * actor.pathY[0];
            actor.worldY = actor.pathX[0] * 128 + 64 * actor.anInt3096;
            actor.method790(0);
        }
        if(actor == Player.localPlayer && (actor.worldX < 1536 || actor.worldY < 1536 || actor.worldX >= 11776 || actor.worldY >= 11776)) {
            actor.graphicId = -1;
            actor.anInt3107 = 0;
            actor.anInt3112 = 0;
            actor.playingAnimation = -1;
            actor.worldX = actor.pathY[0] * 128 + actor.anInt3096 * 64;
            actor.worldY = 64 * actor.anInt3096 + actor.pathX[0] * 128;
            actor.method790(0);
        }
        if(actor.anInt3112 > MovedStatics.pulseCycle)
            method631(actor);
        else if(actor.anInt3107 < MovedStatics.pulseCycle)
            Class44.method898(255, actor);
        else
            PlayerAppearance.method381(actor);
        Projectile.method762(actor);
        Class40_Sub5_Sub15.method736(true, actor);
    }

    public static void handleRequests() {
        for(; ; ) {
            Class40_Sub6 class40_sub6;
            synchronized(RSCanvas.aLinkedList_53) {
                class40_sub6 = (Class40_Sub6) IdentityKit.aLinkedList_2604.removeFirst();
            }
            if(class40_sub6 == null)
                break;
            class40_sub6.cacheArchive.method198(false, class40_sub6.aByteArray2102, (int) class40_sub6.key, class40_sub6.cacheIndex);
        }
    }

    public static void handleInterfaceActions(GameInterfaceArea area, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, int widgetId) {
        if(GameInterface.decodeGameInterface(widgetId)) {
            MovedStatics.handleInterfaceActions(area, mouseX, mouseY, minX, minY, maxX, maxY, GameInterface.cachedInterfaces[widgetId], -1, 0, 0);
        }
    }

    public static int generateHslBitset(int s, int l, int h) {
        if(l > 179)
            s /= 2;
        if(l > 192)
            s /= 2;
        if(l > 217)
            s /= 2;
        if(l > 243)
            s /= 2;
        return l / 2 + (s / 32 << 7) + (h / 4 << 10);
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
        if(arg1 == 30000 && MovedStatics.anInt2359 > 0) {
            byte[] is = RSCanvas.aByteArrayArray47[--MovedStatics.anInt2359];
            RSCanvas.aByteArrayArray47[MovedStatics.anInt2359] = null;
            return is;
        }
        return new byte[arg1];
    }

    public static int[] method247(GameInterface arg0) {
        int i;
        if(arg0.id < 0)
            i = arg0.parentId >> 16;
        else
            i = arg0.id >> 16;
        if(!GameInterface.decodeGameInterface(i))
            return null;
        int i_11_ = arg0.currentX;
        int i_12_ = arg0.currentY;
        int i_13_ = arg0.parentId;
        while(i_13_ != -1) {
            GameInterface gameInterface = GameInterface.cachedInterfaces[i][i_13_ & 0xffff];
            i_11_ += gameInterface.currentX;
            if(!arg0.lockScroll)
                i_11_ -= gameInterface.scrollWidth;
            i_12_ += gameInterface.currentY;
            i_13_ = gameInterface.parentId;
            if(!arg0.lockScroll)
                i_12_ -= gameInterface.scrollPosition;
        }
        int[] is = new int[2];
        is[0] = i_11_;
        is[1] = i_12_;
        return is;
    }

    public static void method249() {
        if(GameObject.frame != null) {
            synchronized(GameObject.frame) {
                GameObject.frame = null;
            }
        }
    }

    public static void method631(Actor actor) {
        int i = actor.anInt3125 * 128 + 64 * actor.anInt3096;
        int i_0_ = actor.anInt3112 + -MovedStatics.pulseCycle;
        if(actor.anInt3073 == 0)
            actor.initialFaceDirection = 1024;
        if(actor.anInt3073 == 1)
            actor.initialFaceDirection = 1536;
        if(actor.anInt3073 == 2)
            actor.initialFaceDirection = 0;
        int i_1_ = actor.anInt3096 * 64 + 128 * actor.anInt3081;
        actor.worldX += (i - actor.worldX) / i_0_;
        if(actor.anInt3073 == 3)
            actor.initialFaceDirection = 512;
        actor.anInt3074 = 0;
        actor.worldY += (-actor.worldY + i_1_) / i_0_;
    }
}
