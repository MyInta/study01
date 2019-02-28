package test.practice03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 测试客户聊天室的第一版，只能发送消息给服务器
 * @author 银涛
 *
 */
public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		//注册按钮的监听者
		//调用setUpNetworking()
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetworking();
		frame.setSize(400,500);
		frame.setVisible(true);
	}
	
	private void setUpNetworking() {
		//建立Socket\PrintWriter
		//赋值PrintWriter给实例变量
		try {
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("NetWorking Established!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class SendButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//取得文字段内容
			//传送到服务器上
			String msg = outgoing.getText();
			writer.println(msg);
			writer.flush();
			outgoing.setText("");
			outgoing.requestFocus();
		}
		//关闭SendButton Listener内部类
	}
	//关闭外部类
	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}
