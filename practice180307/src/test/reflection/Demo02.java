package test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���Ը������ͣ�class,interface.enum,annotation,primitive,type,void��
 * ��java.lang.Class����Ļ�ȡ����
 * @author ����
 *
 */
@SuppressWarnings("all")
public class Demo02 {
	public static void main(String[] args) {
		String path = "test.bean.User";
		try {
			Class<?> clazz = Class.forName(path);
			//��ȡ�������
			System.out.println(clazz.getName());//��ȡ����������
			System.out.println(clazz.getSimpleName());//��ȡ����
			//��ȡ����
			//Field[] fields = clazz.getFields();//ֻ�ܻ�ȡpublic���Ե�field
			Field[] fields = clazz.getDeclaredFields();//���Ի�ȡ����field
			Field f = clazz.getDeclaredField("uname");
			System.out.println(fields.length);
			for(Field temp:fields) {
				System.out.println("���ԣ�"+"-->"+temp);
			}
			//��ȡ������Ϣ
			Method[] methods = clazz.getDeclaredMethods();
			Method m01 = clazz.getDeclaredMethod("getUname", null);
			Method m02 = clazz.getDeclaredMethod("setUname", String.class);//�����ǲ�������
			for(Method m:methods) {
				System.out.println("������"+"-->"+m);
			}
			//������
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor c = clazz.getDeclaredConstructor(String.class,int.class,int.class);//��ȡ��ͬ�Ĺ�����
			for(Constructor temp:constructors) {
				System.out.println("������"+"-->"+temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
