package test.http.server03;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 创建服务器并启动
 * @author 银涛
 *
 */
public class Server01 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	private boolean isShutDown = false;
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
	/**
	 * 启动方法
	 * @param port
	 */
	public void start() {
		start(8888);
	}
	/**
	 * 指定端口的启动方法
	 * @param port
	 */
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();	//启动功能块调用接受数据模块
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	/**
	 * 接收客户端
	 */
	private void receive() {	//由public 改成private仅供内部使用，避免外部改写
		try {
			while(!isShutDown) {
				new Thread(new Dispatcher(server.accept())).start();;
			}
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	//停止
	public void stop() {
		isShutDown = true;
		CloseUtil.closeSocket(server);
	}
}
