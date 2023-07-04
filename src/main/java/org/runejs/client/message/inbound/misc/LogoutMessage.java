package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to indicate that the local player has logged out.
 */
public class LogoutMessage implements InboundMessage {
    /**
     * Constructs a new {@link LogoutMessage}.
     */
    public LogoutMessage() {
    }
}
