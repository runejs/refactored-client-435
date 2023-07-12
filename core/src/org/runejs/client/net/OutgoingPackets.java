package org.runejs.client.net;

import org.runejs.client.Game;
import org.runejs.client.message.OutboundMessage;
import org.runejs.client.net.codec.MessageEncoder;

/**
 * Responsible for sending packets to the server.
 */
public class OutgoingPackets {
    public static PacketBuffer buffer = new PacketBuffer(5000);
    private static ISAAC outCipher;

    public static void init(ISAAC outCipher) {
        OutgoingPackets.outCipher = outCipher;
    }

    /**
     * Opens a fixed-size packet with the specified opcode.
     * 
     * @param size The size of the packet in bytes, not including the opcode.
     */
    public static PacketBuffer openFixedSizePacket(int size, int opcode) {
        // data + 1 byte for opcode
        int totalSize = size + 1;
        PacketBuffer buffer = new PacketBuffer(totalSize);
        buffer.outCipher = outCipher;
        buffer.putPacket(opcode);
        return buffer;
    }

    /**
     * Opens a variable-length packet with the specified opcode.
     * 
     * The first byte of the packet will be reserved for the size of the packet.
     */
    public static VariableLengthPacketBuffer openVariableSizePacket(int opcode) {
        VariableLengthPacketBuffer buffer = new VariableLengthPacketBuffer();
        
        buffer.outCipher = outCipher;
        buffer.putPacket(opcode);

        return buffer;
    }

    /**
     * Sends an OutboundMessage to the server.
     */
    public static <TMessage extends OutboundMessage> void sendMessage(TMessage message) {
        MessageEncoder<TMessage> encoder = (MessageEncoder<TMessage>) Game.packetCodec.getMessageEncoder(message.getClass());

        if (encoder == null) {
            throw new RuntimeException();
        }

        PacketBuffer buffer = encoder.encode(message);

        OutgoingPackets.buffer.putBytes(0, buffer.getSize(), buffer.buffer);
    }
}
