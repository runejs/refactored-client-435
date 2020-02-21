/* Class63 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.util.Random;

public class Class63
{
    public Class16 aClass16_1475;
    public int anInt1476;
    public int anInt1477;
    public static int[] anIntArray1478;
    public int[] anIntArray1479 = new int[5];
    public Class7 aClass7_1480;
    public Class7 aClass7_1481;
    public static int[] anIntArray1482;
    public int[] anIntArray1483 = new int[5];
    public Class7 aClass7_1484;
    public int[] anIntArray1485;
    public int anInt1486;
    public Class7 aClass7_1487;
    public Class7 aClass7_1488;
    public Class7 aClass7_1489;
    public Class7 aClass7_1490;
    public static int[] anIntArray1491 = new int[32768];
    public static int[] anIntArray1492;
    public static int[] anIntArray1493;
    public int anInt1494;
    public static int[] anIntArray1495;
    public static int[] anIntArray1496;
    public Class7 aClass7_1497;
    public Class7 aClass7_1498;
    public static int[] anIntArray1499;
    
    public void method1004(Buffer arg0) {
	aClass7_1488 = new Class7();
	aClass7_1488.method206(arg0);
	aClass7_1490 = new Class7();
	aClass7_1490.method206(arg0);
	int i = arg0.method468(false);
	if (i != 0) {
	    arg0.offset--;
	    aClass7_1484 = new Class7();
	    aClass7_1484.method206(arg0);
	    aClass7_1498 = new Class7();
	    aClass7_1498.method206(arg0);
	}
	i = arg0.method468(false);
	if (i != 0) {
	    arg0.offset--;
	    aClass7_1489 = new Class7();
	    aClass7_1489.method206(arg0);
	    aClass7_1481 = new Class7();
	    aClass7_1481.method206(arg0);
	}
	i = arg0.method468(false);
	if (i != 0) {
	    arg0.offset--;
	    aClass7_1497 = new Class7();
	    aClass7_1497.method206(arg0);
	    aClass7_1480 = new Class7();
	    aClass7_1480.method206(arg0);
	}
	for (int i_0_ = 0; i_0_ < 10; i_0_++) {
	    int i_1_ = arg0.method502((byte) 104);
	    if (i_1_ == 0)
		break;
	    anIntArray1485[i_0_] = i_1_;
	    anIntArray1479[i_0_] = arg0.method482((byte) 46);
	    anIntArray1483[i_0_] = arg0.method502((byte) -77);
	}
	anInt1477 = arg0.method502((byte) 118);
	anInt1486 = arg0.method502((byte) -104);
	anInt1494 = arg0.method469(65280);
	anInt1476 = arg0.method469(65280);
	aClass16_1475 = new Class16();
	aClass7_1487 = new Class7();
	aClass16_1475.method267(arg0, aClass7_1487);
    }
    
    public static void method1005() {
	anIntArray1482 = null;
	anIntArray1491 = null;
	anIntArray1478 = null;
	anIntArray1499 = null;
	anIntArray1495 = null;
	anIntArray1492 = null;
	anIntArray1493 = null;
	anIntArray1496 = null;
    }
    
    public int method1006(int arg0, int arg1, int arg2) {
	if (arg2 == 1) {
	    if ((arg0 & 0x7fff) < 16384)
		return arg1;
	    return -arg1;
	}
	if (arg2 == 2)
	    return anIntArray1478[arg0 & 0x7fff] * arg1 >> 14;
	if (arg2 == 3)
	    return ((arg0 & 0x7fff) * arg1 >> 14) - arg1;
	if (arg2 == 4)
	    return anIntArray1491[arg0 / 2607 & 0x7fff] * arg1;
	return 0;
    }
    
    public int[] method1007(int arg0, int arg1) {
	for (int i = 0; i < arg0; i++)
	    anIntArray1482[i] = 0;
	if (arg1 < 10)
	    return anIntArray1482;
	double d = (double) arg0 / ((double) arg1 + 0.0);
	aClass7_1488.method205();
	aClass7_1490.method205();
	int i = 0;
	int i_2_ = 0;
	int i_3_ = 0;
	if (aClass7_1484 != null) {
	    aClass7_1484.method205();
	    aClass7_1498.method205();
	    i = (int) ((double) (aClass7_1484.anInt268 - aClass7_1484.anInt266)
		       * 32.768 / d);
	    i_2_ = (int) ((double) aClass7_1484.anInt266 * 32.768 / d);
	}
	int i_4_ = 0;
	int i_5_ = 0;
	int i_6_ = 0;
	if (aClass7_1489 != null) {
	    aClass7_1489.method205();
	    aClass7_1481.method205();
	    i_4_ = (int) ((double) (aClass7_1489.anInt268
				    - aClass7_1489.anInt266)
			  * 32.768 / d);
	    i_5_ = (int) ((double) aClass7_1489.anInt266 * 32.768 / d);
	}
	for (int i_7_ = 0; i_7_ < 5; i_7_++) {
	    if (anIntArray1485[i_7_] != 0) {
		anIntArray1499[i_7_] = 0;
		anIntArray1495[i_7_]
		    = (int) ((double) anIntArray1483[i_7_] * d);
		anIntArray1492[i_7_] = (anIntArray1485[i_7_] << 14) / 100;
		anIntArray1493[i_7_]
		    = (int) ((double) (aClass7_1488.anInt268
				       - aClass7_1488.anInt266)
			     * 32.768
			     * Math.pow(1.0057929410678534,
					(double) anIntArray1479[i_7_])
			     / d);
		anIntArray1496[i_7_]
		    = (int) ((double) aClass7_1488.anInt266 * 32.768 / d);
	    }
	}
	for (int i_8_ = 0; i_8_ < arg0; i_8_++) {
	    int i_9_ = aClass7_1488.method208(arg0);
	    int i_10_ = aClass7_1490.method208(arg0);
	    if (aClass7_1484 != null) {
		int i_11_ = aClass7_1484.method208(arg0);
		int i_12_ = aClass7_1498.method208(arg0);
		i_9_ += method1006(i_3_, i_12_, aClass7_1484.anInt267) >> 1;
		i_3_ += (i_11_ * i >> 16) + i_2_;
	    }
	    if (aClass7_1489 != null) {
		int i_13_ = aClass7_1489.method208(arg0);
		int i_14_ = aClass7_1481.method208(arg0);
		i_10_
		    = i_10_ * ((method1006(i_6_, i_14_, aClass7_1489.anInt267)
				>> 1)
			       + 32768) >> 15;
		i_6_ += (i_13_ * i_4_ >> 16) + i_5_;
	    }
	    for (int i_15_ = 0; i_15_ < 5; i_15_++) {
		if (anIntArray1485[i_15_] != 0) {
		    int i_16_ = i_8_ + anIntArray1495[i_15_];
		    if (i_16_ < arg0) {
			anIntArray1482[i_16_]
			    += method1006(anIntArray1499[i_15_],
					  i_10_ * anIntArray1492[i_15_] >> 15,
					  aClass7_1488.anInt267);
			anIntArray1499[i_15_]
			    += ((i_9_ * anIntArray1493[i_15_] >> 16)
				+ anIntArray1496[i_15_]);
		    }
		}
	    }
	}
	if (aClass7_1497 != null) {
	    aClass7_1497.method205();
	    aClass7_1480.method205();
	    int i_17_ = 0;
	    boolean bool = false;
	    boolean bool_18_ = true;
	    for (int i_19_ = 0; i_19_ < arg0; i_19_++) {
		int i_20_ = aClass7_1497.method208(arg0);
		int i_21_ = aClass7_1480.method208(arg0);
		int i_22_;
		if (bool_18_)
		    i_22_ = aClass7_1497.anInt266 + (((aClass7_1497.anInt268
						       - aClass7_1497.anInt266)
						      * i_20_)
						     >> 8);
		else
		    i_22_ = aClass7_1497.anInt266 + (((aClass7_1497.anInt268
						       - aClass7_1497.anInt266)
						      * i_21_)
						     >> 8);
		i_17_ += 256;
		if (i_17_ >= i_22_) {
		    i_17_ = 0;
		    bool_18_ = !bool_18_;
		}
		if (bool_18_)
		    anIntArray1482[i_19_] = 0;
	    }
	}
	if (anInt1477 > 0 && anInt1486 > 0) {
	    int i_23_ = (int) ((double) anInt1477 * d);
	    for (int i_24_ = i_23_; i_24_ < arg0; i_24_++)
		anIntArray1482[i_24_]
		    += anIntArray1482[i_24_ - i_23_] * anInt1486 / 100;
	}
	if (aClass16_1475.anIntArray444[0] > 0
	    || aClass16_1475.anIntArray444[1] > 0) {
	    aClass7_1487.method205();
	    int i_25_ = aClass7_1487.method208(arg0 + 1);
	    int i_26_ = aClass16_1475.method270(0, (float) i_25_ / 65536.0F);
	    int i_27_ = aClass16_1475.method270(1, (float) i_25_ / 65536.0F);
	    if (arg0 >= i_26_ + i_27_) {
		int i_28_ = 0;
		int i_29_ = i_27_;
		if (i_29_ > arg0 - i_26_)
		    i_29_ = arg0 - i_26_;
		for (/**/; i_28_ < i_29_; i_28_++) {
		    int i_30_ = (int) (((long) anIntArray1482[i_28_ + i_26_]
					* (long) Class16.anInt442)
				       >> 16);
		    for (int i_31_ = 0; i_31_ < i_26_; i_31_++)
			i_30_ += (int) (((long) (anIntArray1482
						 [i_28_ + i_26_ - 1 - i_31_])
					 * (long) (Class16.anIntArrayArray440
						   [0][i_31_]))
					>> 16);
		    for (int i_32_ = 0; i_32_ < i_28_; i_32_++)
			i_30_
			    -= (int) (((long) anIntArray1482[i_28_ - 1 - i_32_]
				       * (long) (Class16.anIntArrayArray440[1]
						 [i_32_]))
				      >> 16);
		    anIntArray1482[i_28_] = i_30_;
		    i_25_ = aClass7_1487.method208(arg0 + 1);
		}
		i_29_ = 128;
		for (;;) {
		    if (i_29_ > arg0 - i_26_)
			i_29_ = arg0 - i_26_;
		    for (/**/; i_28_ < i_29_; i_28_++) {
			int i_33_
			    = (int) (((long) anIntArray1482[i_28_ + i_26_]
				      * (long) Class16.anInt442)
				     >> 16);
			for (int i_34_ = 0; i_34_ < i_26_; i_34_++)
			    i_33_
				+= (int) (((long) (anIntArray1482
						   [i_28_ + i_26_ - 1 - i_34_])
					   * (long) (Class16.anIntArrayArray440
						     [0][i_34_]))
					  >> 16);
			for (int i_35_ = 0; i_35_ < i_27_; i_35_++)
			    i_33_
				-= (int) (((long) (anIntArray1482
						   [i_28_ - 1 - i_35_])
					   * (long) (Class16.anIntArrayArray440
						     [1][i_35_]))
					  >> 16);
			anIntArray1482[i_28_] = i_33_;
			i_25_ = aClass7_1487.method208(arg0 + 1);
		    }
		    if (i_28_ >= arg0 - i_26_)
			break;
		    i_26_
			= aClass16_1475.method270(0, (float) i_25_ / 65536.0F);
		    i_27_
			= aClass16_1475.method270(1, (float) i_25_ / 65536.0F);
		    i_29_ += 128;
		}
		for (/**/; i_28_ < arg0; i_28_++) {
		    int i_36_ = 0;
		    for (int i_37_ = i_28_ + i_26_ - arg0; i_37_ < i_26_;
			 i_37_++)
			i_36_ += (int) (((long) (anIntArray1482
						 [i_28_ + i_26_ - 1 - i_37_])
					 * (long) (Class16.anIntArrayArray440
						   [0][i_37_]))
					>> 16);
		    for (int i_38_ = 0; i_38_ < i_27_; i_38_++)
			i_36_
			    -= (int) (((long) anIntArray1482[i_28_ - 1 - i_38_]
				       * (long) (Class16.anIntArrayArray440[1]
						 [i_38_]))
				      >> 16);
		    anIntArray1482[i_28_] = i_36_;
		    i_25_ = aClass7_1487.method208(arg0 + 1);
		}
	    }
	}
	for (int i_39_ = 0; i_39_ < arg0; i_39_++) {
	    if (anIntArray1482[i_39_] < -32768)
		anIntArray1482[i_39_] = -32768;
	    if (anIntArray1482[i_39_] > 32767)
		anIntArray1482[i_39_] = 32767;
	}
	return anIntArray1482;
    }
    
    public Class63() {
	anInt1477 = 0;
	anIntArray1485 = new int[5];
	anInt1476 = 0;
	anInt1486 = 100;
	anInt1494 = 500;
    }
    
    static {
	Random random = new Random(0L);
	for (int i = 0; i < 32768; i++)
	    anIntArray1491[i] = (random.nextInt() & 0x2) - 1;
	anIntArray1478 = new int[32768];
	for (int i = 0; i < 32768; i++)
	    anIntArray1478[i]
		= (int) (Math.sin((double) i / 5215.1903) * 16384.0);
	anIntArray1482 = new int[220500];
	anIntArray1493 = new int[5];
	anIntArray1492 = new int[5];
	anIntArray1496 = new int[5];
	anIntArray1495 = new int[5];
	anIntArray1499 = new int[5];
    }
}
