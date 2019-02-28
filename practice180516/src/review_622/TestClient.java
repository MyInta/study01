package review_622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端，为实现多个客户端的聊天室功能，使用了多线程
 * 具体功能 接受控制台的客户端名称创建信息 接受服务端发送的数据 发送给服务端客户端的信息
 * @author 银涛
 *
 */
public class TestClient {
	private static String ClientName() throws IOException{
		String name = "";
		//控制台输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		name = br.readLine();
		return name;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("请输入客户端用户名：");
		Socket client = new Socket("localhost",8886);
		String name = ClientName();
		//健壮性，如果传入名称为空则不创建
		if(name.equals("")) {
			return;
		}
		//创建新线程，分别是客户端对服务端的输出与输入
		new Thread(new TestSend(client,name)).start();
		new Thread(new TestReceive(client)).start();
	}
}
