package org.runejs.client;

import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;

import java.awt.*;

public class Class17 {
    public static int regionY;
    public static int[] anIntArray456;
    public static int deregisterActorCount = 0;
    public static Font helveticaBold;
    public static ProducingGraphicsBuffer chatboxTop;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_463;
    public static int[] anIntArray466 = new int[256];

    public static void animatePlayers(int playerIndex) {
        for(int currentPlayerIndex = playerIndex; Player.localPlayerCount > currentPlayerIndex; currentPlayerIndex++) {
            int actualIndex;
            if(currentPlayerIndex == -1)
                actualIndex = 2047;
            else
                actualIndex = Player.trackedPlayerIndices[currentPlayerIndex];
            Player player = Player.trackedPlayers[actualIndex];
            if(player != null)
                Actor.handleActorAnimation(player);
        }
    }

}
