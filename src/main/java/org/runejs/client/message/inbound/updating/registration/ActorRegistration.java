package org.runejs.client.message.inbound.updating.registration;

/**
 * The update details for a single actor.
 */
public class ActorRegistration {
    /**
     * The index of the actor.
     */
    public final int index;

    /**
     * The offset X coordinate.
     */
    public final int offsetX;

    /**
     * The offset Y coordinate.
     */
    public final int offsetY;

    /**
     * The facing direction of the actor.
     */
    public final int faceDirection;

    /**
     * Whether the actor requires an update.
     */
    public final boolean updateRequired;

    /**
     * Whether to discard the walking queue.
     */
    public final boolean discardWalkingQueue;

    public ActorRegistration(int index, int offsetX, int offsetY, int faceDirection, boolean updateRequired, boolean discardWalkingQueue) {
        this.index = index;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.faceDirection = faceDirection;
        this.updateRequired = updateRequired;
        this.discardWalkingQueue = discardWalkingQueue;
    }
}
