package org.runejs.client.message.outbound;

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

    public static class MinimapWalkTelemetry {
        //     SceneCluster.packetBuffer.putByte(x);
        //     SceneCluster.packetBuffer.putByte(y);
        //     SceneCluster.packetBuffer.putShortBE(GroundItemTile.cameraHorizontal);
        //     SceneCluster.packetBuffer.putByte(57);
        //     SceneCluster.packetBuffer.putByte(Class43.cameraYawOffset);
        //     SceneCluster.packetBuffer.putByte(Class51.mapZoomOffset);
        //     SceneCluster.packetBuffer.putByte(89);
        //     SceneCluster.packetBuffer.putShortBE(Player.localPlayer.worldX);
        //     SceneCluster.packetBuffer.putShortBE(Player.localPlayer.worldY);
        //     SceneCluster.packetBuffer.putByte(Class40_Sub5_Sub15.arbitraryDestination);
        //     SceneCluster.packetBuffer.putByte(63);

//        public final int mouseX;
//        public final int mouseY;
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

    public WalkOutboundMessage(WalkType type, int startX, int startY, boolean running, WalkStep[] steps) {
        this.type = type;
        this.startX = startX;
        this.startY = startY;
        this.running = running;
        this.steps = steps;
    }
}
