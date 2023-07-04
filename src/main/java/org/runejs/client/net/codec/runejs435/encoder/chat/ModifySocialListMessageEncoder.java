package org.runejs.client.net.codec.runejs435.encoder.chat;

import org.runejs.client.message.outbound.chat.ModifySocialListOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Encodes a {@link ModifySocialListOutboundMessage} into a {@link PacketBuffer}.
 */
public class ModifySocialListMessageEncoder implements MessageEncoder<ModifySocialListOutboundMessage> {
    @Override
    public PacketBuffer encode(ModifySocialListOutboundMessage message) {
        // in 435, "friend add", "friend remove", "ignore add" and "ignore remove" all differ by opcode only
        // the structure is the same. This may not be the same for all revisions
        int opcode = this.getOpcode(message);

        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(4, opcode);

        buffer.putLongBE(message.target);

        return buffer;
    }

    private int getOpcode(ModifySocialListOutboundMessage message) {
        switch (message.action) {
            case ADD:
                switch (message.list) {
                    case FRIEND:
                        return 114;
                    case IGNORE:
                        return 251;
                    default:
                        throw new RuntimeException("Invalid social list: " + message.list);
                }
            case REMOVE:
                switch (message.list) {
                    case FRIEND:
                        return 255;
                    case IGNORE:
                        return 28;
                    default:
                        throw new RuntimeException("Invalid social list: " + message.list);
                }
            default:
                throw new RuntimeException("Invalid social list action: " + message.action);
        }
    }
}
