package test.gof23;
/**
 * 静态内部类 创建单例
 * @author 银涛
 *
 */
public class SingleTon3 {
	private static class SingleTonClassInstance{
		private static final SingleTon3 instance = new SingleTon3();
	}
	private SingleTon3() {
	}
	public static SingleTon3 getInstance() {
		return SingleTonClassInstance.instance;
	}
}
