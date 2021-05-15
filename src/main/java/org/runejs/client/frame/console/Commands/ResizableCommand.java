package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class ResizableCommand extends Command {
    public ResizableCommand() {
        super(new String[]{ "resizable", "responsive" }, "toggles resiable mode");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        if(ScreenController.frameMode == ScreenMode.FIXED) {
            ScreenController.frameMode(ScreenMode.RESIZABLE);
            console.log("<col=00FF00>Client is now Resizable</col>");
        } else {
            ScreenController.frameMode(ScreenMode.FIXED);

            console.log("<col=00FF00>Client is now  not Resizable</col>");
        }
    }
}
