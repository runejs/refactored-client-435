package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

public class AlphaCommand extends Command {
    public AlphaCommand() {
        super("alpha", "Toggles console background transparency");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.toggleAlpha();
    }
}
