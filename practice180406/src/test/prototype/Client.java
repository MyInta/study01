package test.prototype;

import java.util.Date;

/**
 * 测试原型模式
 * @author 银涛
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(123134655464L);
		Sheep s1 = new Sheep("少利",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		Sheep s2 = (Sheep) s1.clone();
		
		
		System.out.println(s2);
		s2.setName("多利");
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
	}
}
