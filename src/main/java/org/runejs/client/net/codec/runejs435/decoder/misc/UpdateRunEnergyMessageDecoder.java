package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.UpdateRunEnergyMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link UpdateRunEnergyMessage}s.
 */
public class UpdateRunEnergyMessageDecoder implements MessageDecoder<UpdateRunEnergyMessage> {
    @Override
    public UpdateRunEnergyMessage decode(PacketBuffer buffer) {
        int amount = buffer.getUnsignedByte();

        return new UpdateRunEnergyMessage(amount);
    }
}
