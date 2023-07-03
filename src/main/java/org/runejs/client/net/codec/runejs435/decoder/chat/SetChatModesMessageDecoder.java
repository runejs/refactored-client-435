package org.runejs.client.net.codec.runejs435.decoder.chat;

import org.runejs.client.message.inbound.chat.SetChatModesInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link SetChatModesInboundMessage}s.
 */
public class SetChatModesMessageDecoder implements MessageDecoder<SetChatModesInboundMessage> {
    @Override
    public SetChatModesInboundMessage decode(PacketBuffer buffer) {
        int publicChatMode = buffer.getUnsignedByte();
        int privateChatMode = buffer.getUnsignedByte();
        int tradeMode = buffer.getUnsignedByte();

        return new SetChatModesInboundMessage(publicChatMode, privateChatMode, tradeMode);
    }
}
