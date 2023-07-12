package org.runejs.client.message.handler.rs435.updating;

import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.ResetAllActorAnimationsInboundMessage;

public class ResetAllActorAnimationsMessageHandler implements MessageHandler<ResetAllActorAnimationsInboundMessage> {
    @Override
    public void handle(ResetAllActorAnimationsInboundMessage message) {
        for(int playerIdx = 0; playerIdx < Player.trackedPlayers.length; playerIdx++) {
            if(Player.trackedPlayers[playerIdx] != null)
                Player.trackedPlayers[playerIdx].playingAnimation = -1;
        }
        for(int npcIdx = 0; Player.npcs.length > npcIdx; npcIdx++) {
            if(Player.npcs[npcIdx] != null)
                Player.npcs[npcIdx].playingAnimation = -1;
        }
    }
}
