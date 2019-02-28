package test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import test.bean.User;

/**
 * ͨ������API��̬�Ĳ��������ԡ�������������
 * �°汾jdk����newInstance()ǰ�ȵ��ù�����
 * ��clazz.getDeclaredConstructor().newInstance();
 * @author ����
 *
 */
@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		String path = "test.bean.User";
		try {
			Class<User> clazz = (Class<User>) Class.forName(path);
			//ͨ������API���ù��췽�����������
			User u = clazz.getDeclaredConstructor().newInstance();	//������User���޲ζ���
			Constructor<User> c = clazz.getDeclaredConstructor(String.class,int.class,int.class);//��ȡ��ͬ�Ĺ�����
			User u2 = c.newInstance("Inta",1321,15);
			System.out.println(u2.getUname());
			//ͨ������API������ͨ����
			User u3 = clazz.getDeclaredConstructor().newInstance();	//ע������API����
			//u3.setUname("Lily");
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "Lily");	//������һ���൱�ڱ�ע�͵���u3.setUname("Lily");
			System.out.println(u3.getUname());
			//ͨ��API��������
			User u4 = clazz.getDeclaredConstructor().newInstance();
			Field f = clazz.getDeclaredField("uname");
			f.setAccessible(true);//������Բ���Ҫ��ȫ����ˣ�����ֱ�ӷ���
			f.set(u4, "Aaron");	//ͨ������ֱ��д����
			System.out.println(u4.getUname());
			System.out.println(f.get(u4));	//ͨ������ֱ�Ӷ�����
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
