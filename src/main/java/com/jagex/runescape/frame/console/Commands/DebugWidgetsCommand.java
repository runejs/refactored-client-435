package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
import tech.henning.fourthreefive.Configuration;

public class DebugWidgetsCommand extends Command {
    public DebugWidgetsCommand() {
        super(new String[]{"dw", "debugwidget", "debugwidgets", "debug_widgets", "debug_widget"}, "Toggles widget debug information");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        Configuration.DEBUG_WIDGETS = !Configuration.DEBUG_WIDGETS;
        if(Configuration.DEBUG_WIDGETS) {
            console.log("<col=00FF00>Widget debug information is now shown</col>");
        } else {
            console.log("<col=FF0000>Widget debug information is now hidden</col>");
        }
    }
}
