package test.adapter;
/**
 * 适配器（类适配器方式）
 * @author 银涛
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		super.request();
	}

}
