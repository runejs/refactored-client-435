package com.jagex.runescape.cache;

import java.io.IOException;

public class CacheIndex {

    public static byte[] buffer = new byte[520];
    public final CacheFileChannel dataChannel;
    public final CacheFileChannel metaChannel;
    public int maxLength;
    public int id;

    public CacheIndex(int id, CacheFileChannel dataChannel, CacheFileChannel metaChannel, int maxLength) {
        this.maxLength = maxLength;
        this.metaChannel = metaChannel;
        this.dataChannel = dataChannel;
        this.id = id;
    }

    public String toString() {
        return "com.jagex.runescape.cache.CacheIndex:" + id;
    }

    public byte[] get(int index) {
        synchronized(dataChannel) {
            try {
                if(metaChannel.getSize() < (long) (6 + index * 6)) {
                    return null;
                }

                metaChannel.setReadIndex(6 * index);
                metaChannel.method1035(buffer, 6, 0);
                int fileBlock = (0xff00 & buffer[4] << 8) + ((0xff & buffer[3]) << 16) + (0xff & buffer[5]);
                int fileSize = (0xff & buffer[2]) + ((buffer[0] & 0xff) << 16) + ((0xff & buffer[1]) << 8);
                if(fileSize < 0 || fileSize > maxLength) {
                    return null;
                }

                if(fileBlock <= 0 || dataChannel.getSize() / 520L < (long) fileBlock) {
                    return null;
                }

                int read = 0;
                int i_3_ = 0;
                byte[] is = new byte[fileSize];

                while(fileSize > read) {
                    if(fileBlock == 0) {
                        return null;
                    }

                    dataChannel.setReadIndex(fileBlock * 520);
                    int remaining = -read + fileSize;
                    if(remaining > 512) {
                        remaining = 512;
                    }

                    dataChannel.method1035(buffer, 8 + remaining, 0);
                    int i_5_ = (0xff00 & buffer[0] << 8) + (0xff & buffer[1]);
                    int i_6_ = (buffer[6] & 0xff) + ((0xff & buffer[5]) << 8) + ((0xff & buffer[4]) << 16);
                    int i_7_ = (0xff00 & buffer[2] << 8) + (0xff & buffer[3]);
                    int i_8_ = 0xff & buffer[7];

                    if(index != i_5_ || i_3_ != i_7_ || id != i_8_) {
                        return null;
                    }

                    if(i_6_ < 0 || dataChannel.getSize() / 520L < (long) i_6_) {
                        return null;
                    }

                    i_3_++;
                    for(int i_9_ = 0; i_9_ < remaining; i_9_++) {
                        is[read++] = buffer[8 + i_9_];
                    }

                    fileBlock = i_6_;
                }

                return is;
            } catch(IOException ioexception) {
                return null;
            }
        }
    }

    public boolean put(byte[] buffer, int index, boolean overwrite, int length) {
        synchronized(dataChannel) {
            try {
                int sector;
                if(overwrite) {
                    if(metaChannel.getSize() < (long) (6 + 6 * index)) {
                        return false;
                    }

                    metaChannel.setReadIndex(index * 6);
                    metaChannel.method1035(CacheIndex.buffer, 6, 0);
                    sector = (CacheIndex.buffer[5] & 0xff) + ((CacheIndex.buffer[3] & 0xff) << 16) +
                            ((CacheIndex.buffer[4] & 0xff) << 8);

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
                metaChannel.setReadIndex(index * 6);
                metaChannel.method1033(0, 6, CacheIndex.buffer);

                int i_10_ = 0;
                int i_11_ = 0;
                int i_12_;
                for(/**/; i_10_ < length; i_10_ += i_12_) {
                    int i_13_ = 0;
                    if(overwrite) {
                        dataChannel.setReadIndex(520 * sector);
                        try {
                            dataChannel.method1035(CacheIndex.buffer, 8, 0);
                        } catch(java.io.EOFException eofexception) {
                            break;
                        }
                        i_13_ = (CacheIndex.buffer[6] & 0xff) + (CacheIndex.buffer[4] << 16 & 0xff0000) +
                                (0xff00 & CacheIndex.buffer[5] << 8);
                        i_12_ = (CacheIndex.buffer[1] & 0xff) + (CacheIndex.buffer[0] << 8 & 0xff00);
                        int i_14_ = CacheIndex.buffer[7] & 0xff;
                        int i_15_ = (CacheIndex.buffer[3] & 0xff) + ((0xff & CacheIndex.buffer[2]) << 8);
                        if(index != i_12_ || i_11_ != i_15_ || id != i_14_) {
                            return false;
                        }
                        if(i_13_ < 0 || dataChannel.getSize() / 520L < (long) i_13_) {
                            return false;
                        }
                    }
                    if(i_13_ == 0) {
                        overwrite = false;
                        i_13_ = (int) ((519L + dataChannel.getSize()) / 520L);
                        if(i_13_ == 0) {
                            i_13_++;
                        }
                        if(sector == i_13_) {
                            i_13_++;
                        }
                    }
                    CacheIndex.buffer[0] = (byte) (index >> 8);
                    if(-i_10_ + length <= 512) {
                        i_13_ = 0;
                    }
                    CacheIndex.buffer[1] = (byte) index;
                    i_12_ = -i_10_ + length;
                    if(i_12_ > 512) {
                        i_12_ = 512;
                    }
                    CacheIndex.buffer[2] = (byte) (i_11_ >> 8);
                    CacheIndex.buffer[3] = (byte) i_11_;
                    CacheIndex.buffer[4] = (byte) (i_13_ >> 16);
                    CacheIndex.buffer[5] = (byte) (i_13_ >> 8);
                    i_11_++;
                    CacheIndex.buffer[6] = (byte) i_13_;
                    CacheIndex.buffer[7] = (byte) id;
                    dataChannel.setReadIndex(520 * sector);
                    dataChannel.method1033(0, 8, CacheIndex.buffer);
                    sector = i_13_;
                    dataChannel.method1033(i_10_, i_12_, buffer);
                }

                return true;
            } catch(java.io.IOException ioexception) {
                return false;
            }
        }
    }

    public boolean put(byte[] arg0, int arg2, int arg3) {
        synchronized(dataChannel) {
            if(arg2 < 0 || arg2 > maxLength) {
                throw new IllegalArgumentException();
            }

            boolean bool = put(arg0, arg3, true, arg2);
            if(!bool) {
                bool = put(arg0, arg3, false, arg2);
            }

            return bool;
        }
    }
}
