package org.runejs.client.message.outbound.magic;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to cast a magic spell on a player.
 */
public class CastMagicOnPlayerOutboundMessage extends BaseCastMagicOutboundMessage implements OutboundMessage {
    /**
     * The id of the player to cast the spell on.
     */
    public final int playerId;

    /**
     * Creates a new {@link CastMagicOnPlayerOutboundMessage}.
     * @param spellId The id of the spell to cast.
     * @param playerId The id of the player to cast the spell on.
     */
    public CastMagicOnPlayerOutboundMessage(int spellId, int playerId) {
        super(spellId);
        this.playerId = playerId;
    }
}
