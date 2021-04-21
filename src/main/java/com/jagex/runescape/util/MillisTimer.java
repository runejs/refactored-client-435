package com.jagex.runescape.util;

import com.jagex.runescape.Class43;

public class MillisTimer extends Timer {
    public int pos;
    public int anInt1903;
    public long[] cache = new long[10];
    public int sleep;
    public long time;
    public int anInt1915;

    public MillisTimer() {
        start();
    }

    public void reset() {
        for(int i_0_ = 0; i_0_ < 10; i_0_++)
            cache[i_0_] = 0L;
    }

    public void start() {
        anInt1915 = 256;
        anInt1903 = 0;
        sleep = 1;
        time = System.currentTimeMillis();
        for(int i = 0; i < 10; i++)
            cache[i] = time;
    }

    public int sleep(int arg0, int arg1) {
        int i = sleep;
        sleep = 1;
        int i_5_ = anInt1915;
        anInt1915 = 300;
        time = System.currentTimeMillis();
        if(cache[pos] == 0L) {
            anInt1915 = i_5_;
            sleep = i;
        } else if(time > cache[pos])
            anInt1915 = (int) ((long) (arg0 * 2560) / (-cache[pos] + time));
        if(anInt1915 < 25)
            anInt1915 = 25;
        if(anInt1915 > 256) {
            anInt1915 = 256;
            sleep = (int) ((long) arg0 - (time - cache[pos]) / 10L);
        }
        if(arg0 < sleep)
            sleep = arg0;
        cache[pos] = time;
        pos = (pos + 1) % 10;
        if(sleep > 1) {
            for(int i_6_ = 0; i_6_ < 10; i_6_++) {
                if(cache[i_6_] != 0L)
                    cache[i_6_] = (long) sleep + cache[i_6_];
            }
        }
        if(sleep < arg1)
            sleep = arg1;
        Class43.sleep(sleep);
        int i_7_ = 0;
        for(/**/; anInt1903 < 256; anInt1903 += anInt1915)
            i_7_++;
        anInt1903 &= 0xff;
        return i_7_;

    }
}
