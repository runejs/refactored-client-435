package org.runejs.client.message.outbound.useitem;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to use an item on a world item
 */
public class UseItemOnWorldItemOutboundMessage extends BaseUseItemOutboundMessage implements OutboundMessage {
    /**
     * The id of the target item, i.e. the one not in the player's inventory.
     */
    public final int targetItemId;

    /**
     * The x coordinate of the target item.
     */
    public final int x;

    /**
     * The y coordinate of the target item.
     */
    public final int y;

    /**
     * Creates a new {@link UseItemOnWorldItemOutboundMessage}.
     *
     * @param itemId       The id of the item to use.
     * @param widgetId     The id of the widget containing the item
     * @param containerId  The id of the container the item is in
     * @param slot         The slot the item is in
     * @param targetItemId The id of the target item, i.e. the one not in the player's inventory.
     * @param x            The x coordinate of the target item.
     * @param y            The y coordinate of the target item.
     */
    public UseItemOnWorldItemOutboundMessage(int itemId, int widgetId, int containerId, int slot, int targetItemId, int x, int y) {
        super(itemId, widgetId, containerId, slot);
        this.targetItemId = targetItemId;
        this.x = x;
        this.y = y;
    }
}
