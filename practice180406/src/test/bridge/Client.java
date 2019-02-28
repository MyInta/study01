package test.bridge;

public class Client {
	public static void main(String[] args) {
		//销售笔记本电脑
		Computer2 c = new Leptop2 (new Lenovo());
		c.sale();
	}
}
