package com.jagex.runescape.cache;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;

public class MemoryCache {
    public static volatile int mouseButtonPressed = 0;
    public static int anInt321 = 5063219;
    public static volatile int eventMouseY = -1;
    public static int anInt324 = 0;
    public static MemoryCache aClass9_326 = new MemoryCache(200);
    public static boolean redrawChatbox = false;
    public static CacheIndex gameInterfaceCacheIndex;
    public static CacheIndex gameDefinitionsCacheIndex;
    public static CacheIndex skeletonCacheIndex;
    public static CacheIndex skinDefinitionCacheIndex;
    public static CacheIndex soundEffectCacheIndex;
    public static CacheIndex gameWorldMapCacheIndex;
    public static CacheIndex musicCacheIndex;
    public static CacheIndex modelCacheIndex;
    public static CacheIndex gameImageCacheIndex;
    public static CacheIndex gameTextureCacheIndex;
    public static CacheIndex huffmanCacheIndex;
    public static CacheIndex jingleCacheIndex;
    public static CacheIndex cs2CacheIndex;

    public SubNode subNode = new SubNode();
    public int unknownInt1;
    public int unknownInt2;
    public HashTable hashTable;
    public Class27 class27 = new Class27();

    public MemoryCache(int arg0) {
        unknownInt2 = arg0;
        int i;
        i = 1;
        while(i + i < arg0) {
            i += i;
        }
        unknownInt1 = arg0;

        hashTable = new HashTable(i);
    }

    public static void method233(boolean arg0) {
        Class33.aClass9_778.method235();
        if(!arg0)
            method236(null, null, null);
    }


    public static void method236(CacheIndex arg1, CacheIndex arg2, CacheIndex arg3) {
        Class40_Sub11.aCacheIndex_2162 = arg1;
        VarbitDefinition.aCacheIndex_2364 = arg3;
        AnimationSequence.aCacheIndex_2484 = arg2;
    }

    public void put(long arg1, SubNode arg2) {
        if(unknownInt1 == 0) {
            SubNode subNode = class27.method351();
            subNode.remove(-1);
            subNode.method539();
            if(subNode == this.subNode) {
                subNode = class27.method351();
                subNode.remove(-1);
                subNode.method539();
            }
        } else
            unknownInt1--;
        hashTable.put(arg2, (byte) -115, arg1);
        class27.method352(102, arg2);
    }

    public SubNode get(long arg0) {
        SubNode subNode = (SubNode) hashTable.method331(arg0, 6120);
        if(subNode != null)
            class27.method352(114, subNode);
        return subNode;
    }

    public void removeAll(long arg0) {
        SubNode subNode = (SubNode) hashTable.method331(arg0, 6120);
        if(subNode == null)
            return;
        subNode.remove(-1);
        subNode.method539();
        unknownInt1++;
    }

    public void method235() {
        for(; ; ) {
            SubNode subNode = class27.method351();
            if(subNode == null)
                break;
            subNode.remove(-1);
            subNode.method539();
        }
        unknownInt1 = unknownInt2;
    }
}
