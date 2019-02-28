package practiceCommons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * ���ϵĲ���
 * 1������
 * 2������
 * 3���
 * @author ����
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		Set<Integer> set2 = new HashSet<>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		//����
		System.out.println("=========����=========");
		Collection<Integer> col = CollectionUtils.union(set1, set2);
		for(Integer inte:col) {
			System.out.print(inte+"\t");
		}
		System.out.println();
		//����
		System.out.println("=========����=========");
//		Collection<Integer> colInter = CollectionUtils.intersection(set1, set2);
		col = CollectionUtils.retainAll(set1, set2);
		for(Integer temp:col) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		//�
		System.out.println("=========�=========");
		col = CollectionUtils.subtract(set1, set2);
		for(Integer temp:col) {
			System.out.print(temp+"\t");
		}
	}
}
