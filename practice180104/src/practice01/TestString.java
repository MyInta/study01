package practice01;
/**
 * ����String
 * @author ����
 *	���⣺new String�������������ΪString��char[]��int[]�ȵ�û��String[] 
 */
public class TestString {
	public static void main(String[] args) {
		String str2 = new String("abcdef");
		System.out.println(str2.charAt(2));
		System.out.println(str2.indexOf('c'));
		String s = str2.substring(2);
		System.out.println(s);
		String s2 = s.replace("c", "01");//String s2 = s.replace('c','0');�������ַ���˫�����ַ���
		System.out.println(s2);

		char[] c = {'a','b','c','d'};
		String str = new String(c);	//���Լ��ַ������������ȥ��ȴ���ܽ��ַ�������������ӽ�ȥ
		System.out.println(str.charAt(2));//�������ΪString���ַ��������
		
		String[] str3 = new String[] {"n+1","m+2","k+3"};
		System.out.println(str3[2]);
		
		//�������мӲ��ӣ�new int[]������������ �ӵ�ʱ��ָ����󣬿�equal����==�����ӵ�ʱ��ָ������Ϊ==
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
		
		System.out.println("abCDef".toLowerCase());	//ȫ��ΪС��ĸ
		System.out.println("abCDef".toUpperCase());	//ȫ��Ϊ����ĸ
		
		String ch01 = "a";
		System.out.println(ch01+10);	//String�ᵼ���ַ���β�����󣬼�������������ԭ�����ݺ���
		
		char ch02 ='a';
		System.out.println((char)(ch02+10)); 	//��ǿ��ת�͵Ļ������char��Ϊint�� �ַ�û��β������
	}
}
