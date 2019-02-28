package practiceCommons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 集合的操作
 * 1、并集
 * 2、交集
 * 3、差集
 * @author 银涛
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
		
		//并集
		System.out.println("=========并集=========");
		Collection<Integer> col = CollectionUtils.union(set1, set2);
		for(Integer inte:col) {
			System.out.print(inte+"\t");
		}
		System.out.println();
		//交集
		System.out.println("=========交集=========");
//		Collection<Integer> colInter = CollectionUtils.intersection(set1, set2);
		col = CollectionUtils.retainAll(set1, set2);
		for(Integer temp:col) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		//差集
		System.out.println("=========差集=========");
		col = CollectionUtils.subtract(set1, set2);
		for(Integer temp:col) {
			System.out.print(temp+"\t");
		}
	}
}
