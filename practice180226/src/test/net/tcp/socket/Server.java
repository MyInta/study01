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
 * 
 * @author ����
 *
 */
public class Server {
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
		Socket socket = server.accept();
		System.out.println("һ���ͻ��˽�������");
		//3���������� +�������� 
		String msg = "��ӭ����";
		/*
		BufferedWriter bw = 
				new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//����readerʱ����������轨���У��˴����û���
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
