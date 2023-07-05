package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.SetSystemUpdateTimeInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetSystemUpdateTimeMessageDecoder implements MessageDecoder<SetSystemUpdateTimeInboundMessage> {
    @Override
    public SetSystemUpdateTimeInboundMessage decode(PacketBuffer buffer) {
        int time = buffer.getUnsignedShortLE() * 30;

        return new SetSystemUpdateTimeInboundMessage(time);
    }
}
