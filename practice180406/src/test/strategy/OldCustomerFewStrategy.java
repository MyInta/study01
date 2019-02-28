package test.strategy;

public class OldCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("´ò°ËµãÎåÕÛ");
		return standardPrice*0.85;
	}
	
}
