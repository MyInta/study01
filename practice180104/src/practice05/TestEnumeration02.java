package practice05;

import java.util.StringTokenizer;

/**
 * Enumeration子类
 * StringTokenizer:String spilt() 字符串 的分割
 * 不支持正则表达式
 * @author 银涛
 *
 */
public class TestEnumeration02 {
	public static void main(String[] args) {
		String str = "ajshdah:ugdfhiu:dusiagiu:fauihf:wehyq:dsh";
		StringTokenizer token = new StringTokenizer(str,":");
		//因为StringTokenizer继承了Enumeration所以可以使用hasMoreElements（）和nextElement()的方法
		while(token.hasMoreElements()) {
			System.out.println(token.nextElement()); 	//实现了字符串的分割
		}
	}
}
