package review_test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client01 {

	public static String ClientName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg ="";
		msg = br.readLine();
		return msg;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建与服务端连接的通道
		Socket client = new Socket("localhost",6667);
		//控制台输入提示
		System.out.println("请输入用户名称，不能为纯空");
		String clientName = ClientName();
		//程序健壮性
		if(null==clientName||"".equals(clientName)) {
			return;
		}
		//创建线程
		new Thread(new Send01(client,clientName)).start();
		new Thread(new Receive01(client)).start();
	}
	
}
