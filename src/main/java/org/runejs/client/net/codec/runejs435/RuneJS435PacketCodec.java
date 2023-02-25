package org.runejs.client.net.codec.runejs435;

import org.runejs.client.message.outbound.interactions.PlayerInteractionOutboundMessage;
import org.runejs.client.net.PacketType;
import org.runejs.client.net.codec.MessagePacketCodec;
import org.runejs.client.net.codec.runejs435.encoder.interactions.PlayerInteractionMessageEncoder;

/**
 * A {@link MessagePacketCodec} for the RuneJS customised 435 protocol.
 */
public class RuneJS435PacketCodec extends MessagePacketCodec {
    public RuneJS435PacketCodec() {
        super(PacketType.incomingPacketSizes);

        this.registerEncoders();
        this.registerDecoders();
    }

    private void registerEncoders() {
        register(PlayerInteractionOutboundMessage.class, new PlayerInteractionMessageEncoder());
    }

    private void registerDecoders() {
    }
}
