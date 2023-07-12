package org.runejs.client.net.codec.runejs435.decoder.chat;

import org.runejs.client.message.inbound.chat.UpdateIgnoreListInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class UpdateIgnoreListMessageDecoder implements MessageDecoder<UpdateIgnoreListInboundMessage> {
    @Override
    public UpdateIgnoreListInboundMessage decode(PacketBuffer buffer) {
        int count = buffer.getSize() / 8;

        long[] ignores = new long[count];
        for (int i = 0; i < count; i++) {
            ignores[i] = buffer.getLongBE();
        }

        return new UpdateIgnoreListInboundMessage(ignores);
    }
}
