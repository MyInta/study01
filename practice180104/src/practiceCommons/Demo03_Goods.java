package practiceCommons;
/**
 * ������
 * @author ����
 *
 */
public class Demo03_Goods {
	private String name;
	private double price;
	//�ۿ�
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
		return "(��Ʒ��"+this.name+"\t�۸�"+this.price+"\t�ۿۣ�"+(this.discount?"��":"��")+")";
	}
}
