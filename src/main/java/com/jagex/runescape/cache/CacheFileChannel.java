package com.jagex.runescape.cache;

import com.jagex.runescape.Class18;
import com.jagex.runescape.MovedStatics;
import com.jagex.runescape.SizedAccessFile;

import java.io.EOFException;
import java.io.IOException;

public class CacheChannel {

    public long aLong1578;
    public byte[] aByteArray1583;
    public int anInt1589;
    public byte[] aByteArray1592;
    public long aLong1593;
    public int anInt1595 = 0;
    public long aLong1596;
    public long aLong1600;
    public long aLong1602;
    public SizedAccessFile accessFile;
    public long aLong1604;

    // Cache something something
    public CacheChannel(SizedAccessFile arg0, int arg1) throws IOException {
        aLong1593 = -1L;
        aLong1596 = -1L;
        accessFile = arg0;
        aLong1602 = aLong1604 = arg0.length();
        aByteArray1592 = new byte[0];
        aByteArray1583 = new byte[arg1];
        aLong1578 = 0L;
    }


    public void method1031(int arg0, long arg1) {
        if(arg0 == 0 && arg1 >= 0)
            aLong1578 = arg1;
    }

    public long method1032(int arg0) {
        if(arg0 != 0)
            return -105L;
        return aLong1602;
    }

    public void method1033(int arg0, int arg1, int arg2, byte[] arg3) throws IOException {
        try {
            if(arg1 != -16777216)
                MovedStatics.method1034(false, 109, -94, null);
            if(aLong1602 < (long) arg2 + aLong1578)
                aLong1602 = (long) arg2 + aLong1578;
            if(aLong1593 != -1 && (aLong1578 < aLong1593 || aLong1593 + (long) anInt1595 < aLong1578))
                method1039(-1);
            if(aLong1593 != -1L && aLong1593 + (long) aByteArray1592.length < (long) arg2 + aLong1578) {
                int i = (int) (aLong1593 - (aLong1578 - (long) aByteArray1592.length));
                arg2 -= i;
                Class18.method278(arg3, arg0, aByteArray1592, (int) (-aLong1593 + aLong1578), i);
                aLong1578 += (long) i;
                anInt1595 = aByteArray1592.length;
                arg0 += i;
                method1039(-1);
            }
            if(arg2 > aByteArray1592.length) {
                if(aLong1600 != aLong1578) {
                    accessFile.seek(aLong1578);
                    aLong1600 = aLong1578;
                }
                accessFile.write(arg3, arg0, arg2);
                aLong1600 += (long) arg2;
                if(aLong1600 > aLong1604)
                    aLong1604 = aLong1600;
                long l = -1L;
                long l_0_ = -1L;
                if(aLong1578 >= aLong1596 && aLong1578 < (long) anInt1589 + aLong1596)
                    l_0_ = aLong1578;
                else if(aLong1578 <= aLong1596 && aLong1596 < aLong1578 + (long) arg2)
                    l_0_ = aLong1596;
                if(aLong1596 < aLong1578 + (long) arg2 && aLong1596 + (long) anInt1589 >= (long) arg2 + aLong1578)
                    l = (long) arg2 + aLong1578;
                else if(aLong1596 + (long) anInt1589 > aLong1578 && (long) arg2 + aLong1578 >= (long) anInt1589 + aLong1596)
                    l = (long) anInt1589 + aLong1596;
                if(l_0_ > -1 && l_0_ < l) {
                    int i = (int) (l - l_0_);
                    Class18.method278(arg3, (int) ((long) arg0 + l_0_ - aLong1578), aByteArray1583, (int) (l_0_ + -aLong1596), i);
                }
                aLong1578 += (long) arg2;
            } else if(arg2 > 0) {
                if(aLong1593 == -1)
                    aLong1593 = aLong1578;
                Class18.method278(arg3, arg0, aByteArray1592, (int) (aLong1578 + -aLong1593), arg2);
                aLong1578 += (long) arg2;
                if((long) anInt1595 < -aLong1593 + aLong1578)
                    anInt1595 = (int) (-aLong1593 + aLong1578);
            }
        } catch(IOException ioexception) {
            aLong1600 = -1L;
            throw ioexception;
        }
    }

