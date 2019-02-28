package test.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端:发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 【问题】：输入流与输出流在同一线程，应该独立处理，彼此独立 
 * @author 银涛
 *
 */
public class Demo01Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8887);
		//写出数据 输出流 交互式
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = 
				new DataOutputStream(client.getOutputStream());
		//读取服务器的数据 输入流
		DataInputStream dis = 
				new DataInputStream(client.getInputStream());
		while(true) {
			String info = br.readLine();
			dos.writeUTF("客户端写出的数据-->"+info);
			dos.flush();
			String msg = dis.readUTF();
			System.out.println(msg);
			client.close();
		}
	}

}
