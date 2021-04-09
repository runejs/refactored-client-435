package com.jagex.runescape.cache.media.gameInterface;

public enum InterfaceModelType {
    NULL, MODEL, NPC_CHATHEAD, LOCAL_PLAYER_CHATHEAD, ITEM, PLAYER;

    public static InterfaceModelType get(int ordinal) {
        return InterfaceModelType.values()[ordinal];
    }
}
