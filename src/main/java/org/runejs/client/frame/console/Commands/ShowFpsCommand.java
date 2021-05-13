package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import org.runejs.client.scene.InteractiveObject;

public class ShowFpsCommand extends Command {
    public ShowFpsCommand() {
        super(new String[]{"displayfps", "show_fps"}, "Shows FPS counter");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        InteractiveObject.showFps = true;
        console.log("<col=00FF00>FPS is now shown</col>");
    }
}
