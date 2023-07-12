package org.runejs.client.net.codec.runejs435.decoder.world.item;

import org.runejs.client.message.inbound.world.item.RemoveGroundItemInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class RemoveGroundItemMessageDecoder implements MessageDecoder<RemoveGroundItemInboundMessage> {
    @Override
    public RemoveGroundItemInboundMessage decode(PacketBuffer buffer) {
        int positionInfo = buffer.getUnsignedByte();
        int y = (positionInfo & 0x7);
        int x = ((0x7a & positionInfo) >> 4);
        int itemId = buffer.getUnsignedShortBE();

        return new RemoveGroundItemInboundMessage(itemId, x, y);
    }
}
