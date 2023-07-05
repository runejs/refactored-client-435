package org.runejs.client.net.codec.runejs435.decoder.updating;

import org.runejs.client.message.inbound.updating.UpdateNPCsInboundMessage;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.movement.MovementUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorGroupRegistrationUpdate;
import org.runejs.client.message.inbound.updating.registration.NPCRegistration;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

import java.util.ArrayList;
import java.util.List;

public class UpdateNPCsMessageDecoder implements MessageDecoder<UpdateNPCsInboundMessage> {
    @Override
    public UpdateNPCsInboundMessage decode(PacketBuffer buffer) {
        ActorGroupMovementUpdate trackedMovement = decodeTrackedMovement(buffer);
        ActorGroupRegistrationUpdate<NPCRegistration> newNPCs = decodeRegistration(buffer);

        // the remaining bytes in the buffer are the appearance update
        PacketBuffer appearanceUpdate = UpdateDecoderHelpers.decodeRemainingBytes(buffer);

        return new UpdateNPCsInboundMessage(trackedMovement, newNPCs, appearanceUpdate);
    }

    private ActorGroupMovementUpdate decodeTrackedMovement(PacketBuffer buffer) {
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

    private ActorGroupRegistrationUpdate<NPCRegistration> decodeRegistration(PacketBuffer buffer) {
        List<NPCRegistration> updates = new ArrayList<>();

        while (buffer.getRemainingBits(buffer.getSize()) >= 27) {
            int index = buffer.getBits(15);

            if (index == 32767)
                break;

            int initialFaceDirection = buffer.getBits(3);

            int offsetX = buffer.getBits(5);
            int offsetY = buffer.getBits(5);
            if (offsetX > 15)
                offsetX -= 32;
            if (offsetY > 15)
                offsetY -= 32;

            boolean updateRequired = buffer.getBits(1) == 1;
            boolean discardWalkingQueue = buffer.getBits(1) == 1;

            int definitionId = buffer.getBits(13);

            updates.add(new NPCRegistration(index, offsetX, offsetY, initialFaceDirection,
                updateRequired, discardWalkingQueue, definitionId));
        }

        return new ActorGroupRegistrationUpdate<>(updates.toArray(new NPCRegistration[updates.size()]));
    }
}
