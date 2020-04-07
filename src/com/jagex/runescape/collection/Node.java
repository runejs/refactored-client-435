package com.jagex.runescape.collection;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;

public class Node {
    public static RSString aClass1_924 = RSString.CreateString("");
    public static RSString aClass1_925 = RSString.CreateString("");
    public static int pulseCycle = 0;
    public static RSString aClass1_929 = RSString.CreateString("");
    public static RSString aClass1_930 = RSString.CreateString("");
    public static RSString aClass1_931 = RSString.CreateString("");
    public static RSString aClass1_932 = RSString.CreateString("@gr2@");
    public static RSString aClass1_934 = RSString.CreateString("");
    public static RSString aClass1_937 = RSString.CreateString("");
    public static int anInt938 = 500;
    public static RSString aClass1_939 = RSString.CreateString("white:");
    public static RSString aClass1_940 = aClass1_939;
    public static RSString aClass1_941 = RSString.CreateString("");
    public static RSString aClass1_942 = RSString.CreateString("");
    public static RSString aClass1_943 = RSString.CreateString("");
    public static RSString aClass1_944 = RSString.CreateString("");
    public static RSString aClass1_945 = RSString.CreateString("");
    public static RSString aClass1_946 = RSString.CreateString("");
    public static int anInt947 = 0;
    public static RSString requestcmd_chalreq = RSString.CreateString(":chalreq:");
    public static RSString aClass1_949 = RSString.CreateString("");
    public static RSString aClass1_951 = RSString.CreateString("");
    public static RSString aClass1_952 = RSString.CreateString("");
    public static RSString aClass1_953 = RSString.CreateString("");
    public static RSString aClass1_954 = RSString.CreateString("");
    public static RSString aClass1_955 = RSString.CreateString("");
    public static RSString aClass1_956 = RSString.CreateString("");
    public static RSString aClass1_957 = RSString.CreateString("");
    public static RSString aClass1_958 = RSString.CreateString("");
    public static RSString aClass1_959 = RSString.CreateString("");
    public static RSString aClass1_960 = RSString.CreateString("");
    public static RSString aClass1_963 = RSString.CreateString("");
    public static RSString aClass1_964 = RSString.CreateString("");
    public static RSString aClass1_966 = RSString.CreateString("");
    public static RSString aClass1_967 = RSString.CreateString("");
    public static RSString aClass1_969 = RSString.CreateString("");
    public static RSString aClass1_972 = RSString.CreateString("");
    public static RSString aClass1_973 = RSString.CreateString("");
    public static RSString aClass1_974 = RSString.CreateString("");
    public static RSString aClass1_975 = RSString.CreateString(")3");
    public static RSString aClass1_976 = RSString.CreateString("");

    public long key;
    public Node aClass40_950;
    public Node aClass40_968;

    public static void method455(int arg0, int arg1, int arg2, int arg3) {
        if(arg2 != 1)
            aClass1_972 = null;
        for(int i = 0; i < 8; i++) {
            for(int i_0_ = 0; i_0_ < 8; i_0_++)
                Class40_Sub6.tile_height[arg1][arg3 + i][arg0 + i_0_] = 0;
        }
        if(arg3 > 0) {
            for(int i = 1; i < 8; i++)
                Class40_Sub6.tile_height[arg1][arg3][arg0 + i] = (Class40_Sub6.tile_height[arg1][-1 + arg3][i + arg0]);
        }
        if(arg0 > 0) {
            for(int i = 1; i < 8; i++)
                Class40_Sub6.tile_height[arg1][i + arg3][arg0] = (Class40_Sub6.tile_height[arg1][i + arg3][-1 + arg0]);
        }
        if(arg3 > 0 && (Class40_Sub6.tile_height[arg1][-1 + arg3][arg0] != 0))
            Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][arg3 - 1][arg0];
        else if(arg0 > 0 && (Class40_Sub6.tile_height[arg1][arg3][arg0 - 1]) != 0)
            Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][arg3][-1 + arg0];
        else if(arg3 > 0 && arg0 > 0 && (Class40_Sub6.tile_height[arg1][arg3 + -1][-1 + arg0]) != 0)
            Class40_Sub6.tile_height[arg1][arg3][arg0] = (Class40_Sub6.tile_height[arg1][-1 + arg3][arg0 - 1]);
    }

    public static void method456(int arg0) {
        if(Class24.method340()) {
            if(Class26.aBoolean618)
                OverlayDefinition.anInt2342 = arg0;
            else
                Class40_Sub5_Sub13.method651(22741, arg0);
        }
    }

    public static void method458() {
        aClass1_952 = null;
        aClass1_939 = null;
        aClass1_964 = null;
        aClass1_940 = null;
        aClass1_973 = null;
        aClass1_924 = null;
        aClass1_934 = null;
        aClass1_967 = null;
        aClass1_954 = null;
        aClass1_972 = null;
        aClass1_976 = null;
        aClass1_944 = null;
        aClass1_959 = null;
        aClass1_943 = null;
        aClass1_975 = null;
        aClass1_949 = null;
        aClass1_951 = null;
        aClass1_974 = null;
        aClass1_963 = null;
        aClass1_942 = null;
        aClass1_946 = null;
        aClass1_929 = null;
        aClass1_955 = null;
        aClass1_931 = null;
        aClass1_941 = null;
        aClass1_945 = null;
        aClass1_930 = null;
        aClass1_956 = null;
        requestcmd_chalreq = null;
        aClass1_966 = null;
        aClass1_960 = null;
        aClass1_969 = null;
        aClass1_932 = null;
        aClass1_953 = null;
        aClass1_957 = null;
        aClass1_937 = null;
        aClass1_925 = null;
        aClass1_958 = null;
    }

    public static boolean method459(int arg0, int arg1, byte arg2) {
        if(arg0 == 11)
            arg0 = 10;
        if(arg2 < 83)
            method459(125, 22, (byte) 101);
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(arg1);
        if(arg0 >= 5 && arg0 <= 8)
            arg0 = 4;
        return gameObjectDefinition.method610(arg0, 7533);
    }

    public boolean method454(boolean arg0) {
        if(aClass40_968 == null)
            return false;
        if(arg0)
            method458();
        return true;
    }

    public void method457(int arg0) {
        if(aClass40_968 != null) {
            aClass40_968.aClass40_950 = aClass40_950;
            if(arg0 == -1) {
                aClass40_950.aClass40_968 = aClass40_968;
                aClass40_968 = null;
                aClass40_950 = null;
            }
        }
    }
}
