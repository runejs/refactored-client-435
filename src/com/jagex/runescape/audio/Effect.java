package com.jagex.runescape.audio;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.Class40_Sub12_Sub1;
import com.jagex.runescape.Class6;

public class Effect {
    public Instrument[] instruments;
    public int loop_begin;
    public int loop_end;

    public Effect(Buffer arg0) {
        instruments = new Instrument[10];
        for(int i = 0; i < 10; i++) {
            int i_10_ = arg0.getUnsignedByte();
            if(i_10_ != 0) {
                arg0.currentPosition--;
                instruments[i] = new Instrument();
                instruments[i].decode(arg0);
            }
        }
        loop_begin = arg0.getUnsignedShortBE();
        loop_end = arg0.getUnsignedShortBE();
    }

    public Effect() {
        instruments = new Instrument[10];
    }

    public static Effect method429(Class6 arg0, int arg1, int arg2) {
        byte[] is = arg0.method172(arg2, 123, arg1);
        if(is == null)
            return null;
        return new Effect(new Buffer(is));
    }

    public byte[] method426() {
        int i = 0;
        for(int i_0_ = 0; i_0_ < 10; i_0_++) {
            if(instruments[i_0_] != null && (instruments[i_0_].duration + instruments[i_0_].begin) > i)
                i = (instruments[i_0_].duration + instruments[i_0_].begin);
        }
        if(i == 0)
            return new byte[0];
        int i_1_ = 22050 * i / 1000;
        byte[] is = new byte[i_1_];
        for(int i_2_ = 0; i_2_ < 10; i_2_++) {
            if(instruments[i_2_] != null) {
                int i_3_ = instruments[i_2_].duration * 22050 / 1000;
                int i_4_ = instruments[i_2_].begin * 22050 / 1000;
                int[] is_5_ = instruments[i_2_].synthesize(i_3_, instruments[i_2_].duration);
                for(int i_6_ = 0; i_6_ < i_3_; i_6_++) {
                    int i_7_ = is[i_6_ + i_4_] + (is_5_[i_6_] >> 8);
                    if((i_7_ + 128 & ~0xff) != 0)
                        i_7_ = i_7_ >> 31 ^ 0x7f;
                    is[i_6_ + i_4_] = (byte) i_7_;
                }
            }
        }
        return is;
    }

    public int method427() {
        int i = 9999999;
        for(int i_8_ = 0; i_8_ < 10; i_8_++) {
            if(instruments[i_8_] != null && instruments[i_8_].begin / 20 < i)
                i = instruments[i_8_].begin / 20;
        }
        if(loop_begin < loop_end && loop_begin / 20 < i)
            i = loop_begin / 20;
        if(i == 9999999 || i == 0)
            return 0;
        for(int i_9_ = 0; i_9_ < 10; i_9_++) {
            if(instruments[i_9_] != null)
                instruments[i_9_].begin -= i * 20;
        }
        if(loop_begin < loop_end) {
            loop_begin -= i * 20;
            loop_end -= i * 20;
        }
        return i;
    }

    public Class40_Sub12_Sub1 method428() {
        byte[] is = method426();
        return new Class40_Sub12_Sub1(22050, is, 22050 * loop_begin / 1000, 22050 * loop_end / 1000);
    }
}
