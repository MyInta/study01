package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * @author ����
 *
 */
public class Demo01Server5 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		Demo01Server5 server = new Demo01Server5();
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
			
			//���տͻ���������Ϣ
			Request req = new Request(client.getInputStream());
			Response res = new Response(client.getOutputStream());
			res.println("<html><head><title>HTTP��Ӧʾ��</title>");
			res.println("</head><body>");
			res.println("��ӭ��").println(req.getParameter("uname")).println("����");
			res.println("</body></html>");
			res.pushToClient(404);	
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//ֹͣ
	public void stop() {
		
	}
}
