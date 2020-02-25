package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;

public class Class52 {
    public static int anInt1211;
    public static int anInt1212;
    public static RSString aClass1_1213 = RSString.CreateString(" @whi@(X");
    public static int anInt1214;
    public static volatile boolean aBoolean1215;
    public static RSString aClass1_1216 = RSString.CreateString("New User");
    public static byte[][] aByteArrayArray1217;
    public static RSString aClass1_1218;
    public static int fps;
    public static boolean redrawChatbox = false;
    public static int anInt1222;
    public static RSString aClass1_1223;
    public static int anInt1224;
    public static int anInt1227;
    public static RSString aClass1_1228;
    public static RSString aClass1_1230;
    public static int anInt1233;
    public static RSString aClass1_1234;
    public static int anInt1236;
    public static int anInt1237;
    public static RSString aClass1_1238;
    public static int anInt1239;
    public static int anInt1240;
    public static RSString aClass1_1241;

    static {
        aBoolean1215 = true;
        anInt1222 = 0;
        aClass1_1223 = aClass1_1216;
        aClass1_1228 = (RSString.CreateString("Ihre Freunde)2Liste ist voll(Q Mitglieder k-Onnen 200 Freunde hinzuf-Ugen)1 freie Spieler nur 100)3"));
        aClass1_1230 = RSString.CreateString("headicons_hint");
        fps = 0;
        aClass1_1234 = RSString.CreateString("Connection timed out)3");
        anInt1233 = 0;
        aClass1_1238 = RSString.CreateString("Der Server wird gerade aktualisiert)3");
        aClass1_1218 = aClass1_1234;
        anInt1214 = 0;
        aClass1_1241 = RSString.CreateString("Lade Wordpack )2 ");
    }

    public int anInt1220;
    public int anInt1225;
    public int anInt1226;
    public boolean aBoolean1229 = true;
    public int anInt1231;
    public int anInt1232;
    public int anInt1235;

    public Class52(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) {

        anInt1231 = arg0;
        aBoolean1229 = arg6;
        anInt1225 = arg1;
        anInt1235 = arg2;
        anInt1220 = arg4;
        anInt1232 = arg3;
        anInt1226 = arg5;

    }

    public static void method943(int arg0, int arg1, TypeFace arg2, int arg3, int arg4) {

        HuffmanEncoding.aClass68_1541.method1046((byte) 90);
        anInt1224++;
        Class57.aClass40_Sub5_Sub14_Sub2_1346.drawImage(0, 0);
        arg2.method688(Class19.aClass1_495, 55, 28, 16777215, true);
        if(arg4 == 0)
            arg2.method688(Npc.aClass1_3311, 55, 41, 65280, true);
        if(arg4 == 1)
            arg2.method688(Class40_Sub5_Sub15.aClass1_2786, 55, 41, 16776960, true);
        if(arg4 == 2)
            arg2.method688(Class30.aClass1_682, 55, 41, 16711680, true);
        if(arg4 == 3)
            arg2.method688(Class40_Sub5_Sub11.aClass1_2622, 55, 41, 65535, true);
        arg2.method688(RSString.aClass1_1703, 184, 28, 16777215, true);
        if(arg3 == 0)
            arg2.method688(Npc.aClass1_3311, 184, 41, 65280, true);
        if(arg3 == 1)
            arg2.method688(Class40_Sub5_Sub15.aClass1_2786, 184, 41, 16776960, true);
        if(arg3 == 2)
            arg2.method688(Class30.aClass1_682, 184, 41, 16711680, true);
        arg2.method688(Class30.aClass1_701, 324, 28, 16777215, true);
        if(arg0 == 0)
            arg2.method688(Npc.aClass1_3311, 324, 41, 65280, true);
        if(arg0 == 1)
            arg2.method688(Class40_Sub5_Sub15.aClass1_2786, 324, 41, 16776960, true);
        if(arg0 == 2)
            arg2.method688(Class30.aClass1_682, 324, 41, 16711680, true);
        arg2.method672(Class22_Sub1.aClass1_1865, 417, 17, 85, 25, 16777215, true, 1, 1, 0);
        int i = -50 % ((arg1 - 82) / 38);
        try {
            Graphics graphics = GameFrame.aCanvas1469.getGraphics();
            HuffmanEncoding.aClass68_1541.method1044(0, 0, graphics, 453);
        } catch(Exception exception) {
            GameFrame.aCanvas1469.repaint();
        }

    }

