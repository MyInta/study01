package test.practice03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * 测试客户聊天室的第二版，能发送消息和接受服务器的消息
 * @author 银涛
 *
 */
public class SimpleChatClient {
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		//注册按钮的监听者
		//调用setUpNetworking()
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qSrcoller = new JScrollPane(incoming);
		qSrcoller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qSrcoller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qSrcoller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		setUpNetworking();
		//启动新的线程，以内部类为任务，读取服务器的socket串流显示在文本区域
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(600,500);
		frame.setVisible(true);
	}
	
	private void setUpNetworking() {
		//建立Socket\PrintWriter
		//赋值PrintWriter给实例变量
		try {
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader isr = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(isr);
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
	
	public class IncomingReader implements Runnable{
		
		/**
		 * run会持续获得服务器提供的信息，并将他显示在可滚动的文本区域上
		 */
		@Override
		public void run() {
			String msg;
			try {
				while((msg=reader.readLine())!=null) {
					System.out.println("read "+msg);
					incoming.append(msg+"\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	//关闭外部类
	public static void main(String[] args) {
		SimpleChatClient client = new SimpleChatClient();
		client.go();
	}
}
