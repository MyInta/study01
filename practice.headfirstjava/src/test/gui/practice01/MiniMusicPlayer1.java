package test.gui.practice01;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer1 {
	public static void main(String[] args) {
		try {
			//创建并打开队列
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			//创建队列并track
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			for(int i=5;i<66;i+=4) {
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			//开始播放
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static MidiEvent makeEvent(int comd,int chan,int one,int two,int tick) {
		MidiEvent event=null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return event;
		
	}
}
