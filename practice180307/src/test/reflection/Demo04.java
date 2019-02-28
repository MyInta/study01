package test.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import test.bean.User;

/**
 * 操作泛型
 * @author 银涛
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
			//获取指定方法泛型信息
			Method method = Demo04.class.getMethod("test01", Map.class,List.class);
			Type[] t = method.getGenericParameterTypes();	//参数类型数组存贮
			for(Type paramType:t) {
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType) {
					//获得参数中的具体参数如map中的key与value类型
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType:genericTypes) {
						System.out.println("泛型类型："+genericType);
					}
				}
			}
			
			//获取指定方法返回值泛型信息
			Method method2 = Demo04.class.getMethod("test02", null);
			Type returnType = method2.getGenericReturnType();	//注意返回值类型不为数组
				if(returnType instanceof ParameterizedType) {
					Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
					for(Type genericType:genericTypes) {
						System.out.println("返回值，泛型类型："+genericType);
					}
				}
		}catch(Exception e){
			
		}
	}
	
	
}
