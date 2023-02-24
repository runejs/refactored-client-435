package org.runejs.client.net.codec.runejs435.decoder;

import org.runejs.client.message.inbound.ReceiveChatboxMessageInboundMessage;
import org.runejs.client.message.inbound.ReceivePrivateMessageInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link ReceiveChatboxMessageInboundMessage}s.
 */
public class ReceiveChatboxMessageDecoder implements MessageDecoder<ReceiveChatboxMessageInboundMessage> {
    @Override
    public ReceiveChatboxMessageInboundMessage decode(PacketBuffer buffer) {
        String message = buffer.getString();

        return new ReceiveChatboxMessageInboundMessage(message);
    }
}
