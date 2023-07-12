package org.runejs.client.message.outbound;

import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.message.OutboundMessage;

public class WalkOutboundMessage implements OutboundMessage {
    public enum WalkType {
        /**
         * A walk initiated by clicking on a tile in the 3d view
         */
        TILE,

        /**
         * A walk initiated by clicking on the minimap
         */
        MAP,

        /**
         * A walk initiated as a result of interacting with something
         */
        INTERACTION
    }

    public static class WalkStep {
        public final int x;
        public final int y;

        public WalkStep(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public final WalkType type;

    /**
     * The starting X coordinate
     */
    public final int startX;

    /**
     * The starting Y coordinate
     */
    public final int startY;

    /**
     * Whether running has been forced on for this walk.
     *
     * TODO (James) is this the best name for it? It doesn't reflect run status but rather ctrl+click
     */
    public final boolean running;

    public final WalkStep[] steps;

    /**
     * Minimap walking has analytics, likely used for anti-cheat
     * 
     * Null if not a minimap walk
     */
    public final Pathfinding.MinimapWalkAnalytics minimapWalkAnalytics;

    public WalkOutboundMessage(WalkType type, int startX, int startY, boolean running, WalkStep[] steps, Pathfinding.MinimapWalkAnalytics minimapWalkAnalytics) {
        this.type = type;
        this.startX = startX;
        this.startY = startY;
        this.running = running;
        this.steps = steps;
        this.minimapWalkAnalytics = minimapWalkAnalytics;
    }
}
