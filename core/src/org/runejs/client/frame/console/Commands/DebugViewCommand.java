package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class DebugViewCommand extends Command {
    public DebugViewCommand() {
        super(new String[]{"debugview", "debug_view"}, "Toggles debug view");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        ScreenController.DebugView = !ScreenController.DebugView;
        if(ScreenController.DebugView) {
            console.log("<col=00FF00>Debug View is now Drawn</col>");
        } else {
            console.log("<col=FF0000>Debug View is now hidden</col>");
        }
    }
}
