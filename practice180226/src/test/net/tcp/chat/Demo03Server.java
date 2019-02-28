package test.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器
 * 写出数据：输入流
 * 读取数据：输出流
 * 接受单个客户端
 * @author 银涛
 *
 */
public class Demo03Server {
	private List<MyChannel> all = new ArrayList<>();
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Demo03Server().start();
	}
	
	public void start() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(8887);
		//连接客户端
		while(true) {
			Socket client = socket.accept();
			//写出数据
			MyChannel channel = new MyChannel(client);
			all.add(channel);	//统一管理
			new Thread(channel).start();	//一条道路
		}
	}

	/**
	 * 一个客户端一条道路
	 *  1、输入流 
	 *  2、输出流 
	 *  3、接受数据
	 *  4、发送数据
	 * 
	 * @author 银涛
	 *
	 */
	class MyChannel implements Runnable {
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;

		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// e.printStackTrace();
				CloseUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}
	/**
	 * 读取数据
	 * 
	 * @return
	 */
	private String receive() {
		String msg = "";
		try {
				msg = dis.readUTF();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);
			}
		return msg;
	}
	/**
	 * 发送数据
	 * @param msg
	 */
	private void send(String msg) {
			if (null == msg || msg.equals("")) {
				return ;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dos);
				isRunning = false;
				all.remove(this);
			}
	}
	/**
	 * 发送给其他容器
	 */
	private void sendOthers() {
		String msg = receive();
		for(MyChannel other:all) {
			if(other==this) {
				continue;	//如果为自身，则跳过
			}
			//发送给其他客户端
			other.send(msg);
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			sendOthers();
		}
	}
}
}
