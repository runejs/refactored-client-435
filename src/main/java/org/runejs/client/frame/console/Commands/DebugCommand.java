package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import tech.henning.fourthreefive.Configuration;

public class DebugCommand extends Command {
    public DebugCommand() {
        super(new String[]{"debug", "toggle_debug"}, "Toggles debug information");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        Configuration.DEBUG_CONTEXT = !Configuration.DEBUG_CONTEXT;
        if(Configuration.DEBUG_CONTEXT) {
            console.log("<col=00FF00>Debug information is now shown</col>");
        } else {
            console.log("<col=FF0000>Debug information is now hidden</col>");
        }
    }
}
