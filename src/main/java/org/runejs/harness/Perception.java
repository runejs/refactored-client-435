package org.runejs.harness;

import org.runejs.client.Game;
import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.node.Node;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.tile.SceneTile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Reads the client's own model of the world and nothing else. If the server knows something the client has not
 * been told, it is not in here — exactly as for a player.
 */
public final class Perception {
    /**
     * Skill ids in the order the 435 protocol numbers them, which is also the server's {@code Skill} enum order.
     */
    public static final String[] SKILL_NAMES = {
            "attack", "defence", "strength", "hitpoints", "ranged", "prayer", "magic", "cooking", "woodcutting",
            "fletching", "fishing", "firemaking", "crafting", "smithing", "mining", "herblore", "agility", "thieving",
            "slayer", "farming", "runecrafting",
    };

    /** The side tab the server places the inventory on. */
    public static final int INVENTORY_TAB = 3;
    private static final int INVENTORY_SIZE = 28;
    private static final int SCENE_SIZE = 104;
    private static final int CHAT_HISTORY = 15;

    private Perception() {
    }

    public static boolean inGame() {
        return (Game.gameStatusCode == 30 || Game.gameStatusCode == 35) && Player.localPlayer != null;
    }

    public static int absoluteX(int localX) {
        return MovedStatics.baseX + localX;
    }

    public static int absoluteY(int localY) {
        return MovedStatics.baseY + localY;
    }

    /**
     * The client's actor path arrays are named the wrong way round: {@code pathY[0]} is the tile's x coordinate and
     * {@code pathX[0]} its y coordinate, as {@code Actor} itself shows when it derives fine coordinates from them.
     */
    public static int tileX(Actor actor) {
        return actor.pathY[0];
    }

    public static int tileY(Actor actor) {
        return actor.pathX[0];
    }

    public static Map<String, Object> look(int radius) {
        Map<String, Object> look = Json.object();
        look.put("status", Game.gameStatusCode);
        if (!inGame()) {
            return look;
        }

        look.put("self", self());
        look.put("inventory", inventory());
        look.put("skills", skills());
        look.put("entities", entities(radius));
        look.put("groundItems", groundItems(radius));
        look.put("interfaces", interfaces());
        look.put("chat", chat());
        return look;
    }

    public static Map<String, Object> self() {
        Player local = Player.localPlayer;
        Map<String, Object> self = Json.object();
        self.put("position", position(absoluteX(tileX(local)), absoluteY(tileY(local))));
        self.put("level", Player.worldLevel);
        self.put("animation", local.playingAnimation == -1 ? null : local.playingAnimation);
        self.put("name", local.playerName);
        self.put("facing", facing(local.facingActorIndex));
        self.put("headIcon", local.headIcon == -1 ? null : local.headIcon);
        return self;
    }

    /**
     * The entity an actor has been told to face, as the client holds it: an NPC by index, a player by index
     * above 32768, or null when facing nothing.
     */
    public static Map<String, Object> facing(int facingActorIndex) {
        if (facingActorIndex == -1) {
            return null;
        }
        Map<String, Object> facing = Json.object();
        if (facingActorIndex >= 32768) {
            facing.put("type", "player");
            facing.put("index", facingActorIndex - 32768);
        } else {
            facing.put("type", "npc");
            facing.put("index", facingActorIndex);
        }
        return facing;
    }

    public static Map<String, Object> position(int x, int y) {
        Map<String, Object> position = Json.object();
        position.put("x", x);
        position.put("y", y);
        return position;
    }

    /**
     * The inventory is whatever container the server placed on the inventory tab. The client does not know the
     * widget by number until the server tells it.
     */
    public static GameInterface inventoryContainer() {
        int widgetId = Game.tabWidgetIds[INVENTORY_TAB];
        if (widgetId == -1 || GameInterface.components == null || widgetId >= GameInterface.components.length) {
            return null;
        }
        GameInterface[] children = GameInterface.components[widgetId];
        if (children == null) {
            return null;
        }
        for (GameInterface child : children) {
            if (child != null && child.invSlotObjId != null && child.invSlotObjId.length == INVENTORY_SIZE) {
                return child;
            }
        }
        return null;
    }

    public static List<Object> inventory() {
        List<Object> items = Json.array();
        GameInterface container = inventoryContainer();
        if (container == null) {
            return items;
        }
        for (int slot = 0; slot < container.invSlotObjId.length; slot++) {
            int stored = container.invSlotObjId[slot];
            if (stored <= 0) {
                continue;
            }
            int itemId = stored - 1;
            Map<String, Object> item = Json.object();
            item.put("ref", EntityRef.item(slot).toString());
            item.put("slot", slot);
            item.put("id", itemId);
            item.put("name", itemName(itemId));
            item.put("amount", container.invSlotObjCount[slot]);
            items.add(item);
        }
        return items;
    }

