package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class29 {
    public static GameSocket updateServerSocket;

    public static boolean isHovering(int areaId, int widgetChildId) {
        if(areaId == 0 && ItemDefinition.anInt2850 == widgetChildId)
            return true;

        if(areaId == 1 && widgetChildId == CollisionMap.currentHoveredWidgetChildId)
            return true;

        if((areaId == 2 || areaId == 3) && Class55.currentHoveredChatboxWidgetChildId == widgetChildId)
            return true;

        return false;
    }

    public static int method372(int arg0, int arg1) {
        if(arg0 <= 92)
            method372(4, 3);
        return (int) (0.5 + Math.log(0.00390625 * (double) arg1) * 868.5889638065036);
    }

}
