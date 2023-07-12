package org.runejs.client.message.inbound.world.item;

import org.runejs.client.message.InboundMessage;

public class RemoveGroundItemInboundMessage implements InboundMessage {
    public final int itemId;

    public final int x;

    public final int y;

    public RemoveGroundItemInboundMessage(int itemId, int x, int y) {
        this.itemId = itemId;
        this.x = x;
        this.y = y;
    }
}
