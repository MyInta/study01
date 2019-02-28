package test.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ���ݵķ��� �߳�
 * @author ����
 *
 */
public class Demo02Send implements Runnable{
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�����߳�
	private boolean isRunning = true;
	public Demo02Send() {
		 console = new BufferedReader(new InputStreamReader(System.in));
	}
	public Demo02Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	//�ӿ���̨��������
	private String getMsgFromConsole() {
		String msg = "";
		try {
			return msg = console.readLine();
		} catch (IOException e) {
			//e.printStackTrace();
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
		return msg;
	}
	/**
	 * 1���ӿ���̨��������
	 * 2����������
	 */
	public void send() {
		String msg = getMsgFromConsole();
		try {
			if (null != msg && !msg.equals("")) {
				dos.writeUTF(msg);
				dos.flush(); //ǿ��ˢ��
			} 
		} catch (Exception e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	@Override
	public void run() {
		//�߳���
		while(isRunning) {
			send();
		}
	}


}
