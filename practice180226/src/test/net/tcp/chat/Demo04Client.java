package test.net.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端:发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 【问题】：输入流与输出流在同一线程，应该独立处理，彼此独立 
 * 【解决】：多线程
 * @author 银涛
 *
 */
public class Demo04Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("请输出名称：");
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals("")) {
			return;
		}
		Socket client = new Socket("localhost",8887);
		new Thread(new Demo04Send(client,name)).start(); //一条路径 
		//读取服务器的数据 输入流
		new Thread(new Demo04Receive(client)).start(); //一条路径 
		
		
	}

}
