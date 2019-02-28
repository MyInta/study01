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
 * 
 * @author 银涛
 *
 */
public class Server {
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
		Socket socket = server.accept();
		System.out.println("一个客户端建立连接");
		//3、发送数据 +连接数据 
		String msg = "欢迎连接";
		/*
		BufferedWriter bw = 
				new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//放置reader时候堵塞，必需建立行，此处作用换行
		bw.flush();
		server.close();
		*/
		DataOutputStream dos = 
				new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
//		server.close();
		
		
	}
}
