package test.net.tcp.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���:��������+��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * �����⡿�����������������ͬһ�̣߳�Ӧ�ö��������˴˶��� 
 * @author ����
 *
 */
public class Demo02Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8887);
		//���͸������������� �����
		new Thread(new Demo02Send(client)).start(); //һ��·�� 
		//��ȡ������������ ������
		new Thread(new Demo02Receive(client)).start(); //һ��·�� 
		
		
	}

}
