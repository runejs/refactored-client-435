package org.runejs.client.net;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.node.HashTable;
import org.runejs.client.scene.InteractiveObject;

import java.io.IOException;
import java.util.zip.CRC32;


public class UpdateServer {

    public static GameSocket updateServerSocket;
    public static Buffer fileDataBuffer = new Buffer(8);
    public static Buffer aClass40_Sub1_2752;
    public static Buffer crcTableBuffer;
    public static HashTable updateServerRequests = new HashTable(4096);
    public static HashTable activeRequests = new HashTable(32);
    public static HashTable queuedRequests = new HashTable(4096);
    public static HashTable aClass23_2545 = new HashTable(4096);
    public static UpdateServerNode aUpdateServerNode_2250;
    public static CRC32 crc32 = new CRC32();
    public static byte aByte302 = (byte) 0;
    public static int anInt464 = 0;
    public static int anInt554 = 0;
    public static int anInt1618 = 0;
    public static int anInt2278 = 0;
    public static int anInt1006 = 0;


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
        GameShell.method19(arg2);
        fileDataBuffer.currentPosition = 0;
        aClass40_Sub1_2752 = null;
        Landscape.anInt1157 = 0;
        aUpdateServerNode_2250 = null;

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) activeRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            updateServerRequests.put(updateServerNode.key, updateServerNode);
            anInt464--;
            anInt1618++;
        }

        for(; ; ) {
            UpdateServerNode updateServerNode = (UpdateServerNode) queuedRequests.getNextNode();
            if(updateServerNode == null) {
                break;
            }

            InteractiveObject.aNodeQueue_485.unshift(updateServerNode);
            aClass23_2545.put(updateServerNode.key, updateServerNode);
            anInt1006--;
            anInt554++;
        }

        if(aByte302 != 0) {
            try {
                Buffer fileRequestBuffer = new Buffer(4);
                fileRequestBuffer.putByte(4);
                fileRequestBuffer.putByte(aByte302);
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
                UpdateServerNode updateServerNode = (UpdateServerNode) updateServerRequests.getNextNode();
                Buffer buffer = new Buffer(4);
                buffer.putByte(1); // immediate file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                activeRequests.put(updateServerNode.key, updateServerNode);
                anInt1618--;
            }

            // Queuable file requests
            for(/**/; anInt1006 < 20 && anInt554 > 0; anInt554--) {
                UpdateServerNode updateServerNode = (UpdateServerNode) InteractiveObject.aNodeQueue_485.next();
                Buffer buffer = new Buffer(4);
                buffer.putByte(0); // queued file request
                buffer.putMediumBE((int) updateServerNode.key); // file index + file id
                updateServerSocket.sendDataFromBuffer(4, 0, buffer.buffer);
                updateServerNode.clear();
                queuedRequests.put(updateServerNode.key, updateServerNode);
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
                if(aUpdateServerNode_2250 == null) {
                    i_35_ = 8;
                } else if(Landscape.anInt1157 == 0) {
                    i_35_ = 1;
                }

                if(i_35_ <= 0) {
                    int inboundFileLength = aClass40_Sub1_2752.buffer.length + -aUpdateServerNode_2250.aByte2758;
                    int i_37_ = -Landscape.anInt1157 + 512;
                    if(-aClass40_Sub1_2752.currentPosition + inboundFileLength < i_37_) {
                        i_37_ = inboundFileLength - aClass40_Sub1_2752.currentPosition;
                    }
                    if(i_37_ > dataAvailable) {
                        i_37_ = dataAvailable;
                    }
                    updateServerSocket.readDataToBuffer(aClass40_Sub1_2752.currentPosition, i_37_, aClass40_Sub1_2752.buffer);
                    if(aByte302 != 0) {
                        for(int i_38_ = 0; i_37_ > i_38_; i_38_++) {
                            aClass40_Sub1_2752.buffer[aClass40_Sub1_2752.currentPosition + i_38_] = (byte) GameShell.method27(aClass40_Sub1_2752.buffer[aClass40_Sub1_2752.currentPosition + i_38_], aByte302);
                        }
                    }

                    aClass40_Sub1_2752.currentPosition += i_37_;
                    Landscape.anInt1157 += i_37_;

                    if(inboundFileLength == aClass40_Sub1_2752.currentPosition) {
                        if(aUpdateServerNode_2250.key == 16711935) { // crc table file key
                            crcTableBuffer = aClass40_Sub1_2752;
                            for(int i = 0; i < 256; i++) {
                                CacheArchive archive = Class24.aClass6_Sub1Array580[i];
                                if(archive != null) {
                                    crcTableBuffer.currentPosition = 4 * i + 5;
                                    int indexCrcValue = crcTableBuffer.getIntBE();
                                    archive.requestLatestVersion(indexCrcValue);
                                }
                            }
                        } else {
                            crc32.reset();
                            crc32.update(aClass40_Sub1_2752.buffer, 0, inboundFileLength);
                            int fileRealCrcValue = (int) crc32.getValue();
                            if(~aUpdateServerNode_2250.crc != ~fileRealCrcValue) {
                                try {
                                    updateServerSocket.kill();
                                } catch(Exception exception) {
                                }
                                aByte302 = (byte) (int) (Math.random() * 255.0 + 1.0);
                                updateServerSocket = null;
                                MovedStatics.anInt813++;
                                return false;
                            }

                            anInt2278 = 0;
                            MovedStatics.anInt813 = 0;
                            aUpdateServerNode_2250.cacheArchive.method196((aUpdateServerNode_2250.key & 0xff0000L) == 16711680L, (int) (aUpdateServerNode_2250.key & 0xffffL), Npc.aBoolean3298, aClass40_Sub1_2752.buffer);
                        }

                        aUpdateServerNode_2250.remove();
                        aUpdateServerNode_2250 = null;
                        aClass40_Sub1_2752 = null;
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
                    int pos = -fileDataBuffer.currentPosition + i_35_;
                    if(pos > dataAvailable) {
                        pos = dataAvailable;
                    }

                    updateServerSocket.readDataToBuffer(fileDataBuffer.currentPosition, pos, fileDataBuffer.buffer);

                    if(aByte302 != 0) {
                        for(int i = 0; pos > i; i++) {
                            fileDataBuffer.buffer[fileDataBuffer.currentPosition + i] =
                                    (byte) GameShell.method27(fileDataBuffer.buffer[fileDataBuffer.currentPosition + i], aByte302);
                        }
                    }

                    fileDataBuffer.currentPosition += pos;
                    if(i_35_ > fileDataBuffer.currentPosition) {
                        break;
                    }

                    if(aUpdateServerNode_2250 == null) {
                        fileDataBuffer.currentPosition = 0;
                        int fileIndexId = fileDataBuffer.getUnsignedByte();
                        int fileId = fileDataBuffer.getUnsignedShortBE();
                        int fileCompression = fileDataBuffer.getUnsignedByte();
                        int fileSize = fileDataBuffer.getIntBE();
                        long fileKey = ((long) fileIndexId << 16) + fileId;
                        UpdateServerNode updateServerNode = (UpdateServerNode) activeRequests.getNode(fileKey);
                        Npc.aBoolean3298 = true;

                        if(updateServerNode == null) {
                            updateServerNode = (UpdateServerNode) queuedRequests.getNode(fileKey);
                            Npc.aBoolean3298 = false;
                        }

                        if(updateServerNode == null) {
                            throw new IOException();
                        }

                        aUpdateServerNode_2250 = updateServerNode;
                        int compressionSizeOffset = fileCompression == 0 ? 5 : 9;
                        aClass40_Sub1_2752 = new Buffer(aUpdateServerNode_2250.aByte2758 + compressionSizeOffset + fileSize);
                        aClass40_Sub1_2752.putByte(fileCompression);
                        aClass40_Sub1_2752.putIntBE(fileSize);
                        Landscape.anInt1157 = 8;
                        fileDataBuffer.currentPosition = 0;
                    } else if(Landscape.anInt1157 == 0) {
                        if(fileDataBuffer.buffer[0] == -1) {
                            fileDataBuffer.currentPosition = 0;
                            Landscape.anInt1157 = 1;
                        } else {
                            aUpdateServerNode_2250 = null;
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

    public static void method327(boolean unknownBool, CacheArchive archive, int archiveIndexId, int fileId, byte arg4, int expectedCrc) {
        long fileKey = fileId + ((long) archiveIndexId << 16);
        UpdateServerNode updateServerNode = (UpdateServerNode) updateServerRequests.getNode(fileKey);

        if (updateServerNode == null) {
            updateServerNode = (UpdateServerNode) activeRequests.getNode(fileKey);
            if (updateServerNode == null) {
                updateServerNode = (UpdateServerNode) aClass23_2545.getNode(fileKey);
                if (updateServerNode == null) {
                    if (!unknownBool) {
                        updateServerNode = (UpdateServerNode) queuedRequests.getNode(fileKey);
                        if (updateServerNode != null)
                            return;
                    }
                    updateServerNode = new UpdateServerNode();
                    updateServerNode.crc = expectedCrc;
                    updateServerNode.aByte2758 = arg4;
                    updateServerNode.cacheArchive = archive;
                    if (unknownBool) {
                        updateServerRequests.put(fileKey, updateServerNode);
                        anInt1618++;
                    } else {
                        InteractiveObject.aNodeQueue_485.push(updateServerNode);
                        aClass23_2545.put(fileKey, updateServerNode);
                        anInt554++;
                    }
                } else if (unknownBool) {
                    updateServerNode.clear();
                    updateServerRequests.put(fileKey, updateServerNode);
                    anInt554--;
                    anInt1618++;
                }
            }
        }
    }
}
