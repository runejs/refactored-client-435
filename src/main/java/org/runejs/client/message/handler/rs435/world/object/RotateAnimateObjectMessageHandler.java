package org.runejs.client.message.handler.rs435.world.object;

import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.object.RotateAnimateObjectInboundMessage;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.scene.tile.WallDecoration;

public class RotateAnimateObjectMessageHandler implements MessageHandler<RotateAnimateObjectInboundMessage> {
    @Override
    public void handle(RotateAnimateObjectInboundMessage message) {
        int x = message.x + MovedStatics.placementX;
        int y = message.y + MovedStatics.placementY;
        int objectTypeKey = message.type;
        int objectType = Npc.anIntArray3304[objectTypeKey];
        int orientation = message.orientation;
        int animationId = message.animationId;

        if (x >= 0 && y >= 0 && x < 103 && y < 103) {
            int tileHeightX0Y0 = MovedStatics.tile_height[Player.worldLevel][x][y];
            int tileHeightX1Y0 = MovedStatics.tile_height[Player.worldLevel][x + 1][y];
            int tileHeightX1Y1 = MovedStatics.tile_height[Player.worldLevel][1 + x][1 + y];
            int tileHeightX0Y1 = MovedStatics.tile_height[Player.worldLevel][x][y + 1];
            if (objectType == 0) {
                Wall wall = Npc.currentScene.method126(Player.worldLevel, x, y);
                if (wall != null) {
                    int i_11_ = 0x7fff & wall.hash >> 14;
                    if (objectTypeKey == 2) {
                        wall.primary = new GameObject(i_11_, 2, 4 + orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                        wall.secondary = new GameObject(i_11_, 2, 0x3 & orientation + 1, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                    } else
                        wall.primary = new GameObject(i_11_, objectTypeKey, orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
                }
            }
            if (objectType == 1) {
                WallDecoration wallDecoration = Npc.currentScene.getWallDecoration(Player.worldLevel, x, y);
                if (wallDecoration != null)
                    wallDecoration.renderable = new GameObject((0x1fffe268 & wallDecoration.hash) >> 14, 4, 0, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
            }
            if (objectType == 2) {
                InteractiveObject interactiveObject = Npc.currentScene.method107(Player.worldLevel, x, y);
                if (objectTypeKey == 11)
                    objectTypeKey = 10;
                if (interactiveObject != null)
                    interactiveObject.renderable = new GameObject(interactiveObject.hash >> 14 & 0x7fff, objectTypeKey, orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
            }
            if (objectType == 3) {
                FloorDecoration floorDecoration = Npc.currentScene.getFloorDecoration(Player.worldLevel, x, y);
                if (floorDecoration != null)
                    floorDecoration.renderable = new GameObject(0x7fff & floorDecoration.hash >> 14, 22, orientation, tileHeightX0Y0, tileHeightX1Y0, tileHeightX1Y1, tileHeightX0Y1, animationId, false);
            }
        }
    }
}
