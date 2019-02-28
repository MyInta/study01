package review_test02_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {
	
	//����·��
	private String url;
	//�������
	private Map<String,List<String>> parameterMapValues;
	//����ʽ
	private String method;
	public static final String CRLF = "\r\n";
	//������Ϣ
	private String requestInfo;
	//������
	private InputStream is;
	
	/**
	 * ��������ʼ������ֹ��ָ���쳣
	 */
	private Request() {
		url = "";
		method = "";
		requestInfo = "";
		parameterMapValues = new HashMap<>();
		
	}
	/**
	 * ���ι��죬��������ע�룬��������������Ϣ
	 * @param is
	 */
	public Request(InputStream is) {
		this();//���ÿչ�����
		this.is = is;
		try {
			byte[] flush = new byte[10240];
			int len = is.read(flush);
			requestInfo = new String(flush,0,len);
		} catch (IOException e) {
			return;//�����ʼ��û�ɹ�����Ȼֱ���ж�
		}
		//����ͷ��ϢrequestIfo
		this.parseRequestInfo();
	}
	/**
	 * ����ͷ��Ϣ
	 */
	private void parseRequestInfo() {
		//���requestInfo��ϢΪ�ջ��߿�ֵ���ͽ��䷵��
		if(null==requestInfo||"".equals(requestInfo=requestInfo.trim())) {
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
		//��ʼ��ʽ�ķ�������
		//1����ȡ����ʽ���Ȼ�ȡ���һ����Ϣ ������һ�����м�ʹĩ������
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		//��ȡ"/"������Ϣ
		int idx = firstLine.indexOf("/");
		//�������ʽ
		this.method = firstLine.substring(0, idx).trim();
		//��ÿ��ܵ�����·��index.html?uname=Inta&psw=654321������index.html����get����post��
		String strUrl = firstLine.substring(idx, firstLine.indexOf("HTTP/1.1")).trim();
		//�ж���get����post��ȷ��������������ڵ�һ����
		//�������������Ϣ��������
		String paramStr = "";
		if("post".equalsIgnoreCase(method)) {
			this.url =strUrl;
			//post��ʽ����������������ĵ����һ��
			paramStr = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim(); 
		}else if("get".equalsIgnoreCase(method)) {
//			this.url = strUrl.substring(0,strUrl.indexOf("?"));
			//���ǵ�get��ʱ����û�д��ν�ȥ��û�к�����һ�е�
			if(strUrl.contains("?")) {
				String[] arr = strUrl.split("\\?");//����split��������ʽ
				this.url = arr[0];
				paramStr = arr[1];//��ò�������uname=Inta&psw=654321
			}else {
				this.url = strUrl;
			}
		}
		//���������Ϊ��ҲҪ����
		if("".equals(paramStr)) {
			return;
		}
		//2�������������װ��map��
		parseParams(paramStr);
	}
	/**
	 * ��װ������Ϣ�����и�������Ӧ���浽map����
	 * ��������uname=Inta&psw=654321
	 * @param paramStr
	 */
	private void parseParams(String paramStr) {
		//ʹ��StringTokenizer�и��ַ����󱣴�
		StringTokenizer st = new StringTokenizer(paramStr,"&");
		while(st.hasMoreElements()) {
			//�����и����uname=Inta����һС��һС��,�����и�
			String keyValue = st.nextToken();
			String[] keyValues = keyValue.split("=");
			//���ǵ��������������ʽ��uname��û��=����
			if(1==keyValues.length) {
				//���ݣ����䳤��Ϊ����
				keyValues = Arrays.copyOf(keyValues, 2);
				//���Ҹ���������Ǹ�Ԫ��ע��Ϊ��
				keyValues[1] = null;
			}
			//���һ����������ô��ʼ�ּ�key ��value��
			String key = keyValues[0].trim();
			String value = null==keyValues[1]?null:decode(keyValues[1].trim(),"gbk");
			//��k vע��׼���õ�������,�����ж�����key�ظ�
			if(!parameterMapValues.containsKey(key)) {
				//��������ڣ���ô�½�һ��
				parameterMapValues.put(key, new ArrayList<>());
			}
			//�����ڣ���ֻ�ܼ�value��ȥ����
			List<String> list = parameterMapValues.get(key);
			list.add(value);
		}
	}
	/**
	 * ����ҳ�洫���nameȡ�ö��ֵ
	 * @param name
	 * @return
	 */
	public String[] getParameterValues(String name) {
		List<String> values = null;
		if(null==(values = parameterMapValues.get(name))) {
			return null;
		}
		return values.toArray(new String[0]);
	}
	/**
	 * ����ҳ�洫���name���ص�ֵ
	 * @param name
	 * @return
	 */
	public String getParameterValue(String name) {
		String[] values = getParameterValues(name);
		if(null==values) {
			return null;
		}
		return values[0];
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

	//����url��set get���� ��������繵ͨurl��Ϣ
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
