package org.runejs.client.net.codec.runejs435.encoder.console;

import org.runejs.client.message.outbound.console.ConsoleCommandOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link ConsoleCommandOutboundMessage}.
 */
public class ConsoleCommandMessageEncoder implements MessageEncoder<ConsoleCommandOutboundMessage> {
    @Override
    public PacketBuffer encode(ConsoleCommandOutboundMessage message) {
        String fullMessage = String.join(" ", message.command);

        // 1 byte per char, plus 1 byte terminator
        int messageLengthBytes = fullMessage.length() + 1;

        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(messageLengthBytes, 246);

        buffer.putString(fullMessage);

        return buffer;
    }
}
