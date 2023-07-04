package org.runejs.client.message.outbound.useitem;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to use an item on a NPC.
 */
public class UseItemOnNPCOutboundMessage extends BaseUseItemOutboundMessage implements OutboundMessage {
    /**
     * The id of the NPC to use the item on.
     */
    public final int npcId;

    /**
     * Creates a new {@link UseItemOnNPCOutboundMessage}.
     *
     * @param itemId        The id of the item to use.
     * @param widgetId      The id of the widget containing the item
     * @param containerId   The id of the container the item is in
     * @param slot          The slot the item is in
     * @param npcId         The id of the NPC to use the item on.
     */
    public UseItemOnNPCOutboundMessage(int itemId, int widgetId, int containerId, int slot, int npcId) {
        super(itemId, widgetId, containerId, slot);
        this.npcId = npcId;
    }
}
