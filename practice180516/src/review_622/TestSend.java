package review_622;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * �ӿͻ������ݵķ���
 * �������� ���ܿ���̨������ ͨ���ͻ��˹ܵ��ཫ���ݷ��͸������
 * @author ����
 *
 */
public class TestSend implements Runnable{

	//����̨������
	private BufferedReader br = null;
	//�ͻ��˹ܵ��������
	private DataOutputStream dos = null;
	//�̹߳�����Ʊ�ʶ��
	private boolean isRunning = true;
	//�ͻ��˹ܵ�������
	private String clientName = "";
	/**
	 * ������˽�л�
	 */
	private TestSend() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	/**
	 * ��������ʼ��
	 * @param client
	 * @param name
	 */
	public TestSend(Socket client, String name) {
		this();
		try {
			//��ÿͻ��˽�����������������������
			dos = new DataOutputStream(client.getOutputStream());
			//��øÿͻ��˹ܵ�������
			this.clientName = name;
			//���ܵ����������
			send(clientName);
		} catch (IOException e) {
			//��������쳣���رյ�����̨������͹ܵ�����������ر�����״̬
			FileUtil.close(br,dos);
			isRunning = false;
		}
	}
	/**
	 * �ӿ���̨��õ���Ϣ
	 * @return ���ػ�õ���Ϣ
	 */
	private String getFromConsole() {
		String msg = "";
		try {
			msg = br.readLine();
		} catch (IOException e) {
			//��������쳣���رյ�����̨����������ر�����״̬
			FileUtil.close(br);
			isRunning = false;
		}
		return msg;
	}
	/**
	 * �������
	 * @param msg ����
	 */
	private void send(String msg) {
		//��׳�ԣ������ϢΪ���Ǹ����򲻴���
		if(null==msg||msg.equals("")) {
			return;
		}
		try {
			//�ܵ������Ϣ
			dos.writeUTF(msg);
		} catch (IOException e) {
			//��������쳣���رյ��ܵ�����������ر�����״̬
			FileUtil.close(br);
			isRunning = false;
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			send(getFromConsole());
		}
	}

}
