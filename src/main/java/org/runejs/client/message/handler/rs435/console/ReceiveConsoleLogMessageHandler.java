package org.runejs.client.message.handler.rs435.console;

import org.runejs.client.frame.console.Console;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.console.ReceiveConsoleLogMessage;

/**
 * Adds a log message to the console.
 */
public class ReceiveConsoleLogMessageHandler implements MessageHandler<ReceiveConsoleLogMessage> {
    @Override
    public void handle(ReceiveConsoleLogMessage message) {
        Console.console.log("<col=FFFF00>" + message.message.toString() + "</col>");
    }
}
