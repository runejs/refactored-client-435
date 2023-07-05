package org.runejs.client.message.outbound.examine;

import org.runejs.client.message.OutboundMessage;

/**
 * An {@link OutboundMessage} sent to the server to examine an item.
 */
public class ExamineItemOutboundMessage implements OutboundMessage {
    /**
     * The id of the item to examine.
     */
    public final int itemId;

    /**
     * Creates a new {@link ExamineItemOutboundMessage}.
     * @param itemId The id of the item to examine.
     */
    public ExamineItemOutboundMessage(int itemId) {
        this.itemId = itemId;
    }
}
