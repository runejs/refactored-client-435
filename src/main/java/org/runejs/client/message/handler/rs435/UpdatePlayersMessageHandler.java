package org.runejs.client.message.handler.rs435;

import org.runejs.client.Class17;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate;
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
        
        // handle the different types of update within the message
        handleLocalPlayerMovement(message.localPlayerMovement);

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

    /**
     * Responsible for applying movement to the client's local player.
     * 
     * @param update The update method
     */
    private void handleLocalPlayerMovement(LocalPlayerMovementUpdate update) {
        // if there is no update at all we do nothing
        if (update == null) {
            return;
        }

        if (update.mapRegionUpdate == null && update.movementUpdate == null) {
            // "no movement" is handled differently to "no update", and needs this to be set
            // this is indicated by mapRegionUpdate and movementUpdate both being null
            Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = 2047;
            return;
        }

        // map region updates
        if (update.mapRegionUpdate != null) {
            Player.worldLevel = update.mapRegionUpdate.level;

            if (update.mapRegionUpdate.runUpdateBlock) {
                Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = 2047;
            }
            
            Player.localPlayer.method787(update.mapRegionUpdate.localChunkY, -7717, update.mapRegionUpdate.teleporting, update.mapRegionUpdate.localChunkX);

            return;
        }

        // general movement updates (walking etc)
        if (update.movementUpdate != null) {
            PlayerMovementUpdate playerMovementUpdate = update.movementUpdate;

            if (playerMovementUpdate.runDirection != null) {
                Player.localPlayer.move(playerMovementUpdate.walkDirection, true);
                Player.localPlayer.move(playerMovementUpdate.runDirection, true);
            } else {
                Player.localPlayer.move(playerMovementUpdate.walkDirection, false);
            }

            if (playerMovementUpdate.runUpdateBlock) {
                Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = 2047;
            }

            return;
        }

        // code should never reach here based on if statements above
        throw new RuntimeException("Unhandled local player movement update");
    }
}
