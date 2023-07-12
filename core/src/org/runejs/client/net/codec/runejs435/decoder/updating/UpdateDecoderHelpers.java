package org.runejs.client.net.codec.runejs435.decoder.updating;

import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.movement.MovementUpdate;
import org.runejs.client.net.PacketBuffer;

import java.util.ArrayList;
import java.util.List;

public class UpdateDecoderHelpers {

    /**
     * Decodes the remaining bytes in the buffer into a new buffer
     *
     * This is used for the appearance update
     *
     * @param buffer The buffer to decode the remaining bytes from
     * @return A new buffer containing the remaining bytes
     */
    public static PacketBuffer decodeRemainingBytes(PacketBuffer buffer) {
        // 5000 bytes is the length previously used in IncomingPackets
        // we can probably refactor to use a smaller/dynamic length in future
        int REMAINING_BYTES_LENGTH = 5000;

        int remainingBytes = buffer.getSize() - buffer.currentPosition;
        PacketBuffer remainingBuffer = new PacketBuffer(REMAINING_BYTES_LENGTH);
        System.arraycopy(buffer.buffer, buffer.currentPosition, remainingBuffer.buffer, 0, remainingBytes);
        remainingBuffer.currentPosition = 0;

        return remainingBuffer;
    }

    /**
     * Decodes a group movement update for a group of actors.
     * @param buffer The buffer to read
     * @return The {@link ActorGroupMovementUpdate}
     */
    public static ActorGroupMovementUpdate decodeGroupMovementUpdate(PacketBuffer buffer) {
        int trackedPlayerCount = buffer.getBits(8);

        List<ActorGroupMovementUpdate.ActorMovementUpdate> updates = new ArrayList<>();

        for (int i = 0; trackedPlayerCount > i; i++) {
            boolean updateRequired = buffer.getBits(1) == 1;

            // No update required
            if (!updateRequired) {
                updates.add(null);
                continue;
            }

            int movementType = buffer.getBits(2);

            // No movement
            if (movementType == 0) {
                updates.add(new ActorGroupMovementUpdate.ActorMovementUpdate(null, false));
                continue;
            }

            // deregister
            if (movementType == 3) {
                updates.add(new ActorGroupMovementUpdate.ActorMovementUpdate(null, true));
                continue;
            }

            // walking
            if (movementType == 1) {
                int walkDirection = buffer.getBits(3);
                boolean runUpdateBlock = buffer.getBits(1) == 1;

                updates.add(new ActorGroupMovementUpdate.ActorMovementUpdate(
                    new MovementUpdate(walkDirection, null, runUpdateBlock), false));
                continue;
            }

            // running
            if (movementType == 2) {
                int walkDirection = buffer.getBits(3);
                int runDirection = buffer.getBits(3);
                boolean runUpdateBlock = buffer.getBits(1) == 1;

                updates.add(new ActorGroupMovementUpdate.ActorMovementUpdate(
                    new MovementUpdate(walkDirection, runDirection, runUpdateBlock), false));
                continue;
            }

            throw new IllegalStateException("Invalid movement type: " + movementType);
        }

        return new ActorGroupMovementUpdate(trackedPlayerCount, updates.toArray(new ActorGroupMovementUpdate.ActorMovementUpdate[updates.size()]));
    }
}
