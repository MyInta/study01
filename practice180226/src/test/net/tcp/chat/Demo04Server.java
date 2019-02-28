package test.net.tcp.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ������
 * д�����ݣ�������
 * ��ȡ���ݣ������
 * ���ܵ����ͻ���
 * @author ����
 *
 */
public class Demo04Server {
	private List<MyChannel> all = new ArrayList<>();
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Demo04Server().start();
	}
	
	public void start() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(8887);
		//���ӿͻ���
		while(true) {
			Socket client = socket.accept();
			//д������
			MyChannel channel = new MyChannel(client);
			all.add(channel);	//ͳһ����
			new Thread(channel).start();	//һ����·
		}
	}

	/**
	 * һ���ͻ���һ����·
	 *  1�������� 
	 *  2������� 
	 *  3����������
	 *  4����������
	 * 
	 * @author ����
	 *
	 */
	class MyChannel implements Runnable {
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;

		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
				
				this.send("��ӭ����������");
				sendOthers(this.name+"������������");
			} catch (IOException e) {
				// e.printStackTrace();
				CloseUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}
	/**
	 * ��ȡ����
	 * 
	 * @return
	 */
	private String receive() {
		String msg = "";
		try {
				msg = dis.readUTF();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);
			}
		return msg;
	}
	/**
	 * ��������
	 * @param msg
	 */
	private void send(String msg) {
			if (null == msg || msg.equals("")) {
				return ;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dos);
				isRunning = false;
				all.remove(this);
			}
	}
	/**
	 * ���͸���������
	 */
	private void sendOthers(String msg) {
		//ʹ��������ʽ���ж��Ƿ�Ϊ˽�� Լ��@+��
		if(msg.startsWith("@")&&msg.indexOf(":")>1) {//˽��
			//��ȡname
			String nameReceive = msg.substring(1, msg.indexOf(":"));	//���ܵ��û�����
			String content = msg.substring(msg.indexOf(":")+1);	//���;�������
			for(MyChannel other:all) {	//�����û�
				if(other.name.equals(nameReceive)) {
					other.send(this.name+"˽�����㣺"+content);
				}
			}
		}else {
			for(MyChannel other:all) {
				if(other==this) {
					continue;	//����
				}
				//���͸������ͻ���
				other.send(this.name+"��������˵��"+msg);
			}
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			sendOthers(receive());
		}
	}
}
}
