package com.jagex.runescape.util;

import com.jagex.runescape.Class43;

public class NanoTimer extends Timer {
    public long last;

    public NanoTimer() {
        start();
    }

    public void reset() {
        start();
    }

    public void start() {
        last = System.nanoTime();
    }

    public int sleep(int arg0, int arg1) {
        int i;
        try {
            long l = (long) arg1 * 1000000L;
            long l_0_ = last - System.nanoTime();
            if(l > l_0_) {
                l_0_ = l;
            }
            Class43.sleep(l_0_ / 1000000L);
            long l_1_ = System.nanoTime();
            int i_2_;
            for(i_2_ = 0; i_2_ < 10 && (i_2_ < 1 || last < l_1_); i_2_++) {
                last += (long) arg0 * 1000000L;
            }
            if(l_1_ > last) {
                last = l_1_;
            }
            i = i_2_;
        } catch(RuntimeException runtimeexception) {
            throw runtimeexception;
        }
        return i;
    }
}
