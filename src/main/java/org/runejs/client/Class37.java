package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.frame.Minimap;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.IncomingPackets;
import org.runejs.client.scene.SceneCluster;

public class Class37 {
    public static int anInt876 = 0;
    public static ImageRGB[] cursorCross;

    static {
        Main.anInt874 = 0;
    }

    public static void method434() {
        MovedStatics.menuOpen = false;
        IncomingPackets.opcode = -1;
        MovedStatics.menuActionRow = 0;
        IncomingPackets.incomingPacketSize = 0;
        SceneCluster.packetBuffer.currentPosition = 0;
        IncomingPackets.lastOpcode = -1;
        IncomingPackets.secondLastOpcode = -1;
        IncomingPackets.cyclesSinceLastPacket = 0;
        IncomingPackets.thirdLastOpcode = -1;
        MovedStatics.destinationX = 0;
        Minimap.minimapState = 0;
        Class40_Sub5_Sub15.systemUpdateTime = 0;
        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
        for(int i = 0; Player.trackedPlayers.length > i; i++) {
            if(Player.trackedPlayers[i] != null)
                Player.trackedPlayers[i].facingActorIndex = -1;
        }
        for(int i = 0; Player.npcs.length > i; i++) {
            if(Player.npcs[i] != null)
                Player.npcs[i].facingActorIndex = -1;
        }
        MovedStatics.processGameStatus(30);
    }

    public static boolean method438(int areaId, int arg1) {
        // (Jameskmonger) something to do with right clicking
        if(areaId == 0 && arg1 == MovedStatics.anInt573)
            return true;
        if(areaId == 1 && MovedStatics.anInt614 == arg1)
            return true;
        if((areaId == 2 || areaId == 3) && MovedStatics.anInt1586 == arg1)
            return true;
        return false;
    }
}
