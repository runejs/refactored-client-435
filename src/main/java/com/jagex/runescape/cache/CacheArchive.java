package com.jagex.runescape.cache;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.bzip.BZip;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.node.Class40_Sub6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

public class CacheArchive {

    public static CRC32 crc32 = new CRC32();
    public static CacheArchive gameInterfaceCacheArchive;
    public static CacheArchive gameDefinitionsCacheArchive;
    public static CacheArchive skeletonCacheArchive;
    public static CacheArchive skinDefinitionCacheArchive;
    public static CacheArchive soundEffectCacheArchive;
    public static CacheArchive gameWorldMapCacheArchive;
    public static CacheArchive musicCacheArchive;
    public static CacheArchive modelCacheArchive;
    public static CacheArchive gameImageCacheArchive;
    public static CacheArchive gameTextureCacheArchive;
    public static CacheArchive huffmanCacheArchive;
    public static CacheArchive jingleCacheArchive;
    public static CacheArchive clientScriptCacheArchive;
    public static CacheArchive definitionCache;

    static {
        Player.npcs = new Npc[32768];
    }

    public byte[][] aByteArrayArray212;
    public int anInt216;
    public Class42[] aClass42Array217;
    public boolean aBoolean220;
    public int anInt221;
    public int[] anIntArray224;
    public int[] anIntArray227;
    public boolean aBoolean233;
    public int[][] anIntArrayArray236;
    public int[] anIntArray239;
    public int[][] anIntArrayArray243;
    public byte[][][] inMemoryCacheBuffer;
    public int[] anIntArray252;
    public Class42 aClass42_254;
    public int[] anIntArray261;
    public volatile boolean[] aBooleanArray1796;
    public int anInt1797 = -1;
    public volatile boolean aBoolean1800 = false;
    public CacheIndex metaIndex;
    public int cacheIndexId;
    public int anInt1810;
    public boolean aBoolean1811;
    public CacheIndex dataIndex;

    public CacheArchive(
            CacheIndex dataIndex, CacheIndex metaIndex, int cacheIndexId, boolean arg3, boolean arg4, boolean arg5
    ) {
        aBoolean220 = arg4;
        aBoolean233 = arg3;
        this.dataIndex = dataIndex;
        aBoolean1811 = arg5;
        this.metaIndex = metaIndex;
        this.cacheIndexId = cacheIndexId;
        Main.method37(this, this.cacheIndexId);
    }

    public static CacheArchive loadArchive(int cacheIndexId, boolean arg1, boolean arg2, boolean arg4) {
        CacheIndex dataIndex = null;
        if(Main.dataChannel != null) {
            dataIndex = new CacheIndex(cacheIndexId, Main.dataChannel, Main.indexChannels[cacheIndexId], 1000000);
        }
        return new CacheArchive(dataIndex, Main.metaIndex, cacheIndexId, arg2, arg4, arg1);
    }

    public static byte[] decompress(byte[] cacheData) {
        Buffer buffer = new Buffer(cacheData);
        int type = buffer.getUnsignedByte();
        int length = buffer.getIntBE();

        if(length < 0 || Class51.anInt1195 != 0 && Class51.anInt1195 < length) {
            throw new RuntimeException();
        }

        if(type != 0) {
            int decompressedLength = buffer.getIntBE();
            if(decompressedLength < 0 || Class51.anInt1195 != 0 && decompressedLength > Class51.anInt1195) {
                return new byte[100];
                //throw new RuntimeException();
            }
            if(decompressedLength >= 2000000) {
                return new byte[100];
            }

            byte[] decompressed = new byte[decompressedLength];
            if(type != 1) {
                // GZIP
                try {
                    final DataInputStream datainputstream = new DataInputStream(
                            new GZIPInputStream(new ByteArrayInputStream(cacheData, 9, length)));
                    datainputstream.readFully(decompressed);
                    datainputstream.close();
                } catch(IOException error) {
                    error.printStackTrace();
                }
            } else {
                // BZIP
                BZip.decompressBzip(decompressed, decompressedLength, cacheData, 9);
            }

            return decompressed;
        }

        byte[] decompressed = new byte[length];
        buffer.getBytes(length, 0, decompressed);
        return decompressed;
    }

