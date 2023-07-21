package org.runejs.client;

import org.runejs.client.media.RasterizerInstanced;

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;

public class ProducingGraphicsBuffer_Sub2 extends ProducingGraphicsBuffer {
    public Component aComponent2214;

    public void drawGraphics(int arg1, int arg3, Graphics arg2) {
        arg2.drawImage(image, arg1, arg3, aComponent2214);
    }
    public void paintComponent(int arg1, int arg3, Graphics arg2) {
        arg2.drawImage(image, arg1, arg3, aComponent2214);
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3, RasterizerInstanced rasterizerInstance) {
        width = arg1;
        if(arg0 > 4) {
            pixels = new int[1 + arg3 * arg1];
            height = arg3;
            DataBufferInt databufferint = new DataBufferInt(pixels, pixels.length);
            DirectColorModel directcolormodel = new DirectColorModel(32, 16711680, 65280, 255);
            WritableRaster writableraster = Raster.createWritableRaster(directcolormodel.createCompatibleSampleModel(width, height), databufferint, null);
            image = new BufferedImage(directcolormodel, writableraster, false, new Hashtable());
            aComponent2214 = arg2;
            prepareRasterizer(rasterizerInstance);
        }
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
        method1041(arg0, arg1, arg2, arg3, null);
    }
}
