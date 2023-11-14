package org.runejs.client.net;

import org.runejs.client.GameSocket;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeQueue;

import java.io.IOException;
import java.util.zip.CRC32;

/**
 * Handles the (JS5) connection to the game's update servers.
 */
public class UpdateServer implements IUpdateServer {
    public int ioExceptionsCount = 0;
    public int crcMismatchesCount = 0;

    private GameSocket updateServerSocket;
    private Buffer fileDataBuffer = new Buffer(8);
    private Buffer js5ResponseData;
    private Buffer crcTableBuffer;
    private HashTable highPriorityPostProcessingQueue = new HashTable(4096);
    private HashTable highPriorityPreProcessingQueue = new HashTable(32);
    private HashTable standardPriorityPreProcessingQueue = new HashTable(4096);
    private HashTable standardPriorityPostProcessingQueue = new HashTable(4096);
    private UpdateServerNode currentResponse;
    private CRC32 crc32 = new CRC32();
    private byte encryption = (byte) 0;
    private int highPriorityResponseCount = 0;
    private int standardPriorityWriteCount = 0;
    private int highPriorityWriteCount = 0;
    private int standardPriorityResponseCount = 0;
    private boolean highPriorityRequest;
    /**
     * A NodeQueue used for the standard queue
     *
     * TODO investigate and give more descriptive name
     */
    private NodeQueue todo_standardprio_nodequeue = new NodeQueue();
    private int blockOffset = 0;
    private int msSinceLastUpdate = 0;
    private long lastUpdateInMillis;
    private CacheArchive[] cacheArchiveLoaders = new CacheArchive[256];

    private enum Opcode {
        REQUEST(0),
        PRIORITY_REQUEST(1),
        LOGGED_IN(2),
        LOGGED_OUT(3),
        NEW_ENCRYPTION(4);

        private final int value;

