package com.jagex.runescape;

import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.io.Buffer;

import java.math.BigInteger;

public class PacketBuffer extends Buffer {
    public static int anInt2231 = 1;
    public static boolean hiddenButtonTest = false;
    public static Effect[] effects = new Effect[50];
    public static RSString aClass1_2240 = RSString.CreateString("Please wait)3)3)3");
    public static long aLong2241 = 0L;
    public static RSString aClass1_2245 = RSString.CreateString("Aus");
    public static BigInteger rsaKey = (new BigInteger("65537"));
    public static int anInt2248 = 0;
    public static Class40_Sub5_Sub13 aClass40_Sub5_Sub13_2250;
    public static boolean aBoolean2255 = false;
    public static int lastClickX = 0;
    public static int anInt2257;
    public static int anInt2258;
    public static RSString aClass1_2259 = RSString.CreateString("oder benutzen Sie eine andere Welt)3");
    public static RSString aClass1_2260 = RSString.CreateString("da dieser Computer gegen unsere ");

    public ISAAC inCipher;
    public ISAAC outCipher;
    public int bitoffset;

    public PacketBuffer(int arg0) {
        super(arg0);
    }

    public static void method513(int arg0, CacheIndex_Sub1 arg1, Class56 arg2, byte arg3) {
        Class40_Sub6 class40_sub6 = new Class40_Sub6();
        class40_sub6.anInt2112 = 1;
        class40_sub6.key = (long) arg0;
        class40_sub6.aClass56_2117 = arg2;
        class40_sub6.aClass6_Sub1_2104 = arg1;
        synchronized(RSCanvas.aClass45_53) {
            if(arg3 != -28)
                method521(false, (byte) -113, -84, -120);
            RSCanvas.aClass45_53.method904(class40_sub6, -72);
        }
        HashTable.method332(600);
    }

    public static void method514(int arg0) {
        aClass40_Sub5_Sub13_2250 = null;
        aClass1_2260 = null;
        if(arg0 == 1) {
            rsaKey = null;
            effects = null;
            aClass1_2245 = null;
            aClass1_2240 = null;
            aClass1_2259 = null;
        }
    }

    public static void method516(int arg0) {
        Class32.packetBuffer.putPacket(176);
        if(Class29.anInt673 != -1) {
            Class55.method958(Class29.anInt673, -14222);
            CacheIndex_Sub1.anInt1819 = -1;
            IdentityKit.aBoolean2597 = true;
            ISAAC.redrawTabArea = true;
            Class29.anInt673 = -1;
        }
        Class40_Sub13.anInt2184++;
        if(Class43.openChatboxWidgetId != -1) {
            Class55.method958(Class43.openChatboxWidgetId, -14222);
            CacheIndex_Sub1.anInt1819 = -1;
            Class52.redrawChatbox = true;
            Class43.openChatboxWidgetId = -1;
        }
        if((ActorDefinition.anInt2433 ^ 0xffffffff) != 0) {
            Class55.method958(ActorDefinition.anInt2433, -14222);
            ActorDefinition.anInt2433 = -1;
            OverlayDefinition.method559(30, -47);
        }
        if((UnderlayDefinition.anInt2562 ^ 0xffffffff) != 0) {
            Class55.method958(UnderlayDefinition.anInt2562, -14222);
            UnderlayDefinition.anInt2562 = -1;
        }
        if(arg0 >= 92) {
            if(Class66.anInt1560 != -1) {
                Class55.method958(Class66.anInt1560, -14222);
                Class66.anInt1560 = -1;
                CacheIndex_Sub1.anInt1819 = -1;
            }
        }
    }

    public static void method517(int arg0, int arg1, int arg2) {
        if(arg2 == -9225) {
            Class32.packetBuffer.putPacket(132);
            ISAAC.anInt499++;
            Class32.packetBuffer.putIntME2(arg1);
            Class32.packetBuffer.putShortLE(arg0);
        }
    }

    public static RSString method521(boolean arg0, byte arg1, int arg2, int arg3) {
        if(arg2 < 1 || arg2 > 36)
            arg2 = 10;
        int i = 1;
        if(arg1 != 8)
            return null;
        int i_2_ = arg3 / arg2;
        while(i_2_ != 0) {
            i_2_ /= arg2;
            i++;
        }
        int i_3_ = i;
        if(arg3 < 0 || arg0)
            i_3_++;
        byte[] is = new byte[i_3_];
        if((arg3 ^ 0xffffffff) > -1)
            is[0] = (byte) 45;
        else if(arg0)
            is[0] = (byte) 43;
        for(int i_4_ = 0; i > i_4_; i_4_++) {
            int i_5_ = arg3 % arg2;
            arg3 /= arg2;
            if(i_5_ < 0)
                i_5_ = -i_5_;
            if((i_5_ ^ 0xffffffff) < -10)
                i_5_ += 39;
            is[-1 + (i_3_ - i_4_)] = (byte) (48 + i_5_);
        }
        RSString class1 = new RSString();
        class1.chars = is;
        class1.length = i_3_;
        return class1;
    }

    public int method510(int arg0, int arg1) {
        if(arg0 <= 118)
            return 75;
        return 8 * arg1 - bitoffset;
    }

    public void finishBitAccess(byte arg0) {
        if(arg0 != -110)
            bitoffset = -12;
        currentPosition = (7 + bitoffset) / 8;
    }

    public int getPacket(byte arg0) {
        if(arg0 != 49)
            aClass1_2260 = null;
        return 0xff & (buffer[currentPosition++] - inCipher.rand());
    }

    public int putBits(int arg0, byte arg1) {
        int i = bitoffset >> 3;
        if(arg1 != -65)
            aClass1_2240 = null;
        int i_0_ = 0;
        int i_1_ = 8 - (0x7 & bitoffset);
        bitoffset += arg0;
        for(/**/; i_1_ < arg0; i_1_ = 8) {
            i_0_ += (Class40_Sub5_Sub4.anIntArray2361[i_1_] & buffer[i++]) << -i_1_ + arg0;
            arg0 -= i_1_;
        }
        if((i_1_ ^ 0xffffffff) != (arg0 ^ 0xffffffff))
            i_0_ += (Class40_Sub5_Sub4.anIntArray2361[arg0] & buffer[i] >> -arg0 + i_1_);
        else
            i_0_ += (buffer[i] & Class40_Sub5_Sub4.anIntArray2361[i_1_]);
        return i_0_;
    }

    public void putPacket(int packetId) {
        buffer[currentPosition++] = (byte) ((packetId + outCipher.rand()) & 0xff);
    }

    public void initInCipher(int[] seed) {
        inCipher = new ISAAC(seed);
    }

    public void initOutCipher(int[] seed) {
        outCipher = new ISAAC(seed);
    }

    public void initBitAccess(int arg0) {
        bitoffset = currentPosition * 8;
        if(arg0 <= 21)
            inCipher = null;
    }
}
