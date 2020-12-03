package com.jagex.runescape.cache;

import com.jagex.runescape.cache.def.ActorDefinition;

public class Cache {

    public CacheFileChannel dataChannel;
    public CacheFileChannel metaChannel = null;
    public int maxLength;
    public int indexFileId;

    public Cache(int indexFileId, CacheFileChannel dataChannel, CacheFileChannel metaChannel, int maxLength) {
        this.maxLength = maxLength;
        this.metaChannel = metaChannel;
        this.dataChannel = dataChannel;
        this.indexFileId = indexFileId;
    }


    public String toString() {
        return "com.jagex.runescape.cache.Cache:" + indexFileId;
    }

    public byte[] method969(int arg0) {
        synchronized(dataChannel) {
            try {
                if(metaChannel.getSize() < (long) (6 + arg0 * 6))
                    return null;
                metaChannel.setReadIndex((long) (6 * arg0));
                metaChannel.method1035(ActorDefinition.aByteArray2416, 6, 0);
                int i_0_ = (0xff00 & ActorDefinition.aByteArray2416[4] << 8) + ((0xff & ActorDefinition.aByteArray2416[3]) << 16) + (0xff & ActorDefinition.aByteArray2416[5]);
                int i_1_ = (0xff & ActorDefinition.aByteArray2416[2]) + ((ActorDefinition.aByteArray2416[0] & 0xff) << 16) + ((0xff & ActorDefinition.aByteArray2416[1]) << 8);
                if(i_1_ < 0 || i_1_ > maxLength)
                    return null;
                if(i_0_ <= 0 || dataChannel.getSize() / 520L < (long) i_0_)
                    return null;
                int i_2_ = 0;
                int i_3_ = 0;
                byte[] is = new byte[i_1_];
                while(i_1_ > i_2_) {
                    if(i_0_ == 0)
                        return null;
                    dataChannel.setReadIndex((long) (i_0_ * 520));
                    int i_4_ = -i_2_ + i_1_;
                    if(i_4_ > 512)
                        i_4_ = 512;
                    dataChannel.method1035(ActorDefinition.aByteArray2416, 8 + i_4_, 0);
                    int i_5_ = (0xff00 & ActorDefinition.aByteArray2416[0] << 8) + (0xff & ActorDefinition.aByteArray2416[1]);
                    int i_6_ = (ActorDefinition.aByteArray2416[6] & 0xff) + ((0xff & ActorDefinition.aByteArray2416[5]) << 8) + ((0xff & ActorDefinition.aByteArray2416[4]) << 16);
                    int i_7_ = (0xff00 & ActorDefinition.aByteArray2416[2] << 8) + (0xff & ActorDefinition.aByteArray2416[3]);
                    int i_8_ = 0xff & ActorDefinition.aByteArray2416[7];
                    if(arg0 != i_5_ || i_3_ != i_7_ || indexFileId != i_8_)
                        return null;
                    if(i_6_ < 0 || dataChannel.getSize() / 520L < (long) i_6_)
                        return null;
                    i_3_++;
                    for(int i_9_ = 0; i_9_ < i_4_; i_9_++)
                        is[i_2_++] = ActorDefinition.aByteArray2416[8 + i_9_];
                    i_0_ = i_6_;
                }
                return is;
            } catch(java.io.IOException ioexception) {
                return null;
            }
        }
    }

