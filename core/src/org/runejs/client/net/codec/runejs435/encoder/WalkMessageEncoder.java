package org.runejs.client.net.codec.runejs435.encoder;

import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.outbound.WalkOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.VariableLengthPacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.SceneCluster;

public class WalkMessageEncoder implements MessageEncoder<WalkOutboundMessage> {
    @Override
    public PacketBuffer encode(WalkOutboundMessage message) {
        VariableLengthPacketBuffer buffer = OutgoingPackets.openVariableSizePacket(this.getOpcodeForWalkType(message.type));

        buffer.putShortLE(message.startY);
        buffer.putByte(message.running ? 1 : 0);
        buffer.putShortLE(message.startX);

        for(WalkOutboundMessage.WalkStep step : message.steps) {
            if (step == null) {
                continue;
            }

            buffer.putByte(step.x);
            buffer.putByte(step.y);
        }

        // Minimap walking has analytic data attached
        if (message.type == WalkOutboundMessage.WalkType.MAP) {
            this.writeMinimapAnalytics(message, buffer);
        }

        buffer.writePacketLength();

        return buffer;
    }

    private int getOpcodeForWalkType(WalkOutboundMessage.WalkType walkType) {
        if (walkType == WalkOutboundMessage.WalkType.TILE) {
            return 73;
        }

        if (walkType == WalkOutboundMessage.WalkType.INTERACTION) {
            return 89;
        }

        if (walkType == WalkOutboundMessage.WalkType.MAP) {
            return 236;
        }

        throw new RuntimeException("Unhandled walk type");
    }

    /**
     * Write "analytic" data related to minimap walking, likely used to combat bots.
     */
    private void writeMinimapAnalytics(WalkOutboundMessage message, PacketBuffer buffer) {
        if (message.minimapWalkAnalytics == null) {
            throw new RuntimeException("No analytics for minimap walk");
        }

        Pathfinding.MinimapWalkAnalytics analytics = message.minimapWalkAnalytics;

        buffer.putByte(analytics.minimapClickX);
        buffer.putByte(analytics.minimapClickY);
        buffer.putShortBE(analytics.cameraYaw);
        buffer.putByte(analytics.magicA);
        buffer.putByte(analytics.minimapRandomRotation);
        buffer.putByte(analytics.minimapRandomZoom);
        buffer.putByte(analytics.magicB);
        buffer.putShortBE(analytics.worldX);
        buffer.putShortBE(analytics.worldY);
        buffer.putByte(analytics.usedDeepSearch ? 1 : 0);
        buffer.putByte(analytics.magicC);
    }
}
