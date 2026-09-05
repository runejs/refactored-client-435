package org.runejs.harness;

import org.runejs.client.Game;
import org.runejs.client.scene.SceneCamera;
import org.runejs.client.GameSocket;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.media.renderable.actor.Player;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Dispatches protocol operations onto the shell.
 */
public final class HarnessCommands {
    private static final int LOGIN_SCREEN = 10;
    private static final int REGION_LOADING = 25;
    private static final int DEFAULT_RADIUS = 12;
    private static final int MAX_REGION_LOAD_LOOPS = 6000;
    private static final long IO_WAIT_TIMEOUT_MS = 15000L;
    /**
     * A client loop is 20 ms and a server tick 600 ms, so this many client cycles make one tick; animation frame
     * lengths are counted in cycles.
     */
    private static final double CYCLES_PER_TICK = 30.0;
    private static final int BACKLOG_TICKS_KEPT = 200;
    private static final int DEFAULT_CAMERA_LOOPS = HeadlessShell.LOOPS_PER_SERVER_TICK;

    private final HeadlessShell shell;
    private final Observations observations = new Observations();
    private final Interaction interaction;
    private final boolean realtime;
    /**
     * The tick at which the previous command was answered: what a live wait reports reaches back to here, so
     * nothing that happened between two commands is lost.
     */
    private long lastAnsweredTick = 0;

    public HarnessCommands(HeadlessShell shell, boolean realtime) {
        this.shell = shell;
        this.realtime = realtime;
        this.interaction = new Interaction(shell);
        observations.attach();
        if (realtime) {
            observations.countTicksFromSync();
        }
    }

    /**
     * @return the answer, or a {@link Waiter} if the answer depends on the game reaching a later state.
     */
    public Object handle(String op, Map<String, Object> request) throws IOException, InterruptedException {
        Object answer = dispatch(op, request);
        if (answer instanceof Waiter) {
            final Waiter waiter = (Waiter) answer;
            return new Waiter() {
                @Override
                public boolean isDone() {
                    return waiter.isDone();
                }

                @Override
                public Map<String, Object> result() throws Exception {
                    Map<String, Object> result = waiter.result();
                    lastAnsweredTick = observations.currentTick();
                    return result;
                }
            };
        }
        lastAnsweredTick = observations.currentTick();
        return answer;
    }

    private Object dispatch(String op, Map<String, Object> request) throws IOException, InterruptedException {
        if (op == null) {
            return Json.error("Missing op");
        }

        switch (op) {
            case "status":
                return status();
            case "loop":
                if (realtime) {
                    throw new IllegalStateException("The loop runs by itself in realtime mode");
                }
                shell.loop(Json.intValue(request, "count", 1));
                return status();
            case "draw":
                shell.draw();
                return status();
            case "login":
                return login();
            case "tick":
                return realtime ? awaitTicks(Json.intValue(request, "ticks", 1)) : tick(request);
            case "look":
                return Perception.look(Json.intValue(request, "radius", DEFAULT_RADIUS));
            case "menu":
                return interaction.hoverOver(EntityRef.parse(Json.stringValue(request, "entity"))).toJson();
            case "click":
                return interaction.click(EntityRef.parse(Json.stringValue(request, "entity")), Json.stringValue(request, "option"));
            case "click_tile":
                return interaction.clickTile(Json.intValue(request, "x", -1), Json.intValue(request, "y", -1));
            case "click_minimap":
                return interaction.clickMinimap(Json.intValue(request, "x", -1), Json.intValue(request, "y", -1));
            case "say":
                return interaction.say(Json.stringValue(request, "text"));
            case "screenshot":
                return screenshot(Json.stringValue(request, "path"));
            case "animation":
                return animation(Json.intValue(request, "id", -1));
            case "camera":
                return camera(Json.stringValue(request, "turn"), Json.intValue(request, "loops", DEFAULT_CAMERA_LOOPS));
            case "interface":
                return Widgets.dump();
            case "varp":
                return varp(Json.intValue(request, "index", -1));
            case "tab":
                return interaction.openTab(Json.intValue(request, "tab", -1));
            case "map":
                return WorldView.map(Json.intValue(request, "radius", WorldView.DEFAULT_RADIUS));
            case "walk_to":
                return WorldView.walkTo(Json.intValue(request, "x", -1), Json.intValue(request, "y", -1));
            default:
                return Json.error("Unknown op: " + op);
        }
    }

