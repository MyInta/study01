package test.strategy;

public class OldCustomerManyStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("�����ۣ�ԭ��");
		return standardPrice;
	}
	
}
