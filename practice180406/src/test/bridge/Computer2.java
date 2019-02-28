package test.bridge;
/**
 * 使用桥接后的品牌与电脑销售
 * @author 银涛
 *
 */
public class Computer2 {
	protected Brand brand;

	public Computer2(Brand b) {
		this.brand = b;
	}
	public void sale() {
		this.brand.sale();
	}
	
}
class Desktop2 extends Computer2{
	public Desktop2(Brand b) {
		super(b);
	}
	
	@Override
	public void sale() {
		System.out.println("销售台式机");
	}
	
}
class Leptop2 extends Computer2{
	public Leptop2(Brand b) {
		super(b);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("销售笔记本");
	}
	
}