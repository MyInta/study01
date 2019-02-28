package test.gof23;

public class Client {
	public static void main(String[] args) {
		SingleTon3 s1 = SingleTon3.getInstance();
		SingleTon3 s2 = SingleTon3.getInstance();
		System.out.println(s1);
		System.out.println(s2);//会发现他们创建的为同一个实例
		
		System.out.println(SingleTon4.INSTANCE==SingleTon4.INSTANCE);
	}
}
