package org.runejs.client.net.codec.runejs435.encoder.widget.input;

import org.runejs.client.message.outbound.widget.input.SubmitChatboxWidgetNumericInputOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class SubmitChatboxWidgetNumericInputMessageEncoder implements MessageEncoder<SubmitChatboxWidgetNumericInputOutboundMessage> {
    @Override
    public PacketBuffer encode(SubmitChatboxWidgetNumericInputOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(4, 238);

        buffer.putIntBE(message.value);

        return buffer;
    }
}
