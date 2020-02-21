/* Class40_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.math.BigInteger;

public class Buffer extends Node
{
    public static int anInt1926;
    public static int anInt1927;
    public static int anInt1928;
    public static int anInt1929;
    public static int anInt1930;
    public static int anInt1931;
    public static int anInt1932;
    public static Cache aClass9_1933 = new Cache(100);
    public static int anInt1934;
    public static int anInt1935;
    public static int anInt1936;
    public static int anInt1937;
    public static int anInt1938;
    public static int anInt1939;
    public static int anInt1940;
    public static int anInt1941;
    public static int anInt1942;
    public static int anInt1943;
    public static int anInt1944;
    public static int anInt1945;
    public static int anInt1946;
    public int offset;
    public static int anInt1948;
    public static int anInt1949;
    public static int anInt1950;
    public static int anInt1951;
    public static int anInt1952;
    public static int anInt1953;
    public static int anInt1954;
    public static int anInt1955;
    public static int anInt1956;
    public static int anInt1957;
    public static int anInt1958;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_1959;
    public static int anInt1960;
    public static int anInt1961;
    public static int anInt1962;
    public static int anInt1963;
    public byte[] payload;
    public static int anInt1965;
    public static int anInt1966;
    public static int anInt1967;
    public static int anInt1968;
    public static int anInt1969;
    public static int anInt1970;
    public static int anInt1971;
    public static int[] anIntArray1972;
    public static int anInt1973;
    public static int anInt1974;
    public static int anInt1975;
    public static int anInt1976 = 0;
    public static int anInt1977;
    public static int anInt1978 = 0;
    public static int anInt1979;
    public static int anInt1980;
    public static int anInt1981;
    public static int anInt1982;
    public static RSString aClass1_1983;
    public static int[] anIntArray1984;
    public static int anInt1985 = -1;
    public static int anInt1986;
    public static int anInt1987;
    public static RSString aClass1_1988;
    public static int anInt1989;
    public static RSString aClass1_1990;
    
    public int method460(int arg0) {
	try {
	    offset += 2;
	    int i = ((payload[-1 + offset] + -128 & 0xff) + (0xff00 & payload[-2 + offset] << 815900680));
	    if (i > 32767)
		i -= 65536;
	    anInt1975++;
	    if (arg0 != -23843)
		anInt1978 = -67;
	    return i;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.GB(" + arg0 + ')');
	}
    }
    
    public int method461(byte arg0) {
	try {
	    anInt1955++;
	    if (arg0 < 56)
		method482((byte) -114);
	    offset += 2;
	    return ((payload[-2 + offset] << 1603608168 & 0xff00) + (0xff & payload[offset + -1] - 128));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.R(" + arg0 + ')');
	}
    }
    
    public void putBytes128(byte arg0, int arg1, byte[] arg2, int arg3) {
	try {
	    anInt1989++;
	    int i = arg1;
	    if (arg0 != -80)
		method504(true);
	    for (/**/; i < arg3 + arg1; i++)
		arg2[i] = (byte) (payload[offset++] + -128);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, ("ba.FA(" + arg0 + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ','  + arg3 + ')'));
	}
    }
    
    public int method463(byte arg0) {
	try {
	    if (arg0 > -58)
		offset = -110;
	    anInt1970++;
	    offset += 2;
	    int i = ((0xff00 & payload[offset + -2] << -1506761304) + (payload[offset - 1] & 0xff));
	    if ((i ^ 0xffffffff) < -32768)
		i -= 65536;
	    return i;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.KA(" + arg0 + ')');
	}
    }
    
    public RSString getRSString(int arg0) {
	try {
	    anInt1963++;
	    int i = offset;
	    if (arg0 != -10721)
		method483(null, true, -57, 63);
	    while (payload[offset++] != 0) {
		/* empty */
	    }
	    return Class19.method279(payload, true, i,
				     -1 + offset + -i);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.M(" + arg0 + ')');
	}
    }
    
    public void put(int arg0, byte arg1) {
	try {
	    if (arg1 == -128) {
		anInt1961++;
		payload[offset++] = (byte) arg0;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.JB(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void applyRSA(BigInteger modulus, BigInteger key, int arg2) {
	try {
	    anInt1965++;
	    int i = offset;
	    offset = 0;
	    byte[] is = new byte[i];
	    method497(is, 0, i, (byte) 45);
	    BigInteger biginteger = new BigInteger(is);
	    BigInteger biginteger_0_ = biginteger.modPow(key, modulus);
	    System.out.println("RSA");
	    byte[] is_1_ = biginteger_0_.toByteArray();
	    offset = 0;
	    if (arg2 == 19280) {
		put(is_1_.length, (byte) -128);
		method475(is_1_.length, is_1_, 0, 8636);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ba.FB("
				    + (modulus != null ? "{...}" : "null") + ','
				    + (key != null ? "{...}" : "null") + ','
				    + arg2 + ')'));
	}
    }
    
    public byte method467(byte arg0) {
	try {
	    if (arg0 < 9)
		getRSString(-30);
	    anInt1931++;
	    return (byte) -payload[offset++];
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.DB(" + arg0 + ')');
	}
    }
    
    public int method468(boolean arg0) {
	try {
	    if (arg0 != false)
		return 118;
	    anInt1932++;
	    return 0xff & payload[offset++];
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.N(" + arg0 + ')');
	}
    }
    
    public int method469(int arg0) {
	try {
	    anInt1939++;
	    offset += 2;
	    if (arg0 != 65280)
		return 7;
	    return (((0xff & payload[offset + -2]) << 21603400)
		    - -(payload[offset + -1] & 0xff));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.A(" + arg0 + ')');
	}
    }
    
    public int method470(int arg0) {
	try {
	    if (arg0 >= -114)
		payload = null;
	    offset += 4;
	    anInt1954++;
	    return ((0xff00 & payload[offset + -1] << 608837736)
		    + ((payload[-4 + offset] << -1100116464
			& 0xff0000)
		       + ((payload[-3 + offset] & 0xff)
			  << 1673380440))
		    - -(payload[offset + -2] & 0xff));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.O(" + arg0 + ')');
	}
    }
    
    public int method471(byte arg0) {
	try {
	    int i = 41 / ((78 - arg0) / 36);
	    anInt1938++;
	    return 0xff & -payload[offset++];
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.BB(" + arg0 + ')');
	}
    }
    
    public static boolean method472(int arg0, Class6 arg1, int arg2) {
	try {
	    byte[] is = arg1.method187(arg2, (byte) -96);
	    anInt1967++;
	    if (arg0 >= -84)
		method499(true);
	    if (is == null)
		return false;
	    Class6.method184(is, 0);
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ba.AA(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + arg2 + ')'));
	}
    }
    
    public int method473(int arg0, int arg1) {
	try {
	    anInt1927++;
	    int i = Class67.method1034(true, arg1, offset, payload);
	    putInt(127, i);
	    if (arg0 <= 14)
		anIntArray1972 = null;
	    return i;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.D(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method474(int arg0, int arg1) {
	try {
	    anInt1958++;
	    int i = -63 / ((-60 - arg1) / 61);
	    payload[offset++] = (byte) (arg0 >> 1391556904);
	    payload[offset++] = (byte) arg0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.EB(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method475(int arg0, byte[] arg1, int arg2, int arg3) {
	try {
	    if (arg3 == 8636) {
		for (int i = arg2; arg2 + arg0 > i; i++)
		    payload[offset++] = arg1[i];
		anInt1977++;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ba.JA(" + arg0 + ','
				    + (arg1 != null ? "{...}" : "null") + ','
				    + arg2 + ',' + arg3 + ')'));
	}
    }
    
    public int method476(int arg0) {
	try {
	    anInt1940++;
	    if (arg0 != 255)
		putTri(-16, 96);
	    return 0xff & payload[offset++] - 128;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.U(" + arg0 + ')');
	}
    }
    
    public void putTri(int arg0, int arg1) {
	try {
	    if (arg1 != 13723)
		offset = -49;
	    anInt1945++;
	    payload[offset++] = (byte) (arg0 >> 600646704);
	    payload[offset++] = (byte) (arg0 >> 530884104);
	    payload[offset++] = (byte) arg0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.CB(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method478(int arg0, int arg1) {
	try {
	    if (arg1 > -17)
		anInt1985 = -53;
	    anInt1950++;
	    payload[offset++] = (byte) (128 + arg0);
	    payload[offset++] = (byte) (arg0 >> -1619921976);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.LA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void finishVarByte(int arg0, byte arg1) {
	try {
	    if (arg1 != 16)
		anIntArray1984 = null;
	    payload[-1 + (offset + -arg0)] = (byte) arg0;
	    anInt1979++;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.C(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public int method480(byte arg0) {
	try {
	    anInt1944++;
	    if (arg0 != -70)
		return -26;
	    return 0xff & 128 - payload[offset++];
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.K(" + arg0 + ')');
	}
    }
    
    public void putLong(long arg0, boolean arg1) {
	try {
	    anInt1962++;
	    payload[offset++] = (byte) (int) (arg0 >> 1191147448);
	    payload[offset++] = (byte) (int) (arg0 >> -1885799824);
	    payload[offset++] = (byte) (int) (arg0 >> -1645205400);
	    if (arg1 != false)
		method500(79);
	    payload[offset++] = (byte) (int) (arg0 >> -1767579936);
	    payload[offset++] = (byte) (int) (arg0 >> 784183768);
	    payload[offset++] = (byte) (int) (arg0 >> 1398515728);
	    payload[offset++] = (byte) (int) (arg0 >> 2029251720);
	    payload[offset++] = (byte) (int) arg0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.WA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public int method482(byte arg0) {
	try {
	    int i = payload[offset] & 0xff;
	    anInt1935++;
	    int i_2_ = -86 % ((-29 - arg0) / 63);
	    if (i >= 128)
		return -49152 + method469(65280);
	    return method468(false) + -64;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.P(" + arg0 + ')');
	}
    }
    
    public void method483(int[] arg0, boolean arg1, int arg2, int arg3) {
	try {
	    anInt1949++;
	    int i = (-arg3 + arg2) / 8;
	    int i_3_ = offset;
	    offset = arg3;
	    int i_4_ = 0;
	    if (arg1 != false)
		method509(87, 12);
	    for (/**/; i > i_4_; i_4_++) {
		int i_5_ = method491(-4750);
		int i_6_ = method491(-4750);
		int i_7_ = 32;
		int i_8_ = -957401312;
		int i_9_ = -1640531527;
		while ((i_7_-- ^ 0xffffffff) < -1) {
		    i_6_
			-= ((i_5_ >>> 1775780933 ^ i_5_ << 1795313636) + i_5_
			    ^ i_8_ + arg0[~0x71dffffc & i_8_ >>> -1457761525]);
		    i_8_ -= i_9_;
		    i_5_ -= ((i_6_ >>> 809137349 ^ i_6_ << -2011388316) + i_6_
			     ^ arg0[0x3 & i_8_] + i_8_);
		}
		offset -= 8;
		putInt(64, i_5_);
		putInt(57, i_6_);
	    }
	    offset = i_3_;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("ba.J(" + (arg0 != null ? "{...}" : "null")
				    + ',' + arg1 + ',' + arg2 + ',' + arg3
				    + ')'));
	}
    }
    
    public int method484(byte arg0) {
	try {
	    offset += 2;
	    if (arg0 < 82)
		return -115;
	    anInt1929++;
	    int i = ((0xff & -128 + payload[offset + -2])
		     + (0xff00 & payload[-1 + offset] << 676702312));
	    if (i > 32767)
		i -= 65536;
	    return i;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.S(" + arg0 + ')');
	}
    }
    
    public int method485(byte arg0) {
	try {
	    offset += 4;
	    if (arg0 != -48)
		method502((byte) 24);
	    anInt1973++;
	    return ((payload[offset - 3] << 491618920 & 0xff00)
		    + (((0xff & payload[-1 + offset]) << -690933064)
		       - -(0xff0000
			   & payload[-2 + offset] << 1151920912))
		    + (payload[offset - 4] & 0xff));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.BA(" + arg0 + ')');
	}
    }
    
    public void method486(int arg0, int arg1) {
	try {
	    anInt1942++;
	    payload[offset++] = (byte) arg1;
	    if (arg0 != 14912)
		method496(73, 82);
	    payload[offset++] = (byte) (arg1 >> -1300162104);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.MA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method487(int arg0, byte arg1) {
	try {
	    anInt1980++;
	    payload[offset++] = (byte) (arg0 >> 1890701136);
	    payload[offset++] = (byte) (arg0 >> 1350143384);
	    payload[offset++] = (byte) arg0;
	    if (arg1 <= 84)
		method470(44);
	    payload[offset++] = (byte) (arg0 >> -1913919160);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.V(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public int getTri(boolean arg0) {
	try {
	    if (arg0 != true)
		anInt1976 = -89;
	    anInt1936++;
	    offset += 3;
	    return (((payload[-3 + offset] & 0xff) << 1362367312)
		    - -((payload[-2 + offset] & 0xff) << -1723151192)
		    + (0xff & payload[offset + -1]));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.W(" + arg0 + ')');
	}
    }
    
    public void method489(int arg0, int arg1) {
	try {
	    anInt1946++;
	    payload[offset++] = (byte) (arg1 + arg0);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.VA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public int method490(byte arg0) {
	try {
	    anInt1943++;
	    if (arg0 != -70)
		anInt1976 = 28;
	    offset += 2;
	    return ((0xff00 & payload[offset - 1] << 1865467432)
		    - -(0xff & payload[-2 + offset]));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.F(" + arg0 + ')');
	}
    }
    
    public int method491(int arg0) {
	try {
	    offset += 4;
	    if (arg0 != -4750)
		method480((byte) 26);
	    anInt1966++;
	    return ((0xff & payload[-1 + offset])
		    + (payload[-2 + offset] << 2134755528 & 0xff00)
		    + (payload[-3 + offset] << -50289552 & 0xff0000)
		    + (~0xffffff
		       & payload[-4 + offset] << -2030879560));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.AB(" + arg0 + ')');
	}
    }
    
    public byte method492(int arg0) {
	try {
	    if (arg0 != 128)
		method492(-79);
	    anInt1928++;
	    return (byte) (-payload[offset++] + 128);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.CA(" + arg0 + ')');
	}
    }
    
    public void method493(int arg0, int arg1) {
	try {
	    anInt1934++;
	    payload[offset++] = (byte) (arg0 >> -74775704);
	    payload[offset++] = (byte) (arg0 + -arg1);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.G(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method494(int arg0, int arg1) {
	payload[offset++] = (byte) arg0;
	anInt1986++;
	payload[offset++] = (byte) (arg0 >> 283040840);
	payload[offset++] = (byte) (arg0 >> 1472658608);
	payload[offset++] = (byte) (arg0 >> -694657128);
	if (arg1 < 69)
	    put(34, (byte) -50);
    }
    
    public byte method495(int arg0) {
	try {
	    if (arg0 >= -39)
		anIntArray1984 = null;
	    anInt1969++;
	    return (byte) (payload[offset++] - 128);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.L(" + arg0 + ')');
	}
    }
    
    public void method496(int arg0, int arg1) {
	try {
	    if (arg0 != 255)
		anInt1976 = 21;
	    anInt1953++;
	    payload[offset++] = (byte) -arg1;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.B(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method497(byte[] arg0, int arg1, int arg2, byte arg3) {
	anInt1960++;
	for (int i = arg1; arg2 + arg1 > i; i++)
	    arg0[i] = payload[offset++];
	if (arg3 != 45)
	    method485((byte) -119);
    }
    
    public long method498(int arg0) {
	try {
	    anInt1981++;
	    long l = 0xffffffffL & (long) method491(arg0 ^ ~0x513401dd);
	    long l_10_ = (long) method491(-4750) & 0xffffffffL;
	    if (arg0 != 1362367312)
		method499(false);
	    return l_10_ + (l << -52842400);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.Q(" + arg0 + ')');
	}
    }
    
    public static void method499(boolean arg0) {
	try {
	    aClass1_1990 = null;
	    anIntArray1984 = null;
	    aClass40_Sub5_Sub14_Sub2_1959 = null;
	    aClass1_1988 = null;
	    if (arg0 != true)
		aClass1_1988 = null;
	    aClass1_1983 = null;
	    aClass9_1933 = null;
	    anIntArray1972 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.IA(" + arg0 + ')');
	}
    }
    
    public int method500(int arg0) {
	try {
	    anInt1957++;
	    if (arg0 < 28)
		anInt1982 = -107;
	    int i = payload[offset++];
	    int i_11_ = 0;
	    for (/**/; i < 0; i = payload[offset++])
		i_11_ = (0x7f & i | i_11_) << -1305190585;
	    return i | i_11_;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.HA(" + arg0 + ')');
	}
    }
    
    public static Class40_Sub5_Sub10 method501(byte arg0, int arg1) {
	try {
	    anInt1956++;
	    if (arg0 != -94)
		aClass9_1933 = null;
	    Class40_Sub5_Sub10 class40_sub5_sub10
		= ((Class40_Sub5_Sub10)
		   Class68.aClass9_1615.method231((long) arg1, (byte) 107));
	    if (class40_sub5_sub10 != null)
		return class40_sub5_sub10;
	    byte[] is = Class49.aClass6_1150.method172(arg1, 114, 3);
	    class40_sub5_sub10 = new Class40_Sub5_Sub10();
	    if (is != null)
		class40_sub5_sub10.method622((byte) 58, new Buffer(is));
	    Class68.aClass9_1615.method230(-7208, (long) arg1,
					   class40_sub5_sub10);
	    return class40_sub5_sub10;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.GA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public int method502(byte arg0) {
	try {
	    int i = payload[offset] & 0xff;
	    int i_12_ = 100 / ((arg0 - -39) / 32);
	    anInt1968++;
	    if ((i ^ 0xffffffff) <= -129)
		return method469(65280) + -32768;
	    return method468(false);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.HB(" + arg0 + ')');
	}
    }
    
    public void method503(int arg0, int arg1) {
	try {
	    payload[offset++] = (byte) (arg1 >> 1096534376);
	    anInt1971++;
	    payload[offset++] = (byte) arg1;
	    if (arg0 != -2030879560)
		method486(1, -84);
	    payload[offset++] = (byte) (arg1 >> -1109429416);
	    payload[offset++] = (byte) (arg1 >> -858003088);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.E(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public int method504(boolean arg0) {
	try {
	    offset += 2;
	    if (arg0 != false)
		method474(40, 44);
	    anInt1930++;
	    return ((0xff & payload[offset + -2] - 128)
		    + (0xff00
		       & payload[offset + -1] << -1456241976));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.H(" + arg0 + ')');
	}
    }
    
    public void method505(RSString arg0, byte arg1) {
	try {
	    int i = -97 / ((38 - arg1) / 37);
	    offset += arg0.method51(0, arg0.method59(-3136), payload, offset, -40);
	    anInt1941++;
	    payload[offset++] = (byte) 0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.IB(" + (arg0 != null ? "{...}"
					       : "null") + ',' + arg1 + ')');
	}
    }
    
    public Buffer(int arg0) {
	try {
	    payload = Class13.method246(-21955, arg0);
	    offset = 0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.<init>(" + arg0 + ')');
	}
    }
    
    public void putInt(int arg0, int arg1) {
	payload[offset++] = (byte) (arg1 >> -334148232);
	payload[offset++] = (byte) (arg1 >> -353432240);
	payload[offset++] = (byte) (arg1 >> -226274136);
	payload[offset++] = (byte) arg1;
    }
    
    public int method507(int arg0) {
	try {
	    if (arg0 != -64)
		return -71;
	    offset += 4;
	    anInt1952++;
	    return ((payload[-4 + offset] << -1937025720 & 0xff00)
		    + ((~0xffffff
			& payload[offset + -2] << -771603592)
		       + (payload[offset + -1] << 1234363952
			  & 0xff0000)
		       - -(payload[-3 + offset] & 0xff)));
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.NA(" + arg0 + ')');
	}
    }
    
    public byte get(int arg0) {
	try {
	    anInt1951++;
	    return payload[offset++];
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "ba.I(" + arg0 + ')');
	}
    }
    
    public void method509(int arg0, int arg1) {
	try {
	    anInt1974++;
	    if (arg1 != 32768)
		aClass40_Sub5_Sub14_Sub2_1959 = null;
	    if ((arg0 ^ 0xffffffff) <= -1 && arg0 < 128)
		put(arg0, (byte) -128);
	    else if (arg0 >= 0 && arg0 < 32768)
		method474(32768 - -arg0, arg1 ^ 0x807d);
	    else
		throw new IllegalArgumentException();
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.DA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public Buffer(byte[] arg0) {
	try {
	    offset = 0;
	    payload = arg0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "ba.<init>(" + (arg0 != null ? "{...}"
						   : "null") + ')');
	}
    }
    
    static {
	anIntArray1984 = new int[2000];
	anInt1987 = 0;
	aClass1_1990 = Class58.method978(-11538, "Ausw-=hlen");
	anInt1982 = 0;
	aClass1_1988
	    = (Class58.method978
	       (-11538, "Too many incorrect logins from your address)3"));
	aClass1_1983 = aClass1_1988;
    }
}