    public void method196(boolean arg0, int arg2, boolean arg3, byte[] data) {
        if(arg0) {
            if(aBoolean1800) {
                throw new RuntimeException();
            }
            if(metaIndex != null) {
                Class40_Sub6.method1055(data, metaIndex, cacheIndexId);
            }
            decodeArchive(data);
            method199();
        } else {
            data[data.length - 2] = (byte) (anIntArray224[arg2] >> 8);
            data[data.length + -1] = (byte) anIntArray224[arg2];
            if(dataIndex != null) {
                Class40_Sub6.method1055(data, dataIndex, arg2);
                aBooleanArray1796[arg2] = true;
            }
            if(arg3) {
                aByteArrayArray212[arg2] = data;
            }
        }
    }

    public int getPercentLoaded() {
        if(aBoolean1800) {
            return 100;
        }
        if(aByteArrayArray212 != null) {
            return 99;
        }
        int i = MovedStatics.calculateDataLoaded(255, cacheIndexId);
        if(i >= 100) {
            i = 99;
        }
        return i;

    }

    public void method198(boolean arg1, byte[] arg2, int arg3, CacheIndex arg4) {
        if(metaIndex == arg4) {
            if(aBoolean1800) {
                throw new RuntimeException();
            }
            if(arg2 == null) {
                MovedStatics.method327(true, this, 255, cacheIndexId, (byte) 0, anInt1810, (byte) 85);
                return;
            }
            crc32.reset();
            crc32.update(arg2, 0, arg2.length);
            int i = (int) crc32.getValue();
            if(i != anInt1810) {
                MovedStatics.method327(true, this, 255, cacheIndexId, (byte) 0, anInt1810, (byte) -121);
                return;
            }

            decodeArchive(arg2);
            method199();
        } else {
            if(!arg1 && anInt1797 == arg3) {
                aBoolean1800 = true;
            }
            if(arg2 == null || arg2.length <= 2) {
                aBooleanArray1796[arg3] = false;
                if(aBoolean1811 || arg1) {
                    MovedStatics.method327(arg1, this, cacheIndexId, arg3, (byte) 2, anIntArray252[arg3], (byte) -117);
                }
                return;
            }
            crc32.reset();
            crc32.update(arg2, 0, arg2.length - 2);
            int i = (int) crc32.getValue();
            int i_0_ = ((arg2[-2 + arg2.length] & 0xff) << 8) + (0xff & arg2[arg2.length + -1]);
            if(i != anIntArray252[arg3] || i_0_ != anIntArray224[arg3]) {
                aBooleanArray1796[arg3] = false;
                if(aBoolean1811 || arg1) {
                    MovedStatics.method327(arg1, this, cacheIndexId, arg3, (byte) 2, anIntArray252[arg3], (byte) -78);
                }
                return;
            }
            aBooleanArray1796[arg3] = true;
            if(arg1) {
                aByteArrayArray212[arg3] = arg2;
            }
        }
    }

    public void method177(int arg1) {
        if(dataIndex != null && aBooleanArray1796 != null && aBooleanArray1796[arg1]) {
            GameObjectDefinition.method602(this, arg1, dataIndex);
        } else {
            MovedStatics.method327(true, this, cacheIndexId, arg1, (byte) 2, anIntArray252[arg1], (byte) -127);
        }
    }

    public void method174(int arg0) {
        MovedStatics.method399(cacheIndexId, arg0);
    }

    public void method199() {
        aBooleanArray1796 = new boolean[aByteArrayArray212.length];
        for(int i_1_ = 0; i_1_ < aBooleanArray1796.length; i_1_++) {
            aBooleanArray1796[i_1_] = false;
        }
        if(dataIndex == null) {
            aBoolean1800 = true;
        } else {
            anInt1797 = -1;
            for(int i_2_ = 0; aBooleanArray1796.length > i_2_; i_2_++) {
                if(anIntArray261[i_2_] > 0) {
                    PacketBuffer.method513(i_2_, this, dataIndex, (byte) -28);
                    anInt1797 = i_2_;
                }
            }
            if(anInt1797 == -1) {
                aBoolean1800 = true;
            }
        }
    }

    public void method200(int arg0, int arg1) {
        if(arg1 >= 41) {
            anInt1810 = arg0;
            if(metaIndex == null) {
                MovedStatics.method327(true, this, 255, cacheIndexId, (byte) 0, anInt1810, (byte) -118);
            } else {
                GameObjectDefinition.method602(this, cacheIndexId, metaIndex);
            }
        }
    }

