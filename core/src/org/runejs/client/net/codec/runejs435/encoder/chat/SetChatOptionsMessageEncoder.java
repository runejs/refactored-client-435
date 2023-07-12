package org.runejs.client.net.codec.runejs435.encoder.chat;

import org.runejs.client.message.outbound.chat.SetChatOptionsOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class SetChatOptionsMessageEncoder implements MessageEncoder<SetChatOptionsOutboundMessage> {
    @Override
    public PacketBuffer encode(SetChatOptionsOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(3, 32);

        buffer.putByte(message.publicMode);
        buffer.putByte(message.privateMode);
        buffer.putByte(message.tradeMode);

        return buffer;
    }
}
