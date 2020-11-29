package com.jagex.runescape.cache.media.gameInterface;

public enum GameInterfaceType {
    LAYER,
    UNKNOWN,
    INVENTORY,
    RECTANGLE,
    TEXT,
    GRAPHIC,
    MODEL,
    TEXT_INVENTORY,
    IF1_TOOLTIP,
    LINE;
    public static GameInterfaceType get(int ordinal) {
        return GameInterfaceType.values()[ordinal];
    }
}
