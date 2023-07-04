package org.runejs.client.message.inbound.updating;

/**
 * The update message containing details about new players that should be registered.
 */
public class RegisterNewPlayersUpdate {
    /**
     * The update details for a single new player.
     */
    public static class RegisterNewPlayerUpdate {
        /**
         * The index of the player.
         */
        public final int playerIndex;

        /**
         * The offset X coordinate.
         */
        public final int offsetX;

        /**
         * The offset Y coordinate.
         */
        public final int offsetY;

        /**
         * The facing direction of the player.
         */
        public final int faceDirection;

        /**
         * Whether the player requires an update.
         */
        public final boolean updateRequired;

        /**
         * Whether to discard the walking queue.
         */
        public final boolean discardWalkingQueue;

        public RegisterNewPlayerUpdate(int playerIndex, int offsetX, int offsetY, int faceDirection, boolean updateRequired, boolean discardWalkingQueue) {
            this.playerIndex = playerIndex;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.faceDirection = faceDirection;
            this.updateRequired = updateRequired;
            this.discardWalkingQueue = discardWalkingQueue;
        }
    }

    /**
     * The list of new players that should be registered.
     */
    public final RegisterNewPlayerUpdate[] players;

    public RegisterNewPlayersUpdate(RegisterNewPlayerUpdate[] players) {
        this.players = players;
    }
}
