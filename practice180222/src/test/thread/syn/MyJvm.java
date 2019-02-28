package test.thread.syn;
/**
 * 单例创建方式
 * 懒汉式
 * 1）、构造器私有化，避免外部调用
 * 2）、声明私有静态属性
 * 3）、对外提供访问属性的静态方法，确保该对象存在
 * @author 银涛
 *
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
	}
	public static MyJvm getInstance() {
		//双重检索，减少线程锁降低的效率
		if(null==instance) {
			synchronized(MyJvm.class) {
				if(null==instance) {
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
}
/**
 * 饿汉式
 * 1）、构造器私有化，避免外部调用
 * 2）、声明私有静态属性，并创建该对象
 * 3）、对外提供访问属性的静态方法，确保该对象存在
 * @author 银涛
 *
 */
class MyJvm2 {
	private static MyJvm2 instance= new MyJvm2();
	private MyJvm2() {
	}
	public static MyJvm2 getInstance() {
		//因为静态创建了对象，所以线程是安全的，不需要线程锁
		return instance;
	}
}
/**
 * 类在使用的时候加载，延缓加载时间
 * @author 银涛
 *
 */
class MyJvm3 {
	//相当于将实例化放置在一个静态内部类里面，这样需要创建的时候调用类对象才会创建，提高效率又线程安全
	private static class MyJvmHolder{
		private static MyJvm3 instance= new MyJvm3();
	}
	private MyJvm3() {
	}
	public static MyJvm3 getInstance() {
		return MyJvmHolder.instance;
	}
}
