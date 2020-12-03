package com.jagex.runescape;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * A RandomAccessFile with a maximum upper size limit.
 */
public class SizedAccessFile {

    public long position;
    public long size;
    public RandomAccessFile accessFile;
    public File file;

    public SizedAccessFile(File file, String fileOptions, long size) throws IOException {
        if(size == -1) {
            size = 9223372036854775807L;
        }
        if(size <= file.length()) {
            file.delete();
        }

        accessFile = new RandomAccessFile(file, fileOptions);

        this.size = size;
        this.file = file;
        position = 0L;
    }

    public File getFile() {
        return file;
    }

    public void seek(long pointer) throws IOException {
        accessFile.seek(pointer);
        position = pointer;
    }

    public void close() throws IOException {
        accessFile.close();
        accessFile = null;
    }

    public void write(byte[] b, int offset, int length) throws IOException {
        if((long) length + position > size) {
            accessFile.seek(1L + size);
            accessFile.write(1);
            throw new EOFException();
        }

        accessFile.write(b, offset, length);
        position += length;
    }

    public long length() throws IOException {
        return accessFile.length();
    }

    public int read(byte[] b, int length, int offset) throws IOException {
        int size = accessFile.read(b, offset, length);
        if(size > 0) {
            position += size;
        }
        return size;
    }

}
