package test.prototype;
/**
 * ԭ��ģʽ���
 * @author ����
 *
 */

import java.util.Date;

public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(123134655464L);
		Sheep2 s1 = new Sheep2("����",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		
		Sheep2 s2 = (Sheep2) s1.clone();
		
		
		System.out.println(s2);
		s2.setName("����");
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
