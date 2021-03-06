package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * @author 银涛
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
	//启动方法
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();	//启动功能块调用接受数据模块
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 接收客户端
	 */
	private void receive() {	//由public 改成private仅供内部使用，避免外部改写
		try {
			Socket client = server.accept();
			
			//接收客户端请求信息
			Request req = new Request(client.getInputStream());
			Response res = new Response(client.getOutputStream());
			res.println("<html><head><title>HTTP响应示例</title>");
			res.println("</head><body>");
			res.println("欢迎：").println(req.getParameter("uname")).println("回来");
			res.println("</body></html>");
			res.pushToClient(404);	
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//停止
	public void stop() {
		
	}
}
