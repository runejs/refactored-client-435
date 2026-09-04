package org.runejs.harness;

import org.runejs.client.Game;
import org.runejs.client.GameSocket;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;

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

    private final HeadlessShell shell;
    private final Observations observations = new Observations();
    private final Interaction interaction;
    private final boolean realtime;

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
        // Whatever arrived while nobody was waiting is not "what happened during this wait", and after an idle
        // stretch it can be hours of sync updates.
        observations.drain();
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
