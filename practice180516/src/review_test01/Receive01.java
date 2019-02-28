package review_test01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import review_622.FileUtil;

public class Receive01 implements Runnable{

	//管道传入流
	private DataInputStream dis;
	//线程控制标识符
	private boolean isRunning;
	/**
	 * 构造器私有化
	 */
	private Receive01() {
		isRunning = true;
	}
	/**
	 * 带参构造初始化
	 * @param client 客户端通道接口
	 */
	public Receive01(Socket client) {
		this();
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
//			e.printStackTrace();
			//出现异常关闭流
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
