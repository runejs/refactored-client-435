/* Class68_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Class68_Sub1 extends Class68
    implements ImageProducer, ImageObserver
{
    public static int anInt2190;
    public static int anInt2191;
    public static int anInt2192;
    public static int anInt2193;
    public ColorModel aColorModel2194;
    public static int anInt2195;
    public static int anInt2196;
    public ImageConsumer anImageConsumer2197;
    public static RSString aClass1_2198
	= Class58.method978(-11538, "Name eingeben:");
    public static int[] anIntArray2199 = new int[32];
    public static int anInt2200;
    public static int anInt2201;
    public static int anInt2202;
    public static int anInt2203;
    public static DirectColorSprite[] aClass40_Sub5_Sub14_Sub4Array2204;
    public static int anInt2205;
    public static int anInt2206;
    public static int[] anIntArray2207 = { 0, -1, 0, 1 };
    public static int anInt2208;
    public static RSString aClass1_2209;
    public static int anInt2210;
    public static int anInt2211;
    public static RSString aClass1_2212;
    public static Class68 aClass68_2213;
    
    public synchronized boolean isConsumer(ImageConsumer arg0) {
	try {
	    anInt2196++;
	    if (anImageConsumer2197 != arg0)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ac.isConsumer(" + (arg0 != null ? "{...}"
						       : "null") + ')');
	}
    }
    
    public static void method1047(int arg0) {
	aClass68_2213 = null;
	aClass40_Sub5_Sub14_Sub4Array2204 = null;
	aClass1_2209 = null;
	aClass1_2198 = null;
	aClass1_2212 = null;
	anIntArray2199 = null;
	anIntArray2207 = null;
	if (arg0 != 0)
	    aClass1_2212 = null;
    }
    
    public synchronized void method1048(byte arg0) {
	try {
	    anInt2191++;
	    if (anImageConsumer2197 != null) {
		int i = -99 / ((7 - arg0) / 62);
		anImageConsumer2197.setPixels(0, 0, anInt1619, anInt1617,
					      aColorModel2194, anIntArray1621,
					      0, anInt1619);
		anImageConsumer2197.imageComplete(2);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ac.G(" + arg0 + ')');
	}
    }
    
    public void method1044(int arg0, int arg1, Graphics arg2, int arg3) {
	try {
	    if (arg0 != 0)
		anIntArray2199 = null;
	    anInt2202++;
	    method1048((byte) -65);
	    arg2.drawImage(anImage1625, arg1, arg3, this);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.E(" + arg0 + ',' + arg1 + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + arg3 + ')'));
	}
    }
    
    public static void method1049(Player arg0, byte arg1,
				  int arg2, int arg3) {
	if (arg1 <= 14)
	    method1049(null, (byte) 8, -14, 82);
	anInt2200++;
	if ((0x100 & arg2) != 0) {
	    int i = Cache.outgoingbuffer.method480((byte) -70);
	    int i_0_ = Cache.outgoingbuffer.method476(255);
	    arg0.method785(i_0_, Node.anInt926, i, -122);
	    arg0.anInt3139 = 300 + Node.anInt926;
	    arg0.anInt3130
		= Cache.outgoingbuffer.method480((byte) -70);
	    arg0.anInt3101 = Cache.outgoingbuffer.method476(255);
	}
	if ((arg2 & 0x10 ^ 0xffffffff) != -1) {
	    arg0.anInt3148 = Cache.outgoingbuffer.method469(65280);
	    arg0.anInt3100
		= Cache.outgoingbuffer.method490((byte) -70);
	}
	if ((arg2 & 0x1 ^ 0xffffffff) != -1) {
	    int i = Cache.outgoingbuffer.method490((byte) -70);
	    if (i == 65535)
		i = -1;
	    int i_1_ = Cache.outgoingbuffer.method471((byte) -17);
	    NpcDefinition.method570(i, i_1_, arg0, -1);
	}
	if ((arg2 & 0x4) != 0) {
	    arg0.anInt3137
		= Cache.outgoingbuffer.method461((byte) 75);
	    if ((arg0.anInt3137 ^ 0xffffffff) == -65536)
		arg0.anInt3137 = -1;
	}
	if ((0x40 & arg2) != 0) {
	    int i = Cache.outgoingbuffer.method468(false);
	    int i_2_ = Cache.outgoingbuffer.method476(255);
	    arg0.method785(i_2_, Node.anInt926, i, -123);
	    arg0.anInt3139 = 300 + Node.anInt926;
	    arg0.anInt3130 = Cache.outgoingbuffer.method476(255);
	    arg0.anInt3101 = Cache.outgoingbuffer.method476(255);
	}
	if ((arg2 & 0x400) != 0) {
	    arg0.anInt3125
		= Cache.outgoingbuffer.method480((byte) -70);
	    arg0.anInt3081
		= Cache.outgoingbuffer.method480((byte) -70);
	    arg0.anInt3099 = Cache.outgoingbuffer.method468(false);
	    arg0.anInt3127 = Cache.outgoingbuffer.method468(false);
	    arg0.anInt3112
		= (Cache.outgoingbuffer.method461((byte) 124)
		   - -Node.anInt926);
	    arg0.anInt3107 = (Cache.outgoingbuffer.method504(false)
			      - -Node.anInt926);
	    arg0.anInt3073 = Cache.outgoingbuffer.method476(255);
	    arg0.method790(0);
	}
	if ((0x8 & arg2 ^ 0xffffffff) != -1) {
	    int i = Cache.outgoingbuffer.method469(65280);
	    int i_3_ = Cache.outgoingbuffer.method476(255);
	    int i_4_ = Cache.outgoingbuffer.method471((byte) 117);
	    int i_5_ = Cache.outgoingbuffer.offset;
	    if (arg0.aClass1_3278 != null && arg0.aClass30_3282 != null) {
		long l = arg0.aClass1_3278.method58((byte) 101);
		boolean bool = false;
		if (i_3_ <= 1) {
		    for (int i_6_ = 0; i_6_ < Class42.anInt1008; i_6_++) {
			if ((Class53.aLongArray1267[i_6_]
			     ^ 0xffffffffffffffffL)
			    == (l ^ 0xffffffffffffffffL)) {
			    bool = true;
			    break;
			}
		    }
		}
		if (!bool && Class4.anInt182 == 0) {
		    Class59.aClass40_Sub1_1385.offset = 0;
		    Cache.outgoingbuffer.putBytes128((byte) -80, 0, Class59.aClass40_Sub1_1385.payload, i_4_);
		    Class59.aClass40_Sub1_1385.offset = 0;
		    RSString class1 = Class54.method956 (124, Class59.aClass40_Sub1_1385).method53(-16315);
		    arg0.aClass1_3090 = class1.method89(false);
		    arg0.anInt3078 = 150;
		    arg0.anInt3123 = i & 0xff;
		    arg0.anInt3102 = i >> 8;
		    if ((i_3_ ^ 0xffffffff) == -3 || (i_3_ ^ 0xffffffff) == -4)
			Class44.method895(68, 1, class1, (Class40_Sub5_Sub17_Sub6.method832
					   (75,
					    (new RSString[]
					     { Class40_Sub5_Sub12.aClass1_2729,
					       arg0.aClass1_3278 }))));
		    else if ((i_3_ ^ 0xffffffff) == -2)
			Class44.method895(123, 1, class1,
					  (Class40_Sub5_Sub17_Sub6.method832
					   (-79, (new RSString[]
						  { Class51.aClass1_1210,
						    arg0.aClass1_3278 }))));
		    else
			Class44.method895(127, 2, class1, arg0.aClass1_3278);
		}
	    }
	    Cache.outgoingbuffer.offset = i_4_ + i_5_;
	}
	if ((0x20 & arg2) != 0) {
	    int i = Cache.outgoingbuffer.method468(false);
	    byte[] is = new byte[i];
	    Buffer buffer = new Buffer(is);
	    Cache.outgoingbuffer.method497(is, 0, i, (byte) 45);
	    Class22.aClass40_Sub1Array534[arg3] = buffer;
	    arg0.method791((byte) -85, buffer);
	}
	if ((arg2 & 0x200) != 0) {
	    arg0.anInt3091
		= Cache.outgoingbuffer.method490((byte) -70);
	    int i = Cache.outgoingbuffer.method470(-117);
	    arg0.anInt3129 = 0;
	    arg0.anInt3093 = Node.anInt926 + (i & 0xffff);
	    if ((arg0.anInt3091 ^ 0xffffffff) == -65536)
		arg0.anInt3091 = -1;
	    arg0.anInt3140 = 0;
	    arg0.anInt3110 = i >> -1354160784;
	    if (arg0.anInt3093 > Node.anInt926)
		arg0.anInt3140 = -1;
	}
	if ((0x80 & arg2 ^ 0xffffffff) != -1) {
	    arg0.aClass1_3090 = Cache.outgoingbuffer.getRSString(-10721);
	    if (arg0.aClass1_3090.method55(0, false) != 126) {
		if (arg0 == Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760)
		    Class44.method895(99, 2, arg0.aClass1_3090, arg0.aClass1_3278);
	    } else {
		arg0.aClass1_3090 = arg0.aClass1_3090.method50((byte) 95, 1);
		Class44.method895(120, 2, arg0.aClass1_3090, arg0.aClass1_3278);
	    }
	    arg0.anInt3078 = 150;
	    arg0.anInt3102 = 0;
	    arg0.anInt3123 = 0;
	}
    }
    
    public synchronized void removeConsumer(ImageConsumer arg0) {
	try {
	    if (arg0 == anImageConsumer2197)
		anImageConsumer2197 = null;
	    anInt2193++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,  ("ac.removeConsumer(" + (arg0 != null ? "{...}" : "null") + ')'));
	}
    }
    
    public static Class40_Sub5_Sub7 method1050(int arg0, int arg1) {
	try {
	    anInt2208++;
	    Class40_Sub5_Sub7 class40_sub5_sub7
		= ((Class40_Sub5_Sub7)
		   Class40_Sub5_Sub6.aClass9_2439.method231((long) arg0,
							    (byte) 47));
	    if (arg1 != 2)
		anInt2211 = -106;
	    if (class40_sub5_sub7 != null)
		return class40_sub5_sub7;
	    byte[] is
		= Class40_Sub5_Sub7.aClass6_2484.method172(arg0, 115, 12);
	    class40_sub5_sub7 = new Class40_Sub5_Sub7();
	    if (is != null)
		class40_sub5_sub7.method594(-1, new Buffer(is));
	    class40_sub5_sub7.method591((byte) 37);
	    Class40_Sub5_Sub6.aClass9_2439.method230(arg1 + -7210, (long) arg0,
						     class40_sub5_sub7);
	    return class40_sub5_sub7;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ac.F(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void requestTopDownLeftRightResend(ImageConsumer arg0) {
	try {
	    anInt2195++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.requestTopDownLeftRightResend("
				    + (arg0 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public static boolean method1051(int arg0, Class40_Sub5_Sub12 arg1) {
	try {
	    if (arg0 != 300)
		return false;
	    anInt2201++;
	    int i = arg1.anInt2639;
	    if (i >= 1 && i <= 200 || i >= 701 && i <= 900) {
		HashTable.anInt557++;
		if (i >= 801)
		    i -= 701;
		else if (i >= 701)
		    i -= 601;
		else if (i < 101)
		    i--;
		else
		    i -= 101;
		Class40_Sub7.anInt2122++;
		Floor.method558
		    (0, Class66.aClass1_1572, 0, arg0 + -801, 0, 13,
		     Class40_Sub5_Sub17_Sub6.method832(arg0 ^ ~0x103,
						       (new RSString[]
							{ Class26.aClass1_620,
							  (Class40_Sub11
							   .aClass1Array2147
							   [i]) })));
		Floor.method558
		    (0, Class58.aClass1_1354, 0, -501, 0, 18,
		     Class40_Sub5_Sub17_Sub6.method832(arg0 + -192,
						       (new RSString[]
							{ Class26.aClass1_620,
							  (Class40_Sub11
							   .aClass1Array2147
							   [i]) })));
		return true;
	    }
	    if (i >= 401 && (i ^ 0xffffffff) >= -501) {
		Class6_Sub1.anInt1793++;
		Floor.method558(0, Class66.aClass1_1572, 0, -501,
					    0, 35,
					    (Class40_Sub5_Sub17_Sub6.method832
					     (115, (new RSString[]
						    { Class26.aClass1_620,
						      arg1.aClass1_2668 }))));
		return true;
	    }
	    return false;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.D(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public static int method1052(int arg0, RSString arg1, Buffer arg2) {
	try {
	    if (arg0 < 24)
		aClass1_2209 = null;
	    anInt2205++;
	    int i = arg2.offset;
	    arg2.method509(arg1.anInt1680, 32768);
	    arg2.offset += (Class40_Sub5_Sub10.aClass66_2590.method1026
			       (-18678, 0, arg2.offset, arg1.anInt1680,
				arg1.aByteArray1692, arg2.payload));
	    return -i + arg2.offset;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.C(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + (arg2 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			       int arg4, int arg5) {
	try {
	    anInt2190++;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.imageUpdate("
				    + (arg0 != null ? "{...}" : "null") + ','
				    + arg1 + ',' + arg2 + ',' + arg3 + ','
				    + arg4 + ',' + arg5 + ')'));
	}
    }
    
    public synchronized void addConsumer(ImageConsumer arg0) {
	try {
	    anImageConsumer2197 = arg0;
	    arg0.setDimensions(anInt1619, anInt1617);
	    anInt2203++;
	    arg0.setProperties(null);
	    arg0.setColorModel(aColorModel2194);
	    arg0.setHints(14);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ac.addConsumer(" + (arg0 != null ? "{...}"
							: "null") + ')');
	}
    }
    
    public void method1041(int arg0, int arg1, Component arg2, int arg3) {
	try {
	    anIntArray1621 = new int[1 + arg1 * arg3];
	    anInt1619 = arg1;
	    anInt2206++;
	    anInt1617 = arg3;
	    aColorModel2194 = new DirectColorModel(32, 16711680, 65280, 255);
	    anImage1625 = arg2.createImage(this);
	    method1048((byte) -100);
	    arg2.prepareImage(anImage1625, this);
	    if (arg0 < 4)
		method1048((byte) -7);
	    method1048((byte) -95);
	    arg2.prepareImage(anImage1625, this);
	    method1048((byte) -81);
	    arg2.prepareImage(anImage1625, this);
	    this.method1046((byte) 90);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.A(" + arg0 + ',' + arg1 + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + arg3 + ')'));
	}
    }
    
    public void startProduction(ImageConsumer arg0) {
	try {
	    addConsumer(arg0);
	    anInt2192++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ac.startProduction("
				    + (arg0 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    static {
	int i = 2;
	for (int i_7_ = 0; i_7_ < 32; i_7_++) {
	    anIntArray2199[i_7_] = -1 + i;
	    i += i;
	}
	anInt2211 = 2;
	aClass1_2212 = Class58.method978(-11538, "Login server offline)3");
	aClass1_2209 = aClass1_2212;
    }
}
