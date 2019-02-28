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
	
	//请求路径
	private String url;
	//请求参数
	private Map<String,List<String>> parameterMapValues;
	//请求方式
	private String method;
	public static final String CRLF = "\r\n";
	//请求信息
	private String requestInfo;
	//输入流
	private InputStream is;
	
	/**
	 * 构造器初始化，防止空指针异常
	 */
	private Request() {
		url = "";
		method = "";
		requestInfo = "";
		parameterMapValues = new HashMap<>();
		
	}
	/**
	 * 带参构造，将输入流注入，并且生产请求信息
	 * @param is
	 */
	public Request(InputStream is) {
		this();//调用空构造器
		this.is = is;
		try {
			byte[] flush = new byte[10240];
			int len = is.read(flush);
			requestInfo = new String(flush,0,len);
		} catch (IOException e) {
			return;//如果初始化没成功，自然直接中断
		}
		//分析头信息requestIfo
		this.parseRequestInfo();
	}
	/**
	 * 分析头信息
	 */
	private void parseRequestInfo() {
		//如果requestInfo信息为空或者空值，就将其返回
		if(null==requestInfo||"".equals(requestInfo=requestInfo.trim())) {
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
		//开始正式的分析工作
		//1、获取请求方式，先获取其第一行信息 遇到第一个换行即使末端索引
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		//获取"/"索引信息
		int idx = firstLine.indexOf("/");
		//获得请求方式
		this.method = firstLine.substring(0, idx).trim();
		//获得可能的请求路径index.html?uname=Inta&psw=654321或者是index.html看是get还是post了
		String strUrl = firstLine.substring(idx, firstLine.indexOf("HTTP/1.1")).trim();
		//判断是get还是post好确定有无请求参数在第一行中
		//将请求参数行信息保存下来
		String paramStr = "";
		if("post".equalsIgnoreCase(method)) {
			this.url =strUrl;
			//post方式请求参数在请求正文的最后一行
			paramStr = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim(); 
		}else if("get".equalsIgnoreCase(method)) {
//			this.url = strUrl.substring(0,strUrl.indexOf("?"));
			//考虑到get有时候若没有传参进去是没有后面那一行的
			if(strUrl.contains("?")) {
				String[] arr = strUrl.split("\\?");//当心split是正则表达式
				this.url = arr[0];
				paramStr = arr[1];//获得参数串如uname=Inta&psw=654321
			}else {
				this.url = strUrl;
			}
		}
		//若请求参数为空也要返回
		if("".equals(paramStr)) {
			return;
		}
		//2、将请求参数封装到map中
		parseParams(paramStr);
	}
	/**
	 * 封装参数信息，即切割参数后对应保存到map容器
	 * 参数串如uname=Inta&psw=654321
	 * @param paramStr
	 */
	private void parseParams(String paramStr) {
		//使用StringTokenizer切割字符串后保存
		StringTokenizer st = new StringTokenizer(paramStr,"&");
		while(st.hasMoreElements()) {
			//现在切割成如uname=Inta这样一小段一小段,继续切割
			String keyValue = st.nextToken();
			String[] keyValues = keyValue.split("=");
			//考虑到可能请求参数形式是uname而没有=，则
			if(1==keyValues.length) {
				//扩容，让其长度为两个
				keyValues = Arrays.copyOf(keyValues, 2);
				//并且给多出来的那个元素注明为空
				keyValues[1] = null;
			}
			//如果一切正常，那么开始分拣到key 和value中
			String key = keyValues[0].trim();
			String value = null==keyValues[1]?null:decode(keyValues[1].trim(),"gbk");
			//将k v注入准备好的容器中,但先判断有无key重复
			if(!parameterMapValues.containsKey(key)) {
				//如果不存在，那么新建一个
				parameterMapValues.put(key, new ArrayList<>());
			}
			//若存在，则只管加value进去就行
			List<String> list = parameterMapValues.get(key);
			list.add(value);
		}
	}
	/**
	 * 根据页面传入的name取得多个值
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
	 * 根据页面传入的name返回单值
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

	//设置url的set get方法 方便与外界沟通url信息
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
