package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.DebugTools;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class DebugWalkCommand extends Command {
    public DebugWalkCommand() {
        super(new String[]{"debugwalk"}, "Toggles debug walkpath");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        DebugTools.walkpathEnabled = !DebugTools.walkpathEnabled;
        if(DebugTools.walkpathEnabled) {
            console.log("<col=00FF00>Walkpath is now drawn</col>");
        } else {
            console.log("<col=FF0000>Walkpath is now hidden</col>");
        }
    }
}
