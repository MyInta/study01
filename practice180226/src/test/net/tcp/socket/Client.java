package test.net.tcp.socket;

//import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1�������ͻ��� ����ָ��������+�˿� �Ҵ�ʱ�������� Socket(String host,int port)
 * 2�� �������� +��������
 * @author ����
 *
 */
public class Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1�������ͻ��� ����ָ��������+�˿� �Ҵ�ʱ�������� Socket(String host,int port)
		Socket client = new Socket("localhost",8888);
		//2�� �������� +��������
		/*
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(client.getInputStream()));
		String echo = br.readLine();
		System.out.println(echo);
		client.close();
		*/
		DataInputStream dis = 
				new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
		client.close();
	}
}
