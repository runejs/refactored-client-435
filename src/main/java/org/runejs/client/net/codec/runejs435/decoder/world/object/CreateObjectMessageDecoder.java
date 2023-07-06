package org.runejs.client.net.codec.runejs435.decoder.world.object;

import org.runejs.client.message.inbound.world.object.CreateObjectInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class CreateObjectMessageDecoder implements MessageDecoder<CreateObjectInboundMessage> {
    @Override
    public CreateObjectInboundMessage decode(PacketBuffer buffer) {
        int data = buffer.getUnsignedByte();
        int orientation = data & 0x3;
        int objectTypeIndex = data >> 2;

        int objectId = buffer.getUnsignedShortBE();
        int positionOffset = buffer.getUnsignedByte();
        int x = ((positionOffset & 0x75) >> 4);
        int y = (0x7 & positionOffset);

        return new CreateObjectInboundMessage(x, y, objectId, objectTypeIndex, orientation);
    }
}
