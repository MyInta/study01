package test.mediator;

public class Client {
	public static void main(String[] args) {
		Mediator m = new President();
		
		Market market = new Market(m);
		Development dev = new Development(m);
		Finacial finacial = new Finacial(m);
		
		market.selfAction();
		market.outAction();
	}
}