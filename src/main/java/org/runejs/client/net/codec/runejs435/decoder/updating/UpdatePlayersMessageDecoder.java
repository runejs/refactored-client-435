package org.runejs.client.net.codec.runejs435.decoder.updating;

import java.util.ArrayList;
import java.util.List;

import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.PlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;
import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate.LocalPlayerMapRegionChangeUpdate;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes the {@link UpdatePlayersInboundMessage}.
 * 
 * This message is sent by the server to update the local player and
 * other surrounding players.
 */
public class UpdatePlayersMessageDecoder implements MessageDecoder<UpdatePlayersInboundMessage> {

    /**
     * Decodes a {@link PacketBuffer} into a {@link UpdatePlayersInboundMessage},
     * which can then be processed by the game.
     */
    @Override
    public UpdatePlayersInboundMessage decode(PacketBuffer buffer) {
        buffer.initBitAccess();
        LocalPlayerMovementUpdate localPlayerMovement = decodeLocalPlayerMovementUpdate(buffer);
        buffer.finishBitAccess();

        return new UpdatePlayersInboundMessage(
                localPlayerMovement,
                null,
                null,
                null);
    }

    /**
     * Decodes the local player movement update.
     * 
     * @param buffer The buffer.
     * @return The local player movement update.
     */
    private LocalPlayerMovementUpdate decodeLocalPlayerMovementUpdate(PacketBuffer buffer) {
        boolean updateRequired = buffer.getBits(1) == 1;

        // No update required
        if (!updateRequired) {
            return null;
        }

        int movementType = buffer.getBits(2);

        // No movement
        if (movementType == 0) {
            return new LocalPlayerMovementUpdate(null, null);
        }
        
        // Walking
        if (movementType == 1) {
            int walkDirection = buffer.getBits(3);
            boolean runUpdateBlock = buffer.getBits(1) == 1;

            return new LocalPlayerMovementUpdate(
                    new PlayerMovementUpdate(walkDirection, null, runUpdateBlock),
                    null);
        }

        // Running
        if (movementType == 2) {
            int walkDirection = buffer.getBits(3);
            int runDirection = buffer.getBits(3);
            boolean runUpdateBlock = buffer.getBits(1) == 1;

            return new LocalPlayerMovementUpdate(
                    new PlayerMovementUpdate(walkDirection, runDirection, runUpdateBlock),
                    null);
        }

        // Map region changed
        if (movementType == 3) {
            boolean teleporting = buffer.getBits(1) == 1;
            int worldLevel = buffer.getBits(2);
            boolean runUpdateBlock = buffer.getBits(1) == 1;
            int localChunkX = buffer.getBits(7);
            int localChunkY = buffer.getBits(7);

            return new LocalPlayerMovementUpdate(
                    null,
                    new LocalPlayerMapRegionChangeUpdate(teleporting, worldLevel, runUpdateBlock, localChunkX,
                            localChunkY));
        }

        throw new IllegalStateException("Invalid movement type: " + movementType);
    }


}
