package review_622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ��ˣ�Ϊʵ�ֶ���ͻ��˵������ҹ��ܣ�ʹ���˶��߳�
 * ���幦�� ���ܿ���̨�Ŀͻ������ƴ�����Ϣ ���ܷ���˷��͵����� ���͸�����˿ͻ��˵���Ϣ
 * @author ����
 *
 */
public class TestClient {
	private static String ClientName() throws IOException{
		String name = "";
		//����̨������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine();
		return name;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("������ͻ����û�����");
		Socket client = new Socket("localhost",8886);
		String name = ClientName();
		//��׳�ԣ������������Ϊ���򲻴���
		if(name.equals("")) {
			return;
		}
		//�������̣߳��ֱ��ǿͻ��˶Է���˵����������
		new Thread(new TestSend(client,name)).start();
		new Thread(new TestReceive(client)).start();
	}
}
