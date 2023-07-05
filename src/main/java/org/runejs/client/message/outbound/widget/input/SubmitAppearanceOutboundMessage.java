package org.runejs.client.message.outbound.widget.input;

import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.OutboundMessage;

/**
 * Submits the player's appearance, e.g. after customising it in an interface
 */
public class SubmitAppearanceOutboundMessage implements OutboundMessage {
    public final PlayerAppearance appearance;

    public SubmitAppearanceOutboundMessage(PlayerAppearance appearance) {
        this.appearance = appearance;
    }
}
