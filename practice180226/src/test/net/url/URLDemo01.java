package test.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		//����·������
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=inta");
		System.out.println("Э�飺"+url.getProtocol());
		System.out.println("������"+url.getHost());
		System.out.println("�˿ڣ�"+url.getPort());
		System.out.println("��Դ��"+url.getFile());
		System.out.println("���·����"+url.getPath());
		System.out.println("ê�㣺"+url.getRef());//#aaΪê��
		System.out.println("������"+url.getQuery());//����ê�㷵��null�����������(#aa)�򷵻���ȷuname=inta
		
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");
		System.out.println(url.toString());
	}
}