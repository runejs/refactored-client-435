package com.jagex.runescape.audio;

import com.jagex.runescape.io.Buffer;

public class MidiFileReader {
    private static byte[] aByteArray429 = {
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
            2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    public int[] trackLengths;
    public int division;
    private Buffer buffer = new Buffer(null);
    private long aLong424;
    private int[] trackPositions;
    private int[] trackStarts;
    private int[] anIntArray428;
    private int anInt430;

    public int getPrioritizedTrack() {
        int i = trackPositions.length;
        int i_0_ = -1;
        int i_1_ = Integer.MAX_VALUE;
        for(int i_2_ = 0; i_2_ < i; i_2_++) {
            if(trackPositions[i_2_] >= 0 && trackLengths[i_2_] < i_1_) {
                i_0_ = i_2_;
                i_1_ = trackLengths[i_2_];
            }
        }
        return i_0_;
    }

    public long method251(int arg0) {
        return aLong424 + (long) arg0 * (long) anInt430;
    }

    public int readMessage(int arg0) {
        int i = readMessage0(arg0);
        return i;
    }

    public int trackCount() {
        return trackPositions.length;
    }

    public void readTrackLength(int arg0) {
        int i = buffer.getIntVar();
        trackLengths[arg0] += i;
    }

    public void clear() {
        buffer.buffer = null;
        trackStarts = null;
        trackPositions = null;
        trackLengths = null;
        anIntArray428 = null;
    }

    public void parse(byte[] arg0) {
        buffer.buffer = arg0;
        buffer.currentPosition = 10;
        int i = buffer.getUnsignedShortBE();
        division = buffer.getUnsignedShortBE();
        anInt430 = 500000;
        trackStarts = new int[i];
        int i_3_ = 0;
        while(i_3_ < i) {
            int i_4_ = buffer.getIntBE();
            int i_5_ = buffer.getIntBE();
            if(i_4_ == 1297379947) {
                trackStarts[i_3_] = buffer.currentPosition;
                i_3_++;
            }
            buffer.currentPosition += i_5_;
        }
        trackPositions = trackStarts.clone();
        trackLengths = new int[i];
        anIntArray428 = new int[i];
    }

    public boolean isReady() {
        return buffer.buffer != null;
    }

    public boolean method258() {
        return buffer.currentPosition < 0;
    }

    public void reset(long arg0) {
        aLong424 = arg0;
        int i = trackPositions.length;
        for(int i_6_ = 0; i_6_ < i; i_6_++) {
            trackLengths[i_6_] = 0;
            anIntArray428[i_6_] = 0;
            buffer.currentPosition = trackStarts[i_6_];
            readTrackLength(i_6_);
            trackPositions[i_6_] = buffer.currentPosition;
        }
    }

    public void markTrackPosition(int arg0) {
        trackPositions[arg0] = buffer.currentPosition;
    }

    public int readMessage0(int arg0) {
        int i = buffer.buffer[buffer.currentPosition];
        if(i < 0) {
            i &= 0xff;
            anIntArray428[arg0] = i;
            buffer.currentPosition++;
        } else {
            i = anIntArray428[arg0];
        }
        if(i == 240 || i == 247) {
            int i_7_ = buffer.getIntVar();
            if(i == 247 && i_7_ > 0) {
                int i_8_ = buffer.buffer[buffer.currentPosition] & 0xff;
                if(i_8_ >= 241 && i_8_ <= 243 || i_8_ == 246 || i_8_ == 248 || i_8_ >= 250 && i_8_ <= 252 ||
                        i_8_ == 254) {
                    buffer.currentPosition++;
                    anIntArray428[arg0] = i_8_;
                    return method262(arg0, i_8_);
                }
            }
            buffer.currentPosition += i_7_;
            return 0;
        }
        return method262(arg0, i);
    }

    public int method262(int arg0, int arg1) {
        if(arg1 == 255) {
            int i = buffer.getUnsignedByte();
            int i_9_ = buffer.getIntVar();
            if(i == 47) {
                buffer.currentPosition += i_9_;
                return 1;
            }
            if(i == 81) {
                int i_10_ = buffer.getMediumBE();
                i_9_ -= 3;
                int i_11_ = trackLengths[arg0];
                aLong424 += (long) i_11_ * (long) (anInt430 - i_10_);
                anInt430 = i_10_;
                buffer.currentPosition += i_9_;
                return 2;
            }
            buffer.currentPosition += i_9_;
            return 3;
        }
        byte i = aByteArray429[arg1 - 128];
        int i_12_ = arg1;
        if(i >= 1) {
            i_12_ |= buffer.getUnsignedByte() << 8;
        }
        if(i >= 2) {
            i_12_ |= buffer.getUnsignedByte() << 16;
        }
        return i_12_;
    }

    public boolean isDone() {
        int i = trackPositions.length;
        for(int i_13_ = 0; i_13_ < i; i_13_++) {
            if(trackPositions[i_13_] >= 0) {
                return false;
            }
        }
        return true;
    }

    public void setTrackDone() {
        buffer.currentPosition = -1;
    }

    public void gotoTrack(int arg0) {
        buffer.currentPosition = trackPositions[arg0];
    }
}
