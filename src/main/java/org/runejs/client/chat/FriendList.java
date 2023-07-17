package org.runejs.client.chat;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.util.TextUtils;

/**
 * A {@link SocialList} that contains a list of friends.
 */
public class FriendList extends SocialList {
    /**
     * The usernames of the players in this list.
     */
    private String[] playerUsernames;

    /**
     * The worlds of the players in this list.
     */
    private int[] playerWorlds;

    /**
     * The maximum amount of players that can be added to this list.
     * 
     * This is different from {@link #getSize()} because players can be added from
     * the server, even if the list is "full" for the player to add more.
     */
    private int limit;

    /**
     * Creates a new friend list with the specified size.
     *
     * @param size The size of the list.
     */
    public FriendList(int size, int limit) {

        super(size);
        this.limit = limit;

        this.playerUsernames = new String[size];
        this.playerWorlds = new int[size];
    }

    @Override
    public int removePlayer(long p) {
        int index = super.removePlayer(p);

        if (index == -1) {
            return -1;
        }

        for (int i = index; i < this.count; i++) {
            this.playerUsernames[i] = this.playerUsernames[i + 1];
            this.playerWorlds[i] = this.playerWorlds[i + 1];
        }

        return index;
    }

    @Override
    public void addPlayer(long p) {
        super.addPlayer(p);

        this.playerWorlds[this.count - 1] = 0;
        this.playerUsernames[this.count - 1] = TextUtils.formatName(TextUtils.longToName(p));
    }

    @Override
    public boolean isFull() {
        return this.count >= this.limit;
    }

    /**
     * Adds a player to this list.
     * @param p The player to add.
     * @param username The username of the player.
     * @param world The world of the player.
     */
    public void addPlayer(long p, String username, int world) {
        int newIndex = this.count;
        this.players[newIndex] = p;
        this.playerUsernames[newIndex] = username;
        this.playerWorlds[newIndex] = world;
        this.count++;
    }

    /**
     * Gets the username of the player at the specified index.
     * @param index The index of the player.
     * @return The username of the player.
     */
    public String getPlayerUsername(int index) {
        return this.playerUsernames[index];
    }

    /**
     * Gets the world of the player at the specified index.
     * @param index The index of the player.
     * @return The world of the player.
     */
    public int getPlayerWorld(int index) {
        return this.playerWorlds[index];
    }

    /**
     * Checks if this list contains the specified player.
     * @param username The username of the player.
     * @return {@code true} if this list contains the player, otherwise {@code false}.
     */
    public boolean containsPlayerUsername(String username) {
        for (int i = 0; i < this.count; i++) {
            if (username.equalsIgnoreCase(this.playerUsernames[i]))
                return true;
        }

        return false;
    }

    /**
     * Set the world of the player at the specified index.
     * @param index The index of the player.
     * @param world The world of the player.
     */
    public void setPlayerWorld(int index, int world) {
        this.playerWorlds[index] = world;
    }
    
    /**
     * Sorts the list:
     * - putting players in the same world as the player at the top,
     * - then other online players,
     * - then offline players.
     */
    public void sort() {
        boolean bool = false;
        while(!bool) {
            bool = true;
            for(int i = 0; this.count - 1 > i; i++) {
                if(Player.worldId != this.playerWorlds[i] && this.playerWorlds[1 + i] == Player.worldId || this.playerWorlds[i] == 0 && this.playerWorlds[i + 1] != 0) {
                    bool = false;
                    int world = this.playerWorlds[i];
                    this.playerWorlds[i] = this.playerWorlds[i + 1];
                    this.playerWorlds[1 + i] = world;
                    String name = this.playerUsernames[i];
                    this.playerUsernames[i] = this.playerUsernames[1 + i];
                    this.playerUsernames[1 + i] = name;
                    long hash = this.players[i];
                    this.players[i] = this.players[i + 1];
                    this.players[1 + i] = hash;
                    GameInterface.redrawTabArea = true;
                }
            }
        }
    }
}
