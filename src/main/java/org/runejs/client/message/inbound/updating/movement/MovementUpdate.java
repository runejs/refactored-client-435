package org.runejs.client.message.inbound.updating.movement;

/**
 * The standard movement update for a player or NPC.
 * 
 * Used when the actor is walking or running (movement types 1 and 2)
 */
public class MovementUpdate {
    /**
     * The walk direction.
     */
    public final int walkDirection;

    /**
     * The run direction.
     * 
     * This is an Integer because it can be null if the actor is not running.
     */
    public final Integer runDirection;

    /**
     * Whether to run the update block.
     */
    public final boolean runUpdateBlock;

    public MovementUpdate(int walkDirection, Integer runDirection, boolean runUpdateBlock) {
        this.walkDirection = walkDirection;
        this.runDirection = runDirection;
        this.runUpdateBlock = runUpdateBlock;
    }
}
