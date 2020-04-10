package com.jagex.runescape;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Class47 {
    public long aLong1118;
    public long aLong1119;
    public RandomAccessFile aRandomAccessFile1120;
    public File aFile1121;

    public Class47(File arg0, String arg1, long arg2) throws IOException {

        if(arg2 == -1)
            arg2 = 9223372036854775807L;
        if(arg2 <= arg0.length())
            arg0.delete();
        aRandomAccessFile1120 = new RandomAccessFile(arg0, arg1);
        aLong1119 = arg2;
        aFile1121 = arg0;
        aLong1118 = 0L;

    }

    public File method915(boolean arg0) {

        if(arg0)
            return null;
        return aFile1121;

    }

    public void method916(boolean arg0, long arg1) throws IOException {

        aRandomAccessFile1120.seek(arg1);
        if(!arg0)
            aLong1118 = 112L;
        aLong1118 = arg1;

    }

    public void method917(int arg0) throws IOException {
        aRandomAccessFile1120.close();
        aRandomAccessFile1120 = null;
        if(arg0 != 1)
            aFile1121 = null;
    }

    public void method918(byte[] arg0, int arg1, int arg2, boolean arg3) throws IOException {

        if((long) arg2 + aLong1118 > aLong1119) {
            aRandomAccessFile1120.seek(1L + aLong1119);
            aRandomAccessFile1120.write(1);
            throw new EOFException();
        }
        if(!arg3) {
            aRandomAccessFile1120.write(arg0, arg1, arg2);
            aLong1118 += (long) arg2;
        }

    }

    public long method919(int arg0) throws IOException {

        if(arg0 <= 12)
            aLong1118 = -17L;
        return aRandomAccessFile1120.length();

    }

    public int method920(int arg0, int arg1, byte[] arg2, int arg3) throws IOException {

        int i = aRandomAccessFile1120.read(arg2, arg0, arg1);
        if(arg3 > -99)
            aRandomAccessFile1120 = null;
        if(i > 0)
            aLong1118 += (long) i;
        return i;

    }
}
