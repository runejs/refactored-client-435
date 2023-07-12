package org.runejs.client.media.renderable;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;

import java.awt.*;

public class GameObject extends Renderable {
    public static MouseHandler frame = new MouseHandler();
    public static ProducingGraphicsBuffer flameRightBackground;
    public static ProducingGraphicsBuffer tabPieceLeft;
    public static int anInt3048 = 1;


    public int vertexHeightTopRight;
    public int orientation;
    public int objectType;
    public int animationCycleDelay;
    public int animationFrame;
    public int vertexHeightTop;
    public int vertexHeight;
    public int vertexHeightRight;
    public AnimationSequence animationSequence;
    public int id;


    public GameObject(int objectId, int objectType, int orientation, int arg3, int arg4, int arg5, int arg6, int animationId, boolean arg8) {
        vertexHeight = arg3;
        id = objectId;
        vertexHeightTop = arg6;
        this.orientation = orientation;
        vertexHeightRight = arg4;
        vertexHeightTopRight = arg5;
        this.objectType = objectType;
        if(animationId != -1) {
            animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId);
            animationFrame = 0;
            animationCycleDelay = -1 + MovedStatics.pulseCycle;
            if(arg8 && animationSequence.frameStep != -1) {
                animationFrame = (int) ((double) animationSequence.frameIds.length * Math.random());
                animationCycleDelay -= (int) (Math.random() * (double) animationSequence.frameLengths[animationFrame]);
            }
        }
    }

    public static IndexedImage method769(int arg0, CacheArchive imageArchive, int arg2) {
        if(!Buffer.method472(imageArchive, arg2))
            return null;
        return MovedStatics.method538();
    }


    public static void drawLoadingText(int percent, Color color, String desc) {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            if(MovedStatics.helveticaBold == null) {
                MovedStatics.helveticaBold = new Font("Helvetica", Font.BOLD, 13);
                MovedStatics.fontMetrics = MouseHandler.gameCanvas.getFontMetrics(MovedStatics.helveticaBold);
            }
            if(MovedStatics.clearScreen) {
                MovedStatics.clearScreen = false;
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, MovedStatics.width, MovedStatics.height);
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
                loadingBoxGraphics.setFont(MovedStatics.helveticaBold);
                loadingBoxGraphics.setColor(Color.white);
                loadingBoxGraphics.drawString(desc, (304 - (MovedStatics.fontMetrics.stringWidth(desc))) / 2, 22);
                graphics.drawImage(Class26.loadingBoxImage, MovedStatics.width / 2 - 152, MovedStatics.height / 2 - 18, null);
            } catch(Exception exception) {
                int centerWidth = MovedStatics.width / 2 - 152;
                int centerHeight = MovedStatics.height / 2 - 18;
                graphics.setColor(color);
                graphics.drawRect(centerWidth, centerHeight, 303, 33);
                graphics.fillRect(2 + centerWidth, centerHeight + 2, 3 * percent, 30);
                graphics.setColor(Color.black);
                graphics.drawRect(centerWidth + 1, 1 + centerHeight, 301, 31);
                graphics.fillRect(percent * 3 + 2 + centerWidth, 2 + centerHeight, 300 + -(3 * percent), 30);
                graphics.setFont(MovedStatics.helveticaBold);
                graphics.setColor(Color.white);
                graphics.drawString(desc, (304 - (MovedStatics.fontMetrics.stringWidth(desc))) / 2+ centerWidth, 22 + centerHeight);
            }
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void clearImageCache() {
        Buffer.rgbImageCache.clear();
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
        if(gameObjectDefinition.childIds != null)
            gameObjectDefinition = gameObjectDefinition.getChildDefinition();
        if(gameObjectDefinition == null)
            return null;
        return gameObjectDefinition.createAnimatedObjectModel(vertexHeight, vertexHeightRight, animationFrame, objectType, orientation, animationSequence, vertexHeightTop, vertexHeightTopRight);
    }
}
