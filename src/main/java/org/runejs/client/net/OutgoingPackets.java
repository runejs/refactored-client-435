package org.runejs.client.net;

import org.runejs.client.Main;
import org.runejs.client.message.OutboundMessage;
import org.runejs.client.net.codec.MessageEncoder;
import org.runejs.client.scene.SceneCluster;

/**
 * Responsible for sending packets to the server.
 */
public class OutgoingPackets {
    private static ISAAC outCipher;

    public static void init(ISAAC outCipher) {
        OutgoingPackets.outCipher = outCipher;
    }

    /**
     * Opens a fixed-size packet with the specified opcode.
     */
    public static PacketBuffer openFixedSizePacket(int size, int opcode) {
        // data + 1 byte for opcode
        int totalSize = size + 1;
        PacketBuffer buffer = new PacketBuffer(totalSize);
        buffer.outCipher = outCipher;
        buffer.putPacket(opcode);
        return buffer;
    }

    // TODO (Jameskmonger) add support for variable-length packets

    /**
     * Sends an OutboundMessage to the server.
     */
    public static <TMessage extends OutboundMessage> void sendMessage(TMessage message) {
        MessageEncoder<TMessage> encoder = (MessageEncoder<TMessage>) Main.packetCodec.getMessageEncoder(message.getClass());

        if (encoder == null) {
            throw new RuntimeException();
        }

        PacketBuffer buffer = encoder.encode(message);

        // TODO (Jameskmonger) this shouldn't live on SceneCluster
        int initialPosition = SceneCluster.packetBuffer.currentPosition;
        SceneCluster.packetBuffer.putBytes(0, buffer.size, buffer.buffer);
    }
}
