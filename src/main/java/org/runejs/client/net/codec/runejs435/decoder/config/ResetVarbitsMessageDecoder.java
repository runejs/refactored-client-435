package org.runejs.client.net.codec.runejs435.decoder.config;

import org.runejs.client.message.inbound.config.ResetVarbitsInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ResetVarbitsMessageDecoder implements MessageDecoder<ResetVarbitsInboundMessage> {
    @Override
    public ResetVarbitsInboundMessage decode(PacketBuffer buffer) {
        return new ResetVarbitsInboundMessage();
    }
}
