package practice02;

import java.util.Scanner;

/**
 * 定义素数，并且按照所有数组长度输出对应数目的素数
 * @author 银涛
 *
 */
public class DefinePrimes {
	
	public static void test01() {
		int[] myPrimes = new int[200];
		myPrimes[0] = 2;
		myPrimes[1] = 3;
		int count = 2;
		int j=0;
		Outer:
		for(int number = 5;count<myPrimes.length;number+=2) {
			int limit = (int) Math.ceil(Math.sqrt(number));
			for(int i=3;i<=limit;i++) {
				if(number%i==0) {
					continue Outer;
				}
			}
			myPrimes[count++] = number;
		}
		for(int n:myPrimes) {
			System.out.print(n+"\t");
			j++;
			if(j%5==0) {	//逢5换行，利于排版
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
//		test01();
//		System.out.println(Math.ceil(4.6));
//		System.out.println(Math.round(4.6));
//		System.out.println(Math.floor(4.6));
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个正数：");
		int num = scan.nextInt();
		System.out.println("即将检测该正数是否为质数~");
		checkPrimes(num);
	}
	
	/**
	 * 测试某个数是否为素数
	 * 是，就显示验证为素数
	 * 否则返回其所有因数
	 * @param num
	 */
	public static void checkPrimes(int num) {
		if(num<0) {
			System.out.println("请输入正数，老哥~");
		}
		switch(num) {
		case 1:
			System.out.println("1不是素数，谢谢~");
			break;
		case 2:
			System.out.println("2是素数！");
			break;
		}
		if(num>=3) {
			int limit = (int) Math.ceil(Math.sqrt(num));
			boolean flag = false;
			for(int i=2;i<=limit;i++) {
				if(num%i==0) {
					System.out.print(i+"\t");
					flag = true;
				}
			}
			if(!flag) {//如果布尔未变说明是质数
				System.out.println(num+"是素数");
			}else {
				System.out.println(num+"不是素数，它有因数");
			}
		}
	}
}
