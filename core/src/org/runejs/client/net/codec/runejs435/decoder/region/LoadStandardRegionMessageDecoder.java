package org.runejs.client.net.codec.runejs435.decoder.region;

import org.runejs.client.message.inbound.region.LoadStandardRegionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes a {@link LoadStandardRegionInboundMessage} from a {@link PacketBuffer}.
 */
public class LoadStandardRegionMessageDecoder implements MessageDecoder<LoadStandardRegionInboundMessage> {
    @Override
    public LoadStandardRegionInboundMessage decode(PacketBuffer buffer) {
        int chunkLocalY = buffer.getUnsignedShortBE();
        int chunkX = buffer.getUnsignedShortLE();
        int chunkLocalX = buffer.getUnsignedShortBE();
        int chunkY = buffer.getUnsignedShortLE();
        int level = buffer.getUnsignedByte();
        int regionCount = (buffer.getSize() - buffer.currentPosition) / 16;
        int[][] xteaKeys = new int[regionCount][4];
        for(int r = 0; regionCount > r; r++) {
            for(int seed = 0; seed < 4; seed++) {
                xteaKeys[r][seed] = buffer.getIntBE();
            }
        }

        return new LoadStandardRegionInboundMessage(
            chunkX,
            chunkY,
            chunkLocalX,
            chunkLocalY,
            level,
            regionCount,
            xteaKeys
        );
    }
}
