package org.runejs.client.message.handler.rs435.world.item;

import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.FramemapDefinition;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.item.AddGroundItemInboundMessage;
import org.runejs.client.scene.tile.Wall;

public class AddGroundItemMessageHandler implements MessageHandler<AddGroundItemInboundMessage> {
    @Override
    public void handle(AddGroundItemInboundMessage message) {
        int y = OverlayDefinition.placementY + message.y;
        int x = MovedStatics.placementX + message.x;

        if (message.excludePlayer != -1 && message.excludePlayer != PlayerAppearance.anInt708) {
            return;
        }

        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            Item item = new Item();
            item.itemCount = message.amount;
            item.itemId = message.itemId;
            if (Wall.groundItems[Player.worldLevel][x][y] == null)
                Wall.groundItems[Player.worldLevel][x][y] = new LinkedList();
            Wall.groundItems[Player.worldLevel][x][y].addLast(item);
            FramemapDefinition.spawnGroundItem(y, x);
        }
    }
}
