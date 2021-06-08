package midi;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class MidiPlayer {

	private Function function = null;

	public MidiPlayer() {
	}

	public MidiPlayer(Function f) {
		function = f;
	}

	public void setFunction(Function f) {
		function = f;
	}

	public void run() {
		try {
			Synthesizer midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();

			// get and load default instrument and channel lists
			Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
			MidiChannel[] mChannels = midiSynth.getChannels();

			midiSynth.loadInstrument(instr[0]);// load an instrument

			for (int i = 0; i < 1000; i++) {
				int result = function.getNthValue(i);
				int note = result % 70 + 30;
				mChannels[0].noteOn(note, 80);// On channel 0, play note number 60 with velocity 100
				try {
					Thread.sleep(150); // wait time in milliseconds to control duration
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mChannels[0].noteOff(note);// turn of the note
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MidiPlayer m = new MidiPlayer();
		
		m.setFunction(new Sandbox());
		m.run();
	}

}
