package test.net.tcp.socket;

//import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������������������������
 * 1������������ ָ���˿� ServerSocket(int port)
 * 2�����տͻ�����
 * 3���������� +��������
 * ���ܶ���ͻ���
 * @author ����
 *
 */
public class MultiServer {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1������������ ָ���˿� ServerSocket(int port)
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8888);
		//2�����տͻ����� ���� ����ʽ
		while(true) {	//��ѭ�� һ��accept()һ���ͻ���
			Socket socket = server.accept();
			System.out.println("һ���ͻ��˽�������");
			//3���������� +�������� 
			String msg = "��ӭ����";
			DataOutputStream dos = 
					new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
			//server.close();  //����رգ���ʵ�ֲ��˶���ͻ��˵Ľ��ܹ���
		}
		
	}
}
