package test.net.tcp.socket;

//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1、创建客户端 必须指定服务器+端口 且此时就在连接 Socket(String host,int port)
 * 2、 连接数据 +发送数据
 * @author 银涛
 *
 */
public class Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、创建客户端 必须指定服务器+端口 且此时就在连接 Socket(String host,int port)
		Socket client = new Socket("localhost",8888);
		//2、 连接数据 +发送数据
		/*
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();
		System.out.println(echo);
		client.close();
		*/
		DataInputStream dis = 
				new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
		client.close();
	}
}
