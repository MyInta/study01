package practice01;

public class Practice2_2 {
	public static void main(String[] args) {
		double a = 1234.5678;
		long b = (int)a;
		short c = (short)((a-(double)b)*10000);
		System.out.println("��������Ϊ��"+b);
		System.out.println("С�������λΪ��"+c);
		System.out.println("ԭ������Ϊ��"+b+"."+c);
		
		Integer i = Integer.parseInt("234");
		System.out.println(i.intValue());
		
		//���ַ���ת��Ϊ����
		String str = "456";
		int str2 = Integer.valueOf(str);
		System.out.println(str2);
	}
}
