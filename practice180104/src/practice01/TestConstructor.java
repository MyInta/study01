package practice01;

import java.util.Scanner;

/**
 * 测试构造器以及对应做出三维点，以及求点与点间距
 * @author 银涛
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
		//插入交互功能，实现自定义一个点，来查找与3.5.6坐标之间的距离关系
		System.out.println("请输入“x,x,x”形式数字坐标");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();//获得控制台输入的一行记录
		String[] msgs = msg.split(",");//按照“，”分割存储为字符串数组
		double[] xyz = new double[3];
		for(int i=0;i<msgs.length;i++) {
//			xyz[i]=Double.valueOf(msgs[i]);
			xyz[i]=Double.parseDouble(msgs[i]);
			System.out.println(xyz[i]);
		}
		//忽略掉所有可能的越界报错等判断
		TestConstructor p2 = new TestConstructor(xyz[0],xyz[1],xyz[2]);
		System.out.println(p.x);
		p.Setx(4);
		System.out.println(p.x);
		System.out.println(p.Distance(p2));
	}
}
