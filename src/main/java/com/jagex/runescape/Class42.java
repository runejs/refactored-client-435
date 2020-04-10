package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;

public class Class42 {
    public static RSString aClass1_988;
    public static RSString aClass1_989 = RSString.CreateString("We suspect someone knows your password)3");
    public static RSString aClass1_990 = RSString.CreateString("Unable to connect)3");
    public static byte[][][] tile_underlayids;
    public static RSString aClass1_995 = RSString.CreateString(" has logged in)3");
    public static RSString aClass1_997;
    public static Cache aClass9_998 = new Cache(100);
    public static RSString aClass1_1000;
    public static RSString aClass1_1001;
    public static RSString aClass1_1002;
    public static RSString aClass1_1005 = RSString.CreateString("Loaded config");
    public static int anInt1006 = 0;
    public static int anInt1008 = 0;
    public static int anInt1010 = 2;
    public static RSString aClass1_1011;
    public static RSString aClass1_1012 = RSString.CreateString("Existing user");
    public static int[] anIntArray1013;

    static {
        aClass1_1001 = aClass1_989;
        aClass1_1000 = aClass1_1005;
        aClass1_988 = aClass1_995;
        aClass1_1002 = aClass1_990;
        aClass1_997 = aClass1_990;
        aClass1_1011 = aClass1_1012;
    }

    public int[] anIntArray996;

    public Class42(int[] arg0) {
        int i;
        for(i = 1; (((arg0.length >> 1) + arg0.length >= i)); i <<= 1) {
            /* empty */
        }
        anIntArray996 = new int[i + i];
        for(int i_8_ = 0; (i + i > i_8_); i_8_++)
            anIntArray996[i_8_] = -1;
        for(int i_9_ = 0; (arg0.length > i_9_); i_9_++) {
            int i_10_;
            for(i_10_ = arg0[i_9_] & i - 1; anIntArray996[i_10_ + (i_10_ + 1)] != -1; i_10_ = i_10_ + 1 & -1 + i) {
                /* empty */
            }
            anIntArray996[i_10_ + i_10_] = arg0[i_9_];
            anIntArray996[1 + i_10_ + i_10_] = i_9_;
        }

    }

    public static void method883(byte arg0, int arg1) {
        if(Class68.method1043(arg1)) {
            Widget[] widgets = Widget.interfaces[arg1];
            for(int i = 0; widgets.length > i; i++) {
                Widget widget = widgets[i];
                if(widget != null) {
                    widget.anInt2660 = 0;
                    widget.anInt2654 = 0;
                }
            }
            int i = 40 % ((arg0 + 57) / 54);
        }
    }

    public static int method884(int arg0, int arg1, int arg2) {
        if(arg2 != 37821)
            method887();
        int i = 57 * arg1 + arg0;
        i ^= i << 13;
        int i_2_ = 1376312589 + (i * i * 15731 + 789221) * i & 0x7fffffff;
        return i_2_ >> 19 & 0xff;
    }

    public static void method885(CacheIndex arg0, boolean arg1, CacheIndex arg2, int arg3) {
        IdentityKit.membersServer = arg1;
        if(arg3 != -313)
            aClass1_1012 = null;
        Class8.aCacheIndex_284 = arg2;
        Class26.aCacheIndex_632 = arg0;
        ItemDefinition.count = Class26.aCacheIndex_632.method190(10);
    }

    public static void method886(int arg0, int arg1, boolean arg2, byte[] arg3, int arg4) {
        if(arg0 == 0 && Class5.aClass22_189 != null) {
            if(MouseHandler.anInt1450 < 0) {
                if(RSCanvas.anInt54 != 0) {
                    PacketBuffer.anInt2258 = arg1;
                    Player.aByteArray3270 = arg3;
                    Class30.aBoolean687 = arg2;
                } else
                    RSString.method56(arg2, arg3, arg1);
            } else {
                Buffer.anInt1982 = arg4;
                if(MouseHandler.anInt1450 != 0) {
                    int i = Class29.method372(arg0 ^ 0x60, MouseHandler.anInt1450);
                    i -= Class39.anInt909;
                    RSCanvas.anInt54 = (i + 3600) / arg4;
                    if(RSCanvas.anInt54 < 1)
                        RSCanvas.anInt54 = 1;
                } else
                    RSCanvas.anInt54 = 1;
                PacketBuffer.anInt2258 = arg1;
                Player.aByteArray3270 = arg3;
                Class30.aBoolean687 = arg2;
            }
        }
    }

    public static void method887() {
        aClass1_988 = null;
        aClass1_1001 = null;
        aClass1_989 = null;
        aClass1_1012 = null;
        aClass9_998 = null;
        anIntArray1013 = null;
        tile_underlayids = null;
        aClass1_995 = null;
        aClass1_990 = null;
        aClass1_1005 = null;
        aClass1_997 = null;
        aClass1_1011 = null;
        aClass1_1002 = null;
        aClass1_1000 = null;
    }

    public static int method888(int arg0, byte arg1, int arg2) {
        int i = (-128 + Class4.method160(arg0 + 45365, 15177, 4, 91923 + arg2) - (-(Class4.method160(arg0 + 10294, 15177, 2, 37821 + arg2) - 128 >> 1) + -(-128 + Class4.method160(arg0, 15177, 1, arg2) >> 2)));
        i = 35 + (int) (0.3 * (double) i);
        if(arg1 != -45)
            return -24;
        if(i >= 10) {
            if(i > 60)
                i = 60;
        } else
            i = 10;
        return i;
    }

    public int method882(int arg0) {
        int i = -2 + anIntArray996.length;
        int i_0_ = arg0 << 1 & i;
        for(; ; ) {
            int i_1_ = anIntArray996[i_0_];
            if(i_1_ == arg0)
                return anIntArray996[i_0_ + 1];
            if(i_1_ == -1)
                return -1;
            i_0_ = i_0_ + 2 & i;
        }
    }
}
