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
 * ���Կͻ������ҵĵ�һ�棬ֻ�ܷ�����Ϣ��������
 * @author ����
 *
 */
public class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		//ע�ᰴť�ļ�����
		//����setUpNetworking()
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
		//����Socket\PrintWriter
		//��ֵPrintWriter��ʵ������
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
			//ȡ�����ֶ�����
			//���͵���������
			String msg = outgoing.getText();
			writer.println(msg);
			writer.flush();
			outgoing.setText("");
			outgoing.requestFocus();
		}
		//�ر�SendButton Listener�ڲ���
	}
	//�ر��ⲿ��
	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}
