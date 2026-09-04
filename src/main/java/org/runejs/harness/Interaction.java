package org.runejs.harness;

import org.runejs.client.ActionRowType;
import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.Point2d;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The player's hands: move the mouse, read the option menu the client builds for whatever is under it, and pick an
 * option from that menu.
 *
 * The client assembles the menu during rendering from what the rasterizer found under the cursor, so reading a menu
 * means pointing the mouse at the entity and drawing a frame. Choosing an option calls the same
 * {@link GameInterface#processMenuActions(int)} a real click reaches. Nothing here can offer an action the client
 * would not have offered a person.
 */
public final class Interaction {
    /**
     * The 3D viewport sits four pixels in from the top-left of the fixed-size frame.
     */
    private static final int VIEWPORT_OFFSET = 4;
    private static final int TILE_UNITS = 128;
    private static final int[] ACTOR_HEIGHT_FRACTIONS = {2, 4, 1};
    private static final int[] OBJECT_HEIGHTS = {80, 30, 160, 250, 10, 400};

    private final HeadlessShell shell;

    public Interaction(HeadlessShell shell) {
        this.shell = shell;
    }

    /**
     * One row of the option menu, top of the menu first.
     */
    public static final class MenuRow {
        public final int row;
        public final String text;
        public final String option;
        public final String target;
        public final int actionType;
        public final int action;
        public final int firstOperand;
        public final int secondOperand;

        private MenuRow(int row) {
            this.row = row;
            this.text = MovedStatics.menuActionTexts[row];
            this.actionType = MovedStatics.menuActionTypes[row];
            this.action = MovedStatics.selectedMenuActions[row];
            this.firstOperand = MovedStatics.firstMenuOperand[row];
            this.secondOperand = MovedStatics.secondMenuOperand[row];
            // A row reads "<option> <colour tag><target>"; the tag is where the option ends, since options
            // themselves can contain spaces ("Chop down", "Walk here").
            String raw = text == null ? "" : text;
            int tag = firstTagIndex(raw);
            this.option = stripColours(tag < 0 ? raw : raw.substring(0, tag));
            this.target = tag < 0 ? "" : stripColours(raw.substring(tag));
        }

        private static int firstTagIndex(String raw) {
            int at = raw.indexOf('@');
            int angle = raw.indexOf('<');
            if (at < 0) {
                return angle;
            }
            if (angle < 0) {
                return at;
            }
            return Math.min(at, angle);
        }

        public Map<String, Object> toJson() {
            Map<String, Object> json = Json.object();
            json.put("row", row);
            json.put("option", option);
            json.put("target", target);
            json.put("text", stripColours(text));
            json.put("actionType", actionType);
            return json;
        }
    }

    public static String stripColours(String text) {
        if (text == null) {
            return "";
        }
        return text.replaceAll("@[a-z0-9]{3}@", "").replaceAll("<[^>]*>", "").trim();
    }

    /**
     * The menu currently held by the client, top row first, without the trailing Cancel entry.
     */
    public static List<MenuRow> currentMenu() {
        List<MenuRow> rows = new ArrayList<MenuRow>();
        for (int row = MovedStatics.menuActionRow - 1; row >= 0; row--) {
            MenuRow entry = new MenuRow(row);
            if (entry.actionType == ActionRowType.CANCEL.getId()) {
                continue;
            }
            rows.add(entry);
        }
        return rows;
    }

    /**
     * Points the mouse at a screen position and renders a frame, which is what makes the client build the menu.
     */
    public void hover(int screenX, int screenY) {
        MouseEvent moved = new MouseEvent(Game.gameCanvas, MouseEvent.MOUSE_MOVED, 0L, 0, screenX, screenY, 0, false);
        Game.mouseHandler.mouseMoved(moved);
        MouseHandler.method1015();
        shell.draw();
    }

    /**
     * Result of pointing at an entity: where the mouse ended up and the menu the client offered there.
     */
    public static final class Hover {
        public final int screenX;
        public final int screenY;
        public final List<MenuRow> menu;
        public final List<MenuRow> entityRows;

        private Hover(int screenX, int screenY, List<MenuRow> menu, List<MenuRow> entityRows) {
            this.screenX = screenX;
            this.screenY = screenY;
            this.menu = menu;
            this.entityRows = entityRows;
        }

        public Map<String, Object> toJson() {
            Map<String, Object> json = Json.object();
            json.put("screen", Perception.position(screenX, screenY));
            json.put("rowsHeld", MovedStatics.menuActionRow);
            List<Object> options = Json.array();
            for (MenuRow row : entityRows) {
                options.add(row.option);
            }
            json.put("options", options);
            List<Object> menu = Json.array();
            for (MenuRow row : this.menu) {
                menu.add(row.toJson());
            }
            json.put("menu", menu);
            return json;
        }
    }

    /**
     * Finds a screen position at which the client offers a menu for {@code ref}. Several heights on the entity are
     * tried, since where a model is hit depends on its shape; the first that yields the entity's own rows wins.
     */
    public Hover hoverOver(EntityRef ref) {
        List<Point2d> candidates = candidatePoints(ref);
        Hover last = null;
        for (Point2d point : candidates) {
            int screenX = point.x + VIEWPORT_OFFSET;
            int screenY = point.y + VIEWPORT_OFFSET;
            if (!ScreenController.isCoordinatesIn3dScreen(screenX, screenY)) {
                continue;
            }
            hover(screenX, screenY);
            List<MenuRow> menu = currentMenu();
            List<MenuRow> own = rowsFor(ref, menu);
            last = new Hover(screenX, screenY, menu, own);
            if (!own.isEmpty()) {
                return last;
            }
        }
        if (last == null) {
            throw new IllegalStateException(ref + " is not on screen");
        }
        return last;
    }

    /**
     * Chooses {@code option} from the menu for {@code ref}, the way a click on that row would.
     */
    public Map<String, Object> click(EntityRef ref, String option) {
        Hover hover = hoverOver(ref);
        MenuRow chosen = null;
        for (MenuRow row : hover.entityRows) {
            if (row.option.equalsIgnoreCase(option)) {
                chosen = row;
                break;
            }
        }
        if (chosen == null) {
            List<String> offered = new ArrayList<String>();
            for (MenuRow row : hover.entityRows) {
                offered.add(row.option);
            }
            throw new IllegalStateException("\"" + option + "\" not offered for " + ref + " — menu was " + offered);
        }

        selectRow(chosen, hover);

        Map<String, Object> result = hover.toJson();
        result.put("clicked", chosen.toJson());
        return result;
    }

    /**
     * Walks to a tile: hovers it, requires "Walk here" to be the default option, and clicks.
     */
    public Map<String, Object> clickTile(int absoluteX, int absoluteY) {
        EntityRef ref = EntityRef.tile(absoluteX, absoluteY);
        Hover hover = hoverOver(ref);
        if (hover.menu.isEmpty() || hover.menu.get(0).actionType != ActionRowType.WALK_HERE.getId()) {
            throw new IllegalStateException("The default option at " + ref + " is not Walk here — menu was " + optionsOf(hover.menu));
        }

        MenuRow walk = hover.menu.get(0);
        selectRow(walk, hover);
        // Walking resolves the clicked tile during the next render, which the real client performs every frame.
        shell.draw();

        Map<String, Object> result = hover.toJson();
        result.put("clicked", walk.toJson());
        return result;
    }

    private void selectRow(MenuRow row, Hover hover) {
        MouseHandler.clickX = hover.screenX;
        MouseHandler.clickY = hover.screenY;
        GameInterface.processMenuActions(row.row);
    }

    private static List<String> optionsOf(List<MenuRow> rows) {
        List<String> options = new ArrayList<String>();
        for (MenuRow row : rows) {
            options.add(row.option);
        }
        return options;
    }

    /**
     * Which of the menu's rows belong to {@code ref}, judged by the operands the client stored with the row.
     */
    private static List<MenuRow> rowsFor(EntityRef ref, List<MenuRow> menu) {
        List<MenuRow> own = new ArrayList<MenuRow>();
        for (MenuRow row : menu) {
            if (belongsTo(ref, row)) {
                own.add(row);
            }
        }
        return own;
    }

    private static boolean belongsTo(EntityRef ref, MenuRow row) {
        int type = row.actionType >= ActionRowType.LOW_PRIORITY_MODIFIER ? row.actionType - ActionRowType.LOW_PRIORITY_MODIFIER : row.actionType;
        switch (ref.kind) {
            case NPC:
                return isNpcAction(type) && row.action == ref.index;
            case PLAYER:
                return isPlayerAction(type) && row.action == ref.index;
            case OBJECT:
                return isObjectAction(type) && Perception.objectIdFromHash(row.action) == ref.id
                        && Perception.absoluteX(row.firstOperand) == ref.x && Perception.absoluteY(row.secondOperand) == ref.y;
            case GROUND:
                return isGroundItemAction(type) && row.action == ref.id
                        && Perception.absoluteX(row.firstOperand) == ref.x && Perception.absoluteY(row.secondOperand) == ref.y;
            case TILE:
                return type == ActionRowType.WALK_HERE.getId();
            case ITEM:
            default:
                return false;
        }
    }

    private static boolean isNpcAction(int type) {
        return type == ActionRowType.INTERACT_WITH_NPC_OPTION_1.getId() || type == ActionRowType.INTERACT_WITH_NPC_OPTION_2.getId()
                || type == ActionRowType.INTERACT_WITH_NPC_OPTION_3.getId() || type == ActionRowType.INTERACT_WITH_NPC_OPTION_4.getId()
                || type == ActionRowType.INTERACT_WITH_NPC_OPTION_5.getId() || type == ActionRowType.EXAMINE_NPC.getId()
                || type == ActionRowType.USE_ITEM_ON_NPC.getId() || type == ActionRowType.CAST_MAGIC_ON_NPC.getId();
    }

    private static boolean isPlayerAction(int type) {
        return type == ActionRowType.INTERACT_WITH_PLAYER_OPTION_1.getId() || type == ActionRowType.INTERACT_WITH_PLAYER_OPTION_2.getId()
                || type == ActionRowType.INTERACT_WITH_PLAYER_OPTION_3.getId() || type == ActionRowType.INTERACT_WITH_PLAYER_OPTION_4.getId()
                || type == ActionRowType.INTERACT_WITH_PLAYER_OPTION_5.getId() || type == ActionRowType.USE_ITEM_ON_PLAYER.getId()
                || type == ActionRowType.CAST_MAGIC_ON_PLAYER.getId();
    }

    private static boolean isObjectAction(int type) {
        return type == ActionRowType.INTERACT_WITH_OBJECT_OPTION_1.getId() || type == ActionRowType.INTERACT_WITH_OBJECT_OPTION_2.getId()
                || type == ActionRowType.INTERACT_WITH_OBJECT_OPTION_3.getId() || type == ActionRowType.INTERACT_WITH_OBJECT_OPTION_4.getId()
                || type == ActionRowType.INTERACT_WITH_OBJECT_OPTION_5.getId() || type == ActionRowType.EXAMINE_OBJECT.getId()
                || type == ActionRowType.USE_ITEM_ON_OBJECT.getId() || type == ActionRowType.CAST_MAGIC_ON_OBJECT.getId();
    }

    private static boolean isGroundItemAction(int type) {
        return type == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_1.getId() || type == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_2.getId()
                || type == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_3.getId() || type == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_4.getId()
                || type == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_5.getId() || type == ActionRowType.USE_ITEM_ON_WORLD_ITEM.getId()
                || type == ActionRowType.CAST_MAGIC_ON_WORLD_ITEM.getId();
    }

    /**
     * Viewport positions worth pointing at for {@code ref}, most likely first.
     */
    private static List<Point2d> candidatePoints(EntityRef ref) {
        List<Point2d> points = new ArrayList<Point2d>();
        switch (ref.kind) {
            case NPC:
            case PLAYER: {
                Actor actor = Perception.actor(ref);
                if (actor == null) {
                    throw new IllegalStateException(ref + " is not tracked by the client");
                }
                for (int fraction : ACTOR_HEIGHT_FRACTIONS) {
                    addProjected(points, actor.anInt3117 / fraction, actor.worldY, actor.worldX);
                }
                break;
            }
            case OBJECT:
            case GROUND:
            case TILE: {
                int localX = ref.x - MovedStatics.baseX;
                int localY = ref.y - MovedStatics.baseY;
                if (localX < 0 || localY < 0 || localX >= 104 || localY >= 104) {
                    throw new IllegalStateException(ref + " is outside the loaded scene");
                }
                int fineX = localX * TILE_UNITS + TILE_UNITS / 2;
                int fineY = localY * TILE_UNITS + TILE_UNITS / 2;
                if (ref.kind == EntityRef.Kind.OBJECT) {
                    for (int height : OBJECT_HEIGHTS) {
                        addProjected(points, height, fineY, fineX);
                    }
                } else {
                    addProjected(points, 0, fineY, fineX);
                    addProjected(points, 10, fineY, fineX);
                }
                break;
            }
            case ITEM:
            default:
                throw new IllegalArgumentException(ref + " is not something on screen");
        }
        return points;
    }

    private static void addProjected(List<Point2d> points, int height, int fineY, int fineX) {
        if (Player.localPlayer == null) {
            return;
        }
        Point2d projected = MovedStatics.getProjectedScreenPosition(height, fineY, fineX);
        if (projected != null) {
            points.add(projected);
        }
    }
}
