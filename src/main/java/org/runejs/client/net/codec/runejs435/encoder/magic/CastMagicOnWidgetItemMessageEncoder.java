package org.runejs.client.net.codec.runejs435.encoder.magic;

import org.runejs.client.message.outbound.magic.CastMagicOnWidgetItemOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;
import org.runejs.client.scene.SceneCluster;

/**
 * A {@link MessageEncoder} for the {@link CastMagicOnWidgetItemOutboundMessage}.
 */
public class CastMagicOnWidgetItemMessageEncoder implements MessageEncoder<CastMagicOnWidgetItemOutboundMessage> {
    @Override
    public PacketBuffer encode(CastMagicOnWidgetItemOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(12, 21);

        SceneCluster.packetBuffer.putIntLE(message.spellId);
        SceneCluster.packetBuffer.putIntME2((message.widgetId << 16) | message.containerId);
        SceneCluster.packetBuffer.putShortBE(message.itemId);
        SceneCluster.packetBuffer.putShortBE(message.slot);

        return buffer;
    }
}
