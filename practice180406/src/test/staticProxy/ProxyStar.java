package test.staticProxy;

public class ProxyStar implements Star {
	private Star star;
	
	public ProxyStar(Star star) {
		super();
		this.star = star;
	}

	@Override
	public void confer() {
		System.out.println("Proxy.confer()");
	}

	@Override
	public void collectMoney() {
		System.out.println("Proxy.collectMonsy()");
	}

	@Override
	public void bookTicket() {
		System.out.println("Proxy.bookTicket()");		
	}

	@Override
	public void sing() {
		star.sing();
	}

}
