package testIo_convert;

import java.io.UnsupportedEncodingException;

public class Demo01Convert {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "中国";
		byte[] date = str.getBytes();
		System.out.println(new String(date,0,3)); 	//字节数不够，产生乱码
	}
	/**
	 * 解码与编码的字符集得统一，否则容易产生乱码
	 * @throws UnsupportedEncodingException 
	 */
	public static void test01() throws UnsupportedEncodingException {
		// 解码
		String str = "中国"; // gbk
		// 编码
		byte[] date = str.getBytes();
		// 编码与解码字符集统一
		System.out.println(new String(date));
		// 不统一出现乱码
		date = str.getBytes("utf-8");
		System.out.println(new String(date));

		// 编码
		byte[] date2 = "中国".getBytes("utf-8");
		// 解码
		str = new String(date2, "utf-8");
		System.out.println(str);
	}
}
