package test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import test.bean.User;

/**
 * 通过反射API动态的操作：属性、方法、构造器
 * 新版本jdk建议newInstance()前先调用构造器
 * 如clazz.getDeclaredConstructor().newInstance();
 * @author 银涛
 *
 */
@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		String path = "test.bean.User";
		try {
			Class<User> clazz = (Class<User>) Class.forName(path);
			//通过反射API调用构造方法，构造对象
			User u = clazz.getDeclaredConstructor().newInstance();	//调用了User的无参对象
			Constructor<User> c = clazz.getDeclaredConstructor(String.class,int.class,int.class);//获取不同的构造器
			User u2 = c.newInstance("Inta",1321,15);
			System.out.println(u2.getUname());
			//通过反射API调用普通方法
			User u3 = clazz.getDeclaredConstructor().newInstance();	//注意是用API调用
			//u3.setUname("Lily");
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "Lily");	//加上上一句相当于被注释掉的u3.setUname("Lily");
			System.out.println(u3.getUname());
			//通过API调用属性
			User u4 = clazz.getDeclaredConstructor().newInstance();
			Field f = clazz.getDeclaredField("uname");
			f.setAccessible(true);//这个属性不需要安全检查了，可以直接访问
			f.set(u4, "Aaron");	//通过反射直接写属性
			System.out.println(u4.getUname());
			System.out.println(f.get(u4));	//通过反射直接读属性
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
