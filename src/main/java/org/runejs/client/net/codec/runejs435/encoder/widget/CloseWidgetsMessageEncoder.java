package org.runejs.client.net.codec.runejs435.encoder.widget;

import org.runejs.client.message.outbound.widget.CloseWidgetsOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class CloseWidgetsMessageEncoder implements MessageEncoder<CloseWidgetsOutboundMessage> {
    @Override
    public PacketBuffer encode(CloseWidgetsOutboundMessage message) {

        return OutgoingPackets.openFixedSizePacket(0, 176);
    }
}
