package org.runejs.client.message.inbound.audio;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the client to the server to play a sound effect
 */
public class PlaySoundInboundMessage implements InboundMessage {
    /**
     * The sound id to play
     */
    public final int soundId;

    /**
     * The volume to play the sound at
     */
    public final int volume;

    /**
     * The delay to play the sound at
     */
    public final int delay;

    /**
     * Creates a new PlaySoundInboundMessage
     */
    public PlaySoundInboundMessage(int soundId, int volume, int delay) {
        this.soundId = soundId;
        this.volume = volume;
        this.delay = delay;
    }
}
