package test.strategy;

public class Client {
	public static void main(String[] args) {
		Strategy s1 = new NewCustomerManyStrategy();
		Context ctx = new Context(s1);
		ctx.printPrice(980);
	}
}
