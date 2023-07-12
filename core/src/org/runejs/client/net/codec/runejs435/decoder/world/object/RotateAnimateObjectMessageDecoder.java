package org.runejs.client.net.codec.runejs435.decoder.world.object;

import org.runejs.client.message.inbound.world.object.RotateAnimateObjectInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class RotateAnimateObjectMessageDecoder implements MessageDecoder<RotateAnimateObjectInboundMessage> {
    @Override
    public RotateAnimateObjectInboundMessage decode(PacketBuffer buffer) {
        int offset = buffer.getUnsignedByte();
        int x = (offset >> 4 & 0x7);
        int y = (0x7 & offset);
        int data = buffer.getUnsignedByte();
        int orientation = 0x3 & data;
        int objectTypeKey = data >> 2;
        int animationId = buffer.getUnsignedShortLE();

        return new RotateAnimateObjectInboundMessage(x, y, objectTypeKey, orientation, animationId);
    }
}
