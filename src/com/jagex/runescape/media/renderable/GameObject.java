package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;

import java.awt.*;

public class GameObject extends Renderable {
    public static int anInt3017;
    public static GameFrame frame = new GameFrame();
    public static int anInt3020;
    public static int anInt3022;
    public static int anInt3023;
    public static int anInt3025;
    public static int anInt3028;
    public static int anInt3031;
    public static int anInt3032;
    public static int anInt3033;
    public static RSString aClass1_3036;
    public static RSString aClass1_3037;
    public static RSString aClass1_3038;
    public static RSString aClass1_3039;
    public static int anInt3040;
    public static RSString aClass1_3041 = RSString.CreateString("Loaded gamescreen");
    public static Class68 aClass68_3042;
    public static RSString aClass1_3043;
    public static RSString aClass1_3044;
    public static Class68 aClass68_3045;
    public static RSString aClass1_3046;
    public static RSString aClass1_3047;
    public static int anInt3048;


    static {
        anInt3040 = 0;
        aClass1_3036 = RSString.CreateString("Accept challenge");
        aClass1_3037 = RSString.CreateString("Okay");
        aClass1_3038 = aClass1_3041;
        aClass1_3047 = RSString.CreateString("mapfunction");
        aClass1_3043 = RSString.CreateString("Bitte laden Sie die Seite neu)3");
        aClass1_3046 = RSString.CreateString("Absender:");
        aClass1_3039 = aClass1_3036;
        anInt3048 = 1;
        aClass1_3044 = RSString.CreateString("");
    }

    public int anInt3016;
    public int anInt3018;
    public int anInt3021;
    public int anInt3024;
    public int anInt3026;
    public int anInt3027;
    public int anInt3029;
    public int anInt3030;
    public Class40_Sub5_Sub7 aClass40_Sub5_Sub7_3034;
    public int anInt3035;


    public GameObject(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, boolean arg8) {
        anInt3029 = arg3;
        anInt3035 = arg0;
        anInt3027 = arg6;
        anInt3018 = arg2;
        anInt3030 = arg4;
        anInt3016 = arg5;
        anInt3021 = arg1;
        if(arg7 != -1) {
            aClass40_Sub5_Sub7_3034 = Class68_Sub1.method1050(arg7, 2);
            anInt3026 = 0;
            anInt3024 = -1 + Node.anInt926;
            if(arg8 && aClass40_Sub5_Sub7_3034.anInt2497 != -1) {
                anInt3026 = (int) ((double) (aClass40_Sub5_Sub7_3034.anIntArray2485).length * Math.random());
                anInt3024 -= (int) (Math.random() * (double) (aClass40_Sub5_Sub7_3034.anIntArray2466[anInt3026]));
            }
        }
    }

