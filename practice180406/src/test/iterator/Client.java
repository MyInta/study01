package test.iterator;

public class Client {
	public static void main(String[] args) {
		ConcreteMyAggregate cmi = new ConcreteMyAggregate();
		cmi.addObject("aa");
		cmi.addObject("bb");
		cmi.addObject("cc");
		
		MyIterator iter = cmi.createIterator();
		while(iter.hasNext()) {
			System.out.println(iter.getCurrentObj());
			iter.next();
		}
	}
}	
