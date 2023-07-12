package org.runejs.client.message.outbound.chat;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server when the player sends a command in the chatbox.
 */
public class ChatCommandOutboundMessage implements OutboundMessage {
    /**
     * The full text of the command, including any arguments
     */
    public final String command;

    /**
     * Creates a new {@link ChatCommandOutboundMessage}
     * @param command The full text of the command, including any arguments
     */
    public ChatCommandOutboundMessage(String command) {
        this.command = command;
    }
}
