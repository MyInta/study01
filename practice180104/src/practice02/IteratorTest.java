package practice02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * ���Ե�������������;
 * @author ����
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//ͨ����������list
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("##############");
		//ͨ������������list
		for(Iterator<String> iter = list.iterator();iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}
		
		System.out.println("#############");
		
		Set<String> set = new HashSet<>();
		set.add("�ų�ܰ");
		set.add("������");
		set.add("����");
		//ͨ������������set
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
		for(Iterator<String> iter=set.iterator();iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}
		
	}
}
