package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.LoadStandardRegionInboundMessage;

/**
 * Loads a standard map region (i.e from terrain files)
 */
public class LoadStandardRegionMessageHandler implements MessageHandler<LoadStandardRegionInboundMessage> {
    @Override
    public void handle(LoadStandardRegionInboundMessage message) {
        Landscape.loadGeneratedMap = false;

        int chunkLocalY = message.chunkLocalY;
        int chunkX = message.chunkX;
        int chunkLocalX = message.chunkLocalX;
        int chunkY = message.chunkY;
        int level = message.level;
        int regionCount = message.regionCount;
        Landscape.xteaKeys = message.xteaKeys;
        Landscape.mapCoordinates = new int[regionCount];
        Landscape.terrainData = new byte[regionCount][];
        boolean inTutorialIsland_maybe = false;
        Landscape.objectData = new byte[regionCount][];
        if((chunkX / 8 == 48 || chunkX / 8 == 49) && chunkY / 8 == 48) {
            inTutorialIsland_maybe = true;
        }
        Landscape.terrainDataIds = new int[regionCount];
        if(chunkX / 8 == 48 && chunkY / 8 == 148) {
            inTutorialIsland_maybe = true;
        }
        Landscape.objectDataIds = new int[regionCount];
        regionCount = 0;
        for(int x = (-6 + chunkX) / 8; x <= (6 + chunkX) / 8; x++) {
            for(int y = (-6 + chunkY) / 8; (6 + chunkY) / 8 >= y; y++) {
                int coords = y + (x << 8);
                if(!inTutorialIsland_maybe || y != 49 && y != 149 && y != 147 && x != 50 && (x != 49 || y != 47)) {
                    Landscape.mapCoordinates[regionCount] = coords;

                    String mapKey = x + Native.MAP_NAME_UNDERSCORE + y;
                    String mapKeyM = Native.MAP_NAME_PREFIX_M + mapKey;
                    String mapKeyL = Native.MAP_NAME_PREFIX_L + mapKey;

                    Landscape.terrainDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyM);
                    Landscape.objectDataIds[regionCount] = CacheArchive.gameWorldMapCacheArchive.getHash(mapKeyL);
                    regionCount++;
                }
            }
        }

        Actor.method789(chunkLocalX, chunkY, chunkX, chunkLocalY, level);
    }
}
