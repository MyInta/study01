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
 * 再增加存储和读取功能
 * @author 银涛
 *
 */
public class BeatBox2 {
	JPanel mainPanel;
	//将checkbox 存储在ArrayList中
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	//乐器名称，以String的 array维护
	String [] instrumentNames = {"Bass DRUM","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare",
			"Crash Cymbal","Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga",
			"Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"};
	//实际的乐器关键字，例如说35是bass 42:Closed Hi-Hat
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	public static void main(String[] args) {
		new BeatBox2().buildGui();
	}
	public void buildGui() {
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		//设置面板上摆设组件时的空白边缘
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
		grid.setVgap(1);//垂直间距
		grid.setHgap(2);//水平间距
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);
		//创建checkbox组，设定成未勾选的为false,并加入到ArrayList和面板上
		for(int i=0;i<256;i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		//设置自己写的midi方法
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
			sequencer.setTempoInBPM(120);	//每分钟节拍数
		}catch(Exception e) {e.printStackTrace();}
	}
	public void buildTrackAndStart() {
		//创建16个元素的数组来存储一项乐器的值，如果该节应该要演奏，其值会是关键字值，否则值为零
		int[] trackList = null;
		//清除掉旧的track做一个新的
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		for(int i=0;i<16;i++) {
			//每个乐器都执行一次
			trackList = new int[16];
			//设定代表乐器的关键字
			int key = instruments[i];
			//对每一拍执行一次
			for(int j=0;j<16;j++) {
				JCheckBox jc = (JCheckBox)checkboxList.get(j+(16*i));
				//如果有勾选，将关键字值放到数组的该位置上，不然就补零.
				if(jc.isSelected()) {
					trackList[j] = key;
				}else {
					trackList[j] = 0;
				}
			}
			//自定义的两个方法，实现创建此乐器的事件并加到track上
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		//确保第16拍有事件，否则beatbox不会重复播放
		track.add(makeEvent(192,9,1,0,15));
		
		try {
			sequencer.setSequence(sequence);
			//指定无穷的重复次数
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}
	//创建某项乐器的所有事件
	public void makeTracks(int[] list) {
		for(int i=0;i<16;i++) {
			int key = list[i];
			if(key!=0) {
				//实现自定义方法，创建NOTE ON 和NOTE OFF事件并加入到track上
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
	//内部类
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
			sequencer.setTempoFactor((float)(tempoFactor*1.03));	//节奏因子，预设为1，每次调整3%
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
			boolean[] checkboxState = new boolean[256];//用于保存复选框的状态
			for(int i=0;i<256;i++) {	//逐个取得状态并加到数组中
				JCheckBox check = checkboxList.get(i);
				if(check.isSelected()) {
					checkboxState[i]=true;
				}
			}
			//将boolean数组序列化
			try {
				FileOutputStream fileStream = new FileOutputStream(new File("F:/视频教学/JAVA教学/Practice/Checkbox.ser"));
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
				FileInputStream fis = new FileInputStream(new File("F:/视频教学/JAVA教学/Practice/Checkbox.ser"));
				ObjectInputStream ois = new ObjectInputStream(fis);
				checkboxState = (boolean[]) ois.readObject();//读取文件中的对象并将Object类型换回boolean数组
			} catch (Exception e) {
				e.printStackTrace();
			}
			//还原每个checkbox的状态
			for(int i=0;i<256;i++) {
				JCheckBox check = checkboxList.get(i);
				if(checkboxState[i]) {
					check.setSelected(true);
				}else {
					check.setSelected(false);
				}
			}
			sequencer.stop();	//停止目前播放的节奏并使用复选框状态
			buildTrackAndStart();//重新创建序列
		}
	}
}
