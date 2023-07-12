package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class AlphaCommand extends Command {
    public AlphaCommand() {
        super("alpha", "Toggles console background transparency");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.toggleAlpha();
    }
}
