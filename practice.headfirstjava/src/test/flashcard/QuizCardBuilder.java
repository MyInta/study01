package test.flashcard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardBuilder {
	
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	
	public static void main(String[] args) {
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}
	public void go() {
		//��������ʾgui
		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif",Font.BOLD,24);
		
		question = new JTextArea(6,20);
		question.setWrapStyleWord(true);
		question.setLineWrap(true);
		question.setFont(bigFont);
		
		answer = new JTextArea(6,20);
		answer.setWrapStyleWord(true);
		answer.setLineWrap(true);
		answer.setFont(bigFont);
		
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane aScroller = new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		cardList = new ArrayList<QuizCard>();
		
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		
		nextButton.addActionListener(new NextCardListener());
		//�ڲ˵�������ѡ��
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");	//����File�����㿪�������save ��load
		
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		
		saveMenuItem.addActionListener(new SaveMenuListener());
		newMenuItem.addActionListener(new NewMenuListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		//������ϼ����
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
		
		
	}
	
	private class NextCardListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			QuizCard card = new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	private class SaveMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//�����Ի���
			//�����û�������������
			QuizCard card = new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			//�������̶Ի��򣬵ȴ��û�����
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}
	private class NewMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//���card�б���ı���
			cardList.clear();
			clearCard();
		}
	}
	
	private void clearCard() {
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	//ʵ�ʱ�д�ļ��ɼ���������ʵ��
	private void saveFile(File file) {
		//���б������һ���ı��ļ�
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for(QuizCard card:cardList) {
				writer.write(card.getQuestion()+"/");
				writer.write(card.getAnswer()+"\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Couldn't write the cardList out");
			e.printStackTrace();
		}
	}
	
	
	
	
}