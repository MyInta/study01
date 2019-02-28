package practice05;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 测试Enumeration接口
 * 1、判断hasMoreElements()
 * 2、获取nextElement()
 * @author 银涛
 *
 */
public class TestEnumeration01 {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<>();
		vec.add("这是一次");
		vec.add("关于enumeration的");
		vec.add("测试class");
		vec.add("文件");
		Enumeration<String> enu = vec.elements();
		while(enu.hasMoreElements()) {	//判断有无下一个元素
			System.out.println(enu.nextElement());	//有，那么输出该下一个元素
		}
	}
}
