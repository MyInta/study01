package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * string��װ����ֽ���
 * @author ����
 *
 */
public class Demo01Server2 {
	private ServerSocket server;
	public static void main(String[] args) {
		Demo01Server2 server = new Demo01Server2();
		server.start();
	}
	//��������
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();	//�������ܿ���ý�������ģ��
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//���տͻ���
	private void receive() {	//��public �ĳ�private�����ڲ�ʹ�ã������ⲿ��д
		try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg =null;	//���տͻ���������Ϣ
			
			byte[] data = new byte[10240];
			int len = client.getInputStream().read(data);
			
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			//System.out.println(sb.toString().trim());
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//ֹͣ
	public void stop() {
		
	}
}
