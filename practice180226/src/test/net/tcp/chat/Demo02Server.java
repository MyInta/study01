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
 * ���ܵ����ͻ���
 * @author ����
 *
 */
public class Demo02Server {
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
		DataOutputStream dos = 
				new DataOutputStream(client.getOutputStream());
		while(true) {
			String msg = dis.readUTF();
			//�����
			dos.writeUTF("���������͵�����-->"+msg);
			dos.flush();
			socket.close();
		}
	}

}
