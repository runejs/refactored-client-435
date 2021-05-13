package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

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
