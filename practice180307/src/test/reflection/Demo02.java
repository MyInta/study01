package test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试各种类型（class,interface.enum,annotation,primitive,type,void）
 * 的java.lang.Class对象的获取方法
 * @author 银涛
 *
 */
@SuppressWarnings("all")
public class Demo02 {
	public static void main(String[] args) {
		String path = "test.bean.User";
		try {
			Class<?> clazz = Class.forName(path);
			//获取类的名字
			System.out.println(clazz.getName());//获取包名加类名
			System.out.println(clazz.getSimpleName());//获取类名
			//获取属性
			//Field[] fields = clazz.getFields();//只能获取public属性的field
			Field[] fields = clazz.getDeclaredFields();//可以获取所有field
			Field f = clazz.getDeclaredField("uname");
			System.out.println(fields.length);
			for(Field temp:fields) {
				System.out.println("属性："+"-->"+temp);
			}
			//获取方法信息
			Method[] methods = clazz.getDeclaredMethods();
			Method m01 = clazz.getDeclaredMethod("getUname", null);
			Method m02 = clazz.getDeclaredMethod("setUname", String.class);//后面是参数类型
			for(Method m:methods) {
				System.out.println("方法："+"-->"+m);
			}
			//构造器
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor c = clazz.getDeclaredConstructor(String.class,int.class,int.class);//获取不同的构造器
			for(Constructor temp:constructors) {
				System.out.println("构造器"+"-->"+temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
