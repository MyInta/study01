package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo02 {
	
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("test.annotation.MyStudent");
			//������������Чע��
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a:annotations) {
				System.out.println(a);
			}
			
			//������ָ��ע��
			Field f = clazz.getDeclaredField("age");
			MyField myField = f.getAnnotation(MyField.class);
			System.out.println(myField.columName()+"--"+myField.type()+"--"+myField.length());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
