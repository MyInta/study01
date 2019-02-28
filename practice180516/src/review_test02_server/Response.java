package review_test02_server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;


public class Response {
	//两个常量
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	//字符串输出流
	private BufferedWriter bw;
	//存储正文信息
	private StringBuilder context;
	//头信息
	private StringBuilder headInfo;
	//请求信息的长度
	private int len;
	/**
	 * 构造器初始化
	 */
	private Response() {
		context = new StringBuilder();
		headInfo = new StringBuilder();
		len =0;
	}
	/**
	 * 带参构造初始化输出流
	 * @param socekt
	 */
	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			headInfo = null;
		}
	}
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	/**
	 * 构建正文
	 * @param string
	 */
	public Response println(String string) {
		context.append(string).append(CRLF);
		len+=(string+CRLF).getBytes().length;
		return this;
	}
	/**
	 * 如果不需要换行的情况
	 */
	public Response print(String string) {
		context.append(string);
		len+=string.getBytes().length;
		return this;
	}
	
	/**
	 * 构建响应头
	 */
	private void createHeadInfo(int code) {
		//构建1）HTTP协议版本 状态代码 描述
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code) {
			case 200:
				headInfo.append("OK");
				break;
			case 404:
				headInfo.append("Not Found");
				break;
			case 500:
				headInfo.append("Server Error");
				break;
		}
		headInfo.append(CRLF);
		//构建2）响应头（Response Head）
		headInfo.append("Server:Inta Server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK:").append(CRLF);
		//正文长度 【重要】为字节长度
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF);	//分隔符-->很重要 不能少
	}

	public void pushToClient(int code) throws IOException {
		//载入响应头构建模块
		createHeadInfo(code);
		if(null==headInfo) {
			code = 500;
		}
		bw.append(headInfo.toString());
		bw.append(context.toString());
		bw.flush();
	}
	public void close() {
		CloseUtil.closeIO(bw);
	}

}
