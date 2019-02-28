package review_test01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import review_622.FileUtil;

public class Server01 {
	//使用容器包裹客户端通道类
	List<MyChannel> channels = new ArrayList<>();
	//服务端的启动
	public static void main(String[] args) {
		new Server01().init();
	}
	/**
	 * 服务器初始化
	 */
	public void init() {
		try {
				//创建服务器socket端口 6667
				ServerSocket server = new ServerSocket(6667);
				//实现多线程，要保持服务端对客户端通道创建的状态持开放态度，要用while true
				while(true) {
					// 获得客户端的socket
					Socket client = server.accept();
					// 创建一个客户端通道类
					MyChannel channel = new MyChannel(client);
					// 并将该通道加入到容器中便于管理
					channels.add(channel);
					// 为此通道开辟一个新线程并启动
					new Thread(channel).start();
				
				
				}
			}catch(Exception e) {
				System.out.println("连接初始化失败");
				return;
			}
	}
	/**
	 * 客户端通道类
	 * 
	 * @author 银涛
	 *
	 */
	class MyChannel implements Runnable {

		// 从客户端传入的数据传入流
		private DataInputStream dis = null;
		// 从服务端将数据传出到客户端的数据传出流
		private DataOutputStream dos = null;
		// 线程运行管理标识符,默认为运行
		private boolean isRunning = true;
		// 客户端通道类的名称
		private String name="";

		/**
		 * 构造器初始化
		 * 
		 * @param client 传入客户端的socket
		 */
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				// 获得客户端首次发送过来的客户端通道的名称
				this.name = dis.readUTF();
				// 首次客户通道创建成功后，发送创建成功的信息
				this.send("连接成功，欢迎" + this.name + "进入聊天室");
				// 并向其他客户端通道发送新入成员信息
				this.sendOthers("欢迎新入成员" + this.name + "加入我们的聊天室");

			} catch (IOException e) {
				// 如果出现异常，关闭传入与传出流，并且将运行状态调整为关闭状态
				FileUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}

		/**
		 * 读取信息
		 * 
		 * @return 返回从客户端通道读取到的信息
		 */
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// 如果出现异常，关闭传入流，并且将运行状态调整为关闭状态
				FileUtil.close(dis);
				isRunning = false;
				// 然后将这个有问题的通道从容器中移除
				channels.remove(this);
			}
			return msg;
		}

		/**
		 * 发送信息
		 * 
		 * @param msg 信息
		 */
		private void send(String msg) {
			//程序健壮性，如果数据为空则停止改功能
			if(null==msg||msg.equals("")) {
				return;
			}
			//正常的话就将数据传出
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				// 如果出现异常，关闭传出流，并且将运行状态调整为关闭状态
				FileUtil.close(dos);
				isRunning = false;
				// 然后将这个有问题的通道从容器中移除
				channels.remove(this);
			}
		}
		/**
		 * 将数据传出给其他客户端通道,或者私聊形式传出给单独莫个客户端
		 * @param msg 要传出去的信息
		 */
		private void sendOthers(String msg) {
			//程序健壮性，如果数据为空则停止改功能
			if(null==msg||msg.equals("")) {
				return;
			}
			//实现私聊形式，规定私聊规则(正则)，要@加上客户端名字然后加:后面是要表达的信息
			if(msg.startsWith("@")&&msg.indexOf(":")>1) {
				//获取客户端通道的名称
				String personnalName = msg.substring(1, msg.indexOf(":"));
				//获取想要表达的信息
				String msgTo = msg.substring(msg.indexOf(":")+1);
				//遍历所有名称的客户端通道来找出私聊对象
				for(MyChannel personnal:channels) {
					if(personnalName.equals(personnal.name)) {
						//通过将信息发送给对应的客户端通道实现信息传递
						personnal.send(this.name+"私聊于你："+msgTo);
					}
				}
			}else {
				for(MyChannel temp:channels) {
					//便利客户端，如果客户端与自己相同，则跳过，总不能自己和自己说吧
					if(temp==this) {
						continue;
					}
					temp.send(this.name+"对所有人说："+msg);
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
