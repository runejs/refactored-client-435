package org.runejs.client.cache;

import java.io.IOException;

public class CacheIndex {

    public static byte[] buffer = new byte[520];
    public final CacheFileChannel dataChannel;
    public final CacheFileChannel metaChannel;
    public int maxLength;
    public int store;

    public CacheIndex(int store, CacheFileChannel dataChannel, CacheFileChannel metaChannel, int maxLength) {
        this.maxLength = maxLength;
        this.metaChannel = metaChannel;
        this.dataChannel = dataChannel;
        this.store = store;
    }

    public String toString() {
        return "CacheIndex:" + store;
    }

    public byte[] read(int file) {
        synchronized(dataChannel) {
            try {
                if(metaChannel.getSize() < (file * 6L + 6)) {
                    return null;
                }

                metaChannel.seek(file * 6L);
                metaChannel.read(buffer, 0, 6);

                int sector = (0xff00 & buffer[4] << 8) + ((0xff & buffer[3]) << 16) + (0xff & buffer[5]);
                int size = (0xff & buffer[2]) + ((buffer[0] & 0xff) << 16) + ((0xff & buffer[1]) << 8);

                if(size < 0 || size > maxLength) {
                    return null;
                }

                if(sector <= 0 || dataChannel.getSize() / 520L < (long) sector) {
                    return null;
                }

                int position = 0;
                int part = 0;
                byte[] data = new byte[size];

                while(size > position) {
                    if(sector == 0) {
                        return null;
                    }

                    dataChannel.seek(sector * 520L);

                    int available = size - position;
                    if (available > 512) {
                        available = 512;
                    }

                    dataChannel.read(buffer, 0, 8 + available);

                    int sectorFile = (0xff00 & buffer[0] << 8) + (0xff & buffer[1]);
                    int nextSector = (buffer[6] & 0xff) + ((0xff & buffer[5]) << 8) + ((0xff & buffer[4]) << 16);
                    int sectorPart = (0xff00 & buffer[2] << 8) + (0xff & buffer[3]);
                    int sectorStore = 0xff & buffer[7];

                    if(file != sectorFile || part != sectorPart || store != sectorStore) {
                        return null;
                    }

                    if(nextSector < 0 || dataChannel.getSize() / 520L < (long) nextSector) {
                        return null;
                    }
                    for(int i = 0; i < available; i++) {
                        data[position++] = buffer[8 + i];
                    }

                    part++;
                    sector = nextSector;
                }

                return data;
            } catch(IOException ioexception) {
                return null;
            }
        }
    }

    public boolean write(byte[] buffer, int file, int length, boolean overwrite) {
        synchronized(dataChannel) {
            try {
                int sector;
                if(overwrite) {
                    if(metaChannel.getSize() < (file * 6L + 6)) {
                        return false;
                    }

                    metaChannel.seek(file * 6L);
                    metaChannel.read(CacheIndex.buffer, 0, 6);

                    sector =
                            (CacheIndex.buffer[5] & 0xff)
                                    + ((CacheIndex.buffer[3] & 0xff) << 16)
                                    + ((CacheIndex.buffer[4] & 0xff) << 8);

                    if(sector <= 0 || dataChannel.getSize() / 520L < (long) sector) {
                        return false;
                    }
                } else {
                    sector = (int) ((519L + dataChannel.getSize()) / 520L);

                    if(sector == 0) {
                        sector = 1;
                    }
                }

                CacheIndex.buffer[0] = (byte) (length >> 16);
                CacheIndex.buffer[1] = (byte) (length >> 8);
                CacheIndex.buffer[2] = (byte) length;
                CacheIndex.buffer[3] = (byte) (sector >> 16);
                CacheIndex.buffer[4] = (byte) (sector >> 8);
                CacheIndex.buffer[5] = (byte) sector;

                metaChannel.seek(file * 6);
                metaChannel.write(CacheIndex.buffer, 0, 6);

                int written = 0;
                for(int part = 0; written < length; part++) {
                    int nextSector = 0;

                    if(overwrite) {
                        dataChannel.seek((long) (520 * sector));

                        try {
                            dataChannel.read(CacheIndex.buffer, 0, 8);
                        } catch(java.io.EOFException eofexception) {
                            break;
                        }

                        nextSector = (CacheIndex.buffer[6] & 0xff) + (CacheIndex.buffer[4] << 16 & 0xff0000) + (0xff00 & CacheIndex.buffer[5] << 8);
                        int sectorFile = (CacheIndex.buffer[1] & 0xff) + (CacheIndex.buffer[0] << 8 & 0xff00);
                        int sectorStore = CacheIndex.buffer[7] & 0xff;
                        int sectorPart = (CacheIndex.buffer[3] & 0xff) + ((0xff & CacheIndex.buffer[2]) << 8);

                        if(file != sectorFile || part != sectorPart || store != sectorStore)
                            return false;

                        if(nextSector < 0 || dataChannel.getSize() / 520L < (long) nextSector)
                            return false;
                    }

                    if(nextSector == 0) {
                        overwrite = false;
                        nextSector = (int) ((519L + dataChannel.getSize()) / 520L);
                        if(nextSector == 0)
                            nextSector++;
                        if(sector == nextSector)
                            nextSector++;
                    }

                    if((length - written) <= 512) {
                        nextSector = 0;
                    }

                    CacheIndex.buffer[0] = (byte) (file >> 8);
                    CacheIndex.buffer[1] = (byte) file;
                    CacheIndex.buffer[2] = (byte) (part >> 8);
                    CacheIndex.buffer[3] = (byte) part;
                    CacheIndex.buffer[4] = (byte) (nextSector >> 16);
                    CacheIndex.buffer[5] = (byte) (nextSector >> 8);
                    CacheIndex.buffer[6] = (byte) nextSector;
                    CacheIndex.buffer[7] = (byte) store;

                    dataChannel.seek((long) (520 * sector));
                    dataChannel.write(CacheIndex.buffer, 0, 8);

                    int available = length - written;
                    if(available > 512)
                        available = 512;

                    dataChannel.write(buffer, written, available);

                    written += available;
                    sector = nextSector;
                }

                return true;
            } catch(java.io.IOException ioexception) {
                return false;
            }
        }
    }

    public boolean write(byte[] data, int file, int length) {
        synchronized(dataChannel) {
            if(length < 0 || length > maxLength) {
                throw new IllegalArgumentException();
            }

            boolean written = write(data, file, length, true);
            if(!written) {
                written = write(data, file, length, false);
            }

            return written;
        }
    }
}
