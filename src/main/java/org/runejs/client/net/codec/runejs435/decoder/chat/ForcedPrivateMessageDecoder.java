package org.runejs.client.net.codec.runejs435.decoder.chat;

import org.runejs.client.RSString;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.message.inbound.chat.ForcedPrivateMessageInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link ForcedPrivateMessageInboundMessage}s.
 */
public class ForcedPrivateMessageDecoder implements MessageDecoder<ForcedPrivateMessageInboundMessage> {
    @Override
    public ForcedPrivateMessageInboundMessage decode(PacketBuffer buffer) {
        long username = buffer.getLongBE();
        String message = RSString.formatChatString(KeyFocusListener.method956(buffer));

        return new ForcedPrivateMessageInboundMessage(username, message);
    }
}
