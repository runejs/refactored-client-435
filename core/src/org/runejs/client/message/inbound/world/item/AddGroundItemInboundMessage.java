package org.runejs.client.message.inbound.world.item;

import org.runejs.client.message.InboundMessage;

public class AddGroundItemInboundMessage implements InboundMessage {
    public final int itemId;

    public final int amount;

    public final int x;

    public final int y;

    /**
     * The client will avoid spawning this item if excludePlayer matches the local player.
     *
     * Set to -1 if no player should be excluded.
     */
    public final int excludePlayer;

    public AddGroundItemInboundMessage(int itemId, int amount, int x, int y, int excludePlayer) {
        this.itemId = itemId;
        this.amount = amount;
        this.x = x;
        this.y = y;
        this.excludePlayer = excludePlayer;
    }
}
