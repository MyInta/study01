package test.dynamicProxy;

public class RealStar implements Star {

	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMonsy()");
	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket()");		
	}

	@Override
	public void sing() {
		System.out.println("ÖÜ½ÜÂ×±¾ÈË.sing()");
	}

}
