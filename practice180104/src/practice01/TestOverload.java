package practice01;
/**
 * 测试下重载的区分
 * @author 银涛
 *证明了重载只与形参的数量、类型和顺序这三个有关。
 */
public class TestOverload {
	public static void main(String[] args) {
		MyMath m = new MyMath();
		int result =m.add(3.4, 4);
		System.out.println(result);
	}
}
class MyMath{
	int a,b;
	public int add(int a,int b) {
		return a+b;
	}
	public int add(double a,int b) {	
		return (int)(a+b);
	}
	public int add(int a,int b,int c) {
		return a+b+c;
	}
	public int add(int a,double b) {
		return (int)(a+b);
	}
}