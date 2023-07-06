package org.runejs.client.net.codec.runejs435.decoder.camera;

import org.runejs.client.message.inbound.camera.CutsceneCameraMoveToInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class CutsceneCameraMoveToMessageDecoder implements MessageDecoder<CutsceneCameraMoveToInboundMessage> {
    @Override
    public CutsceneCameraMoveToInboundMessage decode(PacketBuffer buffer) {
        int x = buffer.getUnsignedByte();
        int y = buffer.getUnsignedByte();
        int height = buffer.getUnsignedShortBE();
        int speedBase = buffer.getUnsignedByte();
        int speedScale = buffer.getUnsignedByte();

        return new CutsceneCameraMoveToInboundMessage(x, y, height, speedBase, speedScale);
    }
}
