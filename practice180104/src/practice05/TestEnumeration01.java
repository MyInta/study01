package practice05;

import java.util.Enumeration;
import java.util.Vector;

/**
 * ����Enumeration�ӿ�
 * 1���ж�hasMoreElements()
 * 2����ȡnextElement()
 * @author ����
 *
 */
public class TestEnumeration01 {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<>();
		vec.add("����һ��");
		vec.add("����enumeration��");
		vec.add("����class");
		vec.add("�ļ�");
		Enumeration<String> enu = vec.elements();
		while(enu.hasMoreElements()) {	//�ж�������һ��Ԫ��
			System.out.println(enu.nextElement());	//�У���ô�������һ��Ԫ��
		}
	}
}
