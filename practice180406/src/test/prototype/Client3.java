package test.prototype;
/**
 * 序列化和反序列化
 * @author 银涛
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
		Sheep s1 = new Sheep("少利",date);
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		
		//序列化
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();
		//反序列化
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep s2 = (Sheep) ois.readObject();
		
		
		date.setTime(564165798464L);
		
		System.out.println(s2);
		s2.setName("多利");
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
