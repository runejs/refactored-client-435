package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import org.runejs.client.message.outbound.console.ConsoleCommandOutboundMessage;
import org.runejs.client.net.OutgoingPackets;

public class ServerCommand extends Command {
    public ServerCommand(String cmdStr, String help) {
        super(cmdStr.split("\\|"), help);
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        String fullCommand = String.join(" ", cmdInput);
        OutgoingPackets.sendMessage(new ConsoleCommandOutboundMessage(fullCommand));
    }
}
