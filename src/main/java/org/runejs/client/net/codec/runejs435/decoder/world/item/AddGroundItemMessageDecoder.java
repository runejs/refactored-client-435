package org.runejs.client.net.codec.runejs435.decoder.world.item;

import org.runejs.client.message.inbound.world.item.AddGroundItemInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class AddGroundItemMessageDecoder implements MessageDecoder<AddGroundItemInboundMessage> {
    @Override
    public AddGroundItemInboundMessage decode(PacketBuffer buffer) {
        int itemId = buffer.getUnsignedShortLE();
        int amount = buffer.getUnsignedShortBE();
        int positionInfo = buffer.getUnsignedByte();
        int y = (positionInfo & 0x7);
        int x = ((0x7a & positionInfo) >> 4);

        return new AddGroundItemInboundMessage(itemId, amount, x, y);
    }
}
