package org.runejs.client.frame.console.Commands;

import org.runejs.client.frame.console.Command;
import org.runejs.client.frame.console.Console;
import org.runejs.client.scene.SceneCluster;

public class ServerCommand extends Command {
    public ServerCommand(String cmdStr, String help) {
        super(cmdStr.split("\\|"), help);
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        SceneCluster.packetBuffer.putPacket(246);
        SceneCluster.packetBuffer.putString(String.join(" ", cmdInput));
    }
}
