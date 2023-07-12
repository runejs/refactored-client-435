package org.runejs.client.net.codec.runejs435.encoder.misc;

import org.runejs.client.message.outbound.misc.ClickFlashingTabIconOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class ClickFlashingTabIconMessageEncoder implements MessageEncoder<ClickFlashingTabIconOutboundMessage> {
    @Override
    public PacketBuffer encode(ClickFlashingTabIconOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(1, 44);

        buffer.putByte(message.tabId);

        return buffer;
    }
}
