package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

public class ClearCommand extends Command {
    public ClearCommand() {
        super(new String[]{"clear", "cls"}, "Clears console output");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.setMessageCount(0);
        console.log("<col=FFFFFF>Cleared</col>");
    }
}
