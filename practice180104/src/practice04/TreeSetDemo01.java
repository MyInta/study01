package practice04;

import java.util.TreeSet;

/**
 * 测试TreeSet 实现接口的业务类Comparator
 * 发现TreeSet是在加元素的时候即已经实现排序
 * 需要一个匿名内部类TreeSet<T> ts = new TreeSet<T>(
 *				new java.util.Comparator<T>() {
 *					@Override public int compare(T x,T x2){
 *					}
 * @author 银涛
 *
 */
public class TreeSetDemo01 {
	public static void main(String[] args) {
		Person p1 = new Person("陈文",100);
		Person p2 = new Person("黄晓明",200);
		Person p3 = new Person("吴思聪",150);
		Person p4 = new Person("牛琦",120);
		TreeSet<Person> ts = new TreeSet<Person>(
				new java.util.Comparator<Person>() {
					@Override
					public int compare(Person arg0, Person arg1) {
						return arg0.getScore()>arg1.getScore()?1:
							arg0.getScore()==arg1.getScore()?0:-1;
					}
					
				}
				);
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		System.out.println(ts);
	}
}
