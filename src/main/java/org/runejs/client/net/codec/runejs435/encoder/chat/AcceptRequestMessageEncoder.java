package org.runejs.client.net.codec.runejs435.encoder.chat;

import org.runejs.client.message.outbound.chat.AcceptRequestOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * A {@link MessageEncoder} for the {@link AcceptRequestOutboundMessage}.
 */
public class AcceptRequestMessageEncoder implements MessageEncoder<AcceptRequestOutboundMessage> {
    @Override
    public PacketBuffer encode(AcceptRequestOutboundMessage message) {
        switch (message.type) {
            case TRADE:
                return this.encodeTrade(message);
            case CHALLENGE:
                return this.encodeChallenge(message);
            default:
                throw new RuntimeException("Invalid request type: " + message.type);
        }
    }

    /**
     * Encodes a trade acceptance
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeTrade(AcceptRequestOutboundMessage message) {
        if (message.type != AcceptRequestOutboundMessage.RequestType.TRADE) {
            throw new RuntimeException("Attempted to handle request type '" + message.type + "' with TRADE handler");
        }

        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 96);

        buffer.putShortBE(message.playerId);

        return buffer;
    }

    /**
     * Encodes a challenge acceptance
     * @param message The message to encode
     * @return The encoded packet
     */
    private PacketBuffer encodeChallenge(AcceptRequestOutboundMessage message) {
        if (message.type != AcceptRequestOutboundMessage.RequestType.CHALLENGE) {
            throw new RuntimeException("Attempted to handle request type '" + message.type + "' with CHALLENGE handler");
        }

        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(2, 68);

        buffer.putShortLE(message.playerId);

        return buffer;
    }
}
