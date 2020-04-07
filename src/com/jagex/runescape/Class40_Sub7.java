package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;

public class Class40_Sub7 extends Node {
    public static Class68 aClass68_2123;
    public static RSString aClass1_2125;
    public static RSString aClass1_2127 = RSString.CreateString("Loading interfaces )2 ");
    public static RSString aClass1_2129 = RSString.CreateString("Mem:");
    public static RSString aClass1_2130 = RSString.CreateString("Loaded update list");
    public static int[] friendWorlds;
    public static RSString aClass1_2132;

    static {
        aClass1_2125 = aClass1_2130;
        friendWorlds = new int[200];
        aClass1_2132 = aClass1_2127;
    }

    public RSString aClass1_2124;

    public static void method839() {
        aClass68_2123 = null;
        aClass1_2132 = null;
        friendWorlds = null;
        aClass1_2129 = null;
        aClass1_2127 = null;
        aClass1_2130 = null;
        aClass1_2125 = null;
    }

    public static boolean method840(byte arg0, byte[] arg1, int arg2, int arg3) {
        boolean bool = true;
        Buffer class40_sub1 = new Buffer(arg1);
        int i = -1;
        if(arg0 > -40)
            return false;
        for(; ; ) {
            int i_0_ = class40_sub1.getSmart();
            if(i_0_ == 0)
                break;
            i += i_0_;
            int i_1_ = 0;
            boolean bool_2_ = false;
            for(; ; ) {
                if(bool_2_) {
                    int i_3_ = class40_sub1.getSmart();
                    if(i_3_ == 0)
                        break;
                    class40_sub1.getUnsignedByte();
                } else {
                    int i_4_ = class40_sub1.getSmart();
                    if(i_4_ == 0)
                        break;
                    i_1_ += i_4_ + -1;
                    int i_5_ = i_1_ & 0x3f;
                    int i_6_ = class40_sub1.getUnsignedByte() >> 2;
                    int i_7_ = 0x3f & i_1_ >> 6;
                    int i_8_ = i_7_ + arg2;
                    int i_9_ = i_5_ + arg3;
                    if(i_8_ > 0 && i_9_ > 0 && i_8_ < 103 && i_9_ < 103) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(i_6_ != 22 || !VertexNormal.lowMemory || (gameObjectDefinition.hasActions != 0) || gameObjectDefinition.obstructsGround) {
                            bool_2_ = true;
                            if(!gameObjectDefinition.method612()) {
                                bool = false;
                                IdentityKit.anInt2591++;
                            }
                        }
                    }
                }
            }
        }
        return bool;
    }
}