    public int method201(int arg0) {
        if(aByteArrayArray212[arg0] != null) {
            return 100;
        }
        if(aBooleanArray1796[arg0]) {
            return 100;
        }
        return MovedStatics.calculateDataLoaded(cacheIndexId, arg0);
    }

    public int method202() {
        int i = 0;
        int i_3_ = 0;
        for(int i_4_ = 0; i_4_ < aByteArrayArray212.length; i_4_++) {
            if(anIntArray261[i_4_] > 0) {
                i += 100;
                i_3_ += method201(i_4_);
            }
        }
        if(i == 0) {
            return 100;
        }
        return i_3_ * 100 / i;
    }

    public byte[] method170(String arg0, String arg1) {
        arg1 = arg1.toLowerCase();
        arg0 = arg0.toLowerCase();
        int i = aClass42_254.method882(RSString.stringHash(arg1));
        int i_0_ = aClass42Array217[i].method882(RSString.stringHash(arg0));

        return getFile(i_0_, i);
    }

    /**
     * Unloads a cache file to free up it's memory
     *
     * @param arg0
     * @param arg1
     */
    public void unloadFile(int arg0, int arg1) {
        int i = 0;
        if(arg0 == 1) {
            for(/**/; i < inMemoryCacheBuffer[arg1].length; i++) {
                inMemoryCacheBuffer[arg1][i] = null;
            }
        }
    }

    public byte[] getFile(int arg0, int arg2) {
        //if(this instanceof CacheIndex)
        //    System.out.printf("Request cache arch: %d index: %d, file: %d\n", this.anInt1807, arg0, arg2);
        return method176(arg2, arg0, null);
    }

    public boolean loaded(int arg0, int arg2) {
        if(arg0 < 0 || arg0 >= inMemoryCacheBuffer.length || inMemoryCacheBuffer[arg0] == null || arg2 < 0 ||
                arg2 >= inMemoryCacheBuffer[arg0].length) {
            return false;
        }
        if(inMemoryCacheBuffer[arg0][arg2] != null) {
            return true;
        }
        if(aByteArrayArray212[arg0] != null) {
            return true;
        }
        method177(arg0);
        return aByteArrayArray212[arg0] != null;
    }

    public int getLength() {
        return inMemoryCacheBuffer.length;
    }

    public byte[] method176(int arg0, int arg1, int[] arg2) {
        if(arg0 < 0 || arg0 >= inMemoryCacheBuffer.length || inMemoryCacheBuffer[arg0] == null || arg1 < 0 ||
                arg1 >= inMemoryCacheBuffer[arg0].length) {
            return null;
        }
        if(inMemoryCacheBuffer[arg0][arg1] == null) {
            boolean bool = method181(arg0, arg2);
            if(!bool) {
                method177(arg0);
                bool = method181(arg0, arg2);
                if(!bool) {
                    return null;
                }
            }
        }
        byte[] is = inMemoryCacheBuffer[arg0][arg1];
        if(aBoolean220) {
            inMemoryCacheBuffer[arg0][arg1] = null;
        }
        return is;
    }

