package org.runejs.client.message.outbound.interactions;

import org.runejs.client.message.OutboundMessage;

/**
 * Represents a message sent to the server when a player interacts with an item
 * on a V2 widget.
 * 
 * e.g. using, dropping, wielding, etc.
 */
public class WidgetV2ItemInteractionOutboundMessage implements OutboundMessage {
    /**
     * Which option on the object was clicked
     *
     * i.e. 1 = first option, 2 = second option, etc.
     */
    public final int option;

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
     * The id of the item
     */
    public final int itemId;

    /**
     * Creates a new {@link WidgetV2ItemInteractionOutboundMessage}.
     * @param option The option clicked
     * @param widgetId The id of the widget containing the item
     * @param containerId The id of the container the item is in
     * @param slot The slot the item is in
     * @param itemId The id of the item
     */
    public WidgetV2ItemInteractionOutboundMessage(int option, int widgetId, int containerId, int slot, int itemId) {
        this.option = option;
        this.widgetId = widgetId;
        this.containerId = containerId;
        this.slot = slot;
        this.itemId = itemId;
    }
}
