package org.runejs.harness;

import org.runejs.Configuration;
import org.runejs.client.Game;
import org.runejs.client.GameErrorHandler;
import org.runejs.client.MovedStatics;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.renderer.SoftwareRenderer;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.Timer;

import java.awt.Canvas;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Runs the real {@link Game} without {@link org.runejs.client.GameShell}: no window, no timer, no sleeping.
 *
 * {@code GameShell.run()} is a loop that calls {@code Game.processGameLoop()} every 20 ms and {@code Game.draw()}
 * whenever it has caught up. This shell exposes those two calls and nothing else, so whoever holds it decides
 * exactly how many loop iterations happen and when a frame is rendered. The rest of the client neither knows nor
 * cares which shell it is running under.
 */
public final class HeadlessShell implements GameErrorHandler {
    /**
     * A server tick is 600 ms and the client loop is 20 ms, so this many loop iterations make up one server tick.
     */
    public static final int LOOPS_PER_SERVER_TICK = 30;

    private static final int WIDTH = 765;
    private static final int HEIGHT = 503;
    private static final int CLIENT_VERSION = 435;
    private static final int CACHE_INDEX_COUNT = 13;
    private static final int FILE_STORE_ID = 32;

    /**
     * Something to do once a number of further loop iterations have run: how a key stays held for a while, in
     * either mode, without anyone sleeping.
     */
    private static final class Deferred {
        int loopsLeft;
        final Runnable action;

        Deferred(int loopsLeft, Runnable action) {
            this.loopsLeft = loopsLeft;
            this.action = action;
        }
    }

    private final Game game;
    private final List<Deferred> deferred = new ArrayList<Deferred>();
    private long loops = 0;
    private long frames = 0;
    private String lastError = null;

    public HeadlessShell() {
        this.game = new Game(new String[0]);
        this.game.setErrorHandler(this);
    }

    /**
     * Mirrors the setup that {@code GameShell.openClientApplet()} and the head of {@code GameShell.run()} perform,
     * minus the frame, the focus plumbing and the timer.
     */
    public void boot(InetAddress serverAddress) throws Exception {
        Game.clientVersion = CLIENT_VERSION;
        MovedStatics.width = WIDTH;
        MovedStatics.height = HEIGHT;
        ScreenController.frameMode(ScreenMode.FIXED);

        MovedStatics.signlink = Game.signlink = new Signlink(true, null, serverAddress, FILE_STORE_ID, "client435", CACHE_INDEX_COUNT);

        Game.renderer = new SoftwareRenderer();
        Game.gameCanvas = new Canvas();
        Game.gameCanvas.setSize(WIDTH, HEIGHT);
        MovedStatics.aProducingGraphicsBuffer_2213 = MovedStatics.createGraphicsBuffer(MovedStatics.width, MovedStatics.height, Game.gameCanvas);
        Game.isClientFocused = true;

        game.startup();
        // The client resets this timer when it starts loading; it is never consulted for pacing here.
        Game.gameTimer = Timer.create();
        Game.gameTimer.start();
    }

    /**
     * One iteration of the client loop, exactly as {@code GameShell.run()} performs it.
     */
    public void loop() {
        loops++;
        MovedStatics.tickSamples[MovedStatics.currentTickSample] = System.currentTimeMillis();
        MovedStatics.currentTickSample = 0x1f & MovedStatics.currentTickSample + 1;
        game.processGameLoop();
        runDeferred();
    }

    /**
     * Runs {@code action} after {@code loops} more loop iterations, on the game thread, once the iteration that
     * brings the count to zero has finished.
     */
    public void afterLoops(int loops, Runnable action) {
        if (loops <= 0) {
            throw new IllegalArgumentException("afterLoops needs a positive loop count, not " + loops);
        }
        deferred.add(new Deferred(loops, action));
    }

    private void runDeferred() {
        Iterator<Deferred> iterator = deferred.iterator();
        while (iterator.hasNext()) {
            Deferred entry = iterator.next();
            if (--entry.loopsLeft <= 0) {
                iterator.remove();
                entry.action.run();
            }
        }
    }

    public void loop(int iterations) {
        for (int i = 0; i < iterations; i++) {
            loop();
        }
    }

    /**
     * Renders one frame into the off-screen buffers. Rendering is where the client decides what is under the mouse
     * and assembles the option menu, so anything that reads the menu must draw first.
     */
    public void draw() {
        frames++;
        game.draw();
    }

    public void close() {
        game.close();
    }

    public int gameStatusCode() {
        return Game.gameStatusCode;
    }

    public long loops() {
        return loops;
    }

    public long frames() {
        return frames;
    }

    public String lastError() {
        return lastError;
    }

    public String serverAddress() {
        return Configuration.SERVER_ADDRESS;
    }

    @Override
    public void handleGameError(String errorMessage) {
        lastError = errorMessage;
        System.err.println("client error: " + errorMessage);
    }
}
