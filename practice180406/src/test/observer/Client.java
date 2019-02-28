package test.observer;

public class Client {
	public static void main(String[] args) {
		//Ŀ�����
		ConcreteSubject subject = new ConcreteSubject();
		//�����۲���
		ObserverA o1 = new ObserverA();
		ObserverA o2 = new ObserverA();
		ObserverA o3 = new ObserverA();
		
		//�������۲�����ӵ�subject������
		subject.register(o1);
		subject.register(o2);
		subject.register(o3);
		
		//�ı����״̬
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
