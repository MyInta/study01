package test.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * �ͻ���
 * 1�������ͻ���+�˿�
 * 2��׼������
 * 3�����+���͵ص㼰�˿�
 * 4�����Ͱ�
 * 5���ͷ�
 * @author ����
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//1�������ͻ���+�˿�
		DatagramSocket client = new DatagramSocket(6666);//�ͷ������Ķ˿ڲ�Ҫ�ص���
		//2��׼������
		String msg = "intaUDP���";
		byte[] data = msg.getBytes();
		//3�����+���͵ص㼰�˿� new DatagramPacket(byte[] buf,int length, InetSocketAddress address,int port)
		DatagramPacket dp = 
				new DatagramPacket(data,data.length,
						new InetSocketAddress("localhost",8888));
		//4�����Ͱ�
		client.send(dp);
		//5���ͷ�
		client.close();
	}
}
