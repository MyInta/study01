package testIo_others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ��װ����
 * @author ����
 *
 */
public class SystemDemo06_bufferedIn {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in; //����Ϊ�ֽ����еĽڵ㣬��Ҫ����FileInputStreamʵ��
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("�����룺");
		String str = br.readLine();
		System.out.println(str);
	}
}
