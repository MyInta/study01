package test.bridge;

public class Client {
	public static void main(String[] args) {
		//���۱ʼǱ�����
		Computer2 c = new Leptop2 (new Lenovo());
		c.sale();
	}
}
