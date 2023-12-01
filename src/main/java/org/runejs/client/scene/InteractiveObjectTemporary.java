package org.runejs.client.scene;

import org.runejs.client.Game;
import org.runejs.client.node.Node;

public class InteractiveObjectTemporary extends Node {
    public int id;
    public int plane;
    public int previousOrientation;
    public int typeKey;
    public int previousId;
    public int type;
    public int duration = -1;
    public int delay = 0;
    public int orientation;
    public int previousType;
    public int y;
    public int x;

    public static void setPrevousObjectDetails(InteractiveObjectTemporary obj) {
        int i = 0;
        int id = -1;
        int type = 0;
        if(obj.typeKey == 0)
            i = Game.currentScene.getWallHash(obj.plane, obj.x, obj.y);
        int orientation = 0;
        if(obj.typeKey == 1)
            i = Game.currentScene.getWallDecorationHash(obj.plane, obj.x, obj.y);
        if(obj.typeKey == 2)
            i = Game.currentScene.getLocationHash(obj.plane, obj.x, obj.y);
        if(obj.typeKey == 3)
            i = Game.currentScene.getFloorDecorationHash(obj.plane, obj.x, obj.y);
        if (i != 0) {
            int i_3_ = Game.currentScene.getArrangement(obj.plane, obj.x, obj.y, i);
            id = (0x1fffe692 & i) >> 14;
            orientation = (i_3_ & 0xde) >> 6;
            type = i_3_ & 0x1f;
        }
        obj.previousOrientation = orientation;
        obj.previousId = id;
        obj.previousType = type;
    }
}
