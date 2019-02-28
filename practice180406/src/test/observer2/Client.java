package test.observer2;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		
		ObserverA o1= new ObserverA();
		ObserverA o2= new ObserverA();
		ObserverA o3= new ObserverA();
		
		subject.addObserver(o1);
		subject.addObserver(o2);
		subject.addObserver(o3);
		
		subject.set(3000);
		System.out.println(o1.getMaState());
		System.out.println(o2.getMaState());
		System.out.println(o3.getMaState());
	}
}
