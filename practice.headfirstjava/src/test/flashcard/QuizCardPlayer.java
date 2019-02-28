package test.flashcard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardPlayer {
	
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard>cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	public static void main(String[] args) {
		QuizCardPlayer quiz = new QuizCardPlayer();
		quiz.go();
	}
	public void go() {
		//��������ʾgui
		frame = new JFrame("Quiz Card Player");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif",Font.BOLD,24);
		
		display = new JTextArea(10,20);
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(false);
		
		JScrollPane qScroll = new JScrollPane(display);
		qScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Question");
		mainPanel.add(qScroll);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(640,500);
		frame.setVisible(true);
	}

	class NextCardListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		//����Ǹ����⣬��ʾ�𰸣�������ʾ��һ������
			//��һ����ʶ���������Ѿ�������������
			if(isShowAnswer) {
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}else {
				//��ʾ����
				if(currentCardIndex<cardList.size()) {
					showNextCard();
				}else {
					//û�и���Ŀ�Ƭ��
					display.setText("That was last card");
					nextButton.setEnabled(false);
				}
			}
		}
	}
	
	class OpenMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}
	
	private void loadFile(File file) {
		//������Ƭ��ArrayList,�����ı��ļ��ж�ȡ����
		//����OpenMenuListener�¼���������ÿ�δ��ļ��ж�ȡһ��
		//����makeCard()��������һ���µĿ�Ƭ
		//ÿһ����ʾ����ʹ𰸣��á�/���ֿ���ʾ
		cardList = new ArrayList<QuizCard>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine())!=null) {
				makeCard(line);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Couldn't read the card file");
			e.printStackTrace();
		} 
	}
	
	private void makeCard(String lineToParse){
		//����LoadFile���������ı��ļ��ж�ȡһ��
		//����һ���µ�QuizCard,ͨ������CardList�����Ǽ��뵽ArrayList�С�
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0],result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}
	private void showNextCard() {
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
	
}
