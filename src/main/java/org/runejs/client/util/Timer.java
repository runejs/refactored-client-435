package org.runejs.client.util;

public abstract class Timer {
    public abstract int getTicks(int i, int i_0_);

    public abstract void start();

    public abstract void reset();

	public static Timer create() {
	    try {
	        return (Timer) Class.forName("org.runejs.client.util.NanoTimer").newInstance();
	    } catch(Throwable throwable) {
	        return new MillisTimer();
	    }
	}
}
