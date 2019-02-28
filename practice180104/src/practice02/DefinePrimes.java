package practice02;

import java.util.Scanner;

/**
 * �������������Ұ����������鳤�������Ӧ��Ŀ������
 * @author ����
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
			if(j%5==0) {	//��5���У������Ű�
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
		System.out.println("������һ��������");
		int num = scan.nextInt();
		System.out.println("�������������Ƿ�Ϊ����~");
		checkPrimes(num);
	}
	
	/**
	 * ����ĳ�����Ƿ�Ϊ����
	 * �ǣ�����ʾ��֤Ϊ����
	 * ���򷵻�����������
	 * @param num
	 */
	public static void checkPrimes(int num) {
		if(num<0) {
			System.out.println("�������������ϸ�~");
		}
		switch(num) {
		case 1:
			System.out.println("1����������лл~");
			break;
		case 2:
			System.out.println("2��������");
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
			if(!flag) {//�������δ��˵��������
				System.out.println(num+"������");
			}else {
				System.out.println(num+"������������������");
			}
		}
	}
}
