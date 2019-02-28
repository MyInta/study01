package test.practice02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui3c implements ActionListener{
	JFrame frame;
	JButton button;
	int i;
	public static void main(String[] args) {
		SimpleGui3c gui = new SimpleGui3c();
		gui.go();
	}
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("Change colors");
		button.addActionListener(this);
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.repaint();
		i++;
		button.setText("The "+i+" time to change");
	}
}
