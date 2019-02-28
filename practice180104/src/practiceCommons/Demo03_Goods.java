package practiceCommons;
/**
 * 货物类
 * @author 银涛
 *
 */
public class Demo03_Goods {
	private String name;
	private double price;
	//折扣
	private boolean discount;
	public Demo03_Goods() {
	}
	public Demo03_Goods(String name, double price, boolean discount) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isDiscount() {
		return discount;
	}
	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "(商品："+this.name+"\t价格："+this.price+"\t折扣："+(this.discount?"有":"无")+")";
	}
}
