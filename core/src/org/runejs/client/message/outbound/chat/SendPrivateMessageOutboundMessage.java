package org.runejs.client.message.outbound.chat;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server when the player sends a private message.
 */
public class SendPrivateMessageOutboundMessage implements OutboundMessage {
    /**
     * The recipient of the message
     */
    public final long recipient;

    /**
     * The message to send
     */
    public final String message;

    /**
     * Creates a new private message to send to the server
     * 
     * @param recipient The recipient of the message
     * @param message The message to send
     */
    public SendPrivateMessageOutboundMessage(long recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }
}
