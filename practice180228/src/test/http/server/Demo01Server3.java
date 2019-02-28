package test.http.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器并启动
 * @author 银涛
 *
 */
public class Demo01Server3 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	public static void main(String[] args) {
		Demo01Server3 server = new Demo01Server3();
		server.start();
	}
	//启动方法
	public void start() {
		try {
			server = new ServerSocket(8888);
			this.receive();	//启动功能块调用接受数据模块
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 接收客户端
	 */
	private void receive() {	//由public 改成private仅供内部使用，避免外部改写
		try {
			Socket client = server.accept();
			//接收客户端请求信息
			
			byte[] data = new byte[20480];	
			int len = client.getInputStream().read(data);
			
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			//响应
			StringBuilder responseContent = new StringBuilder();
			responseContent.append("<html><head><title>HTTP响应示例</title>"+
					"</head><body>Hello Inta~</body></html>");	//可粘贴记事本编写网页内容于此
			StringBuilder response = new StringBuilder();
			//构建1）HTTP协议版本 状态代码 描述
			response.append("HTTP/1.1").
				append(BLANK).append("200").
				append(BLANK).append("OK").append(CRLF);
			//构建2）响应头（Response Head）
			response.append("Server:Inta Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK:").append(CRLF);
			//正文长度 【重要】为字节长度
			response.append("Content-Length:").append(responseContent.toString().getBytes().length).append(CRLF);
			//构建3）正文之前
			response.append(CRLF);
			//构建4）正文
			response.append(responseContent);
			
			
			
			//输出流
			BufferedWriter bw = 
					new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//停止
	public void stop() {
		
	}
}
