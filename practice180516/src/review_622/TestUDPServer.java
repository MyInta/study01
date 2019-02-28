package review_622;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer {

	public static void main(String[] args) throws IOException {
		//1、创建连接
		DatagramSocket socket = new DatagramSocket(8888);
		//2、缓冲数组 以及数组长度
		byte[] buf = new byte[1024];
		int len = buf.length;
		//3、获得容器
		DatagramPacket pd = new DatagramPacket(buf, len);
		//4、接受数据
		socket.receive(pd);
		//5、处理数据
		byte[] data = pd.getData();
		String msg = convert(data);
		System.out.println(msg);
		//6、释放
		socket.close();
	}
	
	private static String convert(byte[] data) throws IOException {
		String msg = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data),"utf-8"));
		msg = br.readLine();
		return msg;
	}
}
