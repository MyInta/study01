package review_test01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import review_622.FileUtil;

public class Receive01 implements Runnable{

	//�ܵ�������
	private DataInputStream dis;
	//�߳̿��Ʊ�ʶ��
	private boolean isRunning;
	/**
	 * ������˽�л�
	 */
	private Receive01() {
		isRunning = true;
	}
	/**
	 * ���ι����ʼ��
	 * @param client �ͻ���ͨ���ӿ�
	 */
	public Receive01(Socket client) {
		this();
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
//			e.printStackTrace();
			//�����쳣�ر���
			FileUtil.close(dis);
			isRunning = false;
		}
	}
	
	private String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
//			e.printStackTrace();
			//��������쳣���رյ��ܵ������������ر�����״̬
			FileUtil.close(dis);
			isRunning = false;
		}
		return msg;
	}
	@Override
	public void run() {
		while(isRunning) {
			System.out.println(receive());
		}
		
	}

	
}
