package review_622;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 在客户端接受从服务端发送来的信息，并在控制台打印出来
 * @author 银涛
 *
 */
public class TestReceive implements Runnable{

	//管道输入流
	private DataInputStream dis = null;
	//线程运行标识符
	private boolean isRunning = true;
	/**
	 * 构造器初始化，创建=客户端的输入流
	 * @param client
	 */
	public TestReceive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			//如果出现异常，关闭掉管道输入流，并关闭运行状态
			FileUtil.close(dis);
			isRunning = false;
		}
	}
	/**
	 * 获得数据，并返回字符串
	 * @return 字符串
	 */
	private String receive() {
		String msg = "";
		try {
			//获得输入流的内容
			msg = dis.readUTF();
		} catch (IOException e) {
			//如果出现异常，关闭掉管道输入流，并关闭运行状态
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