    public void decodeArchive(byte[] data) {
        anInt216 = MovedStatics.method525(data, data.length, (byte) -68);
        Buffer buffer = new Buffer(decompress(data));
        int i = buffer.getUnsignedByte();
        if(i == 5) {
            int i_1_ = 0;
            int i_2_ = buffer.getUnsignedByte();
            anInt221 = buffer.getUnsignedShortBE();
            anIntArray227 = new int[anInt221];
            int i_3_ = -1;
            for(int i_4_ = 0; anInt221 > i_4_; i_4_++) {
                anIntArray227[i_4_] = i_1_ += buffer.getUnsignedShortBE();
                if(anIntArray227[i_4_] > i_3_) {
                    i_3_ = anIntArray227[i_4_];
                }
            }
            anIntArrayArray243 = new int[i_3_ + 1][];
            anIntArray224 = new int[1 + i_3_];
            anIntArray252 = new int[i_3_ + 1];
            inMemoryCacheBuffer = new byte[1 + i_3_][][];
            anIntArray261 = new int[1 + i_3_];
            aByteArrayArray212 = new byte[i_3_ + 1][];
            if(i_2_ != 0) {
                anIntArray239 = new int[i_3_ + 1];
                for(int i_5_ = 0; anInt221 > i_5_; i_5_++) {
                    anIntArray239[anIntArray227[i_5_]] = buffer.getIntBE();
                }
                aClass42_254 = new Class42(anIntArray239);
            }
            for(int i_6_ = 0; i_6_ < anInt221; i_6_++) {
                anIntArray252[anIntArray227[i_6_]] = buffer.getIntBE();
            }
            for(int i_7_ = 0; i_7_ < anInt221; i_7_++) {
                anIntArray224[anIntArray227[i_7_]] = buffer.getIntBE();
            }
            for(int i_8_ = 0; anInt221 > i_8_; i_8_++) {
                anIntArray261[anIntArray227[i_8_]] = buffer.getUnsignedShortBE();
            }
            for(int i_9_ = 0; i_9_ < anInt221; i_9_++) {
                i_1_ = 0;
                int i_10_ = anIntArray227[i_9_];
                int i_11_ = -1;
                int i_12_ = anIntArray261[i_10_];
                anIntArrayArray243[i_10_] = new int[i_12_];
                for(int i_13_ = 0; i_12_ > i_13_; i_13_++) {
                    int i_14_ = anIntArrayArray243[i_10_][i_13_] = i_1_ += buffer.getUnsignedShortBE();
                    if(i_14_ > i_11_) {
                        i_11_ = i_14_;
                    }
                }
                inMemoryCacheBuffer[i_10_] = new byte[i_11_ + 1][];
            }
            if(i_2_ != 0) {
                aClass42Array217 = new Class42[i_3_ + 1];
                anIntArrayArray236 = new int[1 + i_3_][];
                for(int i_15_ = 0; anInt221 > i_15_; i_15_++) {
                    int i_16_ = anIntArray227[i_15_];
                    int i_17_ = anIntArray261[i_16_];
                    anIntArrayArray236[i_16_] = new int[inMemoryCacheBuffer[i_16_].length];
                    for(int i_18_ = 0; i_17_ > i_18_; i_18_++) {
                        anIntArrayArray236[i_16_][anIntArrayArray243[i_16_][i_18_]] = buffer.getIntBE();
                    }
                    aClass42Array217[i_16_] = new Class42(anIntArrayArray236[i_16_]);
                }
            }
        }
    }

    public int method179(int arg1, String arg2) {
        arg2 = arg2.toLowerCase();
        return aClass42Array217[arg1].method882(RSString.stringHash(arg2));
    }

    public boolean method181(int arg0, int[] arg2) {
        if(aByteArrayArray212[arg0] == null) {
            return false;
        }
        int i = anIntArray261[arg0];
        byte[][] is = inMemoryCacheBuffer[arg0];
        int[] is_19_ = anIntArrayArray243[arg0];
        boolean bool = true;
        for(int i_20_ = 0; i_20_ < i; i_20_++) {
            if(is[is_19_[i_20_]] == null) {
                bool = false;
                break;
            }
        }
        if(bool) {
            return true;
        }
        byte[] is_21_;
        if(arg2 == null || arg2[0] == 0 && arg2[1] == 0 && arg2[2] == 0 && arg2[3] == 0) {
            is_21_ = aByteArrayArray212[arg0];
        } else {
            is_21_ = new byte[aByteArrayArray212[arg0].length];
            Class18.method278(aByteArrayArray212[arg0], 0, is_21_, 0, is_21_.length);
            Buffer class40_sub1 = new Buffer(is_21_);
            class40_sub1.method483(arg2, class40_sub1.buffer.length, 5);
        }
        byte[] is_22_;
        is_22_ = decompress(is_21_);
        if(aBoolean233) {
            aByteArrayArray212[arg0] = null;
        }
        if(i > 1) {
            int i_23_ = is_22_.length;
            int i_24_ = is_22_[--i_23_] & 0xff;
            Buffer class40_sub1 = new Buffer(is_22_);
            i_23_ -= 4 * i_24_ * i;
            class40_sub1.currentPosition = i_23_;
            int[] is_25_ = new int[i];
            for(int i_26_ = 0; i_24_ > i_26_; i_26_++) {
                int i_27_ = 0;
                for(int i_28_ = 0; i_28_ < i; i_28_++) {
                    i_27_ += class40_sub1.getIntBE();
                    is_25_[i_28_] += i_27_;
                }
            }
            for(int i_29_ = 0; i_29_ < i; i_29_++) {
                if(is[is_19_[i_29_]] == null) {
                    is[is_19_[i_29_]] = new byte[is_25_[i_29_]];
                }
                is_25_[i_29_] = 0;
            }
            class40_sub1.currentPosition = i_23_;
            int i_30_ = 0;
            for(int i_31_ = 0; i_24_ > i_31_; i_31_++) {
                int i_32_ = 0;
                for(int i_33_ = 0; i_33_ < i; i_33_++) {
                    i_32_ += class40_sub1.getIntBE();
                    Class18.method278(is_22_, i_30_, is[is_19_[i_33_]], is_25_[i_33_], i_32_);
                    is_25_[i_33_] += i_32_;
                    i_30_ += i_32_;
                }
            }
        } else {
            is[is_19_[0]] = is_22_;
        }
        return true;
    }

