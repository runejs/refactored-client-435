package com.jagex.runescape;

import javax.sound.midi.*;
import java.io.ByteArrayInputStream;

public class Class22_Sub2_Sub1 extends Class22_Sub2 implements Receiver {
    public static Sequencer aSequencer2220 = null;
    public static volatile boolean aBoolean2221;
    public static Receiver aReceiver2222 = null;

    static {
        aBoolean2221 = false;
    }

    public Class22_Sub2_Sub1() {
        try {
            aReceiver2222 = MidiSystem.getReceiver();
            aSequencer2220 = MidiSystem.getSequencer(false);
            aSequencer2220.getTransmitter().setReceiver(this);
            aSequencer2220.open();
            method321((byte) 115, -1L);
        } catch(Exception exception) {
            Class65.method1019(104);
        }
    }

    public synchronized void method304(byte arg0, int arg1, int arg2) {
        if(aSequencer2220 != null) {
            method317(arg1, arg2, -1L, 0);
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
            method318(-100, -1L, arg0);
        }
    }

    public void close() {
        /* empty */
    }

    public void method303(byte arg0) {
        if(aSequencer2220 != null) {
            aBoolean2221 = false;
            aSequencer2220.stop();
            method321((byte) 106, -1L);
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

    public void method300(byte[] arg0, boolean arg1, int arg2, int arg3) {
        if(aSequencer2220 != null) {
            try {
                if(arg2 != -15910)
                    aSequencer2220 = null;
                Sequence sequence = MidiSystem.getSequence(new ByteArrayInputStream(arg0));
                aSequencer2220.setSequence(sequence);
                aSequencer2220.setLoopCount(!arg1 ? 0 : -1);
                method317(arg3, 0, -1L, arg2 ^ ~0x3e25);
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
