package org.runejs.client.message.inbound.updating;

/**
 * The update message containing movement updates for all non-local players.
 */
public class OtherPlayersMovementUpdate {
    /**
     * Movement update details for a single non-local player.
     */
    public static class OtherPlayerMovementUpdate {
        /**
         * The local player movement update.
         * 
         * This will be null if the player is not moving.
         */
        public final PlayerMovementUpdate movementUpdate;
    
        /**
         * Whether the player should be deregistered.
         */
        public final boolean shouldDeregister;

        public OtherPlayerMovementUpdate(PlayerMovementUpdate movementUpdate, boolean shouldDeregister) {
            this.movementUpdate = movementUpdate;
            this.shouldDeregister = shouldDeregister;
        }
    }

    /**
     * The number of players contained in this update.
     */
    public final int playerCount;

    /**
     * The movement updates for each player.
     */
    public final OtherPlayerMovementUpdate[] movementUpdates;

    public OtherPlayersMovementUpdate(int playerCount, OtherPlayerMovementUpdate[] movementUpdates) {
        this.playerCount = playerCount;
        this.movementUpdates = movementUpdates;
    }
}