    public byte[] method182(int arg0, int arg2) {
        if(arg2 < 0 || arg2 >= inMemoryCacheBuffer.length || inMemoryCacheBuffer[arg2] == null || arg0 < 0 ||
                inMemoryCacheBuffer[arg2].length <= arg0) {
            return null;
        }
        if(inMemoryCacheBuffer[arg2][arg0] == null) {
            boolean bool = method181(arg2, null);
            if(!bool) {
                method177(arg2);
                bool = method181(arg2, null);
                if(!bool) {
                    return null;
                }
            }
        }
        byte[] is = inMemoryCacheBuffer[arg2][arg0];
        return is;
    }

    public int getHash(String arg1) {
        arg1 = arg1.toLowerCase();
        return aClass42_254.method882(RSString.stringHash(arg1));
    }

    public boolean method185(byte arg0) {
        boolean bool = true;
        if(arg0 < 11) {
            return true;
        }
        for(int i = 0; i < anIntArray227.length; i++) {
            int i_47_ = anIntArray227[i];
            if(aByteArrayArray212[i_47_] == null) {
                method177(i_47_);
                if(aByteArrayArray212[i_47_] == null) {
                    bool = false;
                }
            }
        }
        return bool;
    }

    public boolean fileExists(int arg1) {
        if(aByteArrayArray212[arg1] != null) {
            return true;
        }
        method177(arg1);
        return aByteArrayArray212[arg1] != null;
    }

    public byte[] method187(int arg0) {
        if(inMemoryCacheBuffer.length == 1) {
            return getFile(arg0, 0);
        }
        if(inMemoryCacheBuffer[arg0].length == 1) {
            return getFile(0, arg0);
        }
        throw new RuntimeException();
    }

    public int fileLength(int fileId) {
        return inMemoryCacheBuffer[fileId].length;
    }

    public void method191(int arg0) {
        for(int i = 0; i < inMemoryCacheBuffer.length; i++) {
            if(inMemoryCacheBuffer[i] != null) {
                for(int i_48_ = 0; i_48_ < inMemoryCacheBuffer[i].length; i_48_++) {
                    inMemoryCacheBuffer[i][i_48_] = null;
                }
            }
        }
        if(arg0 != 1120) {
            fileExists(82);
        }
    }

    public int[] method192(int arg0, boolean arg1) {
        if(!arg1) {
            return null;
        }
        return anIntArrayArray243[arg0];
    }

    public byte[] method193(int arg1) {
        if(inMemoryCacheBuffer.length == 1) {
            return method182(arg1, 0);
        }
        if(inMemoryCacheBuffer[arg1].length == 1) {
            return method182(0, arg1);
        }
        throw new RuntimeException();
    }

    public boolean method194(String arg0, String arg1) {
        arg0 = arg0.toLowerCase();
        arg1 = arg1.toLowerCase();
        int i = aClass42_254.method882(RSString.stringHash(arg0));
        int i_49_ = aClass42Array217[i].method882(RSString.stringHash(arg1));
        return loaded(i, i_49_);
    }

    public void method195(int arg0, String arg1) {
        arg1 = arg1.toLowerCase();
        int i = aClass42_254.method882(RSString.stringHash(arg1));
        if(arg0 == 0 && i >= 0) {
            method174(i);
        }
    }
}
