/* Class7 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class7
{
    public int anInt264 = 2;
    public int[] anIntArray265 = new int[2];
    public int anInt266;
    public int anInt267;
    public int anInt268;
    public int[] anIntArray269 = new int[2];
    public int anInt270;
    public int anInt271;
    public int anInt272;
    public int anInt273;
    public int anInt274;
    
    public void method205() {
	anInt272 = 0;
	anInt273 = 0;
	anInt271 = 0;
	anInt274 = 0;
	anInt270 = 0;
    }
    
    public void method206(Buffer arg0) {
	anInt267 = arg0.method468(false);
	anInt266 = arg0.method491(-4750);
	anInt268 = arg0.method491(-4750);
	method207(arg0);
    }
    
    public void method207(Buffer arg0) {
	anInt264 = arg0.method468(false);
	anIntArray265 = new int[anInt264];
	anIntArray269 = new int[anInt264];
	for (int i = 0; i < anInt264; i++) {
	    anIntArray265[i] = arg0.method469(65280);
	    anIntArray269[i] = arg0.method469(65280);
	}
    }
    
    public int method208(int arg0) {
	if (anInt270 >= anInt272) {
	    anInt274 = anIntArray269[anInt273++] << 15;
	    if (anInt273 >= anInt264)
		anInt273 = anInt264 - 1;
	    anInt272 = (int) ((double) anIntArray265[anInt273] / 65536.0
			      * (double) arg0);
	    if (anInt272 > anInt270)
		anInt271 = (((anIntArray269[anInt273] << 15) - anInt274)
			    / (anInt272 - anInt270));
	}
	anInt274 += anInt271;
	anInt270++;
	return anInt274 - anInt271 >> 15;
    }
    
    public Class7() {
	anIntArray265[0] = 0;
	anIntArray265[1] = 65535;
	anIntArray269[0] = 0;
	anIntArray269[1] = 65535;
    }
}
