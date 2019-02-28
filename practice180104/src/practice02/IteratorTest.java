package practice02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 测试迭代器遍历的用途
 * @author 银涛
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//通过索引遍历list
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("##############");
		//通过迭代器遍历list
		for(Iterator<String> iter = list.iterator();iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}
		
		System.out.println("#############");
		
		Set<String> set = new HashSet<>();
		set.add("张楚馨");
		set.add("曹珍珠");
		set.add("李银");
		//通过迭代器遍历set
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
		for(Iterator<String> iter=set.iterator();iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}
		
	}
}
