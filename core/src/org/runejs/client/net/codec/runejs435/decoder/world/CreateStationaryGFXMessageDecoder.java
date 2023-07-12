package org.runejs.client.net.codec.runejs435.decoder.world;

import org.runejs.client.message.inbound.world.CreateStationaryGFXInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class CreateStationaryGFXMessageDecoder implements MessageDecoder<CreateStationaryGFXInboundMessage> {
    @Override
    public CreateStationaryGFXInboundMessage decode(PacketBuffer buffer) {
        int positionData = buffer.getUnsignedByte();
        int x = ((0x78 & positionData) >> 4);
        int y = (0x7 & positionData);
        int gfxId = buffer.getUnsignedShortBE();
        int drawHeight = buffer.getUnsignedByte();
        int delay = buffer.getUnsignedShortBE();

        return new CreateStationaryGFXInboundMessage(gfxId, x, y, drawHeight, delay);
    }
}
