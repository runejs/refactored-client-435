package org.runejs.client.message.inbound.console;

import org.runejs.client.RSString;
import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to add a log message to the console.
 */
public class ReceiveConsoleLogMessage implements InboundMessage {
    /**
     * The message.
     */
    public final RSString message;

    /**
     * Constructs a new {@link ReceiveConsoleLogMessage}.
     * @param message The message.
     */
    public ReceiveConsoleLogMessage(RSString message) {
        this.message = message;
    }
}
