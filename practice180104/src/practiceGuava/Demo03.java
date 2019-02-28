package practiceGuava;

import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Sets;

/**
 * 加入约束条件:非空、长度验证
 * Constraint
 * Preconditions
 * Constraints
 * @author 银涛
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Set<String> sets = Sets.newHashSet();
		//创建约束
		Constraint<String> con = new Constraint<String>() {
			@Override
			public String checkElement(String element) {
				//非空验证
				Preconditions.checkNotNull(element);
				//长度验证 5-20位字符串
				Preconditions.checkArgument(element.length()>=5&&element.length()<=20);
				return element;
			}
			
		};
		Set<String> cs =Constraints.constrainedSet(sets, con);
		//cs.add(null);//java.lang.NullPointerException
		//cs.add("ads");//java.lang.IllegalArgumentException
		cs.add("abcde");
		for(String temp:cs) {
			System.out.println(temp);
		}
	}
}
