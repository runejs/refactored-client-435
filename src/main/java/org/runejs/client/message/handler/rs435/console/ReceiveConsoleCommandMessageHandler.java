package org.runejs.client.message.handler.rs435.console;

import org.runejs.client.frame.console.Console;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.console.ReceiveConsoleCommandMessage;

/**
 * Adds a console command, e.g. for autocomplete.
 */
public class ReceiveConsoleCommandMessageHandler implements MessageHandler<ReceiveConsoleCommandMessage> {
    @Override
    public void handle(ReceiveConsoleCommandMessage message) {
        Console.console.addCommand(message.command, message.help);
    }
}
