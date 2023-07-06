package org.runejs.client.message.inbound.world.item;

import org.runejs.client.message.InboundMessage;

public class UpdateGroundItemAmountInboundMessage implements InboundMessage {
    public final int itemId;

    public final int x;

    public final int y;

    public final int existingAmount;

    public final int newAmount;

    public UpdateGroundItemAmountInboundMessage(int itemId, int x, int y, int existingAmount, int newAmount) {
        this.itemId = itemId;
        this.x = x;
        this.y = y;
        this.existingAmount = existingAmount;
        this.newAmount = newAmount;
    }
}
