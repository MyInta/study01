package practice01;

import java.util.Scanner;

/**
 * ���Թ������Լ���Ӧ������ά�㣬�Լ���������
 * @author ����
 *
 */
public class TestConstructor {
	double x,y,z;
	public TestConstructor(double _x,double _y,double _z) {
		x = _x;
		y = _y;
		z = _z;
	}
	public void Setx(double _x) {
		x= _x;
	}
	public void Sety(double _y) {
		y= _y;
	}
	public void Setz(double _z) {
		z= _z;
	}
	
	public double Distance(TestConstructor p) {
		return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y)+(p.z-z)*(p.z-z));
	}
	
	
	public static void main(String[] args) {
		TestConstructor p = new TestConstructor(3,5,6);
		//���뽻�����ܣ�ʵ���Զ���һ���㣬��������3.5.6����֮��ľ����ϵ
		System.out.println("�����롰x,x,x����ʽ��������");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();//��ÿ���̨�����һ�м�¼
		String[] msgs = msg.split(",");//���ա������ָ�洢Ϊ�ַ�������
		double[] xyz = new double[3];
		for(int i=0;i<msgs.length;i++) {
//			xyz[i]=Double.valueOf(msgs[i]);
			xyz[i]=Double.parseDouble(msgs[i]);
			System.out.println(xyz[i]);
		}
		//���Ե����п��ܵ�Խ�籨����ж�
		TestConstructor p2 = new TestConstructor(xyz[0],xyz[1],xyz[2]);
		System.out.println(p.x);
		p.Setx(4);
		System.out.println(p.x);
		System.out.println(p.Distance(p2));
	}
}