    public static void method768(int arg0) {

        Class17.anInt460 = 0;
        anInt3023++;
        Actor.anInt3153 = 0;
        Class40_Sub5_Sub17_Sub1.method759(false);
        Class42.method889(48);
        Class13.method245(3799);
        if(arg0 > 75) {
            for(int i = 0; i < Class17.anInt460; i++) {
                int i_0_ = Class6.anIntArray225[i];
                if(Node.anInt926 != (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_].anInt3134)) {
                    Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_].aClass40_Sub5_Sub5_3300 = null;
                    Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_0_] = null;
                }
            }
            if((Widget.packetsize ^ 0xffffffff) != (Cache.outgoingbuffer.currentPosition ^ 0xffffffff))
                throw new RuntimeException("gnp1 pos:" + (Cache.outgoingbuffer.currentPosition) + " psize:" + Widget.packetsize);
            for(int i = 0; GameObjectDefinition.anInt2558 > i; i++) {
                if((Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i]]) == null)
                    throw new RuntimeException("gnp2 pos:" + i + " size:" + (GameObjectDefinition.anInt2558));
            }
        }

    }

    public static IndexedImage method769(int arg0, Class6 arg1, int arg2) {

        anInt3032++;
        if(!Buffer.method472(arg1, arg2))
            return null;
        return SubNode.method538(0);

    }

    public static void method770(byte arg0) {

        aClass1_3037 = null;
        aClass1_3047 = null;
        aClass68_3042 = null;
        aClass1_3046 = null;
        int i = 17 % ((arg0 + 10) / 62);
        aClass1_3041 = null;
        aClass1_3044 = null;
        aClass68_3045 = null;
        frame = null;
        aClass1_3038 = null;
        aClass1_3036 = null;
        aClass1_3039 = null;
        aClass1_3043 = null;

    }

    public static void loadObjectBlock(int block_x, Scene scene, CollisionMap[] collisionMaps, byte[] block_data, int block_z) {
        Buffer buffer = new Buffer(block_data);
        anInt3022++;
        int object_id = -1;
        for(; ; ) {
            int delta_id = buffer.getSmart();
            if(delta_id == 0)
                break;
            int pos = 0;
            object_id += delta_id;
            for(; ; ) {
                int delta_pos = buffer.getSmart();
                if(delta_pos == 0)
                    break;
                pos += -1 + delta_pos;
                int tile_z = pos & 0x3f;
                int tile_x = pos >> 6 & 0x3f;
                int tile_y = pos >> 12;
                int object_info = buffer.getUnsignedByte();
                int object_type = object_info >> 2;
                int object_orientation = 0x3 & object_info;
                int object_x = tile_x + block_x;
                int object_z = tile_z + block_z;
                if(object_x > 0 && object_z > 0 && object_x < 103 && object_z < 103) {
                    CollisionMap collisionMap = null;
                    int logic_y = tile_y;
                    if((Floor.tile_flags[1][object_x][object_z] & 2) == 2)
                        logic_y--;
                    if(logic_y >= 0)
                        collisionMap = collisionMaps[logic_y];
                    Class40_Sub5_Sub17_Sub1.addObject(object_id, object_x, object_z, tile_y, object_orientation, object_type, scene, collisionMap);
                }
            }
        }

    }

    public static void drawLoadingText(int arg0, Color color, RSString rsString, int arg3) {

        anInt3033++;
        try {
            Graphics graphics = GameFrame.aCanvas1469.getGraphics();
            if(Class17.aFont461 == null) {
                Class17.aFont461 = new Font("Helvetica", 1, 13);
                Class8.aFontMetrics295 = GameFrame.aCanvas1469.getFontMetrics(Class17.aFont461);
            }
            if(Class40_Sub5_Sub11.aBoolean2631) {
                Class40_Sub5_Sub11.aBoolean2631 = false;
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, Class12.width, IdentityKit.height);
            }
            if(color == null)
                color = new Color(140, 17, 17);
            try {
                if(Class26.anImage624 == null)
                    Class26.anImage624 = GameFrame.aCanvas1469.createImage(304, 34);
                Graphics graphics_13_ = Class26.anImage624.getGraphics();
                graphics_13_.setColor(color);
                int i = -71 % ((arg3 - 8) / 54);
                graphics_13_.drawRect(0, 0, 303, 33);
                graphics_13_.fillRect(2, 2, arg0 * 3, 30);
                graphics_13_.setColor(Color.black);
                graphics_13_.drawRect(1, 1, 301, 31);
                graphics_13_.fillRect(2 + (3 * arg0), 2, 300 - 3 * arg0, 30);
                graphics_13_.setFont(Class17.aFont461);
                graphics_13_.setColor(Color.white);
                rsString.method65(((304 + -rsString.method73(Class8.aFontMetrics295)) / 2), 22, graphics_13_);
                graphics.drawImage(Class26.anImage624, -152 + Class12.width / 2, -18 + IdentityKit.height / 2, null);
            } catch(Exception exception) {
                int i = -152 + Class12.width / 2;
                int i_14_ = IdentityKit.height / 2 + -18;
                graphics.setColor(color);
                graphics.drawRect(i, i_14_, 303, 33);
                graphics.fillRect(2 + i, i_14_ + 2, 3 * arg0, 30);
                graphics.setColor(Color.black);
                graphics.drawRect(i + 1, 1 + i_14_, 301, 31);
                graphics.fillRect(arg0 * 3 + 2 + i, 2 + i_14_, 300 + -(3 * arg0), 30);
                graphics.setFont(Class17.aFont461);
                graphics.setColor(Color.white);
                rsString.method65((-rsString.method73(Class8.aFontMetrics295) + 304) / 2 + i, 22 + i_14_, graphics);
            }
        } catch(Exception exception) {
            GameFrame.aCanvas1469.repaint();
        }

    }

    public static void method773(byte arg0, RSString arg1) {

        anInt3017++;
        if(arg1 == null || arg1.length() == 0)
            VertexNormal.itemSearchResultCount = 0;
        else {
            RSString class1 = arg1;
            RSString[] class1s = new RSString[100];
            if(arg0 != -96)
                aClass1_3043 = null;
            int i = 0;
            for(; ; ) {
                int i_15_ = class1.method57((byte) -5, 32);
                if(i_15_ == -1) {
                    class1 = class1.method89(false);
                    if((class1.length() ^ 0xffffffff) < -1)
                        class1s[i++] = class1.method79();
                    break;
                }
                RSString class1_16_ = class1.substring(0, i_15_).method89(false);
                if((class1_16_.length() ^ 0xffffffff) < -1)
                    class1s[i++] = class1_16_.method79();
                class1 = class1.substring(1 + i_15_);
            }
            VertexNormal.itemSearchResultCount = 0;
            int i_17_ = 0;
            while_12_:
            for(/**/; Class27.anInt661 > i_17_; i_17_++) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_17_, 10);
                if((class40_sub5_sub16.noteTemplateId ^ 0xffffffff) == 0 && class40_sub5_sub16.name != null) {
                    RSString class1_18_ = class40_sub5_sub16.name.method79();
                    for(int i_19_ = 0; i_19_ < i; i_19_++) {
                        if(class1_18_.method60(class1s[i_19_]) == -1)
                            continue while_12_;
                    }
                    Class22_Sub1.aClass1Array1844[VertexNormal.itemSearchResultCount] = class1_18_;
                    Class5.anIntArray191[VertexNormal.itemSearchResultCount] = i_17_;
                    VertexNormal.itemSearchResultCount++;
                    if((VertexNormal.itemSearchResultCount >= Class22_Sub1.aClass1Array1844.length))
                        break;
                }
            }
        }

    }

    public static void method774(byte arg0) {
        anInt3025++;
        Buffer.aClass9_1933.method235((byte) -88);
        if(arg0 != -96)
            aClass1_3047 = null;
    }

    public Model method756(int arg0) {

        if(aClass40_Sub5_Sub7_3034 != null) {
            int i = -anInt3024 + Node.anInt926;
            if(i > 100 && (aClass40_Sub5_Sub7_3034.anInt2497 ^ 0xffffffff) < -1)
                i = 100;
            while(aClass40_Sub5_Sub7_3034.anIntArray2466[anInt3026] < i) {
                i -= aClass40_Sub5_Sub7_3034.anIntArray2466[anInt3026];
                anInt3026++;
                if((aClass40_Sub5_Sub7_3034.anIntArray2485.length <= anInt3026)) {
                    anInt3026 -= aClass40_Sub5_Sub7_3034.anInt2497;
                    if((anInt3026 ^ 0xffffffff) > -1 || (aClass40_Sub5_Sub7_3034.anIntArray2485.length <= anInt3026)) {
                        aClass40_Sub5_Sub7_3034 = null;
                        break;
                    }
                }
            }
            anInt3024 = -i + Node.anInt926;
        }
        anInt3031++;
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(anInt3035);
        int i = 83 % ((41 - arg0) / 47);
        if(gameObjectDefinition.configChangeDest != null)
            gameObjectDefinition = gameObjectDefinition.method611(-20);
        if(gameObjectDefinition == null)
            return null;
        return gameObjectDefinition.method607(anInt3029, 103, anInt3030, anInt3026, anInt3021, anInt3018, aClass40_Sub5_Sub7_3034, anInt3027, anInt3016);

    }
}