    public boolean method970(byte[] arg0, int arg1, boolean arg2, int arg3, byte arg4) {
        synchronized(dataChannel) {
            try {
                if(arg4 >= -80)
                    method969(91);
                int i;
                if(arg2) {
                    if(metaChannel.getSize() < (long) (6 + 6 * arg3))
                        return false;
                    metaChannel.setReadIndex((long) (arg3 * 6));
                    metaChannel.method1035(ActorDefinition.aByteArray2416, 6, 0);
                    i = (ActorDefinition.aByteArray2416[5] & 0xff) + ((ActorDefinition.aByteArray2416[3] & 0xff) << 16) + ((ActorDefinition.aByteArray2416[4] & 0xff) << 8);
                    if(i <= 0 || dataChannel.getSize() / 520L < (long) i)
                        return false;
                } else {
                    i = (int) ((519L + dataChannel.getSize()) / 520L);
                    if(i == 0)
                        i = 1;
                }
                ActorDefinition.aByteArray2416[0] = (byte) (arg1 >> 16);
                ActorDefinition.aByteArray2416[1] = (byte) (arg1 >> 8);
                ActorDefinition.aByteArray2416[2] = (byte) arg1;
                int i_10_ = 0;
                ActorDefinition.aByteArray2416[3] = (byte) (i >> 16);
                int i_11_ = 0;
                ActorDefinition.aByteArray2416[4] = (byte) (i >> 8);
                ActorDefinition.aByteArray2416[5] = (byte) i;
                metaChannel.setReadIndex((long) (arg3 * 6));
                metaChannel.method1033(0, 6, ActorDefinition.aByteArray2416);
                int i_12_;
                for(/**/; i_10_ < arg1; i_10_ += i_12_) {
                    int i_13_ = 0;
                    if(arg2) {
                        dataChannel.setReadIndex((long) (520 * i));
                        try {
                            dataChannel.method1035(ActorDefinition.aByteArray2416, 8, 0);
                        } catch(java.io.EOFException eofexception) {
                            break;
                        }
                        i_13_ = (ActorDefinition.aByteArray2416[6] & 0xff) + (ActorDefinition.aByteArray2416[4] << 16 & 0xff0000) + (0xff00 & ActorDefinition.aByteArray2416[5] << 8);
                        i_12_ = (ActorDefinition.aByteArray2416[1] & 0xff) + (ActorDefinition.aByteArray2416[0] << 8 & 0xff00);
                        int i_14_ = ActorDefinition.aByteArray2416[7] & 0xff;
                        int i_15_ = (ActorDefinition.aByteArray2416[3] & 0xff) + ((0xff & ActorDefinition.aByteArray2416[2]) << 8);
                        if(arg3 != i_12_ || i_11_ != i_15_ || indexFileId != i_14_)
                            return false;
                        if(i_13_ < 0 || dataChannel.getSize() / 520L < (long) i_13_)
                            return false;
                    }
                    if(i_13_ == 0) {
                        arg2 = false;
                        i_13_ = (int) ((519L + dataChannel.getSize()) / 520L);
                        if(i_13_ == 0)
                            i_13_++;
                        if(i == i_13_)
                            i_13_++;
                    }
                    ActorDefinition.aByteArray2416[0] = (byte) (arg3 >> 8);
                    if(-i_10_ + arg1 <= 512)
                        i_13_ = 0;
                    ActorDefinition.aByteArray2416[1] = (byte) arg3;
                    i_12_ = -i_10_ + arg1;
                    if(i_12_ > 512)
                        i_12_ = 512;
                    ActorDefinition.aByteArray2416[2] = (byte) (i_11_ >> 8);
                    ActorDefinition.aByteArray2416[3] = (byte) i_11_;
                    ActorDefinition.aByteArray2416[4] = (byte) (i_13_ >> 16);
                    ActorDefinition.aByteArray2416[5] = (byte) (i_13_ >> 8);
                    i_11_++;
                    ActorDefinition.aByteArray2416[6] = (byte) i_13_;
                    ActorDefinition.aByteArray2416[7] = (byte) indexFileId;
                    dataChannel.setReadIndex((long) (520 * i));
                    dataChannel.method1033(0, 8, ActorDefinition.aByteArray2416);
                    i = i_13_;
                    dataChannel.method1033(i_10_, i_12_, arg0);
                }
                return true;
            } catch(java.io.IOException ioexception) {
                return false;
            }
        }
    }

    public boolean method971(byte[] arg0, int arg1, int arg2, int arg3) {
        synchronized(dataChannel) {
            if(arg2 < 0 || arg2 > maxLength)
                throw new IllegalArgumentException();
            if(arg1 != 1862596560)
                method971(null, 96, -29, 88);
            boolean bool = method970(arg0, arg2, true, arg3, (byte) -120);
            if(!bool)
                bool = method970(arg0, arg2, false, arg3, (byte) -114);
            return bool;
        }
    }
}
