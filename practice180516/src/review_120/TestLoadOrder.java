package review_120;

class ParentA {
	int num = 1;
	void print() {
		System.out.println("num:"+num);
		num = 2;
	}
}

public class TestLoadOrder extends ParentA{
	int num = 3;
	void print() {
		System.out.println("num:"+num);
		num = 4;
	}
	public static void main(String[] args) {
		ParentA t = new TestLoadOrder();
		t.print();
		System.out.println(t.num);
	}
}