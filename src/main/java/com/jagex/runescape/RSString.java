package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;
import java.nio.charset.StandardCharsets;

public class RSString implements Interface1 {
    public static Class68 aClass68_1665;
    public static int clickY = 0;
    public static Cache aClass9_1684;
    public static int anInt1690 = 0;
    public static CacheIndex aCacheIndex_1705;
    public static int[] keyCodes = new int[128];
    public static int anInt1711 = 50;
    public static byte[][] terrainData;
    /*synthetic*/ public static Class aClass1718;
    public boolean aBoolean1675 = true;
    public int length;
    public byte[] chars;
    public int anInt1696;

    public static void method56(boolean arg1, byte[] arg2, int arg3) {
        if(Class5.aClass22_189 != null) {
            if(MouseHandler.anInt1450 >= 0) {
                Class5.aClass22_189.method303((byte) -96);
                Class39.anInt909 = 0;
                Player.aByteArray3270 = null;
                RSCanvas.anInt54 = 20;
                MouseHandler.anInt1450 = -1;
            }
            if(arg2 != null) {
                if(RSCanvas.anInt54 > 0) {
                    Class5.aClass22_189.method301(arg3, 0);
                    RSCanvas.anInt54 = 0;
                }
                MouseHandler.anInt1450 = arg3;
                Class5.aClass22_189.method300(arg2, arg1, -15910, arg3);
            }
        }
    }

    public static void setTutorialIslandFlag() {
        Class4.anInt182 = 0;
        int xPos = (((Player.localPlayer.worldX) >> 7) + SpotAnimDefinition.baseX);
        int yPos = (Class26.baseY + ((Player.localPlayer.worldY) >> 7));
        if(xPos >= 3053 && xPos <= 3156 && yPos >= 3056 && yPos <= 3136)
            Class4.anInt182 = 1;
        if(xPos >= 3072 && xPos <= 3118 && yPos >= 9492 && yPos <= 9535)
            Class4.anInt182 = 1;
        if(Class4.anInt182 == 1 && xPos >= 3139 && xPos <= 3199 && yPos >= 3008 && yPos <= 3062)
            Class4.anInt182 = 0;
    }

    public static byte[] method74(int arg0, CacheIndex arg1, int arg2, int arg4) {
        long l = ((long) (arg0 + 37 * arg2 & 0xffff) + ((long) arg4 << 32) + (long) (arg2 << 16));
        if(aClass9_1684 != null) {
            Class40_Sub5_Sub6 class40_sub5_sub6 = (Class40_Sub5_Sub6) aClass9_1684.get(l, (byte) 85);
            if(class40_sub5_sub6 != null)
                return class40_sub5_sub6.aByteArray2441;
        }
        byte[] is = arg1.getFile(arg0, arg2);
        if(is == null)
            return null;
        if(aClass9_1684 != null)
            aClass9_1684.put(l, new Class40_Sub5_Sub6(is));
        return is;
    }

    public static void method83() {
        aClass9_1684 = null;
        terrainData = null;
        Native.scrollbar = null;
        aCacheIndex_1705 = null;
        Native.prefixPurple = null;
        aClass68_1665 = null;
        Native.chatback = null;
        English.privateChat = null;
        keyCodes = null;
    }

