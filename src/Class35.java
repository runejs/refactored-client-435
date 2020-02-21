/* Class35 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class Class35 implements Interface3 {
    public static int anInt1719;
    public static RSString aClass1_1720 = Class58.method978("Enter object name");
    public static int anInt1721;
    public static int anInt1722;
    public static int anInt1723;
    public static int anInt1724;
    public static RSString aClass1_1725;
    public static RSString aClass1_1726;
    public static int anInt1728;
    public static int anInt1729;
    public static int anInt1730 = 0;
    public static RSString aClass1_1731;
    public static Frame aFrame1732;
    public static int anInt1733;
    public static boolean aBoolean1734;
    public static boolean aBoolean1735;
    public static RSString aClass1_1736;
    public static int anInt1737;
    public static int[] anIntArray1738;
    public static int anInt1739;
    public static int anInt1741;
    public static int anInt1742;
    public static RSString aClass1_1743;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_1744;
    public static byte[][][] aByteArrayArrayArray1745;
    public static RSString aClass1_1746;
    public static RSString aClass1_1747;
    public static int anInt1751;

    static {
        aClass1_1726 = Class58.method978("Wen m-Ochten Sie der Liste hinzuf-Ugen?");
        anInt1733 = 0;
        anIntArray1738 = new int[]{9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486};
        aBoolean1734 = false;
        anInt1737 = 0;
        aClass1_1731 = Class58.method978("Handel)4Duell");
        anInt1728 = 0;
        aClass1_1725 = Class58.method978("null");
        aBoolean1735 = true;
        aClass1_1747 = aClass1_1720;
        aClass1_1736 = Class58.method978("Enter message to send to ");
        aClass1_1743 = Class58.method978("und haben es deaktiviert)3 Benutzen Sie die");
        aClass1_1746 = aClass1_1736;
    }

    public Class45 aClass45_1727 = new Class45();
    public EntryTable[] aClass40_Sub10Array1740;
    public int anInt1748;
    public Class6 aClass6_1749;
    public double aDouble1750 = 1.0;
    public int anInt1752;
    public int anInt1753;

    public Class35(Class6 arg0, Class6 arg1, int arg2, double arg3, int arg4) {
        anInt1748 = 128;
        anInt1753 = 0;
        try {
            anInt1752 = arg2;
            aClass6_1749 = arg1;
            aDouble1750 = arg3;
            anInt1748 = arg4;
            anInt1753 = anInt1752;
            int[] is = arg0.method192(0, true);
            int i = is.length;
            aClass40_Sub10Array1740 = new EntryTable[arg0.method190(0, (byte) 120)];
            for(int i_4_ = 0; i > i_4_; i_4_++) {
                Buffer class40_sub1 = new Buffer(arg0.method172(is[i_4_], 120, 0));
                aClass40_Sub10Array1740[is[i_4_]] = new EntryTable(class40_sub1);
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("mc.<init>(" + (arg0 != null ? "{...}" : "null") + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ',' + arg4 + ')'));
        }
    }

    public static Class40_Sub5_Sub15 method421(Class6 arg0, byte arg1, int arg2, Class6 arg3, boolean arg4) {
        try {
            if(arg1 < 40)
                return null;
            anInt1739++;
            boolean bool = true;
            int[] is = arg0.method192(arg2, true);
            for(int i = 0; (i ^ 0xffffffff) > (is.length ^ 0xffffffff); i++) {
                byte[] is_0_ = arg0.method182(is[i], -114, arg2);
                if(is_0_ == null)
                    bool = false;
                else {
                    int i_1_ = 0xff & is_0_[1] | (0xff & is_0_[0]) << -1471118168;
                    byte[] is_2_;
                    if(arg4)
                        is_2_ = arg3.method182(i_1_, -122, 0);
                    else
                        is_2_ = arg3.method182(0, -123, i_1_);
                    if(is_2_ == null)
                        bool = false;
                }
            }
            if(!bool)
                return null;
            try {
                return new Class40_Sub5_Sub15(arg0, arg3, arg2, arg4);
            } catch(Exception exception) {
                return null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("mc.I(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ',' + (arg3 != null ? "{...}" : "null") + ',' + arg4 + ')'));
        }
    }

    public static void method423(byte arg0) {
        try {
            if(arg0 <= -18) {
                aClass1_1720 = null;
                aByteArrayArrayArray1745 = null;
                aClass1_1725 = null;
                aClass1_1746 = null;
                aFrame1732 = null;
                anIntArray1738 = null;
                aClass1_1743 = null;
                aClass1_1736 = null;
                aClass40_Sub5_Sub14_Sub2_1744 = null;
                aClass1_1747 = null;
                aClass1_1726 = null;
                aClass1_1731 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.F(" + arg0 + ')');
        }
    }

    public void method422(int arg0) {
        try {
            anInt1723++;
            for(int i = arg0; ((aClass40_Sub10Array1740.length ^ 0xffffffff) < (i ^ 0xffffffff)); i++) {
                if(aClass40_Sub10Array1740[i] != null)
                    aClass40_Sub10Array1740[i].method870();
            }
            aClass45_1727 = new Class45();
            anInt1753 = anInt1752;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.D(" + arg0 + ')');
        }
    }

    public int[] method12(int arg0, int arg1) {
        try {
            anInt1742++;
            EntryTable class40_sub10 = aClass40_Sub10Array1740[arg1];
            int i = -68 / ((-75 - arg0) / 33);
            if(class40_sub10 != null) {
                if(class40_sub10.anIntArray2139 != null) {
                    aClass45_1727.method905(0, class40_sub10);
                    class40_sub10.aBoolean2146 = true;
                    return class40_sub10.anIntArray2139;
                }
                boolean bool = class40_sub10.method869(aDouble1750, anInt1748, aClass6_1749);
                if(bool) {
                    if((anInt1753 ^ 0xffffffff) == -1) {
                        EntryTable class40_sub10_3_ = ((EntryTable) aClass45_1727.method899((byte) 87));
                        class40_sub10_3_.method870();
                    } else
                        anInt1753--;
                    aClass45_1727.method905(0, class40_sub10);
                    class40_sub10.aBoolean2146 = true;
                    return class40_sub10.anIntArray2139;
                }
            }
            return null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.A(" + arg0 + ',' + arg1 + ')');
        }
    }

    public int method14(boolean arg0, int arg1) {
        try {
            anInt1724++;
            if(arg0 != true)
                return 115;
            if(aClass40_Sub10Array1740[arg1] != null)
                return aClass40_Sub10Array1740[arg1].anInt2137;
            return 0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.H(" + arg0 + ',' + arg1 + ')');
        }
    }

    public boolean method13(byte arg0, int arg1) {
        try {
            anInt1729++;
            if(arg0 > -99)
                return true;
            return aClass40_Sub10Array1740[arg1].aBoolean2143;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.E(" + arg0 + ',' + arg1 + ')');
        }
    }

    public void method424(int arg0, double arg1) {
        try {
            anInt1722++;
            if(arg0 < 68)
                aClass1_1731 = null;
            aDouble1750 = arg1;
            method422(0);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.B(" + arg0 + ',' + arg1 + ')');
        }
    }

    public void method425(byte arg0, int arg1) {
        try {
            anInt1751++;
            int i = 0;
            if(arg0 == 6) {
                for(/**/; (i ^ 0xffffffff) > (aClass40_Sub10Array1740.length ^ 0xffffffff); i++) {
                    EntryTable class40_sub10 = aClass40_Sub10Array1740[i];
                    if(class40_sub10 != null && (class40_sub10.anInt2136 ^ 0xffffffff) != -1 && class40_sub10.aBoolean2146) {
                        class40_sub10.method868(arg1);
                        class40_sub10.aBoolean2146 = false;
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.C(" + arg0 + ',' + arg1 + ')');
        }
    }

    public boolean method15(int arg0, byte arg1) {
        try {
            anInt1721++;
            if(arg1 != -90)
                return false;
            return anInt1748 == 64;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "mc.G(" + arg0 + ',' + arg1 + ')');
        }
    }
}
