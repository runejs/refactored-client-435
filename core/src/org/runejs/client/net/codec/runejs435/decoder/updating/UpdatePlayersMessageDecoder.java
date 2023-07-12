package org.runejs.client.net.codec.runejs435.decoder.updating;

import java.util.ArrayList;
import java.util.List;

import org.runejs.client.message.inbound.updating.movement.LocalPlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.movement.MovementUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorGroupRegistrationUpdate;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;
import org.runejs.client.message.inbound.updating.movement.LocalPlayerMovementUpdate.LocalPlayerMapRegionChangeUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorRegistration;
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
        ActorGroupMovementUpdate otherPlayersMovement = UpdateDecoderHelpers.decodeGroupMovementUpdate(buffer);
        ActorGroupRegistrationUpdate<ActorRegistration> registerNewPlayers = decodeRegisterNewPlayersUpdate(buffer);
        buffer.finishBitAccess();

        // the remaining bytes in the buffer are the appearance update
        PacketBuffer appearanceUpdate = UpdateDecoderHelpers.decodeRemainingBytes(buffer);

        return new UpdatePlayersInboundMessage(
                localPlayerMovement,
                otherPlayersMovement,
                registerNewPlayers,
                appearanceUpdate);
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
                    new MovementUpdate(walkDirection, null, runUpdateBlock),
                    null);
        }

        // Running
        if (movementType == 2) {
            int walkDirection = buffer.getBits(3);
            int runDirection = buffer.getBits(3);
            boolean runUpdateBlock = buffer.getBits(1) == 1;

            return new LocalPlayerMovementUpdate(
                    new MovementUpdate(walkDirection, runDirection, runUpdateBlock),
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

    /**
     * Decodes the registration details of new players into a {@link ActorGroupRegistrationUpdate}.
     * 
     * @param buffer The buffer.
     * @return The register new players update.
     */
    private ActorGroupRegistrationUpdate<ActorRegistration> decodeRegisterNewPlayersUpdate(PacketBuffer buffer) {
        List<ActorRegistration> updates = new ArrayList<ActorRegistration>();

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
            boolean updateRequired = buffer.getBits(1) == 1;
            boolean discardWalkingQueue = buffer.getBits(1) == 1;

            updates.add(new ActorRegistration(newPlayerIndex, offsetX, offsetY, initialFaceDirection,
                    updateRequired, discardWalkingQueue));
        }

        return new ActorGroupRegistrationUpdate<ActorRegistration>(updates.toArray(new ActorRegistration[updates.size()]));
    }

}
