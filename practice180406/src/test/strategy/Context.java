package test.strategy;
/**
 * 负责具体的策略类交互
 * 这样的话 客户端和算法独立开来
 * 如果使用spring的依赖注入，还可以通过配置文件，动态注入不同策略对象，动态切换不同算法
 * @author 银涛
 *
 */
public class Context {
	private Strategy strategy;
	//通过构造器来注入
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	//通过set来注入
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void printPrice(double s) {
		System.out.println("您该报价："+strategy.getPrice(s));
	}
}
