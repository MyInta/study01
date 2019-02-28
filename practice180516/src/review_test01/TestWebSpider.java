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
 * ������������
 * @author ����
 *
 */
public class TestWebSpider {

	//���ڹ�����������
	private StringBuilder message;
	//�������ݵ�ַ
	private URL url;
	//��װ��list������������Ϣ
	private List<String> messages;
	
	public List<String> getMessages() {
		return messages;
	}
	//������˽�л�
	private TestWebSpider() {
		url = null;
		message = new StringBuilder();
		messages = new ArrayList<>();
	}
	//��������ʼ��
	public TestWebSpider(String urlStr,String regex) {
		this();
		this.getMessageAsList(urlStr, regex);
	}
	/**
	 * �����������Դ
	 * @param url
	 */
	private String getMessage(String urlStr) {
		BufferedReader br=null;
		try {
			url = new URL(urlStr);
			//ͨ��url�����ҳ������
			br= new BufferedReader(new InputStreamReader(url.openStream()));
			//ͨ�����������
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
	 * ��װ���õ���������Դ
	 * @param message
	 * @param regex
	 * @return
	 */
	private List<String> getMessageAsList(String urlStr,String regex){
		//ʹ��getMessageģ������������Դ�ַ�����Ϣ
		String message = getMessage(urlStr);
		//ʹ������ָ�����Դ
		Pattern p = Pattern.compile(regex);
		//matcher�ַ�������
		Matcher m = p.matcher(message);
		//����matcher����󣬷�װ����
		while(m.find()) {
			String s = m.group();
			messages.add(s);
		}
		return messages;
	}
	/**
	 * ������������ʵ��
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
