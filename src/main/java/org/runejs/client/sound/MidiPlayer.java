package org.runejs.client.sound;

import java.io.ByteArrayInputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;

/**
 * An implementation of a MidiPlayer. This is the code from Revision #435 which has been cleaned up, combined into a class and uses some comments from Dane who released a standalone MIDI player for 317..
 *
 */
public class MidiPlayer implements Receiver {
	
	private static volatile boolean active = false;
	private static int[] anIntArray889 = new int[128];

	private static final int PROGRAM_0 = 0;
	private static final int MSB_CHANNEL_VOLUME = 7;
	private static final int LSB_CHANNEL_VOLUME = 39;
	private static final int MSB_BANK_SELECT = 0;
	private static final int LSB_BANK_SELECT = 32;
	private static final int ALL_SOUND_OFF = 120;
	private static final int RESET_ALL_CONTROLLERS = 121;
	private static final int ALL_NOTES_OFF = 123;

    /**
     * An integer array of channel volumes in their bitpacked squared forms.
     *
     * @see <a href="https://www.midi.org/specifications-old/category/reference-tables">MIDI Specifications</a>
     */
    private static final int[] volumes = new int[]{0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200};

    /**
     * The tracked volume
     */
	private static int volume = 256;

    /**
     * The {@link MidiSystem} receiver.
     */
    private static Receiver receiver;

    /**
     * The {@link MidiSystem} sequencer.
     */
    private static Sequencer sequencer;

	private static int getChannelVolume(int channel) {
		int data = MidiPlayer.volumes[channel];
		data = (data * MidiPlayer.volume >> 8) * data;
		return (int) (Math.sqrt(data) + 0.5);
	}

	/**
     * Creates a new {@link MidiPlayer}.
	 */
	public MidiPlayer() {
		try {
			receiver = MidiSystem.getReceiver();
			sequencer = MidiSystem.getSequencer(false);
			sequencer.getTransmitter().setReceiver(this);
			sequencer.open();
			reset(-1L);
		} catch (Exception exception) {
			MusicSystem.stop_();
		}
	}

	@Override
	public void close() {
		/* empty */
	}

	public void play(byte[] arg0, boolean loop, int volume) {
		if (sequencer != null) {
			try {
				Sequence sequence = MidiSystem.getSequence(new ByteArrayInputStream(arg0));
				sequencer.setSequence(sequence);
				sequencer.setLoopCount(loop ? Sequencer.LOOP_CONTINUOUSLY : 0);
				setVolume(volume, 0, -1L);
				active = true;
				sequencer.start();
			} catch (Exception exception) {
				/* empty */
			}
		}
	}

	public void resetVolume(int volume) {
		if (null != sequencer) {
			resetVolume(-1L, volume);
		}
	}

	public void stop0() {
		if (sequencer != null) {
			active = false;
			sequencer.stop();
			reset(-1L);
		}
	}

	public synchronized void setVolume(int volume, int velocity) {
		if (sequencer != null) {
			setVolume(volume, velocity, -1L);
		}
	}

	public void close0(byte arg0) {
		if (null != sequencer) {
			sequencer.close();
			sequencer = null;
		}
		if (receiver != null) {
			receiver.close();
			receiver = null;
		}
	}

	/**
	 * Sends the parameters to the {@link #receiver} 
	 * 
     * @param status the status
     * @param data1  the data1
     * @param data2  the data2
	 * @param timeStamp
	 */
	public void send(int status, int data1, int data2, long timeStamp) {
		try {
			ShortMessage shortmessage = new ShortMessage();
			shortmessage.setMessage(status, data1, data2);
			receiver.send(shortmessage, timeStamp);
		} catch (InvalidMidiDataException invalidmididataexception) {
			/* empty */
		}
	}

	public void setVolume(int volume, int velocity, long timeStamp) {
		volume = (int) (volume * Math.pow(0.1, velocity * 5.0E-4) + 0.5);
		if (volume != MidiPlayer.volume) {
			MidiPlayer.volume = volume;
			for (int i = 0; i < 16; i++) {
				int data = getChannelVolume(i);
				send(ShortMessage.CONTROL_CHANGE + i, MSB_CHANNEL_VOLUME, data >> 7, timeStamp);
				send(ShortMessage.CONTROL_CHANGE + i, LSB_CHANNEL_VOLUME, data & 0x7f, timeStamp);
			}
		}
	}

