package org.runejs.client.message.inbound.chat;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to indicate that a general chatbox message has been received.
 * 
 * This is used for the following messages:
 * - General chat messages
 * - Trade requests
 * - Duel requests
 */
public class ReceiveChatboxMessageInboundMessage implements InboundMessage {
    /**
     * The message
     */
    public final String message;

    /**
     * Constructs a new private message inbound message.
     * 
     * @param message The imessage.
     */
    public ReceiveChatboxMessageInboundMessage(String message) {
        this.message = message;
    }
}
