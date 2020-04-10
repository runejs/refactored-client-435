package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.scene.InteractiveObject;

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
