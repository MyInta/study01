package test.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * �ͻ���
 * 1�������ͻ���+�˿�
 * 2��׼������ double-->�ֽ����� �ֽ����������
 * 3�����+���͵ص㼰�˿�
 * 4�����Ͱ�
 * 5���ͷ�
 * @author ����
 *
 */
public class Client {
	public static void main(String[] args) throws IOException {
		//1�������ͻ���+�˿�
		DatagramSocket client = new DatagramSocket(6666);//�ͷ������Ķ˿ڲ�Ҫ�ص���
		//2��׼������
		double num = 89.72;
		byte[] data = convert(num);
		//3�����+���͵ص㼰�˿� new DatagramPacket(byte[] buf,int length, InetSocketAddress address,int port)
		DatagramPacket dp = 
				new DatagramPacket(data,data.length,
						new InetSocketAddress("localhost",8888));
		//4�����Ͱ�
		client.send(dp);
		//5���ͷ�
		client.close();
	}
	/**
	 * �ֽ����� ����Դ +Data�����
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		//�ֽ����� ����� 
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//Data�����
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();

		//��ȡ����
		data = bos.toByteArray();
		dos.close();	//bos���Բ��أ�Ϊʲô
		
		return data;
	}
}
