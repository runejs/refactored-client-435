package org.runejs.client.io;

import org.runejs.client.MovedStatics;
import org.runejs.client.RSString;
import org.runejs.client.node.Node;

import java.math.BigInteger;

public class Buffer extends Node {
    public int currentPosition;
    public byte[] buffer;

    public Buffer(int size) {
        buffer = new byte[size];
        currentPosition = 0;
    }

    public Buffer(byte[] buffer) {
        currentPosition = 0;
        this.buffer = buffer;

    }

    public int getShortLE() {
        currentPosition += 2;
        int i = ((buffer[currentPosition - 1] & 0xff) << 8) + (buffer[currentPosition - 2] & 0xff);
        if(i > 0x7fff) {
            i -= 0x10000;
        }
        return i;
    }

    public int getShortBE() {
        currentPosition += 2;
        int i = ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] & 0xff);
        if(i > 0x7fff) {
            i -= 0x10000;
        }
        return i;
    }

    public RSString getRSString() {
        int i = currentPosition;
        while(buffer[currentPosition++] != 0) {
            /* empty */
        }
        return RSString.method279(buffer, i, -1 + currentPosition + -i);
    }

    public String getString() {
        int start = currentPosition;
        while(buffer[currentPosition++] != 0) {
            /* empty */
        }
        return new String(buffer, start, currentPosition - start - 1);
    }

    public void putByte(int value) {
        buffer[currentPosition++] = (byte) value;
    }

    public void applyRSA(BigInteger modulus, BigInteger key) {
        int i = currentPosition;
        currentPosition = 0;
        byte[] bytes = new byte[i];
        getBytes(i, 0, bytes);
        BigInteger data = new BigInteger(bytes);
        BigInteger rsaData = data.modPow(key, modulus);
        byte[] rsaBytes = rsaData.toByteArray();
        currentPosition = 0;
        putByte(rsaBytes.length);
        putBytes(0, rsaBytes.length, rsaBytes);
    }

    public int getUnsignedByte() {
        return 0xff & buffer[currentPosition++];
    }

    public int getUnsignedShortBE() {
        currentPosition += 2;
        return ((0xff & buffer[currentPosition - 2]) << 8) + (buffer[currentPosition - 1] & 0xff);
    }

    public int getIntME1() {
        currentPosition += 4;
        return (0xff00 & buffer[currentPosition - 1] << 8) + (buffer[currentPosition - 4] << 16 & 0xff0000) + ((buffer[currentPosition - 3] & 0xff) << 24) + (buffer[currentPosition - 2] & 0xff);
    }

    public int getIntME2() {
        currentPosition += 4;
        return (buffer[currentPosition - 4] << 8 & 0xff00) + (~0xffffff & buffer[currentPosition - 2] << 24) + (buffer[currentPosition - 1] << 16 & 0xff0000) + (buffer[currentPosition - 3] & 0xff);
    }

    public void putIntME1(int value) {
        buffer[currentPosition++] = (byte) (value >> 16);
        buffer[currentPosition++] = (byte) (value >> 24);
        buffer[currentPosition++] = (byte) value;
        buffer[currentPosition++] = (byte) (value >> 8);
    }

    public void putIntME2(int value) {
        buffer[currentPosition++] = (byte) (value >> 8);
        buffer[currentPosition++] = (byte) value;
        buffer[currentPosition++] = (byte) (value >> 24);
        buffer[currentPosition++] = (byte) (value >> 16);
    }

    public int putCrc8(int value) {
        int crc = MovedStatics.calculateCrc8(value, currentPosition, buffer);
        putIntBE(crc);
        return crc;
    }

    public void putShortBE(int value) {
        buffer[currentPosition++] = (byte) (value >> 8);
        buffer[currentPosition++] = (byte) value;
    }

    public void putBytes(int startingIndex, int endingIndex, byte[] data) {
        for(int i = startingIndex; startingIndex + endingIndex > i; i++) {
            buffer[currentPosition++] = data[i];
        }
    }

    public void getBytes(int endingIndex, int startingIndex, byte[] data) {
        for(int i = startingIndex; endingIndex + startingIndex > i; i++) {
            data[i] = buffer[currentPosition++];
        }
    }

    public void putMediumBE(int value) {
        buffer[currentPosition++] = (byte) (value >> 16);
        buffer[currentPosition++] = (byte) (value >> 8);
        buffer[currentPosition++] = (byte) value;
    }

    /**
     * Updates the length marker byte for a variable length packet.
     * 
     * @param length The length of the packet.
     */
    public void finishVarByte(int length) {
        buffer[-1 + currentPosition - length] = (byte) length;
    }

    public void putLongBE(long arg0) {
        buffer[currentPosition++] = (byte) (int) (arg0 >> 56);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 48);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 40);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 32);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 24);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 16);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 8);
        buffer[currentPosition++] = (byte) (int) arg0;
    }

    public int getUnsignedSmart() {
        int peek = buffer[currentPosition] & 0xff;
        if(peek >= 128) {
            return -49152 + getUnsignedShortBE();
        }
        return getUnsignedByte() + -64;
    }

    public int getSmart() {
        int i = buffer[currentPosition] & 0xff;
        if(i >= 128) {
            return getUnsignedShortBE() + -32768;
        }
        return getUnsignedByte();
    }

    public void putSmart(int value) {
        if(value >= 0 && value < 128) {
            putByte(value);
        } else if(value >= 0 && value < 32768) {
            putShortBE(32768 + value);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Decrypt a number of bytes from a given position using the provided XTEA keys.
     *
     * @param xteaKeys The keys to decrypt with.
     * @param bufferStart The starting position for the decrpytion.
     * @param bufferLength The amount of bytes to decrypt.
     */
    public void decryptXTEA(int[] xteaKeys, int bufferStart, int bufferLength) {
        int ROUND_COUNT = 32;

        int blockCount = (bufferLength - bufferStart) / 8;
        int originalPosition = currentPosition;
        currentPosition = bufferStart;

        for(int block = 0; blockCount > block; block++) {
            int v0 = getIntBE();
            int v1 = getIntBE();

            int delta = 0x9E3779B9;
            int sum = delta * ROUND_COUNT;

            for (int i = 0; i < ROUND_COUNT; i++) {
                v1 -= (v0 >>> 5 ^ v0 << 4) + v0 ^ sum + xteaKeys[~0x71dffffc & sum >>> 11];
                sum -= delta;
                v0 -= (v1 >>> 5 ^ v1 << 4) + v1 ^ xteaKeys[0x3 & sum] + sum;
            }

            currentPosition -= 8;
            putIntBE(v0);
            putIntBE(v1);
        }
        currentPosition = originalPosition;
    }

    public int getIntLE() {
        currentPosition += 4;
        return (buffer[currentPosition - 3] << 8 & 0xff00) + ((0xff & buffer[currentPosition - 1]) << 24) + (0xff0000 & buffer[currentPosition - 2] << 16) + (buffer[currentPosition - 4] & 0xff);
    }

    public void putShortLE(int value) {
        buffer[currentPosition++] = (byte) value;
        buffer[currentPosition++] = (byte) (value >> 8);
    }

    public int getMediumBE() {
        currentPosition += 3;
        return ((buffer[currentPosition - 3] & 0xff) << 16) + ((buffer[currentPosition - 2] & 0xff) << 8) + (0xff & buffer[currentPosition - 1]);
    }

    public int getUnsignedShortLE() {
        currentPosition += 2;
        return (0xff00 & buffer[currentPosition - 1] << 8) + (0xff & buffer[currentPosition - 2]);
    }

    public int getIntBE() {
        currentPosition += 4;
        return (0xff & buffer[currentPosition - 1]) + (buffer[currentPosition - 2] << 8 & 0xff00) + (buffer[currentPosition - 3] << 16 & 0xff0000) + (~0xffffff & buffer[currentPosition - 4] << 24);
    }

    public void putIntLE(int value) {
        buffer[currentPosition++] = (byte) value;
        buffer[currentPosition++] = (byte) (value >> 8);
        buffer[currentPosition++] = (byte) (value >> 16);
        buffer[currentPosition++] = (byte) (value >> 24);
    }

    public long getLongBE() {
        long l = 0xffffffffL & (long) getIntBE();
        long l_10_ = (long) getIntBE() & 0xffffffffL;
        return l_10_ + (l << 32);
    }

    // ???
    public int getIntVar() {
        int i = buffer[currentPosition++];
        int i_11_ = 0;
        for(/**/; i < 0; i = buffer[currentPosition++]) {
            i_11_ = (0x7f & i | i_11_) << 7;
        }
        return i | i_11_;
    }

    // ??? set buffer offset to string length???
    public void method505(RSString value) {
        currentPosition += value.method51(0, value.length(), buffer, currentPosition);
        buffer[currentPosition++] = (byte) 0;
    }
    public void putString(String str) {
        if(str == null) {
            str = "";
        }

        byte[] bytes = new byte[str.length()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) str.charAt(i);
        }
        System.arraycopy(bytes, 0, buffer, currentPosition, bytes.length);
        currentPosition += str.length();
        buffer[currentPosition++] = (byte) 0;
    }


    public void putIntBE(int value) {
        buffer[currentPosition++] = (byte) (value >> 24);
        buffer[currentPosition++] = (byte) (value >> 16);
        buffer[currentPosition++] = (byte) (value >> 8);
        buffer[currentPosition++] = (byte) value;
    }

    public byte getByte() {
        return buffer[currentPosition++];
    }
}
