package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class GameObject extends Renderable {
    public static MouseHandler frame = new MouseHandler();
    public static RSString aClass1_3038 = RSString.CreateString("Loaded gamescreen");
    public static RSString aClass1_3039 = RSString.CreateString("Accept challenge");
    public static int anInt3040 = 0;
    public static Class68 aClass68_3042;
    public static RSString aClass1_3044 = RSString.CreateString("");
    public static Class68 aClass68_3045;
    public static RSString aClass1_3047 = RSString.CreateString("mapfunction");
    public static int anInt3048 = 1;


    public int vertexHeightTopRight;
    public int anInt3018;
    public int anInt3021;
    public int animationCycleDelay;
    public int animationFrame;
    public int vertexHeightTop;
    public int vertexHeight;
    public int vertexHeightRight;
    public AnimationSequence animationSequence;
    public int id;


    public GameObject(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, boolean arg8) {
        vertexHeight = arg3;
        id = arg0;
        vertexHeightTop = arg6;
        anInt3018 = arg2;
        vertexHeightRight = arg4;
        vertexHeightTopRight = arg5;
        anInt3021 = arg1;
        if(arg7 != -1) {
            animationSequence = Class68_Sub1.method1050(arg7, 2);
            animationFrame = 0;
            animationCycleDelay = -1 + Node.pulseCycle;
            if(arg8 && animationSequence.frameStep != -1) {
                animationFrame = (int) ((double) (animationSequence.anIntArray2485).length * Math.random());
                animationCycleDelay -= (int) (Math.random() * (double) (animationSequence.animationLengths[animationFrame]));
            }
        }
    }

    public static IndexedImage method769(int arg0, CacheIndex arg1, int arg2) {
        if(!Buffer.method472(arg1, arg2))
            return null;
        return SubNode.method538(0);
    }

    public static void method770() {
        aClass1_3047 = null;
        aClass68_3042 = null;
        aClass1_3044 = null;
        aClass68_3045 = null;
        frame = null;
        aClass1_3038 = null;
        aClass1_3039 = null;
    }

    public static void loadObjectBlock(int block_x, Scene scene, CollisionMap[] collisionMaps, byte[] block_data, int block_z) {
        Buffer buffer = new Buffer(block_data);
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
                    if((OverlayDefinition.tile_flags[1][object_x][object_z] & 2) == 2)
                        logic_y--;
                    if(logic_y >= 0)
                        collisionMap = collisionMaps[logic_y];
                    Class40_Sub5_Sub17_Sub1.addObject(object_id, object_x, object_z, tile_y, object_orientation, object_type, scene, collisionMap);
                }
            }
        }
    }

    public static void drawLoadingText(int percent, Color color, RSString rsString) {
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            if(Class17.helveticaBold == null) {
                Class17.helveticaBold = new Font("Helvetica", Font.BOLD, 13);
                Class8.fontMetrics = MouseHandler.aCanvas1469.getFontMetrics(Class17.helveticaBold);
            }
            if(Class40_Sub5_Sub11.clearScreen) {
                Class40_Sub5_Sub11.clearScreen = false;
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, Class12.width, IdentityKit.height);
            }
            if(color == null)
                color = new Color(140, 17, 17);
            try {
                if(Class26.anImage624 == null)
                    Class26.anImage624 = MouseHandler.aCanvas1469.createImage(304, 34);
                Graphics graphics1 = Class26.anImage624.getGraphics();
                graphics1.setColor(color);
                graphics1.drawRect(0, 0, 303, 33);
                graphics1.fillRect(2, 2, percent * 3, 30);
                graphics1.setColor(Color.black);
                graphics1.drawRect(1, 1, 301, 31);
                graphics1.fillRect(2 + (3 * percent), 2, 300 - 3 * percent, 30);
                graphics1.setFont(Class17.helveticaBold);
                graphics1.setColor(Color.white);
                rsString.method65(((304 - rsString.method73(Class8.fontMetrics)) / 2), 22, graphics1);
                graphics.drawImage(Class26.anImage624, Class12.width / 2 - 152, IdentityKit.height / 2 - 18, null);
            } catch(Exception exception) {
                int centerWidth = Class12.width / 2 - 152;
                int centerHeight = IdentityKit.height / 2 - 18;
                graphics.setColor(color);
                graphics.drawRect(centerWidth, centerHeight, 303, 33);
                graphics.fillRect(2 + centerWidth, centerHeight + 2, 3 * percent, 30);
                graphics.setColor(Color.black);
                graphics.drawRect(centerWidth + 1, 1 + centerHeight, 301, 31);
                graphics.fillRect(percent * 3 + 2 + centerWidth, 2 + centerHeight, 300 + -(3 * percent), 30);
                graphics.setFont(Class17.helveticaBold);
                graphics.setColor(Color.white);
                rsString.method65((-rsString.method73(Class8.fontMetrics) + 304) / 2 + centerWidth, 22 + centerHeight, graphics);
            }
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static void method774(byte arg0) {
        Buffer.aClass9_1933.method235((byte) -88);
        if(arg0 != -96)
            aClass1_3047 = null;
    }

    public Model getRotatedModel(int arg0) {
        if(animationSequence != null) {
            int step = -animationCycleDelay + Node.pulseCycle;
            if(step > 100 && animationSequence.frameStep > 0)
                step = 100;
            while(animationSequence.animationLengths[animationFrame] < step) {
                step -= animationSequence.animationLengths[animationFrame];
                animationFrame++;
                if((animationSequence.anIntArray2485.length <= animationFrame)) {
                    animationFrame -= animationSequence.frameStep;
                    if(animationFrame < 0 || (animationSequence.anIntArray2485.length <= animationFrame)) {
                        animationSequence = null;
                        break;
                    }
                }
            }
            animationCycleDelay = Node.pulseCycle - step;
        }
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(id);
        if(gameObjectDefinition.configChangeDest != null)
            gameObjectDefinition = gameObjectDefinition.getChildDefinition(-20);
        if(gameObjectDefinition == null)
            return null;
        return gameObjectDefinition.getGameObjectModel(vertexHeight, vertexHeightRight, animationFrame, anInt3021, anInt3018, animationSequence, vertexHeightTop, vertexHeightTopRight);
    }
}
