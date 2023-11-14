package org.runejs.client.cache;

import org.runejs.client.MovedStatics;
import org.runejs.client.SizedAccessFile;

import java.io.EOFException;
import java.io.IOException;

public class CacheFileChannel {

    public long readPointer;
    public long writeIndex;
    public byte[] readPayload;
    public int readPayloadLength;
    public byte[] writePayload;
    public long writePointer;
    public int writePayloadLength = 0;
    public long aLong1596;
    public long accessFilePointer;
    public long size;
    public SizedAccessFile accessFile;

    public CacheFileChannel(SizedAccessFile accessFile, int bufferSize) throws IOException {
        writePointer = -1L;
        aLong1596 = -1L;
        this.accessFile = accessFile;
        size = writeIndex = accessFile.length();
        writePayload = new byte[0];
        readPayload = new byte[bufferSize];
        readPointer = 0L;
    }

    public void seek(long pointer) {
        if(pointer >= 0) {
            this.readPointer = pointer;
        }
    }

    public long getSize() {
        return size;
    }

    public void write(byte[] b, int offset, int length) throws IOException {
        try {
            if(size < (long) length + readPointer) {
                size = (long) length + readPointer;
            }

            if(writePointer != -1 && (readPointer < writePointer || writePointer + (long) writePayloadLength < readPointer)) {
                save();
            }

            if(writePointer != -1L && writePointer + (long) writePayload.length < (long) length + readPointer) {
                int i = (int) (writePointer - (readPointer - (long) writePayload.length));
                length -= i;
                MovedStatics.copyBytes(b, offset, writePayload, (int) (readPointer - writePointer), i);
                readPointer += (long) i;
                writePayloadLength = writePayload.length;
                offset += i;
                save();
            }

            if(length > writePayload.length) {
                if(accessFilePointer != readPointer) {
                    accessFile.seek(readPointer);
                    accessFilePointer = readPointer;
                }
                accessFile.write(b, offset, length);
                accessFilePointer += (long) length;
                if(accessFilePointer > writeIndex)
                    writeIndex = accessFilePointer;
                long l = -1L;
                long l_0_ = -1L;
                if(readPointer >= aLong1596 && readPointer < (long) readPayloadLength + aLong1596)
                    l_0_ = readPointer;
                else if(readPointer <= aLong1596 && aLong1596 < readPointer + (long) length)
                    l_0_ = aLong1596;
                if(aLong1596 < readPointer + (long) length && aLong1596 + (long) readPayloadLength >= (long) length + readPointer)
                    l = (long) length + readPointer;
                else if(aLong1596 + (long) readPayloadLength > readPointer && (long) length + readPointer >= (long) readPayloadLength + aLong1596)
                    l = (long) readPayloadLength + aLong1596;
                if(l_0_ > -1 && l_0_ < l) {
                    int i = (int) (l - l_0_);
                    MovedStatics.copyBytes(b, (int) ((long) offset + l_0_ - readPointer), readPayload, (int) (l_0_ + -aLong1596), i);
                }
                readPointer += (long) length;
            } else if(length > 0) {
                if(writePointer == -1)
                    writePointer = readPointer;
                MovedStatics.copyBytes(b, offset, writePayload, (int) (readPointer - writePointer), length);
                readPointer += (long) length;
                if((long) writePayloadLength < (readPointer - writePointer))
                    writePayloadLength = (int) (readPointer - writePointer);
            }
        } catch(IOException ioexception) {
            accessFilePointer = -1L;
            throw ioexception;
        }
    }

