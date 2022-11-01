package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.io.Buffer;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.util.CollisionMap;

public class Class24 {
    public static int[] fullScreenTextureArray;
    public static int[] walkingQueueX = new int[4000];

    public static IndexedImage[] method337(CacheArchive arg1, int arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg2, arg3, arg1))
            return null;
        return MovedStatics.method315();
    }

    public static int getRotatedTileX(int rotation, boolean arg1, int x, int y) {
        rotation &= 0x3;
        if(arg1)
            return 68;
        if(rotation == 0)
            return x;
        if(rotation == 1)
            return y;
        if(rotation == 2)
            return -x + 7;
        return 7 + -y;
    }


    public static void constructMapRegionObjects(int drawX, int drawY, int drawingPlane, int orientation, int x, int y, int plane, Scene scene, byte[] objectData, CollisionMap[] collisionMaps) {
        Buffer objectBuffer = new Buffer(objectData);
        int i = -1;
        for(; ; ) {
            int idOffset = objectBuffer.getSmart();
            if(idOffset == 0)
                break;
            int objectPositionInfo = 0;
            i += idOffset;
            for(; ; ) {
                int objectInfoOffset = objectBuffer.getSmart();
                if(objectInfoOffset == 0)
                    break;
                objectPositionInfo += -1 + objectInfoOffset;
                int objectPlane = objectPositionInfo >> 12;
                int objectX = 0x3f & objectPositionInfo >> 6;
                int objectMetadata = objectBuffer.getUnsignedByte();
                int objectType = objectMetadata >> 2;
                int objectY = objectPositionInfo & 0x3f;
                int originalOrientation = objectMetadata & 0x3;
                if(objectPlane == drawingPlane && drawX <= objectX && objectX < 8 + drawX && drawY <= objectY && drawY + 8 > objectY) {
                    GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                    int tileX = getRotatedObjectX(objectX & 0x7, 0x7 & objectY, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, orientation, originalOrientation) + x;
                    int tileY = getRotatedObjectY(objectX & 0x7, objectY & 0x7, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, orientation, originalOrientation) + y;
                    if(tileX > 0 && tileY > 0 && tileX < 103 && tileY < 103) {
                        CollisionMap collisionMap = null;
                        int collisionMapPlane = plane;
                        if((OverlayDefinition.tile_flags[1][tileX][tileY] & 0x2) == 2) // bridge tile, go down 1 level
                            collisionMapPlane--;
                        if(collisionMapPlane >= 0)
                            collisionMap = collisionMaps[collisionMapPlane];
                        Projectile.addObject(i, tileX, tileY, plane, originalOrientation + orientation & 0x3, objectType, scene, collisionMap);
                    }
                }
            }
        }
    }

    public static int getRotatedObjectX(int x, int y, int sizeX, int sizeY, int orientation, int originalOrientation) {
        orientation &= 0x3;
        if ((originalOrientation & 0x1) == 1) {
            int i = sizeX;
            sizeX = sizeY;
            sizeY = i;
        }
        if (orientation == 0)
            return x;
        if (orientation == 1)
            return y;
        if (orientation == 2)
            return 7 - (x + sizeX) + 1;
        return 7 + -y + 1 + -sizeY;
    }

    public static int getRotatedObjectY(int x, int y, int sizeX, int sizeY, int orientation, int originalOrientation) {
        orientation &= 0x3;
        if((originalOrientation & 0x1) == 1) {
            int i = sizeX;
            sizeX = sizeY;
            sizeY = i;
        }
        if(orientation == 0)
            return y;
        if(orientation == 1)
            return 1 + -sizeX + 7 - x;
        if(orientation == 2)
            return -sizeY + 1 + -y + 7;
        return x;
    }
}
