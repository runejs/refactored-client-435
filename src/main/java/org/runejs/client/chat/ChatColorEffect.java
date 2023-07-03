package org.runejs.client.chat;

import java.util.Arrays;

/**
 * Represents a chat color effect, specified by placing a prefix before the text.
 * 
 * e.g. "yellow:hello!" or "flash1:selling lobsters 80ea"
 */
public enum ChatColorEffect {
    YELLOW(0, "yellow:"),
    RED(1, "red:"),
    GREEN(2, "green:"),
    CYAN(3, "cyan:"),
    PURPLE(4, "purple:"),
    WHITE(5, "white:"),
    FLASH1(6, "flash1:"),
    FLASH2(7, "flash2:"),
    FLASH3(8, "flash3:"),
    GLOW1(9, "glow1:"),
    GLOW2(10, "glow2:"),
    GLOW3(11, "glow3:");

    /**
     * The numeric code sent to the server to represent this effect.
     */
    private final int networkCode;

    /**
     * The prefix used to trigger this effect.
     */
    private final String prefix;

    /**
     * Constructs a new {@link ChatColorEffect}.
     * @param networkCode {@link #networkCode}
     * @param prefix {@link #prefix}
     */
    ChatColorEffect(int networkCode, String prefix) {
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
     * Gets the {@link ChatColorEffect} from the specified input.
     * 
     * Example: ChatColorEffect.fromString("yellow:hello!") == ChatColorEffect.YELLOW
     * 
     * @param input The input to parse
     * @return The {@link ChatColorEffect} or {@code null} if not found
     */
    public static ChatColorEffect fromString(String input) {
        return Arrays.stream(ChatColorEffect.values())
            .filter(effect -> input.startsWith(effect.getPrefix()))
            .findFirst()
            .orElse(null);
    }
}
