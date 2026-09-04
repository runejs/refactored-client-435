package org.runejs.harness;

import org.runejs.client.Game;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceArea;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.ScreenController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The interfaces the client is showing, laid out on screen the way the client's own hit-testing lays them out.
 *
 * {@code MovedStatics.handleInterfaceActions} walks an interface's children from a region's top-left corner,
 * offsetting each child by its parent's position and scroll; the same walk here yields where every widget is, so
 * that a widget can be pointed at and its text read. The regions are the fixed-mode ones the client passes to that
 * walk: the 3D view for a screen interface, the whole frame for a fullscreen one, the tab area, and the chatbox.
 */
public final class Widgets {
    private static final int[] GAME_AREA = {4, 4, 516, 338};
    private static final int[] FULLSCREEN = {0, 0, 765, 503};
    private static final int[] TAB_AREA = {553, 205, 743, 466};
    /**
     * The chatbox, as {@code ScreenController.handleChatBoxMouse} measures it from the bottom of the frame.
     */
    private static final int CHAT_LEFT = 17;
    private static final int CHAT_WIDTH = 479;
    private static final int CHAT_HEIGHT = 96;
    private static final int CHAT_BOTTOM_OFFSET = 50;
    /**
     * The tab buttons around the tab area, as {@code ScreenController.handleTabClick} tests them: an origin and,
     * per tab, the box relative to it.
     */
    private static final int TAB_BUTTONS_LEFT = 539;
    private static final int TAB_BUTTONS_TOP = 168;
    private static final int[][] TAB_BUTTONS = {
            {0, 1, 34, 37}, {30, 0, 60, 37}, {58, 0, 88, 37}, {86, 0, 130, 35}, {127, 0, 157, 37}, {155, 0, 185, 37}, {183, 1, 217, 37},
            {1, 298, 35, 334}, {33, 298, 63, 335}, {60, 298, 90, 335}, {88, 299, 132, 334}, {130, 298, 160, 335}, {157, 298, 187, 335},
            {185, 298, 219, 334},
    };
    private static final int ITEM_CELL = 32;
    private static final int SLOTS_WITH_OFFSETS = 20;

    private Widgets() {
    }

    /**
     * One widget as drawn: which interface it belongs to, where it is on screen, and whether that place is inside
     * its parents' bounds, which is what a scrolled-away line of text is not.
     */
    public static final class Widget {
        public final String area;
        public final int index;
        public final GameInterface component;
        public final int x;
        public final int y;
        /**
         * Inside every ancestor's bounds: somewhere the mouse can reach at all.
         */
        public final boolean inside;
        /**
         * Inside and not in a layer the client hides until the mouse is over it.
         */
        public final boolean visible;

        private Widget(String area, int index, GameInterface component, int x, int y, boolean inside, boolean visible) {
            this.area = area;
            this.index = index;
            this.component = component;
            this.x = x;
            this.y = y;
            this.inside = inside;
            this.visible = visible;
        }

        public int centreX() {
            return x + component.width / 2;
        }

        public int centreY() {
            return y + component.height / 2;
        }

        /**
         * Where slot {@code slot} of an inventory widget is drawn, as the client places it.
         */
        public int[] slotRect(int slot) {
            if (component.type != GameInterfaceType.INVENTORY) {
                throw new IllegalStateException("widget:" + component.id + " is not an inventory");
            }
            int columns = component.width;
            int column = slot % columns;
            int row = slot / columns;
            int slotX = x + column * (component.invMarginX + ITEM_CELL);
            int slotY = y + row * (component.invMarginY + ITEM_CELL);
            if (slot < SLOTS_WITH_OFFSETS && component.invSlotImage != null) {
                slotX += component.invSlotImage[slot];
                slotY += component.invSlotOffsetX[slot];
            }
            return new int[] {slotX, slotY, ITEM_CELL, ITEM_CELL};
        }

        public Map<String, Object> toJson() {
            Map<String, Object> json = Json.object();
            json.put("ref", "widget:" + component.id);
            json.put("id", component.id);
            json.put("index", index);
            json.put("parent", component.layer);
            json.put("type", component.type == null ? "UNKNOWN" : component.type.name());
            json.put("x", x);
            json.put("y", y);
            json.put("width", component.width);
            json.put("height", component.height);
            json.put("visible", visible);
            if (inside && !visible) {
                json.put("hoverOnly", true);
            }
            if (component.hide) {
                json.put("hidden", true);
            }
            if (component.text != null && component.text.length() > 0) {
                String text = Interaction.stripColours(component.text);
                json.put("text", text);
                json.put("color", String.format("%06x", component.textColor & 0xffffff));
                // The width the client draws the text at, in its own font; wider than the widget means clipped.
                TypeFace font = component.getTypeFace();
                if (font != null) {
                    json.put("textWidth", font.getStringWidth(text));
                }
            }
            if (component.option != null && component.option.length() > 0) {
                json.put("option", component.option);
            }
            if (component.buttonType != 0) {
                json.put("buttonType", component.buttonType);
            }
            if (component.contentType != 0) {
                json.put("contentType", component.contentType);
            }
            if (component.itemId > 0 && component.if3) {
                json.put("itemId", component.itemId);
            }
            if (component.type == GameInterfaceType.INVENTORY && component.invSlotObjId != null) {
                json.put("items", items());
            }
            if (component.scrollableHeight > component.height) {
                json.put("scrollY", component.scrollY);
                json.put("scrollableHeight", component.scrollableHeight);
            }
            return json;
        }

