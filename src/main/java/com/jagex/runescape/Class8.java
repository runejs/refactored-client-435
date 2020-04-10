package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;
import java.util.Calendar;

public class Class8 {
    public static RSString aClass1_278;
    public static Calendar aCalendar279 = Calendar.getInstance();
    public static RSString aClass1_281 = RSString.CreateString("backright1");
    public static CacheIndex aCacheIndex_284;
    public static RSString aClass1_286 = RSString.CreateString("Unexpected loginserver response)3");
    public static long aLong288;
    public static int anInt289;
    public static int anInt290 = 0;
    public static RSString aClass1_291 = RSString.CreateString("You have only just left another world)3");
    public static int anInt292 = 0;
    public static RSString aClass1_294;
    public static FontMetrics fontMetrics;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array296;
    public static int[] anIntArray297 = new int[5];
    public static Class68 aClass68_298;
    public static RSString aClass1_299 = RSString.CreateString("runes");
    public static int itemSelected = 0;
    public static byte aByte302 = (byte) 0;
    public static RSString aClass1_303 = RSString.CreateString("_");
    public static RSString aClass1_304 = RSString.CreateString("backhmid2");
    public static RSString aClass1_305 = RSString.CreateString("");

    static {
        aClass1_278 = aClass1_286;
        aClass1_294 = aClass1_291;
    }

    public Class8(int arg0) {
        CollisionMap.anInt141 = arg0;
        aLong288 = System.currentTimeMillis();

    }

    public static void method209() {
        for(int i = 0; i < Player.npcCount; i++) {
            int i_0_ = Player.npcIds[i];
            Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_0_];
            if(class40_sub5_sub17_sub4_sub2 != null)
                Class13.method241(class40_sub5_sub17_sub4_sub2, (class40_sub5_sub17_sub4_sub2.actorDefinition.boundaryDimension), (byte) 107);
        }

    }

    public static void setHighMemory() {
        VertexNormal.lowMemory = false;
        Scene.lowMemory = false;

    }

    public static void method211() {
        ISAAC.aClass9_516.method235((byte) 78);
        MouseHandler.modelCache.method235((byte) 36);
        Buffer.aClass9_1933.method235((byte) 72);

    }

    public static void method214() {
        aClass1_286 = null;
        aClass1_278 = null;
        anIntArray297 = null;
        fontMetrics = null;
        aClass1_305 = null;
        aCacheIndex_284 = null;
        aClass1_291 = null;
        aClass1_303 = null;
        aCalendar279 = null;
        aClass1_299 = null;
        aClass68_298 = null;
        aClass1_304 = null;
        aClass40_Sub5_Sub14_Sub4Array296 = null;
        aClass1_294 = null;
        aClass1_281 = null;
    }

    public static synchronized void method215(int[] arg0, int arg1) {
        int i = 0;
        arg1 -= 7;
        while(i < arg1) {
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
            arg0[i++] = 0;
        }
        arg1 += 7;
        while(i < arg1)
            arg0[i++] = 0;
        if(FloorDecoration.aClass40_Sub9_608 != null)
            FloorDecoration.aClass40_Sub9_608.method844(arg0, 0, arg1);
        ItemDefinition.method748(arg1);
    }


    public static synchronized void method217(int arg0) {
        if(FloorDecoration.aClass40_Sub9_608 != null)
            FloorDecoration.aClass40_Sub9_608.method843(arg0);
        ItemDefinition.method748(arg0);
    }

    public static synchronized void method218(Class40_Sub9 arg0) {
        FloorDecoration.aClass40_Sub9_608 = arg0;
    }

    public void method212(long arg0) {
    }

    public void method213() {
    }
}
