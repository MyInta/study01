package practice05;

import java.util.StringTokenizer;

/**
 * Enumeration����
 * StringTokenizer:String spilt() �ַ��� �ķָ�
 * ��֧��������ʽ
 * @author ����
 *
 */
public class TestEnumeration02 {
	public static void main(String[] args) {
		String str = "ajshdah:ugdfhiu:dusiagiu:fauihf:wehyq:dsh";
		StringTokenizer token = new StringTokenizer(str,":");
		//��ΪStringTokenizer�̳���Enumeration���Կ���ʹ��hasMoreElements������nextElement()�ķ���
		while(token.hasMoreElements()) {
			System.out.println(token.nextElement()); 	//ʵ�����ַ����ķָ�
		}
	}
}
