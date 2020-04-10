package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

import java.util.List;

public class HelpCommand extends Command {
    private List<Command> commands;
    public HelpCommand(List<Command> commands) {
        super(new String[]{"help", "commands"}, "Search for item/npc/object names");
        this.commands = commands;
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.log("<col=FFFF00>Commands:</col>");
        commands.forEach((command -> {
            console.log(command.getPrintableHelp());
        }));
//        printConsoleMessage("<col=00FF00>search [item | npc | object] [name]</col> - <col=FFFF00>Returns list of results</col>", false);
    }
}