    /**
     * A compact {@code itemId * 2^32 + amount} per slot, for cheap before/after comparison. -1 marks an empty slot.
     */
    public static long[] inventorySnapshot() {
        long[] snapshot = new long[INVENTORY_SIZE];
        GameInterface container = inventoryContainer();
        for (int slot = 0; slot < INVENTORY_SIZE; slot++) {
            if (container == null || container.invSlotObjId[slot] <= 0) {
                snapshot[slot] = -1;
            } else {
                snapshot[slot] = ((long) (container.invSlotObjId[slot] - 1) << 32) | (container.invSlotObjCount[slot] & 0xffffffffL);
            }
        }
        return snapshot;
    }

    public static Map<String, Object> skills() {
        Map<String, Object> skills = Json.object();
        for (int i = 0; i < SKILL_NAMES.length; i++) {
            Map<String, Object> skill = Json.object();
            skill.put("level", Player.boostedLevels[i]);
            skill.put("baseLevel", Player.baseLevels[i]);
            skill.put("xp", Player.experience[i]);
            skills.put(SKILL_NAMES[i], skill);
        }
        return skills;
    }

    public static List<Object> entities(int radius) {
        List<Object> entities = Json.array();
        for (int i = 0; i < Player.npcCount; i++) {
            int index = Player.npcIds[i];
            Npc npc = Player.npcs[index];
            if (npc == null) {
                continue;
            }
            entities.add(describeNpc(index, npc));
        }
        for (int i = 0; i < Player.localPlayerCount; i++) {
            int index = Player.trackedPlayerIndices[i];
            Player player = Player.trackedPlayers[index];
            if (player == null || player == Player.localPlayer) {
                continue;
            }
            entities.add(describePlayer(index, player));
        }
        entities.addAll(objects(radius));
        return entities;
    }

    public static Map<String, Object> describeNpc(int index, Npc npc) {
        ActorDefinition definition = npcDefinition(npc);
        Map<String, Object> entity = Json.object();
        entity.put("ref", EntityRef.npc(index).toString());
        entity.put("type", "npc");
        entity.put("index", index);
        entity.put("id", definition == null ? null : definition.id);
        entity.put("name", definition == null ? null : definition.name);
        entity.put("at", position(absoluteX(tileX(npc)), absoluteY(tileY(npc))));
        entity.put("options", definition == null ? Json.array() : nonNull(definition.options));
        entity.put("animation", npc.playingAnimation == -1 ? null : npc.playingAnimation);
        entity.put("chat", npc.chatTimer > 0 ? npc.forcedChatMessage : null);
        entity.put("facing", facing(npc.facingActorIndex));
        entity.put("hitpoints", hitpoints(npc.remainingHitpoints, npc.maximumHitpoints));
        return entity;
    }

    /**
     * An actor's health bar as the client last saw it, or null before any hit has told the client what it is.
     */
    public static Map<String, Object> hitpoints(int remaining, int maximum) {
        if (maximum <= 0) {
            return null;
        }
        Map<String, Object> hitpoints = Json.object();
        hitpoints.put("current", remaining);
        hitpoints.put("max", maximum);
        return hitpoints;
    }

    public static Map<String, Object> describePlayer(int index, Player player) {
        Map<String, Object> entity = Json.object();
        entity.put("ref", EntityRef.player(index).toString());
        entity.put("type", "player");
        entity.put("index", index);
        entity.put("name", player.playerName);
        entity.put("at", position(absoluteX(tileX(player)), absoluteY(tileY(player))));
        entity.put("options", nonNull(Player.playerActions));
        entity.put("hitpoints", hitpoints(player.remainingHitpoints, player.maximumHitpoints));
        return entity;
    }

    public static ActorDefinition npcDefinition(Npc npc) {
        ActorDefinition definition = npc.actorDefinition;
        if (definition != null && definition.childIds != null) {
            definition = definition.getChildDefinition();
        }
        return definition;
    }

    /**
     * Every named scene object within {@code radius} tiles of the player on the current level. Objects that span
     * several tiles are reported once, at their origin tile.
     */
    public static List<Object> objects(int radius) {
        List<Object> objects = Json.array();
        if (Game.currentScene == null || Game.currentScene.tileArray == null) {
            return objects;
        }
        int level = Player.worldLevel;
        int centreX = tileX(Player.localPlayer);
        int centreY = tileY(Player.localPlayer);
        for (int x = Math.max(0, centreX - radius); x <= Math.min(SCENE_SIZE - 1, centreX + radius); x++) {
            for (int y = Math.max(0, centreY - radius); y <= Math.min(SCENE_SIZE - 1, centreY + radius); y++) {
                SceneTile tile = Game.currentScene.tileArray[level][x][y];
                if (tile == null) {
                    continue;
                }
                for (int k = 0; k < tile.entityCount; k++) {
                    InteractiveObject object = tile.interactiveObjects[k];
                    if (object == null || object.tileLeft != x || object.tileTop != y) {
                        continue;
                    }
                    addObject(objects, object.hash, x, y, "interactive");
                }
                if (tile.wall != null) {
                    addObject(objects, tile.wall.hash, x, y, "wall");
                }
                if (tile.wallDecoration != null) {
                    addObject(objects, tile.wallDecoration.hash, x, y, "wallDecoration");
                }
                if (tile.floorDecoration != null) {
                    addObject(objects, tile.floorDecoration.hash, x, y, "floorDecoration");
                }
            }
        }
        return objects;
    }

