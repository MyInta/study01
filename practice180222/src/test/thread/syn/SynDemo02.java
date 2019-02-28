package test.thread.syn;
/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * @author 银涛
 *
 */
public class SynDemo02 {
	public static void main(String[] args) {
//		Jvm jvm = Jvm.getInstance();
//		Jvm jvm2 = Jvm.getInstance();
//		System.out.println(jvm);
//		System.out.println(jvm2);
		JvmThread thread1 = new JvmThread();
		JvmThread thread2 = new JvmThread();
		thread1.start();
		thread2.start();
	}
}
class JvmThread extends Thread{
	private long time;
	public JvmThread() {
	}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+"-->创建"+Jvm.getInstance(time));
	}
}
/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * 懒汉式 double checking
 * 1）、构造器私有化，避免外部创建对象
 * 2）、声明一个静态的私有变量
 * 3）、创建一个公共的静态方法访问该变量，如果变量没有对象，创建对象
 *
 */
class Jvm{
	//2）、声明一个静态的私有变量
	private static Jvm instance = null;
	//1）、构造器私有化，避免外部创建对象
	private Jvm() {
	}
	//3）、创建一个公共的静态方法访问该变量，如果变量没有对象，创建对象
	public static Jvm getInstance(long time) {
		//改进效率。存在对象立刻返回，不需要再进去等待
		if(null==instance) {
		synchronized(Jvm.class) {	//因为没有this，所以用该类的字节码信息
			if(null==instance) {
				try {
					Thread.sleep(time);	//延时，放大错误
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
			}
		}
		return instance;
	}
	/**
	 * 同步块
	 * @param time 等待时间
	 * @return Jvm对象
	 */
	public static Jvm getInstance3(long time) {
		//效率不高。存在对象也需要等待
		synchronized(Jvm.class) {	//因为没有this，所以用该类的字节码信息
		if(null==instance) {
			try {
				Thread.sleep(time);	//延时，放大错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
		}
	}
	/**
	 * 方法直接同步化
	 * @param time 等待时间
	 * @return Jvm对象
	 */
	public static synchronized Jvm getInstance2(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);	//延时，放大错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
	/**
	 * 未同步，线程不安全
	 * @param time 等待时间
	 * @return Jvm对象
	 */
	public static Jvm getInstance1(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);	//延时，放大错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
}
