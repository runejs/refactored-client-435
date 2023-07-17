package org.runejs.client.chat;

/**
 * A list of players in a social list.
 */
public class SocialList {
    /**
     * The players in this list.
     */
    private long[] players;

    /**
     * The amount of players currently in this list.
     */
    private int count = 0;

    /**
     * Creates a new social list with the specified size.
     *
     * @param size The size of the list.
     */
    public SocialList(int size) {
        this.players = new long[size];
    }

    /**
     * Gets the size of this list.
     * @return The size of this list.
     */
    public int getSize() {
        return this.players.length;
    }

    /**
     * Checks if this list is full.
     * @return {@code true} if this list is full, otherwise {@code false}.
     */
    public boolean isFull() {
        return this.count >= this.players.length;
    }

    /**
     * Checks if this list is empty.
     * @return {@code true} if this list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return this.count > 0;
    }

    /**
     * Gets the amount of players currently in this list.
     * @return The amount of players currently in this list.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Checks if this list contains the specified player.
     * @param p The player to check for.
     * @return {@code true} if this list contains the specified player, otherwise {@code false}.
     */
    public boolean containsPlayer(long p) {
        return this.getPlayerIndex(p) != -1;
    }

    /**
     * Removes the specified player from this list.
     * @param p The player to remove.
     * @return The original index of the player that was removed, or {@code -1} if the player was not in this list.
     */
    public int removePlayer(long p) {
        int index = this.getPlayerIndex(p);
        if (index == -1) {
            return -1;
        }

        this.count--;

        for (int i = index; i < this.count; i++) {
            this.players[i] = this.players[i + 1];
        }

        return index;
    }

    /**
     * Gets the index of the specified player.
     * @param p The player to get the index of.
     * @return The index of the specified player, or {@code -1} if the player was not in this list.
     */
    private int getPlayerIndex(long p) {
        for (int i = 0; i < this.count; i++) {
            if (this.players[i] == p) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Gets the player at the specified index.
     * @param index The index of the player to get.
     * @return The player at the specified index.
     */
    public long getPlayer(int index) {
        return this.players[index];
    }

    /**
     * Adds the specified player to this list.
     * @param p The player to add.
     */
    public void addPlayer(long p) {
        this.players[this.count++] = p;
    }

    /**
     * Sets the players in this list.
     * @param p The players to set.
     */
    public void setPlayers(long[] p) {
        this.count = p.length;

        for(int i = 0; i < p.length; i++)
            this.players[i] = p[i];
    }
}