    public void read(byte[] b, int offset, int length) throws IOException {
        try {
            if(offset + length > b.length)
                throw new ArrayIndexOutOfBoundsException(length + offset - b.length);
            if(writePointer != -1 && writePointer <= readPointer && (long) length + readPointer <= (long) writePayloadLength + writePointer) {
                MovedStatics.copyBytes(writePayload, (int) (readPointer - writePointer), b, offset, length);
                readPointer += (long) length;
                return;
            }
            int i = length;
            long l = readPointer;
            int i_2_ = offset;
            if(readPointer >= aLong1596 && (long) readPayloadLength + aLong1596 > readPointer) {
                int i_3_ = (int) ((long) readPayloadLength + -readPointer + aLong1596);
                if(i_3_ > length)
                    i_3_ = length;
                MovedStatics.copyBytes(readPayload, (int) (-aLong1596 + readPointer), b, offset, i_3_);
                offset += i_3_;
                readPointer += (long) i_3_;
                length -= i_3_;
            }
            if(length <= readPayload.length) {
                if(length > 0) {
                    int i_4_ = length;
                    readRemaining();
                    if(i_4_ > readPayloadLength)
                        i_4_ = readPayloadLength;
                    MovedStatics.copyBytes(readPayload, 0, b, offset, i_4_);
                    readPointer += (long) i_4_;
                    offset += i_4_;
                    length -= i_4_;
                }
            } else {
                accessFile.seek(readPointer);
                accessFilePointer = readPointer;
                int i_5_;
                for(/**/; length > 0; length -= i_5_) {
                    i_5_ = accessFile.read(b, length, offset);
                    if(i_5_ == -1)
                        break;
                    readPointer += (long) i_5_;
                    accessFilePointer += (long) i_5_;
                    offset += i_5_;
                }
            }
            if(writePointer != -1L) {
                if(writePointer > readPointer && length > 0) {
                    int i_6_ = (int) (-readPointer + writePointer) + offset;
                    if(i_6_ > offset + length)
                        i_6_ = offset + length;
                    while(offset < i_6_) {
                        length--;
                        b[offset++] = (byte) 0;
                        readPointer++;
                    }
                }
                long l_7_ = -1L;
                if(l < writePointer + (long) writePayloadLength && writePointer + (long) writePayloadLength <= (long) i + l)
                    l_7_ = (long) writePayloadLength + writePointer;
                else if(l + (long) i > writePointer && l + (long) i <= (long) writePayloadLength + writePointer)
                    l_7_ = (long) i + l;
                long l_8_ = -1L;
                if(writePointer < l || writePointer >= (long) i + l) {
                    if(writePointer <= l && l < writePointer + (long) writePayloadLength)
                        l_8_ = l;
                } else
                    l_8_ = writePointer;
                if(l_8_ > -1L && l_7_ > l_8_) {
                    int i_9_ = (int) (-l_8_ + l_7_);
                    MovedStatics.copyBytes(writePayload, (int) (l_8_ - writePointer), b, (int) (-l + l_8_) + i_2_, i_9_);
                    if(readPointer < l_7_) {
                        length -= l_7_ - readPointer;
                        readPointer = l_7_;
                    }
                }
            }
        } catch(IOException ioexception) {
            accessFilePointer = -1L;
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
        readPayloadLength = 0;
        if(readPointer != accessFilePointer) {
            accessFile.seek(readPointer);
            accessFilePointer = readPointer;
        }
        aLong1596 = readPointer;
        int read;
        for(/**/; readPayloadLength < readPayload.length; readPayloadLength += read) {
            read = accessFile.read(readPayload, readPayload.length - readPayloadLength, readPayloadLength);
            if(read == -1)
                break;
            accessFilePointer += read;
        }
    }

    public void save() throws IOException {
        if(writePointer != -1) {
            if(writePointer != accessFilePointer) {
                accessFile.seek(writePointer);
                accessFilePointer = writePointer;
            }

            accessFile.write(writePayload, 0, writePayloadLength);
            accessFilePointer += writePayloadLength;

            if(accessFilePointer > writeIndex) {
                writeIndex = accessFilePointer;
            }

            long l = -1L;

            if(aLong1596 > writePointer || aLong1596 + (long) readPayloadLength <= writePointer) {
                if(writePointer <= aLong1596 && writePointer + (long) writePayloadLength > aLong1596)
                    l = aLong1596;
            } else {
                l = writePointer;
            }

            long l_10_ = -1L;

            if((long) writePayloadLength + writePointer <= aLong1596 || (long) readPayloadLength + aLong1596 < writePointer + (long) writePayloadLength) {
                if(writePointer < (long) readPayloadLength + aLong1596 && aLong1596 + (long) readPayloadLength <= (long) writePayloadLength + writePointer) {
                    l_10_ = (long) readPayloadLength + aLong1596;
                }
            } else {
                l_10_ = writePointer + (long) writePayloadLength;
            }

            if(l > -1L && l < l_10_) {
                int i = (int) (-l + l_10_);
                MovedStatics.copyBytes(writePayload, (int) (l - writePointer), readPayload, (int) (l - aLong1596), i);
            }

            writePayloadLength = 0;
            writePointer = -1L;
        }
    }
}
