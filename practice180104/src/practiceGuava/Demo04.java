package practiceGuava;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * 集合的操作:交集、差集、并集
 * @author 银涛
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Set<Integer> set01 = Sets.newHashSet(1,2,3,4,5,6);
		Set<Integer> set02 = Sets.newHashSet(3,4,5,6,7,8,9);
		//交集
		System.out.println("=========交集=========");
		SetView<Integer> intersection = Sets.intersection(set01, set02);
		for(Integer temp:intersection) {
			System.out.print(temp+"\t");
		}
		
		System.out.print("\n");	//换行
		//差集
		System.out.println("=========差集========");
		SetView<Integer> diff = Sets.difference(set01, set02);
		for(Integer temp:diff) {
			System.out.print(temp+"\t");
		}

		System.out.print("\n");	//换行
		//并集
		System.out.println("=========并集========");
		SetView<Integer> un = Sets.union(set01, set02);
		for(Integer temp:un) {
			System.out.print(temp+"\t");
		}
	}
}
