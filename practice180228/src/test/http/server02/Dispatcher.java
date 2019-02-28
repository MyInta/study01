package test.http.server02;

import java.io.IOException;
import java.net.Socket;

/**
 * һ������ ����Ӧ ��һ������
 * @author ����
 *
 */
public class Dispatcher implements Runnable {
	private Response res;
	private Request req;
	private Socket client;
	private int code =200;
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			res = new Response(client.getOutputStream());
			req = new Request(client.getInputStream());
		} catch (Exception e) {
			code = 500;
			return;
		}
	}
	@Override
	public void run() {
		try {
			Servlet serv = WebApp.getServlet(req.getUrl());
			if(null==serv) {
				this.code = 404; //�Ҳ�����Ӧ����
			}else {
				serv.service(res, req);
			}
			res.pushToClient(code);	//���͵��ͻ���
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
			this.code = 500;
		}
		try {
			res.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeSocket(client);
	}
	
}