    public static int objectIdFromHash(int hash) {
        return (hash >> 14) & 0x7fff;
    }

    private static void addObject(List<Object> objects, int hash, int localX, int localY, String placement) {
        int id = objectIdFromHash(hash);
        GameObjectDefinition definition = objectDefinition(id);
        if (definition == null || definition.name == null || "null".equals(definition.name)) {
            return;
        }
        Map<String, Object> entity = Json.object();
        entity.put("ref", EntityRef.object(id, absoluteX(localX), absoluteY(localY)).toString());
        entity.put("type", "object");
        entity.put("id", id);
        entity.put("name", definition.name);
        entity.put("at", position(absoluteX(localX), absoluteY(localY)));
        entity.put("options", nonNull(definition.actions));
        entity.put("placement", placement);
        objects.add(entity);
    }

    public static GameObjectDefinition objectDefinition(int id) {
        GameObjectDefinition definition = GameObjectDefinition.getDefinition(id);
        if (definition != null && definition.childIds != null) {
            definition = definition.getChildDefinition();
        }
        return definition;
    }

    public static List<Object> groundItems(int radius) {
        List<Object> items = Json.array();
        int level = Player.worldLevel;
        int centreX = tileX(Player.localPlayer);
        int centreY = tileY(Player.localPlayer);
        for (int x = Math.max(0, centreX - radius); x <= Math.min(SCENE_SIZE - 1, centreX + radius); x++) {
            for (int y = Math.max(0, centreY - radius); y <= Math.min(SCENE_SIZE - 1, centreY + radius); y++) {
                LinkedList list = MovedStatics.groundItems[level][x][y];
                if (list == null) {
                    continue;
                }
                for (Node node = list.last.next; node != null && node != list.last; node = node.next) {
                    if (!(node instanceof Item)) {
                        continue;
                    }
                    Item item = (Item) node;
                    Map<String, Object> entry = Json.object();
                    entry.put("ref", EntityRef.ground(item.itemId, absoluteX(x), absoluteY(y)).toString());
                    entry.put("type", "ground");
                    entry.put("id", item.itemId);
                    entry.put("name", itemName(item.itemId));
                    entry.put("amount", item.itemCount);
                    entry.put("at", position(absoluteX(x), absoluteY(y)));
                    items.add(entry);
                }
            }
        }
        return items;
    }

    public static Map<String, Object> interfaces() {
        Map<String, Object> interfaces = Json.object();
        interfaces.put("screen", nullIfUnset(GameInterface.gameScreenInterfaceId));
        interfaces.put("tabArea", nullIfUnset(GameInterface.tabAreaInterfaceId));
        interfaces.put("chatbox", nullIfUnset(GameInterface.chatboxInterfaceId));
        interfaces.put("fullscreen", nullIfUnset(GameInterface.fullscreenInterfaceId));
        interfaces.put("dialogue", nullIfUnset(ChatBox.dialogueId));
        interfaces.put("currentTab", Game.currentTabId);
        interfaces.put("tabs", Game.tabWidgetIds);
        return interfaces;
    }

    /**
     * The most recent chatbox lines, oldest first.
     */
    public static List<Object> chat() {
        List<Object> lines = Json.array();
        for (int i = Math.min(CHAT_HISTORY, ChatBox.chatMessages.length) - 1; i >= 0; i--) {
            if (ChatBox.chatMessages[i] == null) {
                continue;
            }
            Map<String, Object> line = Json.object();
            line.put("type", ChatBox.chatTypes[i]);
            line.put("name", ChatBox.chatPlayerNames[i]);
            line.put("text", ChatBox.chatMessages[i]);
            lines.add(line);
        }
        return lines;
    }

    public static String itemName(int itemId) {
        ItemDefinition definition = ItemDefinition.forId(itemId, 10);
        return definition == null ? null : definition.name;
    }

    public static Actor actor(EntityRef ref) {
        if (ref.kind == EntityRef.Kind.NPC) {
            return ref.index >= 0 && ref.index < Player.npcs.length ? Player.npcs[ref.index] : null;
        }
        if (ref.kind == EntityRef.Kind.PLAYER) {
            return ref.index >= 0 && ref.index < Player.trackedPlayers.length ? Player.trackedPlayers[ref.index] : null;
        }
        return null;
    }

    private static Object nullIfUnset(int id) {
        return id == -1 ? null : id;
    }

    private static List<Object> nonNull(String[] options) {
        List<Object> list = Json.array();
        if (options != null) {
            for (String option : options) {
                if (option != null) {
                    list.add(option);
                }
            }
        }
        return list;
    }
}
