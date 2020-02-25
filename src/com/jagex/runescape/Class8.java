package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Npc;

import java.awt.*;
import java.util.Calendar;

public class Class8 {
    public static int anInt275;
    public static int anInt276;
    public static int anInt277;
    public static RSString aClass1_278;
    public static Calendar aCalendar279;
    public static int anInt280;
    public static int anInt282;
    public static RSString aClass1_281 = RSString.CreateString("backright1");
    public static int anInt283;
    public static CacheIndex aCacheIndex_284;
    public static int anInt285;
    public static RSString aClass1_286 = RSString.CreateString("Unexpected loginserver response)3");
    public static int anInt287;
    public static long aLong288;
    public static int anInt289;
    public static int anInt290;
    public static RSString aClass1_291;
    public static int anInt292;
    public static RSString aClass1_293;
    public static RSString aClass1_294;
    public static FontMetrics fontMetrics;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array296;
    public static int[] anIntArray297;
    public static Class68 aClass68_298;
    public static RSString aClass1_299;
    public static RSString aClass1_300;
    public static int anInt301;
    public static byte aByte302;
    public static RSString aClass1_303;
    public static RSString aClass1_304;
    public static RSString aClass1_305;

    static {
        aClass1_278 = aClass1_286;
        aCalendar279 = Calendar.getInstance();
        aClass1_299 = RSString.CreateString("runes");
        anInt290 = 0;
        aByte302 = (byte) 0;
        aClass1_303 = RSString.CreateString("_");
        anInt292 = 0;
        aClass1_293 = RSString.CreateString("Duell akzeptieren");
        aClass1_300 = RSString.CreateString("welle2:");
        anIntArray297 = new int[5];
        aClass1_291 = RSString.CreateString("You have only just left another world)3");
        aClass1_294 = aClass1_291;
        anInt301 = 0;
        aClass1_305 = RSString.CreateString("");
        aClass1_304 = RSString.CreateString("backhmid2");
    }

    public Class8(int arg0) {
        CollisionMap.anInt141 = arg0;
        aLong288 = System.currentTimeMillis();

    }

    public static void method209(int arg0) {
        for(int i = 0; i < GameObjectDefinition.anInt2558; i++) {
            int i_0_ = Class40_Sub3.anIntArray2016[i];
            Npc class40_sub5_sub17_sub4_sub2 = CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_];
            if(class40_sub5_sub17_sub4_sub2 != null)
                Class13.method241(class40_sub5_sub17_sub4_sub2, (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.tileSpacesOccupied), (byte) 107);
        }
        int i = -30 % ((arg0 + 8) / 34);
        anInt287++;

    }

    public static void method210(int arg0) {
        VertexNormal.lowMemory = false;
        if(arg0 != 0)
            method209(-4);
        anInt276++;
        Scene.aBoolean88 = false;

    }

    public static void method211(byte arg0) {
        anInt280++;
        ISAAC.aClass9_516.method235((byte) 78);
        GameFrame.aClass9_1455.method235((byte) 36);
        if(arg0 != 60)
            method217(17, (byte) -110);
        Buffer.aClass9_1933.method235((byte) 72);

    }

    public static void method214(int arg0) {
        aClass1_286 = null;
        aClass1_278 = null;
        anIntArray297 = null;
        fontMetrics = null;
        int i = 53 % ((51 - arg0) / 40);
        aClass1_305 = null;
        aCacheIndex_284 = null;
        aClass1_291 = null;
        aClass1_303 = null;
        aCalendar279 = null;
        aClass1_299 = null;
        aClass68_298 = null;
        aClass1_304 = null;
        aClass40_Sub5_Sub14_Sub4Array296 = null;
        aClass1_300 = null;
        aClass1_293 = null;
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


    public static synchronized void method217(int arg0, byte arg1) {
        if(FloorDecoration.aClass40_Sub9_608 != null)
            FloorDecoration.aClass40_Sub9_608.method843(arg0);
        anInt285++;
        if(arg1 > 28)
            ItemDefinition.method748(arg0);
    }

    public static synchronized void method218(Class40_Sub9 arg0, int arg1) {
        FloorDecoration.aClass40_Sub9_608 = arg0;
        anInt283++;
    }

    public void method212(long arg0) {
        anInt277++;

    }

    public void method213() {
        anInt275++;

    }
}