    private Map<String, Object> status() throws IOException {
        Map<String, Object> status = Json.object();
        status.put("mode", realtime ? "realtime" : "lockstep");
        status.put("gameStatus", shell.gameStatusCode());
        status.put("inGame", Perception.inGame());
        status.put("loops", shell.loops());
        status.put("frames", shell.frames());
        status.put("tick", observations.currentTick());
        status.put("error", shell.lastError());
        status.put("loadingUpdates", Game.isLoadingUpdates);
        status.put("pendingUrgentRequests",
                Game.updateServerConnectionManager == null ? 0 : Game.updateServerConnectionManager.updateServer.getActiveTaskCount(false, true));
        GameSocket socket = MovedStatics.gameServerSocket;
        status.put("bytesSent", socket == null ? 0 : socket.bytesQueued());
        status.put("bytesReceived", socket == null ? 0 : socket.bytesRead());
        if (Game.playerCamera != null) {
            Map<String, Object> camera = Json.object();
            camera.put("yaw", Game.playerCamera.getYaw());
            camera.put("pitch", Game.playerCamera.getPitch());
            camera.put("minPitch", SceneCamera.minimumPitch());
            camera.put("terrainMinPitch", SceneCamera.cameraTerrainMinScaledPitch / 256);
            status.put("camera", camera);
        }
        return status;
    }

    /**
     * Presses the login button. The credentials come from the client configuration, as they would for a person
     * who had saved them.
     */
    private Map<String, Object> login() throws IOException {
        if (shell.gameStatusCode() != LOGIN_SCREEN) {
            throw new IllegalStateException("Cannot log in from game status " + shell.gameStatusCode());
        }
        MovedStatics.processGameStatus(20);
        return status();
    }

    /**
     * One server tick's worth of client time.
     *
     * Waits until everything the server sent up to {@code awaitBytes} has arrived, runs {@code loops} iterations
     * of the client loop, keeps looping without the server if the client is busy loading a region, renders one
     * frame, waits for the client's own output to reach the network, and reports what changed.
     */
    private Map<String, Object> tick(Map<String, Object> request) throws IOException, InterruptedException {
        int loops = Json.intValue(request, "loops", HeadlessShell.LOOPS_PER_SERVER_TICK);
        long awaitBytes = Json.longValue(request, "awaitBytes", 0L);
        long serverTick = Json.longValue(request, "serverTick", observations.currentTick() + 1);

        awaitArrival(awaitBytes);
        observations.beginTick(serverTick);

        boolean wasInGame = Perception.inGame();
        long[] inventoryBefore = wasInGame ? Perception.inventorySnapshot() : null;
        int xBefore = wasInGame ? Perception.absoluteX(Perception.tileX(Player.localPlayer)) : 0;
        int yBefore = wasInGame ? Perception.absoluteY(Perception.tileY(Player.localPlayer)) : 0;

        shell.loop(loops);

        int extraLoops = 0;
        while (shell.gameStatusCode() == REGION_LOADING && extraLoops < MAX_REGION_LOAD_LOOPS) {
            shell.loop();
            extraLoops++;
        }

        if (Perception.inGame()) {
            shell.draw();
            if (wasInGame) {
                recordDerived(inventoryBefore, xBefore, yBefore);
            }
        }

        awaitFlushed();

        Map<String, Object> result = status();
        result.put("extraLoops", extraLoops);
        result.put("observations", observations.drain());
        return result;
    }

