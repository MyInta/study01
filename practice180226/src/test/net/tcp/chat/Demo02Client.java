package test.net.tcp.chat;

import java.io.IOException;
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
public class Demo02Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8887);
		//发送给服务器的数据 输出流
		new Thread(new Demo02Send(client)).start(); //一条路径 
		//读取服务器的数据 输入流
		new Thread(new Demo02Receive(client)).start(); //一条路径 
		
		
	}

}
