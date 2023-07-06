package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.SetCurrentTabInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetCurrentTabMessageDecoder implements MessageDecoder<SetCurrentTabInboundMessage> {
    @Override
    public SetCurrentTabInboundMessage decode(PacketBuffer buffer) {
        int tabId = buffer.getUnsignedByte();
        return new SetCurrentTabInboundMessage(tabId);
    }
}
