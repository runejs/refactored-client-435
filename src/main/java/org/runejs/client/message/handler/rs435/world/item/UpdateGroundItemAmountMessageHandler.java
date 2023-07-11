package org.runejs.client.message.handler.rs435.world.item;

import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.item.UpdateGroundItemAmountInboundMessage;

public class UpdateGroundItemAmountMessageHandler implements MessageHandler<UpdateGroundItemAmountInboundMessage> {
    @Override
    public void handle(UpdateGroundItemAmountInboundMessage message) {
        int y = MovedStatics.placementY + message.y;
        int x = MovedStatics.placementX + message.x;

        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            LinkedList linkedList = MovedStatics.groundItems[Player.worldLevel][x][y];
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
