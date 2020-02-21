/* Class8_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
//import sun.audio.AudioPlayer;

public class Class8_Sub2 extends Class8
{
    public InputStream_Sub1 anInputStream_Sub1_1834;
    
    public void method213() {
	try {
	    // AudioPlayer.player.stop(anInputStream_Sub1_1834);
	    synchronized (anInputStream_Sub1_1834) {
		anInputStream_Sub1_1834.aBoolean72 = true;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public Class8_Sub2() {
	super(8000);
	try {
	    anInputStream_Sub1_1834 = new InputStream_Sub1();
	    // AudioPlayer.player.start(anInputStream_Sub1_1834);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
