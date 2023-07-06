package org.runejs.client.message.inbound.world;

import org.runejs.client.message.InboundMessage;

public class PlaySoundAtPositionInboundMessage implements InboundMessage {
    public final int x;

    public final int y;

    public final int soundId;

    public final int radius;

    public final int volume;

    public final int delay;

    public PlaySoundAtPositionInboundMessage(int x, int y, int soundId, int radius, int volume, int delay) {
        this.x = x;
        this.y = y;
        this.soundId = soundId;
        this.radius = radius;
        this.volume = volume;
        this.delay = delay;
    }
}
