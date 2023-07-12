package org.runejs.client.frame.console.Commands;

import org.runejs.client.Game;
import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;

public class PlayerRightsCommand extends Command {
    public PlayerRightsCommand() {
        super(new String[]{"rights", "playerrights"}, "Returns current player rights");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        console.log("<col=FFFFFF>Your player rights level: <col=00FF00>" + Game.playerRights + "</col></col>");
    }
}
