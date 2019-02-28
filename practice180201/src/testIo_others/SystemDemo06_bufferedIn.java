package testIo_others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 封装输入
 * @author 银涛
 *
 */
public class SystemDemo06_bufferedIn {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in; //后者为字节流中的节点，需要借助FileInputStream实现
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("请输入：");
		String str = br.readLine();
		System.out.println(str);
	}
}