	public void resetVolume(long timeStamp, int volume) {
		MidiPlayer.volume = volume;
		for (int i = 0; i < 16; i++)
			MidiPlayer.volumes[i] = 12800;
		for (int i = 0; i < 16; i++) {
			int data = getChannelVolume(i);
			send(ShortMessage.CONTROL_CHANGE + i, MSB_CHANNEL_VOLUME, data >> 7, timeStamp);
			send(ShortMessage.CONTROL_CHANGE + i, LSB_CHANNEL_VOLUME, 0x7f & data, timeStamp);
		}
	}

	public void reset(long timeStamp) {
		for (int i = 0; i < 128; i++) {
			int i_6_ = MidiPlayer.anIntArray889[i];
			MidiPlayer.anIntArray889[i] = 0;
			for (int i_7_ = 0; i_7_ < 16; i_7_++) {
				if ((i_6_ & 1 << i_7_) != 0)
					send(144 + i_7_, i, 0, timeStamp);
			}
		}
		for (int i = 0; i < 16; i++)
			send(i + ShortMessage.CONTROL_CHANGE, ALL_NOTES_OFF, 0, timeStamp);
		for (int i = 0; i < 16; i++)
			send(i + ShortMessage.CONTROL_CHANGE, ALL_SOUND_OFF, 0, timeStamp);
		for (int i = 0; i < 16; i++)
			send(i + ShortMessage.CONTROL_CHANGE, RESET_ALL_CONTROLLERS, 0, timeStamp);
		for (int i = 0; i < 16; i++)
			send(i + ShortMessage.CONTROL_CHANGE, MSB_BANK_SELECT, 0, timeStamp);
		for (int i = 0; i < 16; i++)
			send(i + ShortMessage.CONTROL_CHANGE, LSB_BANK_SELECT, 0, timeStamp);
		for (int i = 0; i < 16; i++)
			send(i + ShortMessage.PROGRAM_CHANGE, PROGRAM_0, 0, timeStamp);
	}

	/**
	 * An internal method used to override specific control changes.
	 * 
     * @param status the status
     * @param data1  the data1
     * @param data2  the data2
	 * @param timeStamp
	 * @return <code>true</code> if overriden, else <code>false</code>.
	 */
	public boolean send0(int status, int data1, int data2, long timeStamp) {
		if ((status & 0xe0) == ShortMessage.NOTE_OFF) {
			int i = 1 << (status & 0xf);
			int i_8_ = MidiPlayer.anIntArray889[data1];
			if (status >= 144 && data2 != 0) {
				if ((i_8_ & i) != 0)
					send(status, data1, 0, timeStamp);
				else
					MidiPlayer.anIntArray889[data1] = i_8_ | i;
			} else
				MidiPlayer.anIntArray889[data1] = i_8_ & (i ^ 0xffffffff);
			return false;
		}
		if ((status & 0xf0) == ShortMessage.CONTROL_CHANGE) {
			if (data1 == RESET_ALL_CONTROLLERS) {
				send(status, data1, data2, timeStamp);
				int i = status & 0xf;
				MidiPlayer.volumes[i] = 12800;
				int i_9_ = getChannelVolume(i);
				send(status, MSB_CHANNEL_VOLUME, i_9_ >> 7, timeStamp);
				send(status, LSB_CHANNEL_VOLUME, i_9_ & 0x7f, timeStamp);
				return true;
			}
			if (data1 == MSB_CHANNEL_VOLUME || data1 == LSB_CHANNEL_VOLUME) {
				int i = status & 0xf;
				if (data1 == MSB_CHANNEL_VOLUME)
					MidiPlayer.volumes[i] = (MidiPlayer.volumes[i] & 0x7f) + (data2 << 7);
				else
					MidiPlayer.volumes[i] = (MidiPlayer.volumes[i] & 0x3f80) + data2;
				int i_10_ = getChannelVolume(i);
				send(status, MSB_CHANNEL_VOLUME, i_10_ >> 7, timeStamp);
				send(status, LSB_CHANNEL_VOLUME, i_10_ & 0x7f, timeStamp);
				return true;
			}
		}
		return false;
	}

	
	@Override
	public synchronized void send(MidiMessage message, long timeStamp) {
		if (active) {
			byte[] is = message.getMessage();
			if (!send0(is[0] & 0xff, is[1], is.length >= 3 ? is[2] : 0, timeStamp))
				receiver.send(message, timeStamp);
		}
	}
}
