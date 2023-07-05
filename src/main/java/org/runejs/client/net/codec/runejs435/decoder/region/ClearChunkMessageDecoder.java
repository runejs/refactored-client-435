package org.runejs.client.net.codec.runejs435.decoder.region;

import org.runejs.client.message.inbound.region.ClearChunkInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes a {@link ClearChunkInboundMessage} from a {@link PacketBuffer}.
 */
public class ClearChunkMessageDecoder implements MessageDecoder<ClearChunkInboundMessage> {
    @Override
    public ClearChunkInboundMessage decode(PacketBuffer buffer) {
        int y = buffer.getUnsignedByte();
        int x = buffer.getUnsignedByte();

        return new ClearChunkInboundMessage(x, y);
    }
}
