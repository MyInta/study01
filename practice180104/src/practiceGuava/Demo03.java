package practiceGuava;

import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Sets;

/**
 * ����Լ������:�ǿա�������֤
 * Constraint
 * Preconditions
 * Constraints
 * @author ����
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Set<String> sets = Sets.newHashSet();
		//����Լ��
		Constraint<String> con = new Constraint<String>() {
			@Override
			public String checkElement(String element) {
				//�ǿ���֤
				Preconditions.checkNotNull(element);
				//������֤ 5-20λ�ַ���
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
