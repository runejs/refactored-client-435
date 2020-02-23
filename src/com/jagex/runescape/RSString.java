package com.jagex.runescape;

import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;
import java.nio.charset.StandardCharsets;

public class RSString implements Interface1 {
    public static Class68 aClass68_1665;
    public static int anInt1668 = 0;
    public static Cache aClass9_1684;
    public static int anInt1690 = 0;
    public static Class6 aClass6_1705;
    public static int[] anIntArray1706 = new int[128];
    public static int anInt1711 = 50;
    public static byte[][] aByteArrayArray1715;
    public static RSString aClass1_1717 = Class58.method978("purple:");
    /*synthetic*/ public static Class aClass1718;
    public static RSString aClass1_1677 = Class58.method978("scrollbar");
    public static RSString aClass1_1702 = Class58.method978("Der Anmelde)2Server ist offline)3");
    public static RSString aClass1_1703 = Class58.method978("Private chat");
    public static RSString aClass1_1713 = Class58.method978("Diese Welt ist voll)3");
    public static RSString aClass1_1716 = Class58.method978("chatback");
    public boolean aBoolean1675 = true;
    public int length;
    public byte[] chars;
    public int anInt1696;
    public String str;

    public static void method56(int arg0, boolean arg1, byte[] arg2, int arg3) {
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
        Class4.anInt182 = 0;
        int i = (((Class40_Sub5_Sub13.localPlayer.anInt3098) >> 2067257703) + Class40_Sub5_Sub2.anInt2307);
        int i_10_ = (Class26.anInt635 + ((Class40_Sub5_Sub13.localPlayer.anInt3089) >> 1064414503));
        if((i ^ 0xffffffff) <= -3054 && i <= 3156 && i_10_ >= 3056 && i_10_ <= 3136)
            Class4.anInt182 = 1;
        if(i >= 3072 && (i ^ 0xffffffff) >= -3119 && (i_10_ ^ 0xffffffff) <= -9493 && (i_10_ ^ 0xffffffff) >= -9536)
            Class4.anInt182 = 1;
        if((Class4.anInt182 ^ 0xffffffff) == -2 && (i ^ 0xffffffff) <= -3140 && i <= 3199 && i_10_ >= 3008 && (i_10_ ^ 0xffffffff) >= -3063)
            Class4.anInt182 = 0;
        int i_11_ = 74 / ((arg0 - 42) / 38);
    }

    public static byte[] method74(int arg0, Class6 arg1, int arg2, int arg3, int arg4) {
        if(arg3 >= -98)
            method83((byte) -1);
        long l = ((long) (arg0 + 37 * arg2 & 0xffff) + ((long) arg4 << -1686849184) + (long) (arg2 << -1491383504));
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
    }

    public static void method83(byte arg0) {
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
        aClass1_1716 = null;
        aClass1_1703 = null;
        anIntArray1706 = null;
    }

