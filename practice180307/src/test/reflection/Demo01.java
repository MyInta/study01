package test.reflection;

import test.bean.User;

/**
 * ���Ը������ͣ�class,interface.enum,annotation,primitive,type,void��
 * ��java.lang.Class����Ļ�ȡ����
 * @author ����
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path = "test.bean.User";
		try {
			Class<?> clazz = Class.forName(path);
			//�����ʾ���װһЩ���ݡ�һ���౻���غ�JVM�ᴴ��һ����Ӧ�����Class������������ṹ��Ϣ�ᱻ�ŵ���ӦClass��
			//���Class�������һ�澵�ӣ�ͨ�����澵�ӿ��Կ������������Ϣ
			System.out.println(clazz);
			User u = (User) clazz.newInstance();
			System.out.println(u.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
