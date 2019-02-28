package review_test02_server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;


public class Response {
	//��������
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	//�ַ��������
	private BufferedWriter bw;
	//�洢������Ϣ
	private StringBuilder context;
	//ͷ��Ϣ
	private StringBuilder headInfo;
	//������Ϣ�ĳ���
	private int len;
	/**
	 * ��������ʼ��
	 */
	private Response() {
		context = new StringBuilder();
		headInfo = new StringBuilder();
		len =0;
	}
	/**
	 * ���ι����ʼ�������
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
	 * ��������
	 * @param string
	 */
	public Response println(String string) {
		context.append(string).append(CRLF);
		len+=(string+CRLF).getBytes().length;
		return this;
	}
	/**
	 * �������Ҫ���е����
	 */
	public Response print(String string) {
		context.append(string);
		len+=string.getBytes().length;
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

	public void pushToClient(int code) throws IOException {
		//������Ӧͷ����ģ��
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