    /*synthetic*/
    public static Class method90(String arg0) {
        try {
            return Class.forName(arg0);
        } catch(ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public RSString substring(int arg1) {
        return substring(arg1, length);
    }

    public int method51(int arg0, int arg1, byte[] arg2, int arg3) {
        Class18.method278(chars, arg0, arg2, arg3, arg1 - arg0);
        return -arg0 + arg1;
    }

    public int method52() {
        return method88(false, 10);
    }

    public RSString method53(int arg0) {
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        boolean bool = true;
        if(arg0 != -16315)
            method89(false);
        for(int i = 0; i < length; i++) {
            byte i_0_ = chars[i];
            if((i_0_ ^ 0xffffffff) <= -98 && (i_0_ ^ 0xffffffff) >= -123 || i_0_ >= -32 && i_0_ <= -2 && (i_0_ ^ 0xffffffff) != 8) {
                if(bool)
                    i_0_ -= 32;
                bool = false;
            } else if((i_0_ ^ 0xffffffff) <= -66 && i_0_ <= 90 || ((i_0_ ^ 0xffffffff) <= 63 && i_0_ <= -34 && i_0_ != -41)) {
                if(!bool)
                    i_0_ += 32;
                bool = false;
            }
            class1.chars[i] = i_0_;
            if((i_0_ ^ 0xffffffff) == -47 || i_0_ == 33 || i_0_ == 63)
                bool = true;
        }
        return class1;
    }

    public boolean equals(RSString str) {
        if(str == null)
            return false;
        if(str.length != length)
            return false;
        if(!aBoolean1675 || !str.aBoolean1675) {
            if((anInt1696 ^ 0xffffffff) == -1) {
                anInt1696 = method76();
                if((anInt1696 ^ 0xffffffff) == -1)
                    anInt1696 = 1;
            }
            if((str.anInt1696 ^ 0xffffffff) == -1) {
                str.anInt1696 = str.method76();
                if(str.anInt1696 == 0)
                    str.anInt1696 = 1;
            }
            if(str.anInt1696 != anInt1696)
                return false;
        }
        for(int i = 0; length > i; i++) {
            if(chars[i] != str.chars[i])
                return false;
        }
        return true;
    }

    public int method55(int arg0, boolean arg1) {
        if(arg1 != false)
            method80(-9);
        return 0xff & chars[arg0];
    }

    public int method57(byte arg0, int arg1) {
        if(arg0 != -5)
            return -56;
        return method64(0, arg1, true);
    }

    public long method58(byte arg0) {
        long l = 0L;
        for(int i = 0; i < length; i++) {
            if((i ^ 0xffffffff) <= -13)
                break;
            l *= 37L;
            int i_1_ = chars[i];
            if(i_1_ >= 65 && i_1_ <= 90)
                l += (long) (i_1_ + 1 + -65);
            else if(i_1_ >= 97 && i_1_ <= 122)
                l += (long) (1 + (i_1_ + -97));
            else if(i_1_ >= 48 && i_1_ <= 57)
                l += (long) (27 - (-i_1_ + 48));
        }
        for(/**/; ((l % 37L ^ 0xffffffffffffffffL) == -1L && (l ^ 0xffffffffffffffffL) != -1L); l /= 37L) {
            /* empty */
        }
        if(arg0 < 88)
            method89(true);
        return l;
    }

    public int length() {
        return length;
    }

    public int method60(RSString arg0) {
        return method81(arg0, 0, true);
    }

    public RSString method61(boolean arg0) {
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        int i = 0;
        if(arg0 != false)
            aClass1_1713 = null;
        for(/**/; i < length; i++)
            class1.chars[i] = (byte) 42;
        return class1;
    }

    public RSString method62(int arg0) {
        RSString class1 = new RSString();
        if(arg0 != 57)
            startsWith(null);
        class1.length = 0;
        int i = 0;
        class1.chars = new byte[12];
        for(int i_2_ = 0; (i_2_ ^ 0xffffffff) > (length ^ 0xffffffff); i_2_++) {
            if(chars[i_2_] >= 65 && (chars[i_2_] ^ 0xffffffff) >= -91) {
                class1.chars[i++] = (byte) (-65 + chars[i_2_] + 97);
                class1.length = i;
            } else if((chars[i_2_] >= 97 && (chars[i_2_] ^ 0xffffffff) >= -123) || (chars[i_2_] >= 48 && chars[i_2_] <= 57)) {
                class1.chars[i++] = chars[i_2_];
                class1.length = i;
            } else if(i > 0)
                class1.chars[i++] = (byte) 95;
            if((i ^ 0xffffffff) == -13)
                break;
        }
        return class1;
    }

    public boolean equalsIgnoreCase(RSString arg0, boolean arg1) {
        if(arg1 != true)
            aClass1_1713 = null;
        if(arg0 == null)
            return false;
        if(arg0.length != length)
            return false;
        for(int i = 0; length > i; i++) {
            byte i_3_ = arg0.chars[i];
            byte i_4_ = chars[i];
            if((i_3_ ^ 0xffffffff) <= -66 && i_3_ <= 90 || ((i_3_ ^ 0xffffffff) <= 63 && (i_3_ ^ 0xffffffff) >= 33 && i_3_ != -41))
                i_3_ += 32;
            if((i_4_ ^ 0xffffffff) <= -66 && (i_4_ ^ 0xffffffff) >= -91 || (i_4_ >= -64 && (i_4_ ^ 0xffffffff) >= 33 && (i_4_ ^ 0xffffffff) != 40))
                i_4_ += 32;
            if((i_3_ ^ 0xffffffff) != (i_4_ ^ 0xffffffff))
                return false;
        }
        return true;
    }

    public int method64(int arg0, int arg1, boolean arg2) {
        byte i = (byte) arg1;
        for(int i_5_ = arg0; i_5_ < length; i_5_++) {
            if((i ^ 0xffffffff) == (chars[i_5_] ^ 0xffffffff))
                return i_5_;
        }
        if(arg2 != true)
            aClass1_1703 = null;
        return -1;
    }

    public void method65(int arg1, int arg2, Graphics arg3) {
        String string;
        string = new String(chars, 0, length, StandardCharsets.ISO_8859_1);
        arg3.drawString(string, arg1, arg2);
    }

    public RSString method66() {
        long l = method86(1544463557);
        synchronized(aClass1718 != null ? aClass1718 : (aClass1718 = method90("com.jagex.runescape.RSString"))) {
            if(Class34.aClass23_805 != null) {
                for(Class40_Sub7 class40_sub7 = ((Class40_Sub7) Class34.aClass23_805.method331(l, 6120)); class40_sub7 != null; class40_sub7 = (Class40_Sub7) Class34.aClass23_805.method333()) {
                    if(equals(class40_sub7.aClass1_2124))
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
        return method76();
    }

    public boolean method67(int arg0, int arg1) {
        if((arg1 ^ 0xffffffff) > -2 || arg1 > 36)
            arg1 = 10;
        if(arg0 != 90)
            method64(112, 37, true);
        boolean bool = false;
        boolean bool_6_ = false;
        int i = 0;
        for(int i_7_ = 0; length > i_7_; i_7_++) {
            int i_8_ = 0xff & chars[i_7_];
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
    }

    public RSString substring(int arg1, int arg2) {
        RSString class1 = new RSString();
        class1.chars = new byte[-arg1 + arg2];
        class1.length = -arg1 + arg2;
        Class18.method278(chars, arg1, class1.chars, 0, class1.length);
        return class1;
    }

    public RSString method69(RSString arg0, int arg1, int arg2) {
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        if(arg1 != 16039)
            method58((byte) -74);
        if(arg2 > length)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        if(arg0.length + arg2 > chars.length) {
            int i;
            for(i = 1; (i ^ 0xffffffff) > (arg0.length + arg2 ^ 0xffffffff); i += i) {
                /* empty */
            }
            byte[] is = new byte[i];
            Class18.method278(chars, 0, is, 0, length);
            chars = is;
        }
        Class18.method278(arg0.chars, 0, chars, arg2, arg0.length);
        if(length < arg2 + arg0.length)
            length = arg0.length + arg2;
        return this;
    }

    public RSString method70(int arg0, int arg1) {
        if(arg0 <= arg1 || arg0 > 255)
            throw new IllegalArgumentException("invalid char");
        RSString class1 = new RSString();
        class1.chars = new byte[length + 1];
        class1.length = length + 1;
        Class18.method278(chars, 0, class1.chars, 0, length);
        class1.chars[length] = (byte) arg0;
        return class1;
    }

    public RSString method72(RSString arg0, byte arg1) {
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        if((length + arg0.length ^ 0xffffffff) < (chars.length ^ 0xffffffff)) {
            int i;
            for(i = 1; (i ^ 0xffffffff) > (length + arg0.length ^ 0xffffffff); i += i) {
                /* empty */
            }
            byte[] is = new byte[i];
            Class18.method278(chars, 0, is, 0, length);
            chars = is;
        }
        Class18.method278(arg0.chars, 0, chars, length, arg0.length);
        length += arg0.length;
        if(arg1 != -87)
            return null;
        return this;
    }

    public int method73(FontMetrics arg1) {
        String string;
        string = new String(chars, 0, length, StandardCharsets.ISO_8859_1);
        return arg1.stringWidth(string);
    }

    public boolean startsWith(RSString string) {
        if(string.length > length)
            return false;
        for(int i = 0; string.length > i; i++) {
            if(chars[i] != string.chars[i])
                return false;
        }
        return true;
    }

    public int method76() {
        int i = 0;
        for(int i_12_ = 0; length > i_12_; i_12_++)
            i = (0xff & chars[i_12_]) + -i + (i << -361727451);
        return i;
    }

    public RSString method77(byte arg0) {
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        int i = 77 % ((arg0 - 32) / 55);
        if(length != chars.length) {
            byte[] is = new byte[length];
            Class18.method278(chars, 0, is, 0, length);
            chars = is;
        }
        return this;
    }

    public RSString method78(int arg0, int arg1) {
        if((arg1 ^ 0xffffffff) >= -1 || arg1 > 255)
            throw new IllegalArgumentException("invalid char");
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        if(length == chars.length) {
            int i;
            for(i = 1; i <= length; i += i) {
                /* empty */
            }
            byte[] is = new byte[i];
            Class18.method278(chars, 0, is, 0, length);
            chars = is;
        }
        chars[length++] = (byte) arg1;
        if(arg0 > -21)
            return null;
        return this;
    }

    public RSString method79() {
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        for(int i = 0; length > i; i++) {
            byte i_13_ = chars[i];
            if((i_13_ ^ 0xffffffff) <= -66 && i_13_ <= 90 || (i_13_ >= -64 && (i_13_ ^ 0xffffffff) >= 33 && i_13_ != -41))
                i_13_ += 32;
            class1.chars[i] = i_13_;
        }
        return class1;
    }

    public byte[] method80(int arg0) {
        if(arg0 != 0)
            method69(null, -108, -121);
        byte[] is = new byte[length];
        Class18.method278(chars, 0, is, 0, length);
        return is;
    }

    public int method81(RSString arg0, int arg1, boolean arg2) {
        int[] is = new int[arg0.length];
        int[] is_14_ = new int[arg0.length];
        int[] is_15_ = new int[256];
        for(int i = 0; (i ^ 0xffffffff) > (is_15_.length ^ 0xffffffff); i++)
            is_15_[i] = arg0.length;
        for(int i = 1; i <= arg0.length; i++) {
            is[-1 + i] = (arg0.length << 828194177) - i;
            is_15_[Class66.method1021(arg0.chars[-1 + i], 255)] = arg0.length - i;
        }
        int i = 1 + arg0.length;
        for(int i_16_ = arg0.length; i_16_ > 0; i_16_--) {
            is_14_[i_16_ - 1] = i;
            for(/**/; (i <= arg0.length && (arg0.chars[i - 1] != arg0.chars[-1 + i_16_])); i = is_14_[-1 + i]) {
                if((-i_16_ + arg0.length ^ 0xffffffff) >= (is[i - 1] ^ 0xffffffff))
                    is[i - 1] = -i_16_ + arg0.length;
            }
            i--;
        }
        int i_17_ = i;
        i = 1 + (arg0.length - i_17_);
        int i_18_ = 1;
        int i_19_ = 0;
        for(int i_20_ = 1; i_20_ <= i; i_20_++) {
            is_14_[i_20_ - 1] = i_19_;
            for(/**/; i_19_ >= 1 && (arg0.chars[-1 + i_20_] != arg0.chars[-1 + i_19_]); i_19_ = is_14_[-1 + i_19_]) {
                /* empty */
            }
            i_19_++;
        }
        while(i_17_ < arg0.length) {
            for(int i_21_ = i_18_; i_17_ >= i_21_; i_21_++) {
                if((-i_21_ + i_17_ + arg0.length ^ 0xffffffff) >= (is[i_21_ + -1] ^ 0xffffffff))
                    is[i_21_ + -1] = -i_21_ + arg0.length + i_17_;
            }
            i_18_ = 1 + i_17_;
            i_17_ = -is_14_[-1 + i] + (i + i_17_);
            i = is_14_[i - 1];
        }
        int i_22_;
        for(int i_23_ = -1 + (arg1 + arg0.length); i_23_ < length; i_23_ += Math.max(is_15_[chars[i_23_] & 0xff], is[i_22_])) {
            for(i_22_ = arg0.length + -1; i_22_ >= 0 && ((arg0.chars[i_22_] ^ 0xffffffff) == (chars[i_23_] ^ 0xffffffff)); i_22_--)
                i_23_--;
            if((i_22_ ^ 0xffffffff) == 0)
                return 1 + i_23_;
        }
        return -1;
    }

    public boolean method82(int arg0) {
        if(arg0 < 101)
            anInt1668 = 12;
        return method67(90, 10);
    }

    public String toString() {
        return this.str;
    }

    public int method84(RSString arg0, byte arg1) {
        int i;
        if(arg0.length >= length)
            i = length;
        else
            i = arg0.length;
        for(int i_24_ = 0; (i ^ 0xffffffff) < (i_24_ ^ 0xffffffff); i_24_++) {
            if((arg0.chars[i_24_] ^ 0xffffffff) < (chars[i_24_] ^ 0xffffffff))
                return -1;
            if((chars[i_24_] ^ 0xffffffff) < (arg0.chars[i_24_] ^ 0xffffffff))
                return 1;
        }
        if(arg1 < 75)
            method78(8, -101);
        if(arg0.length > length)
            return -1;
        if(length > arg0.length)
            return 1;
        return 0;
    }

    public RSString method85(int arg0) {
        boolean bool = true;
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        if(arg0 != -4305)
            anIntArray1706 = null;
        for(int i = 0; i < length; i++) {
            byte i_25_ = chars[i];
            if((i_25_ ^ 0xffffffff) == -96) {
                class1.chars[i] = (byte) 32;
                bool = true;
            } else if(i_25_ < 97 || (i_25_ ^ 0xffffffff) < -123 || !bool) {
                class1.chars[i] = i_25_;
                bool = false;
            } else {
                bool = false;
                class1.chars[i] = (byte) (i_25_ - 32);
            }
        }
        return class1;
    }

    public long method86(int arg0) {
        long l = 0L;
        if(arg0 != 1544463557)
            aByteArrayArray1715 = null;
        for(int i = 0; length > i; i++)
            l = -l + (l << 1544463557) + (long) (0xff & chars[i]);
        return l;
    }

    public boolean method87(int arg0, RSString arg1) {
        if(length < arg1.length)
            return false;
        if(arg0 <= 62)
            method82(-116);
        int i = length + -arg1.length;
        for(int i_26_ = 0; arg1.length > i_26_; i_26_++) {
            if(chars[i_26_ + i] != arg1.chars[i_26_])
                return false;
        }
        return true;
    }

    public int method88(boolean arg0, int arg1) {
        if((arg1 ^ 0xffffffff) > -2 || arg1 > 36)
            arg1 = 10;
        boolean bool = false;
        boolean bool_27_ = arg0;
        int i = 0;
        for(int i_28_ = 0; i_28_ < length; i_28_++) {
            int i_29_ = chars[i_28_] & 0xff;
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
    }

    public RSString method89(boolean arg0) {
        int i = 0;
        int i_31_ = length;
        while((length > i && (chars[i] >= 0 && chars[i] <= 32 || (0xff & chars[i]) == 160))) {
            i++;
        }
        if(arg0 != false)
            aClass1_1717 = null;
        while(((i_31_ ^ 0xffffffff) < (i ^ 0xffffffff) && ((chars[i_31_ + -1] >= 0 && chars[-1 + i_31_] <= 32) || (chars[i_31_ + -1] & 0xff ^ 0xffffffff) == -161))) {
            i_31_--;
        }
        if(i == 0 && (i_31_ ^ 0xffffffff) == (length ^ 0xffffffff))
            return this;
        RSString class1 = new RSString();
        class1.length = i_31_ + -i;
        class1.chars = new byte[class1.length];
        for(int i_32_ = 0; (class1.length ^ 0xffffffff) < (i_32_ ^ 0xffffffff); i_32_++)
            class1.chars[i_32_] = chars[i + i_32_];
        return class1;
    }
}
