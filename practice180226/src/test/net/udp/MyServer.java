package test.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ������
 * @author ����
 *
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		//1�����������+�˿�
		DatagramSocket server = new DatagramSocket(8888);
		//2��׼����������
		byte[] container = new byte[1024];
		//3����װ�ɰ�DatagramPacket(byte[] buf,int length);
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4����������
		server.receive(packet);
		//5����������
		byte[] date = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(date,0,len));
		//6���ͷ�
		server.close();
	}
}