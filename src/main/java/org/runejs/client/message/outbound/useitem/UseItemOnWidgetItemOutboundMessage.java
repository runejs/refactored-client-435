package org.runejs.client.message.outbound.useitem;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to use an item on a widget item.
 */
public class UseItemOnWidgetItemOutboundMessage extends BaseUseItemOutboundMessage implements OutboundMessage {
    /**
     * The id of the target item, i.e. the one not in the player's inventory.
     */
    public final int targetItemId;

    /**
     * The id of the widget containing the target item,
     * i.e. the one not in the player's inventory.
     */
    public final int targetWidgetId;

    /**
     * The id of the container containing the target item,
     * i.e. the one not in the player's inventory.
     */
    public final int targetContainerId;

    /**
     * The slot of the target item,
     * i.e. the one not in the player's inventory.
     */
    public final int targetSlot;

    /**
     * Creates a new {@link UseItemOnWidgetItemOutboundMessage}.
     *
     * @param itemId            The id of the item to use.
     * @param widgetId          The id of the widget containing the item
     * @param containerId       The id of the container the item is in
     * @param slot              The slot the item is in
     * @param targetItemId      The id of the target item, i.e. the one not in the player's inventory.
     * @param targetWidgetId
     * @param targetContainerId
     * @param targetSlot
     */
    public UseItemOnWidgetItemOutboundMessage(int itemId, int widgetId, int containerId, int slot, int targetItemId, int targetWidgetId, int targetContainerId, int targetSlot) {
        super(itemId, widgetId, containerId, slot);
        this.targetItemId = targetItemId;
        this.targetWidgetId = targetWidgetId;
        this.targetContainerId = targetContainerId;
        this.targetSlot = targetSlot;
    }
}
