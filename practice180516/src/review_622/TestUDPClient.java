package review_622;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient {

	public static void main(String[] args) throws IOException {
		//1�������ͻ�������,�ͷ���˲�Ҫһ��
		DatagramSocket client = new DatagramSocket(6666);
		//2������ת��
		String msg = "Inta��UDP����";
		byte[] buf =convert(msg);
		//3��׼����һ���������,���Ҵ��з���Ŀ�ĵ�
		DatagramPacket dp = new DatagramPacket(buf, buf.length,new InetSocketAddress("localhost",8888));
		//4����������
		client.send(dp);
		//5���ͷ�
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
