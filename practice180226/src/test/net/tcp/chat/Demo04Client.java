package test.net.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���:��������+��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * �����⡿�����������������ͬһ�̣߳�Ӧ�ö��������˴˶��� 
 * ������������߳�
 * @author ����
 *
 */
public class Demo04Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("��������ƣ�");
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals("")) {
			return;
		}
		Socket client = new Socket("localhost",8887);
		new Thread(new Demo04Send(client,name)).start(); //һ��·�� 
		//��ȡ������������ ������
		new Thread(new Demo04Receive(client)).start(); //һ��·�� 
		
		
	}

}
