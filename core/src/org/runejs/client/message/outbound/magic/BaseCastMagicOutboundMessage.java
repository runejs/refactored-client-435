package org.runejs.client.message.outbound.magic;

/**
 * A base class for all "cast magic on X" messages.
 */
public abstract class BaseCastMagicOutboundMessage {
    /**
     * The id of the spell to cast.
     */
    public final int spellId;

    /**
     * Creates a new {@link BaseCastMagicOutboundMessage}.
     * @param spellId The id of the spell to cast.
     */
    public BaseCastMagicOutboundMessage(int spellId) {
        this.spellId = spellId;
    }
}