        Opcode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    @Override
    public void receiveConnection(GameSocket socket, boolean isLoggedIn) {
        if(updateServerSocket != null) {
            try {
                updateServerSocket.kill();
            } catch(Exception exception) {
                exception.printStackTrace();
                /* empty */
            }
            updateServerSocket = null;
        }

        updateServerSocket = socket;
        resetRequests(isLoggedIn);
        fileDataBuffer.currentPosition = 0;
        js5ResponseData = null;
        blockOffset = 0;
        currentResponse = null;

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) highPriorityPreProcessingQueue.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            highPriorityPostProcessingQueue.put(updateServerNode.key, updateServerNode);
            highPriorityResponseCount--;
            highPriorityWriteCount++;
        }

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) standardPriorityPreProcessingQueue.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            todo_standardprio_nodequeue.unshift(updateServerNode);
            standardPriorityPostProcessingQueue.put(updateServerNode.key, updateServerNode);
            standardPriorityResponseCount--;
            standardPriorityWriteCount++;
        }

        if(encryption != 0) {
            try {
                Buffer fileRequestBuffer = new Buffer(4);
                fileRequestBuffer.putByte(Opcode.NEW_ENCRYPTION.getValue());
                fileRequestBuffer.putByte(encryption);
                fileRequestBuffer.putShortBE(0);
                updateServerSocket.sendDataFromBuffer(4, 0, fileRequestBuffer.buffer);
            } catch(java.io.IOException ioexception) {
                ioexception.printStackTrace();
                try {
                    updateServerSocket.kill();
                } catch(Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                updateServerSocket = null;
                ioExceptionsCount++;
            }
        }
        msSinceLastUpdate = 0;
        lastUpdateInMillis = System.currentTimeMillis();
    }


    @Override
    public boolean poll() {
        long l = System.currentTimeMillis();
        int currentMsSinceLastUpdate = (int) (l - lastUpdateInMillis);
        lastUpdateInMillis = l;
        if(currentMsSinceLastUpdate > 200) {
            currentMsSinceLastUpdate = 200;
        }
        msSinceLastUpdate += currentMsSinceLastUpdate;
        if(standardPriorityResponseCount == 0 && highPriorityResponseCount == 0 && standardPriorityWriteCount == 0 && highPriorityWriteCount == 0) {
            return true;
        }
        if(updateServerSocket == null) {
            return false;
        }

        try {
            if(msSinceLastUpdate > 30000) {
                throw new IOException();
            }

            // Immediate file requests
            for(/**/; highPriorityResponseCount < 20; highPriorityResponseCount++) {
                if(highPriorityWriteCount <= 0) {
                    break;
                }
                UpdateServerNode updateServerNode = (UpdateServerNode) highPriorityPostProcessingQueue.getNextNode();
                Buffer buffer = new Buffer(4);
                buffer.putByte(Opcode.PRIORITY_REQUEST.getValue()); // immediate file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                highPriorityPreProcessingQueue.put(updateServerNode.key, updateServerNode);
                highPriorityWriteCount--;
            }

            // Queuable file requests
            for(/**/; standardPriorityResponseCount < 20 && standardPriorityWriteCount > 0; standardPriorityWriteCount--) {
                UpdateServerNode updateServerNode = (UpdateServerNode) todo_standardprio_nodequeue.next();
                Buffer buffer = new Buffer(4);
                buffer.putByte(Opcode.REQUEST.getValue()); // queued file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                updateServerNode.clear();
                standardPriorityPreProcessingQueue.put(updateServerNode.key, updateServerNode);
                standardPriorityResponseCount++;
            }

            for(int i1 = 0; i1 < 100; i1++) {
                int dataAvailable = updateServerSocket.inputStreamAvailable();
                if(dataAvailable < 0) {
                    throw new IOException();
                }
                if(dataAvailable == 0) {
                    break;
                }

                msSinceLastUpdate = 0;

                if (currentResponse == null || blockOffset == 0) {
                    int read = currentResponse == null ? 8 : 1;

                    int amountToRead = read - fileDataBuffer.currentPosition;
                    if(amountToRead > dataAvailable) {
                        amountToRead = dataAvailable;
                    }

                    updateServerSocket.readDataToBuffer(fileDataBuffer.buffer, fileDataBuffer.currentPosition, amountToRead);

                    if(encryption != 0) {
                        for(int i = 0; amountToRead > i; i++) {
                            fileDataBuffer.buffer[fileDataBuffer.currentPosition + i] =
                                    (byte) xor(fileDataBuffer.buffer[fileDataBuffer.currentPosition + i], encryption);
                        }
                    }

                    fileDataBuffer.currentPosition += amountToRead;
                    if(read > fileDataBuffer.currentPosition) {
                        break;
                    }

                    if(currentResponse == null) {
                        fileDataBuffer.currentPosition = 0;
                        int archiveId = fileDataBuffer.getUnsignedByte();
                        int groupId = fileDataBuffer.getUnsignedShortBE();
                        int type = fileDataBuffer.getUnsignedByte();
                        int length = fileDataBuffer.getIntBE();
                        long fileKey = ((long) archiveId << 16) + groupId;
                        UpdateServerNode updateServerNode = (UpdateServerNode) highPriorityPreProcessingQueue.getNode(fileKey);
                        highPriorityRequest = true;

                        if(updateServerNode == null) {
                            updateServerNode = (UpdateServerNode) standardPriorityPreProcessingQueue.getNode(fileKey);
                            highPriorityRequest = false;
                        }

                        if(updateServerNode == null) {
                            throw new IOException();
                        }

                        currentResponse = updateServerNode;

                        int compressionSizeOffset = type == 0 ? 5 : 9;
                        js5ResponseData = new Buffer(currentResponse.padding + compressionSizeOffset + length);
                        js5ResponseData.putByte(type);
                        js5ResponseData.putIntBE(length);

                        blockOffset = 8;
                        fileDataBuffer.currentPosition = 0;
                    } else if(blockOffset == 0) {
                        if(fileDataBuffer.buffer[0] == -1) {
                            fileDataBuffer.currentPosition = 0;
                            blockOffset = 1;
                        } else {
                            currentResponse = null;
                        }
                    }
                } else {
                    int inboundFileLength = js5ResponseData.buffer.length - currentResponse.padding;
                    int amountToRead = 512 - blockOffset;

                    if(amountToRead > inboundFileLength - js5ResponseData.currentPosition) {
                        amountToRead = inboundFileLength - js5ResponseData.currentPosition;
                    }

                    if(amountToRead > dataAvailable) {
                        amountToRead = dataAvailable;
                    }

                    updateServerSocket.readDataToBuffer(js5ResponseData.buffer, js5ResponseData.currentPosition, amountToRead);

                    if(encryption != 0) {
                        for(int i = 0; amountToRead > i; i++) {
                            js5ResponseData.buffer[js5ResponseData.currentPosition + i] = (byte) UpdateServer.xor(js5ResponseData.buffer[js5ResponseData.currentPosition + i], encryption);
                        }
                    }

                    js5ResponseData.currentPosition += amountToRead;
                    blockOffset += amountToRead;

                    if(inboundFileLength == js5ResponseData.currentPosition) {
                        if(currentResponse.key == 16711935) { // crc table file key
                            crcTableBuffer = js5ResponseData;
                            for(int i = 0; i < 256; i++) {
                                CacheArchive archive = cacheArchiveLoaders[i];
                                if(archive != null) {
                                    crcTableBuffer.currentPosition = 4 * i + 5;
                                    int indexCrcValue = crcTableBuffer.getIntBE();
                                    archive.requestLatestVersion(indexCrcValue);
                                }
                            }
                        } else {
                            crc32.reset();
                            crc32.update(js5ResponseData.buffer, 0, inboundFileLength);
                            int fileRealCrcValue = (int) crc32.getValue();
                            if(~currentResponse.crc != ~fileRealCrcValue) {
                                try {
                                    updateServerSocket.kill();
                                } catch(Exception exception) {
                                }
                                encryption = (byte) (int) (Math.random() * 255.0 + 1.0);
                                updateServerSocket = null;
                                crcMismatchesCount++;
                                return false;
                            }

                            ioExceptionsCount = 0;
                            crcMismatchesCount = 0;
                            currentResponse.cacheArchive.method196((currentResponse.key & 0xff0000L) == 16711680L, (int) (currentResponse.key & 0xffffL), highPriorityRequest, js5ResponseData.buffer);
                        }

                        currentResponse.unlink();
                        currentResponse = null;
                        js5ResponseData = null;
                        blockOffset = 0;

                        if(highPriorityRequest) {
                            highPriorityResponseCount--;
                        } else {
                            standardPriorityResponseCount--;
                        }
                    } else {
                        if(blockOffset != 512) {
                            break;
                        }

                        blockOffset = 0;
                    }
                }
            }

            return true;
        } catch(IOException ioexception) {
            ioexception.printStackTrace();

            try {
                updateServerSocket.kill();
            } catch(Exception exception) {
                exception.printStackTrace();
            }

            ioExceptionsCount++;
            updateServerSocket = null;

            return false;
        }
    }

    public void enqueueFileRequest(boolean isPriority, CacheArchive archive, int archiveIndexId, int fileId, byte padding, int expectedCrc) {
        long fileKey = fileId + ((long) archiveIndexId << 16);
        UpdateServerNode updateServerNode = (UpdateServerNode) highPriorityPostProcessingQueue.getNode(fileKey);

        if (updateServerNode == null) {
            updateServerNode = (UpdateServerNode) highPriorityPreProcessingQueue.getNode(fileKey);
            if (updateServerNode == null) {
                updateServerNode = (UpdateServerNode) standardPriorityPostProcessingQueue.getNode(fileKey);
                if (updateServerNode == null) {
                    if (!isPriority) {
                        updateServerNode = (UpdateServerNode) standardPriorityPreProcessingQueue.getNode(fileKey);
                        if (updateServerNode != null)
                            return;
                    }
                    updateServerNode = new UpdateServerNode();
                    updateServerNode.crc = expectedCrc;
                    updateServerNode.padding = padding;
                    updateServerNode.cacheArchive = archive;
                    if (isPriority) {
                        highPriorityPostProcessingQueue.put(fileKey, updateServerNode);
                        highPriorityWriteCount++;
                    } else {
                        todo_standardprio_nodequeue.push(updateServerNode);
                        standardPriorityPostProcessingQueue.put(fileKey, updateServerNode);
                        standardPriorityWriteCount++;
                    }
                } else if (isPriority) {
                    updateServerNode.clear();
                    highPriorityPostProcessingQueue.put(fileKey, updateServerNode);
                    standardPriorityWriteCount--;
                    highPriorityWriteCount++;
                }
            }
        }
    }

    /**
     * TODO suspicious name
     */
    public void moveRequestToPendingQueue(int arg0, int arg2) {
        long l = (arg0 << 16) + arg2;
        UpdateServerNode updateServerNode = (UpdateServerNode) standardPriorityPostProcessingQueue.getNode(l);
        if (updateServerNode != null) {
            todo_standardprio_nodequeue.unshift(updateServerNode);
        }
    }

    public void requestArchiveChecksum(CacheArchive cacheArchive, int cacheIndexId) {
        if (crcTableBuffer == null) {
            enqueueFileRequest(true, null, 255, 255, (byte) 0, 0);
            cacheArchiveLoaders[cacheIndexId] = cacheArchive;
        } else {
            crcTableBuffer.currentPosition = 5 + cacheIndexId * 4;
            int i = crcTableBuffer.getIntBE();
            cacheArchive.requestLatestVersion(i);
        }
    }

    private static int xor(int arg0, int arg1) {
        return arg0 ^ arg1;
    }


    @Override
    public void resetRequests(boolean loggedIn) {
        if (updateServerSocket != null) {
            try {
                Buffer buffer = new Buffer(4);
                buffer.putByte(loggedIn ? Opcode.LOGGED_IN.getValue() : Opcode.LOGGED_OUT.getValue());
                buffer.putMediumBE(0);
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
            } catch (java.io.IOException ioexception) {
                ioexception.printStackTrace();
                try {
                    updateServerSocket.kill();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                updateServerSocket = null;
                ioExceptionsCount++;
            }
        }
    
    }

    @Override
    public void close() {
        if(updateServerSocket != null) {
            updateServerSocket.kill();
        }
    }

    @Override
    public int getLoadedPercentage(int volume, int file) {
        long l = (long) ((volume << 16) + file);
        if (currentResponse == null || currentResponse.key != l)
            return 0;
        return 1 + js5ResponseData.currentPosition * 99 / (js5ResponseData.buffer.length + -currentResponse.padding);
    }

    @Override
    public int getActiveTaskCount(boolean includeStandardPriority, boolean includeHighPriority) {
        int total = 0;
        if (includeHighPriority) {
            total += highPriorityResponseCount + highPriorityWriteCount;
        }
        if (includeStandardPriority) {
            total += standardPriorityResponseCount + standardPriorityWriteCount;
        }
        return total;
    }
}
