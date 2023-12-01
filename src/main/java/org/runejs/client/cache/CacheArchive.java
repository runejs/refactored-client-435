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

    public byte[][] groupContentCache;
    public int crc8;
    public NameHashCollection[] fileNames;
    /**
     * false for gameDefinitions (2), otherwise true
     */
    public boolean clearEncryptableContent;
    public int size;
    public int[] groupVersions;
    public int[] groupIds;
    /**
     * true for gameDefinitions (2), music (6), otherwise false
     */
    public boolean clearGroupContentCache;
    public int[][] fileNameHashes;
    public int[] nameHashes;
    public int[][] fileIds;
    public byte[][][] fileContentCache;
    public int[] groupChecksums;
    public NameHashCollection groupNames;
    public int[] groupSizes;
    public volatile boolean[] hasValidContents;
    public int lastReceivedGroupRequest = -1;
    public volatile boolean finishedReceiving = false;
    public CacheIndex idx255;
    public int cacheIndexId;
    public int archiveCrcValue;
    /**
     * false for music (6), true otherwise
     *
     * treats some requests for this archive as high priority
     */
    public boolean forceHighPriority;
    public CacheIndex dataIndex;

    public CacheArchive(int cacheIndexId, CacheIndex idx255, CacheIndex dataIndex, boolean clearGroupContentCache, boolean clearEncryptableContent, boolean forceHighPriority) {
        this.clearEncryptableContent = clearEncryptableContent;
        this.clearGroupContentCache = clearGroupContentCache;
        this.dataIndex = dataIndex;
        this.forceHighPriority = forceHighPriority;
        this.idx255 = idx255;
        this.cacheIndexId = cacheIndexId;
        Game.updateServerConnectionManager.updateServer.requestArchiveChecksum(this, this.cacheIndexId);
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

    private void prioritiseDecodeGroup(CacheIndex index, int groupId) {
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
            // `index.read` is a bit of a misleading name, this actually
            // uses the index to read the file data from the .dat2 file
            byte[] dataFromIndex = index.read(groupId);
            this.attemptDecodeData(true, dataFromIndex, groupId, index);
        } else {
            this.attemptDecodeData(true, dataFromQueue, groupId, index);
        }
    }

    public int getIndexLoadedPercentage() {
        if(finishedReceiving) {
            return 100;
        }

        if(groupContentCache != null) {
            return 99;
        }

        return Math.min(
                99,
                Game.updateServerConnectionManager.updateServer.getLoadedPercentage(255, cacheIndexId)
        );
    }

    public void attemptDecodeData(boolean highPriority, byte[] data, int key, CacheIndex cacheIndex) {
        // we are trying to decode the current index for this archive
        if (cacheIndex == idx255) {
            if(finishedReceiving) {
                throw new RuntimeException();
            }

            if(data == null) {
                Game.updateServerConnectionManager.updateServer.enqueueFileRequest(this, 255, cacheIndexId, (byte) 0, archiveCrcValue, true
                );
                return;
            }

            crc32.reset();
            crc32.update(data, 0, data.length);

            int actualChecksum = (int) crc32.getValue();
            if(actualChecksum != archiveCrcValue) {
                Game.updateServerConnectionManager.updateServer.enqueueFileRequest(this, 255, cacheIndexId, (byte) 0, archiveCrcValue, true
                );
                return;
            }

            decodeIndex(data);
            postDecodeIndex();

            return;
        }

        if (!highPriority && lastReceivedGroupRequest == key) {
            finishedReceiving = true;
        }

        if (data == null || data.length <= 2) {
            hasValidContents[key] = false;
            if (forceHighPriority || highPriority)
                Game.updateServerConnectionManager.updateServer.enqueueFileRequest(this, cacheIndexId, key, (byte) 2, groupChecksums[key], highPriority);
            return;
        }

        crc32.reset();
        crc32.update(data, 0, data.length - 2);
        int actualChecksum = (int) crc32.getValue();
        int actualVersion = ((data[data.length - 2] & 0xff) << 8) + (0xff & data[data.length - 1]);
        if (actualChecksum != groupChecksums[key] || actualVersion != groupVersions[key]) {
            hasValidContents[key] = false;
            if (forceHighPriority || highPriority)
                Game.updateServerConnectionManager.updateServer.enqueueFileRequest(this, cacheIndexId, key, (byte) 2, groupChecksums[key], highPriority);
            return;
        }

        hasValidContents[key] = true;

        if (highPriority) {
            groupContentCache[key] = data;
        }
    }

    public void requestGroup(int groupId) {
        if(dataIndex != null && hasValidContents != null && hasValidContents[groupId]) {
            prioritiseDecodeGroup(dataIndex, groupId);
        } else {
            Game.updateServerConnectionManager.updateServer.enqueueFileRequest(this, cacheIndexId, groupId, (byte) 2, groupChecksums[groupId], true);
        }
    }

    /**
     * what is this doing?
     */
    public void postDecodeIndex() {
        hasValidContents = new boolean[groupContentCache.length];

        for(int i = 0; i < hasValidContents.length; i++) {
            hasValidContents[i] = false;
        }

        if(dataIndex == null) {
            finishedReceiving = true;
        } else {
            lastReceivedGroupRequest = -1;

            for(int i = 0; hasValidContents.length > i; i++) {
                if(groupSizes[i] > 0) {
                    OnDemandRequest.createCacheArchiveOnDemandRequest(i, this, dataIndex);
                    lastReceivedGroupRequest = i;
                }
            }

            if(lastReceivedGroupRequest == -1) {
                finishedReceiving = true;
            }
        }
    }

    public void receiveContent(boolean isIndex, int groupId, boolean highPriority, byte[] data) {
        if(isIndex) {
            if(finishedReceiving) {
                throw new RuntimeException();
            }

            if(idx255 != null) {
                OnDemandRequest.createByteArrayOnDemandRequest(data, idx255, cacheIndexId);
            }

            decodeIndex(data);
            postDecodeIndex();
        } else {
            data[data.length - 2] = (byte) (groupVersions[groupId] >> 8);
            data[data.length - 1] = (byte) groupVersions[groupId];

            if(dataIndex != null) {
                OnDemandRequest.createByteArrayOnDemandRequest(data, dataIndex, groupId);
                hasValidContents[groupId] = true;
            }

            if(highPriority) {
                groupContentCache[groupId] = data;
            }
        }
    }

    public void requestLatestVersion(int crcValue) {
        archiveCrcValue = crcValue;

        /**
         * some exception occured while loading cache files...
         *
         * this shouldn't really occur, only if an IOException happened in Signlink
         */
        if(idx255 == null) {
            Game.updateServerConnectionManager.updateServer.enqueueFileRequest(this, 255, cacheIndexId, (byte) 0, archiveCrcValue, true);

            return;
        }

        prioritiseDecodeGroup(idx255, cacheIndexId);
    }

    public int getGroupLoadedPercentage(int groupId) {
        if(groupContentCache[groupId] != null)
            return 100;
        if(hasValidContents[groupId])
            return 100;
        return Game.updateServerConnectionManager.updateServer.getLoadedPercentage(cacheIndexId, groupId);
    }

    public int getGroupsLoadedPercentage() {
        int totalAvailablePercentage = 0;
        int totalPercentage = 0;

        for(int i = 0; i < groupContentCache.length; i++) {
            if(groupSizes[i] > 0) {
                totalAvailablePercentage += 100;
                totalPercentage += getGroupLoadedPercentage(i);
            }
        }

        if(totalAvailablePercentage == 0) {
            return 100;
        }

        return totalPercentage * 100 / totalAvailablePercentage;
    }

    /**
     * Unloads a cache group to free up its memory
     *
     * @param groupId
     */
    public void unloadGroup(int groupId) {
        for(int i = 0; i < fileContentCache[groupId].length; i++)
            fileContentCache[groupId][i] = null;
    }

    public byte[] getFile(int groupId, int fileId) {
        //if(this instanceof CacheIndex)
        //    System.out.printf("Request cache arch: %d index: %d, file: %d\n", this.anInt1807, arg0, arg2);
        return getEncryptableFileContents(groupId, fileId, null);
    }

    public byte[] getFile(int fileId) {
        if(fileContentCache.length == 1)
            return getFile(0, fileId);
        if(fileContentCache[fileId].length == 1)
            return getFile(fileId, 0);
        throw new RuntimeException();
    }

    public byte[] getFileByName(String groupName, String fileName) {
        groupName = groupName.toLowerCase();
        fileName = fileName.toLowerCase();
        int groupId = groupNames.getIdByName(RSString.stringHash(groupName));
        int fileId = fileNames[groupId].getIdByName(RSString.stringHash(fileName));

        return getFile(groupId, fileId);
    }

    public boolean loaded(int groupId, int fileId) {
        if(groupId < 0 || groupId >= fileContentCache.length || fileContentCache[groupId] == null || fileId < 0 || fileId >= fileContentCache[groupId].length)
            return false;
        if(fileContentCache[groupId][fileId] != null)
            return true;
        if(groupContentCache[groupId] != null)
            return true;
        requestGroup(groupId);
        return groupContentCache[groupId] != null;
    }

    public boolean loaded(String groupName, String fileName) {
        groupName = groupName.toLowerCase();
        fileName = fileName.toLowerCase();
        int groupId = groupNames.getIdByName(RSString.stringHash(groupName));
        int fileId = fileNames[groupId].getIdByName(RSString.stringHash(fileName));
        return loaded(groupId, fileId);
    }

    public int getLength() {
        return fileContentCache.length;
    }

    public void decodeIndex(byte[] data) {
        crc8 = MovedStatics.calculateCrc8(0, data.length, data);
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
            fileContentCache = new byte[highestGroupId + 1][][];

            groupContentCache = new byte[highestGroupId + 1][];

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

                fileContentCache[groupId] = new byte[highestFileId + 1][];
            }

            if(hasNames != 0) {
                fileNames = new NameHashCollection[highestGroupId + 1];
                fileNameHashes = new int[1 + highestGroupId][];

                for(int i = 0; size > i; i++) {
                    int groupId = groupIds[i];
                    int groupSize = groupSizes[groupId];
                    fileNameHashes[groupId] = new int[fileContentCache[groupId].length];

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

    public boolean decodeGroup(int groupId, int[] xteaKeys) {
        if(groupContentCache[groupId] == null)
            return false;

        int groupSize = groupSizes[groupId];
        byte[][] groupFileData = fileContentCache[groupId];
        int[] groupFileIds = fileIds[groupId];

        boolean allFilesPresent = true;

        for(int i = 0; i < groupSize; i++) {
            if(groupFileData[groupFileIds[i]] == null) {
                allFilesPresent = false;
                break;
            }
        }

        if(allFilesPresent)
            return true;

        byte[] compressedData;
        if(xteaKeys == null || xteaKeys[0] == 0 && xteaKeys[1] == 0 && xteaKeys[2] == 0 && xteaKeys[3] == 0)
            compressedData = groupContentCache[groupId];
        else {
            compressedData = new byte[groupContentCache[groupId].length];
            MovedStatics.copyBytes(groupContentCache[groupId], 0, compressedData, 0, compressedData.length);
            Buffer buffer = new Buffer(compressedData);
            buffer.decryptXTEA(xteaKeys, 5, buffer.buffer.length);
        }

        byte[] decompressedData = decompress(compressedData);

        if(clearGroupContentCache)
            groupContentCache[groupId] = null;

        if(groupSize > 1) {
            int dataLength = decompressedData.length;
            int stripeCount = decompressedData[--dataLength] & 0xff;
            Buffer buffer = new Buffer(decompressedData);
            dataLength -= 4 * stripeCount * groupSize;
            buffer.currentPosition = dataLength;

            int[] fileSizes = new int[groupSize];
            for(int stripe = 0; stripeCount > stripe; stripe++) {
                int currentLength = 0;
                for(int f = 0; f < groupSize; f++) {
                    int delta = buffer.getIntBE();

                    currentLength += delta;
                    fileSizes[f] += currentLength;
                }
            }

            for(int f = 0; f < groupSize; f++) {
                if(groupFileData[groupFileIds[f]] == null)
                    groupFileData[groupFileIds[f]] = new byte[fileSizes[f]];

                fileSizes[f] = 0;
            }

            buffer.currentPosition = dataLength;
            int decompressedDataPointer = 0;
            for(int stripe = 0; stripeCount > stripe; stripe++) {
                int size = 0;
                for(int f = 0; f < groupSize; f++) {
                    int stripeLength = fileSizes[f];

                    int delta = buffer.getIntBE();
                    size += delta;

                    MovedStatics.copyBytes(decompressedData, decompressedDataPointer, groupFileData[groupFileIds[f]], stripeLength, size);
                    fileSizes[f] += size;
                    decompressedDataPointer += size;
                }
            }
        } else {
            groupFileData[groupFileIds[0]] = decompressedData;
        }

        return true;
    }

    public byte[] getEncryptableFileContents(int groupId, int fileId, int[] xteaKeys) {
        if(groupId < 0 || groupId >= fileContentCache.length || fileContentCache[groupId] == null || fileId < 0 || fileId >= fileContentCache[groupId].length) {
            return null;
        }

        if(fileContentCache[groupId][fileId] == null) {
            boolean loaded = decodeGroup(groupId, xteaKeys);
            if(!loaded) {
                requestGroup(groupId);
                loaded = decodeGroup(groupId, xteaKeys);
                if(!loaded)
                    return null;
            }
        }

        byte[] data = fileContentCache[groupId][fileId];

        if(clearEncryptableContent) {
            fileContentCache[groupId][fileId] = null;
        }

        return data;
    }

    /**
     * Gets the contents for a single file.
     *
     * If the file contents are not immediately available, this method
     * will attempt to decode the file from the group cache.
     *
     * @param groupId
     * @param fileId
     * @return
     */
    public byte[] getFileContents(int groupId, int fileId) {
        if(groupId < 0 || groupId >= fileContentCache.length || fileContentCache[groupId] == null || fileId < 0 || fileId >= fileContentCache[groupId].length)
            return null;

        if(fileContentCache[groupId][fileId] == null) {
            boolean bool = decodeGroup(groupId, null);
            if(!bool) {
                requestGroup(groupId);
                bool = decodeGroup(groupId, null);
                if(!bool)
                    return null;
            }
        }

        return fileContentCache[groupId][fileId];
    }

    /**
     * Get the contents for a file in a one-dimensional cache archive,
     * that is, an archive with either one group containing many files,
     * or many groups each containing one file.
     *
     * @param fileId The file or group id
     * @return The file byte contents
     */
    public byte[] getFileContents(int fileId) {
        if(fileContentCache.length == 1)
            return getFileContents(0, fileId);
        if(fileContentCache[fileId].length == 1)
            return getFileContents(fileId, 0);
        throw new RuntimeException();
    }

    public int getGroupIdByName(String name) {
        name = name.toLowerCase();
        return groupNames.getIdByName(RSString.stringHash(name));
    }

    public boolean areAllGroupsLoaded() {
        boolean bool = true;
        for(int i = 0; i < groupIds.length; i++) {
            int groupId = groupIds[i];
            if(groupContentCache[groupId] == null) {
                requestGroup(groupId);
                if(groupContentCache[groupId] == null)
                    bool = false;
            }
        }
        return bool;
    }

    public boolean groupExists(int groupId) {
        if(groupContentCache[groupId] != null)
            return true;
        requestGroup(groupId);
        if(groupContentCache[groupId] != null)
            return true;
        return false;
    }

    public int fileLength(int fileId) {
        return fileContentCache[fileId].length;
    }

    public void clearFileContentCache() {
        for(int group = 0; group < fileContentCache.length; group++) {
            if(fileContentCache[group] != null) {
                for(int file = 0; file < fileContentCache[group].length; file++)
                    fileContentCache[group][file] = null;
            }
        }
    }

    public int[] getFileIds(int groupId) {
        return fileIds[groupId];
    }

    public void prioritiseByName(String fileName) {
        fileName = fileName.toLowerCase();
        int groupId = groupNames.getIdByName(RSString.stringHash(fileName));
        if(groupId >= 0) {
            prioritiseRequest(groupId);
        }
    }

    private void prioritiseRequest(int groupId) {
        Game.updateServerConnectionManager.updateServer.prioritisePrefetchRequest(cacheIndexId, groupId);
    }
}
