package test.gof23;
/**
 * 测试饿汉式单例模式
 * @author 银涛
 *
 */
public class SingleTon {
	//没有延时加载的优势
	private static SingleTon instance = new SingleTon();//类初始化时立即加载
	private SingleTon() {
	}
	//方法没有同步，调用效率高
	public static SingleTon getInstance() {
		return instance;
	}
}
