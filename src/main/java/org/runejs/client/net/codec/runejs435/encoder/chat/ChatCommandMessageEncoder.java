package org.runejs.client.net.codec.runejs435.encoder.chat;

import org.runejs.client.message.outbound.chat.ChatCommandOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.VariableLengthPacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link ChatCommandOutboundMessage}.
 */
public class ChatCommandMessageEncoder implements MessageEncoder<ChatCommandOutboundMessage> {
    @Override
    public PacketBuffer encode(ChatCommandOutboundMessage message) {
        VariableLengthPacketBuffer buffer = OutgoingPackets.openVariableSizePacket(248);

        buffer.putString(message.command);

        buffer.writePacketLength();

        return buffer;
    }
}
