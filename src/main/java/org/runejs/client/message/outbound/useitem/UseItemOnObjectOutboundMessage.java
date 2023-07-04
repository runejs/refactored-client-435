package org.runejs.client.message.outbound.useitem;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to use an item on an object.
 */
public class UseItemOnObjectOutboundMessage extends BaseUseItemOutboundMessage implements OutboundMessage {
    /**
     * The id of the object to use the item on.
     */
    public final int objectId;

    /**
     * The x coordinate of the object.
     */
    public final int x;

    /**
     * The y coordinate of the object.
     */
    public final int y;

    /**
     * Creates a new {@link UseItemOnObjectOutboundMessage}.
     *
     * @param itemId      The id of the item to use.
     * @param widgetId    The id of the widget containing the item
     * @param containerId The id of the container the item is in
     * @param slot        The slot the item is in
     * @param objectId    The id of the player to use the item on.
     * @param x           The x coordinate of the object.
     * @param y           The y coordinate of the object.
     */
    public UseItemOnObjectOutboundMessage(int itemId, int widgetId, int containerId, int slot, int objectId, int x, int y) {
        super(itemId, widgetId, containerId, slot);
        this.objectId = objectId;
        this.x = x;
        this.y = y;
    }
}
