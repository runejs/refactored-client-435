package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.scene.InteractiveObject;

public class ShowFpsCommand extends Command {
    public ShowFpsCommand() {
        super("show_fps", "Shows FPS counter");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        InteractiveObject.showFps = true;
        console.log("<col=00FF00>FPS is now shown</col>");
    }
}
