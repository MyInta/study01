package test.gof23;

public class Client {
	public static void main(String[] args) {
		SingleTon3 s1 = SingleTon3.getInstance();
		SingleTon3 s2 = SingleTon3.getInstance();
		System.out.println(s1);
		System.out.println(s2);//�ᷢ�����Ǵ�����Ϊͬһ��ʵ��
		
		System.out.println(SingleTon4.INSTANCE==SingleTon4.INSTANCE);
	}
}
