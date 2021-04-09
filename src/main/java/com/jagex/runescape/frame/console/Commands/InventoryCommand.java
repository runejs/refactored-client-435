package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

public class InventoryCommand extends Command {
    public InventoryCommand() {
        super("inventory", "Lists items in the inventory");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        //        Widget widget = Widget.forId(149);
        //        console.log("<col=FFFF00>Items:</col>");
        //        for (int item = 0; item < widget.items.length; item++) {
        //            if (widget.items[item] != -1) {
        //                ItemDefinition.forId(widget.items[item], 10);
        //                StringBuilder bldr = new StringBuilder();
        //                bldr.
        //
        //                console.log(command.getPrintableHelp());
        //            }
        //        }
    }
}
