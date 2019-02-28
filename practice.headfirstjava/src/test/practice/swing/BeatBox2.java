package test.practice.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * �����Ӵ洢�Ͷ�ȡ����
 * @author ����
 *
 */
public class BeatBox2 {
	JPanel mainPanel;
	//��checkbox �洢��ArrayList��
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	//�������ƣ���String�� arrayά��
	String [] instrumentNames = {"Bass DRUM","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
			"Crash Cymbal","Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga",
			"Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"};
	//ʵ�ʵ������ؼ��֣�����˵35��bass 42:Closed Hi-Hat
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	public static void main(String[] args) {
		new BeatBox2().buildGui();
	}
	public void buildGui() {
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		//��������ϰ������ʱ�Ŀհױ�Ե
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		JButton serializelt = new JButton("Serializelt");
		serializelt.addActionListener(new MySendListener());
		buttonBox.add(serializelt);
		
		JButton restore = new JButton("Restore");
		restore.addActionListener(new MyRestoreListener());
		buttonBox.add(restore);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i=0;i<16;i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);
		
		
		theFrame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);//��ֱ���
		grid.setHgap(2);//ˮƽ���
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);
		//����checkbox�飬�趨��δ��ѡ��Ϊfalse,�����뵽ArrayList�������
		for(int i=0;i<256;i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		//�����Լ�д��midi����
		setUpMidi();
		
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
		
	}
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);	//ÿ���ӽ�����
		}catch(Exception e) {e.printStackTrace();}
	}
	public void buildTrackAndStart() {
		//����16��Ԫ�ص��������洢һ��������ֵ������ý�Ӧ��Ҫ���࣬��ֵ���ǹؼ���ֵ������ֵΪ��
		int[] trackList = null;
		//������ɵ�track��һ���µ�
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		for(int i=0;i<16;i++) {
			//ÿ��������ִ��һ��
			trackList = new int[16];
			//�趨���������Ĺؼ���
			int key = instruments[i];
			//��ÿһ��ִ��һ��
			for(int j=0;j<16;j++) {
				JCheckBox jc = (JCheckBox)checkboxList.get(j+(16*i));
				//����й�ѡ�����ؼ���ֵ�ŵ�����ĸ�λ���ϣ���Ȼ�Ͳ���.
				if(jc.isSelected()) {
					trackList[j] = key;
				}else {
					trackList[j] = 0;
				}
			}
			//�Զ��������������ʵ�ִ������������¼����ӵ�track��
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		//ȷ����16�����¼�������beatbox�����ظ�����
		track.add(makeEvent(192,9,1,0,15));
		
		try {
			sequencer.setSequence(sequence);
			//ָ��������ظ�����
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}
	//����ĳ�������������¼�
	public void makeTracks(int[] list) {
		for(int i=0;i<16;i++) {
			int key = list[i];
			if(key!=0) {
				//ʵ���Զ��巽��������NOTE ON ��NOTE OFF�¼������뵽track��
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}
	public MidiEvent makeEvent(int comd,int chan,int one,int two,int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return event;
	}
	//�ڲ���
	public class MyStartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			buildTrackAndStart();
		}
	}
	public class MyStopListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			sequencer.stop();
		}
	}
	public class MyUpTempoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));	//�������ӣ�Ԥ��Ϊ1��ÿ�ε���3%
		}
	}
	public class MyDownTempoListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*.97));
		}
	}
	public class MySendListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean[] checkboxState = new boolean[256];//���ڱ��渴ѡ���״̬
			for(int i=0;i<256;i++) {	//���ȡ��״̬���ӵ�������
				JCheckBox check = checkboxList.get(i);
				if(check.isSelected()) {
					checkboxState[i]=true;
				}
			}
			//��boolean�������л�
			try {
				FileOutputStream fileStream = new FileOutputStream(new File("F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Checkbox.ser"));
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
				os.writeObject(checkboxState);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public class MyRestoreListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean[] checkboxState = null;	
			try {
				FileInputStream fis = new FileInputStream(new File("F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Checkbox.ser"));
				ObjectInputStream ois = new ObjectInputStream(fis);
				checkboxState = (boolean[]) ois.readObject();//��ȡ�ļ��еĶ��󲢽�Object���ͻ���boolean����
			} catch (Exception e) {
				e.printStackTrace();
			}
			//��ԭÿ��checkbox��״̬
			for(int i=0;i<256;i++) {
				JCheckBox check = checkboxList.get(i);
				if(checkboxState[i]) {
					check.setSelected(true);
				}else {
					check.setSelected(false);
				}
			}
			sequencer.stop();	//ֹͣĿǰ���ŵĽ��ಢʹ�ø�ѡ��״̬
			buildTrackAndStart();//���´�������
		}
	}
}
