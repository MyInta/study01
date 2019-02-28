package test.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1、创建客户端+端口
 * 2、准备数据 double-->字节数组 字节数组输出流
 * 3、打包+发送地点及端口
 * 4、发送包
 * 5、释放
 * @author 银涛
 *
 */
public class Client {
	public static void main(String[] args) throws IOException {
		//1、创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);//和服务器的端口不要重叠了
		//2、准备数据
		double num = 89.72;
		byte[] data = convert(num);
		//3、打包+发送地点及端口 new DatagramPacket(byte[] buf,int length, InetSocketAddress address,int port)
		DatagramPacket dp = 
				new DatagramPacket(data,data.length,
						new InetSocketAddress("localhost",8888));
		//4、发送包
		client.send(dp);
		//5、释放
		client.close();
	}
	/**
	 * 字节数组 数据源 +Data输出流
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		//字节数组 输出流 
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//Data输出流
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();

		//获取数据
		data = bos.toByteArray();
		dos.close();	//bos可以不关？为什么
		
		return data;
	}
}
