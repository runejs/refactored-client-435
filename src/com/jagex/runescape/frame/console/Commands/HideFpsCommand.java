package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.scene.InteractiveObject;

public class HideFpsCommand extends Command {
    public HideFpsCommand() {
        super("hide_fps", "Hides FPS counter");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        InteractiveObject.showFps = false;
        console.log("<col=FF0000>FPS is now hidden</col>");
    }
}
