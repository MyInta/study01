package test.prototype;

import java.util.Date;

/**
 * ����ԭ��ģʽ
 * @author ����
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(123134655464L);
		Sheep s1 = new Sheep("����",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		Sheep s2 = (Sheep) s1.clone();
		
		
		System.out.println(s2);
		s2.setName("����");
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
	}
}