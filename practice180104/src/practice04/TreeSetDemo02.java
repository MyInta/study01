package practice04;

import java.util.TreeSet;

/**
 * Ԫ�ر�����ʵ��comparable
 * �ղ�������TreeSet<Person02> ts = new TreeSet<>();
 * @author ����
 *
 */
public class TreeSetDemo02 {
	public static void main(String[] args) {
		Person02 p1 = new Person02("����",100);
		Person02 p2 = new Person02("������",200);
		Person02 p3 = new Person02("��˼��",150);
		Person02 p4 = new Person02("ţ��",120);
		TreeSet<Person02> ts = new TreeSet<>();
		ts.add(p1);
		ts.add(p2);
		ts.add(p3);
		ts.add(p4);
		System.out.println(ts);
	}
}
