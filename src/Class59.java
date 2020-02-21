/* Class59 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class59
{
    public static int anInt1380;
    public static int anInt1381;
    public static int anInt1382;
    public static int anInt1383;
    public static int anInt1384;
    public static Buffer aClass40_Sub1_1385
	= new Buffer(new byte[5000]);
    public static int anInt1386;
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_1387;
    public static int anInt1388;
    public static int anInt1389 = 0;
    public static Class40_Sub5_Sub12[][] aClass40_Sub5_Sub12ArrayArray1390;
    public static RSString aClass1_1391;
    public static Class54 aClass54_1392;
    public static int[] anIntArray1393;
    public static RSString aClass1_1394 = Class58.method978(-11538, "Hidden");
    public static RSString aClass1_1395 = Class58.method978(-11538, "backbase1");
    public static RSString aClass1_1396;
    public static long[] aLongArray1397;
    public static int[] anIntArray1398;
    public static RSString aClass1_1399;
    
    public static void method982(int arg0) {
	anInt1384++;
	if (Class32.anInt771 > 0)
	    Class48.method928(-7225);
	else {
	    Floor.method559(40, 99);
	    Class30.aClass64_717 = Class40_Sub6.aClass64_2098;
	    Class40_Sub6.aClass64_2098 = null;
	    if (arg0 != 2578)
		aClass1_1395 = null;
	}
    }
    
    public static void method983(int arg0) {
	try {
	    anInt1381++;
	    int i = 70 / ((62 - arg0) / 55);
	    Class2.aBoolean88 = true;
	    Class46.aBoolean1112 = true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "tc.E(" + arg0 + ')');
	}
    }
    
    public static void method984(int arg0) {
	try {
	    if (arg0 == 0) {
		anInt1380++;
		if (Class5.aClass22_189 != null) {
		    if ((Class62.anInt1450 ^ 0xffffffff) <= -1) {
			if (RSCanvas.anInt54 > 0) {
			    Class39.anInt909 += Buffer.anInt1982;
			    Class5.aClass22_189.method304((byte) -97,
							  Class62.anInt1450,
							  Class39.anInt909);
			    RSCanvas.anInt54--;
			    if (RSCanvas.anInt54 == 0) {
				Class5.aClass22_189.method303((byte) -96);
				Class62.anInt1450 = -1;
				RSCanvas.anInt54 = 20;
			    }
			}
		    } else if (RSCanvas.anInt54 > 0) {
			RSCanvas.anInt54--;
			if ((RSCanvas.anInt54 ^ 0xffffffff) == -1) {
			    if (Player.aByteArray3270
				== null)
				Class5.aClass22_189.method301(256, 0);
			    else {
				Class5.aClass22_189.method301
				    (PacketBuffer.anInt2258, arg0);
				Class62.anInt1450
				    = PacketBuffer.anInt2258;
				Class5.aClass22_189.method300
				    ((Player
				      .aByteArray3270),
				     Class30.aBoolean687, -15910,
				     PacketBuffer.anInt2258);
				Player.aByteArray3270
				    = null;
			    }
			    Class39.anInt909 = 0;
			}
		    }
		    Class5.aClass22_189.method302(0);
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "tc.A(" + arg0 + ')');
	}
    }
    
    public static void method985(byte arg0) {
	try {
	    aClass40_Sub1_1385 = null;
	    int i = 84 / ((arg0 - -74) / 47);
	    aClass40_Sub5_Sub12ArrayArray1390 = null;
	    anIntArray1398 = null;
	    aClass1_1394 = null;
	    aClass40_Sub5_Sub14_Sub2_1387 = null;
	    aClass1_1399 = null;
	    aLongArray1397 = null;
	    aClass1_1395 = null;
	    aClass54_1392 = null;
	    aClass1_1391 = null;
	    aClass1_1396 = null;
	    anIntArray1393 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "tc.B(" + arg0 + ')');
	}
    }
    
    public static int method986(int arg0, int arg1, int arg2, int arg3) {
	try {
	    if (arg2 != 0)
		method986(-73, 123, 115, 98);
	    anInt1382++;
	    if (((Floor.aByteArrayArrayArray2323[arg0][arg3][arg1]
		  & 0x8)
		 ^ 0xffffffff)
		!= -1)
		return 0;
	    if ((arg0 ^ 0xffffffff) < -1
		&& ((Floor.aByteArrayArrayArray2323[1][arg3][arg1]
		     & 0x2)
		    ^ 0xffffffff) != -1)
		return -1 + arg0;
	    return arg0;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("tc.D(" + arg0 + ',' + arg1 + ',' + arg2
				    + ',' + arg3 + ')'));
	}
    }
    
    static {
	anIntArray1393 = new int[500];
	aClass1_1391
	    = (Class58.method978
	       (-11538,
		"Your friendlist is full)3 Max of 100 for free users)1 and 200 for members"));
	aClass1_1396 = aClass1_1394;
	aClass1_1399 = aClass1_1391;
	aLongArray1397 = new long[200];
	aClass54_1392 = new Class54();
    }
}
