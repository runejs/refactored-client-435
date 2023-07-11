package org.runejs.client;

import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.node.Node;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.VertexNormal;

public class Class40_Sub7 extends Node {
    public static ProducingGraphicsBuffer mapBackRight;

    public RSString aClass1_2124;


    public static boolean method840(byte[] arg1, int arg2, int arg3) {
        boolean bool = true;
        Buffer class40_sub1 = new Buffer(arg1);
        int i = -1;
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
                        if(i_6_ != 22 || !VertexNormal.lowMemory || gameObjectDefinition.hasActions != 0 || gameObjectDefinition.obstructsGround) {
                            bool_2_ = true;
                            if(!gameObjectDefinition.method612()) {
                                bool = false;
                                Game.anInt2591++;
                            }
                        }
                    }
                }
            }
        }
        return bool;
    }
}