    /**
     * Live mode's `tick`: the answer arrives once the server has sent {@code ticks} more sync updates, each of which
     * marks the end of one of its ticks. What changed is reported the same way as in lockstep, diffed from now.
     */
    private Waiter awaitTicks(final int ticks) {
        // Everything since the previous answer stays: the consequences of an action can land a tick or two after
        // the command that caused it was answered (a level-up is queued a tick after its xp drop), and the gap
        // between two commands is where they would otherwise be lost. An idle stretch is bounded so that an hour
        // of sync updates does not come back as one answer.
        observations.forgetBefore(Math.max(lastAnsweredTick, observations.currentTick() - BACKLOG_TICKS_KEPT));
        final long target = observations.currentTick() + ticks;
        final boolean wasInGame = Perception.inGame();
        final long[] inventoryBefore = wasInGame ? Perception.inventorySnapshot() : null;
        final int xBefore = wasInGame ? Perception.absoluteX(Perception.tileX(Player.localPlayer)) : 0;
        final int yBefore = wasInGame ? Perception.absoluteY(Perception.tileY(Player.localPlayer)) : 0;

        return new Waiter() {
            @Override
            public boolean isDone() {
                return observations.currentTick() >= target;
            }

            @Override
            public Map<String, Object> result() throws Exception {
                if (wasInGame && Perception.inGame()) {
                    recordDerived(inventoryBefore, xBefore, yBefore);
                }
                Map<String, Object> result = status();
                result.put("observations", observations.drain());
                return result;
            }
        };
    }

    private void recordDerived(long[] inventoryBefore, int xBefore, int yBefore) {
        long[] after = Perception.inventorySnapshot();
        for (int slot = 0; slot < after.length; slot++) {
            long before = inventoryBefore[slot];
            if (before == after[slot]) {
                continue;
            }
            int idBefore = before < 0 ? -1 : (int) (before >> 32);
            int amountBefore = before < 0 ? 0 : (int) (before & 0xffffffffL);
            int idAfter = after[slot] < 0 ? -1 : (int) (after[slot] >> 32);
            int amountAfter = after[slot] < 0 ? 0 : (int) (after[slot] & 0xffffffffL);

            if (idBefore != -1 && (idAfter != idBefore || amountAfter < amountBefore)) {
                int lost = idAfter == idBefore ? amountBefore - amountAfter : amountBefore;
                observations.record("inventory.lost", itemChange(slot, idBefore, lost));
            }
            if (idAfter != -1 && (idAfter != idBefore || amountAfter > amountBefore)) {
                int gained = idAfter == idBefore ? amountAfter - amountBefore : amountAfter;
                observations.record("inventory.gained", itemChange(slot, idAfter, gained));
            }
        }

        int xAfter = Perception.absoluteX(Perception.tileX(Player.localPlayer));
        int yAfter = Perception.absoluteY(Perception.tileY(Player.localPlayer));
        if (xAfter != xBefore || yAfter != yBefore) {
            Map<String, Object> moved = Json.object();
            moved.put("from", Perception.position(xBefore, yBefore));
            moved.put("to", Perception.position(xAfter, yAfter));
            observations.record("self.moved", moved);
        }
    }

    private static Map<String, Object> itemChange(int slot, int itemId, int amount) {
        Map<String, Object> change = Json.object();
        change.put("slot", slot);
        change.put("id", itemId);
        change.put("name", Perception.itemName(itemId));
        change.put("amount", amount);
        return change;
    }

    /**
     * Blocks until {@code awaitBytes} bytes have arrived from the server. This is a wait for I/O, not for time:
     * the server has already sent them, the network merely has to deliver them.
     */
    private void awaitArrival(long awaitBytes) throws IOException, InterruptedException {
        GameSocket socket = MovedStatics.gameServerSocket;
        if (socket == null || awaitBytes <= 0) {
            return;
        }
        long deadline = System.currentTimeMillis() + IO_WAIT_TIMEOUT_MS;
        while (socket.bytesArrived() < awaitBytes) {
            if (System.currentTimeMillis() > deadline) {
                throw new IllegalStateException("Waited " + IO_WAIT_TIMEOUT_MS + " ms for " + awaitBytes + " bytes from the server, have " + socket.bytesArrived());
            }
            Thread.sleep(1L);
        }
    }

