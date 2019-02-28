package review_260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpiderTest {
	
	/**
	 * 获取urlStr对应地址的网页源代码
	 * @param urlStr
	 * @return
	 */
	public static String getURLContent(String urlStr) {
		StringBuilder sb=new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()/*,Charset.forName("UFT-8")*/));
			String msg="";
			while(null!=(msg=br.readLine())) {
				sb.append(msg);
				sb.append("\r\n");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}
	
	public static List<String> getMatcherSubStrs(String destStr,String regexStr){
		List<String> list = new ArrayList<>();
		String msg = getURLContent(destStr);
//		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");
		Pattern p = Pattern.compile(regexStr);
		
		Matcher m = p.matcher(msg);
		while(m.find()) {
//			System.out.println(m.group());
//			System.out.println(m.group(1));
			list.add(m.group());
		}
		return list;
	}
	
	public static void main(String[] args) {
		String destStr = "http://www.163.com";
		String str = "href=\"(http.+?)\"";
		List<String> list = getMatcherSubStrs(destStr,str);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
