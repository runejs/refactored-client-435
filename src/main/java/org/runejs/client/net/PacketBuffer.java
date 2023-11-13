package org.runejs.client.net;

import org.runejs.client.MovedStatics;
import org.runejs.client.io.Buffer;

public class PacketBuffer extends Buffer {
    public ISAAC inCipher;
    public ISAAC outCipher;
    public int bitoffset;

    /**
     * The size of this packet buffer, in bytes.
     */
    private final int size;

    /**
     * Creates a new packet buffer with the specified size, in bytes.
     */
    public PacketBuffer(int size) {
        super(size);

        this.size = size;
    }

    /**
     * Gets the size of this packet buffer, in bytes.
     */
    public int getSize() {
        return this.size;
    }


    public int getRemainingBits(int packetSize) {
        return 8 * packetSize - bitoffset;
    }

    public void finishBitAccess() {
        currentPosition = (7 + bitoffset) / 8;
    }

    /**
     * Gets the packet opcode after ISAAC decryption (the - inCypher.nextInt() part).
     * @return the unencrypted packet opcode
     */
    public int getPacket() {
        return 0xff & buffer[currentPosition++] - inCipher.nextInt();
    }

    public int getBits(int arg0) {
        int i = bitoffset >> 3;
        int i_0_ = 0;
        int i_1_ = 8 - (0x7 & bitoffset);
        bitoffset += arg0;
        for(/**/; i_1_ < arg0; i_1_ = 8) {
            i_0_ += (MovedStatics.anIntArray2361[i_1_] & buffer[i++]) << -i_1_ + arg0;
            arg0 -= i_1_;
        }
        if(arg0 != i_1_)
            i_0_ += MovedStatics.anIntArray2361[arg0] & buffer[i] >> -arg0 + i_1_;
        else
            i_0_ += buffer[i] & MovedStatics.anIntArray2361[i_1_];
        return i_0_;
    }

    public void putPacket(int packetId) {
        buffer[currentPosition++] = (byte) (packetId + outCipher.nextInt() & 0xff);
    }

    public void initInCipher(int[] seed) {
        inCipher = new ISAAC(seed);
    }

    public void initOutCipher(int[] seed) {
        outCipher = new ISAAC(seed);
    }

    public void initBitAccess() {
        bitoffset = currentPosition * 8;
    }
}
