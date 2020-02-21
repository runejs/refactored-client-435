/* Class40_Sub5_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Graphics;

public class NpcDefinition extends SubNode
{
    public boolean aBoolean2372 = true;
    public static int anInt2373;
    public int anInt2374 = 1;
    public int[] anIntArray2375;
    public RSString[] aClass1Array2376 = new RSString[5];
    public static Class6_Sub1 aClass6_Sub1_2377;
    public static int anInt2378;
    public static int anInt2379;
    public static RSString aClass1_2380;
    public int anInt2381;
    public int anInt2382 = -1;
    public static RSString aClass1_2383
	= Class58.method978(-11538, "Please wait 1 minute and try again)3");
    public static RSString aClass1_2384;
    public int anInt2385;
    public static int[] anIntArray2386;
    public int anInt2387;
    public static RSString aClass1_2388;
    public int anInt2389;
    public static int anInt2390;
    public int anInt2391;
    public static RSString aClass1_2392;
    public int anInt2393;
    public static int anInt2394;
    public int[] anIntArray2395;
    public static RSString aClass1_2396;
    public boolean aBoolean2397;
    public static int anInt2398;
    public static RSString aClass1_2399;
    public static int anInt2400;
    public static RSString aClass1_2401;
    public RSString aClass1_2402;
    public static int anInt2403;
    public static int anInt2404;
    public int[] anIntArray2405;
    public int anInt2406;
    public int anInt2407;
    public static RSString aClass1_2408;
    public int anInt2409;
    public static RSString aClass1_2410;
    public int anInt2411;
    public static int anInt2412;
    public int anInt2413;
    public static int anInt2414;
    public int anInt2415;
    public static byte[] aByteArray2416;
    public static RSString aClass1_2417;
    public int anInt2418;
    public static int anInt2419;
    public static int anInt2420;
    public int anInt2421;
    public static int anInt2422;
    public static RSString aClass1_2423;
    public static int anInt2424;
    public int anInt2425;
    public int[] anIntArray2426;
    public int anInt2427;
    public int[] anIntArray2428;
    public static int anInt2429;
    public boolean aBoolean2430;
    public static int anInt2431;
    public static RSString aClass1_2432;
    public static int anInt2433;
    
    public static void method567(int arg0) {
	anInt2400++;
	if (arg0 != 1)
	    aClass1_2432 = null;
	if (Class57.aClass64_1345 != null)
	    Class57.aClass64_1345.method1009(90);
    }
    
    public Model method568(byte arg0, Class40_Sub5_Sub7 arg1,
					     Class40_Sub5_Sub7 arg2, int arg3,
					     int arg4) {
	try {
	    anInt2412++;
	    if (arg0 != -50)
		anInt2391 = 31;
	    if (anIntArray2426 != null) {
		NpcDefinition class40_sub5_sub5 = method577(arg0 ^ 0x31);
		if (class40_sub5_sub5 == null)
		    return null;
		return class40_sub5_sub5.method568((byte) -50, arg1, arg2,
						   arg3, arg4);
	    }
	    Model class40_sub5_sub17_sub5
		= ((Model)
		   Class67.aClass9_1611.method231((long) anInt2427,
						  (byte) 75));
	    if (class40_sub5_sub17_sub5 == null) {
		boolean bool = false;
		for (int i = 0; i < anIntArray2405.length; i++) {
		    if (!Class67.aClass6_1577.method173(anIntArray2405[i],
							(byte) -10, 0))
			bool = true;
		}
		if (bool)
		    return null;
		Model[] class40_sub5_sub17_sub5s
		    = new Model[anIntArray2405.length];
		for (int i = 0;
		     (i ^ 0xffffffff) > (anIntArray2405.length ^ 0xffffffff);
		     i++)
		    class40_sub5_sub17_sub5s[i]
			= Model.method830((Class67
							     .aClass6_1577),
							    anIntArray2405[i],
							    0);
		if (class40_sub5_sub17_sub5s.length == 1)
		    class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5s[0];
		else
		    class40_sub5_sub17_sub5
			= (new Model
			   (class40_sub5_sub17_sub5s,
			    class40_sub5_sub17_sub5s.length));
		if (anIntArray2428 != null) {
		    for (int i = 0; ((anIntArray2428.length ^ 0xffffffff)
				     < (i ^ 0xffffffff)); i++)
			class40_sub5_sub17_sub5.method803(anIntArray2428[i],
							  anIntArray2395[i]);
		}
		class40_sub5_sub17_sub5.method810();
		class40_sub5_sub17_sub5.method802(anInt2387 + 64,
						  850 - -anInt2409, -30, -50,
						  -30, true);
		Class67.aClass9_1611.method230(-7208, (long) anInt2427,
					       class40_sub5_sub17_sub5);
	    }
	    Model class40_sub5_sub17_sub5_0_;
	    if (arg1 != null && arg2 != null)
		class40_sub5_sub17_sub5_0_
		    = arg1.method590(class40_sub5_sub17_sub5, arg2, arg4, arg3,
				     (byte) 63);
	    else if (arg1 != null)
		class40_sub5_sub17_sub5_0_
		    = arg1.method599(arg4, class40_sub5_sub17_sub5, false);
	    else if (arg2 == null)
		class40_sub5_sub17_sub5_0_
		    = class40_sub5_sub17_sub5.method817(true);
	    else
		class40_sub5_sub17_sub5_0_
		    = arg2.method599(arg3, class40_sub5_sub17_sub5, false);
	    if ((anInt2407 ^ 0xffffffff) != -129 || anInt2415 != 128)
		class40_sub5_sub17_sub5_0_.method821(anInt2407, anInt2415,
						     anInt2407);
	    return class40_sub5_sub17_sub5_0_;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("h.C(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + arg3 + ',' + arg4 + ')'));
	}
    }
    
    public static void method569(boolean arg0) {
	try {
	    Class17.anIntArray456 = null;
	    Class58.aByteArrayArray1370 = null;
	    NPC.anIntArray3312 = null;
	    if (arg0 == true) {
		Class40_Sub5_Sub17_Sub4.anIntArray3111 = null;
		Buffer.anIntArray1972 = null;
		Class57.anIntArray1347 = null;
		anInt2403++;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.L(" + arg0 + ')');
	}
    }
    
    public static void method570(int arg0, int arg1,
				 Player arg2, int arg3) {
	try {
	    anInt2431++;
	    if (arg3 == -1) {
		if ((arg0 ^ 0xffffffff) == (arg2.anInt3141 ^ 0xffffffff)
		    && arg0 != -1) {
		    int i = Class68_Sub1.method1050(arg0, 2).anInt2483;
		    if (i == 1) {
			arg2.anInt3104 = 0;
			arg2.anInt3095 = 0;
			arg2.anInt3122 = arg1;
			arg2.anInt3115 = 0;
		    }
		    if (i == 2)
			arg2.anInt3095 = 0;
		} else if ((arg0 ^ 0xffffffff) == 0 || arg2.anInt3141 == -1
			   || (Class68_Sub1.method1050(arg0, 2).anInt2494
			       >= (Class68_Sub1.method1050(arg2.anInt3141, 2)
				   .anInt2494))) {
		    arg2.anInt3094 = arg2.anInt3109;
		    arg2.anInt3104 = 0;
		    arg2.anInt3115 = 0;
		    arg2.anInt3095 = 0;
		    arg2.anInt3122 = arg1;
		    arg2.anInt3141 = arg0;
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("h.E(" + arg0 + ',' + arg1 + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + arg3 + ')'));
	}
    }
    
    public boolean method571(int arg0) {
	try {
	    anInt2378++;
	    if (anIntArray2426 == null)
		return true;
	    int i = arg0;
	    if (anInt2411 != -1)
		i = Class40_Sub5_Sub6.method585(anInt2411, 1369);
	    else if ((anInt2385 ^ 0xffffffff) != 0)
		i = Class58.varbitmasks[anInt2385];
	    if (i < 0 || anIntArray2426.length <= i
		|| (anIntArray2426[i] ^ 0xffffffff) == 0)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.I(" + arg0 + ')');
	}
    }
    
    public void method572(int arg0, int arg1, Buffer arg2) {
	try {
	    if (arg1 == 8965) {
		if ((arg0 ^ 0xffffffff) == -2) {
		    int i = arg2.method468(false);
		    anIntArray2405 = new int[i];
		    for (int i_1_ = 0; (i_1_ ^ 0xffffffff) > (i ^ 0xffffffff);
			 i_1_++)
			anIntArray2405[i_1_] = arg2.method469(65280);
		} else if (arg0 == 2)
		    aClass1_2402 = arg2.getRSString(arg1 ^ ~0xae5);
		else if (arg0 != 12) {
		    if ((arg0 ^ 0xffffffff) == -14)
			anInt2382 = arg2.method469(65280);
		    else if ((arg0 ^ 0xffffffff) == -15)
			anInt2425 = arg2.method469(65280);
		    else if ((arg0 ^ 0xffffffff) == -16)
			anInt2421 = arg2.method469(arg1 + 56315);
		    else if (arg0 == 16)
			anInt2389 = arg2.method469(65280);
		    else if (arg0 != 17) {
			if ((arg0 ^ 0xffffffff) > -31
			    || (arg0 ^ 0xffffffff) <= -36) {
			    if ((arg0 ^ 0xffffffff) == -41) {
				int i = arg2.method468(false);
				anIntArray2395 = new int[i];
				anIntArray2428 = new int[i];
				for (int i_2_ = 0; i_2_ < i; i_2_++) {
				    anIntArray2428[i_2_]
					= arg2.method469(65280);
				    anIntArray2395[i_2_]
					= arg2.method469(65280);
				}
			    } else if ((arg0 ^ 0xffffffff) != -61) {
				if (arg0 != 93) {
				    if ((arg0 ^ 0xffffffff) == -96)
					anInt2393
					    = arg2.method469(arg1 + 56315);
				    else if ((arg0 ^ 0xffffffff) != -98) {
					if (arg0 != 98) {
					    if (arg0 != 99) {
						if (arg0 != 100) {
						    if (arg0 == 101)
							anInt2409
							    = (arg2.get
							       (75)) * 5;
						    else if ((arg0
							      ^ 0xffffffff)
							     == -103)
							anInt2381
							    = (arg2.method469
							       (65280));
						    else if (arg0 == 103)
							anInt2391
							    = (arg2.method469
							       (65280));
						    else if ((arg0
							      ^ 0xffffffff)
							     != -107) {
							if (arg0 == 107)
							    aBoolean2372
								= false;
						    } else {
							anInt2411
							    = (arg2.method469
							       (65280));
							if (anInt2411 == 65535)
							    anInt2411 = -1;
							anInt2385
							    = (arg2.method469
							       (65280));
							if (anInt2385 == 65535)
							    anInt2385 = -1;
							int i = (arg2.method468
								 (false));
							anIntArray2426
							    = new int[i + 1];
							for (int i_3_ = 0;
							     i >= i_3_;
							     i_3_++) {
							    anIntArray2426
								[i_3_]
								= (arg2.method469
								   (65280));
							    if (((anIntArray2426
								  [i_3_])
								 ^ 0xffffffff)
								== -65536)
								anIntArray2426
								    [i_3_]
								    = -1;
							}
						    }
						} else
						    anInt2387
							= arg2.get(116);
					    } else
						aBoolean2397 = true;
					} else
					    anInt2415 = arg2.method469(65280);
				    } else
					anInt2407
					    = arg2.method469(arg1 ^ 0xdc05);
				} else
				    aBoolean2430 = false;
			    } else {
				int i = arg2.method468(false);
				anIntArray2375 = new int[i];
				for (int i_4_ = 0; i > i_4_; i_4_++)
				    anIntArray2375[i_4_]
					= arg2.method469(65280);
			    }
			} else {
			    aClass1Array2376[arg0 - 30]
				= arg2.getRSString(-10721);
			    if (aClass1Array2376[arg0 - 30]
				    .method63(Class59.aClass1_1396, true))
				aClass1Array2376[-30 + arg0] = null;
			}
		    } else {
			anInt2425 = arg2.method469(65280);
			anInt2406 = arg2.method469(65280);
			anInt2418 = arg2.method469(65280);
			anInt2413 = arg2.method469(65280);
		    }
		} else
		    anInt2374 = arg2.method468(false);
		anInt2414++;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("h.A(" + arg0 + ',' + arg1 + ','
				    + (arg2 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public void method573(boolean arg0, Buffer arg1) {
	try {
	    for (;;) {
		int i = arg1.method468(!arg0);
		if (i == 0)
		    break;
		method572(i, 8965, arg1);
	    }
	    if (arg0 != true)
		method575((byte) 43);
	    anInt2420++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("h.H(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null")
				    + ')'));
	}
    }
    
    public static void method574(int arg0) {
	try {
	    if (arg0 != 4)
		method576(true);
	    try {
		Graphics graphics = Class62.aCanvas1469.getGraphics();
		RSString.aClass68_1665.method1044(0, 550, graphics, 4);
	    } catch (Exception exception) {
		Class62.aCanvas1469.repaint();
	    }
	    anInt2429++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.D(" + arg0 + ')');
	}
    }
    
    public Model method575(byte arg0) {
	try {
	    anInt2419++;
	    if (anIntArray2426 != null) {
		NpcDefinition class40_sub5_sub5 = method577(-1);
		if (class40_sub5_sub5 == null)
		    return null;
		return class40_sub5_sub5.method575((byte) 112);
	    }
	    if (anIntArray2375 == null)
		return null;
	    boolean bool = false;
	    for (int i = 0; i < anIntArray2375.length; i++) {
		if (!Class67.aClass6_1577.method173(anIntArray2375[i],
						    (byte) -10, 0))
		    bool = true;
	    }
	    if (arg0 < 108)
		method570(-116, 79, null, -61);
	    if (bool)
		return null;
	    Model[] class40_sub5_sub17_sub5s
		= new Model[anIntArray2375.length];
	    for (int i = 0; i < anIntArray2375.length; i++)
		class40_sub5_sub17_sub5s[i]
		    = Model.method830(Class67.aClass6_1577,
							anIntArray2375[i], 0);
	    Model class40_sub5_sub17_sub5;
	    if (class40_sub5_sub17_sub5s.length != 1)
		class40_sub5_sub17_sub5 = (new Model
					   (class40_sub5_sub17_sub5s,
					    class40_sub5_sub17_sub5s.length));
	    else
		class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5s[0];
	    if (anIntArray2428 != null) {
		for (int i = 0;
		     (anIntArray2428.length ^ 0xffffffff) < (i ^ 0xffffffff);
		     i++)
		    class40_sub5_sub17_sub5.method803(anIntArray2428[i],
						      anIntArray2395[i]);
	    }
	    return class40_sub5_sub17_sub5;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.M(" + arg0 + ')');
	}
    }
    
    public static int method576(boolean arg0) {
	try {
	    if (arg0 != false)
		aClass1_2432 = null;
	    anInt2422++;
	    return 19;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.O(" + arg0 + ')');
	}
    }
    
    public NpcDefinition method577(int arg0) {
	try {
	    int i = arg0;
	    anInt2398++;
	    if (anInt2411 != -1)
		i = Class40_Sub5_Sub6.method585(anInt2411, 1369);
	    else if (anInt2385 != -1)
		i = Class58.varbitmasks[anInt2385];
	    if ((i ^ 0xffffffff) > -1
		|| (i ^ 0xffffffff) <= (anIntArray2426.length ^ 0xffffffff)
		|| (anIntArray2426[i] ^ 0xffffffff) == 0)
		return null;
	    return Landscape.method932((byte) -114, anIntArray2426[i]);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.J(" + arg0 + ')');
	}
    }
    
    public static DirectColorSprite method578(int arg0) {
	try {
	    anInt2379++;
	    DirectColorSprite class40_sub5_sub14_sub4
		= new DirectColorSprite();
	    class40_sub5_sub14_sub4.anInt2954 = ItemDefinition.anInt2846;
	    class40_sub5_sub14_sub4.anInt2952 = RSApplet.anInt31;
	    class40_sub5_sub14_sub4.anInt2953 = Class57.anIntArray1347[0];
	    class40_sub5_sub14_sub4.anInt2949
		= Class40_Sub5_Sub17_Sub4.anIntArray3111[0];
	    if (arg0 > -85)
		method578(79);
	    class40_sub5_sub14_sub4.anInt2951 = Class17.anIntArray456[0];
	    class40_sub5_sub14_sub4.anInt2950
		= NPC.anIntArray3312[0];
	    byte[] is = Class58.aByteArrayArray1370[0];
	    int i = (class40_sub5_sub14_sub4.anInt2951
		     * class40_sub5_sub14_sub4.anInt2950);
	    class40_sub5_sub14_sub4.anIntArray2955 = new int[i];
	    for (int i_5_ = 0; i_5_ < i; i_5_++)
		class40_sub5_sub14_sub4.anIntArray2955[i_5_]
		    = (Buffer.anIntArray1972
		       [Class66.method1021(255, is[i_5_])]);
	    method569(true);
	    return class40_sub5_sub14_sub4;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.K(" + arg0 + ')');
	}
    }
    
    public void method579(byte arg0) {
	try {
	    anInt2373++;
	    int i = -82 % ((arg0 - 15) / 41);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.F(" + arg0 + ')');
	}
    }
    
    public static void method580(Signlink arg0, byte arg1, Buffer arg2,
				 int arg3) {
	try {
	    Class40_Sub11 class40_sub11 = new Class40_Sub11();
	    class40_sub11.anInt2160 = arg2.method468(false);
	    anInt2424++;
	    class40_sub11.anInt2166 = arg2.method491(-4750);
	    class40_sub11.anIntArray2154 = new int[class40_sub11.anInt2160];
	    int i = 123 / ((-34 - arg1) / 43);
	    class40_sub11.aClass15Array2157
		= new Class15[class40_sub11.anInt2160];
	    class40_sub11.anIntArray2165 = new int[class40_sub11.anInt2160];
	    class40_sub11.aByteArrayArrayArray2159
		= new byte[class40_sub11.anInt2160][][];
	    class40_sub11.aClass15Array2156
		= new Class15[class40_sub11.anInt2160];
	    class40_sub11.anIntArray2155 = new int[class40_sub11.anInt2160];
	    for (int i_6_ = 0;
		 (i_6_ ^ 0xffffffff) > (class40_sub11.anInt2160 ^ 0xffffffff);
		 i_6_++) {
		try {
		    int i_7_ = arg2.method468(false);
		    if (i_7_ != 0 && i_7_ != 1 && (i_7_ ^ 0xffffffff) != -3) {
			if (i_7_ == 3 || (i_7_ ^ 0xffffffff) == -5) {
			    String string = new String(arg2.getRSString
							   (-10721)
							   .method80(0));
			    String string_8_
				= new String(arg2.getRSString(-10721)
						 .method80(0));
			    int i_9_ = arg2.method468(false);
			    String[] strings = new String[i_9_];
			    for (int i_10_ = 0; i_9_ > i_10_; i_10_++)
				strings[i_10_]
				    = new String(arg2.getRSString(-10721)
						     .method80(0));
			    byte[][] is = new byte[i_9_][];
			    if (i_7_ == 3) {
				for (int i_11_ = 0;
				     ((i_11_ ^ 0xffffffff)
				      > (i_9_ ^ 0xffffffff));
				     i_11_++) {
				    int i_12_ = arg2.method491(-4750);
				    is[i_11_] = new byte[i_12_];
				    arg2.method497(is[i_11_], 0, i_12_,
						   (byte) 45);
				}
			    }
			    class40_sub11.anIntArray2154[i_6_] = i_7_;
			    Class[] var_classes = new Class[i_9_];
			    for (int i_13_ = 0;
				 (i_13_ ^ 0xffffffff) > (i_9_ ^ 0xffffffff);
				 i_13_++)
				var_classes[i_13_]
				    = Class26.method349((byte) 91,
							strings[i_13_]);
			    class40_sub11.aClass15Array2156[i_6_]
				= arg0.method386(var_classes, string_8_,
						 Class26.method349((byte) 91,
								   string),
						 (byte) -64);
			    class40_sub11.aByteArrayArrayArray2159[i_6_] = is;
			}
		    } else {
			int i_14_ = 0;
			String string
			    = new String(arg2.getRSString(-10721).method80(0));
			String string_15_
			    = new String(arg2.getRSString(-10721).method80(0));
			if ((i_7_ ^ 0xffffffff) == -2)
			    i_14_ = arg2.method491(-4750);
			class40_sub11.anIntArray2154[i_6_] = i_7_;
			class40_sub11.anIntArray2165[i_6_] = i_14_;
			class40_sub11.aClass15Array2157[i_6_]
			    = arg0.method392(Class26.method349((byte) 91,
							       string),
					     string_15_, true);
		    }
		} catch (ClassNotFoundException classnotfoundexception) {
		    class40_sub11.anIntArray2155[i_6_] = -1;
		} catch (SecurityException securityexception) {
		    class40_sub11.anIntArray2155[i_6_] = -2;
		} catch (NullPointerException nullpointerexception) {
		    class40_sub11.anIntArray2155[i_6_] = -3;
		} catch (Exception exception) {
		    class40_sub11.anIntArray2155[i_6_] = -4;
		} catch (Throwable throwable) {
		    class40_sub11.anIntArray2155[i_6_] = -5;
		}
	    }
	    Class54.aClass45_1278.method904(class40_sub11, 92);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("h.G(" + (arg0 != null ? "{...}" : "null")
				    + ',' + arg1 + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + arg3 + ')'));
	}
    }
    
    public static void method581(int arg0) {
	try {
	    anIntArray2386 = null;
	    aClass6_Sub1_2377 = null;
	    aClass1_2388 = null;
	    aClass1_2399 = null;
	    aClass1_2432 = null;
	    aClass1_2380 = null;
	    aClass1_2396 = null;
	    aClass1_2423 = null;
	    aClass1_2417 = null;
	    if (arg0 == -96) {
		aClass1_2410 = null;
		aClass1_2383 = null;
		aByteArray2416 = null;
		aClass1_2401 = null;
		aClass1_2392 = null;
		aClass1_2408 = null;
		aClass1_2384 = null;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "h.N(" + arg0 + ')');
	}
    }
    
    public NpcDefinition() {
	anInt2381 = -1;
	anInt2391 = 32;
	anInt2387 = 0;
	anInt2406 = -1;
	anInt2385 = -1;
	anInt2409 = 0;
	anInt2407 = 128;
	aBoolean2397 = false;
	anInt2393 = -1;
	anInt2389 = -1;
	anInt2413 = -1;
	anInt2411 = -1;
	anInt2415 = 128;
	anInt2425 = -1;
	anInt2421 = -1;
	aClass1_2402 = Class35.aClass1_1725;
	anInt2418 = -1;
	aBoolean2430 = true;
    }
    
    static {
	aClass1_2380
	    = (Class58.method978
	       (-11538, "Moderator option: Mute player for 48 hours: <ON>"));
	aClass1_2399 = Class58.method978(-11538, "Loaded fonts");
	aClass1_2401 = aClass1_2383;
	aClass1_2384 = aClass1_2380;
	anInt2394 = 0;
	anInt2404 = 0;
	aClass1_2410 = aClass1_2383;
	aClass1_2392 = aClass1_2399;
	aClass1_2408 = Class58.method978(-11538, "Unexpected server response");
	aByteArray2416 = new byte[520];
	aClass1_2417 = Class58.method978(-11538, "Versteckt");
	aClass1_2423 = Class58.method978(-11538, "(X100(U(Y");
	aClass1_2388 = Class58.method978(-11538, "Checking for updates )2 ");
	aClass1_2396 = aClass1_2388;
	anInt2433 = -1;
	aClass1_2432 = aClass1_2408;
    }
}
