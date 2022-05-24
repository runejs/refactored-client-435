package org.runejs.client.sound;

import java.awt.Component;

import org.runejs.client.util.Signlink;

public class StaticAudio {

	public static int sampleRate;

	/*synthetic*/
	public static Class method1058(String arg0) {
	    try {
	        return Class.forName(arg0);
	    } catch(ClassNotFoundException classnotfoundexception) {
	        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
	    }
	}

	public static void method1054() {
	    if(StaticAudio.aClass8_166 != null) {
	        long l = System.currentTimeMillis();
	        if(StaticAudio.aLong288 < l) {
	            StaticAudio.aClass8_166.method212(l);
	            int i = (int) (-StaticAudio.aLong288 + l);
	            StaticAudio.aLong288 = l;
	            synchronized(StaticAudio.aClass1654 != null ? StaticAudio.aClass1654 : (StaticAudio.aClass1654 = method1058("org.runejs.client.sound.Class8"))) {
	                StaticAudio.anInt2081 += sampleRate * i;
	                int i_0_ = (-(2000 * sampleRate) + StaticAudio.anInt2081) / 1000;
	                if(i_0_ > 0) {
	                    if(StaticAudio.aPcmStream_608 != null)
	                        StaticAudio.aPcmStream_608.skip(i_0_);
	                    StaticAudio.anInt2081 -= i_0_ * 1000;
	                }
	            }
	        }
	    }
	}

	public static PcmStream aPcmStream_608;
	public static long aLong288;
	public static Class8 aClass8_166;
	/*synthetic*/ public static Class aClass1654;
	public static Object lock = new Object();
	public static int anInt2081;

	public static void method748(int arg1) {
	    for(StaticAudio.anInt2866 += arg1; StaticAudio.anInt2866 >= sampleRate; StaticAudio.anInt2866 -= sampleRate) {
	        anInt2081 -= anInt2081 >> 2;
	    }
	    anInt2081 -= 1000 * arg1;
	    if(anInt2081 < 0) {
	        anInt2081 = 0;
	    }
	}

	public static int anInt2866;

	public static void method1040(Component arg0, int arg1, Signlink arg2) {
	    try {    	
	        Class8_Sub1 class8_sub1 = new Class8_Sub1_Sub2();
	        class8_sub1.method222(arg2, 2048);
	        aClass8_166 = class8_sub1;        
	    } catch (Throwable throwable) {
            aClass8_166 = new Class8(8000);	        
	    }
	
	}

	public static PcmStreamMixer method1003(Signlink arg0, Component arg1) {
	    method1040(arg1, 0, arg0);
	    PcmStreamMixer class40_sub9_sub1 = new PcmStreamMixer();
	    Class8.method218(class40_sub9_sub1);
	    return class40_sub9_sub1;
	
	}

}
