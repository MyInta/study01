package test.adapter;
/**
 * 对象适配器（组合的方式）
 * @author 银涛
 *
 */
public class Adapter2 implements Target{
	Adaptee adaptee;
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void handleReq() {
		this.adaptee.request();
	}

}
