package practice04;

import java.util.TreeSet;

/**
 * 元素本身已实现comparable
 * 空参数即可TreeSet<Person02> ts = new TreeSet<>();
 * @author 银涛
 *
 */
public class TreeSetDemo02 {
	public static void main(String[] args) {
		Person02 p1 = new Person02("陈文",100);
		Person02 p2 = new Person02("黄晓明",200);
		Person02 p3 = new Person02("吴思聪",150);
		Person02 p4 = new Person02("牛琦",120);
		TreeSet<Person02> ts = new TreeSet<>();
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		System.out.println(ts);
	}
}
