package org.runejs.client;

import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.scene.util.CollisionMap;

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

}
