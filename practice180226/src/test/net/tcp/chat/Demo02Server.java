package test.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 * 写出数据：输入流
 * 读取数据：输出流
 * 接受单个客户端
 * @author 银涛
 *
 */
public class Demo02Server {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8887);
		//连接客户端
		Socket client = socket.accept();
		//写出数据
		//输入流
		DataInputStream dis = 
				new DataInputStream(client.getInputStream());
		DataOutputStream dos = 
				new DataOutputStream(client.getOutputStream());
		while(true) {
			String msg = dis.readUTF();
			//输出流
			dos.writeUTF("服务器发送的数据-->"+msg);
			dos.flush();
			socket.close();
		}
	}

}
