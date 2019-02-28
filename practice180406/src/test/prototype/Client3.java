package test.prototype;
/**
 * ���л��ͷ����л�
 * @author ����
 *
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Client3 {
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Date date = new Date(123134655464L);
		Sheep s1 = new Sheep("����",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		
		//���л�
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();
		//�����л�
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep s2 = (Sheep) ois.readObject();
		
		
		date.setTime(564165798464L);
		
		System.out.println(s2);
		s2.setName("����");
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
