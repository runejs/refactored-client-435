/* Class14 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class14
{
    public Buffer aClass40_Sub1_423 = new Buffer(null);
    public long aLong424;
    public int[] anIntArray425;
    public int[] anIntArray426;
    public int[] anIntArray427;
    public int[] anIntArray428;
    public static byte[] aByteArray429
	= { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
	    2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
	    2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1,
	    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
	    1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
	    2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public int anInt430;
    public int anInt431;
    
    public int method250() {
	int i = anIntArray425.length;
	int i_0_ = -1;
	int i_1_ = 2147483647;
	for (int i_2_ = 0; i_2_ < i; i_2_++) {
	    if (anIntArray425[i_2_] >= 0 && anIntArray427[i_2_] < i_1_) {
		i_0_ = i_2_;
		i_1_ = anIntArray427[i_2_];
	    }
	}
	return i_0_;
    }
    
    public long method251(int arg0) {
	return aLong424 + (long) arg0 * (long) anInt430;
    }
    
    public int method252(int arg0) {
	int i = method261(arg0);
	return i;
    }
    
    public int method253() {
	return anIntArray425.length;
    }
    
    public void method254(int arg0) {
	int i = aClass40_Sub1_423.method500(68);
	anIntArray427[arg0] += i;
    }
    
    public void method255() {
	aClass40_Sub1_423.payload = null;
	anIntArray426 = null;
	anIntArray425 = null;
	anIntArray427 = null;
	anIntArray428 = null;
    }
    
    public void method256(byte[] arg0) {
	aClass40_Sub1_423.payload = arg0;
	aClass40_Sub1_423.offset = 10;
	int i = aClass40_Sub1_423.method469(65280);
	anInt431 = aClass40_Sub1_423.method469(65280);
	anInt430 = 500000;
	anIntArray426 = new int[i];
	int i_3_ = 0;
	while (i_3_ < i) {
	    int i_4_ = aClass40_Sub1_423.method491(-4750);
	    int i_5_ = aClass40_Sub1_423.method491(-4750);
	    if (i_4_ == 1297379947) {
		anIntArray426[i_3_] = aClass40_Sub1_423.offset;
		i_3_++;
	    }
	    aClass40_Sub1_423.offset += i_5_;
	}
	anIntArray425 = (int[]) anIntArray426.clone();
	anIntArray427 = new int[i];
	anIntArray428 = new int[i];
    }
    
    public boolean method257() {
	if (aClass40_Sub1_423.payload == null)
	    return false;
	return true;
    }
    
    public boolean method258() {
	if (aClass40_Sub1_423.offset >= 0)
	    return false;
	return true;
    }
    
    public void method259(long arg0) {
	aLong424 = arg0;
	int i = anIntArray425.length;
	for (int i_6_ = 0; i_6_ < i; i_6_++) {
	    anIntArray427[i_6_] = 0;
	    anIntArray428[i_6_] = 0;
	    aClass40_Sub1_423.offset = anIntArray426[i_6_];
	    method254(i_6_);
	    anIntArray425[i_6_] = aClass40_Sub1_423.offset;
	}
    }
    
    public void method260(int arg0) {
	anIntArray425[arg0] = aClass40_Sub1_423.offset;
    }
    
    public int method261(int arg0) {
	int i = aClass40_Sub1_423.payload[aClass40_Sub1_423.offset];
	if (i < 0) {
	    i &= 0xff;
	    anIntArray428[arg0] = i;
	    aClass40_Sub1_423.offset++;
	} else
	    i = anIntArray428[arg0];
	if (i == 240 || i == 247) {
	    int i_7_ = aClass40_Sub1_423.method500(63);
	    if (i == 247 && i_7_ > 0) {
		int i_8_ = ((aClass40_Sub1_423.payload
			     [aClass40_Sub1_423.offset])
			    & 0xff);
		if (i_8_ >= 241 && i_8_ <= 243 || i_8_ == 246 || i_8_ == 248
		    || i_8_ >= 250 && i_8_ <= 252 || i_8_ == 254) {
		    aClass40_Sub1_423.offset++;
		    anIntArray428[arg0] = i_8_;
		    return method262(arg0, i_8_);
		}
	    }
	    aClass40_Sub1_423.offset += i_7_;
	    return 0;
	}
	return method262(arg0, i);
    }
    
    public int method262(int arg0, int arg1) {
	if (arg1 == 255) {
	    int i = aClass40_Sub1_423.method468(false);
	    int i_9_ = aClass40_Sub1_423.method500(88);
	    if (i == 47) {
		aClass40_Sub1_423.offset += i_9_;
		return 1;
	    }
	    if (i == 81) {
		int i_10_ = aClass40_Sub1_423.getTri(true);
		i_9_ -= 3;
		int i_11_ = anIntArray427[arg0];
		aLong424 += (long) i_11_ * (long) (anInt430 - i_10_);
		anInt430 = i_10_;
		aClass40_Sub1_423.offset += i_9_;
		return 2;
	    }
	    aClass40_Sub1_423.offset += i_9_;
	    return 3;
	}
	byte i = aByteArray429[arg1 - 128];
	int i_12_ = arg1;
	if (i >= 1)
	    i_12_ |= aClass40_Sub1_423.method468(false) << 8;
	if (i >= 2)
	    i_12_ |= aClass40_Sub1_423.method468(false) << 16;
	return i_12_;
    }
    
    public boolean method263() {
	int i = anIntArray425.length;
	for (int i_13_ = 0; i_13_ < i; i_13_++) {
	    if (anIntArray425[i_13_] >= 0)
		return false;
	}
	return true;
    }
    
    public void method264() {
	aClass40_Sub1_423.offset = -1;
    }
    
    public void method265(int arg0) {
	aClass40_Sub1_423.offset = anIntArray425[arg0];
    }
    
    public static void method266() {
	aByteArray429 = null;
    }
}
