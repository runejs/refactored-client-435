package org.runejs.client.message.inbound.console;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to add a command to the console.
 */
public class ReceiveConsoleCommandMessage implements InboundMessage {
    /**
     * The command to add.
     */
    public final String command;

    /**
     * The help text for the command.
     */
    public final String help;

    /**
     * Constructs a new {@link ReceiveConsoleCommandMessage}.
     * @param command The command to add.
     * @param help The help text for the command.
     */
    public ReceiveConsoleCommandMessage(String command, String help) {
        this.command = command;
        this.help = help;
    }
}
