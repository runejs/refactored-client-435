package org.runejs.client.cache;

import org.runejs.client.*;
import org.runejs.client.cache.bzip.BZip;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.OnDemandRequest;

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

    public byte[][] aByteArrayArray212;
    public int crc8;
    public NameHashCollection[] fileNameHashCollection;
    public boolean aBoolean220;
    public int fileCount;
    public int[] versions;
    public int[] fileIds;
    public boolean aBoolean233;
    public int[][] fileIndexNameHashes;
    public int[] nameHashes;
    public int[][] fileSubIndexIds;
    public byte[][][] groupDataBuffers;
    public int[] checksums;
    public NameHashCollection groupNameHashCollection;
    public int[] groupSizes;
    public volatile boolean[] aBooleanArray1796;
    public int anInt1797 = -1;
    public volatile boolean aBoolean1800 = false;
    public CacheIndex metaIndex;
    public int cacheIndexId;
    public int archiveCrcValue;
    public boolean aBoolean1811;
    public CacheIndex dataIndex;

    public CacheArchive(CacheIndex dataIndex, CacheIndex metaIndex, int cacheIndexId, boolean arg3, boolean arg4, boolean arg5) {
        aBoolean220 = arg4;
        aBoolean233 = arg3;
        this.dataIndex = dataIndex;
        aBoolean1811 = arg5;
        this.metaIndex = metaIndex;
        this.cacheIndexId = cacheIndexId;
        Game.updateServer.requestArchiveChecksum(this, this.cacheIndexId);
    }

    public static CacheArchive loadArchive(int cacheIndexId, boolean arg1, boolean arg2, boolean arg4) {
        CacheIndex dataIndex = null;
        if(Game.dataChannel != null) {
            dataIndex = new CacheIndex(cacheIndexId, Game.dataChannel, Game.indexChannels[cacheIndexId], 1000000);
        }
        return new CacheArchive(dataIndex, Game.metaIndex, cacheIndexId, arg2, arg4, arg1);
    }

    public static byte[] decompress(byte[] cacheData) {
        Buffer buffer = new Buffer(cacheData);
        int type = buffer.getUnsignedByte();
        int length = buffer.getIntBE();

        if(length < 0) {
            throw new RuntimeException();
        }

        if(type != 0) {
            int decompressedLength = buffer.getIntBE();
            if(decompressedLength < 0) {
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

    public static int calculateFullCrc8(byte[] data, int size) {
        return MovedStatics.calculateCrc8(0, size, data);
    }

    private static void method602(CacheArchive arg0, int indexId, CacheIndex meta) {
        byte[] is = null;
        synchronized(OnDemandRequestProcessor.aLinkedList_53) {
            for(OnDemandRequest onDemandRequest = (OnDemandRequest) OnDemandRequestProcessor.aLinkedList_53.peekFirst(); onDemandRequest != null; onDemandRequest = (OnDemandRequest) OnDemandRequestProcessor.aLinkedList_53.pollFirst()) {
                if((long) indexId == onDemandRequest.key && meta == onDemandRequest.cacheIndex && onDemandRequest.type == 0) {
                    is = onDemandRequest.data;
                    break;
                }
            }
        }
        if(is == null) {
            byte[] is_6_ = meta.read(indexId);
            arg0.method198(true, is_6_, indexId, meta);
        } else {
            arg0.method198(true, is, indexId, meta);
        }
    }

    public int getPercentLoaded() {
        if(aBoolean1800)
            return 100;
        if(aByteArrayArray212 != null)
            return 99;
        int i = Game.updateServer.getLoadedPercentage(255, cacheIndexId);
        if(i >= 100)
            i = 99;
        return i;

    }

    public void method198(boolean highPriority, byte[] data, int key, CacheIndex cacheIndex) {
        if(metaIndex == cacheIndex) {
            if(aBoolean1800)
                throw new RuntimeException();
            if(data == null) {
                Game.updateServer.enqueueFileRequest(true, this, 255, cacheIndexId, (byte) 0,
                        archiveCrcValue);
                return;
            }
            crc32.reset();
            crc32.update(data, 0, data.length);
            int actualChecksum = (int) crc32.getValue();
            if(actualChecksum != archiveCrcValue) {
                Game.updateServer.enqueueFileRequest(true, this, 255, cacheIndexId, (byte) 0,
                        archiveCrcValue);
                return;
            }

            decodeArchive(data);
            method199();
        } else {
            if(!highPriority && anInt1797 == key)
                aBoolean1800 = true;
            if(data == null || data.length <= 2) {
                aBooleanArray1796[key] = false;
                if(aBoolean1811 || highPriority)
                    Game.updateServer.enqueueFileRequest(highPriority, this, cacheIndexId, key, (byte) 2, checksums[key]);
                return;
            }
            crc32.reset();
            crc32.update(data, 0, data.length - 2);
            int actualChecksum = (int) crc32.getValue();
            int actualVersion = ((data[-2 + data.length] & 0xff) << 8) + (0xff & data[data.length + -1]);
            if(actualChecksum != checksums[key] || actualVersion != versions[key]) {
                aBooleanArray1796[key] = false;
                if(aBoolean1811 || highPriority)
                    Game.updateServer.enqueueFileRequest(highPriority, this, cacheIndexId, key, (byte) 2, checksums[key]);
                return;
            }
            aBooleanArray1796[key] = true;
            if(highPriority)
                aByteArrayArray212[key] = data;
        }
    }

    public void method177(int fileId) {
        if(dataIndex != null && aBooleanArray1796 != null && aBooleanArray1796[fileId])
            method602(this, fileId, dataIndex);
        else
            Game.updateServer.enqueueFileRequest(true, this, cacheIndexId, fileId, (byte) 2, checksums[fileId]);
    }

    public void method174(int arg0) {
        Game.updateServer.moveRequestToPendingQueue(cacheIndexId, arg0);
    }

    public void method199() {
        aBooleanArray1796 = new boolean[aByteArrayArray212.length];
        for(int i_1_ = 0; i_1_ < aBooleanArray1796.length; i_1_++)
            aBooleanArray1796[i_1_] = false;
        if(dataIndex == null)
            aBoolean1800 = true;
        else {
            anInt1797 = -1;
            for(int i_2_ = 0; aBooleanArray1796.length > i_2_; i_2_++) {
                if(groupSizes[i_2_] > 0) {
                    OnDemandRequest.createCacheArchiveOnDemandRequest(i_2_, this, dataIndex);
                    anInt1797 = i_2_;
                }
            }
            if(anInt1797 == -1)
                aBoolean1800 = true;
        }
    }

    public void method196(boolean arg0, int arg2, boolean highPriority, byte[] data) {
        if(arg0) {
            if(aBoolean1800) {
                throw new RuntimeException();
            }
            if(metaIndex != null) {
                OnDemandRequest.createByteArrayOnDemandRequest(data, metaIndex, cacheIndexId);
            }
            decodeArchive(data);
            method199();
        } else {
            data[data.length - 2] = (byte) (versions[arg2] >> 8);
            data[data.length + -1] = (byte) versions[arg2];
            if(dataIndex != null) {
                OnDemandRequest.createByteArrayOnDemandRequest(data, dataIndex, arg2);
                aBooleanArray1796[arg2] = true;
            }
            if(highPriority) {
                aByteArrayArray212[arg2] = data;
            }
        }
    }

    public void requestLatestVersion(int crcValue) {
        archiveCrcValue = crcValue;
        if(metaIndex == null)
            Game.updateServer.enqueueFileRequest(true, this, 255, cacheIndexId, (byte) 0, archiveCrcValue);
        else
            method602(this, cacheIndexId, metaIndex);
    }

    public int method201(int arg0) {
        if(aByteArrayArray212[arg0] != null)
            return 100;
        if(aBooleanArray1796[arg0])
            return 100;
        return Game.updateServer.getLoadedPercentage(cacheIndexId, arg0);
    }

    public int method202() {
        int i = 0;
        int i_3_ = 0;
        for(int i_4_ = 0; i_4_ < aByteArrayArray212.length; i_4_++) {
            if(groupSizes[i_4_] > 0) {
                i += 100;
                i_3_ += method201(i_4_);
            }
        }
        if(i == 0)
            return 100;
        return i_3_ * 100 / i;
    }

    public byte[] method170(String arg0, String arg1) {
        arg1 = arg1.toLowerCase();
        arg0 = arg0.toLowerCase();
        int i = groupNameHashCollection.method882(RSString.stringHash(arg1));
        int i_0_ = fileNameHashCollection[i].method882(RSString.stringHash(arg0));

        return getFile(i, i_0_);
    }

    /**
     * Unloads a cache file to free up it's memory
     * @param arg0
     * @param arg1
     */
    public void unloadFile(int arg0, int arg1) {
        int i = 0;
        if(arg0 == 1) {
            for(/**/; i < groupDataBuffers[arg1].length; i++)
                groupDataBuffers[arg1][i] = null;
        }
    }

    public byte[] getFile(int fileId, int childId) {
        //if(this instanceof CacheIndex)
        //    System.out.printf("Request cache arch: %d index: %d, file: %d\n", this.anInt1807, arg0, arg2);
        return method176(fileId, childId, null);
    }

    public boolean loaded(int arg0, int arg2) {
        if(arg0 < 0 || arg0 >= groupDataBuffers.length || groupDataBuffers[arg0] == null || arg2 < 0 || arg2 >= groupDataBuffers[arg0].length)
            return false;
        if(groupDataBuffers[arg0][arg2] != null)
            return true;
        if(aByteArrayArray212[arg0] != null)
            return true;
        method177(arg0);
        return aByteArrayArray212[arg0] != null;
    }

    public int getLength() {
        return groupDataBuffers.length;
    }

    public byte[] method176(int fileId, int childId, int[] arg2) {
        if(fileId < 0 || fileId >= groupDataBuffers.length || groupDataBuffers[fileId] == null || childId < 0 || childId >= groupDataBuffers[fileId].length)
            return null;
        if(groupDataBuffers[fileId][childId] == null) {
            boolean bool = method181(fileId, arg2);
            if(!bool) {
                method177(fileId);
                bool = method181(fileId, arg2);
                if(!bool)
                    return null;
            }
        }
        byte[] is = groupDataBuffers[fileId][childId];
        if(aBoolean220)
            groupDataBuffers[fileId][childId] = null;
        return is;
    }

    public void decodeArchive(byte[] data) {
        crc8 = calculateFullCrc8(data, data.length);
        Buffer buffer = new Buffer(decompress(data));

        /**
         * 5 = original
         * 6 = versioned
         * 7 = smart
         */
        int protocol = buffer.getUnsignedByte();

        if(protocol == 5) {
            int accumulator = 0;
            int hasNames = buffer.getUnsignedByte();
            fileCount = buffer.getUnsignedShortBE();
            fileIds = new int[fileCount];
            int size = -1;
            for(int index = 0; fileCount > index; index++) {
                fileIds[index] = accumulator += buffer.getUnsignedShortBE();
                if(fileIds[index] > size)
                    size = fileIds[index];
            }

            fileSubIndexIds = new int[size + 1][];
            versions = new int[1 + size];
            checksums = new int[size + 1];
            groupDataBuffers = new byte[1 + size][][];
            groupSizes = new int[1 + size];
            aByteArrayArray212 = new byte[size + 1][];

            if(hasNames != 0) {
                nameHashes = new int[size + 1];

                for(int i = 0; fileCount > i; i++) {
                    int fileId = fileIds[i];
                    nameHashes[fileId] = buffer.getIntBE();
                }

                groupNameHashCollection = new NameHashCollection(nameHashes);
            }

            for(int i = 0; i < fileCount; i++)
                checksums[fileIds[i]] = buffer.getIntBE();

            for(int i = 0; i < fileCount; i++)
                versions[fileIds[i]] = buffer.getIntBE();

            for(int i = 0; fileCount > i; i++)
                groupSizes[fileIds[i]] = buffer.getUnsignedShortBE();

            for(int i = 0; i < fileCount; i++) {
                accumulator = 0;
                int fileId = fileIds[i];
                int i_11_ = -1;
                int groupSize = groupSizes[fileId];
                fileSubIndexIds[fileId] = new int[groupSize];
                for(int j = 0; groupSize > j; j++) {
                    int i_14_ = fileSubIndexIds[fileId][j] = accumulator += buffer.getUnsignedShortBE();
                    if(i_14_ > i_11_)
                        i_11_ = i_14_;
                }
                groupDataBuffers[fileId] = new byte[i_11_ + 1][];
            }

            if(hasNames != 0) {
                fileNameHashCollection = new NameHashCollection[size + 1];
                fileIndexNameHashes = new int[1 + size][];
                for(int i = 0; fileCount > i; i++) {
                    int fileId = fileIds[i];
                    int groupSize = groupSizes[fileId];
                    fileIndexNameHashes[fileId] = new int[groupDataBuffers[fileId].length];
                    for(int g = 0; groupSize > g; g++)
                        fileIndexNameHashes[fileId][fileSubIndexIds[fileId][g]] = buffer.getIntBE();
                    fileNameHashCollection[fileId] = new NameHashCollection(fileIndexNameHashes[fileId]);
                }
            }
        }
    }

    public int method179(int arg1, String arg2) {
        arg2 = arg2.toLowerCase();
        return fileNameHashCollection[arg1].method882(RSString.stringHash(arg2));
    }

    public boolean method181(int arg0, int[] arg2) {
        if(aByteArrayArray212[arg0] == null)
            return false;
        int i = groupSizes[arg0];
        byte[][] is = groupDataBuffers[arg0];
        int[] is_19_ = fileSubIndexIds[arg0];
        boolean bool = true;
        for(int i_20_ = 0; i_20_ < i; i_20_++) {
            if(is[is_19_[i_20_]] == null) {
                bool = false;
                break;
            }
        }
        if(bool)
            return true;
        byte[] is_21_;
        if(arg2 == null || arg2[0] == 0 && arg2[1] == 0 && arg2[2] == 0 && arg2[3] == 0)
            is_21_ = aByteArrayArray212[arg0];
        else {
            is_21_ = new byte[aByteArrayArray212[arg0].length];
            MovedStatics.copyBytes(aByteArrayArray212[arg0], 0, is_21_, 0, is_21_.length);
            Buffer class40_sub1 = new Buffer(is_21_);
            class40_sub1.method483(arg2, class40_sub1.buffer.length, 5);
        }
        byte[] is_22_;
        is_22_ = decompress(is_21_);
        if(aBoolean233)
            aByteArrayArray212[arg0] = null;
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
                if(is[is_19_[i_29_]] == null)
                    is[is_19_[i_29_]] = new byte[is_25_[i_29_]];
                is_25_[i_29_] = 0;
            }
            class40_sub1.currentPosition = i_23_;
            int i_30_ = 0;
            for(int i_31_ = 0; i_24_ > i_31_; i_31_++) {
                int i_32_ = 0;
                for(int i_33_ = 0; i_33_ < i; i_33_++) {
                    i_32_ += class40_sub1.getIntBE();
                    MovedStatics.copyBytes(is_22_, i_30_, is[is_19_[i_33_]], is_25_[i_33_], i_32_);
                    is_25_[i_33_] += i_32_;
                    i_30_ += i_32_;
                }
            }
        } else
            is[is_19_[0]] = is_22_;
        return true;
    }

    public byte[] method182(int arg0, int arg2) {
        if(arg2 < 0 || arg2 >= groupDataBuffers.length || groupDataBuffers[arg2] == null || arg0 < 0 || groupDataBuffers[arg2].length <= arg0)
            return null;
        if(groupDataBuffers[arg2][arg0] == null) {
            boolean bool = method181(arg2, null);
            if(!bool) {
                method177(arg2);
                bool = method181(arg2, null);
                if(!bool)
                    return null;
            }
        }
        byte[] is = groupDataBuffers[arg2][arg0];
        return is;
    }

    public int getHash(String arg1) {
        arg1 = arg1.toLowerCase();
        return groupNameHashCollection.method882(RSString.stringHash(arg1));
    }

    public boolean method185() {
        boolean bool = true;
        for(int i = 0; i < fileIds.length; i++) {
            int i_47_ = fileIds[i];
            if(aByteArrayArray212[i_47_] == null) {
                method177(i_47_);
                if(aByteArrayArray212[i_47_] == null)
                    bool = false;
            }
        }
        return bool;
    }

    public boolean fileExists(int arg1) {
        if(aByteArrayArray212[arg1] != null)
            return true;
        method177(arg1);
        if(aByteArrayArray212[arg1] != null)
            return true;
        return false;
    }

    public byte[] method187(int fileId) {
        if(groupDataBuffers.length == 1)
            return getFile(0, fileId);
        if(groupDataBuffers[fileId].length == 1)
            return getFile(fileId, 0);
        throw new RuntimeException();
    }

    public int fileLength(int fileId) {
        return groupDataBuffers[fileId].length;
    }

    public void clearCache() {
        for(int i = 0; i < groupDataBuffers.length; i++) {
            if(groupDataBuffers[i] != null) {
                for(int i_48_ = 0; i_48_ < groupDataBuffers[i].length; i_48_++)
                    groupDataBuffers[i][i_48_] = null;
            }
        }
    }

    public int[] method192(int arg0, boolean arg1) {
        if(!arg1)
            return null;
        return fileSubIndexIds[arg0];
    }

    public byte[] method193(int arg1) {
        if(groupDataBuffers.length == 1)
            return method182(arg1, 0);
        if(groupDataBuffers[arg1].length == 1)
            return method182(0, arg1);
        throw new RuntimeException();
    }

    public boolean method194(String arg0, String arg1) {
        arg0 = arg0.toLowerCase();
        arg1 = arg1.toLowerCase();
        int i = groupNameHashCollection.method882(RSString.stringHash(arg0));
        int i_49_ = fileNameHashCollection[i].method882(RSString.stringHash(arg1));
        return loaded(i, i_49_);
    }

    public void method195(int arg0, String arg1) {
        arg1 = arg1.toLowerCase();
        int i = groupNameHashCollection.method882(RSString.stringHash(arg1));
        if(arg0 == 0 && i >= 0)
            method174(i);
    }
}
