package org.runejs.client.net.codec.runejs435.decoder.region;

import org.runejs.client.message.inbound.region.UpdateReferencePositionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes an {@link UpdateReferencePositionInboundMessage} from a {@link PacketBuffer}.
 */
public class UpdateReferencePositionMessageDecoder implements MessageDecoder<UpdateReferencePositionInboundMessage> {
    @Override
    public UpdateReferencePositionInboundMessage decode(PacketBuffer buffer) {
        int y = buffer.getUnsignedByte();
        int x = buffer.getUnsignedByte();

        return new UpdateReferencePositionInboundMessage(x, y);
    }
}
