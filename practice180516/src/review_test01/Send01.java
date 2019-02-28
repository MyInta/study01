package review_test01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import review_622.FileUtil;

/**
 * ���õ�����������̨�����������������˵������
 * @author ����
 *
 */
public class Send01 implements Runnable{
	
	//����̨������
	BufferedReader br;
	//���������˵������
	DataOutputStream dos;
	//��ʶ�������ڿ����̵߳�ѭ�������
	private boolean isRunning;
	//�ͻ��˹ܵ�������
	private String clientName;
	
	/**
	 * ������˽�л�
	 */
	private Send01() {
		br = new BufferedReader(new InputStreamReader(System.in));
		this.isRunning=true;
		this.clientName="";
	}
	public Send01(Socket client,String clientName) {
		this();
		try {
			//��ÿͻ��˴����������
			dos = new DataOutputStream(client.getOutputStream());
			//����ͻ������ӵ�ͨ������
			this.clientName = clientName;
			//�ڳ�ʼ������ʱ��Ͱ�ͨ�����Ʒ��ͳ�ȥ
			send(this.clientName);
			
		} catch (IOException e) {
//			e.printStackTrace();
			return;
		}
		
		
	}
	
	/**
	 * �������ݵķ���
	 * @param msg ��Ҫ���͵�����
	 */
	private void send(String msg) {
		//����׳��,����Ϊ�ղ�����
		if(null==msg||"".equals(msg)) {
			return;
		}
		//������Ϣ�����ȥ
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
//			e.printStackTrace();
			//�����쳣�ر���
			FileUtil.close(dos);
			isRunning = false;
		}
	}
	
	/**
	 * �ӿ���̨�������
	 * @return ���ַ�����ʽ����
	 */
	private String getMsgFromConsole() {
		String msg="";
		try {
			msg = br.readLine();
		} catch (IOException e) {
//			e.printStackTrace();
			FileUtil.close(br);
			isRunning = false;
		}
		
		return msg;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			send(getMsgFromConsole());
		}
	}

}
