package practice04;

import java.util.TreeSet;

/**
 * ����TreeSet ʵ�ֽӿڵ�ҵ����Comparator
 * ����TreeSet���ڼ�Ԫ�ص�ʱ���Ѿ�ʵ������
 * ��Ҫһ�������ڲ���TreeSet<T> ts = new TreeSet<T>(
 *				new java.util.Comparator<T>() {
 *					@Override public int compare(T x,T x2){
 *					}
 * @author ����
 *
 */
public class TreeSetDemo01 {
	public static void main(String[] args) {
		Person p1 = new Person("����",100);
		Person p2 = new Person("������",200);
		Person p3 = new Person("��˼��",150);
		Person p4 = new Person("ţ��",120);
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
