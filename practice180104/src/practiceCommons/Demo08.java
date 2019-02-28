package practiceCommons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag包允许重复
 * 1、HashBag 无序
 * 2、TreeBag 有序
 * 统计单词出现的次数
 * @author 银涛
 *
 */
public class Demo08 {
	public static void main(String[] args) {
//		hashBag();
//		treeBag();
		String str = "this is a cat and that is a mice and where is the food ?";
		//分割字符串
		String[] strArray = str.split(" ");
		Bag<String> bag = new TreeBag<>();//如果使用HashBag则结果无序，问号在最后排
		//装填
		for(String temp:strArray) {
			bag.add(temp);
		}
		//获取非重复元素
		Set<String> set = bag.uniqueSet();
		for(String unStr:set) {
			String key = unStr;
			System.out.println(key+"-->"+bag.getCount(key));
		}
	}
	/**
	 * 有序的Bag
	 */
	public static void treeBag() {
		Bag<String> b = new TreeBag<String>();
		b.add("abd");
		b.add("a",3);//表示添加5个a
		b.remove("a",2);
		b.add("bdc",2);
		b.add("c");
		Iterator<String> it = b.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * 无序的Bag
	 */
	public static void hashBag() {
		Bag<String> b = new HashBag<String>();
		b.add("abd");
		b.add("cfe");
		b.add("a",3);//表示添加5个a
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
