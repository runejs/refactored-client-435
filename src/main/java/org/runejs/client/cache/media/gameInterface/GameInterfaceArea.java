package org.runejs.client.cache.media.gameInterface;

/**
 * Represents the different areas of the game interface.
 * 
 * Used to differentiate between clicks.
 */
public enum GameInterfaceArea {
    /**
     * The area that renders in 3D.
     */
    GAME_AREA(0),

    /**
     * The widgets that display within the tab area.
     */
    TAB_AREA(1),

    /**
     * The chat itself, as well as all sorts of dialogues and anything that renders over the chat.
     */
    CHAT_AREA(2),

    /**
     * 'Permanent chat box' widgets. Takes precedence over regular chat box widgets
     */
    PERMANENT_CHAT_BOX_WIDGET(3);

    private final int id;

    GameInterfaceArea(int areaId) {
        this.id = areaId;
    }

    public int getId() {
        return id;
    }    
}
