package org.runejs.client.net.codec.runejs435;

import org.runejs.client.net.PacketType;
import org.runejs.client.net.codec.MessagePacketCodec;
import org.runejs.client.net.codec.runejs435.decoder.ReceiveChatboxMessageDecoder;
import org.runejs.client.net.codec.runejs435.decoder.ReceivePrivateMessageDecoder;

/**
 * A {@link MessagePacketCodec} for the RuneJS customised 435 protocol.
 */
public class RuneJS435PacketCodec extends MessagePacketCodec {
    public RuneJS435PacketCodec() {
        super(PacketType.incomingPacketSizes);

        this.registerEncoders();
        this.registerDecoders();
    }

    private void registerEncoders() {
    }

    private void registerDecoders() {
        register(PacketType.PRIVATE_MESSAGE_RECEIVED.getOpcode(), new ReceivePrivateMessageDecoder());
        register(PacketType.CHATBOX_MESSAGE_RECEIVED.getOpcode(), new ReceiveChatboxMessageDecoder());
    }
}
