package com.jagex.runescape.io;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.scene.InteractiveObject;

import java.math.BigInteger;

public class Buffer extends Node {
    public static Cache aClass9_1933 = new Cache(100);
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1959;
    public static int[] anIntArray1972;
    public static int cameraOffsetX = 0;
    public static int lastItemDragTime = 0;

    public static int anInt1982 = 0;
    public static RSString aClass1_1983 = (RSString.CreateString("Too many incorrect logins from your address)3"));
    public static int[] anIntArray1984 = new int[2000];
    public static int anInt1985 = -1;
    public static int anInt1987 = 0;

    public int currentPosition;
    public byte[] buffer;

    public Buffer(int size) {
        buffer = Class13.method246(size);
        currentPosition = 0;
    }

    public Buffer(byte[] buffer) {
        currentPosition = 0;
        this.buffer = buffer;

    }

    // ???
    public static boolean method472(CacheIndex arg1, int arg2) {
        byte[] is = arg1.method187(arg2);
        if(is == null) {
            return false;
        }
        CacheIndex.method184(is, 0);
        return true;

    }

    public static void method499() {
        anIntArray1984 = null;
        aClass40_Sub5_Sub14_Sub2_1959 = null;
        aClass1_1983 = null;
        aClass9_1933 = null;
        anIntArray1972 = null;
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
        return InteractiveObject.method279(buffer, true, i, -1 + currentPosition + -i);
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
        return (((0xff & buffer[currentPosition - 2]) << 8) + (buffer[currentPosition - 1] & 0xff));
    }

    public int getIntME1() {
        currentPosition += 4;
        return ((0xff00 & buffer[currentPosition - 1] << 8) + ((buffer[currentPosition - 4] << 16 & 0xff0000) + ((buffer[currentPosition - 3] & 0xff) << 24)) + (buffer[currentPosition - 2] & 0xff));
    }

    public int getIntME2() {
        currentPosition += 4;
        return ((buffer[currentPosition - 4] << 8 & 0xff00) + ((~0xffffff & buffer[currentPosition - 2] << 24) + (buffer[currentPosition - 1] << 16 & 0xff0000) + (buffer[currentPosition - 3] & 0xff)));
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

    // ???
    public int method473(int value) {
        int i = Class67.method1034(true, value, currentPosition, buffer);
        putIntBE(i);
        return i;
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

    public void finishVarByte(int value) {
        buffer[-1 + (currentPosition + -value)] = (byte) value;
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

    // ???
    public void method483(int[] arg0, int arg2, int arg3) {
        int i = (-arg3 + arg2) / 8;
        int i_3_ = currentPosition;
        currentPosition = arg3;
        int i_4_ = 0;
        for(/**/; i > i_4_; i_4_++) {
            int i_5_ = getIntBE();
            int i_6_ = getIntBE();
            int i_7_ = 32;
            int i_8_ = -957401312;
            int i_9_ = -1640531527;
            while(i_7_-- > 0) {
                i_6_ -= ((i_5_ >>> 5 ^ i_5_ << 4) + i_5_ ^ i_8_ + arg0[~0x71dffffc & i_8_ >>> 11]);
                i_8_ -= i_9_;
                i_5_ -= ((i_6_ >>> 5 ^ i_6_ << 4) + i_6_ ^ arg0[0x3 & i_8_] + i_8_);
            }
            currentPosition -= 8;
            putIntBE(i_5_);
            putIntBE(i_6_);
        }
        currentPosition = i_3_;
    }

    public int getIntLE() {
        currentPosition += 4;
        return ((buffer[currentPosition - 3] << 8 & 0xff00) + (((0xff & buffer[currentPosition - 1]) << 24) + (0xff0000 & buffer[currentPosition - 2] << 16)) + (buffer[currentPosition - 4] & 0xff));
    }

    public void putShortLE(int value) {
        buffer[currentPosition++] = (byte) value;
        buffer[currentPosition++] = (byte) (value >> 8);
    }

    public int getMediumBE() {
        currentPosition += 3;
        return (((buffer[currentPosition - 3] & 0xff) << 16) + ((buffer[currentPosition - 2] & 0xff) << 8) + (0xff & buffer[currentPosition - 1]));
    }

    public int getUnsignedShortLE() {
        currentPosition += 2;
        return ((0xff00 & buffer[currentPosition - 1] << 8) + (0xff & buffer[currentPosition - 2]));
    }

    public int getIntBE() {
        currentPosition += 4;
        return ((0xff & buffer[currentPosition - 1]) + (buffer[currentPosition - 2] << 8 & 0xff00) + (buffer[currentPosition - 3] << 16 & 0xff0000) + (~0xffffff & buffer[currentPosition - 4] << 24));
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
    public int method500() {
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
//        if(str == null) {
//            str = "";
//        }
//
//        byte[] bytes = new byte[str.length()];
//        for (int i = 0; i < bytes.length; i++) {
//            bytes[i] = (byte) str.charAt(i);
//        }
//        System.arraycopy(bytes, 0, buffer, currentPosition, bytes.length);
//        currentPosition += str.length();
//        buffer[currentPosition++] = 10;
        method505(RSString.CreateString(str));
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
