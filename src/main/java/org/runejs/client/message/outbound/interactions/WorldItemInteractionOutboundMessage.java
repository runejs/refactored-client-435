package org.runejs.client.message.outbound.interactions;

import org.runejs.client.message.OutboundMessage;

/**
 * Represents a message sent to the server when a player interacts with a world item.
 * 
 * e.g. picking up an item, or lighting a pile of logs
 */
public class WorldItemInteractionOutboundMessage implements OutboundMessage {
    /**
     * Which option on the item was clicked
     *
     * i.e. 1 = first option, 2 = second option, etc.
     */
    public final int option;

    /**
     * The id of the item
     */
    public final int itemId;

    /**
     * The x coordinate
     */
    public final int x;

    /**
     * The y coordinate
     */
    public final int y;

    /**
     * Creates a new {@link WorldItemInteractionOutboundMessage}.
     * @param option The option that was clicked
     * @param itemId The id of the item
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public WorldItemInteractionOutboundMessage(int option, int itemId, int x, int y) {
        this.option = option;
        this.itemId = itemId;
        this.x = x;
        this.y = y;
    }
}
