package org.runejs.client.message.handler.rs435;

import org.runejs.client.Class17;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;

/**
 * Applies the main "player updating" message to the game state.
 * 
 * Reponsible for registering and deregistering players, as well
 * as updating their movement and appearance.
 */
public class UpdatePlayersMessageHandler implements MessageHandler<UpdatePlayersInboundMessage> {

    @Override
    public void handle(UpdatePlayersInboundMessage message) {
        // initialisation steps for player updating
        Actor.actorUpdatingIndex = 0;
        Class17.deregisterActorCount = 0;

        // TODO handle message here
        // handle any deregistrations
        for(int i = 0; Class17.deregisterActorCount > i; i++) {
            int trackedPlayerIndex = Player.deregisterActorIndices[i];
            if(MovedStatics.pulseCycle != Player.trackedPlayers[trackedPlayerIndex].anInt3134)
                Player.trackedPlayers[trackedPlayerIndex] = null;
        }

        // check that the tracked player list is valid
        int i = 0;
        for(/**/; Player.localPlayerCount > i; i++) {
            if(Player.trackedPlayers[Player.trackedPlayerIndices[i]] == null)
                throw new RuntimeException("gpp2 pos:" + i + " size:" + Player.localPlayerCount);
        }
    }
}
