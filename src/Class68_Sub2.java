/* Class68_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;

public class Class68_Sub2 extends Class68 {
    public Component aComponent2214;

    public void method1044(int arg0, int arg1, Graphics arg2, int arg3) {
        if(arg0 == 0)
            arg2.drawImage(anImage1625, arg1, arg3, aComponent2214);
    }

    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
        anInt1619 = arg1;
        if(arg0 > 4) {
            anIntArray1621 = new int[1 + arg3 * arg1];
            anInt1617 = arg3;
            DataBufferInt databufferint = new DataBufferInt(anIntArray1621, anIntArray1621.length);
            DirectColorModel directcolormodel = new DirectColorModel(32, 16711680, 65280, 255);
            WritableRaster writableraster = (Raster.createWritableRaster(directcolormodel.createCompatibleSampleModel(anInt1619, anInt1617), databufferint, null));
            anImage1625 = new BufferedImage(directcolormodel, writableraster, false, new Hashtable());
            aComponent2214 = arg2;
            method1046((byte) 90);
        }
    }
}
