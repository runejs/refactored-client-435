package org.runejs.client.message.handler.rs435.updating;

import org.runejs.client.Class17;
import org.runejs.client.MovedStatics;
import org.runejs.client.Projectile;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.movement.*;
import org.runejs.client.message.inbound.updating.registration.*;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate.ActorMovementUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorRegistration;

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
        handleOtherPlayersMovement(message.otherPlayersMovement);

        handleRegisterNewPlayers(message.newPlayers);
        
        /**
         * We call into the original method here to keep this implementation simple.
         * 
         * In future, we should refactor this to be a part of the message handling system also.
         */
        Player.parseTrackedPlayerUpdateMasks(message.appearanceUpdates);

        // handle any deregistrations
        for(int i = 0; Class17.deregisterActorCount > i; i++) {
            int trackedPlayerIndex = Player.deregisterActorIndices[i];
            if(MovedStatics.pulseCycle != Player.trackedPlayers[trackedPlayerIndex].anInt3134)
                Player.trackedPlayers[trackedPlayerIndex] = null;
        }

        // TODO check there are no bytes left (buffer.currentPosition != buffer.size) or should this happen in decoder?

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
     * @param update The update information to apply
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
            
            Player.localPlayer.method787(update.mapRegionUpdate.localChunkY, update.mapRegionUpdate.teleporting, update.mapRegionUpdate.localChunkX);

            return;
        }

        // general movement updates (walking etc)
        if (update.movementUpdate != null) {
            MovementUpdate movementUpdate = update.movementUpdate;

            if (movementUpdate.runDirection != null) {
                Player.localPlayer.move(movementUpdate.walkDirection, true);
                Player.localPlayer.move(movementUpdate.runDirection, true);
            } else {
                Player.localPlayer.move(movementUpdate.walkDirection, false);
            }

            if (movementUpdate.runUpdateBlock) {
                Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = 2047;
            }

            return;
        }

        // code should never reach here based on if statements above
        throw new RuntimeException("Unhandled local player movement update");
    }

    /**
     * Handle the movement/placement of other (already tracked) players.
     * 
     * This method is pulled from the original implementation with minimal changes.
     * 
     * @param update The update information to apply
     */
    private void handleOtherPlayersMovement(ActorGroupMovementUpdate update) {
        int trackedPlayerCount = update.actorCount;
        if(trackedPlayerCount < Player.localPlayerCount) {
            for(int i = trackedPlayerCount; Player.localPlayerCount > i; i++)
                Player.deregisterActorIndices[Class17.deregisterActorCount++] = Player.trackedPlayerIndices[i];
        }
        
        if(Player.localPlayerCount < trackedPlayerCount) {
            System.out.println("gppov1 " + Player.localPlayerCount + " " + trackedPlayerCount);
            throw new RuntimeException("gppov1");
        }

        Player.localPlayerCount = 0;

        for(int i = 0; trackedPlayerCount > i; i++) {
            int trackedPlayerIndex = Player.trackedPlayerIndices[i];
            Player player = Player.trackedPlayers[trackedPlayerIndex];

            ActorMovementUpdate playerUpdate = update.movementUpdates[i];
            
            // no update required
            if (playerUpdate == null) {
                Player.trackedPlayerIndices[Player.localPlayerCount++] = trackedPlayerIndex;
                player.anInt3134 = MovedStatics.pulseCycle;
                continue;
            }

            // deregister player if necessary
            if (playerUpdate.shouldDeregister) {
                Player.deregisterActorIndices[Class17.deregisterActorCount++] = trackedPlayerIndex;
                continue;
            }
            
            Player.trackedPlayerIndices[Player.localPlayerCount++] = trackedPlayerIndex;
            player.anInt3134 = MovedStatics.pulseCycle;

            // if no movement then we can skip the rest
            if (playerUpdate.movementUpdate == null) {
                Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = trackedPlayerIndex;
                continue;
            }

            // handle the player movement
            MovementUpdate movementUpdate = playerUpdate.movementUpdate;

            if (movementUpdate.runDirection != null) {
                player.move(movementUpdate.walkDirection, true);
                player.move(movementUpdate.runDirection, true);
            } else {
                player.move(movementUpdate.walkDirection, false);
            }

            if (movementUpdate.runUpdateBlock) {
                Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = trackedPlayerIndex;
            }
        }
    }

    /**
     * Handle the registration of new players.
     * 
     * This method is pulled from the original implementation with minimal changes.
     * 
     * @param update The update information to apply
     */
    private void handleRegisterNewPlayers(ActorGroupRegistrationUpdate<ActorRegistration> update) {
        for (ActorRegistration playerUpdate : update.players) {
            int newPlayerIndex = playerUpdate.index;

            // likely isn't needed as it's handled in the decoder
            if(newPlayerIndex == 2047)
                break;

            // rehydrate the player from existing appearance data
            boolean bool = false;
            if(Player.trackedPlayers[newPlayerIndex] == null) {
                Player.trackedPlayers[newPlayerIndex] = new Player();
                if(Player.trackedPlayerAppearanceCache[newPlayerIndex] != null)
                    Player.trackedPlayers[newPlayerIndex].parsePlayerAppearanceData(Player.trackedPlayerAppearanceCache[newPlayerIndex]);
                bool = true;
            }

            // begin registration proper
            Player.trackedPlayerIndices[Player.localPlayerCount++] = newPlayerIndex;
            Player player = Player.trackedPlayers[newPlayerIndex];
            player.anInt3134 = MovedStatics.pulseCycle;
            int offsetX = playerUpdate.offsetX;
            int offsetY = playerUpdate.offsetY;
            if(offsetX > 15)
                offsetX -= 32;
            if(offsetY > 15)
                offsetY -= 32;

            // parse and apply direction
            int initialFaceDirection = playerUpdate.faceDirection;
            int faceDirection = Projectile.directions[initialFaceDirection];
            if(bool)
                player.initialFaceDirection = faceDirection;

            // discard walking queue if necessary
            if(playerUpdate.discardWalkingQueue)
                Player.actorUpdatingIndices[Player.actorUpdatingIndex++] = newPlayerIndex;

            // adjust the actors position?
            player.method787(offsetY + Player.localPlayer.pathX[0], playerUpdate.updateRequired, Player.localPlayer.pathY[0] + offsetX);
        }
    }
}
