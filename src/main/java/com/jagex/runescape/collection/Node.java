package com.jagex.runescape.collection;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;

public class Node {
    public static int pulseCycle = 0;
    public static String aClass1_932 = "@gr2@";
    public static int anInt938 = 500;
    public static String aClass1_940 = "white:";
    public static int loginScreenFocus = 0;
    public static String requestcmd_chalreq = ":chalreq:";
    public static String aClass1_975 = ".";

    public long key;
    public Node aClass40_950;
    public Node aClass40_968;

    public static void method455(int arg0, int arg1, int arg3) {
        for(int i = 0; i < 8; i++) {
            for(int i_0_ = 0; i_0_ < 8; i_0_++)
                Class40_Sub6.tile_height[arg1][arg3 + i][arg0 + i_0_] = 0;
        }
        if(arg3 > 0) {
            for(int i = 1; i < 8; i++)
                Class40_Sub6.tile_height[arg1][arg3][arg0 + i] = Class40_Sub6.tile_height[arg1][-1 + arg3][i + arg0];
        }
        if(arg0 > 0) {
            for(int i = 1; i < 8; i++)
                Class40_Sub6.tile_height[arg1][i + arg3][arg0] = Class40_Sub6.tile_height[arg1][i + arg3][-1 + arg0];
        }
        if(arg3 > 0 && Class40_Sub6.tile_height[arg1][-1 + arg3][arg0] != 0)
            Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][arg3 - 1][arg0];
        else if(arg0 > 0 && Class40_Sub6.tile_height[arg1][arg3][arg0 - 1] != 0)
            Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][arg3][-1 + arg0];
        else if(arg3 > 0 && arg0 > 0 && Class40_Sub6.tile_height[arg1][arg3 + -1][-1 + arg0] != 0)
            Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][-1 + arg3][arg0 - 1];
    }

    public static void method456(int arg0) {
        if(Class24.method340()) {
            if(Class26.aBoolean618)
                OverlayDefinition.anInt2342 = arg0;
            else
                Class40_Sub5_Sub13.method651(22741, arg0);
        }
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

    public boolean method454() {
        if(aClass40_968 == null)
            return false;
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
