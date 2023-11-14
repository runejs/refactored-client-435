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

    public byte[][] highPriorityData_todo;
    public int crc8;
    public NameHashCollection[] fileNames;
    /**
     * false for gameDefinitions (2), otherwise true
     *
     * clears groupDataBuffers
     */
    public boolean aBoolean3;
    public int size;
    public int[] groupVersions;
    public int[] groupIds;
    /**
     * true for gameDefinitions (2), music (6), otherwise false
     *
     * clears some array values after something
     */
    public boolean aBoolean1;
    public int[][] fileNameHashes;
    public int[] nameHashes;
    public int[][] fileIds;
    public byte[][][] fileData;
    public int[] groupChecksums;
    public NameHashCollection groupNames;
    public int[] groupSizes;
    public volatile boolean[] aBooleanArray1796;
    public int anInt1797 = -1;
    public volatile boolean aBoolean1800 = false;
    public CacheIndex metaIndex;
    public int cacheIndexId;
    public int archiveCrcValue;
    /**
     * false for music (6), true otherwise
     *
     * treats some requests for this archive as high priority?
     */
    public boolean aBoolean2;
    public CacheIndex dataIndex;

    public CacheArchive(CacheIndex dataIndex, CacheIndex metaIndex, int cacheIndexId, boolean aBoolean1, boolean aBoolean3, boolean aBoolean2) {
        this.aBoolean3 = aBoolean3;
        this.aBoolean1 = aBoolean1;
        this.dataIndex = dataIndex;
        this.aBoolean2 = aBoolean2;
        this.metaIndex = metaIndex;
        this.cacheIndexId = cacheIndexId;
        Game.updateServer.requestArchiveChecksum(this, this.cacheIndexId);
    }

    public static CacheArchive loadArchive(int cacheIndexId, boolean aBoolean1, boolean aBoolean2, boolean aBoolean3) {
        CacheIndex dataIndex = null;
        if(Game.dataChannel != null) {
            dataIndex = new CacheIndex(cacheIndexId, Game.dataChannel, Game.indexChannels[cacheIndexId], 1000000);
        }
        return new CacheArchive(dataIndex, Game.metaIndex, cacheIndexId, aBoolean1, aBoolean2, aBoolean3);
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

    private void method602(int groupId, CacheIndex index) {
        byte[] dataFromQueue = null;

        synchronized(OnDemandRequestProcessor.queue) {
            for(OnDemandRequest onDemandRequest = (OnDemandRequest) OnDemandRequestProcessor.queue.peekFirst(); onDemandRequest != null; onDemandRequest = (OnDemandRequest) OnDemandRequestProcessor.queue.pollFirst()) {
                if((long) groupId == onDemandRequest.key && index == onDemandRequest.cacheIndex && onDemandRequest.type == 0) {
                    dataFromQueue = onDemandRequest.data;
                    break;
                }
            }
        }

        if(dataFromQueue == null) {
            byte[] dataFromIndex = index.read(groupId);
            this.method198(true, dataFromIndex, groupId, index);
        } else {
            this.method198(true, dataFromQueue, groupId, index);
        }
    }

    public int getPercentLoaded() {
        if(aBoolean1800)
            return 100;
        if(highPriorityData_todo != null)
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

            decodeIndex(data);
            postDecodeIndex();
        } else {
            if(!highPriority && anInt1797 == key)
                aBoolean1800 = true;
            if(data == null || data.length <= 2) {
                aBooleanArray1796[key] = false;
                if(aBoolean2 || highPriority)
                    Game.updateServer.enqueueFileRequest(highPriority, this, cacheIndexId, key, (byte) 2, groupChecksums[key]);
                return;
            }
            crc32.reset();
            crc32.update(data, 0, data.length - 2);
            int actualChecksum = (int) crc32.getValue();
            int actualVersion = ((data[-2 + data.length] & 0xff) << 8) + (0xff & data[data.length + -1]);
            if(actualChecksum != groupChecksums[key] || actualVersion != groupVersions[key]) {
                aBooleanArray1796[key] = false;
                if(aBoolean2 || highPriority)
                    Game.updateServer.enqueueFileRequest(highPriority, this, cacheIndexId, key, (byte) 2, groupChecksums[key]);
                return;
            }
            aBooleanArray1796[key] = true;
            if(highPriority) {
                highPriorityData_todo[key] = data;
            }
        }
    }

    public void method177(int groupId) {
        if(dataIndex != null && aBooleanArray1796 != null && aBooleanArray1796[groupId])
            method602(groupId, dataIndex);
        else
            Game.updateServer.enqueueFileRequest(true, this, cacheIndexId, groupId, (byte) 2, groupChecksums[groupId]);
    }

    public void method174(int arg0) {
        Game.updateServer.moveRequestToPendingQueue(cacheIndexId, arg0);
    }

    /**
     * what is this doing?
     */
    public void postDecodeIndex() {
        aBooleanArray1796 = new boolean[highPriorityData_todo.length];
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
            decodeIndex(data);
            postDecodeIndex();
        } else {
            data[data.length - 2] = (byte) (groupVersions[arg2] >> 8);
            data[data.length + -1] = (byte) groupVersions[arg2];
            if(dataIndex != null) {
                OnDemandRequest.createByteArrayOnDemandRequest(data, dataIndex, arg2);
                aBooleanArray1796[arg2] = true;
            }
            if(highPriority) {
                highPriorityData_todo[arg2] = data;
            }
        }
    }

    public void requestLatestVersion(int crcValue) {
        archiveCrcValue = crcValue;
        if(metaIndex == null) {
            Game.updateServer.enqueueFileRequest(true, this, 255, cacheIndexId, (byte) 0, archiveCrcValue);
        } else {
            method602(cacheIndexId, metaIndex);
        }
    }

    public int method201(int arg0) {
        if(highPriorityData_todo[arg0] != null)
            return 100;
        if(aBooleanArray1796[arg0])
            return 100;
        return Game.updateServer.getLoadedPercentage(cacheIndexId, arg0);
    }

    public int method202() {
        int i = 0;
        int i_3_ = 0;
        for(int i_4_ = 0; i_4_ < highPriorityData_todo.length; i_4_++) {
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
        int i = groupNames.getIdByName(RSString.stringHash(arg1));
        int i_0_ = fileNames[i].getIdByName(RSString.stringHash(arg0));

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
            for(/**/; i < fileData[arg1].length; i++)
                fileData[arg1][i] = null;
        }
    }

    public byte[] getFile(int groupId, int fileId) {
        //if(this instanceof CacheIndex)
        //    System.out.printf("Request cache arch: %d index: %d, file: %d\n", this.anInt1807, arg0, arg2);
        return method176(groupId, fileId, null);
    }

    public boolean loaded(int arg0, int arg2) {
        if(arg0 < 0 || arg0 >= fileData.length || fileData[arg0] == null || arg2 < 0 || arg2 >= fileData[arg0].length)
            return false;
        if(fileData[arg0][arg2] != null)
            return true;
        if(highPriorityData_todo[arg0] != null)
            return true;
        method177(arg0);
        return highPriorityData_todo[arg0] != null;
    }

    public int getLength() {
        return fileData.length;
    }

    public byte[] method176(int groupId, int fileId, int[] arg2) {
        if(groupId < 0 || groupId >= fileData.length || fileData[groupId] == null || fileId < 0 || fileId >= fileData[groupId].length)
            return null;
        if(fileData[groupId][fileId] == null) {
            boolean bool = method181(groupId, arg2);
            if(!bool) {
                method177(groupId);
                bool = method181(groupId, arg2);
                if(!bool)
                    return null;
            }
        }
        byte[] is = fileData[groupId][fileId];
        if(aBoolean3)
            fileData[groupId][fileId] = null;
        return is;
    }

    public void decodeIndex(byte[] data) {
        crc8 = calculateFullCrc8(data, data.length);
        Buffer buffer = new Buffer(decompress(data));

        /**
         * 5 = original
         * 6 = versioned
         * 7 = smart
         *
         * Only protocol 5 is supported in our revision, others come later
         *
         * (see https://github.com/openrs2/openrs2/blob/master/cache/src/main/kotlin/org/openrs2/cache/Js5Index.kt#L286)
         */
        int protocol = buffer.getUnsignedByte();

        if(protocol == 5) {

            /**
             * The following have names:
             * - maps (5), music (6), images (8), huffman (10), clientscript (12)
             *
             * in later revisions this value contains other settings (digests, lengths, uncompressed checksums)
             */
            int hasNames = buffer.getUnsignedByte();

            size = buffer.getUnsignedShortBE();
            groupIds = new int[size];

            int previousGroupId = 0;
            int highestGroupId = -1;
            for(int index = 0; size > index; index++) {
                groupIds[index] = previousGroupId += buffer.getUnsignedShortBE();
                if(groupIds[index] > highestGroupId)
                    highestGroupId = groupIds[index];
            }

            groupVersions = new int[highestGroupId + 1];
            groupChecksums = new int[highestGroupId + 1];
            groupSizes = new int[highestGroupId + 1];
            fileIds = new int[highestGroupId + 1][];
            highPriorityData_todo = new byte[highestGroupId + 1][];
            fileData = new byte[highestGroupId + 1][][];

            if(hasNames != 0) {
                nameHashes = new int[highestGroupId + 1];

                for(int i = 0; size > i; i++) {
                    int groupId = groupIds[i];
                    nameHashes[groupId] = buffer.getIntBE();
                }

                groupNames = new NameHashCollection(nameHashes);
            }

            for(int i = 0; i < size; i++)
                groupChecksums[groupIds[i]] = buffer.getIntBE();

            for(int i = 0; i < size; i++)
                groupVersions[groupIds[i]] = buffer.getIntBE();

            for(int i = 0; size > i; i++)
                groupSizes[groupIds[i]] = buffer.getUnsignedShortBE();

            for(int i = 0; i < size; i++) {
                int groupId = groupIds[i];
                int groupSize = groupSizes[groupId];
                fileIds[groupId] = new int[groupSize];

                int previousFileId = 0;
                int highestFileId = -1;

                for(int fileId = 0; groupSize > fileId; fileId++) {
                    fileIds[groupId][fileId] = previousFileId += buffer.getUnsignedShortBE();

                    if(fileIds[groupId][fileId] > highestFileId)
                        highestFileId = fileIds[groupId][fileId];
                }

                fileData[groupId] = new byte[highestFileId + 1][];
            }

            if(hasNames != 0) {
                fileNames = new NameHashCollection[highestGroupId + 1];
                fileNameHashes = new int[1 + highestGroupId][];

                for(int i = 0; size > i; i++) {
                    int groupId = groupIds[i];
                    int groupSize = groupSizes[groupId];
                    fileNameHashes[groupId] = new int[fileData[groupId].length];

                    for(int fileId = 0; groupSize > fileId; fileId++)
                        fileNameHashes[groupId][fileIds[groupId][fileId]] = buffer.getIntBE();

                    fileNames[groupId] = new NameHashCollection(fileNameHashes[groupId]);
                }
            }
        }
    }

    public int getFileIdByName(int groupId, String fileName) {
        fileName = fileName.toLowerCase();
        return fileNames[groupId].getIdByName(RSString.stringHash(fileName));
    }

    public boolean method181(int groupId, int[] arg2) {
        if(highPriorityData_todo[groupId] == null)
            return false;
        int i = groupSizes[groupId];
        byte[][] is = fileData[groupId];
        int[] is_19_ = fileIds[groupId];
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
            is_21_ = highPriorityData_todo[groupId];
        else {
            is_21_ = new byte[highPriorityData_todo[groupId].length];
            MovedStatics.copyBytes(highPriorityData_todo[groupId], 0, is_21_, 0, is_21_.length);
            Buffer class40_sub1 = new Buffer(is_21_);
            class40_sub1.method483(arg2, class40_sub1.buffer.length, 5);
        }
        byte[] is_22_;
        is_22_ = decompress(is_21_);
        if(aBoolean1)
            highPriorityData_todo[groupId] = null;
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

    public byte[] method182(int fileId, int groupId) {
        if(groupId < 0 || groupId >= fileData.length || fileData[groupId] == null || fileId < 0 || fileData[groupId].length <= fileId)
            return null;
        if(fileData[groupId][fileId] == null) {
            boolean bool = method181(groupId, null);
            if(!bool) {
                method177(groupId);
                bool = method181(groupId, null);
                if(!bool)
                    return null;
            }
        }
        byte[] is = fileData[groupId][fileId];
        return is;
    }

    public int getGroupIdByName(String name) {
        name = name.toLowerCase();
        return groupNames.getIdByName(RSString.stringHash(name));
    }

    public boolean method185() {
        boolean bool = true;
        for(int i = 0; i < groupIds.length; i++) {
            int i_47_ = groupIds[i];
            if(highPriorityData_todo[i_47_] == null) {
                method177(i_47_);
                if(highPriorityData_todo[i_47_] == null)
                    bool = false;
            }
        }
        return bool;
    }

    public boolean fileExists(int arg1) {
        if(highPriorityData_todo[arg1] != null)
            return true;
        method177(arg1);
        if(highPriorityData_todo[arg1] != null)
            return true;
        return false;
    }

    public byte[] method187(int fileId) {
        if(fileData.length == 1)
            return getFile(0, fileId);
        if(fileData[fileId].length == 1)
            return getFile(fileId, 0);
        throw new RuntimeException();
    }

    public int fileLength(int fileId) {
        return fileData[fileId].length;
    }

    public void clearCache() {
        for(int i = 0; i < fileData.length; i++) {
            if(fileData[i] != null) {
                for(int i_48_ = 0; i_48_ < fileData[i].length; i_48_++)
                    fileData[i][i_48_] = null;
            }
        }
    }

    public int[] method192(int arg0, boolean arg1) {
        if(!arg1)
            return null;
        return fileIds[arg0];
    }

    public byte[] method193(int arg1) {
        if(fileData.length == 1)
            return method182(arg1, 0);
        if(fileData[arg1].length == 1)
            return method182(0, arg1);
        throw new RuntimeException();
    }

    public boolean method194(String arg0, String arg1) {
        arg0 = arg0.toLowerCase();
        arg1 = arg1.toLowerCase();
        int i = groupNames.getIdByName(RSString.stringHash(arg0));
        int i_49_ = fileNames[i].getIdByName(RSString.stringHash(arg1));
        return loaded(i, i_49_);
    }

    public void method195(String fileName) {
        fileName = fileName.toLowerCase();
        int i = groupNames.getIdByName(RSString.stringHash(fileName));
        if(i >= 0)
            method174(i);
    }
}
