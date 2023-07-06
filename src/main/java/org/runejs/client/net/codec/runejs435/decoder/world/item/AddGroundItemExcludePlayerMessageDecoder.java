package org.runejs.client.net.codec.runejs435.decoder.world.item;

import org.runejs.client.message.inbound.world.item.AddGroundItemInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class AddGroundItemExcludePlayerMessageDecoder implements MessageDecoder<AddGroundItemInboundMessage> {
    @Override
    public AddGroundItemInboundMessage decode(PacketBuffer buffer) {
        int amount = buffer.getUnsignedShortLE();
        int playerToExclude = buffer.getUnsignedShortLE();
        int itemId = buffer.getUnsignedShortBE();
        int positionInfo = buffer.getUnsignedByte();
        int x = ((0x71 & positionInfo) >> 4);
        int y = (0x7 & positionInfo);

        return new AddGroundItemInboundMessage(itemId, amount, x, y, playerToExclude);
    }
}
