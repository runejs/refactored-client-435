package org.runejs.client.message.inbound.updating;

/**
 * The standard movement update for a player.
 * 
 * Used when the player is walking or running (movement types 1 and 2)
 */
public class PlayerMovementUpdate {
    /**
     * The walk direction.
     */
    public final int walkDirection;

    /**
     * The run direction.
     * 
     * This is an Integer because it can be null if the player is not running.
     */
    public final Integer runDirection;

    /**
     * Whether to run the update block.
     */
    public final boolean runUpdateBlock;

    public PlayerMovementUpdate(int walkDirection, Integer runDirection, boolean runUpdateBlock) {
        this.walkDirection = walkDirection;
        this.runDirection = runDirection;
        this.runUpdateBlock = runUpdateBlock;
    }
}
