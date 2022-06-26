package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.io.Buffer;

public class TextureStore implements Interface3 {
    public static int anInt1730 = 0;
    public static int songTimeout = 0;
    public static boolean aBoolean1734 = false;
    public static boolean aBoolean1735 = true;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1744;

    public LinkedList aLinkedList_1727 = new LinkedList();
    public Texture[] textureFiles;
    public int textureSize;
    public CacheArchive imageArchive;
    public double aDouble1750 = 1.0;
    public int anInt1752;
    public int anInt1753;

    public TextureStore(CacheArchive textureArchive, CacheArchive imageArchive, int arg2, double arg3, int textureSize) {
        this.textureSize = 128;
        anInt1753 = 0;
        anInt1752 = arg2;
        this.imageArchive = imageArchive;
        aDouble1750 = arg3;
        this.textureSize = textureSize;
        anInt1753 = anInt1752;
        int[] textureGroupBuffer = textureArchive.getGroupedFileIndexes(0);
        textureFiles = new Texture[textureArchive.fileLength(0)];

        for (int j : textureGroupBuffer) {
            Buffer buffer = new Buffer(textureArchive.getFile(0, j));
            textureFiles[j] = new Texture(buffer);
        }
    }


    public void method422() {
        for(int i = 0; textureFiles.length > i; i++) {
            if(textureFiles[i] != null)
                textureFiles[i].resetPixels();
        }
        aLinkedList_1727 = new LinkedList();
        anInt1753 = anInt1752;
    }

    public int[] getTexturePixels(int arg0, int arg1) {
        Texture texture = textureFiles[arg1];
        if(texture != null) {
            if(texture.pixels != null) {
                aLinkedList_1727.method905(0, texture);
                texture.aBoolean2146 = true;
                return texture.pixels;
            }
            boolean bool = texture.method869(aDouble1750, textureSize, imageArchive);
            if(bool) {
                if(anInt1753 == 0) {
                    Texture class40_sub10_3_ = (Texture) aLinkedList_1727.method899();
                    class40_sub10_3_.resetPixels();
                } else
                    anInt1753--;
                aLinkedList_1727.method905(0, texture);
                texture.aBoolean2146 = true;
                return texture.pixels;
            }
        }
        return null;
    }

    public int getFile(int textureId) {
        if(textureFiles[textureId] != null)
            return textureFiles[textureId].rgb;
        return 0;
    }

    public boolean method13(byte arg0, int arg1) {
        if(arg0 > -99)
            return true;
        return textureFiles[arg1].opaque;
    }

    public void method424(double arg1) {
        aDouble1750 = arg1;
        method422();
    }

    public void method425(byte arg0, int arg1) {
        int i = 0;
        if(arg0 == 6) {
            for(/**/; i < textureFiles.length; i++) {
                Texture texture = textureFiles[i];
                if(texture != null && texture.direction != 0 && texture.aBoolean2146) {
                    texture.method868(arg1);
                    texture.aBoolean2146 = false;
                }
            }
        }
    }

    public boolean method15(int arg0, byte arg1) {
        if(arg1 != -90)
            return false;
        return textureSize == 64;
    }
}
