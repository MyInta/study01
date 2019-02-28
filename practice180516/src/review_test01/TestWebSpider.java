package review_test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试网络爬虫
 * @author 银涛
 *
 */
public class TestWebSpider {

	//用于构建数据正文
	private StringBuilder message;
	//网络数据地址
	private URL url;
	//封装到list容器的数据信息
	private List<String> messages;
	
	public List<String> getMessages() {
		return messages;
	}
	//构造器私有化
	private TestWebSpider() {
		url = null;
		message = new StringBuilder();
		messages = new ArrayList<>();
	}
	//构造器初始化
	public TestWebSpider(String urlStr,String regex) {
		this();
		this.getMessageAsList(urlStr, regex);
	}
	/**
	 * 获得网络数据源
	 * @param url
	 */
	private String getMessage(String urlStr) {
		BufferedReader br=null;
		try {
			url = new URL(urlStr);
			//通过url获得网页输入流
			br= new BufferedReader(new InputStreamReader(url.openStream()));
			//通过流获得数据
			String temp="";
			while(null!=(temp=br.readLine())) {
				message.append(temp);
				message.append("\r\n");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message.toString();
	}
	/**
	 * 封装爬得的网络数据源
	 * @param message
	 * @param regex
	 * @return
	 */
	private List<String> getMessageAsList(String urlStr,String regex){
		//使用getMessage模块获得网络数据源字符串信息
		String message = getMessage(urlStr);
		//使用正则分割数据源
		Pattern p = Pattern.compile(regex);
		//matcher字符串对象
		Matcher m = p.matcher(message);
		//遍历matcher结果后，封装数据
		while(m.find()) {
			String s = m.group();
			messages.add(s);
		}
		return messages;
	}
	/**
	 * 测试网络爬虫实验
	 * @param args
	 */
	public static void main(String[] args) {
		String urlStr = "http://www.163.com";
		String regex = "href=\"(http.+?)\"";
		TestWebSpider tws = new TestWebSpider(urlStr,regex);
		Iterator<String> it = tws.getMessages().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
