package test.reflection;

import test.bean.User;

/**
 * 测试各种类型（class,interface.enum,annotation,primitive,type,void）
 * 的java.lang.Class对象的获取方法
 * @author 银涛
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path = "test.bean.User";
		try {
			Class<?> clazz = Class.forName(path);
			//对象表示或封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会被放到对应Class中
			//这个Class对象就像一面镜子，通过这面镜子可以看到整个类的信息
			System.out.println(clazz);
			User u = (User) clazz.newInstance();
			System.out.println(u.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
