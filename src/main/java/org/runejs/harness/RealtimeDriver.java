package org.runejs.harness;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;

/**
 * Live mode: the client runs on its own, one loop iteration every 20 ms as {@code GameShell} would, against a
 * server that ticks by itself. Commands are queued from the socket thread and executed by this thread between
 * iterations, so the client's state cannot change under a command, and a {@link Waiter} is re-checked after every
 * iteration until it is satisfied.
 */
public final class RealtimeDriver implements CommandExecutor, Runnable {
    private static final long LOOP_INTERVAL_NANOS = 20_000_000L;
    private static final int LOOPS_PER_FRAME = 2;

    private static final class Pending {
        final Waiter waiter;
        final CompletableFuture<Map<String, Object>> future;

        Pending(Waiter waiter, CompletableFuture<Map<String, Object>> future) {
            this.waiter = waiter;
            this.future = future;
        }
    }

    private static final class Submitted {
        final Callable<Object> command;
        final CompletableFuture<Map<String, Object>> future;

        Submitted(Callable<Object> command, CompletableFuture<Map<String, Object>> future) {
            this.command = command;
            this.future = future;
        }
    }

    private final HeadlessShell shell;
    private final ConcurrentLinkedQueue<Submitted> submitted = new ConcurrentLinkedQueue<Submitted>();
    private final List<Pending> pending = new ArrayList<Pending>();
    private volatile boolean running = true;

    public RealtimeDriver(HeadlessShell shell) {
        this.shell = shell;
    }

    public void stop() {
        running = false;
    }

    @Override
    public Map<String, Object> execute(Callable<Object> command) throws Exception {
        CompletableFuture<Map<String, Object>> future = new CompletableFuture<Map<String, Object>>();
        submitted.add(new Submitted(command, future));
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Exception) {
                throw (Exception) cause;
            }
            throw e;
        }
    }

    @Override
    public void run() {
        int loopsSinceFrame = 0;
        while (running) {
            long started = System.nanoTime();

            runSubmitted();
            shell.loop();
            loopsSinceFrame++;
            if (loopsSinceFrame >= LOOPS_PER_FRAME && Perception.inGame()) {
                shell.draw();
                loopsSinceFrame = 0;
            }
            checkPending();

            long elapsed = System.nanoTime() - started;
            long remaining = LOOP_INTERVAL_NANOS - elapsed;
            if (remaining > 0) {
                try {
                    Thread.sleep(remaining / 1_000_000L, (int) (remaining % 1_000_000L));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        failPending(new IllegalStateException("The client is shutting down"));
    }

    @SuppressWarnings("unchecked")
    private void runSubmitted() {
        Submitted next;
        while ((next = submitted.poll()) != null) {
            try {
                Object answer = next.command.call();
                if (answer instanceof Waiter) {
                    pending.add(new Pending((Waiter) answer, next.future));
                } else {
                    next.future.complete((Map<String, Object>) answer);
                }
            } catch (Exception e) {
                next.future.completeExceptionally(e);
            }
        }
    }

    private void checkPending() {
        Iterator<Pending> iterator = pending.iterator();
        while (iterator.hasNext()) {
            Pending entry = iterator.next();
            try {
                if (entry.waiter.isDone()) {
                    entry.future.complete(entry.waiter.result());
                    iterator.remove();
                }
            } catch (Exception e) {
                entry.future.completeExceptionally(e);
                iterator.remove();
            }
        }
    }

    private void failPending(Exception reason) {
        for (Pending entry : pending) {
            entry.future.completeExceptionally(reason);
        }
        pending.clear();
        Submitted next;
        while ((next = submitted.poll()) != null) {
            next.future.completeExceptionally(reason);
        }
    }
}
