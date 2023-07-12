package org.runejs.client.net.codec.runejs435.decoder.config;

import org.runejs.client.message.inbound.config.ResetVarpsInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ResetVarpsMessageDecoder implements MessageDecoder<ResetVarpsInboundMessage> {
    @Override
    public ResetVarpsInboundMessage decode(PacketBuffer buffer) {
        return new ResetVarpsInboundMessage();
    }
}
