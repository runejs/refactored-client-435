package org.runejs.client.net.codec.runejs435.decoder.world;

import org.runejs.client.message.inbound.world.CreateProjectileInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class CreateProjectileMessageDecoder implements MessageDecoder<CreateProjectileInboundMessage> {
    @Override
    public CreateProjectileInboundMessage decode(PacketBuffer buffer) {
        int offset = buffer.getUnsignedByte();
        int startY = (offset & 0x7);
        int startX = (0x7 & offset >> 4);
        int endX = buffer.getByte();
        int endY = buffer.getByte();
        int entityIndex = buffer.getShortBE();
        int graphicsId = buffer.getUnsignedShortBE();
        int startHeight = buffer.getUnsignedByte() * 4;
        int endHeight = buffer.getUnsignedByte() * 4;
        int delay = buffer.getUnsignedShortBE();
        int speed = buffer.getUnsignedShortBE();
        int startSlope = buffer.getUnsignedByte();
        int startDistance = buffer.getUnsignedByte();

        return new CreateProjectileInboundMessage(startX, startY, endX, endY, entityIndex, graphicsId, startHeight, endHeight, startSlope, startDistance, delay, speed);
    }
}
