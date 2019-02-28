package practiceCommons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag�������ظ�
 * 1��HashBag ����
 * 2��TreeBag ����
 * ͳ�Ƶ��ʳ��ֵĴ���
 * @author ����
 *
 */
public class Demo08 {
	public static void main(String[] args) {
//		hashBag();
//		treeBag();
		String str = "this is a cat and that is a mice and where is the food ?";
		//�ָ��ַ���
		String[] strArray = str.split(" ");
		Bag<String> bag = new TreeBag<>();//���ʹ��HashBag���������ʺ��������
		//װ��
		for(String temp:strArray) {
			bag.add(temp);
		}
		//��ȡ���ظ�Ԫ��
		Set<String> set = bag.uniqueSet();
		for(String unStr:set) {
			String key = unStr;
			System.out.println(key+"-->"+bag.getCount(key));
		}
	}
	/**
	 * �����Bag
	 */
	public static void treeBag() {
		Bag<String> b = new TreeBag<String>();
		b.add("abd");
		b.add("a",3);//��ʾ���5��a
		b.remove("a",2);
		b.add("bdc",2);
		b.add("c");
		Iterator<String> it = b.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * �����Bag
	 */
	public static void hashBag() {
		Bag<String> b = new HashBag<String>();
		b.add("abd");
		b.add("cfe");
		b.add("a",3);//��ʾ���5��a
		b.add("b",2);
		b.remove("a",2);
		Iterator<String> it = b.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		System.out.println("=========");
//		for(String str:b) {
//			System.out.println(str);
//		}
	}
}
