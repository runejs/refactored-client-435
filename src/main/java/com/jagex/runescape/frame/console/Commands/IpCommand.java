package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
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
