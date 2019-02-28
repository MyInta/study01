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
 * 迭代器的扩展
 * 1、MapIterator 以后不再使用map.setKey.iterator()访问
 * 	  IterableMap HashedMap
 * 2、UniqueFilterIterator 去重迭代器
 * 3、自定义过滤器
 * 	  FilterIterator(iterator,判断)
 * 4、循环迭代器
 * 	  LoopingIterator
 * 5、数组迭代器
 *    ArrayListIterator
 * @author 银涛
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
	 * 数组迭代器
	 */
	public static void arrayIt() {
		System.out.println("======数组迭代器========");
		String[] str = {"a","b","c","d","e"};
//		Iterator<String> it = new ArrayListIterator(str);
		//还可以指定起始与终末数据，str,n.m）n起始索引0启,终末m前截断，即输出str[n]到str[m-1]。
		Iterator<String> it = new ArrayListIterator(str,0,1);
		while(it.hasNext()) {
			System.out.print(it.next()+"\t");
		}
	}
	/**
	 * 循环迭代器
	 */
	public static void loop() {
		System.out.println("======循环迭代器========");
		List<String> list = new ArrayList<String>();
		list.add("afternoon");
		list.add("level");
		list.add("moom");
		list.add("inta");
		Iterator<String> it = new LoopingIterator(list);//类似将一个特殊子功能的事物赋给普通父类
		for(int i=0;i<5;i++) {
			System.out.println(it.next());
		}
	}
	/**
	 * 自定义过滤器
	 */
	public static void selfFilter() {
		System.out.println("======自定义过滤器========");
		List<String> list = new ArrayList<String>();
		list.add("afternoon");
		list.add("level");
		list.add("moom");
		list.add("inta");
		//加一个判断，弄成只输出回文形式
		Predicate<String> pre = new Predicate<>() {
			public boolean evaluate(String value) {
				return new StringBuilder(value).reverse().toString().equals(value);
			}
		};
		//包装成一个非重复的迭代器
		Iterator<String> it = new FilterIterator(list.iterator(),pre);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * 去重迭代器
	 */
	public static void uniqueFilter() {
		System.out.println("======去重迭代器========");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		//包装成一个非重复的迭代器
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * map迭代器
	 */
	public static void mapIt() {
		System.out.println("======map迭代器========");
		IterableMap<String, String> map = new HashedMap<>();
		map.put("inta", "handsome");
		map.put("lily", "pulchritude");
		map.put("elaine", "charisma");
		//原本需要使用setKey收集，现在使用MapIterator
		MapIterator<String, String> it = map.mapIterator();
		while(it.hasNext()) {
			//必须要有it.next()-->指针作用,也可换成 it.next();String key=it.getKey();
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
}
