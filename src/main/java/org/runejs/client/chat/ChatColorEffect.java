package org.runejs.client.chat;

import org.runejs.client.language.English;
import org.runejs.client.language.Native;

import java.util.Arrays;

/**
 * Represents a chat color effect, specified by placing a prefix before the text.
 * 
 * e.g. "yellow:hello!" or "flash1:selling lobsters 80ea"
 */
public enum ChatColorEffect {
    YELLOW(0, English.effectYellow.toLowerCase()),
    RED(1, English.effectRed.toLowerCase()),
    GREEN(2, English.effectGreen.toLowerCase()),
    CYAN(3, English.effectCyan.toLowerCase()),
    PURPLE(4, English.effectPurple.toLowerCase()),
    WHITE(5, English.effectWhite.toLowerCase()),
    FLASH1(6, Native.effectFlash1.toLowerCase()),
    FLASH2(7, English.effectFlash2.toLowerCase()),
    FLASH3(8, English.effectFlash3.toLowerCase()),
    GLOW1(9, English.effectGlow1.toLowerCase()),
    GLOW2(10, English.effectGlow2.toLowerCase()),
    GLOW3(11, English.effectGlow3.toLowerCase());

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
