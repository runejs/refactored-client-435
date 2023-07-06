package org.runejs.client.net.codec.runejs435.encoder.widget.input;

import org.runejs.client.message.outbound.widget.input.SubmitChatboxWidgetNameInputOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class SubmitChatboxWidgetNameInputMessageEncoder implements MessageEncoder<SubmitChatboxWidgetNameInputOutboundMessage> {
    @Override
    public PacketBuffer encode(SubmitChatboxWidgetNameInputOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(8, 86);

        buffer.putLongBE(message.name);

        return buffer;
    }
}
