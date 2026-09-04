package org.runejs.harness;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Runs a command on the game thread and returns its answer, waiting for a {@link Waiter} to finish if the command
 * hands one back.
 */
public interface CommandExecutor {
    Map<String, Object> execute(Callable<Object> command) throws Exception;
}
