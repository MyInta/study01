package test.gof23;
/**
 * 测试懒汉式单例模式
 * @author 银涛
 *
 */
public class SingleTon2 {
	//有延时加载的优势,真正用时再加载
	private static SingleTon2 instance;
	private SingleTon2() {
	}
	//方法没有同步，调用效率高
	public static synchronized SingleTon2 getInstance() {
		if(instance==null) {
			instance = new SingleTon2();
		}
		return instance;
	}
}
