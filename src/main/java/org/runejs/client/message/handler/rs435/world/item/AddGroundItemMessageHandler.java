package org.runejs.client.message.handler.rs435.world.item;

import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.item.AddGroundItemInboundMessage;

public class AddGroundItemMessageHandler implements MessageHandler<AddGroundItemInboundMessage> {
    @Override
    public void handle(AddGroundItemInboundMessage message) {
        int y = MovedStatics.placementY + message.y;
        int x = MovedStatics.placementX + message.x;

        if (message.excludePlayer != -1 && message.excludePlayer != Player.localPlayerId) {
            return;
        }

        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            Item item = new Item();
            item.itemCount = message.amount;
            item.itemId = message.itemId;
            if (MovedStatics.groundItems[Player.worldLevel][x][y] == null)
                MovedStatics.groundItems[Player.worldLevel][x][y] = new LinkedList();
            MovedStatics.groundItems[Player.worldLevel][x][y].addLast(item);
            MovedStatics.spawnGroundItem(y, x);
        }
    }
}
