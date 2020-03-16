package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Class64 implements Runnable {
    public static RSString aClass1_1502 = RSString.CreateString("Wordpack geladen)3");
    public static RSString aClass1_1505 = RSString.CreateString("Handel akzeptieren");
    public static int anInt1511 = -1;
    public static RSString aClass1_1517 = RSString.CreateString("redstone3");
    public static CacheIndex aCacheIndex_1521;
    public static RSString aClass1_1523 = RSString.CreateString("");
    public static RSString aClass1_1524 = RSString.CreateString("Menge eingeben:");
    public static RSString aClass1_1526 = RSString.CreateString("Your account has been disabled)3");
    public static int setZ = 99;

    public InputStream anInputStream1503;
    public byte[] aByteArray1504;
    public Socket aSocket1508;
    public int anInt1509 = 0;
    public boolean aBoolean1510;
    public SignlinkNode aSignlinkNode_1512;
    public boolean aBoolean1513;
    public Signlink aClass31_1515;
    public int anInt1520 = 0;
    public OutputStream anOutputStream1528;

    public Class64(Socket arg0, Signlink arg1) throws IOException {
        aBoolean1513 = false;
        aBoolean1510 = false;
        aClass31_1515 = arg1;
        aSocket1508 = arg0;
        aSocket1508.setSoTimeout(30000);
        aSocket1508.setTcpNoDelay(true);
        anInputStream1503 = aSocket1508.getInputStream();
        anOutputStream1528 = aSocket1508.getOutputStream();

    }

    public static void method1011(boolean arg0) {

        aClass1_1505 = null;
        aClass1_1526 = null;
        if(!arg0)
            aClass1_1502 = null;
        aClass1_1523 = null;
        aClass1_1502 = null;
        aCacheIndex_1521 = null;
        aClass1_1524 = null;
        aClass1_1517 = null;

    }

    public static void method1012(int arg0, int arg1) {
        if(Class68.method1043(arg0)) {
            Widget[] widgets = Widget.interfaces[arg0];
            if(arg1 != 2)
                method1013(true);
            for(int i = 0; widgets.length > i; i++) {
                Widget widget = widgets[i];
                if(widget.anObjectArray2677 != null)
                    Widget.method891(widget.anObjectArray2677, 0, 0, widget, 0, false);
            }
        }
    }

    public static void method1013(boolean arg0) {
        int i = -1;
        if(arg0)
            method1013(false);
        if(Class8.anInt301 == 0 && Main.anInt1773 == 0) {
            OverlayDefinition.method558(0, Class22_Sub2.aClass1_1876, Landscape.mouseY, -501, Class13.mouseX, 7, HuffmanEncoding.blank_string);
        }
        int i_1_ = 0;
        for(/**/; ((Model.anInt3220 > i_1_)); i_1_++) {
            int i_2_ = Model.anIntArray3211[i_1_];
            int i_3_ = 0x7f & i_2_;
            int i_4_ = i_2_ >> 7 & 0x7f;
            int i_5_ = i_2_ >> 29 & 0x3;
            int i_6_ = (i_2_ & 0x1fffcccc) >> 14;
            if(i != i_2_) {
                i = i_2_;
                if(i_5_ == 2 && (Npc.aScene_3301.getArrangement(Player.anInt3267, i_3_, i_4_, i_2_)) >= 0) {
                    GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i_6_);
                    if(gameObjectDefinition.configChangeDest != null)
                        gameObjectDefinition = gameObjectDefinition.method611(-20);
                    if(gameObjectDefinition == null)
                        continue;
                    if(Class8.anInt301 == 1) {
                        OverlayDefinition.method558(i_2_, Main.aClass1_1763, i_4_, -501, i_3_, 5, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{(Npc.aClass1_3295), Class40_Sub5_Sub1.aClass1_2277, gameObjectDefinition.name}))));
                        Class44.anInt1045++;
                    } else if(Main.anInt1773 != 1) {
                        RSString[] class1s = gameObjectDefinition.actions;
                        if(Class60.aBoolean1402)
                            class1s = Class56.method968(class1s, arg0);
                        Class29.anInt675++;
                        if(class1s != null) {
                            for(int i_7_ = 4; i_7_ >= 0; i_7_--) {
                                if(class1s[i_7_] != null) {
                                    int i_8_ = 0;
                                    Class35.anInt1741++;
                                    if(i_7_ == 0)
                                        i_8_ = 16;
                                    if(i_7_ == 1)
                                        i_8_ = 29;
                                    if(i_7_ == 2)
                                        i_8_ = 17;
                                    if(i_7_ == 3)
                                        i_8_ = 27;
                                    if(i_7_ == 4)
                                        i_8_ = 1002;
                                    OverlayDefinition.method558(i_2_, class1s[i_7_], i_4_, -501, i_3_, i_8_, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{(Renderable.aClass1_2862), (gameObjectDefinition.name)}))));
                                }
                            }
                        }
                        OverlayDefinition.method558(gameObjectDefinition.anInt2538 << 14, Class40_Sub5_Sub15.prefix_examine, i_4_, -501, i_3_, 1004, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{Renderable.aClass1_2862, gameObjectDefinition.name}))));
                    } else if((ItemDefinition.anInt2815 & 0x4) == 4) {
                        Renderable.anInt2863++;
                        OverlayDefinition.method558(i_2_, Class38_Sub1.aClass1_1918, i_4_, -501, i_3_, 32, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{FloorDecoration.aClass1_611, Class40_Sub5_Sub1.aClass1_2277, gameObjectDefinition.name}))));
                    }
                }
                if(i_5_ == 1) {
                    Npc class40_sub5_sub17_sub4_sub2 = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_6_]);
                    if((class40_sub5_sub17_sub4_sub2.actorDefinition.tileSpacesOccupied) == 1 && ((class40_sub5_sub17_sub4_sub2.anInt3098 & 0x7f) == 64) && ((0x7f & class40_sub5_sub17_sub4_sub2.anInt3089) == 64)) {
                        for(int i_9_ = 0; ((GameObjectDefinition.anInt2558 > i_9_)); i_9_++) {
                            Npc class40_sub5_sub17_sub4_sub2_10_ = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i_9_]]);
                            if(class40_sub5_sub17_sub4_sub2_10_ != null && (class40_sub5_sub17_sub4_sub2_10_ != class40_sub5_sub17_sub4_sub2) && (class40_sub5_sub17_sub4_sub2_10_.actorDefinition.tileSpacesOccupied) == 1 && ((class40_sub5_sub17_sub4_sub2_10_.anInt3098) == class40_sub5_sub17_sub4_sub2.anInt3098) && ((class40_sub5_sub17_sub4_sub2_10_.anInt3089) == (class40_sub5_sub17_sub4_sub2.anInt3089)))
                                HuffmanEncoding.method1025(0, i_3_, i_4_, Class40_Sub3.anIntArray2016[i_9_], (class40_sub5_sub17_sub4_sub2_10_.actorDefinition));
                        }
                        for(int i_11_ = 0; i_11_ < Class60.anInt1407; i_11_++) {
                            Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_11_]]);
                            if(class40_sub5_sub17_sub4_sub1 != null && (class40_sub5_sub17_sub4_sub2.anInt3098 == (class40_sub5_sub17_sub4_sub1.anInt3098)) && ((class40_sub5_sub17_sub4_sub1.anInt3089) == class40_sub5_sub17_sub4_sub2.anInt3089))
                                Class40_Sub5_Sub1.method545(i_4_, false, i_3_, class40_sub5_sub17_sub4_sub1, Class57.anIntArray1334[i_11_]);
                        }
                    }
                    HuffmanEncoding.method1025(0, i_3_, i_4_, i_6_, (class40_sub5_sub17_sub4_sub2.actorDefinition));
                }
                if(i_5_ == 0) {
                    Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_6_]);
                    if((0x7f & class40_sub5_sub17_sub4_sub1.anInt3098) == 64 && (0x7f & class40_sub5_sub17_sub4_sub1.anInt3089) == 64) {
                        for(int i_12_ = 0; ((i_12_ < GameObjectDefinition.anInt2558)); i_12_++) {
                            Npc class40_sub5_sub17_sub4_sub2 = (CacheIndex_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i_12_]]);
                            if(class40_sub5_sub17_sub4_sub2 != null && ((class40_sub5_sub17_sub4_sub2.actorDefinition.tileSpacesOccupied) == 1) && ((class40_sub5_sub17_sub4_sub2.anInt3098) == class40_sub5_sub17_sub4_sub1.anInt3098) && (class40_sub5_sub17_sub4_sub2.anInt3089 == (class40_sub5_sub17_sub4_sub1.anInt3089)))
                                HuffmanEncoding.method1025(0, i_3_, i_4_, Class40_Sub3.anIntArray2016[i_12_], (class40_sub5_sub17_sub4_sub2.actorDefinition));
                        }
                        for(int i_13_ = 0; ((i_13_ < Class60.anInt1407)); i_13_++) {
                            Player class40_sub5_sub17_sub4_sub1_14_ = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[Class57.anIntArray1334[i_13_]]);
                            if(class40_sub5_sub17_sub4_sub1_14_ != null && (class40_sub5_sub17_sub4_sub1_14_ != class40_sub5_sub17_sub4_sub1) && ((class40_sub5_sub17_sub4_sub1.anInt3098) == (class40_sub5_sub17_sub4_sub1_14_.anInt3098)) && ((class40_sub5_sub17_sub4_sub1.anInt3089) == (class40_sub5_sub17_sub4_sub1_14_.anInt3089)))
                                Class40_Sub5_Sub1.method545(i_4_, arg0, i_3_, class40_sub5_sub17_sub4_sub1_14_, Class57.anIntArray1334[i_13_]);
                        }
                    }
                    Class40_Sub5_Sub1.method545(i_4_, false, i_3_, class40_sub5_sub17_sub4_sub1, i_6_);
                }
                if(i_5_ == 3) {
                    Class45 class45 = (Wall.aClass45ArrayArrayArray357[Player.anInt3267][i_3_][i_4_]);
                    if(class45 != null) {
                        for(Class40_Sub5_Sub17_Sub3 class40_sub5_sub17_sub3 = ((Class40_Sub5_Sub17_Sub3) class45.method901((byte) -95)); class40_sub5_sub17_sub3 != null; class40_sub5_sub17_sub3 = ((Class40_Sub5_Sub17_Sub3) class45.method912(4))) {
                            ItemDefinition class40_sub5_sub16 = (ItemDefinition.forId(class40_sub5_sub17_sub3.anInt3067, 10));
                            if(Class8.anInt301 == 1) {
                                Class44.anInt1036++;
                                OverlayDefinition.method558(class40_sub5_sub17_sub3.anInt3067, Main.aClass1_1763, i_4_, -501, i_3_, 47, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{(Npc.aClass1_3295), Class5.aClass1_206, (class40_sub5_sub16.name)}))));
                            } else if(Main.anInt1773 != 1) {
                                RSString[] class1s = class40_sub5_sub16.groundOptions;
                                Class56.anInt1319++;
                                if(Class60.aBoolean1402)
                                    class1s = Class56.method968(class1s, arg0);
                                for(int i_15_ = 4; i_15_ >= 0; i_15_--) {
                                    if(class1s == null || class1s[i_15_] == null) {
                                        if(i_15_ == 2) {
                                            Wall.anInt339++;
                                            OverlayDefinition.method558((class40_sub5_sub17_sub3.anInt3067), Class27.takeStringInstance, i_4_, -501, i_3_, 3, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.name)}))));
                                        }
                                    } else {
                                        OverlayDefinition.anInt2331++;
                                        int i_16_ = 0;
                                        if(i_15_ == 0)
                                            i_16_ = 2;
                                        if(i_15_ == 1)
                                            i_16_ = 38;
                                        if(i_15_ == 2)
                                            i_16_ = 3;
                                        if(i_15_ == 3)
                                            i_16_ = 8;
                                        if(i_15_ == 4)
                                            i_16_ = 36;
                                        OverlayDefinition.method558((class40_sub5_sub17_sub3.anInt3067), class1s[i_15_], i_4_, -501, i_3_, i_16_, (Class40_Sub5_Sub17_Sub6.method832((new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.name)}))));
                                    }
                                }
                                OverlayDefinition.method558(class40_sub5_sub17_sub3.anInt3067, Class40_Sub5_Sub15.prefix_examine, i_4_, -501, i_3_, 1003, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{VertexNormal.aClass1_1114, (class40_sub5_sub16.name)})));
                            } else if((0x1 & ItemDefinition.anInt2815) == 1) {
                                OverlayDefinition.method558(class40_sub5_sub17_sub3.anInt3067, Class38_Sub1.aClass1_1918, i_4_, -501, i_3_, 15, (Class40_Sub5_Sub17_Sub6.method832(new RSString[]{FloorDecoration.aClass1_611, Class5.aClass1_206, (class40_sub5_sub16.name)})));
                            }
                        }
                    }
                }
            }
        }

    }

    public static void method1015(int arg0) {

        synchronized(GameObject.frame) {
            SpotAnimDefinition.anInt2302 = Cache.mouseButtonPressed;
            Class13.mouseX = Class12.eventMouseX;
            if(arg0 != -656)
                aClass1_1524 = null;
            Landscape.mouseY = Cache.eventMouseY;
            GameFrame.clickType = Actor.eventMouseButtonPressed;
            Class57.anInt1338 = Class55.eventClickX;
            RSString.anInt1668 = Class40_Sub5_Sub11.eventClickY;
            GameObjectDefinition.aLong2561 = OverlayDefinition.lastClick;
            Actor.eventMouseButtonPressed = 0;
        }
    }

    public void method1008(int arg0, int arg1, int arg2, byte[] arg3) throws IOException {
        if(!aBoolean1513 && arg2 < -126) {
            while(arg1 > 0) {
                int i = anInputStream1503.read(arg3, arg0, arg1);
                if(i <= 0)
                    throw new EOFException();
                arg1 -= i;
                arg0 += i;
            }
        }
    }

    public void method1009(int arg0) {
        int i = 27 / ((-54 - arg0) / 32);
        if(!aBoolean1513) {
            synchronized(this) {
                aBoolean1513 = true;
                this.notifyAll();
            }
            if(aSignlinkNode_1512 != null) {
                while(aSignlinkNode_1512.anInt434 == 0)
                    Class43.method890(1L, 115);
                if(aSignlinkNode_1512.anInt434 == 1) {
                    try {
                        ((Thread) aSignlinkNode_1512.value).join();
                    } catch(InterruptedException interruptedexception) {
                        interruptedexception.printStackTrace();
                        /* empty */
                    }
                }
            }
            aSignlinkNode_1512 = null;
        }
    }

    public void method1010(int arg0, byte arg1, int arg2, byte[] arg3) throws IOException {
        if(!aBoolean1513) {
            if(aBoolean1510) {
                aBoolean1510 = false;
                throw new IOException();
            }
            if(aByteArray1504 == null)
                aByteArray1504 = new byte[5000];
            synchronized(this) {
                for(int i = 0; i < arg0; i++) {
                    aByteArray1504[anInt1509] = arg3[arg2 + i];
                    anInt1509 = (1 + anInt1509) % 5000;
                    if(anInt1509 == (4900 + anInt1520) % 5000)
                        throw new IOException();
                }
                if(aSignlinkNode_1512 == null)
                    aSignlinkNode_1512 = aClass31_1515.method394(3, 0, this);
                this.notifyAll();
                if(arg1 != -19)
                    run();
            }
        }

    }

    public void finalize() {
        method1009(-4);
    }

    public void run() {
        try {
            for(; ; ) {
                int i;
                int i_0_;
                synchronized(this) {
                    if(anInt1509 == anInt1520) {
                        if(aBoolean1513) {
                            break;
                        }
                        try {
                            this.wait();
                        } catch(InterruptedException interruptedexception) {
                            /* empty */
                            interruptedexception.printStackTrace();
                        }
                    }
                    if(anInt1509 >= anInt1520)
                        i = anInt1509 - anInt1520;
                    else
                        i = -anInt1520 + 5000;
                    i_0_ = anInt1520;
                }
                if(i > 0) {
                    try {
                        anOutputStream1528.write(aByteArray1504, i_0_, i);
                    } catch(IOException ioexception) {
                        aBoolean1510 = true;
                    }
                    anInt1520 = (i + anInt1520) % 5000;
                    try {
                        if(anInt1520 == anInt1509)
                            anOutputStream1528.flush();
                    } catch(IOException ioexception) {
                        ioexception.printStackTrace();
                        aBoolean1510 = true;
                    }
                }
            }
            try {
                if(anInputStream1503 != null)
                    anInputStream1503.close();
                if(anOutputStream1528 != null)
                    anOutputStream1528.close();
                if(aSocket1508 != null)
                    aSocket1508.close();
            } catch(IOException ioexception) {
                /* empty */
                ioexception.printStackTrace();
            }
            aByteArray1504 = null;
        } catch(Exception exception) {
            CacheIndex.method169(null, (byte) -122, exception);
        }
    }

    public int method1014(int arg0) throws IOException {
        if(arg0 >= -120)
            aClass31_1515 = null;
        if(aBoolean1513)
            return 0;
        return anInputStream1503.available();
    }

    public int method1016(int arg0) throws IOException {
        if(arg0 < 14)
            aClass1_1524 = null;
        if(aBoolean1513)
            return 0;
        return anInputStream1503.read();
    }
}
