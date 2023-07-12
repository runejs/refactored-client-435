package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.UpdatePlayerOptionsInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class UpdatePlayerOptionsMessageDecoder implements MessageDecoder<UpdatePlayerOptionsInboundMessage> {
    @Override
    public UpdatePlayerOptionsInboundMessage decode(PacketBuffer buffer) {
        String option = buffer.getString();
        boolean lowPriority = buffer.getUnsignedByte() == 0;
        int index = buffer.getUnsignedByte();

        return new UpdatePlayerOptionsInboundMessage(index, option, lowPriority);
    }
}
