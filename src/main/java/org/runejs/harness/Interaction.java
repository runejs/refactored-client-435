package org.runejs.harness;

import org.runejs.client.ActionRowType;
import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.Point2d;

import java.awt.event.KeyEvent;
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
    private static final int[] WALL_HEIGHTS = {80, 160, 30};
    private static final int EDGE = TILE_UNITS / 2 - 4;
    private static final int[][] TILE_EDGES = {{-EDGE, 0}, {EDGE, 0}, {0, -EDGE}, {0, EDGE}};
    private static final int MAX_CHAT_LENGTH = 80;
    /**
     * Action types the client uses for widgets without naming them in {@code ActionRowType}: a button or clickable
     * text, a "click here to continue" line, and a widget's listener options.
     */
    private static final int WIDGET_BUTTON_ACTION = 42;
    private static final int WIDGET_CONTINUE_ACTION = 54;
    private static final int WIDGET_LISTENER_ACTION = 50;

    /**
     * The fixed-mode minimap's clickable box on screen, as {@code ScreenController.handleMinimapMouse} defines it.
     */
    private static final int MINIMAP_LEFT = 575;
    private static final int MINIMAP_TOP = 9;
    private static final int MINIMAP_WIDTH = 146;
    private static final int MINIMAP_HEIGHT = 151;
    private static final int MINIMAP_CENTRE_X = 73;
    private static final int MINIMAP_CENTRE_Y = 75;

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
        if (ref.kind == EntityRef.Kind.ITEM) {
            showInventoryTab();
        }
        List<Point2d> candidates = screenPoints(ref);
        Hover last = null;
        for (Point2d point : candidates) {
            int screenX = point.x;
            int screenY = point.y;
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
     * Chooses {@code option} from the menu for {@code ref}, the way a click on that row would. With no option
     * named, the entity's first row is chosen, which is what a left click does.
     */
    public Map<String, Object> click(EntityRef ref, String option) {
        Hover hover = hoverOver(ref);
        MenuRow chosen = null;
        for (MenuRow row : hover.entityRows) {
            if (option == null || row.option.equalsIgnoreCase(option)) {
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

    /**
     * Walks to a tile by clicking it on the minimap, which is how a player covers ground the viewport cannot show.
     *
     * The client turns a minimap pixel into a destination tile with a rotation around the player; rather than
     * invert that arithmetic, this scans the minimap for a pixel the client itself would map to the wanted tile,
     * then moves the mouse there and clicks. The next game loop iteration handles the click exactly as it would a
     * person's.
     */
    public Map<String, Object> clickMinimap(int absoluteX, int absoluteY) {
        if (Player.localPlayer == null) {
            throw new IllegalStateException("Not in the game");
        }
        int localX = absoluteX - MovedStatics.baseX;
        int localY = absoluteY - MovedStatics.baseY;

        int matches = 0;
        long sumX = 0;
        long sumY = 0;
        for (int px = 0; px < MINIMAP_WIDTH; px++) {
            for (int py = 0; py < MINIMAP_HEIGHT; py++) {
                if (minimapDestinationX(px, py) == localX && minimapDestinationY(px, py) == localY) {
                    matches++;
                    sumX += px;
                    sumY += py;
                }
            }
        }
        if (matches == 0) {
            throw new IllegalStateException("tile:" + absoluteX + "," + absoluteY + " is not on the minimap");
        }

        int screenX = MINIMAP_LEFT + (int) (sumX / matches);
        int screenY = MINIMAP_TOP + (int) (sumY / matches);
        hover(screenX, screenY);
        press(screenX, screenY);

        Map<String, Object> result = Json.object();
        result.put("screen", Perception.position(screenX, screenY));
        result.put("target", Perception.position(absoluteX, absoluteY));
        return result;
    }

    /**
     * The scene-local x tile the client would walk to for a click at this offset into the minimap box. The
     * arithmetic is {@code ScreenController.handleMinimapMouse}'s, kept identical on purpose.
     */
    private static int minimapDestinationX(int px, int py) {
        int clickX = px - MINIMAP_CENTRE_X;
        int clickY = py - MINIMAP_CENTRE_Y;
        int angle = 0x7ff & Game.getMinimapRotation();
        int sin = Rasterizer3D.sinetable[angle];
        int cos = Rasterizer3D.cosinetable[angle];
        int offset = clickY * sin + clickX * cos >> 11;
        return Player.localPlayer.worldX + offset >> 7;
    }

    private static int minimapDestinationY(int px, int py) {
        int clickX = px - MINIMAP_CENTRE_X;
        int clickY = py - MINIMAP_CENTRE_Y;
        int angle = 0x7ff & Game.getMinimapRotation();
        int sin = Rasterizer3D.sinetable[angle];
        int cos = Rasterizer3D.cosinetable[angle];
        int offset = cos * clickY - clickX * sin >> 11;
        return -offset + Player.localPlayer.worldY >> 7;
    }

    /**
     * Says something in public chat by typing it: each character and then Enter are delivered to the client's key
     * listener as the canvas would deliver them, and the client's own text handling sends the chat message on its
     * next loop iteration. A leading "::" therefore reaches the server as a command, as it would for a person.
     */
    public Map<String, Object> say(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("say needs text");
        }
        if (text.length() > MAX_CHAT_LENGTH) {
            throw new IllegalArgumentException("Chat is limited to " + MAX_CHAT_LENGTH + " characters");
        }
        if (Player.localPlayer == null) {
            throw new IllegalStateException("Not in the game");
        }
        for (int i = 0; i < text.length(); i++) {
            typeKey(KeyEvent.VK_UNDEFINED, text.charAt(i));
        }
        typeKey(KeyEvent.VK_ENTER, '\n');

        Map<String, Object> result = Json.object();
        result.put("said", text);
        return result;
    }

    private static void typeKey(int keyCode, char keyChar) {
        Game.keyFocusListener.keyPressed(keyEvent(KeyEvent.KEY_PRESSED, keyCode, keyChar));
        Game.keyFocusListener.keyReleased(keyEvent(KeyEvent.KEY_RELEASED, keyCode, keyChar));
    }

    private static KeyEvent keyEvent(int id, int keyCode, char keyChar) {
        return new KeyEvent(Game.gameCanvas, id, 0L, 0, keyCode, keyChar);
    }

    /**
     * A key that is down until the shell has run a number of further loop iterations.
     */
    public static final class HeldKey {
        public final int keyCode;
        private volatile boolean released = false;

        private HeldKey(int keyCode) {
            this.keyCode = keyCode;
        }

        public boolean isReleased() {
            return released;
        }
    }

    /**
     * Presses a key and keeps it down for {@code loops} loop iterations, then releases it, all through the key
     * listener as the canvas would deliver it. The client reads the key state on each loop, so a held arrow key
     * turns the camera at the client's own pace, as it does for a person holding the key.
     */
    public HeldKey holdKey(final int keyCode, int loops) {
        if (loops <= 0) {
            throw new IllegalArgumentException("holdKey needs a positive loop count, not " + loops);
        }
        final HeldKey held = new HeldKey(keyCode);
        Game.keyFocusListener.keyPressed(keyEvent(KeyEvent.KEY_PRESSED, keyCode, KeyEvent.CHAR_UNDEFINED));
        shell.afterLoops(loops, new Runnable() {
            @Override
            public void run() {
                Game.keyFocusListener.keyReleased(keyEvent(KeyEvent.KEY_RELEASED, keyCode, KeyEvent.CHAR_UNDEFINED));
                held.released = true;
            }
        });
        return held;
    }

    /**
     * The camera's rotation in the client's units, 2048 to a full turn. Yaw 0 looks north.
     */
    public static Map<String, Object> camera() {
        Map<String, Object> camera = Json.object();
        camera.put("yaw", Game.playerCamera.getYaw());
        camera.put("pitch", Game.playerCamera.getPitch());
        return camera;
    }

    /**
     * A left click at a screen position, delivered as the press and release the AWT canvas would deliver. The
     * client consumes it on its next loop iteration.
     */
    public void press(int screenX, int screenY) {
        MouseEvent pressed = new MouseEvent(Game.gameCanvas, MouseEvent.MOUSE_PRESSED, 0L, 0, screenX, screenY, 1, false, MouseEvent.BUTTON1);
        MouseEvent released = new MouseEvent(Game.gameCanvas, MouseEvent.MOUSE_RELEASED, 0L, 0, screenX, screenY, 1, false, MouseEvent.BUTTON1);
        Game.mouseHandler.mousePressed(pressed);
        Game.mouseHandler.mouseReleased(released);
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
            case WIDGET:
                return isWidgetAction(type) && row.secondOperand == ref.id;
            case ITEM: {
                GameInterface container = Perception.inventoryContainer();
                return container != null && isItemAction(type) && row.firstOperand == ref.index && row.secondOperand == container.id;
            }
            default:
                return false;
        }
    }

    /**
     * Rows the client adds for a widget itself: buttons and clickable text (42), "click here to continue" (54),
     * listener options (50), and the varp, close and spell buttons. Each carries the widget id as its second operand.
     */
    private static boolean isWidgetAction(int type) {
        return type == WIDGET_BUTTON_ACTION || type == WIDGET_CONTINUE_ACTION || type == WIDGET_LISTENER_ACTION
                || type == ActionRowType.BUTTON_TOGGLE_VARP.getId() || type == ActionRowType.BUTTON_SET_VARP_VALUE.getId()
                || type == ActionRowType.CLOSE_WIDGET.getId() || type == ActionRowType.CLOSE_PERMANENT_CHATBOX_WIDGET.getId()
                || type == ActionRowType.SELECT_SPELL_ON_WIDGET.getId();
    }

    /**
     * Rows for an item in an inventory widget: its own options, Use, Drop, Examine, and a selected item or spell
     * being used on it. The slot is the first operand and the widget id the second.
     */
    private static boolean isItemAction(int type) {
        return type == ActionRowType.SELECT_ITEM_ON_WIDGET.getId() || type == ActionRowType.DROP_ITEM.getId()
                || type == ActionRowType.USE_ITEM_ON_INVENTORY_ITEM.getId() || type == ActionRowType.CAST_MAGIC_ON_WIDGET_ITEM.getId()
                || type == ActionRowType.EXAMINE_ITEM_ON_V1_WIDGET.getId()
                || type == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1.getId() || type == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2.getId()
                || type == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3.getId() || type == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4.getId()
                || type == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5.getId()
                || type == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId() || type == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId()
                || type == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId() || type == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId();
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
     * Screen positions worth pointing at for {@code ref}, most likely first. Something in the scene is projected
     * through the camera and must land inside the 3D view; a widget or an inventory slot is where the client
     * draws it.
     */
    private static List<Point2d> screenPoints(EntityRef ref) {
        List<Point2d> points = new ArrayList<Point2d>();
        if (ref.kind == EntityRef.Kind.WIDGET) {
            Widgets.Widget widget = Widgets.find(ref.id);
            if (widget == null) {
                throw new IllegalStateException(ref + " is not part of any open interface");
            }
            // A widget in a layer the client hides until hovered still has a place on screen; pointing at it is
            // exactly what reveals it. Only something scrolled or clipped out of its parents cannot be reached.
            if (!widget.inside) {
                throw new IllegalStateException(ref + " is not on screen: it is scrolled or clipped out of view");
            }
            points.add(new Point2d(widget.centreX(), widget.centreY()));
            return points;
        }
        if (ref.kind == EntityRef.Kind.ITEM) {
            GameInterface container = Perception.inventoryContainer();
            Widgets.Widget widget = container == null ? null : Widgets.find(container.id);
            if (widget == null) {
                throw new IllegalStateException(ref + " cannot be pointed at: the inventory is not the open tab");
            }
            int[] rect = widget.slotRect(ref.index);
            points.add(new Point2d(rect[0] + rect[2] / 2, rect[1] + rect[3] / 2));
            return points;
        }
        for (Point2d viewport : candidatePoints(ref)) {
            int screenX = viewport.x + VIEWPORT_OFFSET;
            int screenY = viewport.y + VIEWPORT_OFFSET;
            if (ScreenController.isCoordinatesIn3dScreen(screenX, screenY)) {
                points.add(new Point2d(screenX, screenY));
            }
        }
        return points;
    }

    /**
     * Viewport positions worth pointing at for something in the scene, most likely first.
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
                    // A wall object such as a door or a gate stands on one edge of its tile, not at its centre.
                    for (int height : WALL_HEIGHTS) {
                        for (int[] edge : TILE_EDGES) {
                            addProjected(points, height, fineY + edge[1], fineX + edge[0]);
                        }
                    }
                } else {
                    addProjected(points, 0, fineY, fineX);
                    addProjected(points, 10, fineY, fineX);
                }
                break;
            }
            case ITEM:
            case WIDGET:
            default:
                throw new IllegalArgumentException(ref + " is not something in the scene");
        }
        return points;
    }

    /**
     * Brings the inventory tab to the front if another tab is showing, by clicking its button and letting the
     * client take one loop iteration to handle the click, as it would for a person. An interface occupying the
     * tab area (a shop, a skill guide) is left alone: a person would have to close it first.
     */
    private void showInventoryTab() {
        if (Game.currentTabId == Perception.INVENTORY_TAB || Game.tabWidgetIds[Perception.INVENTORY_TAB] == -1) {
            return;
        }
        if (GameInterface.tabAreaInterfaceId != -1) {
            throw new IllegalStateException("The inventory cannot be pointed at: interface " + GameInterface.tabAreaInterfaceId + " covers the tab area");
        }
        openTab(Perception.INVENTORY_TAB);
        shell.loop();
    }

    /**
     * Opens a side tab by clicking its button, which the client handles on its next loop iteration.
     */
    public Map<String, Object> openTab(int tab) {
        int[] button = Widgets.tabButton(tab);
        if (button == null) {
            throw new IllegalStateException("Tab " + tab + " has no interface to show");
        }
        hover(button[0], button[1]);
        press(button[0], button[1]);
        Map<String, Object> result = Json.object();
        result.put("tab", tab);
        result.put("screen", Perception.position(button[0], button[1]));
        return result;
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
