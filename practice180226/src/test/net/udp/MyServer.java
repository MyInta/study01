package test.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务器
 * @author 银涛
 *
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		//1、创建服务端+端口
		DatagramSocket server = new DatagramSocket(8888);
		//2、准备接受容器
		byte[] container = new byte[1024];
		//3、封装成包DatagramPacket(byte[] buf,int length);
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4、接收数据
		server.receive(packet);
		//5、分析数据
		byte[] date = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(date,0,len));
		//6、释放
		server.close();
	}
}
