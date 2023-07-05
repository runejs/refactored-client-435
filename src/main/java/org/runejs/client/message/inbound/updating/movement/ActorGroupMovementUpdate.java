package org.runejs.client.message.inbound.updating.movement;

/**
 * The update message containing movement updates for a group of actors.
 */
public class ActorGroupMovementUpdate {
    /**
     * Movement update details for a single actor.
     */
    public static class ActorMovementUpdate {
        /**
         * The actor's movement update.
         * 
         * This will be null if the actor is not moving.
         */
        public final MovementUpdate movementUpdate;
    
        /**
         * Whether the actor should be deregistered.
         */
        public final boolean shouldDeregister;

        public ActorMovementUpdate(MovementUpdate movementUpdate, boolean shouldDeregister) {
            this.movementUpdate = movementUpdate;
            this.shouldDeregister = shouldDeregister;
        }
    }

    /**
     * The number of actor contained in this update.
     */
    public final int actorCount;

    /**
     * The movement updates for each actor.
     */
    public final ActorMovementUpdate[] movementUpdates;

    public ActorGroupMovementUpdate(int actorCount, ActorMovementUpdate[] movementUpdates) {
        this.actorCount = actorCount;
        this.movementUpdates = movementUpdates;
    }
}
