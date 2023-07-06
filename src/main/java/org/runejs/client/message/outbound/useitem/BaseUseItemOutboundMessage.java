package org.runejs.client.message.outbound.useitem;

/**
 * A base class for all "use item on X" messages.
 */
public abstract class BaseUseItemOutboundMessage {
    /**
     * The id of the item to use.
     */
    public final int itemId;

    /**
     * The id of the widget containing the item
     */
    public final int widgetId;

    /**
     * The id of the container the item is in
     */
    public final int containerId;

    /**
     * The slot the item is in
     */
    public final int slot;

    /**
     * Creates a new {@link BaseUseItemOutboundMessage}.
     *
     * @param itemId        The id of the item to use.
     * @param widgetId      The id of the widget containing the item
     * @param containerId   The id of the container the item is in
     * @param slot          The slot the item is in
     */
    public BaseUseItemOutboundMessage(int itemId, int widgetId, int containerId, int slot) {
        this.itemId = itemId;
        this.widgetId = widgetId;
        this.containerId = containerId;
        this.slot = slot;
    }
}
