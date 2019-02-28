package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * @author ����
 *
 */
public class Demo01Server6 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		Demo01Server6 server = new Demo01Server6();
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
	/**
	 * ���տͻ���
	 */
	private void receive() {	//��public �ĳ�private�����ڲ�ʹ�ã������ⲿ��д
		try {
			Socket client = server.accept();
			Servlet serv = new Servlet();
			Response res = new Response(client.getOutputStream());
			Request req = new Request(client.getInputStream());
			serv.service(res,req);
			res.pushToClient(200);	
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//ֹͣ
	public void stop() {
		
	}
}