    public static ImageRGB[] method944(byte arg0, int arg1, CacheIndex arg2, int arg3) {

        anInt1237++;
        if(!method948(arg3, arg1, arg2, -3844))
            return null;
        int i = -59 % ((-60 - arg0) / 34);
        return Class22_Sub2.method319((byte) -62);

    }

    public static void method945(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        anInt1211++;
        if(arg5 != 103)
            anInt1214 = -81;
        if(arg2 >= 1 && arg0 >= 1 && arg2 <= 102 && arg0 <= 102) {
            if(!VertexNormal.lowMemory || Player.anInt3267 == arg7) {
                int i = -1;
                int i_0_ = 0;
                boolean bool = false;
                boolean bool_1_ = false;
                if(arg6 == 0)
                    i_0_ = Npc.aScene_3301.method122(arg7, arg2, arg0);
                if(arg6 == 1)
                    i_0_ = Npc.aScene_3301.method91(arg7, arg2, arg0);
                if(arg6 == 2)
                    i_0_ = Npc.aScene_3301.method110(arg7, arg2, arg0);
                if(arg6 == 3)
                    i_0_ = Npc.aScene_3301.method93(arg7, arg2, arg0);
                if(i_0_ != 0) {
                    i = (i_0_ & 0x1ffff138) >> 14;
                    int i_2_ = Npc.aScene_3301.method141(arg7, arg2, arg0, i_0_);
                    int i_3_ = i_2_ >> 6 & 0x3;
                    int i_4_ = 0x1f & i_2_;
                    if(arg6 == 0) {
                        Npc.aScene_3301.method124(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(gameObjectDefinition.solid)
                            Landscape.aCollisionMapArray1167[arg7].method148(-4, arg2, i_3_, gameObjectDefinition.walkable, arg0, i_4_);
                    }
                    if(arg6 == 1)
                        Npc.aScene_3301.method127(arg7, arg2, arg0);
                    if(arg6 == 2) {
                        Npc.aScene_3301.method135(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if((arg2 + gameObjectDefinition.sizeX > 103) || arg0 + gameObjectDefinition.sizeX > 103 || arg2 + gameObjectDefinition.sizeY > 103 || gameObjectDefinition.sizeY + arg0 > 103)
                            return;
                        if(gameObjectDefinition.solid)
                            Landscape.aCollisionMapArray1167[arg7].method149(gameObjectDefinition.walkable, arg0, arg2, i_3_, gameObjectDefinition.sizeX, (byte) -55, gameObjectDefinition.sizeY);
                    }
                    if(arg6 == 3) {
                        Npc.aScene_3301.method131(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1)
                            Landscape.aCollisionMapArray1167[arg7].method145(arg0, arg5 + 28124, arg2);
                    }
                }
                if(arg1 >= 0) {
                    int i_5_ = arg7;
                    if(i_5_ < 3 && ((OverlayDefinition.tile_flags[1][arg2][arg0]) & 0x2) == 2)
                        i_5_++;
                    Class40_Sub5_Sub1.method543(Landscape.aCollisionMapArray1167[arg7], arg1, i_5_, arg7, arg3, (Npc.aScene_3301), -22078, arg4, arg0, arg2);
                }
            }
        }
    }

    public static void method946(boolean arg0) {

        aClass1_1213 = null;
        aClass1_1241 = null;
        aClass1_1228 = null;
        if(arg0 == false) {
            aClass1_1238 = null;
            aClass1_1223 = null;
            aClass1_1234 = null;
            aByteArrayArray1217 = null;
            aClass1_1218 = null;
            aClass1_1216 = null;
            aClass1_1230 = null;
        }

    }

    public static void method947(int arg0) {

        synchronized(CollisionMap.anObject162) {
            if((Buffer.anInt1987 ^ 0xffffffff) != arg0) {
                Buffer.anInt1987 = 1;
                try {
                    CollisionMap.anObject162.wait();
                } catch(InterruptedException interruptedexception) {
                    /* empty */
                }
            }
        }
        anInt1212++;

    }

    public static boolean method948(int arg0, int arg1, CacheIndex arg2, int arg3) {

        if(arg3 != -3844)
            method948(14, -28, null, -69);
        byte[] is = arg2.getFile(arg0, arg1);
        anInt1239++;
        if(is == null)
            return false;
        CacheIndex.method184(is, 0);
        return true;

    }
}
