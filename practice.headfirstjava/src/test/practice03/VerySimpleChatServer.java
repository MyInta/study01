package test.practice03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Ϊ�����Chat�����õķ�������
 * @author ����
 *
 */
public class VerySimpleChatServer {
	ArrayList clientOutputStreams;
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		
		/**
		 * ���ι��죬����һ��Socket
		 * ���ܿͻ��˴����Socket����������Reader
		 * @param clientSocket
		 */
		public ClientHandler(Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isr = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * ����ȡ��Ϣ��Ϊ��ʱ������Ϣ���ݸ����пͻ�
		 */
		@Override
		public void run() {
			String msg;
			try {
				while((msg=reader.readLine())!=null) {
					System.out.println("read "+msg);
					tellEveryOne(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * ����Ϣ���ݸ����пͻ���
	 * @param msg
	 */
	public void tellEveryOne(String msg) {
		//ʹ�õ�����������Ҫ�������Ϣ����
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()) {
			PrintWriter writer = (PrintWriter) it.next();
			writer.println(msg);
			writer.flush();
		}
	}
	
	/**
	 * ����������ͻ��˵�����
	 */
	public void go() {
		clientOutputStreams = new ArrayList();
		try {
			ServerSocket serverSock = new ServerSocket(5000);
			/**
			 * һֱ����ִ��״̬
			 */
			while(true) {
				Socket clientSocket = serverSock.accept();//�ȴ���÷������˽��յ��Ŀͻ���socket
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());//��ȡsocket�������
				clientOutputStreams.add(writer);
				
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new VerySimpleChatServer().go();
	}
}
