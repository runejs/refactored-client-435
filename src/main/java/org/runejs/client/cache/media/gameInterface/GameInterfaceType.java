package org.runejs.client.cache.media.gameInterface;

public enum GameInterfaceType {
    LAYER, // 0
    UNKNOWN, // 1
    INVENTORY, // 2
    RECTANGLE, // 3
    TEXT, // 4
    GRAPHIC, // 5
    MODEL, // 6
    TEXT_INVENTORY,  // 7
    IF1_TOOLTIP, // 8
    LINE; // 9
    public static GameInterfaceType get(int ordinal) {
        return GameInterfaceType.values()[ordinal];
    }
}
