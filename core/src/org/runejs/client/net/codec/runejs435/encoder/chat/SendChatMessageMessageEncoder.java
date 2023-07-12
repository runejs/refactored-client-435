package org.runejs.client.net.codec.runejs435.encoder.chat;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.outbound.chat.SendChatMessageOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.VariableLengthPacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} that encodes {@link SendChatMessageOutboundMessage}s.
 * 
 * This is used to send chat messages to the server.
 */
public class SendChatMessageMessageEncoder implements MessageEncoder<SendChatMessageOutboundMessage> {
    @Override
    public PacketBuffer encode(SendChatMessageOutboundMessage message) {
        VariableLengthPacketBuffer buffer = OutgoingPackets.openVariableSizePacket(75);

        buffer.putByte(message.chatColorEffect.getNetworkCode());
        buffer.putByte(message.chatShapeEffect.getNetworkCode());

        // probably putString?
        MovedStatics.method1052(message.message, buffer);

        buffer.writePacketLength();

        return buffer;
    }
}
