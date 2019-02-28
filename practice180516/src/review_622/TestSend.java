package review_622;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 从客户端数据的发送
 * 具体内容 接受控制台的数据 通过客户端管道类将数据发送给服务端
 * @author 银涛
 *
 */
public class TestSend implements Runnable{

	//控制台输入流
	private BufferedReader br = null;
	//客户端管道的输出流
	private DataOutputStream dos = null;
	//线程管理控制标识符
	private boolean isRunning = true;
	//客户端管道的名称
	private String clientName = "";
	/**
	 * 构造器私有化
	 */
	private TestSend() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	/**
	 * 构造器初始化
	 * @param client
	 * @param name
	 */
	public TestSend(Socket client, String name) {
		this();
		try {
			//获得客户端进来的输出流，并创建输出流
			dos = new DataOutputStream(client.getOutputStream());
			//获得该客户端管道的名称
			this.clientName = name;
			//将管道的名称输出
			send(clientName);
		} catch (IOException e) {
			//如果出现异常，关闭掉控制台输出流和管道输出流，并关闭运行状态
			FileUtil.close(br,dos);
			isRunning = false;
		}
	}
	/**
	 * 从控制台获得的信息
	 * @return 返回获得的信息
	 */
	private String getFromConsole() {
		String msg = "";
		try {
			msg = br.readLine();
		} catch (IOException e) {
			//如果出现异常，关闭掉控制台输出流，并关闭运行状态
			FileUtil.close(br);
			isRunning = false;
		}
		return msg;
	}
	/**
	 * 输出数据
	 * @param msg 数据
	 */
	private void send(String msg) {
		//健壮性，如果信息为空那个，则不传出
		if(null==msg||msg.equals("")) {
			return;
		}
		try {
			//管道输出信息
			dos.writeUTF(msg);
		} catch (IOException e) {
			//如果出现异常，关闭掉管道输出流，并关闭运行状态
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
