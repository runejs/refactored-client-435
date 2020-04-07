package com.jagex.runescape.cache;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.net.IncomingPackets;

public class Cache {
    public static RSString dropString = RSString.CreateString("Drop");
    public static RSString dropStringInstance = dropString;
    public static volatile int mouseButtonPressed = 0;
    public static int anInt321 = 5063219;
    public static volatile int eventMouseY = -1;
    public static RSString aClass1_323 = (RSString.CreateString("Please check your message)2centre for details)3"));
    public static int anInt324 = 0;
    public static Cache aClass9_326 = new Cache(200);
    public static RSString aClass1_327 = RSString.CreateString("@or1@");
    public static CacheIndex aCacheIndex_329;
    public static boolean redrawChatbox = false;
    public static RSString aClass1_332 = RSString.CreateString("Classic");
    public static RSString aClass1_333 = aClass1_332;

    public SubNode aClass40_Sub5_309 = new SubNode();
    public int anInt316;
    public int anInt317;
    public HashTable aClass23_318;
    public Class27 aClass27_319 = new Class27();

    public Cache(int arg0) {
        anInt317 = arg0;
        int i;
        i = 1;
        while((i + i < arg0)) {
            i += i;
        }
        anInt316 = arg0;

        aClass23_318 = new HashTable(i);
    }

    public static void method233(boolean arg0) {
        Class33.aClass9_778.method235((byte) 108);
        if(!arg0)
            method236(true, null, null, null);
    }

    public static void method234() {
        dropStringInstance = null;
        aClass1_333 = null;
        dropString = null;
        aClass1_332 = null;
        IncomingPackets.incomingPacketBuffer = null;
        aClass9_326 = null;
        aCacheIndex_329 = null;
        aClass1_327 = null;
        aClass1_323 = null;
    }

    public static void method236(boolean arg0, CacheIndex arg1, CacheIndex arg2, CacheIndex arg3) {
        Class40_Sub11.aCacheIndex_2162 = arg1;
        if(arg0)
            anInt324 = -101;
        VarbitDefinition.aCacheIndex_2364 = arg3;
        AnimationSequence.aCacheIndex_2484 = arg2;
    }

    public void put(long arg1, SubNode arg2) {
        if(anInt316 == 0) {
            SubNode class40_sub5 = aClass27_319.method351();
            class40_sub5.method457(-1);
            class40_sub5.method539();
            if(class40_sub5 == aClass40_Sub5_309) {
                class40_sub5 = aClass27_319.method351();
                class40_sub5.method457(-1);
                class40_sub5.method539();
            }
        } else
            anInt316--;
        aClass23_318.put(arg2, (byte) -115, arg1);
        aClass27_319.method352(102, arg2);
    }

    public SubNode get(long arg0, byte arg1) {
        SubNode class40_sub5 = (SubNode) aClass23_318.method331(arg0, 6120);
        if(arg1 < 39)
            aClass1_333 = null;
        if(class40_sub5 != null)
            aClass27_319.method352(114, class40_sub5);
        return class40_sub5;
    }

    public void removeAll(long arg0, int arg1) {
        if(arg1 <= 94)
            get(30L, (byte) 20);
        SubNode class40_sub5 = (SubNode) aClass23_318.method331(arg0, 6120);
        if(class40_sub5 == null)
            return;
        class40_sub5.method457(-1);
        class40_sub5.method539();
        anInt316++;
    }

    public void method235(byte arg0) {
        for(; ; ) {
            SubNode class40_sub5 = aClass27_319.method351();
            if(class40_sub5 == null)
                break;
            class40_sub5.method457(-1);
            class40_sub5.method539();
        }
        anInt316 = anInt317;
        int i = 115 / ((-2 - arg0) / 33);
    }
}
