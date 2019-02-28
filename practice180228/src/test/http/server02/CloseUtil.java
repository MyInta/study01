package test.http.server02;

import java.io.Closeable;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �ر����ķ���
 * @author ����
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
	 * ʹ�÷��ͷ����ر�IO��
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
