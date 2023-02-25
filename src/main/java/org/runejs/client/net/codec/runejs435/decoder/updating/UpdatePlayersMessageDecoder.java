package org.runejs.client.net.codec.runejs435.decoder.updating;

import java.util.ArrayList;
import java.util.List;

import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.PlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;
import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate.LocalPlayerMapRegionChangeUpdate;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class UpdatePlayersMessageDecoder implements MessageDecoder<UpdatePlayersInboundMessage> {

    @Override
    public UpdatePlayersInboundMessage decode(PacketBuffer buffer) {
        LocalPlayerMovementUpdate localPlayerMovement = decodeLocalPlayerMovementUpdate(buffer);

        return new UpdatePlayersInboundMessage(
                localPlayerMovement,
                null,
                null,
                null);
    }

    private LocalPlayerMovementUpdate decodeLocalPlayerMovementUpdate(PacketBuffer buffer) {
        buffer.initBitAccess();
        int updateRequired = buffer.getBits(1);

        if (updateRequired == 0) {
            return null;
        }

        int movementType = buffer.getBits(2);
        if (movementType == 0) {
            return null;
        }

        if (movementType == 1) { // Walking
            int walkDirection = buffer.getBits(3);
            int runUpdateBlock = buffer.getBits(1);

            return new LocalPlayerMovementUpdate(
                    new PlayerMovementUpdate(walkDirection, null, runUpdateBlock == 1),
                    null);
        }

        if (movementType == 2) { // Running
            int walkDirection = buffer.getBits(3);
            int runDirection = buffer.getBits(3);
            int runUpdateBlock = buffer.getBits(1);

            return new LocalPlayerMovementUpdate(
                    new PlayerMovementUpdate(walkDirection, runDirection, runUpdateBlock == 1),
                    null);
        }

        if (movementType == 3) { // Map region changed
            int teleporting = buffer.getBits(1);
            int worldLevel = buffer.getBits(2);
            int runUpdateBlock = buffer.getBits(1);
            int localChunkX = buffer.getBits(7);
            int localChunkY = buffer.getBits(7);

            return new LocalPlayerMovementUpdate(
                    null,
                    new LocalPlayerMapRegionChangeUpdate(teleporting == 1, worldLevel, runUpdateBlock == 1, localChunkX,
                            localChunkY));
        }

        throw new IllegalStateException("Invalid movement type: " + movementType);
    }


}
