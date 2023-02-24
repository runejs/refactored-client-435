package org.runejs.client.net.codec.runejs435.decoder;

import org.runejs.client.message.inbound.FriendChangedWorldInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link FriendChangedWorldInboundMessage}s.
 */
public class FriendChangedWorldMessageDecoder implements MessageDecoder<FriendChangedWorldInboundMessage> {
    @Override
    public FriendChangedWorldInboundMessage decode(PacketBuffer buffer) {
        long nameAsLong = buffer.getLongBE();
        int worldId = buffer.getUnsignedShortBE();

        return new FriendChangedWorldInboundMessage(nameAsLong, worldId);
    }
}
