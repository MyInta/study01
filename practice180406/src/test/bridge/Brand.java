package test.bridge;
/**
 * 品牌
 * @author 银涛
 *
 */
public interface Brand {
	void sale();
}
class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("销售联想品牌电脑");
	}
	
}
class Dell implements Brand{
	
	@Override
	public void sale() {
		System.out.println("销售戴尔品牌电脑");
	}
	
}
