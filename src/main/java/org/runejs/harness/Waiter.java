package org.runejs.harness;

import java.util.Map;

/**
 * A command whose answer is not ready yet: it completes once the game has reached some state, which only the game
 * thread can observe, one loop iteration at a time.
 */
public interface Waiter {
    boolean isDone();

    Map<String, Object> result() throws Exception;
}
