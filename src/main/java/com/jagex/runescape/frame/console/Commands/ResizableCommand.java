package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

public class ResizableCommand extends Command {
    public ResizableCommand() {
        super("resizable", "toggles resiable mode");
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
