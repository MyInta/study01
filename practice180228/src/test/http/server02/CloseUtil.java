package test.http.server02;

import java.io.Closeable;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 关闭流的方法
 * @author 银涛
 *
 */
public class CloseUtil {
	/*public static void closeAll(Closeable ... io) {
		for(Closeable temp:io) {
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
			}
		}
	}*/
	/**
	 * 使用泛型方法关闭IO流
	 * @param io
	 */
	public static <T extends Closeable> void closeIO(T ... io) {
		for(Closeable temp:io) {
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
			}
		}
	}
	public static void closeSocket(Socket socket) {
		try {
			if (null != socket) {
				socket.close();
			} 
		} catch (Exception e) {
		}
	}
	public static void closeSocket(ServerSocket socket) {
		try {
			if (null != socket) {
				socket.close();
			} 
		} catch (Exception e) {
		}
	}
	public static void closeSocket(DatagramSocket socket) {
		try {
			if (null != socket) {
				socket.close();
			} 
		} catch (Exception e) {
		}
	}
	
}
