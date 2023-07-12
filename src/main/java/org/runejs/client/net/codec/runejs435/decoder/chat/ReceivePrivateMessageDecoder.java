package org.runejs.client.net.codec.runejs435.decoder.chat;

import org.runejs.client.MovedStatics;
import org.runejs.client.RSString;
import org.runejs.client.message.inbound.chat.ReceivePrivateMessageInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link ReceivePrivateMessageInboundMessage}s.
 */
public class ReceivePrivateMessageDecoder implements MessageDecoder<ReceivePrivateMessageInboundMessage> {
    @Override
    public ReceivePrivateMessageInboundMessage decode(PacketBuffer buffer) {
        long fromPlayerIndex = buffer.getLongBE();
        long chatIdModifier = buffer.getUnsignedShortBE();
        long privateMessageCounter = buffer.getMediumBE();
        int fromPlayerRights = buffer.getUnsignedByte();

        // TODO (Jameskmonger) previously the client would only call this if the message was actually visible to the
        //                  player. I suspect that's just a performance thing, so we probably don't need to worry anymore.
        String privateMessage = RSString.formatChatString(MovedStatics.method956(buffer));

        return new ReceivePrivateMessageInboundMessage(chatIdModifier, privateMessageCounter, fromPlayerIndex, fromPlayerRights, privateMessage);
    }
}
