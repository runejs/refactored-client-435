package org.runejs.client.net;

import org.runejs.client.GameSocket;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeQueue;

import java.io.IOException;
import java.util.zip.CRC32;


public class UpdateServer {
    public static int anInt2278 = 0;
	public static int anInt813 = 0;

    private static GameSocket updateServerSocket;
    private static Buffer fileDataBuffer = new Buffer(8);
    private static Buffer aClass40_Sub1_2752;
    private static Buffer crcTableBuffer;
    private static HashTable updateServerRequests = new HashTable(4096);
    private static HashTable activeRequests = new HashTable(32);
    private static HashTable queuedRequests = new HashTable(4096);
    private static HashTable aClass23_2545 = new HashTable(4096);
    private static UpdateServerNode aUpdateServerNode_2250;
    private static CRC32 crc32 = new CRC32();
    private static byte aByte302 = (byte) 0;
    private static int anInt464 = 0;
    private static int anInt554 = 0;
    private static int anInt1618 = 0;
    private static int anInt1006 = 0;
	private static boolean aBoolean3298;
	private static NodeQueue aNodeQueue_485 = new NodeQueue();
	private static int anInt1157 = 0;
	private static int msSinceLastUpdate = 0;
	private static long lastUpdateInMillis;
	private static CacheArchive[] aClass6_Sub1Array580 = new CacheArchive[256];

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
        UpdateServer.method19(arg2);
        fileDataBuffer.currentPosition = 0;
        aClass40_Sub1_2752 = null;
        UpdateServer.anInt1157 = 0;
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

            UpdateServer.aNodeQueue_485.unshift(updateServerNode);
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
        if(anInt1006 == 0 && anInt464 == 0 && anInt554 == 0 && anInt1618 == 0) {
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
                UpdateServerNode updateServerNode = (UpdateServerNode) UpdateServer.aNodeQueue_485.next();
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

                UpdateServer.msSinceLastUpdate = 0;

                int i_35_ = 0;
                if(aUpdateServerNode_2250 == null) {
                    i_35_ = 8;
                } else if(UpdateServer.anInt1157 == 0) {
                    i_35_ = 1;
                }

                if(i_35_ <= 0) {
                    int inboundFileLength = aClass40_Sub1_2752.buffer.length + -aUpdateServerNode_2250.aByte2758;
                    int i_37_ = -UpdateServer.anInt1157 + 512;
                    if(-aClass40_Sub1_2752.currentPosition + inboundFileLength < i_37_) {
                        i_37_ = inboundFileLength - aClass40_Sub1_2752.currentPosition;
                    }
                    if(i_37_ > dataAvailable) {
                        i_37_ = dataAvailable;
                    }
                    updateServerSocket.readDataToBuffer(aClass40_Sub1_2752.currentPosition, i_37_, aClass40_Sub1_2752.buffer);
                    if(aByte302 != 0) {
                        for(int i_38_ = 0; i_37_ > i_38_; i_38_++) {
                            aClass40_Sub1_2752.buffer[aClass40_Sub1_2752.currentPosition + i_38_] = (byte) UpdateServer.method27(aClass40_Sub1_2752.buffer[aClass40_Sub1_2752.currentPosition + i_38_], aByte302);
                        }
                    }

                    aClass40_Sub1_2752.currentPosition += i_37_;
                    UpdateServer.anInt1157 += i_37_;

                    if(inboundFileLength == aClass40_Sub1_2752.currentPosition) {
                        if(aUpdateServerNode_2250.key == 16711935) { // crc table file key
                            crcTableBuffer = aClass40_Sub1_2752;
                            for(int i = 0; i < 256; i++) {
                                CacheArchive archive = UpdateServer.aClass6_Sub1Array580[i];
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
                                UpdateServer.anInt813++;
                                return false;
                            }

                            anInt2278 = 0;
                            UpdateServer.anInt813 = 0;
                            aUpdateServerNode_2250.cacheArchive.method196((aUpdateServerNode_2250.key & 0xff0000L) == 16711680L, (int) (aUpdateServerNode_2250.key & 0xffffL), UpdateServer.aBoolean3298, aClass40_Sub1_2752.buffer);
                        }

                        aUpdateServerNode_2250.unlink();
                        aUpdateServerNode_2250 = null;
                        aClass40_Sub1_2752 = null;
                        UpdateServer.anInt1157 = 0;

                        if(!UpdateServer.aBoolean3298) {
                            anInt1006--;
                        } else {
                            anInt464--;
                        }
                    } else {
                        if(UpdateServer.anInt1157 != 512) {
                            break;
                        }
                        UpdateServer.anInt1157 = 0;
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
                                    (byte) UpdateServer.method27(fileDataBuffer.buffer[fileDataBuffer.currentPosition + i], aByte302);
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
                        UpdateServer.aBoolean3298 = true;

                        if(updateServerNode == null) {
                            updateServerNode = (UpdateServerNode) queuedRequests.getNode(fileKey);
                            UpdateServer.aBoolean3298 = false;
                        }

                        if(updateServerNode == null) {
                            throw new IOException();
                        }

                        aUpdateServerNode_2250 = updateServerNode;
                        int compressionSizeOffset = fileCompression == 0 ? 5 : 9;
                        aClass40_Sub1_2752 = new Buffer(aUpdateServerNode_2250.aByte2758 + compressionSizeOffset + fileSize);
                        aClass40_Sub1_2752.putByte(fileCompression);
                        aClass40_Sub1_2752.putIntBE(fileSize);
                        UpdateServer.anInt1157 = 8;
                        fileDataBuffer.currentPosition = 0;
                    } else if(UpdateServer.anInt1157 == 0) {
                        if(fileDataBuffer.buffer[0] == -1) {
                            fileDataBuffer.currentPosition = 0;
                            UpdateServer.anInt1157 = 1;
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
                        UpdateServer.aNodeQueue_485.push(updateServerNode);
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

	public static void method399(int arg0, int arg2) {
	    long l = (arg0 << 16) + arg2;
	    UpdateServerNode updateServerNode = (UpdateServerNode) aClass23_2545.getNode(l);
	    if (updateServerNode != null) {
	        aNodeQueue_485.unshift(updateServerNode);
	    }
	}

	public static void method37(CacheArchive cacheArchive, int arg2) {
	    if (crcTableBuffer == null) {
	        method327(true, null, 255, 255, (byte) 0, 0);
	        UpdateServer.aClass6_Sub1Array580[arg2] = cacheArchive;
	    } else {
	        crcTableBuffer.currentPosition = 5 + arg2 * 4;
	        int i = crcTableBuffer.getIntBE();
	        cacheArchive.requestLatestVersion(i);
	    }
	}

	private static int method27(int arg0, int arg1) {
	    return arg0 ^ arg1;
	}

	public static void method19(boolean loggedIn) {
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
	            anInt2278++;
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
	    if (aUpdateServerNode_2250 == null || aUpdateServerNode_2250.key != l)
	        return 0;
	    return 1 + aClass40_Sub1_2752.currentPosition * 99 / (aClass40_Sub1_2752.buffer.length + -aUpdateServerNode_2250.aByte2758);
	}

	public static int method368(byte arg0, boolean arg1, boolean arg2) {
	    int i = 0;
	    if (arg2) {
	        i += anInt464 + anInt1618;
	    }
	    if (arg1) {
	        i += anInt1006 + anInt554;
	    }
	    return i;
	}
}
