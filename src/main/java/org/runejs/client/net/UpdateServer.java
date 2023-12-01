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
    /***
     * The CRC table received from the JS5 server in Buffer form
     */
    private Buffer crcTableBuffer;
    private HashTable urgentRequestTable = new HashTable(4096);
    private HashTable urgentInFlightRequests = new HashTable(32);
    private HashTable prefetchInFlightRequests = new HashTable(4096);
    private HashTable prefetchRequestTable = new HashTable(4096);
    private UpdateServerNode currentResponse;
    private CRC32 crc32 = new CRC32();
    private byte encryption = (byte) 0;

    /**
     * How many urgent requests have been sent and are awaiting a response?
     */
    private int urgentInFlightRequestCount = 0;

    /**
     * How many prefetch requests are waiting to be sent to the update server?
     */
    private int prefetchPendingRequestCount = 0;

    /**
     * How many urgent requests are waiting to be sent to the update server?
     */
    private int urgentPendingRequestCount = 0;

    /**
     * How many prefetch requests have been sent and are awaiting a response?
     */
    private int prefetchInFlightRequestCount = 0;
    private boolean urgentRequest;
    /**
     * A queue of prefetch requests to be sent to the update server.
     */
    private NodeQueue prefetchRequestQueue = new NodeQueue();
    private int blockOffset = 0;
    private int msSinceLastUpdate = 0;
    private long lastUpdateInMillis;
    /**
     * TODO (jkm) suspicious name, I think it's actually just the set of loaded CacheArchives
     */
    private CacheArchive[] cacheArchiveLoaders = new CacheArchive[256];

    private enum Opcode {
        PREFETCH_REQUEST(0),
        URGENT_REQUEST(1),
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
            UpdateServerNode updateServerNode = (UpdateServerNode) urgentInFlightRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            urgentRequestTable.put(updateServerNode.key, updateServerNode);
            urgentInFlightRequestCount--;
            urgentPendingRequestCount++;
        }

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) prefetchInFlightRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            prefetchRequestQueue.unshift(updateServerNode);
            prefetchRequestTable.put(updateServerNode.key, updateServerNode);
            prefetchInFlightRequestCount--;
            prefetchPendingRequestCount++;
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

    private void sendPendingUrgentRequests() throws IOException {
        for(/**/; urgentInFlightRequestCount < 20; urgentInFlightRequestCount++) {
            if(urgentPendingRequestCount <= 0) {
                break;
            }
            UpdateServerNode updateServerNode = (UpdateServerNode) urgentRequestTable.getNextNode();
            Buffer buffer = new Buffer(4);
            buffer.putByte(Opcode.URGENT_REQUEST.getValue()); // immediate file request
            buffer.putMediumBE((int) updateServerNode.key); // file index + file id
            updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
            urgentInFlightRequests.put(updateServerNode.key, updateServerNode);
            urgentPendingRequestCount--;
        }
    }

    private void sendPendingPrefetchRequests() throws IOException {
        for(/**/; prefetchInFlightRequestCount < 20 && prefetchPendingRequestCount > 0; prefetchPendingRequestCount--) {
            UpdateServerNode updateServerNode = (UpdateServerNode) prefetchRequestQueue.next();
            Buffer buffer = new Buffer(4);
            buffer.putByte(Opcode.PREFETCH_REQUEST.getValue()); // queued file request
            buffer.putMediumBE((int) updateServerNode.key); // file index + file id
            updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
            updateServerNode.clear();
            prefetchInFlightRequests.put(updateServerNode.key, updateServerNode);
            prefetchInFlightRequestCount++;
        }
    }

    private void readJS5ResponseHeader(Buffer buffer) throws IOException {
        buffer.currentPosition = 0;
        int archiveId = buffer.getUnsignedByte();
        int groupId = buffer.getUnsignedShortBE();
        int type = buffer.getUnsignedByte();
        int length = buffer.getIntBE();
        long fileKey = ((long) archiveId << 16) + groupId;
        UpdateServerNode updateServerNode = (UpdateServerNode) urgentInFlightRequests.getNode(fileKey);
        urgentRequest = true;

        if(updateServerNode == null) {
            updateServerNode = (UpdateServerNode) prefetchInFlightRequests.getNode(fileKey);
            urgentRequest = false;
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
        buffer.currentPosition = 0;
    }

    private void readJS5CRCTableResponse(Buffer buffer) {
        crcTableBuffer = buffer;

        for (int i = 0; i < 256; i++) {
            CacheArchive archive = cacheArchiveLoaders[i];

            if (archive == null) {
                continue;
            }

            // TODO (jkm) why is this +5?
            int targetPosition = (i * 4) + 5;
            crcTableBuffer.currentPosition = targetPosition;

            int indexCrcValue = crcTableBuffer.getIntBE();
            archive.requestLatestVersion(indexCrcValue);
        }
    }

    private boolean readJS5ArchiveFileResponse(Buffer buffer, int inboundFileLength) {
        crc32.reset();
        crc32.update(buffer.buffer, 0, inboundFileLength);
        int fileRealCrcValue = (int) crc32.getValue();
        if (~currentResponse.crc != ~fileRealCrcValue) {
            try {
                updateServerSocket.kill();
            } catch (Exception exception) {
            }
            encryption = (byte) (int) (Math.random() * 255.0 + 1.0);
            updateServerSocket = null;
            crcMismatchesCount++;
            return false;
        }

        ioExceptionsCount = 0;
        crcMismatchesCount = 0;
        currentResponse.cacheArchive.receiveContent((currentResponse.key & 0xff0000L) == 16711680L, (int) (currentResponse.key & 0xffffL), urgentRequest, buffer.buffer);
        return true;
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
        if(prefetchInFlightRequestCount == 0 && urgentInFlightRequestCount == 0 && prefetchPendingRequestCount == 0 && urgentPendingRequestCount == 0) {
            return true;
        }
        if(updateServerSocket == null) {
            return false;
        }

        try {
            if(msSinceLastUpdate > 30000) {
                throw new IOException();
            }

            this.sendPendingUrgentRequests();

            this.sendPendingPrefetchRequests();

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
                        this.readJS5ResponseHeader(fileDataBuffer);
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

                    if (inboundFileLength != js5ResponseData.currentPosition) {
                        if(blockOffset != 512) {
                            break;
                        }

                        blockOffset = 0;
                        continue;
                    }

                    if (currentResponse.key == 16711935) {
                        this.readJS5CRCTableResponse(js5ResponseData);
                    } else {
                        this.readJS5ArchiveFileResponse(js5ResponseData, inboundFileLength);
                    }

                    currentResponse.unlink();
                    currentResponse = null;
                    js5ResponseData = null;
                    blockOffset = 0;

                    if (urgentRequest) {
                        urgentInFlightRequestCount--;
                    } else {
                        prefetchInFlightRequestCount--;
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

    public void enqueueFileRequest(CacheArchive archive, int archiveId, int groupId, byte padding, int expectedCrc, boolean urgent) {
        long fileKey = ((long) archiveId << 16) + groupId;
        UpdateServerNode updateServerNode = (UpdateServerNode) urgentRequestTable.getNode(fileKey);

        if (updateServerNode == null) {
            updateServerNode = (UpdateServerNode) urgentInFlightRequests.getNode(fileKey);
            if (updateServerNode == null) {
                updateServerNode = (UpdateServerNode) prefetchRequestTable.getNode(fileKey);
                if (updateServerNode == null) {
                    if (!urgent) {
                        updateServerNode = (UpdateServerNode) prefetchInFlightRequests.getNode(fileKey);
                        if (updateServerNode != null)
                            return;
                    }
                    updateServerNode = new UpdateServerNode();
                    updateServerNode.crc = expectedCrc;
                    updateServerNode.padding = padding;
                    updateServerNode.cacheArchive = archive;
                    if (urgent) {
                        urgentRequestTable.put(fileKey, updateServerNode);
                        urgentPendingRequestCount++;
                    } else {
                        prefetchRequestQueue.push(updateServerNode);
                        prefetchRequestTable.put(fileKey, updateServerNode);
                        prefetchPendingRequestCount++;
                    }
                } else if (urgent) {
                    updateServerNode.clear();
                    urgentRequestTable.put(fileKey, updateServerNode);
                    prefetchPendingRequestCount--;
                    urgentPendingRequestCount++;
                }
            }
        }
    }

    public void prioritisePrefetchRequest(int archiveId, int groupId) {
        long fileKey = (archiveId << 16) + groupId;
        UpdateServerNode updateServerNode = (UpdateServerNode) prefetchRequestTable.getNode(fileKey);
        if (updateServerNode != null) {
            prefetchRequestQueue.unshift(updateServerNode);
        }
    }

    public void requestArchiveChecksum(CacheArchive cacheArchive, int cacheIndexId) {
        if (crcTableBuffer == null) {
            enqueueFileRequest(null, 255, 255, (byte) 0, 0, true);
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
    public int getLoadedPercentage(int groupId, int fileId) {
        long l = (long) ((groupId << 16) + fileId);
        if (currentResponse == null || currentResponse.key != l)
            return 0;
        return 1 + js5ResponseData.currentPosition * 99 / (js5ResponseData.buffer.length + -currentResponse.padding);
    }

    @Override
    public int getActiveTaskCount(boolean includePrefetch, boolean includeUrgent) {
        int total = 0;
        if (includeUrgent) {
            total += urgentInFlightRequestCount + urgentPendingRequestCount;
        }
        if (includePrefetch) {
            total += prefetchInFlightRequestCount + prefetchPendingRequestCount;
        }
        return total;
    }
}
