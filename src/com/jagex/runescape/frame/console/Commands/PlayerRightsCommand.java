package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.scene.InteractiveObject;

public class PlayerRightsCommand extends Command {
    public PlayerRightsCommand() {
        super(new String[]{"rights", "playerrights"}, "Returns current player rights");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.log("<col=FFFFFF>Your player rights level: <col=00FF00>" + InteractiveObject.playerRights + "</col></col>");
    }
}
