package review_test01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import review_622.FileUtil;

/**
 * 会用到的流：控制台输入流、输出到服务端的输出流
 * @author 银涛
 *
 */
public class Send01 implements Runnable{
	
	//控制台输入流
	BufferedReader br;
	//输出到服务端的输出流
	DataOutputStream dos;
	//标识符，用于控制线程的循环与结束
	private boolean isRunning;
	//客户端管道的名称
	private String clientName;
	
	/**
	 * 构造器私有化
	 */
	private Send01() {
		br = new BufferedReader(new InputStreamReader(System.in));
		this.isRunning=true;
		this.clientName="";
	}
	public Send01(Socket client,String clientName) {
		this();
		try {
			//获得客户端传来的输出流
			dos = new DataOutputStream(client.getOutputStream());
			//传入客户端连接的通道名称
			this.clientName = clientName;
			//在初始创建的时候就把通道名称发送出去
			send(this.clientName);
			
		} catch (IOException e) {
//			e.printStackTrace();
			return;
		}
		
		
	}
	
	/**
	 * 发送数据的方法
	 * @param msg 需要发送的数据
	 */
	private void send(String msg) {
		//程序健壮性,内容为空不传出
		if(null==msg||"".equals(msg)) {
			return;
		}
		//否则将信息传输出去
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
//			e.printStackTrace();
			//出现异常关闭流
			FileUtil.close(dos);
			isRunning = false;
		}
	}
	
	/**
	 * 从控制台获得数据
	 * @return 以字符串形式传输
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
