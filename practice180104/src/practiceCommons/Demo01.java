package practiceCommons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;


/**
 * ����ʽ���֮Predicate����
 * ��װ�������б�ʽif else�����
 * 1��new EqualPredicate<����>(ֵ)
 * 		EqualPredicate.equalPredicate(ֵ)
 * 2��NotNullPredicate.INSTANCE
 * 3��UniquePredicate.uniquePredicate()
 * 4���Զ����ж�	
 *   new Predicate<T>()+evaluate����
 * 		PredicateUtils.allPredicate������������  andPredicateֻ�ܴ������൱�ڡ��ҡ�
 * 											   anyPredicate����һ��Ϊtrue�����൱�ڡ���
 * 		PredicatedXxx.predicatedXxx(����,�ж�)
 * @author ����
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println("=========�Զ����ж�========");
		//�Զ�����б�ʽ
		Predicate<String> preSelf = new Predicate<String>() {
			@Override
			public boolean evaluate(String object) {
				return object.length()>=5&&object.length()<=20;
			}
		};
		Predicate notNull = NotNullPredicate.notNullPredicate();
		Predicate all = PredicateUtils.allPredicate(notNull,preSelf);//�����������˳��Ӱ���ж�˳��
		//ʵ���˽����Ⱥ��Ƿ�յ��ж����������������Ҫһ��������
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
		//list.add("inta");//���Ȳ�������
		//list.add(null);	//��ָ���쳣 
		list.add("intadd");
	}
	/**
	 * �ж�Ψһ��
	 */
	public static void unique() {
		System.out.println("=========Ψһ���ж�========");
		org.apache.commons.collections4.Predicate<Long> unique = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), 
				unique);
		list.add(100L);
		list.add(200L);
//		list.add(100L);	//�����ظ�ֵ���׳��쳣
	}
	/**
	 * �ǿ��ж�
	 */
	public static void notNull() {
		System.out.println("=========�ǿ��ж�========");
		org.apache.commons.collections4.Predicate<Object> notNull = NotNullPredicate.INSTANCE;
//		org.apache.commons.collections4.Predicate<Object> notNull = NotNullPredicate.notNullPredicate();
//		String str = "id";
		String str = null;
		System.out.println(notNull.evaluate(str));
		//�������
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), 
				notNull/*NotNullPredicate.INSTANCE*/);
		list.add(10000L);
//		list.add(null);
	}
	/**
	 * �Ƚ�����ж�
	 */
	public static void equal() {
		System.out.println("=========����ж�========");
//		EqualPredicate<String> pre = (EqualPredicate<String>) EqualPredicate.equalPredicate("inta");
		EqualPredicate<String> pre = new EqualPredicate<String>("inta");
		boolean test01 = pre.evaluate("intadd");
		System.out.println(test01);
	}
}
