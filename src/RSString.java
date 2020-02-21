/* Class1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.nio.charset.StandardCharsets;

public class RSString implements Interface1 {
    public static int anInt1655;
    public static int anInt1656;
    public static int anInt1657;
    public static int anInt1658;
    public static int anInt1659;
    public static int anInt1660;
    public static int anInt1661;
    public static int anInt1662;
    public static int anInt1663;
    public static int anInt1664;
    public static Class68 aClass68_1665;
    public static int anInt1666;
    public static int anInt1667;
    public static int anInt1668 = 0;
    public static int anInt1669;
    public static int anInt1670;
    public static int anInt1671;
    public static int anInt1672;
    public static int anInt1673;
    public static int anInt1674;
    public static int anInt1676;
    public static RSString aClass1_1677;
    public static int anInt1678;
    public static int anInt1679;
    public static int anInt1681;
    public static int anInt1682;
    public static int anInt1683;
    public static Cache aClass9_1684;
    public static int anInt1685;
    public static int anInt1686;
    public static int anInt1687;
    public static int anInt1688;
    public static int anInt1689;
    public static int anInt1690;
    public static int anInt1693;
    public static int anInt1694;
    public static int anInt1695;
    public static int anInt1697;
    public static int anInt1698;
    public static RSString aClass1_1699;
    public static int anInt1700;
    public static int anInt1701;
    public static RSString aClass1_1702;
    public static RSString aClass1_1703;
    public static int anInt1704;
    public static Class6 aClass6_1705;
    public static int[] anIntArray1706;
    public static int anInt1707;
    public static int anInt1708;
    public static int anInt1709;
    public static int anInt1710;
    public static int anInt1711;
    public static int anInt1712;
    public static RSString aClass1_1713;
    public static int anInt1714;
    public static byte[][] aByteArrayArray1715;
    public static RSString aClass1_1716;
    public static RSString aClass1_1717;
    /*synthetic*/ public static Class aClass1718;
    public static RSString aClass1_1691 = Class58.method978("Private chat");

    static {
        anInt1690 = 0;
        aClass1_1677 = Class58.method978("scrollbar");
        aClass1_1699 = Class58.method978("purple:");
        aClass1_1703 = aClass1_1691;
        aClass1_1702 = Class58.method978("Der Anmelde)2Server ist offline)3");
        aClass1_1716 = Class58.method978("chatback");
        anInt1711 = 50;
        aClass1_1717 = aClass1_1699;
        aClass1_1713 = Class58.method978("Diese Welt ist voll)3");
        anIntArray1706 = new int[128];
    }

    public boolean aBoolean1675 = true;
    public int anInt1680;
    public byte[] aByteArray1692;
    public int anInt1696;
    public String str;

    public static void method56(int arg0, boolean arg1, byte[] arg2, int arg3) {
        anInt1679++;
        if(arg0 == 2037 && Class5.aClass22_189 != null) {
            if(Class62.anInt1450 >= 0) {
                Class5.aClass22_189.method303((byte) -96);
                Class39.anInt909 = 0;
                Player.aByteArray3270 = null;
                RSCanvas.anInt54 = 20;
                Class62.anInt1450 = -1;
            }
            if(arg2 != null) {
                if((RSCanvas.anInt54 ^ 0xffffffff) < -1) {
                    Class5.aClass22_189.method301(arg3, 0);
                    RSCanvas.anInt54 = 0;
                }
                Class62.anInt1450 = arg3;
                Class5.aClass22_189.method300(arg2, arg1, -15910, arg3);
            }
        }
    }

    public static void method71(int arg0) {
        try {
            Class4.anInt182 = 0;
            int i = (((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3098) >> 2067257703) - -Class40_Sub5_Sub2.anInt2307);
            int i_10_ = (Class26.anInt635 + ((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3089) >> 1064414503));
            if((i ^ 0xffffffff) <= -3054 && i <= 3156 && i_10_ >= 3056 && i_10_ <= 3136)
                Class4.anInt182 = 1;
            anInt1698++;
            if(i >= 3072 && (i ^ 0xffffffff) >= -3119 && (i_10_ ^ 0xffffffff) <= -9493 && (i_10_ ^ 0xffffffff) >= -9536)
                Class4.anInt182 = 1;
            if((Class4.anInt182 ^ 0xffffffff) == -2 && (i ^ 0xffffffff) <= -3140 && i <= 3199 && i_10_ >= 3008 && (i_10_ ^ 0xffffffff) >= -3063)
                Class4.anInt182 = 0;
            int i_11_ = 74 / ((arg0 - 42) / 38);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.GA(" + arg0 + ')');
        }
    }

    public static byte[] method74(int arg0, Class6 arg1, int arg2, int arg3, int arg4) {
        try {
            anInt1686++;
            if(arg3 >= -98)
                method83((byte) -1);
            long l = ((long) (arg0 + 37 * arg2 & 0xffff) + ((long) arg4 << -1686849184) - -(long) (arg2 << -1491383504));
            if(aClass9_1684 != null) {
                Class40_Sub5_Sub6 class40_sub5_sub6 = (Class40_Sub5_Sub6) aClass9_1684.method231(l, (byte) 85);
                if(class40_sub5_sub6 != null)
                    return class40_sub5_sub6.aByteArray2441;
            }
            byte[] is = arg1.method172(arg0, 112, arg2);
            if(is == null)
                return null;
            if(aClass9_1684 != null)
                aClass9_1684.method230(-7208, l, new Class40_Sub5_Sub6(is));
            return is;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.O(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ',' + arg4 + ')'));
        }
    }

    public static void method83(byte arg0) {
        try {
            aClass9_1684 = null;
            aClass1_1713 = null;
            aByteArrayArray1715 = null;
            aClass1_1677 = null;
            aClass6_1705 = null;
            aClass1_1702 = null;
            aClass1_1717 = null;
            if(arg0 < 111)
                aByteArrayArray1715 = null;
            aClass68_1665 = null;
            aClass1_1699 = null;
            aClass1_1716 = null;
            aClass1_1691 = null;
            aClass1_1703 = null;
            anIntArray1706 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.K(" + arg0 + ')');
        }
    }

    /*synthetic*/
    public static Class method90(String arg0) {
        try {
            return Class.forName(arg0);
        } catch(ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public RSString method50(byte arg0, int arg1) {
        try {
            anInt1658++;
            if(arg0 != 95)
                anInt1690 = 126;
            return method68(arg0 + -95, arg1, anInt1680);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.PA(" + arg0 + ',' + arg1 + ')');
        }
    }

    public int method51(int arg0, int arg1, byte[] arg2, int arg3, int arg4) {
        try {
            Class18.method278(aByteArray1692, arg0, arg2, arg3, arg1 - arg0);
            if(arg4 != -40)
                method78(68, -2);
            anInt1674++;
            return -arg0 + arg1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.I(" + arg0 + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ',' + arg3 + ',' + arg4 + ')'));
        }
    }

    public int method52(byte arg0) {
        try {
            anInt1695++;
            if(arg0 != -34)
                aClass1_1691 = null;
            return method88(false, 10);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.T(" + arg0 + ')');
        }
    }

    public RSString method53(int arg0) {
        try {
            anInt1662++;
            RSString class1 = new RSString();
            class1.anInt1680 = anInt1680;
            class1.aByteArray1692 = new byte[anInt1680];
            boolean bool = true;
            if(arg0 != -16315)
                method89(false);
            for(int i = 0; i < anInt1680; i++) {
                byte i_0_ = aByteArray1692[i];
                if((i_0_ ^ 0xffffffff) <= -98 && (i_0_ ^ 0xffffffff) >= -123 || i_0_ >= -32 && i_0_ <= -2 && (i_0_ ^ 0xffffffff) != 8) {
                    if(bool)
                        i_0_ -= 32;
                    bool = false;
                } else if((i_0_ ^ 0xffffffff) <= -66 && i_0_ <= 90 || ((i_0_ ^ 0xffffffff) <= 63 && i_0_ <= -34 && i_0_ != -41)) {
                    if(!bool)
                        i_0_ += 32;
                    bool = false;
                }
                class1.aByteArray1692[i] = i_0_;
                if((i_0_ ^ 0xffffffff) == -47 || i_0_ == 33 || i_0_ == 63)
                    bool = true;
            }
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.V(" + arg0 + ')');
        }
    }

    public boolean method54(RSString arg0, int arg1) {
        try {
            anInt1707++;
            if(arg0 == null)
                return false;
            if((anInt1680 ^ 0xffffffff) != (arg0.anInt1680 ^ 0xffffffff))
                return false;
            if(arg1 != 122)
                anInt1690 = -114;
            if(!aBoolean1675 || !arg0.aBoolean1675) {
                if((anInt1696 ^ 0xffffffff) == -1) {
                    anInt1696 = method76((byte) 41);
                    if((anInt1696 ^ 0xffffffff) == -1)
                        anInt1696 = 1;
                }
                if((arg0.anInt1696 ^ 0xffffffff) == -1) {
                    arg0.anInt1696 = arg0.method76((byte) 41);
                    if(arg0.anInt1696 == 0)
                        arg0.anInt1696 = 1;
                }
                if(arg0.anInt1696 != anInt1696)
                    return false;
            }
            for(int i = 0; (i ^ 0xffffffff) > (anInt1680 ^ 0xffffffff); i++) {
                if(aByteArray1692[i] != arg0.aByteArray1692[i])
                    return false;
            }
            return true;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.MA(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public int method55(int arg0, boolean arg1) {
        try {
            anInt1667++;
            if(arg1 != false)
                method80(-9);
            return 0xff & aByteArray1692[arg0];
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.OA(" + arg0 + ',' + arg1 + ')');
        }
    }

    public int method57(byte arg0, int arg1) {
        try {
            anInt1700++;
            if(arg0 != -5)
                return -56;
            return method64(0, arg1, true);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.LA(" + arg0 + ',' + arg1 + ')');
        }
    }

    public long method58(byte arg0) {
        try {
            anInt1678++;
            long l = 0L;
            for(int i = 0; (anInt1680 ^ 0xffffffff) < (i ^ 0xffffffff); i++) {
                if((i ^ 0xffffffff) <= -13)
                    break;
                l *= 37L;
                int i_1_ = aByteArray1692[i];
                if(i_1_ >= 65 && i_1_ <= 90)
                    l += (long) (i_1_ + 1 + -65);
                else if(i_1_ >= 97 && i_1_ <= 122)
                    l += (long) (1 + (i_1_ + -97));
                else if(i_1_ >= 48 && i_1_ <= 57)
                    l += (long) (27 - (-i_1_ - -48));
            }
            for(/**/; ((l % 37L ^ 0xffffffffffffffffL) == -1L && (l ^ 0xffffffffffffffffL) != -1L); l /= 37L) {
                /* empty */
            }
            if(arg0 < 88)
                method89(true);
            return l;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.P(" + arg0 + ')');
        }
    }

    public int method59(int arg0) {
        try {
            if(arg0 != -3136)
                return -11;
            anInt1693++;
            return anInt1680;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.J(" + arg0 + ')');
        }
    }

    public int method60(RSString arg0, int arg1) {
        try {
            if(arg1 != 32)
                return 110;
            anInt1657++;
            return method81(arg0, 0, true);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.H(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public RSString method61(boolean arg0) {
        try {
            RSString class1 = new RSString();
            anInt1710++;
            class1.anInt1680 = anInt1680;
            class1.aByteArray1692 = new byte[anInt1680];
            int i = 0;
            if(arg0 != false)
                aClass1_1713 = null;
            for(/**/; (anInt1680 ^ 0xffffffff) < (i ^ 0xffffffff); i++)
                class1.aByteArray1692[i] = (byte) 42;
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.C(" + arg0 + ')');
        }
    }

    public RSString method62(int arg0) {
        try {
            anInt1676++;
            RSString class1 = new RSString();
            if(arg0 != 57)
                method75((byte) 100, null);
            class1.anInt1680 = 0;
            int i = 0;
            class1.aByteArray1692 = new byte[12];
            for(int i_2_ = 0; (i_2_ ^ 0xffffffff) > (anInt1680 ^ 0xffffffff); i_2_++) {
                if(aByteArray1692[i_2_] >= 65 && (aByteArray1692[i_2_] ^ 0xffffffff) >= -91) {
                    class1.aByteArray1692[i++] = (byte) (-65 + aByteArray1692[i_2_] + 97);
                    class1.anInt1680 = i;
                } else if((aByteArray1692[i_2_] >= 97 && (aByteArray1692[i_2_] ^ 0xffffffff) >= -123) || (aByteArray1692[i_2_] >= 48 && aByteArray1692[i_2_] <= 57)) {
                    class1.aByteArray1692[i++] = aByteArray1692[i_2_];
                    class1.anInt1680 = i;
                } else if(i > 0)
                    class1.aByteArray1692[i++] = (byte) 95;
                if((i ^ 0xffffffff) == -13)
                    break;
            }
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.EA(" + arg0 + ')');
        }
    }

    public boolean method63(RSString arg0, boolean arg1) {
        try {
            anInt1712++;
            if(arg1 != true)
                aClass1_1713 = null;
            if(arg0 == null)
                return false;
            if(arg0.anInt1680 != anInt1680)
                return false;
            for(int i = 0; (i ^ 0xffffffff) > (anInt1680 ^ 0xffffffff); i++) {
                byte i_3_ = arg0.aByteArray1692[i];
                byte i_4_ = aByteArray1692[i];
                if((i_3_ ^ 0xffffffff) <= -66 && i_3_ <= 90 || ((i_3_ ^ 0xffffffff) <= 63 && (i_3_ ^ 0xffffffff) >= 33 && i_3_ != -41))
                    i_3_ += 32;
                if((i_4_ ^ 0xffffffff) <= -66 && (i_4_ ^ 0xffffffff) >= -91 || (i_4_ >= -64 && (i_4_ ^ 0xffffffff) >= 33 && (i_4_ ^ 0xffffffff) != 40))
                    i_4_ += 32;
                if((i_3_ ^ 0xffffffff) != (i_4_ ^ 0xffffffff))
                    return false;
            }
            return true;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.DA(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public int method64(int arg0, int arg1, boolean arg2) {
        try {
            anInt1689++;
            byte i = (byte) arg1;
            for(int i_5_ = arg0; i_5_ < anInt1680; i_5_++) {
                if((i ^ 0xffffffff) == (aByteArray1692[i_5_] ^ 0xffffffff))
                    return i_5_;
            }
            if(arg2 != true)
                aClass1_1703 = null;
            return -1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.AA(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public void method65(int arg1, int arg2, Graphics arg3) {
        String string;
        string = new String(aByteArray1692, 0, anInt1680, StandardCharsets.ISO_8859_1);
        anInt1660++;
        arg3.drawString(string, arg1, arg2);
    }

    public RSString method66() {
        long l = method86(1544463557);
        anInt1681++;
        synchronized(aClass1718 != null ? aClass1718 : (aClass1718 = method90("RSString"))) {
            if(Class34.aClass23_805 != null) {
                for(Class40_Sub7 class40_sub7 = ((Class40_Sub7) Class34.aClass23_805.method331(l, 6120)); class40_sub7 != null; class40_sub7 = (Class40_Sub7) Class34.aClass23_805.method333()) {
                    if(method54(class40_sub7.aClass1_2124, 122))
                        return class40_sub7.aClass1_2124;
                }
            } else
                Class34.aClass23_805 = new HashTable(4096);
            Class40_Sub7 class40_sub7 = new Class40_Sub7();
            aBoolean1675 = false;
            class40_sub7.aClass1_2124 = this;
            Class34.aClass23_805.put(class40_sub7, (byte) -117, l);
        }
        return this;

    }

    public int hashCode() {
        try {
            anInt1669++;
            return method76((byte) 41);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.hashCode(" + ')');
        }
    }

    public boolean method67(int arg0, int arg1) {
        try {
            if((arg1 ^ 0xffffffff) > -2 || arg1 > 36)
                arg1 = 10;
            if(arg0 != 90)
                method64(112, 37, true);
            boolean bool = false;
            anInt1704++;
            boolean bool_6_ = false;
            int i = 0;
            for(int i_7_ = 0; anInt1680 > i_7_; i_7_++) {
                int i_8_ = 0xff & aByteArray1692[i_7_];
                if(i_7_ == 0) {
                    if((i_8_ ^ 0xffffffff) == -46) {
                        bool = true;
                        continue;
                    }
                    if((i_8_ ^ 0xffffffff) == -44)
                        continue;
                }
                if((i_8_ ^ 0xffffffff) > -49 || (i_8_ ^ 0xffffffff) < -58) {
                    if((i_8_ ^ 0xffffffff) <= -66 && (i_8_ ^ 0xffffffff) >= -91)
                        i_8_ -= 55;
                    else {
                        if((i_8_ ^ 0xffffffff) > -98 || i_8_ > 122)
                            return false;
                        i_8_ -= 87;
                    }
                } else
                    i_8_ -= 48;
                if((arg1 ^ 0xffffffff) >= (i_8_ ^ 0xffffffff))
                    return false;
                if(bool)
                    i_8_ = -i_8_;
                int i_9_ = i_8_ + arg1 * i;
                if(i_9_ / arg1 != i)
                    return false;
                i = i_9_;
                bool_6_ = true;
            }
            return bool_6_;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.QA(" + arg0 + ',' + arg1 + ')');
        }
    }

    public RSString method68(int arg0, int arg1, int arg2) {
        try {
            anInt1683++;
            if(arg0 != 0)
                return null;
            RSString class1 = new RSString();
            class1.aByteArray1692 = new byte[-arg1 + arg2];
            class1.anInt1680 = -arg1 + arg2;
            Class18.method278(aByteArray1692, arg1, class1.aByteArray1692, 0, class1.anInt1680);
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.R(" + arg0 + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public RSString method69(RSString arg0, int arg1, int arg2) {
        try {
            anInt1663++;
            if(!aBoolean1675)
                throw new IllegalArgumentException();
            if(arg1 != 16039)
                method58((byte) -74);
            if(arg2 > anInt1680)
                throw new IllegalArgumentException();
            anInt1696 = 0;
            if(arg0.anInt1680 + arg2 > aByteArray1692.length) {
                int i;
                for(i = 1; (i ^ 0xffffffff) > (arg0.anInt1680 + arg2 ^ 0xffffffff); i += i) {
                    /* empty */
                }
                byte[] is = new byte[i];
                Class18.method278(aByteArray1692, 0, is, 0, anInt1680);
                aByteArray1692 = is;
            }
            Class18.method278(arg0.aByteArray1692, 0, aByteArray1692, arg2, arg0.anInt1680);
            if(anInt1680 < arg2 - -arg0.anInt1680)
                anInt1680 = arg0.anInt1680 + arg2;
            return this;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.D(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public RSString method70(int arg0, int arg1) {
        try {
            anInt1701++;
            if(arg0 <= arg1 || arg0 > 255)
                throw new IllegalArgumentException("invalid char");
            RSString class1 = new RSString();
            class1.aByteArray1692 = new byte[anInt1680 - -1];
            class1.anInt1680 = anInt1680 - -1;
            Class18.method278(aByteArray1692, 0, class1.aByteArray1692, 0, anInt1680);
            class1.aByteArray1692[anInt1680] = (byte) arg0;
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.HA(" + arg0 + ',' + arg1 + ')');
        }
    }

    public boolean equals(Object arg0) {
        try {
            anInt1666++;
            throw new RuntimeException();
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.equals(" + (arg0 != null ? "{...}" : "null") + ')');
        }
    }

    public RSString method72(RSString arg0, byte arg1) {
        try {
            anInt1685++;
            if(!aBoolean1675)
                throw new IllegalArgumentException();
            anInt1696 = 0;
            if((anInt1680 - -arg0.anInt1680 ^ 0xffffffff) < (aByteArray1692.length ^ 0xffffffff)) {
                int i;
                for(i = 1; (i ^ 0xffffffff) > (anInt1680 + arg0.anInt1680 ^ 0xffffffff); i += i) {
                    /* empty */
                }
                byte[] is = new byte[i];
                Class18.method278(aByteArray1692, 0, is, 0, anInt1680);
                aByteArray1692 = is;
            }
            Class18.method278(arg0.aByteArray1692, 0, aByteArray1692, anInt1680, arg0.anInt1680);
            anInt1680 += arg0.anInt1680;
            if(arg1 != -87)
                return null;
            return this;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.Q(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public int method73(int arg0, FontMetrics arg1) {
        try {
            String string;
            string = new String(aByteArray1692, 0, anInt1680, StandardCharsets.ISO_8859_1);
            if(arg0 > -6)
                return 68;
            anInt1664++;
            return arg1.stringWidth(string);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.NA(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public boolean method75(byte arg0, RSString arg1) {
        try {
            anInt1709++;
            if(arg1.anInt1680 > anInt1680)
                return false;
            if(arg0 != 116)
                return false;
            for(int i = 0; arg1.anInt1680 > i; i++) {
                if((aByteArray1692[i] ^ 0xffffffff) != (arg1.aByteArray1692[i] ^ 0xffffffff))
                    return false;
            }
            return true;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.FA(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public int method76(byte arg0) {
        try {
            if(arg0 != 41)
                aClass6_1705 = null;
            anInt1671++;
            int i = 0;
            for(int i_12_ = 0; anInt1680 > i_12_; i_12_++)
                i = (0xff & aByteArray1692[i_12_]) + -i + (i << -361727451);
            return i;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.B(" + arg0 + ')');
        }
    }

    public RSString method77(byte arg0) {
        try {
            anInt1708++;
            if(!aBoolean1675)
                throw new IllegalArgumentException();
            anInt1696 = 0;
            int i = 77 % ((arg0 - 32) / 55);
            if(anInt1680 != aByteArray1692.length) {
                byte[] is = new byte[anInt1680];
                Class18.method278(aByteArray1692, 0, is, 0, anInt1680);
                aByteArray1692 = is;
            }
            return this;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.E(" + arg0 + ')');
        }
    }

    public RSString method78(int arg0, int arg1) {
        try {
            anInt1714++;
            if((arg1 ^ 0xffffffff) >= -1 || arg1 > 255)
                throw new IllegalArgumentException("invalid char");
            if(!aBoolean1675)
                throw new IllegalArgumentException();
            anInt1696 = 0;
            if((aByteArray1692.length ^ 0xffffffff) == (anInt1680 ^ 0xffffffff)) {
                int i;
                for(i = 1; i <= anInt1680; i += i) {
                    /* empty */
                }
                byte[] is = new byte[i];
                Class18.method278(aByteArray1692, 0, is, 0, anInt1680);
                aByteArray1692 = is;
            }
            aByteArray1692[anInt1680++] = (byte) arg1;
            if(arg0 > -21)
                return null;
            return this;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.N(" + arg0 + ',' + arg1 + ')');
        }
    }

    public RSString method79(int arg0) {
        try {
            anInt1661++;
            RSString class1 = new RSString();
            class1.anInt1680 = anInt1680;
            class1.aByteArray1692 = new byte[anInt1680];
            for(int i = 0; (i ^ 0xffffffff) > (anInt1680 ^ 0xffffffff); i++) {
                byte i_13_ = aByteArray1692[i];
                if((i_13_ ^ 0xffffffff) <= -66 && i_13_ <= 90 || (i_13_ >= -64 && (i_13_ ^ 0xffffffff) >= 33 && i_13_ != -41))
                    i_13_ += 32;
                class1.aByteArray1692[i] = i_13_;
            }
            if(arg0 >= -127)
                aClass1_1691 = null;
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.U(" + arg0 + ')');
        }
    }

    public byte[] method80(int arg0) {
        try {
            if(arg0 != 0)
                method69(null, -108, -121);
            byte[] is = new byte[anInt1680];
            Class18.method278(aByteArray1692, 0, is, 0, anInt1680);
            anInt1688++;
            return is;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.L(" + arg0 + ')');
        }
    }

    public int method81(RSString arg0, int arg1, boolean arg2) {
        try {
            anInt1682++;
            int[] is = new int[arg0.anInt1680];
            int[] is_14_ = new int[arg0.anInt1680];
            int[] is_15_ = new int[256];
            for(int i = 0; (i ^ 0xffffffff) > (is_15_.length ^ 0xffffffff); i++)
                is_15_[i] = arg0.anInt1680;
            if(arg2 != true)
                aClass1_1691 = null;
            for(int i = 1; (arg0.anInt1680 ^ 0xffffffff) <= (i ^ 0xffffffff); i++) {
                is[-1 + i] = (arg0.anInt1680 << 828194177) - i;
                is_15_[Class66.method1021(arg0.aByteArray1692[-1 + i], 255)] = arg0.anInt1680 - i;
            }
            int i = 1 + arg0.anInt1680;
            for(int i_16_ = arg0.anInt1680; i_16_ > 0; i_16_--) {
                is_14_[i_16_ - 1] = i;
                for(/**/; ((arg0.anInt1680 ^ 0xffffffff) <= (i ^ 0xffffffff) && (arg0.aByteArray1692[i - 1] != arg0.aByteArray1692[-1 + i_16_])); i = is_14_[-1 + i]) {
                    if((-i_16_ + arg0.anInt1680 ^ 0xffffffff) >= (is[i - 1] ^ 0xffffffff))
                        is[i - 1] = -i_16_ + arg0.anInt1680;
                }
                i--;
            }
            int i_17_ = i;
            i = 1 + (arg0.anInt1680 - i_17_);
            int i_18_ = 1;
            int i_19_ = 0;
            for(int i_20_ = 1; i_20_ <= i; i_20_++) {
                is_14_[i_20_ - 1] = i_19_;
                for(/**/; i_19_ >= 1 && (arg0.aByteArray1692[-1 + i_20_] != arg0.aByteArray1692[-1 + i_19_]); i_19_ = is_14_[-1 + i_19_]) {
                    /* empty */
                }
                i_19_++;
            }
            while(i_17_ < arg0.anInt1680) {
                for(int i_21_ = i_18_; i_17_ >= i_21_; i_21_++) {
                    if((-i_21_ + i_17_ + arg0.anInt1680 ^ 0xffffffff) >= (is[i_21_ + -1] ^ 0xffffffff))
                        is[i_21_ + -1] = -i_21_ + arg0.anInt1680 - -i_17_;
                }
                i_18_ = 1 + i_17_;
                i_17_ = -is_14_[-1 + i] + (i + i_17_);
                i = is_14_[i - 1];
            }
            int i_22_;
            for(int i_23_ = -1 + (arg1 + arg0.anInt1680); i_23_ < anInt1680; i_23_ += Math.max(is_15_[aByteArray1692[i_23_] & 0xff], is[i_22_])) {
                for(i_22_ = arg0.anInt1680 + -1; i_22_ >= 0 && ((arg0.aByteArray1692[i_22_] ^ 0xffffffff) == (aByteArray1692[i_23_] ^ 0xffffffff)); i_22_--)
                    i_23_--;
                if((i_22_ ^ 0xffffffff) == 0)
                    return 1 + i_23_;
            }
            return -1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.M(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public boolean method82(int arg0) {
        try {
            if(arg0 < 101)
                anInt1668 = 12;
            anInt1697++;
            return method67(90, 10);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.IA(" + arg0 + ')');
        }
    }

    public String toString() {
        try {
            anInt1672++;
            throw new RuntimeException();
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.toString(" + ')');
        }
    }

    public int method84(RSString arg0, byte arg1) {
        try {
            int i;
            if(arg0.anInt1680 >= anInt1680)
                i = anInt1680;
            else
                i = arg0.anInt1680;
            anInt1687++;
            for(int i_24_ = 0; (i ^ 0xffffffff) < (i_24_ ^ 0xffffffff); i_24_++) {
                if((arg0.aByteArray1692[i_24_] ^ 0xffffffff) < (aByteArray1692[i_24_] ^ 0xffffffff))
                    return -1;
                if((aByteArray1692[i_24_] ^ 0xffffffff) < (arg0.aByteArray1692[i_24_] ^ 0xffffffff))
                    return 1;
            }
            if(arg1 < 75)
                method78(8, -101);
            if((anInt1680 ^ 0xffffffff) > (arg0.anInt1680 ^ 0xffffffff))
                return -1;
            if((arg0.anInt1680 ^ 0xffffffff) > (anInt1680 ^ 0xffffffff))
                return 1;
            return 0;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.CA(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ')'));
        }
    }

    public RSString method85(int arg0) {
        try {
            anInt1656++;
            boolean bool = true;
            RSString class1 = new RSString();
            class1.anInt1680 = anInt1680;
            class1.aByteArray1692 = new byte[anInt1680];
            if(arg0 != -4305)
                anIntArray1706 = null;
            for(int i = 0; (anInt1680 ^ 0xffffffff) < (i ^ 0xffffffff); i++) {
                byte i_25_ = aByteArray1692[i];
                if((i_25_ ^ 0xffffffff) == -96) {
                    class1.aByteArray1692[i] = (byte) 32;
                    bool = true;
                } else if(i_25_ < 97 || (i_25_ ^ 0xffffffff) < -123 || !bool) {
                    class1.aByteArray1692[i] = i_25_;
                    bool = false;
                } else {
                    bool = false;
                    class1.aByteArray1692[i] = (byte) (i_25_ - 32);
                }
            }
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.BA(" + arg0 + ')');
        }
    }

    public long method86(int arg0) {
        try {
            anInt1694++;
            long l = 0L;
            if(arg0 != 1544463557)
                aByteArrayArray1715 = null;
            for(int i = 0; (i ^ 0xffffffff) > (anInt1680 ^ 0xffffffff); i++)
                l = -l + (l << 1544463557) - -(long) (0xff & aByteArray1692[i]);
            return l;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.KA(" + arg0 + ')');
        }
    }

    public boolean method87(int arg0, RSString arg1) {
        try {
            anInt1655++;
            if((arg1.anInt1680 ^ 0xffffffff) < (anInt1680 ^ 0xffffffff))
                return false;
            if(arg0 <= 62)
                method82(-116);
            int i = anInt1680 + -arg1.anInt1680;
            for(int i_26_ = 0; arg1.anInt1680 > i_26_; i_26_++) {
                if(aByteArray1692[i_26_ + i] != arg1.aByteArray1692[i_26_])
                    return false;
            }
            return true;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("a.A(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public int method88(boolean arg0, int arg1) {
        try {
            if((arg1 ^ 0xffffffff) > -2 || arg1 > 36)
                arg1 = 10;
            boolean bool = false;
            anInt1670++;
            boolean bool_27_ = arg0;
            int i = 0;
            for(int i_28_ = 0; i_28_ < anInt1680; i_28_++) {
                int i_29_ = aByteArray1692[i_28_] & 0xff;
                if(i_28_ == 0) {
                    if(i_29_ == 45) {
                        bool_27_ = true;
                        continue;
                    }
                    if(i_29_ == 43)
                        continue;
                }
                if((i_29_ ^ 0xffffffff) <= -49 && i_29_ <= 57)
                    i_29_ -= 48;
                else if((i_29_ ^ 0xffffffff) <= -66 && (i_29_ ^ 0xffffffff) >= -91)
                    i_29_ -= 55;
                else {
                    if(i_29_ < 97 || (i_29_ ^ 0xffffffff) < -123)
                        throw new NumberFormatException();
                    i_29_ -= 87;
                }
                if(arg1 <= i_29_)
                    throw new NumberFormatException();
                if(bool_27_)
                    i_29_ = -i_29_;
                int i_30_ = i_29_ + i * arg1;
                if(i != i_30_ / arg1)
                    throw new NumberFormatException();
                i = i_30_;
                bool = true;
            }
            if(!bool)
                throw new NumberFormatException();
            return i;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.F(" + arg0 + ',' + arg1 + ')');
        }
    }

    public RSString method89(boolean arg0) {
        try {
            anInt1659++;
            int i = 0;
            int i_31_ = anInt1680;
            for(/**/; ((i ^ 0xffffffff) > (anInt1680 ^ 0xffffffff) && (aByteArray1692[i] >= 0 && aByteArray1692[i] <= 32 || (0xff & aByteArray1692[i]) == 160)); i++) {
                /* empty */
            }
            if(arg0 != false)
                aClass1_1717 = null;
            for(/**/; ((i_31_ ^ 0xffffffff) < (i ^ 0xffffffff) && ((aByteArray1692[i_31_ + -1] >= 0 && aByteArray1692[-1 + i_31_] <= 32) || (aByteArray1692[i_31_ + -1] & 0xff ^ 0xffffffff) == -161)); i_31_--) {
                /* empty */
            }
            if(i == 0 && (i_31_ ^ 0xffffffff) == (anInt1680 ^ 0xffffffff))
                return this;
            RSString class1 = new RSString();
            class1.anInt1680 = i_31_ + -i;
            class1.aByteArray1692 = new byte[class1.anInt1680];
            for(int i_32_ = 0; (class1.anInt1680 ^ 0xffffffff) < (i_32_ ^ 0xffffffff); i_32_++)
                class1.aByteArray1692[i_32_] = aByteArray1692[i + i_32_];
            return class1;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "a.S(" + arg0 + ')');
        }
    }
}
