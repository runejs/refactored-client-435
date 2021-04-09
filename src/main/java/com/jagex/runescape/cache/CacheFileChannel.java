package com.jagex.runescape.cache;

import com.jagex.runescape.Class18;
import com.jagex.runescape.SizedAccessFile;

import java.io.EOFException;
import java.io.IOException;

public class CacheFileChannel {

    public long readIndex;
    public long writeIndex;
    public byte[] aByteArray1583;
    public int anInt1589;
    public byte[] aByteArray1592;
    public long aLong1593;
    public int anInt1595 = 0;
    public long aLong1596;
    public long dataRead;
    public long size;
    public SizedAccessFile accessFile;

    public CacheFileChannel(SizedAccessFile accessFile, int bufferSize) throws IOException {
        aLong1593 = -1L;
        aLong1596 = -1L;
        this.accessFile = accessFile;
        size = writeIndex = accessFile.length();
        aByteArray1592 = new byte[0];
        aByteArray1583 = new byte[bufferSize];
        readIndex = 0L;
    }

    public void setReadIndex(long index) {
        if(index >= 0) {
            readIndex = index;
        }
    }

    public long getSize() {
        return size;
    }

    public void method1033(int arg0, int arg2, byte[] arg3) throws IOException {
        try {
            if(size < (long) arg2 + readIndex) {
                size = (long) arg2 + readIndex;
            }

            if(aLong1593 != -1 && (readIndex < aLong1593 || aLong1593 + (long) anInt1595 < readIndex)) {
                save();
            }

            if(aLong1593 != -1L && aLong1593 + (long) aByteArray1592.length < (long) arg2 + readIndex) {
                int i = (int) (aLong1593 - (readIndex - (long) aByteArray1592.length));
                arg2 -= i;
                Class18.method278(arg3, arg0, aByteArray1592, (int) (-aLong1593 + readIndex), i);
                readIndex += (long) i;
                anInt1595 = aByteArray1592.length;
                arg0 += i;
                save();
            }

            if(arg2 > aByteArray1592.length) {
                if(dataRead != readIndex) {
                    accessFile.seek(readIndex);
                    dataRead = readIndex;
                }
                accessFile.write(arg3, arg0, arg2);
                dataRead += (long) arg2;
                if(dataRead > writeIndex) {
                    writeIndex = dataRead;
                }
                long l = -1L;
                long l_0_ = -1L;
                if(readIndex >= aLong1596 && readIndex < (long) anInt1589 + aLong1596) {
                    l_0_ = readIndex;
                } else if(readIndex <= aLong1596 && aLong1596 < readIndex + (long) arg2) {
                    l_0_ = aLong1596;
                }
                if(aLong1596 < readIndex + (long) arg2 && aLong1596 + (long) anInt1589 >= (long) arg2 + readIndex) {
                    l = (long) arg2 + readIndex;
                } else if(aLong1596 + (long) anInt1589 > readIndex &&
                        (long) arg2 + readIndex >= (long) anInt1589 + aLong1596) {
                    l = (long) anInt1589 + aLong1596;
                }
                if(l_0_ > -1 && l_0_ < l) {
                    int i = (int) (l - l_0_);
                    Class18.method278(
                            arg3, (int) ((long) arg0 + l_0_ - readIndex), aByteArray1583, (int) (l_0_ + -aLong1596), i);
                }
                readIndex += (long) arg2;
            } else if(arg2 > 0) {
                if(aLong1593 == -1) {
                    aLong1593 = readIndex;
                }
                Class18.method278(arg3, arg0, aByteArray1592, (int) (readIndex + -aLong1593), arg2);
                readIndex += (long) arg2;
                if((long) anInt1595 < -aLong1593 + readIndex) {
                    anInt1595 = (int) (-aLong1593 + readIndex);
                }
            }
        } catch(IOException ioexception) {
            dataRead = -1L;
            throw ioexception;
        }
    }

