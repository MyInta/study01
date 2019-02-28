package test.thread.create;
/**
 * 静态代理设计模式
 * 1、真实角色
 * 2、代理角色:持有真实角色的引用 
 * 3、二者实现相同的接口 代理角色对方法的重写
 * @author 银涛
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//创建真实角色
		You you = new You();
		//创建代理角色+真实角色的引用
		WeddingAgent wa = new WeddingAgent(you);
		//执行
		wa.marry();
	}
}
//共同的接口
interface Marry{
	public abstract void marry();
}
//真实角色
class You implements Marry{
	@Override
	public void marry() {
		System.out.println("Inta和Lily结婚了");
	}
	
}
//代理角色
class WeddingAgent implements Marry{
	//真实角色的引用
	private Marry you;
	private WeddingAgent() {
	}
	public WeddingAgent(Marry you) {
		this();
		this.you = you;
	}
	private void before() {
		System.out.println("布置婚房");
	}
	private void after() {
		System.out.println("闹洞房");
	}
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}




