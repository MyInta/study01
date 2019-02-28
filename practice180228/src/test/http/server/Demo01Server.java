package test.http.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * �����ַ������ֽ���
 * @author ����
 *
 */
public class Demo01Server {
	private ServerSocket server;
	public static void main(String[] args) {
		Demo01Server server = new Demo01Server();
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
			
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0) {
				sb.append(msg);
				sb.append("\r\n");
				if("".equals(msg)) {
					break;
				}
			}
			String requestInfo = sb.toString().trim();	//��trim()��������ȥ������հײ���
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
