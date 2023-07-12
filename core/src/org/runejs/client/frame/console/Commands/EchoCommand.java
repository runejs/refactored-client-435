package org.runejs.client.frame.console.Commands;

import org.runejs.client.RSString;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class EchoCommand extends Command {

    public EchoCommand() {
        super(new String[]{"rsecho", "rssay"}, "Converts input string to rsstring and echos back");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        StringBuilder torepeat = new StringBuilder();
        for (int i = 1; i < cmdInput.length; i++) {
            if (i > 1) {
                torepeat.append(" ");
            }
            torepeat.append(cmdInput[i]);
        }
        console.log("\"" + RSString.CreateString(torepeat.toString()).toString() + "\"");

//        printConsoleMessage("<col=00FF00>search [item | npc | object] [name]</col> - <col=FFFF00>Returns list of results</col>", false);
    }
}
