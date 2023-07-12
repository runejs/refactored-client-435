package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.UpdateCarryWeightMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link UpdateCarryWeightMessage}s.
 */
public class UpdateCarryWeightMessageDecoder implements MessageDecoder<UpdateCarryWeightMessage> {
    @Override
    public UpdateCarryWeightMessage decode(PacketBuffer buffer) {
        int amount = buffer.getShortBE();

        return new UpdateCarryWeightMessage(amount);
    }
}
