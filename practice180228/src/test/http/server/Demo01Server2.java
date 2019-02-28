package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * string包装类和字节流
 * @author 银涛
 *
 */
public class Demo01Server2 {
	private ServerSocket server;
	public static void main(String[] args) {
		Demo01Server2 server = new Demo01Server2();
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
	//接收客户端
	private void receive() {	//由public 改成private仅供内部使用，避免外部改写
		try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg =null;	//接收客户端请求信息
			
			byte[] data = new byte[10240];
			int len = client.getInputStream().read(data);
			
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			//System.out.println(sb.toString().trim());
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//停止
	public void stop() {
		
	}
}
