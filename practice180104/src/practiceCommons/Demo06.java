package practiceCommons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * ����������չ
 * 1��MapIterator �Ժ���ʹ��map.setKey.iterator()����
 * 	  IterableMap HashedMap
 * 2��UniqueFilterIterator ȥ�ص�����
 * 3���Զ��������
 * 	  FilterIterator(iterator,�ж�)
 * 4��ѭ��������
 * 	  LoopingIterator
 * 5�����������
 *    ArrayListIterator
 * @author ����
 *
 */
public class Demo06 {
	public static void main(String[] args) {
//		mapIt();
//		uniqueFilter();
//		selfFilter();
//		loop();
		arrayIt();
	}
	/**
	 * ���������
	 */
	public static void arrayIt() {
		System.out.println("======���������========");
		String[] str = {"a","b","c","d","e"};
//		Iterator<String> it = new ArrayListIterator(str);
		//������ָ����ʼ����ĩ���ݣ�str,n.m��n��ʼ����0��,��ĩmǰ�ضϣ������str[n]��str[m-1]��
		Iterator<String> it = new ArrayListIterator(str,0,1);
		while(it.hasNext()) {
			System.out.print(it.next()+"\t");
		}
	}
	/**
	 * ѭ��������
	 */
	public static void loop() {
		System.out.println("======ѭ��������========");
		List<String> list = new ArrayList<String>();
		list.add("afternoon");
		list.add("level");
		list.add("moom");
		list.add("inta");
		Iterator<String> it = new LoopingIterator(list);//���ƽ�һ�������ӹ��ܵ����︳����ͨ����
		for(int i=0;i<5;i++) {
			System.out.println(it.next());
		}
	}
	/**
	 * �Զ��������
	 */
	public static void selfFilter() {
		System.out.println("======�Զ��������========");
		List<String> list = new ArrayList<String>();
		list.add("afternoon");
		list.add("level");
		list.add("moom");
		list.add("inta");
		//��һ���жϣ�Ū��ֻ���������ʽ
		Predicate<String> pre = new Predicate<>() {
			public boolean evaluate(String value) {
				return new StringBuilder(value).reverse().toString().equals(value);
			}
		};
		//��װ��һ�����ظ��ĵ�����
		Iterator<String> it = new FilterIterator(list.iterator(),pre);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * ȥ�ص�����
	 */
	public static void uniqueFilter() {
		System.out.println("======ȥ�ص�����========");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		//��װ��һ�����ظ��ĵ�����
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * map������
	 */
	public static void mapIt() {
		System.out.println("======map������========");
		IterableMap<String, String> map = new HashedMap<>();
		map.put("inta", "handsome");
		map.put("lily", "pulchritude");
		map.put("elaine", "charisma");
		//ԭ����Ҫʹ��setKey�ռ�������ʹ��MapIterator
		MapIterator<String, String> it = map.mapIterator();
		while(it.hasNext()) {
			//����Ҫ��it.next()-->ָ������,Ҳ�ɻ��� it.next();String key=it.getKey();
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
}
