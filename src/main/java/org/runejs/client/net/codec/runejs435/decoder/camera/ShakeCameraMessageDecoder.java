package org.runejs.client.net.codec.runejs435.decoder.camera;

import org.runejs.client.message.inbound.camera.ShakeCameraInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class ShakeCameraMessageDecoder implements MessageDecoder<ShakeCameraInboundMessage> {
    @Override
    public ShakeCameraInboundMessage decode(PacketBuffer buffer) {
        int cameraType = buffer.getUnsignedByte();
        int jitter = buffer.getUnsignedByte();
        int amplitude = buffer.getUnsignedByte();
        int frequency = buffer.getUnsignedByte();

        return new ShakeCameraInboundMessage(cameraType, jitter, amplitude, frequency);
    }
}
