package org.runejs.client.message.inbound.world.item;

import org.runejs.client.message.InboundMessage;

public class AddGroundItemInboundMessage implements InboundMessage {
    public final int itemId;

    public final int amount;

    public final int x;

    public final int y;

    public AddGroundItemInboundMessage(int itemId, int amount, int x, int y) {
        this.itemId = itemId;
        this.amount = amount;
        this.x = x;
        this.y = y;
    }
}