        private List<Object> items() {
            List<Object> items = Json.array();
            for (int slot = 0; slot < component.invSlotObjId.length; slot++) {
                int stored = component.invSlotObjId[slot];
                if (stored <= 0) {
                    continue;
                }
                Map<String, Object> item = Json.object();
                item.put("slot", slot);
                item.put("id", stored - 1);
                item.put("name", Perception.itemName(stored - 1));
                item.put("amount", component.invSlotObjCount[slot]);
                items.add(item);
            }
            return items;
        }
    }

    /**
     * Every widget of every interface currently open, in drawing order.
     */
    public static List<Widget> all() {
        List<Widget> widgets = new ArrayList<Widget>();
        int chatTop = ScreenController.drawHeight - CHAT_BOTTOM_OFFSET - CHAT_HEIGHT;
        int[] chat = {CHAT_LEFT, chatTop, CHAT_LEFT + CHAT_WIDTH, chatTop + CHAT_HEIGHT};

        collect("fullscreen", GameInterfaceArea.GAME_AREA, GameInterface.fullscreenInterfaceId, FULLSCREEN, widgets);
        collect("screen", GameInterfaceArea.GAME_AREA, GameInterface.gameScreenInterfaceId, GAME_AREA, widgets);
        int tabInterface = GameInterface.tabAreaInterfaceId != -1 ? GameInterface.tabAreaInterfaceId : currentTabInterface();
        collect("tabArea", GameInterfaceArea.TAB_AREA, tabInterface, TAB_AREA, widgets);
        collect("dialogue", GameInterfaceArea.PERMANENT_CHAT_BOX_WIDGET, ChatBox.dialogueId, chat, widgets);
        collect("chatbox", GameInterfaceArea.CHAT_AREA, GameInterface.chatboxInterfaceId, chat, widgets);
        return widgets;
    }

    private static int currentTabInterface() {
        if (Game.tabWidgetIds == null || Game.currentTabId < 0 || Game.currentTabId >= Game.tabWidgetIds.length) {
            return -1;
        }
        return Game.tabWidgetIds[Game.currentTabId];
    }

    private static void collect(String area, GameInterfaceArea areaKind, int interfaceId, int[] region, List<Widget> out) {
        if (interfaceId == -1 || !GameInterface.load(interfaceId)) {
            return;
        }
        walk(area, areaKind.getId(), region[0], region[1], region[2], region[3], GameInterface.components[interfaceId], -1, 0, 0, true, true, out);
    }

    /**
     * The geometry of {@code MovedStatics.handleInterfaceActions}: a child sits at its own offset from the region's
     * corner, less its parent's scroll; a layer opens a region of its own for its children.
     */
    private static void walk(String area, int areaId, int minX, int minY, int maxX, int maxY, GameInterface[] children, int parentId, int scrollY,
            int scrollX, boolean parentInside, boolean parentVisible, List<Widget> out) {
        if (children == null) {
            return;
        }
        for (int i = 0; i < children.length; i++) {
            GameInterface child = children[i];
            if (child == null || child.layer != parentId) {
                continue;
            }
            int x = child.x - scrollX + minX;
            int y = child.y - scrollY + minY;
            boolean inside = parentInside && x < maxX && x + child.width > minX && y < maxY && y + child.height > minY;
            boolean visible = parentVisible && inside;
            if (child.type == GameInterfaceType.LAYER && child.hide && !GameInterface.isHovering(areaId, i)) {
                visible = false;
            }
            out.add(new Widget(area, i, child, x, y, inside, visible));
            if (child.type == GameInterfaceType.LAYER) {
                walk(area, areaId, x, y, x + child.width, y + child.height, children, i, child.scrollY, child.scrollX, inside, visible, out);
                walk(area, areaId, x, y, x + child.width, y + child.height, child.createdComponents, child.id, child.scrollY, child.scrollX, inside, visible, out);
            }
        }
    }

    /**
     * The widget with this id, preferring one that is on screen over one scrolled away or hidden.
     */
    public static Widget find(int widgetId) {
        Widget fallback = null;
        for (Widget widget : all()) {
            if (widget.component.id != widgetId) {
                continue;
            }
            if (widget.visible) {
                return widget;
            }
            if (fallback == null) {
                fallback = widget;
            }
        }
        return fallback;
    }

    /**
     * The open interfaces, area by area, with every widget's place and text.
     */
    public static Map<String, Object> dump() {
        Map<String, List<Object>> areas = new LinkedHashMap<String, List<Object>>();
        for (Widget widget : all()) {
            List<Object> list = areas.get(widget.area);
            if (list == null) {
                list = Json.array();
                areas.put(widget.area, list);
            }
            list.add(widget.toJson());
        }
        Map<String, Object> widgets = Json.object();
        widgets.putAll(areas);
        Map<String, Object> dump = Json.object();
        dump.put("interfaces", Perception.interfaces());
        dump.put("widgets", widgets);
        return dump;
    }

    /**
     * The screen position of tab button {@code tab}, or null when that tab has no interface to show.
     */
    public static int[] tabButton(int tab) {
        if (tab < 0 || tab >= TAB_BUTTONS.length) {
            throw new IllegalArgumentException("There are " + TAB_BUTTONS.length + " tabs, numbered from 0; " + tab + " is not one");
        }
        if (Game.tabWidgetIds == null || Game.tabWidgetIds[tab] == -1) {
            return null;
        }
        int[] box = TAB_BUTTONS[tab];
        return new int[] {TAB_BUTTONS_LEFT + (box[0] + box[2]) / 2, TAB_BUTTONS_TOP + (box[1] + box[3]) / 2};
    }
}
