package org.runejs.client.message.inbound.region;

import org.runejs.client.message.InboundMessage;

/**
 * An {@link InboundMessage} sent to load a standard region.
 */
public class LoadStandardRegionInboundMessage implements InboundMessage {
    public final int chunkX;

    public final int chunkY;

    public final int chunkLocalX;

    public final int chunkLocalY;

    /**
     * The level of the region.
     */
    public final int level;

    /**
     * The number of regions being loaded.
     */
    public final int regionCount;

    /**
     * The xtea keys of the region.
     */
    public final int[][] xteaKeys;

    /**
     * Creates a new {@link LoadStandardRegionInboundMessage}.
     * @param chunkX
     * @param chunkY
     * @param chunkLocalX
     * @param chunkLocalY
     * @param level         The level of the region.
     * @param regionCount   The number of regions being loaded.
     * @param xteaKeys      The xtea keys of the regions.
     */
    public LoadStandardRegionInboundMessage(int chunkX, int chunkY, int chunkLocalX, int chunkLocalY, int level, int regionCount, int[][] xteaKeys) {
        this.chunkX = chunkX;
        this.chunkY = chunkY;
        this.chunkLocalX = chunkLocalX;
        this.chunkLocalY = chunkLocalY;
        this.level = level;
        this.regionCount = regionCount;
        this.xteaKeys = xteaKeys;
    }
}
