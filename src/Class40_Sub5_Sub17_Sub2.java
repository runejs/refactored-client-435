/* Class40_Sub5_Sub17_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Class40_Sub5_Sub17_Sub2 extends Class40_Sub5_Sub17
{
    public int anInt3016;
    public static int anInt3017;
    public int anInt3018;
    public static Class62 aClass62_3019 = new Class62();
    public static int anInt3020;
    public int anInt3021;
    public static int anInt3022;
    public static int anInt3023;
    public int anInt3024;
    public static int anInt3025;
    public int anInt3026;
    public int anInt3027;
    public static int anInt3028;
    public int anInt3029;
    public int anInt3030;
    public static int anInt3031;
    public static int anInt3032;
    public static int anInt3033;
    public Class40_Sub5_Sub7 aClass40_Sub5_Sub7_3034;
    public int anInt3035;
    public static RSString aClass1_3036;
    public static RSString aClass1_3037;
    public static RSString aClass1_3038;
    public static RSString aClass1_3039;
    public static int anInt3040;
    public static RSString aClass1_3041
	= Class58.method978(-11538, "Loaded gamescreen");
    public static Class68 aClass68_3042;
    public static RSString aClass1_3043;
    public static RSString aClass1_3044;
    public static Class68 aClass68_3045;
    public static RSString aClass1_3046;
    public static RSString aClass1_3047;
    public static int anInt3048;
    
    public static void method768(int arg0) {
	try {
	    Class17.anInt460 = 0;
	    anInt3023++;
	    Class40_Sub5_Sub17_Sub4.anInt3153 = 0;
	    Class40_Sub5_Sub17_Sub1.method759(false);
	    Class42.method889(48);
	    Class13.method245(3799);
	    if (arg0 > 75) {
		for (int i = 0;
		     (Class17.anInt460 ^ 0xffffffff) < (i ^ 0xffffffff); i++) {
		    int i_0_ = Class6.anIntArray225[i];
		    if (Node.anInt926
			!= (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813
			    [i_0_].anInt3134)) {
			Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813
			    [i_0_].aClass40_Sub5_Sub5_3300
			    = null;
			Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813
			    [i_0_]
			    = null;
		    }
		}
		if ((Class40_Sub5_Sub12.packetsize ^ 0xffffffff)
		    != (Cache.outgoingbuffer.offset ^ 0xffffffff))
		    throw new RuntimeException("gnp1 pos:"
					       + (Cache.outgoingbuffer
						  .offset)
					       + " psize:"
					       + Class40_Sub5_Sub12.packetsize);
		for (int i = 0; Class40_Sub5_Sub8.anInt2558 > i; i++) {
		    if ((Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813
			 [Class40_Sub3.anIntArray2016[i]])
			== null)
			throw new RuntimeException("gnp2 pos:" + i + " size:"
						   + (Class40_Sub5_Sub8
						      .anInt2558));
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "j.A(" + arg0 + ')');
	}
    }
    
    public static IndexedColorSprite method769(int arg0, Class6 arg1,
						    int arg2) {
	try {
	    if (arg0 != 2)
		method771(-42, null, null, null, -3, (byte) -48);
	    anInt3032++;
	    if (!Buffer.method472(arg0 ^ ~0x69, arg1, arg2))
		return null;
	    return SubNode.method538(0);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("j.F(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + arg2 + ')'));
	}
    }
    
    public static void method770(byte arg0) {
	try {
	    aClass1_3037 = null;
	    aClass1_3047 = null;
	    aClass68_3042 = null;
	    aClass1_3046 = null;
	    int i = 17 % ((arg0 - -10) / 62);
	    aClass1_3041 = null;
	    aClass1_3044 = null;
	    aClass68_3045 = null;
	    aClass62_3019 = null;
	    aClass1_3038 = null;
	    aClass1_3036 = null;
	    aClass1_3039 = null;
	    aClass1_3043 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "j.E(" + arg0 + ')');
	}
    }
    
    public static void method771(int arg0, Class2 arg1, Class3[] arg2,
				 byte[] arg3, int arg4, byte arg5) {
	try {
	    if (arg5 >= -76)
		method771(-120, null, null, null, -1, (byte) -104);
	    Buffer class40_sub1 = new Buffer(arg3);
	    anInt3022++;
	    int i = -1;
	    for (;;) {
		int i_1_ = class40_sub1.method502((byte) 52);
		if ((i_1_ ^ 0xffffffff) == -1)
		    break;
		int i_2_ = 0;
		i += i_1_;
		for (;;) {
		    int i_3_ = class40_sub1.method502((byte) 62);
		    if ((i_3_ ^ 0xffffffff) == -1)
			break;
		    i_2_ += -1 + i_3_;
		    int i_4_ = 0x3f & i_2_;
		    int i_5_ = (i_2_ & 0xfc3) >> 586500870;
		    int i_6_ = i_2_ >> 1983594540;
		    int i_7_ = class40_sub1.method468(false);
		    int i_8_ = i_7_ >> 1990285058;
		    int i_9_ = 0x3 & i_7_;
		    int i_10_ = i_5_ + arg0;
		    int i_11_ = i_4_ - -arg4;
		    if (i_10_ > 0 && i_11_ > 0 && (i_10_ ^ 0xffffffff) > -104
			&& (i_11_ ^ 0xffffffff) > -104) {
			Class3 class3 = null;
			int i_12_ = i_6_;
			if (((Floor.aByteArrayArrayArray2323[1]
			      [i_10_][i_11_])
			     & 0x2)
			    == 2)
			    i_12_--;
			if ((i_12_ ^ 0xffffffff) <= -1)
			    class3 = arg2[i_12_];
			Class40_Sub5_Sub17_Sub1.method767(i, i_8_, i_9_, i_6_, arg1, -18, i_11_, i_10_, class3
			);
		    }
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("j.D(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + (arg3 != null ? "{...}" : "null") + ','
				    + arg4 + ',' + arg5 + ')'));
	}
    }
    
    public static void drawLoadingText(int arg0, Color color, RSString rsString, int arg3) {
	try {
	    anInt3033++;
	    try {
		Graphics graphics = Class62.aCanvas1469.getGraphics();
		if (Class17.aFont461 == null) {
		    Class17.aFont461 = new Font("Helvetica", 1, 13);
		    Class8.aFontMetrics295
			= Class62.aCanvas1469.getFontMetrics(Class17.aFont461);
		}
		if (Class40_Sub5_Sub11.aBoolean2631) {
		    Class40_Sub5_Sub11.aBoolean2631 = false;
		    graphics.setColor(Color.black);
		    graphics.fillRect(0, 0, Class12.anInt390,
				      Class40_Sub5_Sub10.anInt2605);
		}
		if (color == null)
		    color = new Color(140, 17, 17);
		try {
		    if (Class26.anImage624 == null)
			Class26.anImage624
			    = Class62.aCanvas1469.createImage(304, 34);
		    Graphics graphics_13_ = Class26.anImage624.getGraphics();
		    graphics_13_.setColor(color);
		    int i = -71 % ((arg3 - 8) / 54);
		    graphics_13_.drawRect(0, 0, 303, 33);
		    graphics_13_.fillRect(2, 2, arg0 * 3, 30);
		    graphics_13_.setColor(Color.black);
		    graphics_13_.drawRect(1, 1, 301, 31);
		    graphics_13_.fillRect(2 - -(3 * arg0), 2, 300 - 3 * arg0,
					  30);
		    graphics_13_.setFont(Class17.aFont461);
		    graphics_13_.setColor(Color.white);
		    rsString.method65((byte) -124,
				  ((304
				    + -rsString.method73(-48,
						     Class8.aFontMetrics295))
				   / 2),
				  22, graphics_13_);
			System.out.println(rsString.str);
		    graphics.drawImage(Class26.anImage624,
				       -152 + Class12.anInt390 / 2,
				       -18 + Class40_Sub5_Sub10.anInt2605 / 2,
				       null);
		} catch (Exception exception) {
		    int i = -152 + Class12.anInt390 / 2;
		    int i_14_ = Class40_Sub5_Sub10.anInt2605 / 2 + -18;
		    graphics.setColor(color);
		    graphics.drawRect(i, i_14_, 303, 33);
		    graphics.fillRect(2 + i, i_14_ - -2, 3 * arg0, 30);
		    graphics.setColor(Color.black);
		    graphics.drawRect(i + 1, 1 + i_14_, 301, 31);
		    graphics.fillRect(arg0 * 3 + 2 + i, 2 + i_14_,
				      300 + -(3 * arg0), 30);
		    graphics.setFont(Class17.aFont461);
		    graphics.setColor(Color.white);
		    rsString.method65((byte) -32,
				  (-rsString.method73(-46, Class8.aFontMetrics295)
				   + 304) / 2 + i,
				  22 + i_14_, graphics);
		}
	    } catch (Exception exception) {
		Class62.aCanvas1469.repaint();
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("j.B(" + arg0 + ','
				    + (color != null ? "{...}" : "null") + ','
				    + (rsString != null ? "{...}" : "null") + ','
				    + arg3 + ')'));
	}
    }
    
    public static void method773(byte arg0, RSString arg1) {
	try {
	    anInt3017++;
	    if (arg1 == null || arg1.method59(-3136) == 0)
		Class46.anInt1110 = 0;
	    else {
		RSString class1 = arg1;
		RSString[] class1s = new RSString[100];
		if (arg0 != -96)
		    aClass1_3043 = null;
		int i = 0;
		for (;;) {
		    int i_15_ = class1.method57((byte) -5, 32);
		    if (i_15_ == -1) {
			class1 = class1.method89(false);
			if ((class1.method59(arg0 ^ 0xc60) ^ 0xffffffff) < -1)
			    class1s[i++]
				= class1.method79(RSApplet.method27(arg0,
								       32));
			break;
		    }
		    RSString class1_16_
			= class1.method68(0, 0, i_15_).method89(false);
		    if ((class1_16_.method59(-3136) ^ 0xffffffff) < -1)
			class1s[i++] = class1_16_.method79(arg0 + -32);
		    class1 = class1.method50((byte) 95, 1 + i_15_);
		}
		Class46.anInt1110 = 0;
		int i_17_ = 0;
	    while_12_:
		for (/**/; Class27.anInt661 > i_17_; i_17_++) {
		    ItemDefinition class40_sub5_sub16
			= Class44.method897(i_17_, 10);
		    if ((class40_sub5_sub16.anInt2807 ^ 0xffffffff) == 0
			&& class40_sub5_sub16.aClass1_2796 != null) {
			RSString class1_18_ = class40_sub5_sub16.aClass1_2796
						.method79(arg0 + -32);
			for (int i_19_ = 0; i_19_ < i; i_19_++) {
			    if (class1_18_.method60(class1s[i_19_], 32) == -1)
				continue while_12_;
			}
			Class22_Sub1.aClass1Array1844[Class46.anInt1110]
			    = class1_18_;
			Class5.anIntArray191[Class46.anInt1110] = i_17_;
			Class46.anInt1110++;
			if ((Class46.anInt1110 ^ 0xffffffff)
			    <= (Class22_Sub1.aClass1Array1844.length
				^ 0xffffffff))
			    break;
		    }
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("j.C(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public Model method756(int arg0) {
	try {
	    if (aClass40_Sub5_Sub7_3034 != null) {
		int i = -anInt3024 + Node.anInt926;
		if (i > 100
		    && (aClass40_Sub5_Sub7_3034.anInt2497 ^ 0xffffffff) < -1)
		    i = 100;
		while (aClass40_Sub5_Sub7_3034.anIntArray2466[anInt3026] < i) {
		    i -= aClass40_Sub5_Sub7_3034.anIntArray2466[anInt3026];
		    anInt3026++;
		    if ((aClass40_Sub5_Sub7_3034.anIntArray2485.length
			 ^ 0xffffffff)
			>= (anInt3026 ^ 0xffffffff)) {
			anInt3026 -= aClass40_Sub5_Sub7_3034.anInt2497;
			if ((anInt3026 ^ 0xffffffff) > -1
			    || (aClass40_Sub5_Sub7_3034.anIntArray2485.length
				^ 0xffffffff) >= (anInt3026 ^ 0xffffffff)) {
			    aClass40_Sub5_Sub7_3034 = null;
			    break;
			}
		    }
		}
		anInt3024 = -i + Node.anInt926;
	    }
	    anInt3031++;
	    Class40_Sub5_Sub8 class40_sub5_sub8
		= Class40_Sub4.method535(anInt3035, (byte) 123);
	    int i = 83 % ((41 - arg0) / 47);
	    if (class40_sub5_sub8.anIntArray2534 != null)
		class40_sub5_sub8 = class40_sub5_sub8.method611(-20);
	    if (class40_sub5_sub8 == null)
		return null;
	    return class40_sub5_sub8.method607(anInt3029, 103, anInt3030,
					       anInt3026, anInt3021, anInt3018,
					       aClass40_Sub5_Sub7_3034,
					       anInt3027, anInt3016);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "j.UA(" + arg0 + ')');
	}
    }
    
    public static void method774(byte arg0) {
	anInt3025++;
	Buffer.aClass9_1933.method235((byte) -88);
	if (arg0 != -96)
	    aClass1_3047 = null;
    }
    
    public Class40_Sub5_Sub17_Sub2(int arg0, int arg1, int arg2, int arg3,
				   int arg4, int arg5, int arg6, int arg7,
				   boolean arg8) {
	anInt3029 = arg3;
	anInt3035 = arg0;
	anInt3027 = arg6;
	anInt3018 = arg2;
	anInt3030 = arg4;
	anInt3016 = arg5;
	anInt3021 = arg1;
	if (arg7 != -1) {
	    aClass40_Sub5_Sub7_3034 = Class68_Sub1.method1050(arg7, 2);
	    anInt3026 = 0;
	    anInt3024 = -1 + Node.anInt926;
	    if (arg8 && aClass40_Sub5_Sub7_3034.anInt2497 != -1) {
		anInt3026 = (int) ((double) (aClass40_Sub5_Sub7_3034
					     .anIntArray2485).length
				   * Math.random());
		anInt3024 -= (int) (Math.random()
				    * (double) (aClass40_Sub5_Sub7_3034
						.anIntArray2466[anInt3026]));
	    }
	}
    }
    
    static {
	anInt3040 = 0;
	aClass1_3036 = Class58.method978(-11538, "Accept challenge");
	aClass1_3037 = Class58.method978(-11538, "Okay");
	aClass1_3038 = aClass1_3041;
	aClass1_3047 = Class58.method978(-11538, "mapfunction");
	aClass1_3043
	    = Class58.method978(-11538, "Bitte laden Sie die Seite neu)3");
	aClass1_3046 = Class58.method978(-11538, "Absender:");
	aClass1_3039 = aClass1_3036;
	anInt3048 = 1;
	aClass1_3044 = Class58.method978(-11538, "");
    }
}
