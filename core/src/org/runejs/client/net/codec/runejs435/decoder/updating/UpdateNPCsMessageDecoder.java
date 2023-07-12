package org.runejs.client.net.codec.runejs435.decoder.updating;

import org.runejs.client.message.inbound.updating.UpdateNPCsInboundMessage;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorGroupRegistrationUpdate;
import org.runejs.client.message.inbound.updating.registration.NPCRegistration;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

import java.util.ArrayList;
import java.util.List;

public class UpdateNPCsMessageDecoder implements MessageDecoder<UpdateNPCsInboundMessage> {
    @Override
    public UpdateNPCsInboundMessage decode(PacketBuffer buffer) {
        buffer.initBitAccess();
        ActorGroupMovementUpdate trackedMovement = UpdateDecoderHelpers.decodeGroupMovementUpdate(buffer);
        ActorGroupRegistrationUpdate<NPCRegistration> newNPCs = decodeRegistration(buffer);
        buffer.finishBitAccess();

        // the remaining bytes in the buffer are the appearance update
        PacketBuffer appearanceUpdate = UpdateDecoderHelpers.decodeRemainingBytes(buffer);

        return new UpdateNPCsInboundMessage(trackedMovement, newNPCs, appearanceUpdate);
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
