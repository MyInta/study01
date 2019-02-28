package test.http.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * 缓冲字符流和字节流
 * @author 银涛
 *
 */
public class Demo01Server {
	private ServerSocket server;
	public static void main(String[] args) {
		Demo01Server server = new Demo01Server();
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
			String requestInfo = sb.toString().trim();	//加trim()的作用是去除多余空白部分
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
