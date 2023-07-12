package org.runejs.client.message.outbound.useitem;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to use an item on a player.
 */
public class UseItemOnPlayerOutboundMessage extends BaseUseItemOutboundMessage implements OutboundMessage {
    /**
     * The id of the player to use the item on.
     */
    public final int playerId;

    /**
     * Creates a new {@link UseItemOnPlayerOutboundMessage}.
     *
     * @param itemId        The id of the item to use.
     * @param widgetId      The id of the widget containing the item
     * @param containerId   The id of the container the item is in
     * @param slot          The slot the item is in
     * @param playerId      The id of the player to use the item on.
     */
    public UseItemOnPlayerOutboundMessage(int itemId, int widgetId, int containerId, int slot, int playerId) {
        super(itemId, widgetId, containerId, slot);
        this.playerId = playerId;
    }
}
