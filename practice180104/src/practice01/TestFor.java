package practice01;

import java.util.Scanner;

/**
 * �������������������Scanner
 * ����Forѭ���������žų˷��ھ�
 * @author ����
 *
 */
public class TestFor {
	public static void test01() {
		Scanner s = new Scanner(System.in);
		System.out.println("������һ������a");
		int a=s.nextInt();
		System.out.println("��������һ������b");
		int b =s.nextInt();
		int sum =a*b;
		System.out.println("���������˻�Ϊ��"+sum);
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
