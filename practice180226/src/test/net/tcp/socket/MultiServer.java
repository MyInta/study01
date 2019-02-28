package test.net.tcp.socket;

//import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必需先启动服务器，后连接
 * 1、创建服务器 指定端口 ServerSocket(int port)
 * 2、接收客户数据
 * 3、发送数据 +连接数据
 * 接受多个客户端
 * @author 银涛
 *
 */
public class MultiServer {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1、创建服务器 指定端口 ServerSocket(int port)
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8888);
		//2、接收客户数据 连接 阻塞式
		while(true) {	//死循环 一个accept()一个客户端
			Socket socket = server.accept();
			System.out.println("一个客户端建立连接");
			//3、发送数据 +连接数据 
			String msg = "欢迎连接";
			DataOutputStream dos = 
					new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
			//server.close();  //如果关闭，则实现不了多个客户端的接受功能
		}
		
	}
}
