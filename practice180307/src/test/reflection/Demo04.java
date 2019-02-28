package test.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import test.bean.User;

/**
 * ��������
 * @author ����
 *
 */
public class Demo04 {
	public void test01(Map<String,User> map,List<User> list) {
		System.out.println("Demo04.test01()");
	}
	public Map<String,User> test02() {
		System.out.println("Demo04.test02()");
		return null;
	}
	
	public static void main(String[] args) {
		try {
			//��ȡָ������������Ϣ
			Method method = Demo04.class.getMethod("test01", Map.class,List.class);
			Type[] t = method.getGenericParameterTypes();	//���������������
			for(Type paramType:t) {
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType) {
					//��ò����еľ��������map�е�key��value����
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType:genericTypes) {
						System.out.println("�������ͣ�"+genericType);
					}
				}
			}
			
			//��ȡָ����������ֵ������Ϣ
			Method method2 = Demo04.class.getMethod("test02", null);
			Type returnType = method2.getGenericReturnType();	//ע�ⷵ��ֵ���Ͳ�Ϊ����
				if(returnType instanceof ParameterizedType) {
					Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
					for(Type genericType:genericTypes) {
						System.out.println("����ֵ���������ͣ�"+genericType);
					}
				}
		}catch(Exception e){
			
		}
	}
	
	
}
