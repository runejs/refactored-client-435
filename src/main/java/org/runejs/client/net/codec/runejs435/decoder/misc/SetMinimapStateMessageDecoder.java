package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.SetMinimapStateInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetMinimapStateMessageDecoder implements MessageDecoder<SetMinimapStateInboundMessage> {
    @Override
    public SetMinimapStateInboundMessage decode(PacketBuffer buffer) {
        int minimapState = buffer.getUnsignedByte();
        return new SetMinimapStateInboundMessage(minimapState);
    }
}
