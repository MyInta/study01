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
 * 为了配合Chat测试用的服务器端
 * @author 银涛
 *
 */
public class VerySimpleChatServer {
	ArrayList clientOutputStreams;
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		
		/**
		 * 带参构造，传入一个Socket
		 * 接受客户端传入的Socket流，并建立Reader
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
		 * 当获取信息不为空时，将信息传递给所有客户
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
	 * 将信息传递给所有客户端
	 * @param msg
	 */
	public void tellEveryOne(String msg) {
		//使用迭代器遍历需要输出的信息数组
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()) {
			PrintWriter writer = (PrintWriter) it.next();
			writer.println(msg);
			writer.flush();
		}
	}
	
	/**
	 * 创建输出到客户端的连接
	 */
	public void go() {
		clientOutputStreams = new ArrayList();
		try {
			ServerSocket serverSock = new ServerSocket(5000);
			/**
			 * 一直处于执行状态
			 */
			while(true) {
				Socket clientSocket = serverSock.accept();//等待获得服务器端接收到的客户端socket
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());//获取socket传输的流
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
