package org.runejs.client.chat;

import java.util.Arrays;

/**
 * Represents a chat shape effect, specified by placing a prefix before the text.
 * 
 * e.g. "wave:hello!" or "shake:(((( shake banana shake ))))"
 */
public enum ChatShapeEffect {
    /**
     * Represents no effect, does not have a prefix.
     */
    NONE(0, null),
    WAVE(1, "wave:"),
    WAVE2(2, "wave2:"),
    SHAKE(3, "shake:"),
    SCROLL(4, "scroll:"),
    SLIDE(5, "slide:");

    /**
     * The numeric code sent to the server to represent this effect.
     */
    private final int networkCode;

    /**
     * The prefix used to trigger this effect.
     */
    private final String prefix;

    /**
     * Constructs a new {@link ChatShapeEffect}.
     * @param networkCode {@link #networkCode}
     * @param prefix {@link #prefix}
     */
    ChatShapeEffect(int networkCode, String prefix) {
        this.networkCode = networkCode;
        this.prefix = prefix;
    }

    /**
     * Gets the prefix used to trigger this effect.
     * @return {@link #prefix}
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * Gets the numeric code sent to the server to represent this effect.
     * @return {@link #networkCode}
     */
    public int getNetworkCode() {
        return this.networkCode;
    }

    /**
     * Gets the length of the prefix used to trigger this effect.
     * @return {@link #prefix} length
     */
    public int getPrefixLength() {
        return this.prefix.length();
    }

    /**
     * Gets the {@link ChatShapeEffect} from the specified input.
     * 
     * Example: ChatShapeEffect.fromString("shake:hello!") == ChatShapeEffect.SHAKE
     * 
     * @implNote Differs from {@link ChatColorEffect#fromString(String)} in that it needs to check for null prefix
     * 
     * @param input The input to parse
     * @return The {@link ChatShapeEffect} or {@code null} if not found
     */
    public static ChatShapeEffect fromString(String input) {
        return Arrays.stream(ChatShapeEffect.values())
            .filter(effect -> effect.getPrefix() != null)
            .filter(effect -> input.startsWith(effect.getPrefix()))
            .findFirst()
            .orElse(null);
    }
}
