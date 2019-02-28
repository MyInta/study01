package review_test02_server;

import java.io.IOException;
import java.net.Socket;

import review_test02_servlet.Servlet;

public class Dispatcher implements Runnable{

	private Request req;
	private Response resp;
	private Socket client;
	private int code=200;
	/**
	 * ��������ʼ��
	 */
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			resp = new Response(client.getOutputStream());
			req = new Request(client.getInputStream());
		} catch (IOException e) {
			code=500;
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
				serv.service(req, resp);
			}
			resp.pushToClient(code);	//���͵��ͻ���
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
			this.code = 500;
		}
		try {
			resp.pushToClient(500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CloseUtil.closeSocket(client);
	}

}
