package test.practice02;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGuil {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		//window�ر�ʱ���ѳ���رյ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��button���뵽frame��pane��
		frame.getContentPane().add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
