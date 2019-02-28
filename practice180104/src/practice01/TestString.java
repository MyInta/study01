package practice01;
/**
 * 测试String
 * @author 银涛
 *	问题：new String（）（）里面可为String、char[]、int[]等但没有String[] 
 */
public class TestString {
	public static void main(String[] args) {
		String str2 = new String("abcdef");
		System.out.println(str2.charAt(2));
		System.out.println(str2.indexOf('c'));
		String s = str2.substring(2);
		System.out.println(s);
		String s2 = s.replace("c", "01");//String s2 = s.replace('c','0');单引号字符，双引号字符串
		System.out.println(s2);

		char[] c = {'a','b','c','d'};
		String str = new String(c);	//可以加字符‘’的数组进去，却不能将字符串“”的数组加进去
		System.out.println(str.charAt(2));//可以理解为String是字符数组组成
		
		String[] str3 = new String[] {"n+1","m+2","k+3"};
		System.out.println(str3[2]);
		
		//下面那行加不加（new int[]）的区别在于 加的时候指向对象，可equal但不==，不加的时候都指向常量池为==
		//int[] a = /*new int[] */{1,2,3,4};
		int[] a = new int[3];
		for(int i=0;i<a.length;i++) {
			a[i]= i+1;
		}
		System.out.println(a[2]);
		
		String str4 = "sdsaf uuie iohfe vcpu efho";
		String[] strArray = str4.split(" ");
		for(int i=0;i<strArray.length;i++) {
		System.out.println(strArray[i]);	
		}
		
		System.out.println("abCDef".toLowerCase());	//全变为小字母
		System.out.println("abCDef".toUpperCase());	//全变为大字母
		
		String ch01 = "a";
		System.out.println(ch01+10);	//String会导致字符串尾加现象，即所加内容置于原有内容后面
		
		char ch02 ='a';
		System.out.println((char)(ch02+10)); 	//不强制转型的话会出现char变为int型 字符没有尾加现象
	}
}
