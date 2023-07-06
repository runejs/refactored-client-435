package org.runejs.client.net.codec.runejs435.decoder.region;

import org.runejs.client.message.inbound.region.LoadConstructedRegionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes a {@link LoadConstructedRegionInboundMessage} from a {@link PacketBuffer}.
 */
public class LoadConstructedRegionMessageDecoder implements MessageDecoder<LoadConstructedRegionInboundMessage> {
    @Override
    public LoadConstructedRegionInboundMessage decode(PacketBuffer buffer) {
        int chunkLocalY = buffer.getUnsignedShortBE();
        int chunkLocalX = buffer.getUnsignedShortLE();
        int chunkX = buffer.getUnsignedShortBE();
        int level = buffer.getUnsignedByte();
        int chunkY = buffer.getUnsignedShortBE();

        int[][][] mapTiles = new int[4][13][13];
        buffer.initBitAccess();
        for(int _level = 0; _level < 4; _level++) {
            for(int _x = 0; _x < 13; _x++) {
                for(int _y = 0; _y < 13; _y++) {
                    int isConstructedChunk = buffer.getBits(1);
                    if(isConstructedChunk != 1) {
                        mapTiles[_level][_x][_y] = -1;
                    } else {
                        mapTiles[_level][_x][_y] = buffer.getBits(26);
                    }
                }
            }
        }
        buffer.finishBitAccess();

        int regionCount = (buffer.getSize() - buffer.currentPosition) / 16;
        int[][] xteaKeys = new int[regionCount][4];
        for(int r = 0; regionCount > r; r++) {
            for(int seed = 0; seed < 4; seed++) {
                xteaKeys[r][seed] = buffer.getIntBE();
            }
        }

        return new LoadConstructedRegionInboundMessage(
            chunkX,
            chunkY,
            chunkLocalX,
            chunkLocalY,
            level,
            mapTiles,
            regionCount,
            xteaKeys
        );
    }
}
