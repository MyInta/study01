package review_test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client01 {

	public static String ClientName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg ="";
		msg = br.readLine();
		return msg;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//�������������ӵ�ͨ��
		Socket client = new Socket("localhost",6667);
		//����̨������ʾ
		System.out.println("�������û����ƣ�����Ϊ����");
		String clientName = ClientName();
		//����׳��
		if(null==clientName||"".equals(clientName)) {
			return;
		}
		//�����߳�
		new Thread(new Send01(client,clientName)).start();
		new Thread(new Receive01(client)).start();
	}
	
}
