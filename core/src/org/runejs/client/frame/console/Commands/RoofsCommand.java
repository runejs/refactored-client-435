package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import org.runejs.Configuration;

public class RoofsCommand extends Command {
    public RoofsCommand() {
        super(new String[]{"toggleroofs", "roofs"}, "Toggles rendering roofs");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        Configuration.ROOFS_ENABLED = !Configuration.ROOFS_ENABLED;
        if(Configuration.ROOFS_ENABLED) {
            console.log("<col=00FF00>Roofs are now rendered</col>");
        } else {
            console.log("<col=FF0000>Roofs are now not rendered</col>");
        }
    }
}
