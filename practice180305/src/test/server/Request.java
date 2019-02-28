package test.server;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ��װrequest
 * @author ����
 *
 */
public class Request {
	//����ʽ
	private String method;
	//������Դ
	private String url;
	//�������
	private  Map<String,List<String>> parameterMapValues;
	public static final String CRLF = "\r\n";
	private InputStream is;
	private String requestInfo;
	//url��set ��get �������ʹ��
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Request() {
		method = "";
		requestInfo = "";
		url = "";	//�����ָ���쳣
		parameterMapValues = new HashMap<String,List<String>>();
		
	}
	public Request(InputStream is) {
		this();
		this.is = is;
		try {
			byte[] data = new byte[20480];
			int len = is.read(data);
			requestInfo = new String(data, 0, len);
		} catch (Exception e) {
			return;
		}
		//����ͷ��Ϣ
		parseRequestInfo();
	}
	/**
	 * ����ͷ��Ϣ
	 */
	private void parseRequestInfo() {
		if(null==requestInfo||(requestInfo=requestInfo.trim()).equals("")) {
			return;
		}
		/**
		 * =================================
		 * ����Ϣ���зֽ��������ʽ ����·�� ���������get ���ܴ��ڣ�
		 * GET /index.html?uname=Inta&psw=654321 HTTP/1.1
		 * 
		 * 
		 * ���ΪPOST ����������������������
		 * =================================
		 * 
		 */
		String paramString = "";	//����������Ϣ
		//1����ȡ����ʽ
		String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idf = requestInfo.indexOf("/");	// /��λ��
		this.method = requestInfo.substring(0,idf).trim();
		String strUrl = firstLine.substring(idf,firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("POST")) {
			this.url = strUrl;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();	//�������һ��CRLF
		}else if(this.method.equalsIgnoreCase("GET")){
			if(strUrl.contains("?")) {	//�Ƿ���ڲ���
				String[] urlArray = strUrl.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1];
			}else {
				this.url = strUrl;
			}
		}
		//�������������
		if(paramString.equals("")) {
			return;
		}
		//2�������������װ��Map��
		parseParams(paramString);
	}
	private void parseParams(String paramString) {
		//�ָ� ���ַ���ת������
		StringTokenizer token = new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()) {
			String keyValue = token.nextToken();
			String[] keyValues = keyValue.split("=");
			if(keyValues.length==1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			
			String key = keyValues[0].trim();
			String value = null==keyValues[1]?null:decode(keyValues[1].trim(),"gbk");
			//ת����Map �ּ�
			if(!parameterMapValues.containsKey(key)) {
				parameterMapValues.put(key, new ArrayList<String>());
			}
			List<String> values = parameterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * ����û���Ϊ����ʱ������������
	 * @param value
	 * @param code
	 * @return
	 */
	private String decode(String value,String code) {
		try {
			return URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����ҳ���name ��ȡ���ֵ
	 * @param name
	 * @return
	 */
	public String[] getParameterValues(String name) {
		List<String> values = null;
		if((values=parameterMapValues.get(name))==null) {
			return null;
		}else {
			return values.toArray(new String[0]);//���鳤�ȸ���ʵ�ʳ����Զ�����
		}
	}
	/**
	 * ����ҳ���name ��ȡ��һֵ
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		String[] values =getParameterValues(name);
		if(null==values) {
			return null;
		}else {
			return values[0];
		}
	}
	
}
