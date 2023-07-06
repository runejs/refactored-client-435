package org.runejs.client.net.codec.runejs435.encoder.widget.input;

import org.runejs.client.message.outbound.widget.input.SubmitReportAbuseOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class SubmitReportAbuseMessageEncoder implements MessageEncoder<SubmitReportAbuseOutboundMessage> {
    @Override
    public PacketBuffer encode(SubmitReportAbuseOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(10, 202);

        buffer.putLongBE(message.name);
        buffer.putByte(message.reason);
        buffer.putByte(message.mutePlayer ? 1 : 0);
        return null;
    }
}
