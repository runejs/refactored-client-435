package org.runejs.client.message.inbound.updating;

public class LocalPlayerMovementUpdate {
        /**
     * The map region change update for the local player.
     * 
     * Used when the player is teleporting or changing levels (movement type 3)
     */
    public static class LocalPlayerMapRegionChangeUpdate {
        /**
         * Whether the player is teleporting.
         */
        public final boolean teleporting;

        /**
         * The world level.
         */
        public final int level;

        /**
         * The local chunk X coordinate.
         */
        public final int localChunkX;

        /**
         * The local chunk Y coordinate.
         */
        public final int localChunkY;

        /**
         * Whether to run the update block.
         */
        public final boolean runUpdateBlock;

        public LocalPlayerMapRegionChangeUpdate(boolean teleporting, int level, boolean runUpdateBlock, int localChunkX, int localChunkY) {
            this.teleporting = teleporting;
            this.level = level;
            this.runUpdateBlock = runUpdateBlock;
            this.localChunkX = localChunkX;
            this.localChunkY = localChunkY;
        }
    }

    /**
     * The local player movement update.
     * 
     * This will be null if the player is not moving.
     */
    public final PlayerMovementUpdate movementUpdate;

    /**
     * The local player map region change update.
     * 
     * This will be null if the player does not need to change map regions.
     */
    public final LocalPlayerMapRegionChangeUpdate mapRegionUpdate;

    public LocalPlayerMovementUpdate(PlayerMovementUpdate movementUpdate, LocalPlayerMapRegionChangeUpdate mapRegionUpdate) {
        if (movementUpdate != null && mapRegionUpdate != null)
            throw new IllegalArgumentException("Cannot have both a local player movement update and a local player map region change update.");

        this.movementUpdate = movementUpdate;
        this.mapRegionUpdate = mapRegionUpdate;
    }
}
