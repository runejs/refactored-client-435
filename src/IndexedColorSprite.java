/* Class40_Sub5_Sub14_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class IndexedColorSprite extends Rasterizer
{
    public int anInt2921;
    public int[] anIntArray2922;
    public int anInt2923;
    public int anInt2924;
    public byte[] aByteArray2925;
    public int anInt2926;
    public int anInt2927;
    public int anInt2928;
    
    public IndexedColorSprite method691() {
	IndexedColorSprite class40_sub5_sub14_sub2
	    = new IndexedColorSprite(anInt2921, anInt2926,
					  anIntArray2922.length);
	class40_sub5_sub14_sub2.anInt2923 = anInt2923;
	class40_sub5_sub14_sub2.anInt2924 = anInt2924;
	class40_sub5_sub14_sub2.anInt2928 = anInt2928;
	class40_sub5_sub14_sub2.anInt2927 = anInt2927;
	int i = aByteArray2925.length;
	for (int i_0_ = 0; i_0_ < i; i_0_++)
	    class40_sub5_sub14_sub2.aByteArray2925[i_0_]
		= aByteArray2925[i_0_];
	i = anIntArray2922.length;
	for (int i_1_ = 0; i_1_ < i; i_1_++)
	    class40_sub5_sub14_sub2.anIntArray2922[i_1_]
		= anIntArray2922[i_1_];
	return class40_sub5_sub14_sub2;
    }
    
    public void method692(int arg0, int arg1) {
	arg0 += anInt2928;
	arg1 += anInt2927;
	int i = arg0 + arg1 * Rasterizer.anInt2768;
	int i_2_ = 0;
	int i_3_ = anInt2926;
	int i_4_ = anInt2921;
	int i_5_ = Rasterizer.anInt2768 - i_4_;
	int i_6_ = 0;
	if (arg1 < Rasterizer.anInt2767) {
	    int i_7_ = Rasterizer.anInt2767 - arg1;
	    i_3_ -= i_7_;
	    arg1 = Rasterizer.anInt2767;
	    i_2_ += i_7_ * i_4_;
	    i += i_7_ * Rasterizer.anInt2768;
	}
	if (arg1 + i_3_ > Rasterizer.anInt2770)
	    i_3_ -= arg1 + i_3_ - Rasterizer.anInt2770;
	if (arg0 < Rasterizer.anInt2771) {
	    int i_8_ = Rasterizer.anInt2771 - arg0;
	    i_4_ -= i_8_;
	    arg0 = Rasterizer.anInt2771;
	    i_2_ += i_8_;
	    i += i_8_;
	    i_6_ += i_8_;
	    i_5_ += i_8_;
	}
	if (arg0 + i_4_ > Rasterizer.anInt2772) {
	    int i_9_ = arg0 + i_4_ - Rasterizer.anInt2772;
	    i_4_ -= i_9_;
	    i_6_ += i_9_;
	    i_5_ += i_9_;
	}
	if (i_4_ > 0 && i_3_ > 0)
	    method693(Rasterizer.anIntArray2766, aByteArray2925,
		      anIntArray2922, i_2_, i, i_4_, i_3_, i_5_, i_6_);
    }
    
    public static void method693(int[] arg0, byte[] arg1, int[] arg2, int arg3,
				 int arg4, int arg5, int arg6, int arg7,
				 int arg8) {
	int i = -(arg5 >> 2);
	arg5 = -(arg5 & 0x3);
	for (int i_10_ = -arg6; i_10_ < 0; i_10_++) {
	    for (int i_11_ = i; i_11_ < 0; i_11_++) {
		int i_12_ = arg1[arg3++];
		if (i_12_ != 0)
		    arg0[arg4++] = arg2[i_12_ & 0xff];
		else
		    arg4++;
		i_12_ = arg1[arg3++];
		if (i_12_ != 0)
		    arg0[arg4++] = arg2[i_12_ & 0xff];
		else
		    arg4++;
		i_12_ = arg1[arg3++];
		if (i_12_ != 0)
		    arg0[arg4++] = arg2[i_12_ & 0xff];
		else
		    arg4++;
		i_12_ = arg1[arg3++];
		if (i_12_ != 0)
		    arg0[arg4++] = arg2[i_12_ & 0xff];
		else
		    arg4++;
	    }
	    for (int i_13_ = arg5; i_13_ < 0; i_13_++) {
		int i_14_ = arg1[arg3++];
		if (i_14_ != 0)
		    arg0[arg4++] = arg2[i_14_ & 0xff];
		else
		    arg4++;
	    }
	    arg4 += arg7;
	    arg3 += arg8;
	}
    }
    
    public void method694() {
	if (anInt2921 != anInt2923 || anInt2926 != anInt2924) {
	    byte[] is = new byte[anInt2923 * anInt2924];
	    int i = 0;
	    for (int i_15_ = 0; i_15_ < anInt2926; i_15_++) {
		for (int i_16_ = 0; i_16_ < anInt2921; i_16_++)
		    is[i_16_ + anInt2928 + (i_15_ + anInt2927) * anInt2923]
			= aByteArray2925[i++];
	    }
	    aByteArray2925 = is;
	    anInt2921 = anInt2923;
	    anInt2926 = anInt2924;
	    anInt2928 = 0;
	    anInt2927 = 0;
	}
    }
    
    public void method695() {
	byte[] is = new byte[anInt2921 * anInt2926];
	int i = 0;
	for (int i_17_ = 0; i_17_ < anInt2926; i_17_++) {
	    for (int i_18_ = anInt2921 - 1; i_18_ >= 0; i_18_--)
		is[i++] = aByteArray2925[i_18_ + i_17_ * anInt2921];
	}
	aByteArray2925 = is;
	anInt2928 = anInt2923 - anInt2921 - anInt2928;
    }
    
    public void method696() {
	byte[] is = new byte[anInt2921 * anInt2926];
	int i = 0;
	for (int i_19_ = anInt2926 - 1; i_19_ >= 0; i_19_--) {
	    for (int i_20_ = 0; i_20_ < anInt2921; i_20_++)
		is[i++] = aByteArray2925[i_20_ + i_19_ * anInt2921];
	}
	aByteArray2925 = is;
	anInt2927 = anInt2924 - anInt2926 - anInt2927;
    }
    
    public void method697(int arg0, int arg1, int arg2) {
	for (int i = 0; i < anIntArray2922.length; i++) {
	    int i_21_ = anIntArray2922[i] >> 16 & 0xff;
	    i_21_ += arg0;
	    if (i_21_ < 0)
		i_21_ = 0;
	    else if (i_21_ > 255)
		i_21_ = 255;
	    int i_22_ = anIntArray2922[i] >> 8 & 0xff;
	    i_22_ += arg1;
	    if (i_22_ < 0)
		i_22_ = 0;
	    else if (i_22_ > 255)
		i_22_ = 255;
	    int i_23_ = anIntArray2922[i] & 0xff;
	    i_23_ += arg2;
	    if (i_23_ < 0)
		i_23_ = 0;
	    else if (i_23_ > 255)
		i_23_ = 255;
	    anIntArray2922[i] = (i_21_ << 16) + (i_22_ << 8) + i_23_;
	}
    }
    
    public IndexedColorSprite() {
	/* empty */
    }
    
    public IndexedColorSprite(int arg0, int arg1, int arg2) {
	anInt2923 = anInt2921 = arg0;
	anInt2924 = anInt2926 = arg1;
	anInt2928 = anInt2927 = 0;
	aByteArray2925 = new byte[arg0 * arg1];
	anIntArray2922 = new int[arg2];
    }
}
