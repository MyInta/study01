package test.http.server;

import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求 与响应 就一个对象
 * @author 银涛
 *
 */
public class Dispatcher implements Runnable {
	private Response res;
	private Request req;
	private Socket client;
	private int code =404;
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
		Servlet serv = new Servlet();
		serv.service(res,req);
		try {
			res.pushToClient(code);	//推送到客户端
		} catch (IOException e) {
			//e.printStackTrace();
		}
//		try {
//			res.pushToClient(500);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		CloseUtil.closeSocket(client);
	}
	
}
