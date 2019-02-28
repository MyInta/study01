package review_622;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient {

	public static void main(String[] args) throws IOException {
		//1、创建客户端连接,和服务端不要一样
		DatagramSocket client = new DatagramSocket(6666);
		//2、数据转换
		String msg = "Inta的UDP尝试";
		byte[] buf =convert(msg);
		//3、准备好一个打包容器,并且带有发送目的地
		DatagramPacket dp = new DatagramPacket(buf, buf.length,new InetSocketAddress("localhost",8888));
		//4、发送数据
		client.send(dp);
		//5、释放
		client.close();
	}
	private static byte[] convert(String msg) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeUTF(msg);
		data = bos.toByteArray();
		return data;
	}
}
