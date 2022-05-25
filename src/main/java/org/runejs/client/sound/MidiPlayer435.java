package org.runejs.client.sound;

import javax.sound.midi.*;

import java.io.ByteArrayInputStream;

public class MidiPlayer435 implements Receiver {    
    
    public static int[] anIntArray774 = new int[]{12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800};


    public static int method323(int arg0) {
        int i = anIntArray774[arg0];
        i = (i * MidiPlayer435.anInt1040 >> 8) * i;
        return (int) (Math.sqrt(i) + 0.5);
    }

	public static int[] anIntArray889 = new int[128];
	public static int anInt1040 = 256;

    public void method317(int arg0, int arg1, long arg2) {
        do {
            arg0 = (int) ((double) arg0 * Math.pow(0.1, (double) arg1 * 5.0E-4) + 0.5);
            if(arg0 != MidiPlayer435.anInt1040) {
                MidiPlayer435.anInt1040 = arg0;
                for(int i = 0; i < 16; i++) {
                    int i_2_ = method323(i);
                    method314(176 + i, 7, i_2_ >> 7, arg2);
                    method314(176 + i, 39, i_2_ & 0x7f, arg2);
                }
            }
            break;
        } while(false);
    }

    public void method318(long arg1, int arg2) {
        MidiPlayer435.anInt1040 = arg2;
        for(int i = 0; i < 16; i++)
            anIntArray774[i] = 12800;
        for(int i = 0; i < 16; i++) {
            int i_3_ = method323(i);
            method314(176 + i, 7, i_3_ >> 7, arg1);
            method314(176 + i, 39, 0x7f & i_3_, arg1);
        }
    }

    public void method321(long arg1) {
        for(int i = 0; i < 128; i++) {
            int i_6_ = MidiPlayer435.anIntArray889[i];
            MidiPlayer435.anIntArray889[i] = 0;
            for(int i_7_ = 0; i_7_ < 16; i_7_++) {
                if((i_6_ & 1 << i_7_) != 0)
                    method314(144 + i_7_, i, 0, arg1);
            }
        }
        for(int i = 0; i < 16; i++)
            method314(i + 176, 123, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 120, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 121, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 0, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(176 + i, 32, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 192, 0, 0, arg1);
    }

    public boolean method322(int arg0, int arg1, int arg2, long arg3) {
        if((arg0 & 0xe0) == 128) {
            int i = 1 << (arg0 & 0xf);
            int i_8_ = MidiPlayer435.anIntArray889[arg1];
            if(arg0 >= 144 && arg2 != 0) {
                if((i_8_ & i) != 0)
                    method314(arg0, arg1, 0, arg3);
                else
                    MidiPlayer435.anIntArray889[arg1] = i_8_ | i;
            } else
                MidiPlayer435.anIntArray889[arg1] = i_8_ & (i ^ 0xffffffff);
            return false;
        }
        if((arg0 & 0xf0) == 176) {
            if(arg1 == 121) {
                method314(arg0, arg1, arg2, arg3);
                int i = arg0 & 0xf;
                anIntArray774[i] = 12800;
                int i_9_ = method323(i);
                method314(arg0, 7, i_9_ >> 7, arg3);
                method314(arg0, 39, i_9_ & 0x7f, arg3);
                return true;
            }
            if(arg1 == 7 || arg1 == 39) {
                int i = arg0 & 0xf;
                if(arg1 == 7)
                    anIntArray774[i] = (anIntArray774[i] & 0x7f) + (arg2 << 7);
                else
                    anIntArray774[i] = (anIntArray774[i] & 0x3f80) + arg2;
                int i_10_ = method323(i);
                method314(arg0, 7, i_10_ >> 7, arg3);
                method314(arg0, 39, i_10_ & 0x7f, arg3);
                return true;
            }
        }
        return false;
    }
    
    public static Sequencer aSequencer2220 = null;
    public static volatile boolean aBoolean2221;
    public static Receiver aReceiver2222 = null;

    static {
        aBoolean2221 = false;
    }

    public MidiPlayer435() {
        try {
            aReceiver2222 = MidiSystem.getReceiver();
            aSequencer2220 = MidiSystem.getSequencer(false);
            aSequencer2220.getTransmitter().setReceiver(this);
            aSequencer2220.open();
            method321(-1L);
        } catch(Exception exception) {
            StaticAudio.method1019();
        }
    }

    public synchronized void method304(byte arg0, int arg1, int arg2) {
        if(aSequencer2220 != null) {
            method317(arg1, arg2, -1L);
            if(arg0 > -82)
                aSequencer2220 = null;
        }
    }

    public void method306(byte arg0) {
        if(null != aSequencer2220) {
            aSequencer2220.close();
            aSequencer2220 = null;
        }
        if(aReceiver2222 != null) {
            aReceiver2222.close();
            aReceiver2222 = null;
        }
        if(arg0 < 100)
            method301(-16, -43);
    }

    public void method301(int arg0, int arg1) {
        if(null != aSequencer2220) {
            if(arg1 != 0)
                method301(114, 102);
            method318(-1L, arg0);
        }
    }

    public void close() {
        /* empty */
    }

    public void method303(byte arg0) {
        if(aSequencer2220 != null) {
            aBoolean2221 = false;
            aSequencer2220.stop();
            method321(-1L);
            if(arg0 != -96)
                method314(-102, -74, -81, 35L);
        }
    }

    public void method314(int arg0, int arg1, int arg2, long arg3) {
        try {
            ShortMessage shortmessage = new ShortMessage();
            shortmessage.setMessage(arg0, arg1, arg2);
            aReceiver2222.send(shortmessage, arg3);
        } catch(InvalidMidiDataException invalidmididataexception) {
            /* empty */
        }
    }

    public void method300(byte[] arg0, boolean arg1, int arg3) {
        if(aSequencer2220 != null) {
            try {
                Sequence sequence = MidiSystem.getSequence(new ByteArrayInputStream(arg0));
                aSequencer2220.setSequence(sequence);
                aSequencer2220.setLoopCount(!arg1 ? 0 : -1);
                method317(arg3, 0, -1L);
                aBoolean2221 = true;
                aSequencer2220.start();
            } catch(Exception exception) {
                /* empty */
            }
        }
    }

    public synchronized void send(MidiMessage arg0, long arg1) {
        if(aBoolean2221) {
            byte[] is = arg0.getMessage();
            if(!method322(is[0] & 0xff, is[1], is.length >= 3 ? is[2] : 0, arg1))
                aReceiver2222.send(arg0, arg1);
        }
    }

    public void method302(int arg0) {
        if(arg0 != 0)
            method303((byte) -23);
    }
}
