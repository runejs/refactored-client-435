package org.runejs.client.message.inbound.updating;

public class RegisterNewPlayersUpdate {
    public static class RegisterNewPlayerUpdate {
        public final int playerIndex;
        public final int offsetX;
        public final int offsetY;
        public final int faceDirection;
        public final boolean updateRequired;
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

    public final RegisterNewPlayerUpdate[] players;

    public RegisterNewPlayersUpdate(RegisterNewPlayerUpdate[] players) {
        this.players = players;
    }
}