    /*synthetic*/
    public static Class method90(String arg0) {
        try {
            return Class.forName(arg0);
        } catch(ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public static RSString CreateString(String arg1) {
        byte[] charBytes = arg1.getBytes();
        int length = charBytes.length;
        RSString class1 = new RSString();
        int index = 0;
        class1.chars = new byte[length];
        while(length > index) {
            int character = 0xff & charBytes[index++];
            if(character <= 45 && character >= 40) {
                if((index >= length))
                    break;
                int next = 0xff & charBytes[index++];
                class1.chars[class1.length++] = (byte) (next + -48 + 43 * (-40 + character));
            } else if(character != 0)
                class1.chars[class1.length++] = (byte) character;
        }
        class1.method77();
        return class1.method66();
    }

    public static RSString createString(int length) {
        RSString string = new RSString();
        string.chars = new byte[length];
        string.length = 0;
        return string;
    }

    public static RSString linkRSStrings(RSString[] arg1) {
        if(arg1.length < 2)
            throw new IllegalArgumentException();
        return method627(arg1.length, 0, arg1);
    }

    public static RSString method627(int arg1, int arg2, RSString[] arg3) {
        int i = 0;
        for(int i_3_ = 0; i_3_ < arg1; i_3_++) {
            if(arg3[arg2 + i_3_] == null) {
                arg3[i_3_ + arg2] = GameShell.aClass1_28;
            }
            i += arg3[i_3_ + arg2].length;
        }
        byte[] is = new byte[i];
        int i_4_ = 0;
        for(int i_5_ = 0; i_5_ < arg1; i_5_++) {
            RSString class1 = arg3[arg2 + i_5_];
            Class18.method278(class1.chars, 0, is, i_4_, class1.length);
            i_4_ += class1.length;
        }
        RSString class1 = new RSString();
        class1.length = i;
        class1.chars = is;
        return class1;
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

    public RSString method53() {
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        boolean bool = true;
        for(int i = 0; i < length; i++) {
            byte i_0_ = chars[i];
            if(i_0_ >= 97 && i_0_ <= 122 || i_0_ >= -32 && i_0_ <= -2 && i_0_ != -9) {
                if(bool)
                    i_0_ -= 32;
                bool = false;
            } else if(i_0_ >= 65 && i_0_ <= 90 || (i_0_ >= -64 && i_0_ <= -34 && i_0_ != -41)) {
                if(!bool)
                    i_0_ += 32;
                bool = false;
            }
            class1.chars[i] = i_0_;
            if(i_0_ == 46 || i_0_ == 33 || i_0_ == 63)
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
            if(anInt1696 == 0) {
                anInt1696 = method76();
                if(anInt1696 == 0)
                    anInt1696 = 1;
            }
            if(str.anInt1696 == 0) {
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

    public int getChar(int arg0) {
        return 0xff & chars[arg0];
    }

    public int indexOf(int arg1) {
        return method64(0, arg1);
    }

    public long method58(byte arg0) {
        long l = 0L;
        for(int i = 0; i < length; i++) {
            if(i >= 12)
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
        for(/**/; (l % 37L == 0 && l != 0); l /= 37L) {
            /* empty */
        }
        if(arg0 < 88)
            trim();
        return l;
    }

    public int length() {
        return length;
    }

    public int contains(RSString arg0) {
        return method81(arg0, 0);
    }

    public RSString method61() {
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        int i = 0;
        for(/**/; i < length; i++)
            class1.chars[i] = (byte) 42;
        return class1;
    }

    public RSString method62() {
        RSString class1 = new RSString();
        class1.length = 0;
        int i = 0;
        class1.chars = new byte[12];
        for(int i_2_ = 0; (i_2_ < length); i_2_++) {
            if(chars[i_2_] >= 65 && chars[i_2_] <= 90) {
                class1.chars[i++] = (byte) (-65 + chars[i_2_] + 97);
                class1.length = i;
            } else if((chars[i_2_] >= 97 && chars[i_2_] <= 122) || (chars[i_2_] >= 48 && chars[i_2_] <= 57)) {
                class1.chars[i++] = chars[i_2_];
                class1.length = i;
            } else if(i > 0)
                class1.chars[i++] = (byte) 95;
            if(i == 12)
                break;
        }
        return class1;
    }

    public boolean equalsIgnoreCase(RSString arg0) {
        if(arg0 == null)
            return false;
        if(arg0.length != length)
            return false;
        for(int i = 0; length > i; i++) {
            byte i_3_ = arg0.chars[i];
            byte i_4_ = chars[i];
            if(i_3_ >= 65 && i_3_ <= 90 || (i_3_ >= -64 && i_3_ <= -34 && i_3_ != -41))
                i_3_ += 32;
            if(i_4_ >= 65 && i_4_ <= 90 || (i_4_ >= -64 && i_4_ <= -34 && i_4_ != -41))
                i_4_ += 32;
            if(i_4_ != i_3_)
                return false;
        }
        return true;
    }

    public int method64(int arg0, int arg1) {
        byte i = (byte) arg1;
        for(int i_5_ = arg0; i_5_ < length; i_5_++) {
            if(chars[i_5_] == i)
                return i_5_;
        }
        return -1;
    }

    public void method65(int arg1, int arg2, Graphics arg3) {
        String string;
        string = new String(chars, 0, length, StandardCharsets.ISO_8859_1);
        arg3.drawString(string, arg1, arg2);
    }

    public RSString method66() {
        long l = method86();
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

    public boolean method67(int arg1) {
        if(arg1 < 1 || arg1 > 36)
            arg1 = 10;
        boolean bool = false;
        boolean bool_6_ = false;
        int i = 0;
        for(int i_7_ = 0; length > i_7_; i_7_++) {
            int i_8_ = 0xff & chars[i_7_];
            if(i_7_ == 0) {
                if(i_8_ == 45) {
                    bool = true;
                    continue;
                }
                if(i_8_ == 43)
                    continue;
            }
            if(i_8_ < 48 || i_8_ > 57) {
                if(i_8_ >= 65 && i_8_ <= 90)
                    i_8_ -= 55;
                else {
                    if(i_8_ < 97 || i_8_ > 122)
                        return false;
                    i_8_ -= 87;
                }
            } else
                i_8_ -= 48;
            if((arg1 <= i_8_))
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
        class1.chars = new byte[arg2 - arg1];
        class1.length = -arg1 + arg2;
        Class18.method278(chars, arg1, class1.chars, 0, class1.length);
        return class1;
    }

    public RSString prepend(RSString arg0, int arg2) {
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        if(arg2 > length)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        if(arg0.length + arg2 > chars.length) {
            int i;
            for(i = 1; (i < arg0.length + arg2); i += i) {
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

    public RSString method70(int arg0) {
        if(arg0 > 255)
            throw new IllegalArgumentException("invalid char");
        RSString class1 = new RSString();
        class1.chars = new byte[length + 1];
        class1.length = length + 1;
        Class18.method278(chars, 0, class1.chars, 0, length);
        class1.chars[length] = (byte) arg0;
        return class1;
    }

    public RSString add(RSString arg0) {
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        if((length + arg0.length > chars.length)) {
            int i;
            i = 1;
            while((i < length + arg0.length)) {
                i += i;
            }
            byte[] newChars = new byte[i];
            Class18.method278(chars, 0, newChars, 0, length);
            chars = newChars;
        }
        Class18.method278(arg0.chars, 0, chars, length, arg0.length);
        length += arg0.length;
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

    public boolean startsWith(String string) {
        return this.toString().startsWith(string);
    }

    public int method76() {
        int i = 0;
        for(int i_12_ = 0; length > i_12_; i_12_++)
            i = (0xff & chars[i_12_]) + -i + (i << 5);
        return i;
    }

    public RSString method77() {
        if(!aBoolean1675)
            throw new IllegalArgumentException();
        anInt1696 = 0;
        if(length != chars.length) {
            byte[] is = new byte[length];
            Class18.method278(chars, 0, is, 0, length);
            chars = is;
        }
        return this;
    }

    public RSString method78(int arg1) {
        if(arg1 <= 0 || arg1 > 255)
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
        return this;
    }

    public RSString toLowerCase() {
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        for(int i = 0; length > i; i++) {
            byte i_13_ = chars[i];
            if(i_13_ >= 65 && i_13_ <= 90 || (i_13_ >= -64 && i_13_ <= -34 && i_13_ != -41))
                i_13_ += 32;
            class1.chars[i] = i_13_;
        }
        return class1;
    }

    public byte[] method80() {
        byte[] is = new byte[length];
        Class18.method278(chars, 0, is, 0, length);
        return is;
    }

    public int method81(RSString arg0, int arg1) {
        int[] is = new int[arg0.length];
        int[] is_14_ = new int[arg0.length];
        int[] is_15_ = new int[256];
        for(int i = 0; (i < is_15_.length); i++)
            is_15_[i] = arg0.length;
        for(int i = 1; i <= arg0.length; i++) {
            is[-1 + i] = (arg0.length << 1) - i;
            is_15_[HuffmanEncoding.method1021(arg0.chars[-1 + i], 255)] = arg0.length - i;
        }
        int i = 1 + arg0.length;
        for(int i_16_ = arg0.length; i_16_ > 0; i_16_--) {
            is_14_[i_16_ - 1] = i;
            for(/**/; (i <= arg0.length && (arg0.chars[i - 1] != arg0.chars[-1 + i_16_])); i = is_14_[-1 + i]) {
                if((-i_16_ + arg0.length <= is[i - 1]))
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
                if((-i_21_ + i_17_ + arg0.length <= is[i_21_ + -1]))
                    is[i_21_ + -1] = -i_21_ + arg0.length + i_17_;
            }
            i_18_ = 1 + i_17_;
            i_17_ = -is_14_[-1 + i] + (i + i_17_);
            i = is_14_[i - 1];
        }
        int i_22_;
        for(int i_23_ = -1 + (arg1 + arg0.length); i_23_ < length; i_23_ += Math.max(is_15_[chars[i_23_] & 0xff], is[i_22_])) {
            for(i_22_ = arg0.length + -1; i_22_ >= 0 && (chars[i_23_] == arg0.chars[i_22_]); i_22_--)
                i_23_--;
            if(i_22_ == -1)
                return 1 + i_23_;
        }
        return -1;
    }

    public boolean method82() {
        return method67(10);
    }

    public String toString() {
        return new String(this.chars);
    }

    public int method84(RSString arg0) {
        int i;
        if(arg0.length >= length)
            i = length;
        else
            i = arg0.length;
        for(int i_24_ = 0; (i > i_24_); i_24_++) {
            if((arg0.chars[i_24_] > chars[i_24_]))
                return -1;
            if((chars[i_24_] > arg0.chars[i_24_]))
                return 1;
        }
        if(arg0.length > length)
            return -1;
        if(length > arg0.length)
            return 1;
        return 0;
    }

    public RSString method85() {
        boolean bool = true;
        RSString class1 = new RSString();
        class1.length = length;
        class1.chars = new byte[length];
        for(int i = 0; i < length; i++) {
            byte i_25_ = chars[i];
            if(i_25_ == 95) {
                class1.chars[i] = (byte) 32;
                bool = true;
            } else if(i_25_ < 97 || i_25_ > 122 || !bool) {
                class1.chars[i] = i_25_;
                bool = false;
            } else {
                bool = false;
                class1.chars[i] = (byte) (i_25_ - 32);
            }
        }
        return class1;
    }

    public long method86() {
        long l = 0L;
        for(int i = 0; length > i; i++)
            l = -l + (l << 5) + (long) (0xff & chars[i]);
        return l;
    }

    public boolean method87(RSString arg1) {
        if(length < arg1.length)
            return false;
        int i = length + -arg1.length;
        for(int i_26_ = 0; arg1.length > i_26_; i_26_++) {
            if(chars[i_26_ + i] != arg1.chars[i_26_])
                return false;
        }
        return true;
    }

    public int method88(boolean arg0, int arg1) {
        if(arg1 < 1 || arg1 > 36)
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
            if(i_29_ >= 48 && i_29_ <= 57)
                i_29_ -= 48;
            else if(i_29_ >= 65 && i_29_ <= 90)
                i_29_ -= 55;
            else {
                if(i_29_ < 97 || i_29_ > 122)
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

    public RSString trim() {
        int i = 0;
        int i_31_ = length;
        while((length > i && (chars[i] >= 0 && chars[i] <= 32 || (0xff & chars[i]) == 160))) {
            i++;
        }
        while(((i_31_ > i) && ((chars[i_31_ + -1] >= 0 && chars[-1 + i_31_] <= 32) || (chars[i_31_ + -1] & 0xff) == 160))) {
            i_31_--;
        }
        if(i == 0 && length == i_31_)
            return this;
        RSString class1 = new RSString();
        class1.length = i_31_ + -i;
        class1.chars = new byte[class1.length];
        for(int i_32_ = 0; (class1.length > i_32_); i_32_++)
            class1.chars[i_32_] = chars[i + i_32_];
        return class1;
    }
}
