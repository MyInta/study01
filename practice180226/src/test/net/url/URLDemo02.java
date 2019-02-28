package test.net.url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 * 获取资源，源代码
 * @author 银涛
 *
 */
public class URLDemo02 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");	//主页默认资源
		//获取资源,网络流
		/*
		InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		is.close();
		*/
		//使用字节流转换流
		InputStream is = 
				new BufferedInputStream(
						url.openStream());
		OutputStream os = 
				new BufferedOutputStream(
						new FileOutputStream("index.html"));
		byte[] flush = new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))) {
			os.write(flush, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}
	public static void test01(String strUrl) throws UnsupportedEncodingException, IOException {
		URL url = new URL("strUrl");
		//使用转换流
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("baidu.html"),"utf-8"));
		String msg = null;
		while(null!=(msg=br.readLine())) {
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
