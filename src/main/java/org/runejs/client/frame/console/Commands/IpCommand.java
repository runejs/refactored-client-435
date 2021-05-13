package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import tech.henning.fourthreefive.Configuration;

public class IpCommand extends Command {
    public IpCommand() {
        super(new String[]{"ip", "host"}, "Returns current server address");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.log("<col=FFFFFF>Server address: <col=00FF00>" + Configuration.SERVER_ADDRESS + "</col></col>");
    }
}
