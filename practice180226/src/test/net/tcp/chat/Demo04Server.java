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
public class Demo04Server {
	private List<MyChannel> all = new ArrayList<>();
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Demo04Server().start();
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
		private String name;

		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
				
				this.send("欢迎进入聊天室");
				sendOthers(this.name+"进入了聊天室");
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
	private void sendOthers(String msg) {
		//使用正则表达式，判断是否为私聊 约定@+：
		if(msg.startsWith("@")&&msg.indexOf(":")>1) {//私聊
			//获取name
			String nameReceive = msg.substring(1, msg.indexOf(":"));	//接受的用户名称
			String content = msg.substring(msg.indexOf(":")+1);	//发送具体内容
			for(MyChannel other:all) {	//遍历用户
				if(other.name.equals(nameReceive)) {
					other.send(this.name+"私聊于你："+content);
				}
			}
		}else {
			for(MyChannel other:all) {
				if(other==this) {
					continue;	//跳过
				}
				//发送给其他客户端
				other.send(this.name+"对所有人说："+msg);
			}
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			sendOthers(receive());
		}
	}
}
}
