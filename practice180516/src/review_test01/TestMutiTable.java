package review_test01;

public class TestMutiTable {

	
	
	//做一个99乘法表，从小到大排
	public static void method01() {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
	}

	//做一个99乘法表，从大到小排
	public static void method02() {
		for(int i=9;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Test01!");
		method01();
		System.out.print("\n");	//换行
		method02();
	}
}
