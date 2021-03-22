package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

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
