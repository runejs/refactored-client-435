package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class29 {
    public static Class64 aClass64_676;

    public static boolean isHovering(int areaId, int arg2) {
        if(areaId == 0 && ItemDefinition.anInt2850 == arg2) {
            return true;
        }

        if(areaId == 1 && arg2 == CollisionMap.anInt163) {
            return true;
        }

        if((areaId == 2 || areaId == 3) && Class55.anInt1296 == arg2) {
            return true;
        }

        return false;
    }

    public static int method372(int arg0, int arg1) {
        if(arg0 <= 92) {
            method372(4, 3);
        }
        return (int) (0.5 + Math.log(0.00390625 * (double) arg1) * 868.5889638065036);
    }

}
