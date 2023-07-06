package org.runejs.client.net.codec.runejs435.encoder.widget.input;

import org.runejs.client.message.outbound.widget.input.ClickWidgetButtonOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class ClickWidgetButtonMessageEncoder implements MessageEncoder<ClickWidgetButtonOutboundMessage> {
    @Override
    public PacketBuffer encode(ClickWidgetButtonOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(4, 64);
        buffer.putIntBE((message.widgetId << 16) | message.childId);
        return buffer;
    }
}
