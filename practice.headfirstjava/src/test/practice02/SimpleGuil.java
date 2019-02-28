package test.practice02;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGuil {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		//window关闭时，把程序关闭掉
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//把button加入到frame的pane上
		frame.getContentPane().add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
