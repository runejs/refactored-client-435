/* Class40_Sub1_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.math.BigInteger;

public class PacketBuffer extends Buffer
{
    public static int anInt2230;
    public static int anInt2231;
    public static int anInt2232;
    public static int anInt2233;
    public static int anInt2234;
    public static int anInt2235;
    public static boolean aBoolean2236 = false;
    public static int anInt2237;
    public static Class36[] aClass36Array2238;
    public ISAAC encryption;
    public static RSString aClass1_2240;
    public static long aLong2241;
    public static int anInt2242;
    public static int anInt2243;
    public int bitoffset;
    public static RSString aClass1_2245;
    public static int anInt2246;
    public static BigInteger rsaKey;
    public static int anInt2248;
    public static int anInt2249;
    public static Class40_Sub5_Sub13 aClass40_Sub5_Sub13_2250;
    public static int anInt2251;
    public static int anInt2252;
    public static int anInt2253;
    public static RSString aClass1_2254;
    public static boolean aBoolean2255;
    public static int anInt2256;
    public static int anInt2257;
    public static int anInt2258;
    public static RSString aClass1_2259;
    public static RSString aClass1_2260;
    
    public int method510(int arg0, int arg1) {
	try {
	    if (arg0 <= 118)
		return 75;
	    anInt2237++;
	    return 8 * arg1 - bitoffset;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "fe.MB(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void finishBitAccess(byte arg0) {
	try {
	    if (arg0 != -110)
		bitoffset = -12;
	    offset = (7 + bitoffset) / 8;
	    anInt2249++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "fe.QB(" + arg0 + ')');
	}
    }
    
    public int getPacket(byte arg0) {
	try {
	    if (arg0 != 49)
		aClass1_2260 = null;
	    anInt2232++;
	    return 0xff & (payload[offset++]/* + -encryption.method286(-101)*/);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "fe.TB(" + arg0 + ')');
	}
    }
    
    public static void method513(int arg0, Class6_Sub1 arg1, Class56 arg2,
				 byte arg3) {
	try {
	    Class40_Sub6 class40_sub6 = new Class40_Sub6();
	    anInt2252++;
	    class40_sub6.anInt2112 = 1;
	    class40_sub6.key = (long) arg0;
	    class40_sub6.aClass56_2117 = arg2;
	    class40_sub6.aClass6_Sub1_2104 = arg1;
	    synchronized (RSCanvas.aClass45_53) {
		if (arg3 != -28)
		    method521(false, (byte) -113, -84, -120);
		RSCanvas.aClass45_53.method904(class40_sub6, -72);
	    }
	    HashTable.method332(600);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("fe.KB(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + (arg2 != null ? "{...}" : "null") + ','
				    + arg3 + ')'));
	}
    }
    
    public static void method514(int arg0) {
	try {
	    aClass40_Sub5_Sub13_2250 = null;
	    aClass1_2260 = null;
	    aClass1_2254 = null;
	    if (arg0 == 1) {
		rsaKey = null;
		aClass36Array2238 = null;
		aClass1_2245 = null;
		aClass1_2240 = null;
		aClass1_2259 = null;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "fe.NB(" + arg0 + ')');
	}
    }
    
    public int putBits(int arg0, byte arg1) {
	try {
	    anInt2234++;
	    int i = bitoffset >> -921091357;
	    if (arg1 != -65)
		aClass1_2240 = null;
	    int i_0_ = 0;
	    int i_1_ = 8 - (0x7 & bitoffset);
	    bitoffset += arg0;
	    for (/**/; i_1_ < arg0; i_1_ = 8) {
		i_0_ += (Class40_Sub5_Sub4.anIntArray2361[i_1_]
			 & payload[i++]) << -i_1_ + arg0;
		arg0 -= i_1_;
	    }
	    if ((i_1_ ^ 0xffffffff) != (arg0 ^ 0xffffffff))
		i_0_ += (Class40_Sub5_Sub4.anIntArray2361[arg0]
			 & payload[i] >> -arg0 + i_1_);
	    else
		i_0_ += (payload[i]
			 & Class40_Sub5_Sub4.anIntArray2361[i_1_]);
	    return i_0_;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "fe.RB(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public static void method516(int arg0) {
	Class32.packetBuffer.putPacket(11453, 176);
	if (Class29.anInt673 != -1) {
	    Class55.method958(Class29.anInt673, -14222);
	    Class6_Sub1.anInt1819 = -1;
	    Class40_Sub5_Sub10.aBoolean2597 = true;
	    ISAAC.aBoolean505 = true;
	    Class29.anInt673 = -1;
	}
	Class40_Sub13.anInt2184++;
	anInt2233++;
	if (Class43.anInt1028 != -1) {
	    Class55.method958(Class43.anInt1028, -14222);
	    Class6_Sub1.anInt1819 = -1;
	    Class52.aBoolean1221 = true;
	    Class43.anInt1028 = -1;
	}
	if ((NpcDefinition.anInt2433 ^ 0xffffffff) != 0) {
	    Class55.method958(NpcDefinition.anInt2433, -14222);
	    NpcDefinition.anInt2433 = -1;
	    Floor.method559(30, -47);
	}
	if ((Class40_Sub5_Sub9.anInt2562 ^ 0xffffffff) != 0) {
	    Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
	    Class40_Sub5_Sub9.anInt2562 = -1;
	}
	if (arg0 >= 92) {
	    if (Class66.anInt1560 != -1) {
		Class55.method958(Class66.anInt1560, -14222);
		Class66.anInt1560 = -1;
		Class6_Sub1.anInt1819 = -1;
	    }
	}
    }
    
    public static void method517(int arg0, int arg1, int arg2) {
	try {
	    if (arg2 == -9225) {
		anInt2230++;
		Class32.packetBuffer.putPacket(11453, 132);
		ISAAC.anInt499++;
		Class32.packetBuffer.method503(-2030879560, arg1);
		Class32.packetBuffer.method486(14912, arg0);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("fe.PB(" + arg0 + ',' + arg1 + ',' + arg2
				    + ')'));
	}
    }
    
    public PacketBuffer(int arg0) {
	super(arg0);
    }
    
    public void putPacket(int arg0, int arg1) {
	try {
	    if (arg0 != 11453)
		method513(62, null, null, (byte) -105);
	    anInt2253++;
	    payload[offset++] = //(byte) (encryption.method286(RSApplet.method27(arg0, -11500)) + arg1);
				(byte) arg1;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "fe.UB(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void initEncryption(int arg0, int[] arg1) {
	encryption = new ISAAC(arg1);
	anInt2246++;
	if (arg0 != -1)
	    aClass1_2259 = null;
    }
    
    public void initBitAccess(int arg0) {
	anInt2235++;
	bitoffset = offset * 8;
	if (arg0 <= 21)
	    encryption = null;
    }
    
    public static RSString method521(boolean arg0, byte arg1, int arg2,
				   int arg3) {
	try {
	    if (arg2 < 1 || arg2 > 36)
		arg2 = 10;
	    int i = 1;
	    if (arg1 != 8)
		return null;
	    int i_2_ = arg3 / arg2;
	    while (i_2_ != 0) {
		i_2_ /= arg2;
		i++;
	    }
	    anInt2251++;
	    int i_3_ = i;
	    if (arg3 < 0 || arg0)
		i_3_++;
	    byte[] is = new byte[i_3_];
	    if ((arg3 ^ 0xffffffff) > -1)
		is[0] = (byte) 45;
	    else if (arg0)
		is[0] = (byte) 43;
	    for (int i_4_ = 0; i > i_4_; i_4_++) {
		int i_5_ = arg3 % arg2;
		arg3 /= arg2;
		if (i_5_ < 0)
		    i_5_ = -i_5_;
		if ((i_5_ ^ 0xffffffff) < -10)
		    i_5_ += 39;
		is[-1 + (i_3_ - i_4_)] = (byte) (48 + i_5_);
	    }
	    RSString class1 = new RSString();
	    class1.aByteArray1692 = is;
	    class1.anInt1680 = i_3_;
	    return class1;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("fe.OB(" + arg0 + ',' + arg1 + ',' + arg2
				    + ',' + arg3 + ')'));
	}
    }
    
    static {
	anInt2231 = 1;
	aLong2241 = 0L;
	aClass1_2245 = Class58.method978(-11538, "Aus");
	aClass36Array2238 = new Class36[50];
	anInt2248 = 0;
	aClass1_2254 = Class58.method978(-11538, "Please wait)3)3)3");
	aClass1_2240 = aClass1_2254;
	rsaKey
	    = (new BigInteger
	       ("65537"));
	aBoolean2255 = false;
	aClass1_2260
	    = Class58.method978(-11538, "da dieser Computer gegen unsere ");
	aClass1_2259
	    = Class58.method978(-11538,
				"oder benutzen Sie eine andere Welt)3");
	anInt2256 = 0;
    }
}
