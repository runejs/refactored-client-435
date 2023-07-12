package org.runejs.client.util;

import org.runejs.client.MovedStatics;

public class NanoTimer extends Timer {
    public long nextUpdate;

    public NanoTimer() {
        start();
    }

    public void reset() {
        start();
    }

    public void start() {
        nextUpdate = System.nanoTime();
    }

    /**
     * Gets the pending ticks required to reach the next update time, based on a set time per tick
     * @param millisPerTick the tick length in milliseconds, normally 20ms
     * @param minSleep the minimum amount to sleep for, normally 1ms
     * @return the ticks that we needed, to reach the next update time
     */
    public int getTicks(int millisPerTick, int minSleep) {
        // Converts minSleep to nanoseconds
        long minSleepNano = (long) minSleep * 1000000L;

        // Sets the sleep value to the delta till the next update
        long sleepNano = nextUpdate - System.nanoTime();

        // Make sure we always sleep above the specified minSleep value (to avoid sleeping by 0 or any negative values)
        if(sleepNano < minSleepNano)
            sleepNano = minSleepNano;

        // Sleeps the thread till the next due update
        MovedStatics.threadSleep(sleepNano / 1000000L);

        long currentNanoTime = System.nanoTime();

        // Increases the nextUpdate value by the milliseconds per tick, until we go above the current time (caps at 10 ticks)
        int ticks;
        for(ticks = 0; ticks < 10 && (ticks < 1 || nextUpdate < currentNanoTime); ticks++) {
            nextUpdate += (long) millisPerTick * 1000000L;
        }

        // Make sure we always keep the next update above or equal to the current time
        if(nextUpdate < currentNanoTime) {
            nextUpdate = currentNanoTime;
        }

        // Returns the ticks that we needed, to reach the nextUpdate time
        return ticks;
    }
}
