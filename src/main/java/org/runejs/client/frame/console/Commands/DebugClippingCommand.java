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
        boolean radiusProvided = cmdInput.length == 2;
        int radius = radiusProvided ? Integer.parseInt(cmdInput[1]) : 10;

        if (DebugTools.clippingRenderDistance != 0) {
            if (!radiusProvided) {
                console.log("<col=FF0000>Clipping is now hidden</col>");
                DebugTools.clippingRenderDistance = 0;
                return;
            }

            DebugTools.clippingRenderDistance = radius;
            console.log("<col=FF0000>Radius updated to: " + radius + "</col>");
            return;
        }

        DebugTools.clippingRenderDistance = radius;
        console.log("<col=00FF00>Clipping is now drawn.</col> <col=FF0000>Red = blocks walk.</col> <col=539FE9>Blue = blocks projectiles.</col>");

        if (!radiusProvided) {
            console.log("Using default radius: " + radius + ". You can use e.g. `debugclip 15` to increase radius to 15.");
        }
    }
}
