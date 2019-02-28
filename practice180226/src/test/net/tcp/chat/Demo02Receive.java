package test.net.tcp.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �����߳�
 * @author ����
 *
 */
public class Demo02Receive implements Runnable{
	//������
	private DataInputStream dis;
	//�̱߳�ʶ
	private boolean isRunning = true;
	public Demo02Receive() {
	}
	public Demo02Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	/**
	 * ��������
	 * @return
	 */
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	@Override
	public void run() {
		//�߳���
		while(isRunning) {
			System.out.println(receive());
		}
				
	}

}
