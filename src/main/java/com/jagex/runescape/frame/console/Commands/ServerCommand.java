package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.scene.SceneCluster;

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
