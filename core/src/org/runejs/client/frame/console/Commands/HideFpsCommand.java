package org.runejs.client.frame.console.Commands;

import org.runejs.client.MovedStatics;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class HideFpsCommand extends Command {
    public HideFpsCommand() {
        super("hide_fps", "Hides FPS counter");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        MovedStatics.showFps = false;
        console.log("<col=FF0000>FPS is now hidden</col>");
    }
}
