package com.jagex.runescape.cache.media.Widget;

public enum WidgetType {
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
    public static WidgetType get(int ordinal) {
        return WidgetType.values()[ordinal];
    }
}
