package org.runejs.client.scene.tile;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.Class57;

import java.awt.*;

public class GenericTile {
    public static int anInt1214 = 0;
    public static int carryWeight = 0;

    public int texture;
    public int colourB;
    public int rgbColor;
    public boolean flat;
    public int colourA;
    public int colourC;
    public int colourD;

    public GenericTile(int colourA, int colourB, int colourC, int colourD, int texture, int rgbColor, boolean flat) {
        this.colourA = colourA;
        this.colourB = colourB;
        this.colourC = colourC;
        this.colourD = colourD;
        this.texture = texture;
        this.rgbColor = rgbColor;
        this.flat = flat;
    }

    public static void method943(int arg0, TypeFace arg2, int arg3, int arg4) {
        MovedStatics.chatModes.prepareRasterizer();
        Class57.bottomChatBack.drawImage(0, 0);
        arg2.drawShadowedStringCenter(English.publicChat, 55, 28, 16777215, true);
        if(arg4 == 0)
            arg2.drawShadowedStringCenter(English.on, 55, 41, 65280, true);
        if(arg4 == 1)
            arg2.drawShadowedStringCenter(English.friends, 55, 41, 16776960, true);
        if(arg4 == 2)
            arg2.drawShadowedStringCenter(English.off, 55, 41, 16711680, true);
        if(arg4 == 3)
            arg2.drawShadowedStringCenter(English.hide, 55, 41, 65535, true);
        arg2.drawShadowedStringCenter(English.privateChat, 184, 28, 16777215, true);
        if(arg3 == 0)
            arg2.drawShadowedStringCenter(English.on, 184, 41, 65280, true);
        if(arg3 == 1)
            arg2.drawShadowedStringCenter(English.friends, 184, 41, 16776960, true);
        if(arg3 == 2)
            arg2.drawShadowedStringCenter(English.off, 184, 41, 16711680, true);
        arg2.drawShadowedStringCenter(English.trade, 324, 28, 16777215, true);
        if(arg0 == 0)
            arg2.drawShadowedStringCenter(English.on, 324, 41, 65280, true);
        if(arg0 == 1)
            arg2.drawShadowedStringCenter(English.friends, 324, 41, 16776960, true);
        if(arg0 == 2)
            arg2.drawShadowedStringCenter(English.off, 324, 41, 16711680, true);
        arg2.drawText(English.reportAbuse, 417, 17, 85, 25, 16777215, true, 1, 1, 0);
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            if(ScreenController.frameMode == ScreenMode.FIXED) {
                MovedStatics.chatModes.drawGraphics(0, 453, graphics);
            }
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }


}
