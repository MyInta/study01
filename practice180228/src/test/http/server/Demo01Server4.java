package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * @author ����
 *
 */
public class Demo01Server4 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		Demo01Server4 server = new Demo01Server4();
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
			
			byte[] data = new byte[20480];	
			int len = client.getInputStream().read(data);
			
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			//��Ӧ
			
			Response res = new Response(client.getOutputStream());
			res.println("<html><head><title>HTTP��Ӧʾ��</title>");
			res.println("</head><body>Hello Inta~</body></html>");
			res.pushToClient(404);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//ֹͣ
	public void stop() {
		
	}
}