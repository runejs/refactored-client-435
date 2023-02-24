package org.runejs.client.net.codec.runejs435.decoder;

import org.runejs.client.message.inbound.SetFriendsListStatusInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link SetFriendsListStatusInboundMessage}s.
 */
public class SetFriendsListStatusMessageDecoder implements MessageDecoder<SetFriendsListStatusInboundMessage> {
    @Override
    public SetFriendsListStatusInboundMessage decode(PacketBuffer buffer) {
        int friendListStatus = buffer.getUnsignedByte();
        return new SetFriendsListStatusInboundMessage(friendListStatus);
    }
}
