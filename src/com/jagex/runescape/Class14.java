package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;

public class Class14 {
    public static byte[] aByteArray429 = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public Buffer aClass40_Sub1_423 = new Buffer(null);
    public long aLong424;
    public int[] anIntArray425;
    public int[] anIntArray426;
    public int[] anIntArray427;
    public int[] anIntArray428;
    public int anInt430;
    public int anInt431;

    public static void method266() {
        aByteArray429 = null;
    }

    public int method250() {
        int i = anIntArray425.length;
        int i_0_ = -1;
        int i_1_ = Integer.MAX_VALUE;
        for(int i_2_ = 0; i_2_ < i; i_2_++) {
            if(anIntArray425[i_2_] >= 0 && anIntArray427[i_2_] < i_1_) {
                i_0_ = i_2_;
                i_1_ = anIntArray427[i_2_];
            }
        }
        return i_0_;
    }

    public long method251(int arg0) {
        return aLong424 + (long) arg0 * (long) anInt430;
    }

    public int method252(int arg0) {
        int i = method261(arg0);
        return i;
    }

    public int method253() {
        return anIntArray425.length;
    }

    public void method254(int arg0) {
        int i = aClass40_Sub1_423.method500();
        anIntArray427[arg0] += i;
    }

    public void method255() {
        aClass40_Sub1_423.buffer = null;
        anIntArray426 = null;
        anIntArray425 = null;
        anIntArray427 = null;
        anIntArray428 = null;
    }

    public void method256(byte[] arg0) {
        aClass40_Sub1_423.buffer = arg0;
        aClass40_Sub1_423.currentPosition = 10;
        int i = aClass40_Sub1_423.getUnsignedShortBE();
        anInt431 = aClass40_Sub1_423.getUnsignedShortBE();
        anInt430 = 500000;
        anIntArray426 = new int[i];
        int i_3_ = 0;
        while(i_3_ < i) {
            int i_4_ = aClass40_Sub1_423.getIntBE();
            int i_5_ = aClass40_Sub1_423.getIntBE();
            if(i_4_ == 1297379947) {
                anIntArray426[i_3_] = aClass40_Sub1_423.currentPosition;
                i_3_++;
            }
            aClass40_Sub1_423.currentPosition += i_5_;
        }
        anIntArray425 = anIntArray426.clone();
        anIntArray427 = new int[i];
        anIntArray428 = new int[i];
    }

    public boolean method257() {
        return aClass40_Sub1_423.buffer != null;
    }

    public boolean method258() {
        return aClass40_Sub1_423.currentPosition < 0;
    }

    public void method259(long arg0) {
        aLong424 = arg0;
        int i = anIntArray425.length;
        for(int i_6_ = 0; i_6_ < i; i_6_++) {
            anIntArray427[i_6_] = 0;
            anIntArray428[i_6_] = 0;
            aClass40_Sub1_423.currentPosition = anIntArray426[i_6_];
            method254(i_6_);
            anIntArray425[i_6_] = aClass40_Sub1_423.currentPosition;
        }
    }

    public void method260(int arg0) {
        anIntArray425[arg0] = aClass40_Sub1_423.currentPosition;
    }

    public int method261(int arg0) {
        int i = aClass40_Sub1_423.buffer[aClass40_Sub1_423.currentPosition];
        if(i < 0) {
            i &= 0xff;
            anIntArray428[arg0] = i;
            aClass40_Sub1_423.currentPosition++;
        } else
            i = anIntArray428[arg0];
        if(i == 240 || i == 247) {
            int i_7_ = aClass40_Sub1_423.method500();
            if(i == 247 && i_7_ > 0) {
                int i_8_ = ((aClass40_Sub1_423.buffer[aClass40_Sub1_423.currentPosition]) & 0xff);
                if(i_8_ >= 241 && i_8_ <= 243 || i_8_ == 246 || i_8_ == 248 || i_8_ >= 250 && i_8_ <= 252 || i_8_ == 254) {
                    aClass40_Sub1_423.currentPosition++;
                    anIntArray428[arg0] = i_8_;
                    return method262(arg0, i_8_);
                }
            }
            aClass40_Sub1_423.currentPosition += i_7_;
            return 0;
        }
        return method262(arg0, i);
    }

    public int method262(int arg0, int arg1) {
        if(arg1 == 255) {
            int i = aClass40_Sub1_423.getUnsignedByte();
            int i_9_ = aClass40_Sub1_423.method500();
            if(i == 47) {
                aClass40_Sub1_423.currentPosition += i_9_;
                return 1;
            }
            if(i == 81) {
                int i_10_ = aClass40_Sub1_423.getMediumBE();
                i_9_ -= 3;
                int i_11_ = anIntArray427[arg0];
                aLong424 += (long) i_11_ * (long) (anInt430 - i_10_);
                anInt430 = i_10_;
                aClass40_Sub1_423.currentPosition += i_9_;
                return 2;
            }
            aClass40_Sub1_423.currentPosition += i_9_;
            return 3;
        }
        byte i = aByteArray429[arg1 - 128];
        int i_12_ = arg1;
        if(i >= 1)
            i_12_ |= aClass40_Sub1_423.getUnsignedByte() << 8;
        if(i >= 2)
            i_12_ |= aClass40_Sub1_423.getUnsignedByte() << 16;
        return i_12_;
    }

    public boolean method263() {
        int i = anIntArray425.length;
        for(int i_13_ = 0; i_13_ < i; i_13_++) {
            if(anIntArray425[i_13_] >= 0)
                return false;
        }
        return true;
    }

    public void method264() {
        aClass40_Sub1_423.currentPosition = -1;
    }

    public void method265(int arg0) {
        aClass40_Sub1_423.currentPosition = anIntArray425[arg0];
    }
}
