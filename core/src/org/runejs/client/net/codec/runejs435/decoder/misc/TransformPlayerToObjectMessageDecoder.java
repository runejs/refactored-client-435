package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.TransformPlayerToObjectInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class TransformPlayerToObjectMessageDecoder implements MessageDecoder<TransformPlayerToObjectInboundMessage> {
    @Override
    public TransformPlayerToObjectInboundMessage decode(PacketBuffer buffer) {
        int unknownXMax = buffer.getByte();
        int playerId = buffer.getUnsignedShortBE();
        int unknownYMax = buffer.getByte();
        int unknownYMin = buffer.getByte();
        int objectData = buffer.getUnsignedByte();
        int orientation = objectData & 0x3;
        int typeKey = objectData >> 2;
        int positionData = buffer.getUnsignedByte();
        int y = (positionData & 0x7);
        int x = (positionData >> 4 & 0x7);
        int delay = buffer.getUnsignedShortBE();
        int unknownXMin = buffer.getByte();
        int objectId = buffer.getUnsignedShortLE();
        int duration = buffer.getUnsignedShortLE();

        return new TransformPlayerToObjectInboundMessage(
            playerId,
            objectId,
            x,
            y,
            typeKey,
            orientation,
            duration,
            delay,
            unknownXMin,
            unknownXMax,
            unknownYMin,
            unknownYMax
        );
    }
}
