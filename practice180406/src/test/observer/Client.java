package test.observer;

public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject = new ConcreteSubject();
		//创建观察者
		ObserverA o1 = new ObserverA();
		ObserverA o2 = new ObserverA();
		ObserverA o3 = new ObserverA();
		
		//将三个观察者添加到subject容器中
		subject.register(o1);
		subject.register(o2);
		subject.register(o3);
		
		//改变对象状态
		subject.setState(3000);
		System.out.println(o1.getMyState());
		System.out.println(o2.getMyState());
		System.out.println(o3.getMyState());
		
		System.out.println("===================");
		subject.setState(30);
		System.out.println(o1.getMyState());
		System.out.println(o2.getMyState());
		System.out.println(o3.getMyState());
	}
}
