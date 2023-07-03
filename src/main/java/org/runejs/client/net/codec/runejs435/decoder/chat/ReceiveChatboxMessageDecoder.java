package org.runejs.client.net.codec.runejs435.decoder.chat;

import org.runejs.client.message.inbound.chat.ReceiveChatboxMessageInboundMessage;
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
