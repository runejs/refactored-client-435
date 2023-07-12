package org.runejs.client.net.codec.runejs435.decoder.world.item;

import org.runejs.client.message.inbound.world.item.UpdateGroundItemAmountInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class UpdateGroundItemAmountMessageDecoder implements MessageDecoder<UpdateGroundItemAmountInboundMessage> {
    @Override
    public UpdateGroundItemAmountInboundMessage decode(PacketBuffer buffer) {
        int positionInfo = buffer.getUnsignedByte();
        int y = (positionInfo & 0x7);
        int x = ((0x7a & positionInfo) >> 4);
        int itemId = buffer.getUnsignedShortBE();
        int existingAmount = buffer.getUnsignedShortBE();
        int newAmount = buffer.getUnsignedShortBE();

        return new UpdateGroundItemAmountInboundMessage(itemId, x, y, existingAmount, newAmount);
    }
}
