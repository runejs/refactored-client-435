package org.runejs.client.message.inbound.region;

import org.runejs.client.message.InboundMessage;

/**
 * An {@link InboundMessage} sent to load a region constructed from composite chunks.
 */
public class LoadConstructedRegionInboundMessage implements InboundMessage {
    public final int chunkX;

    public final int chunkY;

    public final int chunkLocalX;

    public final int chunkLocalY;

    /**
     * The level of the region.
     */
    public final int level;

    public final int[][][] mapTiles;

    /**
     * The number of regions being loaded.
     */
    public final int regionCount;

    /**
     * The xtea keys of the region.
     */
    public final int[][] xteaKeys;

    /**
     * Creates a new {@link LoadConstructedRegionInboundMessage}.
     *
     * @param chunkX
     * @param chunkY
     * @param chunkLocalX
     * @param chunkLocalY
     * @param level             The level of the region.
     * @param mapTiles
     * @param regionCount       The number of regions being loaded.
     * @param xteaKeys          The xtea keys of the regions.
     */
    public LoadConstructedRegionInboundMessage(int chunkX, int chunkY, int chunkLocalX, int chunkLocalY, int level, int[][][] mapTiles, int regionCount, int[][] xteaKeys) {
        this.chunkX = chunkX;
        this.chunkY = chunkY;
        this.chunkLocalX = chunkLocalX;
        this.chunkLocalY = chunkLocalY;
        this.level = level;
        this.mapTiles = mapTiles;
        this.regionCount = regionCount;
        this.xteaKeys = xteaKeys;
    }
}
