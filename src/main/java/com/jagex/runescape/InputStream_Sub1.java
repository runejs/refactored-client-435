package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;

import java.io.InputStream;

public class InputStream_Sub1 extends InputStream {
    public int[] objecttypes;
    public boolean aBoolean72;
    public byte[] aByteArray73 = new byte[65536];
    public int[] anIntArray74;

    public InputStream_Sub1() {
        objecttypes = (new int[]{0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7});
        anIntArray74 = new int[256];
        for(int i = -32768; i < 32768; i++)
            aByteArray73[i + 32768] = method49(i);
    }

    public static void method48(byte[] arg0, int[] arg1, byte[] arg2, int arg3, int arg4, int arg5) {
        for(arg3 = 0; arg3 < arg5; arg3++)
            arg2[arg4++] = arg0[(arg1[arg3] >> 8) + 32768];
    }

    public int read() {
        byte[] is = new byte[1];
        read(is, 0, 1);
        return is[0];
    }

    public byte method49(int arg0) {
        int i = arg0 >> 8 & 0x80;
        if(i != 0)
            arg0 = -arg0;
        if(arg0 > 32635)
            arg0 = 32635;
        arg0 += 132;
        int i_0_ = objecttypes[arg0 >> 7 & 0xff];
        int i_1_ = arg0 >> i_0_ + 3 & 0xf;
        byte i_2_ = (byte) ((i | i_0_ << 4 | i_1_) ^ 0xffffffff);
        return i_2_;
    }

    public synchronized int read(byte[] arg0, int arg1, int arg2) {
        try {
            if(aBoolean72)
                return -1;
            if(arg2 > 256) {
                read(arg0, arg1, 256);
                read(arg0, arg1 + 256, arg2 - 256);
                return arg2;
            }
            Class8.method215(anIntArray74, arg2);
            for(int i = 0; i < arg2; i++) {
                int i_3_ = anIntArray74[i];
                if((i_3_ + 8388608 & ~0xffffff) != 0)
                    anIntArray74[i] = 0x7fffff ^ i_3_ >> 31;
            }
            method48(aByteArray73, anIntArray74, arg0, 0, arg1, arg2);
            return arg2;
        } catch(Exception exception) {
            aBoolean72 = true;
            CacheIndex.method169(null, (byte) -125, exception);
            return -1;
        }
    }
}
