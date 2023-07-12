package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.Landscape;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.TransformPlayerToObjectInboundMessage;
import org.runejs.client.scene.Scene;

public class TransformPlayerToObjectMessageHandler implements MessageHandler<TransformPlayerToObjectInboundMessage> {
    @Override
    public void handle(TransformPlayerToObjectInboundMessage message) {
        int x = message.x + MovedStatics.placementX;
        int y = message.y + MovedStatics.placementY;

        int unknownXMin = message.unknownXMin;
        int unknownXMax = message.unknownXMax;
        int unknownYMin = message.unknownYMin;
        int unknownYMax = message.unknownYMax;

        int typeKey = message.type;
        int type = GameObjectDefinition.OBJECT_TYPES[typeKey];

        Player player;
        if (message.playerId != PlayerAppearance.anInt708)
            player = Player.trackedPlayers[message.playerId];
        else
            player = Player.localPlayer;
        if (player != null) {
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(message.objectId);
            int tileHeightX0Y0 = Landscape.tile_height[Player.worldLevel][x][y];
            int tileHeightX0Y1 = Landscape.tile_height[Player.worldLevel][x][1 + y];
            int tileHeightX1Y1 = Landscape.tile_height[Player.worldLevel][1 + x][1 + y];
            int tileHeightX1Y0 = Landscape.tile_height[Player.worldLevel][x + 1][y];
            Model model = gameObjectDefinition.createTerrainObjectModel(tileHeightX1Y1, tileHeightX0Y1, message.orientation, tileHeightX0Y0, typeKey, tileHeightX1Y0);
            if (model != null) {
                if (unknownXMax < unknownXMin) {
                    int temp = unknownXMin;
                    unknownXMin = unknownXMax;
                    unknownXMax = temp;
                }
                if (unknownYMax < unknownYMin) {
                    int temp = unknownYMin;
                    unknownYMin = unknownYMax;
                    unknownYMax = temp;
                }
                GameObjectDefinition.method609(-1, x, 0, 1 + message.duration, Player.worldLevel, y, type, 0, 1 + message.delay);
                player.anInt3274 = message.duration + MovedStatics.pulseCycle;
                int sizeX = gameObjectDefinition.sizeX;
                player.playerModel = model;
                player.anInt3283 = message.delay + MovedStatics.pulseCycle;
                int sizeY = gameObjectDefinition.sizeY;
                if (message.orientation == 1 || message.orientation == 3) {
                    sizeY = gameObjectDefinition.sizeX;
                    sizeX = gameObjectDefinition.sizeY;
                }
                player.anInt3271 = x * 128 + 64 * sizeX;
                player.anInt3291 = y * 128 + 64 * sizeY;
                player.anInt3272 = Scene.getFloorDrawHeight(Player.worldLevel, player.anInt3271, player.anInt3291);
                player.anInt3281 = unknownYMin + y;
                player.anInt3258 = x + unknownXMin;
                player.anInt3262 = x + unknownXMax;
                player.anInt3289 = unknownYMax + y;
            }
        }
    }
}