    public void method1035(byte[] b, int length, int offset) throws IOException {
        try {
            if(offset + length > b.length) {
                throw new ArrayIndexOutOfBoundsException(length + offset - b.length);
            }
            if(aLong1593 != -1 && aLong1593 <= readIndex && (long) length + readIndex <= (long) anInt1595 + aLong1593) {
                Class18.method278(aByteArray1592, (int) (readIndex - aLong1593), b, offset, length);
                readIndex += (long) length;
                return;
            }
            int i = length;
            long l = readIndex;
            int i_2_ = offset;
            if(readIndex >= aLong1596 && (long) anInt1589 + aLong1596 > readIndex) {
                int i_3_ = (int) ((long) anInt1589 + -readIndex + aLong1596);
                if(i_3_ > length) {
                    i_3_ = length;
                }
                Class18.method278(aByteArray1583, (int) (-aLong1596 + readIndex), b, offset, i_3_);
                offset += i_3_;
                readIndex += (long) i_3_;
                length -= i_3_;
            }
            if(length <= aByteArray1583.length) {
                if(length > 0) {
                    int i_4_ = length;
                    readRemaining();
                    if(i_4_ > anInt1589) {
                        i_4_ = anInt1589;
                    }
                    Class18.method278(aByteArray1583, 0, b, offset, i_4_);
                    readIndex += (long) i_4_;
                    offset += i_4_;
                    length -= i_4_;
                }
            } else {
                accessFile.seek(readIndex);
                dataRead = readIndex;
                int i_5_;
                for(/**/; length > 0; length -= i_5_) {
                    i_5_ = accessFile.read(b, length, offset);
                    if(i_5_ == -1) {
                        break;
                    }
                    readIndex += (long) i_5_;
                    dataRead += (long) i_5_;
                    offset += i_5_;
                }
            }
            if(aLong1593 != -1L) {
                if(aLong1593 > readIndex && length > 0) {
                    int i_6_ = (int) (-readIndex + aLong1593) + offset;
                    if(i_6_ > offset + length) {
                        i_6_ = offset + length;
                    }
                    while(offset < i_6_) {
                        length--;
                        b[offset++] = (byte) 0;
                        readIndex++;
                    }
                }
                long l_7_ = -1L;
                if(l < aLong1593 + (long) anInt1595 && aLong1593 + (long) anInt1595 <= (long) i + l) {
                    l_7_ = (long) anInt1595 + aLong1593;
                } else if(l + (long) i > aLong1593 && l + (long) i <= (long) anInt1595 + aLong1593) {
                    l_7_ = (long) i + l;
                }
                long l_8_ = -1L;
                if(aLong1593 < l || aLong1593 >= (long) i + l) {
                    if(aLong1593 <= l && l < aLong1593 + (long) anInt1595) {
                        l_8_ = l;
                    }
                } else {
                    l_8_ = aLong1593;
                }
                if(l_8_ > -1L && l_7_ > l_8_) {
                    int i_9_ = (int) (-l_8_ + l_7_);
                    Class18.method278(aByteArray1592, (int) (l_8_ - aLong1593), b, (int) (-l + l_8_) + i_2_, i_9_);
                    if(readIndex < l_7_) {
                        length -= l_7_ - readIndex;
                        readIndex = l_7_;
                    }
                }
            }
        } catch(IOException ioexception) {
            dataRead = -1L;
            throw ioexception;
        }

        if(length > 0) {
            throw new EOFException();
        }
    }

    public void close() throws IOException {
        save();
        accessFile.close();
    }

    public void readRemaining() throws IOException {
        anInt1589 = 0;
        if(readIndex != dataRead) {
            accessFile.seek(readIndex);
            dataRead = readIndex;
        }
        aLong1596 = readIndex;
        int read;
        for(/**/; anInt1589 < aByteArray1583.length; anInt1589 += read) {
            read = accessFile.read(aByteArray1583, aByteArray1583.length - anInt1589, anInt1589);
            if(read == -1) {
                break;
            }
            dataRead += read;
        }
    }

    public void save() throws IOException {
        if(aLong1593 != -1) {
            if(aLong1593 != dataRead) {
                accessFile.seek(aLong1593);
                dataRead = aLong1593;
            }

            accessFile.write(aByteArray1592, 0, anInt1595);
            dataRead += anInt1595;

            if(dataRead > writeIndex) {
                writeIndex = dataRead;
            }

            long l = -1L;

            if(aLong1596 > aLong1593 || aLong1596 + (long) anInt1589 <= aLong1593) {
                if(aLong1593 <= aLong1596 && aLong1593 + (long) anInt1595 > aLong1596) {
                    l = aLong1596;
                }
            } else {
                l = aLong1593;
            }

            long l_10_ = -1L;

            if((long) anInt1595 + aLong1593 <= aLong1596 ||
                    (long) anInt1589 + aLong1596 < aLong1593 + (long) anInt1595) {
                if(aLong1593 < (long) anInt1589 + aLong1596 &&
                        aLong1596 + (long) anInt1589 <= (long) anInt1595 + aLong1593) {
                    l_10_ = (long) anInt1589 + aLong1596;
                }
            } else {
                l_10_ = aLong1593 + (long) anInt1595;
            }

            if(l > -1L && l < l_10_) {
                int i = (int) (-l + l_10_);
                Class18.method278(aByteArray1592, (int) (-aLong1593 + l), aByteArray1583, (int) (l - aLong1596), i);
            }

            anInt1595 = 0;
            aLong1593 = -1L;
        }
    }
}
