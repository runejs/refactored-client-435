package org.runejs.client.message.handler.rs435.updating;

import org.runejs.client.Class17;
import org.runejs.client.MovedStatics;
import org.runejs.client.Projectile;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.UpdateNPCsInboundMessage;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.movement.MovementUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorGroupRegistrationUpdate;
import org.runejs.client.message.inbound.updating.registration.NPCRegistration;

public class UpdateNPCsMessageHandler implements MessageHandler<UpdateNPCsInboundMessage> {
    @Override
    public void handle(UpdateNPCsInboundMessage message) {
        // initialisation steps
        Class17.deregisterActorCount = 0;
        Actor.actorUpdatingIndex = 0;

        handleTrackedMovement(message.trackedNPCMovement);
        handleRegisterNewNPCs(message.newNPCs);

        Npc.parseNpcUpdateMasks(message.appearanceUpdates);

        for(int i = 0; i < Class17.deregisterActorCount; i++) {
            int trackedNpcIndex = Player.deregisterActorIndices[i];
            if(MovedStatics.pulseCycle != Player.npcs[trackedNpcIndex].anInt3134) {
                Player.npcs[trackedNpcIndex].actorDefinition = null;
                Player.npcs[trackedNpcIndex] = null;
            }
        }

        // TODO check there are no bytes left (buffer.currentPosition != buffer.size) or should this happen in decoder?

        for(int i = 0; Player.npcCount > i; i++) {
            if(Player.npcs[Player.npcIds[i]] == null)
                throw new RuntimeException("gnp2 pos:" + i + " size:" + Player.npcCount);
        }
    }

    /**
     * Handles the movement of tracked NPCs
     * @param update The update containing the movement information
     */
    private void handleTrackedMovement(ActorGroupMovementUpdate update) {
        int trackedNpcCount = update.actorCount;
        if(Player.npcCount > trackedNpcCount) {
            for(int i = trackedNpcCount; i < Player.npcCount; i++)
                Player.deregisterActorIndices[Class17.deregisterActorCount++] = Player.npcIds[i];
        }

        if(Player.npcCount < trackedNpcCount) {
            System.out.println("gppov1 [npc] " + Player.npcCount + " " + trackedNpcCount);
            throw new RuntimeException("gppov1");
        }

        Player.npcCount = 0;

        for(int i = 0; trackedNpcCount > i; i++) {
            int trackedNpcIndex = Player.npcIds[i];
            Npc npc = Player.npcs[trackedNpcIndex];

            ActorGroupMovementUpdate.ActorMovementUpdate npcUpdate = update.movementUpdates[i];

            // no update required
            if (npcUpdate == null) {
                Player.npcIds[Player.npcCount++] = trackedNpcIndex;
                npc.anInt3134 = MovedStatics.pulseCycle;
                Player.actorUpdatingIndices[Npc.actorUpdatingIndex++] = trackedNpcIndex;
                continue;
            }

            // deregister npc if necessary
            if (npcUpdate.shouldDeregister) {
                Player.deregisterActorIndices[Class17.deregisterActorCount++] = trackedNpcIndex;
                continue;
            }

            Player.npcIds[Player.npcCount++] = trackedNpcIndex;
            npc.anInt3134 = MovedStatics.pulseCycle;

            // if no movement then we can skip the rest
            if (npcUpdate.movementUpdate == null) {
                Player.actorUpdatingIndices[Npc.actorUpdatingIndex++] = trackedNpcIndex;
                continue;
            }

            // handle the player movement
            MovementUpdate movementUpdate = npcUpdate.movementUpdate;

            if (movementUpdate.runDirection != null) {
                npc.move(movementUpdate.walkDirection, true);
                npc.move(movementUpdate.runDirection, true);
            } else {
                npc.move(movementUpdate.walkDirection, false);
            }

            if (movementUpdate.runUpdateBlock) {
                Player.actorUpdatingIndices[Npc.actorUpdatingIndex++] = trackedNpcIndex;
            }
        }
    }

    /**
     * Handles the registration of new NPCs
     * @param update The update containing the registration information
     */
    private void handleRegisterNewNPCs(ActorGroupRegistrationUpdate<NPCRegistration> update) {
        for (NPCRegistration playerUpdate : update.players) {
            int i = playerUpdate.index;

            // likely isn't needed as it's handled in the decoder
            if(i == 32767)
                break;

            // rehydrate the player from existing appearance data
            boolean initializing = false;
            if(Player.npcs[i] == null) {
                Player.npcs[i] = new Npc();
                initializing = true;
            }

            // begin registration proper
            Npc npc = Player.npcs[i];
            Player.npcIds[Player.npcCount++] = i;
            npc.anInt3134 = MovedStatics.pulseCycle;

            int initialFaceDirection = playerUpdate.faceDirection;
            int faceDirection = Projectile.directions[initialFaceDirection];
            if(initializing)
                npc.initialFaceDirection = faceDirection;

            int offsetX = playerUpdate.offsetX;
            int offsetY = playerUpdate.offsetY;
            if(offsetX > 15)
                offsetX -= 32;
            if(offsetY > 15)
                offsetY -= 32;

            if (playerUpdate.updateRequired) {
                Player.actorUpdatingIndices[Npc.actorUpdatingIndex++] = i;
            }

            npc.actorDefinition = ActorDefinition.getDefinition(playerUpdate.definitionId);
            npc.turnLeftAnimationId = npc.actorDefinition.rotate90LeftAnimation;
            npc.idleAnimation = npc.actorDefinition.stanceAnimation;
            npc.anInt3083 = npc.actorDefinition.rotateRightAnimation;
            npc.walkAnimationId = npc.actorDefinition.walkAnimation;
            npc.anInt3096 = npc.actorDefinition.boundaryDimension;
            npc.turnAroundAnimationId = npc.actorDefinition.rotate180Animation;
            npc.standTurnAnimationId = npc.actorDefinition.rotateLeftAnimation;
            npc.anInt3113 = npc.actorDefinition.degreesToTurn;
            if(npc.anInt3113 == 0)
                npc.anInt3118 = 0;
            npc.turnRightAnimationId = npc.actorDefinition.rotate90RightAnimation;
            npc.method787(Player.localPlayer.pathX[0] + offsetY, playerUpdate.updateRequired, Player.localPlayer.pathY[0] + offsetX);
        }
    }
}
