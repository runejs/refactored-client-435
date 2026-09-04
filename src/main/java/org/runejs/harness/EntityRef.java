package org.runejs.harness;

/**
 * How the controller names things it can see. The forms are exactly what {@code look()} reports, so an agent
 * can only refer to something the client has shown it.
 *
 * <pre>
 * npc:&lt;index&gt;              an NPC by its server index
 * player:&lt;index&gt;           another player by index
 * object:&lt;id&gt;@&lt;x&gt;,&lt;y&gt;      a scene object by id and absolute tile
 * ground:&lt;itemId&gt;@&lt;x&gt;,&lt;y&gt;  an item on the floor
 * item:&lt;slot&gt;              an inventory slot
 * tile:&lt;x&gt;,&lt;y&gt;             a walkable tile
 * widget:&lt;id&gt;              a widget of an open interface, as {@code interface} reports it
 * </pre>
 */
public final class EntityRef {
    public enum Kind { NPC, PLAYER, OBJECT, GROUND, ITEM, TILE, WIDGET }

    public final Kind kind;
    public final int index;
    public final int id;
    public final int x;
    public final int y;

    private EntityRef(Kind kind, int index, int id, int x, int y) {
        this.kind = kind;
        this.index = index;
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public static EntityRef npc(int index) {
        return new EntityRef(Kind.NPC, index, -1, -1, -1);
    }

    public static EntityRef player(int index) {
        return new EntityRef(Kind.PLAYER, index, -1, -1, -1);
    }

    public static EntityRef object(int id, int x, int y) {
        return new EntityRef(Kind.OBJECT, -1, id, x, y);
    }

    public static EntityRef ground(int itemId, int x, int y) {
        return new EntityRef(Kind.GROUND, -1, itemId, x, y);
    }

    public static EntityRef item(int slot) {
        return new EntityRef(Kind.ITEM, slot, -1, -1, -1);
    }

    public static EntityRef tile(int x, int y) {
        return new EntityRef(Kind.TILE, -1, -1, x, y);
    }

    public static EntityRef widget(int id) {
        return new EntityRef(Kind.WIDGET, -1, id, -1, -1);
    }

    public static EntityRef parse(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Missing entity reference");
        }
        int colon = text.indexOf(':');
        if (colon < 0) {
            throw new IllegalArgumentException("Malformed entity reference: " + text);
        }
        String kind = text.substring(0, colon);
        String rest = text.substring(colon + 1);
        try {
            switch (kind) {
                case "npc":
                    return npc(Integer.parseInt(rest));
                case "player":
                    return player(Integer.parseInt(rest));
                case "item":
                    return item(Integer.parseInt(rest));
                case "widget":
                    return widget(Integer.parseInt(rest));
                case "tile": {
                    String[] xy = rest.split(",");
                    return tile(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
                }
                case "object":
                case "ground": {
                    int at = rest.indexOf('@');
                    if (at < 0) {
                        throw new IllegalArgumentException("Malformed entity reference: " + text);
                    }
                    int id = Integer.parseInt(rest.substring(0, at));
                    String[] xy = rest.substring(at + 1).split(",");
                    int x = Integer.parseInt(xy[0]);
                    int y = Integer.parseInt(xy[1]);
                    return kind.equals("object") ? object(id, x, y) : ground(id, x, y);
                }
                default:
                    throw new IllegalArgumentException("Unknown entity kind: " + kind);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Malformed entity reference: " + text);
        }
    }

    @Override
    public String toString() {
        switch (kind) {
            case NPC:
                return "npc:" + index;
            case PLAYER:
                return "player:" + index;
            case ITEM:
                return "item:" + index;
            case WIDGET:
                return "widget:" + id;
            case TILE:
                return "tile:" + x + "," + y;
            case OBJECT:
                return "object:" + id + "@" + x + "," + y;
            case GROUND:
            default:
                return "ground:" + id + "@" + x + "," + y;
        }
    }
}
