package com.jagex.runescape.cache.media.Widget;

public enum  WidgetModelType {
    NULL,
    MODEL,
    NPC_CHATHEAD,
    LOCAL_PLAYER_CHATHEAD,
    ITEM,
    PLAYER;

    public static WidgetModelType get(int ordinal) {
        return WidgetModelType.values()[ordinal];
    }
}