package org.runejs.client.sound;

import javax.sound.midi.*;

import java.io.ByteArrayInputStream;

public class MidiPlayer435 implements Receiver {    
    
    private static volatile boolean active;


    private static int volume = 256;

    private static int[] volumes = new int[]{12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800};
	private static int[] anIntArray889 = new int[128];

	private static Receiver receiver = null;

	private static Sequencer sequencer = null;

    static {
        active = false;
    }

    private static int getChannelVolume(int channel) {
        int i = volumes[channel];
        i = (i * MidiPlayer435.volume >> 8) * i;
        return (int) (Math.sqrt(i) + 0.5);
    }
    
    public MidiPlayer435() {
        try {
            receiver = MidiSystem.getReceiver();
            sequencer = MidiSystem.getSequencer(false);
            sequencer.getTransmitter().setReceiver(this);
            sequencer.open();
            reset(-1L);
        } catch(Exception exception) {
            StaticAudio.method1019();
        }
    }
    public void close() {
        /* empty */
    }
    public void method300(byte[] arg0, boolean arg1, int arg3) {
        if(sequencer != null) {
            try {
                Sequence sequence = MidiSystem.getSequence(new ByteArrayInputStream(arg0));
                sequencer.setSequence(sequence);
                sequencer.setLoopCount(!arg1 ? 0 : -1);
                method317(arg3, 0, -1L);
                active = true;
                sequencer.start();
            } catch(Exception exception) {
                /* empty */
            }
        }
    }

    public void method301(int arg0, int arg1) {
        if(null != sequencer) {
            if(arg1 != 0)
                method301(114, 102);
            method318(-1L, arg0);
        }
    }

    public void method302(int arg0) {
        if(arg0 != 0)
            method303((byte) -23);
    }

    public void method303(byte arg0) {
        if(sequencer != null) {
            active = false;
            sequencer.stop();
            reset(-1L);
            if(arg0 != -96)
                send(-102, -74, -81, 35L);
        }
    }

    public synchronized void method304(byte arg0, int arg1, int arg2) {
        if(sequencer != null) {
            method317(arg1, arg2, -1L);
            if(arg0 > -82)
                sequencer = null;
        }
    }

    public void close(byte arg0) {
        if(null != sequencer) {
            sequencer.close();
            sequencer = null;
        }
        if(receiver != null) {
            receiver.close();
            receiver = null;
        }
    }

    public void send(int status, int data1, int data2, long timeStamp) {
        try {
            ShortMessage shortmessage = new ShortMessage();
            shortmessage.setMessage(status, data1, data2);
            receiver.send(shortmessage, timeStamp);
        } catch(InvalidMidiDataException invalidmididataexception) {
            /* empty */
        }
    }

    public void method317(int arg0, int arg1, long arg2) {
        do {
            arg0 = (int) ((double) arg0 * Math.pow(0.1, (double) arg1 * 5.0E-4) + 0.5);
            if(arg0 != MidiPlayer435.volume) {
                MidiPlayer435.volume = arg0;
                for(int i = 0; i < 16; i++) {
                    int i_2_ = getChannelVolume(i);
                    send(176 + i, 7, i_2_ >> 7, arg2);
                    send(176 + i, 39, i_2_ & 0x7f, arg2);
                }
            }
            break;
        } while(false);
    }

    public void method318(long arg1, int arg2) {
        MidiPlayer435.volume = arg2;
        for(int i = 0; i < 16; i++)
            volumes[i] = 12800;
        for(int i = 0; i < 16; i++) {
            int i_3_ = getChannelVolume(i);
            send(176 + i, 7, i_3_ >> 7, arg1);
            send(176 + i, 39, 0x7f & i_3_, arg1);
        }
    }

    public void reset(long timeStamp) {
        for(int i = 0; i < 128; i++) {
            int i_6_ = MidiPlayer435.anIntArray889[i];
            MidiPlayer435.anIntArray889[i] = 0;
            for(int i_7_ = 0; i_7_ < 16; i_7_++) {
                if((i_6_ & 1 << i_7_) != 0)
                    send(144 + i_7_, i, 0, timeStamp);
            }
        }
        for(int i = 0; i < 16; i++)
            send(i + 176, 123, 0, timeStamp);
        for(int i = 0; i < 16; i++)
            send(i + 176, 120, 0, timeStamp);
        for(int i = 0; i < 16; i++)
            send(i + 176, 121, 0, timeStamp);
        for(int i = 0; i < 16; i++)
            send(i + 176, 0, 0, timeStamp);
        for(int i = 0; i < 16; i++)
            send(176 + i, 32, 0, timeStamp);
        for(int i = 0; i < 16; i++)
            send(i + 192, 0, 0, timeStamp);
    }

    public boolean send0(int status, int data1, int data2, long timeStamp) {
        if((status & 0xe0) == 128) {
            int i = 1 << (status & 0xf);
            int i_8_ = MidiPlayer435.anIntArray889[data1];
            if(status >= 144 && data2 != 0) {
                if((i_8_ & i) != 0)
                    send(status, data1, 0, timeStamp);
                else
                    MidiPlayer435.anIntArray889[data1] = i_8_ | i;
            } else
                MidiPlayer435.anIntArray889[data1] = i_8_ & (i ^ 0xffffffff);
            return false;
        }
        if((status & 0xf0) == 176) {
            if(data1 == 121) {
                send(status, data1, data2, timeStamp);
                int i = status & 0xf;
                volumes[i] = 12800;
                int i_9_ = getChannelVolume(i);
                send(status, 7, i_9_ >> 7, timeStamp);
                send(status, 39, i_9_ & 0x7f, timeStamp);
                return true;
            }
            if(data1 == 7 || data1 == 39) {
                int i = status & 0xf;
                if(data1 == 7)
                    volumes[i] = (volumes[i] & 0x7f) + (data2 << 7);
                else
                    volumes[i] = (volumes[i] & 0x3f80) + data2;
                int i_10_ = getChannelVolume(i);
                send(status, 7, i_10_ >> 7, timeStamp);
                send(status, 39, i_10_ & 0x7f, timeStamp);
                return true;
            }
        }
        return false;
    }

    public synchronized void send(MidiMessage message, long timeStamp) {
        if(active) {
            byte[] is = message.getMessage();
            if(!send0(is[0] & 0xff, is[1], is.length >= 3 ? is[2] : 0, timeStamp))
                receiver.send(message, timeStamp);
        }
    }
}
