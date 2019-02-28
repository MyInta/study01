package review_test01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import review_622.FileUtil;

public class Server01 {
	//ʹ�����������ͻ���ͨ����
	List<MyChannel> channels = new ArrayList<>();
	//����˵�����
	public static void main(String[] args) {
		new Server01().init();
	}
	/**
	 * ��������ʼ��
	 */
	public void init() {
		try {
				//����������socket�˿� 6667
				ServerSocket server = new ServerSocket(6667);
				//ʵ�ֶ��̣߳�Ҫ���ַ���˶Կͻ���ͨ��������״̬�ֿ���̬�ȣ�Ҫ��while true
				while(true) {
					// ��ÿͻ��˵�socket
					Socket client = server.accept();
					// ����һ���ͻ���ͨ����
					MyChannel channel = new MyChannel(client);
					// ������ͨ�����뵽�����б��ڹ���
					channels.add(channel);
					// Ϊ��ͨ������һ�����̲߳�����
					new Thread(channel).start();
				
				
				}
			}catch(Exception e) {
				System.out.println("���ӳ�ʼ��ʧ��");
				return;
			}
	}
	/**
	 * �ͻ���ͨ����
	 * 
	 * @author ����
	 *
	 */
	class MyChannel implements Runnable {

		// �ӿͻ��˴�������ݴ�����
		private DataInputStream dis = null;
		// �ӷ���˽����ݴ������ͻ��˵����ݴ�����
		private DataOutputStream dos = null;
		// �߳����й����ʶ��,Ĭ��Ϊ����
		private boolean isRunning = true;
		// �ͻ���ͨ���������
		private String name="";

		/**
		 * ��������ʼ��
		 * 
		 * @param client ����ͻ��˵�socket
		 */
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				// ��ÿͻ����״η��͹����Ŀͻ���ͨ��������
				this.name = dis.readUTF();
				// �״οͻ�ͨ�������ɹ��󣬷��ʹ����ɹ�����Ϣ
				this.send("���ӳɹ�����ӭ" + this.name + "����������");
				// ���������ͻ���ͨ�����������Ա��Ϣ
				this.sendOthers("��ӭ�����Ա" + this.name + "�������ǵ�������");

			} catch (IOException e) {
				// ��������쳣���رմ����봫���������ҽ�����״̬����Ϊ�ر�״̬
				FileUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}

		/**
		 * ��ȡ��Ϣ
		 * 
		 * @return ���شӿͻ���ͨ����ȡ������Ϣ
		 */
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// ��������쳣���رմ����������ҽ�����״̬����Ϊ�ر�״̬
				FileUtil.close(dis);
				isRunning = false;
				// Ȼ������������ͨ�����������Ƴ�
				channels.remove(this);
			}
			return msg;
		}

		/**
		 * ������Ϣ
		 * 
		 * @param msg ��Ϣ
		 */
		private void send(String msg) {
			//����׳�ԣ��������Ϊ����ֹͣ�Ĺ���
			if(null==msg||msg.equals("")) {
				return;
			}
			//�����Ļ��ͽ����ݴ���
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				// ��������쳣���رմ����������ҽ�����״̬����Ϊ�ر�״̬
				FileUtil.close(dos);
				isRunning = false;
				// Ȼ������������ͨ�����������Ƴ�
				channels.remove(this);
			}
		}
		/**
		 * �����ݴ����������ͻ���ͨ��,����˽����ʽ����������Ī���ͻ���
		 * @param msg Ҫ����ȥ����Ϣ
		 */
		private void sendOthers(String msg) {
			//����׳�ԣ��������Ϊ����ֹͣ�Ĺ���
			if(null==msg||msg.equals("")) {
				return;
			}
			//ʵ��˽����ʽ���涨˽�Ĺ���(����)��Ҫ@���Ͽͻ�������Ȼ���:������Ҫ������Ϣ
			if(msg.startsWith("@")&&msg.indexOf(":")>1) {
				//��ȡ�ͻ���ͨ��������
				String personnalName = msg.substring(1, msg.indexOf(":"));
				//��ȡ��Ҫ������Ϣ
				String msgTo = msg.substring(msg.indexOf(":")+1);
				//�����������ƵĿͻ���ͨ�����ҳ�˽�Ķ���
				for(MyChannel personnal:channels) {
					if(personnalName.equals(personnal.name)) {
						//ͨ������Ϣ���͸���Ӧ�Ŀͻ���ͨ��ʵ����Ϣ����
						personnal.send(this.name+"˽�����㣺"+msgTo);
					}
				}
			}else {
				for(MyChannel temp:channels) {
					//�����ͻ��ˣ�����ͻ������Լ���ͬ�����������ܲ����Լ����Լ�˵��
					if(temp==this) {
						continue;
					}
					temp.send(this.name+"��������˵��"+msg);
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
