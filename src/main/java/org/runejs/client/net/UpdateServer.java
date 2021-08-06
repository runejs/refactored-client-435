package org.runejs.client.net;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeQueue;

import java.io.IOException;
import java.util.zip.CRC32;


public class UpdateServer {

    public static GameSocket updateServerSocket;
    public static Buffer inboundDataBuffer = new Buffer(8);
    public static Buffer fileDataBuffer;
    public static Buffer crcTableBuffer;
    public static HashTable immediateFileRequests = new HashTable(32);
    public static HashTable immediateFileResponses = new HashTable(4096);
    public static HashTable queuableRequests = new HashTable(4096);
    public static NodeQueue activeQueuedRequests = new NodeQueue();
    public static HashTable queuedFileResponses = new HashTable(4096);
    public static UpdateServerNode activeNode;
    public static CRC32 crc = new CRC32();
    public static byte archiveIndex = (byte) 0;
    public static int anInt464 = 0;
    public static int anInt554 = 0;
    public static int anInt1618 = 0;
    public static int anInt2278 = 0;
    public static int anInt1006 = 0;


    public static void handleUpdateServerConnection(GameSocket socket, boolean playerLoggedIn) {
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
        GameShell.method19(playerLoggedIn);
        inboundDataBuffer.currentPosition = 0;
        fileDataBuffer = null;
        Landscape.anInt1157 = 0;
        activeNode = null;

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) immediateFileRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            immediateFileResponses.put(updateServerNode.key, updateServerNode);
            anInt464--;
            anInt1618++;
        }

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) queuableRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            activeQueuedRequests.unshift(updateServerNode);
            queuedFileResponses.put(updateServerNode.key, updateServerNode);
            anInt1006--;
            anInt554++;
        }

        if(archiveIndex != 0) {
            try {
                Buffer fileRequestBuffer = new Buffer(4);
                fileRequestBuffer.putByte(4);
                fileRequestBuffer.putByte(archiveIndex);
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
                anInt2278++;
            }
        }
        MovedStatics.msSinceLastUpdate = 0;
        MovedStatics.lastUpdateInMillis = System.currentTimeMillis();
    }

    public static boolean processUpdateServerResponse() {
        long l = System.currentTimeMillis();
        int currentMsSinceLastUpdate = (int) (l - MovedStatics.lastUpdateInMillis);
        MovedStatics.lastUpdateInMillis = l;
        if(currentMsSinceLastUpdate > 200) {
            currentMsSinceLastUpdate = 200;
        }
        MovedStatics.msSinceLastUpdate += currentMsSinceLastUpdate;
        if(anInt1006 == 0 && anInt464 == 0 && anInt554 == 0 && anInt1618 == 0) {
            return true;
        }
        if(updateServerSocket == null) {
            return false;
        }

        try {
            if(MovedStatics.msSinceLastUpdate > 30000) {
                throw new IOException();
            }

            // Immediate file requests
            for(/**/; anInt464 < 20; anInt464++) {
                if(anInt1618 <= 0) {
                    break;
                }
                UpdateServerNode updateServerNode = (UpdateServerNode) immediateFileResponses.getNextNode();
                Buffer buffer = new Buffer(4);
                buffer.putByte(1); // immediate file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id (read as a byte "index" and a short "file" in the update server)
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                immediateFileRequests.put(updateServerNode.key, updateServerNode);
                anInt1618--;
            }

            // Queueable file requests
            for(/**/; anInt1006 < 20 && anInt554 > 0; anInt554--) {
                UpdateServerNode updateServerNode = (UpdateServerNode) activeQueuedRequests.next();
                Buffer buffer = new Buffer(4);
                buffer.putByte(0); // queued file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id (read as a byte "index" and a short "file" in the update server)
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                updateServerNode.clear();
                queuableRequests.put(updateServerNode.key, updateServerNode);
                anInt1006++;
            }

            for(int i1 = 0; i1 < 100; i1++) {
                int dataAvailable = updateServerSocket.inputStreamAvailable();
                if(dataAvailable < 0) {
                    throw new IOException();
                }
                if(dataAvailable == 0) {
                    break;
                }

                MovedStatics.msSinceLastUpdate = 0;

                int i_35_ = 0;
                if(activeNode == null) {
                    i_35_ = 8;
                } else if(Landscape.anInt1157 == 0) {
                    i_35_ = 1;
                }

                if(i_35_ <= 0) {
                    int inboundFileLength = fileDataBuffer.buffer.length + -activeNode.versionSize;
                    int i_37_ = -Landscape.anInt1157 + 512;
                    if(-fileDataBuffer.currentPosition + inboundFileLength < i_37_) {
                        i_37_ = inboundFileLength - fileDataBuffer.currentPosition;
                    }
                    if(i_37_ > dataAvailable) {
                        i_37_ = dataAvailable;
                    }
                    updateServerSocket.readDataToBuffer(fileDataBuffer.currentPosition, i_37_, fileDataBuffer.buffer);
                    if(archiveIndex != 0) {
                        for(int i_38_ = 0; i_37_ > i_38_; i_38_++) {
                            fileDataBuffer.buffer[fileDataBuffer.currentPosition + i_38_] = (byte) GameShell.method27(fileDataBuffer.buffer[fileDataBuffer.currentPosition + i_38_], archiveIndex);
                        }
                    }

                    fileDataBuffer.currentPosition += i_37_;
                    Landscape.anInt1157 += i_37_;

                    if(inboundFileLength == fileDataBuffer.currentPosition) {
                        if(activeNode.key == 16711935) { // crc table file key
                            crcTableBuffer = fileDataBuffer;
                            for(int i = 0; i < 256; i++) {
                                CacheArchive archive = Class24.aClass6_Sub1Array580[i];
                                if(archive != null) {
                                    crcTableBuffer.currentPosition = 4 * i + 5;
                                    int indexCrcValue = crcTableBuffer.getIntBE();
                                    archive.requestLatestVersion(indexCrcValue);
                                }
                            }
                        } else {
                            crc.reset();
                            crc.update(fileDataBuffer.buffer, 0, inboundFileLength);
                            int fileRealCrcValue = (int) crc.getValue();
                            if(~activeNode.crc != ~fileRealCrcValue) {
                                /*try {
                                    updateServerSocket.kill();
                                } catch(Exception exception) {
                                }
                                archiveIndex = (byte) (int) (Math.random() * 255.0 + 1.0);
                                updateServerSocket = null;
                                MovedStatics.anInt813++;
                                return false;*/
                            }

                            anInt2278 = 0;
                            MovedStatics.anInt813 = 0;
                            activeNode.cacheArchive.method196((activeNode.key & 0xff0000L) == 16711680L, (int) (activeNode.key & 0xffffL), Npc.aBoolean3298, fileDataBuffer.buffer);
                        }

                        activeNode.remove();
                        activeNode = null;
                        fileDataBuffer = null;
                        Landscape.anInt1157 = 0;

                        if(!Npc.aBoolean3298) {
                            anInt1006--;
                        } else {
                            anInt464--;
                        }
                    } else {
                        if(Landscape.anInt1157 != 512) {
                            break;
                        }
                        Landscape.anInt1157 = 0;
                    }
                } else {
                    int pos = -inboundDataBuffer.currentPosition + i_35_;
                    if(pos > dataAvailable) {
                        pos = dataAvailable;
                    }

                    updateServerSocket.readDataToBuffer(inboundDataBuffer.currentPosition, pos, inboundDataBuffer.buffer);

                    if(archiveIndex != 0) {
                        for(int i = 0; pos > i; i++) {
                            inboundDataBuffer.buffer[inboundDataBuffer.currentPosition + i] =
                                    (byte) GameShell.method27(inboundDataBuffer.buffer[inboundDataBuffer.currentPosition + i], archiveIndex);
                        }
                    }

                    inboundDataBuffer.currentPosition += pos;
                    if(i_35_ > inboundDataBuffer.currentPosition) {
                        break;
                    }

                    if(activeNode == null) {
                        inboundDataBuffer.currentPosition = 0;
                        int fileIndexId = inboundDataBuffer.getUnsignedByte();
                        int fileId = inboundDataBuffer.getUnsignedShortBE();
                        int fileCompression = inboundDataBuffer.getUnsignedByte();
                        int fileSize = inboundDataBuffer.getIntBE();
                        // System.out.println("Update server response, index=" + fileIndexId + ", file=" + fileId);
                        long fileKey = ((long) fileIndexId << 16) + fileId;
                        UpdateServerNode updateServerNode = (UpdateServerNode) immediateFileRequests.getNode(fileKey);
                        Npc.aBoolean3298 = true;

                        if(updateServerNode == null) {
                            updateServerNode = (UpdateServerNode) queuableRequests.getNode(fileKey);
                            Npc.aBoolean3298 = false;
                        }

                        if(updateServerNode == null) {
                            throw new IOException();
                        }

                        activeNode = updateServerNode;
                        int compressionSizeOffset = fileCompression == 0 ? 5 : 9;
                        fileDataBuffer = new Buffer(activeNode.versionSize + compressionSizeOffset + fileSize);
                        fileDataBuffer.putByte(fileCompression);
                        fileDataBuffer.putIntBE(fileSize);
                        Landscape.anInt1157 = 8;
                        inboundDataBuffer.currentPosition = 0;
                    } else if(Landscape.anInt1157 == 0) {
                        if(inboundDataBuffer.buffer[0] == -1) {
                            inboundDataBuffer.currentPosition = 0;
                            Landscape.anInt1157 = 1;
                        } else {
                            activeNode = null;
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

            anInt2278++;
            updateServerSocket = null;

            return false;
        }
    }

    public static void method327(boolean immediate, CacheArchive archive, int archiveIndexId, int fileId, byte versionSize, int expectedCrc) {
        long fileKey = fileId + ((long) archiveIndexId << 16);
        UpdateServerNode updateServerNode = (UpdateServerNode) immediateFileResponses.getNode(fileKey);

        if (updateServerNode == null) {
            updateServerNode = (UpdateServerNode) immediateFileRequests.getNode(fileKey);
            if (updateServerNode == null) {
                updateServerNode = (UpdateServerNode) queuedFileResponses.getNode(fileKey);
                if (updateServerNode == null) {
                    if (!immediate) {
                        updateServerNode = (UpdateServerNode) queuableRequests.getNode(fileKey);
                        if (updateServerNode != null)
                            return;
                    }
                    updateServerNode = new UpdateServerNode();
                    updateServerNode.crc = expectedCrc;
                    updateServerNode.versionSize = versionSize;
                    updateServerNode.cacheArchive = archive;
                    if (immediate) {
                        immediateFileResponses.put(fileKey, updateServerNode);
                        anInt1618++;
                    } else {
                        activeQueuedRequests.push(updateServerNode);
                        queuedFileResponses.put(fileKey, updateServerNode);
                        anInt554++;
                    }
                } else if (immediate) {
                    updateServerNode.clear();
                    immediateFileResponses.put(fileKey, updateServerNode);
                    anInt554--;
                    anInt1618++;
                }
            }
        }
    }
}
