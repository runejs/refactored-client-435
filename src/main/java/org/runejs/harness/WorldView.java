package org.runejs.harness;

import org.runejs.client.Game;
import org.runejs.client.Landscape;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The world as the client models it for walking: a text map of the loaded scene around the player, and a walk that
 * takes the client's own route.
 *
 * The rendered frame shows what a person sees; this shows what a person knows after playing for a while: where the
 * fences are, which side of them the player stands, where the doors and gates are, and what can be reached on foot
 * without opening anything. Every tile's flags come from the collision map the client's pathfinder reads
 * ({@code Landscape.currentCollisionMap}), so reachability here is the pathfinder's own answer, computed with the
 * same masks it applies when it plans a route.
 */
public final class WorldView {
    public static final int DEFAULT_RADIUS = 12;
    public static final int MAX_RADIUS = 40;
    private static final int SCENE_SIZE = 104;

    /**
     * The pathfinder checks these bits on the tile it would step onto: the tile is blocked whatever the direction.
     * They cover unwalkable floor, a solid object, and an object occupying the tile.
     */
    private static final int BLOCKED = 0x1280100;
    /**
     * Wall bits on a tile, by the side the wall stands on. Stepping onto a tile is refused across the wall on the
     * side the step arrives from, which is how the pathfinder's four masks below are made.
     */
    private static final int WALL_NORTH = 0x2;
    private static final int WALL_EAST = 0x8;
    private static final int WALL_SOUTH = 0x20;
    private static final int WALL_WEST = 0x80;
    private static final int STEP_WEST_ONTO = BLOCKED | WALL_EAST;
    private static final int STEP_EAST_ONTO = BLOCKED | WALL_WEST;
    private static final int STEP_SOUTH_ONTO = BLOCKED | WALL_NORTH;
    private static final int STEP_NORTH_ONTO = BLOCKED | WALL_SOUTH;

    private WorldView() {
    }

    private static int[][] clipping() {
        return Landscape.currentCollisionMap[Player.worldLevel].clippingData;
    }

    /**
     * Which tiles the player can walk to without opening anything: a flood from the player's tile over the
     * pathfinder's cardinal step masks. A diagonal step in the pathfinder requires both cardinal neighbours to be
     * enterable, so nothing is reachable diagonally that is not reachable this way.
     */
    public static boolean[][] reachable(int fromX, int fromY) {
        int[][] flags = clipping();
        boolean[][] seen = new boolean[SCENE_SIZE][SCENE_SIZE];
        int[] queueX = new int[SCENE_SIZE * SCENE_SIZE];
        int[] queueY = new int[SCENE_SIZE * SCENE_SIZE];
        int head = 0;
        int tail = 0;
        seen[fromX][fromY] = true;
        queueX[tail] = fromX;
        queueY[tail++] = fromY;
        while (head < tail) {
            int x = queueX[head];
            int y = queueY[head++];
            if (x > 0 && !seen[x - 1][y] && (flags[x - 1][y] & STEP_WEST_ONTO) == 0) {
                seen[x - 1][y] = true;
                queueX[tail] = x - 1;
                queueY[tail++] = y;
            }
            if (x < SCENE_SIZE - 1 && !seen[x + 1][y] && (flags[x + 1][y] & STEP_EAST_ONTO) == 0) {
                seen[x + 1][y] = true;
                queueX[tail] = x + 1;
                queueY[tail++] = y;
            }
            if (y > 0 && !seen[x][y - 1] && (flags[x][y - 1] & STEP_SOUTH_ONTO) == 0) {
                seen[x][y - 1] = true;
                queueX[tail] = x;
                queueY[tail++] = y - 1;
            }
            if (y < SCENE_SIZE - 1 && !seen[x][y + 1] && (flags[x][y + 1] & STEP_NORTH_ONTO) == 0) {
                seen[x][y + 1] = true;
                queueX[tail] = x;
                queueY[tail++] = y + 1;
            }
        }
        return seen;
    }

    /**
     * Whether the player could stand on this tile or right next to it: what it takes to use a door, a gate, or
     * anything else that is itself not walkable.
     */
    private static boolean reachableOrAdjacent(boolean[][] reach, int x, int y) {
        if (x < 0 || y < 0 || x >= SCENE_SIZE || y >= SCENE_SIZE) {
            return false;
        }
        return reach[x][y] || (x > 0 && reach[x - 1][y]) || (x < SCENE_SIZE - 1 && reach[x + 1][y]) || (y > 0 && reach[x][y - 1])
                || (y < SCENE_SIZE - 1 && reach[x][y + 1]);
    }

