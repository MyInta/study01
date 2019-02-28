package practice01;

public class Practice2_2 {
	public static void main(String[] args) {
		double a = 1234.5678;
		long b = (int)a;
		short c = (short)((a-(double)b)*10000);
		System.out.println("整数部分为："+b);
		System.out.println("小数点后四位为："+c);
		System.out.println("原来的数为："+b+"."+c);
		
		Integer i = Integer.parseInt("234");
		System.out.println(i.intValue());
		
		//将字符串转变为整数
		String str = "456";
		int str2 = Integer.valueOf(str);
		System.out.println(str2);
	}
}
