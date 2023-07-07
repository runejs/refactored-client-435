package org.runejs.client.message.inbound;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent containing a group of messages in one.
 */
public class BulkInboundMessage implements InboundMessage {
    /**
     * New X reference position.
     */
    public final int x;

    /**
     * New Y reference position.
     */
    public final int y;

    /**
     * Child messages to be handled.
     */
    public final InboundMessage[] messages;

    public BulkInboundMessage(int x, int y, InboundMessage[] messages) {
        this.x = x;
        this.y = y;
        this.messages = messages;
    }
}
