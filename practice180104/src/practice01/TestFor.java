package practice01;

import java.util.Scanner;

/**
 * 测试了下输入输出互动Scanner
 * 测试For循环来导出九九乘法口诀
 * @author 银涛
 *
 */
public class TestFor {
	public static void test01() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个整数a");
		int a=s.nextInt();
		System.out.println("请输入另一个整数b");
		int b =s.nextInt();
		int sum =a*b;
		System.out.println("两个整数乘积为："+sum);
		if(null!=s) {
			s.close();
		}
	}
	
	public static void main(String[] args) {
		test01();
		System.out.println("************");
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
					System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
}