    private void awaitFlushed() throws InterruptedException {
        GameSocket socket = MovedStatics.gameServerSocket;
        if (socket == null) {
            return;
        }
        long deadline = System.currentTimeMillis() + IO_WAIT_TIMEOUT_MS;
        while (!socket.flushed()) {
            if (System.currentTimeMillis() > deadline) {
                throw new IllegalStateException("The client's output did not reach the network within " + IO_WAIT_TIMEOUT_MS + " ms");
            }
            Thread.sleep(1L);
        }
    }

    /**
     * What the cache says about an animation sequence: whether it exists and how long it runs, so a test can
     * check that a skill replays its animation as often as the animation lasts.
     */
    private Map<String, Object> animation(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("animation needs an id");
        }
        if (!Perception.inGame()) {
            throw new IllegalStateException("Animations can only be read in the game, once the definitions are loaded");
        }
        AnimationSequence sequence = AnimationSequence.getAnimationSequence(id);
        Map<String, Object> result = Json.object();
        result.put("id", id);
        boolean exists = sequence.frameLengths != null;
        result.put("exists", exists);
        int[] frameLengths = exists ? sequence.frameLengths : new int[0];
        int cycles = 0;
        for (int length : frameLengths) {
            cycles += length;
        }
        result.put("frameCount", frameLengths.length);
        result.put("frameLengths", frameLengths);
        result.put("cycles", cycles);
        result.put("ticks", cycles / CYCLES_PER_TICK);
        return result;
    }

    /**
     * Turns the camera by holding an arrow key for {@code loops} loop iterations. In lockstep those iterations
     * run here, client-only, like the extra loops a region load takes; in realtime the key stays held while the
     * loop runs on its own and the answer waits for the release.
     */
    private Object camera(String turn, final int loops) {
        if (!Perception.inGame()) {
            throw new IllegalStateException("Not in the game");
        }
        final Interaction.HeldKey held = interaction.holdKey(arrowKey(turn), loops);
        if (realtime) {
            return new Waiter() {
                @Override
                public boolean isDone() {
                    return held.isReleased();
                }

                @Override
                public Map<String, Object> result() {
                    return cameraTurned(loops);
                }
            };
        }
        shell.loop(loops);
        return cameraTurned(loops);
    }

    private static Map<String, Object> cameraTurned(int loops) {
        Map<String, Object> result = Interaction.camera();
        result.put("loops", loops);
        return result;
    }

    /**
     * The client's key listener maps the AWT arrow keys onto the four camera flags it polls each loop, so a held
     * arrow key is enough; nothing is set behind the listener's back.
     */
    private static int arrowKey(String turn) {
        if (turn == null) {
            throw new IllegalArgumentException("camera needs a turn: left, right, up or down");
        }
        switch (turn) {
            case "left":
                return KeyEvent.VK_LEFT;
            case "right":
                return KeyEvent.VK_RIGHT;
            case "up":
                return KeyEvent.VK_UP;
            case "down":
                return KeyEvent.VK_DOWN;
            default:
                throw new IllegalArgumentException("Unknown camera turn: " + turn + " (left, right, up or down)");
        }
    }

    /**
     * What the client currently holds for a player variable, which is what its interfaces render from.
     */
    private static Map<String, Object> varp(int index) {
        if (index < 0 || index >= VarPlayerDefinition.varPlayers.length) {
            throw new IllegalArgumentException("varp needs an index between 0 and " + (VarPlayerDefinition.varPlayers.length - 1));
        }
        Map<String, Object> result = Json.object();
        result.put("index", index);
        result.put("value", VarPlayerDefinition.varPlayers[index]);
        return result;
    }

    private Map<String, Object> screenshot(String path) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("screenshot needs a path");
        }
        if (Perception.inGame()) {
            shell.draw();
        }
        Screenshot.write(new File(path));
        Map<String, Object> result = Json.object();
        result.put("path", path);
        return result;
    }
}
