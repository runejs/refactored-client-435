package org.runejs.client.cache;

import org.runejs.client.*;
import org.runejs.client.cache.bzip.BZip;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.node.Class40_Sub6;

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

    public byte[][] fileData;
    public int crc8;
    public NameHashCollection[] groupedFileNameHashCollection;
    public boolean clearMemoryBuffer;
    public int groupCount;
    public int[] groupVersions;
    public int[] groupIndexes;
    public boolean aBoolean233;
    public int[][] groupedFileNameHashes;
    public int[] groupNameHashes;
    public int[][] groupedFileIndexes;
    public byte[][][] groupedFileData;
    public int[] groupChecksums;
    public NameHashCollection groupNameHashCollection;
    public int[] groupFileCounts;
    public volatile boolean[] aBooleanArray1796;
    public int anInt1797 = -1;
    public volatile boolean aBoolean1800 = false;
    public CacheIndex metaIndex;
    public int cacheIndexId;
    public int archiveCrcValue;
    public boolean hasVersionNumbers;
    public CacheIndex dataIndex;

    static {
        Player.npcs = new Npc[32768];
    }

    public CacheArchive(CacheIndex dataIndex, CacheIndex metaIndex, int cacheIndexId, boolean arg3, boolean clearMemoryBuffer, boolean hasVersionNumbers) {
        this.clearMemoryBuffer = clearMemoryBuffer;
        aBoolean233 = arg3;
        this.dataIndex = dataIndex;
        this.hasVersionNumbers = hasVersionNumbers;
        this.metaIndex = metaIndex;
        this.cacheIndexId = cacheIndexId;
        Main.method37(this, this.cacheIndexId);
    }

    public static CacheArchive loadArchive(int cacheIndexId, boolean hasVersionNumbers, boolean arg2, boolean arg4) {
        CacheIndex dataIndex = null;
        if(Main.dataChannel != null) {
            dataIndex = new CacheIndex(cacheIndexId, Main.dataChannel, Main.indexChannels[cacheIndexId], 1000000);
        }
        return new CacheArchive(dataIndex, Main.metaIndex, cacheIndexId, arg2, arg4, hasVersionNumbers);
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

    public static int calculateFullCrc8(byte[] data, int size) {
        return MovedStatics.calculateCrc8(0, size, data);
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
            data[data.length - 2] = (byte) (groupVersions[arg2] >> 8);
            data[data.length + -1] = (byte) groupVersions[arg2];
            if(dataIndex != null) {
                Class40_Sub6.method1055(data, dataIndex, arg2);
                aBooleanArray1796[arg2] = true;
            }
            if(arg3) {
                fileData[arg2] = data;
            }
        }
    }

    public int getPercentLoaded() {
        if(aBoolean1800)
            return 100;
        if(fileData != null)
            return 99;
        int i = MovedStatics.calculateDataLoaded(255, cacheIndexId);
        if(i >= 100)
            i = 99;
        return i;

    }

    public void method198(boolean immediate, byte[] fileData, int fileIndex, CacheIndex cacheIndex) {
        if(metaIndex == cacheIndex) {
            if(aBoolean1800)
                throw new RuntimeException();
            if(fileData == null) {
                UpdateServer.requestFile(true, this, 255, cacheIndexId, (byte) 0,
                        archiveCrcValue);
                return;
            }
            crc32.reset();
            crc32.update(fileData, 0, fileData.length);
            int i = (int) crc32.getValue();
            if(i != archiveCrcValue) {
                // @TODO still broken
                // UpdateServer.method327(true, this, 255, cacheIndexId, (byte) 0,
                //         archiveCrcValue);
                // return;
            }

            decodeArchive(fileData);
            method199();
        } else {
            if(!immediate && anInt1797 == fileIndex)
                aBoolean1800 = true;
            if(fileData == null || fileData.length <= 2) {
                aBooleanArray1796[fileIndex] = false;
                if(hasVersionNumbers || immediate)
                    UpdateServer.requestFile(immediate, this, cacheIndexId, fileIndex, (byte) 2, groupChecksums[fileIndex]);
                return;
            }
            crc32.reset();
            crc32.update(fileData, 0, fileData.length - 2);
            int i = (int) crc32.getValue();
            int i_0_ = ((fileData[-2 + fileData.length] & 0xff) << 8) + (0xff & fileData[fileData.length + -1]);
            if(i != groupChecksums[fileIndex] || i_0_ != groupVersions[fileIndex]) {
                aBooleanArray1796[fileIndex] = false;
                if(hasVersionNumbers || immediate)
                    UpdateServer.requestFile(immediate, this, cacheIndexId, fileIndex, (byte) 2, groupChecksums[fileIndex]);
                return;
            }
            aBooleanArray1796[fileIndex] = true;
            if(immediate)
                this.fileData[fileIndex] = fileData;
        }
    }

    public void method177(int arg1) {
        if(dataIndex != null && aBooleanArray1796 != null && aBooleanArray1796[arg1])
            GameObjectDefinition.method602(this, arg1, dataIndex);
        else
            UpdateServer.requestFile(true, this, cacheIndexId, arg1, (byte) 2, groupChecksums[arg1]);
    }

    public void method174(int arg0) {
        MovedStatics.method399(cacheIndexId, arg0);
    }

    public void method199() {
        aBooleanArray1796 = new boolean[fileData.length];
        for(int i_1_ = 0; i_1_ < aBooleanArray1796.length; i_1_++)
            aBooleanArray1796[i_1_] = false;
        if(dataIndex == null)
            aBoolean1800 = true;
        else {
            anInt1797 = -1;
            for(int i_2_ = 0; aBooleanArray1796.length > i_2_; i_2_++) {
                if(groupFileCounts[i_2_] > 0) {
                    PacketBuffer.method513(i_2_, this, dataIndex, (byte) -28);
                    anInt1797 = i_2_;
                }
            }
            if(anInt1797 == -1)
                aBoolean1800 = true;
        }
    }

    public void requestLatestVersion(int crcValue) {
        archiveCrcValue = crcValue;
        if(metaIndex == null)
            UpdateServer.requestFile(true, this, 255, cacheIndexId, (byte) 0, archiveCrcValue);
        else
            GameObjectDefinition.method602(this, cacheIndexId, metaIndex);
    }

    public int method201(int arg0) {
        if(fileData[arg0] != null)
            return 100;
        if(aBooleanArray1796[arg0])
            return 100;
        return MovedStatics.calculateDataLoaded(cacheIndexId, arg0);
    }

    public int method202() {
        int i = 0;
        int i_3_ = 0;
        for(int i_4_ = 0; i_4_ < fileData.length; i_4_++) {
            if(groupFileCounts[i_4_] > 0) {
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
        int i_0_ = groupedFileNameHashCollection[i].method882(RSString.stringHash(arg0));

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
            for(/**/; i < groupedFileData[arg1].length; i++)
                groupedFileData[arg1][i] = null;
        }
    }

    public byte[] getFile(int fileId, int childId) {
        //if(this instanceof CacheIndex)
        //    System.out.printf("Request cache arch: %d index: %d, file: %d\n", this.anInt1807, arg0, arg2);
        return method176(fileId, childId, null);
    }

    public boolean loaded(int arg0, int arg2) {
        if(arg0 < 0 || arg0 >= groupedFileData.length || groupedFileData[arg0] == null || arg2 < 0 || arg2 >= groupedFileData[arg0].length)
            return false;
        if(groupedFileData[arg0][arg2] != null)
            return true;
        if(fileData[arg0] != null)
            return true;
        method177(arg0);
        return fileData[arg0] != null;
    }

    public int getLength() {
        return groupedFileData.length;
    }

    public byte[] method176(int groupIndex, int fileIndex, int[] arg2) {
        if(groupIndex < 0 || groupIndex >= groupedFileData.length || groupedFileData[groupIndex] == null || fileIndex < 0 || fileIndex >= groupedFileData[groupIndex].length)
            return null;
        if(groupedFileData[groupIndex][fileIndex] == null) {
            boolean bool = method181(groupIndex, arg2);
            if(!bool) {
                method177(groupIndex);
                bool = method181(groupIndex, arg2);
                if(!bool)
                    return null;
            }
        }
        byte[] is = groupedFileData[groupIndex][fileIndex];
        if(clearMemoryBuffer)
            groupedFileData[groupIndex][fileIndex] = null;
        return is;
    }

    public void decodeArchive(byte[] data) {
        crc8 = calculateFullCrc8(data, data.length);
        Buffer buffer = new Buffer(decompress(data));
        int format = buffer.getUnsignedByte();
        if(format == 5) {
            int accumulator = 0;
            int settings = buffer.getUnsignedByte();
            groupCount = buffer.getUnsignedShortBE();
            groupIndexes = new int[groupCount];
            int groupSize = -1;
            for(int i = 0; groupCount > i; i++) {
                groupIndexes[i] = accumulator += buffer.getUnsignedShortBE();
                if(groupIndexes[i] > groupSize)
                    groupSize = groupIndexes[i];
            }

            groupedFileIndexes = new int[groupSize + 1][];
            groupVersions = new int[1 + groupSize];
            groupChecksums = new int[groupSize + 1];
            groupedFileData = new byte[1 + groupSize][][];
            groupFileCounts = new int[1 + groupSize];
            fileData = new byte[groupSize + 1][];

            if(settings != 0) {
                groupNameHashes = new int[groupSize + 1];
                for(int i = 0; groupCount > i; i++)
                    groupNameHashes[groupIndexes[i]] = buffer.getIntBE();
                groupNameHashCollection = new NameHashCollection(groupNameHashes);
            }

            for(int i = 0; i < groupCount; i++)
                groupChecksums[groupIndexes[i]] = buffer.getIntBE();

            for(int i = 0; i < groupCount; i++)
                groupVersions[groupIndexes[i]] = buffer.getIntBE();

            for(int i = 0; groupCount > i; i++)
                groupFileCounts[groupIndexes[i]] = buffer.getUnsignedShortBE();

            for(int i = 0; i < groupCount; i++) {
                accumulator = 0;
                int groupIndex = groupIndexes[i];
                int fileSize = -1;
                int fileCount = groupFileCounts[groupIndex];
                groupedFileIndexes[groupIndex] = new int[fileCount];
                for(int j = 0; fileCount > j; j++) {
                    int delta = groupedFileIndexes[groupIndex][j] = accumulator += buffer.getUnsignedShortBE();
                    if(delta > fileSize)
                        fileSize = delta;
                }
                groupedFileData[groupIndex] = new byte[fileSize + 1][];
            }

            if(settings != 0) {
                groupedFileNameHashCollection = new NameHashCollection[groupSize + 1];
                groupedFileNameHashes = new int[1 + groupSize][];
                for(int i = 0; groupCount > i; i++) {
                    int groupIndex = groupIndexes[i];
                    int fileCount = groupFileCounts[groupIndex];
                    groupedFileNameHashes[groupIndex] = new int[groupedFileData[groupIndex].length];
                    for(int j = 0; fileCount > j; j++)
                        groupedFileNameHashes[groupIndex][groupedFileIndexes[groupIndex][j]] = buffer.getIntBE();
                    groupedFileNameHashCollection[groupIndex] = new NameHashCollection(groupedFileNameHashes[groupIndex]);
                }
            }
        }
    }

    public int method179(int groupIndex, String fileName) {
        fileName = fileName.toLowerCase();
        int newHash = RSString.stringHash(fileName);
        return groupedFileNameHashCollection[groupIndex].method882(newHash);
    }

    public boolean method181(int groupIndex, int[] arg2) {
        if(fileData[groupIndex] == null)
            return false;

        int fileCount = groupFileCounts[groupIndex];
        byte[][] groupFileData = this.groupedFileData[groupIndex];
        int[] groupFileIndexes = groupedFileIndexes[groupIndex];
        boolean fullyLoaded = true;

        for(int i = 0; i < fileCount; i++) {
            if(groupFileData[groupFileIndexes[i]] == null) {
                fullyLoaded = false;
                break;
            }
        }

        if(fullyLoaded)
            return true;

        byte[] fileData;

        // xtea check
        if(arg2 == null || arg2[0] == 0 && arg2[1] == 0 && arg2[2] == 0 && arg2[3] == 0)
            fileData = this.fileData[groupIndex];
        else {
            // xtea decode
            fileData = new byte[this.fileData[groupIndex].length];
            Class18.method278(this.fileData[groupIndex], 0, fileData, 0, fileData.length);
            Buffer buffer = new Buffer(fileData);
            buffer.method483(arg2, buffer.buffer.length, 5);
        }

        byte[] decompressedData;
        decompressedData = decompress(fileData);

        if(aBoolean233)
            this.fileData[groupIndex] = null;

        if(fileCount > 1) {
            int decompressedLength = decompressedData.length;
            int i_24_ = decompressedData[--decompressedLength] & 0xff;
            Buffer buffer = new Buffer(decompressedData);
            decompressedLength -= 4 * i_24_ * fileCount;
            buffer.currentPosition = decompressedLength;
            int[] is_25_ = new int[fileCount];

            for(int i = 0; i_24_ > i; i++) {
                int i_27_ = 0;
                for(int j = 0; j < fileCount; j++) {
                    i_27_ += buffer.getIntBE();
                    is_25_[j] += i_27_;
                }
            }

            for(int i = 0; i < fileCount; i++) {
                if(groupFileData[groupFileIndexes[i]] == null)
                    groupFileData[groupFileIndexes[i]] = new byte[is_25_[i]];
                is_25_[i] = 0;
            }

            buffer.currentPosition = decompressedLength;
            int i_30_ = 0;

            for(int i = 0; i_24_ > i; i++) {
                int i_32_ = 0;
                for(int j = 0; j < fileCount; j++) {
                    i_32_ += buffer.getIntBE();
                    Class18.method278(decompressedData, i_30_, groupFileData[groupFileIndexes[j]], is_25_[j], i_32_);
                    is_25_[j] += i_32_;
                    i_30_ += i_32_;
                }
            }
        } else {
            groupFileData[groupFileIndexes[0]] = decompressedData;
        }

        return true;
    }

    public byte[] method182(int fileIndex, int groupIndex) {
        if(groupIndex < 0 || groupIndex >= groupedFileData.length || groupedFileData[groupIndex] == null || fileIndex < 0 || groupedFileData[groupIndex].length <= fileIndex)
            return null;
        if(groupedFileData[groupIndex][fileIndex] == null) {
            boolean bool = method181(groupIndex, null);
            if(!bool) {
                method177(groupIndex);
                bool = method181(groupIndex, null);
                if(!bool)
                    return null;
            }
        }
        byte[] is = groupedFileData[groupIndex][fileIndex];
        return is;
    }

    public int getHash(String arg1) {
        arg1 = arg1.toLowerCase();
        int newHash = RSString.stringHash(arg1);
        return groupNameHashCollection.method882(newHash);
    }

    public boolean method185(byte arg0) {
        boolean bool = true;
        if(arg0 < 11)
            return true;
        for(int i = 0; i < groupIndexes.length; i++) {
            int i_47_ = groupIndexes[i];
            if(fileData[i_47_] == null) {
                method177(i_47_);
                if(fileData[i_47_] == null)
                    bool = false;
            }
        }
        return bool;
    }

    public boolean fileExists(int fileIndex) {
        if(fileData[fileIndex] != null)
            return true;
        method177(fileIndex);
        if(fileData[fileIndex] != null)
            return true;
        return false;
    }

    public byte[] method187(int fileIndex) {
        if(groupedFileData.length == 1)
            return getFile(0, fileIndex);
        if(groupedFileData[fileIndex].length == 1)
            return getFile(fileIndex, 0);
        throw new RuntimeException();
    }

    public int fileLength(int fileId) {
        return groupedFileData[fileId].length;
    }

    public void clearCache() {
        for(int i = 0; i < groupedFileData.length; i++) {
            if(groupedFileData[i] != null) {
                for(int i_48_ = 0; i_48_ < groupedFileData[i].length; i_48_++)
                    groupedFileData[i][i_48_] = null;
            }
        }
    }

    public int[] getGroupedFileIndexes(int groupIndex) {
        return groupedFileIndexes[groupIndex];
    }

    public byte[] method193(int arg1) {
        if(groupedFileData.length == 1)
            return method182(arg1, 0);
        if(groupedFileData[arg1].length == 1)
            return method182(0, arg1);
        throw new RuntimeException();
    }

    public boolean method194(String arg0, String arg1) {
        arg0 = arg0.toLowerCase();
        arg1 = arg1.toLowerCase();
        int i = groupNameHashCollection.method882(RSString.stringHash(arg0));
        int i_49_ = groupedFileNameHashCollection[i].method882(RSString.stringHash(arg1));
        return loaded(i, i_49_);
    }

    public void method195(int arg0, String arg1) {
        arg1 = arg1.toLowerCase();
        int i = groupNameHashCollection.method882(RSString.stringHash(arg1));
        if(arg0 == 0 && i >= 0)
            method174(i);
    }
}
