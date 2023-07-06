package org.runejs.client.net.codec.runejs435.decoder.updating;

import org.runejs.client.message.inbound.updating.SetLocalPlayerPositionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetLocalPlayerPositionMessageDecoder implements MessageDecoder<SetLocalPlayerPositionInboundMessage> {
    @Override
    public SetLocalPlayerPositionInboundMessage decode(PacketBuffer buffer) {
        int heightAndTeleporting = buffer.getUnsignedByte();
        int y = buffer.getUnsignedByte();
        int x = buffer.getUnsignedByte();

        boolean teleporting = (heightAndTeleporting & 0x1) == 1;
        int level = heightAndTeleporting >> 1;

        return new SetLocalPlayerPositionInboundMessage(x, y, level, teleporting);
    }
}
