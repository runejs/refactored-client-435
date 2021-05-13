package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import org.runejs.client.scene.InteractiveObject;

public class FpsCommand extends Command {
    public FpsCommand() {
        super(new String[]{"fps", "toggle_fps"}, "Toggles the FPS counter");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        InteractiveObject.showFps = !InteractiveObject.showFps;
        if(InteractiveObject.showFps) {
            console.log("<col=00FF00>FPS is now shown</col>");
        } else {
            console.log("<col=FF0000>FPS is now hidden</col>");
        }
    }
}
