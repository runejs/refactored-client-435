/* Class67 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.io.EOFException;
import java.io.IOException;

public class Class67 {
    public static int anInt1574;
    public static volatile boolean aBoolean1575;
    public static int anInt1576;
    public static Class6 aClass6_1577;
    public static int[] anIntArray1579;
    public static RSString aClass1_1580;
    public static int anInt1581;
    public static Cache aClass9_1582;
    public static int anInt1584;
    public static RSString aClass1_1585;
    public static int anInt1586;
    public static int anInt1587;
    public static int[] anIntArray1588 = new int[1000];
    public static RSString aClass1_1590;
    public static RSString aClass1_1591
            = Class58.method978("Update)2Liste geladen)3");
    public static int anInt1594;
    public static int anInt1597;
    public static RSString aClass1_1598;
    public static int anInt1599;
    public static boolean aBoolean1601 = false;
    public static RSString aClass1_1605;
    public static int anInt1606;
    public static int anInt1607;
    public static int anInt1608;
    public static RSString aClass1_1609;
    public static RSString aClass1_1610;
    public static Cache aClass9_1611;
    public static RSString aClass1_1612;
    public static RSString aClass1_1613;
    public static long[] aLongArray1614;

    static {
        aClass1_1580 = Class58.method978("p12_full");
        aBoolean1575 = false;
        anInt1607 = 10;
        aClass1_1605 = Class58.method978("Loading )2 please wait)3");
        anInt1586 = -1;
        aClass1_1585 = aClass1_1605;
        aClass1_1609 = Class58.method978("gleiten:");
        aClass1_1590 = Class58.method978("Create a free account");
        aClass1_1610 = Class58.method978("(U3");
        aClass1_1598 = aClass1_1590;
        aClass9_1582 = new Cache(20);
        aClass9_1611 = new Cache(50);
        aLongArray1614 = new long[32];
        aClass1_1613
                = Class58.method978("60 Sekunden noch einmal)3)3)3");
        aClass1_1612 = Class58.method978("Lade Texturen )2 ");
    }

    public long aLong1578;
    public byte[] aByteArray1583;
    public int anInt1589;
    public byte[] aByteArray1592;
    public long aLong1593;
    public int anInt1595 = 0;
    public long aLong1596;
    public long aLong1600;
    public long aLong1602;
    public Class47 aClass47_1603;
    public long aLong1604;

    public Class67(Class47 arg0, int arg1, int arg2) throws IOException {
        aLong1593 = -1L;
        aLong1596 = -1L;
        try {
            aClass47_1603 = arg0;
            aLong1602 = aLong1604 = arg0.method919(87);
            aByteArray1592 = new byte[arg2];
            aByteArray1583 = new byte[arg1];
            aLong1578 = 0L;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("wb.<init>("
                            + (arg0 != null ? "{...}" : "null") + ','
                            + arg1 + ',' + arg2 + ')'));
        }
    }

    public static int method1034(boolean arg0, int arg1, int arg2,
                                 byte[] arg3) {
        try {
            anInt1584++;
            int i = -1;
            if (arg0 != true)
                return 39;
            for (int i_1_ = arg1; (i_1_ ^ 0xffffffff) > (arg2 ^ 0xffffffff);
                 i_1_++)
                i = (Class54.anIntArray1282[0xff & (i ^ arg3[i_1_])]
                        ^ i >>> -1341612408);
            i ^= 0xffffffff;
            return i;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    ("wb.G(" + arg0 + ',' + arg1 + ',' + arg2
                            + ',' + (arg3 != null ? "{...}" : "null")
                            + ')'));
        }
    }

    public static void method1037(boolean arg0) {
        try {
            anIntArray1579 = null;
            aClass1_1598 = null;
            aLongArray1614 = null;
            aClass1_1612 = null;
            aClass1_1580 = null;
            aClass1_1613 = null;
            if (arg0 != false)
                aClass1_1590 = null;
            aClass9_1582 = null;
            aClass1_1591 = null;
            aClass1_1605 = null;
            aClass1_1610 = null;
            aClass9_1611 = null;
            anIntArray1588 = null;
            aClass1_1590 = null;
            aClass1_1585 = null;
            aClass1_1609 = null;
            aClass6_1577 = null;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "wb.H(" + arg0 + ')');
        }
    }

    public void method1031(int arg0, long arg1) {
        try {
            anInt1587++;
            if (arg0 == 0 && (arg1 ^ 0xffffffffffffffffL) <= -1L)
                aLong1578 = arg1;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception,
                    "wb.C(" + arg0 + ',' + arg1 + ')');
        }
    }

    public long method1032(int arg0) {
        try {
            if (arg0 != 0)
                return -105L;
            anInt1581++;
            return aLong1602;
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "wb.D(" + arg0 + ')');
        }
    }

    public void method1033(int arg0, int arg1, int arg2, byte[] arg3)
            throws IOException {
        anInt1606++;
        try {
            if (arg1 != -16777216)
                method1034(false, 109, -94, null);
            if (((long) arg2 + aLong1578 ^ 0xffffffffffffffffL)
                    < (aLong1602 ^ 0xffffffffffffffffL))
                aLong1602 = (long) arg2 + aLong1578;
            if ((aLong1593 ^ 0xffffffffffffffffL) != 0L
                    && (aLong1578 < aLong1593 || ((aLong1578 ^ 0xffffffffffffffffL)
                    < (aLong1593 + (long) anInt1595
                    ^ 0xffffffffffffffffL))))
                method1039(-1);
            if (aLong1593 != -1L
                    && (((long) arg2 + aLong1578 ^ 0xffffffffffffffffL)
                    < (aLong1593 + (long) aByteArray1592.length
                    ^ 0xffffffffffffffffL))) {
                int i = (int) (aLong1593
                        - (aLong1578 - (long) aByteArray1592.length));
                arg2 -= i;
                Class18.method278(arg3, arg0, aByteArray1592,
                        (int) (-aLong1593 + aLong1578), i);
                aLong1578 += (long) i;
                anInt1595 = aByteArray1592.length;
                arg0 += i;
                method1039(-1);
            }
            if ((aByteArray1592.length ^ 0xffffffff) > (arg2 ^ 0xffffffff)) {
                if ((aLong1578 ^ 0xffffffffffffffffL)
                        != (aLong1600 ^ 0xffffffffffffffffL)) {
                    aClass47_1603.method916(true, aLong1578);
                    aLong1600 = aLong1578;
                }
                aClass47_1603.method918(arg3, arg0, arg2, false);
                aLong1600 += (long) arg2;
                if (aLong1600 > aLong1604)
                    aLong1604 = aLong1600;
                long l = -1L;
                long l_0_ = -1L;
                if (aLong1578 >= aLong1596
                        && aLong1578 < (long) anInt1589 + aLong1596)
                    l_0_ = aLong1578;
                else if (((aLong1596 ^ 0xffffffffffffffffL)
                        <= (aLong1578 ^ 0xffffffffffffffffL))
                        && aLong1596 < aLong1578 - -(long) arg2)
                    l_0_ = aLong1596;
                if (aLong1596 < aLong1578 - -(long) arg2
                        && (((long) arg2 + aLong1578 ^ 0xffffffffffffffffL)
                        >= (aLong1596 - -(long) anInt1589
                        ^ 0xffffffffffffffffL)))
                    l = (long) arg2 + aLong1578;
                else if (aLong1596 + (long) anInt1589 > aLong1578
                        && (((long) anInt1589 + aLong1596
                        ^ 0xffffffffffffffffL)
                        >= ((long) arg2 + aLong1578
                        ^ 0xffffffffffffffffL)))
                    l = (long) anInt1589 + aLong1596;
                if ((l_0_ ^ 0xffffffffffffffffL) < 0L
                        && (l ^ 0xffffffffffffffffL) < (l_0_
                        ^ 0xffffffffffffffffL)) {
                    int i = (int) (l - l_0_);
                    Class18.method278(arg3,
                            (int) ((long) arg0 + (l_0_ - aLong1578)),
                            aByteArray1583,
                            (int) (l_0_ + -aLong1596), i);
                }
                aLong1578 += (long) arg2;
            } else if ((arg2 ^ 0xffffffff) < -1) {
                if ((aLong1593 ^ 0xffffffffffffffffL) == 0L)
                    aLong1593 = aLong1578;
                Class18.method278(arg3, arg0, aByteArray1592,
                        (int) (aLong1578 + -aLong1593), arg2);
                aLong1578 += (long) arg2;
                if ((long) anInt1595 < -aLong1593 + aLong1578)
                    anInt1595 = (int) (-aLong1593 + aLong1578);
            }
        } catch (IOException ioexception) {
            aLong1600 = -1L;
            throw ioexception;
        }
    }

    public void method1035(int arg0, byte arg1, int arg2, byte[] arg3)
            throws IOException {
        anInt1599++;
        try {
            if ((arg0 - -arg2 ^ 0xffffffff) < (arg3.length ^ 0xffffffff))
                throw new ArrayIndexOutOfBoundsException(arg2
                        + (arg0
                        - arg3.length));
            if ((aLong1593 ^ 0xffffffffffffffffL) != 0L
                    && (aLong1578 ^ 0xffffffffffffffffL) <= (aLong1593
                    ^ 0xffffffffffffffffL)
                    && (long) arg2 + aLong1578 <= (long) anInt1595 + aLong1593) {
                Class18.method278(aByteArray1592,
                        (int) (aLong1578 - aLong1593), arg3, arg0,
                        arg2);
                aLong1578 += (long) arg2;
                return;
            }
            int i = arg2;
            long l = aLong1578;
            int i_2_ = arg0;
            if ((aLong1596 ^ 0xffffffffffffffffL) >= (aLong1578
                    ^ 0xffffffffffffffffL)
                    && (long) anInt1589 + aLong1596 > aLong1578) {
                int i_3_
                        = (int) ((long) anInt1589 + (-aLong1578 - -aLong1596));
                if ((i_3_ ^ 0xffffffff) < (arg2 ^ 0xffffffff))
                    i_3_ = arg2;
                Class18.method278(aByteArray1583,
                        (int) (-aLong1596 + aLong1578), arg3, arg0,
                        i_3_);
                arg0 += i_3_;
                aLong1578 += (long) i_3_;
                arg2 -= i_3_;
            }
            if (arg2 <= aByteArray1583.length) {
                if ((arg2 ^ 0xffffffff) < -1) {
                    int i_4_ = arg2;
                    method1038((byte) 50);
                    if (i_4_ > anInt1589)
                        i_4_ = anInt1589;
                    Class18.method278(aByteArray1583, 0, arg3, arg0, i_4_);
                    aLong1578 += (long) i_4_;
                    arg0 += i_4_;
                    arg2 -= i_4_;
                }
            } else {
                aClass47_1603.method916(true, aLong1578);
                aLong1600 = aLong1578;
                int i_5_;
                for (/**/; arg2 > 0; arg2 -= i_5_) {
                    i_5_ = aClass47_1603.method920(arg0, arg2, arg3, -120);
                    if ((i_5_ ^ 0xffffffff) == 0)
                        break;
                    aLong1578 += (long) i_5_;
                    aLong1600 += (long) i_5_;
                    arg0 += i_5_;
                }
            }
            if (aLong1593 != -1L) {
                if ((aLong1578 ^ 0xffffffffffffffffL) > (aLong1593
                        ^ 0xffffffffffffffffL)
                        && arg2 > 0) {
                    int i_6_ = (int) (-aLong1578 + aLong1593) + arg0;
                    if ((i_6_ ^ 0xffffffff) < (arg0 + arg2 ^ 0xffffffff))
                        i_6_ = arg0 + arg2;
                    while (arg0 < i_6_) {
                        arg2--;
                        arg3[arg0++] = (byte) 0;
                        aLong1578++;
                    }
                }
                long l_7_ = -1L;
                if (((aLong1593 - -(long) anInt1595 ^ 0xffffffffffffffffL)
                        < (l ^ 0xffffffffffffffffL))
                        && (((long) i + l ^ 0xffffffffffffffffL)
                        <= (aLong1593 + (long) anInt1595
                        ^ 0xffffffffffffffffL)))
                    l_7_ = (long) anInt1595 + aLong1593;
                else if (l - -(long) i > aLong1593
                        && (((long) anInt1595 + aLong1593
                        ^ 0xffffffffffffffffL)
                        <= (l - -(long) i ^ 0xffffffffffffffffL)))
                    l_7_ = (long) i + l;
                long l_8_ = -1L;
                if ((l ^ 0xffffffffffffffffL) < (aLong1593
                        ^ 0xffffffffffffffffL)
                        || (((long) i + l ^ 0xffffffffffffffffL)
                        >= (aLong1593 ^ 0xffffffffffffffffL))) {
                    if (aLong1593 <= l
                            && (aLong1593 - -(long) anInt1595
                            ^ 0xffffffffffffffffL) < (l ^ 0xffffffffffffffffL))
                        l_8_ = l;
                } else
                    l_8_ = aLong1593;
                if (l_8_ > -1L && ((l_8_ ^ 0xffffffffffffffffL)
                        > (l_7_ ^ 0xffffffffffffffffL))) {
                    int i_9_ = (int) (-l_8_ + l_7_);
                    Class18.method278(aByteArray1592, (int) (l_8_ - aLong1593),
                            arg3, (int) (-l + l_8_) + i_2_, i_9_);
                    if (aLong1578 < l_7_) {
                        arg2 -= l_7_ - aLong1578;
                        aLong1578 = l_7_;
                    }
                }
            }
            if (arg1 >= -8)
                method1032(34);
        } catch (IOException ioexception) {
            aLong1600 = -1L;
            throw ioexception;
        }
        if ((arg2 ^ 0xffffffff) < -1)
            throw new EOFException();
    }

    public void method1036(int arg0) throws IOException {
        try {
            anInt1574++;
            if (arg0 == 841617512) {
                method1039(arg0 ^ ~0x322a1068);
                aClass47_1603.method917(arg0 + -841617511);
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "wb.A(" + arg0 + ')');
        }
    }

    public void method1038(byte arg0) throws IOException {
        try {
            anInt1608++;
            if (arg0 == 50) {
                anInt1589 = 0;
                if ((aLong1600 ^ 0xffffffffffffffffL)
                        != (aLong1578 ^ 0xffffffffffffffffL)) {
                    aClass47_1603.method916(true, aLong1578);
                    aLong1600 = aLong1578;
                }
                aLong1596 = aLong1578;
                int i;
                for (/**/; ((aByteArray1583.length ^ 0xffffffff)
                        < (anInt1589 ^ 0xffffffff)); anInt1589 += i) {
                    i = aClass47_1603.method920(anInt1589,
                            (aByteArray1583.length
                                    - anInt1589),
                            aByteArray1583, -110);
                    if ((i ^ 0xffffffff) == 0)
                        break;
                    aLong1600 += (long) i;
                }
            }
        } catch (RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "wb.B(" + arg0 + ')');
        }
    }

    public void method1039(int arg0) throws IOException {
        anInt1597++;
        if (arg0 == -1) {
            if ((aLong1593 ^ 0xffffffffffffffffL) != 0L) {
                if ((aLong1600 ^ 0xffffffffffffffffL)
                        != (aLong1593 ^ 0xffffffffffffffffL)) {
                    aClass47_1603.method916(true, aLong1593);
                    aLong1600 = aLong1593;
                }
                aClass47_1603.method918(aByteArray1592, 0, anInt1595, false);
                aLong1600 += (long) anInt1595;
                if ((aLong1604 ^ 0xffffffffffffffffL)
                        > (aLong1600 ^ 0xffffffffffffffffL))
                    aLong1604 = aLong1600;
                long l = -1L;
                if (aLong1596 > aLong1593 || ((aLong1593 ^ 0xffffffffffffffffL)
                        <= (aLong1596 - -(long) anInt1589
                        ^ 0xffffffffffffffffL))) {
                    if (aLong1593 <= aLong1596
                            && aLong1593 + (long) anInt1595 > aLong1596)
                        l = aLong1596;
                } else
                    l = aLong1593;
                long l_10_ = -1L;
                if ((long) anInt1595 + aLong1593 <= aLong1596
                        || ((long) anInt1589 + aLong1596
                        < aLong1593 - -(long) anInt1595)) {
                    if ((((long) anInt1589 + aLong1596 ^ 0xffffffffffffffffL)
                            < (aLong1593 ^ 0xffffffffffffffffL))
                            && (((long) anInt1595 + aLong1593
                            ^ 0xffffffffffffffffL)
                            <= (aLong1596 - -(long) anInt1589
                            ^ 0xffffffffffffffffL)))
                        l_10_ = (long) anInt1589 + aLong1596;
                } else
                    l_10_ = aLong1593 + (long) anInt1595;
                if (l > -1L && ((l_10_ ^ 0xffffffffffffffffL)
                        < (l ^ 0xffffffffffffffffL))) {
                    int i = (int) (-l + l_10_);
                    Class18.method278(aByteArray1592, (int) (-aLong1593 + l),
                            aByteArray1583, (int) (l - aLong1596),
                            i);
                }
                anInt1595 = 0;
                aLong1593 = -1L;
            }
        }
    }
}
