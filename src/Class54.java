/* Class54 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Class54 implements KeyListener, FocusListener
{
    public static RSString aClass1_1271
	= Class58.method978(-11538, "Benutzername: ");
    public static int anInt1272;
    public static int anInt1273;
    public static int anInt1274;
    public static int anInt1275;
    public static int anInt1276;
    public static int anInt1277;
    public static Class45 aClass45_1278 = new Class45();
    public static int anInt1279;
    public static int anInt1280;
    public static int anInt1281;
    public static int[] anIntArray1282 = new int[256];
    public static RSString aClass1_1283;
    public static RSString aClass1_1284;
    public static Class68 aClass68_1285;
    
    public void keyTyped(KeyEvent arg0) {
	try {
	    arg0.consume();
	    anInt1275++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "re.keyTyped(" + (arg0 != null ? "{...}"
						     : "null") + ')');
	}
    }
    
    public void focusGained(FocusEvent arg0) {
	try {
	    anInt1281++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "re.focusGained(" + (arg0 != null ? "{...}"
							: "null") + ')');
	}
    }
    
    public static void method953(byte arg0) {
	try {
	    if (arg0 > -32)
		method957(75, false, false, (byte) 125, true);
	    aClass1_1271 = null;
	    aClass1_1283 = null;
	    aClass68_1285 = null;
	    aClass45_1278 = null;
	    anIntArray1282 = null;
	    aClass1_1284 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "re.A(" + arg0 + ')');
	}
    }
    
    public static void method954(int arg0) {
	Class10.method238(4);
	if (Class45.anInt1075 == 1)
	    Class37.aClass40_Sub5_Sub14_Sub4Array878
		[Floor.anInt2319 / 100].method721
		(-4 + Class40_Sub11.anInt2163 + -8,
		 -8 + (Class40_Sub5_Sub1.anInt2276 - 4));
	if ((Class45.anInt1075 ^ 0xffffffff) == -3)
	    Class37.aClass40_Sub5_Sub14_Sub4Array878
		[4 + Floor.anInt2319 / 100].method721
		(-8 + Class40_Sub11.anInt2163 - 4,
		 -4 + Class40_Sub5_Sub1.anInt2276 - 8);
	if (arg0 == -15454) {
	    anInt1276++;
	    if (Class58.anInt1376 != -1) {
		Class40_Sub5_Sub17.method754(29378, Class58.anInt1376);
		Class40_Sub5_Sub6.method583(0, Class58.anInt1376, 334,
					    (byte) -5, 0, 4, 512);
	    }
	    if ((Class66.anInt1560 ^ 0xffffffff) != 0) {
		Class40_Sub5_Sub17.method754(29378, Class66.anInt1560);
		Class40_Sub5_Sub6.method583(0, Class66.anInt1560, 334,
					    (byte) -5, 0, 0, 512);
	    }
	    RSString.method71(arg0 ^ 0x3c7b);
	    if (Class4.aBoolean173) {
		if (Class40_Sub5_Sub17_Sub1.anInt2983 == 0)
		    Class40_Sub5_Sub6.method588(-1);
	    } else {
		Class43.method894(false);
		Class40_Sub4.method537(4);
	    }
	    if (Class40_Sub6.anInt2118 == 1)
		Class45.aClass40_Sub5_Sub14_Sub4_1057.method721(472, 296);
	    if (Class19.aBoolean496) {
		int i = 20;
		int i_0_ = 507;
		int i_1_ = 16776960;
		if (Class52.anInt1219 < 30 && Class46.aBoolean1112)
		    i_1_ = 16711680;
		if ((Class52.anInt1219 ^ 0xffffffff) > -21
		    && !Class46.aBoolean1112)
		    i_1_ = 16711680;
		Class53.aClass40_Sub5_Sub14_Sub1_1268.method687
		    ((Class40_Sub5_Sub17_Sub6.method832
		      (-88, new RSString[] { Class61.aClass1_1446,
					   HashTable.method334(Class52.anInt1219,
							     -1) })),
		     i_0_, i, i_1_);
		i_1_ = 16776960;
		i += 15;
		Runtime runtime = Runtime.getRuntime();
		int i_2_
		    = (int) ((runtime.totalMemory() + -runtime.freeMemory())
			     / 1024L);
		if (i_2_ > 32768 && Class46.aBoolean1112)
		    i_1_ = 16711680;
		if ((i_2_ ^ 0xffffffff) < -65537 && !Class46.aBoolean1112)
		    i_1_ = 16711680;
		Class53.aClass40_Sub5_Sub14_Sub1_1268.method687
		    ((Class40_Sub5_Sub17_Sub6.method832
		      (81,
		       new RSString[] { Class40_Sub7.aClass1_2129,
				      HashTable.method334(i_2_, arg0 ^ 0x3c5d),
				      RSCanvas.aClass1_68 })),
		     i_0_, i, i_1_);
		i += 15;
		if (Class38.aBoolean893) {
		    Class53.aClass40_Sub5_Sub14_Sub1_1268
			.method687(Class66.aClass1_1544, i_0_, i, 16711680);
		    i += 15;
		    Class38.aBoolean893 = false;
		}
		if (Class6.aBoolean260) {
		    Class53.aClass40_Sub5_Sub14_Sub1_1268
			.method687(Class58.aClass1_1378, i_0_, i, 16711680);
		    i += 15;
		    Class6.aBoolean260 = false;
		}
		if (Class40_Sub3.aBoolean2026) {
		    Class53.aClass40_Sub5_Sub14_Sub1_1268
			.method687(Class66.aClass1_1546, i_0_, i, 16711680);
		    Class40_Sub3.aBoolean2026 = false;
		    i += 15;
		}
	    }
	    if ((Class40_Sub5_Sub15.anInt2782 ^ 0xffffffff) != -1) {
		int i = Class40_Sub5_Sub15.anInt2782 / 50;
		int i_3_ = i / 60;
		i %= 60;
		if (i < 10)
		    Class53.aClass40_Sub5_Sub14_Sub1_1268.method690
			((Class40_Sub5_Sub17_Sub6.method832
			  (86, new RSString[] { Class61.aClass1_1432,
					      HashTable.method334(i_3_,
								arg0 ^ 0x3c5d),
					      Class17.aClass1_465,
					      HashTable.method334(i, -1) })),
			 4, 329, 16776960);
		else
		    Class53.aClass40_Sub5_Sub14_Sub1_1268.method690
			((Class40_Sub5_Sub17_Sub6.method832
			  (70,
			   new RSString[] { Class61.aClass1_1432,
					  HashTable.method334(i_3_, -1),
					  Class43.aClass1_1027,
					  HashTable.method334(i,
							    arg0 ^ 0x3c5d) })),
			 4, 329, 16776960);
	    }
	}
    }
    
    public static int method955(Class6 arg0, byte arg1) {
	try {
	    anInt1277++;
	    int i = 0;
	    if (arg0.method194(Class27.aClass1_638, Class8.aClass1_305, -1234))
		i++;
	    if (arg0.method194(RSString.aClass1_1716, Class8.aClass1_305,
			       arg1 + -1175))
		i++;
	    if (arg0.method194(Class46.aClass1_1113, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Class59.aClass1_1395, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Class6.aClass1_256, Class8.aClass1_305,
			       arg1 ^ 0x4eb))
		i++;
	    if (arg0.method194(Class10.aClass1_338, Class8.aClass1_305, -1234))
		i++;
	    if (arg0.method194(Class61.aClass1_1440, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Class43.aClass1_1024, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Class8.aClass1_281, Class8.aClass1_305, -1234))
		i++;
	    if (arg0.method194(Class53.aClass1_1266, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Main.aClass1_1788, Class8.aClass1_305, -1234))
		i++;
	    if (arg0.method194(Class58.aClass1_1374, Class8.aClass1_305,
			       arg1 ^ 0x4eb))
		i++;
	    if (arg0.method194(Class40_Sub5_Sub10.aClass1_2588,
			       Class8.aClass1_305, -1234))
		i++;
	    if (arg1 != -59)
		aClass1_1271 = null;
	    if (arg0.method194(Class5.aClass1_196, Class8.aClass1_305, -1234))
		i++;
	    if (arg0.method194(Class8.aClass1_304, Class8.aClass1_305, -1234))
		i++;
	    if (arg0.method194(SubNode.aClass1_2093, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Class40_Sub5_Sub17_Sub6.aClass1_3254,
			       Class8.aClass1_305, arg1 + -1175))
		i++;
	    if (arg0.method194(Class64.aClass1_1517, Class8.aClass1_305,
			       -1234))
		i++;
	    if (arg0.method194(Class40_Sub5_Sub15.aClass1_2787,
			       Class8.aClass1_305, -1234))
		i++;
	    return i;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("re.D(" + (arg0 != null ? "{...}" : "null")
				    + ',' + arg1 + ')'));
	}
    }
    
    public static RSString method956(int arg0, Buffer arg1) {
	try {
	    if (arg0 < 62)
		aClass45_1278 = null;
	    anInt1279++;
	    return Class22.method307(arg1, -1, 32767);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("re.B(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public static Class6_Sub1 method957(int arg0, boolean arg1, boolean arg2,
					byte arg3, boolean arg4) {
	try {
	    anInt1272++;
	    Class56 class56 = null;
	    if (Class40_Sub5_Sub2.aClass67_2298 != null)
		class56
		    = new Class56(arg0, Class40_Sub5_Sub2.aClass67_2298,
				  Class40_Sub5_Sub6.aClass67Array2436[arg0],
				  1000000);
	    if (arg3 < 116)
		method955(null, (byte) -86);
	    return new Class6_Sub1(class56, Class40_Sub5_Sub4.aClass56_2356,
				   arg0, arg2, arg4, arg1);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("re.E(" + arg0 + ',' + arg1 + ',' + arg2
				    + ',' + arg3 + ',' + arg4 + ')'));
	}
    }
    
    public synchronized void focusLost(FocusEvent arg0) {
	anInt1274++;
	if (Class59.aClass54_1392 != null)
	    Class40_Sub5_Sub8.anInt2543 = -1;
    }
    
    public synchronized void keyPressed(KeyEvent arg0) {
	try {
	    anInt1273++;
	    if (Class59.aClass54_1392 != null) {
		Class49.anInt1147 = 0;
		int i = arg0.getKeyCode();
		if ((i ^ 0xffffffff) <= -1
		    && (i ^ 0xffffffff) > (Class66.anIntArray1564.length
					   ^ 0xffffffff)) {
		    i = Class66.anIntArray1564[i];
		    if ((0x80 & i ^ 0xffffffff) != -1)
			i = -1;
		} else
		    i = -1;
		int i_4_;
		if (i == 85 || (i ^ 0xffffffff) == -81 || i == 84
		    || (i ^ 0xffffffff) == -1 || (i ^ 0xffffffff) == -102)
		    i_4_ = -1;
		else
		    i_4_ = Class51.method938(107, arg0);
		if (Class40_Sub5_Sub8.anInt2543 >= 0
		    && (i ^ 0xffffffff) <= -1) {
		    RSString.anIntArray1706[Class40_Sub5_Sub8.anInt2543] = i;
		    Class40_Sub5_Sub8.anInt2543
			= 0x7f & Class40_Sub5_Sub8.anInt2543 - -1;
		    if (Class40_Sub5_Sub8.anInt2543 == Class40_Sub13.anInt2183)
			Class40_Sub5_Sub8.anInt2543 = -1;
		}
		if ((i ^ 0xffffffff) <= -1 || (i_4_ ^ 0xffffffff) <= -1) {
		    int i_5_ = 0x7f & 1 + Class40_Sub5_Sub10.anInt2598;
		    if (Class59.anInt1389 != i_5_) {
			Class40_Sub6.anIntArray2113[(Class40_Sub5_Sub10
						     .anInt2598)]
			    = i;
			Class40_Sub5_Sub13.anIntArray2764[(Class40_Sub5_Sub10
							   .anInt2598)]
			    = i_4_;
			Class40_Sub5_Sub10.anInt2598 = i_5_;
		    }
		}
	    }
	    arg0.consume();
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "re.keyPressed(" + (arg0 != null ? "{...}"
						       : "null") + ')');
	}
    }
    
    public synchronized void keyReleased(KeyEvent arg0) {
	try {
	    if (Class59.aClass54_1392 != null) {
		Class49.anInt1147 = 0;
		int i = arg0.getKeyCode();
		if (i < 0 || Class66.anIntArray1564.length <= i)
		    i = -1;
		else
		    i = ~0x80 & Class66.anIntArray1564[i];
		if ((Class40_Sub5_Sub8.anInt2543 ^ 0xffffffff) <= -1
		    && i >= 0) {
		    RSString.anIntArray1706[Class40_Sub5_Sub8.anInt2543]
			= i ^ 0xffffffff;
		    Class40_Sub5_Sub8.anInt2543
			= 0x7f & 1 + Class40_Sub5_Sub8.anInt2543;
		    if (Class40_Sub13.anInt2183 == Class40_Sub5_Sub8.anInt2543)
			Class40_Sub5_Sub8.anInt2543 = -1;
		}
	    }
	    anInt1280++;
	    arg0.consume();
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "re.keyReleased(" + (arg0 != null ? "{...}"
							: "null") + ')');
	}
    }
    
    static {
	for (int i = 0; i < 256; i++) {
	    int i_6_ = i;
	    for (int i_7_ = 0; (i_7_ ^ 0xffffffff) > -9; i_7_++) {
		if ((i_6_ & 0x1) != 1)
		    i_6_ >>>= 1;
		else
		    i_6_ = ~0x12477cdf ^ i_6_ >>> 1162344193;
	    }
	    anIntArray1282[i] = i_6_;
	}
	aClass1_1283 = Class58.method978(-11538, "@yel@");
	aClass1_1284 = Class58.method978(-11538, "compass");
    }
}
