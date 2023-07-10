package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.DebugTools;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class DebugClippingCommand extends Command {
    public DebugClippingCommand() {
        super(new String[]{"debugclip"}, "Toggles clipping rendering.");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        DebugTools.clippingEnabled = !DebugTools.clippingEnabled;
        if(DebugTools.clippingEnabled) {
            console.log("<col=00FF00>Clipping is now drawn.</col> <col=FF0000>Red = blocks walk.</col> <col=539FE9>Blue = blocks projectiles.</col>");
        } else {
            console.log("<col=FF0000>Clipping is now hidden</col>");
        }
    }
}
