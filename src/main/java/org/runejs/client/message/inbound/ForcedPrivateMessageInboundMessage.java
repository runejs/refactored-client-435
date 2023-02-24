package org.runejs.client.message.inbound;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to indicate that a private message has been sent
 * to another player by the client.
 * 
 * TODO (Jameskmonger) what was this used for?
 */
public class ForcedPrivateMessageInboundMessage implements InboundMessage {
    /**
     * The username of the recipient.
     */
    public final long username;

    /**
     * The message text.
     */
    public final String message;

    /**
     * Constructs a new private message inbound message.
     * 
     * @param username The username of the recipient.
     * @param message The message text.
     */
    public ForcedPrivateMessageInboundMessage(long username, String message) {
        this.username = username;
        this.message = message;
    }
}
