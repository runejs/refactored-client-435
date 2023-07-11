package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;

public class Class24 {
    public static int[] fullScreenTextureArray;

    public static IndexedImage[] method337(CacheArchive arg1, int arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg2, arg3, arg1))
            return null;
        return MovedStatics.method315();
    }


}
