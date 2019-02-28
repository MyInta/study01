package review_622;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �ڿͻ��˽��ܴӷ���˷���������Ϣ�����ڿ���̨��ӡ����
 * @author ����
 *
 */
public class TestReceive implements Runnable{

	//�ܵ�������
	private DataInputStream dis = null;
	//�߳����б�ʶ��
	private boolean isRunning = true;
	/**
	 * ��������ʼ��������=�ͻ��˵�������
	 * @param client
	 */
	public TestReceive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			//��������쳣���رյ��ܵ������������ر�����״̬
			FileUtil.close(dis);
			isRunning = false;
		}
	}
	/**
	 * ������ݣ��������ַ���
	 * @return �ַ���
	 */
	private String receive() {
		String msg = "";
		try {
			//���������������
			msg = dis.readUTF();
		} catch (IOException e) {
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
