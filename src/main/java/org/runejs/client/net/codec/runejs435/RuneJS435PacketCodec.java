package org.runejs.client.net.codec.runejs435;

import org.runejs.client.message.outbound.interactions.ObjectInteractionOutboundMessage;
import org.runejs.client.net.PacketType;
import org.runejs.client.net.codec.MessagePacketCodec;
import org.runejs.client.net.codec.runejs435.encoder.*;
import org.runejs.client.net.codec.runejs435.decoder.*;

/**
 * A {@link MessagePacketCodec} for the RuneJS customised 435 protocol.
 */
public class RuneJS435PacketCodec extends MessagePacketCodec {
    public RuneJS435PacketCodec() {
        super(PacketType.incomingPacketSizes);

        this.registerEncoders();
        this.registerDecoders();
    }

    private void registerEncoders() {
        register(ObjectInteractionOutboundMessage.class, new ObjectInteractionMessageEncoder());
    }

    private void registerDecoders() {
        register(PacketType.PLAY_SONG.getOpcode(), new PlaySongMessageDecoder());
        register(PacketType.PLAY_QUICK_SONG.getOpcode(), new PlayQuickSongMessageDecoder());
        register(PacketType.PLAY_SOUND.getOpcode(), new PlaySoundMessageDecoder());
    }
}
