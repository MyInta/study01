package test.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Demo01Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8887);
		//д������ ����� ����ʽ
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = 
				new DataOutputStream(client.getOutputStream());
		//��ȡ������������ ������
		DataInputStream dis = 
				new DataInputStream(client.getInputStream());
		while(true) {
			String info = br.readLine();
			dos.writeUTF("�ͻ���д��������-->"+info);
			dos.flush();
			String msg = dis.readUTF();
			System.out.println(msg);
			client.close();
		}
	}

}
