package org.runejs.harness;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Lockstep mode: the socket thread is the game thread, so commands simply run.
 */
public final class InlineExecutor implements CommandExecutor {
    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> execute(Callable<Object> command) throws Exception {
        Object answer = command.call();
        if (answer instanceof Waiter) {
            throw new IllegalStateException("A deferred command is only possible in realtime mode");
        }
        return (Map<String, Object>) answer;
    }
}
