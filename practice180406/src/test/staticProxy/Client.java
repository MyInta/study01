package test.staticProxy;

public class Client {
	public static void main(String[] args) {
		Star real = new RealStar();
		Star s = new ProxyStar(real);
		
		s.bookTicket();
		s.collectMoney();
		s.confer();
		s.sing();
	}
}
