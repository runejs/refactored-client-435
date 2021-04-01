package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class GameObject extends Renderable {
    public static MouseHandler frame = new MouseHandler();
    public static int minimapHintCount = 0;
    public static ProducingGraphicsBuffer flameRightBackground;
    public static ProducingGraphicsBuffer tabPieceLeft;
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
            animationSequence = ProducingGraphicsBuffer_Sub1.method1050(arg7, 2);
            animationFrame = 0;
            animationCycleDelay = -1 + MovedStatics.pulseCycle;
            if(arg8 && animationSequence.frameStep != -1) {
                animationFrame = (int) ((double) animationSequence.frameIds.length * Math.random());
                animationCycleDelay -= (int) (Math.random() * (double) animationSequence.frameLengths[animationFrame]);
            }
        }
    }

    public static IndexedImage method769(int arg0, CacheArchive arg1, int arg2) {
        if(!Buffer.method472(arg1, arg2))
            return null;
        return MovedStatics.method538(0);
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

    public static void drawLoadingText(int percent, Color color, String desc) {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            if(Class17.helveticaBold == null) {
                Class17.helveticaBold = new Font("Helvetica", Font.BOLD, 13);
                Class8.fontMetrics = MouseHandler.gameCanvas.getFontMetrics(Class17.helveticaBold);
            }
            if(Class40_Sub5_Sub11.clearScreen) {
                Class40_Sub5_Sub11.clearScreen = false;
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, Class12.width, IdentityKit.height);
            }
            if(color == null)
                color = new Color(140, 17, 17);
            try {
                if(Class26.loadingBoxImage == null)
                    Class26.loadingBoxImage = MouseHandler.gameCanvas.createImage(304, 34);
                Graphics loadingBoxGraphics = Class26.loadingBoxImage.getGraphics();
                loadingBoxGraphics.setColor(color);
                loadingBoxGraphics.drawRect(0, 0, 303, 33);
                loadingBoxGraphics.fillRect(2, 2, percent * 3, 30);
                loadingBoxGraphics.setColor(Color.black);
                loadingBoxGraphics.drawRect(1, 1, 301, 31);
                loadingBoxGraphics.fillRect(2 + 3 * percent, 2, 300 - 3 * percent, 30);
                loadingBoxGraphics.setFont(Class17.helveticaBold);
                loadingBoxGraphics.setColor(Color.white);
                loadingBoxGraphics.drawString(desc, (304 - (Class8.fontMetrics.stringWidth(desc))) / 2, 22);
                graphics.drawImage(Class26.loadingBoxImage, Class12.width / 2 - 152, IdentityKit.height / 2 - 18, null);
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
                graphics.drawString(desc, (304 - (Class8.fontMetrics.stringWidth(desc))) / 2+ centerWidth, 22 + centerHeight);
            }
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method774(byte arg0) {
        Buffer.rgbImageCache.clear();
        if(arg0 != -96)
            Native.mapFunction = null;
    }

    public Model getRotatedModel() {
        if(animationSequence != null) {
            int step = -animationCycleDelay + MovedStatics.pulseCycle;
            if(step > 100 && animationSequence.frameStep > 0)
                step = 100;
            while(animationSequence.frameLengths[animationFrame] < step) {
                step -= animationSequence.frameLengths[animationFrame];
                animationFrame++;
                if(animationSequence.frameIds.length <= animationFrame) {
                    animationFrame -= animationSequence.frameStep;
                    if(animationFrame < 0 || animationSequence.frameIds.length <= animationFrame) {
                        animationSequence = null;
                        break;
                    }
                }
            }
            animationCycleDelay = MovedStatics.pulseCycle - step;
        }
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(id);
        if(gameObjectDefinition.configChangeDest != null)
            gameObjectDefinition = gameObjectDefinition.getChildDefinition();
        if(gameObjectDefinition == null)
            return null;
        return gameObjectDefinition.createAnimatedObjectModel(vertexHeight, vertexHeightRight, animationFrame, anInt3021, anInt3018, animationSequence, vertexHeightTop, vertexHeightTopRight);
    }
}
