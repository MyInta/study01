package test.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������
 * д�����ݣ�������
 * ��ȡ���ݣ������
 * @author ����
 *
 */
public class Demo01Server {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8887);
		//���ӿͻ���
		Socket client = socket.accept();
		//д������
		//������
		DataInputStream dis = 
				new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		//�����
		DataOutputStream dos = 
				new DataOutputStream(client.getOutputStream());
		dos.writeUTF("���������͵�����-->"+msg);
		dos.flush();
		socket.close();
	}

}
