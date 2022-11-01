package org.runejs.client.net;

import org.runejs.client.GameSocket;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeQueue;

import java.io.IOException;
import java.util.zip.CRC32;


public class UpdateServer {
    public static int ioExceptions = 0;
    public static int crcMismatches = 0;

    private static GameSocket updateServerSocket;
    private static Buffer fileDataBuffer = new Buffer(8);
    private static Buffer inboundFile;
    private static Buffer crcTableBuffer;
    private static HashTable immediateWriteQueue = new HashTable(4096);
    private static HashTable activeRequests = new HashTable(32);
    private static HashTable queuedRequests = new HashTable(4096);
    private static HashTable writeQueue = new HashTable(4096);
    private static UpdateServerNode currentResponse;
    private static CRC32 crc32 = new CRC32();
    private static byte encryption = (byte) 0;
    private static int immediateResponses = 0;
    private static int pendingWrites = 0;
    private static int immediateWrites = 0;
    private static int pendingResponses = 0;
    private static boolean priorityRequest;
    private static NodeQueue pendingWriteQueue = new NodeQueue();
    private static int blockOffset = 0;
    private static int msSinceLastUpdate = 0;
    private static long lastUpdateInMillis;
    private static CacheArchive[] cacheArchiveLoaders = new CacheArchive[256];

