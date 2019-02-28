package practice01;
/**
 * 测试数组
 * @author 银涛
 *
 */
public class TestArray {
	public static void main(String[] args) {
		int [] a;
		a = new int[4];
		for(int i=0;i<a.length;i++) {
			a[i] = i*12;
		}
		//静态初始化
		int[] b = {12,11,15,10};	//长度4，索引0~3
		HelloWorld[] h = {
							new HelloWorld("数组1"),
							new HelloWorld("数组1"),
							new HelloWorld("数组2"),
							new HelloWorld("数组3")
						};
		h[2].showName();
		HelloWorld h2 = new HelloWorld("数组1");
		//但如果比较h2和h[0]则==与equal都为false,对象地址不同
		System.out.println(h2.name==h[0].name);
		System.out.println(h2.equals(h[0]));
		System.out.println(h[0].toString());//数组内元素创建，对象非单例
		System.out.println(h[1].toString());
		System.out.println(h[0].equals(h[1]));//对象为多例，引用地址不同。
		System.out.println(b[2]);
	}
}