    private static char terrainGlyph(int flags, boolean reachable) {
        if ((flags & BLOCKED) != 0) {
            return '#';
        }
        boolean eastWest = (flags & (WALL_EAST | WALL_WEST)) != 0;
        boolean northSouth = (flags & (WALL_NORTH | WALL_SOUTH)) != 0;
        if (eastWest && northSouth) {
            return '+';
        }
        if (eastWest) {
            return '|';
        }
        if (northSouth) {
            return '-';
        }
        return reachable ? '.' : '~';
    }

    /**
     * What is drawn over the terrain: an entity's glyph, decided from what {@code look()} reports about it.
     */
    private static char entityGlyph(Map<String, Object> entity) {
        String type = String.valueOf(entity.get("type"));
        if ("npc".equals(type)) {
            return 'N';
        }
        if ("player".equals(type)) {
            return 'P';
        }
        if ("ground".equals(type)) {
            return 'i';
        }
        List<?> options = (List<?>) entity.get("options");
        if (options == null || options.isEmpty()) {
            return 0;
        }
        if (options.contains("Open")) {
            return 'D';
        }
        if (options.contains("Close")) {
            return 'd';
        }
        return 'O';
    }

    @SuppressWarnings("unchecked")
    private static int[] entityTile(Map<String, Object> entity) {
        Map<String, Object> at = (Map<String, Object>) entity.get("at");
        int x = ((Number) at.get("x")).intValue() - MovedStatics.baseX;
        int y = ((Number) at.get("y")).intValue() - MovedStatics.baseY;
        return new int[] {x, y};
    }

    /**
     * The scene within {@code radius} tiles of the player as text, north up and west left, with a legend of every
     * entity drawn. Reachability is judged from where the player stands now.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> map(int radius) {
        if (!Perception.inGame() || Player.localPlayer == null) {
            throw new IllegalStateException("Not in the game");
        }
        if (radius < 1 || radius > MAX_RADIUS) {
            throw new IllegalArgumentException("map radius must be between 1 and " + MAX_RADIUS + ", not " + radius);
        }
        int px = Perception.tileX(Player.localPlayer);
        int py = Perception.tileY(Player.localPlayer);
        int[][] flags = clipping();
        boolean[][] reach = reachable(px, py);

        char[][] grid = new char[2 * radius + 1][2 * radius + 1];
        for (int row = 0; row < grid.length; row++) {
            int y = py + radius - row;
            for (int column = 0; column < grid[row].length; column++) {
                int x = px - radius + column;
                if (x < 0 || y < 0 || x >= SCENE_SIZE || y >= SCENE_SIZE) {
                    grid[row][column] = ' ';
                } else {
                    grid[row][column] = terrainGlyph(flags[x][y], reach[x][y]);
                }
            }
        }

        List<Object> legend = Json.array();
        List<Object> entities = Perception.entities(radius);
        entities.addAll(Perception.groundItems(radius));
        for (Object listed : entities) {
            Map<String, Object> entity = (Map<String, Object>) listed;
            char glyph = entityGlyph(entity);
            if (glyph == 0) {
                continue;
            }
            int[] tile = entityTile(entity);
            int column = tile[0] - px + radius;
            int row = py + radius - tile[1];
            if (column < 0 || row < 0 || column >= grid.length || row >= grid.length) {
                continue;
            }
            // A door or gate is drawn over anything else on its tile, and an actor over an object.
            char current = grid[row][column];
            boolean keep = current == 'D' || current == 'd' || ((current == 'N' || current == 'P') && glyph == 'O');
            if (!keep) {
                grid[row][column] = glyph;
            }
            Map<String, Object> entry = Json.object();
            entry.put("glyph", String.valueOf(glyph));
            entry.put("ref", entity.get("ref"));
            entry.put("name", entity.get("name"));
            entry.put("at", entity.get("at"));
            entry.put("options", entity.get("options"));
            entry.put("reachable", reachableOrAdjacent(reach, tile[0], tile[1]));
            legend.add(entry);
        }
        grid[radius][radius] = '@';

        List<Object> lines = Json.array();
        for (int row = 0; row < grid.length; row++) {
            lines.add(String.format("%5d %s", Perception.absoluteY(py + radius - row), new String(grid[row])));
        }

        int reachableTiles = 0;
        for (int x = 0; x < SCENE_SIZE; x++) {
            for (int y = 0; y < SCENE_SIZE; y++) {
                if (reach[x][y]) {
                    reachableTiles++;
                }
            }
        }

        Map<String, Object> result = Json.object();
        result.put("self", Perception.position(Perception.absoluteX(px), Perception.absoluteY(py)));
        result.put("level", Player.worldLevel);
        result.put("radius", radius);
        result.put("xRuler", ruler(Perception.absoluteX(px - radius), 2 * radius + 1));
        result.put("lines", lines);
        result.put("legend", legend);
        result.put("reachableTiles", reachableTiles);
        result.put("key",
                "@ you  N npc  P player  i ground item  D closed door/gate  d open door/gate  O object with options  "
                        + "# blocked  | wall east or west  - wall north or south  + both  . reachable on foot  ~ walkable but not reachable from here");
        return result;
    }

    /**
     * Two lines that label the columns: the last two digits of every fifth x coordinate, and a tick under each.
     */
    private static List<Object> ruler(int firstX, int columns) {
        StringBuilder digits = new StringBuilder("      ");
        StringBuilder ticks = new StringBuilder("      ");
        for (int column = 0; column < columns; column++) {
            int x = firstX + column;
            if (x % 5 == 0) {
                String label = String.format("%02d", x % 100);
                digits.append(label.charAt(0));
                ticks.append(label.charAt(1));
            } else {
                digits.append(' ');
                ticks.append(' ');
            }
        }
        List<Object> lines = Json.array();
        lines.add(digits.toString());
        lines.add(ticks.toString());
        return lines;
    }

