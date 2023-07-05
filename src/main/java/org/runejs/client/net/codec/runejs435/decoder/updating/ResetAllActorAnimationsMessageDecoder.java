package org.runejs.client.net.codec.runejs435.decoder.updating;

import org.runejs.client.message.inbound.updating.ResetAllActorAnimationsInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ResetAllActorAnimationsMessageDecoder implements MessageDecoder<ResetAllActorAnimationsInboundMessage> {
    @Override
    public ResetAllActorAnimationsInboundMessage decode(PacketBuffer buffer) {
        return new ResetAllActorAnimationsInboundMessage();
    }
}
