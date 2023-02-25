package org.runejs.client.message.inbound.updating;

public class OtherPlayersMovementUpdate {
    public static class OtherPlayerMovementUpdate {

        /**
         * The local player movement update.
         * 
         * This will be null if the player is not moving.
         */
        public final PlayerMovementUpdate movementUpdate;
    
        public final boolean shouldDeregister;

        public OtherPlayerMovementUpdate(PlayerMovementUpdate movementUpdate, boolean shouldDeregister) {
            this.movementUpdate = movementUpdate;
            this.shouldDeregister = shouldDeregister;
        }
    }

    public final int playerCount;
    public final OtherPlayerMovementUpdate[] movementUpdates;

    public OtherPlayersMovementUpdate(int playerCount, OtherPlayerMovementUpdate[] movementUpdates) {
        this.playerCount = playerCount;
        this.movementUpdates = movementUpdates;
    }
}