    /**
     * Walks to a tile by the client's own route, the way a click on that tile in the view would: the pathfinder
     * plans over the collision map and sends the same walk packet. When the tile cannot be reached, the pathfinder
     * settles for the nearest tile it can, as it does for a person, and the answer says so and names the closed
     * door or gate nearest the target that the player could get to, since opening it is usually the way on.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> walkTo(int absoluteX, int absoluteY) {
        if (!Perception.inGame() || Player.localPlayer == null) {
            throw new IllegalStateException("Not in the game");
        }
        int targetX = absoluteX - MovedStatics.baseX;
        int targetY = absoluteY - MovedStatics.baseY;
        if (targetX < 0 || targetY < 0 || targetX >= SCENE_SIZE || targetY >= SCENE_SIZE) {
            throw new IllegalStateException("tile:" + absoluteX + "," + absoluteY + " is outside the loaded scene");
        }
        int px = Perception.tileX(Player.localPlayer);
        int py = Perception.tileY(Player.localPlayer);
        boolean[][] reach = reachable(px, py);

        Map<String, Object> result = Json.object();
        result.put("requested", Perception.position(absoluteX, absoluteY));
        result.put("from", Perception.position(Perception.absoluteX(px), Perception.absoluteY(py)));
        result.put("targetReachable", reach[targetX][targetY]);

        boolean sent = px != targetX || py != targetY ? Pathfinding.doTileWalkTo(px, py, targetX, targetY) : false;
        result.put("sent", sent);
        if (sent) {
            int destinationX = MovedStatics.destinationX;
            int destinationY = Game.destinationY;
            result.put("destination", Perception.position(Perception.absoluteX(destinationX), Perception.absoluteY(destinationY)));
            result.put("exact", destinationX == targetX && destinationY == targetY);
        } else {
            result.put("destination", px == targetX && py == targetY ? result.get("from") : null);
            result.put("exact", px == targetX && py == targetY);
        }

        if (!reach[targetX][targetY]) {
            Map<String, Object> nearest = null;
            int nearestDistance = Integer.MAX_VALUE;
            for (Object listed : Perception.objects(MAX_RADIUS)) {
                Map<String, Object> object = (Map<String, Object>) listed;
                List<?> options = (List<?>) object.get("options");
                if (options == null || !options.contains("Open")) {
                    continue;
                }
                int[] tile = entityTile(object);
                if (!reachableOrAdjacent(reach, tile[0], tile[1])) {
                    continue;
                }
                int distance = Math.max(Math.abs(tile[0] - targetX), Math.abs(tile[1] - targetY));
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearest = object;
                }
            }
            if (nearest != null) {
                Map<String, Object> blocker = Json.object();
                blocker.put("ref", nearest.get("ref"));
                blocker.put("name", nearest.get("name"));
                blocker.put("at", nearest.get("at"));
                blocker.put("tilesFromTarget", nearestDistance);
                result.put("blockedBy", blocker);
            } else {
                result.put("blockedBy", null);
            }
        }
        return result;
    }
}
