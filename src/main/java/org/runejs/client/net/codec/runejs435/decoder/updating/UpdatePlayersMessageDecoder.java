package org.runejs.client.net.codec.runejs435.decoder.updating;

import java.util.ArrayList;
import java.util.List;

import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.OtherPlayersMovementUpdate;
import org.runejs.client.message.inbound.updating.PlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.RegisterNewPlayersUpdate;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;
import org.runejs.client.message.inbound.updating.LocalPlayerMovementUpdate.LocalPlayerMapRegionChangeUpdate;
import org.runejs.client.message.inbound.updating.OtherPlayersMovementUpdate.OtherPlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.RegisterNewPlayersUpdate.RegisterNewPlayerUpdate;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class UpdatePlayersMessageDecoder implements MessageDecoder<UpdatePlayersInboundMessage> {

    @Override
    public UpdatePlayersInboundMessage decode(PacketBuffer buffer) {
        buffer.initBitAccess();
        LocalPlayerMovementUpdate localPlayerMovement = decodeLocalPlayerMovementUpdate(buffer);
        OtherPlayersMovementUpdate otherPlayersMovement = decodeOtherPlayersMovementUpdate(buffer);
        RegisterNewPlayersUpdate registerNewPlayers = decodeRegisterNewPlayersUpdate(buffer);
        buffer.finishBitAccess();

        PacketBuffer remainingBuffer = decodeRemainingBytes(buffer);

        return new UpdatePlayersInboundMessage(
                localPlayerMovement,
                otherPlayersMovement,
                registerNewPlayers,
                remainingBuffer);
    }

    private LocalPlayerMovementUpdate decodeLocalPlayerMovementUpdate(PacketBuffer buffer) {
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

    private OtherPlayersMovementUpdate decodeOtherPlayersMovementUpdate(PacketBuffer buffer) {
        int trackedPlayerCount = buffer.getBits(8);

        List<OtherPlayerMovementUpdate> updates = new ArrayList<OtherPlayerMovementUpdate>();

        for (int i = 0; trackedPlayerCount > i; i++) {
            int updateRequired = buffer.getBits(1);

            if (updateRequired == 0) {
                updates.add(new OtherPlayerMovementUpdate(null, false));
                continue;
            }

            int movementType = buffer.getBits(2);
            if (movementType == 0) { // No movement
                updates.add(new OtherPlayerMovementUpdate(null, false));
                continue;
            }

            if (movementType == 3) { // deregister
                updates.add(new OtherPlayerMovementUpdate(null, true));
                continue;
            }

            if (movementType == 1) { // walking
                int walkDirection = buffer.getBits(3);
                int runUpdateBlock = buffer.getBits(1);

                updates.add(new OtherPlayerMovementUpdate(
                        new PlayerMovementUpdate(walkDirection, null, runUpdateBlock == 1), false));
                continue;
            }

            if (movementType == 2) { // running
                int walkDirection = buffer.getBits(3);
                int runDirection = buffer.getBits(3);
                int runUpdateBlock = buffer.getBits(1);

                updates.add(new OtherPlayerMovementUpdate(
                        new PlayerMovementUpdate(walkDirection, runDirection, runUpdateBlock == 1), false));
                continue;
            }

            throw new IllegalStateException("Invalid movement type: " + movementType);
        }

        return new OtherPlayersMovementUpdate(trackedPlayerCount,
                updates.toArray(new OtherPlayerMovementUpdate[updates.size()]));
    }

    private RegisterNewPlayersUpdate decodeRegisterNewPlayersUpdate(PacketBuffer buffer) {
        List<RegisterNewPlayerUpdate> updates = new ArrayList<RegisterNewPlayerUpdate>();

        while (buffer.getRemainingBits(buffer.getSize()) >= 11) {
            int newPlayerIndex = buffer.getBits(11);

            if (newPlayerIndex == 2047)
                break;

            int offsetX = buffer.getBits(5);
            int offsetY = buffer.getBits(5);
            if (offsetX > 15)
                offsetX -= 32;
            if (offsetY > 15)
                offsetY -= 32;
            int initialFaceDirection = buffer.getBits(3);
            int updateRequired = buffer.getBits(1);
            int discardWalkingQueue = buffer.getBits(1);

            updates.add(new RegisterNewPlayerUpdate(newPlayerIndex, offsetX, offsetY, initialFaceDirection,
                    updateRequired == 1, discardWalkingQueue == 1));
        }

        return new RegisterNewPlayersUpdate(updates.toArray(new RegisterNewPlayerUpdate[updates.size()]));
    }

    private PacketBuffer decodeRemainingBytes(PacketBuffer buffer) {
        int remainingBytes = buffer.getSize() - buffer.currentPosition;
        PacketBuffer remainingBuffer = new PacketBuffer(remainingBytes);
        System.arraycopy(buffer.buffer, buffer.currentPosition, remainingBuffer.buffer, 0, remainingBytes);
        remainingBuffer.currentPosition = 0;

        return remainingBuffer;
    }

}
