package test.http.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ����������������
 * @author ����
 *
 */
public class Demo01Server7 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	private boolean isShutDown = false;
	public static void main(String[] args) {
		Demo01Server7 server = new Demo01Server7();
		server.start();
	}
	/**
	 * ��������
	 * @param port
	 */
	public void start() {
		start(8888);
	}
	/**
	 * ָ���˿ڵ���������
	 * @param port
	 */
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();	//�������ܿ���ý�������ģ��
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	/**
	 * ���տͻ���
	 */
	private void receive() {	//��public �ĳ�private�����ڲ�ʹ�ã������ⲿ��д
		try {
			while(!isShutDown) {
				new Thread(new Dispatcher(server.accept())).start();;
			}
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	//ֹͣ
	public void stop() {
		isShutDown = true;
		CloseUtil.closeSocket(server);
	}
}
