package test.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * ��װ��Ӧ��Ϣ
 * 
 * @author ����
 *
 */
public class Response {
	//��������
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	//��
	private BufferedWriter bw;
	//����
	private StringBuilder content;
	//�洢ͷ��Ϣ
	private StringBuilder headInfo;
	//�洢���ĳ���
	private int len = 0;
	public Response() {
		headInfo = new StringBuilder();
		content = new StringBuilder();
		len = 0;
	}
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
	 * ��������
	 */
	public Response print(String info) {
		content.append(info);
		len+=info.getBytes().length;
		return this;
	}
	/**
	 * ��������+�س�
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len+= (info+CRLF).getBytes().length;
		return this;
	}
	
	/**
	 * ������Ӧͷ
	 */
	private void createHeadInfo(int code) {
		//����1��HTTPЭ��汾 ״̬���� ����
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
		//����2����Ӧͷ��Response Head��
		headInfo.append("Server:Inta Server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK:").append(CRLF);
		//���ĳ��� ����Ҫ��Ϊ�ֽڳ���
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF);	//�ָ���-->����Ҫ ������
	}

	//���͵��ͻ���
	void pushToClient(int code) throws IOException {
		createHeadInfo(code);
		if(null==headInfo) {
			code = 500;
		}
		//ͷ��Ϣ+�ָ���
		bw.append(headInfo.toString());
		//����
		bw.append(content.toString());
		bw.flush();
	}
	public void close() {
		CloseUtil.closeIO(bw);
	}
}