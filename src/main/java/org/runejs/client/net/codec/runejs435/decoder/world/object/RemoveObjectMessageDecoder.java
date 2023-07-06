package org.runejs.client.net.codec.runejs435.decoder.world.object;

import org.runejs.client.message.inbound.world.object.RemoveObjectInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class RemoveObjectMessageDecoder implements MessageDecoder<RemoveObjectInboundMessage> {
    @Override
    public RemoveObjectInboundMessage decode(PacketBuffer buffer) {
        int offset = buffer.getUnsignedByte();
        int y = (0x7 & offset);
        int x = (offset >> 4 & 0x7);
        int data = buffer.getUnsignedByte();
        int orientation = data & 0x3;
        int objectTypeIndex = data >> 2;

        return new RemoveObjectInboundMessage(x, y, objectTypeIndex, orientation);
    }
}
