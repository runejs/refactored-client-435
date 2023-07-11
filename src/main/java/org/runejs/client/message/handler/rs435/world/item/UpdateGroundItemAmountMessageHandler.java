package org.runejs.client.message.handler.rs435.world.item;

import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.item.UpdateGroundItemAmountInboundMessage;
import org.runejs.client.scene.tile.Wall;

public class UpdateGroundItemAmountMessageHandler implements MessageHandler<UpdateGroundItemAmountInboundMessage> {
    @Override
    public void handle(UpdateGroundItemAmountInboundMessage message) {
        int y = OverlayDefinition.placementY + message.y;
        int x = MovedStatics.placementX + message.x;

        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            LinkedList linkedList = Wall.groundItems[Player.worldLevel][x][y];
            if (linkedList != null) {
                for (Item item = (Item) linkedList.peekFirst(); item != null; item = (Item) linkedList.pollFirst()) {
                    if (item.itemId == (message.itemId & 0x7fff) && message.existingAmount == item.itemCount) {
                        item.itemCount = message.newAmount;
                        break;
                    }
                }
                MovedStatics.spawnGroundItem(y, x);
            }
        }
    }
}