    public void method1035(int arg0, byte arg1, int arg2, byte[] arg3) throws IOException {
        try {
            if(arg0 + arg2 > arg3.length)
                throw new ArrayIndexOutOfBoundsException(arg2 + arg0 - arg3.length);
            if(aLong1593 != -1 && aLong1593 <= aLong1578 && (long) arg2 + aLong1578 <= (long) anInt1595 + aLong1593) {
                Class18.method278(aByteArray1592, (int) (aLong1578 - aLong1593), arg3, arg0, arg2);
                aLong1578 += (long) arg2;
                return;
            }
            int i = arg2;
            long l = aLong1578;
            int i_2_ = arg0;
            if(aLong1578 >= aLong1596 && (long) anInt1589 + aLong1596 > aLong1578) {
                int i_3_ = (int) ((long) anInt1589 + -aLong1578 + aLong1596);
                if(i_3_ > arg2)
                    i_3_ = arg2;
                Class18.method278(aByteArray1583, (int) (-aLong1596 + aLong1578), arg3, arg0, i_3_);
                arg0 += i_3_;
                aLong1578 += (long) i_3_;
                arg2 -= i_3_;
            }
            if(arg2 <= aByteArray1583.length) {
                if(arg2 > 0) {
                    int i_4_ = arg2;
                    method1038((byte) 50);
                    if(i_4_ > anInt1589)
                        i_4_ = anInt1589;
                    Class18.method278(aByteArray1583, 0, arg3, arg0, i_4_);
                    aLong1578 += (long) i_4_;
                    arg0 += i_4_;
                    arg2 -= i_4_;
                }
            } else {
                accessFile.seek(aLong1578);
                aLong1600 = aLong1578;
                int i_5_;
                for(/**/; arg2 > 0; arg2 -= i_5_) {
                    i_5_ = accessFile.read(arg3, arg2, arg0);
                    if(i_5_ == -1)
                        break;
                    aLong1578 += (long) i_5_;
                    aLong1600 += (long) i_5_;
                    arg0 += i_5_;
                }
            }
            if(aLong1593 != -1L) {
                if(aLong1593 > aLong1578 && arg2 > 0) {
                    int i_6_ = (int) (-aLong1578 + aLong1593) + arg0;
                    if(i_6_ > arg0 + arg2)
                        i_6_ = arg0 + arg2;
                    while(arg0 < i_6_) {
                        arg2--;
                        arg3[arg0++] = (byte) 0;
                        aLong1578++;
                    }
                }
                long l_7_ = -1L;
                if(l < aLong1593 + (long) anInt1595 && aLong1593 + (long) anInt1595 <= (long) i + l)
                    l_7_ = (long) anInt1595 + aLong1593;
                else if(l + (long) i > aLong1593 && l + (long) i <= (long) anInt1595 + aLong1593)
                    l_7_ = (long) i + l;
                long l_8_ = -1L;
                if(aLong1593 < l || aLong1593 >= (long) i + l) {
                    if(aLong1593 <= l && l < aLong1593 + (long) anInt1595)
                        l_8_ = l;
                } else
                    l_8_ = aLong1593;
                if(l_8_ > -1L && l_7_ > l_8_) {
                    int i_9_ = (int) (-l_8_ + l_7_);
                    Class18.method278(aByteArray1592, (int) (l_8_ - aLong1593), arg3, (int) (-l + l_8_) + i_2_, i_9_);
                    if(aLong1578 < l_7_) {
                        arg2 -= l_7_ - aLong1578;
                        aLong1578 = l_7_;
                    }
                }
            }
            if(arg1 >= -8)
                method1032(34);
        } catch(IOException ioexception) {
            aLong1600 = -1L;
            throw ioexception;
        }
        if(arg2 > 0)
            throw new EOFException();
    }

    public void method1036(int arg0) throws IOException {
        if(arg0 == 841617512) {
            method1039(arg0 ^ ~0x322a1068);
            accessFile.close();
        }
    }

    public void method1038(byte arg0) throws IOException {
        if(arg0 == 50) {
            anInt1589 = 0;
            if(aLong1578 != aLong1600) {
                accessFile.seek(aLong1578);
                aLong1600 = aLong1578;
            }
            aLong1596 = aLong1578;
            int i;
            for(/**/; anInt1589 < aByteArray1583.length; anInt1589 += i) {
                i = accessFile.read(aByteArray1583, aByteArray1583.length - anInt1589, anInt1589);
                if(i == -1)
                    break;
                aLong1600 += (long) i;
            }
        }
    }

    public void method1039(int arg0) throws IOException {
        if(arg0 == -1) {
            if(aLong1593 != -1) {
                if(aLong1593 != aLong1600) {
                    accessFile.seek(aLong1593);
                    aLong1600 = aLong1593;
                }
                accessFile.write(aByteArray1592, 0, anInt1595);
                aLong1600 += (long) anInt1595;
                if(aLong1600 > aLong1604)
                    aLong1604 = aLong1600;
                long l = -1L;
                if(aLong1596 > aLong1593 || aLong1596 + (long) anInt1589 <= aLong1593) {
                    if(aLong1593 <= aLong1596 && aLong1593 + (long) anInt1595 > aLong1596)
                        l = aLong1596;
                } else
                    l = aLong1593;
                long l_10_ = -1L;
                if((long) anInt1595 + aLong1593 <= aLong1596 || (long) anInt1589 + aLong1596 < aLong1593 + (long) anInt1595) {
                    if(aLong1593 < (long) anInt1589 + aLong1596 && aLong1596 + (long) anInt1589 <= (long) anInt1595 + aLong1593)
                        l_10_ = (long) anInt1589 + aLong1596;
                } else
                    l_10_ = aLong1593 + (long) anInt1595;
                if(l > -1L && l < l_10_) {
                    int i = (int) (-l + l_10_);
                    Class18.method278(aByteArray1592, (int) (-aLong1593 + l), aByteArray1583, (int) (l - aLong1596), i);
                }
                anInt1595 = 0;
                aLong1593 = -1L;
            }
        }
    }
}
