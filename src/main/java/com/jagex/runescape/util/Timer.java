package com.jagex.runescape.util;

public abstract class Timer {
    public static Timer create() {
        try {
            return (Timer) Class.forName("com.jagex.runescape.util.NanoTimer").newInstance();
        } catch(Throwable throwable) {
            return new MillisTimer();
        }
    }

    public abstract int sleep(int i, int i_0_);

    public abstract void start();

    public abstract void reset();
}
