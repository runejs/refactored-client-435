/* Class47 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Class47
{
    public long aLong1118;
    public long aLong1119;
    public RandomAccessFile aRandomAccessFile1120;
    public File aFile1121;
    
    public File method915(boolean arg0) {
	try {
	    if (arg0 != false)
		return null;
	    return aFile1121;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void method916(boolean arg0, long arg1) throws IOException {
	try {
	    aRandomAccessFile1120.seek(arg1);
	    if (arg0 != true)
		aLong1118 = 112L;
	    aLong1118 = arg1;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void method917(int arg0) throws IOException {
	aRandomAccessFile1120.close();
	aRandomAccessFile1120 = null;
	if (arg0 != 1)
	    aFile1121 = null;
    }
    
    public Class47(File arg0, String arg1, long arg2) throws IOException {
	try {
	    if ((arg2 ^ 0xffffffffffffffffL) == 0L)
		arg2 = 9223372036854775807L;
	    if (arg2 <= arg0.length())
		arg0.delete();
	    aRandomAccessFile1120 = new RandomAccessFile(arg0, arg1);
	    aLong1119 = arg2;
	    aFile1121 = arg0;
	    aLong1118 = 0L;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public void method918(byte[] arg0, int arg1, int arg2, boolean arg3)
	throws IOException {
	try {
	    if ((long) arg2 + aLong1118 > aLong1119) {
		aRandomAccessFile1120.seek(1L + aLong1119);
		aRandomAccessFile1120.write(1);
		throw new EOFException();
	    }
	    if (arg3 == false) {
		aRandomAccessFile1120.write(arg0, arg1, arg2);
		aLong1118 += (long) arg2;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public long method919(int arg0) throws IOException {
	try {
	    if (arg0 <= 12)
		aLong1118 = -17L;
	    return aRandomAccessFile1120.length();
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public int method920(int arg0, int arg1, byte[] arg2, int arg3)
	throws IOException {
	try {
	    int i = aRandomAccessFile1120.read(arg2, arg0, arg1);
	    if (arg3 > -99)
		aRandomAccessFile1120 = null;
	    if ((i ^ 0xffffffff) < -1)
		aLong1118 += (long) i;
	    return i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
