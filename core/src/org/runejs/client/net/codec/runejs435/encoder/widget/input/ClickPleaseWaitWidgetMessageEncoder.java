package org.runejs.client.net.codec.runejs435.encoder.widget.input;

import org.runejs.client.message.outbound.widget.input.ClickPleaseWaitWidgetOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;
import org.runejs.client.scene.SceneCluster;

public class ClickPleaseWaitWidgetMessageEncoder implements MessageEncoder<ClickPleaseWaitWidgetOutboundMessage> {
    @Override
    public PacketBuffer encode(ClickPleaseWaitWidgetOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(6, 132);

        buffer.putIntME2((message.widgetId << 16) | message.childId);
        buffer.putShortLE(message.option);

        return buffer;
    }
}
