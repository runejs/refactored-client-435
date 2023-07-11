package org.runejs.client.message.handler.rs435.world.item;

import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.item.RemoveGroundItemInboundMessage;
import org.runejs.client.scene.tile.Wall;

public class RemoveGroundItemMessageHandler implements MessageHandler<RemoveGroundItemInboundMessage> {
    @Override
    public void handle(RemoveGroundItemInboundMessage message) {
        int y = MovedStatics.placementY + message.y;
        int x = MovedStatics.placementX + message.x;

        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            LinkedList linkedList = Wall.groundItems[Player.worldLevel][x][y];
            if (linkedList != null) {
                for (Item item = (Item) linkedList.peekFirst(); item != null; item = (Item) linkedList.pollFirst()) {
                    if ((0x7fff & message.itemId) == item.itemId) {
                        item.unlink();
                        break;
                    }
                }
                if (linkedList.peekFirst() == null)
                    Wall.groundItems[Player.worldLevel][x][y] = null;
                MovedStatics.spawnGroundItem(y, x);
            }
        }
    }
}