    public static void handleUpdateServerConnection(GameSocket socket, boolean arg2) {
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
        UpdateServer.resetUpdateServerRequests(arg2);
        fileDataBuffer.currentPosition = 0;
        inboundFile = null;
        UpdateServer.blockOffset = 0;
        currentResponse = null;

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) activeRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            immediateWriteQueue.put(updateServerNode.key, updateServerNode);
            immediateResponses--;
            immediateWrites++;
        }

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) queuedRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            UpdateServer.pendingWriteQueue.unshift(updateServerNode);
            writeQueue.put(updateServerNode.key, updateServerNode);
            pendingResponses--;
            pendingWrites++;
        }

        if(encryption != 0) {
            try {
                Buffer fileRequestBuffer = new Buffer(4);
                fileRequestBuffer.putByte(4);
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
                ioExceptions++;
            }
        }
        UpdateServer.msSinceLastUpdate = 0;
        UpdateServer.lastUpdateInMillis = System.currentTimeMillis();
    }

    public static boolean processUpdateServerResponse() {
        long l = System.currentTimeMillis();
        int currentMsSinceLastUpdate = (int) (l - UpdateServer.lastUpdateInMillis);
        UpdateServer.lastUpdateInMillis = l;
        if(currentMsSinceLastUpdate > 200) {
            currentMsSinceLastUpdate = 200;
        }
        UpdateServer.msSinceLastUpdate += currentMsSinceLastUpdate;
        if(pendingResponses == 0 && immediateResponses == 0 && pendingWrites == 0 && immediateWrites == 0) {
            return true;
        }
        if(updateServerSocket == null) {
            return false;
        }

        try {
            if(UpdateServer.msSinceLastUpdate > 30000) {
                throw new IOException();
            }

            // Immediate file requests
            for(/**/; immediateResponses < 20; immediateResponses++) {
                if(immediateWrites <= 0) {
                    break;
                }
                UpdateServerNode updateServerNode = (UpdateServerNode) immediateWriteQueue.getNextNode();
                Buffer buffer = new Buffer(4);
                buffer.putByte(1); // immediate file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                activeRequests.put(updateServerNode.key, updateServerNode);
                immediateWrites--;
            }

            // Queuable file requests
            for(/**/; pendingResponses < 20 && pendingWrites > 0; pendingWrites--) {
                UpdateServerNode updateServerNode = (UpdateServerNode) UpdateServer.pendingWriteQueue.next();
                Buffer buffer = new Buffer(4);
                buffer.putByte(0); // queued file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                updateServerNode.clear();
                queuedRequests.put(updateServerNode.key, updateServerNode);
                pendingResponses++;
            }

            for(int i1 = 0; i1 < 100; i1++) {
                int dataAvailable = updateServerSocket.inputStreamAvailable();
                if(dataAvailable < 0) {
                    throw new IOException();
                }
                if(dataAvailable == 0) {
                    break;
                }

                UpdateServer.msSinceLastUpdate = 0;

                int read = 0;
                if(currentResponse == null) {
                    read = 8;
                } else if(UpdateServer.blockOffset == 0) {
                    read = 1;
                }

                if(read <= 0) {
                    int inboundFileLength = inboundFile.buffer.length + -currentResponse.padding;
                    int i_37_ = -UpdateServer.blockOffset + 512;
                    if(-inboundFile.currentPosition + inboundFileLength < i_37_) {
                        i_37_ = inboundFileLength - inboundFile.currentPosition;
                    }
                    if(i_37_ > dataAvailable) {
                        i_37_ = dataAvailable;
                    }
                    updateServerSocket.readDataToBuffer(inboundFile.currentPosition, i_37_, inboundFile.buffer);
                    if(encryption != 0) {
                        for(int i_38_ = 0; i_37_ > i_38_; i_38_++) {
                            inboundFile.buffer[inboundFile.currentPosition + i_38_] = (byte) UpdateServer.xor(inboundFile.buffer[inboundFile.currentPosition + i_38_], encryption);
                        }
                    }

                    inboundFile.currentPosition += i_37_;
                    UpdateServer.blockOffset += i_37_;

                    if(inboundFileLength == inboundFile.currentPosition) {
                        if(currentResponse.key == 16711935) { // crc table file key
                            crcTableBuffer = inboundFile;
                            for(int i = 0; i < 256; i++) {
                                CacheArchive archive = UpdateServer.cacheArchiveLoaders[i];
                                if(archive != null) {
                                    crcTableBuffer.currentPosition = 4 * i + 5;
                                    int indexCrcValue = crcTableBuffer.getIntBE();
                                    archive.requestLatestVersion(indexCrcValue);
                                }
                            }
                        } else {
                            crc32.reset();
                            crc32.update(inboundFile.buffer, 0, inboundFileLength);
                            int fileRealCrcValue = (int) crc32.getValue();
                            if(~currentResponse.crc != ~fileRealCrcValue) {
                                try {
                                    updateServerSocket.kill();
                                } catch(Exception exception) {
                                }
                                encryption = (byte) (int) (Math.random() * 255.0 + 1.0);
                                updateServerSocket = null;
                                UpdateServer.crcMismatches++;
                                return false;
                            }

                            ioExceptions = 0;
                            UpdateServer.crcMismatches = 0;
                            currentResponse.cacheArchive.method196((currentResponse.key & 0xff0000L) == 16711680L, (int) (currentResponse.key & 0xffffL), UpdateServer.priorityRequest, inboundFile.buffer);
                        }

                        currentResponse.unlink();
                        currentResponse = null;
                        inboundFile = null;
                        UpdateServer.blockOffset = 0;

                        if(!UpdateServer.priorityRequest) {
                            pendingResponses--;
                        } else {
                            immediateResponses--;
                        }
                    } else {
                        if(UpdateServer.blockOffset != 512) {
                            break;
                        }
                        UpdateServer.blockOffset = 0;
                    }
                } else {
                    int pos = -fileDataBuffer.currentPosition + read;
                    if(pos > dataAvailable) {
                        pos = dataAvailable;
                    }

                    updateServerSocket.readDataToBuffer(fileDataBuffer.currentPosition, pos, fileDataBuffer.buffer);

                    if(encryption != 0) {
                        for(int i = 0; pos > i; i++) {
                            fileDataBuffer.buffer[fileDataBuffer.currentPosition + i] =
                                    (byte) UpdateServer.xor(fileDataBuffer.buffer[fileDataBuffer.currentPosition + i], encryption);
                        }
                    }

                    fileDataBuffer.currentPosition += pos;
                    if(read > fileDataBuffer.currentPosition) {
                        break;
                    }

                    if(currentResponse == null) {
                        fileDataBuffer.currentPosition = 0;
                        int fileIndexId = fileDataBuffer.getUnsignedByte();
                        int fileId = fileDataBuffer.getUnsignedShortBE();
                        int fileCompression = fileDataBuffer.getUnsignedByte();
                        int fileSize = fileDataBuffer.getIntBE();
                        long fileKey = ((long) fileIndexId << 16) + fileId;
                        UpdateServerNode updateServerNode = (UpdateServerNode) activeRequests.getNode(fileKey);
                        UpdateServer.priorityRequest = true;

                        if(updateServerNode == null) {
                            updateServerNode = (UpdateServerNode) queuedRequests.getNode(fileKey);
                            UpdateServer.priorityRequest = false;
                        }

                        if(updateServerNode == null) {
                            throw new IOException();
                        }

                        currentResponse = updateServerNode;
                        int compressionSizeOffset = fileCompression == 0 ? 5 : 9;
                        inboundFile = new Buffer(currentResponse.padding + compressionSizeOffset + fileSize);
                        inboundFile.putByte(fileCompression);
                        inboundFile.putIntBE(fileSize);
                        UpdateServer.blockOffset = 8;
                        fileDataBuffer.currentPosition = 0;
                    } else if(UpdateServer.blockOffset == 0) {
                        if(fileDataBuffer.buffer[0] == -1) {
                            fileDataBuffer.currentPosition = 0;
                            UpdateServer.blockOffset = 1;
                        } else {
                            currentResponse = null;
                        }
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

            ioExceptions++;
            updateServerSocket = null;

            return false;
        }
    }

    public static void method327(boolean unknownBool, CacheArchive archive, int archiveIndexId, int fileId, byte arg4, int expectedCrc) {
        long fileKey = fileId + ((long) archiveIndexId << 16);
        UpdateServerNode updateServerNode = (UpdateServerNode) immediateWriteQueue.getNode(fileKey);

        if (updateServerNode == null) {
            updateServerNode = (UpdateServerNode) activeRequests.getNode(fileKey);
            if (updateServerNode == null) {
                updateServerNode = (UpdateServerNode) writeQueue.getNode(fileKey);
                if (updateServerNode == null) {
                    if (!unknownBool) {
                        updateServerNode = (UpdateServerNode) queuedRequests.getNode(fileKey);
                        if (updateServerNode != null)
                            return;
                    }
                    updateServerNode = new UpdateServerNode();
                    updateServerNode.crc = expectedCrc;
                    updateServerNode.padding = arg4;
                    updateServerNode.cacheArchive = archive;
                    if (unknownBool) {
                        immediateWriteQueue.put(fileKey, updateServerNode);
                        immediateWrites++;
                    } else {
                        UpdateServer.pendingWriteQueue.push(updateServerNode);
                        writeQueue.put(fileKey, updateServerNode);
                        pendingWrites++;
                    }
                } else if (unknownBool) {
                    updateServerNode.clear();
                    immediateWriteQueue.put(fileKey, updateServerNode);
                    pendingWrites--;
                    immediateWrites++;
                }
            }
        }
    }

    public static void method399(int arg0, int arg2) {
        long l = (arg0 << 16) + arg2;
        UpdateServerNode updateServerNode = (UpdateServerNode) writeQueue.getNode(l);
        if (updateServerNode != null) {
            pendingWriteQueue.unshift(updateServerNode);
        }
    }

    public static void getArchiveChecksum(CacheArchive cacheArchive, int arg2) {
        if (crcTableBuffer == null) {
            method327(true, null, 255, 255, (byte) 0, 0);
            UpdateServer.cacheArchiveLoaders[arg2] = cacheArchive;
        } else {
            crcTableBuffer.currentPosition = 5 + arg2 * 4;
            int i = crcTableBuffer.getIntBE();
            cacheArchive.requestLatestVersion(i);
        }
    }

    private static int xor(int arg0, int arg1) {
        return arg0 ^ arg1;
    }

    public static void resetUpdateServerRequests(boolean loggedIn) {
        if (updateServerSocket != null) {
            try {
                Buffer buffer = new Buffer(4);
                buffer.putByte(loggedIn ? 2 : 3);
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
                ioExceptions++;
            }
        }
    
    }

    public static void killUpdateServerSocket() {
        if(updateServerSocket != null) {
            updateServerSocket.kill();
        }
    }

    public static int calculateDataLoaded(int arg1, int arg2) {
        long l = (long) ((arg1 << 16) + arg2);
        if (currentResponse == null || currentResponse.key != l)
            return 0;
        return 1 + inboundFile.currentPosition * 99 / (inboundFile.buffer.length + -currentResponse.padding);
    }

    public static int getActiveCount(byte arg0, boolean pending, boolean immediate) {
        int total = 0;
        if (immediate) {
            total += immediateResponses + immediateWrites;
        }
        if (pending) {
            total += pendingResponses + pendingWrites;
        }
        return total;
    }
}
