package org.runejs.client.net;

/**
 * A packet buffer that can be used to write variable-length packets.
 * 
 * This is used for packets that have a variable size, such as the
 * chat message packet.
 * 
 * The size of the packet is written to the reserved size marker byte
 * when the packet is closed. This byte is stored at index 1 in the
 * buffer.
 */
public class VariableLengthPacketBuffer extends PacketBuffer {
    /**
     * The maximum size of a packet.
     * 
     * This is set to 255 because that's the maximum size that can
     * be encoded in a single byte.
     */
    private static int MAX_PACKET_SIZE = 255;

    /**
     * Whether the opcode and reserved size marker byte have been written yet.
     */
    private boolean isOpcodeWritten = false;

    /**
     * Whether the reserved size marker byte has been populated.
     */
    private boolean isSizeWritten = false;

    public VariableLengthPacketBuffer() {
        // the packet size plus the opcode and reserved size marker byte
        super(MAX_PACKET_SIZE + 2);
    }

    /**
     * Gets the size of the packet based on the value written to the length marker byte.
     */
    @Override
    public int getSize() {
        if (!isSizeWritten) {
            throw new IllegalStateException("Size has not been written");
        }

        // the packet size plus the opcode and reserved size marker byte
        return buffer[1] + 2;
    }

    /**
     * Opens a packet and reserves a byte for the size of the packet.
     */
    public void putPacket(int opcode) {
        if (isOpcodeWritten) {
            throw new IllegalStateException("Opcode has already been written");
        }

        super.putPacket(opcode);

        // this is the size of the packet, which we don't know yet
        super.putByte(0);

        isOpcodeWritten = true;
    }

    /**
     * Writes the size of the packet to the reserved size marker byte.
     */
    public void writePacketLength() {
        if (!isOpcodeWritten) {
            throw new IllegalStateException("Opcode has not been written");
        }

        if (isSizeWritten) {
            throw new IllegalStateException("Size has already been written");
        }

        // the size of the packet is the current position minus the opcode and reserved size marker byte
        int size = currentPosition - 2;
        if (size > MAX_PACKET_SIZE) {
            throw new IllegalStateException("Packet size is too large");
        }

        // write the size of the packet
        buffer[1] = (byte) size;

        isSizeWritten = true;
    }
}
