package org.runejs.client.message.outbound.console;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server when the player sends a console command.
 */
public class ConsoleCommandOutboundMessage implements OutboundMessage {
    /**
     * The full text of the command, including any arguments
     */
    public final String command;

    /**
     * Creates a new {@link ConsoleCommandOutboundMessage}
     * @param command The full text of the command, including any arguments
     */
    public ConsoleCommandOutboundMessage(String command) {
        this.command = command;
    }
}
