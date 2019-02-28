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
 * 封装request
 * @author 银涛
 *
 */
public class Request {
	//请求方式
	private String method;
	//请求资源
	private String url;
	//请求参数
	private  Map<String,List<String>> parameterMapValues;
	public static final String CRLF = "\r\n";
	private InputStream is;
	private String requestInfo;
	//url的set 与get 方便对外使用
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Request() {
		method = "";
		requestInfo = "";
		url = "";	//避免空指针异常
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
		//分析头信息
		parseRequestInfo();
	}
	/**
	 * 分析头信息
	 */
	private void parseRequestInfo() {
		if(null==requestInfo||(requestInfo=requestInfo.trim()).equals("")) {
			return;
		}
		/**
		 * =================================
		 * 从信息首行分解出：请求方式 请求路径 请求参数（get 可能存在）
		 * GET /index.html?uname=Inta&psw=654321 HTTP/1.1
		 * 
		 * 
		 * 如果为POST 请求参数可能在最后正文中
		 * =================================
		 * 
		 */
		String paramString = "";	//接受请求信息
		//1、获取请求方式
		String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idf = requestInfo.indexOf("/");	// /的位置
		this.method = requestInfo.substring(0,idf).trim();
		String strUrl = firstLine.substring(idf,firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("POST")) {
			this.url = strUrl;
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();	//正文最后一个CRLF
		}else if(this.method.equalsIgnoreCase("GET")){
			if(strUrl.contains("?")) {	//是否存在参数
				String[] urlArray = strUrl.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1];
			}else {
				this.url = strUrl;
			}
		}
		//不存在请求参数
		if(paramString.equals("")) {
			return;
		}
		//2、将请求参数封装到Map中
		parseParams(paramString);
	}
	private void parseParams(String paramString) {
		//分割 将字符串转成数组
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
			//转换成Map 分拣
			if(!parameterMapValues.containsKey(key)) {
				parameterMapValues.put(key, new ArrayList<String>());
			}
			List<String> values = parameterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * 解决用户名为中文时出现乱码问题
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
	 * 根据页面的name 获取多个值
	 * @param name
	 * @return
	 */
	public String[] getParameterValues(String name) {
		List<String> values = null;
		if((values=parameterMapValues.get(name))==null) {
			return null;
		}else {
			return values.toArray(new String[0]);//数组长度根据实际长度自动调整
		}
	}
	/**
	 * 根据页面的name 获取单一值
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
