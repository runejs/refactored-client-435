package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.language.Native;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.LoadConstructedRegionInboundMessage;

/**
 * Loads a construction map region (i.e composed from chunks)
 */
public class LoadConstructedRegionMessageHandler implements MessageHandler<LoadConstructedRegionInboundMessage> {
    @Override
    public void handle(LoadConstructedRegionInboundMessage message) {
        Landscape.loadGeneratedMap = true;

        int chunkLocalY = message.chunkLocalY;
        int chunkX = message.chunkX;
        int chunkLocalX = message.chunkLocalX;
        int chunkY = message.chunkY;
        int level = message.level;
        int regionCount = message.regionCount;

        Landscape.xteaKeys = message.xteaKeys;
        Landscape.constructMapTiles = message.mapTiles;

        Landscape.terrainDataIds = new int[regionCount];
        Landscape.terrainData = new byte[regionCount][];
        Landscape.objectDataIds = new int[regionCount];
        Landscape.objectData = new byte[regionCount][];
        Landscape.mapCoordinates = new int[regionCount];
        regionCount = 0;
        for(int i_11_ = 0; i_11_ < 4; i_11_++) {
            for(int i_12_ = 0; i_12_ < 13; i_12_++) {
                for(int i_13_ = 0; i_13_ < 13; i_13_++) {
                    int i_14_ = Landscape.constructMapTiles[i_11_][i_12_][i_13_];
                    if(i_14_ != -1) {
                        int i_15_ = i_14_ >> 14 & 0x3ff;
                        int i_16_ = i_14_ >> 3 & 0x7ff;
                        int i_17_ = i_16_ / 8 + (i_15_ / 8 << 8);
                        for(int i_18_ = 0; regionCount > i_18_; i_18_++) {
                            if(Landscape.mapCoordinates[i_18_] == i_17_) {
                                i_17_ = -1;
                                break;
                            }
                        }
                        if(i_17_ != -1) {
                            Landscape.mapCoordinates[regionCount] = i_17_;
                            int i_19_ = i_17_ & 0xff;
                            int i_20_ = (0xffbe & i_17_) >> 8;
                            Landscape.terrainDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getGroupIdByName(Native.MAP_NAME_PREFIX_M +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                            Landscape.objectDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getGroupIdByName(Native.MAP_NAME_PREFIX_L +i_20_+ Native.MAP_NAME_UNDERSCORE +i_19_);
                            regionCount++;
                        }
                    }
                }
            }
        }
        MovedStatics.method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
    }
}
