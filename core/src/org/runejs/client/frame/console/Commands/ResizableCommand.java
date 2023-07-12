package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class ResizableCommand extends Command {
    public ResizableCommand() {
        super(new String[]{ "resizable", "responsive", "resizeable", "fullscreen", "full", "maximize", "max", "grow", "thicc" }, "toggles resiable mode");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        if(ScreenController.frameMode == ScreenMode.FIXED) {
            ScreenController.frameMode(ScreenMode.RESIZABLE);
            console.log("<col=00FF00>Client is now Resizable</col>");
        } else if(ScreenController.frameMode == ScreenMode.RESIZABLE) {
            ScreenController.frameMode(ScreenMode.FULLSCREEN);
            console.log("<col=00FF00>Client is now Fullscreen</col>");
        } else if(ScreenController.frameMode == ScreenMode.FULLSCREEN) {
            ScreenController.frameMode(ScreenMode.FIXED);

            console.log("<col=00FF00>Client is now Fixed</col>");
        }
    }
}
