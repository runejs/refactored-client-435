package org.runejs.client.net.codec.runejs435.decoder.camera;

import org.runejs.client.message.inbound.camera.CutsceneExitInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Exits the cutscene camera.
 *
 * This message has no properties.
 */
public class CutsceneExitMessageDecoder implements MessageDecoder<CutsceneExitInboundMessage> {
    @Override
    public CutsceneExitInboundMessage decode(PacketBuffer buffer) {
        return new CutsceneExitInboundMessage();
    }
}
